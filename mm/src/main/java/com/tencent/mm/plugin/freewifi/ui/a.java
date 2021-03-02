package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.protocal.protobuf.bfr;
import com.tencent.mm.protocal.protobuf.dho;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;

public final class a {
    Activity activity;
    int channel;
    String dFd;
    Intent intent;

    public a(Activity activity2, String str, int i2) {
        AppMethodBeat.i(24992);
        if (Util.isNullOrNil(str)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("acitvity or apKey cannot be null.");
            AppMethodBeat.o(24992);
            throw illegalArgumentException;
        }
        this.activity = activity2;
        this.intent = activity2.getIntent();
        this.dFd = str;
        this.channel = i2;
        AppMethodBeat.o(24992);
    }

    public final void connect() {
        AppMethodBeat.i(24993);
        if (Util.isNullOrNil(this.dFd)) {
            Log.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get key failed");
            this.activity.finish();
        }
        this.activity.getIntent().putExtra("free_wifi_url", this.dFd);
        this.activity.getIntent().putExtra("free_wifi_ap_key", this.dFd);
        if (Util.isNullOrNil(this.dFd)) {
            Log.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "ap key is null");
            this.activity.finish();
            AppMethodBeat.o(24993);
            return;
        }
        Log.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo, desc=it starts net request [getApInfo] for retrieving protocol type and frontpage info. apKey=%s, channel=%d", m.aw(this.intent), Integer.valueOf(m.ax(this.intent)), this.dFd, Integer.valueOf(this.channel));
        k.a dMF = k.dMF();
        dMF.dFd = this.dFd;
        dMF.quX = m.aw(this.intent);
        dMF.wNd = k.b.GetFrontPage.wNO;
        dMF.wNe = k.b.GetFrontPage.name;
        dMF.channel = this.channel;
        dMF.wNc = m.ay(this.intent);
        dMF.dMH().c(this.intent, false).dMG();
        new com.tencent.mm.plugin.freewifi.d.a(this.dFd, this.channel, m.aw(this.intent)).ap(this.activity).c(new i() {
            /* class com.tencent.mm.plugin.freewifi.ui.a.AnonymousClass1 */

            @Override // com.tencent.mm.ak.i
            public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                AppMethodBeat.i(24990);
                k.a dMF = k.dMF();
                dMF.dFd = a.this.dFd;
                dMF.quX = m.aw(a.this.intent);
                dMF.wNd = k.b.GetFrontPageReturn.wNO;
                dMF.wNe = k.b.GetFrontPageReturn.name;
                dMF.wNc = m.ay(a.this.intent);
                dMF.channel = a.this.channel;
                dMF.result = i3;
                dMF.resultMsg = str;
                dMF.dMH().c(a.this.intent, i3 != 0).dMG();
                Log.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback, desc=net request [getApInfo] returns. errType=%d, errCode=%d, errMsg=%s", m.aw(a.this.intent), Integer.valueOf(m.ax(a.this.intent)), Integer.valueOf(i2), Integer.valueOf(i3), str);
                if (i2 == 0 && i3 == 0) {
                    a aVar = a.this;
                    if (!(qVar instanceof com.tencent.mm.plugin.freewifi.d.a)) {
                        aVar.ayc(aVar.activity.getString(R.string.dhw));
                        AppMethodBeat.o(24990);
                        return;
                    }
                    com.tencent.mm.plugin.freewifi.d.a aVar2 = (com.tencent.mm.plugin.freewifi.d.a) qVar;
                    aVar.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_SHOULD_BIND_PHONE", aVar2.dNx());
                    bfr dNy = aVar2.dNy();
                    if (dNy != null) {
                        Log.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo/getFrontPage), desc=net request [getapinfo] gets response. frontpageinfo:  appid: %s, nickName: %s, userName: %s, headImgUrl: %s, welcomeMsg: %s, privacyDescriUrl: %s, timestamp=%s, sign=%s, HasMobile=%d", m.aw(aVar.intent), Integer.valueOf(m.ax(aVar.intent)), dNy.KGX, dNy.oUJ, dNy.UserName, dNy.xJE, dNy.LPm, dNy.LPn, dNy.KPJ, dNy.Lkr, Integer.valueOf(dNy.KCz));
                        aVar.intent.putExtra("free_wifi_appid", dNy.KGX);
                        aVar.intent.putExtra("free_wifi_head_img_url", dNy.xJE);
                        aVar.intent.putExtra("free_wifi_welcome_msg", dNy.LPm);
                        aVar.intent.putExtra("free_wifi_privacy_url", dNy.LPn);
                        aVar.intent.putExtra("free_wifi_app_nickname", dNy.oUJ);
                        aVar.intent.putExtra("free_wifi_welcome_sub_title", dNy.LPo);
                    }
                    if (aVar.channel != 2) {
                        aVar.activity.getIntent().putExtra("free_wifi_jump_to_main_ui", true);
                    }
                    dho dNw = aVar2.dNw();
                    if (dNw == null) {
                        Log.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get qstring from server is null");
                        aVar.activity.finish();
                        k.a dMF2 = k.dMF();
                        dMF2.dFd = aVar.dFd;
                        dMF2.quX = m.aw(aVar.intent);
                        dMF2.wNd = k.b.GetFrontPageReturnDataCheck.wNO;
                        dMF2.wNe = k.b.GetFrontPageReturnDataCheck.name;
                        dMF2.wNc = m.ay(aVar.intent);
                        dMF2.channel = aVar.channel;
                        dMF2.result = -1;
                        dMF2.resultMsg = "qstrInfo is null.";
                        dMF2.dMH().c(aVar.intent, true).dMG();
                        AppMethodBeat.o(24990);
                    } else if (m.eP(dNw.rBy)) {
                        Log.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get qstrInfo.ssid from server is empty");
                        aVar.activity.finish();
                        k.a dMF3 = k.dMF();
                        dMF3.dFd = aVar.dFd;
                        dMF3.quX = m.aw(aVar.intent);
                        dMF3.wNd = k.b.GetFrontPageReturnDataCheck.wNO;
                        dMF3.wNe = k.b.GetFrontPageReturnDataCheck.name;
                        dMF3.wNc = m.ay(aVar.intent);
                        dMF3.channel = aVar.channel;
                        dMF3.result = -1;
                        dMF3.resultMsg = "qstrInfo.Ssid is empty.";
                        dMF3.dMH().c(aVar.intent, true).dMG();
                        AppMethodBeat.o(24990);
                    } else {
                        aVar.intent.putExtra("free_wifi_ssid", dNw.rBy);
                        Log.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=net request [getApInfo/getFrontPage] gets response. qstrInfo:  prototype = %d, ssid : %s, pssword : %s", m.aw(aVar.intent), Integer.valueOf(m.ax(aVar.intent)), Integer.valueOf(dNw.MMx), dNw.rBy, dNw.LuS);
                        String openId = aVar2.getOpenId();
                        String ahV = aVar2.ahV();
                        aVar.intent.putExtra("free_wifi_openid", openId);
                        aVar.intent.putExtra("free_wifi_tid", ahV);
                        aVar.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_TIMESTAMP", dNy.KPJ);
                        aVar.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_SIGN", dNy.Lkr);
                        Log.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=net request [getApInfo/getFrontPage] gets response. openId=%s, tid=%s", m.aw(aVar.intent), Integer.valueOf(m.ax(aVar.intent)), openId, ahV);
                        aVar.intent.putExtra("free_wifi_protocol_type", dNw.MMx);
                        if (dNw.MMx == 10) {
                            if (Util.isNullOrNil(dNw.rBy) || Util.isNullOrNil(dNw.LuS)) {
                                Log.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "ssid or password is null");
                                aVar.activity.finish();
                                AppMethodBeat.o(24990);
                                return;
                            }
                            aVar.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 4);
                            aVar.intent.putExtra("free_wifi_auth_type", 2);
                            aVar.intent.putExtra("free_wifi_passowrd", dNw.LuS);
                            aVar.intent.setClass(aVar.activity, FreeWifiFrontPageUI.class);
                            Activity activity = aVar.activity;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(aVar.intent);
                            com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector", "openFrontPageByApInfo", "(Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            activity.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector", "openFrontPageByApInfo", "(Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            aVar.activity.finish();
                            aVar.activity.overridePendingTransition(R.anim.eq, R.anim.en);
                            AppMethodBeat.o(24990);
                        } else if (dNw.MMx == 11) {
                            if (Util.isNullOrNil(dNw.rBy) || Util.isNullOrNil(dNw.LuS)) {
                                Log.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "ssid or password is null");
                                aVar.activity.finish();
                                AppMethodBeat.o(24990);
                                return;
                            }
                            aVar.intent.putExtra("free_wifi_auth_type", 2);
                            aVar.intent.putExtra("free_wifi_passowrd", dNw.LuS);
                            aVar.intent.setClass(aVar.activity, FreewifiActivateWeChatNoAuthStateUI.class);
                            Activity activity2 = aVar.activity;
                            com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(aVar.intent);
                            com.tencent.mm.hellhoundlib.a.a.a(activity2, bl2.axQ(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector", "openFrontPageByApInfo", "(Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            activity2.startActivity((Intent) bl2.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(activity2, "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector", "openFrontPageByApInfo", "(Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            aVar.activity.finish();
                            aVar.activity.overridePendingTransition(R.anim.eq, R.anim.en);
                            AppMethodBeat.o(24990);
                        } else if (dNw.MMx == 12) {
                            aVar.intent.putExtra("free_wifi_auth_type", 1);
                            aVar.intent.setClass(aVar.activity, FreeWifiActivateAuthStateUI.class);
                            Activity activity3 = aVar.activity;
                            com.tencent.mm.hellhoundlib.b.a bl3 = new com.tencent.mm.hellhoundlib.b.a().bl(aVar.intent);
                            com.tencent.mm.hellhoundlib.a.a.a(activity3, bl3.axQ(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector", "openFrontPageByApInfo", "(Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            activity3.startActivity((Intent) bl3.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(activity3, "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector", "openFrontPageByApInfo", "(Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            aVar.activity.finish();
                            aVar.activity.overridePendingTransition(R.anim.eq, R.anim.en);
                            AppMethodBeat.o(24990);
                        } else if (dNw.MMx == 31) {
                            aVar.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 31);
                            Log.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=it goes into protocal 31 handle branch.", m.aw(aVar.intent), Integer.valueOf(m.ax(aVar.intent)));
                            String stringExtra = aVar.intent.getStringExtra("free_wifi_schema_ticket");
                            Log.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=it tries to get ticket. ticket=%s.", m.aw(aVar.intent), Integer.valueOf(m.ax(aVar.intent)), stringExtra);
                            if (Util.isNullOrNil(stringExtra)) {
                                aVar.activity.finish();
                                k.a dMF4 = k.dMF();
                                dMF4.dFd = aVar.dFd;
                                dMF4.quX = m.aw(aVar.intent);
                                dMF4.wNd = k.b.GetFrontPageReturnDataCheck.wNO;
                                dMF4.wNe = k.b.GetFrontPageReturnDataCheck.name;
                                dMF4.channel = aVar.channel;
                                dMF4.wNc = m.ay(aVar.intent);
                                dMF4.result = -1;
                                dMF4.resultMsg = "31 ticket is empty.";
                                dMF4.dMH().c(aVar.intent, true).dMG();
                                AppMethodBeat.o(24990);
                                return;
                            }
                            String str2 = dNw.rBy;
                            String str3 = dNy.KPJ;
                            String str4 = dNy.Lkr;
                            if (d.dNd() == null) {
                                Log.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo, desc=it tries to get current connected wifi info but return null, so it fails to connect wifi. ", m.aw(aVar.intent), Integer.valueOf(m.ax(aVar.intent)));
                                aVar.ayc(aVar.activity.getString(R.string.dhw));
                                k.a dMF5 = k.dMF();
                                dMF5.dFd = aVar.dFd;
                                dMF5.quX = m.aw(aVar.intent);
                                dMF5.wNd = k.b.GetFrontPageReturnDataCheck.wNO;
                                dMF5.wNe = k.b.GetFrontPageReturnDataCheck.name;
                                dMF5.channel = aVar.channel;
                                dMF5.wNc = m.ay(aVar.intent);
                                dMF5.result = -1;
                                dMF5.resultMsg = "wifiInfo is empty.";
                                dMF5.dMH().c(aVar.intent, true).dMG();
                                AppMethodBeat.o(24990);
                                return;
                            }
                            Log.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo, desc=it gets connected wifi info. is_current_connected_ssid_equals_target_ssid=%b", m.aw(aVar.intent), Integer.valueOf(m.ax(aVar.intent)), Boolean.valueOf(d.axS(str2)));
                            String connectedWifiSsid = NetStatusUtil.getConnectedWifiSsid(MMApplicationContext.getContext());
                            String connectedWifiBssid = NetStatusUtil.getConnectedWifiBssid(MMApplicationContext.getContext());
                            String axO = m.axO("MicroMsg.FreeWifi.FreeWifiNetCheckUI");
                            Log.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo desc=it starts net request [GetPortalApInfo]  for portal ap info. apKey=%s, apSsid=%s, apBssid=%s, mobileMac=%s, ticket=%s", m.aw(aVar.intent), Integer.valueOf(m.ax(aVar.intent)), aVar.dFd, connectedWifiSsid, connectedWifiBssid, axO, stringExtra);
                            k.a dMF6 = k.dMF();
                            dMF6.dFd = aVar.dFd;
                            dMF6.quX = m.aw(aVar.intent);
                            dMF6.wNd = k.b.GetFrontPageReturnDataCheck.wNO;
                            dMF6.wNe = k.b.GetFrontPageReturnDataCheck.name;
                            dMF6.channel = aVar.channel;
                            dMF6.wNc = m.ay(aVar.intent);
                            dMF6.result = 0;
                            dMF6.resultMsg = "";
                            dMF6.dMH().c(aVar.intent, true).dMG();
                            k.a dMF7 = k.dMF();
                            dMF7.ssid = aVar.intent.getStringExtra("free_wifi_ssid");
                            dMF7.dFd = aVar.dFd;
                            dMF7.wNb = aVar.intent.getStringExtra("free_wifi_appid");
                            dMF7.quX = m.aw(aVar.intent);
                            dMF7.wNc = m.ay(aVar.intent);
                            dMF7.wNd = k.b.GetPortalApInfo.wNO;
                            dMF7.wNe = k.b.GetPortalApInfo.name;
                            dMF7.channel = m.az(aVar.intent);
                            dMF7.wNc = m.ay(aVar.intent);
                            dMF7.dMH().c(aVar.intent, false).dMG();
                            new com.tencent.mm.plugin.freewifi.d.i(aVar.dFd, connectedWifiSsid, connectedWifiBssid, axO, stringExtra, m.aw(aVar.intent)).ap(aVar.activity).c(new i(openId, ahV, str3, str4) {
                                /* class com.tencent.mm.plugin.freewifi.ui.a.AnonymousClass2 */
                                final /* synthetic */ String wRa;
                                final /* synthetic */ String wRb;
                                final /* synthetic */ String wRc;
                                final /* synthetic */ String wRd;

                                {
                                    this.wRa = r2;
                                    this.wRb = r3;
                                    this.wRc = r4;
                                    this.wRd = r5;
                                }

                                @Override // com.tencent.mm.ak.i
                                public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                                    AppMethodBeat.i(24991);
                                    Log.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo.callback, desc=net request [GetPortalApInfo] returns. errType=%d, errCode=%d, errMsg=%s", m.aw(a.this.intent), Integer.valueOf(m.ax(a.this.intent)), Integer.valueOf(i2), Integer.valueOf(i3), str);
                                    if (i2 == 0 && i3 == 0) {
                                        k.a dMF = k.dMF();
                                        dMF.dFd = a.this.dFd;
                                        dMF.quX = m.aw(a.this.intent);
                                        dMF.wNd = k.b.GetPortalApInfoReturn.wNO;
                                        dMF.wNe = k.b.GetPortalApInfoReturn.name;
                                        dMF.channel = a.this.channel;
                                        dMF.result = i3;
                                        dMF.resultMsg = str;
                                        dMF.dMH().c(a.this.intent, false).dMG();
                                        com.tencent.mm.plugin.freewifi.d.i iVar = (com.tencent.mm.plugin.freewifi.d.i) qVar;
                                        String dND = iVar.dND();
                                        if (m.eP(dND)) {
                                            Log.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo, desc=authUrl is empty, so it fails to connect wifi. ", m.aw(a.this.intent), Integer.valueOf(m.ax(a.this.intent)));
                                            a.this.ayc(a.this.activity.getString(R.string.dhw));
                                            k.a dMF2 = k.dMF();
                                            dMF2.dFd = a.this.dFd;
                                            dMF2.quX = m.aw(a.this.intent);
                                            dMF2.wNd = k.b.GetPortalApInfoReturnDataCheck.wNO;
                                            dMF2.wNe = k.b.GetPortalApInfoReturnDataCheck.name;
                                            dMF2.channel = a.this.channel;
                                            dMF2.wNc = m.ay(a.this.intent);
                                            dMF2.result = -1;
                                            dMF2.resultMsg = "31 auth url is empty.";
                                            dMF2.dMH().c(a.this.intent, true).dMG();
                                            AppMethodBeat.o(24991);
                                            return;
                                        }
                                        String axL = m.axL(iVar.dNE());
                                        String axL2 = m.axL(this.wRa);
                                        String axL3 = m.axL(this.wRb);
                                        StringBuilder sb = new StringBuilder(dND);
                                        if (dND.indexOf("?") != -1) {
                                            sb.append("&extend=").append(axL);
                                        } else {
                                            sb.append("?extend=").append(axL);
                                        }
                                        sb.append("&openId=").append(axL2).append("&tid=").append(axL3).append("&timestamp=").append(m.axL(this.wRc)).append("&sign=").append(m.axL(this.wRd));
                                        Log.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo, desc=it gets authentication url. http url=%s ", m.aw(a.this.intent), Integer.valueOf(m.ax(a.this.intent)), sb.toString());
                                        a.this.intent.putExtra("free_wifi_portal_ap_info_authurl_with_params", sb.toString());
                                        a.this.intent.setClass(a.this.activity, FreeWifiFrontPageUI.class);
                                        Activity activity = a.this.activity;
                                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(a.this.intent);
                                        com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector$2", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                        activity.startActivity((Intent) bl.pG(0));
                                        com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector$2", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                        a.this.activity.finish();
                                        a.this.activity.overridePendingTransition(R.anim.eq, R.anim.en);
                                        k.a dMF3 = k.dMF();
                                        dMF3.dFd = a.this.dFd;
                                        dMF3.quX = m.aw(a.this.intent);
                                        dMF3.wNd = k.b.GetPortalApInfoReturnDataCheck.wNO;
                                        dMF3.wNe = k.b.GetPortalApInfoReturnDataCheck.name;
                                        dMF3.channel = a.this.channel;
                                        dMF3.wNc = m.ay(a.this.intent);
                                        dMF3.result = 0;
                                        dMF3.resultMsg = "";
                                        dMF3.dMH().c(a.this.intent, true).dMG();
                                        AppMethodBeat.o(24991);
                                        return;
                                    }
                                    k.a dMF4 = k.dMF();
                                    dMF4.dFd = a.this.dFd;
                                    dMF4.quX = m.aw(a.this.intent);
                                    dMF4.wNd = k.b.GetPortalApInfoReturn.wNO;
                                    dMF4.wNe = k.b.GetPortalApInfoReturn.name;
                                    dMF4.channel = a.this.channel;
                                    dMF4.wNc = m.ay(a.this.intent);
                                    dMF4.result = i3;
                                    dMF4.resultMsg = str;
                                    dMF4.dMH().c(a.this.intent, true).dMG();
                                    if (m.gC(i2, i3) && !m.eP(str)) {
                                        a.this.ayc(str + "(" + m.a(m.ay(a.this.intent), k.b.GetPortalApInfoReturn, i3) + ")");
                                        AppMethodBeat.o(24991);
                                    } else if (m.eP(str)) {
                                        a.this.ayc(a.this.activity.getString(R.string.dhw));
                                        AppMethodBeat.o(24991);
                                    } else {
                                        a.this.ayc(str);
                                        AppMethodBeat.o(24991);
                                    }
                                }
                            });
                            AppMethodBeat.o(24990);
                        } else if (dNw.MMx == 32) {
                            aVar.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 32);
                            Log.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=it goes into protocal 32 handle branch.", m.aw(aVar.intent), Integer.valueOf(m.ax(aVar.intent)));
                            aVar.intent.setClass(aVar.activity, FreeWifiFrontPageUI.class);
                            Activity activity4 = aVar.activity;
                            com.tencent.mm.hellhoundlib.b.a bl4 = new com.tencent.mm.hellhoundlib.b.a().bl(aVar.intent);
                            com.tencent.mm.hellhoundlib.a.a.a(activity4, bl4.axQ(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector", "openFrontPageByApInfo", "(Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            activity4.startActivity((Intent) bl4.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(activity4, "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector", "openFrontPageByApInfo", "(Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            aVar.activity.finish();
                            aVar.activity.overridePendingTransition(R.anim.eq, R.anim.en);
                            AppMethodBeat.o(24990);
                        } else if (dNw.MMx == 1) {
                            aVar.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 1);
                            aVar.intent.putExtra("free_wifi_auth_type", 1);
                            aVar.intent.setClass(aVar.activity, FreeWifiFrontPageUI.class);
                            Activity activity5 = aVar.activity;
                            com.tencent.mm.hellhoundlib.b.a bl5 = new com.tencent.mm.hellhoundlib.b.a().bl(aVar.intent);
                            com.tencent.mm.hellhoundlib.a.a.a(activity5, bl5.axQ(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector", "openFrontPageByApInfo", "(Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            activity5.startActivity((Intent) bl5.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(activity5, "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector", "openFrontPageByApInfo", "(Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            aVar.activity.finish();
                            aVar.activity.overridePendingTransition(R.anim.eq, R.anim.en);
                            AppMethodBeat.o(24990);
                        } else {
                            aVar.activity.finish();
                            aVar.ayc(aVar.activity.getString(R.string.di1));
                            AppMethodBeat.o(24990);
                        }
                    }
                } else if (m.gC(i2, i3) && !m.eP(str)) {
                    a.this.ayc(str + "(" + m.a(m.ay(a.this.intent), k.b.GetFrontPageReturn, i3) + ")");
                    AppMethodBeat.o(24990);
                } else if (i3 == -30031) {
                    a.this.ayc(a.this.activity.getString(R.string.di0));
                    AppMethodBeat.o(24990);
                } else {
                    a.this.ayc(a.this.activity.getString(R.string.dhw) + "(" + String.format("%02d", Integer.valueOf(m.ay(a.this.intent))) + k.b.GetFrontPageReturn.wNO + Math.abs(i3) + ")");
                    AppMethodBeat.o(24990);
                }
            }
        });
        AppMethodBeat.o(24993);
    }

    /* access modifiers changed from: package-private */
    public final void ayc(String str) {
        AppMethodBeat.i(24994);
        Intent intent2 = new Intent();
        intent2.putExtra("free_wifi_error_ui_error_msg", str);
        intent2.setClass(this.activity, FreeWifiErrorUI.class);
        this.activity.finish();
        Activity activity2 = this.activity;
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
        com.tencent.mm.hellhoundlib.a.a.a(activity2, bl.axQ(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector", "toErrorUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        activity2.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(activity2, "com/tencent/mm/plugin/freewifi/ui/FreeWifiConnector", "toErrorUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(24994);
    }
}
