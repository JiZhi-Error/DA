package com.tencent.mm.plugin.webcanvas;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.res.Resources;
import android.os.Build;
import android.os.Looper;
import android.os.MessageQueue;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.ValueCallback;
import android.widget.ListView;
import com.eclipsesource.v8.V8Object;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.ab.f;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.n.n;
import kotlin.x;
import kotlinx.a.b.ab;
import kotlinx.a.b.as;
import kotlinx.a.b.ba;
import kotlinx.a.b.bf;
import kotlinx.a.c.a;
import kotlinx.a.c.a.r;
import kotlinx.a.c.u;
import kotlinx.a.h;
import kotlinx.a.y;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0010\u0014\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0004\n\u0002\b\u0011\u0018\u0000 }2\u00020\u00012\u00020\u0002:\u0005}~\u0001B;\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006¢\u0006\u0002\u0010\rJ\u0015\u0010Q\u001a\u00020R2\u0006\u0010@\u001a\u00020NH\u0000¢\u0006\u0002\bSJ\b\u0010T\u001a\u00020\u0006H\u0016J\u000e\u0010U\u001a\u00020\u00062\u0006\u0010V\u001a\u00020\u0011J\u0015\u0010W\u001a\u00020R2\u0006\u0010X\u001a\u00020YH\u0000¢\u0006\u0002\bZJ\b\u0010[\u001a\u00020HH\u0002J\r\u0010\\\u001a\u00020RH\u0000¢\u0006\u0002\b]J\u0012\u0010^\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0002J\n\u0010_\u001a\u0004\u0018\u00010`H\u0016J\b\u0010a\u001a\u00020HH\u0016J\b\u0010b\u001a\u00020(H\u0016J\b\u0010c\u001a\u00020HH\u0016J\b\u0010d\u001a\u00020HH\u0016J\b\u0010e\u001a\u00020\u0004H\u0016J\u0012\u0010f\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\b\u0010I\u001a\u00020HH\u0016J\b\u0010L\u001a\u00020HH\u0016J\b\u0010g\u001a\u00020HH\u0016J\b\u0010h\u001a\u00020\u0006H\u0016J\r\u0010i\u001a\u00020RH\u0000¢\u0006\u0002\bjJ\r\u0010k\u001a\u00020\u0006H\u0000¢\u0006\u0002\blJ\u0012\u0010m\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J8\u0010n\u001a\u00020R2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010o\u001a\u00020p2\u0006\u0010q\u001a\u00020p2\u0006\u0010r\u001a\u00020p2\u0006\u0010s\u001a\u00020p2\u0006\u0010t\u001a\u00020\u0004H\u0016J\u0006\u0010u\u001a\u00020RJ\u0010\u0010v\u001a\u00020R2\u0006\u0010s\u001a\u00020pH\u0016J\u0018\u0010w\u001a\u00020R2\u0006\u0010q\u001a\u00020p2\u0006\u0010x\u001a\u00020pH\u0016J\u0015\u0010y\u001a\u0004\u0018\u00010H*\u0004\u0018\u00010HH\u0002¢\u0006\u0002\u0010zJ\f\u0010{\u001a\u00020R*\u00020 H\u0002J\u0015\u0010|\u001a\u0004\u0018\u00010H*\u0004\u0018\u00010HH\u0002¢\u0006\u0002\u0010zR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u00020\t8@X\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\u00020\u001c8@X\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u0004\u0018\u00010 8BX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\"\u0010&\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010-\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010*\"\u0004\b/\u0010,R\"\u00100\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010*\"\u0004\b2\u0010,R\u0014\u00103\u001a\u00020\u000b8@X\u0004¢\u0006\u0006\u001a\u0004\b4\u00105R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u00106\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010%\"\u0004\b8\u00109R\u001c\u0010:\u001a\u0004\u0018\u00010;X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0016\u0010@\u001a\u0004\u0018\u00010 8VX\u0004¢\u0006\u0006\u001a\u0004\bA\u0010\"R\u0010\u0010B\u001a\u0004\u0018\u00010CX\u000e¢\u0006\u0002\n\u0000R\u0018\u0010D\u001a\u00020\u0006*\u00020E8BX\u0004¢\u0006\u0006\u001a\u0004\bD\u0010FR\u0018\u0010G\u001a\u00020H*\u00020E8BX\u0004¢\u0006\u0006\u001a\u0004\bI\u0010JR\u0018\u0010K\u001a\u00020H*\u00020E8BX\u0004¢\u0006\u0006\u001a\u0004\bL\u0010JR\u001a\u0010M\u001a\u0004\u0018\u00010N*\u00020E8BX\u0004¢\u0006\u0006\u001a\u0004\bO\u0010P¨\u0006\u0001"}, hxF = {"Lcom/tencent/mm/plugin/webcanvas/WebCanvasContext;", "Lcom/tencent/mm/plugin/webjsapi/WxCanvasAPIContext;", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasPopupTarget;", "canvasId", "", "needCheckDrawChanged", "", "logicJsEngineReference", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasJsEngine;", "renderJsEngineReference", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasRenderJsEngine;", "updateHeight", "(Ljava/lang/String;ZLjava/lang/ref/WeakReference;Ljava/lang/ref/WeakReference;Z)V", "barrier", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasContext$SyncBarrierInfo;", "barrierStartTime", "", "getBarrierStartTime", "()J", "lastDraw", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasContext$DrawInfo;", "layoutCache", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasContext$LayoutCache;", "logicJsEngine", "getLogicJsEngine$webview_sdk_release", "()Lcom/tencent/mm/plugin/webcanvas/WebCanvasJsEngine;", "magicBrush", "Lcom/tencent/magicbrush/MagicBrush;", "getMagicBrush$webview_sdk_release", "()Lcom/tencent/magicbrush/MagicBrush;", "magicBrushView", "Lcom/tencent/magicbrush/ui/MagicBrushView;", "getMagicBrushView", "()Lcom/tencent/magicbrush/ui/MagicBrushView;", "methodInQueue", "getMethodInQueue", "()Z", "onGetFontSize", "Lkotlin/Function0;", "", "getOnGetFontSize", "()Lkotlin/jvm/functions/Function0;", "setOnGetFontSize", "(Lkotlin/jvm/functions/Function0;)V", "onGetWidth", "getOnGetWidth", "setOnGetWidth", "onSetHeight", "getOnSetHeight", "setOnSetHeight", "renderJsEngine", "getRenderJsEngine$webview_sdk_release", "()Lcom/tencent/mm/plugin/webcanvas/WebCanvasRenderJsEngine;", "videoCanAutoPlayNow", "getVideoCanAutoPlayNow", "setVideoCanAutoPlayNow", "(Z)V", "videoPos", "", "getVideoPos", "()[F", "setVideoPos", "([F)V", "view", "getView", "viewContext", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasViewContext;", "isParentPaused", "Landroid/view/View;", "(Landroid/view/View;)Z", "offsetHeight", "", "getOffsetHeight", "(Landroid/view/View;)I", "offsetTop", "getOffsetTop", "parentListView", "Landroid/view/ViewGroup;", "getParentListView", "(Landroid/view/View;)Landroid/view/ViewGroup;", "attach", "", "attach$webview_sdk_release", "canVideoAutoPlay", "checkDrawChanged", "start", "createCanvasView", "context", "Landroid/content/Context;", "createCanvasView$webview_sdk_release", "currentOrientation", "destroy", "destroy$webview_sdk_release", "getCacheKey", "getCanvas", "Lcom/eclipsesource/v8/V8Object;", "getElementId", "getFontSize", "getFps", "getHeight", "getId", "getLayoutCache", "getWidth", "isOnScreen", "postSyncBarrier", "postSyncBarrier$webview_sdk_release", "removeSyncBarrier", "removeSyncBarrier$webview_sdk_release", "restore", "save", "left", "", "top", "width", "height", "layout", "saveLastDraw", "setHeight", "setVideo", "bottom", "absoluteWidth", "(Ljava/lang/Integer;)Ljava/lang/Integer;", "resumeLayout", "takeWhenValid", "Companion", "DrawInfo", "LayoutCache", "SyncBarrierInfo", "webview-sdk_release"})
public final class a implements com.tencent.mm.plugin.ab.g, j {
    private static final kotlin.f Izh = kotlin.g.ah(d.Izo);
    private static final kotlin.f Izi = kotlin.g.ah(b.Izm);
    private static final kotlin.f Izj = kotlin.g.ah(c.Izn);
    private static int Izk = 0;
    public static final C1932a Izl = new C1932a((byte) 0);
    static final String TAG = TAG;
    n IyU;
    public kotlin.g.a.a<Float> IyV;
    public kotlin.g.a.a<Float> IyW;
    public kotlin.g.a.a<Boolean> IyX;
    float[] IyY;
    public boolean IyZ = true;
    g Iza;
    f Izb;
    e Izc;
    final boolean Izd;
    private final WeakReference<c> Ize;
    private final WeakReference<k> Izf;
    private final boolean Izg;
    final String lAN;

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"restoreFromStorage", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasContext$LayoutCache;", "invoke"})
    public static final class j extends q implements kotlin.g.a.a<f> {
        final /* synthetic */ String Izy;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(String str) {
            super(0);
            this.Izy = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ f invoke() {
            AppMethodBeat.i(224582);
            f fWx = fWx();
            AppMethodBeat.o(224582);
            return fWx;
        }

        public final f fWx() {
            String string;
            AppMethodBeat.i(224583);
            C1932a aVar = a.Izl;
            MultiProcessMMKV multiProcessMMKV = (MultiProcessMMKV) C1932a.fWt().findSlot(this.Izy);
            if (!(multiProcessMMKV == null || (string = multiProcessMMKV.getString(this.Izy, "")) == null)) {
                p.g(string, LocaleUtil.ITALIAN);
                if (!(!n.aL(string))) {
                    string = null;
                }
                if (string != null) {
                    a.C2377a aVar2 = kotlinx.a.c.a.TZl;
                    f.b bVar = f.Izq;
                    p.g(string, LocaleUtil.ITALIAN);
                    f fVar = (f) a.C2377a.a(f.C1933a.Izr, string);
                    AppMethodBeat.o(224583);
                    return fVar;
                }
            }
            AppMethodBeat.o(224583);
            return null;
        }
    }

    public a(String str, boolean z, WeakReference<c> weakReference, WeakReference<k> weakReference2, boolean z2) {
        p.h(str, "canvasId");
        p.h(weakReference, "logicJsEngineReference");
        p.h(weakReference2, "renderJsEngineReference");
        AppMethodBeat.i(224612);
        this.lAN = str;
        this.Izd = z;
        this.Ize = weakReference;
        this.Izf = weakReference2;
        this.Izg = z2;
        AppMethodBeat.o(224612);
    }

    public static final /* synthetic */ MagicBrushView a(a aVar) {
        AppMethodBeat.i(224614);
        MagicBrushView MQ = aVar.MQ();
        AppMethodBeat.o(224614);
        return MQ;
    }

    public static final /* synthetic */ void a(a aVar, MagicBrushView magicBrushView) {
        AppMethodBeat.i(224615);
        aVar.e(magicBrushView);
        AppMethodBeat.o(224615);
    }

    public final k fWk() {
        AppMethodBeat.i(224586);
        k kVar = this.Izf.get();
        if (kVar == null) {
            p.hyc();
        }
        p.g(kVar, "renderJsEngineReference.get()!!");
        k kVar2 = kVar;
        AppMethodBeat.o(224586);
        return kVar2;
    }

    public final c fWl() {
        AppMethodBeat.i(224587);
        c cVar = this.Ize.get();
        if (cVar == null) {
            p.hyc();
        }
        p.g(cVar, "logicJsEngineReference.get()!!");
        c cVar2 = cVar;
        AppMethodBeat.o(224587);
        return cVar2;
    }

    /* access modifiers changed from: package-private */
    public final MagicBrushView MQ() {
        AppMethodBeat.i(224588);
        n nVar = this.IyU;
        if (nVar != null) {
            MagicBrushView MQ = nVar.MQ();
            AppMethodBeat.o(224588);
            return MQ;
        }
        AppMethodBeat.o(224588);
        return null;
    }

    private final ViewGroup gc(View view) {
        RecyclerView recyclerView;
        ViewGroup viewGroup = null;
        AppMethodBeat.i(224589);
        while (true) {
            ViewParent parent = view.getParent();
            if (!(parent instanceof ListView)) {
                parent = null;
            }
            ListView listView = (ListView) parent;
            if (listView != null) {
                recyclerView = listView;
            } else {
                ViewParent parent2 = view.getParent();
                if (!(parent2 instanceof RecyclerView)) {
                    parent2 = null;
                }
                recyclerView = (RecyclerView) parent2;
            }
            if (recyclerView != null) {
                viewGroup = recyclerView;
                break;
            }
            ViewParent parent3 = view.getParent();
            if (!(parent3 instanceof View)) {
                parent3 = null;
            }
            View view2 = (View) parent3;
            if (view2 == null) {
                break;
            }
            view = view2;
        }
        AppMethodBeat.o(224589);
        return viewGroup;
    }

    @Override // com.tencent.mm.plugin.ab.g
    public final String getId() {
        return this.lAN;
    }

    @Override // com.tencent.mm.plugin.ab.g
    public final V8Object getCanvas() {
        V8Object v8Object;
        AppMethodBeat.i(224590);
        try {
            k fWk = fWk();
            n nVar = this.IyU;
            if (nVar == null) {
                p.hyc();
            }
            int i2 = nVar.biJ;
            m bMA = fWk.bMA();
            p.g(bMA, "v8Context");
            v8Object = bMA.getGlobalObject().getObject("NativeGlobal").executeObjectFunction("findElementById", fWk.bMA().newV8Array().push(i2));
            p.g(v8Object, "v8Context.globalObject.g…8Array().push(elementId))");
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "getCanvas", new Object[0]);
            v8Object = null;
        }
        AppMethodBeat.o(224590);
        return v8Object;
    }

    @Override // com.tencent.mm.plugin.ab.g
    public final int getElementId() {
        AppMethodBeat.i(224591);
        n nVar = this.IyU;
        if (nVar == null) {
            p.hyc();
        }
        int i2 = nVar.biJ;
        AppMethodBeat.o(224591);
        return i2;
    }

    @Override // com.tencent.mm.plugin.ab.g
    public final boolean isOnScreen() {
        MagicBrushView MQ;
        boolean z;
        Context baseContext;
        AppMethodBeat.i(224593);
        n nVar = this.IyU;
        if (nVar == null || (MQ = nVar.MQ()) == null) {
            AppMethodBeat.o(224593);
            return false;
        }
        if (MQ.isShown() || MQ.isAttachedToWindow()) {
            MagicBrushView magicBrushView = MQ;
            Context context = magicBrushView.getContext();
            if (!(context instanceof MutableContextWrapper)) {
                context = null;
            }
            MutableContextWrapper mutableContextWrapper = (MutableContextWrapper) context;
            Context context2 = (mutableContextWrapper == null || (baseContext = mutableContextWrapper.getBaseContext()) == null) ? magicBrushView.getContext() : baseContext;
            if (!(context2 instanceof MMActivity)) {
                context2 = null;
            }
            MMActivity mMActivity = (MMActivity) context2;
            if (mMActivity != null) {
                z = mMActivity.isPaused();
            } else {
                z = false;
            }
            if (!z) {
                AppMethodBeat.o(224593);
                return true;
            }
        }
        AppMethodBeat.o(224593);
        return false;
    }

    @Override // com.tencent.mm.plugin.ab.g
    public final float getFontSize() {
        Float invoke;
        AppMethodBeat.i(224594);
        kotlin.g.a.a<Float> aVar = this.IyV;
        if (aVar == null || (invoke = aVar.invoke()) == null) {
            f.a aVar2 = com.tencent.mm.plugin.ab.f.IBd;
            float ez = com.tencent.mm.cb.a.ez(MMApplicationContext.getContext());
            AppMethodBeat.o(224594);
            return ez;
        }
        float floatValue = invoke.floatValue();
        AppMethodBeat.o(224594);
        return floatValue;
    }

    private static Integer o(Integer num) {
        AppMethodBeat.i(224595);
        if (num != null) {
            if (num.intValue() > 0) {
                AppMethodBeat.o(224595);
                return num;
            }
            AppMethodBeat.o(224595);
            return null;
        }
        AppMethodBeat.o(224595);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x012d  */
    @Override // com.tencent.mm.plugin.ab.g
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int getWidth() {
        /*
        // Method dump skipped, instructions count: 304
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webcanvas.a.getWidth():int");
    }

    @Override // com.tencent.mm.plugin.ab.g
    public final int getHeight() {
        Integer num;
        int i2;
        Integer num2;
        Integer o;
        Integer num3 = null;
        AppMethodBeat.i(224597);
        f fVar = this.Izb;
        if (fVar == null || (o = o(Integer.valueOf(fVar.height))) == null) {
            MagicBrushView MQ = MQ();
            Integer o2 = o(MQ != null ? Integer.valueOf(MQ.getMeasuredHeight()) : null);
            if (o2 != null) {
                f.a aVar = com.tencent.mm.plugin.ab.f.IBd;
                num = Integer.valueOf(f.a.d(o2));
            } else {
                num = null;
            }
        } else {
            f.a aVar2 = com.tencent.mm.plugin.ab.f.IBd;
            num = Integer.valueOf(f.a.d(o));
        }
        if (num != null) {
            i2 = num.intValue();
        } else {
            i2 = 0;
        }
        String str = TAG;
        StringBuilder append = new StringBuilder("getHeight canvasId=").append(this.lAN).append(" measuredHeight = ");
        MagicBrushView MQ2 = MQ();
        if (MQ2 != null) {
            num2 = Integer.valueOf(MQ2.getMeasuredHeight());
        } else {
            num2 = null;
        }
        Integer o3 = o(num2);
        if (o3 != null) {
            f.a aVar3 = com.tencent.mm.plugin.ab.f.IBd;
            num3 = Integer.valueOf(f.a.d(o3));
        }
        Log.v(str, append.append(num3).append(" height=").append(i2).toString());
        AppMethodBeat.o(224597);
        return i2;
    }

    @Override // com.tencent.mm.plugin.ab.g
    public final int getOffsetTop() {
        AppMethodBeat.i(224598);
        MagicBrushView MQ = MQ();
        if (MQ != null) {
            MagicBrushView magicBrushView = MQ;
            ViewGroup gc = gc(magicBrushView);
            if (gc != null) {
                f.a aVar = com.tencent.mm.plugin.ab.f.IBd;
                int d2 = f.a.d(Integer.valueOf(com.tencent.mm.ac.d.cm(magicBrushView)[1] - com.tencent.mm.ac.d.cm(gc)[1]));
                AppMethodBeat.o(224598);
                return d2;
            }
            AppMethodBeat.o(224598);
            return 0;
        }
        AppMethodBeat.o(224598);
        return 0;
    }

    @Override // com.tencent.mm.plugin.ab.g
    public final int getOffsetHeight() {
        Integer o;
        AppMethodBeat.i(224599);
        MagicBrushView MQ = MQ();
        if (MQ != null) {
            ViewGroup gc = gc(MQ);
            if (gc == null || (o = o(Integer.valueOf(gc.getMeasuredHeight()))) == null) {
                AppMethodBeat.o(224599);
                return 0;
            }
            f.a aVar = com.tencent.mm.plugin.ab.f.IBd;
            int d2 = f.a.d(o);
            AppMethodBeat.o(224599);
            return d2;
        }
        AppMethodBeat.o(224599);
        return 0;
    }

    @Override // com.tencent.mm.plugin.ab.g
    public final void setHeight(Number number) {
        int i2;
        int i3;
        String str = null;
        int i4 = -1;
        AppMethodBeat.i(224600);
        p.h(number, "height");
        if (!this.Izg || p.j(number, 0)) {
            AppMethodBeat.o(224600);
            return;
        }
        kotlin.g.a.a<Boolean> aVar = this.IyX;
        if (aVar != null) {
            aVar.invoke();
        }
        f.a aVar2 = com.tencent.mm.plugin.ab.f.IBd;
        int c2 = f.a.c(number);
        String str2 = TAG;
        StringBuilder append = new StringBuilder("#setHeight# pixelHeight=").append(c2).append(", cacheHeight=");
        f fVar = this.Izb;
        Log.d(str2, append.append(fVar != null ? Integer.valueOf(fVar.height) : null).append(" canvasId=#").append(this.lAN).append(' ').append(hashCode()).toString());
        f fVar2 = this.Izb;
        if (fVar2 == null || c2 != fVar2.height) {
            String str3 = this.lAN;
            f fVar3 = this.Izb;
            if (fVar3 != null) {
                i2 = fVar3.width;
            } else {
                i2 = -1;
            }
            f fVar4 = this.Izb;
            if (fVar4 != null) {
                i3 = fVar4.left;
            } else {
                i3 = -1;
            }
            f fVar5 = this.Izb;
            if (fVar5 != null) {
                i4 = fVar5.top;
            }
            f fVar6 = this.Izb;
            if (fVar6 != null) {
                str = fVar6.Izp;
            }
            this.Izb = new f(str3, c2, i2, i3, i4, str);
            fWk().aWB(this.lAN);
            com.tencent.mm.ac.d.h(new l(this, c2, number));
        }
        Log.i(TAG, "setHeight:#" + this.lAN + ", " + number);
        AppMethodBeat.o(224600);
    }

    @Override // com.tencent.mm.plugin.ab.g
    public final void setVideo(Number number, Number number2) {
        AppMethodBeat.i(224601);
        p.h(number, "top");
        p.h(number2, "bottom");
        Log.d(TAG, "setVideo:" + this.lAN + " to " + number + ' ' + number2);
        this.IyY = new float[]{number.floatValue(), number2.floatValue()};
        AppMethodBeat.o(224601);
    }

    @Override // com.tencent.mm.plugin.ab.g
    public final void save(String str, Number number, Number number2, Number number3, Number number4, String str2) {
        AppMethodBeat.i(224603);
        p.h(str, "canvasId");
        p.h(number, "left");
        p.h(number2, "top");
        p.h(number3, "width");
        p.h(number4, "height");
        p.h(str2, "layout");
        Log.i(TAG, "saveLayout:#" + str + " location:[" + number + ", " + number2 + "], size:[" + number3 + ", " + number4 + ']');
        if (!p.j(number3, 0) || !p.j(number4, 0)) {
            MultiProcessMMKV multiProcessMMKV = (MultiProcessMMKV) C1932a.fWt().getSlot();
            String aWu = aWu(str);
            a.C2377a aVar = kotlinx.a.c.a.TZl;
            f.b bVar = f.Izq;
            f.C1933a aVar2 = f.C1933a.Izr;
            f fVar = new f(str, C1932a.a(number4, -2), C1932a.a(number3, -1), number.intValue(), number2.intValue(), str2);
            if (p.j(str, this.lAN)) {
                setHeight(number4);
                this.Izb = fVar;
            }
            p.h(aVar2, "serializer");
            kotlinx.a.c.a hON = kotlinx.a.c.a.hON();
            p.h(aVar2, "serializer");
            StringBuilder sb = new StringBuilder();
            kotlinx.a.c.a.n nVar = new kotlinx.a.c.a.n(sb, hON, r.OBJ, new u[r.values().length]);
            p.h(nVar, "$this$encode");
            p.h(aVar2, "strategy");
            nVar.a(aVar2, fVar);
            String sb2 = sb.toString();
            p.g(sb2, "result.toString()");
            multiProcessMMKV.putString(aWu, sb2);
            AppMethodBeat.o(224603);
            return;
        }
        Log.e(TAG, "saveLayout:#" + str + " invalid params");
        AppMethodBeat.o(224603);
    }

    @Override // com.tencent.mm.plugin.ab.g
    public final String restore(String str) {
        AppMethodBeat.i(224604);
        p.h(str, "canvasId");
        f aWt = aWt(str);
        if (aWt != null) {
            String str2 = aWt.Izp;
            AppMethodBeat.o(224604);
            return str2;
        }
        AppMethodBeat.o(224604);
        return null;
    }

    private final f aWt(String str) {
        f fVar;
        AppMethodBeat.i(224605);
        j jVar = new j(aWu(str));
        Log.d(TAG, "getLayoutCache: #".concat(String.valueOf(str)));
        if (p.j(str, this.lAN)) {
            fVar = this.Izb;
            if (fVar == null) {
                f fWx = jVar.fWx();
                if (fWx != null) {
                    this.Izb = fWx;
                    AppMethodBeat.o(224605);
                    return fWx;
                }
                AppMethodBeat.o(224605);
                return null;
            }
        } else {
            fVar = jVar.fWx();
        }
        AppMethodBeat.o(224605);
        return fVar;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/webcanvas/WebCanvasContext$DrawInfo;", "", "width", "", "height", "fontSize", "", "isDarkMode", "", "orientation", "(IIFZI)V", "getFontSize", "()F", "getHeight", "()I", "()Z", "getOrientation", "getWidth", "component1", "component2", "component3", "component4", "component5", "copy", "equals", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "", "webview-sdk_release"})
    public static final class e {
        final boolean crv;
        final float fontSize;
        final int height;
        final int orientation;
        final int width;

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x002e, code lost:
            if (r3.orientation == r4.orientation) goto L_0x0030;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 224565(0x36d35, float:3.14683E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x0030
                boolean r0 = r4 instanceof com.tencent.mm.plugin.webcanvas.a.e
                if (r0 == 0) goto L_0x0035
                com.tencent.mm.plugin.webcanvas.a$e r4 = (com.tencent.mm.plugin.webcanvas.a.e) r4
                int r0 = r3.width
                int r1 = r4.width
                if (r0 != r1) goto L_0x0035
                int r0 = r3.height
                int r1 = r4.height
                if (r0 != r1) goto L_0x0035
                float r0 = r3.fontSize
                float r1 = r4.fontSize
                int r0 = java.lang.Float.compare(r0, r1)
                if (r0 != 0) goto L_0x0035
                boolean r0 = r3.crv
                boolean r1 = r4.crv
                if (r0 != r1) goto L_0x0035
                int r0 = r3.orientation
                int r1 = r4.orientation
                if (r0 != r1) goto L_0x0035
            L_0x0030:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            L_0x0034:
                return r0
            L_0x0035:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x0034
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webcanvas.a.e.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            AppMethodBeat.i(224564);
            int floatToIntBits = ((((this.width * 31) + this.height) * 31) + Float.floatToIntBits(this.fontSize)) * 31;
            boolean z = this.crv;
            if (z) {
                z = true;
            }
            int i2 = z ? 1 : 0;
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            int i5 = ((i2 + floatToIntBits) * 31) + this.orientation;
            AppMethodBeat.o(224564);
            return i5;
        }

        public final String toString() {
            AppMethodBeat.i(224563);
            String str = "DrawInfo(width=" + this.width + ", height=" + this.height + ", fontSize=" + this.fontSize + ", isDarkMode=" + this.crv + ", orientation=" + this.orientation + ")";
            AppMethodBeat.o(224563);
            return str;
        }

        public e(int i2, int i3, float f2, boolean z, int i4) {
            this.width = i2;
            this.height = i3;
            this.fontSize = f2;
            this.crv = z;
            this.orientation = i4;
        }
    }

    public final void fWm() {
        AppMethodBeat.i(224606);
        f fVar = this.Izb;
        if (fVar != null) {
            int i2 = fVar.width;
            int i3 = fVar.height;
            float fontSize = getFontSize();
            f.a aVar = com.tencent.mm.plugin.ab.f.IBd;
            this.Izc = new e(i2, i3, fontSize, ao.isDarkMode(), fWp());
            String str = TAG;
            StringBuilder append = new StringBuilder("saveLastDraw:[").append(fVar.width).append(", ").append(fVar.height).append(", ");
            e eVar = this.Izc;
            Log.d(str, append.append(eVar != null ? Integer.valueOf(eVar.orientation) : null).append(']').toString());
            AppMethodBeat.o(224606);
            return;
        }
        AppMethodBeat.o(224606);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/webcanvas/WebCanvasContext$SyncBarrierInfo;", "", "token", "", "start", "", "(IJ)V", "getStart", "()J", "getToken", "()I", "component1", "component2", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "", "webview-sdk_release"})
    public static final class g {
        final long start;
        final int token;

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof g) {
                    g gVar = (g) obj;
                    if (!(this.token == gVar.token && this.start == gVar.start)) {
                        return false;
                    }
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            long j2 = this.start;
            return (this.token * 31) + ((int) (j2 ^ (j2 >>> 32)));
        }

        public final String toString() {
            AppMethodBeat.i(224578);
            String str = "SyncBarrierInfo(token=" + this.token + ", start=" + this.start + ")";
            AppMethodBeat.o(224578);
            return str;
        }

        public g(int i2, long j2) {
            this.token = i2;
            this.start = j2;
        }
    }

    static boolean fWn() {
        return Build.VERSION.SDK_INT >= 23;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/webcanvas/WebCanvasContext$postSyncBarrier$1$1"})
    static final class k implements Runnable {
        final /* synthetic */ a Izv;

        k(a aVar) {
            this.Izv = aVar;
        }

        public final void run() {
            AppMethodBeat.i(224584);
            if (this.Izv.fWo()) {
                Log.e(a.TAG, "removeSyncBarrier by delay:" + this.Izv.lAN);
            }
            AppMethodBeat.o(224584);
        }
    }

    public final boolean fWo() {
        boolean z = true;
        AppMethodBeat.i(224608);
        synchronized (this) {
            try {
                g gVar = this.Iza;
                if (gVar != null) {
                    int i2 = gVar.token;
                    if (fWn()) {
                        Method method = MessageQueue.class.getMethod("removeSyncBarrier", Integer.TYPE);
                        Looper mainLooper = Looper.getMainLooper();
                        p.g(mainLooper, "Looper.getMainLooper()");
                        method.invoke(mainLooper.getQueue(), Integer.valueOf(i2));
                    } else {
                        Looper.class.getMethod("removeSyncBarrier", Integer.TYPE).invoke(Looper.getMainLooper(), Integer.valueOf(i2));
                    }
                    Log.d(TAG, "removeSyncBarrier " + this.lAN + " token:" + i2);
                    this.Iza = null;
                } else {
                    z = false;
                }
            } finally {
                AppMethodBeat.o(224608);
            }
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public final void e(MagicBrushView magicBrushView) {
        AppMethodBeat.i(224609);
        f aWt = aWt(this.lAN);
        if (aWt != null) {
            if (!((aWt.width == 0 || aWt.height == 0 || magicBrushView.getWidth() == aWt.width || magicBrushView.getHeight() == aWt.height) ? false : true)) {
                aWt = null;
            }
            if (aWt != null) {
                ViewGroup.LayoutParams layoutParams = magicBrushView.getLayoutParams();
                layoutParams.width = aWt.width;
                layoutParams.height = aWt.height;
                Log.i(TAG, "resume layout:#" + this.lAN + " size:[" + layoutParams.width + ", " + layoutParams.height + ']');
                magicBrushView.setLayoutParams(layoutParams);
                AppMethodBeat.o(224609);
                return;
            }
        }
        AppMethodBeat.o(224609);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0006\b\b\u0018\u0000 ,2\u00020\u0001:\u0002+,BM\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rB?\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000eJ\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003JG\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\u0003HÖ\u0001J\t\u0010*\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001a\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R\u001a\u0010\t\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0014\"\u0004\b\u001e\u0010\u0016¨\u0006-"}, hxF = {"Lcom/tencent/mm/plugin/webcanvas/WebCanvasContext$LayoutCache;", "", "seen1", "", "canvasId", "", "height", "width", "left", "top", "layout", "serializationConstructorMarker", "Lkotlinx/serialization/SerializationConstructorMarker;", "(ILjava/lang/String;IIIILjava/lang/String;Lkotlinx/serialization/SerializationConstructorMarker;)V", "(Ljava/lang/String;IIIILjava/lang/String;)V", "getCanvasId", "()Ljava/lang/String;", "setCanvasId", "(Ljava/lang/String;)V", "getHeight", "()I", "setHeight", "(I)V", "getLayout", "setLayout", "getLeft", "setLeft", "getTop", "setTop", "getWidth", "setWidth", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "$serializer", "Companion", "webview-sdk_release"})
    public static final class f {
        public static final b Izq = new b((byte) 0);
        String Izp;
        int height;
        private String lAN;
        int left;
        int top;
        int width;

        static {
            AppMethodBeat.i(224572);
            AppMethodBeat.o(224572);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0038, code lost:
            if (kotlin.g.b.p.j(r3.Izp, r4.Izp) != false) goto L_0x003a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 224575(0x36d3f, float:3.14697E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x003a
                boolean r0 = r4 instanceof com.tencent.mm.plugin.webcanvas.a.f
                if (r0 == 0) goto L_0x003f
                com.tencent.mm.plugin.webcanvas.a$f r4 = (com.tencent.mm.plugin.webcanvas.a.f) r4
                java.lang.String r0 = r3.lAN
                java.lang.String r1 = r4.lAN
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x003f
                int r0 = r3.height
                int r1 = r4.height
                if (r0 != r1) goto L_0x003f
                int r0 = r3.width
                int r1 = r4.width
                if (r0 != r1) goto L_0x003f
                int r0 = r3.left
                int r1 = r4.left
                if (r0 != r1) goto L_0x003f
                int r0 = r3.top
                int r1 = r4.top
                if (r0 != r1) goto L_0x003f
                java.lang.String r0 = r3.Izp
                java.lang.String r1 = r4.Izp
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x003f
            L_0x003a:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            L_0x003e:
                return r0
            L_0x003f:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x003e
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webcanvas.a.f.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            int i2 = 0;
            AppMethodBeat.i(224574);
            String str = this.lAN;
            int hashCode = (((((((((str != null ? str.hashCode() : 0) * 31) + this.height) * 31) + this.width) * 31) + this.left) * 31) + this.top) * 31;
            String str2 = this.Izp;
            if (str2 != null) {
                i2 = str2.hashCode();
            }
            int i3 = hashCode + i2;
            AppMethodBeat.o(224574);
            return i3;
        }

        public final String toString() {
            AppMethodBeat.i(224573);
            String str = "LayoutCache(canvasId=" + this.lAN + ", height=" + this.height + ", width=" + this.width + ", left=" + this.left + ", top=" + this.top + ", layout=" + this.Izp + ")";
            AppMethodBeat.o(224573);
            return str;
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, hxF = {"com/tencent/mm/plugin/webcanvas/WebCanvasContext.LayoutCache.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasContext$LayoutCache;", "()V", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/Decoder;", "serialize", "", FFmpegMetadataRetriever.METADATA_KEY_ENCODER, "Lkotlinx/serialization/Encoder;", "value", "webview-sdk_release"})
        /* renamed from: com.tencent.mm.plugin.webcanvas.a$f$a  reason: collision with other inner class name */
        public static final class C1933a implements kotlinx.a.b.u<f> {
            public static final C1933a Izr = new C1933a();
            private static final /* synthetic */ kotlinx.a.n Izs;

            @Override // kotlinx.a.h, kotlinx.a.f
            public final kotlinx.a.n fWv() {
                return Izs;
            }

            static {
                AppMethodBeat.i(224566);
                ba baVar = new ba("com.tencent.mm.plugin.webcanvas.WebCanvasContext.LayoutCache", Izr);
                baVar.dV("canvasId", false);
                baVar.dV("height", false);
                baVar.dV("width", true);
                baVar.dV("left", true);
                baVar.dV("top", true);
                baVar.dV("layout", true);
                Izs = baVar;
                AppMethodBeat.o(224566);
            }

            private C1933a() {
            }

            @Override // kotlinx.a.f
            public final /* synthetic */ Object a(kotlinx.a.c cVar, Object obj) {
                AppMethodBeat.i(224567);
                p.h(cVar, "decoder");
                p.h((f) obj, "old");
                p.h(cVar, "decoder");
                f fVar = (f) h.a.a(this, cVar);
                AppMethodBeat.o(224567);
                return fVar;
            }

            @Override // kotlinx.a.v
            public final /* synthetic */ void a(kotlinx.a.g gVar, Object obj) {
                AppMethodBeat.i(224568);
                f fVar = (f) obj;
                p.h(gVar, FFmpegMetadataRetriever.METADATA_KEY_ENCODER);
                p.h(fVar, "value");
                kotlinx.a.n nVar = Izs;
                kotlinx.a.b b2 = gVar.b(nVar, new kotlinx.a.h[0]);
                f.a(fVar, b2, nVar);
                b2.a(nVar);
                AppMethodBeat.o(224568);
            }

            @Override // kotlinx.a.f
            public final /* synthetic */ Object a(kotlinx.a.c cVar) {
                AppMethodBeat.i(224569);
                p.h(cVar, "decoder");
                kotlinx.a.n nVar = Izs;
                kotlinx.a.a a2 = cVar.a(nVar, new kotlinx.a.h[0]);
                String str = null;
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                String str2 = null;
                int i6 = 0;
                while (true) {
                    int b2 = a2.b(nVar);
                    switch (b2) {
                        case -1:
                            a2.a(nVar);
                            f fVar = new f(i6, str2, i5, i4, i3, i2, str);
                            AppMethodBeat.o(224569);
                            return fVar;
                        case 0:
                            str2 = a2.i(nVar, 0);
                            i6 |= 1;
                            break;
                        case 1:
                            i5 = a2.e(nVar, 1);
                            i6 |= 2;
                            break;
                        case 2:
                            i4 = a2.e(nVar, 2);
                            i6 |= 4;
                            break;
                        case 3:
                            i3 = a2.e(nVar, 3);
                            i6 |= 8;
                            break;
                        case 4:
                            i2 = a2.e(nVar, 4);
                            i6 |= 16;
                            break;
                        case 5:
                            bf bfVar = bf.TYV;
                            Object a3 = (i6 & 32) != 0 ? a2.a(nVar, bfVar, str) : a2.a(nVar, bfVar);
                            i6 |= 32;
                            str = (String) a3;
                            break;
                        default:
                            y yVar = new y(b2);
                            AppMethodBeat.o(224569);
                            throw yVar;
                    }
                }
            }

            @Override // kotlinx.a.b.u
            public final kotlinx.a.h<?>[] fWw() {
                AppMethodBeat.i(224570);
                bf bfVar = bf.TYV;
                p.h(bfVar, "actualSerializer");
                kotlinx.a.h<?>[] hVarArr = {bf.TYV, ab.TYt, ab.TYt, ab.TYt, ab.TYt, new as(bfVar)};
                AppMethodBeat.o(224570);
                return hVarArr;
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/webcanvas/WebCanvasContext$LayoutCache$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasContext$LayoutCache;", "webview-sdk_release"})
        public static final class b {
            private b() {
            }

            public /* synthetic */ b(byte b2) {
                this();
            }
        }

        public /* synthetic */ f(int i2, String str, int i3, int i4, int i5, int i6, String str2) {
            AppMethodBeat.i(224576);
            if ((i2 & 1) == 0) {
                kotlinx.a.i iVar = new kotlinx.a.i("canvasId");
                AppMethodBeat.o(224576);
                throw iVar;
            }
            this.lAN = str;
            if ((i2 & 2) == 0) {
                kotlinx.a.i iVar2 = new kotlinx.a.i("height");
                AppMethodBeat.o(224576);
                throw iVar2;
            }
            this.height = i3;
            if ((i2 & 4) != 0) {
                this.width = i4;
            } else {
                this.width = 0;
            }
            if ((i2 & 8) != 0) {
                this.left = i5;
            } else {
                this.left = 0;
            }
            if ((i2 & 16) != 0) {
                this.top = i6;
            } else {
                this.top = 0;
            }
            if ((i2 & 32) != 0) {
                this.Izp = str2;
                AppMethodBeat.o(224576);
                return;
            }
            this.Izp = null;
            AppMethodBeat.o(224576);
        }

        public f(String str, int i2, int i3, int i4, int i5, String str2) {
            p.h(str, "canvasId");
            AppMethodBeat.i(224571);
            this.lAN = str;
            this.height = i2;
            this.width = i3;
            this.left = i4;
            this.top = i5;
            this.Izp = str2;
            AppMethodBeat.o(224571);
        }

        public static final void a(f fVar, kotlinx.a.b bVar, kotlinx.a.n nVar) {
            boolean z = true;
            AppMethodBeat.i(224577);
            p.h(fVar, "self");
            p.h(bVar, "output");
            p.h(nVar, "serialDesc");
            bVar.a(nVar, fVar.lAN);
            bVar.a(nVar, 1, fVar.height);
            if ((fVar.width != 0) || bVar.c(nVar)) {
                bVar.a(nVar, 2, fVar.width);
            }
            if ((fVar.left != 0) || bVar.c(nVar)) {
                bVar.a(nVar, 3, fVar.left);
            }
            if (fVar.top == 0) {
                z = false;
            }
            if (z || bVar.c(nVar)) {
                bVar.a(nVar, 4, fVar.top);
            }
            if ((!p.j(fVar.Izp, null)) || bVar.c(nVar)) {
                bVar.a(nVar, bf.TYV, fVar.Izp);
            }
            AppMethodBeat.o(224577);
        }
    }

    private final String aWu(String str) {
        AppMethodBeat.i(224610);
        StringBuilder append = new StringBuilder().append(str).append('-').append(fWp()).append('-').append(getWidth()).append('-').append(getFontSize()).append('-');
        f.a aVar = com.tencent.mm.plugin.ab.f.IBd;
        String sb = append.append(ao.isDarkMode()).toString();
        AppMethodBeat.o(224610);
        return sb;
    }

    static int fWp() {
        AppMethodBeat.i(224611);
        f.a aVar = com.tencent.mm.plugin.ab.f.IBd;
        Resources resources = f.a.getAppContext().getResources();
        p.g(resources, "appContext.resources");
        int i2 = resources.getConfiguration().orientation;
        AppMethodBeat.o(224611);
        return i2;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0004\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0019\u001a\u00020\u0006*\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\u00020\f8FX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\u00128FX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\u00128FX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0017\u0010\u0014¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/webcanvas/WebCanvasContext$Companion;", "", "()V", "TAG", "", "attachCount", "", "getAttachCount", "()I", "setAttachCount", "(I)V", "canvasStorage", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "getCanvasStorage", "()Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "canvasStorage$delegate", "Lkotlin/Lazy;", "pauseOnNoViewAttach", "", "getPauseOnNoViewAttach", "()Z", "pauseOnNoViewAttach$delegate", "videoAutoPlayOpen", "getVideoAutoPlayOpen", "videoAutoPlayOpen$delegate", BuildConfig.KINDA_DEFAULT, "", "def", "webview-sdk_release"})
    /* renamed from: com.tencent.mm.plugin.webcanvas.a$a  reason: collision with other inner class name */
    public static final class C1932a {
        public static MMKVSlotManager fWt() {
            AppMethodBeat.i(224560);
            kotlin.f fVar = a.Izi;
            C1932a aVar = a.Izl;
            MMKVSlotManager mMKVSlotManager = (MMKVSlotManager) fVar.getValue();
            AppMethodBeat.o(224560);
            return mMKVSlotManager;
        }

        public static boolean fWu() {
            AppMethodBeat.i(224562);
            kotlin.f fVar = a.Izj;
            C1932a aVar = a.Izl;
            boolean booleanValue = ((Boolean) fVar.getValue()).booleanValue();
            AppMethodBeat.o(224562);
            return booleanValue;
        }

        private C1932a() {
        }

        public /* synthetic */ C1932a(byte b2) {
            this();
        }

        static int a(Number number, int i2) {
            AppMethodBeat.i(224561);
            if (p.j(number, 0)) {
                AppMethodBeat.o(224561);
                return i2;
            }
            f.a aVar = com.tencent.mm.plugin.ab.f.IBd;
            int c2 = f.a.c(number);
            AppMethodBeat.o(224561);
            return c2;
        }
    }

    static {
        AppMethodBeat.i(224613);
        AppMethodBeat.o(224613);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class l extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ Number IzA;
        final /* synthetic */ a Izv;
        final /* synthetic */ int Izz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(a aVar, int i2, Number number) {
            super(0);
            this.Izv = aVar;
            this.Izz = i2;
            this.IzA = number;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(224585);
            MagicBrushView a2 = a.a(this.Izv);
            if (!(a2 == null || !a2.isShown() || a2.getLayoutParams() == null)) {
                ViewGroup.LayoutParams layoutParams = a2.getLayoutParams();
                layoutParams.height = this.Izz;
                Log.i(a.TAG, "update layout height:#" + this.Izv.lAN + ", " + this.IzA);
                a2.setLayoutParams(layoutParams);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(224585);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/webcanvas/WebCanvasContext$attach$2$1"})
    static final class h extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ n Izt;
        final /* synthetic */ MutableContextWrapper Izu;
        final /* synthetic */ a Izv;
        final /* synthetic */ ViewGroup Izw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(n nVar, MutableContextWrapper mutableContextWrapper, a aVar, ViewGroup viewGroup) {
            super(0);
            this.Izt = nVar;
            this.Izu = mutableContextWrapper;
            this.Izv = aVar;
            this.Izw = viewGroup;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(224579);
            this.Izu.setBaseContext(this.Izw.getContext());
            ViewParent parent = this.Izt.MQ().getParent();
            if (!(parent instanceof ViewGroup)) {
                parent = null;
            }
            ViewGroup viewGroup = (ViewGroup) parent;
            if (viewGroup != null) {
                viewGroup.removeView(this.Izt.MQ());
            }
            this.Izw.addView(this.Izt.MQ());
            a.a(this.Izv, this.Izt.MQ());
            x xVar = x.SXb;
            AppMethodBeat.o(224579);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "kotlin.jvm.PlatformType", "onReceiveValue"})
    static final class i<T> implements ValueCallback<String> {
        final /* synthetic */ n Izt;

        i(n nVar) {
            this.Izt = nVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.webkit.ValueCallback
        public final /* synthetic */ void onReceiveValue(String str) {
            AppMethodBeat.i(224581);
            com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.plugin.webcanvas.a.i.AnonymousClass1 */
                final /* synthetic */ i Izx;

                {
                    this.Izx = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(224580);
                    this.Izx.Izt.MQ().destroy();
                    x xVar = x.SXb;
                    AppMethodBeat.o(224580);
                    return xVar;
                }
            });
            AppMethodBeat.o(224581);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class d extends q implements kotlin.g.a.a<Boolean> {
        public static final d Izo = new d();

        static {
            AppMethodBeat.i(224559);
            AppMethodBeat.o(224559);
        }

        d() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            boolean z;
            AppMethodBeat.i(224558);
            if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_open_timeline_video_preview, 0) == 1) {
                z = true;
            } else {
                z = false;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(224558);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "invoke"})
    static final class b extends q implements kotlin.g.a.a<MMKVSlotManager> {
        public static final b Izm = new b();

        static {
            AppMethodBeat.i(224555);
            AppMethodBeat.o(224555);
        }

        b() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ MMKVSlotManager invoke() {
            AppMethodBeat.i(224554);
            MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("__webcanvans__");
            p.g(mmkv, "MultiProcessMMKV.getMMKV(\"__webcanvans__\")");
            MMKVSlotManager mMKVSlotManager = new MMKVSlotManager(mmkv, 259200);
            AppMethodBeat.o(224554);
            return mMKVSlotManager;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends q implements kotlin.g.a.a<Boolean> {
        public static final c Izn = new c();

        static {
            AppMethodBeat.i(224557);
            AppMethodBeat.o(224557);
        }

        c() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            boolean z;
            AppMethodBeat.i(224556);
            if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_open_web_canvas_pause_on_no_view_attach, 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(224556);
            return valueOf;
        }
    }

    @Override // com.tencent.mm.plugin.ab.g
    public final int getFps() {
        AppMethodBeat.i(224592);
        int i2 = (int) fWk().pqH.QP().cKu;
        AppMethodBeat.o(224592);
        return i2;
    }

    @Override // com.tencent.mm.plugin.ab.g
    public final boolean canVideoAutoPlay() {
        AppMethodBeat.i(224602);
        if (!((Boolean) Izh.getValue()).booleanValue()) {
            AppMethodBeat.o(224602);
            return true;
        }
        Log.i(TAG, "canVideoAutoPlay videoCanAutoPlayNow=" + this.IyZ);
        boolean z = this.IyZ;
        AppMethodBeat.o(224602);
        return z;
    }

    @Override // com.tencent.mm.plugin.webcanvas.j
    public final /* synthetic */ View getView() {
        AppMethodBeat.i(224607);
        MagicBrushView MQ = MQ();
        AppMethodBeat.o(224607);
        return MQ;
    }
}
