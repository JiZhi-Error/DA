package com.tencent.mm.plugin.webcanvas;

import android.content.Context;
import android.os.Looper;
import android.os.MessageQueue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import com.tencent.f.h;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.ab.c;
import com.tencent.mm.plugin.ab.f;
import com.tencent.mm.plugin.ac.c;
import com.tencent.mm.plugin.appbrand.m.g;
import com.tencent.mm.plugin.webcanvas.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMSlotKt;
import java.lang.reflect.Method;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010 \u001a\u00020!R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8BX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00158BX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u001d8BX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006\""}, hxF = {"Lcom/tencent/mm/plugin/webcanvas/WebCanvasViewContext;", "", "canvasContext", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasContext;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/webcanvas/WebCanvasContext;Landroid/content/Context;)V", "TAG", "", "getCanvasContext", "()Lcom/tencent/mm/plugin/webcanvas/WebCanvasContext;", "canvasId", "getCanvasId", "()Ljava/lang/String;", "contextId", "", "getContextId", "()I", "elementId", "getElementId", "logicJsEngine", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasJsEngine;", "getLogicJsEngine", "()Lcom/tencent/mm/plugin/webcanvas/WebCanvasJsEngine;", "magicBrushView", "Lcom/tencent/magicbrush/ui/MagicBrushView;", "getMagicBrushView", "()Lcom/tencent/magicbrush/ui/MagicBrushView;", "renderJsEngine", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasRenderJsEngine;", "getRenderJsEngine", "()Lcom/tencent/mm/plugin/webcanvas/WebCanvasRenderJsEngine;", "config", "", "webview-sdk_release"})
public final class n {
    final int IAR;
    final a IAS;
    final String TAG = "MicroMsg.WebCanvasViewContext";
    final int biJ;

    public n(a aVar, Context context) {
        p.h(aVar, "canvasContext");
        p.h(context, "context");
        AppMethodBeat.i(224770);
        this.IAS = aVar;
        g bME = this.IAS.fWk().bME();
        f fVar = new f(this.IAS);
        p.g(bME, "this");
        fVar.f(bME);
        p.g(bME, "canvasContext.renderJsEn…ntext).attach(this)\n    }");
        this.IAR = bME.bMC();
        MagicBrushView magicBrushView = new MagicBrushView(context, MagicBrushView.h.TextureView);
        String str = "#" + this.IAS.lAN + ':' + this.IAR + '@' + magicBrushView.getVirtualElementId();
        k fWk = this.IAS.fWk();
        fWk.fWD();
        magicBrushView.setMagicBrush(fWk.pqH);
        Log.i(this.TAG, "createCanvasView:".concat(String.valueOf(str)));
        magicBrushView.setOpaque(false);
        magicBrushView.setClipChildren(false);
        magicBrushView.setClipToPadding(false);
        magicBrushView.setEnableTouchEvent(false);
        magicBrushView.setOnTouchListener(new a(this));
        z.a aVar2 = new z.a();
        aVar2.SYB = false;
        z.a aVar3 = new z.a();
        aVar3.SYB = false;
        magicBrushView.addOnAttachStateChangeListener(new b(magicBrushView, str, aVar2, aVar3, this));
        magicBrushView.a(new c(aVar2, str, aVar3, this));
        this.biJ = magicBrushView.getVirtualElementId();
        AppMethodBeat.o(224770);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch", "com/tencent/mm/plugin/webcanvas/WebCanvasViewContext$elementId$1$2"})
    static final class a implements View.OnTouchListener {
        final /* synthetic */ n IAT;

        a(n nVar) {
            this.IAT = nVar;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            String str;
            AppMethodBeat.i(224759);
            c fWl = this.IAT.IAS.fWl();
            String str2 = this.IAT.IAS.lAN;
            p.g(motionEvent, "event");
            p.h(str2, "canvasId");
            p.h(motionEvent, "touch");
            switch (motionEvent.getAction()) {
                case 0:
                    str = "touchstart";
                    break;
                case 1:
                    str = "touchend";
                    break;
                case 2:
                    str = "touchmove";
                    break;
                case 3:
                    str = "touchcancel";
                    break;
                default:
                    str = null;
                    break;
            }
            if (str != null) {
                StringBuilder append = new StringBuilder("\n                {\n                    target:\"").append(str2).append("\",\n                    touches: [{\n                        identifier:").append(motionEvent.getPointerId(motionEvent.getActionIndex())).append(",\n                        clientX:");
                f.a aVar = f.IBd;
                StringBuilder append2 = append.append(f.a.d(Float.valueOf(motionEvent.getX()))).append(",\n                        clientY:");
                f.a aVar2 = f.IBd;
                c.a.a(fWl, str, kotlin.n.n.buv(append2.append(f.a.d(Float.valueOf(motionEvent.getY()))).append("\n                    }]\n                }\n            ").toString()), null, 4);
            }
            AppMethodBeat.o(224759);
            return true;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/webcanvas/WebCanvasViewContext$elementId$1$3", "Landroid/view/View$OnAttachStateChangeListener;", "onViewAttachedToWindow", "", "v", "Landroid/view/View;", "onViewDetachedFromWindow", "webview-sdk_release"})
    public static final class b implements View.OnAttachStateChangeListener {
        final /* synthetic */ n IAT;
        final /* synthetic */ MagicBrushView IAU;
        final /* synthetic */ z.a IAV;
        final /* synthetic */ z.a IAW;
        final /* synthetic */ String pAl;

        b(MagicBrushView magicBrushView, String str, z.a aVar, z.a aVar2, n nVar) {
            this.IAU = magicBrushView;
            this.pAl = str;
            this.IAV = aVar;
            this.IAW = aVar2;
            this.IAT = nVar;
        }

        public final void onViewAttachedToWindow(View view) {
            Object invoke;
            AppMethodBeat.i(224762);
            a.C1932a aVar = a.Izl;
            if (a.C1932a.fWu()) {
                a.C1932a aVar2 = a.Izl;
                int i2 = a.Izk;
                a.Izk = i2 + 1;
                if (i2 == 0) {
                    this.IAT.IAS.fWk().fWD();
                }
            }
            c fWl = this.IAT.IAS.fWl();
            String str = this.IAT.IAS.lAN;
            p.h(str, "canvasId");
            c.a(fWl, "attach", str);
            this.IAT.IAS.fWk().aWA(this.IAT.IAS.lAN);
            a aVar3 = this.IAT.IAS;
            synchronized (aVar3) {
                try {
                    if (aVar3.Iza != null) {
                        Log.e(a.TAG, "barrier exists");
                    } else {
                        h.RTc.a(new a.k(aVar3), 100, a.TAG);
                        if (a.fWn()) {
                            Method method = MessageQueue.class.getMethod("postSyncBarrier", new Class[0]);
                            Looper mainLooper = Looper.getMainLooper();
                            p.g(mainLooper, "Looper.getMainLooper()");
                            invoke = method.invoke(mainLooper.getQueue(), new Object[0]);
                        } else {
                            invoke = Looper.class.getMethod("postSyncBarrier", new Class[0]).invoke(Looper.getMainLooper(), new Object[0]);
                        }
                        Log.d(a.TAG, "postSyncBarrier " + aVar3.lAN + " token:" + invoke);
                        if (invoke == null) {
                            t tVar = new t("null cannot be cast to non-null type kotlin.Int");
                            AppMethodBeat.o(224762);
                            throw tVar;
                        }
                        aVar3.Iza = new a.g(((Integer) invoke).intValue(), MMSlotKt.now());
                        x xVar = x.SXb;
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(224762);
                    throw th;
                }
            }
            this.IAU.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(this) {
                /* class com.tencent.mm.plugin.webcanvas.n.b.AnonymousClass1 */
                final /* synthetic */ b IAX;

                {
                    this.IAX = r1;
                }

                public final void onGlobalLayout() {
                    AppMethodBeat.i(224761);
                    this.IAX.IAU.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    Log.d(this.IAX.IAT.TAG, "onAttachedToWindow:" + this.IAX.pAl + " height= " + this.IAX.IAU.getHeight());
                    if (!this.IAX.IAV.SYB && !this.IAX.IAW.SYB) {
                        l lVar = l.IAx;
                        l.LV(111);
                        d.a(1000, new kotlin.g.a.a<x>(this) {
                            /* class com.tencent.mm.plugin.webcanvas.n.b.AnonymousClass1.AnonymousClass1 */
                            final /* synthetic */ AnonymousClass1 IAY;

                            {
                                this.IAY = r2;
                            }

                            /* Return type fixed from 'java.lang.Object' to match base method */
                            @Override // kotlin.g.a.a
                            public final /* synthetic */ x invoke() {
                                AppMethodBeat.i(224760);
                                if (!this.IAY.IAX.IAV.SYB && !this.IAY.IAX.IAW.SYB) {
                                    l lVar = l.IAx;
                                    l.LV(112);
                                    Log.i(this.IAY.IAX.IAT.TAG, "onAttachedToWindow:" + this.IAY.IAX.pAl + " has not surfaceAvailable");
                                }
                                x xVar = x.SXb;
                                AppMethodBeat.o(224760);
                                return xVar;
                            }
                        });
                    }
                    if (this.IAX.IAU.getHeight() == 0) {
                        Log.i(this.IAX.IAT.TAG, "reflow:" + this.IAX.pAl + " when height == 0");
                        this.IAX.IAT.IAS.fWk().aWB(this.IAX.IAT.IAS.lAN);
                        l lVar2 = l.IAx;
                        l.LV(113);
                    }
                    AppMethodBeat.o(224761);
                }
            });
            AppMethodBeat.o(224762);
        }

        public final void onViewDetachedFromWindow(View view) {
            AppMethodBeat.i(224763);
            this.IAT.IAS.fWo();
            c fWl = this.IAT.IAS.fWl();
            String str = this.IAT.IAS.lAN;
            p.h(str, "canvasId");
            c.a(fWl, "detach", str);
            k.a(this.IAT.IAS.fWk(), this.IAT.IAS.lAN);
            this.IAW.SYB = true;
            a.C1932a aVar = a.Izl;
            if (a.C1932a.fWu()) {
                a.C1932a aVar2 = a.Izl;
                a.Izk = a.Izk - 1;
                if (a.Izk == 0) {
                    this.IAT.IAS.fWk().fWE();
                }
            }
            AppMethodBeat.o(224763);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\nH\u0016¨\u0006\r¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/webcanvas/WebCanvasViewContext$elementId$1$4", "Lcom/tencent/magicbrush/ui/MagicBrushView$MBSurfaceListener;", "onSurfaceAvailable", "", "surface", "", "width", "", "height", "canReadPixelsFromJava", "", "onSurfaceDestroyed", "syncDestroy", "webview-sdk_release"})
    public static final class c implements MagicBrushView.c {
        final /* synthetic */ n IAT;
        final /* synthetic */ z.a IAV;
        final /* synthetic */ z.a IAW;
        final /* synthetic */ String pAl;

        c(z.a aVar, String str, z.a aVar2, n nVar) {
            this.IAV = aVar;
            this.pAl = str;
            this.IAW = aVar2;
            this.IAT = nVar;
        }

        @Override // com.tencent.magicbrush.ui.MagicBrushView.c
        public final void c(Object obj, int i2, int i3) {
            AppMethodBeat.i(224767);
            p.h(obj, "surface");
            p.h(obj, "surface");
            AppMethodBeat.o(224767);
        }

        /* JADX WARNING: Removed duplicated region for block: B:26:0x012c  */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x0137  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x013a  */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x0182  */
        @Override // com.tencent.magicbrush.ui.MagicBrushView.c
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(java.lang.Object r10, int r11, int r12, boolean r13) {
            /*
            // Method dump skipped, instructions count: 411
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webcanvas.n.c.a(java.lang.Object, int, int, boolean):void");
        }

        @Override // com.tencent.magicbrush.ui.MagicBrushView.c
        public final void a(Object obj, boolean z) {
            AppMethodBeat.i(224766);
            p.h(obj, "surface");
            Log.d(this.IAT.TAG, "onSurfaceDestroyed:" + this.pAl);
            this.IAT.IAS.fWk().IAp.add(this.IAT.IAS.lAN);
            this.IAW.SYB = true;
            AppMethodBeat.o(224766);
        }
    }

    public final MagicBrushView MQ() {
        AppMethodBeat.i(224769);
        MagicBrushView find = this.IAS.fWk().pqH.cLz.find(this.biJ);
        AppMethodBeat.o(224769);
        return find;
    }

    public final void cYb() {
        AppMethodBeat.i(224768);
        k fWk = this.IAS.fWk();
        g xX = this.IAS.fWk().xX(this.IAR);
        p.g(xX, "renderJsEngine.getJsContext(contextId)");
        com.tencent.mm.plugin.ac.c.a(fWk, xX, "CanvasRender#" + this.IAS.lAN, (String) null, (kotlin.g.a.b) null, (c.a) null, 28);
        AppMethodBeat.o(224768);
    }
}
