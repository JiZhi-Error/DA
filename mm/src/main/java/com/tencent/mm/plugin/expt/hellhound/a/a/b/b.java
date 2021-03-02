package com.tencent.mm.plugin.expt.hellhound.a.a.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\"\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u001a\u0010\u0017\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0018\u001a\u00020\u0015H\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/report/HellSampling;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/report/IHellSamplingStagety;", "callback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/report/IHellSamplingCallback;", "timeout", "", "(Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/report/IHellSamplingCallback;J)V", "getCallback", "()Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/report/IHellSamplingCallback;", "lastestTimestamp", "listViewRef", "Ljava/lang/ref/WeakReference;", "Landroid/widget/AbsListView;", "mUiHandler", "Landroid/os/Handler;", "getTimeout", "()J", "sendOnScroll", "", "listView", "firstVisibleItem", "", "visibleItemCount", "sendOnScrollStateChanged", "scrollState", "Companion", "plugin-expt_release"})
public final class b implements f {
    public static final a sCu = new a((byte) 0);
    final e sBU;
    private long sCr = 0;
    private WeakReference<AbsListView> sCs = null;
    private final Handler sCt = new HandlerC1010b(this, Looper.getMainLooper());
    private final long timeout;

    static {
        AppMethodBeat.i(220801);
        AppMethodBeat.o(220801);
    }

    public b(e eVar, long j2) {
        AppMethodBeat.i(220800);
        this.sBU = eVar;
        this.timeout = j2;
        AppMethodBeat.o(220800);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/report/HellSampling$Companion;", "", "()V", "DEFAULT_TIMEOUT", "", "MSG_TIMEOUT", "", "plugin-expt_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0014, code lost:
        if ((r0 != null ? r0.get() : null) == null) goto L_0x0016;
     */
    @Override // com.tencent.mm.plugin.expt.hellhound.a.a.b.f
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.widget.AbsListView r3, int r4) {
        /*
            r2 = this;
            r1 = 220798(0x35e7e, float:3.09404E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r1)
            java.lang.ref.WeakReference<android.widget.AbsListView> r0 = r2.sCs
            if (r0 == 0) goto L_0x0016
            java.lang.ref.WeakReference<android.widget.AbsListView> r0 = r2.sCs
            if (r0 == 0) goto L_0x0021
            java.lang.Object r0 = r0.get()
            android.widget.AbsListView r0 = (android.widget.AbsListView) r0
        L_0x0014:
            if (r0 != 0) goto L_0x001d
        L_0x0016:
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference
            r0.<init>(r3)
            r2.sCs = r0
        L_0x001d:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r1)
            return
        L_0x0021:
            r0 = 0
            goto L_0x0014
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.expt.hellhound.a.a.b.b.a(android.widget.AbsListView, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0024, code lost:
        if ((r0 != null ? r0.get() : null) == null) goto L_0x0026;
     */
    @Override // com.tencent.mm.plugin.expt.hellhound.a.a.b.f
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.widget.AbsListView r8, int r9, int r10) {
        /*
            r7 = this;
            r6 = 220799(0x35e7f, float:3.09405E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
            long r0 = java.lang.System.currentTimeMillis()
            long r2 = r7.sCr
            long r2 = r0 - r2
            long r4 = r7.timeout
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 <= 0) goto L_0x003e
            r7.sCr = r0
            java.lang.ref.WeakReference<android.widget.AbsListView> r0 = r7.sCs
            if (r0 == 0) goto L_0x0026
            java.lang.ref.WeakReference<android.widget.AbsListView> r0 = r7.sCs
            if (r0 == 0) goto L_0x0042
            java.lang.Object r0 = r0.get()
            android.widget.AbsListView r0 = (android.widget.AbsListView) r0
        L_0x0024:
            if (r0 != 0) goto L_0x002d
        L_0x0026:
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference
            r0.<init>(r8)
            r7.sCs = r0
        L_0x002d:
            android.os.Message r0 = android.os.Message.obtain()
            r1 = 100
            r0.what = r1
            r0.arg1 = r9
            r0.arg2 = r10
            android.os.Handler r1 = r7.sCt
            r1.sendMessage(r0)
        L_0x003e:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
            return
        L_0x0042:
            r0 = 0
            goto L_0x0024
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.expt.hellhound.a.a.b.b.a(android.widget.AbsListView, int, int):void");
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/expt/hellhound/ext/feed/report/HellSampling$mUiHandler$1", "Landroid/os/Handler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-expt_release"})
    /* renamed from: com.tencent.mm.plugin.expt.hellhound.a.a.b.b$b  reason: collision with other inner class name */
    public static final class HandlerC1010b extends Handler {
        final /* synthetic */ b sCv;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        HandlerC1010b(b bVar, Looper looper) {
            super(looper);
            this.sCv = bVar;
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.i(220797);
            p.h(message, "msg");
            super.handleMessage(message);
            switch (message.what) {
                case 100:
                    e eVar = this.sCv.sBU;
                    if (eVar != null) {
                        WeakReference weakReference = this.sCv.sCs;
                        eVar.c(weakReference != null ? (AbsListView) weakReference.get() : null, message.arg1, message.arg2);
                        AppMethodBeat.o(220797);
                        return;
                    }
                    break;
            }
            AppMethodBeat.o(220797);
        }
    }
}
