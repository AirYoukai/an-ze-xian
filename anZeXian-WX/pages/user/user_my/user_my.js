var app = getApp();
Page({
  /**
   * 页面的初始数据
   */
  data: {
    loginFlag: null //是否已登录
  },


  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    // let that = this;
    // that.setData({
    //   loginFlag: wx.getStorageSync('loginFlag')
    // })
    // console.info("当前是否已登录："+wx.getStorageSync('loginFlag'));
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
    let that = this;
    that.setData({
      loginFlag: wx.getStorageSync('loginFlag')
    })
    console.info("当前是否已登录：" + wx.getStorageSync('loginFlag'));
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
  logout: function () {
    let that = this;
    wx.showModal({
      title: '注销提示',
      content: '确定要退出吗?',
      success: function (res) {
        if (res.confirm) {
          console.log('用户点击确定');
          wx.showLoading({ title: '加载中…' });
          wx.setStorageSync('loginFlag', false);
          // 获取用户信息
          wx.showToast({
            title: '已退出登录',
            icon: 'success',
            duration: 2000
          });

          setTimeout(() => {
            // wx.switchTab({
            //   url: '/pages/user/user_my/user_my'
            // });
            that.onShow();
          }, 1500)
        } else if (res.cancel) {
          console.log('用户点击取消')
        }
      }
    })
  },
  scanCodeLoginWeb: function () {
    wx.scanCode({
      onlyFromCamera: true,
      success(res) {
        let loginCode = res.result.split("=")[1];
        console.log("loginCode=" + loginCode);
        //调用scanLoginWeb接口
        wx.request({
          url: wx.getStorageSync('prefixURL') + '/user/scanLoginWeb', //服务器地址
          menthod: "POST",
          header: {
            'content-type': 'application/json'
          },
          data: {
            openId: wx.getStorageSync('openId'),
            loginCode:loginCode
          },
          success: function (res) {
            if (res.data==true) {
              wx.showToast({
                title: '登录成功，网页自动跳转',
                icon: 'success',
                duration: 2000
              });
            }else{
              wx.showToast({
                title: '登录失败',
                icon: 'error',
                duration: 2000
              });
            }
          }
        })
      }
    })
  },
  login: function () {
    // 登录
    let that = this;
    wx.showModal({
      title: '登录提示',
      content: '接下来将获取您的用户信息，是否继续?',
      success: function (res) {
        if (res.confirm) {
          console.log('用户点击确定');
          wx.showLoading({ title: '加载中…' });
          wx.login({
            success: res => {
              // 发送 res.code 到后台换取 openId, sessionKey, unionId
              console.log("res.code=" + res.code);
              wx.request({
                url: wx.getStorageSync('prefixURL') + '/user/getOpenIdAndSessionKey?js_code=' + res.code, //服务器地址
                menthod: "GET",
                header: {
                  'content-type': 'application/json'
                },
                success: function (res) {
                  console.log("res got =" + JSON.stringify(res));
                  wx.setStorageSync('openId', res.data.openid);
                  wx.setStorageSync('sessionKey', res.data.session_key);
                  that.tryLogin();
                },
                fail: function (res) {
                  console.log(res);
                  wx.showModal({
                    title: '温馨提示',
                    content: '登录超时，请稍后重试',
                    confirmText: "确定",
                    // cancelText: "拒绝",
                    success: function (res) {
                      if (res.confirm) {
                        that.onShow();
                      }
                    }
                  });
                }
              });
            }
          })
          // 获取用户信息
        } else if (res.cancel) {
          console.log('用户点击取消')
        }
      }
    })
  },

  tryLogin: function () {
    let that = this;
    wx.request({
      url: wx.getStorageSync('prefixURL') + '/user/tryLogin', //服务器地址
      menthod: "POST",
      header: {
        'content-type': 'application/json'
      },
      data: {
        openId: wx.getStorageSync('openId')
      },
      success: function (res) {
        if (res.data.id != null) {
          wx.setStorageSync('loginFlag', true);
          // wx.hideLoading();
          wx.showToast({
            title: '登录成功',
            icon: 'success',
            duration: 2000
          });
          //这句话正式发布后要加上
          if (true) {
          // if (res.data.userRole == 0 || res.data.userRole == 1) {
            wx.showModal({
              title: '温馨提示',
              content: '服务号需要在有待办业务时向您发送消息',
              confirmText: "同意",
              cancelText: "拒绝",
              success: function (res) {
                if (res.confirm) {
                  that.subscribeMessage();
                } else if (res.cancel) {
                  ///显示第二个弹说明一下
                  wx.showModal({
                    title: '温馨提示',
                    content: '拒绝后您将无法获取实时的待办业务消息',
                    confirmText: "知道了",
                    showCancel: false,
                    success: function (res) { }
                  });
                }
                setTimeout(() => {
                  that.onShow();
                }, 1500)
              }
            });
          }
          setTimeout(() => {
            // wx.switchTab({
            //   url: '/pages/user/user_my/user_my'
            // });
            that.onShow()
          }, 1500)
        }

        else
          wx.showModal({
            title: '温馨提示',
            content: '您尚未注册，是否要注册账户？',
            confirmText: "同意",
            cancelText: "拒绝",
            success: function (res) {
              if (res.confirm) {
                console.log('用户点击确定');
                that.signUpByOpenId();
              }
            }
          });
      },
      fail: function () {
        wx.showModal({
          title: '温馨提示',
          content: '登录超时，请稍后重试',
          confirmText: "确定",
          // cancelText: "拒绝",
          success: function (res) {
            if (res.confirm) {
              that.onShow();
            }
          }
        });
      }
    });
  },

  signUpByOpenId: function () {
    let that = this;
    wx.request({
      url: wx.getStorageSync('prefixURL') + '/user/signup', //服务器地址
      menthod: "POST",
      header: {
        'content-type': 'application/json'
      },
      data: {
        openId: wx.getStorageSync('openId')
      },
      success: function (res) {
        if (res.data == true || res.data == 'true') {
          wx.setStorageSync('loginFlag', true);
          wx.showToast({
            title: '注册成功，将自动跳转',
            icon: 'success',
            duration: 2000
          });

          setTimeout(() => {
            // wx.switchTab({
            //   url: '/pages/user/user_my/user_my'
            // });
            that.onShow();
          }, 1500)
        }
      }
    })
  },

  getAccessToken: function () {
    let that = this;
    wx.request({
      url: wx.getStorageSync('prefixURL') + '/miniProgram/getAccessToken', //服务器地址
      menthod: "POST",
      header: {
        'content-type': 'application/json'
      },
      data: {
        // openId: wx.getStorageSync('openId')
      },
      success: function (res) {
        if (res.data != null && res.data != '') {
          console.info("获取token成功！token=" + res.data);
          wx.setStorageSync('accessToken', res.data)
        }
      }
    })
  },

  subscribeMessage: function () {
    let that = this;
    wx.requestSubscribeMessage({
      tmplIds: ['rpOdYba1dozS3QboRMmm2-4Yaguk8wrKYpLtrQbj0aI'],
      success: (res) => {
        console.log("订阅消息 成功 " + res);
      //   wx.getSetting({
      //     success (res) {
      //         if (res.authSetting['scope.userInfo'] == false) { //已拒绝
      //             //如果之前用户拒绝了，这时要调用wx.openSetting()方法，给用户再选择一次的机会
      //         }else if( res.authSetting['scope.userInfo'] == undefined ){ //未设置
      //             //在未设置的情况下，可以调用业务函数（如wx.getUserInfo，或wx.getLocation），系统会自动提示用户同意
      //         }else if( res.authSetting['scope.userInfo'] == true ){ //已授权
      //             //如果是已授权的情况下，直接调用业务函数，系统不会再提示用户
      //         }
      //     }
      // })
      },
      fail: (errCode, errMessage) => {
        console.log("订阅消息 失败 " + errCode + " message " + errMessage);
      },
      complete: (errMsg) => {
        console.log("订阅消息 完成 " + errMsg);
      }
    });
  },

  tryRequestMessage: function () {
    let that = this;
    wx.request({
      url: wx.getStorageSync('prefixURL') + '/miniProgram/tryRequestMessage', //服务器地址
      menthod: "POST",
      header: {
        'content-type': 'application/json'
      },
      data: {
        openId: wx.getStorageSync('openId'),
        templateId: "rpOdYba1dozS3QboRMmm2-4Yaguk8wrKYpLtrQbj0aI",
        page: "/pages/user/user_my/user_my"
      },
      success: function (res) {
        if (res.data == true) console.info("获取消息成功！");
        else console.info("获取消息失败！");
      }
    })
  }
})