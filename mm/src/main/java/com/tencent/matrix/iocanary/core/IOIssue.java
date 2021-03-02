package com.tencent.matrix.iocanary.core;

public final class IOIssue {
    public final long bufferSize;
    public final long fileSize;
    public final int opCnt;
    public final long opCostTime;
    public final long opSize;
    public final int opType;
    public final String path;
    public final int repeatReadCnt;
    public final String stack;
    public final String threadName;
    public final int type;

    public IOIssue(int i2, String str, long j2, int i3, long j3, long j4, int i4, long j5, String str2, String str3, int i5) {
        this.type = i2;
        this.path = str;
        this.fileSize = j2;
        this.opCnt = i3;
        this.bufferSize = j3;
        this.opCostTime = j4;
        this.opType = i4;
        this.opSize = j5;
        this.threadName = str2;
        this.stack = str3;
        this.repeatReadCnt = i5;
    }
}
