package com.tencent.recovery.model;

public class RecoveryHandleResult {
    public boolean result;
    public boolean retry;

    public String toString() {
        return "RecoveryHandleResult{result=" + this.result + ", retry=" + this.retry + '}';
    }
}
