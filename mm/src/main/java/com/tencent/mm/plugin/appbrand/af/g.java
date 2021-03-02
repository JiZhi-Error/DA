package com.tencent.mm.plugin.appbrand.af;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class g {
    public static boolean an(AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(49349);
        if (appBrandRuntime != null) {
            boolean equalsIgnoreCase = "wxfe02ecfe70800f46".equalsIgnoreCase(appBrandRuntime.mAppId);
            AppMethodBeat.o(49349);
            return equalsIgnoreCase;
        }
        AppMethodBeat.o(49349);
        return false;
    }

    public static String bZR() {
        return "appbrand0";
    }

    public static void a(AppBrandRuntime appBrandRuntime, ImageView imageView, Runnable runnable) {
        AppMethodBeat.i(227749);
        if (appBrandRuntime.OU() instanceof AppBrandInitConfigLU) {
            AppBrandInitConfigLU appBrandInitConfigLU = (AppBrandInitConfigLU) appBrandRuntime.OU();
            String str = appBrandInitConfigLU.cyt.thumbUrl;
            String str2 = appBrandInitConfigLU.cyt.leN;
            Log.i("MicroMsg.AppBrandWeishiUtil", "showLaunchThumb, thumbUrl:%s, thumbPath:%s", str, str2);
            if (!Util.isNullOrNil(str)) {
                a(imageView, str, "file://".concat(String.valueOf(str2)), runnable);
                AppMethodBeat.o(227749);
                return;
            } else if (!Util.isNullOrNil(str2)) {
                a(imageView, "file://".concat(String.valueOf(str2)), null, runnable);
            }
        }
        AppMethodBeat.o(227749);
    }

    static void a(final ImageView imageView, String str, final String str2, final Runnable runnable) {
        AppMethodBeat.i(49352);
        Log.i("MicroMsg.AppBrandWeishiUtil", "loadThumbImage:%s", str);
        b.aXY().a(new b.k() {
            /* class com.tencent.mm.plugin.appbrand.af.g.AnonymousClass1 */

            @Override // com.tencent.mm.modelappbrand.a.b.k
            public final void aYg() {
            }

            @Override // com.tencent.mm.modelappbrand.a.b.k
            public final void I(Bitmap bitmap) {
                AppMethodBeat.i(49346);
                Log.i("MicroMsg.AppBrandWeishiUtil", "thumb loaded");
                ImageView imageView = imageView;
                if (!(imageView == null || bitmap == null || bitmap.isRecycled())) {
                    imageView.setImageBitmap(bitmap);
                }
                if (runnable != null) {
                    runnable.run();
                }
                AppMethodBeat.o(49346);
            }

            @Override // com.tencent.mm.modelappbrand.a.b.k
            public final void oD() {
                AppMethodBeat.i(49347);
                Log.e("MicroMsg.AppBrandWeishiUtil", "thumb loaded fail");
                if (str2 != null) {
                    g.a(imageView, str2, null, runnable);
                }
                AppMethodBeat.o(49347);
            }

            @Override // com.tencent.mm.modelappbrand.a.b.k, com.tencent.mm.modelappbrand.a.c
            public final String Lb() {
                return "AppBrandWeishiUtil#THUMB";
            }
        }, str, (b.h) null, (b.f) null);
        AppMethodBeat.o(49352);
    }

    public static void bZS() {
        AppMethodBeat.i(49353);
        Log.d("MicroMsg.AppBrandWeishiUtil", "sendEventAppBrandWeishiUIReady");
        if (MMApplicationContext.isMMProcess()) {
            bZT();
            AppMethodBeat.o(49353);
            return;
        }
        XIPCInvoker.a(MainProcessIPCService.dkO, new IPCString("wxfe02ecfe70800f46"), a.class, new d<IPCVoid>() {
            /* class com.tencent.mm.plugin.appbrand.af.g.AnonymousClass2 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.ipcinvoker.d
            public final /* bridge */ /* synthetic */ void bn(IPCVoid iPCVoid) {
            }
        });
        AppMethodBeat.o(49353);
    }

    static class a implements com.tencent.mm.ipcinvoker.b<IPCString, IPCVoid> {
        private a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(IPCString iPCString, d<IPCVoid> dVar) {
            AppMethodBeat.i(49348);
            IPCString iPCString2 = iPCString;
            if (iPCString2 != null && !Util.isNullOrNil(iPCString2.value)) {
                g.bZT();
            }
            AppMethodBeat.o(49348);
        }
    }

    static void bZT() {
        AppMethodBeat.i(49354);
        EventCenter.instance.publish(new f());
        AppMethodBeat.o(49354);
    }

    public static boolean afU(String str) {
        AppMethodBeat.i(261638);
        boolean equalsIgnoreCase = "wxfe02ecfe70800f46".equalsIgnoreCase(str);
        AppMethodBeat.o(261638);
        return equalsIgnoreCase;
    }
}
