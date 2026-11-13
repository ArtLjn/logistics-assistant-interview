import unittest

from fastapi.testclient import TestClient

from logistics_exam.app import app


class StarterTest(unittest.TestCase):
    def test_static_page_and_assets_are_available(self):
        with TestClient(app) as client:
            for path in ("/", "/web/app.js", "/web/style.css"):
                with self.subTest(path=path):
                    self.assertEqual(client.get(path).status_code, 200)
