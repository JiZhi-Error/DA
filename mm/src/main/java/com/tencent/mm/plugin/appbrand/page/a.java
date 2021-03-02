package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.os.SystemClock;
import android.support.v4.view.u;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.tencent.luggage.sdk.b.a.c;
import com.tencent.luggage.sdk.b.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.aq;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.b;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.page.a.f;
import com.tencent.mm.plugin.appbrand.page.a.h;
import com.tencent.mm.plugin.appbrand.page.aj;
import com.tencent.mm.plugin.appbrand.page.ao;
import com.tencent.mm.plugin.appbrand.page.bh;
import com.tencent.mm.plugin.appbrand.performance.g;
import com.tencent.mm.plugin.appbrand.utils.m;
import com.tencent.mm.plugin.appbrand.utils.s;
import com.tencent.mm.plugin.appbrand.widget.input.al;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.URL;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class a<PAGE extends com.tencent.luggage.sdk.b.a.c> extends com.tencent.luggage.sdk.b.a.b.a<PAGE> implements com.tencent.luggage.sdk.b.a.d, com.tencent.mm.plugin.appbrand.page.a.c {
    String lBI;
    ViewGroup nmW;
    bb nmX;
    boolean nmY = false;
    private boolean nmZ = false;
    String nna;
    private aj nnb;
    private bf nnc;
    ao nnd;
    private bp nne;
    boolean nnf;
    a<PAGE>.d nng;
    private be nnh;
    private AbstractC0767a nni;
    bh nnj;

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.plugin.appbrand.page.a$a  reason: collision with other inner class name */
    public interface AbstractC0767a {
        void adu(String str);

        void adv(String str);

        boolean adw(String str);

        void bQv();

        String name();
    }

    /* access modifiers changed from: protected */
    public abstract bb ee(Context context);

    @Override // com.tencent.luggage.sdk.b.a.a.AbstractC0178a, com.tencent.mm.plugin.appbrand.page.ae
    public <T> T S(Class<T> cls) {
        if (ICommLibReader.class.equals(cls)) {
            return cls.cast(((com.tencent.luggage.sdk.b.a.c) NN()).bqZ());
        }
        return cls.isInstance(this) ? cls.cast(this) : (T) super.S(cls);
    }

    /* access modifiers changed from: protected */
    public boolean bQr() {
        if (NN() == null || !((com.tencent.luggage.sdk.b.a.c) NN()).nqW) {
            return true;
        }
        return false;
    }

    public a(PAGE page) {
        super(page);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.ae
    public final View a(LayoutInflater layoutInflater) {
        return new FrameLayout(layoutInflater.getContext());
    }

    @Override // com.tencent.mm.plugin.appbrand.page.ae
    public void cb(View view) {
        this.nmW = (FrameLayout) view;
        this.nmW.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
            /* class com.tencent.mm.plugin.appbrand.page.a.AnonymousClass1 */

            public final void onViewAttachedToWindow(View view) {
            }

            public final void onViewDetachedFromWindow(View view) {
                AppMethodBeat.i(147413);
                ao aoVar = a.this.nnd;
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                obtain.setSource(4098);
                for (ao.b bVar : aoVar.nsv) {
                    View view2 = bVar.nsR.get();
                    if (view2 != null) {
                        view2.dispatchTouchEvent(obtain);
                    }
                }
                obtain.recycle();
                AppMethodBeat.o(147413);
            }
        });
        this.nnc = new al((ac) NN());
        if (this.nmX == null) {
            ((com.tencent.luggage.sdk.b.a.c) NN()).bEb();
        }
        this.nmX.aG(getContext());
        this.nmX.setFullscreenImpl(((com.tencent.luggage.sdk.b.a.c) NN()).getFullscreenImpl());
        this.nmX.setOnScrollChangedListener(this.nnc);
        this.nmX.setWebViewLayoutListener(this.nnc);
        this.nnc.setupWebViewTouchInterceptor(this.nmX);
        this.nnb = new aj(getContext(), this.nmX);
        this.nnb.addView(this.nnc.getContainer());
        this.nnb.setOnPullDownOffsetListener(this.nnc);
        this.nnb.setOnPullDownListener(new aj.a() {
            /* class com.tencent.mm.plugin.appbrand.page.a.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.appbrand.page.aj.a
            public final void bQy() {
                AppMethodBeat.i(147414);
                if (a.this.NN() == null) {
                    AppMethodBeat.o(147414);
                    return;
                }
                ((com.tencent.luggage.sdk.b.a.c) a.this.NN()).b("onPullDownRefresh", (String) null, new int[]{((com.tencent.luggage.sdk.b.a.c) a.this.NN()).getComponentId()});
                AppMethodBeat.o(147414);
            }
        });
        this.nmW.addView(this.nnb);
        this.nnd = new ao(this.nnc.getContainer());
        this.nnd.setFullscreenImpl(((com.tencent.luggage.sdk.b.a.c) NN()).getFullscreenImpl());
    }

    @Override // com.tencent.mm.plugin.appbrand.page.ae
    public final RelativeLayout.LayoutParams cc(View view) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (view != null) {
            if (view.getId() == -1) {
                view.setId(R.id.po);
            }
            layoutParams.addRule(2, view.getId());
        }
        return layoutParams;
    }

    public final boolean isRunning() {
        com.tencent.luggage.sdk.b.a.c cVar = (com.tencent.luggage.sdk.b.a.c) NN();
        return cVar != null && cVar.isRunning();
    }

    @Override // com.tencent.luggage.sdk.b.a.b.a, com.tencent.mm.plugin.appbrand.page.ae
    public final void b(com.tencent.mm.plugin.appbrand.widget.actionbar.b bVar) {
        super.b(com.tencent.mm.plugin.appbrand.page.a.a.class, new bk((ac) NN()));
        super.b(bVar);
    }

    /* access modifiers changed from: protected */
    public final String getURL() {
        return this.lBI;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.ae
    public final bf Nc() {
        return this.nnc;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.ae
    public final ao getCustomViewContainer() {
        return this.nnd;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.a.c
    public Map<String, p> Nf() {
        return new com.tencent.luggage.sdk.a().Nt();
    }

    /* access modifiers changed from: package-private */
    public final void c(JSONObject jSONObject, String str, Object obj) {
        ((com.tencent.luggage.sdk.b.a.c) NN()).c(jSONObject, str, obj);
    }

    /* access modifiers changed from: package-private */
    public final class d extends ay {
        public d(Context context) {
            super(context);
        }

        @Override // com.tencent.mm.plugin.appbrand.page.ay
        @JavascriptInterface
        public final float getWidth() {
            AppMethodBeat.i(147429);
            float ceil = (float) Math.ceil((double) (((float) a.this.NP().getWindowAndroid().getVDisplayMetrics().widthPixels) / getPixelRatio()));
            float ceil2 = (float) Math.ceil((double) (((float) a.this.nmW.getWidth()) / super.getPixelRatio()));
            if (ceil2 > 0.0f && ceil2 != ceil) {
                Log.w("Luggage.AbstractMPPageViewRenderer", "__deviceInfo.getWidth(), resources[%f] != view[%f], may in pad env", Float.valueOf(ceil), Float.valueOf(ceil2));
            }
            AppMethodBeat.o(147429);
            return ceil;
        }
    }

    /* access modifiers changed from: protected */
    public g bQs() {
        return new g() {
            /* class com.tencent.mm.plugin.appbrand.page.a.AnonymousClass5 */

            @Override // com.tencent.mm.plugin.appbrand.performance.g
            public final void notifyLongTask(long j2) {
                AppMethodBeat.i(169500);
                Log.d("Luggage.AbstractMPPageViewRenderer", "notifyLongTask :%d", Long.valueOf(j2));
                AppMethodBeat.o(169500);
            }
        };
    }

    @Override // com.tencent.mm.plugin.appbrand.page.a.c
    public final bb aI(Context context) {
        if (context == null) {
            context = getContext();
        }
        this.nmX = ee(context);
        if (System.currentTimeMillis() % 1000 == 1 || WeChatEnvironment.hasDebugger() || BuildInfo.IS_FLAVOR_RED) {
            Log.i("Luggage.AbstractMPPageViewRenderer", "do observeLongTask");
            this.nmX.addJavascriptInterface(bQs(), "PageLongTaskReporter");
            this.nnf = true;
        }
        bb bbVar = this.nmX;
        a<PAGE>.d dVar = new d(context);
        this.nng = dVar;
        bbVar.addJavascriptInterface(dVar, "__deviceInfo");
        return this.nmX;
    }

    /* access modifiers changed from: protected */
    public final void eD(String str, String str2) {
        URL url;
        if (TextUtils.isEmpty(str2)) {
            Log.e("Luggage.AbstractMPPageViewRenderer", "[!]injectScript appId[%s] name[%s] url[%s] hash[%d] source EMPTY", getAppId(), str, this.lBI, Integer.valueOf(hashCode()));
            return;
        }
        final d.a aVar = new d.a();
        aVar.scriptName = str;
        aVar.czz = str2;
        aVar.czA = str2.length();
        final long currentTimeMillis = System.currentTimeMillis();
        Log.i("Luggage.AbstractMPPageViewRenderer", "injectScript start, appId[%s] name[%s] url[%s] hash[%d]", getAppId(), str, this.lBI, Integer.valueOf(hashCode()));
        try {
            if (TextUtils.isEmpty(str)) {
                Log.w("Luggage.AbstractMPPageViewRenderer", "[!] injectScript, valid name is required, appId:%s, url:%s", getAppId(), this.lBI);
                url = null;
            } else {
                url = new URL("https", WeChatHosts.domainString(R.string.e2b), str);
            }
        } catch (Exception e2) {
            url = null;
        }
        s.a(((com.tencent.luggage.sdk.b.a.c) NN()).getJsRuntime(), url, str2, new s.a() {
            /* class com.tencent.mm.plugin.appbrand.page.a.AnonymousClass6 */

            @Override // com.tencent.mm.plugin.appbrand.utils.s.a
            public final void onSuccess(String str) {
                AppMethodBeat.i(169501);
                dP(true);
                AppMethodBeat.o(169501);
            }

            @Override // com.tencent.mm.plugin.appbrand.utils.s.a
            public final void du(String str) {
                AppMethodBeat.i(169502);
                dP(false);
                AppMethodBeat.o(169502);
            }

            private void dP(boolean z) {
                AppMethodBeat.i(169503);
                a.this.a(aVar, z, currentTimeMillis, System.currentTimeMillis(), null);
                AppMethodBeat.o(169503);
            }
        });
    }

    public void a(d.a aVar, boolean z, long j2, long j3, Object obj) {
    }

    @Override // com.tencent.mm.plugin.appbrand.page.a.c
    public boolean b(String str, String str2, int i2) {
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.a.c
    public boolean y(String str, String str2) {
        return false;
    }

    /* access modifiers changed from: protected */
    public final AbstractC0767a ads(String str) {
        if (this.nni == null) {
            this.nni = ((aa) ((com.tencent.luggage.sdk.b.a.c) NN()).av(aa.class)).bRa() ? new b(this, (byte) 0) : new c(this, (byte) 0);
            bh.a aVar = bh.ntk;
            this.nnj = bh.a.d(this);
            Log.i("Luggage.AbstractMPPageViewRenderer", "getInjectionMode created mode name = %s, appId = %s, reason = %s", this.nni.name(), getAppId(), str);
        }
        return this.nni;
    }

    /* access modifiers changed from: protected */
    public final be bQt() {
        if (this.nnh == null) {
            this.nnh = bQu();
            if (this.nnh == null) {
                this.nnh = new bi(this);
            }
        }
        return this.nnh;
    }

    /* access modifiers changed from: protected */
    public be bQu() {
        return null;
    }

    /* access modifiers changed from: protected */
    public final void bQv() {
        if (!this.nmY) {
            try {
                ads("injectAppSharedPageFrameScript").bQv();
                this.nmY = true;
            } catch (aq e2) {
            }
        }
    }

    public void adt(String str) {
        ((com.tencent.luggage.sdk.b.a.c) NN()).dF(str);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.ae
    public boolean dy(String str) {
        this.lBI = ((com.tencent.luggage.sdk.b.a.c) NN()).lBI;
        this.nna = ((com.tencent.luggage.sdk.b.a.c) NN()).nna;
        super.b(f.class, new bm((ac) NN(), this.nnb) {
            /* class com.tencent.mm.plugin.appbrand.page.a.AnonymousClass4 */

            @Override // com.tencent.mm.plugin.appbrand.page.a.f, com.tencent.mm.plugin.appbrand.page.bm
            public final void eE(String str, String str2) {
                AppMethodBeat.i(147417);
                boolean bzD = a.this.NP().getAppConfig().bzD();
                a(f.a.az(str, bzD), com.tencent.mm.plugin.appbrand.ac.g.cu(str2, a.this.NP().mContext.getResources().getColor(bzD ? R.color.f3045c : R.color.am)));
                AppMethodBeat.o(147417);
            }

            @Override // com.tencent.mm.plugin.appbrand.page.a.f, com.tencent.mm.plugin.appbrand.page.bm
            public final void a(f.a aVar, final int i2) {
                AppMethodBeat.i(147418);
                super.a(aVar, i2);
                if (a.this.NN() == null) {
                    AppMethodBeat.o(147418);
                    return;
                }
                ((com.tencent.luggage.sdk.b.a.c) a.this.NN()).P(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.page.a.AnonymousClass4.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(147416);
                        if (!(a.this.NN() == null || ((com.tencent.luggage.sdk.b.a.c) a.this.NN()).getContentView() == null)) {
                            ((com.tencent.luggage.sdk.b.a.c) a.this.NN()).getContentView().setBackgroundColor(i2);
                        }
                        if (a.this.nne != null) {
                            a.this.nne.setBackgroundColor(i2);
                        }
                        AppMethodBeat.o(147416);
                    }
                });
                AppMethodBeat.o(147418);
            }
        });
        this.nnd.a(new bd() {
            /* class com.tencent.mm.plugin.appbrand.page.a.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.appbrand.page.bd
            public final void a(AppBrandPageFullScreenView appBrandPageFullScreenView) {
                AppMethodBeat.i(147415);
                if (((com.tencent.luggage.sdk.b.a.c) a.this.NN()).nqU == null) {
                    Log.e("Luggage.AbstractMPPageViewRenderer", "FullScreenViewAttach getContainerPage is null, check time sequence, err, appId[%s], url[%s]", a.this.getAppId(), a.this.lBI);
                    AppMethodBeat.o(147415);
                    return;
                }
                ((com.tencent.luggage.sdk.b.a.c) a.this.NN()).nqU.a((ac) a.this.NN(), appBrandPageFullScreenView);
                AppMethodBeat.o(147415);
            }
        });
        b.d pageConfig = ((com.tencent.luggage.sdk.b.a.c) NN()).getPageConfig();
        ((com.tencent.luggage.sdk.b.a.c) NN()).bOF();
        bl blVar = (bl) S(bl.class);
        String str2 = pageConfig.lcB;
        blVar.ntx.cAC = false;
        blVar.cwU = str2;
        if (!((com.tencent.luggage.sdk.b.a.c) NN()).bqY().UW(this.lBI)) {
            Log.e("Luggage.AbstractMPPageViewRenderer", "Empty page content, appId[%s] url[%s], abort inject", getAppId(), str);
            adt(str);
            return false;
        }
        if (bQr()) {
            this.nne = new bp(NP().mContext, (ac) NN());
        }
        bQw();
        bQv();
        String str3 = this.lBI;
        try {
            ads(String.format(Locale.ENGLISH, "injectModuleSharedPageFrameScript(%s)", str3)).adu(str3);
        } catch (aq e2) {
            Log.e("Luggage.AbstractMPPageViewRenderer", "injectModuleSharedPageFrameScript appId[%s] path[%s] ScriptNotFoundException", getAppId(), str3);
            NP().finish();
        }
        String str4 = this.lBI;
        try {
            ads(String.format(Locale.ENGLISH, "injectPageScript(%s)", str4)).adv(str4);
        } catch (aq e3) {
            Log.e("Luggage.AbstractMPPageViewRenderer", "injectPageScript appId[%s] url[%s] ScriptNotFoundException", getAppId(), str4);
            NP().finish();
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void bQw() {
    }

    private void bQx() {
        if (this.nne != null) {
            this.nne.setVisibility(8);
            if (u.aD(this.nne)) {
                ((com.tencent.luggage.sdk.b.a.c) NN()).bRi().setNavLoadingIconVisibilityResetListener(null);
                ((com.tencent.luggage.sdk.b.a.c) NN()).bRi().setLoadingIconVisibility(this.nne.nuo);
                ((ViewGroup) this.nne.getParent()).removeView(this.nne);
                Log.i("Luggage.AbstractMPPageViewRenderer", "dismissWaitingReadyCover appId:%s, url:%s", getAppId(), this.lBI);
            }
        }
    }

    @Override // com.tencent.luggage.sdk.b.a.b.a, com.tencent.mm.plugin.appbrand.page.ae
    public void dispatchStart() {
        super.dispatchStart();
        super.b(com.tencent.mm.plugin.appbrand.page.a.d.class, new bl((ac) NN()));
        super.b(h.class, new bo((ac) NN()));
        AnonymousClass7 r0 = new m() {
            /* class com.tencent.mm.plugin.appbrand.page.a.AnonymousClass7 */

            @Override // com.tencent.mm.plugin.appbrand.utils.m, java.lang.reflect.InvocationHandler
            public final Object invoke(Object obj, Method method, Object[] objArr) {
                AppMethodBeat.i(169504);
                Log.e("Luggage.AbstractMPPageViewRenderer", "DummyPullDownExtension: invoke(%s), args=%s", method.getName(), org.apache.commons.b.a.toString(objArr, "NULL"));
                Object invoke = super.invoke(obj, method, objArr);
                AppMethodBeat.o(169504);
                return invoke;
            }
        };
        super.b(f.class, (f) Proxy.newProxyInstance(f.class.getClassLoader(), new Class[]{f.class}, r0));
        com.tencent.luggage.sdk.b.a.b.b.a((ac) NN());
        if (((com.tencent.luggage.sdk.b.a.c) NN()).NP().getAppConfig().bzD()) {
            this.nmX.setBackgroundColor(android.support.v4.content.b.n(getContext(), R.color.w));
        } else {
            this.nmX.setBackgroundColor(-1);
        }
    }

    @Override // com.tencent.luggage.sdk.b.a.b.a, com.tencent.mm.plugin.appbrand.page.ae
    public void Nd() {
        Log.i("Luggage.AbstractMPPageViewRenderer", "dispatchForeground appId:%s, url:%s, mIsPageReady:%b", getAppId(), this.lBI, Boolean.valueOf(this.nmZ));
        super.Nd();
        this.nmX.onForeground();
        ((com.tencent.luggage.sdk.b.a.c) NN()).NW();
        if (this.nmZ) {
            return;
        }
        if (!bQr()) {
            bQx();
        } else if (this.nne != null) {
            FrameLayout frameLayout = (FrameLayout) this.nmW;
            if (this.nne.getParent() != frameLayout) {
                boolean cag = ((com.tencent.luggage.sdk.b.a.c) NN()).bRi().cag();
                ((com.tencent.luggage.sdk.b.a.c) NN()).bRi().setLoadingIconVisibility(true);
                ((com.tencent.luggage.sdk.b.a.c) NN()).bRi().setNavLoadingIconVisibilityResetListener(this.nne);
                this.nne.nuo = cag;
                if (this.nne.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.nne.getParent()).removeView(this.nne);
                }
                frameLayout.addView(this.nne, new FrameLayout.LayoutParams(-1, -1));
            }
            bp bpVar = this.nne;
            Context context = getContext();
            if (bpVar.nqL != null) {
                bpVar.nqL.aG(context);
            }
            this.nne.bSo();
            this.nne.bringToFront();
            Log.i("Luggage.AbstractMPPageViewRenderer", "revealWaitingReadyCover appId:%s, url:%s", getAppId(), this.lBI);
        }
    }

    @Override // com.tencent.luggage.sdk.b.a.b.a, com.tencent.mm.plugin.appbrand.page.ae
    public void Ne() {
        super.Ne();
        this.nmX.onBackground();
    }

    @Override // com.tencent.mm.plugin.appbrand.page.ae
    public void Ng() {
        Log.i("Luggage.AbstractMPPageViewRenderer", "dispatchPageReady appId:%s, url:%s", getAppId(), this.lBI);
        this.nmZ = true;
        bQx();
    }

    @Override // com.tencent.luggage.sdk.b.a.b.a, com.tencent.mm.plugin.appbrand.page.ae
    public final void dispatchDestroy() {
        super.dispatchDestroy();
        this.nnc.a(this.nmX);
        this.nmX.destroy();
        this.nmX = null;
        this.nmW.removeAllViewsInLayout();
        this.nnb.removeAllViewsInLayout();
        this.nnb = null;
        this.nnc = null;
    }

    public final JSONObject Or() {
        boolean z;
        JSONObject f2 = com.tencent.luggage.sdk.g.b.f(NP().NY().Or());
        try {
            f2.put("isFirstPage", ((com.tencent.luggage.sdk.b.a.c) NN()).nqW);
        } catch (JSONException e2) {
            Log.e("Luggage.AbstractMPPageViewRenderer", "generateWxConfig appId[%s] put isFirstPage e=%s", getAppId(), e2);
        }
        try {
            if (NP().ON().cyz == com.tencent.luggage.sdk.launching.b.PRE_RENDER) {
                z = true;
            } else {
                z = false;
            }
            f2.put("prerender", z);
        } catch (JSONException e3) {
            Log.e("Luggage.AbstractMPPageViewRenderer", "generateWxConfig appId[%s] put prerender e=%s", getAppId(), e3);
        }
        f2.remove("permission");
        f2.remove("subpackages");
        f2.remove("pages");
        return f2;
    }

    /* access modifiers changed from: package-private */
    public final class c implements AbstractC0767a {
        private c() {
        }

        /* synthetic */ c(a aVar, byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.appbrand.page.a.AbstractC0767a
        public final boolean adw(String str) {
            AppMethodBeat.i(229945);
            if ("app-wxss.js".equals(str) || "page-frame.html".equals(str)) {
                AppMethodBeat.o(229945);
                return true;
            }
            AppMethodBeat.o(229945);
            return false;
        }

        @Override // com.tencent.mm.plugin.appbrand.page.a.AbstractC0767a
        public final void bQv() {
            AppMethodBeat.i(147426);
            a.this.nnj.ay(ModulePkgInfo.MAIN_MODULE_NAME, false);
            if (a.this.NP().kAI.bPn()) {
                String adT = a.this.bQt().adT("app-wxss.js");
                if (TextUtils.isEmpty(adT)) {
                    aq aqVar = new aq("app-wxss.js");
                    AppMethodBeat.o(147426);
                    throw aqVar;
                }
                a.this.eD("app-wxss.js", adT);
                AppMethodBeat.o(147426);
                return;
            }
            a.this.eD("page-frame.html", a.this.bQt().adT("page-frame.html"));
            AppMethodBeat.o(147426);
        }

        @Override // com.tencent.mm.plugin.appbrand.page.a.AbstractC0767a
        public final void adu(String str) {
            AppMethodBeat.i(147427);
            if (!a.this.NP().kAI.bPn()) {
                AppMethodBeat.o(147427);
                return;
            }
            String acN = a.this.NP().kAI.acN(str);
            String str2 = acN + (acN.endsWith(FilePathGenerator.ANDROID_DIR_SEP) ? "" : FilePathGenerator.ANDROID_DIR_SEP) + "page-frame.js";
            String adT = a.this.bQt().adT(str2);
            if (TextUtils.isEmpty(adT)) {
                aq aqVar = new aq(str2);
                AppMethodBeat.o(147427);
                throw aqVar;
            }
            a.this.nnj.ay(acN, false);
            a.this.eD(str2, adT);
            AppMethodBeat.o(147427);
        }

        @Override // com.tencent.mm.plugin.appbrand.page.a.AbstractC0767a
        public final void adv(String str) {
            AppMethodBeat.i(147428);
            a.this.eD(str, a.this.bQt().adT(str));
            AppMethodBeat.o(147428);
        }

        @Override // com.tencent.mm.plugin.appbrand.page.a.AbstractC0767a
        public final String name() {
            return "Legacy";
        }
    }

    /* access modifiers changed from: package-private */
    public final class b implements AbstractC0767a {
        private b() {
        }

        /* synthetic */ b(a aVar, byte b2) {
            this();
        }

        private void adx(String str) {
            AppMethodBeat.i(147423);
            String adT = a.this.bQt().adT(str);
            if (TextUtils.isEmpty(adT)) {
                aq aqVar = new aq(str);
                AppMethodBeat.o(147423);
                throw aqVar;
            }
            a.this.eD(str, adT);
            AppMethodBeat.o(147423);
        }

        @Override // com.tencent.mm.plugin.appbrand.page.a.AbstractC0767a
        public final boolean adw(String str) {
            AppMethodBeat.i(229944);
            boolean equals = "webview.app.js".equals(str);
            AppMethodBeat.o(229944);
            return equals;
        }

        @Override // com.tencent.mm.plugin.appbrand.page.a.AbstractC0767a
        public final void bQv() {
            AppMethodBeat.i(147424);
            a.this.nnj.ay(ModulePkgInfo.MAIN_MODULE_NAME, true);
            adx("common.app.js");
            adx("webview.app.js");
            AppMethodBeat.o(147424);
        }

        @Override // com.tencent.mm.plugin.appbrand.page.a.AbstractC0767a
        public final void adu(String str) {
            AppMethodBeat.i(147425);
            if (!a.this.NP().kAI.bPn()) {
                AppMethodBeat.o(147425);
                return;
            }
            String acN = a.this.NP().kAI.acN(str);
            if (ModulePkgInfo.MAIN_MODULE_NAME.equals(acN)) {
                AppMethodBeat.o(147425);
                return;
            }
            a.this.nnj.ay(acN, true);
            String str2 = acN + (acN.endsWith(FilePathGenerator.ANDROID_DIR_SEP) ? "" : FilePathGenerator.ANDROID_DIR_SEP);
            adx(str2 + "common.app.js");
            adx(str2 + "webview.app.js");
            AppMethodBeat.o(147425);
        }

        @Override // com.tencent.mm.plugin.appbrand.page.a.AbstractC0767a
        public final void adv(String str) {
        }

        @Override // com.tencent.mm.plugin.appbrand.page.a.AbstractC0767a
        public final String name() {
            return "LazyCodeLoading";
        }
    }
}
