Page({
  data: {
    showsearch:false,   //显示搜索按钮
    searchtext:'',  //搜索文字
    filterdata:{},  //筛选条件数据
    showfilter:false, //是否显示下拉筛选
    showfilterindex:null, //显示哪个筛选类目
    sortindex:0,  //一级分类索引
    sortid:null,  //一级分类id
    subsortindex:0, //二级分类索引
    subsortid:null, //二级分类id
    cityindex:0,  //一级城市索引
    cityid:null,  //一级城市id
    subcityindex:0,  //二级城市索引
    subcityid:null, //二级城市id
    myOrderList:[], //服务集市列表
    scrolltop:null, //滚动位置
    page: 0  //分页
  },
  onLoad: function () { //加载数据渲染页面

  },

  onShow:function(){
    wx.showLoading({title: '加载中…'});
    this.getMyOrders();
    this.fetchFilterData();
  },

  getMyOrders: function () {
    let that=this;
    wx.request({//已改
      url: wx.getStorageSync('prefixURL')+'/insuranceOrder/selectByOpenId', //服务器地址
        menthod: "POST",
      header: {
        'content-type': 'application/json'
      },
      data: {
        openId: wx.getStorageSync('openId')
        // openId:that.globalData.openid
      },
      success: function (res) {
        wx.setStorageSync('myOrders', res.data);
        that.fetchServiceData();
      }
    })
  },

  fetchFilterData:function(){ //获取筛选条件
    this.setData({
      filterdata:{
        "sort": [
            {
                "id": 0,
                "title": "全部"
            },
            {
              "id": 1,
              "title": "人力资源",
              "subsort": [
                {
                    "id": 1,
                    "title": "全部"
                },
                {
                    "id": 11,
                    "title": "社会及商业"
                },
                {
                    "id": 12,
                    "title": "招聘、猎头"
                },
                {
                    "id": 13,
                    "title": "薪酬绩效"
                },
              ]
            },
            {
              "id": 2,
              "title": "财务法务",
              "subsort": [
                {
                    "id": 2,
                    "title": "全部"
                },
                {
                    "id": 21,
                    "title": "知识产权保护"
                },
                {
                    "id": 22,
                    "title": "工商注册"
                },
                {
                    "id": 23,
                    "title": "法律咨询"
                },
              ]
            },
            {
              "id": 3,
              "title": "行政办公",
              "subsort": [
                {
                    "id": 3,
                    "title": "全部"
                },
                {
                    "id": 31,
                    "title": "翻译"
                },
                {
                    "id": 32,
                    "title": "速记"
                }
              ]
            },
            {
              "id": 4,
              "title": "创业指导",
              "subsort": [
                {
                    "id": 4,
                    "title": "全部"
                },
                {
                    "id": 41,
                    "title": "创业培训"
                }
              ]
            },
        ],
        "city": [
            {
                "id": 0,
                "title": "全部"
            },
            {
              "id": 1,
              "title": "湖北省",
              "subcity": [
                {
                    "id": 1,
                    "title": "全部"
                },
                {
                    "id": 11,
                    "title": "武汉市"
                },
                {
                    "id": 12,
                    "title": "襄阳市"
                },
                {
                    "id": 13,
                    "title": "孝感市"
                },
                {
                    "id": 14,
                    "title": "随州市"
                },
                {
                    "id": 15,
                    "title": "荆州市"
                },
                {
                    "id": 16,
                    "title": "黄冈市"
                },
                {
                    "id": 17,
                    "title": "天门市"
                },
                {
                    "id": 18,
                    "title": "仙桃市"
                },
                {
                    "id": 19,
                    "title": "潜江市"
                },
                {
                    "id": 20,
                    "title": "十堰市"
                },
                {
                    "id": 21,
                    "title": "宜昌市"
                },
                {
                    "id": 22,
                    "title": "咸宁市"
                },
              ]
            },
            {
              "id": 2,
              "title": "浙江省",
              "subcity": [
                {
                    "id": 2,
                    "title": "全部"
                },
                {
                    "id": 21,
                    "title": "杭州市"
                },
                {
                    "id": 22,
                    "title": "金华市"
                },
                {
                    "id": 23,
                    "title": "义乌市"
                },
              ]
            },
            {
              "id": 3,
              "title": "江苏省",
              "subcity": [
                {
                    "id": 3,
                    "title": "全部"
                },
                {
                    "id": 31,
                    "title": "南京市"
                },
                {
                    "id": 32,
                    "title": "苏州市"
                }
              ]
            }
        ],
      }
    })
  },
  fetchServiceData:function(){  //获取城市列表
    let _this = this;
    // wx.showToast({
    //   title: '加载中',
    //   icon: 'loading'
    // })
    const perpage = 10;
    this.setData({
      page:this.data.page+1
    })
    const page = this.data.page;
    let myOrders = wx.getStorageSync('myOrders');
    console.info("myOrders= "+JSON.stringify(myOrders));
    const newlist = [];

    for (var i =0; i < myOrders.length; i++) {
      newlist.push({
          "id": i,//这个id并非数据库中的id而是在页面从上到下的顺序
          "serviceName":myOrders[i].insuranceService.serviceName,
          "companyName":myOrders[i].insuranceService.insuranceCompany.companyName,
          "industry":myOrders[i].insuranceService.industry
      });
    }
    setTimeout(()=>{
      _this.setData({
        myOrderList:newlist
      })
      wx.hideLoading();
    },1500)
  },
  inputSearch:function(e){  //输入搜索文字
    this.setData({
      showsearch:e.detail.cursor>0,
      searchtext:e.detail.value
    })
  },
  submitSearch:function(){  //提交搜索
    console.log(this.data.searchtext);
    this.fetchServiceData();
  },
  setFilterPanel: function(e){ //展开筛选面板
    const d = this.data;
    const i = e.currentTarget.dataset.findex;
    if(d.showfilterindex == i){
      this.setData({
        showfilter: false,
        showfilterindex: null
      })
    }else{    
      this.setData({
        showfilter: true,
        showfilterindex:i,
      })
    }
    console.log(d.showfilterindex);
  },
  setSortIndex:function(e){ //服务类别一级索引
    const d= this.data;
    const dataset = e.currentTarget.dataset;
    this.setData({
      sortindex:dataset.sortindex,
      sortid:dataset.sortid,
      subsortindex: d.sortindex==dataset.sortindex ? d.subsortindex:0
    })
    console.log('服务类别id：一级--'+this.data.sortid+',二级--'+this.data.subsortid);
  },
  setSubsortIndex:function(e){ //服务类别二级索引
    const dataset = e.currentTarget.dataset;
    this.setData({
      subsortindex:dataset.subsortindex,
      subsortid:dataset.subsortid,
    })
    console.log('服务类别id：一级--'+this.data.sortid+',二级--'+this.data.subsortid);
  },
  // setCityIndex:function(e){ //服务城市一级索引
  //   const d= this.data;
  //   const dataset = e.currentTarget.dataset;
  //   this.setData({
  //     cityindex:dataset.cityindex,
  //     cityid:dataset.cityid,
  //     subcityindex: d.cityindex==dataset.cityindex ? d.subcityindex:0
  //   })
  //   console.log('服务城市id：一级--'+this.data.cityid+',二级--'+this.data.subcityid);
  // },
  // setSubcityIndex:function(e){ //服务城市二级索引
  //   const dataset = e.currentTarget.dataset;
  //   this.setData({
  //     subcityindex:dataset.subcityindex,
  //     subcityid:dataset.subcityid,
  //   })
  //   console.log('服务城市id：一级--'+this.data.cityid+',二级--'+this.data.subcityid);
  // },
  hideFilter: function(){ //关闭筛选面板
    this.setData({
      showfilter: false,
      showfilterindex: null
    })
  },
  scrollHandle:function(e){ //滚动事件
    this.setData({
      scrolltop:e.detail.scrollTop
    })
  },
  goToTop:function(){ //回到顶部
    this.setData({
      scrolltop:0
    })
  },
  scrollLoading:function(){ //滚动加载
    this.fetchServiceData();
  },
  onPullDownRefresh:function(){ //下拉刷新
    this.setData({
      page:0,
      myOrderList:[]
    })
    this.fetchServiceData();
    this.fetchFilterData();
    setTimeout(()=>{
      wx.stopPullDownRefresh()
    },1000)
  }
})