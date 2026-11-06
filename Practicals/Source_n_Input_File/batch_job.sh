#!/bin/bash
# batch_job.sh - Simple HTCondor Batch Script

echo "=========================================="
echo "Starting Job Process ID: $1"
echo "Running on Host: $(hostname)"
echo "Start Time: $(date)"
echo "=========================================="

# Simulate workload
sleep 5
