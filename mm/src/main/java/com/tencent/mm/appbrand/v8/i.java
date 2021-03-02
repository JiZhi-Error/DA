package com.tencent.mm.appbrand.v8;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

/* access modifiers changed from: package-private */
public final class i extends z {
    private static final ThreadLocal<i> dpE = new ThreadLocal<>();
    private final a dpC;
    private boolean dpD = true;

    /* access modifiers changed from: package-private */
    public interface a {
        boolean XB();

        void closeUVLoop();

        void wakeUpUVLoop();
    }

    static {
        AppMethodBeat.i(144034);
        AppMethodBeat.o(144034);
    }

    public static i a(a aVar, boolean z) {
        AppMethodBeat.i(216888);
        if (dpE.get() != null) {
            RuntimeException runtimeException = new RuntimeException("Only one Looper may be created per thread");
            AppMethodBeat.o(216888);
            throw runtimeException;
        }
        i iVar = new i(aVar, z);
        dpE.set(iVar);
        AppMethodBeat.o(216888);
        return iVar;
    }

    private i(a aVar, boolean z) {
        super(z);
        this.dpC = aVar;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.appbrand.v8.z
    public final boolean XC() {
        AppMethodBeat.i(144028);
        if (this.dpD || !super.XC()) {
            AppMethodBeat.o(144028);
            return false;
        }
        AppMethodBeat.o(144028);
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.appbrand.v8.z
    public final void XD() {
        AppMethodBeat.i(144029);
        super.XD();
        this.dpD = this.dpC.XB();
        AppMethodBeat.o(144029);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.appbrand.v8.z
    public final void XE() {
        AppMethodBeat.i(216889);
        super.XE();
        this.dpD = this.dpC.XB();
        AppMethodBeat.o(216889);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.appbrand.v8.z
    public final void XF() {
        AppMethodBeat.i(144030);
        super.XF();
        if (this.dpC != null) {
            this.dpC.closeUVLoop();
        }
        AppMethodBeat.o(144030);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.appbrand.v8.z
    public final void XG() {
        AppMethodBeat.i(144031);
        if (this.dpC != null && !isPaused()) {
            this.dpC.wakeUpUVLoop();
        }
        AppMethodBeat.o(144031);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.appbrand.v8.z
    public final void onResume() {
        AppMethodBeat.i(144032);
        if (this.dpC != null) {
            this.dpC.wakeUpUVLoop();
        }
        AppMethodBeat.o(144032);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.appbrand.v8.z
    public final void XH() {
        AppMethodBeat.i(144033);
        if (this.dpC != null) {
            Log.i("MicroMsg.NodeJSRuntimeLooper", "onQuit wakeUpUVLoop");
            this.dpC.wakeUpUVLoop();
        }
        AppMethodBeat.o(144033);
    }
}
