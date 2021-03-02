package com.tencent.mm.plugin.freewifi.ui;

import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.protobuf.ih;
import com.tencent.mm.sdk.platformtools.Log;

@Deprecated
public class FreewifiWeChatNoAuthStateUI extends FreeWifiNoAuthStateUI {
    private int dIX;
    private String wSW;
    private String wSX;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.freewifi.ui.FreeWifiNoAuthStateUI, com.tencent.mm.plugin.freewifi.ui.FreeWifiStateUI, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.freewifi.ui.FreeWifiNoAuthStateUI
    public final String dNQ() {
        AppMethodBeat.i(25177);
        String string = getString(R.string.dip);
        AppMethodBeat.o(25177);
        return string;
    }

    @Override // com.tencent.mm.plugin.freewifi.ui.FreeWifiNoAuthStateUI, com.tencent.mm.plugin.freewifi.ui.FreeWifiStateUI, com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver.a
    public final void a(NetworkInfo.State state) {
        AppMethodBeat.i(25178);
        Log.i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "now network state : %s", state.toString());
        if (state == NetworkInfo.State.CONNECTED && d.axS(this.ssid) && this.wQQ) {
            dNT();
            this.wQQ = false;
            this.wSW = d.dNb();
            this.wSX = d.dNf();
            this.dIX = d.dNc();
            Log.i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "now has connect the ap, check from server rssi is :  %d, mac : %s, ssid is : %s", Integer.valueOf(this.dIX), this.wSW, this.wSX);
            new a(this.pFJ, this.wSW, this.wSX, this.dIX, this.channelId, m.aw(getIntent())).c(new i() {
                /* class com.tencent.mm.plugin.freewifi.ui.FreewifiWeChatNoAuthStateUI.AnonymousClass1 */

                @Override // com.tencent.mm.ak.i
                public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(25176);
                    bg.azz().b(640, this);
                    Log.i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "onSceneEnd, errType = %d, errCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
                    if (i2 == 0 && i3 == 0) {
                        Log.i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "check ap ok");
                        ih dNz = ((a) qVar).dNz();
                        if (dNz != null) {
                            Log.i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s", dNz.KGX, dNz.oUJ, dNz.UserName, Integer.valueOf(dNz.KMt), dNz.KMu, dNz.keb);
                            FreewifiWeChatNoAuthStateUI.this.dNI = dNz.KGX;
                            FreewifiWeChatNoAuthStateUI.this.wPA = dNz.oUJ;
                            FreewifiWeChatNoAuthStateUI.this.appUserName = dNz.UserName;
                            FreewifiWeChatNoAuthStateUI.this.wSD = dNz.KMt;
                            FreewifiWeChatNoAuthStateUI.this.wSE = dNz.KMu;
                            FreewifiWeChatNoAuthStateUI.this.signature = dNz.keb;
                            FreewifiWeChatNoAuthStateUI.this.wSF = dNz.KMv;
                        }
                        d.a(FreewifiWeChatNoAuthStateUI.this.ssid, 2, FreewifiWeChatNoAuthStateUI.this.getIntent());
                        AppMethodBeat.o(25176);
                        return;
                    }
                    Log.e("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "check ap failed ： rssi is :  %d, mac : %s, ssid is : %s", Integer.valueOf(FreewifiWeChatNoAuthStateUI.this.dIX), FreewifiWeChatNoAuthStateUI.this.wSW, FreewifiWeChatNoAuthStateUI.this.wSX);
                    d.a(FreewifiWeChatNoAuthStateUI.this.ssid, -2014, FreewifiWeChatNoAuthStateUI.this.getIntent());
                    d.axU(FreewifiWeChatNoAuthStateUI.this.wSX);
                    AppMethodBeat.o(25176);
                }
            });
        }
        AppMethodBeat.o(25178);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.freewifi.ui.FreeWifiNoAuthStateUI, com.tencent.mm.plugin.freewifi.ui.FreeWifiStateUI, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(25179);
        super.onDestroy();
        AppMethodBeat.o(25179);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.freewifi.ui.FreeWifiNoAuthStateUI, com.tencent.mm.plugin.freewifi.ui.FreeWifiStateUI
    public final int dNP() {
        AppMethodBeat.i(25180);
        j.dNm();
        int axR = d.axR(this.ssid);
        Log.i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "get connect state = %d", Integer.valueOf(axR));
        if (axR == 0) {
            AppMethodBeat.o(25180);
            return -2014;
        }
        AppMethodBeat.o(25180);
        return axR;
    }
}
