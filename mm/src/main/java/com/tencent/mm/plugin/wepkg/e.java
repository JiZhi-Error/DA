package com.tencent.mm.plugin.wepkg;

import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.webkit.ConsoleMessage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.game.commlib.util.BatteryManager;
import com.tencent.mm.plugin.wepkg.event.DownloadBigPkgCompleteNotify;
import com.tencent.mm.plugin.wepkg.event.ForceUpdateNotify;
import com.tencent.mm.plugin.wepkg.event.a;
import com.tencent.mm.plugin.wepkg.event.b;
import com.tencent.mm.plugin.wepkg.event.c;
import com.tencent.mm.plugin.wepkg.model.WepkgVersion;
import com.tencent.mm.plugin.wepkg.model.f;
import com.tencent.mm.plugin.wepkg.model.h;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public final class e {
    private static final Pattern lnT = Pattern.compile(".*#.*wechat_redirect");
    public boolean JLC = false;
    h JLD;
    private WepkgVersion JLE;
    private f JLF;
    private boolean JLG = false;
    private boolean JLH = false;
    public b JLI;
    private boolean JLJ = false;
    private Set<String> JLK = new HashSet();
    private long JLL;
    public boolean JLM = true;
    private String JLN;
    public boolean JLO;
    private boolean JLP;
    public boolean JLQ = false;
    private long aWK = 0;
    private MTimerHandler timer;
    private String xGt;
    private a xwU;
    private String xyo;
    private GameWebPerformanceInfo xyv;

    static /* synthetic */ void h(e eVar) {
        AppMethodBeat.i(200157);
        eVar.gkz();
        AppMethodBeat.o(200157);
    }

    public e() {
        AppMethodBeat.i(110539);
        d.gkp();
        this.JLF = new f();
        d.gkq();
        this.xwU = new a() {
            /* class com.tencent.mm.plugin.wepkg.e.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.wepkg.event.a
            public final void dt(Object obj) {
                DownloadBigPkgCompleteNotify downloadBigPkgCompleteNotify;
                AppMethodBeat.i(110535);
                if (obj instanceof ForceUpdateNotify) {
                    ForceUpdateNotify forceUpdateNotify = (ForceUpdateNotify) obj;
                    if (!(forceUpdateNotify == null || forceUpdateNotify.JMN == null || forceUpdateNotify.JMN.length <= 0)) {
                        String[] strArr = forceUpdateNotify.JMN;
                        for (String str : strArr) {
                            if (str.equals(a.gkm()) || (!Util.isNullOrNil(e.this.xGt) && str.equals(e.this.xGt))) {
                                e.a(e.this, str);
                                AppMethodBeat.o(110535);
                                return;
                            }
                        }
                    }
                    AppMethodBeat.o(110535);
                    return;
                }
                if ((obj instanceof DownloadBigPkgCompleteNotify) && (downloadBigPkgCompleteNotify = (DownloadBigPkgCompleteNotify) obj) != null && downloadBigPkgCompleteNotify.hhD != null && (downloadBigPkgCompleteNotify.hhD.equals(a.gkm()) || downloadBigPkgCompleteNotify.hhD.equals(e.this.xGt))) {
                    e.a(e.this, downloadBigPkgCompleteNotify.hhD, downloadBigPkgCompleteNotify.success, downloadBigPkgCompleteNotify.JML);
                }
                AppMethodBeat.o(110535);
            }
        };
        c.a(this.xwU);
        AppMethodBeat.o(110539);
    }

    public final boolean m(String str, boolean z, boolean z2) {
        AppMethodBeat.i(200146);
        this.JLP = z2;
        this.xyo = str;
        this.xGt = d.bcO(str);
        h cU = d.cU(str, z);
        if (cU != null) {
            if (cU.dTL()) {
                this.JLD = cU;
                this.JLC = true;
                this.JLE = this.JLD.JNh;
                com.tencent.mm.plugin.wepkg.utils.a.b("WepkgUsed", this.xyo, this.xGt, this.JLE.version, 2, 0, null);
                com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", this.xyo, this.xGt, this.JLE.version, 1, 0, null);
            } else {
                com.tencent.mm.plugin.wepkg.utils.a.b("WepkgUsed", this.xyo, this.xGt, cU.Dak, 3, 0, com.tencent.mm.plugin.wepkg.utils.a.ahr(cU.JMR));
            }
            if (cU.JMS) {
                com.tencent.mm.plugin.wepkg.utils.a.b("WepkgUsed", this.xyo, this.xGt, cU.Dak, 1, 0, null);
            }
        } else {
            com.tencent.mm.plugin.wepkg.utils.a.b("WepkgUsed", this.xyo, this.xGt, null, 3, 0, com.tencent.mm.plugin.wepkg.utils.a.ahr(8));
        }
        com.tencent.mm.plugin.wepkg.utils.a.b("WepkgUsed", this.xyo, this.xGt, this.JLE != null ? this.JLE.version : "", 0, 0, null);
        if (this.JLC && !Util.isNullOrNil(this.xGt)) {
            boolean z3 = ((com.tencent.mm.game.report.a.b) g.af(com.tencent.mm.game.report.a.b.class)).a(b.a.clicfg_game_open_page_cache, 0) == 1;
            Log.i("MicroMsg.Wepkg.WePkgPlugin", "isOpenPageCache:%b", Boolean.valueOf(z3));
            if (z3) {
                this.JLN = ((com.tencent.mm.plugin.game.luggage.a.a) g.af(com.tencent.mm.plugin.game.luggage.a.a.class)).azz(this.xGt);
                if (this.JLN != null && this.JLN.length() < 8) {
                    this.JLN = null;
                }
            }
            Log.d("MicroMsg.Wepkg.WePkgPlugin", "mPageCache:%s", this.JLN);
        }
        Log.i("MicroMsg.Wepkg.WePkgPlugin", "wepkgAvailable:%s, pkgId:%s", Boolean.valueOf(this.JLC), this.xGt);
        if (this.xyv == null) {
            this.xyv = GameWebPerformanceInfo.Fd(str);
            this.xyv.hhD = d.bcO(str);
            this.xyv.hhw = this.JLC ? 1 : 0;
            this.xyv.hhY = a.gkn();
            this.xyv.hhZ = gkx();
        }
        boolean z4 = this.JLC;
        AppMethodBeat.o(200146);
        return z4;
    }

    public final String gkv() {
        if (!this.JLC) {
            this.JLN = null;
        }
        return this.JLN;
    }

    public final void zE(boolean z) {
        AppMethodBeat.i(110541);
        if (this.timer != null) {
            this.timer.stopTimer();
        }
        if (z && !Util.isNullOrNil(this.xGt)) {
            d.aer(this.xGt);
            com.tencent.mm.plugin.wepkg.model.c.gkN().aH(this.xGt, 2, 1);
        }
        d.gks();
        c.b(this.xwU);
        AppMethodBeat.o(110541);
    }

    public final void bcg(String str) {
        AppMethodBeat.i(200147);
        Log.d("MicroMsg.Wepkg.WePkgPlugin", "onPageStarted, url = %s", str);
        this.aWK = System.currentTimeMillis();
        AppMethodBeat.o(200147);
    }

    public final void bch(String str) {
        AppMethodBeat.i(200148);
        Log.d("MicroMsg.Wepkg.WePkgPlugin", "onPageFinished, url = %s", str);
        if (this.aWK != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.aWK;
            String bcO = d.bcO(str);
            if (Util.isNullOrNil(bcO)) {
                com.tencent.mm.plugin.wepkg.utils.a.b("PageLoadTime", str, "", null, 2, currentTimeMillis, null);
            } else if (!this.JLC || this.JLE == null) {
                com.tencent.mm.plugin.wepkg.utils.a.b("PageLoadTime", str, bcO, null, 0, currentTimeMillis, null);
            } else {
                com.tencent.mm.plugin.wepkg.utils.a.b("PageLoadTime", str, this.JLE.hhD, this.JLE.version, 1, currentTimeMillis, null);
            }
            this.aWK = 0;
        }
        if (this.JLC && this.JLD != null && !this.JLP && (!Util.isNullOrNil(this.JLN) || this.JLD.bcE(str))) {
            Log.i("MicroMsg.Wepkg.WePkgPlugin", "startTimer");
            if (this.timer == null) {
                gkA();
            }
            this.timer.startTimer(1000);
        }
        AppMethodBeat.o(200148);
    }

    public final void a(ConsoleMessage consoleMessage) {
        AppMethodBeat.i(110544);
        this.JLH = true;
        String message = consoleMessage != null ? consoleMessage.message() : null;
        if (!Util.isNullOrNil(message) && message.equalsIgnoreCase("weixin://whiteScreenEnd")) {
            Log.i("MicroMsg.Wepkg.WePkgPlugin", "mIsReceivedWhiteScreenEnd: true");
            this.JLG = true;
        }
        AppMethodBeat.o(110544);
    }

    public final WebResourceResponse p(WebView webView, String str) {
        WebResourceResponse webResourceResponse;
        AppMethodBeat.i(200149);
        Log.d("MicroMsg.Wepkg.WePkgPlugin", "onRequestIntercept, url: ".concat(String.valueOf(str)));
        if (webView != null) {
            q(webView, str);
        }
        String bce = d.bce(str);
        if (bce != null) {
            Log.i("MicroMsg.Wepkg.WePkgPlugin", "onRequestIntercept, rid: ".concat(String.valueOf(bce)));
            WebResourceResponse bca = a.bca(bce);
            if (bca != null) {
                AppMethodBeat.o(200149);
                return bca;
            }
        }
        String bcO = d.bcO(str);
        if (!bcO.equals(this.xGt)) {
            Log.i("MicroMsg.Wepkg.WePkgPlugin", "load iframe pkgId:%s", bcO);
            this.JLF.bcA(str);
        }
        if (this.JLC) {
            if (this.JLD != null) {
                webResourceResponse = this.JLD.bcB(d.bcQ(str));
            } else {
                webResourceResponse = null;
            }
            if (webResourceResponse != null) {
                if (this.JLE != null) {
                    com.tencent.mm.plugin.wepkg.utils.a.b("RequestHook", str, this.JLE.hhD, this.JLE.version, 1, 0, null);
                }
                Log.i("MicroMsg.Wepkg.WePkgPlugin", "hit resource:%s", str);
                AppMethodBeat.o(200149);
                return webResourceResponse;
            }
        }
        WebResourceResponse bcB = this.JLF.bcB(d.bcQ(str));
        AppMethodBeat.o(200149);
        return bcB;
    }

    private void q(final WebView webView, String str) {
        AppMethodBeat.i(200150);
        if (!this.JLO && !df(str)) {
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.wepkg.e.AnonymousClass2 */

                public final void run() {
                    boolean z;
                    AppMethodBeat.i(110536);
                    if (webView != null) {
                        String format = String.format("javascript:(function() {window.__usewepkg__=%s;})();", String.valueOf(e.this.bci(e.this.xyo)));
                        Log.i("MicroMsg.Wepkg.WePkgPlugin", "__usewepkg__: %s", format);
                        webView.evaluateJavascript(format, null);
                        Object[] objArr = new Object[1];
                        PowerManager powerManager = (PowerManager) MMApplicationContext.getContext().getSystemService("power");
                        if (powerManager == null || Build.VERSION.SDK_INT < 21) {
                            z = false;
                        } else {
                            z = powerManager.isPowerSaveMode();
                        }
                        objArr[0] = String.valueOf(z);
                        String format2 = String.format("javascript:(function() {window.__lowPowerMode__=%s;})();", objArr);
                        Log.i("MicroMsg.Wepkg.WePkgPlugin", "__lowPowerMode__: %s", format2);
                        webView.evaluateJavascript(format2, null);
                        String format3 = String.format("javascript:(function() {window.__lowPower__=%s;})();", String.valueOf(BatteryManager.xvy));
                        Log.i("MicroMsg.Wepkg.WePkgPlugin", "__lowPower__: %s", format3);
                        webView.evaluateJavascript(format3, null);
                        String format4 = String.format("javascript:(function() {window.__game_center_preload__=%s;})();", String.valueOf(e.this.JLQ));
                        Log.i("MicroMsg.Wepkg.WePkgPlugin", "__game_center_preload__: %s", format4);
                        webView.evaluateJavascript(format4, null);
                        String format5 = String.format("javascript:(function() {window.__is_game_center_preload_page__=%s;})();", String.valueOf(e.this.JLQ));
                        Log.i("MicroMsg.Wepkg.WePkgPlugin", "__is_game_center_preload_page__: %s", format5);
                        webView.evaluateJavascript(format5, null);
                        AppMethodBeat.o(110536);
                        return;
                    }
                    Log.i("MicroMsg.Wepkg.WePkgPlugin", "injectGameJs, webview == null");
                    AppMethodBeat.o(110536);
                }
            });
            this.JLO = true;
        }
        AppMethodBeat.o(200150);
    }

    public final Object onMiscCallBack(String str, Bundle bundle) {
        AppMethodBeat.i(110546);
        Object[] objArr = new Object[2];
        objArr[0] = str;
        objArr[1] = Boolean.valueOf(bundle == null);
        Log.i("MicroMsg.Wepkg.WePkgPlugin", "method = %s, bundler == null ? %b", objArr);
        if (Util.isNullOrNil(str) || bundle == null) {
            AppMethodBeat.o(110546);
            return null;
        }
        if (this.JLC && this.JLD != null && str.equalsIgnoreCase("shouldInterceptMediaUrl")) {
            String string = bundle.getString("url");
            Log.i("MicroMsg.Wepkg.WePkgPlugin", "onMiscCallBack origin mediaUrl:".concat(String.valueOf(string)));
            if (!Util.isNullOrNil(string)) {
                Log.i("MicroMsg.Wepkg.WePkgPlugin", "onMiscCallBack replace localPath");
                String anz = this.JLD.anz(d.bcQ(string));
                if (!Util.isNullOrNil(anz)) {
                    Log.i("MicroMsg.Wepkg.WePkgPlugin", "localFile:".concat(String.valueOf(anz)));
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(859, 14, 1, false);
                    AppMethodBeat.o(110546);
                    return anz;
                }
            }
        }
        AppMethodBeat.o(110546);
        return null;
    }

    private static boolean df(String str) {
        AppMethodBeat.i(177085);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(177085);
            return false;
        }
        String path = Uri.parse(str).getPath();
        if (path == null || !path.trim().endsWith("html")) {
            AppMethodBeat.o(177085);
            return false;
        }
        AppMethodBeat.o(177085);
        return true;
    }

    public final boolean gkw() {
        return this.JLE == null || !this.JLE.JNP;
    }

    public final String gkx() {
        if (this.JLE != null) {
            return this.JLE.version;
        }
        return "";
    }

    public static String gky() {
        AppMethodBeat.i(259551);
        String gkn = a.gkn();
        AppMethodBeat.o(259551);
        return gkn;
    }

    static {
        AppMethodBeat.i(110556);
        AppMethodBeat.o(110556);
    }

    public final boolean bci(String str) {
        AppMethodBeat.i(110549);
        if (lnT.matcher(Util.nullAsNil(str)).find()) {
            AppMethodBeat.o(110549);
            return false;
        }
        boolean z = this.JLC;
        AppMethodBeat.o(110549);
        return z;
    }

    public final boolean isAvailable() {
        return this.JLC;
    }

    private void gkz() {
        AppMethodBeat.i(200152);
        this.JLM = false;
        ((com.tencent.mm.plugin.game.luggage.a.a) g.af(com.tencent.mm.plugin.game.luggage.a.a.class)).azA(this.xGt);
        AppMethodBeat.o(200152);
    }

    private void gkA() {
        AppMethodBeat.i(200153);
        this.timer = new MTimerHandler(new MTimerHandler.CallBack() {
            /* class com.tencent.mm.plugin.wepkg.e.AnonymousClass3 */

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                AppMethodBeat.i(110538);
                if (!e.this.JLH || e.this.JLG) {
                    e.ahq(0);
                } else {
                    Log.i("MicroMsg.Wepkg.WePkgPlugin", "white screen");
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.wepkg.e.AnonymousClass3.AnonymousClass1 */

                        public final void run() {
                            boolean z = false;
                            AppMethodBeat.i(110537);
                            try {
                                Log.i("MicroMsg.Wepkg.WePkgPlugin", "load url from net");
                                if (!Util.isNullOrNil(e.this.gkv())) {
                                    z = true;
                                }
                                e.f(e.this);
                                int gkB = e.gkB();
                                if (gkB > 1) {
                                    if (e.this.JLE != null) {
                                        if (z) {
                                            com.tencent.mm.plugin.wepkg.utils.a.b("whiteScreen", e.this.xyo, e.this.JLE.hhD, e.this.JLE.version, 1, 0, null);
                                        } else {
                                            com.tencent.mm.plugin.wepkg.utils.a.b("whiteScreen", e.this.xyo, e.this.JLE.hhD, e.this.JLE.version, -1, 0, null);
                                        }
                                    }
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(859, 13, 1, false);
                                    String bcO = d.bcO(e.this.xyo);
                                    d.aer(bcO);
                                    com.tencent.mm.plugin.wepkg.model.c.gkN().aH(bcO, 1, 2);
                                    e.gkC();
                                    e.h(e.this);
                                    AppMethodBeat.o(110537);
                                    return;
                                }
                                e.ahq(gkB + 1);
                                AppMethodBeat.o(110537);
                            } catch (Exception e2) {
                                AppMethodBeat.o(110537);
                            }
                        }
                    });
                }
                AppMethodBeat.o(110538);
                return false;
            }
        }, false);
        AppMethodBeat.o(200153);
    }

    static /* synthetic */ void a(e eVar, String str) {
        AppMethodBeat.i(110550);
        eVar.gkz();
        eVar.JLL = System.currentTimeMillis();
        Log.i("MicroMsg.Wepkg.WePkgPlugin", "forceUpdatePageSrc, pkgId: %s, time: %d", str, Long.valueOf(eVar.JLL));
        eVar.JLK.add(str);
        if (eVar.JLI != null && eVar.JLC && !eVar.JLJ) {
            eVar.JLJ = true;
            eVar.JLI.dTU();
        }
        a.bbZ(str);
        AppMethodBeat.o(110550);
    }

    static /* synthetic */ void a(e eVar, String str, boolean z, boolean z2) {
        String str2;
        AppMethodBeat.i(200154);
        Log.i("MicroMsg.Wepkg.WePkgPlugin", "downloadPkgCpl, pkgId: %s, success: %b", str, Boolean.valueOf(z));
        if (z && z2 && str.equalsIgnoreCase(eVar.xGt)) {
            eVar.gkz();
        }
        if (eVar.JLK.contains(str)) {
            int i2 = z ? 1 : 2;
            long currentTimeMillis = System.currentTimeMillis() - eVar.JLL;
            String str3 = eVar.xyo;
            if (eVar.xGt == null || !eVar.xGt.equals(str)) {
                if (a.gkm().equals(str)) {
                    str2 = a.gkn();
                } else {
                    str2 = "";
                }
            } else if (eVar.JLE != null) {
                str2 = eVar.JLE.version;
            } else {
                str2 = "";
            }
            com.tencent.mm.plugin.wepkg.utils.a.b("forceUpdateTime", str3, str, str2, (long) i2, currentTimeMillis, null);
            eVar.JLK.remove(str);
            d.aer(str);
        }
        a.cT(str, z);
        if (eVar.JLI != null && eVar.JLC && eVar.JLK.isEmpty()) {
            eVar.JLI.pL(z);
        }
        AppMethodBeat.o(200154);
    }

    static /* synthetic */ void f(e eVar) {
        AppMethodBeat.i(200155);
        Log.i("MicroMsg.Wepkg.WePkgPlugin", "reloadPage");
        if (eVar.JLC) {
            eVar.JLC = false;
            d.aer(eVar.xGt);
        }
        if (eVar.JLI != null) {
            eVar.JLI.dTT();
        }
        AppMethodBeat.o(200155);
    }

    static /* synthetic */ int gkB() {
        AppMethodBeat.i(200156);
        SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences("we_pkg_sp", 4);
        if (sharedPreferences != null) {
            int i2 = sharedPreferences.getInt("white_screen_times", 0);
            AppMethodBeat.o(200156);
            return i2;
        }
        AppMethodBeat.o(200156);
        return 0;
    }

    static /* synthetic */ void gkC() {
        AppMethodBeat.i(110554);
        SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences("we_pkg_sp", 4);
        if (sharedPreferences != null) {
            Log.i("MicroMsg.Wepkg.WePkgPlugin", "disableWePkg");
            sharedPreferences.edit().putBoolean("disable_we_pkg", true).commit();
        }
        AppMethodBeat.o(110554);
    }

    static /* synthetic */ void ahq(int i2) {
        AppMethodBeat.i(200158);
        SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences("we_pkg_sp", 4);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("white_screen_times", i2).commit();
        }
        AppMethodBeat.o(200158);
    }
}
