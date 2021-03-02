package com.tencent.wxa;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.wxa.b.b;
import com.tencent.wxa.c.a;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.android.d;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.view.FlutterMain;
import java.util.HashSet;

public class c {
    private static c SxD;
    public a SxE;
    public io.flutter.embedding.engine.a SxF;
    public b SxG;
    private FlutterView SxH;

    public static c hrH() {
        AppMethodBeat.i(206291);
        if (SxD == null) {
            synchronized (c.class) {
                try {
                    SxD = new c();
                } catch (Throwable th) {
                    AppMethodBeat.o(206291);
                    throw th;
                }
            }
        }
        c cVar = SxD;
        AppMethodBeat.o(206291);
        return cVar;
    }

    public final void a(a aVar) {
        this.SxE = aVar;
    }

    public final void init() {
        AppMethodBeat.i(206292);
        PP();
        initFlutter();
        hrI();
        AppMethodBeat.o(206292);
    }

    public final void a(FlutterView flutterView, io.flutter.embedding.engine.a aVar) {
        AppMethodBeat.i(206293);
        if (flutterView == this.SxH) {
            AppMethodBeat.o(206293);
            return;
        }
        if (this.SxH != null) {
            this.SxH.hwy();
        }
        if (flutterView != null) {
            flutterView.d(aVar);
        }
        this.SxH = flutterView;
        AppMethodBeat.o(206293);
    }

    public final void a(FlutterView flutterView) {
        AppMethodBeat.i(206294);
        if (flutterView == null) {
            AppMethodBeat.o(206294);
        } else if (flutterView != this.SxH) {
            AppMethodBeat.o(206294);
        } else {
            try {
                flutterView.hwy();
            } catch (Exception e2) {
                a.e("WxaRouter.WxaRouter", "detachViewFromFlutterEngine fail %s", e2.toString());
            }
            this.SxH = null;
            AppMethodBeat.o(206294);
        }
    }

    public final void b(FlutterView flutterView) {
        AppMethodBeat.i(206295);
        if (flutterView != this.SxH) {
            AppMethodBeat.o(206295);
            return;
        }
        this.SxF.SNZ.hxd();
        AppMethodBeat.o(206295);
    }

    public final void c(FlutterView flutterView) {
        AppMethodBeat.i(206296);
        if (flutterView != this.SxH) {
            AppMethodBeat.o(206296);
            return;
        }
        this.SxF.SNZ.hxe();
        AppMethodBeat.o(206296);
    }

    private void PP() {
        AppMethodBeat.i(206297);
        if (this.SxE.SxO != null) {
            a.b(this.SxE.SxO);
        }
        AppMethodBeat.o(206297);
    }

    private void initFlutter() {
        AppMethodBeat.i(206298);
        if (this.SxF != null) {
            AppMethodBeat.o(206298);
            return;
        }
        io.flutter.embedding.engine.a b2 = b(this.SxE);
        b2.SOc.setInitialRoute(this.SxE.SxJ);
        if (b2.SNW.SOI) {
            AppMethodBeat.o(206298);
            return;
        }
        b2.SNW.a(new DartExecutor.a(FlutterMain.findAppBundlePath(), this.SxE.SxI));
        a(this.SxF);
        AppMethodBeat.o(206298);
    }

    private io.flutter.embedding.engine.a b(a aVar) {
        AppMethodBeat.i(206299);
        FlutterMain.startInitialization(aVar.mAppContext);
        FlutterMain.ensureInitializationComplete(aVar.mAppContext, aVar.SxL.toArray());
        this.SxF = new io.flutter.embedding.engine.a(aVar.mAppContext, (char) 0);
        io.flutter.embedding.engine.a aVar2 = this.SxF;
        AppMethodBeat.o(206299);
        return aVar2;
    }

    private void hrI() {
        AppMethodBeat.i(206300);
        if (this.SxE.SxN != null) {
            d.k(this.SxE.SxN);
            AppMethodBeat.o(206300);
            return;
        }
        a.i("WxaRouter.WxaRouter", "no method call handler.", new Object[0]);
        AppMethodBeat.o(206300);
    }

    private void a(io.flutter.embedding.engine.a aVar) {
        AppMethodBeat.i(206301);
        a.i("WxaRouter.WxaRouter", "registerPlugins by wxa router", new Object[0]);
        try {
            Class.forName("io.flutter.plugins.GeneratedPluginRegistrant").getDeclaredMethod("registerWith", io.flutter.embedding.engine.a.class).invoke(null, aVar);
            if (this.SxE.SxM != null) {
                this.SxE.SxM.a(aVar);
            }
            AppMethodBeat.o(206301);
        } catch (Exception e2) {
            a.w("WxaRouter.WxaRouter", "Tried to automatically register plugins with FlutterEngine (" + aVar + ") but could not find and invoke the GeneratedPluginRegistrant.", new Object[0]);
            AppMethodBeat.o(206301);
        }
    }

    public final b hrJ() {
        return this.SxG;
    }

    public static class a {
        public static final String crl = d.a.opaque.name();
        public String SxI = "main";
        public String SxJ = FilePathGenerator.ANDROID_DIR_SEP;
        public FlutterView.b SxK = FlutterView.b.texture;
        public io.flutter.embedding.engine.d SxL = new io.flutter.embedding.engine.d(new String[0]);
        public b SxM;
        private HashSet<a> SxN = new HashSet<>();
        public a.AbstractC2228a SxO;
        public Context mAppContext;

        static {
            AppMethodBeat.i(206290);
            AppMethodBeat.o(206290);
        }

        public a(Context context) {
            AppMethodBeat.i(206288);
            this.mAppContext = context;
            AppMethodBeat.o(206288);
        }

        public final a brB(String str) {
            this.SxI = str;
            return this;
        }

        public final a a(b bVar) {
            this.SxM = bVar;
            return this;
        }

        public final a a(a aVar) {
            AppMethodBeat.i(206289);
            if (!this.SxN.contains(aVar)) {
                this.SxN.add(aVar);
            }
            AppMethodBeat.o(206289);
            return this;
        }

        public final a a(a.AbstractC2228a aVar) {
            this.SxO = aVar;
            return this;
        }

        public final a hrK() {
            return this;
        }
    }
}
