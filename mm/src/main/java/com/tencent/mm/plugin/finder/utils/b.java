package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import com.tencent.f.h;
import com.tencent.f.i.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0016R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/finder/utils/DelayLoadingComponent;", "", "()V", "context", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "getContext", "()Ljava/lang/ref/WeakReference;", "setContext", "(Ljava/lang/ref/WeakReference;)V", "delay", "", "getDelay", "()J", "setDelay", "(J)V", "dialogRunnable", "Lcom/tencent/threadpool/runnable/FutureEx;", "getDialogRunnable", "()Lcom/tencent/threadpool/runnable/FutureEx;", "setDialogRunnable", "(Lcom/tencent/threadpool/runnable/FutureEx;)V", "loadingWidget", "Lcom/tencent/mm/plugin/finder/utils/LoadingWidget;", "getLoadingWidget", "()Lcom/tencent/mm/plugin/finder/utils/LoadingWidget;", "setLoadingWidget", "(Lcom/tencent/mm/plugin/finder/utils/LoadingWidget;)V", "begin", "", "end", "Companion", "plugin-finder_release"})
public class b {
    public static final a vVa = new a((byte) 0);
    d<?> dialogRunnable;
    public long gY = 500;
    WeakReference<Context> lAM;
    public ai vUZ;

    static {
        AppMethodBeat.i(253353);
        AppMethodBeat.o(253353);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\t\u001a\u00020\n¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/finder/utils/DelayLoadingComponent$Companion;", "", "()V", "createLoadingDialog", "Lcom/tencent/mm/plugin/finder/utils/DelayLoadingComponent;", "context", "Landroid/content/Context;", "wording", "", "delay", "", "onCancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "createLoadingProgressBar", "progressBar", "Landroid/widget/ProgressBar;", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static b e(Context context, String str, long j2) {
            AppMethodBeat.i(253348);
            p.h(context, "context");
            b bVar = new b();
            bVar.gY = j2;
            bVar.lAM = new WeakReference<>(context);
            ag agVar = new ag();
            if (str != null) {
                agVar.awz(str);
            }
            agVar.kke = null;
            agVar.lAM = new WeakReference<>(context);
            bVar.vUZ = agVar;
            AppMethodBeat.o(253348);
            return bVar;
        }
    }

    public synchronized void begin() {
        AppMethodBeat.i(253351);
        d<?> dVar = this.dialogRunnable;
        if (dVar != null) {
            dVar.cancel(false);
        }
        this.dialogRunnable = h.RTc.n(new RunnableC1313b(this), this.gY);
        AppMethodBeat.o(253351);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.finder.utils.b$b  reason: collision with other inner class name */
    public static final class RunnableC1313b implements Runnable {
        final /* synthetic */ b vVb;

        RunnableC1313b(b bVar) {
            this.vVb = bVar;
        }

        public final void run() {
            AppMethodBeat.i(253349);
            ai aiVar = this.vVb.vUZ;
            if (aiVar != null) {
                aiVar.dismiss();
            }
            ai aiVar2 = this.vVb.vUZ;
            if (aiVar2 != null) {
                aiVar2.show();
                AppMethodBeat.o(253349);
                return;
            }
            AppMethodBeat.o(253349);
        }
    }

    public synchronized void end() {
        AppMethodBeat.i(253352);
        d<?> dVar = this.dialogRunnable;
        if (dVar != null) {
            dVar.cancel(false);
        }
        com.tencent.mm.ac.d.h(new c(this));
        AppMethodBeat.o(253352);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ b vVb;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(b bVar) {
            super(0);
            this.vVb = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(253350);
            ai aiVar = this.vVb.vUZ;
            if (aiVar != null) {
                aiVar.dismiss();
            }
            x xVar = x.SXb;
            AppMethodBeat.o(253350);
            return xVar;
        }
    }
}
