package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.al.ag;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoPreviewMgr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.z;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 52\u00020\u0001:\u00015B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J(\u0010\"\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&H\u0017J\n\u0010(\u001a\u0004\u0018\u00010)H\u0016J\b\u0010*\u001a\u00020$H\u0016J\n\u0010+\u001a\u0004\u0018\u00010&H\u0016J\u0006\u0010,\u001a\u00020\u0018J\u0010\u0010-\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020&H\u0016J\b\u0010.\u001a\u00020/H\u0016J\u0018\u00100\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\u0001H\u0016J\u0010\u00102\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u00103\u001a\u00020\u001d2\u0006\u00104\u001a\u00020$H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108FX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0014\u001a\u00020\u00108FX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0015\u0010\u0012R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u000e\u001a\u0004\b\u0019\u0010\u001a¨\u00066"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCanvas;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardTmpl;", "context", "Landroid/content/Context;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "canvasView", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardCanvasView;", "getCanvasView", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardCanvasView;", "canvasView$delegate", "Lkotlin/Lazy;", "newTipsLayout", "Landroid/widget/LinearLayout;", "getNewTipsLayout", "()Landroid/widget/LinearLayout;", "newTipsLayout$delegate", "topLayout", "getTopLayout", "topLayout$delegate", "viewParent", "Landroid/view/ViewGroup;", "getViewParent", "()Landroid/view/ViewGroup;", "viewParent$delegate", "clickCard", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "extra", "", "filling", "pos", "", "convertView", "Landroid/view/View;", "parent", "getVideoRelativePos", "", "getVideoStatus", "getVideoView", "getView", "inflate", "isVideoCard", "", "registerCard", "cardTmpl", "resetUnReadIfNeed", "setVideoStatus", "status", "Companion", "plugin-brandservice_release"})
public final class r extends ad {
    private static final kotlin.f puK = kotlin.g.ah(b.puM);
    public static final a puL = new a((byte) 0);
    private final Context context;
    private final com.tencent.mm.plugin.brandservice.ui.timeline.b psQ;
    private final kotlin.f puG = kotlin.g.ah(new g(this));
    private final kotlin.f puH = kotlin.g.ah(new c(this));
    private final kotlin.f puI = kotlin.g.ah(new f(this));
    private final kotlin.f puJ = kotlin.g.ah(new d(this));

    private final BizTLRecCardCanvasView cmR() {
        AppMethodBeat.i(195328);
        BizTLRecCardCanvasView bizTLRecCardCanvasView = (BizTLRecCardCanvasView) this.puH.getValue();
        AppMethodBeat.o(195328);
        return bizTLRecCardCanvasView;
    }

    public final ViewGroup cmQ() {
        AppMethodBeat.i(195327);
        ViewGroup viewGroup = (ViewGroup) this.puG.getValue();
        AppMethodBeat.o(195327);
        return viewGroup;
    }

    public r(Context context2, com.tencent.mm.plugin.brandservice.ui.timeline.b bVar) {
        p.h(context2, "context");
        p.h(bVar, "adapter");
        AppMethodBeat.i(195335);
        this.context = context2;
        this.psQ = bVar;
        AppMethodBeat.o(195335);
    }

    public static final /* synthetic */ ViewGroup b(r rVar) {
        AppMethodBeat.i(195337);
        ViewGroup cmQ = rVar.cmQ();
        AppMethodBeat.o(195337);
        return cmQ;
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.item.ad
    @SuppressLint({"ClickableViewAccessibility"})
    public final void a(z zVar, int i2, View view, View view2) {
        AppMethodBeat.i(195329);
        p.h(zVar, "info");
        p.h(view, "convertView");
        p.h(view2, "parent");
        String str = "__ad_card_" + zVar.gAG();
        Log.i("MicroMsg.BizTLRecCanvas", "filling#" + str + " msgId=" + zVar.field_msgId);
        cmR().setBizTimeLineInfo(zVar);
        BizTLRecCardCanvasView cmR = cmR();
        long j2 = zVar.field_msgId;
        String pathType = zVar.getPathType();
        if (pathType == null) {
            pathType = "ad";
        }
        String acx = zVar.acx();
        p.g(acx, "info.adData");
        cmR.a(j2, str, pathType, acx);
        this.psQ.a(i2, zVar, (LinearLayout) this.puI.getValue(), (LinearLayout) this.puJ.getValue());
        aa ban = ag.ban();
        p.g(ban, "SubCoreBiz.getBizTimeLineInfoStorage()");
        if (!(zVar.gAo() == ban.gAS() || (zVar.field_status == 4 && zVar.field_hasShow == 1))) {
            zVar.field_status = 4;
            zVar.field_hasShow = 1;
            h.RTc.aX(new e(zVar));
        }
        a(zVar, this);
        AppMethodBeat.o(195329);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class e implements Runnable {
        final /* synthetic */ z prL;

        e(z zVar) {
            this.prL = zVar;
        }

        public final void run() {
            AppMethodBeat.i(195324);
            ag.ban().c(this.prL, false);
            AppMethodBeat.o(195324);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCanvas$Companion;", "", "()V", "JS_ENGINE", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardJsEngine;", "getJS_ENGINE", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardJsEngine;", "JS_ENGINE$delegate", "Lkotlin/Lazy;", "TAG", "", "plugin-brandservice_release"})
    public static final class a {
        public static x cmU() {
            AppMethodBeat.i(195321);
            kotlin.f fVar = r.puK;
            a aVar = r.puL;
            x xVar = (x) fVar.getValue();
            AppMethodBeat.o(195321);
            return xVar;
        }

        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(195336);
        AppMethodBeat.o(195336);
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.item.ad
    public final void a(z zVar, ad adVar) {
        AppMethodBeat.i(195330);
        p.h(zVar, "info");
        p.h(adVar, "cardTmpl");
        MPVideoPreviewMgr mPVideoPreviewMgr = MPVideoPreviewMgr.pJz;
        MPVideoPreviewMgr.a(zVar, adVar);
        AppMethodBeat.o(195330);
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.item.ad
    public final boolean cmS() {
        z zVar;
        boolean z = true;
        AppMethodBeat.i(195331);
        BizTLRecCardCanvasView cmR = cmR();
        if (cmR.pvt.aWv(cmR.getCanvasId()) == null && ((zVar = cmR.psm) == null || !zVar.gAH())) {
            z = false;
        }
        Log.i(cmR.TAG, "isVideoCard = " + z + ", " + cmR.getCanvasId());
        AppMethodBeat.o(195331);
        return z;
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.item.ad
    public final View getVideoView() {
        AppMethodBeat.i(195332);
        BizTLRecCardCanvasView cmR = cmR();
        AppMethodBeat.o(195332);
        return cmR;
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.item.ad
    public final void setVideoStatus(int i2) {
        AppMethodBeat.i(195333);
        cmR().setVideoStatus(i2);
        AppMethodBeat.o(195333);
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.item.ad
    public final void a(z zVar, String str) {
        AppMethodBeat.i(195334);
        p.h(zVar, "info");
        p.h(str, "extra");
        MPVideoPreviewMgr mPVideoPreviewMgr = MPVideoPreviewMgr.pJz;
        MPVideoPreviewMgr.a(zVar, "");
        AppMethodBeat.o(195334);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Landroid/view/ViewGroup;", "invoke"})
    static final class g extends q implements kotlin.g.a.a<ViewGroup> {
        final /* synthetic */ r puN;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(r rVar) {
            super(0);
            this.puN = rVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ ViewGroup invoke() {
            AppMethodBeat.i(195326);
            View inflate = View.inflate(this.puN.context, R.layout.k4, null);
            if (inflate == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup");
                AppMethodBeat.o(195326);
                throw tVar;
            }
            ViewGroup viewGroup = (ViewGroup) inflate;
            AppMethodBeat.o(195326);
            return viewGroup;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardCanvasView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class c extends q implements kotlin.g.a.a<BizTLRecCardCanvasView> {
        final /* synthetic */ r puN;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(r rVar) {
            super(0);
            this.puN = rVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ BizTLRecCardCanvasView invoke() {
            AppMethodBeat.i(195322);
            BizTLRecCardCanvasView bizTLRecCardCanvasView = (BizTLRecCardCanvasView) r.b(this.puN).findViewById(R.id.gtt);
            AppMethodBeat.o(195322);
            return bizTLRecCardCanvasView;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Landroid/widget/LinearLayout;", "invoke"})
    static final class f extends q implements kotlin.g.a.a<LinearLayout> {
        final /* synthetic */ r puN;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(r rVar) {
            super(0);
            this.puN = rVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ LinearLayout invoke() {
            AppMethodBeat.i(195325);
            View findViewById = r.b(this.puN).findViewById(R.id.a8c);
            if (findViewById == null) {
                t tVar = new t("null cannot be cast to non-null type android.widget.LinearLayout");
                AppMethodBeat.o(195325);
                throw tVar;
            }
            LinearLayout linearLayout = (LinearLayout) findViewById;
            AppMethodBeat.o(195325);
            return linearLayout;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Landroid/widget/LinearLayout;", "invoke"})
    static final class d extends q implements kotlin.g.a.a<LinearLayout> {
        final /* synthetic */ r puN;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(r rVar) {
            super(0);
            this.puN = rVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ LinearLayout invoke() {
            AppMethodBeat.i(195323);
            View findViewById = r.b(this.puN).findViewById(R.id.a8m);
            if (findViewById == null) {
                t tVar = new t("null cannot be cast to non-null type android.widget.LinearLayout");
                AppMethodBeat.o(195323);
                throw tVar;
            }
            LinearLayout linearLayout = (LinearLayout) findViewById;
            AppMethodBeat.o(195323);
            return linearLayout;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardJsEngine;", "invoke"})
    static final class b extends q implements kotlin.g.a.a<x> {
        public static final b puM = new b();

        static {
            AppMethodBeat.i(195320);
            AppMethodBeat.o(195320);
        }

        b() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(195319);
            x xVar = new x();
            AppMethodBeat.o(195319);
            return xVar;
        }
    }
}
