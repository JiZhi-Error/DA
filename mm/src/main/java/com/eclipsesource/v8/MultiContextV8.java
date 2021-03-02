package com.eclipsesource.v8;

import com.eclipsesource.v8.utils.MemoryManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class MultiContextV8 {
    private final V8ContextSessionMgr contextSessionMgr;
    private final V8 v8;

    private MultiContextV8() {
        this(null);
    }

    private MultiContextV8(String str) {
        this(str, null, null);
    }

    private MultiContextV8(String str, String str2, byte[] bArr) {
        AppMethodBeat.i(61599);
        this.v8 = V8.createV8Runtime(str, null, false, str2, bArr);
        this.contextSessionMgr = new V8ContextSessionMgr(getV8());
        AppMethodBeat.o(61599);
    }

    public static MultiContextV8 createMultiContextV8() {
        AppMethodBeat.i(61600);
        MultiContextV8 multiContextV8 = new MultiContextV8();
        AppMethodBeat.o(61600);
        return multiContextV8;
    }

    public static MultiContextV8 createMultiContextV8(String str) {
        AppMethodBeat.i(61601);
        MultiContextV8 multiContextV8 = new MultiContextV8(str);
        AppMethodBeat.o(61601);
        return multiContextV8;
    }

    public static MultiContextV8 createMultiContextV8(String str, byte[] bArr) {
        AppMethodBeat.i(61602);
        MultiContextV8 multiContextV8 = new MultiContextV8(null, str, bArr);
        AppMethodBeat.o(61602);
        return multiContextV8;
    }

    public static MultiContextV8 createMultiContextV8(String str, String str2, byte[] bArr) {
        AppMethodBeat.i(61603);
        MultiContextV8 multiContextV8 = new MultiContextV8(str, str2, bArr);
        AppMethodBeat.o(61603);
        return multiContextV8;
    }

    public final V8Context createContext(int i2) {
        AppMethodBeat.i(61604);
        V8Context context = new V8ContextWrapper(this, this.v8.createV8Context(i2)).context();
        AppMethodBeat.o(61604);
        return context;
    }

    public final void release() {
        AppMethodBeat.i(61605);
        this.v8.release();
        AppMethodBeat.o(61605);
    }

    public final long getIsolatePtr() {
        AppMethodBeat.i(61606);
        long isolatePtr = this.v8.getIsolatePtr();
        AppMethodBeat.o(61606);
        return isolatePtr;
    }

    public final long getUVLoopPtr() {
        AppMethodBeat.i(61607);
        long uVLoopPtr = this.v8.getUVLoopPtr();
        AppMethodBeat.o(61607);
        return uVLoopPtr;
    }

    public final V8Locker getV8Locker() {
        AppMethodBeat.i(61608);
        V8Locker locker = this.v8.getLocker();
        AppMethodBeat.o(61608);
        return locker;
    }

    public final void waitForDebugger(String str) {
        AppMethodBeat.i(61609);
        this.v8.waitForDebugger(str);
        AppMethodBeat.o(61609);
    }

    public final void debuggerMessageLoop() {
        AppMethodBeat.i(61610);
        this.v8.debuggerMessageLoop();
        AppMethodBeat.o(61610);
    }

    public final void memoryPressureNotification(int i2) {
        AppMethodBeat.i(61611);
        this.v8.memoryPressureNotification(i2);
        AppMethodBeat.o(61611);
    }

    public final MemoryManager createMemoryManager() {
        AppMethodBeat.i(61612);
        MemoryManager memoryManager = new MemoryManager(this.v8);
        AppMethodBeat.o(61612);
        return memoryManager;
    }

    /* access modifiers changed from: protected */
    public final void enterContext(V8ContextWrapper v8ContextWrapper) {
        AppMethodBeat.i(61613);
        this.contextSessionMgr.enterContext(v8ContextWrapper);
        AppMethodBeat.o(61613);
    }

    /* access modifiers changed from: protected */
    public final void releaseContext(V8ContextWrapper v8ContextWrapper) {
        AppMethodBeat.i(61614);
        this.contextSessionMgr.releaseContext(v8ContextWrapper);
        AppMethodBeat.o(61614);
    }

    public final V8 getV8() {
        return this.v8;
    }
}
