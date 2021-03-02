package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.live.b.x;
import com.tencent.mm.live.c.b;
import com.tencent.mm.live.core.view.LivePreviewView;
import com.tencent.mm.live.d.e;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 C2\u00020\u0001:\u0001CB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0006\u0010\u0016\u001a\u00020\u0003J\u0018\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u0013J\b\u0010\u001c\u001a\u00020\u0018H\u0016J,\u0010\u001d\u001a\u00020\u00182\"\u0010\u001e\u001a\u001e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020 0\u001fj\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020 `!H\u0002J*\u0010\"\u001a\u00020\u00182\"\u0010\u001e\u001a\u001e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020 0\u001fj\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020 `!J4\u0010#\u001a\u00020\u00182\"\u0010\u001e\u001a\u001e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020 0\u001fj\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020 `!2\u0006\u0010$\u001a\u00020%H\u0016J\u001e\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\u0013J\b\u0010)\u001a\u00020\u0018H\u0016J\u0006\u0010*\u001a\u00020\u0018J\u0006\u0010+\u001a\u00020\u0018J\u0006\u0010,\u001a\u00020\u0018J\b\u0010-\u001a\u00020\u0018H\u0016J\u000e\u0010.\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ@\u0010/\u001a\u00020\u001828\u00100\u001a4\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(4\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(5\u0012\u0004\u0012\u00020\u0018\u0018\u000101J@\u00106\u001a\u00020\u001828\u00100\u001a4\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(7\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(8\u0012\u0004\u0012\u00020\u0018\u0018\u000101J\u000e\u00109\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\b\u0010:\u001a\u00020\u0018H\u0002J\u0006\u0010;\u001a\u00020\u0018J\u001a\u0010<\u001a\u00020\u00182\u0006\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010@H\u0016J\b\u0010A\u001a\u00020\u0018H\u0002J\b\u0010B\u001a\u00020\u0018H\u0016R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006D"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorPreviewPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "liveCore", "Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "getLiveCore", "()Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "pkAvatarGroup", "Landroid/widget/RelativeLayout;", "previewView", "Lcom/tencent/mm/live/core/view/LivePreviewView;", "dp2px", "", "dpVal", "", "getPreviewLayout", "micUserWaitingState", "", "userId", "", "type", "mount", "notifyLinkMicMode", "micUserMap", "Ljava/util/LinkedHashMap;", "Landroid/graphics/Rect;", "Lkotlin/collections/LinkedHashMap;", "notifyNormalMode", "onAudienceMicUserChanged", "isPkAnchor", "", "orientationChanged", "orientation", "streamType", "pause", "refreshCameraView", "refreshPreviewView", "restoreFromHalfMode", "resume", "setPkUserId", "setPreviewMoveListener", "callback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "xOffset", "yOffset", "setPreviewTouchListener", "x", "y", "setSelfUserId", "showMicLayout", "startPreview", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "switchCamera", "unMount", "Companion", "plugin-finder_release"})
public final class r extends d {
    public static final a unV = new a((byte) 0);
    private final Context context;
    public final LivePreviewView hAs;
    private final com.tencent.mm.live.c.b hOp;

    static {
        AppMethodBeat.i(246521);
        AppMethodBeat.o(246521);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public r(ViewGroup viewGroup, com.tencent.mm.live.c.b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(246520);
        this.hOp = bVar;
        this.context = viewGroup.getContext();
        View findViewById = viewGroup.findViewById(R.id.ek7);
        p.g(findViewById, "root.findViewById(R.id.live_preview_view)");
        this.hAs = (LivePreviewView) findViewById;
        viewGroup.setPadding(0, 0, 0, 0);
        AppMethodBeat.o(246520);
    }

    public static final /* synthetic */ com.tencent.mm.live.core.core.trtc.a hTv() {
        AppMethodBeat.i(260574);
        com.tencent.mm.live.core.core.trtc.a liveCore = getLiveCore();
        AppMethodBeat.o(260574);
        return liveCore;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorPreviewPlugin$Companion;", "", "()V", "LIVE_UI", "", "TAG", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    private static com.tencent.mm.live.core.core.trtc.a getLiveCore() {
        AppMethodBeat.i(260571);
        o oVar = o.ujN;
        com.tencent.mm.live.core.core.a.b hTh = o.hTh();
        AppMethodBeat.o(260571);
        return hTh;
    }

    public final void startPreview() {
        AppMethodBeat.i(246516);
        com.tencent.mm.live.core.core.trtc.a liveCore = getLiveCore();
        if (liveCore != null) {
            o oVar = o.ujN;
            liveCore.qs(o.dgk());
        }
        com.tencent.mm.live.core.core.trtc.a liveCore2 = getLiveCore();
        if (liveCore2 != null) {
            LivePreviewView livePreviewView = this.hAs;
            o oVar2 = o.ujN;
            com.tencent.mm.live.core.b.a aGk = o.aGk();
            o oVar3 = o.ujN;
            liveCore2.a(livePreviewView, aGk, o.aGl());
        }
        this.hwr.post(new c(this));
        AppMethodBeat.o(246516);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class c implements Runnable {
        final /* synthetic */ r unW;

        c(r rVar) {
            this.unW = rVar;
        }

        public final void run() {
            AppMethodBeat.i(246515);
            if (r.hTv() instanceof com.tencent.mm.live.core.core.a.b) {
                com.tencent.mm.live.core.core.trtc.a hTv = r.hTv();
                if (hTv == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.live.core.core.anchor.LiveAnchorTRTCCore");
                    AppMethodBeat.o(246515);
                    throw tVar;
                }
                o oVar = o.ujN;
                ((com.tencent.mm.live.core.core.a.b) hTv).ew(o.dgl());
            }
            AppMethodBeat.o(246515);
        }
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d, com.tencent.mm.live.c.a
    public final void mount() {
    }

    @Override // com.tencent.mm.live.c.a
    public final void resume() {
    }

    @Override // com.tencent.mm.live.c.a
    public final void pause() {
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d, com.tencent.mm.live.c.a
    public final void unMount() {
        AppMethodBeat.i(246517);
        super.unMount();
        Log.i("MicroMsg.LiveCoreAnchor", "unMount");
        AppMethodBeat.o(246517);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        int i2 = 0;
        AppMethodBeat.i(246518);
        p.h(cVar, "status");
        super.statusChange(cVar, bundle);
        switch (s.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
            case 2:
            case 3:
                rg(0);
                AppMethodBeat.o(246518);
                return;
            case 4:
                Log.i("MicroMsg.LiveCoreAnchor", "switchCamera");
                com.tencent.mm.live.core.core.trtc.a liveCore = getLiveCore();
                if (liveCore != null) {
                    liveCore.switchCamera();
                }
                com.tencent.mm.live.core.core.trtc.a liveCore2 = getLiveCore();
                if (liveCore2 == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.live.core.core.anchor.LiveAnchorTRTCCore");
                    AppMethodBeat.o(246518);
                    throw tVar;
                }
                o oVar = o.ujN;
                ((com.tencent.mm.live.core.core.a.b) liveCore2).ew(o.dgl());
                x xVar = x.hJf;
                String aGm = x.aGm();
                x xVar2 = x.hJf;
                long j2 = x.aGr().hyH;
                x xVar3 = x.hJf;
                String aGt = x.aGt();
                com.tencent.mm.live.core.core.trtc.a.a aDC = com.tencent.mm.live.core.core.trtc.a.a.aDC();
                p.g(aDC, "ConfigHelper.getInstance()");
                if (aDC.aDG().hBp == 0) {
                    i2 = 1;
                }
                String aTY = z.aTY();
                p.g(aTY, "ConfigStorageLogic.getUsernameFromUserInfo()");
                x xVar4 = x.hJf;
                e.a(aGm, j2, aGt, 1, i2, aTY, x.aGr().LIa);
                com.tencent.mm.live.d.a.aIa();
                AppMethodBeat.o(246518);
                return;
            case 5:
                com.tencent.mm.live.core.core.trtc.a liveCore3 = getLiveCore();
                if (liveCore3 != null) {
                    liveCore3.aBS();
                    AppMethodBeat.o(246518);
                    return;
                }
                break;
        }
        AppMethodBeat.o(246518);
    }

    public final void bxG(String str) {
        AppMethodBeat.i(260572);
        d.h(new b(this, str));
        AppMethodBeat.o(260572);
    }

    @Override // com.tencent.mm.live.c.a
    public final void a(LinkedHashMap<String, Rect> linkedHashMap, boolean z) {
        AppMethodBeat.i(260573);
        p.h(linkedHashMap, "micUserMap");
        if (linkedHashMap.size() > 1) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(linkedHashMap.keySet());
            if (this.hwr.getLayoutParams() == null) {
                t tVar = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                AppMethodBeat.o(260573);
                throw tVar;
            }
            b.C0376b.a(this.hOp, b.c.hNQ);
            this.hAs.hF(arrayList);
            Log.i("MicroMsg.LiveCoreAnchor", "notifyLinkMicMode userIdList:".concat(String.valueOf(arrayList)));
            AppMethodBeat.o(260573);
            return;
        }
        p.h(linkedHashMap, "micUserMap");
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(linkedHashMap.keySet());
        ViewGroup.LayoutParams layoutParams = this.hwr.getLayoutParams();
        if (layoutParams == null) {
            t tVar2 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            AppMethodBeat.o(260573);
            throw tVar2;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        layoutParams2.topMargin = 0;
        layoutParams2.bottomMargin = 0;
        this.hAs.hF(arrayList2);
        b.C0376b.a(this.hOp, b.c.hNR);
        Log.i("MicroMsg.LiveCoreAnchor", "notifyNormalMode userIdList:".concat(String.valueOf(arrayList2)));
        AppMethodBeat.o(260573);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class b extends q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ int $type = 0;
        final /* synthetic */ String hEV;
        final /* synthetic */ r unW;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(r rVar, String str) {
            super(0);
            this.unW = rVar;
            this.hEV = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(260570);
            this.unW.hAs.X(this.hEV, this.$type);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(260570);
            return xVar;
        }
    }
}
