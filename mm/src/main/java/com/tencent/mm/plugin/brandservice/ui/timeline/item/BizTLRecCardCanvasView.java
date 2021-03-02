package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.r;
import com.tencent.mm.plugin.webcanvas.WebCanvasView;
import com.tencent.mm.plugin.webcanvas.c;
import com.tencent.mm.plugin.webcanvas.g;
import com.tencent.mm.plugin.webcanvas.h;
import com.tencent.mm.plugin.webcanvas.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.z;
import java.lang.ref.WeakReference;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010%\u001a\u0004\u0018\u00010&J&\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020\u000bJ\b\u0010.\u001a\u00020(H\u0014J\u0012\u0010/\u001a\u00020(2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\b\u00102\u001a\u00020(H\u0014J\b\u00103\u001a\u00020(H\u0016J*\u00104\u001a\u00020(2\b\u00105\u001a\u0004\u0018\u0001062\u0006\u00107\u001a\u00020\b2\u0006\u00108\u001a\u00020\b2\u0006\u00109\u001a\u00020\bH\u0016J\u001a\u0010:\u001a\u00020(2\b\u00105\u001a\u0004\u0018\u0001062\u0006\u0010;\u001a\u00020\bH\u0016J\u000e\u0010<\u001a\u00020(2\u0006\u0010=\u001a\u00020\rR\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u00020\u00138FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R$\u0010 \u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006>"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardCanvasView;", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasView;", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasNoneLifecycleObserver;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "getInfo", "()Lcom/tencent/mm/storage/BizTimeLineInfo;", "setInfo", "(Lcom/tencent/mm/storage/BizTimeLineInfo;)V", "isDoingConfigurationChanged", "", "()Z", "setDoingConfigurationChanged", "(Z)V", "isVideoCard", "setVideoCard", "jsEngine", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasJsEngine;", "getJsEngine", "()Lcom/tencent/mm/plugin/webcanvas/WebCanvasJsEngine;", "logicEngine", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardJsEngine;", "value", "videoStatus", "getVideoStatus", "()I", "setVideoStatus", "(I)V", "getVideoRelativePos", "", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "", "msgId", "", "canvasId", "type", "data", "onAttachedToWindow", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDetachedFromWindow", "onScreenShot", "onScroll", "view", "Landroid/widget/AbsListView;", "firstVisibleItem", "visibleItemCount", "totalItemCount", "onScrollStateChanged", "scrollState", "setBizTimeLineInfo", "bizTimeLineInfo", "plugin-brandservice_release"})
public final class BizTLRecCardCanvasView extends WebCanvasView implements h {
    final String TAG;
    z psm;
    private boolean pvi;
    final x pvt;
    private final c pvu;
    private boolean pvv;
    private int videoStatus;

    public BizTLRecCardCanvasView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, (byte) 0);
    }

    public static final /* synthetic */ String b(BizTLRecCardCanvasView bizTLRecCardCanvasView) {
        AppMethodBeat.i(195387);
        String canvasId = bizTLRecCardCanvasView.getCanvasId();
        AppMethodBeat.o(195387);
        return canvasId;
    }

    private /* synthetic */ BizTLRecCardCanvasView(Context context, AttributeSet attributeSet, byte b2) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BizTLRecCardCanvasView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(195386);
        this.TAG = "MicroMsg.BizTLRecCardCanvasView:" + hashCode();
        this.pvi = true;
        r.a aVar = r.puL;
        this.pvt = r.a.cmU();
        this.pvu = this.pvt;
        AppMethodBeat.o(195386);
    }

    public final z getInfo() {
        return this.psm;
    }

    public final void setInfo(z zVar) {
        this.psm = zVar;
    }

    public final void setVideoCard(boolean z) {
        this.pvi = z;
    }

    public final int getVideoStatus() {
        return this.videoStatus;
    }

    public final void setVideoStatus(int i2) {
        AppMethodBeat.i(195377);
        this.videoStatus = i2;
        Log.d(this.TAG, "set videoStatus = " + i2 + ", " + getCanvasId());
        if (i2 == 1) {
            x xVar = this.pvt;
            String canvasId = getCanvasId();
            p.h(canvasId, "canvasId");
            Log.i(x.TAG, "enterHotZone #".concat(String.valueOf(canvasId)));
            ab abVar = xVar.pvY;
            if (abVar == null) {
                p.btv("tlRenderJsEngine");
            }
            p.h(canvasId, "canvasId");
            k.a(abVar, "enterHotZone", canvasId);
            com.tencent.mm.plugin.webcanvas.a aWC = xVar.cnb().aWC(canvasId);
            if (aWC != null) {
                aWC.IyZ = true;
                AppMethodBeat.o(195377);
                return;
            }
            AppMethodBeat.o(195377);
            return;
        }
        this.pvt.ahP(getCanvasId());
        AppMethodBeat.o(195377);
    }

    @Override // com.tencent.mm.plugin.webcanvas.WebCanvasView
    public final c getJsEngine() {
        return this.pvu;
    }

    public final void setBizTimeLineInfo(z zVar) {
        AppMethodBeat.i(195378);
        p.h(zVar, "bizTimeLineInfo");
        this.pvt.psm = zVar;
        this.psm = zVar;
        AppMethodBeat.o(195378);
    }

    public final void a(long j2, String str, String str2, String str3) {
        AppMethodBeat.i(195379);
        p.h(str, "canvasId");
        p.h(str2, "type");
        p.h(str3, "data");
        c jsEngine = getJsEngine();
        if (jsEngine == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.item.BizTLRecCardJsEngine");
            AppMethodBeat.o(195379);
            throw tVar;
        }
        ((x) jsEngine).pvX.put(str, Long.valueOf(j2));
        WeakReference<Context> weakReference = new WeakReference<>(getContext());
        p.h(weakReference, "<set-?>");
        ((x) getJsEngine()).lAM = weakReference;
        bb(str, str2, str3);
        AppMethodBeat.o(195379);
    }

    @Override // com.tencent.mm.plugin.webcanvas.WebCanvasView
    public final void onAttachedToWindow() {
        AppMethodBeat.i(195380);
        super.onAttachedToWindow();
        Context context = getContext();
        if (!(context instanceof g)) {
            context = null;
        }
        g gVar = (g) context;
        if (gVar != null) {
            gVar.a((h) this);
            AppMethodBeat.o(195380);
            return;
        }
        AppMethodBeat.o(195380);
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        AppMethodBeat.i(195381);
        super.onDetachedFromWindow();
        Context context = getContext();
        if (!(context instanceof g)) {
            context = null;
        }
        g gVar = (g) context;
        if (gVar != null) {
            gVar.b(this);
        }
        if (this.videoStatus == 1) {
            this.pvt.ahP(getCanvasId());
        }
        AppMethodBeat.o(195381);
    }

    @Override // com.tencent.mm.plugin.webcanvas.h
    public final void cmV() {
        AppMethodBeat.i(195382);
        x xVar = this.pvt;
        String canvasId = getCanvasId();
        p.h(canvasId, "canvasId");
        c.a(xVar, "scroll", canvasId);
        AppMethodBeat.o(195382);
    }

    @Override // com.tencent.mm.plugin.webcanvas.h
    public final void cmW() {
        AppMethodBeat.i(195383);
        x xVar = this.pvt;
        String canvasId = getCanvasId();
        p.h(canvasId, "canvasId");
        Log.i(x.TAG, "onScreenShot ".concat(String.valueOf(canvasId)));
        c.a(xVar, "onScreenShot", canvasId);
        AppMethodBeat.o(195383);
    }

    public final void setDoingConfigurationChanged(boolean z) {
        this.pvv = z;
    }

    @Override // com.tencent.mm.plugin.webcanvas.h
    public final void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(195384);
        if (this.pvv) {
            AppMethodBeat.o(195384);
            return;
        }
        this.pvv = true;
        Log.d(this.TAG, "onConfigurationChanged before:[" + getMeasuredWidth() + ", " + getMeasuredHeight() + ']');
        getViewTreeObserver().addOnGlobalLayoutListener(new a(this));
        AppMethodBeat.o(195384);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardCanvasView$onConfigurationChanged$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-brandservice_release"})
    public static final class a implements ViewTreeObserver.OnGlobalLayoutListener {
        final /* synthetic */ BizTLRecCardCanvasView pvw;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        a(BizTLRecCardCanvasView bizTLRecCardCanvasView) {
            this.pvw = bizTLRecCardCanvasView;
        }

        public final void onGlobalLayout() {
            AppMethodBeat.i(195376);
            this.pvw.setDoingConfigurationChanged(false);
            Log.i(this.pvw.TAG, "onConfigurationChanged:[" + this.pvw.getMeasuredWidth() + ", " + this.pvw.getMeasuredHeight() + ']');
            this.pvw.getJsEngine().bw(BizTLRecCardCanvasView.b(this.pvw), -1);
            this.pvw.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            AppMethodBeat.o(195376);
        }
    }

    public final float[] getVideoRelativePos() {
        AppMethodBeat.i(195385);
        float[] aWv = this.pvt.aWv(getCanvasId());
        if (aWv == null) {
            aWv = new float[]{0.0f, 0.0f};
        }
        AppMethodBeat.o(195385);
        return aWv;
    }
}
