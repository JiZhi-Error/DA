package com.tencent.mm.plugin.freewifi.ui;

import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.c;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.appbrand.service.s;
import com.tencent.mm.plugin.freewifi.j;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.t;

public class FreeWifiSuccWebViewUI extends WebViewUI implements i {
    private String appUserName;
    private int channel;
    private String dNI;
    private String signature;
    private String wPA;
    private int wSD;
    private String wSE;
    private boolean wSP = false;

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    @TargetApi(11)
    public void onDestroy() {
        AppMethodBeat.i(25160);
        super.onDestroy();
        bg.azz().b(1703, this);
        AppMethodBeat.o(25160);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI
    public final void bXg() {
        AppMethodBeat.i(25161);
        super.bXg();
        AppMethodBeat.o(25161);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void finish() {
        AppMethodBeat.i(25162);
        super.finish();
        AppMethodBeat.o(25162);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(25163);
        super.onBackPressed();
        AppMethodBeat.o(25163);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(25164);
        super.initView();
        setBackBtnVisible(false);
        addTextOptionMenu(0, getString(R.string.di4), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiSuccWebViewUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(25157);
                FreeWifiSuccWebViewUI.this.finish();
                FreeWifiSuccWebViewUI.a(FreeWifiSuccWebViewUI.this);
                AppMethodBeat.o(25157);
                return true;
            }
        }, null, t.b.TRANSPARENT_GREEN_TEXT);
        AppMethodBeat.o(25164);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public boolean onPrepareOptionsMenu(Menu menu) {
        AppMethodBeat.i(25165);
        if (!getString(R.string.di4).equals((String) menu.getItem(0).getTitle())) {
            addTextOptionMenu(0, getString(R.string.di4), new MenuItem.OnMenuItemClickListener() {
                /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiSuccWebViewUI.AnonymousClass2 */

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(25158);
                    FreeWifiSuccWebViewUI.this.finish();
                    FreeWifiSuccWebViewUI.a(FreeWifiSuccWebViewUI.this);
                    AppMethodBeat.o(25158);
                    return true;
                }
            }, null, t.b.TRANSPARENT_GREEN_TEXT);
        }
        boolean onPrepareOptionsMenu = super.onPrepareOptionsMenu(menu);
        AppMethodBeat.o(25165);
        return onPrepareOptionsMenu;
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(25166);
        Log.i("MicroMsg.FreeWifi.FreeWifiSuccWebViewUI", "onSceneEnd, scnee type = %d, errType = %d, errCode = %d", Integer.valueOf(qVar.getType()), Integer.valueOf(i2), Integer.valueOf(i3));
        bg.azz().b(1703, this);
        AppMethodBeat.o(25166);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(25159);
        j.userName = "";
        j.type = 0;
        String stringExtra = getIntent().getStringExtra("free_wifi_qinghuai_url");
        Log.i("MicroMsg.FreeWifi.FreeWifiSuccWebViewUI", "qinghuaiUrl=%s", stringExtra);
        getIntent().putExtra("rawUrl", stringExtra);
        getIntent().putExtra("showShare", false);
        super.onCreate(bundle);
        this.dNI = getIntent().getStringExtra("free_wifi_appid");
        this.wPA = getIntent().getStringExtra("free_wifi_app_nickname");
        this.appUserName = getIntent().getStringExtra("free_wifi_app_username");
        this.wSD = getIntent().getIntExtra("free_wifi_finish_actioncode", 0);
        this.wSE = getIntent().getStringExtra("free_wifi_finish_url");
        this.signature = getIntent().getStringExtra("free_wifi_signature");
        this.channel = m.az(getIntent());
        if (this.channel == 10) {
            String str = ae.gKy.gJB;
            String cu = ae.cu(getContext());
            if (!m.eP(str) && !m.eP(cu)) {
                this.wSE = Uri.parse(this.wSE).buildUpon().appendQueryParameter("manufacturer", cu).appendQueryParameter("manufacturerUsername", str).toString();
            }
        }
        Log.i("MicroMsg.FreeWifi.FreeWifiSuccWebViewUI", "get from intent, appid = %s, appNickName = %s, appUserName = %s, finishActionCode = %d, finishUrl = %s, signature = %s", this.dNI, this.wPA, this.appUserName, Integer.valueOf(this.wSD), this.wSE, this.signature);
        k.a dMF = k.dMF();
        String axO = m.axO("MicroMsg.FreeWifi.FreeWifiSuccWebViewUI");
        dMF.ssid = NetStatusUtil.getConnectedWifiSsid(MMApplicationContext.getContext());
        dMF.bssid = NetStatusUtil.getConnectedWifiBssid(MMApplicationContext.getContext());
        dMF.dFe = axO;
        dMF.dFd = getIntent().getStringExtra("free_wifi_ap_key");
        dMF.wNb = this.dNI;
        dMF.quX = m.aw(getIntent());
        dMF.wNc = m.ay(getIntent());
        dMF.wNd = k.b.GetBackPage.wNO;
        dMF.wNe = k.b.GetBackPage.name;
        dMF.channel = m.az(getIntent());
        dMF.wNf = this.appUserName;
        dMF.dMH().dMG();
        AppMethodBeat.o(25159);
    }

    static /* synthetic */ void a(FreeWifiSuccWebViewUI freeWifiSuccWebViewUI) {
        AppMethodBeat.i(25167);
        String str = j.userName;
        if (Util.isNullOrNil(freeWifiSuccWebViewUI.appUserName) || !freeWifiSuccWebViewUI.appUserName.equals(str)) {
            freeWifiSuccWebViewUI.wSP = false;
        } else {
            freeWifiSuccWebViewUI.wSP = true;
        }
        if (freeWifiSuccWebViewUI.wSP && !Util.isNullOrNil(freeWifiSuccWebViewUI.dNI) && (!ab.IT(freeWifiSuccWebViewUI.appUserName) || !ab.IS(freeWifiSuccWebViewUI.appUserName))) {
            bg.azz().a(1703, freeWifiSuccWebViewUI);
            bg.azz().a(new com.tencent.mm.plugin.freewifi.model.i(freeWifiSuccWebViewUI.dNI, freeWifiSuccWebViewUI.getIntent().getStringExtra("free_wifi_ap_key"), freeWifiSuccWebViewUI.getIntent().getIntExtra("free_wifi_channel_id", 0), m.aw(freeWifiSuccWebViewUI.getIntent())), 0);
        }
        l.c(d.dNe(), freeWifiSuccWebViewUI.getIntent().getStringExtra("free_wifi_ap_key"), freeWifiSuccWebViewUI.getIntent().getIntExtra("free_wifi_protocol_type", 0), freeWifiSuccWebViewUI.wSP);
        k.a dMF = k.dMF();
        String axO = m.axO("MicroMsg.FreeWifi.FreeWifiSuccWebViewUI");
        dMF.ssid = NetStatusUtil.getConnectedWifiSsid(MMApplicationContext.getContext());
        dMF.bssid = NetStatusUtil.getConnectedWifiBssid(MMApplicationContext.getContext());
        dMF.dFe = axO;
        dMF.dFd = m.aA(freeWifiSuccWebViewUI.getIntent());
        dMF.wNb = freeWifiSuccWebViewUI.dNI;
        dMF.quX = m.aw(freeWifiSuccWebViewUI.getIntent());
        dMF.wNc = m.ay(freeWifiSuccWebViewUI.getIntent());
        dMF.wNd = k.b.QinghuaiBackpageFinished.wNO;
        dMF.wNe = k.b.QinghuaiBackpageFinished.name;
        dMF.channel = m.az(freeWifiSuccWebViewUI.getIntent());
        dMF.wNf = freeWifiSuccWebViewUI.appUserName;
        dMF.dMH().dMG();
        String stringExtra = freeWifiSuccWebViewUI.getIntent().getStringExtra("free_wifi_finish_url");
        if (freeWifiSuccWebViewUI.wSD != 1 || Util.isNullOrNil(stringExtra)) {
            if (freeWifiSuccWebViewUI.wSD == 3 && !Util.isNullOrNil(stringExtra)) {
                ((s) g.af(s.class)).b(freeWifiSuccWebViewUI, stringExtra, 1078, null, null);
                Log.i("MicroMsg.FreeWifi.FreeWifiSuccWebViewUI", "jump to wxa after connect wifi success, url is : %s", stringExtra);
            }
            AppMethodBeat.o(25167);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", Uri.parse(stringExtra).buildUpon().appendQueryParameter("lang", LocaleUtil.loadApplicationLanguage(freeWifiSuccWebViewUI.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), freeWifiSuccWebViewUI)).build().toString());
        intent.putExtra("show_bottom", false);
        intent.putExtra("stastic_scene", 7);
        intent.putExtra("neverBlockLocalRequest", true);
        c.b(freeWifiSuccWebViewUI, "webview", ".ui.tools.WebViewUI", intent);
        Log.i("MicroMsg.FreeWifi.FreeWifiSuccWebViewUI", "jump to ad page after connect wifi success, url is : %s", intent.getStringExtra("rawUrl"));
        AppMethodBeat.o(25167);
    }
}
