<template>
  <div
    id="canvas"
    @drop="handleDrop"
    @dragover="handleDragover"
    @mousedown="handleMousedown"
  >
    <canvas
      style="position: absolute; top: 0; left: 0"
      width="1050"
      height="1000"
      ref="grids"
    ></canvas>
    <div id="mark-line"></div>
  </div>
</template>

<script>
export default {
  props: {
    msg: String,
  },
  mounted() {
    const context = this.$refs.grids.getContext("2d");
    context.fillStyle = "#fff";
    context.beginPath();
    context.fillRect(0, 0, context.canvas.width, context.canvas.height);
    drawGrid("#f0f0f0", 10, 10);
    function drawGrid(color, stepx, stepy) {
      context.save();

      context.strokeStyle = color;
      context.lineWidth = 0.5;
      // context.clearRect(0, 0, context.canvas.width, context.canvas.height);

      let count = 0;
      for (let i = stepx + 0.5; i < context.canvas.width; i += stepx) {
        if (count++ === 4) {
          count = 0;
          context.lineWidth = 1;
        } else {
          context.lineWidth = 0.5;
        }
        context.beginPath();
        context.moveTo(i, 0);
        context.lineTo(i, context.canvas.height);
        context.stroke();
      }
      count = 0;
      for (let i = stepy + 0.5; i < context.canvas.height; i += stepy) {
        if (count++ === 4) {
          count = 0;
          context.lineWidth = 1;
        } else {
          context.lineWidth = 0.5;
        }
        context.beginPath();
        context.moveTo(0, i);
        context.lineTo(context.canvas.width, i);
        context.stroke();
      }

      context.restore();
    }
  },
  methods: {
    handleDragover(e) {
      e.preventDefault();
      e.dataTransfer.dropEffect = "copy";
    },
    handleMousedown(e) {
      e.stopPropagation();
    },
    handleDrop(e) {
      e.preventDefault();
      e.stopPropagation();
      console.log(e);
    },
  },
};
</script>

<style scoped>
#canvas {
  position: relative;
  overflow: scroll;
}
</style>
