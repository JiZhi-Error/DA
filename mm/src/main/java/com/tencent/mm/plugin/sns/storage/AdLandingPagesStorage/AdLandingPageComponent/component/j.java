package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.aa;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.g.a.vc;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.sns.ad.landingpage.helper.a.a;
import com.tencent.mm.plugin.sns.ad.landingpage.helper.a.b;
import com.tencent.mm.plugin.sns.data.h;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.an;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.webview.ui.tools.widget.c;
import com.tencent.mm.plugin.webview.ui.tools.widget.d;
import com.tencent.mm.plugin.webview.ui.tools.widget.f;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import com.tencent.xweb.WebView;
import java.io.OutputStream;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class j extends m {
    IListener<vc> EcF;
    private final String[] EcG = {"weixin.qq.com", "wxs.qq.com"};
    private Runnable EcH = new Runnable() {
        /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.j.AnonymousClass2 */

        public final void run() {
            ViewGroup viewGroup;
            AppMethodBeat.i(176275);
            try {
                MMWebView mMWebView = j.this.iGY;
                if (mMWebView != null && mMWebView.isAttachedToWindow() && (viewGroup = (ViewGroup) mMWebView.getChildAt(0)) != null && viewGroup.getChildCount() > 0) {
                    viewGroup.setPadding(0, 0, 0, 0);
                    View childAt = viewGroup.getChildAt(0);
                    if (childAt != null) {
                        childAt.requestLayout();
                    }
                }
                AppMethodBeat.o(176275);
            } catch (Throwable th) {
                Log.w("AdLandingNewH5Comp", "there is something in wevView fix!");
                AppMethodBeat.o(176275);
            }
        }
    };
    h EcI = null;
    MMWebView iGY;
    private com.tencent.mm.plugin.webview.d.h mHt;
    private volatile boolean mIsDestroyed = false;

    public j(Context context, z zVar, ViewGroup viewGroup) {
        super(context, zVar, viewGroup);
        AppMethodBeat.i(202887);
        AppMethodBeat.o(202887);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eWT() {
        String str;
        AppMethodBeat.i(96462);
        if (((an) fdr()) != null) {
            WebView webView = (WebView) getView();
            an anVar = (an) fdr();
            if (!TextUtils.isEmpty(anVar.url)) {
                String uin = AdLandingPagesProxy.getInstance().getUin();
                String n = ap.n(anVar.url, "uxinfo=" + fds().uxInfo, "uin=".concat(String.valueOf(uin)));
                if (anVar.subType == 1) {
                    String adVoteInfo = AdLandingPagesProxy.getInstance().getAdVoteInfo(anVar.url, fds().uxInfo, uin);
                    if (!Util.isNullOrNil(adVoteInfo)) {
                        str = n + "&" + adVoteInfo;
                        Log.i("AdLandingNewH5Comp", "final url=".concat(String.valueOf(str)));
                    }
                }
                str = n;
                Log.i("AdLandingNewH5Comp", "final url=".concat(String.valueOf(str)));
            } else {
                str = anVar.url;
            }
            webView.loadUrl(str);
        }
        try {
            if (this.EcF == null) {
                this.EcF = new IListener<vc>() {
                    /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.j.AnonymousClass5 */

                    {
                        AppMethodBeat.i(202882);
                        this.__eventId = vc.class.getName().hashCode();
                        AppMethodBeat.o(202882);
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
                    @Override // com.tencent.mm.sdk.event.IListener
                    public final /* synthetic */ boolean callback(vc vcVar) {
                        AppMethodBeat.i(202884);
                        boolean a2 = a(vcVar);
                        AppMethodBeat.o(202884);
                        return a2;
                    }

                    private boolean a(vc vcVar) {
                        MMWebView mMWebView;
                        AppMethodBeat.i(202883);
                        try {
                            j jVar = j.this;
                            int i2 = vcVar.ebu.ebv;
                            if (jVar.EcF != null) {
                                jVar.EcF.dead();
                                jVar.EcF = null;
                            }
                            if (5 == i2 && (mMWebView = jVar.iGY) != null) {
                                mMWebView.setCleanOnDetached(true);
                            }
                        } catch (Throwable th) {
                        }
                        AppMethodBeat.o(202883);
                        return false;
                    }
                };
                this.EcF.alive();
            }
            AppMethodBeat.o(96462);
        } catch (Throwable th) {
            AppMethodBeat.o(96462);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eWX() {
        AppMethodBeat.i(96463);
        ViewGroup.LayoutParams layoutParams = this.contentView.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).setMargins((int) this.EcX.paddingLeft, (int) this.EcX.paddingTop, (int) this.EcX.paddingRight, (int) this.EcX.paddingBottom);
        }
        this.contentView.setLayoutParams(layoutParams);
        AppMethodBeat.o(96463);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final View eWY() {
        AppMethodBeat.i(96464);
        this.mIsDestroyed = false;
        this.iGY = f.a.Jys.eK(this.context);
        this.iGY.setCleanOnDetached(false);
        this.iGY.getSettings().hsR();
        this.iGY.getSettings().hsV();
        this.iGY.getSettings().hsU();
        this.iGY.setWebViewClient(c.a.Jyr.a(this.iGY, false, (d) new d() {
            /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.j.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.webview.ui.tools.widget.d
            public final boolean f(int i2, Bundle bundle) {
                AppMethodBeat.i(96461);
                Log.i("AdLandingNewH5Comp", "callback, actionCode=".concat(String.valueOf(i2)));
                switch (i2) {
                    case 150:
                        an anVar = (an) j.this.fdr();
                        AdLandingPagesProxy.getInstance().saveAdVoteInfo(anVar.url, j.this.fds().uxInfo, j.this.fds().uin, bundle.getInt("sns_landing_pages_ad_vote_index"), 0, bundle.getString("sns_landing_pages_ad_vote_result"));
                        break;
                    case 151:
                        try {
                            Intent intent = new Intent();
                            String n = ap.n(bundle.getString("sns_landing_pages_ad_jumpurl"), "traceid=" + j.this.fds().kZe, "aid=" + j.this.fds().aid);
                            String str = j.this.fds().DZW;
                            if (TextUtils.isEmpty(str)) {
                                str = j.this.fds().uxInfo;
                                Log.i("AdLandingNewH5Comp", "opJumpView, use orig_UxInfo:".concat(String.valueOf(str)));
                            } else {
                                Log.i("AdLandingNewH5Comp", "opJumpView, use updated_UxInfo:".concat(String.valueOf(str)));
                            }
                            String kb = r.kb(n, str);
                            r.h(intent, str);
                            intent.putExtra("rawUrl", kb);
                            intent.putExtra("useJs", true);
                            intent.putExtra("type", -255);
                            intent.putExtra("geta8key_scene", 2);
                            com.tencent.mm.br.c.b(j.this.context, "webview", ".ui.tools.WebViewUI", intent);
                            Log.i("AdLandingNewH5Comp", "jumpUrl, finalUrl=".concat(String.valueOf(kb)));
                            break;
                        } catch (Exception e2) {
                            Log.e("AdLandingNewH5Comp", "OptJump exp=" + e2.toString());
                            break;
                        }
                    case 152:
                        boolean ks = j.this.ks(bundle.getString("sns_landing_pages_h5_params"), bundle.getString("callbackId"));
                        AppMethodBeat.o(96461);
                        return ks;
                }
                AppMethodBeat.o(96461);
                return false;
            }
        }));
        MMWebView mMWebView = this.iGY;
        AppMethodBeat.o(96464);
        return mMWebView;
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eXd() {
        AppMethodBeat.i(96465);
        super.eXd();
        WebView webView = (WebView) getView();
        if (!(webView == null || webView.getParent() == null)) {
            ((ViewGroup) webView.getParent()).removeView(webView);
            webView.setTag(null);
            webView.destroy();
        }
        this.mIsDestroyed = true;
        this.mHt = null;
        this.contentView = null;
        AppMethodBeat.o(96465);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eWZ() {
        AppMethodBeat.i(202888);
        super.eWZ();
        try {
            MMWebView mMWebView = this.iGY;
            if (mMWebView != null) {
                mMWebView.postOnAnimation(this.EcH);
            }
            AppMethodBeat.o(202888);
        } catch (Throwable th) {
            AppMethodBeat.o(202888);
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean ks(String str, String str2) {
        AppMethodBeat.i(202889);
        try {
            Log.i("AdLandingNewH5Comp", "handleJSAPI, params=".concat(String.valueOf(str)));
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("funcName");
            if ("opUpdateContentHeight".equals(optString)) {
                final int i2 = jSONObject.getInt("height");
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.j.AnonymousClass3 */

                    public final void run() {
                        AppMethodBeat.i(202879);
                        if (j.this.contentView != null && i2 >= 0) {
                            try {
                                ViewGroup.LayoutParams layoutParams = j.this.contentView.getLayoutParams();
                                int a2 = (int) i.a((double) i2, 1, 750, 1);
                                Log.i("AdLandingNewH5Comp", "adJuestHeight, curH=" + layoutParams.height + ", newH=" + i2 + ", newPx=" + a2);
                                if (layoutParams.height != a2) {
                                    ((an) j.this.fdr()).DZl = (float) a2;
                                    j.this.fdp();
                                }
                                AppMethodBeat.o(202879);
                                return;
                            } catch (Exception e2) {
                                Log.e("AdLandingNewH5Comp", "adJuestHeight exp=" + e2.toString());
                            }
                        }
                        AppMethodBeat.o(202879);
                    }
                });
            } else if ("opStartQRScan".equals(optString)) {
                jSONObject.getString("scanUrl");
            } else if ("opEndQRScan".equals(optString)) {
                final String string = jSONObject.getString("scanUrl");
                try {
                    if (this.EcI == null) {
                        Bundle bundle = new Bundle();
                        an anVar = (an) fdr();
                        bundle.putString("qrExtInfo", anVar != null ? anVar.DYM : "");
                        this.EcI = new h(this.context, fds(), 2, bundle);
                    }
                    String kz = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.kz("adId", string);
                    if (TextUtils.isEmpty(kz) || !s.YS(kz)) {
                        Bitmap bitmapFromView = BitmapUtil.getBitmapFromView(this.contentView);
                        if (bitmapFromView != null) {
                            Log.i("AdLandingNewH5Comp", "shoot webView succ");
                            String kz2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.kz("adId", string + "_shoot");
                            OutputStream ap = s.ap(new o(kz2));
                            boolean compress = bitmapFromView.compress(Bitmap.CompressFormat.JPEG, 100, ap);
                            ap.flush();
                            ap.close();
                            if (compress) {
                                Log.i("AdLandingNewH5Comp", "shoot save succ");
                                this.EcI.jX(kz2, string);
                            }
                        }
                        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(string, ((an) fdr()).DZj, new f.a() {
                            /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.j.AnonymousClass4 */

                            @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                            public final void eWN() {
                            }

                            @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                            public final void eWO() {
                                AppMethodBeat.i(202880);
                                Log.e("AdLandingNewH5Comp", "onDownloadError, imageUrl=" + string);
                                AppMethodBeat.o(202880);
                            }

                            @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                            public final void aNH(String str) {
                                AppMethodBeat.i(202881);
                                Log.i("AdLandingNewH5Comp", "onDownloaded, imageUrl=" + string);
                                AppMethodBeat.o(202881);
                            }
                        });
                    } else {
                        Log.i("AdLandingNewH5Comp", "local file exists, imageUrl=".concat(String.valueOf(string)));
                        this.EcI.jX(kz, string);
                    }
                } catch (Throwable th) {
                    Log.e("AdLandingNewH5Comp", "handleQR, exp=" + th.toString());
                }
            } else if ("opGetLocation".equals(optString)) {
                String optString2 = jSONObject.optString("type");
                b a2 = com.tencent.mm.plugin.sns.ad.landingpage.helper.a.a.a(this.context, new a(str2, this));
                if (a2 != null) {
                    a2.request(optString2);
                }
                AppMethodBeat.o(202889);
                return true;
            } else if ("opGetDeviceInfo".equals(optString)) {
                if (!aPW(this.iGY.getUrl())) {
                    l(str2, -2, "url permission denied", "");
                } else {
                    if (!com.tencent.mm.pluginsdk.permission.b.e(this.context, "android.permission.READ_PHONE_STATE")) {
                        l(str2, -3, "system permission denied", "");
                    } else {
                        String dr = q.dr(false);
                        if (TextUtils.isEmpty(dr)) {
                            l(str2, -1, "id is empty", "");
                        } else {
                            l(str2, 0, "ok", MD5Util.getMD5String(dr));
                        }
                    }
                }
                AppMethodBeat.o(202889);
                return true;
            }
        } catch (Exception e2) {
            Log.e("AdLandingNewH5Comp", "handleJSAPI, exp=" + e2.toString());
        }
        AppMethodBeat.o(202889);
        return false;
    }

    private void l(String str, int i2, String str2, String str3) {
        AppMethodBeat.i(202890);
        HashMap hashMap = new HashMap();
        hashMap.put("ret", Integer.valueOf(i2));
        hashMap.put(TPDownloadProxyEnum.USER_DEVICE_ID, Util.nullAsNil(str3));
        g(str, str2, hashMap);
        AppMethodBeat.o(202890);
    }

    private boolean aPW(String str) {
        AppMethodBeat.i(202891);
        int a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_ad_landing_page_form_device_id, 1);
        Log.d("AdLandingNewH5Comp", "checkDeviceInfoUrlPermission::expt value is ".concat(String.valueOf(a2)));
        if (a2 == 0) {
            AppMethodBeat.o(202891);
            return false;
        } else if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(202891);
            return false;
        } else {
            String host = Uri.parse(str).getHost();
            if (host != null && com.tencent.mm.plugin.sns.ad.i.c.x(this.EcG)) {
                String[] strArr = this.EcG;
                for (String str2 : strArr) {
                    if (str2 != null && host.contains(str2)) {
                        AppMethodBeat.o(202891);
                        return true;
                    }
                }
            }
            Log.d("AdLandingNewH5Comp", "checkDeviceInfoUrlPermission::the domain is ".concat(String.valueOf(host)));
            AppMethodBeat.o(202891);
            return false;
        }
    }

    private static Method aW(Class<?> cls) {
        AppMethodBeat.i(202892);
        try {
            Method method = cls.getMethod("getJsapi", new Class[0]);
            AppMethodBeat.o(202892);
            return method;
        } catch (Throwable th) {
            Log.e("AdLandingNewH5Comp", "there is no method named getJsapi");
            AppMethodBeat.o(202892);
            return null;
        }
    }

    private static Method aX(Class<?> cls) {
        AppMethodBeat.i(202893);
        Method method = null;
        try {
            Method[] declaredMethods = cls.getDeclaredMethods();
            int length = declaredMethods.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                Method method2 = declaredMethods[i2];
                Class<?> returnType = method2.getReturnType();
                Class<?>[] parameterTypes = method2.getParameterTypes();
                if (returnType == com.tencent.mm.plugin.webview.d.h.class && com.tencent.mm.plugin.sns.ad.i.c.w(parameterTypes)) {
                    method = method2;
                    break;
                }
                i2++;
            }
            if (method == null) {
                Log.w("AdLandingNewH5Comp", "there is no method satisfying the condition");
            }
        } catch (Throwable th) {
            Log.e("AdLandingNewH5Comp", "finding the js method occurs something exception");
        }
        AppMethodBeat.o(202893);
        return method;
    }

    private void fdd() {
        com.tencent.mm.plugin.webview.d.h hVar;
        AppMethodBeat.i(202894);
        if (this.mHt == null && !this.mIsDestroyed) {
            try {
                aa aaVar = (aa) g.af(aa.class);
                if (aaVar != null) {
                    hVar = aaVar.b(this.iGY);
                } else {
                    hVar = null;
                }
                if (hVar != null) {
                    Log.d("AdLandingNewH5Comp", "the jsApiHandler is set from service");
                    this.mHt = hVar;
                } else {
                    Log.w("AdLandingNewH5Comp", "the jsApiHandler is null from service!");
                }
            } catch (Throwable th) {
                Log.e("AdLandingNewH5Comp", "ensureJsApiHandlerFromService has something wrong!!");
            }
            if (this.mHt == null) {
                try {
                    long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
                    Class<?> cls = this.iGY.getClass();
                    Method aW = aW(cls);
                    if (aW == null) {
                        Log.i("AdLandingNewH5Comp", "the js method is not found in getJsapiMethod, try to findJsapiMethod");
                        aW = aX(cls);
                    }
                    if (aW == null) {
                        Log.w("AdLandingNewH5Comp", "the js method is not found!");
                        AppMethodBeat.o(202894);
                        return;
                    }
                    Object invoke = aW.invoke(this.iGY, new Object[0]);
                    if (invoke instanceof com.tencent.mm.plugin.webview.d.h) {
                        Log.i("AdLandingNewH5Comp", "the method return type is js api in ensureJsApiHandlerFromWebView");
                        this.mHt = (com.tencent.mm.plugin.webview.d.h) invoke;
                    } else {
                        Log.w("AdLandingNewH5Comp", "the method return value is null ??");
                    }
                    Log.i("AdLandingNewH5Comp", "get the js api handler takes : " + (SystemClock.currentThreadTimeMillis() - currentThreadTimeMillis));
                    AppMethodBeat.o(202894);
                    return;
                } catch (Throwable th2) {
                    Log.e("AdLandingNewH5Comp", "there is no getJsApiHandler method, the jsApiHandler object may be null!!");
                }
            }
        }
        AppMethodBeat.o(202894);
    }

    /* access modifiers changed from: package-private */
    public final void g(String str, String str2, Map<String, Object> map) {
        AppMethodBeat.i(202895);
        fdd();
        com.tencent.mm.plugin.webview.d.h hVar = this.mHt;
        if (hVar != null) {
            Log.d("AdLandingNewH5Comp", "the js api handler is called!!");
            hVar.a(str, str2, map, true);
            AppMethodBeat.o(202895);
            return;
        }
        Log.w("AdLandingNewH5Comp", "the js api handler is null!!");
        AppMethodBeat.o(202895);
    }

    /* access modifiers changed from: package-private */
    public static class a implements a.AbstractC1706a {
        private String EcL;
        private Reference<j> EcM;

        a(String str, j jVar) {
            AppMethodBeat.i(202885);
            this.EcL = str;
            this.EcM = new WeakReference(jVar);
            AppMethodBeat.o(202885);
        }

        @Override // com.tencent.mm.plugin.sns.ad.landingpage.helper.a.a.AbstractC1706a
        public final void aH(Map<String, Object> map) {
            AppMethodBeat.i(202886);
            try {
                Log.i("AdLandingNewH5Comp", "onGeoCallback is called!");
                String str = this.EcL;
                j jVar = this.EcM.get();
                if (!(str == null || jVar == null)) {
                    jVar.g(str, "GEO", map);
                }
                AppMethodBeat.o(202886);
            } catch (Throwable th) {
                Log.e("AdLandingNewH5Comp", "there is a exception in onGeoCallback");
                AppMethodBeat.o(202886);
            }
        }
    }
}
