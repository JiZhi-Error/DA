package com.tencent.mm.live.core.mini;

import android.content.Intent;
import android.os.PowerManager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.mini.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 &2\u00020\u0001:\u0001&B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J.\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bJ\u0006\u0010\u001d\u001a\u00020\u0011J\u0006\u0010\u001e\u001a\u00020\u0011J\u000e\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u000fJ\u0010\u0010!\u001a\u00020\u00112\b\u0010\"\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020%R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00060\bR\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, hxF = {"Lcom/tencent/mm/live/core/mini/LiveMiniManager;", "", "()V", "intent", "Landroid/content/Intent;", "isReported", "", "mWakeLock", "Landroid/os/PowerManager$WakeLock;", "Landroid/os/PowerManager;", "miniLayout", "Lcom/tencent/mm/live/core/mini/AbsLiveMiniView;", "miniLayoutVideoContainer", "Landroid/widget/FrameLayout;", "resumeActivityName", "", "addRenderView", "", "view", "Landroid/view/View;", "addViewToWindow", "size", "Landroid/graphics/Point;", "liveId", "", "isAnchor", "generateType", "", "opType", "release", "removeViewFromWindow", "setup", "activityName", "setupMiniView", "miniView", "updateState", "state", "Lcom/tencent/mm/live/core/mini/LiveMiniState;", "Companion", "plugin-core_release"})
public final class b {
    public static final a hCR = new a((byte) 0);
    public boolean gqx;
    public final PowerManager.WakeLock hCN;
    public AbsLiveMiniView hCO;
    public FrameLayout hCP = new FrameLayout(MMApplicationContext.getContext());
    public String hCQ = "";
    public Intent intent = new Intent();

    static {
        AppMethodBeat.i(196588);
        AppMethodBeat.o(196588);
    }

    public b() {
        AppMethodBeat.i(196587);
        Object systemService = MMApplicationContext.getContext().getSystemService("power");
        if (systemService == null) {
            t tVar = new t("null cannot be cast to non-null type android.os.PowerManager");
            AppMethodBeat.o(196587);
            throw tVar;
        }
        PowerManager.WakeLock newWakeLock = ((PowerManager) systemService).newWakeLock(536870922, "MicroMsg.LiveCoreMini");
        p.g(newWakeLock, "pm.newWakeLock(PowerMana…er.ON_AFTER_RELEASE, TAG)");
        this.hCN = newWakeLock;
        if (!this.hCN.isHeld()) {
            Log.i("MicroMsg.LiveCoreMini", "alvinluo acquire wakeLock");
            this.hCN.acquire();
        }
        AppMethodBeat.o(196587);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/live/core/mini/LiveMiniManager$Companion;", "", "()V", "ROUTE_TO_MAXIMIZE", "", "TAG", "plugin-core_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void aEj() {
        AppMethodBeat.i(196585);
        c cVar = c.hCU;
        c.aEk();
        a.C0388a aVar = a.hCD;
        a.b bVar = a.b.hCF;
        a.b.aEi().b(this.hCO);
        AppMethodBeat.o(196585);
    }

    public final void co(View view) {
        AppMethodBeat.i(196586);
        p.h(view, "view");
        view.setClipToOutline(true);
        view.setOutlineProvider(new e((float) com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 8)));
        this.hCP.removeAllViews();
        this.hCP.addView(view, new RelativeLayout.LayoutParams(-1, -1));
        AppMethodBeat.o(196586);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.live.core.mini.b$b  reason: collision with other inner class name */
    public static final class C0389b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ b hCS;
        final /* synthetic */ d hCT;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0389b(b bVar, d dVar) {
            super(0);
            this.hCS = bVar;
            this.hCT = dVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(196584);
            AbsLiveMiniView absLiveMiniView = this.hCS.hCO;
            if (absLiveMiniView != null) {
                absLiveMiniView.b(this.hCT);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(196584);
            return xVar;
        }
    }
}
