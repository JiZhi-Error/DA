package com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine;

public class Timeval {
    public final long tvSec;
    public final int tvUsec;

    public Timeval(long j2, int i2) {
        this.tvSec = j2;
        this.tvUsec = i2;
    }
}
