package com.tencent.wxperf.jni.pthread;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wxperf.jni.a;
import java.util.HashSet;
import java.util.Set;

public class PthreadHook extends a {
    public static final PthreadHook SyB = new PthreadHook();
    public Set<String> SyC = new HashSet();
    public Set<String> Syt = new HashSet();
    public Set<String> Syu = new HashSet();

    private native void addHookSoNative(String[] strArr);

    private native void addHookThreadNameNative(String[] strArr);

    private native void addIgnoreSoNative(String[] strArr);

    public native void dumpNative(String str);

    static {
        AppMethodBeat.i(199069);
        AppMethodBeat.o(199069);
    }

    private PthreadHook() {
        AppMethodBeat.i(199066);
        AppMethodBeat.o(199066);
    }

    @Override // com.tencent.wxperf.jni.a
    public final void hrX() {
        AppMethodBeat.i(199067);
        addHookThreadNameNative((String[]) this.SyC.toArray(new String[0]));
        AppMethodBeat.o(199067);
    }

    @Override // com.tencent.wxperf.jni.a
    public final void hrY() {
        AppMethodBeat.i(199068);
        addHookSoNative((String[]) this.Syt.toArray(new String[0]));
        addIgnoreSoNative((String[]) this.Syu.toArray(new String[0]));
        AppMethodBeat.o(199068);
    }
}
