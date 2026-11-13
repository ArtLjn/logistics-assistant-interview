from pathlib import Path

from fastapi import FastAPI
from fastapi.responses import FileResponse, JSONResponse
from fastapi.staticfiles import StaticFiles

WEB_DIR = Path(__file__).resolve().parents[2] / "web"
app = FastAPI(title="物流检索与异常排查助手")
app.mount("/web", StaticFiles(directory=WEB_DIR), name="web")


@app.get("/", include_in_schema=False)
def index():
    return FileResponse(WEB_DIR / "index.html")


@app.post("/ask")
async def ask():
    # 在此接入候选人实现的问答流程。
    return JSONResponse({"message": "请实现 POST /ask"}, status_code=501)
