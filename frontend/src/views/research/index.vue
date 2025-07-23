<template>
  <div class="research-container">
    <h1 class="research-title">关于该项目的学科研究</h1>
    <div class="timeline">
      <div class="timeline-item" v-for="(article, index) in articles" :key="index">
        <div class="card">
          <div class="card-header">
            <h2 class="card-title">{{ article.title }}</h2>
            <span class="card-date">{{ article.date }}</span>
            <div class="card-tags">
              <span v-for="tag in article.tags" :key="tag" class="tag">{{ tag }}</span>
            </div>
          </div>
          <div class="card-content" v-html="article.content"></div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'ResearchPage',
  data() {
    return {
      articles: [
        {
          title: '从互联网产品兴衰史谈数字经济的发展',
          date: '2025-07-23',
          content: `
            <h3>被淘汰的互联网产品：历史的镜子</h3>
            <h4>百度外卖：本地服务的短暂辉煌</h4>
            百度外卖曾是中国外卖市场的早期参与者，凭借百度强大的流量支持迅速崛起。然而，随着美团和饿了么通过补贴战和数据驱动的优化占据主导地位，百度外卖的市场份额逐渐萎缩。2017年，百度将其外卖业务出售给饿了么，退出这一赛道。这一案例表明，在高度竞争的本地服务市场中，缺乏独特定位和快速迭代能力的产品难以长期生存。<br><br>

            <h4>腾讯微博：社交平台的失利</h4>
            腾讯微博于2010年推出，试图挑战新浪微博的地位。然而，其功能同质化严重，用户粘性不足，且微信的崛起分流了社交资源。2016年，腾讯宣布停止更新腾讯微博，将重点转向微信生态。这一转变揭示了单一社交平台的局限性，在多功能超级应用面前难以抗衡。<br><br>

            <h4>Skype：通信工具的式微</h4>
            Skype曾是互联网通信的标杆，但随着移动互联网兴起，WhatsApp、Zoom等移动优先的通讯工具抢占市场。2021年起，微软逐步淡化Skype品牌，表明传统PC端工具难以适应移动化和视频化趋势。这一案例提示，技术迭代速度决定了一个产品的生命周期。<br><br>

            <h4>易迅网：电商平台的夭折</h4>
            易迅网作为京东的早期竞争对手，曾在中国电商市场崭露头角。然而，2014年京东收购易迅网后，其独立品牌逐渐消失。易迅网的衰落源于无法与京东的供应链和物流体系抗衡，凸显了电商行业规模化竞争的残酷性。<br><br>

            <h4>UC浏览器：移动浏览器的没落</h4>
            UC浏览器曾是中国移动浏览器的领先者，凭借数据压缩和本地化优化吸引用户。但随着谷歌Chrome和国内厂商自研浏览器的崛起，阿里巴巴2014年收购UC后，其独立发展受限，市场份额逐步下滑。这反映了移动互联网时代，浏览器市场的整合趋势。<br><br>

            <h4>开心网：社交网络的黄昏</h4>
            开心网是中国第一代社交网络的代表，模仿Facebook推出“偷菜”等游戏，一度风靡。2008年至2011年间，其用户数激增，但随后因微信、QQ空间的竞争以及游戏模式的单一化，开心网逐渐衰落并转型为职场平台。这一案例表明，社交产品需不断创新以保持活力。<br><br>

            <h3>从兴衰看中国数字经济的演进</h3>
            <h4>平台整合与生态构建</h4>
            腾讯微博的衰落与微信的崛起相辅相成，体现了中国互联网企业通过超级生态构建竞争优势的策略。微信整合了社交、支付、电商等功能，2024年其小程序交易额预计已超2万亿元，成为数字经济的核心基础设施。类似地，阿里巴巴通过淘宝、支付宝构建了电商和金融生态，而百度则通过AI技术支持智能搜索和无人驾驶，形成了技术驱动的生态模式。这种整合能力帮助中国企业在全球竞争中占据一席之地。<br><br>

            <h4>电商与本地服务的竞争与创新</h4>
            易迅网的退出和百度外卖的没落，加速了京东、美团等平台的崛起。这些平台通过大数据和人工智能优化供应链与配送服务，深刻改变了传统行业。2024年，中国电商市场规模预计达15万亿元，外卖市场超1.5万亿元，显示数字化如何重塑消费模式。此外，拼多多等平台的崛起表明，低价策略和社交电商模式为数字经济注入了新活力。<br><br>

            <h4>技术升级与产业融合</h4>
            Skype和UC浏览器的式微表明，通信和浏览工具需顺应移动化和智能化趋势。中国企业在此领域表现突出，字节跳动的飞书、钉钉等工具结合AI和云服务，服务于远程办公和企业协作。2025年，产业互联网渗透率预计达40%，AI专利申请量位居全球前列（如百度2020年申请9364项AI专利），显示技术创新如何驱动实体经济。<br><br>

            <h4>社交与内容平台的迭代</h4>
            开心网的衰落和新一代社交平台（如抖音、快手）的兴起，反映了中国社交网络从游戏驱动向短视频和直播转型。2024年，抖音月活用户超8亿，快手超6亿，这些平台通过算法推荐和内容创作，成为数字经济的重要增长点，带动了电商、广告等产业链的繁荣。<br><br>

            <h3>数字经济的发展机遇与挑战</h3>
            中国数字经济的快速发展得益于政策支持、市场需求和技术创新。“十四五”规划将数字经济列为重点发展领域，2025年政府投入预计超5000亿元用于5G、云计算和AI基础设施建设。同时，庞大的消费市场（如2024年网民规模超11亿）为企业提供了试验场。<br><br>

            然而，挑战同样存在。被淘汰产品的案例表明，过度依赖单一模式或忽视用户需求可能导致失败。此外，数据隐私和监管压力日益增加，2024年中国出台了更严格的数据安全法，限制跨境数据流动，这对互联网企业提出了更高要求。国际竞争加剧也迫使中国企业需在全球化中寻找平衡，例如抖音在印度市场的退出提醒了地缘政治风险。<br><br>

            <h3>未来展望</h3>
            从互联网产品兴衰史中，我们看到，适应技术潮流、构建生态系统和持续创新是数字经济发展的关键。中国正通过政策引导和企业协同，加速向智能化、绿色化方向迈进。未来，AI、大数据和区块链或将进一步推动产业融合，而淘汰掉不适应新趋势的产品也将常态化。<br><br>

            与此同时，中国数字经济的影响力正扩展至全球。阿里巴巴的跨境电商、腾讯的WeChat Pay和百度的AI技术已在“一带一路”沿线国家落地，2024年数字贸易额预计超6000亿美元。这不仅体现了中国方案的竞争力，也为全球数字经济提供了借鉴。<br><br>

            通过审视历史，我们不仅能理解数字经济的过去与现在，更能为未来提供启示。在这个快速变化的时代，唯有洞察趋势、勇于变革，方能引领数字经济的浪潮。
          `,
          tags: ['互联网', '数字经济', '技术创新']
        }
      ]
    };
  }
};
</script>

<style scoped>
.research-container {
  max-width: 1200px;
  margin: 0 auto;
  padding: 20px;
  background-color: #fff;
 
}

.research-title {
  font-size: 32px;
  font-weight: bold;
  text-align: center;
  margin-bottom: 30px;
  color: #333;
}

.timeline {
  position: relative;
}

.timeline-item {
  margin-bottom: 40px;
  padding-left: 20px;
  position: relative;
}

.timeline-item::before {
  content: '';
  position: absolute;
  left: 0;
  top: 0;
  height: 100%;
  width: 2px;
  background-color: #ccc;
}

.card {
  background-color: #f9f9f9;
  border-radius: 8px;
  padding: 15px;
}

.card-header {
  margin-bottom: 10px;
}

.card-title {
  font-size: 22px;
  color: #007bff;
  margin: 0;
}

.card-date {
  font-size: 14px;
  color: #666;
  margin-top: 5px;
  display: block;
}

.card-tags {
  margin-top: 5px;
}

.tag {
  display: inline-block;
  background-color: #e9ecef;
  color: #333;
  padding: 2px 10px;
  border-radius: 12px;
  font-size: 12px;
  margin-right: 5px;
}

.card-content {
  font-size: 16px;
  line-height: 1.6;
  color: #666;
  margin-bottom: 10px;
}

.card-content h3 {
  font-size: 20px;
  color: #0056b3;
  margin-top: 15px;
}

.card-content h4 {
  font-size: 18px;
  color: #007bff;
  margin-top: 10px;
}
</style>
