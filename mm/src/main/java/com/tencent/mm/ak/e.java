package com.tencent.mm.ak;

import android.os.HandlerThread;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/modelbase/HandlerData;", "", "thread", "Landroid/os/HandlerThread;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "(Landroid/os/HandlerThread;Lcom/tencent/mm/sdk/platformtools/MMHandler;)V", "getHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getThread", "()Landroid/os/HandlerThread;", "component1", "component2", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "toString", "", "plugin-audiologic_release"})
public final class e {
    public final MMHandler handler;
    public final HandlerThread thread;

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0020, code lost:
        if (kotlin.g.b.p.j(r3.handler, r4.handler) != false) goto L_0x0022;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r2 = 187354(0x2dbda, float:2.62539E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            if (r3 == r4) goto L_0x0022
            boolean r0 = r4 instanceof com.tencent.mm.ak.e
            if (r0 == 0) goto L_0x0027
            com.tencent.mm.ak.e r4 = (com.tencent.mm.ak.e) r4
            android.os.HandlerThread r0 = r3.thread
            android.os.HandlerThread r1 = r4.thread
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0027
            com.tencent.mm.sdk.platformtools.MMHandler r0 = r3.handler
            com.tencent.mm.sdk.platformtools.MMHandler r1 = r4.handler
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0027
        L_0x0022:
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
        L_0x0026:
            return r0
        L_0x0027:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x0026
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ak.e.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(187353);
        HandlerThread handlerThread = this.thread;
        int hashCode = (handlerThread != null ? handlerThread.hashCode() : 0) * 31;
        MMHandler mMHandler = this.handler;
        if (mMHandler != null) {
            i2 = mMHandler.hashCode();
        }
        int i3 = hashCode + i2;
        AppMethodBeat.o(187353);
        return i3;
    }

    public final String toString() {
        AppMethodBeat.i(187352);
        String str = "HandlerData(thread=" + this.thread + ", handler=" + this.handler + ")";
        AppMethodBeat.o(187352);
        return str;
    }

    public e(HandlerThread handlerThread, MMHandler mMHandler) {
        p.h(handlerThread, "thread");
        p.h(mMHandler, "handler");
        AppMethodBeat.i(187351);
        this.thread = handlerThread;
        this.handler = mMHandler;
        AppMethodBeat.o(187351);
    }
}
