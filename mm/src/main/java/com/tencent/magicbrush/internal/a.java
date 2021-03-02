package com.tencent.magicbrush.internal;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Point;
import com.github.henryye.nativeiv.BaseImageDecodeService;
import com.github.henryye.nativeiv.api.IImageDecodeService;
import com.tencent.magicbrush.a.c;
import com.tencent.magicbrush.f;
import com.tencent.magicbrush.g;
import com.tencent.magicbrush.handler.fs.IMBFileSystem;
import com.tencent.magicbrush.handler.glfont.i;
import com.tencent.magicbrush.utils.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\f\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0000\u001a\f\u0010\u0007\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\b\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\t\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\n"}, hxF = {"logIfVerbose", "", "Lcom/tencent/magicbrush/MagicBrushBuilder;", "message", "", "processAndAbortIfNeeded", "", "processAssetManagerOrThrow", "processDprWidthHeightOrThrow", "processImageHandler", "lib-magicbrush-nano_release"})
public final class a {
    public static final boolean d(f fVar) {
        boolean z;
        AssetManager assetManager;
        AppMethodBeat.i(140202);
        p.h(fVar, "$this$processAndAbortIfNeeded");
        try {
            double Rr = (double) fVar.Rr();
            if (Rr < 0.0d || Rr > 1.0d) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                IllegalStateException illegalStateException = new IllegalStateException(("GcFactor must in [0, 1], but " + fVar.Rr()).toString());
                AppMethodBeat.o(140202);
                throw illegalStateException;
            } else if (fVar.context == null) {
                IllegalStateException illegalStateException2 = new IllegalStateException("AndroidContext invalid.".toString());
                AppMethodBeat.o(140202);
                throw illegalStateException2;
            } else if (fVar.cLJ == null) {
                IllegalStateException illegalStateException3 = new IllegalStateException("JsThreadHandler invalid.".toString());
                AppMethodBeat.o(140202);
                throw illegalStateException3;
            } else if (fVar.cLK == null) {
                IllegalStateException illegalStateException4 = new IllegalStateException("v8RawPointer invalid. Please define which JsEngine magicbrush should use.".toString());
                AppMethodBeat.o(140202);
                throw illegalStateException4;
            } else {
                p.h(fVar, "$this$processAssetManagerOrThrow");
                if (fVar.Rp() == null) {
                    Context context = fVar.context;
                    if (context != null) {
                        assetManager = context.getAssets();
                    } else {
                        assetManager = null;
                    }
                    fVar.cLP.a(g.cLI[4], assetManager);
                }
                if (fVar.Rp() == null) {
                    IllegalStateException illegalStateException5 = new IllegalStateException("AssetManager invalid. Either assetManager or context should be provided.".toString());
                    AppMethodBeat.o(140202);
                    throw illegalStateException5;
                }
                p.h(fVar, "$this$processDprWidthHeightOrThrow");
                if (fVar.getDevicePixelRatio() <= 0.0f && fVar.context != null) {
                    Context context2 = fVar.context;
                    if (context2 == null) {
                        p.hyc();
                    }
                    fVar.ae(b.getDensity(context2));
                }
                C0199a aVar = new C0199a(fVar);
                if (!((Boolean) aVar.invoke()).booleanValue()) {
                    if (fVar.context == null) {
                        IllegalStateException illegalStateException6 = new IllegalStateException(("w/h invalid. context invalid. " + fVar.Rn() + '/' + fVar.Ro()).toString());
                        AppMethodBeat.o(140202);
                        throw illegalStateException6;
                    } else if (fVar.context != null) {
                        Context context3 = fVar.context;
                        if (context3 == null) {
                            p.hyc();
                        }
                        Point aV = b.aV(context3);
                        p.g(aV, "DisplayUtil.getDisplayLogicSize(context!!)");
                        fVar.cLM.a(g.cLI[1], Integer.valueOf(aV.x));
                        fVar.cLN.a(g.cLI[2], Integer.valueOf(aV.y));
                        a(fVar, "w/h invalid, use context automatically. " + fVar.Rn() + '/' + fVar.Ro());
                    }
                }
                if (!((Boolean) aVar.invoke()).booleanValue()) {
                    IllegalStateException illegalStateException7 = new IllegalStateException(("dpr/w/h invalid. " + fVar.getDevicePixelRatio() + '/' + fVar.Rn() + '/' + fVar.Ro()).toString());
                    AppMethodBeat.o(140202);
                    throw illegalStateException7;
                }
                if (((IMBFileSystem) fVar.cLO.a(g.cLI[3])) == null) {
                    a(fVar, "FileSystem invalid, BindingFileSystem can not use. BE CAUTIOUS!");
                    x xVar = x.SXb;
                }
                c(fVar);
                if (fVar.cLR == null) {
                    fVar.cLR = new i();
                }
                AppMethodBeat.o(140202);
                return true;
            }
        } catch (Exception e2) {
            if (fVar.cMd) {
                Exception exc = e2;
                AppMethodBeat.o(140202);
                throw exc;
            }
            AppMethodBeat.o(140202);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.magicbrush.internal.a$a  reason: collision with other inner class name */
    public static final class C0199a extends q implements kotlin.g.a.a<Boolean> {
        final /* synthetic */ f cOu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0199a(f fVar) {
            super(0);
            this.cOu = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            AppMethodBeat.i(140199);
            Boolean valueOf = Boolean.valueOf(this.cOu.Rn() > 0 && this.cOu.Ro() > 0);
            AppMethodBeat.o(140199);
            return valueOf;
        }
    }

    private static void a(f fVar, String str) {
        AppMethodBeat.i(140200);
        p.h(fVar, "$this$logIfVerbose");
        p.h(str, "message");
        if (fVar.cMe) {
            c.C0193c.i("MagicBrush", str, new Object[0]);
        }
        AppMethodBeat.o(140200);
    }

    private static void c(f fVar) {
        AppMethodBeat.i(140201);
        p.h(fVar, "$this$processImageHandler");
        if (!fVar.cLQ.cMt) {
            if (fVar.cLQ.cMx == null) {
                a(fVar, "ImageHandler invalid, BindingImage can not use. BE CAUTIOUS!");
                x xVar = x.SXb;
            }
            AppMethodBeat.o(140201);
            return;
        }
        BaseImageDecodeService baseImageDecodeService = new BaseImageDecodeService();
        baseImageDecodeService.addImageStreamFetcher(new com.tencent.magicbrush.b.b(), false);
        List<com.github.henryye.nativeiv.b.b> list = fVar.cLQ.cMu;
        int i2 = 0;
        for (T t : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                j.hxH();
            }
            baseImageDecodeService.addImageStreamFetcher(t, i2 == list.size() - 1);
            i2 = i3;
        }
        if (fVar.cLQ.cMv != null) {
            baseImageDecodeService.setKvReportDelegate(fVar.cLQ.cMv);
        }
        if (fVar.cLQ.cMw != null) {
            IImageDecodeService.a aVar = fVar.cLQ.cMw;
            if (aVar == null) {
                p.hyc();
            }
            baseImageDecodeService.setBitmapDecodeSlave(aVar);
        }
        fVar.cLQ.cMx = baseImageDecodeService;
        AppMethodBeat.o(140201);
    }
}
