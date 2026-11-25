import time
import json
import random
import os

BASE = "/mnt/data/dagman_demo"

print("Starting preparation task...")

data = {
    "values": [random.randint(1, 100) for _ in range(50)],
    "timestamp": time.time()
}

time.sleep(10)

with open(os.path.join(BASE, "prep_output.json"), "w") as f:
    json.dump(data, f, indent=2)

print("Preparation complete: prep_output.json created.")
