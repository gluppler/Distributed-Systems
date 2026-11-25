import json
import time
import random
import os

BASE = "/mnt/data/dagman_demo"

print("Task B starting...")

with open(os.path.join(BASE, "prep_output.json")) as f:
    data = json.load(f)

values = data["values"]
evens = [v for v in values if v % 2 == 0]
avg = sum(evens) / len(evens) if evens else 0

delay = random.uniform(1, 4)
time.sleep(delay)

output = {
    "task": "B",
    "operation": "average_of_evens",
    "runtime_delay_seconds": delay,
    "result": avg
}

with open(os.path.join(BASE, "output_B.json"), "w") as f:
    json.dump(output, f, indent=2)

print("Task B complete.")
