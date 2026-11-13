const form = document.querySelector("#ask-form");
const status = document.querySelector("#status");

form.addEventListener("submit", (event) => {
  event.preventDefault();
  // 在此接入 fetch 请求、加载和错误状态，以及回答、引用和调用记录渲染。
  status.textContent = "请先完成页面与 POST /ask 的联调。";
});
