package com.tencent.mm.plugin.freewifi.ui;

import android.net.NetworkInfo;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.g;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.protobuf.ih;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

@Deprecated
public class FreeWifiAuthStateUI extends FreeWifiStateUI {
    private boolean rHi = true;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.freewifi.ui.FreeWifiStateUI, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.freewifi.ui.FreeWifiStateUI, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(24981);
        super.onCreate(bundle);
        AppMethodBeat.o(24981);
    }

    @Override // com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.freewifi.ui.FreeWifiStateUI
    public void initView() {
        AppMethodBeat.i(24982);
        super.initView();
        setMMTitle(R.string.dip);
        d.a(this.ssid, 4, getIntent());
        AppMethodBeat.o(24982);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0029, code lost:
        if (r1 == false) goto L_0x002b;
     */
    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onResume() {
        /*
        // Method dump skipped, instructions count: 122
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.freewifi.ui.FreeWifiAuthStateUI.onResume():void");
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.freewifi.ui.FreeWifiStateUI, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(24984);
        super.onDestroy();
        AppMethodBeat.o(24984);
    }

    @Override // com.tencent.mm.plugin.freewifi.ui.FreeWifiStateUI, com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver.a
    public final void a(NetworkInfo.State state) {
        AppMethodBeat.i(24985);
        Log.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "now network state : %s", state.toString());
        if (state == NetworkInfo.State.CONNECTED && d.axS(this.ssid)) {
            dNT();
            dNV();
        }
        AppMethodBeat.o(24985);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.freewifi.ui.FreeWifiStateUI
    public final void bpf() {
        AppMethodBeat.i(24986);
        j.dNs().a(this.ssid, new g.b() {
            /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiAuthStateUI.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.freewifi.model.g.b
            public final void dV(String str, int i2) {
                AppMethodBeat.i(24979);
                String dNb = d.dNb();
                Log.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "get ap auth data : %s, url : %s, mac : %s", str, FreeWifiAuthStateUI.this.pFJ, dNb);
                if (!Util.isNullOrNil(str)) {
                    new a(FreeWifiAuthStateUI.this.pFJ, FreeWifiAuthStateUI.this.ssid, dNb, FreeWifiAuthStateUI.this.wQO, str, "", i2, m.aw(FreeWifiAuthStateUI.this.getIntent())).c(new i() {
                        /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiAuthStateUI.AnonymousClass1.AnonymousClass1 */

                        @Override // com.tencent.mm.ak.i
                        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                            AppMethodBeat.i(24978);
                            Log.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "errType : %d, errCode : %d, errMsg : %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                            FreeWifiAuthStateUI.this.wQQ = false;
                            if (i2 == 0 && i3 == 0) {
                                a aVar = (a) qVar;
                                String dNv = aVar.dNv();
                                Log.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "authUrl : %s", dNv);
                                ih dNz = aVar.dNz();
                                if (dNz != null) {
                                    Log.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s", dNz.KGX, dNz.oUJ, dNz.UserName, Integer.valueOf(dNz.KMt), dNz.KMu, dNz.keb);
                                    FreeWifiAuthStateUI.this.dNI = dNz.KGX;
                                    FreeWifiAuthStateUI.this.wPA = dNz.oUJ;
                                    FreeWifiAuthStateUI.this.appUserName = dNz.UserName;
                                    FreeWifiAuthStateUI.this.wSD = dNz.KMt;
                                    FreeWifiAuthStateUI.this.wSE = dNz.KMu;
                                    FreeWifiAuthStateUI.this.signature = dNz.keb;
                                    FreeWifiAuthStateUI.this.wSF = dNz.KMv;
                                }
                                j.dNs().a(FreeWifiAuthStateUI.this.ssid, dNv, FreeWifiAuthStateUI.this.getIntent());
                                AppMethodBeat.o(24978);
                            } else if (i3 == -2014) {
                                d.a(FreeWifiAuthStateUI.this.ssid, -2014, FreeWifiAuthStateUI.this.getIntent());
                                AppMethodBeat.o(24978);
                            } else {
                                d.a(FreeWifiAuthStateUI.this.ssid, 3, FreeWifiAuthStateUI.this.getIntent());
                                AppMethodBeat.o(24978);
                            }
                        }
                    });
                }
                AppMethodBeat.o(24979);
            }
        }, this.channelId, getIntent());
        AppMethodBeat.o(24986);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(24987);
        if (iArr == null || iArr.length <= 0) {
            Log.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i2), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(24987);
            return;
        }
        Log.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i2), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        if (iArr.length == 0) {
            AppMethodBeat.o(24987);
            return;
        }
        switch (i2) {
            case 64:
                if (iArr[0] != 0) {
                    this.rHi = false;
                    break;
                }
                break;
        }
        AppMethodBeat.o(24987);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.freewifi.ui.FreeWifiStateUI
    public final void dNO() {
        AppMethodBeat.i(24988);
        dNS();
        d.axT(this.ssid);
        AppMethodBeat.o(24988);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.freewifi.ui.FreeWifiStateUI
    public final int dNP() {
        AppMethodBeat.i(24989);
        j.dNm();
        int axR = d.axR(this.ssid);
        AppMethodBeat.o(24989);
        return axR;
    }
}
