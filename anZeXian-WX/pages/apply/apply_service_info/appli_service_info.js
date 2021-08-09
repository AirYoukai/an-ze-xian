// pages/apply/apply_service_info/appli_service_info.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    serviceInfo: {},
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    const i = options.id;//这里的options就是上一个页面中，跳转链接后面跟的参数 xx=xxx&xx=xxxx
    let tmp = wx.getStorageSync('allService')[i];
    console.info('serviceInfo= ' + JSON.stringify(tmp));
    this.setData({
      serviceInfo: {
        "serviceId": tmp.id,
        "serviceName": tmp.serviceName,
        "servicePrice": tmp.servicePrice,
        "servicePremium": tmp.servicePremium,
        "serviceDuration": tmp.serviceDuration,
        "industry": tmp.industry,
        "companyName": tmp.insuranceCompany.companyName,
        "claimMethod": tmp.claimMethod,
        "contactName": tmp.contactName,
        "contactPhone": tmp.contactPhone
      }
    })
    wx.setNavigationBarTitle({
      title: "套餐详情"
    })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  },
  buyService: function () {
    let that = this;
    if (!wx.getStorageSync('loginFlag')) {
      wx.showModal({
        title: '登录提示',
        content: '您还没有登录！是否要登录？',
        success: function (res) {
          if (res.confirm) {
            console.log('用户点击确定');
            setTimeout(() => {
              wx.switchTab({
                url: '/pages/user/user_my/user_my'
              });
            }, 1500)
          } else if (res.cancel) {
            console.log('用户点击取消')
            // that.onShow();
          }
        }
      })
    } else {
      wx.showModal({
        title: '提示',
        content: '确认要购买该套餐?',
        success: function (res) {
          if (res.confirm) {
            console.log('用户点击确定')
            that.tryPay();
            // wx.navigateTo({
            //   url: '/pages/apply/payment/payment?serviceId='+that.data.serviceInfo.serviceId,
            // })
          } else if (res.cancel) {
            console.log('用户点击取消')
          }
        }
      })

    }
  },
  pay: function (param) {
    let that = this;
    console.info('param to pay='+JSON.stringify(param));
    wx.requestPayment({
      timeStamp: param.timeStamp,
      nonceStr: param.nonceStr,
      package: param.package,
      signType: param.signType,
      paySign: param.paySign,
      success: function (res) {
        // success
        wx.showLoading({ title: '加载中…' });
        console.log(res);
        wx.request({
         url: wx.getStorageSync('prefixURL')+'/insuranceWxpay/paySucceed', //服务器地址
          menthod: "POST",
          header: {
            'content-type': 'application/json'
          },
          data: {
            wxpayId: param.id,
            openId: wx.getStorageSync('openId'),
            // applicant: app.globalData.applicant,
            // insured: app.globalData.insured,
            serviceId: that.data.serviceInfo.serviceId
          },
          success: function (res) {
            console.log(res);
            wx.showToast({
              title: '支付成功',
              icon: 'success',
              duration: 2000
            });
          }
        })
      },
      fail: function () {
        // fail
        console.log("支付失败");
      },
      complete: function () {
        // complete
        console.log("pay complete");
        wx.hideLoading();
      }
    })
  },

  tryPay: function () {
    let that = this;
    wx.showLoading({ title: '加载中…' });
    // console.info("before unifiedorder, serviceId is "+that.data.serviceId);
    wx.request({
      url: wx.getStorageSync('prefixURL')+'/insuranceWxpay/doUnifiedOrder', //服务器地址
      menthod: "POST",
      header: {
        'content-type': 'application/json'
      },
      data: {
        serviceId: that.data.serviceInfo.serviceId,
        openId: wx.getStorageSync('openId')
      },
      success: function (res) {
        console.log("res got from localhost");
        console.log(res);
        that.pay(res.data);
      }
    })
  }
})