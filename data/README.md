# 模拟数据

- `sop.json` 包含 47 条模拟 SOP 片段。字段为 `id`、`title`、`text`。按 ID 前缀分为入库（IN）、出库（OUT）、盘点（INV）、退货（RET）、运输（TRA）、订单状态（ST）、仓储（STO）、交接（HDO）八组。
- `orders.json` 只用于按单号精确查询。字段为 `order_id`、`warehouse`、`order_status`。起始标签含 4 条订单，`main` 新增 1 条。
- `synonyms.json` 提供几条查询归一化样例。候选人可按需要扩充，只填写业务用语。

以上资料为面试模拟数据，仅适用于本题。
