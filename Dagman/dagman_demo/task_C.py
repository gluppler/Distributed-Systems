import json
import time
import random
import os

BASE = "/mnt/data/dagman_demo"

print("Task C starting...")

with open(os.path.join(BASE, "prep_output.json")) as f:
    data = json.load(f)

values = data["values"]
diff = max(values) - min(values)

delay = random.uniform(1, 4)
time.sleep(delay)

output = {
    "task": "C",
    "operation": "range_max_minus_min",
    "runtime_delay_seconds": delay,
    "result": diff
}

with open(os.path.join(BASE, "output_C.json"), "w") as f:
    json.dump(output, f, indent=2)

print("Task C complete.")
