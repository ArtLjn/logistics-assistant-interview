# 物流检索与异常排查助手

四小时 AI 应用工程面试。实现一个本地助手，用自然语言查询订单状态和仓库 SOP，并展示引用与工具调用记录。前 215 分钟开发，最后 25 分钟走查。

## 开始

```bash
git clone https://github.com/ArtLjn/logistics-assistant-interview.git
cd logistics-assistant-interview
git switch -c feature/assistant exam-base
git merge --ff-only origin/exam-conflict
```

从 [Releases](https://github.com/ArtLjn/logistics-assistant-interview/releases/latest) 下载 `offline-deps.tar.gz` 并在仓库根目录执行 `tar -xzf offline-deps.tar.gz`。验收前请准备好 Git、Bash 和所选运行时。Windows 可用 WSL。

| 二选一 | 启动 | 测试 |
| --- | --- | --- |
| Python 3.11 + FastAPI | `bash scripts/run python start` | `bash scripts/run python test` |
| Java 17 + Maven 3.9 + Spring Boot 3.2 | `bash scripts/run java start` | `bash scripts/run java test` |

打开 [本地页面](http://127.0.0.1:8000/)。脚手架提供静态页面和 `/ask` 占位（HTTP 501），初始测试只验证脚手架。默认 `AGENT_LLM=off`。

```bash
curl -sS http://127.0.0.1:8000/ask \
  -H 'Content-Type: application/json' \
  -d '{"question":"HD202611002 现在是什么状态"}'
```

## 发放资料

- [完整题面和 Git 提交流程](docs/assignment.md)
- [API 契约](docs/api.md)
- [模拟数据与字段说明](data/README.md)
- [五条公开验收用例](docs/public-cases.md)
