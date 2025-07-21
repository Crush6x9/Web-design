<template>
  <div class="container">
    <div class="grid">
      <div v-for="item in items" :key="item.id" class="grid-item">
        <div class="item-content">
          <img :src="item.image" class="item-image" />
          <div class="text-content">
            <h3 class="item-title">{{ item.title }}</h3>
            <p class="item-text">{{ item.description }}</p>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      items: [
        { id: 1, title: '百度外卖 2014.5-2017.8', description: '百度外卖，是百度公司于2014年5月正式推出的一款O2O生活服务网站，为客户提供外卖配送服务。2017年8月，百度以5亿美元将百度外卖出售给饿了么，并在2018年10月更名为“饿了么星选”', image: require('@/assets/images/BaiDuTakeout.png') },
        { id: 2, title: '百度医生 2015.1.8-2017.4.1', description: '从2015年1月8日成立，到2017年2月9日裁撤，百度医疗事业部一共存在了764天。该事业部旗下的产品——“百度医生”在4月1日正式关停，平台上所有数据至此全部清空；现衍生出“百度健康”', image: require('@/assets/images/BaiDuDoctor.png') },
        { id: 3, title: '百度云OS 2011.9-2015.3', description: '百度云OS，由中国百度所研发的移动操作系统，根源自谷歌Android操作系统。在2011年首次推出。虽然使用Linux内核，但未依照LGPL发布源代码。2015年三月无限期停止更新，官方论坛也被关闭', image: require('@/assets/images/BaiDuOS.png') },
        { id: 4, title: '腾讯微博 2010.4.1-2014.7', description: '一项微博客服务。微博用户可以通过网页、短信、手机程序、QQ等方式发布最长140字的广播，后因新浪微博的崛起几乎处于半废止状态', image: require('@/assets/images/TencentWB.png') },
        { id: 5, title: 'QQ宠物 2005.6-2018.9.15', description: '全球首款基于IM的桌面虚拟宠物养成游戏。次年7月，QQ宠物同时在线用户数突破百万，成为全球最大的虚拟宠物社区。2010年，由于奇虎360与腾讯QQ争斗事件，使用“360扣扣保镖”软件的使用者无法正常运行QQ宠物。后宣布停止运营', image: require('@/assets/images/QQPet.jpg') },
        { id: 6, title: 'QQ旋风 2008-2017.8.3', description: '一款下载工具，前身为超级旋风。2017年8月3日，QQ旋风项目组在官网发布《QQ旋风下线公告》，宣布项目将于2017年9月6日停止运营，软件、网站已停止提供，增值功能将停止服务', image: require('@/assets/images/QQDownload.png') },
        { id: 7, title: '雅虎中国 1999.9-2013.9.1', description: '1999年9月雅虎网正式开通。2005年10月，阿里巴巴和雅虎全球达成战略合作，全资收购雅虎中国，并更名为阿里巴巴雅虎。2013年9月1日零时起，不再提供资讯及社区服务。原有团队将专注于阿里巴巴集团公益事业的传播', image: require('@/assets/images/YAHOO.png') },
        { id: 8, title: '阿里软件 2007.1.8-2010.4.30', description: '一间商务软件研发公司，研发的软件有网店管理软件，适用于阿里巴巴网站和淘宝网，当中较为著名的软件是即时通讯软件阿里旺旺。阿里软件于2010年4月30日起关停阿里软件社区、互联平台、软件开发平台、服务接口调用服务', image: require('@/assets/images/AliSoft.png') },
        { id: 9, title: '虾米音乐 2007-2021.2.5', description: '虾米音乐是专业的音乐内容发现及消费平台，依托曲库全、分类细，同时致力于扶持原创音乐。2021年1月5日，虾米音乐发布官方声明表示，虾米音乐播放器业务于2021年2月5日正式停止服务；3月5日0点后运营均停止并关闭服务器', image: require('@/assets/images/XiaMiMusic.png') },
        { id: 10, title: '网易云相册 2003-2019.5.8', description: '网易相册曾凭借免费使用、无限容量、速度快等优点，一度成为国内最大、知名度最高的网络相册。经过十多年的发展，网易相册已拥有1.3亿用户、56亿相片。2019年5月8日，网易相册全面停止运营并关闭服务器', image: require('@/assets/images/163Album.png') },
        { id: 11, title: '非人学院 2018.6.22-2025.6.18', description: '《非人学园》是由网易游戏Inception工作室自研的一款无厘头漫画风5V5对战游戏。2018年6月22日，游戏App Store独家首发，6月26日在全平台进行公测；2025年6月18日关闭游戏服务器，仅保留“细水长流”服务器', image: require('@/assets/images/163MOBA.png') },
        { id: 12, title: '网易考拉 2015.1.9-2019.9.6', description: '考拉海购目前是阿里巴巴旗下以跨境进口业务为主的会员电商，主打官方自营，全球直采的零售模式。于2015年1月9日公测，2019年9月6日，阿里巴巴集团宣布20亿美元全资收购考拉海购，领投网易云音乐7亿美元融资', image: require('@/assets/images/163Koala.png') },
        { id: 13, title: 'Google+ 2011-2019.4.2', description: '在2011年Google+上线，2013年时成为仅次于Facebook的全球第二大社交网站。2018年10月时由于软体漏洞，Google+可能有多达50万用户的个人资料遭到泄露。最终在2019年的4月2日，Google宣布关闭个人版本的Google+', image: require('@/assets/images/Google+.png') },
        { id: 14, title: 'Google Allo 2016-2019.3', description: '一款发布于2016年Google I/O开发者大会上的即时通讯软件，其最特别的一点在于，在软件中内置了一个虚拟助手为你推荐回复，并且随着用户的使用习惯进行调整。但是Google Allo的安装用户量却并不高，于2019年3月后停止工作', image: require('@/assets/images/GoogleAllo.png') },
        { id: 15, title: 'GoogleReader 2007.9.17-2013.7.1', description: 'Google Blog的一句话或许可以解答它的停运：我们在2007年推出了 Google 阅读器，皆在让人们发现并关注自己喜爱的网站。虽然该产品具有忠诚的追随者，但多年来使用率下降。因此，在2013年7月1日，我们将退出 Google 阅读器', image: require('@/assets/images/GoogleReader.png') },
        { id: 16, title: 'Skype 2003-2025.5', description: 'Skype于2003年在爱沙尼亚推出并迅速流行，成为用户免费拨打全球电话的热门工具。2025年2月28日，最新的Skype预览版中有这样一条信息：“从5月起，Skype将停止提供服务。请在Teams中继续进行通话和聊天。”', image: require('@/assets/images/Skype.png') },
        { id: 17, title: 'Windows地图 2015.7.29-2025.7', description: '微软计划在2025年7月下架Windows地图应用。这款地图服务在过去为用户提供了导航和位置查询功能，但随着其他地图应用的崛起，Windows地图的使用频率大幅下降，最终在微软商店下架', image: require('@/assets/images/WindowsMap.png') },
        { id: 18, title: 'Hotmail 1996.7.4-2013.5.2', description: '2012年7月31日开始，微软Outlook将逐步淘汰Hotmail服务，凸显云计算战略。美国时间2013年5月2日，微软宣布完成Hotmail到Outlook邮箱的升级，用户访问Hotmail将被重定向至Outlook邮箱。Hotmail正式终结', image: require('@/assets/images/Hotmail.png') },
        { id: 19, title: 'LifeStage 2016-2017.8', description: '2016年推出的独立社交媒体软件，该应用需绑定手机号，且仅当同一学校有20名学生注册时开放该校社区互动功能；超过21岁的用户无法查看他人资料。2017年8月，因用户活跃度不足，Facebook宣布关闭Lifestage并下架应用', image: require('@/assets/images/LifeStage.png') },
        { id: 20, title: 'Oculus 2021-2017.5', description: 'Meta公司旗下的一家美国虚拟现实科技公司，首件产品Oculus Rift是一款逼真的虚拟现实头戴式显示器，且目前已经在市面上贩售。2017年5月，Facebook宣布将关闭Oculus的VR内容制作部门“Oculus Story Studio”', image: require('@/assets/images/Oculus.png') },
        { id: 21, title: 'Novi 2020.5-2022.7', description: 'Novi是Meta为支持数字货币交易而开发的数字钱包服务，试点期间采用与美元挂钩的稳定币USDP。2021年12月，Novi通过WhatsApp在美国启动加密货币支付试点 ；但因监管压力，于2022年7月宣布终止服务', image: require('@/assets/images/Novi.png') },
        // require('@/assets/images/.png')
        { id: 22, title: 'Crucible 2020.5-2020.10', description: '《Crucible》是由亚马逊旗下游戏工作室Relentless Studios研发的一款团队射击竞技游戏。游戏首日的在线人数超过了2.5万人，但在Steam玩家的好评率却只有40%，最终拉回测试后取消该项目', image: require('@/assets/images/Crucible.png') },
        { id: 23, title: '百度贴吧', description: '这是一个描述', image: 'https://via.placeholder.com/50' },
        { id: 24, title: '百度贴吧', description: '这是一个描述', image: 'https://via.placeholder.com/50' },
        { id: 25, title: '百度贴吧', description: '这是一个描述', image: 'https://via.placeholder.com/50' },
        { id: 26, title: '百度贴吧', description: '这是一个描述', image: 'https://via.placeholder.com/50' },
        { id: 27, title: '百度贴吧', description: '这是一个描述', image: 'https://via.placeholder.com/50' },
        { id: 28, title: '百度贴吧', description: '这是一个描述', image: 'https://via.placeholder.com/50' },
        { id: 29, title: '百度贴吧', description: '这是一个描述', image: 'https://via.placeholder.com/50' },
        { id: 30, title: '百度贴吧', description: '这是一个描述', image: 'https://via.placeholder.com/50' }
      ]
    };
  }
};
</script>

<style scoped>
.container {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
  margin-top: 2%;
}

.grid {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  gap: 40px;
  width: 90%;
  margin: 0 auto;
}

.grid-item {
  border: none;
  border-bottom: 1px dashed #585757;
  padding: 10px;

}

.item-content {
  display: flex;
  align-items: center;
}

.item-image {
  max-width: 120px;
  height: auto;
  margin-right: 5px;
}

.text-content {
  flex: 1;
}

.item-title {
  margin-left: 10%;
  font-size: 18px;
  font-weight: bold;
}

.item-text {
  margin-left: 10%;
  font-size: 14px;
  color: #666;
}

#search-result {
  scroll-margin-top: 50px;
}
</style>
