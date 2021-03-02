package com.tencent.tav.report;

public class AverageTimeReporter {
    private long count = 0;
    private long total = 0;

    public void add(long j2) {
        this.total += j2;
        this.count++;
    }

    public long average() {
        if (this.count == 0) {
            return 0;
        }
        return this.total / this.count;
    }

    public void reset() {
        this.total = 0;
        this.count = 0;
    }
}
