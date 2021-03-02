package com.tencent.mm.plugin.freewifi.e;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.sdk.platformtools.Log;

public class e {
    protected String appId = this.intent.getStringExtra("free_wifi_appid");
    protected int channelId = this.intent.getIntExtra("free_wifi_channel_id", 0);
    protected String dFd = this.intent.getStringExtra("free_wifi_ap_key");
    protected final Intent intent;
    protected String pFJ = this.intent.getStringExtra("free_wifi_url");
    protected int source = this.intent.getIntExtra("free_wifi_source", 1);
    protected String ssid = this.intent.getStringExtra("free_wifi_ssid");
    protected String wPA = this.intent.getStringExtra("free_wifi_app_nickname");
    protected FreeWifiFrontPageUI wPy;
    protected int wPz = this.intent.getIntExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 0);

    public e(FreeWifiFrontPageUI freeWifiFrontPageUI) {
        AppMethodBeat.i(24876);
        this.wPy = freeWifiFrontPageUI;
        this.intent = freeWifiFrontPageUI.getIntent();
        Log.i("MicroMsg.FreeWifi.ProtocolBase", "sessionKey=%s, step=%d, desc=Data retrieved. ssid=%s, fullUrl=%s, apKey=%s, source=%s, channelId=%d, appid=%s, appNickName=%s, protocolNumber=%d", m.aw(this.intent), Integer.valueOf(m.ax(this.intent)), this.ssid, this.pFJ, this.dFd, Integer.valueOf(this.source), Integer.valueOf(this.channelId), this.appId, this.wPA, Integer.valueOf(this.wPz));
        AppMethodBeat.o(24876);
    }
}
