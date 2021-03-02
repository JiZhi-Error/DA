package com.tencent.mm.live.c;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.live.b.x;
import com.tencent.mm.live.c.b;
import com.tencent.mm.live.core.core.a.b;
import com.tencent.mm.live.core.core.d.b;
import com.tencent.mm.live.core.view.LivePreviewView;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.mmsight.model.d;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.at;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 E2\u00020\u00012\u00020\u0002:\u0001EB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J1\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2!\u0010 \u001a\u001d\u0012\u0013\u0012\u00110\"¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u001d0!J\b\u0010&\u001a\u00020\u001dH\u0002J\b\u0010'\u001a\u00020\u001dH\u0002J\u0006\u0010(\u001a\u00020\u001dJ\u0006\u0010)\u001a\u00020\u001dJ\b\u0010*\u001a\u00020\"H\u0016J\u0010\u0010+\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020\u0014H\u0016J\u001e\u0010-\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020\u00142\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u0014J\b\u00102\u001a\u00020\u001dH\u0016J\u0006\u00103\u001a\u00020\u001dJ\u0006\u00104\u001a\u00020\u001dJ\b\u00105\u001a\u00020\u001dH\u0016J@\u00106\u001a\u00020\u001d28\u00107\u001a4\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(9\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(:\u0012\u0004\u0012\u00020\u001d\u0018\u000108J\b\u0010;\u001a\u00020\u001dH\u0002J\b\u0010<\u001a\u00020\u001dH\u0002J\u0006\u0010=\u001a\u00020\u001dJ\u001a\u0010>\u001a\u00020\u001d2\u0006\u0010?\u001a\u00020@2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\u0006\u0010C\u001a\u00020\u001dJ\b\u0010D\u001a\u00020\u001dH\u0016R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006F"}, hxF = {"Lcom/tencent/mm/live/plugin/LiveVisitorPreviewPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lcom/tencent/mm/plugin/mmsight/model/DeviceOrientationListener$OrienChangeCallback;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "liveCore", "Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore;", "mCameraRenderHolder", "Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "getMCameraRenderHolder", "()Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "setMCameraRenderHolder", "(Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;)V", "mCurrentDegree", "", "orientationEventListener", "Lcom/tencent/mm/plugin/mmsight/model/DeviceOrientationListener;", "previewView", "Lcom/tencent/mm/live/core/view/LivePreviewView;", "dp2px", "dpVal", "", "enterRoom", "", "liveRoomModel", "Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", NativeProtocol.WEB_DIALOG_ACTION, "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "enterRoomFail", "enterRoomSuccess", "exitRoom", "hideMicLayout", "onBackPress", "onOrientationChange", "degree", "orientationChanged", "orientation", "userId", "", "streamType", "pause", "refreshPreviewView", "requestStopMic", "resume", "setPreviewTouchListener", "callback", "Lkotlin/Function2;", "x", "y", "setupSwitchCameraBtn", "showMicLayout", "startPreview", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "switchCamera", "unMount", "Companion", "plugin-logic_release"})
public final class bk extends a implements d.a {
    public static final a hTE = new a((byte) 0);
    private Context context;
    public final LivePreviewView hAs;
    private final b hOp;
    public com.tencent.mm.live.core.b.l hTC;
    private int hTD = getCurrentOrientation();
    public com.tencent.mm.live.core.core.d.b liveCore;
    private com.tencent.mm.plugin.mmsight.model.d orientationEventListener;

    static {
        AppMethodBeat.i(208284);
        AppMethodBeat.o(208284);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public bk(ViewGroup viewGroup, b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(208283);
        this.hOp = bVar;
        this.context = viewGroup.getContext();
        View findViewById = viewGroup.findViewById(R.id.ek7);
        p.g(findViewById, "root.findViewById(R.id.live_preview_view)");
        this.hAs = (LivePreviewView) findViewById;
        b.a aVar = com.tencent.mm.live.core.core.d.b.hCo;
        viewGroup.getContext();
        this.liveCore = b.a.aEf();
        this.orientationEventListener = new com.tencent.mm.plugin.mmsight.model.d(this.context, (byte) 0);
        com.tencent.mm.plugin.mmsight.model.d dVar = this.orientationEventListener;
        if (dVar != null) {
            dVar.a(this);
        }
        com.tencent.mm.plugin.mmsight.model.d dVar2 = this.orientationEventListener;
        if (dVar2 != null) {
            dVar2.enable();
        }
        ImageView imageView = new ImageView(this.hwr.getContext());
        imageView.setImageDrawable(ar.m(this.hwr.getContext(), R.raw.icons_filled_camera_switch, -1));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(at.fromDPToPix(this.hwr.getContext(), 28), at.fromDPToPix(this.hwr.getContext(), 28));
        layoutParams.addRule(21);
        int fromDPToPix = at.fromDPToPix(this.hwr.getContext(), 4);
        imageView.setPadding(fromDPToPix, fromDPToPix, fromDPToPix, fromDPToPix);
        RelativeLayout cameraRootView = this.hAs.getCameraRootView();
        if (cameraRootView != null) {
            cameraRootView.addView(imageView, layoutParams);
        }
        imageView.setOnClickListener(new e(this));
        AppMethodBeat.o(208283);
    }

    public static final /* synthetic */ void aHR() {
    }

    public static final /* synthetic */ void aHS() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/live/plugin/LiveVisitorPreviewPlugin$Companion;", "", "()V", "ENTER_ROOM_SCENE_LINK_MIC", "", "ENTER_ROOM_SCENE_VISITOR", "LIVE_UI", "", "TAG", "plugin-logic_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class e implements View.OnClickListener {
        final /* synthetic */ bk hTF;

        e(bk bkVar) {
            this.hTF = bkVar;
        }

        public final void onClick(View view) {
            com.tencent.mm.live.core.core.b.d dVar;
            boolean z;
            boolean z2;
            com.tencent.mm.live.core.core.b.d dVar2;
            AppMethodBeat.i(208271);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveVisitorPreviewPlugin$setupSwitchCameraBtn$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            b.C0376b.a(this.hTF.hOp, b.c.hLE);
            x xVar = x.hJf;
            com.tencent.mm.live.core.core.b.f aGv = x.aGv();
            if (!(aGv == null || (dVar = aGv.hzt) == null)) {
                x xVar2 = x.hJf;
                com.tencent.mm.live.core.core.b.f aGv2 = x.aGv();
                if (aGv2 == null || (dVar2 = aGv2.hzt) == null) {
                    z = true;
                } else {
                    z = dVar2.hzh;
                }
                if (!z) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                dVar.hzh = z2;
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveVisitorPreviewPlugin$setupSwitchCameraBtn$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(208271);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/live/plugin/LiveVisitorPreviewPlugin$exitRoom$1", "Lcom/tencent/mm/live/core/core/LiveCallback;", "callback", "", OpenSDKTool4Assistant.EXTRA_ERROR_CODE, "", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
    public static final class c implements com.tencent.mm.live.core.core.c {
        c() {
        }

        @Override // com.tencent.mm.live.core.core.c
        public final void callback(int i2, Bundle bundle) {
            AppMethodBeat.i(208269);
            Log.i("MicroMsg.LiveCoreVisitor", "on exit room finish");
            AppMethodBeat.o(208269);
        }
    }

    public final void exitRoom() {
        AppMethodBeat.i(208275);
        com.tencent.mm.live.core.core.d.b bVar = this.liveCore;
        if (bVar != null) {
            bVar.b(new c());
            AppMethodBeat.o(208275);
            return;
        }
        AppMethodBeat.o(208275);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/live/plugin/LiveVisitorPreviewPlugin$enterRoom$1", "Lcom/tencent/mm/live/core/core/LiveCallback;", "callback", "", OpenSDKTool4Assistant.EXTRA_ERROR_CODE, "", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
    public static final class b implements com.tencent.mm.live.core.core.c {
        final /* synthetic */ kotlin.g.a.b hSE;
        final /* synthetic */ bk hTF;

        b(bk bkVar, kotlin.g.a.b bVar) {
            this.hTF = bkVar;
            this.hSE = bVar;
        }

        @Override // com.tencent.mm.live.core.core.c
        public final void callback(int i2, Bundle bundle) {
            AppMethodBeat.i(208268);
            if (i2 >= 0) {
                bk.aHR();
                this.hSE.invoke(Boolean.TRUE);
                AppMethodBeat.o(208268);
                return;
            }
            bk.aHS();
            this.hSE.invoke(Boolean.FALSE);
            AppMethodBeat.o(208268);
        }
    }

    public final void a(com.tencent.mm.live.core.core.b.f fVar, kotlin.g.a.b<? super Boolean, kotlin.x> bVar) {
        AppMethodBeat.i(208276);
        p.h(fVar, "liveRoomModel");
        p.h(bVar, NativeProtocol.WEB_DIALOG_ACTION);
        com.tencent.mm.live.core.core.d.b bVar2 = this.liveCore;
        if (bVar2 != null) {
            bVar2.a(fVar);
        }
        com.tencent.mm.live.core.core.d.b bVar3 = this.liveCore;
        if (bVar3 != null) {
            bVar3.a(this.hAs, new b(this, bVar));
            AppMethodBeat.o(208276);
            return;
        }
        AppMethodBeat.o(208276);
    }

    public final void aHQ() {
        AppMethodBeat.i(208277);
        ViewParent parent = this.hAs.getParent();
        if (parent != null) {
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.hAs);
                ((ViewGroup) parent).addView(this.hAs);
            }
            AppMethodBeat.o(208277);
            return;
        }
        AppMethodBeat.o(208277);
    }

    public final void c(int i2, String str, int i3) {
        AppMethodBeat.i(208278);
        p.h(str, "userId");
        this.hAs.c(i2, str, i3);
        AppMethodBeat.o(208278);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        int i2;
        com.tencent.mm.live.core.core.d.b bVar;
        com.tencent.mm.live.core.core.b.g gVar;
        com.tencent.mm.live.core.core.b.g gVar2;
        com.tencent.mm.live.core.core.b.g gVar3;
        com.tencent.mm.live.core.core.b.g gVar4;
        Integer num = null;
        boolean z = false;
        boolean z2 = true;
        AppMethodBeat.i(208279);
        p.h(cVar, "status");
        super.statusChange(cVar, bundle);
        switch (bl.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
            case 2:
            case 3:
                com.tencent.mm.plugin.mmsight.model.d dVar = this.orientationEventListener;
                if (dVar != null) {
                    dVar.disable();
                }
                com.tencent.mm.plugin.mmsight.model.d dVar2 = this.orientationEventListener;
                if (dVar2 != null) {
                    dVar2.a(null);
                }
                this.orientationEventListener = null;
                exitRoom();
                rg(8);
                AppMethodBeat.o(208279);
                return;
            case 4:
                if (bundle != null) {
                    z = bundle.getBoolean("PARAM_HANGUP_SELF", false);
                }
                if (z) {
                    com.tencent.mm.live.core.core.d.b bVar2 = this.liveCore;
                    if (bVar2 == null || (gVar4 = bVar2.hAz) == null || !gVar4.aDu()) {
                        com.tencent.mm.live.core.core.d.b bVar3 = this.liveCore;
                        if (!(bVar3 == null || (gVar3 = bVar3.hAz) == null || !gVar3.aDt())) {
                            com.tencent.mm.live.d.c.aIt();
                        }
                    } else {
                        com.tencent.mm.live.d.c.aIs();
                    }
                } else {
                    com.tencent.mm.live.core.core.d.b bVar4 = this.liveCore;
                    if (bVar4 == null || (gVar2 = bVar4.hAz) == null || !gVar2.aDu()) {
                        com.tencent.mm.live.core.core.d.b bVar5 = this.liveCore;
                        if (!(bVar5 == null || (gVar = bVar5.hAz) == null || !gVar.aDt())) {
                            com.tencent.mm.live.d.c.aIv();
                        }
                    } else {
                        com.tencent.mm.live.d.c.aIu();
                    }
                }
                b.a aVar = com.tencent.mm.live.core.core.d.b.hCo;
                this.hwr.getContext();
                b.a.aEf().aEd();
                com.tencent.mm.live.core.core.d.b bVar6 = this.liveCore;
                if (bVar6 != null) {
                    num = Integer.valueOf(bVar6.aDZ());
                }
                Log.i("MicroMsg.LiveCoreVisitor", "requestLinkMic ret:".concat(String.valueOf(num)));
                this.hAs.post(new f(this));
                AppMethodBeat.o(208279);
                return;
            case 5:
                AppMethodBeat.o(208279);
                return;
            case 6:
            case 7:
                AppMethodBeat.o(208279);
                return;
            case 8:
                com.tencent.mm.live.core.b.l lVar = this.hTC;
                if (!(lVar == null || (bVar = this.liveCore) == null)) {
                    bVar.a(lVar);
                }
                x xVar = x.hJf;
                String aGm = x.aGm();
                x xVar2 = x.hJf;
                long j2 = x.aGr().hyH;
                x xVar3 = x.hJf;
                String aGt = x.aGt();
                String aTY = z.aTY();
                p.g(aTY, "ConfigStorageLogic.getUsernameFromUserInfo()");
                x xVar4 = x.hJf;
                com.tencent.mm.live.d.e.a(aGm, j2, aGt, 7, 1, aTY, x.aGr().LIa);
                AppMethodBeat.o(208279);
                return;
            case 9:
                rg(0);
                aHQ();
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
                if (resources2.getConfiguration().orientation != 1) {
                    z2 = false;
                }
                aDD.eA(z2);
                b.a aVar2 = com.tencent.mm.live.core.core.d.b.hCo;
                this.hwr.getContext();
                b.a.aEf().b(this.hAs);
                com.tencent.mm.live.d.c.aIp();
                AppMethodBeat.o(208279);
                return;
            case 10:
                this.hAs.post(new g(this));
                b.a aVar3 = com.tencent.mm.live.core.core.d.b.hCo;
                this.hwr.getContext();
                b.a.aEf().aEd();
                x xVar5 = x.hJf;
                String aGm2 = x.aGm();
                x xVar6 = x.hJf;
                long j3 = x.aGr().hyH;
                x xVar7 = x.hJf;
                String aGt2 = x.aGt();
                String aTY2 = z.aTY();
                p.g(aTY2, "ConfigStorageLogic.getUsernameFromUserInfo()");
                x xVar8 = x.hJf;
                com.tencent.mm.live.d.e.a(aGm2, j3, aGt2, 7, 0, aTY2, x.aGr().LIa);
                AppMethodBeat.o(208279);
                return;
            case 11:
                Log.i("MicroMsg.LiveCoreVisitor", "switchCamera");
                com.tencent.mm.live.core.core.d.b bVar7 = this.liveCore;
                if (bVar7 != null) {
                    bVar7.switchCamera();
                }
                x xVar9 = x.hJf;
                String aGm3 = x.aGm();
                x xVar10 = x.hJf;
                long j4 = x.aGr().hyH;
                x xVar11 = x.hJf;
                String aGt3 = x.aGt();
                com.tencent.mm.live.core.core.trtc.a.a aDC2 = com.tencent.mm.live.core.core.trtc.a.a.aDC();
                p.g(aDC2, "ConfigHelper.getInstance()");
                if (aDC2.aDG().hBp == 0) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                x xVar12 = x.hJf;
                com.tencent.mm.live.d.e.a(aGm3, j4, aGt3, 1, i2, x.aGr().LIa);
                break;
        }
        AppMethodBeat.o(208279);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class f implements Runnable {
        final /* synthetic */ bk hTF;

        f(bk bkVar) {
            this.hTF = bkVar;
        }

        public final void run() {
            AppMethodBeat.i(208272);
            this.hTF.hAs.hER.aEY();
            AppMethodBeat.o(208272);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class g implements Runnable {
        final /* synthetic */ bk hTF;

        g(bk bkVar) {
            this.hTF = bkVar;
        }

        public final void run() {
            AppMethodBeat.i(208273);
            this.hTF.hAs.hER.aEY();
            AppMethodBeat.o(208273);
        }
    }

    @Override // com.tencent.mm.live.c.a
    public final void resume() {
        AppMethodBeat.i(208280);
        x xVar = x.hJf;
        if (x.getLastOrientation() != -1) {
            Object systemService = this.context.getSystemService("window");
            if (systemService == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.WindowManager");
                AppMethodBeat.o(208280);
                throw tVar;
            }
            Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
            p.g(defaultDisplay, "((context.getSystemServi…owManager).defaultDisplay");
            int rotation = defaultDisplay.getRotation();
            x xVar2 = x.hJf;
            if (rotation != x.getLastOrientation()) {
                com.tencent.mm.live.core.core.d.b bVar = this.liveCore;
                if (bVar != null) {
                    bVar.a(this.hAs);
                }
                this.hAs.getRenderLayout().post(new d(this));
            }
        }
        AppMethodBeat.o(208280);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class d implements Runnable {
        final /* synthetic */ bk hTF;

        d(bk bkVar) {
            this.hTF = bkVar;
        }

        public final void run() {
            AppMethodBeat.i(208270);
            LivePreviewView livePreviewView = this.hTF.hAs;
            livePreviewView.hER.qP(livePreviewView.hER.getRemoteViewIndex());
            AppMethodBeat.o(208270);
        }
    }

    @Override // com.tencent.mm.live.c.a
    public final void pause() {
    }

    @Override // com.tencent.mm.live.c.a
    public final void unMount() {
        com.tencent.mm.live.core.core.d.b bVar;
        com.tencent.mm.live.core.core.d.b bVar2;
        com.tencent.mm.live.core.core.b.g gVar;
        com.tencent.mm.live.core.core.b.g gVar2;
        com.tencent.mm.live.core.core.b.g gVar3;
        AppMethodBeat.i(208281);
        Log.i("MicroMsg.LiveCoreVisitor", "unMount");
        com.tencent.mm.live.core.core.d.b bVar3 = this.liveCore;
        if (bVar3 == null || (gVar3 = bVar3.hAz) == null || !gVar3.isFloatMode()) {
            x xVar = x.hJf;
            if (x.isManualClosed() || (((bVar = this.liveCore) == null || (gVar2 = bVar.hAz) == null || !gVar2.aDu()) && ((bVar2 = this.liveCore) == null || (gVar = bVar2.hAz) == null || !gVar.aDt()))) {
                com.tencent.mm.live.core.core.d.b bVar4 = this.liveCore;
                if (bVar4 != null) {
                    bVar4.b(new h());
                    AppMethodBeat.o(208281);
                    return;
                }
                AppMethodBeat.o(208281);
                return;
            }
        }
        com.tencent.mm.live.core.debug.a aVar = com.tencent.mm.live.core.debug.a.hCA;
        com.tencent.mm.live.core.debug.a.GA("activity recycler");
        AppMethodBeat.o(208281);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/live/plugin/LiveVisitorPreviewPlugin$unMount$1", "Lcom/tencent/mm/live/core/core/LiveCallback;", "callback", "", OpenSDKTool4Assistant.EXTRA_ERROR_CODE, "", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
    public static final class h implements com.tencent.mm.live.core.core.c {
        h() {
        }

        @Override // com.tencent.mm.live.core.core.c
        public final void callback(int i2, Bundle bundle) {
            AppMethodBeat.i(208274);
            Log.i("MicroMsg.LiveCoreVisitor", "on exitRoom finish");
            b.a aVar = com.tencent.mm.live.core.core.a.b.hyv;
            b.a.releaseInstance();
            AppMethodBeat.o(208274);
        }
    }

    @Override // com.tencent.mm.live.c.a
    public final boolean onBackPress() {
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0048, code lost:
        if (r1.getConfiguration().orientation == 2) goto L_0x004a;
     */
    @Override // com.tencent.mm.plugin.mmsight.model.d.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onOrientationChange(int r10) {
        /*
        // Method dump skipped, instructions count: 187
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.live.c.bk.onOrientationChange(int):void");
    }
}
