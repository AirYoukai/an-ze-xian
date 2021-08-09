// pages/user/user_order_info/user_order_info.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    myOrderInfo: {},
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    const i = options.id;//这里的options就是上一个页面中，跳转链接后面跟的参数 xx=xxx&xx=xxxx
    let tmp = wx.getStorageSync('myOrders')[i];
    this.setData({
      myOrderInfo: {
        // "expireTimeDate":tmp.expireTime,
        "orderId": tmp.id,
        "expireTime": tmp.expireTime.year + "/" + tmp.expireTime.monthValue + "/" + tmp.expireTime.dayOfMonth,
        "serviceName": tmp.insuranceService.serviceName,
        "servicePrice": tmp.insuranceService.servicePrice,
        "servicePremium": tmp.insuranceService.servicePremium,
        "serviceDuration": tmp.insuranceService.serviceDuration,
        "industry": tmp.insuranceService.industry,
        "companyName": tmp.insuranceService.insuranceCompany.companyName,
        "claimMethod": tmp.insuranceService.claimMethod,
        "contactName": tmp.insuranceService.contactName,
        "contactPhone": tmp.insuranceService.contactPhone
      }
    })
    wx.setNavigationBarTitle({
      title: "订单详情"
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
  cancelOrder: function () {
    let that = this;
    console.info(new Date(that.data.myOrderInfo.expireTime));
    console.info(new Date().toLocaleDateString());//格式为 YYYY/MM/DD
    // console.info(that.data.myOrderInfo.expireTimeDate.getTime()<new Date().getTime());
    if (new Date(that.data.myOrderInfo.expireTime) > new Date()) {
      wx.showModal({
        title: '提示',
        content: '确定要撤销订单吗?',
        success: function (res) {
          if (res.confirm) {
            console.log('用户点击确定')
            wx.request({
              url: wx.getStorageSync('prefixURL') + '/insuranceOrder/setNotActive', //服务器地址
              menthod: "POST",
              header: {
                'content-type': 'application/json'
              },
              data: {
                orderId:that.data.myOrderInfo.orderId
              },
              success: function (res) {
                if (res.data==true) {
                  wx.showToast({
                    title: '撤保请求已发出',
                    icon: 'success',
                    duration: 2000
                  });
                }else{
                  wx.showToast({
                    title: '撤保请求失败',
                    icon: 'error',
                    duration: 2000
                  });
                }
              }
            })
          } else if (res.cancel) {
            console.log('用户点击取消')
          }
        }
      })
    } else
      wx.showToast({
        title: '该订单已过期！',
        icon: 'none',
        duration: 5000
      })
  },
  applyClaim: function () {
    let that = this;
    console.info(new Date(that.data.myOrderInfo.expireTime));
    console.info(new Date().toLocaleDateString());//格式为 YYYY/MM/DD
    // console.info(that.data.myOrderInfo.expireTimeDate.getTime()<new Date().getTime());
    if (new Date(that.data.myOrderInfo.expireTime) > new Date()) {
      wx.showModal({
        title: '提示',
        content: '接下来将选择证明材料，是否继续?',
        success: function (res) {
          if (res.confirm) {
            console.log('用户点击确定')
            //         wx.navigateTo({
            //     url: '/pages/user/user_claim/apply_applicant'
            // })
            wx.chooseMessageFile({
              count: 1,
              type: 'file',
              success(res) {
                const tempFilePaths = res.tempFiles[0].path;
                console.info("选择文件路径：" + tempFilePaths);
                wx.uploadFile({
                  url: wx.getStorageSync('prefixURL') + '/insuranceClaim/tryClaim', //服务器地址

                  header: { "Content-Type": "multipart/form-data" },//类型
                  filePath: tempFilePaths,
                  name: 'file',
                  formData: {
                    // name: encodeURI(logoName)
                    // orderId:JSON.stringify(that.data.myOrderInfo.orderId) ,
                    // openId: JSON.stringify(wx.getStorageSync('openId'))
                    orderId: that.data.myOrderInfo.orderId,
                    openId: wx.getStorageSync('openId')
                  },
                  success(res) {
                    const data = res.data;
                    console.info("result from backend is " + data);
                    if (data == true || data == 'true') {
                      wx.showToast({
                        title: '成功',
                        icon: 'success',
                        duration: 2000
                      });
                    }
                    else {
                      wx.showToast({
                        title: '错误！请稍后重试',
                        // icon: 'success',
                        duration: 2000
                      });
                    }
                    //do something
                  }
                })
              },
              fail() {
                console.info('选择文件失败');
              }
            })
          } else if (res.cancel) {
            console.log('用户点击取消')
          }
        }
      })
    } else
      wx.showToast({
        title: '该订单已过期！',
        icon: 'none',
        duration: 5000
      })

    // console.info("before unifiedorder, serviceId is "+that.data.serviceId);

  }
})