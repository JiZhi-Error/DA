package com.tencent.mm.live.core.mini;

import android.graphics.Point;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ball.service.FloatBallHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.at;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00162\u00020\u0001:\u0002\u0016\u0017B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u0006J\b\u0010\u0010\u001a\u00020\u0006H\u0002J\b\u0010\u0011\u001a\u00020\u0006H\u0002J\u0010\u0010\u0012\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0013J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/live/core/mini/LiveFloatBallHelper;", "Lcom/tencent/mm/plugin/ball/service/FloatBallHelper;", "()V", "timeWhenRemoveView", "", "addVoipView", "", "state", "", "view", "Landroid/view/View;", "reportDataInfo", "Lcom/tencent/mm/live/core/mini/ReportDataInfo;", "size", "Landroid/graphics/Point;", "clickFloatBall", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "initReportInfo", "removeVoipView", "Landroid/widget/FrameLayout;", "setLiveViewSize", "updateReportInfo", "Companion", "Holder", "plugin-core_release"})
public final class a extends FloatBallHelper {
    public static final C0388a hCD = new C0388a((byte) 0);
    public long hCC;

    static {
        AppMethodBeat.i(196577);
        AppMethodBeat.o(196577);
    }

    private a() {
        AppMethodBeat.i(196576);
        G(21, com.tencent.mm.plugin.ball.f.b.cjf());
        ciw().hDa = 15;
        civ();
        AppMethodBeat.o(196576);
    }

    public /* synthetic */ a(byte b2) {
        this();
    }

    public static final /* synthetic */ void a(a aVar, f fVar) {
        AppMethodBeat.i(196578);
        aVar.a(fVar);
        AppMethodBeat.o(196578);
    }

    public static final /* synthetic */ void b(a aVar) {
        AppMethodBeat.i(196579);
        aVar.aEh();
        AppMethodBeat.o(196579);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/live/core/mini/LiveFloatBallHelper$Holder;", "", "()V", "sHelper", "Lcom/tencent/mm/live/core/mini/LiveFloatBallHelper;", "getSHelper", "()Lcom/tencent/mm/live/core/mini/LiveFloatBallHelper;", "setSHelper", "(Lcom/tencent/mm/live/core/mini/LiveFloatBallHelper;)V", "plugin-core_release"})
    public static final class b {
        private static a hCE = new a((byte) 0);
        public static final b hCF = new b();

        static {
            AppMethodBeat.i(196571);
            AppMethodBeat.o(196571);
        }

        private b() {
        }

        public static a aEi() {
            return hCE;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class c implements Runnable {
        final /* synthetic */ a hCG;
        final /* synthetic */ int hCH = 4;
        final /* synthetic */ View hCI;
        final /* synthetic */ boolean hCJ;
        final /* synthetic */ f hCK;
        final /* synthetic */ Point hCL;

        public c(a aVar, View view, boolean z, f fVar, Point point) {
            this.hCG = aVar;
            this.hCI = view;
            this.hCJ = z;
            this.hCK = fVar;
            this.hCL = point;
        }

        public final void run() {
            AppMethodBeat.i(196572);
            Log.i("MicroMsg.LiveFloatBallHelper", "addVoipView, no ball, state:%s, view:%s", Integer.valueOf(this.hCH), this.hCI);
            this.hCG.oWE.oWr = true;
            this.hCG.oWE.nno = false;
            this.hCG.oWE.state = this.hCH;
            this.hCG.oWE.vk = this.hCI;
            this.hCG.oWE.oWq = true;
            this.hCG.oWE.gqx = this.hCJ;
            a.a(this.hCG, this.hCK);
            a.b(this.hCG);
            this.hCG.cis();
            AppMethodBeat.o(196572);
        }
    }

    public final void a(f fVar) {
        AppMethodBeat.i(196573);
        this.oWE.oWs.hDa = fVar.hDa;
        this.oWE.oWs.dPJ = String.valueOf(fVar.liveId);
        this.oWE.oWs.oWy = fVar.dMz ? "1" : "2";
        this.oWE.oWs.hCZ = fVar.hCZ;
        this.oWE.oWs.opType = fVar.opType;
        Log.v("MicroMsg.LiveFloatBallHelper", "addVoipView updateReportInfo bizScene: %d, bizId: %s, bizSubId: %s, generateType: %s", Integer.valueOf(this.oWE.oWs.hDa), this.oWE.oWs.dPJ, this.oWE.oWs.oWy, Integer.valueOf(this.oWE.oWs.hCZ));
        AppMethodBeat.o(196573);
    }

    public final void b(FrameLayout frameLayout) {
        AppMethodBeat.i(196574);
        if (ciq()) {
            Log.i("MicroMsg.LiveFloatBallHelper", "removeVoipView, has ball, view:%s", frameLayout);
            this.hCC = Util.nowMilliSecond();
            cir();
            AppMethodBeat.o(196574);
            return;
        }
        Log.i("MicroMsg.LiveFloatBallHelper", "removeVoipView, no ball, view:%s", frameLayout);
        AppMethodBeat.o(196574);
    }

    public final void bQc() {
        AppMethodBeat.i(261595);
        Log.d("MicroMsg.LiveFloatBallHelper", "clickFloatBall");
        this.oWE.oWs.opType = 3;
        ((com.tencent.mm.plugin.ball.c.b) g.af(com.tencent.mm.plugin.ball.c.b.class)).m(this.oWE);
        AppMethodBeat.o(261595);
    }

    public final void aEh() {
        AppMethodBeat.i(196575);
        if (this.oWE.oWm == null) {
            this.oWE.oWm = new Point();
        }
        int aH = at.aH(MMApplicationContext.getContext(), R.dimen.ct);
        this.oWE.oWm.x = at.aH(MMApplicationContext.getContext(), R.dimen.a7b) + (aH * 2);
        this.oWE.oWm.y = at.aH(MMApplicationContext.getContext(), R.dimen.a7_) + (aH * 2);
        Log.v("MicroMsg.LiveFloatBallHelper", "setLiveViewSize %s, margin: %d", this.oWE.oWm, Integer.valueOf(aH));
        AppMethodBeat.o(196575);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/live/core/mini/LiveFloatBallHelper$Companion;", "", "()V", "INTERVAL_REMOVE_THEN_ADD", "", "TAG", "", "instance", "Lcom/tencent/mm/live/core/mini/LiveFloatBallHelper;", "getInstance", "()Lcom/tencent/mm/live/core/mini/LiveFloatBallHelper;", "plugin-core_release"})
    /* renamed from: com.tencent.mm.live.core.mini.a$a  reason: collision with other inner class name */
    public static final class C0388a {
        private C0388a() {
        }

        public /* synthetic */ C0388a(byte b2) {
            this();
        }
    }
}
