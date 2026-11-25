import json
import os

BASE = "/mnt/data/dagman_demo"

print("Merging results...")

task_files = [
    "output_A.json",
    "output_B.json",
    "output_C.json"
]

merged = {}

for fname in task_files:
    fpath = os.path.join(BASE, fname)
    with open(fpath) as f:
        merged[fname] = json.load(f)

with open(os.path.join(BASE, "final_result.json"), "w") as f:
    json.dump(merged, f, indent=2)

print("Merge complete: final_result.json created.")
