package com.tencent.mm.plugin.appbrand.game.f;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.Window;
import com.tencent.magicbrush.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.ui.y;
import com.tencent.mm.plugin.appbrand.widget.actionbar.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.g.g;

@SuppressLint({"ViewConstructor"})
public final class d extends ag {
    private boolean ltg = false;

    d() {
        super(e.class);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.ag, com.tencent.mm.plugin.appbrand.page.ac
    public final void a(Context context, AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(45181);
        long currentTicks = Util.currentTicks();
        super.a(context, appBrandRuntime);
        this.lxr = new a((byte) 0);
        Log.i("AppBrandGame.WAGamePageView", "[damonlei] WAGamePageView init cost [%d]ms", Long.valueOf(Util.ticksToNow(currentTicks)));
        AppMethodBeat.o(45181);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f, com.tencent.mm.plugin.appbrand.jsapi.g, com.tencent.mm.plugin.appbrand.page.ac
    public final void b(String str, String str2, int[] iArr) {
        AppMethodBeat.i(45183);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(45183);
        } else if (str.startsWith("onAppRoute")) {
            AppMethodBeat.o(45183);
        } else if (getRuntime() == null || getRuntime().bsE() == null) {
            Log.w("AppBrandGame.WAGamePageView", "publish runtime destroyed, event %s", str);
            AppMethodBeat.o(45183);
        } else {
            getRuntime().bsE().c(str, str2, getComponentId());
            AppMethodBeat.o(45183);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.page.ac
    public final void wz(int i2) {
    }

    @Override // com.tencent.mm.plugin.appbrand.page.ac
    public final void YO(String str) {
    }

    @Override // com.tencent.mm.plugin.appbrand.page.ac
    public final String bDn() {
        return null;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.ac
    public final void wA(int i2) {
    }

    @Override // com.tencent.mm.plugin.appbrand.page.ac
    public final void he(boolean z) {
    }

    @Override // com.tencent.mm.plugin.appbrand.page.ac
    public final void YP(final String str) {
        AppMethodBeat.i(45184);
        runOnUiThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.game.f.d.AnonymousClass1 */

            public final void run() {
                Window window;
                AppMethodBeat.i(45177);
                d.this.ltg = e.a.afW(str) == e.a.BLACK;
                if ((d.this.getContext() instanceof Activity) && (window = ((Activity) d.this.getContext()).getWindow()) != null) {
                    y.d(window, d.this.ltg);
                }
                AppMethodBeat.o(45177);
            }
        });
        AppMethodBeat.o(45184);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.ac
    public final void bDo() {
        AppMethodBeat.i(45185);
        runOnUiThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.game.f.d.AnonymousClass2 */

            public final void run() {
                Window window;
                AppMethodBeat.i(45178);
                if ((d.this.getContext() instanceof Activity) && (window = ((Activity) d.this.getContext()).getWindow()) != null) {
                    y.d(window, d.this.ltg);
                }
                AppMethodBeat.o(45178);
            }
        });
        AppMethodBeat.o(45185);
    }

    @Override // com.tencent.luggage.sdk.b.a.c
    public final c<Bitmap> NT() {
        AppMethodBeat.i(45186);
        c<_Ret> c2 = g.hdG().c(new com.tencent.mm.vending.c.a<Bitmap, Void>() {
            /* class com.tencent.mm.plugin.appbrand.game.f.d.AnonymousClass3 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Bitmap call(Void r7) {
                AppMethodBeat.i(226617);
                Bitmap a2 = b.a(((com.tencent.luggage.game.page.d) d.this.S(com.tencent.luggage.game.page.d.class)).MQ().getMagicBrush().cLA);
                Log.i("AppBrandGame.WAGamePageView", "try get game sharing screenshot: %s", a2);
                AppMethodBeat.o(226617);
                return a2;
            }
        });
        AppMethodBeat.o(45186);
        return c2;
    }

    static final class a implements f.b {
        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.f.b
        public final void V(int i2, String str) {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.f.b
        public final boolean a(p pVar, String str, int i2, f.a aVar) {
            AppMethodBeat.i(45179);
            aVar.Zb("UnsupportedOperation");
            AppMethodBeat.o(45179);
            return true;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.f.b
        public final void a(p pVar, String str, int i2, String str2) {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.f.b
        public final void a(bc bcVar, f.a aVar) {
            AppMethodBeat.i(45180);
            aVar.Zb("UnsupportedOperation");
            AppMethodBeat.o(45180);
        }
    }
}
