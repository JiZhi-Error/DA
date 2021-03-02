package com.tencent.wxperf.jni.memory;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.stubs.logger.Log;
import com.tencent.wxperf.jni.HookManager;
import com.tencent.wxperf.jni.a;
import java.util.HashSet;
import java.util.Set;

public class MemoryHook extends a {
    public static final MemoryHook Sys = new MemoryHook();
    public boolean SyA;
    public Set<String> Syt = new HashSet();
    public Set<String> Syu = new HashSet();
    public int Syv;
    public int Syw;
    public int Syx = 10485760;
    public double Syy = 1.0d;
    public boolean Syz;

    private native void addHookSoNative(String[] strArr);

    private native void addIgnoreSoNative(String[] strArr);

    private native void dumpNative(String str, String str2);

    private native void enableMmapHookNative(boolean z);

    private native void enableStacktraceNative(boolean z);

    private native void setSampleSizeRangeNative(int i2, int i3);

    private native void setSamplingNative(double d2);

    private native void setStacktraceLogThresholdNative(int i2);

    static {
        AppMethodBeat.i(199065);
        AppMethodBeat.o(199065);
    }

    private MemoryHook() {
        AppMethodBeat.i(199061);
        AppMethodBeat.o(199061);
    }

    @Override // com.tencent.wxperf.jni.a
    public final void hrX() {
        AppMethodBeat.i(199062);
        if (this.Syv < 0 || (this.Syw != 0 && this.Syw < this.Syv)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("sizes should not be negative and maxSize should be 0 or greater than minSize: min = " + this.Syv + ", max = " + this.Syw);
            AppMethodBeat.o(199062);
            throw illegalArgumentException;
        }
        Log.d("Yves.debug", "enable mmap? " + this.SyA);
        enableMmapHookNative(this.SyA);
        setSampleSizeRangeNative(this.Syv, this.Syw);
        setSamplingNative(this.Syy);
        setStacktraceLogThresholdNative(this.Syx);
        enableStacktraceNative(this.Syz);
        AppMethodBeat.o(199062);
    }

    @Override // com.tencent.wxperf.jni.a
    public final void hrY() {
        AppMethodBeat.i(199063);
        addHookSoNative((String[]) this.Syt.toArray(new String[0]));
        addIgnoreSoNative((String[]) this.Syu.toArray(new String[0]));
        AppMethodBeat.o(199063);
    }

    public final void dump(String str, String str2) {
        AppMethodBeat.i(199064);
        if (HookManager.Syn.Syo) {
            dumpNative(str, str2);
        }
        AppMethodBeat.o(199064);
    }
}
