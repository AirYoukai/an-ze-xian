// pages/user/user_order_info/user_order_info.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    myClaimInfo: {},
    axis: [

    ],
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    let _this = this;
    const i = options.id;//这里的options就是上一个页面中，跳转链接后面跟的参数 xx=xxx&xx=xxxx
    let tmp = wx.getStorageSync('myClaims')[i];
    let timeArray = [];
    let status = "";
    timeArray.push({
      time: tmp.createTime.year + "-" + tmp.createTime.monthValue + "-" + tmp.createTime.dayOfMonth,
      name: '开始',
    });
    if (tmp.reviewStaffTime != null) {
      status = (tmp.statusStaff == "DENIED") ? '员工审核结果：未通过' : '员工审核结果：通过';
      timeArray.push({
        time: tmp.reviewStaffTime.year + "-" + tmp.reviewStaffTime.monthValue + "-" + tmp.reviewStaffTime.dayOfMonth,
        name: status,
      });
    }
    if (tmp.reviewManagerTime != null) {
      status = (tmp.statusManager == "DENIED") ? '领导审核结果：未通过' : '领导审核结果：通过';
      timeArray.push({
        time: tmp.reviewManagerTime.year + "-" + tmp.reviewManagerTime.monthValue + "-" + tmp.reviewManagerTime.dayOfMonth,
        name: status,
      });
    }
    if (tmp.paybackTime != null) {
      timeArray.push({
        time: tmp.paybackTime.year + "-" + tmp.paybackTime.monthValue + "-" + tmp.paybackTime.dayOfMonth,
        name: '已赔款',
      });
    }
    let currentStatus = "暂无进展";
    switch (tmp.curPos) {
      case 0:
        currentStatus = "待员工审核";
        break;
      case 1:
        currentStatus = "待领导审核";
        break;
      case 2:
        currentStatus = "待赔款";
        break;
      case 3:
        currentStatus = "流程结束";
        break;
      default:break;
      // 与 case 1 和 case 2 不同时执行的代码
    }
    _this.setData({
      myClaimInfo: {
        "currentStatus": currentStatus,
        "reviewStaffName":(tmp.userManageReviewStaff==null)?('暂无'):(tmp.userManageReviewStaff.userRealName),
        "reviewManagerName": (tmp.userManageReviewManager==null)?('暂无'):(tmp.userManageReviewManager.userRealName),
        "serviceName": tmp.insuranceOrder.insuranceService.serviceName,
        "servicePremium": tmp.insuranceOrder.insuranceService.servicePremium,
      }
    })
    _this.setData({
      axis: _this.data.axis.concat(timeArray)
    });

    wx.setNavigationBarTitle({
      title: "流程详情"
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
  applyClaim: function () {
    let that = this;
    wx.showModal({
      title: '提示',
      content: '确认要进行流程吗?',
      success: function (res) {
        if (res.confirm) {
          console.log('用户点击确定')
          //         wx.navigateTo({
          //     url: '/pages/user/user_claim/apply_applicant'
          // })
          wx.chooseMessageFile({
            count: 10,
            type: 'file',
            success(res) {
              // tempFilePath可以作为img标签的src属性显示图片
              const tempFilePaths = res.tempFiles;
              // console.info("选择文件："+res);
              wx.uploadFile({
                url: wx.getStorageSync('prefixURL')+'/insuranceClaim/tryClaim', //服务器地址
      filePath: tempFilePaths[0],
                name: 'file',
                formData: {
                  'user': 'test'
                },
                success(res) {
                  const data = res.data
                  //do something
                }
              })
            }
          })
        } else if (res.cancel) {
          console.log('用户点击取消')
        }
      }
    })
    // console.info("before unifiedorder, serviceId is "+that.data.serviceId);

  }
})