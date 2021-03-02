package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import com.tencent.f.h;
import com.tencent.f.i.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0006\u0010\u0007\u001a\u00020\u0006J\b\u0010\b\u001a\u00020\u0006H\u0016J\u0006\u0010\t\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/finder/utils/MultiDelayLoadingComponent;", "Lcom/tencent/mm/plugin/finder/utils/DelayLoadingComponent;", "()V", "loadingCount", "", "begin", "", "cancel", "end", "reset", "Companion", "plugin-finder_release"})
public final class ak extends b {
    public static final a wan = new a((byte) 0);
    public int wam;

    static {
        AppMethodBeat.i(253803);
        AppMethodBeat.o(253803);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rJ\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/finder/utils/MultiDelayLoadingComponent$Companion;", "", "()V", "TAG", "", "createLoadingDialog", "Lcom/tencent/mm/plugin/finder/utils/MultiDelayLoadingComponent;", "context", "Landroid/content/Context;", "wording", "delay", "", "onCancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "createLoadingProgressBar", "progressBar", "Landroid/widget/ProgressBar;", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static ak dm(Context context, String str) {
            AppMethodBeat.i(261493);
            p.h(context, "context");
            ak akVar = new ak();
            akVar.gY = 1000;
            akVar.lAM = new WeakReference<>(context);
            ag agVar = new ag();
            if (str != null) {
                agVar.awz(str);
            }
            agVar.kke = null;
            agVar.lAM = new WeakReference<>(context);
            akVar.vUZ = agVar;
            AppMethodBeat.o(261493);
            return akVar;
        }
    }

    @Override // com.tencent.mm.plugin.finder.utils.b
    public final synchronized void begin() {
        AppMethodBeat.i(253801);
        this.wam++;
        Log.i("MultiDelayLoadingComponent", "begin() loadingCount:" + this.wam);
        if (this.wam > 1) {
            AppMethodBeat.o(253801);
        } else {
            d<?> dVar = this.dialogRunnable;
            if (dVar != null) {
                dVar.cancel(false);
            }
            this.dialogRunnable = h.RTc.n(new b(this), this.gY);
            AppMethodBeat.o(253801);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class b implements Runnable {
        final /* synthetic */ ak wao;

        b(ak akVar) {
            this.wao = akVar;
        }

        public final void run() {
            AppMethodBeat.i(253799);
            Log.i("MultiDelayLoadingComponent", "begin() show loadingCount:" + this.wao.wam);
            ai aiVar = this.wao.vUZ;
            if (aiVar != null) {
                aiVar.dismiss();
            }
            ai aiVar2 = this.wao.vUZ;
            if (aiVar2 != null) {
                aiVar2.show();
                AppMethodBeat.o(253799);
                return;
            }
            AppMethodBeat.o(253799);
        }
    }

    @Override // com.tencent.mm.plugin.finder.utils.b
    public final synchronized void end() {
        AppMethodBeat.i(253802);
        this.wam--;
        Log.i("MultiDelayLoadingComponent", "end() loadingCount:" + this.wam);
        if (this.wam > 0) {
            AppMethodBeat.o(253802);
        } else {
            d<?> dVar = this.dialogRunnable;
            if (dVar != null) {
                dVar.cancel(false);
            }
            com.tencent.mm.ac.d.h(new c(this));
            AppMethodBeat.o(253802);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ ak wao;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(ak akVar) {
            super(0);
            this.wao = akVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(253800);
            Log.i("MultiDelayLoadingComponent", "end() dismiss loadingCount:" + this.wao.wam);
            ai aiVar = this.wao.vUZ;
            if (aiVar != null) {
                aiVar.dismiss();
            }
            x xVar = x.SXb;
            AppMethodBeat.o(253800);
            return xVar;
        }
    }
}
