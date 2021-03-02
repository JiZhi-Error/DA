package com.tencent.luggage.d;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.tencent.luggage.bridge.o;
import com.tencent.luggage.webview.a;
import com.tencent.luggage.webview.a.b;
import com.tencent.luggage.webview.a.d;
import com.tencent.luggage.webview.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.regex.Pattern;

public final class p extends n {
    o csD;
    private final MutableContextWrapper ctH;
    final Class<? extends a> ctI;
    public q ctJ;
    public a ctK;
    boolean ctL = false;
    public b ctM;
    d ctN;
    boolean ctO = false;
    private a.AbstractC0187a ctP = new a.AbstractC0187a() {
        /* class com.tencent.luggage.d.p.AnonymousClass1 */

        @Override // com.tencent.luggage.webview.a.AbstractC0187a
        public final boolean cU(String str) {
            AppMethodBeat.i(221189);
            Iterator<Pair<e, Pattern>> it = p.this.ctN.cDB.iterator();
            while (it.hasNext()) {
                Pair<e, Pattern> next = it.next();
                e eVar = (e) next.first;
                Pattern pattern = (Pattern) next.second;
                if (pattern != null && pattern.matcher(str).matches()) {
                    boolean Pm = eVar.Pm();
                    AppMethodBeat.o(221189);
                    return Pm;
                }
            }
            AppMethodBeat.o(221189);
            return false;
        }

        @Override // com.tencent.luggage.webview.a.AbstractC0187a
        public final void cV(String str) {
            AppMethodBeat.i(221190);
            p.this.ctO = false;
            p.this.mUrl = str;
            if (p.this.ctJ != null) {
                p.this.ctJ.cV(str);
            }
            AppMethodBeat.o(221190);
        }

        @Override // com.tencent.luggage.webview.a.AbstractC0187a
        public final void cW(String str) {
            AppMethodBeat.i(221191);
            p.this.mUrl = str;
            p.this.csD.csK.onReady();
            if (p.this.ctJ != null) {
                p.this.csD.cN(p.this.ctJ.LJ());
                p.this.ctJ.cW(str);
            }
            AppMethodBeat.o(221191);
        }

        @Override // com.tencent.luggage.webview.a.AbstractC0187a
        public final WebResourceResponse cX(String str) {
            AppMethodBeat.i(221192);
            cZ(str);
            WebResourceResponse dO = p.this.ctM.dO(str);
            AppMethodBeat.o(221192);
            return dO;
        }

        @Override // com.tencent.luggage.webview.a.AbstractC0187a
        public final WebResourceResponse a(WebResourceRequest webResourceRequest, Bundle bundle) {
            WebResourceResponse a2;
            AppMethodBeat.i(221193);
            cZ(webResourceRequest.getUrl().toString());
            if (p.this.ctJ == null || (a2 = p.this.ctJ.a(webResourceRequest, bundle)) == null) {
                WebResourceResponse dO = p.this.ctM.dO(webResourceRequest.getUrl().toString());
                AppMethodBeat.o(221193);
                return dO;
            }
            AppMethodBeat.o(221193);
            return a2;
        }

        @Override // com.tencent.luggage.webview.a.AbstractC0187a
        public final String cY(String str) {
            AppMethodBeat.i(221194);
            String cO = p.this.csD.csK.cO(str);
            AppMethodBeat.o(221194);
            return cO;
        }

        private void cZ(String str) {
            AppMethodBeat.i(221195);
            if (!p.this.ctO) {
                if (df(str)) {
                    AppMethodBeat.o(221195);
                    return;
                }
                p.this.LI();
            }
            AppMethodBeat.o(221195);
        }

        private static boolean df(String str) {
            AppMethodBeat.i(221196);
            if (str == null || str.length() == 0) {
                AppMethodBeat.o(221196);
                return false;
            }
            String path = Uri.parse(str).getPath();
            if (path == null || !path.trim().endsWith("html")) {
                AppMethodBeat.o(221196);
                return false;
            }
            AppMethodBeat.o(221196);
            return true;
        }
    };
    private Handler mHandler;
    public String mUrl;

    public p(Context context, Class<? extends a> cls) {
        AppMethodBeat.i(140424);
        this.ctH = new MutableContextWrapper(context);
        this.ctI = cls == null ? com.tencent.luggage.webview.default_impl.a.class : cls;
        this.mHandler = new Handler(Looper.getMainLooper());
        LD();
        this.ctK = (a) org.a.a.bF(this.ctI).ak(this.ctH).object;
        this.ctK.setWebCore(this);
        this.ctK.a(this.ctP);
        this.csD = new o(this.ctK);
        AppMethodBeat.o(140424);
    }

    private void LD() {
        AppMethodBeat.i(140425);
        this.ctM = new b();
        this.ctN = new d();
        LE();
        AppMethodBeat.o(140425);
    }

    private void LE() {
        AppMethodBeat.i(140426);
        this.ctM.a(new com.tencent.luggage.webview.a.a(this.ctH));
        AppMethodBeat.o(140426);
    }

    public final void setContext(Context context) {
        AppMethodBeat.i(140427);
        this.ctH.setBaseContext(context);
        if (this.ctK != null) {
            this.ctK.setContext(context);
        }
        AppMethodBeat.o(140427);
    }

    public final void LF() {
        AppMethodBeat.i(140430);
        if (this.ctL) {
            this.ctL = false;
            LD();
        }
        AppMethodBeat.o(140430);
    }

    @Deprecated
    public final <T> T LG() {
        AppMethodBeat.i(140431);
        try {
            T t = (T) getView();
            AppMethodBeat.o(140431);
            return t;
        } catch (Exception e2) {
            Log.e(getClass().getSimpleName(), "CoreImpl cast failed", e2);
            AppMethodBeat.o(140431);
            return null;
        }
    }

    public final View getView() {
        AppMethodBeat.i(140432);
        View view = this.ctK.getView();
        AppMethodBeat.o(140432);
        return view;
    }

    public final void loadUrl(String str) {
        AppMethodBeat.i(140433);
        this.ctK.loadUrl(str);
        AppMethodBeat.o(140433);
    }

    public final void stopLoading() {
        AppMethodBeat.i(140434);
        this.ctK.stopLoading();
        AppMethodBeat.o(140434);
    }

    @Override // com.tencent.luggage.d.n
    public final void destroy() {
        AppMethodBeat.i(140436);
        Log.i("Luggage.LuggageWebCore", "destroy");
        if (!this.ctL) {
            this.ctK.destroy();
        }
        AppMethodBeat.o(140436);
    }

    public final void LH() {
        AppMethodBeat.i(221197);
        if (this.ctK != null) {
            this.ctK.destroy();
        }
        AppMethodBeat.o(221197);
    }

    public final void cT(String str) {
        AppMethodBeat.i(221198);
        this.ctK.evaluateJavascript(str, null);
        AppMethodBeat.o(221198);
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.luggage.d.n
    public final o getBridge() {
        return this.csD;
    }

    @Override // com.tencent.luggage.d.n
    public final String getUserAgent() {
        AppMethodBeat.i(221199);
        String userAgent = this.ctK.getUserAgent();
        AppMethodBeat.o(221199);
        return userAgent;
    }

    public final synchronized void LI() {
        AppMethodBeat.i(221200);
        if (!this.ctO) {
            Log.printInfoStack("Luggage.LuggageWebCore", "try inject jsbridge", new Object[0]);
            this.csD.La();
            if (this.ctJ != null) {
                this.csD.cN(this.ctJ.LJ());
            }
            this.ctO = true;
        }
        AppMethodBeat.o(221200);
    }
}
