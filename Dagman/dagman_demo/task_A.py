import json
import time
import random
import os

BASE = "/mnt/data/dagman_demo"

print("Task A starting...")

with open(os.path.join(BASE, "prep_output.json")) as f:
    data = json.load(f)

values = data["values"]
result = sum(v*v for v in values)

delay = random.uniform(1, 4)
time.sleep(delay)

output = {
    "task": "A",
    "operation": "sum_of_squares",
    "runtime_delay_seconds": delay,
    "result": result
}

with open(os.path.join(BASE, "output_A.json"), "w") as f:
    json.dump(output, f, indent=2)

print("Task A complete.")
