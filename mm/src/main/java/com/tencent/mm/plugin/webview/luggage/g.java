package com.tencent.mm.plugin.webview.luggage;

import android.app.Activity;
import android.graphics.Color;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.tencent.f.h;
import com.tencent.luggage.d.j;
import com.tencent.luggage.d.l;
import com.tencent.luggage.d.p;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cr.d;
import com.tencent.mm.plugin.handoff.model.HandOffURL;
import com.tencent.mm.plugin.webview.f.c;
import com.tencent.mm.plugin.webview.f.e;
import com.tencent.mm.plugin.webview.luggage.c.b;
import com.tencent.mm.plugin.webview.luggage.q;
import com.tencent.mm.plugin.webview.ui.tools.WebViewKeyboardLinearLayout;
import com.tencent.mm.plugin.webview.ui.tools.widget.MovingImageButton;
import com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter;
import com.tencent.mm.protocal.protobuf.bhj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.KeyboardLinearLayout;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.MMFalseProgressBar;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ac;
import com.tencent.xweb.r;
import com.tencent.xweb.x;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class g extends s {
    private static final Pattern ITJ = Pattern.compile("\"\\s*rgba\\(\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*\\)\\s*\"");
    private static final Pattern ITK = Pattern.compile("\"\\s*rgb\\(\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*\\)\\s*\"");
    protected m ISN;
    protected boolean ITA;
    protected int ITB;
    protected boolean ITC;
    public boolean ITD = false;
    private boolean ITE = false;
    private boolean ITF = false;
    private boolean ITG = false;
    public y ITH = new y();
    private a ITI;
    private com.tencent.mm.plugin.webview.f.a<bhj> ITL = new com.tencent.mm.plugin.webview.f.a<bhj>() {
        /* class com.tencent.mm.plugin.webview.luggage.g.AnonymousClass16 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, boolean, java.lang.String, java.lang.String, java.lang.Object] */
        @Override // com.tencent.mm.plugin.webview.f.a
        public final /* synthetic */ void a(int i2, boolean z, final String str, final String str2, bhj bhj) {
            AppMethodBeat.i(210901);
            g.this.ITz = false;
            final Map<String, String> ij = c.ij(bhj.LRq);
            g.this.aC(new Runnable() {
                /* class com.tencent.mm.plugin.webview.luggage.g.AnonymousClass16.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(210895);
                    g.this.c(str, str2, ij);
                    AppMethodBeat.o(210895);
                }
            });
            AppMethodBeat.o(210901);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.String, java.lang.Object] */
        @Override // com.tencent.mm.plugin.webview.f.a
        public final /* bridge */ /* synthetic */ boolean b(int i2, String str, bhj bhj) {
            return false;
        }

        @Override // com.tencent.mm.plugin.webview.f.a
        public final void bx(int i2, String str) {
        }

        @Override // com.tencent.mm.plugin.webview.f.a
        public final void by(int i2, String str) {
            AppMethodBeat.i(210898);
            g.this.azO(str);
            AppMethodBeat.o(210898);
        }

        @Override // com.tencent.mm.plugin.webview.f.a
        public final void C(int i2, final String str, final String str2) {
            AppMethodBeat.i(210899);
            g.this.ITz = false;
            g.this.aC(new Runnable() {
                /* class com.tencent.mm.plugin.webview.luggage.g.AnonymousClass16.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(210896);
                    g gVar = g.this;
                    gVar.ctS.ctK.loadData(str2, "text/html", ProtocolPackage.ServerEncoding);
                    AppMethodBeat.o(210896);
                }
            });
            AppMethodBeat.o(210899);
        }

        @Override // com.tencent.mm.plugin.webview.f.a
        public final void a(final int i2, final String str, final int i3, final int i4, final String str2) {
            AppMethodBeat.i(210900);
            g.this.ITz = false;
            g.this.aC(new Runnable() {
                /* class com.tencent.mm.plugin.webview.luggage.g.AnonymousClass16.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(210897);
                    g.this.b(i2, str, i3, i4);
                    AppMethodBeat.o(210897);
                }
            });
            AppMethodBeat.o(210900);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.String, java.lang.String, java.lang.Object] */
        @Override // com.tencent.mm.plugin.webview.f.a
        public final /* bridge */ /* synthetic */ void a(int i2, String str, String str2, bhj bhj) {
            g.this.ITz = false;
        }
    };
    private s.a ITM = new s.a() {
        /* class com.tencent.mm.plugin.webview.luggage.g.AnonymousClass17 */

        @Override // com.tencent.luggage.d.s.a
        public final void a(s sVar, String str) {
            AppMethodBeat.i(210902);
            g.this.cV(str);
            AppMethodBeat.o(210902);
        }

        @Override // com.tencent.luggage.d.s.a
        public final void b(s sVar, String str) {
            AppMethodBeat.i(210903);
            g.this.cW(str);
            AppMethodBeat.o(210903);
        }

        @Override // com.tencent.luggage.d.s.a
        public final WebResourceResponse a(WebResourceRequest webResourceRequest, Bundle bundle) {
            AppMethodBeat.i(210904);
            if (d.kS(g.this.mContext)) {
                try {
                    int i2 = bundle.getInt("resourceType");
                    if (i2 == 1 || i2 == 7) {
                        Log.i("MicroMsg.LuggageMMWebPage", "get resoutce type is iframe : %d, start geta8key", Integer.valueOf(i2));
                        g.this.aYr(webResourceRequest.getUrl().toString());
                    }
                } catch (Exception e2) {
                    Log.w("MicroMsg.LuggageMMWebPage", "get resource type failed Exception ; %s", e2.getMessage());
                } catch (Throwable th) {
                    Log.w("MicroMsg.LuggageMMWebPage", "get resource type failed Throwable ; %s", th.getMessage());
                }
            }
            WebResourceResponse azN = g.this.azN(webResourceRequest != null ? webResourceRequest.getUrl().toString() : "");
            AppMethodBeat.o(210904);
            return azN;
        }
    };
    public com.tencent.mm.plugin.webview.luggage.webview_impl.a ITd;
    protected l ITe;
    protected b ITf;
    private WebViewKeyboardLinearLayout ITg;
    public WebViewInputFooter ITh;
    public WebViewSearchContentInputFooter ITi;
    private FrameLayout ITj;
    private MMFalseProgressBar ITk;
    protected MovingImageButton ITl;
    protected FrameLayout ITm;
    public FrameLayout ITn;
    protected s ITo;
    protected q ITp;
    protected t ITq;
    protected HandOffURL ITr;
    private WebChromeClient.CustomViewCallback ITs;
    private FrameLayout ITt;
    private ProgressBar ITu;
    protected c ITv;
    public w ITw;
    protected q.a ITx;
    protected Map<String, String> ITy;
    protected boolean ITz = false;
    private boolean mGR = true;
    private com.tencent.mm.plugin.webview.ui.tools.c mHI;
    public MMHandler mHandler;
    protected boolean mIsForeground = false;
    public FrameLayout mRootView;
    public int ppd = 0;
    public int ppe = 0;
    protected String xwe;
    protected boolean xzH = false;

    static /* synthetic */ void a(g gVar, int i2) {
        AppMethodBeat.i(210914);
        gVar.afX(i2);
        AppMethodBeat.o(210914);
    }

    static /* synthetic */ void gbM() {
    }

    static /* synthetic */ void i(g gVar) {
        AppMethodBeat.i(210915);
        gVar.gbz();
        AppMethodBeat.o(210915);
    }

    /* access modifiers changed from: package-private */
    public static class a {
        boolean ITX;
        boolean ITY;
        boolean ITZ;

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(j jVar, p pVar, Bundle bundle) {
        super(jVar, pVar, bundle);
        boolean z = true;
        AppMethodBeat.i(78282);
        if (pVar != null) {
            this.ITC = true;
            this.ITv = e.agf(pVar.hashCode());
        }
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.ITv != null ? false : z);
        Log.i("MicroMsg.LuggageMMWebPage", "LuggageMMWebPage create, getA8key == null ? %b", objArr);
        if (this.ITv == null) {
            this.ITv = new c();
        }
        this.mHandler = new MMHandler();
        this.ITw = new w(this);
        this.ITx = new q.a(this, this.ITv);
        this.ctS.ctB = this.ITx;
        this.ITo = new s(this);
        this.ITp = new q(new d(this), this);
        this.ITq = new t(this, new u(this));
        j.b(this);
        if (this.ITd != null) {
            this.ITd.setPage(this);
            this.ITd.setWebViewClient(new ac() {
                /* class com.tencent.mm.plugin.webview.luggage.g.AnonymousClass10 */

                @Override // com.tencent.xweb.ac
                public final void a(WebView webView, int i2, String str, String str2) {
                    AppMethodBeat.i(210887);
                    Log.i("MicroMsg.LuggageMMWebPage", "onReceivedError, errCode = %d, description = %s, failingUrl = %s", Integer.valueOf(i2), str, str2);
                    g.this.D(i2, str, str2);
                    AppMethodBeat.o(210887);
                }

                @Override // com.tencent.xweb.ac
                public final void a(WebView webView, r rVar, SslError sslError) {
                    AppMethodBeat.i(210888);
                    if (g.this.mHI == null) {
                        g.this.mHI = new com.tencent.mm.plugin.webview.ui.tools.c(g.this.mContext, webView);
                    }
                    g.this.mHI.a(g.this.getUrl(), rVar, sslError);
                    AppMethodBeat.o(210888);
                }
            });
            this.ITd.setWebChromeClient(new x() {
                /* class com.tencent.mm.plugin.webview.luggage.g.AnonymousClass12 */

                @Override // com.tencent.xweb.x
                public final void d(WebView webView, String str) {
                    boolean z = true;
                    AppMethodBeat.i(210889);
                    Log.i("MicroMsg.LuggageMMWebPage", "onReceivedTitle, title = %s", str);
                    if (!b.afC(str)) {
                        if (Util.isNullOrNil(str) || !str.equalsIgnoreCase("about:blank")) {
                            z = false;
                        }
                        if (!z) {
                            g.this.ec(str, 0);
                        }
                    }
                    g.this.ctS.LI();
                    AppMethodBeat.o(210889);
                }

                @Override // com.tencent.xweb.x
                public final void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
                    AppMethodBeat.i(210890);
                    Log.i("MicroMsg.LuggageMMWebPage", "onShowCustomView, sdk int = " + Build.VERSION.SDK_INT);
                    try {
                        if (g.this.ITt != null) {
                            customViewCallback.onCustomViewHidden();
                            AppMethodBeat.o(210890);
                            return;
                        }
                        g.this.ITt = new FrameLayout(g.this.mContext);
                        g.this.ITt.setBackgroundResource(R.color.afj);
                        g.this.ITt.addView(view);
                        g.this.ITs = customViewCallback;
                        g.this.ITe.setVisibility(8);
                        g.this.ISN.setVisibility(8);
                        g.this.mRootView.addView(g.this.ITt);
                        AppMethodBeat.o(210890);
                    } catch (Exception e2) {
                        Log.e("MicroMsg.LuggageMMWebPage", "onShowCustomView error " + e2.getMessage());
                        AppMethodBeat.o(210890);
                    }
                }

                @Override // com.tencent.xweb.x
                public final void onHideCustomView() {
                    AppMethodBeat.i(210891);
                    Log.i("MicroMsg.LuggageMMWebPage", "onHideCustomView, sdk int = " + Build.VERSION.SDK_INT);
                    if (g.this.ITt == null) {
                        AppMethodBeat.o(210891);
                        return;
                    }
                    try {
                        g.this.ITe.setVisibility(0);
                        if (g.this.ITs != null) {
                            g.this.ITs.onCustomViewHidden();
                        }
                        g.this.ISN.setVisibility(0);
                        if (g.this.ITt != null) {
                            g.this.mRootView.removeView(g.this.ITt);
                        }
                        g.this.ITt.removeAllViews();
                        g.this.ITt = null;
                        AppMethodBeat.o(210891);
                    } catch (Exception e2) {
                        Log.e("MicroMsg.LuggageMMWebPage", "onHideCustomView error " + e2.getMessage());
                        AppMethodBeat.o(210891);
                    }
                }

                @Override // com.tencent.xweb.x
                public final View getVideoLoadingProgressView() {
                    AppMethodBeat.i(210892);
                    Log.i("MicroMsg.LuggageMMWebPage", "getVideoLoadingProgressView");
                    if (g.this.ITu == null) {
                        g.this.ITu = new ProgressBar(g.this.mContext);
                        g.this.ITu.setIndeterminate(true);
                    }
                    ProgressBar progressBar = g.this.ITu;
                    AppMethodBeat.o(210892);
                    return progressBar;
                }

                @Override // com.tencent.xweb.x
                public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                    return false;
                }
            });
        }
        a(this.ITM);
        this.ctf.ctz.put(new l.a() {
            /* class com.tencent.mm.plugin.webview.luggage.g.AnonymousClass1 */

            @Override // com.tencent.luggage.d.l.a
            public final boolean onBackPressed() {
                AppMethodBeat.i(78236);
                if (g.this.gbB()) {
                    AppMethodBeat.o(78236);
                    return true;
                } else if (g.this.ITq != null && g.this.ITq.O(1, true)) {
                    AppMethodBeat.o(78236);
                    return true;
                } else if (g.this.ITp == null || !g.this.ITp.wu(2)) {
                    AppMethodBeat.o(78236);
                    return false;
                } else {
                    AppMethodBeat.o(78236);
                    return true;
                }
            }
        }, Boolean.FALSE);
        AppMethodBeat.o(78282);
    }

    /* access modifiers changed from: protected */
    public Boolean dTB() {
        return Boolean.FALSE;
    }

    /* access modifiers changed from: protected */
    public View dTM() {
        AppMethodBeat.i(78284);
        this.ISN = new m(this);
        m mVar = this.ISN;
        AppMethodBeat.o(78284);
        return mVar;
    }

    /* access modifiers changed from: protected */
    public void dTH() {
        AppMethodBeat.i(78285);
        this.ISN.dTH();
        AppMethodBeat.o(78285);
    }

    public final void gby() {
        AppMethodBeat.i(78286);
        Log.i("MicroMsg.LuggageMMWebPage", "onAddInContainer");
        String string = this.mParams.getString("float_ball_key");
        if (!Util.isNullOrNil(string)) {
            this.ITp.G(5, string);
            this.ITq.G(5, string);
        } else {
            this.ITp.G(5, com.tencent.mm.plugin.ball.f.b.bxq(coX()));
            this.ITq.G(5, com.tencent.mm.plugin.multitask.g.aGG(((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).ahz(coX())));
        }
        this.ITp.eU("rawUrl", coX());
        this.ITp.aYt(coX());
        if (Util.isNullOrNil(this.ISN.getTitle())) {
            this.ITp.agT(coX());
        }
        this.ITF = true;
        if (this.ITE) {
            this.ITp.bCA();
            this.ITq.bCA();
        }
        this.ITr = new HandOffURL(Util.nullAsNil(coX()), Util.nullAsNil(coX()), "");
        ((com.tencent.mm.plugin.handoff.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).a(this.ITr);
        gbz();
        AppMethodBeat.o(78286);
    }

    @Override // com.tencent.luggage.d.h
    public void onForeground() {
        AppMethodBeat.i(78287);
        if (this.ITE) {
            AppMethodBeat.o(78287);
            return;
        }
        this.ITE = true;
        Log.i("MicroMsg.LuggageMMWebPage", "onForeground");
        if (this.ITD) {
            hb(false);
            AppMethodBeat.o(78287);
            return;
        }
        gbz();
        pJ(isFullScreen());
        dTN();
        aYq("onResume");
        this.ITd.onResume();
        this.mIsForeground = true;
        afX(0);
        if (this.ITF) {
            this.ITp.bCA();
            this.ITq.bCA();
        }
        this.ISN.onForeground();
        AppMethodBeat.o(78287);
    }

    @Override // com.tencent.luggage.d.h
    public void onBackground() {
        AppMethodBeat.i(78288);
        Log.i("MicroMsg.LuggageMMWebPage", "onBackground");
        this.ITE = false;
        aYq("onPause");
        this.ISN.dTI();
        this.ITd.onPause();
        this.mIsForeground = false;
        if (this.ITp != null) {
            this.ITp.aGj();
        }
        if (this.ITq != null) {
            this.ITq.aGj();
        }
        AppMethodBeat.o(78288);
    }

    @Override // com.tencent.luggage.d.h
    public void onDestroy() {
        AppMethodBeat.i(78289);
        if (!this.xzH) {
            this.xzH = true;
            Log.i("MicroMsg.LuggageMMWebPage", "onDestroy");
            this.ITo.ISU = null;
            j.c(this);
            this.mRootView.removeAllViews();
            this.ctS.setContext(MMApplicationContext.getContext());
            if (this.ITp != null) {
                this.ITp.onDestroy();
            }
            if (this.ITq != null) {
                if (this.ITq.eqW()) {
                    r.a(this.ITq.bjl(), this.ctS, this.ITv);
                } else {
                    aYq("onDestroy");
                }
            }
            if (this.ITr != null) {
                ((com.tencent.mm.plugin.handoff.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).b(this.ITr);
            }
            this.ITv.IJS = true;
            this.ISN.onDestroy();
        }
        AppMethodBeat.o(78289);
    }

    /* access modifiers changed from: protected */
    public void pJ(boolean z) {
        AppMethodBeat.i(78292);
        if (z) {
            this.ISN.setVisibility(8);
            this.ITl.setVisibility(0);
            com.tencent.mm.plugin.webview.luggage.c.a.c(((Activity) this.mContext).getWindow(), true);
            AppMethodBeat.o(78292);
            return;
        }
        this.ISN.setVisibility(0);
        this.ITl.setVisibility(8);
        com.tencent.mm.plugin.webview.luggage.c.a.c(((Activity) this.mContext).getWindow(), false);
        AppMethodBeat.o(78292);
    }

    /* access modifiers changed from: protected */
    public void dTN() {
        AppMethodBeat.i(78294);
        if (!this.ITA) {
            this.ITB = this.mParams.getInt("customize_status_bar_color");
            if (this.ITB == 0) {
                this.ITB = android.support.v4.content.b.n(this.mContext, R.color.bj);
            }
        }
        gbA();
        AppMethodBeat.o(78294);
    }

    /* access modifiers changed from: protected */
    public final void gbA() {
        AppMethodBeat.i(78295);
        Log.d("MicroMsg.LuggageMMWebPage", "setActionBarColor");
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            this.mHandler.post(new Runnable() {
                /* class com.tencent.mm.plugin.webview.luggage.g.AnonymousClass24 */

                public final void run() {
                    AppMethodBeat.i(78277);
                    g.this.gbA();
                    AppMethodBeat.o(78277);
                }
            });
            AppMethodBeat.o(78295);
            return;
        }
        this.ISN.k(this.ITB, this.ITI.ITX, this.ITI.ITY);
        AppMethodBeat.o(78295);
    }

    public final void c(String str, final float f2, int i2) {
        AppMethodBeat.i(210910);
        if (!Util.isNullOrNil(str)) {
            try {
                int parseColor = Color.parseColor(str) | com.tencent.smtt.sdk.WebView.NIGHT_MODE_COLOR;
                this.ITA = true;
                this.ITB = parseColor;
                this.ISN.setActionBarColorValue(this.ITB);
            } catch (Exception e2) {
            }
        }
        this.ISN.setIconDark(i2);
        if (f2 < 0.0f || f2 > 1.0f) {
            gbA();
            AppMethodBeat.o(210910);
            return;
        }
        this.mHandler.post(new Runnable() {
            /* class com.tencent.mm.plugin.webview.luggage.g.AnonymousClass25 */

            public final void run() {
                AppMethodBeat.i(78278);
                g.this.ISN.setAlpha(f2);
                AppMethodBeat.o(78278);
            }
        });
        AppMethodBeat.o(210910);
    }

    public void ec(final String str, final int i2) {
        AppMethodBeat.i(78298);
        if (this.ITF) {
            this.ITp.agT(str);
        }
        this.ITq.aCM(str);
        if (this.ITr != null) {
            this.ITr.setTitle(str);
            ((com.tencent.mm.plugin.handoff.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).e(this.ITr);
        }
        this.mHandler.post(new Runnable() {
            /* class com.tencent.mm.plugin.webview.luggage.g.AnonymousClass26 */

            public final void run() {
                AppMethodBeat.i(210907);
                if (g.this.ISN != null) {
                    if (!Util.isNullOrNil(str)) {
                        g.this.ISN.setTitleText(str);
                    }
                    if (i2 != 0) {
                        g.this.ISN.setTitleColor(i2);
                    }
                }
                AppMethodBeat.o(210907);
            }
        });
        AppMethodBeat.o(78298);
    }

    public final void afW(int i2) {
        AppMethodBeat.i(78299);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.ITh.getLayoutParams();
        if (marginLayoutParams.bottomMargin != i2) {
            marginLayoutParams.bottomMargin = i2;
            this.ITh.setLayoutParams(marginLayoutParams);
        }
        AppMethodBeat.o(78299);
    }

    private void afX(int i2) {
        AppMethodBeat.i(78300);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.ITi.getLayoutParams();
        if (marginLayoutParams.bottomMargin != i2) {
            marginLayoutParams.bottomMargin = i2;
            this.ITi.setLayoutParams(marginLayoutParams);
        }
        if (this.ITi.isShown()) {
            i2 += this.ITi.getHeight();
        }
        this.ITe.setPadding(this.ITe.getPaddingLeft(), this.ITe.getPaddingTop(), this.ITe.getPaddingRight(), i2);
        AppMethodBeat.o(78300);
    }

    public final void zc(boolean z) {
        AppMethodBeat.i(210911);
        if (!z) {
            this.ITi.hide();
            AppMethodBeat.o(210911);
            return;
        }
        if (!this.ITi.isShown()) {
            this.ITi.reset();
            this.ITi.giD();
            this.ITi.show();
        }
        AppMethodBeat.o(210911);
    }

    public boolean Oc(int i2) {
        AppMethodBeat.i(78302);
        boolean gs = this.ITv.gs(getUrl(), i2);
        AppMethodBeat.o(78302);
        return gs;
    }

    public final boolean gbB() {
        AppMethodBeat.i(78304);
        if (this.ISN != null) {
            boolean gbB = this.ISN.gbB();
            AppMethodBeat.o(78304);
            return gbB;
        }
        AppMethodBeat.o(78304);
        return false;
    }

    public final void cT(String str) {
        AppMethodBeat.i(210912);
        if (this.ITd != null) {
            this.ITd.evaluateJavascript(str, null);
        }
        AppMethodBeat.o(210912);
    }

    public final String getTitle() {
        AppMethodBeat.i(259608);
        String title = this.ISN.getTitle();
        AppMethodBeat.o(259608);
        return title;
    }

    public final m gbC() {
        return this.ISN;
    }

    public final void ega() {
        AppMethodBeat.i(78306);
        this.ISN.setVisibility(8);
        AppMethodBeat.o(78306);
    }

    static {
        AppMethodBeat.i(78330);
        AppMethodBeat.o(78330);
    }

    /* access modifiers changed from: protected */
    public void D(int i2, String str, String str2) {
    }

    public final void gbD() {
        AppMethodBeat.i(78309);
        this.mHandler.post(new Runnable() {
            /* class com.tencent.mm.plugin.webview.luggage.g.AnonymousClass15 */

            public final void run() {
                AppMethodBeat.i(210894);
                g.this.ITe.setPullDownEnabled(false);
                AppMethodBeat.o(210894);
            }
        });
        AppMethodBeat.o(78309);
    }

    public final boolean gbE() {
        return this.ITz;
    }

    /* access modifiers changed from: protected */
    public boolean azJ(String str) {
        return false;
    }

    /* access modifiers changed from: protected */
    public void dTA() {
        AppMethodBeat.i(78310);
        this.ITk.setVisibility(0);
        this.ITk.start();
        AppMethodBeat.o(78310);
    }

    /* access modifiers changed from: protected */
    public void dTO() {
        AppMethodBeat.i(78311);
        this.ITk.finish();
        this.ITk.setVisibility(8);
        AppMethodBeat.o(78311);
    }

    /* access modifiers changed from: protected */
    public void azH(String str) {
        AppMethodBeat.i(78312);
        if (this.ITd.getX5WebViewExtension() != null) {
            this.ITe.setPullDownEnabled(true);
            this.ITe.setCurrentUrl(str);
        }
        AppMethodBeat.o(78312);
    }

    @Override // com.tencent.luggage.d.h, com.tencent.luggage.d.s
    public void g(String str, Bundle bundle) {
        AppMethodBeat.i(78313);
        Log.i("MicroMsg.LuggageMMWebPage", "load url, url: %s, fromStash: %b", str, Boolean.valueOf(this.ITC));
        this.ctS.mUrl = str;
        if (this.ITC) {
            Log.i("MicroMsg.LuggageMMWebPage", "stash url");
            this.ISN.setOptionEnable(true);
            if (!Util.isNullOrNil(this.mParams.getString("title"))) {
                ec(this.mParams.getString("title"), 0);
            }
            this.mGR = false;
            if (this.ITv == null) {
                this.ITv = new c();
            }
            azL(str);
            AppMethodBeat.o(78313);
            return;
        }
        dTA();
        String string = bundle.getString("game_open_html");
        if (!Util.isNullOrNil(string)) {
            this.ITG = true;
            this.ITd.loadDataWithBaseURL(str, string, "text/html", ProtocolPackage.ServerEncoding, null);
        } else if (azJ(str)) {
            azM(str);
        } else if (!this.mGR) {
            g(str, null);
            AppMethodBeat.o(78313);
            return;
        }
        azL(str);
        this.mGR = false;
        AppMethodBeat.o(78313);
    }

    /* access modifiers changed from: protected */
    public void azM(String str) {
        AppMethodBeat.i(78314);
        Log.i("MicroMsg.LuggageMMWebPage", "loadUrlWithoutCache, url: %s, __Time__: %d", str, Long.valueOf(System.currentTimeMillis()));
        HashMap hashMap = new HashMap(2);
        hashMap.put("Pragma", "no-cache");
        hashMap.put("Cache-Control", "no-cache");
        this.ITd.loadUrl(str, hashMap);
        AppMethodBeat.o(78314);
    }

    /* access modifiers changed from: protected */
    public void cV(String str) {
        int cO;
        AppMethodBeat.i(78315);
        Log.d("MicroMsg.LuggageMMWebPage", "onUrlLoadingStarted, url = ".concat(String.valueOf(str)));
        if (!azL(str) || !((cO = this.ITv.cO(str, false)) == 0 || cO == 2 || cO == 8)) {
            com.tencent.mm.plugin.webview.model.a.e(this.ITd);
            if (this.ITp != null) {
                this.ITp.eU("rawUrl", str);
                this.ITp.aYt(str);
            }
            if (this.ITr != null) {
                this.ITr.setUrl(Util.nullAsNil(str));
                ((com.tencent.mm.plugin.handoff.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).e(this.ITr);
            }
            this.ISN.setOptionEnable(false);
            dTA();
            azH(str);
            AppMethodBeat.o(78315);
            return;
        }
        this.ctS.stopLoading();
        AppMethodBeat.o(78315);
    }

    /* access modifiers changed from: protected */
    public void cW(String str) {
        AppMethodBeat.i(78316);
        Log.d("MicroMsg.LuggageMMWebPage", "onUrlLoadingFinished, url = ".concat(String.valueOf(str)));
        com.tencent.mm.plugin.webview.model.a.e(this.ITd);
        this.ISN.setOptionEnable(true);
        dTO();
        if (this.ITp != null) {
            this.ITp.eU("rawUrl", str);
            this.ITp.aYt(str);
        }
        if (this.ITr != null) {
            this.ITr.setUrl(Util.nullAsNil(str));
            ((com.tencent.mm.plugin.handoff.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).e(this.ITr);
        }
        AppMethodBeat.o(78316);
    }

    /* access modifiers changed from: protected */
    public WebResourceResponse azN(String str) {
        return null;
    }

    @Override // com.tencent.luggage.d.s
    public String LJ() {
        AppMethodBeat.i(78317);
        String afA = com.tencent.mm.plugin.appbrand.ac.d.afA("luggage_mm_adapter.js");
        AppMethodBeat.o(78317);
        return afA;
    }

    public final String coy() {
        return this.xwe;
    }

    public final c gbF() {
        return this.ITv;
    }

    public final q.a gbG() {
        return this.ITx;
    }

    /* access modifiers changed from: protected */
    public boolean azL(String str) {
        boolean z;
        AppMethodBeat.i(78319);
        if (this.ITv.aZI(str)) {
            this.ITz = true;
            AppMethodBeat.o(78319);
            return false;
        }
        if (this.ITv.a(str, this.ITL) == c.a.WILL_GET) {
            z = true;
        } else {
            z = false;
        }
        Log.i("MicroMsg.LuggageMMWebPage", "startGetA8Key, url: %s, ret: %b", str, Boolean.valueOf(z));
        this.ITz = z;
        AppMethodBeat.o(78319);
        return z;
    }

    /* access modifiers changed from: protected */
    public final boolean aYr(String str) {
        AppMethodBeat.i(78320);
        if (this.ITv.a(str, 5, this.ITL) == c.a.WILL_GET) {
            AppMethodBeat.o(78320);
            return true;
        }
        AppMethodBeat.o(78320);
        return false;
    }

    /* access modifiers changed from: protected */
    public void azO(String str) {
    }

    /* access modifiers changed from: protected */
    public void c(String str, String str2, Map<String, String> map) {
        AppMethodBeat.i(78321);
        Log.i("MicroMsg.LuggageMMWebPage", "onUrlRedirect, reqUrl = %s, full = %s", str, str2);
        if (Util.isNullOrNil(this.xwe)) {
            this.xwe = str2;
        }
        this.ITy = map;
        if (!azJ(str) && !this.ITC && !this.ITG) {
            this.ctS.stopLoading();
            if (map == null || map.size() <= 0) {
                this.ctS.loadUrl(str2);
            } else {
                this.ctS.ctK.loadUrl(str2, map);
                AppMethodBeat.o(78321);
                return;
            }
        }
        AppMethodBeat.o(78321);
    }

    /* access modifiers changed from: protected */
    public final void b(int i2, String str, int i3, int i4) {
        AppMethodBeat.i(78322);
        Log.i("MicroMsg.LuggageMMWebPage", "onError, reason = %d, errType = %d, errCode = %d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        switch (i2) {
            case 0:
            case 2:
            case 8:
            case 9:
                if (!azJ(str)) {
                    this.ITj.setVisibility(0);
                    dTO();
                    break;
                }
                break;
        }
        AppMethodBeat.o(78322);
    }

    public final void aC(Runnable runnable) {
        AppMethodBeat.i(78323);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
            AppMethodBeat.o(78323);
            return;
        }
        this.mHandler.post(runnable);
        AppMethodBeat.o(78323);
    }

    public final q gbI() {
        return this.ITp;
    }

    public final t gbJ() {
        return this.ITq;
    }

    public final HandOffURL gbK() {
        return this.ITr;
    }

    public final void gbL() {
        AppMethodBeat.i(78326);
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            int indexOf = this.ctg.Lx().indexOf(this);
            if (indexOf < 0) {
                AppMethodBeat.o(78326);
            } else if (!this.ctg.Ly().remove(indexOf)) {
                this.ctg.LA().finish();
                AppMethodBeat.o(78326);
            } else {
                h.RTc.n(new Runnable() {
                    /* class com.tencent.mm.plugin.webview.luggage.g.AnonymousClass18 */

                    public final void run() {
                        AppMethodBeat.i(78273);
                        com.tencent.luggage.d.h peek = g.this.ctg.Lx().peek();
                        if (peek != null && (peek instanceof g)) {
                            g.i((g) peek);
                        }
                        AppMethodBeat.o(78273);
                    }
                }, 250);
                AppMethodBeat.o(78326);
            }
        } else {
            com.tencent.mm.ipcinvoker.p.y(new Runnable() {
                /* class com.tencent.mm.plugin.webview.luggage.g.AnonymousClass19 */

                public final void run() {
                    AppMethodBeat.i(210905);
                    g.this.gbL();
                    AppMethodBeat.o(210905);
                }
            });
            AppMethodBeat.o(78326);
        }
    }

    public final void hb(final boolean z) {
        AppMethodBeat.i(78327);
        if (this.ITp != null && this.ITp.wu(1)) {
            AppMethodBeat.o(78327);
        } else if (this.ITq == null || !this.ITq.O(1, true)) {
            if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
                com.tencent.mm.ipcinvoker.p.y(new Runnable() {
                    /* class com.tencent.mm.plugin.webview.luggage.g.AnonymousClass20 */

                    public final void run() {
                        AppMethodBeat.i(210906);
                        g.this.hb(z);
                        AppMethodBeat.o(210906);
                    }
                });
            } else if (!this.ctg.Ly().bR(z)) {
                this.ctg.LA().finish();
                AppMethodBeat.o(78327);
                return;
            }
            AppMethodBeat.o(78327);
        } else {
            AppMethodBeat.o(78327);
        }
    }

    @Override // com.tencent.luggage.d.h, com.tencent.luggage.d.s
    public View Lf() {
        AppMethodBeat.i(78283);
        String coX = coX();
        this.ITI = new a((byte) 0);
        Uri parse = Uri.parse(coX);
        if (Util.nullAsNil(parse.getQueryParameter("immersiveUIStyle")).equals("1")) {
            this.ITI.ITX = true;
        }
        if (Util.nullAsNil(parse.getQueryParameter("immersivePageBgIsDark")).equals("1")) {
            this.ITI.ITY = true;
        } else if (!Util.nullAsNil(parse.getQueryParameter("immersivePageBgIsDark")).equals("2")) {
            this.ITI.ITY = false;
        } else if (ao.isDarkMode()) {
            this.ITI.ITY = true;
        } else {
            this.ITI.ITY = false;
        }
        if (Util.nullAsNil(parse.getQueryParameter("hide_share_option")).equals("1")) {
            this.ITI.ITZ = true;
        }
        this.ITd = (com.tencent.mm.plugin.webview.luggage.webview_impl.a) this.ctS.LG();
        this.ITe = new l(this.mContext, super.Lf());
        this.ITd.setCompetitorView(this.ITe);
        this.ITd.setSource(this.mParams.getString("KPublisherId"));
        this.mRootView = new FrameLayout(this.mContext);
        this.ITf = new b(this.mContext);
        this.ITf.setBackgroundColor(android.support.v4.content.b.n(this.mContext, R.color.afz));
        this.mRootView.addView(this.ITf, new FrameLayout.LayoutParams(-1, -1));
        View inflate = aa.jQ(this.mContext).inflate(R.layout.b4r, (ViewGroup) this.ITf, false);
        dTM();
        if (dTB().booleanValue()) {
            this.ITf.addView(inflate);
        } else {
            b bVar = this.ITf;
            m mVar = this.ISN;
            boolean z = this.ITI.ITX;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(10);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
            if (z) {
                layoutParams2.addRule(10);
                bVar.addView(inflate, layoutParams2);
                bVar.addView(mVar, layoutParams);
            } else {
                bVar.addView(mVar, layoutParams);
                layoutParams2.addRule(3, mVar.getId());
                bVar.addView(inflate, layoutParams2);
            }
        }
        if (this.ITI.ITZ) {
            this.ISN.zd(true);
        }
        this.ITf.setActionBar(this.ISN);
        this.ITf.setWebView(this.ITd);
        this.ITm = (FrameLayout) inflate.findViewById(R.id.be3);
        this.ITk = (MMFalseProgressBar) inflate.findViewById(R.id.jk9);
        this.ITl = (MovingImageButton) inflate.findViewById(R.id.dc0);
        this.ITl.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.webview.luggage.g.AnonymousClass11 */

            public final void onClick(View view) {
                AppMethodBeat.i(78257);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/luggage/LuggageMMWebPage$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                g.this.dTH();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/luggage/LuggageMMWebPage$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(78257);
            }
        });
        this.ITg = (WebViewKeyboardLinearLayout) inflate.findViewById(R.id.dj9);
        this.ITn = (FrameLayout) inflate.findViewById(R.id.jk8);
        this.ITn.addView(this.ITe, new ViewGroup.LayoutParams(-1, -1));
        this.ITh = (WebViewInputFooter) inflate.findViewById(R.id.jkr);
        this.ITh.hide();
        this.ITh.setOnTextSendListener(new WebViewInputFooter.c() {
            /* class com.tencent.mm.plugin.webview.luggage.g.AnonymousClass27 */

            @Override // com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter.c
            public final void gbU() {
                AppMethodBeat.i(210908);
                g.gbM();
                if (g.this.ITh != null) {
                    g.this.ITh.hide();
                }
                AppMethodBeat.o(210908);
            }
        });
        this.ITh.setOnSmileyChosenListener(new WebViewInputFooter.a() {
            /* class com.tencent.mm.plugin.webview.luggage.g.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter.a
            public final boolean afZ(final String str) {
                AppMethodBeat.i(210874);
                g.this.ctS.a(new com.tencent.luggage.d.d() {
                    /* class com.tencent.mm.plugin.webview.luggage.g.AnonymousClass2.AnonymousClass1 */

                    @Override // com.tencent.luggage.d.d
                    public final String name() {
                        return "onGetSmiley";
                    }

                    @Override // com.tencent.luggage.d.d
                    public final JSONObject Ld() {
                        AppMethodBeat.i(210873);
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("smiley", str);
                        } catch (JSONException e2) {
                        }
                        AppMethodBeat.o(210873);
                        return jSONObject;
                    }
                });
                AppMethodBeat.o(210874);
                return true;
            }
        });
        this.ITh.setOnSmileyPanelVisibilityChangedListener(new WebViewInputFooter.b() {
            /* class com.tencent.mm.plugin.webview.luggage.g.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter.b
            public final void gbP() {
                AppMethodBeat.i(210875);
                g.this.afW(0);
                AppMethodBeat.o(210875);
            }

            @Override // com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter.b
            public final void gbQ() {
                AppMethodBeat.i(210876);
                if (g.this.ITg != null && g.this.ITg.getKeyBoardHeight() > 0) {
                    g.this.afW(g.this.ITg.getKeyBoardHeight());
                }
                AppMethodBeat.o(210876);
            }
        });
        this.ITi = (WebViewSearchContentInputFooter) inflate.findViewById(R.id.hdp);
        this.ITi.setActionDelegate(new WebViewSearchContentInputFooter.a() {
            /* class com.tencent.mm.plugin.webview.luggage.g.AnonymousClass4 */

            @Override // com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter.a
            public final void gbR() {
                AppMethodBeat.i(210877);
                g.a(g.this, 0);
                g.this.ITd.clearMatches();
                g.this.ITi.giD();
                AppMethodBeat.o(210877);
            }

            @Override // com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter.a
            public final void a(WebViewSearchContentInputFooter webViewSearchContentInputFooter) {
                AppMethodBeat.i(210878);
                if (webViewSearchContentInputFooter.getVisibility() == 0) {
                    b(webViewSearchContentInputFooter);
                }
                AppMethodBeat.o(210878);
            }

            @Override // com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter.a
            public final void gbS() {
                AppMethodBeat.i(210879);
                g.this.ITd.findNext(false);
                AppMethodBeat.o(210879);
            }

            @Override // com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter.a
            public final void gbT() {
                AppMethodBeat.i(210880);
                g.this.ITd.findNext(true);
                AppMethodBeat.o(210880);
            }

            @Override // com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter.a
            public final void b(WebViewSearchContentInputFooter webViewSearchContentInputFooter) {
                AppMethodBeat.i(210881);
                g.this.ITd.clearMatches();
                webViewSearchContentInputFooter.reset();
                g.this.ITi.H(0, 0, true);
                g.this.ITd.findAllAsync(webViewSearchContentInputFooter.getSearchContent());
                AppMethodBeat.o(210881);
            }

            @Override // com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter.a
            public final boolean c(int i2, KeyEvent keyEvent) {
                return false;
            }
        });
        this.ITd.setFindListener(new WebView.FindListener() {
            /* class com.tencent.mm.plugin.webview.luggage.g.AnonymousClass5 */

            public final void onFindResultReceived(int i2, int i3, boolean z) {
                AppMethodBeat.i(210882);
                g.this.ITi.H(i2, i3, z);
                AppMethodBeat.o(210882);
            }
        });
        this.ITj = (FrameLayout) inflate.findViewById(R.id.gym);
        if (this.ITj != null) {
            this.ITj.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.webview.luggage.g.AnonymousClass21 */

                public final void onClick(View view) {
                    AppMethodBeat.i(78274);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/luggage/LuggageMMWebPage$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    g.this.ctS.loadUrl(g.this.getUrl());
                    g.this.ITj.setVisibility(8);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/luggage/LuggageMMWebPage$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(78274);
                }
            });
        }
        this.ITg.setOnkbdStateListener(new KeyboardLinearLayout.a() {
            /* class com.tencent.mm.plugin.webview.luggage.g.AnonymousClass6 */

            @Override // com.tencent.mm.ui.KeyboardLinearLayout.a
            public final void Ns(int i2) {
                AppMethodBeat.i(210883);
                Log.i("MicroMsg.LuggageMMWebPage", "onKeyBoardStateChange, state = ".concat(String.valueOf(i2)));
                if (!g.this.mIsForeground) {
                    Log.i("MicroMsg.LuggageMMWebPage", "background ignored");
                    AppMethodBeat.o(210883);
                    return;
                }
                g.a(g.this, g.this.ITg, i2);
                if (i2 == -3) {
                    if (g.this.ITh != null && g.this.ITh.getVisibility() == 0) {
                        WebViewInputFooter webViewInputFooter = g.this.ITh;
                        if (webViewInputFooter.JAQ) {
                            webViewInputFooter.setVisibility(8);
                        }
                        webViewInputFooter.state = 0;
                        webViewInputFooter.cbM();
                    }
                    g.a(g.this, g.this.ITg.getKeyBoardHeight());
                    AppMethodBeat.o(210883);
                    return;
                }
                g.a(g.this, 0);
                AppMethodBeat.o(210883);
            }
        });
        this.ITd.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.webview.luggage.g.AnonymousClass22 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(78275);
                if (g.this.ITh.isShown()) {
                    g.this.ITh.hide();
                }
                if (motionEvent.getAction() == 0) {
                    g.this.ppd = (int) motionEvent.getRawX();
                    g.this.ppe = (int) motionEvent.getRawY();
                }
                AppMethodBeat.o(78275);
                return false;
            }
        });
        FrameLayout frameLayout = this.mRootView;
        AppMethodBeat.o(78283);
        return frameLayout;
    }

    public void reload() {
        AppMethodBeat.i(78290);
        this.ITd.reload();
        AppMethodBeat.o(78290);
    }

    public final void gbz() {
        AppMethodBeat.i(210909);
        int i2 = this.mParams.getInt("screen_orientation", -1);
        if (this.ctg.Lx().peek() == this) {
            ((Activity) this.mContext).setRequestedOrientation(i2);
        }
        AppMethodBeat.o(210909);
    }

    /* access modifiers changed from: protected */
    public final void aYq(final String str) {
        AppMethodBeat.i(78293);
        this.ctS.a(new com.tencent.luggage.d.d() {
            /* class com.tencent.mm.plugin.webview.luggage.g.AnonymousClass23 */

            @Override // com.tencent.luggage.d.d
            public final String name() {
                return "activity:state_change";
            }

            @Override // com.tencent.luggage.d.d
            public final JSONObject Ld() {
                AppMethodBeat.i(78276);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("state", str);
                } catch (Exception e2) {
                }
                AppMethodBeat.o(78276);
                return jSONObject;
            }
        });
        AppMethodBeat.o(78293);
    }

    public final void bDo() {
        AppMethodBeat.i(78297);
        this.ITB = android.support.v4.content.b.n(this.mContext, R.color.bj);
        this.ISN.IUv = -1;
        gbA();
        AppMethodBeat.o(78297);
    }

    public final boolean isFullScreen() {
        AppMethodBeat.i(78303);
        boolean z = this.mParams.getBoolean("show_full_screen", false);
        AppMethodBeat.o(78303);
        return z;
    }

    public final String getUrl() {
        if (this.ctS != null) {
            return this.ctS.mUrl;
        }
        return "";
    }

    public final String coX() {
        AppMethodBeat.i(78318);
        String string = this.mParams.getString("rawUrl");
        AppMethodBeat.o(78318);
        return string;
    }

    public final boolean gbH() {
        AppMethodBeat.i(78324);
        boolean z = this.mParams.getBoolean("forceHideShare", false);
        boolean z2 = this.mParams.getBoolean("showShare", true);
        Log.i("MicroMsg.LuggageMMWebPage", "forceHideShare:%b showShareBtn:%b enableMinimize:%b", Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(cpz()));
        if (z || !z2 || !cpz()) {
            AppMethodBeat.o(78324);
            return false;
        }
        AppMethodBeat.o(78324);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean cpz() {
        boolean z;
        AppMethodBeat.i(78325);
        if (!this.mParams.getBoolean("disable_minimize", false)) {
            z = true;
        } else {
            z = false;
        }
        Log.i("MicroMsg.LuggageMMWebPage", "enableMinimize class:%s enable:%b", getClass(), Boolean.valueOf(z));
        AppMethodBeat.o(78325);
        return z;
    }

    static /* synthetic */ void a(g gVar, WebViewKeyboardLinearLayout webViewKeyboardLinearLayout, int i2) {
        AppMethodBeat.i(78329);
        if (gVar.ITd.getX5WebViewExtension() != null || Build.VERSION.SDK_INT >= 19) {
            if (i2 == -3) {
                final int keyBoardHeight = webViewKeyboardLinearLayout.getKeyBoardHeight();
                gVar.mHandler.post(new Runnable() {
                    /* class com.tencent.mm.plugin.webview.luggage.g.AnonymousClass7 */

                    public final void run() {
                        AppMethodBeat.i(78249);
                        g.this.ctS.a(new com.tencent.luggage.d.d() {
                            /* class com.tencent.mm.plugin.webview.luggage.g.AnonymousClass7.AnonymousClass1 */

                            @Override // com.tencent.luggage.d.d
                            public final String name() {
                                return "onGetKeyboardHeight";
                            }

                            @Override // com.tencent.luggage.d.d
                            public final JSONObject Ld() {
                                AppMethodBeat.i(78248);
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("height", keyBoardHeight);
                                } catch (Exception e2) {
                                }
                                AppMethodBeat.o(78248);
                                return jSONObject;
                            }
                        });
                        AppMethodBeat.o(78249);
                    }
                });
                AppMethodBeat.o(78329);
                return;
            }
            gVar.mHandler.post(new Runnable() {
                /* class com.tencent.mm.plugin.webview.luggage.g.AnonymousClass8 */

                public final void run() {
                    AppMethodBeat.i(210885);
                    g.this.ctS.a(new com.tencent.luggage.d.d() {
                        /* class com.tencent.mm.plugin.webview.luggage.g.AnonymousClass8.AnonymousClass1 */

                        @Override // com.tencent.luggage.d.d
                        public final String name() {
                            return "onGetKeyboardHeight";
                        }

                        @Override // com.tencent.luggage.d.d
                        public final JSONObject Ld() {
                            AppMethodBeat.i(210884);
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("height", 0);
                            } catch (Exception e2) {
                            }
                            AppMethodBeat.o(210884);
                            return jSONObject;
                        }
                    });
                    AppMethodBeat.o(210885);
                }
            });
        }
        AppMethodBeat.o(78329);
    }
}
