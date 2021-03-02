package com.tencent.mm.plugin.appbrand.jsapi.ag.b;

import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.tencent.luggage.xweb_ext.extendplugin.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import com.tencent.mm.plugin.appbrand.jsapi.ag.b.b.d;
import com.tencent.mm.plugin.appbrand.jsapi.ag.b.b.e;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.xweb.skia_canvas.SkiaCanvasView;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a extends com.tencent.luggage.xweb_ext.extendplugin.a.a {
    volatile h mJd;
    SkiaCanvasView mJe;
    C0604a mJf;
    volatile SurfaceTexture mSurfaceTexture = new SurfaceTexture(0);
    int mViewId;

    public a() {
        AppMethodBeat.i(139433);
        Log.i("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "skia version:%s", SkiaCanvasView.version());
        AppMethodBeat.o(139433);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a.b, com.tencent.luggage.xweb_ext.extendplugin.a.a
    public final void e(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(139434);
        super.e(surfaceTexture);
        Log.i("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "handlePluginReady mViewId:%d", Integer.valueOf(this.mViewId));
        this.mSurfaceTexture = surfaceTexture;
        if (this.mJd == null) {
            Log.e("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "mComponent is null, updateSurfaceTextureIfNeed return");
            AppMethodBeat.o(139434);
            return;
        }
        this.mJd.getAsyncHandler().post(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.ag.b.a.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(139418);
                if (a.this.mJe != null) {
                    a.this.mJe.swapSurface(a.this.mSurfaceTexture);
                    if (a.this.mJd == null) {
                        Log.e("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "mComponent is null, onXWebCanvasSurfaceChange return");
                        AppMethodBeat.o(139418);
                        return;
                    }
                    Log.i("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "JsApiOnXWebCanvasSurfaceChange. dispatch ViewId:%d", Integer.valueOf(a.this.mViewId));
                    com.tencent.mm.plugin.appbrand.jsapi.ag.b.b.c.e(a.this.mJd, a.this.mViewId);
                    AppMethodBeat.o(139418);
                    return;
                }
                Log.e("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "mSurfaceTexture is null, return");
                AppMethodBeat.o(139418);
            }
        });
        AppMethodBeat.o(139434);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a.b, com.tencent.luggage.xweb_ext.extendplugin.a.a
    public final void PQ() {
        AppMethodBeat.i(139435);
        super.PQ();
        Log.i("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "handlePluginDestroy mViewId:%d", Integer.valueOf(this.mViewId));
        AppMethodBeat.o(139435);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a.b, com.tencent.luggage.xweb_ext.extendplugin.a.a
    public final String h(final com.tencent.luggage.xweb_ext.extendplugin.a aVar) {
        AppMethodBeat.i(139436);
        Log.v("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "handleJsApi:%s", aVar.Pt());
        if (aVar instanceof com.tencent.mm.plugin.appbrand.h.b) {
            com.tencent.mm.plugin.appbrand.h.b bVar = (com.tencent.mm.plugin.appbrand.h.b) aVar;
            final f fVar = bVar.lqg;
            final p pVar = bVar.lqf;
            final JSONObject jSONObject = bVar.lnV;
            final int i2 = bVar.lqe;
            Log.i("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "*** handler(%s) handleJsApi(%s), data:%s", Lb(), pVar.getName(), jSONObject.toString());
            AnonymousClass2 r0 = new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.ag.b.a.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(139419);
                    if (pVar instanceof com.tencent.mm.plugin.appbrand.jsapi.ag.b.b.b) {
                        aVar.a(new a.AbstractC0188a() {
                            /* class com.tencent.mm.plugin.appbrand.jsapi.ag.b.a.AnonymousClass3 */

                            @Override // com.tencent.luggage.xweb_ext.extendplugin.a.AbstractC0188a
                            public final void onForeground() {
                                AppMethodBeat.i(215803);
                                if (a.this.mJe != null) {
                                    a.this.mJe.notifyVisibilityChanged(true);
                                }
                                AppMethodBeat.o(215803);
                            }

                            @Override // com.tencent.luggage.xweb_ext.extendplugin.a.AbstractC0188a
                            public final void hU(int i2) {
                                AppMethodBeat.i(215804);
                                if (a.this.mJe != null) {
                                    a.this.mJe.notifyVisibilityChanged(false);
                                }
                                AppMethodBeat.o(215804);
                            }

                            @Override // com.tencent.luggage.xweb_ext.extendplugin.a.AbstractC0188a
                            public final void onDestroy() {
                                AppMethodBeat.i(139420);
                                a.this.release();
                                AppMethodBeat.o(139420);
                            }
                        });
                        a aVar = a.this;
                        f fVar = fVar;
                        JSONObject jSONObject = jSONObject;
                        p pVar = pVar;
                        int i2 = i2;
                        aVar.mViewId = jSONObject.optInt("viewId", 0);
                        if (d.G(fVar) == null) {
                            Log.e("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "app is null, fail return");
                            fVar.i(i2, pVar.h("fail", null));
                            AppMethodBeat.o(139419);
                            return;
                        }
                        aVar.mJd = (h) fVar;
                        aVar.mJe = new SkiaCanvasView(d.G(fVar), aVar.mSurfaceTexture, fVar.getAppId(), (long) aVar.mViewId);
                        b.a(aVar.mViewId, aVar.mJe);
                        aVar.mJf = new C0604a(aVar.mJd);
                        aVar.mJf.data = jSONObject.optString("data", "");
                        aVar.mJf.mJo = jSONObject.optBoolean("gesture", false);
                        fVar.i(i2, pVar.h("ok", null));
                        AppMethodBeat.o(139419);
                    } else if (pVar instanceof e) {
                        a aVar2 = a.this;
                        f fVar2 = fVar;
                        p pVar2 = pVar;
                        int i3 = i2;
                        if (aVar2.mJe == null) {
                            Log.e("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "update fail");
                            fVar2.i(i3, pVar2.h("fail:internal error", null));
                            AppMethodBeat.o(139419);
                            return;
                        }
                        fVar2.i(i3, pVar2.h("ok", null));
                        AppMethodBeat.o(139419);
                    } else {
                        if (pVar instanceof d) {
                            a aVar3 = a.this;
                            f fVar3 = fVar;
                            p pVar3 = pVar;
                            int i4 = i2;
                            if (aVar3.mJe == null) {
                                Log.e("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "remove fail");
                                fVar3.i(i4, pVar3.h("fail:internal error", null));
                                AppMethodBeat.o(139419);
                                return;
                            }
                            aVar3.release();
                            fVar3.i(i4, pVar3.h("ok", null));
                        }
                        AppMethodBeat.o(139419);
                    }
                }
            };
            if (fVar.getAsyncHandler().getLooper() == Looper.myLooper()) {
                r0.run();
            } else {
                fVar.getAsyncHandler().post(r0);
            }
        }
        AppMethodBeat.o(139436);
        return null;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a.b, com.tencent.luggage.xweb_ext.extendplugin.a.a
    public final boolean g(com.tencent.luggage.xweb_ext.extendplugin.a aVar) {
        return true;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a.b, com.tencent.luggage.xweb_ext.extendplugin.a.a
    public final void o(MotionEvent motionEvent) {
        AppMethodBeat.i(139439);
        Log.v("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "motionEvent:%s", motionEvent);
        if (this.mJf != null) {
            C0604a aVar = this.mJf;
            switch (motionEvent.getActionMasked()) {
                case 0:
                case 5:
                    aVar.b(C0604a.mJh, C0604a.E(motionEvent));
                    break;
                case 1:
                case 6:
                    aVar.b(C0604a.mJi, C0604a.E(motionEvent));
                    aVar.c(C0604a.mJn, C0604a.E(motionEvent));
                    break;
                case 2:
                    if (System.currentTimeMillis() - aVar.hwQ >= 20) {
                        aVar.hwQ = System.currentTimeMillis();
                        aVar.a(C0604a.mJj, C0604a.F(motionEvent));
                        break;
                    }
                    break;
                case 3:
                    aVar.a(C0604a.mJk, C0604a.F(motionEvent));
                    break;
            }
            GestureDetector gestureDetector = aVar.mDJ;
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, bl.axQ(), "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/canvas/AppBrandCanvasPluginHandler$CanvasTouchEventDispatcher", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
            com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, gestureDetector.onTouchEvent((MotionEvent) bl.pG(0)), "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/canvas/AppBrandCanvasPluginHandler$CanvasTouchEventDispatcher", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        }
        AppMethodBeat.o(139439);
    }

    static class b extends bc {
        private static final int CTRL_INDEX = -2;
        private static final String NAME = "onSkiaCanvasLongPress";

        private b() {
        }

        /* synthetic */ b(byte b2) {
            this();
        }
    }

    static class c extends bc {
        private static final int CTRL_INDEX = -2;
        private static final String NAME = "onSkiaCanvasTouchEnd";

        private c() {
        }

        /* synthetic */ c(byte b2) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.ag.b.a$a  reason: collision with other inner class name */
    static class C0604a {
        static bc mJh = new e.c();
        static bc mJi = new e.C0599e();
        static bc mJj = new e.d();
        static bc mJk = new e.b();
        static bc mJl = new e.a();
        static bc mJm = new b((byte) 0);
        static bc mJn = new c((byte) 0);
        public String data;
        long hwQ = 0;
        GestureDetector mDJ;
        private h mJd;
        public boolean mJo;

        static {
            AppMethodBeat.i(139432);
            AppMethodBeat.o(139432);
        }

        public C0604a(h hVar) {
            AppMethodBeat.i(139422);
            this.mJd = hVar;
            this.mDJ = new GestureDetector(this.mJd.getContext(), new GestureDetector.SimpleOnGestureListener() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.ag.b.a.C0604a.AnonymousClass1 */

                public final boolean onContextClick(MotionEvent motionEvent) {
                    AppMethodBeat.i(215807);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(motionEvent);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/canvas/AppBrandCanvasPluginHandler$CanvasTouchEventDispatcher$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
                    boolean onContextClick = super.onContextClick(motionEvent);
                    com.tencent.mm.hellhoundlib.a.a.a(onContextClick, this, "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/canvas/AppBrandCanvasPluginHandler$CanvasTouchEventDispatcher$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
                    AppMethodBeat.o(215807);
                    return onContextClick;
                }

                public final boolean onDoubleTap(MotionEvent motionEvent) {
                    AppMethodBeat.i(215806);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(motionEvent);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/canvas/AppBrandCanvasPluginHandler$CanvasTouchEventDispatcher$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
                    boolean onDoubleTap = super.onDoubleTap(motionEvent);
                    com.tencent.mm.hellhoundlib.a.a.a(onDoubleTap, this, "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/canvas/AppBrandCanvasPluginHandler$CanvasTouchEventDispatcher$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
                    AppMethodBeat.o(215806);
                    return onDoubleTap;
                }

                public final boolean onSingleTapUp(MotionEvent motionEvent) {
                    AppMethodBeat.i(215805);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(motionEvent);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/canvas/AppBrandCanvasPluginHandler$CanvasTouchEventDispatcher$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
                    boolean onSingleTapUp = super.onSingleTapUp(motionEvent);
                    com.tencent.mm.hellhoundlib.a.a.a(onSingleTapUp, this, "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/canvas/AppBrandCanvasPluginHandler$CanvasTouchEventDispatcher$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
                    AppMethodBeat.o(215805);
                    return onSingleTapUp;
                }

                public final void onLongPress(MotionEvent motionEvent) {
                    AppMethodBeat.i(139421);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(motionEvent);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/canvas/AppBrandCanvasPluginHandler$CanvasTouchEventDispatcher$1", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V", this, bVar.axR());
                    C0604a.a(C0604a.this, motionEvent);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/canvas/AppBrandCanvasPluginHandler$CanvasTouchEventDispatcher$1", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V");
                    AppMethodBeat.o(139421);
                }
            });
            AppMethodBeat.o(139422);
        }

        static JSONObject E(MotionEvent motionEvent) {
            AppMethodBeat.i(139423);
            int actionIndex = motionEvent.getActionIndex();
            int pointerId = motionEvent.getPointerId(actionIndex);
            float x = motionEvent.getX(actionIndex);
            float y = motionEvent.getY(actionIndex);
            e.f fVar = new e.f();
            fVar.b(pointerId, x, y);
            JSONObject jSONObject = fVar.toJSONObject();
            AppMethodBeat.o(139423);
            return jSONObject;
        }

        static JSONArray F(MotionEvent motionEvent) {
            AppMethodBeat.i(139424);
            JSONArray jSONArray = new JSONArray();
            e.f[] z = z(motionEvent);
            if (z.length > 0) {
                for (e.f fVar : z) {
                    jSONArray.put(fVar.toJSONObject());
                }
            }
            AppMethodBeat.o(139424);
            return jSONArray;
        }

        /* access modifiers changed from: package-private */
        public final void b(bc bcVar, JSONObject jSONObject) {
            AppMethodBeat.i(139427);
            HashMap hashMap = new HashMap(1);
            hashMap.put("data", this.data);
            hashMap.put("touch", jSONObject);
            this.mJd.a(bcVar.L(hashMap), (int[]) null);
            AppMethodBeat.o(139427);
        }

        /* access modifiers changed from: package-private */
        public final void c(bc bcVar, JSONObject jSONObject) {
            AppMethodBeat.i(139428);
            HashMap hashMap = new HashMap(1);
            hashMap.put("data", this.data);
            hashMap.put("touch", jSONObject);
            this.mJd.a(bcVar.L(hashMap));
            AppMethodBeat.o(139428);
        }

        /* access modifiers changed from: package-private */
        public final void a(bc bcVar, JSONArray jSONArray) {
            AppMethodBeat.i(139429);
            HashMap hashMap = new HashMap(1);
            hashMap.put("data", this.data);
            hashMap.put("touches", jSONArray);
            this.mJd.a(bcVar.L(hashMap), (int[]) null);
            AppMethodBeat.o(139429);
        }

        private static e.f[] z(MotionEvent motionEvent) {
            AppMethodBeat.i(139430);
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < motionEvent.getPointerCount(); i2++) {
                e.f fVar = new e.f();
                fVar.id = motionEvent.getPointerId(i2);
                fVar.x = motionEvent.getX(i2);
                fVar.y = motionEvent.getY(i2);
                arrayList.add(fVar);
            }
            e.f[] fVarArr = new e.f[arrayList.size()];
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                fVarArr[i3] = (e.f) arrayList.get(i3);
            }
            AppMethodBeat.o(139430);
            return fVarArr;
        }

        static /* synthetic */ void a(C0604a aVar, MotionEvent motionEvent) {
            AppMethodBeat.i(139431);
            aVar.b(mJl, E(motionEvent));
            aVar.c(mJm, E(motionEvent));
            AppMethodBeat.o(139431);
        }
    }

    /* access modifiers changed from: package-private */
    public final void release() {
        AppMethodBeat.i(139440);
        Log.i("MicroMsg.AppBrand.SameLayer.AppBrandCanvasPluginHandler", "release");
        if (this.mJe != null) {
            this.mJe.recycle();
        }
        b.remove(this.mViewId);
        AppMethodBeat.o(139440);
    }
}
