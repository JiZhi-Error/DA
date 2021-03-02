package com.tencent.mm.plugin.appbrand.jsapi.ag.b;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.h;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.appbrand.ac.l;
import com.tencent.mm.plugin.appbrand.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.ag.b.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.ag.b.b.e;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.m;
import com.tencent.mm.plugin.appbrand.m.q;
import com.tencent.mm.plugin.appbrand.m.v;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.xweb.skia_canvas.IXWebLibraryLoader;
import com.tencent.xweb.skia_canvas.IXWebWorkingHandler;
import com.tencent.xweb.skia_canvas.SkiaCanvasApp;
import com.tencent.xweb.skia_canvas.XWebLibraryLoader;
import com.tencent.xweb.skia_canvas.resource_loader.SkiaCanvasResourceLoader;
import java.util.ArrayList;
import java.util.List;

public final class d {
    private static boolean mJx = false;
    private static SparseArray<SkiaCanvasApp> mJy = new SparseArray<>();

    static /* synthetic */ void b(int i2, SkiaCanvasApp skiaCanvasApp) {
        AppMethodBeat.i(215827);
        a(i2, skiaCanvasApp);
        AppMethodBeat.o(215827);
    }

    static {
        AppMethodBeat.i(215828);
        AppMethodBeat.o(215828);
    }

    private static void bMb() {
        AppMethodBeat.i(178852);
        if (!mJx) {
            h.class.getClassLoader();
            j.Ed("c++_shared");
            XWebLibraryLoader.initXWebLibraryLoader(new IXWebLibraryLoader() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.ag.b.d.AnonymousClass1 */

                @Override // com.tencent.xweb.skia_canvas.IXWebLibraryLoader
                public final boolean beforeLoad() {
                    return false;
                }

                @Override // com.tencent.xweb.skia_canvas.IXWebLibraryLoader
                public final boolean load(String str) {
                    AppMethodBeat.i(139445);
                    Log.i("Luggage.XWebCanvasLogic", "load %s", str);
                    try {
                        h.class.getClassLoader();
                        j.Ed(str);
                        AppMethodBeat.o(139445);
                        return true;
                    } catch (Throwable th) {
                        Log.e("Luggage.XWebCanvasLogic", "load %s fail, %s", str, th);
                        AppMethodBeat.o(139445);
                        return false;
                    }
                }

                @Override // com.tencent.xweb.skia_canvas.IXWebLibraryLoader
                public final boolean afterLoad() {
                    AppMethodBeat.i(139446);
                    h.class.getClassLoader();
                    j.Ed("skia-canvas-log-bridge");
                    AppMethodBeat.o(139446);
                    return true;
                }
            });
            mJx = true;
        }
        AppMethodBeat.o(178852);
    }

    public static void a(final b bVar, final com.tencent.mm.plugin.appbrand.f.a aVar, final s sVar) {
        AppMethodBeat.i(139447);
        bMb();
        i jsRuntime = sVar.getJsRuntime();
        if (jsRuntime != null) {
            q qVar = (q) jsRuntime.R(q.class);
            if (qVar != null) {
                qVar.post(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.ag.b.d.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(215817);
                        Log.i("Luggage.XWebCanvasLogic", "init resource loader");
                        SkiaCanvasResourceLoader.setDelegate(new c(bVar, aVar, sVar));
                        AppMethodBeat.o(215817);
                    }
                });
                AppMethodBeat.o(139447);
                return;
            }
            Log.e("Luggage.XWebCanvasLogic", "jsThreadAddon is null, fail");
        }
        AppMethodBeat.o(139447);
    }

    /* access modifiers changed from: package-private */
    public static class a extends l implements m.a {
        a(Runnable runnable) {
            super(runnable);
        }

        @Override // com.tencent.mm.plugin.appbrand.m.m.a
        public final void onDestroy() {
            AppMethodBeat.i(215822);
            run();
            AppMethodBeat.o(215822);
        }
    }

    public static void a(final i iVar, final s sVar) {
        AppMethodBeat.i(215823);
        bMb();
        final q qVar = (q) iVar.R(q.class);
        if (qVar != null) {
            qVar.post(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.ag.b.d.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(215820);
                    if (iVar == null) {
                        Log.e("Luggage.XWebCanvasLogic", "postCreateJsRuntime, try init xweb canvas, but jsRuntime is null");
                        AppMethodBeat.o(215820);
                        return;
                    }
                    v vVar = (v) iVar.R(v.class);
                    int hashCode = sVar.hashCode();
                    d.b(hashCode, new SkiaCanvasApp(vVar.getIsolatePtr(), vVar.XK(), new IXWebWorkingHandler() {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.ag.b.d.AnonymousClass3.AnonymousClass1 */

                        @Override // com.tencent.xweb.skia_canvas.IXWebWorkingHandler
                        public final void post(Runnable runnable) {
                            AppMethodBeat.i(215818);
                            if (qVar == null) {
                                Log.e("Luggage.XWebCanvasLogic", "jsThreadAddon is null, error");
                                AppMethodBeat.o(215818);
                            } else if (qVar.LO()) {
                                runnable.run();
                                AppMethodBeat.o(215818);
                            } else {
                                qVar.post(runnable);
                                AppMethodBeat.o(215818);
                            }
                        }

                        @Override // com.tencent.xweb.skia_canvas.IXWebWorkingHandler
                        public final boolean isRunOnWorkingThread() {
                            AppMethodBeat.i(215819);
                            boolean LO = qVar.LO();
                            AppMethodBeat.o(215819);
                            return LO;
                        }
                    }));
                    Log.i("Luggage.XWebCanvasLogic", "init id:%s %s", Integer.valueOf(hashCode), d.xT(hashCode));
                    AppMethodBeat.o(215820);
                }
            });
            m mVar = (m) iVar.R(m.class);
            if (mVar != null) {
                mVar.a(new a(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.ag.b.d.AnonymousClass4 */

                    public final void run() {
                        AppMethodBeat.i(215821);
                        int hashCode = sVar.hashCode();
                        SkiaCanvasApp skiaCanvasApp = (SkiaCanvasApp) d.mJy.get(hashCode);
                        d.mJy.remove(hashCode);
                        Log.i("Luggage.XWebCanvasLogic", "id:%s onJSContextDestroying %s", Integer.valueOf(hashCode), skiaCanvasApp);
                        skiaCanvasApp.onJSContextDestroying();
                        AppMethodBeat.o(215821);
                    }
                }));
                AppMethodBeat.o(215823);
                return;
            }
            Log.e("Luggage.XWebCanvasLogic", "addonDestroyListener is null, fail");
        }
        AppMethodBeat.o(215823);
    }

    public static SkiaCanvasApp G(f fVar) {
        AppMethodBeat.i(215824);
        SkiaCanvasApp skiaCanvasApp = null;
        int i2 = -1;
        if (fVar instanceof s) {
            i2 = fVar.hashCode();
            skiaCanvasApp = xT(i2);
        } else if (fVar instanceof ac) {
            i2 = ((ac) fVar).NY().hashCode();
            skiaCanvasApp = xT(i2);
        }
        if (skiaCanvasApp == null) {
            Log.e("Luggage.XWebCanvasLogic", "id:%d app is null, err", Integer.valueOf(i2));
        }
        AppMethodBeat.o(215824);
        return skiaCanvasApp;
    }

    private static synchronized void a(int i2, SkiaCanvasApp skiaCanvasApp) {
        synchronized (d.class) {
            AppMethodBeat.i(215825);
            mJy.put(i2, skiaCanvasApp);
            AppMethodBeat.o(215825);
        }
    }

    public static synchronized SkiaCanvasApp xT(int i2) {
        SkiaCanvasApp skiaCanvasApp;
        synchronized (d.class) {
            AppMethodBeat.i(215826);
            skiaCanvasApp = mJy.get(i2);
            AppMethodBeat.o(215826);
        }
        return skiaCanvasApp;
    }

    public static String bMc() {
        AppMethodBeat.i(177201);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(com.tencent.mm.plugin.appbrand.ac.d.afA("wxa_library/js_binding_skia.js"));
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(177201);
        return stringBuffer2;
    }

    public static void release() {
        AppMethodBeat.i(139448);
        AppMethodBeat.o(139448);
    }

    public static List<p> hU(boolean z) {
        AppMethodBeat.i(139449);
        Log.i("Luggage.XWebCanvasLogic", "createCavnasJsApis useCoverView:%b", Boolean.valueOf(z));
        ArrayList arrayList = new ArrayList();
        if (z) {
            arrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.ag.b.a.a());
            arrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.ag.b.a.b());
            arrayList.add(new c());
        } else {
            arrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.ag.b.b.b());
            arrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.ag.b.b.d());
            arrayList.add(new e());
        }
        AppMethodBeat.o(139449);
        return arrayList;
    }
}
