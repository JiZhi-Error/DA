package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.SparseBooleanArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.common.Scopes;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.e;
import com.tencent.mm.plugin.appbrand.openmaterial.h;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialCollection;
import com.tencent.mm.plugin.appbrand.openmaterial.model.MaterialModel;
import com.tencent.mm.plugin.appbrand.openmaterial.model.b;
import com.tencent.mm.plugin.appbrand.service.i;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.webview.c;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.plugin.webview.ui.tools.browser.e;
import com.tencent.mm.plugin.webview.ui.tools.browser.f;
import com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.o;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LruCache;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class j extends a {
    protected Map<String, SparseBooleanArray> Jgj = new HashMap();
    protected Map<String, Integer> Jgk = new HashMap();
    LruCache<String, Bitmap> Jgl = new LruCache<>(12);
    HashMap<String, String> Jgm = new HashMap<>();
    f Jgn = new f(1);
    public HashMap<Integer, a> Jgo = new HashMap<>();
    public String Jgp;
    HashMap<String, Integer> Jgq = new HashMap<>();
    public boolean Jgr = true;
    public boolean Jgs = false;
    Set<Integer> Jgt = new HashSet();
    m Jgu;
    ArrayList<e.b> Jgv;
    Boolean Jgw;
    String Jgx = null;
    AppBrandOpenMaterialCollection Jgy = null;
    private h Jgz = null;
    private int height;
    private String myD = "";
    com.tencent.mm.ui.widget.a.e nVN;
    private int width;

    static /* synthetic */ void a(j jVar, List list) {
        AppMethodBeat.i(211095);
        jVar.ik(list);
        AppMethodBeat.o(211095);
    }

    static /* synthetic */ void a(j jVar, boolean z) {
        AppMethodBeat.i(259614);
        jVar.FJ(z);
        AppMethodBeat.o(259614);
    }

    public j(WebViewUI webViewUI) {
        super(webViewUI);
        AppMethodBeat.i(79877);
        this.width = webViewUI.getResources().getDisplayMetrics().widthPixels;
        this.height = webViewUI.getResources().getDisplayMetrics().heightPixels;
        AppMethodBeat.o(79877);
    }

    private boolean hXN() {
        AppMethodBeat.i(259611);
        try {
            JsapiPermissionWrapper gdH = geo().IMH.mHi.gdH();
            if (!agI(7) || !a(gdH, 45) || !agH(7) || b(gdH, 45) || this.Jgw.booleanValue()) {
                AppMethodBeat.o(259611);
                return false;
            }
            AppMethodBeat.o(259611);
            return true;
        } catch (Exception e2) {
            Log.w("MicroMsg.WebViewMenuHelper", "canShowOpenMaterials fail since ".concat(String.valueOf(e2)));
            AppMethodBeat.o(259611);
            return false;
        }
    }

    private void FJ(final boolean z) {
        AppMethodBeat.i(259612);
        Log.d("MicroMsg.WebViewMenuHelper", "loadOpenMaterialsIfNeedAndEnhanceBottomSheet, onBottomSheetCreate: ".concat(String.valueOf(z)));
        final i iVar = (i) g.af(i.class);
        if (iVar == null) {
            Log.w("MicroMsg.WebViewMenuHelper", "loadOpenMaterialsIfNeedAndEnhanceBottomSheet, openMaterialService is null");
            AppMethodBeat.o(259612);
        } else if (!iVar.c(b.WEB_VIEW)) {
            Log.i("MicroMsg.WebViewMenuHelper", "loadOpenMaterialsIfNeedAndEnhanceBottomSheet, openMaterialService is disabled");
            AppMethodBeat.o(259612);
        } else {
            WebViewUI geo = geo();
            if (geo == null) {
                Log.w("MicroMsg.WebViewMenuHelper", "loadOpenMaterialsIfNeedAndEnhanceBottomSheet, webViewUI is null");
                AppMethodBeat.o(259612);
                return;
            }
            com.tencent.mm.plugin.webview.core.i iVar2 = geo.IMH;
            if (iVar2 == null) {
                Log.w("MicroMsg.WebViewMenuHelper", "loadOpenMaterialsIfNeedAndEnhanceBottomSheet, controller is null");
                AppMethodBeat.o(259612);
                return;
            }
            final String beU = iVar2.beU();
            Log.d("MicroMsg.WebViewMenuHelper", "loadOpenMaterialsIfNeedAndEnhanceBottomSheet, url: ".concat(String.valueOf(beU)));
            if (Util.isNullOrNil(beU)) {
                Log.w("MicroMsg.WebViewMenuHelper", "loadOpenMaterialsIfNeedAndEnhanceBottomSheet, url is empty");
                com.tencent.f.h.RTc.n(new Runnable() {
                    /* class com.tencent.mm.plugin.webview.ui.tools.j.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(211051);
                        j.a(j.this, z);
                        AppMethodBeat.o(211051);
                    }
                }, 1000);
                AppMethodBeat.o(259612);
                return;
            }
            if (z && this.Jgz != null) {
                this.Jgz.dead();
                this.Jgz = null;
            }
            if (beU.equals(this.Jgx)) {
                Log.i("MicroMsg.WebViewMenuHelper", "loadOpenMaterialsIfNeedAndEnhanceBottomSheet, already load");
                a(iVar);
                AppMethodBeat.o(259612);
                return;
            }
            MaterialModel adp = MaterialModel.adp(beU);
            if (!iVar.adl(adp.mimeType)) {
                Log.i("MicroMsg.WebViewMenuHelper", "loadOpenMaterialsIfNeedAndEnhanceBottomSheet, openMaterialService is not support " + adp.mimeType);
                AppMethodBeat.o(259612);
                return;
            }
            iVar.a(adp, new com.tencent.mm.plugin.appbrand.openmaterial.i() {
                /* class com.tencent.mm.plugin.webview.ui.tools.j.AnonymousClass12 */

                @Override // com.tencent.mm.plugin.appbrand.openmaterial.i
                public final void a(boolean z, AppBrandOpenMaterialCollection appBrandOpenMaterialCollection) {
                    AppMethodBeat.i(211062);
                    if (!z) {
                        Log.i("MicroMsg.WebViewMenuHelper", "loadOpenMaterialsIfNeedAndEnhanceBottomSheet#onMyOpenMaterialsGot, fail");
                        AppMethodBeat.o(211062);
                        return;
                    }
                    j.this.Jgx = beU;
                    j.this.Jgy = appBrandOpenMaterialCollection;
                    j.this.a(iVar);
                    AppMethodBeat.o(211062);
                }
            });
            AppMethodBeat.o(259612);
        }
    }

    public final void onDestroy() {
        AppMethodBeat.i(79878);
        for (SparseBooleanArray sparseBooleanArray : this.Jgj.values()) {
            if (sparseBooleanArray != null) {
                sparseBooleanArray.clear();
            }
        }
        this.Jgj.clear();
        this.Jgq.clear();
        if (this.nVN != null && this.nVN.isShowing()) {
            this.nVN.bMo();
        }
        AppMethodBeat.o(79878);
    }

    public final void geK() {
        AppMethodBeat.i(79879);
        this.Jgk.clear();
        this.Jgk.put("menuItem:share:brand", 0);
        this.Jgk.put("menuItem:share:appMessage", 1);
        this.Jgk.put("menuItem:share:dataMessage", 23);
        this.Jgk.put("menuItem:share:timeline", 2);
        this.Jgk.put("menuItem:favorite", 3);
        this.Jgk.put("menuItem:profile", 5);
        this.Jgk.put("menuItem:addContact", 5);
        this.Jgk.put("menuItem:copyUrl", 6);
        this.Jgk.put("menuItem:openWithSafari", 7);
        this.Jgk.put("menuItem:share:email", 8);
        this.Jgk.put("menuItem:delete", 9);
        this.Jgk.put("menuItem:exposeArticle", 10);
        this.Jgk.put("menuItem:setFont", 11);
        this.Jgk.put("menuItem:editTag", 12);
        this.Jgk.put("menuItem:share:qq", 20);
        this.Jgk.put("menuItem:share:weiboApp", 21);
        this.Jgk.put("menuItem:share:QZone", 22);
        this.Jgk.put("menuItem:share:facebook", 33);
        this.Jgk.put("menuItem:share:enterprise", 24);
        this.Jgk.put("menuItem:refresh", 28);
        this.Jgk.put("menuItem:share:wework", 25);
        this.Jgk.put("menuItem:share:wework_LOCAL", 43);
        this.Jgk.put("menuItem:share:weread", 26);
        this.Jgk.put("menuItem:addShortcut", 29);
        this.Jgk.put("menuItem:search", 31);
        this.Jgk.put("menuItem:readArticle", 34);
        this.Jgk.put("menuItem:minimize", 35);
        this.Jgk.put("menuItem:cancelMinimize", 36);
        this.Jgk.put("menuItem:translate", 37);
        this.Jgk.put("menuItem:haoKan", 38);
        this.Jgk.put("menuItem:cancelHaoKan", 39);
        this.Jgk.put("menuItem:ttsStart", 40);
        this.Jgk.put("menuItem:ttsPause", 41);
        this.Jgk.put("menuItem:ttsResume", 42);
        AppMethodBeat.o(79879);
    }

    public final void g(String str, Intent intent) {
        AppMethodBeat.i(211077);
        SparseBooleanArray sparseBooleanArray = this.Jgj.get(str);
        if (sparseBooleanArray == null) {
            sparseBooleanArray = new SparseBooleanArray();
            this.Jgj.put(str, sparseBooleanArray);
        }
        if (sparseBooleanArray != null) {
            sparseBooleanArray.put(34, true);
            sparseBooleanArray.put(10, intent.getBooleanExtra("key_menu_hide_expose", false));
        }
        AppMethodBeat.o(211077);
    }

    /* access modifiers changed from: protected */
    public final boolean agH(int i2) {
        AppMethodBeat.i(79881);
        SparseBooleanArray sparseBooleanArray = this.Jgj.get(geo().pGj.getUrl());
        if (sparseBooleanArray == null || !sparseBooleanArray.get(i2, false)) {
            AppMethodBeat.o(79881);
            return true;
        }
        AppMethodBeat.o(79881);
        return false;
    }

    protected static boolean a(JsapiPermissionWrapper jsapiPermissionWrapper, int i2) {
        AppMethodBeat.i(79882);
        if (jsapiPermissionWrapper == null) {
            AppMethodBeat.o(79882);
            return false;
        }
        int aiW = jsapiPermissionWrapper.aiW(i2);
        if (aiW == 1 || aiW == 10) {
            AppMethodBeat.o(79882);
            return true;
        }
        AppMethodBeat.o(79882);
        return false;
    }

    protected static boolean b(JsapiPermissionWrapper jsapiPermissionWrapper, int i2) {
        AppMethodBeat.i(79883);
        if (jsapiPermissionWrapper == null) {
            AppMethodBeat.o(79883);
            return false;
        } else if (jsapiPermissionWrapper.aiW(i2) == 10) {
            AppMethodBeat.o(79883);
            return true;
        } else {
            AppMethodBeat.o(79883);
            return false;
        }
    }

    public final boolean geL() {
        AppMethodBeat.i(211078);
        if (this.nVN == null) {
            AppMethodBeat.o(211078);
            return false;
        }
        boolean isShowing = this.nVN.isShowing();
        AppMethodBeat.o(211078);
        return isShowing;
    }

    /* access modifiers changed from: protected */
    public final void geM() {
        AppMethodBeat.i(79884);
        if (!this.Jgs) {
            AppMethodBeat.o(79884);
            return;
        }
        this.Jgr = false;
        geo().JjM = false;
        this.Jgs = false;
        if (geL()) {
            Mf(0);
        }
        AppMethodBeat.o(79884);
    }

    public final void ani() {
        AppMethodBeat.i(79885);
        if (geL()) {
            Mf(0);
        }
        AppMethodBeat.o(79885);
    }

    public final void geN() {
        AppMethodBeat.i(79886);
        this.Jgr = true;
        this.Jgt.clear();
        if (geo() instanceof GameWebViewUI) {
            this.Jgt.add(11);
            this.Jgt.add(28);
            AppMethodBeat.o(79886);
            return;
        }
        this.Jgt.add(7);
        this.Jgt.add(11);
        this.Jgt.add(28);
        AppMethodBeat.o(79886);
    }

    /* access modifiers changed from: package-private */
    public final boolean agI(int i2) {
        AppMethodBeat.i(211079);
        if (!this.Jgr || this.Jgt.contains(Integer.valueOf(i2))) {
            AppMethodBeat.o(211079);
            return true;
        }
        AppMethodBeat.o(211079);
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void a(i iVar) {
        AppMethodBeat.i(211080);
        if (this.Jgy == null) {
            Log.i("MicroMsg.WebViewMenuHelper", "enhanceBottomSheet, openMaterialCollection is null");
            AppMethodBeat.o(211080);
        } else if (this.nVN == null) {
            Log.i("MicroMsg.WebViewMenuHelper", "enhanceBottomSheet, mmBottomSheet is null");
            AppMethodBeat.o(211080);
        } else {
            WebViewUI geo = geo();
            if (geo == null) {
                Log.w("MicroMsg.WebViewMenuHelper", "enhanceBottomSheet, webViewUI is null");
                AppMethodBeat.o(211080);
                return;
            }
            boolean hXN = hXN();
            Log.i("MicroMsg.WebViewMenuHelper", "enhanceBottomSheet, canShowOpenMaterials: ".concat(String.valueOf(hXN)));
            if (this.Jgz != null) {
                this.Jgz.a(hXN ? h.a.ENABLE : h.a.HIDE);
                AppMethodBeat.o(211080);
                return;
            }
            if (hXN) {
                this.Jgz = iVar.a(b.WEB_VIEW, geo, this.nVN, this.Jgy, null, null);
            }
            AppMethodBeat.o(211080);
        }
    }

    public final void cpD() {
        AppMethodBeat.i(259613);
        Mf(0);
        AppMethodBeat.o(259613);
    }

    /* access modifiers changed from: protected */
    public final void Mf(final long j2) {
        boolean z;
        AppMethodBeat.i(211082);
        if (gcd()) {
            Log.w("MicroMsg.WebViewMenuHelper", "showReaderModeMenu, webViewUI is finished");
            AppMethodBeat.o(211082);
            return;
        }
        this.Jgv = geO();
        this.Jgw = Boolean.valueOf(this.Jgv != null && this.Jgv.size() > 0);
        boolean geL = geL();
        if (!geL) {
            if (this.Jgw.booleanValue()) {
                this.nVN = new com.tencent.mm.ui.widget.a.e((Context) geo(), 1, false);
            } else {
                this.nVN = new com.tencent.mm.ui.widget.a.e((Context) geo(), 0, true);
            }
        }
        if (!geL) {
            z = true;
        } else {
            z = false;
        }
        FJ(z);
        this.nVN.HMa = new o.b() {
            /* class com.tencent.mm.plugin.webview.ui.tools.j.AnonymousClass18 */

            @Override // com.tencent.mm.ui.base.o.b
            public final void a(ImageView imageView, MenuItem menuItem) {
                Bitmap baf;
                AppMethodBeat.i(211068);
                if (j.e(menuItem)) {
                    imageView.setVisibility(8);
                    AppMethodBeat.o(211068);
                    return;
                }
                String sb = new StringBuilder().append((Object) menuItem.getTitle()).toString();
                if (j.this.Jgl.get(sb) == null || j.this.Jgl.get(sb).isRecycled()) {
                    Log.w("MicroMsg.WebViewMenuHelper", "on attach icon, load from cache fail");
                    try {
                        String aZQ = j.this.geo().IMH.mHh.aZQ(sb);
                        if (!Util.isNullOrNil(aZQ) && (baf = e.baf(aZQ)) != null && !baf.isRecycled()) {
                            imageView.setImageBitmap(baf);
                            j.this.Jgl.put(sb, baf);
                        }
                        AppMethodBeat.o(211068);
                    } catch (Exception e2) {
                        Log.w("MicroMsg.WebViewMenuHelper", "getheadimg, ex = " + e2.getMessage());
                        AppMethodBeat.o(211068);
                    }
                } else {
                    imageView.setImageBitmap(j.this.Jgl.get(sb));
                    AppMethodBeat.o(211068);
                }
            }
        };
        this.nVN.HMb = new o.c() {
            /* class com.tencent.mm.plugin.webview.ui.tools.j.AnonymousClass19 */

            @Override // com.tencent.mm.ui.base.o.c
            public final void a(TextView textView, MenuItem menuItem) {
                AppMethodBeat.i(211069);
                String sb = new StringBuilder().append((Object) menuItem.getTitle()).toString();
                if (textView != null) {
                    String str = j.this.Jgm.get(sb);
                    if (Util.isNullOrNil(str)) {
                        textView.setText(sb);
                        AppMethodBeat.o(211069);
                        return;
                    }
                    textView.setText(l.b(j.this.geo(), str, textView.getTextSize()));
                }
                AppMethodBeat.o(211069);
            }
        };
        AnonymousClass20 r9 = new o.g() {
            /* class com.tencent.mm.plugin.webview.ui.tools.j.AnonymousClass20 */

            /* JADX WARNING: Removed duplicated region for block: B:193:0x1179  */
            /* JADX WARNING: Removed duplicated region for block: B:31:0x012b  */
            @Override // com.tencent.mm.ui.base.o.g
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void onMMMenuItemSelected(android.view.MenuItem r10, int r11) {
                /*
                // Method dump skipped, instructions count: 4842
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.j.AnonymousClass20.onMMMenuItemSelected(android.view.MenuItem, int):void");
            }
        };
        this.nVN.HLY = r9;
        this.nVN.QNG = new e.c() {
            /* class com.tencent.mm.plugin.webview.ui.tools.j.AnonymousClass21 */

            @Override // com.tencent.mm.ui.widget.a.e.c
            public final void onShow() {
                AppMethodBeat.i(211072);
                a aVar = j.this.Jgo.get(45);
                if (aVar == null) {
                    AppMethodBeat.o(211072);
                    return;
                }
                j.this.Jgo.remove(45);
                if (!(j.this.nVN == null || !j.this.nVN.isShowing() || j.this.Jgu == null)) {
                    int gKR = j.this.Jgu.gKR();
                    com.tencent.mm.ui.widget.a.e eVar = j.this.nVN;
                    if (!(eVar.mRecyclerView == null || eVar.mRecyclerView.getLayoutManager() == null || eVar.QOs == null)) {
                        eVar.QOs.atO = gKR;
                        eVar.mRecyclerView.getLayoutManager().startSmoothScroll(eVar.QOs);
                    }
                }
                j jVar = j.this;
                if (aVar != null) {
                    int i2 = aVar.nfG;
                    Bundle bundle = aVar.JgL;
                    if (bundle != null && i2 == 45) {
                        ResolveInfo resolveInfo = (ResolveInfo) bundle.getParcelable("show_browser_resolve_info");
                        boolean z = bundle.getBoolean("show_browser_with_animation", false);
                        if (resolveInfo != null) {
                            jVar.Jgn.JlN = null;
                            jVar.Jgn.resolveInfo = resolveInfo;
                            jVar.a(jVar.geo(), jVar.Jgn.resolveInfo, jVar.Jgu, aVar.neT, z);
                        }
                    }
                }
                AppMethodBeat.o(211072);
            }
        };
        this.nVN.PGl = new e.b() {
            /* class com.tencent.mm.plugin.webview.ui.tools.j.AnonymousClass22 */

            @Override // com.tencent.mm.ui.widget.a.e.b
            public final void onDismiss() {
                AppMethodBeat.i(211073);
                if (j.this.geo().gfB() && j.this.geo().IBw != null) {
                    j.this.geo().IBw.onWindowFocusChanged(true);
                }
                AppMethodBeat.o(211073);
            }
        };
        if (geo().mHi == null) {
            Log.e("MicroMsg.WebViewMenuHelper", "get permission failed");
            AppMethodBeat.o(211082);
            return;
        }
        final JsapiPermissionWrapper gdH = geo().IMH.mHi.gdH();
        this.nVN.HLX = new o.f() {
            /* class com.tencent.mm.plugin.webview.ui.tools.j.AnonymousClass23 */

            /* JADX WARNING: Removed duplicated region for block: B:131:0x050d  */
            @Override // com.tencent.mm.ui.base.o.f
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void onCreateMMMenu(com.tencent.mm.ui.base.m r14) {
                /*
                // Method dump skipped, instructions count: 2041
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.j.AnonymousClass23.onCreateMMMenu(com.tencent.mm.ui.base.m):void");
            }
        };
        String fZM = geo().fZM();
        geo();
        final o.a baw = o.baw(fZM);
        boolean z2 = g.af(com.tencent.mm.plugin.brandservice.a.b.class) != null && ((com.tencent.mm.plugin.brandservice.a.b) g.af(com.tencent.mm.plugin.brandservice.a.b.class)).isMpUrl(fZM);
        this.nVN.QNH = new o.f() {
            /* class com.tencent.mm.plugin.webview.ui.tools.j.AnonymousClass24 */

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(m mVar) {
                boolean z;
                boolean z2;
                boolean a2;
                boolean b2;
                AppMethodBeat.i(211075);
                if (j.this.gcd()) {
                    AppMethodBeat.o(211075);
                    return;
                }
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(480, 0, 1, false);
                mVar.clear();
                if (j.this.Jgw.booleanValue()) {
                    AppMethodBeat.o(211075);
                    return;
                }
                if (ao.gJN() && aw.b(aw.gWy(), j.this.geo().getTaskId())) {
                    aw.kA(j.this.geo().getContext());
                    if (aw.a(aw.gWy(), j.this.geo().getTaskId()) == 2) {
                        mVar.b(44, j.this.geo().getString(R.string.b5z), R.raw.icons_outlined_merge);
                    } else {
                        mVar.b(44, j.this.geo().getString(R.string.hdp), R.raw.icons_outlined_sperated);
                    }
                }
                if (j.this.geo().Jju != null && j.this.geo().Jju.bPq() && j.this.agI(35) && j.this.agH(35)) {
                    mVar.b(35, j.this.geo().getString(R.string.ftx), R.raw.icons_outlined_multitask);
                }
                switch (j.this.geo().JjB) {
                    case 1:
                        mVar.b(40, j.this.geo().getString(R.string.j0o), R.raw.icon_outlined_talk);
                        break;
                    case 2:
                        mVar.b(41, j.this.geo().getString(R.string.j0m), R.raw.icon_outlined_stoptalking);
                        break;
                    case 3:
                        mVar.b(42, j.this.geo().getString(R.string.j0n), R.raw.icon_outlined_talk);
                        break;
                }
                try {
                    LinkedList<e.a> gfK = j.this.geo().gfK();
                    if (gfK != null) {
                        int i2 = 0;
                        while (i2 < gfK.size() && i2 < 8) {
                            e.a aVar = gfK.get(i2);
                            n nVar = null;
                            if (FirebaseAnalytics.b.INDEX.equals(Util.nullAsNil(aVar.id))) {
                                nVar = (n) mVar.b(15, j.this.geo().getString(R.string.iz7), R.raw.bottomsheet_icon_jd_index);
                            } else if ("categories".equals(Util.nullAsNil(aVar.id))) {
                                nVar = (n) mVar.b(16, j.this.geo().getString(R.string.iz6), R.raw.bottomsheet_icon_jd_collect_list);
                            } else if ("cart".equals(Util.nullAsNil(aVar.id))) {
                                nVar = (n) mVar.b(17, j.this.geo().getString(R.string.iz5), R.raw.bottomsheet_icon_jd_cart);
                            } else if (Scopes.PROFILE.equals(Util.nullAsNil(aVar.id))) {
                                nVar = (n) mVar.b(18, j.this.geo().getString(R.string.iz9), R.raw.bottomsheet_icon_profile);
                            } else if ("member".equals(Util.nullAsNil(aVar.id))) {
                                nVar = (n) mVar.b(19, j.this.geo().getString(R.string.iz8), R.raw.bottomsheet_icon_jd_member);
                            }
                            if (nVar != null) {
                                nVar.lDS = aVar.url;
                            }
                            i2++;
                        }
                    }
                } catch (Exception e2) {
                    Log.e("MicroMsg.WebViewMenuHelper", "exception in add jd menu, " + e2.getMessage());
                }
                String stringExtra = j.this.geo().getIntent().getStringExtra("srcUsername");
                if (!Util.isNullOrNil(stringExtra)) {
                    try {
                        z = j.this.geo().IMH.mHh.IT(stringExtra);
                    } catch (Exception e3) {
                        Log.e("MicroMsg.WebViewMenuHelper", "sharebtn click fail isBizContact, ex = " + e3.getMessage());
                        z = false;
                    }
                    if (!z) {
                        try {
                            j.this.geo().IMH.mHh.aZW(stringExtra);
                        } catch (Exception e4) {
                            Log.e("MicroMsg.WebViewMenuHelper", "sharebtn click fail triggerGetContact, ex = " + e4.getMessage());
                        }
                    } else {
                        try {
                            z2 = j.this.geo().IMH.mHh.IS(stringExtra);
                        } catch (Exception e5) {
                            Log.e("MicroMsg.WebViewMenuHelper", "sharebtn click fail, ex = " + e5.getMessage());
                            z2 = false;
                        }
                        if (z2) {
                            a2 = j.a(gdH, 19);
                            b2 = j.b(gdH, 19);
                        } else {
                            a2 = j.a(gdH, 20);
                            b2 = j.b(gdH, 20);
                        }
                        boolean fZV = j.this.geo().fZV();
                        if (j.this.agI(5) && a2 && j.this.agH(5)) {
                            if (fZV) {
                                mVar.a(5, j.this.geo().getString(R.string.j4g), R.raw.icons_outlined_official_accounts, b2);
                            } else if (baw == null || !baw.JbC) {
                                mVar.a(5, j.this.geo().getString(R.string.j4f), R.raw.icons_outlined_official_accounts, b2);
                            }
                        }
                    }
                }
                if (j.this.agH(10)) {
                    mVar.b(10, j.this.geo().getString(R.string.ahk), R.raw.icons_outlined_report_problem);
                }
                if (j.this.agI(6) && j.a(gdH, 44) && j.this.agH(6)) {
                    mVar.a(6, j.this.geo().getString(R.string.j45), R.raw.icons_outlined_link, j.b(gdH, 44));
                }
                if (j.this.agI(28) && j.this.agH(28)) {
                    mVar.b(28, j.this.geo().getString(R.string.iy_), R.raw.icons_outlined_refresh);
                }
                if ((j2 & 1) == 0 && j.this.agI(31)) {
                    mVar.b(31, j.this.geo().getString(R.string.j51), R.raw.actionbar_icon_dark_search);
                }
                if (gdH.Kzq != null && j.this.geo().Jiv && !Util.isNullOrNil(j.this.geo().gfu()) && !Util.isNullOrNil(j.this.geo().JjQ) && j.this.geo().gfu().startsWith(j.this.geo().JjQ) && j.this.geo().getIntent().getBooleanExtra("key_detail_can_delete", true) && j.this.geR()) {
                    if (j.this.agI(12) && j.this.agH(12)) {
                        mVar.b(12, j.this.geo().getString(R.string.c90), R.raw.bottomsheet_icon_addtag);
                    }
                    if (j.this.agI(9)) {
                        mVar.b(9, j.this.geo().getString(R.string.tf), R.raw.bottomsheet_icon_del);
                    }
                }
                if (j.this.agI(37)) {
                    j.this.geo();
                    if (c.a(j.this.geo().pGj) && j.this.agH(37)) {
                        mVar.b(37, j.this.geo().getString(R.string.izy), R.raw.icons_outlined_translate);
                    }
                }
                if ((j2 & 2) == 0 && j.this.agI(11) && j.a(gdH, 18) && j.this.agH(11)) {
                    mVar.a(11, j.this.geo().getString(R.string.ftj), R.raw.icons_outlined_font, j.b(gdH, 18));
                }
                if (BuildInfo.IS_FLAVOR_RED || BuildInfo.DEBUG || ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_webview_debug, 0) == 1) {
                    mVar.a(99, (CharSequence) j.this.geo().getString(com.tencent.mm.plugin.webview.d.l.gbo() ? R.string.izs : R.string.izt), R.raw.webview_menu_enable_debug, false);
                }
                j.this.nVN.fPw();
                AppMethodBeat.o(211075);
            }
        };
        this.nVN.QNK = r9;
        final String currentUrl = geo().IMH.getCurrentUrl();
        if (!Util.isNullOrNil(currentUrl)) {
            String host = Uri.parse(currentUrl).getHost();
            String string = geo().getString(R.string.izp, new Object[]{host});
            if (!Util.isNullOrNil(this.Jgp)) {
                View inflate = LayoutInflater.from(geo()).inflate(R.layout.ban, (ViewGroup) null);
                MMNeat7extView mMNeat7extView = (MMNeat7extView) inflate.findViewById(R.id.bn5);
                this.nVN.V(inflate, false);
                SpannableString j3 = l.j(mMNeat7extView.getContext(), Util.nullAsNil(this.Jgp), (int) mMNeat7extView.getTextSize());
                mMNeat7extView.aw(j3);
                ClickableSpan[] clickableSpanArr = (ClickableSpan[]) j3.getSpans(0, j3.length(), ClickableSpan.class);
                if (clickableSpanArr != null && clickableSpanArr.length > 0) {
                    Log.i("MicroMsg.WebViewMenuHelper", "terry h5 apply show");
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(16337, currentUrl, 1, 0);
                    mMNeat7extView.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.h(mMNeat7extView, new com.tencent.mm.pluginsdk.ui.span.o(mMNeat7extView.getContext())) {
                        /* class com.tencent.mm.plugin.webview.ui.tools.j.AnonymousClass3 */

                        @Override // com.tencent.neattextview.textview.view.b, com.tencent.mm.pluginsdk.ui.span.h
                        public final boolean onTouch(View view, MotionEvent motionEvent) {
                            AppMethodBeat.i(211053);
                            boolean onTouch = super.onTouch(view, motionEvent);
                            if (onTouch) {
                                Log.i("MMNeatTouchListener", "terry h5 apply click");
                                com.tencent.mm.plugin.report.service.h.INSTANCE.a(16337, currentUrl, 1, 1);
                            }
                            AppMethodBeat.o(211053);
                            return onTouch;
                        }
                    });
                }
            } else if (z2 && baw != null && baw.isDataValid()) {
                View inflate2 = LayoutInflater.from(geo()).inflate(R.layout.bam, (ViewGroup) null);
                View findViewById = inflate2.findViewById(R.id.bex);
                ((TextView) inflate2.findViewById(R.id.iy5)).setText(baw.Jkn);
                c.a aVar = new c.a();
                aVar.jbe = true;
                aVar.iaT = true;
                aVar.jbq = R.drawable.bca;
                com.tencent.mm.av.a.a.bdb().a(baw.Jko, (ImageView) inflate2.findViewById(R.id.e4o), aVar.bdv());
                findViewById.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.webview.ui.tools.j.AnonymousClass2 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(211052);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/WebViewMenuHelper$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        j.this.gx("Contact_Scene", TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_3);
                        j.this.geo().IMs.gdh().C(j.this.geo().coX(), 38, 1).report();
                        j.this.geo().bas(baw.brandUsername);
                        if (j.this.nVN != null) {
                            j.this.nVN.bMo();
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewMenuHelper$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(211052);
                    }
                });
                com.tencent.mm.ui.tools.o.hq(findViewById);
                this.nVN.V(inflate2, true);
            } else if (!Util.isNullOrNil(host)) {
                this.nVN.o(string, 1);
            }
        } else {
            this.nVN.o(" ", 1);
        }
        if (geo().gfB()) {
            this.nVN.mLN = true;
            this.nVN.mLO = true;
            com.tencent.f.h.RTc.n(new Runnable() {
                /* class com.tencent.mm.plugin.webview.ui.tools.j.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(211054);
                    if (j.this.geo().IBw != null) {
                        j.this.geo().IBw.onWindowFocusChanged(false);
                    }
                    AppMethodBeat.o(211054);
                }
            }, 500);
        } else {
            this.nVN.mLN = false;
            this.nVN.mLO = false;
        }
        if (geo().Jik == null || !geo().Jik.isShown()) {
            geo().hideVKB();
            this.nVN.dGm();
        } else {
            geo().Jik.hide();
            this.nVN.dGm();
        }
        if (geo().IBw != null) {
            geo().IBw.aYi("");
        }
        AppMethodBeat.o(211082);
    }

    static ResolveInfo a(WebViewUI webViewUI, com.tencent.mm.plugin.webview.stub.e eVar) {
        boolean z = true;
        AppMethodBeat.i(211083);
        if (eVar != null) {
            try {
                Bundle bundle = new Bundle();
                bundle.putString("WebViewShare_wv_url", webViewUI.fZM());
                Bundle j2 = eVar.j(120000, bundle);
                String string = j2.getString("default_browser_package_name", "");
                ResolveInfo N = com.tencent.mm.plugin.webview.ui.tools.browser.b.N(webViewUI, string, j2.getString("k_share_url", ""));
                Object[] objArr = new Object[2];
                objArr[0] = string;
                if (N == null) {
                    z = false;
                }
                objArr[1] = Boolean.valueOf(z);
                Log.i("MicroMsg.WebViewMenuHelper", "alvinluo getDefaultBrowser defaultBrowserPackageName: %s, defaultBrowser != null: %b", objArr);
                AppMethodBeat.o(211083);
                return N;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.WebViewMenuHelper", e2, "alvinluo addDefaultBrowserMenuItem exception", new Object[0]);
            }
        }
        AppMethodBeat.o(211083);
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void a(WebViewUI webViewUI, ResolveInfo resolveInfo, final m mVar, final boolean z, final boolean z2) {
        AppMethodBeat.i(211084);
        String b2 = com.tencent.mm.plugin.webview.ui.tools.browser.b.b(webViewUI, resolveInfo);
        final String format = String.format(webViewUI.getString(R.string.iyc), b2);
        if (this.Jgn.JlN != null) {
            a(mVar, format, this.Jgn.JlN, z, z2);
            AppMethodBeat.o(211084);
            return;
        }
        new com.tencent.mm.plugin.webview.ui.tools.browser.e(webViewUI, b2, new e.a() {
            /* class com.tencent.mm.plugin.webview.ui.tools.j.AnonymousClass5 */

            @Override // com.tencent.mm.plugin.webview.ui.tools.browser.e.a
            public final void B(Drawable drawable) {
                AppMethodBeat.i(211055);
                j.this.Jgn.JlN = drawable;
                if (!(drawable == null || j.this.nVN == null || !j.this.nVN.isShowing())) {
                    j.this.a(mVar, format, drawable, z, z2);
                }
                AppMethodBeat.o(211055);
            }
        }).execute(resolveInfo);
        AppMethodBeat.o(211084);
    }

    /* access modifiers changed from: package-private */
    public final void a(final m mVar, final String str, final Drawable drawable, final boolean z, boolean z2) {
        AppMethodBeat.i(211085);
        Log.d("MicroMsg.WebViewMenuHelper", "alvinluo addDefaultBrowserMenuItem withAnimation: %s, title: %s, iconDrawable: %s, bitmap: %s", Boolean.valueOf(z2), str, drawable, null);
        if (!z2) {
            if (a(mVar, Math.max(0, mVar.gKR()), drawable, str, z)) {
                this.nVN.fPw();
            }
            AppMethodBeat.o(211085);
            return;
        }
        com.tencent.f.h.RTc.n(new Runnable() {
            /* class com.tencent.mm.plugin.webview.ui.tools.j.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(211056);
                if (j.this.nVN != null && j.this.nVN.isShowing()) {
                    int max = Math.max(0, mVar.gKR());
                    if (j.a(mVar, max, drawable, str, z)) {
                        com.tencent.mm.ui.widget.a.e eVar = j.this.nVN;
                        int size = eVar.HMc.size();
                        if (eVar.QOd != null && max >= 0 && max < size) {
                            eVar.QOd.cj(max);
                        }
                    }
                }
                AppMethodBeat.o(211056);
            }
        }, 100);
        AppMethodBeat.o(211085);
    }

    static boolean a(m mVar, int i2, Drawable drawable, String str, boolean z) {
        AppMethodBeat.i(211086);
        if (mVar == null) {
            AppMethodBeat.o(211086);
            return false;
        } else if (mVar.findItem(45) != null) {
            Log.w("MicroMsg.WebViewMenuHelper", "alvinluo doAddDefaultBrowserMenuItem has added and ignore");
            AppMethodBeat.o(211086);
            return false;
        } else {
            Log.d("MicroMsg.WebViewMenuHelper", "alvinluo doAddDefaultBrowserMenuItem index: %s", Integer.valueOf(i2));
            MenuItem b2 = mVar.b(i2, str, z);
            ((n) b2).ORF = TextUtils.TruncateAt.END;
            ((n) b2).ORG = false;
            b2.setIcon(drawable);
            AppMethodBeat.o(211086);
            return true;
        }
    }

    private ArrayList<e.b> geO() {
        AppMethodBeat.i(79888);
        if (geo().pGj == null) {
            Log.w("MicroMsg.WebViewMenuHelper", "getCustomMenuList viewWV is null");
            AppMethodBeat.o(79888);
            return null;
        }
        String url = geo().pGj.getUrl();
        if (geo().JiO.containsKey(url)) {
            ArrayList<e.b> arrayList = geo().JiO.get(url);
            AppMethodBeat.o(79888);
            return arrayList;
        }
        AppMethodBeat.o(79888);
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void bam(String str) {
        AppMethodBeat.i(79889);
        geo().IBw.cL("sendAppMessage", false);
        com.tencent.mm.plugin.webview.d.h hVar = geo().IBw;
        if (!hVar.GBl) {
            Log.e("MicroMsg.JsApiHandler", "onSendToEnterprise fail, not ready");
            AppMethodBeat.o(79889);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("scene", "enterprise");
        hVar.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + n.a.b("menu:share:appmessage", hashMap, hVar.IRj, hVar.zpY) + ")", null);
        try {
            hVar.mHh.an("connector_local_send", str, hVar.IRl);
            hVar.mHh.an("scene", "enterprise", hVar.IRl);
            AppMethodBeat.o(79889);
        } catch (Exception e2) {
            Log.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + e2.getMessage());
            AppMethodBeat.o(79889);
        }
    }

    private void agJ(int i2) {
        AppMethodBeat.i(79891);
        String aXD = geo().aXD(geo().gfu());
        if (TextUtils.isEmpty(geo().gfu()) || TextUtils.isEmpty(aXD)) {
            Log.i("MicroMsg.WebViewMenuHelper", "stev appId is null or empty");
            AppMethodBeat.o(79891);
            return;
        }
        Log.i("MicroMsg.WebViewMenuHelper", "stev appId %s", aXD);
        long nowSecond = Util.nowSecond();
        Log.d("MicroMsg.WebViewMenuHelper", "stev report(%s), clickTimestamp : %d, appID : %s, url : %s, sessionId : %s, actionType : %d, flag : %d", 13377, Long.valueOf(nowSecond), aXD, geo().gfu(), geo().sessionId, 3, Integer.valueOf(i2));
        String str = "";
        try {
            str = q.encode(geo().gfu(), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e2) {
            Log.printErrStackTrace("MicroMsg.WebViewMenuHelper", e2, "", new Object[0]);
        }
        int aXI = geo().aXI(geo().getIntent().getStringExtra("geta8key_username"));
        String str2 = "";
        if (aXI == 7 || aXI == 56) {
            str2 = geo().getIntent().getStringExtra("geta8key_username");
        }
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(13377, Long.valueOf(nowSecond), aXD, str, geo().sessionId, 3, Integer.valueOf(i2), 0, str2);
        AppMethodBeat.o(79891);
    }

    /* access modifiers changed from: protected */
    public final void geP() {
        AppMethodBeat.i(79892);
        if (geo().IBw != null) {
            geo().IBw.aYi("fav");
            geo().IBw.cL("sendAppMessage", false);
            geo().IBw.d(geQ(), 0);
            AppMethodBeat.o(79892);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putLong("msg_id", geo().getIntent().getLongExtra("msg_id", Long.MIN_VALUE));
        bundle.putString("sns_local_id", geo().getIntent().getStringExtra("sns_local_id"));
        bundle.putInt("news_svr_id", geo().getIntent().getIntExtra("news_svr_id", 0));
        bundle.putString("news_svr_tweetid", geo().getIntent().getStringExtra("news_svr_tweetid"));
        bundle.putInt("message_index", geo().getIntent().getIntExtra("message_index", 0));
        bundle.putString("rawUrl", geo().coX());
        if (!Util.isNullOrNil(geo().coX()) && geo().coX().endsWith("#rd")) {
            String substring = geo().coX().substring(0, geo().coX().length() - 3);
            if (!Util.isNullOrNil(geo().gfu()) && !geo().gfu().startsWith(substring)) {
                bundle.putString("rawUrl", geo().gfu());
                bundle.putLong("msg_id", Long.MIN_VALUE);
            }
        } else if (!Util.isNullOrNil(geo().gfu()) && !geo().gfu().startsWith(geo().coX())) {
            bundle.putString("rawUrl", geo().gfu());
            bundle.putLong("msg_id", Long.MIN_VALUE);
        }
        Intent intent = geo().getIntent();
        if (intent != null) {
            bundle.putString("preChatName", intent.getStringExtra("preChatName"));
            bundle.putInt("preMsgIndex", intent.getIntExtra("preMsgIndex", 0));
            bundle.putString("prePublishId", intent.getStringExtra("prePublishId"));
            bundle.putString("preUsername", intent.getStringExtra("preUsername"));
        }
        try {
            com.tencent.mm.plugin.webview.stub.c aY = geo().IMH.mHh.aY(bundle);
            if (aY.gdT()) {
                geo().IBw.cL("sendAppMessage", false);
                geo().IBw.d(geQ(), 0);
                Log.i("MicroMsg.WebViewMenuHelper", "on favorite simple url");
                AppMethodBeat.o(79892);
                return;
            }
            com.tencent.mm.plugin.fav.ui.e.a(aY.getRet(), geo(), geo().xxK);
            if (aY.getRet() == 0) {
                agJ(1);
                AppMethodBeat.o(79892);
                return;
            }
            agJ(2);
            AppMethodBeat.o(79892);
        } catch (Exception e2) {
            Log.e("MicroMsg.WebViewMenuHelper", "edw, favoriteUrl fail, ex = " + e2.getMessage());
            AppMethodBeat.o(79892);
        }
    }

    public final HashMap<String, String> geQ() {
        AppMethodBeat.i(79893);
        if (!geo().JjM) {
            AppMethodBeat.o(79893);
            return null;
        }
        Intent intent = geo().getIntent();
        String stringExtra = intent.getStringExtra("share_report_pre_msg_url");
        String stringExtra2 = intent.getStringExtra("share_report_pre_msg_title");
        String stringExtra3 = intent.getStringExtra("share_report_pre_msg_icon_url");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("share_report_pre_msg_url", stringExtra);
        hashMap.put("share_report_pre_msg_title", stringExtra2);
        hashMap.put("share_report_pre_msg_desc", intent.getStringExtra("share_report_pre_msg_desc"));
        hashMap.put("share_report_pre_msg_icon_url", stringExtra3);
        AppMethodBeat.o(79893);
        return hashMap;
    }

    private void ik(List<String> list) {
        Bitmap baf;
        AppMethodBeat.i(79894);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.o(79894);
            return;
        }
        for (String str : list) {
            if (this.Jgl.get(str) != null) {
                Log.i("MicroMsg.WebViewMenuHelper", "find %s icon from cache ok", str);
            } else {
                Log.w("MicroMsg.WebViewMenuHelper", "not found %s icon from cache, try to load", str);
                try {
                    String aZQ = geo().IMH.mHh.aZQ(str);
                    if (!Util.isNullOrNil(aZQ) && (baf = e.baf(aZQ)) != null) {
                        Log.i("MicroMsg.WebViewMenuHelper", "load ok, and cache it");
                        this.Jgl.put(str, baf);
                    }
                } catch (Exception e2) {
                    Log.w("MicroMsg.WebViewMenuHelper", "getheadimg, ex = " + e2.getMessage());
                }
            }
            if (this.Jgm.containsKey(str)) {
                Log.i("MicroMsg.WebViewMenuHelper", "find %s nick from cache ok", str);
            } else {
                Log.w("MicroMsg.WebViewMenuHelper", "not found %s nick from cache, try to load", str);
                String str2 = null;
                try {
                    str2 = geo().IMH.mHh.getDisplayName(str);
                    Log.i("MicroMsg.WebViewMenuHelper", "load nick ok");
                } catch (Exception e3) {
                    Log.w("MicroMsg.WebViewMenuHelper", "onAttach, ex = " + e3.getMessage());
                }
                this.Jgm.put(str, str2);
            }
        }
        AppMethodBeat.o(79894);
    }

    public final void gx(String str, int i2) {
        AppMethodBeat.i(79895);
        if (geo().IBw != null) {
            Bundle bundle = new Bundle();
            bundle.putInt(str, i2);
            com.tencent.mm.plugin.webview.d.h hVar = geo().IBw;
            try {
                hVar.mHh.a(21, bundle, hVar.IRl);
                AppMethodBeat.o(79895);
                return;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.JsApiHandler", e2, "", new Object[0]);
                Log.w("MicroMsg.JsApiHandler", "updateJsapiArgsBundleKV, ex = ".concat(String.valueOf(e2)));
            }
        }
        AppMethodBeat.o(79895);
    }

    /* access modifiers changed from: package-private */
    public final boolean geR() {
        boolean z = false;
        AppMethodBeat.i(79896);
        try {
            z = geo().IMH.mHh.aZU("favorite");
            AppMethodBeat.o(79896);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.WebViewMenuHelper", e2, "", new Object[0]);
            AppMethodBeat.o(79896);
        }
        return z;
    }

    /* access modifiers changed from: protected */
    public final void cjP() {
        AppMethodBeat.i(79897);
        String aXD = geo().aXD(geo().gfu());
        String stringExtra = geo().getIntent().getStringExtra("shortcut_user_name");
        if (Util.isNullOrNil(aXD) || Util.isNullOrNil(stringExtra)) {
            Log.e("MicroMsg.WebViewMenuHelper", "addShortcut, appid or username is null");
            AppMethodBeat.o(79897);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("KAppId", aXD);
        bundle.putString("shortcut_user_name", stringExtra);
        bundle.putInt("webviewui_binder_id", hashCode());
        try {
            geo().IMH.mHh.j(80, bundle);
            AppMethodBeat.o(79897);
        } catch (Exception e2) {
            Log.e("MicroMsg.WebViewMenuHelper", "addShortcut, e = " + e2.getMessage());
            AppMethodBeat.o(79897);
        }
    }

    public final void geS() {
        AppMethodBeat.i(79899);
        if (geo() == null || geo().mHi == null) {
            Log.e("MicroMsg.WebViewMenuHelper", "showShareMenu params failed");
            AppMethodBeat.o(79899);
            return;
        }
        final JsapiPermissionWrapper gdH = geo().mHi.gdH();
        if (a(gdH, 21, 1) || a(gdH, 23, 2)) {
            com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) geo(), 1, false);
            eVar.HLX = new o.f() {
                /* class com.tencent.mm.plugin.webview.ui.tools.j.AnonymousClass16 */

                @Override // com.tencent.mm.ui.base.o.f
                public final void onCreateMMMenu(m mVar) {
                    AppMethodBeat.i(211066);
                    if (j.this.a(gdH, 21, 1)) {
                        mVar.a(1, (CharSequence) j.this.geo().getString(R.string.ftk), R.raw.bottomsheet_icon_transmit, false);
                    }
                    if (j.this.a(gdH, 23, 2)) {
                        mVar.a(2, (CharSequence) j.this.geo().getString(R.string.ftl), R.raw.bottomsheet_icon_moment, false);
                    }
                    AppMethodBeat.o(211066);
                }
            };
            eVar.HLY = new o.g() {
                /* class com.tencent.mm.plugin.webview.ui.tools.j.AnonymousClass17 */

                @Override // com.tencent.mm.ui.base.o.g
                public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                    int i3 = 0;
                    AppMethodBeat.i(211067);
                    switch (menuItem.getItemId()) {
                        case 1:
                            String stringExtra = j.this.geo().getIntent().getStringExtra("KPublisherId");
                            String stringExtra2 = j.this.geo().getIntent().getStringExtra("KAppId");
                            String stringExtra3 = j.this.geo().getIntent().getStringExtra("srcUsername");
                            j.this.geo().IMs.gdh().C(j.this.geo().coX(), 1, 1, stringExtra, stringExtra2, stringExtra3).report();
                            j.this.geo().agO(1);
                            AppMethodBeat.o(211067);
                            return;
                        case 2:
                            String stringExtra4 = j.this.geo().getIntent().getStringExtra("KPublisherId");
                            String stringExtra5 = j.this.geo().getIntent().getStringExtra("KAppId");
                            String stringExtra6 = j.this.geo().getIntent().getStringExtra("srcUsername");
                            j.this.geo().IMs.gdh().C(j.this.geo().coX(), 2, 1, stringExtra4, stringExtra5, stringExtra6).report();
                            if (j.this.Jgq.containsKey(j.this.geo().pGj.getUrl())) {
                                i3 = j.this.Jgq.get(j.this.geo().pGj.getUrl()).intValue();
                            }
                            j.a(j.this, i3, 1);
                            break;
                    }
                    AppMethodBeat.o(211067);
                }
            };
            eVar.o(" ", 1);
            eVar.dGm();
            AppMethodBeat.o(79899);
            return;
        }
        com.tencent.mm.ui.base.h.cD(geo(), geo().getString(R.string.j4h));
        AppMethodBeat.o(79899);
    }

    public final void cpE() {
        AppMethodBeat.i(79900);
        if (geo() == null || geo().pGj == null || geo().mHi == null) {
            Log.e("MicroMsg.WebViewMenuHelper", "setShareFuncFlag params failed");
            AppMethodBeat.o(79900);
            return;
        }
        String url = geo().pGj.getUrl();
        if (!Util.isNullOrNil(url)) {
            try {
                if (!new URL(url).getHost().equals(WeChatHosts.domainString(R.string.e20))) {
                    AppMethodBeat.o(79900);
                    return;
                }
                int geT = geT();
                if (geo().IBw != null) {
                    geo().IBw.gi("setFuncFlag", geT);
                }
                AppMethodBeat.o(79900);
            } catch (Exception e2) {
                Log.e("MicroMsg.WebViewMenuHelper", "create url fail : " + e2.getLocalizedMessage());
                AppMethodBeat.o(79900);
            }
        } else {
            AppMethodBeat.o(79900);
        }
    }

    public final int geT() {
        int i2;
        AppMethodBeat.i(79901);
        if (geo() == null || geo().mHi == null) {
            Log.e("MicroMsg.WebViewMenuHelper", "getShareFuncFlag params failed");
            AppMethodBeat.o(79901);
            return -1;
        }
        JsapiPermissionWrapper gdH = geo().mHi.gdH();
        if (a(gdH, 21, 1)) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (a(gdH, 23, 2)) {
            i2 |= 2;
        }
        Log.i("MicroMsg.WebViewMenuHelper", "getShareFuncFlag %d", Integer.valueOf(i2));
        AppMethodBeat.o(79901);
        return i2;
    }

    /* access modifiers changed from: protected */
    public final boolean a(JsapiPermissionWrapper jsapiPermissionWrapper, int i2, int i3) {
        AppMethodBeat.i(79902);
        if (jsapiPermissionWrapper == null) {
            AppMethodBeat.o(79902);
            return false;
        } else if (jsapiPermissionWrapper.aiW(i2) != 1 || !agH(i3)) {
            AppMethodBeat.o(79902);
            return false;
        } else {
            AppMethodBeat.o(79902);
            return true;
        }
    }

    public static class a {
        public int JgK;
        public Bundle JgL;
        public boolean neT;
        public int nfG;

        public a() {
            this.nfG = -1;
            this.JgK = -1;
            this.neT = false;
            this.JgL = null;
            this.nfG = 45;
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x013c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void ban(java.lang.String r12) {
        /*
        // Method dump skipped, instructions count: 527
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.j.ban(java.lang.String):void");
    }

    static /* synthetic */ boolean e(MenuItem menuItem) {
        AppMethodBeat.i(211088);
        if (menuItem.getItemId() >= 10000) {
            AppMethodBeat.o(211088);
            return true;
        }
        AppMethodBeat.o(211088);
        return false;
    }

    static /* synthetic */ void a(j jVar, int i2, int i3) {
        AppMethodBeat.i(211089);
        jVar.geo().IBw.cL(com.tencent.mm.plugin.appbrand.jsapi.share.l.NAME, true);
        com.tencent.mm.plugin.webview.d.h hVar = jVar.geo().IBw;
        HashMap<String, String> geQ = jVar.geQ();
        Log.i("MicroMsg.JsApiHandler", "onShareTimeline %b", Boolean.valueOf(hVar.GBl));
        if (!hVar.GBl) {
            Log.w("MicroMsg.JsApiHandler", "onShareTimeline not ready");
            hVar.i(hVar.bH(geQ), com.tencent.mm.plugin.appbrand.jsapi.share.l.NAME);
        } else {
            Bundle afU = hVar.afU(2);
            if (afU == null || !afU.getBoolean("WebViewShare_reslut", false)) {
                try {
                    hVar.mHh.an("urlAttribute", String.valueOf(i2), hVar.IRl);
                } catch (RemoteException e2) {
                    Log.printErrStackTrace("MicroMsg.JsApiHandler", e2, "", new Object[0]);
                }
                HashMap hashMap = new HashMap();
                hashMap.put("shareScene", Integer.valueOf(i3));
                hVar.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + n.a.b("menu:share:timeline", hashMap, hVar.IRj, hVar.zpY) + ")", null);
            } else {
                hVar.i(afU, com.tencent.mm.plugin.appbrand.jsapi.share.l.NAME);
            }
        }
        jVar.geo().IMs.aZc("mm_share_sns_count");
        AppMethodBeat.o(211089);
    }

    static /* synthetic */ void a(j jVar, final int i2) {
        AppMethodBeat.i(211090);
        if (i2 == 1) {
            String str = null;
            Bundle bundle = new Bundle();
            bundle.putInt("WebViewShare_BinderID", jVar.geo().hashCode());
            bundle.putString("WebViewShare_wv_url", jVar.geo().pGj.getUrl());
            try {
                Bundle j2 = jVar.geo().IMH.mHh.j(109, bundle);
                if (j2 != null) {
                    str = j2.getString("key_hao_kan_title");
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.WebViewMenuHelper", "setHaoKanStatus e=%s", e2.getMessage());
            }
            com.tencent.mm.plugin.webview.k.g.a(jVar.geo(), str, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.webview.ui.tools.j.AnonymousClass15 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(211065);
                    j.this.geo().IBw.w(i2, dialogInterface == null ? "" : ((d) dialogInterface).hbk(), 0);
                    AppMethodBeat.o(211065);
                }
            });
            AppMethodBeat.o(211090);
            return;
        }
        jVar.geo().IBw.w(i2, "", 0);
        AppMethodBeat.o(211090);
    }

    static /* synthetic */ void b(j jVar) {
        AppMethodBeat.i(211091);
        ClipboardHelper.setText(jVar.geo().IMH.beU());
        Toast.makeText(jVar.geo(), jVar.geo().getString(R.string.j46), 0).show();
        AppMethodBeat.o(211091);
    }

    static /* synthetic */ void c(j jVar) {
        AppMethodBeat.i(211092);
        String fZM = jVar.geo().fZM();
        boolean ahv = ((com.tencent.mm.plugin.brandservice.a.b) g.af(com.tencent.mm.plugin.brandservice.a.b.class)).ahv(fZM);
        com.tencent.mm.plugin.webview.c cVar = jVar.geo().Jjp;
        WebViewUI geo = jVar.geo();
        com.tencent.mm.co.g.hio().h(
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x003d: INVOKE  
              (wrap: com.tencent.mm.co.f<_Ret> : 0x0034: INVOKE  (r0v5 com.tencent.mm.co.f<_Ret>) = 
              (wrap: com.tencent.mm.co.f<java.lang.Void> : 0x002b: INVOKE  (r5v0 com.tencent.mm.co.f<java.lang.Void>) =  type: STATIC call: com.tencent.mm.co.g.hio():com.tencent.mm.co.f)
              (wrap: com.tencent.mm.plugin.webview.c$2 : 0x0031: CONSTRUCTOR  (r6v0 com.tencent.mm.plugin.webview.c$2) = 
              (r2v1 'cVar' com.tencent.mm.plugin.webview.c)
              (r3v0 'geo' com.tencent.mm.plugin.webview.ui.tools.WebViewUI)
              (wrap: com.tencent.mm.ui.widget.MMWebView : 0x0029: IGET  (r4v1 com.tencent.mm.ui.widget.MMWebView) = 
              (wrap: com.tencent.mm.plugin.webview.ui.tools.WebViewUI : 0x0025: INVOKE  (r4v0 com.tencent.mm.plugin.webview.ui.tools.WebViewUI) = (r9v0 'jVar' com.tencent.mm.plugin.webview.ui.tools.j) type: VIRTUAL call: com.tencent.mm.plugin.webview.ui.tools.j.geo():com.tencent.mm.plugin.webview.ui.tools.WebViewUI)
             com.tencent.mm.plugin.webview.ui.tools.WebViewUI.pGj com.tencent.mm.ui.widget.MMWebView)
              (r0v4 'ahv' boolean)
             call: com.tencent.mm.plugin.webview.c.2.<init>(com.tencent.mm.plugin.webview.c, android.app.Activity, com.tencent.xweb.WebView, boolean):void type: CONSTRUCTOR)
             type: VIRTUAL call: com.tencent.mm.co.f.h(com.tencent.mm.vending.c.a):com.tencent.mm.co.f)
              (wrap: com.tencent.mm.plugin.webview.c$1 : 0x003a: CONSTRUCTOR  (r4v2 com.tencent.mm.plugin.webview.c$1) = 
              (r2v1 'cVar' com.tencent.mm.plugin.webview.c)
              (r3v0 'geo' com.tencent.mm.plugin.webview.ui.tools.WebViewUI)
              (r1v0 'fZM' java.lang.String)
             call: com.tencent.mm.plugin.webview.c.1.<init>(com.tencent.mm.plugin.webview.c, android.app.Activity, java.lang.String):void type: CONSTRUCTOR)
             type: VIRTUAL call: com.tencent.mm.co.f.b(com.tencent.mm.vending.c.a):com.tencent.mm.co.f in method: com.tencent.mm.plugin.webview.ui.tools.j.c(com.tencent.mm.plugin.webview.ui.tools.j):void, file: classes.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0034: INVOKE  (r0v5 com.tencent.mm.co.f<_Ret>) = 
              (wrap: com.tencent.mm.co.f<java.lang.Void> : 0x002b: INVOKE  (r5v0 com.tencent.mm.co.f<java.lang.Void>) =  type: STATIC call: com.tencent.mm.co.g.hio():com.tencent.mm.co.f)
              (wrap: com.tencent.mm.plugin.webview.c$2 : 0x0031: CONSTRUCTOR  (r6v0 com.tencent.mm.plugin.webview.c$2) = 
              (r2v1 'cVar' com.tencent.mm.plugin.webview.c)
              (r3v0 'geo' com.tencent.mm.plugin.webview.ui.tools.WebViewUI)
              (wrap: com.tencent.mm.ui.widget.MMWebView : 0x0029: IGET  (r4v1 com.tencent.mm.ui.widget.MMWebView) = 
              (wrap: com.tencent.mm.plugin.webview.ui.tools.WebViewUI : 0x0025: INVOKE  (r4v0 com.tencent.mm.plugin.webview.ui.tools.WebViewUI) = (r9v0 'jVar' com.tencent.mm.plugin.webview.ui.tools.j) type: VIRTUAL call: com.tencent.mm.plugin.webview.ui.tools.j.geo():com.tencent.mm.plugin.webview.ui.tools.WebViewUI)
             com.tencent.mm.plugin.webview.ui.tools.WebViewUI.pGj com.tencent.mm.ui.widget.MMWebView)
              (r0v4 'ahv' boolean)
             call: com.tencent.mm.plugin.webview.c.2.<init>(com.tencent.mm.plugin.webview.c, android.app.Activity, com.tencent.xweb.WebView, boolean):void type: CONSTRUCTOR)
             type: VIRTUAL call: com.tencent.mm.co.f.h(com.tencent.mm.vending.c.a):com.tencent.mm.co.f in method: com.tencent.mm.plugin.webview.ui.tools.j.c(com.tencent.mm.plugin.webview.ui.tools.j):void, file: classes.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
            	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:87)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:715)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
            	... 14 more
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0031: CONSTRUCTOR  (r6v0 com.tencent.mm.plugin.webview.c$2) = 
              (r2v1 'cVar' com.tencent.mm.plugin.webview.c)
              (r3v0 'geo' com.tencent.mm.plugin.webview.ui.tools.WebViewUI)
              (wrap: com.tencent.mm.ui.widget.MMWebView : 0x0029: IGET  (r4v1 com.tencent.mm.ui.widget.MMWebView) = 
              (wrap: com.tencent.mm.plugin.webview.ui.tools.WebViewUI : 0x0025: INVOKE  (r4v0 com.tencent.mm.plugin.webview.ui.tools.WebViewUI) = (r9v0 'jVar' com.tencent.mm.plugin.webview.ui.tools.j) type: VIRTUAL call: com.tencent.mm.plugin.webview.ui.tools.j.geo():com.tencent.mm.plugin.webview.ui.tools.WebViewUI)
             com.tencent.mm.plugin.webview.ui.tools.WebViewUI.pGj com.tencent.mm.ui.widget.MMWebView)
              (r0v4 'ahv' boolean)
             call: com.tencent.mm.plugin.webview.c.2.<init>(com.tencent.mm.plugin.webview.c, android.app.Activity, com.tencent.xweb.WebView, boolean):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.webview.ui.tools.j.c(com.tencent.mm.plugin.webview.ui.tools.j):void, file: classes.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
            	... 20 more
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.webview.c, state: GENERATED_AND_UNLOADED
            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
            	... 26 more
            */
        /*
        // Method dump skipped, instructions count: 107
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.j.c(com.tencent.mm.plugin.webview.ui.tools.j):void");
    }

    static /* synthetic */ void a(j jVar, MenuItem menuItem) {
        AppMethodBeat.i(79909);
        if (menuItem instanceof com.tencent.mm.ui.base.n) {
            String str = ((com.tencent.mm.ui.base.n) menuItem).lDS;
            if (!Util.isNullOrNil(str) && !str.equals(jVar.geo().pGj.getUrl())) {
                jVar.geo().loadUrl(str);
            }
        }
        AppMethodBeat.o(79909);
    }

    static /* synthetic */ void d(j jVar) {
        AppMethodBeat.i(211093);
        String beU = jVar.geo().IMH.beU();
        if (Util.isNullOrNil(beU)) {
            beU = jVar.geo().coX();
        }
        try {
            beU = "weread://mp?url=" + q.encode(beU, ProtocolPackage.ServerEncoding);
        } catch (Exception e2) {
            Log.e("MicroMsg.WebViewMenuHelper", "encode url failed ; %s", e2.getMessage());
        }
        Log.i("MicroMsg.WebViewMenuHelper", "now url = %s", beU);
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(beU));
        intent.addFlags(268435456);
        if (Util.isIntentAvailable(jVar.geo(), intent)) {
            WebViewUI geo = jVar.geo();
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(geo, bl.axQ(), "com/tencent/mm/plugin/webview/ui/tools/WebViewMenuHelper", "shareToWeRead", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            geo.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(geo, "com/tencent/mm/plugin/webview/ui/tools/WebViewMenuHelper", "shareToWeRead", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(211093);
            return;
        }
        Log.e("MicroMsg.WebViewMenuHelper", "not availble app match this intent");
        AppMethodBeat.o(211093);
    }

    static /* synthetic */ void e(j jVar) {
        AppMethodBeat.i(211094);
        try {
            Bundle bundle = new Bundle();
            bundle.putString("enterprise_action", "enterprise_connectors");
            final ArrayList<String> stringArrayList = jVar.geo().IMH.mHh.j(71, bundle).getStringArrayList("enterprise_connectors");
            if (stringArrayList == null || stringArrayList.size() <= 0) {
                AppMethodBeat.o(211094);
            } else if (stringArrayList.size() == 1) {
                jVar.bam(stringArrayList.get(0));
                AppMethodBeat.o(211094);
            } else {
                jVar.ik(stringArrayList);
                com.tencent.mm.ui.tools.l lVar = new com.tencent.mm.ui.tools.l(jVar.geo());
                lVar.a(jVar.geo().pGj, jVar.geo(), null);
                lVar.HMa = new o.b() {
                    /* class com.tencent.mm.plugin.webview.ui.tools.j.AnonymousClass7 */

                    @Override // com.tencent.mm.ui.base.o.b
                    public final void a(ImageView imageView, MenuItem menuItem) {
                        Bitmap baf;
                        AppMethodBeat.i(211057);
                        if (j.e(menuItem)) {
                            imageView.setVisibility(8);
                            AppMethodBeat.o(211057);
                            return;
                        }
                        String sb = new StringBuilder().append((Object) menuItem.getTitle()).toString();
                        if (j.this.Jgl.get(sb) == null || j.this.Jgl.get(sb).isRecycled()) {
                            Log.w("MicroMsg.WebViewMenuHelper", "on attach icon, load from cache fail");
                            try {
                                String aZQ = j.this.geo().IMH.mHh.aZQ(sb);
                                if (!Util.isNullOrNil(aZQ) && (baf = e.baf(aZQ)) != null && !baf.isRecycled()) {
                                    imageView.setImageBitmap(baf);
                                    j.this.Jgl.put(sb, baf);
                                }
                                AppMethodBeat.o(211057);
                            } catch (Exception e2) {
                                Log.w("MicroMsg.WebViewMenuHelper", "getheadimg, ex = " + e2.getMessage());
                                AppMethodBeat.o(211057);
                            }
                        } else {
                            imageView.setImageBitmap(j.this.Jgl.get(sb));
                            AppMethodBeat.o(211057);
                        }
                    }
                };
                lVar.HMb = new o.c() {
                    /* class com.tencent.mm.plugin.webview.ui.tools.j.AnonymousClass8 */

                    @Override // com.tencent.mm.ui.base.o.c
                    public final void a(TextView textView, MenuItem menuItem) {
                        AppMethodBeat.i(211058);
                        String sb = new StringBuilder().append((Object) menuItem.getTitle()).toString();
                        if (textView != null) {
                            String str = j.this.Jgm.get(sb);
                            if (Util.isNullOrNil(str)) {
                                textView.setText(sb);
                                AppMethodBeat.o(211058);
                                return;
                            }
                            textView.setText(l.b(j.this.geo(), str, textView.getTextSize()));
                        }
                        AppMethodBeat.o(211058);
                    }
                };
                lVar.b(jVar.geo().pGj, new View.OnCreateContextMenuListener() {
                    /* class com.tencent.mm.plugin.webview.ui.tools.j.AnonymousClass9 */

                    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                        AppMethodBeat.i(211059);
                        Iterator it = stringArrayList.iterator();
                        while (it.hasNext()) {
                            contextMenu.add((String) it.next());
                        }
                        AppMethodBeat.o(211059);
                    }
                }, new o.g() {
                    /* class com.tencent.mm.plugin.webview.ui.tools.j.AnonymousClass10 */

                    @Override // com.tencent.mm.ui.base.o.g
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                        AppMethodBeat.i(211060);
                        j.this.bam(menuItem.getTitle().toString());
                        AppMethodBeat.o(211060);
                    }
                });
                AppMethodBeat.o(211094);
            }
        } catch (Exception e2) {
            Log.w("MicroMsg.WebViewMenuHelper", "builder add, ex = " + e2.getMessage());
            AppMethodBeat.o(211094);
        }
    }
}
