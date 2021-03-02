package com.tencent.mm.live.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.core.debug.LiveDebugView;
import com.tencent.mm.live.core.view.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.util.List;
import kotlin.g.a.m;
import kotlin.g.a.q;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u000f\b\u0016\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u001b\u001a\u00020\u00142\b\u0010\u001c\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u001eJ\u0010\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u0004\u0018\u00010\u0001J\b\u0010%\u001a\u00020&H\u0002JS\u0010'\u001a\u00020\u00142K\u0010(\u001aG\u0012\u0013\u0012\u00110*¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(+\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(,\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\u00140)J\u001a\u0010.\u001a\u0004\u0018\u00010/2\b\u0010\u001c\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u00100\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\bJ\u0012\u00101\u001a\u00020#2\b\u00102\u001a\u0004\u0018\u000103H\u0016J\u001e\u00104\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u00105\u001a\u00020\u0014J\u0018\u00106\u001a\u00020\u00142\b\u0010\u001c\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u00107\u001a\u00020\u0014J\u0006\u00108\u001a\u00020\u0014J\u0014\u00109\u001a\u00020\u00142\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\b0;J$\u0010<\u001a\u00020\u00142\u0006\u0010=\u001a\u00020\b2\u0006\u0010>\u001a\u00020\b2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\b0;J\u0006\u0010?\u001a\u00020\u0014J\u000e\u0010@\u001a\u00020\u00142\u0006\u0010A\u001a\u00020#J\u0018\u0010@\u001a\u00020\u00142\b\u0010\u001c\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010B\u001a\u00020\u0014J\u0006\u0010C\u001a\u00020\u0014J\u000e\u0010D\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\bJ@\u0010E\u001a\u00020\u001428\u0010(\u001a4\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(F\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(G\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000eJ@\u0010H\u001a\u00020\u001428\u0010(\u001a4\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000eJ\u000e\u0010I\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\bR\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R@\u0010\r\u001a4\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006J"}, hxF = {"Lcom/tencent/mm/live/core/view/LivePreviewView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "debugView", "Lcom/tencent/mm/live/core/debug/LiveDebugView;", "downTime", "", "previewTouchListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "x", "y", "", "renderLayout", "Lcom/tencent/mm/live/core/view/TRTCVideoLayoutManager;", "getRenderLayout", "()Lcom/tencent/mm/live/core/view/TRTCVideoLayoutManager;", "setRenderLayout", "(Lcom/tencent/mm/live/core/view/TRTCVideoLayoutManager;)V", "bringToFront", "userId", "streamType", "", "cameraOrientationChanged", "orientation", "enableDebugView", "enable", "", "getCameraRootView", "getCameraView", "Landroid/view/SurfaceView;", "getSurface", "callback", "Lkotlin/Function3;", "Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "surface", "width", "height", "getTXCloudView", "Lcom/tencent/rtmp/ui/TXCloudVideoView;", "halfRemoteAndCamera", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "orientationChanged", "recyclerCameraView", "recyclerCloudViewView", "refreshCameraView", "refreshVideoView", "relayoutAnchorPreview", "userIdList", "", "relayoutVisitorPreview", "anchorUserId", "selfUserId", "release", "remoteViewFullScreen", "value", "remoteViewPkScreen", "restoreFromHalfMode", "setPkUserId", "setPreviewMoveListener", "xOffset", "yOffset", "setPreviewTouchListener", "setSelfUserId", "plugin-core_release"})
public class LivePreviewView extends RelativeLayout {
    private final String TAG = "MicroMsg.LiveCore";
    private LiveDebugView hCz;
    public TRTCVideoLayoutManager hER;
    private m<? super Float, ? super Float, x> hES;
    private long hET = -1;

    public LivePreviewView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z;
        AppMethodBeat.i(196765);
        View inflate = LayoutInflater.from(context).inflate(R.layout.b1z, (ViewGroup) this, true);
        View findViewById = inflate.findViewById(R.id.h33);
        p.g(findViewById, "parent.findViewById(R.id.render_view)");
        this.hER = (TRTCVideoLayoutManager) findViewById;
        View findViewById2 = inflate.findViewById(R.id.egu);
        p.g(findViewById2, "parent.findViewById(R.id.live_debug_view)");
        this.hCz = (LiveDebugView) findViewById2;
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        if (aAh.azQ().getInt(ar.a.USERINFO_LIVE_DEBUG_VIEW_INT_SYNC, 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.hCz.setVisibility(0);
            com.tencent.mm.live.core.debug.a aVar = com.tencent.mm.live.core.debug.a.hCA;
            com.tencent.mm.live.core.debug.a.c(this.hCz);
            AppMethodBeat.o(196765);
            return;
        }
        this.hCz.setVisibility(8);
        com.tencent.mm.live.core.debug.a aVar2 = com.tencent.mm.live.core.debug.a.hCA;
        com.tencent.mm.live.core.debug.a.release();
        AppMethodBeat.o(196765);
    }

    public final TRTCVideoLayoutManager getRenderLayout() {
        return this.hER;
    }

    public final void setRenderLayout(TRTCVideoLayoutManager tRTCVideoLayoutManager) {
        AppMethodBeat.i(196753);
        p.h(tRTCVideoLayoutManager, "<set-?>");
        this.hER = tRTCVideoLayoutManager;
        AppMethodBeat.o(196753);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class a implements Runnable {
        final /* synthetic */ LivePreviewView hEU;
        final /* synthetic */ String hEV;
        final /* synthetic */ int hEW = 0;

        a(LivePreviewView livePreviewView, String str) {
            this.hEU = livePreviewView;
            this.hEV = str;
        }

        public final void run() {
            AppMethodBeat.i(196751);
            this.hEU.getRenderLayout().qP(this.hEU.getRenderLayout().Z(this.hEV, this.hEW));
            AppMethodBeat.o(196751);
        }
    }

    public final void GE(String str) {
        AppMethodBeat.i(196754);
        post(new a(this, str));
        AppMethodBeat.o(196754);
    }

    public final void hF(List<String> list) {
        AppMethodBeat.i(261596);
        p.h(list, "userIdList");
        this.hER.hF(list);
        AppMethodBeat.o(261596);
    }

    public final void h(String str, String str2, List<String> list) {
        AppMethodBeat.i(261597);
        p.h(str, "anchorUserId");
        p.h(str2, "selfUserId");
        p.h(list, "userIdList");
        this.hER.h(str, str2, list);
        AppMethodBeat.o(261597);
    }

    public final TXCloudVideoView X(String str, int i2) {
        AppMethodBeat.i(196755);
        TXCloudVideoView Y = this.hER.Y(str, i2);
        AppMethodBeat.o(196755);
        return Y;
    }

    public final void GH(String str) {
        AppMethodBeat.i(261598);
        this.hER.GH(str);
        AppMethodBeat.o(261598);
    }

    public final RelativeLayout getCameraRootView() {
        AppMethodBeat.i(196756);
        RelativeLayout cameraContentView = this.hER.getCameraContentView();
        AppMethodBeat.o(196756);
        return cameraContentView;
    }

    public final void qO(int i2) {
        AppMethodBeat.i(196757);
        this.hER.qQ(i2);
        AppMethodBeat.o(196757);
    }

    public final void c(int i2, String str, int i3) {
        AppMethodBeat.i(196758);
        p.h(str, "userId");
        this.hER.c(i2, str, i3);
        AppMethodBeat.o(196758);
    }

    public final void setPkUserId(String str) {
        AppMethodBeat.i(196759);
        p.h(str, "userId");
        this.hER.setPkUserId(str);
        AppMethodBeat.o(196759);
    }

    public final void setSelfUserId(String str) {
        AppMethodBeat.i(196760);
        p.h(str, "userId");
        this.hER.setMySelfUserId(str);
        AppMethodBeat.o(196760);
    }

    private final SurfaceView getCameraView() {
        AppMethodBeat.i(196761);
        SurfaceView aEX = this.hER.aEX();
        p.g(aEX, "renderLayout.allocCameraView()");
        AppMethodBeat.o(196761);
        return aEX;
    }

    public final void a(q<? super com.tencent.mm.live.core.b.l, ? super Integer, ? super Integer, x> qVar) {
        AppMethodBeat.i(196762);
        p.h(qVar, "callback");
        qVar.d(new com.tencent.mm.live.core.b.l(getCameraView().getHolder()), Integer.valueOf(this.hER.getCameraViewWidth()), Integer.valueOf(this.hER.getCameraViewHeight()));
        AppMethodBeat.o(196762);
    }

    public final void setPreviewTouchListener(m<? super Float, ? super Float, x> mVar) {
        this.hES = mVar;
    }

    public final void setPreviewMoveListener(m<? super Float, ? super Float, x> mVar) {
        Object obj;
        AppMethodBeat.i(196763);
        TRTCVideoLayoutManager tRTCVideoLayoutManager = this.hER;
        if (mVar != null) {
            obj = new a(mVar);
        } else {
            obj = mVar;
        }
        tRTCVideoLayoutManager.setGestureListener((b.a) obj);
        AppMethodBeat.o(196763);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(196764);
        Integer valueOf = motionEvent != null ? Integer.valueOf(motionEvent.getAction()) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            this.hET = System.currentTimeMillis();
        } else if (valueOf != null && valueOf.intValue() == 1) {
            if (this.hET > 0 && System.currentTimeMillis() - this.hET <= ((long) ViewConfiguration.getTapTimeout())) {
                Log.d(this.TAG, "preview action up");
                m<? super Float, ? super Float, x> mVar = this.hES;
                if (mVar != null) {
                    mVar.invoke(Float.valueOf(motionEvent.getRawX()), Float.valueOf(motionEvent.getRawY()));
                }
            }
            this.hET = -1;
        }
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        AppMethodBeat.o(196764);
        return onInterceptTouchEvent;
    }
}
