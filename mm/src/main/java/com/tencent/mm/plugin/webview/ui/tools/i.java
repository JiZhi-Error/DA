package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MenuItem;
import android.view.View;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.b.n;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.g;
import com.tencent.mm.plugin.webview.modeltools.h;
import com.tencent.mm.pluginsdk.ui.tools.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.e;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.bottomsheet.ViewTitleWithAnimation;
import com.tencent.xweb.WebView;
import com.tencent.xweb.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.b.f;
import org.json.JSONObject;

public final class i extends a {
    static Map<String, Boolean> Jgg = new HashMap();
    private int DDM;
    private com.tencent.mm.plugin.webview.k.i FLs;
    private String FLt;
    private int IUQ;
    private e lBM;
    private String mHk;
    h mHo;
    private WebView.b mHp;
    private WebView.b mHq;
    ScanCodeSheetItemLogic mHu;
    private h.c mHw = new h.c() {
        /* class com.tencent.mm.plugin.webview.ui.tools.i.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.webview.modeltools.h.c
        public final void abF(String str) {
            AppMethodBeat.i(79838);
            if (i.this.gcd()) {
                AppMethodBeat.o(79838);
                return;
            }
            try {
                if (i.this.geo().mHh != null) {
                    i.this.geo().mHh.a(str, null, i.this.geo().ppd, i.this.geo().ppe);
                    AppMethodBeat.o(79838);
                    return;
                }
                Log.i("MicroMsg.WebViewLongClickHelper", "viewCaptureCallback, invoker is null");
                AppMethodBeat.o(79838);
            } catch (RemoteException e2) {
                Log.e("MicroMsg.WebViewLongClickHelper", "recog failed");
                AppMethodBeat.o(79838);
            }
        }
    };
    String nKc = "";

    static /* synthetic */ boolean a(i iVar, View view) {
        AppMethodBeat.i(175776);
        boolean gd = iVar.gd(view);
        AppMethodBeat.o(175776);
        return gd;
    }

    static /* synthetic */ boolean a(i iVar, WebView.b bVar) {
        AppMethodBeat.i(175771);
        boolean b2 = iVar.b(bVar);
        AppMethodBeat.o(175771);
        return b2;
    }

    static /* synthetic */ void b(i iVar) {
        AppMethodBeat.i(175770);
        iVar.gce();
        AppMethodBeat.o(175770);
    }

    static /* synthetic */ boolean b(i iVar, WebView.b bVar) {
        AppMethodBeat.i(175772);
        boolean a2 = iVar.a(bVar);
        AppMethodBeat.o(175772);
        return a2;
    }

    static /* synthetic */ boolean bak(String str) {
        AppMethodBeat.i(175774);
        boolean ahv = ahv(str);
        AppMethodBeat.o(175774);
        return ahv;
    }

    static /* synthetic */ String bal(String str) {
        AppMethodBeat.i(175775);
        String ahz = ahz(str);
        AppMethodBeat.o(175775);
        return ahz;
    }

    static /* synthetic */ boolean g(i iVar) {
        AppMethodBeat.i(175773);
        boolean geG = iVar.geG();
        AppMethodBeat.o(175773);
        return geG;
    }

    static {
        AppMethodBeat.i(175784);
        AppMethodBeat.o(175784);
    }

    public i(WebViewUI webViewUI) {
        super(webViewUI);
        AppMethodBeat.i(79848);
        if (geo().pGj != null) {
            geo().pGj.setOnLongClickListener(new View.OnLongClickListener() {
                /* class com.tencent.mm.plugin.webview.ui.tools.i.AnonymousClass5 */

                public final boolean onLongClick(final View view) {
                    AppMethodBeat.i(79842);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/WebViewLongClickHelper$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                    i.this.FLs = new com.tencent.mm.plugin.webview.k.i();
                    i.this.FLs.reset(1);
                    Log.v("MicroMsg.WebViewLongClickHelper", "registerForContextMenu normal view long click");
                    i.f(i.this);
                    if (i.this.geo().pGj == null) {
                        com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/webview/ui/tools/WebViewLongClickHelper$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                        AppMethodBeat.o(79842);
                    } else {
                        i.this.nKc = i.this.geo().fZM();
                        if (i.g(i.this) || !i.bak(i.this.nKc)) {
                            i.a(i.this, view);
                        } else {
                            i.this.geo().pGj.evaluateJavascript("javascript:(typeof window.getWXLongPressImageEventConfig === 'function')?window.getWXLongPressImageEventConfig():{}", new ValueCallback<String>() {
                                /* class com.tencent.mm.plugin.webview.ui.tools.i.AnonymousClass5.AnonymousClass1 */

                                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                                @Override // android.webkit.ValueCallback
                                public final /* synthetic */ void onReceiveValue(String str) {
                                    AppMethodBeat.i(175764);
                                    String str2 = str;
                                    Log.i("MicroMsg.WebViewLongClickHelper", "getWXLongPressImageEventConfig value %s", str2);
                                    if (!Util.isNullOrNil(str2)) {
                                        try {
                                            boolean z = new JSONObject(f.bvh(str2)).optInt("forbidForward", 0) == 1;
                                            i.Jgg.put(i.bal(i.this.nKc), Boolean.valueOf(z));
                                            Log.d("MicroMsg.WebViewLongClickHelper", "getWXLongPressImageEventConfig forbidForward %b", Boolean.valueOf(z));
                                        } catch (Exception e2) {
                                            Log.w("MicroMsg.WebViewLongClickHelper", "reportOnLeave, ex = %s", e2.getMessage());
                                        }
                                    }
                                    i.a(i.this, view);
                                    AppMethodBeat.o(175764);
                                }
                            });
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/webview/ui/tools/WebViewLongClickHelper$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                        AppMethodBeat.o(79842);
                    }
                    return false;
                }
            });
        }
        this.mHu = new ScanCodeSheetItemLogic(webViewUI, new ScanCodeSheetItemLogic.a() {
            /* class com.tencent.mm.plugin.webview.ui.tools.i.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.a
            public final void bLz() {
                AppMethodBeat.i(79840);
                if (i.this.lBM != null && i.this.lBM.isShowing()) {
                    i.b(i.this);
                }
                AppMethodBeat.o(79840);
            }
        });
        AppMethodBeat.o(79848);
    }

    public final void aF(String str, int i2, int i3) {
        AppMethodBeat.i(211047);
        Log.i("MicroMsg.WebViewLongClickHelper", "onGetQRCodeResult");
        this.mHk = str;
        this.IUQ = i2;
        this.DDM = i3;
        gce();
        if (Util.isNullOrNil(this.mHk)) {
            Log.w("MicroMsg.WebViewLongClickHelper", "processGetWXACodeNickName mResultOfImageUrl nil");
            AppMethodBeat.o(211047);
            return;
        }
        if (g.ci(this.IUQ, this.mHk)) {
            Log.i("MicroMsg.WebViewLongClickHelper", "processGetWXACodeNickName");
            Bundle bundle = new Bundle();
            try {
                bundle.putString("wxa_result", this.mHk);
                bundle.putInt("wxa_code_type", this.IUQ);
                bundle.putInt("wxa_code_version", this.DDM);
                geo().mHh.a(110000, bundle, geo().IMH.fZu());
                AppMethodBeat.o(211047);
                return;
            } catch (RemoteException e2) {
                Log.w("MicroMsg.WebViewLongClickHelper", "processGetWXACodeNickName exp:%s", e2.getLocalizedMessage());
            }
        }
        AppMethodBeat.o(211047);
    }

    private void gce() {
        AppMethodBeat.i(79849);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.webview.ui.tools.i.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(79841);
                if (i.this.mHp != null) {
                    i.a(i.this, i.this.mHp);
                    AppMethodBeat.o(79841);
                    return;
                }
                if (i.this.mHq != null) {
                    i.b(i.this, i.this.mHq);
                }
                AppMethodBeat.o(79841);
            }
        });
        AppMethodBeat.o(79849);
    }

    private boolean gd(View view) {
        AppMethodBeat.i(79850);
        if (gcd()) {
            AppMethodBeat.o(79850);
        } else {
            try {
                if (view instanceof android.webkit.WebView) {
                    WebView.b hitTestResult = geo().pGj.getHitTestResult();
                    if (hitTestResult == null) {
                        AppMethodBeat.o(79850);
                    } else {
                        if (hitTestResult.mType == 5 || hitTestResult.mType == 8) {
                            b(hitTestResult);
                        }
                        AppMethodBeat.o(79850);
                    }
                } else {
                    if (view instanceof MMWebView) {
                        WebView.b hitTestResult2 = ((MMWebView) view).getHitTestResult();
                        if (hitTestResult2 == null) {
                            AppMethodBeat.o(79850);
                        } else if (hitTestResult2.mType == 5 || hitTestResult2.mType == 8) {
                            a(hitTestResult2);
                        }
                    }
                    AppMethodBeat.o(79850);
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.WebViewLongClickHelper", "onCreateContextMenu exp %s", e2.getMessage());
            }
        }
        return false;
    }

    private boolean aYx(final String str) {
        AppMethodBeat.i(79853);
        if (gcd()) {
            AppMethodBeat.o(79853);
            return false;
        } else if (!geE()) {
            AppMethodBeat.o(79853);
            return true;
        } else {
            this.FLt = str;
            if (this.lBM == null) {
                this.lBM = new e((Context) geo(), 1, false);
            }
            this.lBM.HLX = new o.f() {
                /* class com.tencent.mm.plugin.webview.ui.tools.i.AnonymousClass6 */

                @Override // com.tencent.mm.ui.base.o.f
                public final void onCreateMMMenu(m mVar) {
                    AppMethodBeat.i(79843);
                    i.a(i.this, mVar);
                    AppMethodBeat.o(79843);
                }
            };
            this.lBM.HLY = new o.g() {
                /* class com.tencent.mm.plugin.webview.ui.tools.i.AnonymousClass7 */

                /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                @Override // com.tencent.mm.ui.base.o.g
                public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                    AppMethodBeat.i(79844);
                    switch (menuItem.getItemId()) {
                        case 1:
                            i.a(i.this, 1);
                            i.b(i.this, str);
                            AppMethodBeat.o(79844);
                            return;
                        case 2:
                            i.a(i.this, 2);
                            i.c(i.this, str);
                            AppMethodBeat.o(79844);
                            return;
                        case 3:
                            i.a(i.this, 3);
                            i.d(i.this, str);
                            break;
                    }
                    AppMethodBeat.o(79844);
                }
            };
            this.lBM.PGl = new e.b() {
                /* class com.tencent.mm.plugin.webview.ui.tools.i.AnonymousClass8 */

                @Override // com.tencent.mm.ui.widget.a.e.b
                public final void onDismiss() {
                    AppMethodBeat.i(79845);
                    i.a(i.this, 5);
                    if (!(i.this.mHo == null || i.this.geo().mHh == null)) {
                        try {
                            i.this.IUQ = 0;
                            i.this.mHk = null;
                            i.this.mHu.onDismiss();
                            i.this.geo().mHh.aZZ(i.this.mHo.Jbk);
                            i.this.mHo.gdA();
                            AppMethodBeat.o(79845);
                            return;
                        } catch (Exception e2) {
                            Log.e("MicroMsg.WebViewLongClickHelper", "cancel capture failed");
                        }
                    }
                    AppMethodBeat.o(79845);
                }
            };
            if (!geo().isFinishing() && geI()) {
                this.lBM.dGm();
            }
            boolean isShowing = this.lBM.isShowing();
            AppMethodBeat.o(79853);
            return isShowing;
        }
    }

    private boolean geE() {
        AppMethodBeat.i(79854);
        boolean z = false;
        try {
            z = geo().mHh.isSDCardAvailable();
        } catch (Exception e2) {
            Log.e("MicroMsg.WebViewLongClickHelper", "onCreateContextMenu fail, ex = " + e2.getMessage());
        }
        AppMethodBeat.o(79854);
        return z;
    }

    private boolean geF() {
        boolean z = false;
        AppMethodBeat.i(79855);
        try {
            z = geo().mHh.gdW();
        } catch (Exception e2) {
            Log.e("MicroMsg.WebViewLongClickHelper", "get has setuin failed : %s", e2.getMessage());
        }
        AppMethodBeat.o(79855);
        return z;
    }

    private boolean gcf() {
        boolean z = false;
        AppMethodBeat.i(79856);
        int aXI = geo().aXI(Util.nullAsNil(geo().JiT));
        if (aXI == 53 || aXI == 52) {
            Log.i("MicroMsg.WebViewLongClickHelper", "isAllowScanQRCode open link not allow to ScanQRCode");
            AppMethodBeat.o(79856);
        } else {
            try {
                if (geo().mHh == null) {
                    Log.w("MicroMsg.WebViewLongClickHelper", "invoker is null");
                    AppMethodBeat.o(79856);
                } else {
                    z = geo().mHh.geh();
                    AppMethodBeat.o(79856);
                }
            } catch (RemoteException e2) {
                Log.e("MicroMsg.WebViewLongClickHelper", "unable get config for Scan QRCode" + e2.getMessage());
            }
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public static final class a {
        final int id;
        final String title;

        public a(int i2, String str) {
            this.id = i2;
            this.title = str;
        }
    }

    private boolean geG() {
        AppMethodBeat.i(175765);
        boolean containsKey = Jgg.containsKey(ahz(this.nKc));
        AppMethodBeat.o(175765);
        return containsKey;
    }

    private boolean geH() {
        AppMethodBeat.i(175766);
        if (!geG()) {
            AppMethodBeat.o(175766);
            return false;
        }
        boolean booleanValue = Jgg.get(ahz(this.nKc)).booleanValue();
        AppMethodBeat.o(175766);
        return booleanValue;
    }

    private boolean geI() {
        AppMethodBeat.i(175767);
        if (!geH() || !Util.isNullOrNil(this.mHk)) {
            AppMethodBeat.o(175767);
            return true;
        }
        AppMethodBeat.o(175767);
        return false;
    }

    static String ahz(String str) {
        AppMethodBeat.i(175768);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(175768);
            return "";
        } else if (!ahv(str)) {
            AppMethodBeat.o(175768);
            return str;
        } else {
            String ahz = ((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).ahz(str);
            AppMethodBeat.o(175768);
            return ahz;
        }
    }

    private static boolean ahv(String str) {
        AppMethodBeat.i(211048);
        if (str == null || com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class) == null) {
            AppMethodBeat.o(211048);
            return false;
        }
        boolean ahv = ((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).ahv(str);
        AppMethodBeat.o(211048);
        return ahv;
    }

    public static void f(MMWebView mMWebView) {
        AppMethodBeat.i(211049);
        if (!(((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_webview_long_press_test_enable, 0) == 1)) {
            AppMethodBeat.o(211049);
            return;
        }
        Log.i("MicroMsg.WebViewLongClickHelper", "WebViewLongPress AB Test Enabled");
        int a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_webview_long_press_menu_duration, 500);
        if (a2 < 150 || a2 > 2500) {
            Log.w("MicroMsg.WebViewLongClickHelper", "WebViewLongPress  is invalid, time = %d", Integer.valueOf(a2));
            AppMethodBeat.o(211049);
            return;
        }
        Log.i("MicroMsg.WebViewLongClickHelper", "WebViewLongPress Set Time: %d", Integer.valueOf(a2));
        mMWebView.getSettings().enableCustomizedLongPressTimeout(a2);
        AppMethodBeat.o(211049);
    }

    private boolean a(WebView.b bVar) {
        AppMethodBeat.i(79851);
        boolean aYx = aYx(bVar.mExtra);
        if (Util.isNullOrNil(this.mHk) && geo().mHi.gdI().gtD() && gcf()) {
            this.mHq = bVar;
            this.mHo = new h();
            this.mHo.a(geo().pGj, this.mHw);
        }
        AppMethodBeat.o(79851);
        return aYx;
    }

    private boolean b(WebView.b bVar) {
        AppMethodBeat.i(79852);
        boolean aYx = aYx(bVar.mExtra);
        if (Util.isNullOrNil(this.mHk) && geo().mHi.gdI().gtD() && gcf()) {
            this.mHp = bVar;
            this.mHo = new h();
            this.mHo.a(geo().pGj, this.mHw);
        }
        AppMethodBeat.o(79852);
        return aYx;
    }

    static /* synthetic */ void f(i iVar) {
        AppMethodBeat.i(211050);
        iVar.mHk = null;
        iVar.mHq = null;
        iVar.mHp = null;
        iVar.mHu.onDismiss();
        AppMethodBeat.o(211050);
    }

    static /* synthetic */ void a(i iVar, m mVar) {
        AppMethodBeat.i(175777);
        boolean geH = iVar.geH();
        boolean geF = iVar.geF();
        boolean gtH = iVar.geo().mHi.gdI().gtH();
        boolean gtI = iVar.geo().mHi.gdI().gtI();
        Log.i("MicroMsg.WebViewLongClickHelper", "installMenuItems hasSetAcc = %b, canShareImage = %b, canFavImage = %b", Boolean.valueOf(geF), Boolean.valueOf(gtH), Boolean.valueOf(gtI));
        ArrayList arrayList = new ArrayList();
        if (!geH) {
            if (geF && gtH) {
                arrayList.add(new a(1, iVar.geo().getString(R.string.ftk)));
            }
            arrayList.add(new a(2, iVar.geo().getString(R.string.gau)));
            if (geF && gtI) {
                arrayList.add(new a(3, iVar.geo().getString(R.string.fn9)));
            }
        }
        if (iVar.mHk != null) {
            arrayList.add(new a(4, iVar.mHu.Wp(iVar.IUQ)));
        }
        iVar.lBM.setFooterView(null);
        mVar.clear();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            a aVar = (a) arrayList.get(i2);
            if (aVar.id == 4) {
                View a2 = iVar.mHu.a(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.webview.ui.tools.i.AnonymousClass9 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(79846);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/WebViewLongClickHelper$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        if (i.this.lBM != null && i.this.lBM.isShowing()) {
                            i.this.lBM.bMo();
                        }
                        i.a(i.this, 4);
                        i.e(i.this, i.this.mHk);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewLongClickHelper$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(79846);
                    }
                }, iVar.IUQ, iVar.mHk, 7);
                iVar.lBM.setFooterView(a2);
                if (a2 instanceof ViewTitleWithAnimation) {
                    if (arrayList.size() > 1) {
                        ((ViewTitleWithAnimation) a2).setTopPaddingVisibility(0);
                    } else {
                        ((ViewTitleWithAnimation) a2).setTopPaddingVisibility(8);
                    }
                }
            } else {
                mVar.d(aVar.id, aVar.title);
            }
        }
        AppMethodBeat.o(175777);
    }

    static /* synthetic */ void a(i iVar, int i2) {
        String bfG;
        AppMethodBeat.i(175778);
        if (iVar.FLs != null) {
            if (iVar.geo() != null) {
                iVar.FLs.url = iVar.nKc;
                iVar.FLs.ehX = iVar.geo().bLC();
            }
            if (!Util.isNullOrNil(iVar.mHk)) {
                iVar.FLs.JBD = true;
                iVar.FLs.ahn(iVar.IUQ);
                iVar.FLs.scanResult = iVar.mHk;
            }
            if (URLUtil.isDataUrl(iVar.FLt)) {
                try {
                    bfG = n.fc(iVar.FLt);
                } catch (Exception e2) {
                    Log.e("MicroMsg.WebViewLongClickHelper", "getSHA1 ex %s", e2.getMessage());
                    bfG = "";
                }
            } else {
                bfG = z.bfG(iVar.FLt);
            }
            iVar.FLs.zfq = bfG;
            iVar.FLs.pl(i2);
        }
        AppMethodBeat.o(175778);
    }

    static /* synthetic */ void b(i iVar, String str) {
        AppMethodBeat.i(175779);
        try {
            z.a(iVar.geo(), str, c.hsp().getCookie(str), iVar.geE(), new z.a() {
                /* class com.tencent.mm.plugin.webview.ui.tools.i.AnonymousClass10 */

                @Override // com.tencent.mm.pluginsdk.ui.tools.z.a
                public final void abE(String str) {
                    AppMethodBeat.i(79847);
                    if (Util.isNullOrNil(str)) {
                        Log.w("MicroMsg.WebViewLongClickHelper", "share image to friend fail, imgPath is null");
                        AppMethodBeat.o(79847);
                        return;
                    }
                    i.f(i.this, str);
                    AppMethodBeat.o(79847);
                }
            });
            AppMethodBeat.o(175779);
        } catch (Exception e2) {
            Log.e("MicroMsg.WebViewLongClickHelper", "onMenuItemClick fail, ex = " + e2.getMessage());
            AppMethodBeat.o(175779);
        }
    }

    static /* synthetic */ void c(i iVar, String str) {
        AppMethodBeat.i(79857);
        try {
            z.b(iVar.geo(), str, c.hsp().getCookie(str), iVar.geE());
            AppMethodBeat.o(79857);
        } catch (Exception e2) {
            Log.e("MicroMsg.WebViewLongClickHelper", "save to sdcard failed : %s", e2.getMessage());
            AppMethodBeat.o(79857);
        }
    }

    static /* synthetic */ void d(i iVar, String str) {
        AppMethodBeat.i(175780);
        try {
            boolean geE = iVar.geE();
            String replaceAll = str.replaceAll("tp=webp", "");
            z.a(iVar.geo(), replaceAll, c.hsp().getCookie(replaceAll), geE, new z.a() {
                /* class com.tencent.mm.plugin.webview.ui.tools.i.AnonymousClass2 */

                @Override // com.tencent.mm.pluginsdk.ui.tools.z.a
                public final void abE(String str) {
                    AppMethodBeat.i(79839);
                    i.g(i.this, str);
                    AppMethodBeat.o(79839);
                }
            });
            AppMethodBeat.o(175780);
        } catch (Exception e2) {
            Log.e("MicroMsg.WebViewLongClickHelper", "onMenuItemClick fail, ex = " + e2.getMessage());
            AppMethodBeat.o(175780);
        }
    }

    static /* synthetic */ void e(i iVar, String str) {
        String substring;
        AppMethodBeat.i(175781);
        try {
            Bundle bundle = new Bundle();
            bundle.putString("preUsername", iVar.geo().getIntent().getStringExtra("preUsername"));
            bundle.putString("preChatName", iVar.geo().getIntent().getStringExtra("preChatName"));
            bundle.putString("rawUrl", iVar.geo().coX());
            String stringExtra = iVar.geo().getIntent().getStringExtra("pre_username");
            if (stringExtra == null || !iVar.geo().mHh.IT(stringExtra)) {
                bundle.putString("pre_username", iVar.geo().getIntent().getStringExtra(e.p.OzH));
            } else {
                bundle.putString("pre_username", stringExtra);
            }
            com.tencent.mm.plugin.webview.stub.e eVar = iVar.geo().mHh;
            String str2 = iVar.mHk;
            String str3 = iVar.nKc;
            if (Util.isNullOrNil(str)) {
                substring = "";
            } else {
                substring = str.length() > 1024 ? str.substring(0, 1024) : str;
            }
            eVar.a(str2, str3, substring, iVar.IUQ, iVar.DDM, bundle);
            Log.i("MicroMsg.WebViewLongClickHelper", "onMenuItemClick recognize qbcode");
            AppMethodBeat.o(175781);
        } catch (RemoteException e2) {
            Log.e("MicroMsg.WebViewLongClickHelper", "recognize qbar result failed");
            AppMethodBeat.o(175781);
        }
    }

    static /* synthetic */ void f(i iVar, String str) {
        AppMethodBeat.i(175782);
        if (!iVar.gcd()) {
            try {
                iVar.geo().mHh.aZY(str);
                AppMethodBeat.o(175782);
                return;
            } catch (Exception e2) {
                Log.e("MicroMsg.WebViewLongClickHelper", "sendImgToFriend fail, ex = " + e2.getMessage());
            }
        }
        AppMethodBeat.o(175782);
    }

    static /* synthetic */ void g(i iVar, String str) {
        AppMethodBeat.i(175783);
        if (!iVar.gcd()) {
            try {
                com.tencent.mm.plugin.fav.ui.e.a(iVar.geo().mHh.aZX(str), iVar.geo(), iVar.geo().xxK);
                AppMethodBeat.o(175783);
                return;
            } catch (Exception e2) {
                Log.e("MicroMsg.WebViewLongClickHelper", "favoriteUrl fail, ex = " + e2.getMessage());
            }
        }
        AppMethodBeat.o(175783);
    }
}
