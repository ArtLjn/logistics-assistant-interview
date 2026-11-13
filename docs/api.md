# API 契约

`POST /ask` 接收 `application/json`，请求体仅包含一个非空字符串字段 `question`。空字符串、纯空白、字段缺失、类型错误、额外字段或无效 JSON 返回 HTTP 400。业务结果统一返回 HTTP 200。

| 响应字段 | 类型 | 说明 |
| --- | --- | --- |
| `status` | 字符串 | `answered`、`order_not_found` 或 `insufficient_evidence` |
| `answer` | 字符串 | 用户可读的回答 |
| `citations` | 数组 | 引用对象含 `id`、`title`、`excerpt`，无引用时为空数组 |
| `trace` | 数组 | 按实际调用顺序记录步骤，`seq` 从 1 递增 |

每个步骤包含 `seq`、`tool`、`input`、`outcome`、`hit_ids`。`tool` 为 `order_query`、`sop_search` 或 `generate`。用对象记录本步骤输入，例如 `{"order_id":"HD202611002"}`。`outcome` 为 `ok`、`not_found` 或 `no_hit`。`hit_ids` 是该步骤命中或实际使用的条目 ID 数组。订单工具可使用订单号，SOP 工具使用片段 ID。

纯状态查询示例

```json
{
  "status": "answered",
  "answer": "订单 HD202611002 当前状态为待审核。",
  "citations": [],
  "trace": [
    {
      "seq": 1,
      "tool": "order_query",
      "input": {"order_id": "HD202611002"},
      "outcome": "ok",
      "hit_ids": ["HD202611002"]
    }
  ]
}
```
