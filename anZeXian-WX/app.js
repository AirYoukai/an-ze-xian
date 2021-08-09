// app.js
// var that = this;
App({
  globalData: {
    // contextPath:"https://www.ylxteach.net/anZeXian",//这是服务器接口的前缀
    prefixURL: "http://10.132.163.172:8080/anZeXian",
    userInfo: null,
    sessionKey: "",
    openid: "",
    appid: "wxe665f52060db5e0b",
    body: "成都亚利欣科技有限公司",
    serviceId: "",
    allService: [],//全部可用的service
    myOrders: [],//我的订单
    applicant: {
      applicantName: "",
      applicantAddress: "",
      organizationCode: "",
      licenseCode: "",
      contactName: "",
      contactPhone: "",
      contactZipCode: ""
    },
    insured: {
      insuredName: "",
      insuredAddress: "",
      organizationCode: "",
      licenseCode: "",
      businessArea: "",
      employeeNumber: "",

      contactName: "",
      contactPhone: "",
      contactZipCode: ""
    }
  },
  onLaunch() {
    //  wx.showLoading({title: '加载中…'});
    let that = this;
    // 展示本地存储能力
    
    // wx.setStorageSync('prefixURL', "http://10.132.163.172:8080/anZeXian");
    // wx.setStorageSync('prefixURL', "http://localhost:8080/anZeXian");
    wx.setStorageSync('prefixURL', "https://www.ylxteach.net/anZeXian");

   //contextPath 是服务器域名的前缀
    wx.switchTab({
      url: '/pages/apply/apply_map/apply_map'
    });
    wx.setStorageSync('loginFlag', false);//未登录
    const logs = wx.getStorageSync('logs') || []
    logs.unshift(Date.now())
    wx.setStorageSync('logs', logs);
    wx.getSetting({
      success: res => {
        if (res.authSetting['scope.userInfo']) {
          // 已经授权，可以直接调用 getUserInfo 获取头像昵称，不会弹框
          wx.getUserInfo({
            success: res => {
              // 可以将 res 发送给后台解码出 unionId
              this.globalData.userInfo = res.userInfo
              // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
              // 所以此处加入 callback 以防止这种情况
              if (this.userInfoReadyCallback) {
                this.userInfoReadyCallback(res)
              }
            }
          })
        }
      }
    });


  }
})
