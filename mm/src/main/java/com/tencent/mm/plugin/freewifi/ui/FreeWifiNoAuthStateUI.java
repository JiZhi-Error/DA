package com.tencent.mm.plugin.freewifi.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.NetworkInfo;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.h;
import com.tencent.thumbplayer.core.common.TPCodecParamers;

@Deprecated
public abstract class FreeWifiNoAuthStateUI extends FreeWifiStateUI {
    private String dQC;
    private boolean rHi = true;
    private int wQH;
    private boolean wQI;

    /* access modifiers changed from: protected */
    public abstract String dNQ();

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.freewifi.ui.FreeWifiStateUI, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.freewifi.ui.FreeWifiStateUI, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        this.wQH = getIntent().getIntExtra("free_wifi_encrypt_type", 0);
        this.dQC = getIntent().getStringExtra("free_wifi_passowrd");
        this.wQI = getIntent().getBooleanExtra("free_wifi_hide_ssid", false);
        super.onCreate(bundle);
        d.a(this.ssid, 4, getIntent());
        Log.i("MicroMsg.FreeWifi.FreeWifiNoAuthStateUI", "Comes from webview, do auth");
    }

    @Override // com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.freewifi.ui.FreeWifiStateUI
    public void initView() {
        super.initView();
        setMMTitle(dNQ());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0024, code lost:
        if (r1 == false) goto L_0x0026;
     */
    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onResume() {
        /*
        // Method dump skipped, instructions count: 105
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.freewifi.ui.FreeWifiNoAuthStateUI.onResume():void");
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.freewifi.ui.FreeWifiStateUI, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.tencent.mm.plugin.freewifi.ui.FreeWifiStateUI, com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver.a
    public void a(NetworkInfo.State state) {
        Log.i("MicroMsg.FreeWifi.FreeWifiNoAuthStateUI", "now network state : %s", state.toString());
        if (state == NetworkInfo.State.CONNECTED && d.axS(this.ssid)) {
            dNT();
            this.wQQ = false;
            d.a(this.ssid, 2, getIntent());
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            Log.i("MicroMsg.FreeWifi.FreeWifiNoAuthStateUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i2), Long.valueOf(Thread.currentThread().getId()));
            return;
        }
        Log.i("MicroMsg.FreeWifi.FreeWifiNoAuthStateUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i2), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i2) {
            case TPCodecParamers.TP_PROFILE_H264_MAIN /*{ENCODED_INT: 77}*/:
                if (iArr.length > 0 && iArr[0] == -1) {
                    this.rHi = false;
                    h.a((Context) this, getString(R.string.fl_), getString(R.string.flp), getString(R.string.e_k), getString(R.string.amn), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiNoAuthStateUI.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(25114);
                            FreeWifiNoAuthStateUI freeWifiNoAuthStateUI = FreeWifiNoAuthStateUI.this;
                            a bl = new a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            com.tencent.mm.hellhoundlib.a.a.a(freeWifiNoAuthStateUI, bl.axQ(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiNoAuthStateUI$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            freeWifiNoAuthStateUI.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(freeWifiNoAuthStateUI, "com/tencent/mm/plugin/freewifi/ui/FreeWifiNoAuthStateUI$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            FreeWifiNoAuthStateUI.this.finish();
                            AppMethodBeat.o(25114);
                        }
                    }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiNoAuthStateUI.AnonymousClass3 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(25115);
                            FreeWifiNoAuthStateUI.this.finish();
                            AppMethodBeat.o(25115);
                        }
                    });
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.freewifi.ui.FreeWifiStateUI
    public final void bpf() {
        dNO();
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.freewifi.ui.FreeWifiStateUI
    public final void dNO() {
        if (this.wQQ) {
            Log.i("MicroMsg.FreeWifi.FreeWifiNoAuthStateUI", "it is authing now");
            return;
        }
        this.wQQ = true;
        dNS();
        int d2 = d.d(this.ssid, this.dQC, this.wQH, this.wQI);
        k.a dMF = k.dMF();
        dMF.ssid = this.ssid;
        dMF.dFd = this.dFd;
        dMF.quX = m.aw(getIntent());
        dMF.wNc = m.ay(getIntent());
        dMF.wNd = k.b.AddNetwork.wNO;
        dMF.wNe = k.b.AddNetwork.name;
        dMF.result = d2;
        dMF.channel = m.az(getIntent());
        dMF.wNb = this.dNI;
        dMF.wNf = this.appUserName;
        dMF.dMH().dMG();
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.freewifi.ui.FreeWifiStateUI
    public int dNP() {
        if (!d.axS(this.ssid)) {
            return 1;
        }
        d.a(this.ssid, 2, getIntent());
        return 2;
    }
}
