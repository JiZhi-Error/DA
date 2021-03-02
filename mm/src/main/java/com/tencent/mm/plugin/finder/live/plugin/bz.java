package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.live.c.b;
import com.tencent.mm.live.core.core.b.f;
import com.tencent.mm.live.core.core.b.g;
import com.tencent.mm.live.core.core.d.b;
import com.tencent.mm.live.core.view.LivePreviewView;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 S2\u00020\u0001:\u0001SB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u0017J\u0010\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020!H\u0002J1\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020$2!\u0010%\u001a\u001d\u0012\u0013\u0012\u00110'¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\u001b0&J\b\u0010+\u001a\u00020\u001bH\u0002J\b\u0010,\u001a\u00020\u001bH\u0002J\u0006\u0010-\u001a\u00020\u001bJ\u0006\u0010.\u001a\u00020/J\u0006\u00100\u001a\u00020/J\u0018\u00101\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u00102\u001a\u00020\u0017J,\u00103\u001a\u00020\u001b2\"\u00104\u001a\u001e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020605j\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u000206`7H\u0002J,\u00108\u001a\u00020\u001b2\"\u00104\u001a\u001e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020605j\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u000206`7H\u0002J4\u00109\u001a\u00020\u001b2\"\u00104\u001a\u001e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u0002060:j\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u000206`;2\u0006\u0010<\u001a\u00020'H\u0016J\b\u0010=\u001a\u00020'H\u0016J\u001e\u0010>\u001a\u00020\u001b2\u0006\u0010?\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0017J\b\u0010@\u001a\u00020\u001bH\u0016J\u0006\u0010A\u001a\u00020\u001bJ\u0006\u0010B\u001a\u00020\u001bJ\u0006\u0010C\u001a\u00020\u001bJ\b\u0010D\u001a\u00020\u001bH\u0016J\u0010\u0010E\u001a\u00020\u001b2\u0006\u0010F\u001a\u00020\u0017H\u0016J\b\u0010G\u001a\u00020\u001bH\u0002J\b\u0010H\u001a\u00020\u001bH\u0002J\u0006\u0010I\u001a\u00020\u001bJ\u001a\u0010J\u001a\u00020\u001b2\u0006\u0010K\u001a\u00020L2\b\u0010M\u001a\u0004\u0018\u00010NH\u0016J\u0006\u0010O\u001a\u00020\u001bJ\u000e\u0010P\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010Q\u001a\u00020\u001bJ\u0006\u0010R\u001a\u00020\u001bR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\f\u001a\u0004\u0018\u00010\r8BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006T"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorPreviewPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "VideoLinkBottomBar", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "liveCore", "Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore;", "getLiveCore", "()Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore;", "mCameraRenderHolder", "Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "getMCameraRenderHolder", "()Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "setMCameraRenderHolder", "(Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;)V", "mCurrentDegree", "", "previewView", "Lcom/tencent/mm/live/core/view/LivePreviewView;", "bringToFront", "", "userId", "", "streamType", "dp2px", "dpVal", "", "enterRoom", "liveRoomModel", "Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", NativeProtocol.WEB_DIALOG_ACTION, "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "enterRoomFail", "enterRoomSuccess", "exitRoom", "getPreview", "Landroid/view/View;", "getPreviewLayout", "micUserWaitingState", "type", "notifyLinkMicMode", "micUserMap", "Ljava/util/HashMap;", "Landroid/graphics/Rect;", "Lkotlin/collections/HashMap;", "notifyNormalMode", "onAudienceMicUserChanged", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "isPkAnchor", "onBackPress", "orientationChanged", "orientation", "pause", "refreshCameraView", "refreshPreviewView", "requestStopMic", "resume", "setVisible", "visible", "setupSwitchCameraBtn", "showMicLayout", "startPreview", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "switchCamera", "updateCore", "updateOutputSurface", "updatePreview", "Companion", "plugin-finder_release"})
public final class bz extends d {
    public static final a uvS = new a((byte) 0);
    private Context context;
    public final LivePreviewView hAs;
    private final com.tencent.mm.live.c.b hOp;
    private com.tencent.mm.live.core.b.l hTC;
    private int hTD = getCurrentOrientation();

    static {
        AppMethodBeat.i(247222);
        AppMethodBeat.o(247222);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public bz(ViewGroup viewGroup, com.tencent.mm.live.c.b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(247221);
        this.hOp = bVar;
        this.context = viewGroup.getContext();
        View findViewById = viewGroup.findViewById(R.id.ek7);
        p.g(findViewById, "root.findViewById(R.id.live_preview_view)");
        this.hAs = (LivePreviewView) findViewById;
        AppMethodBeat.o(247221);
    }

    public static final /* synthetic */ void dib() {
    }

    public static final /* synthetic */ void dic() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorPreviewPlugin$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static com.tencent.mm.live.core.core.d.b hTF() {
        AppMethodBeat.i(260741);
        o oVar = o.ujN;
        com.tencent.mm.live.core.core.d.b hTg = o.hTg();
        AppMethodBeat.o(260741);
        return hTg;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorPreviewPlugin$exitRoom$1", "Lcom/tencent/mm/live/core/core/LiveCallback;", "callback", "", OpenSDKTool4Assistant.EXTRA_ERROR_CODE, "", "param", "Landroid/os/Bundle;", "plugin-finder_release"})
    public static final class c implements com.tencent.mm.live.core.core.c {
        c() {
        }

        @Override // com.tencent.mm.live.core.core.c
        public final void callback(int i2, Bundle bundle) {
            AppMethodBeat.i(247210);
            Log.i("Finder.FinderLiveVisitorPreviewPlugin", "on exit room finish");
            AppMethodBeat.o(247210);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorPreviewPlugin$enterRoom$1", "Lcom/tencent/mm/live/core/core/LiveCallback;", "callback", "", OpenSDKTool4Assistant.EXTRA_ERROR_CODE, "", "param", "Landroid/os/Bundle;", "plugin-finder_release"})
    public static final class b implements com.tencent.mm.live.core.core.c {
        final /* synthetic */ kotlin.g.a.b hSE;
        final /* synthetic */ bz uvT;

        b(bz bzVar, kotlin.g.a.b bVar) {
            this.uvT = bzVar;
            this.hSE = bVar;
        }

        @Override // com.tencent.mm.live.core.core.c
        public final void callback(int i2, Bundle bundle) {
            AppMethodBeat.i(247209);
            if (i2 >= 0) {
                bz.dib();
                this.hSE.invoke(Boolean.TRUE);
                AppMethodBeat.o(247209);
                return;
            }
            bz.dic();
            this.hSE.invoke(Boolean.FALSE);
            AppMethodBeat.o(247209);
        }
    }

    public final void atO(String str) {
        AppMethodBeat.i(247218);
        com.tencent.mm.live.core.view.b GG = this.hAs.hER.GG(str);
        if (GG != null) {
            GG.bringToFront();
            AppMethodBeat.o(247218);
            return;
        }
        AppMethodBeat.o(247218);
    }

    public final void bxG(String str) {
        AppMethodBeat.i(260742);
        com.tencent.mm.ac.d.h(new d(this, str));
        AppMethodBeat.o(260742);
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d, com.tencent.mm.live.c.a
    public final void rg(int i2) {
        AppMethodBeat.i(247219);
        super.rg(i2);
        Log.printInfoStack("Finder.FinderLiveVisitorPreviewPlugin", "setVisible ".concat(String.valueOf(i2)), new Object[0]);
        AppMethodBeat.o(247219);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        boolean z;
        AppMethodBeat.i(247220);
        p.h(cVar, "status");
        super.statusChange(cVar, bundle);
        switch (ca.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
            case 2:
            case 3:
                exitRoom();
                rg(8);
                AppMethodBeat.o(247220);
                return;
            case 4:
                if (bundle != null) {
                    bundle.getBoolean("PARAM_HANGUP_SELF", false);
                }
                b.a aVar = com.tencent.mm.live.core.core.d.b.hCo;
                this.hwr.getContext();
                b.a.aEf().aEd();
                dhZ();
                this.hAs.hER.aEY();
                AppMethodBeat.o(247220);
                return;
            case 5:
                com.tencent.mm.live.core.b.l lVar = this.hTC;
                if (lVar != null) {
                    o oVar = o.ujN;
                    com.tencent.mm.live.core.core.d.b hTg = o.hTg();
                    if (hTg != null) {
                        hTg.a(lVar);
                        AppMethodBeat.o(247220);
                        return;
                    }
                    AppMethodBeat.o(247220);
                    return;
                }
                AppMethodBeat.o(247220);
                return;
            case 6:
                rg(0);
                ViewParent parent = this.hAs.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(this.hAs);
                    ((ViewGroup) parent).addView(this.hAs);
                }
                LivePreviewView livePreviewView = this.hAs;
                Context context2 = this.hwr.getContext();
                p.g(context2, "root.context");
                Resources resources = context2.getResources();
                p.g(resources, "root.context.resources");
                livePreviewView.qO(resources.getConfiguration().orientation);
                com.tencent.mm.live.core.core.trtc.a.a aDC = com.tencent.mm.live.core.core.trtc.a.a.aDC();
                p.g(aDC, "ConfigHelper.getInstance()");
                com.tencent.mm.live.core.core.trtc.a.a.d aDD = aDC.aDD();
                p.g(aDD, "ConfigHelper.getInstance().videoConfig");
                Context context3 = this.context;
                p.g(context3, "context");
                Resources resources2 = context3.getResources();
                p.g(resources2, "context.resources");
                if (resources2.getConfiguration().orientation == 1) {
                    z = true;
                } else {
                    z = false;
                }
                aDD.eA(z);
                b.a aVar2 = com.tencent.mm.live.core.core.d.b.hCo;
                this.hwr.getContext();
                b.a.aEf().b(this.hAs);
                AppMethodBeat.o(247220);
                return;
            case 7:
                this.hAs.hER.aEY();
                b.a aVar3 = com.tencent.mm.live.core.core.d.b.hCo;
                this.hwr.getContext();
                b.a.aEf().aEd();
                AppMethodBeat.o(247220);
                return;
            case 8:
                Log.i("Finder.FinderLiveVisitorPreviewPlugin", "switchCamera");
                o oVar2 = o.ujN;
                com.tencent.mm.live.core.core.d.b hTg2 = o.hTg();
                if (hTg2 != null) {
                    hTg2.switchCamera();
                    AppMethodBeat.o(247220);
                    return;
                }
                break;
        }
        AppMethodBeat.o(247220);
    }

    @Override // com.tencent.mm.live.c.a
    public final void resume() {
    }

    @Override // com.tencent.mm.live.c.a
    public final void pause() {
    }

    @Override // com.tencent.mm.live.c.a
    public final boolean onBackPress() {
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x005e, code lost:
        if (r3 != null) goto L_0x0060;
     */
    @Override // com.tencent.mm.live.c.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.util.LinkedHashMap<java.lang.String, android.graphics.Rect> r8, boolean r9) {
        /*
        // Method dump skipped, instructions count: 333
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.live.plugin.bz.a(java.util.LinkedHashMap, boolean):void");
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ int $type = 0;
        final /* synthetic */ String hEV;
        final /* synthetic */ bz uvT;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(bz bzVar, String str) {
            super(0);
            this.uvT = bzVar;
            this.hEV = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(260740);
            this.uvT.hAs.X(this.hEV, this.$type);
            x xVar = x.SXb;
            AppMethodBeat.o(260740);
            return xVar;
        }
    }

    public static void exitRoom() {
        AppMethodBeat.i(247212);
        o oVar = o.ujN;
        com.tencent.mm.live.core.core.d.b hTg = o.hTg();
        if (hTg != null) {
            hTg.b(new c());
            AppMethodBeat.o(247212);
            return;
        }
        AppMethodBeat.o(247212);
    }

    public static void dhZ() {
        AppMethodBeat.i(247213);
        o oVar = o.ujN;
        com.tencent.mm.live.core.core.d.b hTg = o.hTg();
        Log.i("Finder.FinderLiveVisitorPreviewPlugin", "requestLinkMic ret:".concat(String.valueOf(hTg != null ? Integer.valueOf(hTg.aDZ()) : null)));
        AppMethodBeat.o(247213);
    }

    public final void a(f fVar, kotlin.g.a.b<? super Boolean, x> bVar) {
        AppMethodBeat.i(247214);
        p.h(fVar, "liveRoomModel");
        p.h(bVar, NativeProtocol.WEB_DIALOG_ACTION);
        o oVar = o.ujN;
        com.tencent.mm.live.core.core.d.b hTg = o.hTg();
        if (hTg != null) {
            hTg.a(fVar);
        }
        o oVar2 = o.ujN;
        com.tencent.mm.live.core.core.d.b hTg2 = o.hTg();
        if (hTg2 != null) {
            hTg2.a(this.hAs, new b(this, bVar));
            AppMethodBeat.o(247214);
            return;
        }
        AppMethodBeat.o(247214);
    }

    public final void startPreview() {
        AppMethodBeat.i(247215);
        o oVar = o.ujN;
        com.tencent.mm.live.core.core.d.b hTg = o.hTg();
        if (hTg != null) {
            o oVar2 = o.ujN;
            hTg.qs(o.dgk());
        }
        o oVar3 = o.ujN;
        com.tencent.mm.live.core.core.d.b hTg2 = o.hTg();
        if (hTg2 != null) {
            LivePreviewView livePreviewView = this.hAs;
            o oVar4 = o.ujN;
            com.tencent.mm.live.core.b.a aGk = o.aGk();
            o oVar5 = o.ujN;
            hTg2.a(livePreviewView, aGk, o.aGl());
            AppMethodBeat.o(247215);
            return;
        }
        AppMethodBeat.o(247215);
    }

    public final void dia() {
        String str;
        g gVar;
        AppMethodBeat.i(247217);
        o oVar = o.ujN;
        com.tencent.mm.live.core.core.d.b hTg = o.hTg();
        if (hTg != null) {
            hTg.a(this.hAs);
        }
        o oVar2 = o.ujN;
        com.tencent.mm.live.core.core.d.b hTg2 = o.hTg();
        if (hTg2 != null) {
            o oVar3 = o.ujN;
            com.tencent.mm.live.core.core.d.b hTg3 = o.hTg();
            if (hTg3 == null || (gVar = hTg3.hAz) == null) {
                str = null;
            } else {
                str = gVar.hzG;
            }
            hTg2.Gp(str);
            AppMethodBeat.o(247217);
            return;
        }
        AppMethodBeat.o(247217);
    }
}
