
<template>
  <div ref="chartContainer" style="width: 800px; height: 400px"></div>
</template>

<script>
import * as echarts from "echarts"; // 引用

export default {
  data() {
    return {
      chart: null,
      option: {
        title: {
          text: "Nightingale Chart",
          subtext: "Fake Data",
          left: "center",
        },
        tooltip: {
          trigger: "item",
          formatter: "{a} <br/>{b} : {c} ({d}%)",
        },
        legend: {
          left: "center",
          top: "bottom",
          data: [
            "rose1",
            "rose2",
            "rose3",
            "rose4",
            "rose5",
            "rose6",
            "rose7",
            "rose8",
          ],
        },
        toolbox: {
          show: true,
          feature: {
            mark: { show: true },
            dataView: { show: true, readOnly: false },
            restore: { show: true },
            saveAsImage: { show: true },
          },
        },
        series: [
          {
            name: "Radius Mode",
            type: "pie",
            radius: [20, 140],
            center: ["25%", "50%"],
            roseType: "radius",
            itemStyle: {
              borderRadius: 5,
            },
            label: {
              show: false,
            },
            emphasis: {
              label: {
                show: true,
              },
            },
            data: [
              { value: 40, name: "rose 1" },
              { value: 33, name: "rose 2" },
              { value: 28, name: "rose 3" },
              { value: 22, name: "rose 4" },
              { value: 20, name: "rose 5" },
              { value: 15, name: "rose 6" },
              { value: 12, name: "rose 7" },
              { value: 10, name: "rose 8" },
            ],
          },
          {
            name: "Area Mode",
            type: "pie",
            radius: [20, 140],
            center: ["75%", "50%"],
            roseType: "area",
            itemStyle: {
              borderRadius: 5,
            },
            data: [
              { value: 30, name: "rose 1" },
              { value: 28, name: "rose 2" },
              { value: 26, name: "rose 3" },
              { value: 24, name: "rose 4" },
              { value: 22, name: "rose 5" },
              { value: 20, name: "rose 6" },
              { value: 18, name: "rose 7" },
              { value: 16, name: "rose 8" },
            ]
          }
        ]
      }
    };
  },
  mounted() {
    this.chart = echarts.init(this.$refs.chartContainer); // 检查是否成功初始化图表实例
    this.chart.setOption(this.option); // 设置选项并检查是否有错误发生。
  },
  methods: {
  }
};
</script>
