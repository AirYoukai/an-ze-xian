// pages/apply/apply_news_info/apply_news_info.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    newsInfo:{},
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    const i = options.id;//这里的options就是上一个页面中，跳转链接后面跟的参数 xx=xxx&xx=xxxx
    let tmp=wx.getStorageSync('allNews')[i];
    console.info('newsInfo= '+JSON.stringify(tmp));
    this.setData({
      newsInfo:{
        "title":tmp.title,
        "shortContent":tmp.shortContent,
        "releaseTime": tmp.releaseTime.year + "-" + tmp.releaseTime.monthValue + "-" + tmp.releaseTime.dayOfMonth
      }
    })
    wx.setNavigationBarTitle({
      title: "新闻详情"
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

  }
})