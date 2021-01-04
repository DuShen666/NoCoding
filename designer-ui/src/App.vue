<template>
  <div id="app">
    <div id="toolBar"></div>
    <div id="content">
      <div id="leftBar">
        <div id="toolBox">
          <ToolItem
            :label="item.label"
            v-for="(item, index) in componentList"
            :key="index"
          />
        </div>
      </div>
      <div id="property"></div>
      <Canvas id="canvas" />
      <div style="clear: both"></div>
    </div>
  </div>
</template>

<script>
import ToolItem from "./components/ToolItem.vue";
import Canvas from "./components/Canvas.vue";

export default {
  name: "App",
  components: {
    ToolItem,Canvas
  },
  data() {
    return {
      componentList: [
        {
          name: "t1",
          label: "组件一",
          style: {
            width: 200,
            height: 33,
          },
        },
        {
          name: "t2",
          label: "组件二",
          style: {
            width: 300,
            height: 60,
          },
        },
      ],
    };
  },
  created() {
    
  },
};
</script>

<style>
body {
  margin: 0;
  padding: 0;
}
#app,
#content {
  width: 100%;
}
#toolBar {
  width: 100%;
  height: 50px;
  background: #fff;
  border-bottom: 1px solid #ccc;
}
#leftBar {
  width: 200px;
  background: #fff;
  border-right: 1px solid #ccc;
  float: left;
}
#canvas {
  width: calc(100% - 410px);
  height: 1000px;
}
#property {
  float: right;
  width: 200px;
  height: 200px;
  background: #fff;
  border-left: 1px solid #ccc;
}
</style>
