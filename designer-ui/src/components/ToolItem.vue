<template>
  <div
    @dragstart="handleDragstart"
    :class="{ active: isActive, toolItem: true }"
    draggable="true"
  >
    <a href="#">{{ label }}</a>
  </div>
</template>
<script>
export default {
  props: {
    label: String,
  },
  data() {
    return {
      isActive: false,
    };
  },
  methods: {
    handleDragstart(e) {
      e.dataTransfer.setData("index", e.target.dataset.index);
    },
  },
};
</script>
<style lang="css" scoped>
.toolItem {
  line-height: 30px;
  height: 30px;
  background-color: #fff;
  list-style: none;
  padding: 10px;
}
.toolItem:hover {
  background-color: honeydew;
}
.toolItem.active {
  background-color: lavenderblush;
  border: 1px solid green;
  font-weight: bolder;
}
</style>