package com.tencent.mm.plugin.freewifi.ui;

import android.net.NetworkInfo;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.Log;

@Deprecated
public abstract class FreeWifiActivateNoAuthStateUI extends FreeWifiActivateStateUI {
    private String dQC;
    private int wQH;
    private boolean wQI;

    /* access modifiers changed from: protected */
    public abstract String dNQ();

    @Override // com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateStateUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateStateUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        this.wQH = getIntent().getIntExtra("free_wifi_encrypt_type", 0);
        this.dQC = getIntent().getStringExtra("free_wifi_passowrd");
        this.wQI = getIntent().getBooleanExtra("free_wifi_hide_ssid", false);
        super.onCreate(bundle);
        d.a(this.ssid, 1, getIntent());
        Log.i("MicroMsg.FreeWifi.FreeWifiActivateNoAuthStateUI", "Comes from webview, do auth");
    }

    @Override // com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateStateUI, com.tencent.mm.ui.MMActivity
    public void initView() {
        super.initView();
        this.wQN.setVisibility(0);
        setMMTitle(dNQ());
    }

    @Override // com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateStateUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver.a
    public void a(NetworkInfo.State state) {
        Log.i("MicroMsg.FreeWifi.FreeWifiActivateNoAuthStateUI", "now network state : %s", state.toString());
        if (state == NetworkInfo.State.CONNECTED && d.axS(this.ssid)) {
            dNT();
            this.wQQ = false;
            d.a(this.ssid, 2, getIntent());
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateStateUI
    public final void bpf() {
        dNO();
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateStateUI
    public final void dNO() {
        if (this.wQQ) {
            Log.i("MicroMsg.FreeWifi.FreeWifiActivateNoAuthStateUI", "it is authing now");
            return;
        }
        this.wQQ = true;
        dNS();
        d.d(this.ssid, this.dQC, this.wQH, this.wQI);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateStateUI
    public int dNP() {
        if (!d.axS(this.ssid)) {
            return 1;
        }
        d.a(this.ssid, 2, getIntent());
        return 2;
    }
}
