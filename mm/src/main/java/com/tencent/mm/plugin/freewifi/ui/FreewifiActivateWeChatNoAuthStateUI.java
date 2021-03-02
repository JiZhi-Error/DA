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
import com.tencent.mm.sdk.platformtools.Log;

@Deprecated
public class FreewifiActivateWeChatNoAuthStateUI extends FreeWifiActivateNoAuthStateUI {
    private int dIX;
    private String wSW;
    private String wSX;

    @Override // com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateStateUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateNoAuthStateUI, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateNoAuthStateUI
    public final String dNQ() {
        AppMethodBeat.i(25172);
        String string = getString(R.string.dip);
        AppMethodBeat.o(25172);
        return string;
    }

    @Override // com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateNoAuthStateUI, com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver.a
    public final void a(NetworkInfo.State state) {
        AppMethodBeat.i(25173);
        Log.i("MicroMsg.FreeWifi.FreewifiActivateWeChatNoAuthStateUI", "now network state : %s", state.toString());
        if (state == NetworkInfo.State.CONNECTED && d.axS(this.ssid) && this.wQQ) {
            dNT();
            this.wQQ = false;
            this.wSW = d.dNb();
            this.wSX = d.dNf();
            this.dIX = d.dNc();
            Log.i("MicroMsg.FreeWifi.FreewifiActivateWeChatNoAuthStateUI", "now has connect the ap, check from server rssi is :  %d, mac : %s, ssid is : %s", Integer.valueOf(this.dIX), this.wSW, this.wSX);
            new a(this.pFJ, this.wSW, this.wSX, this.dIX, this.channelId, m.aw(getIntent())).c(new i() {
                /* class com.tencent.mm.plugin.freewifi.ui.FreewifiActivateWeChatNoAuthStateUI.AnonymousClass1 */

                @Override // com.tencent.mm.ak.i
                public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(25171);
                    bg.azz().b(640, this);
                    Log.i("MicroMsg.FreeWifi.FreewifiActivateWeChatNoAuthStateUI", "onSceneEnd, errType = %d, errCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
                    if (i2 == 0 && i3 == 0) {
                        Log.i("MicroMsg.FreeWifi.FreewifiActivateWeChatNoAuthStateUI", "check ap ok");
                        d.a(FreewifiActivateWeChatNoAuthStateUI.this.ssid, 2, FreewifiActivateWeChatNoAuthStateUI.this.getIntent());
                        AppMethodBeat.o(25171);
                        return;
                    }
                    Log.e("MicroMsg.FreeWifi.FreewifiActivateWeChatNoAuthStateUI", "check ap failed ： rssi is :  %d, mac : %s, ssid is : %s", Integer.valueOf(FreewifiActivateWeChatNoAuthStateUI.this.dIX), FreewifiActivateWeChatNoAuthStateUI.this.wSW, FreewifiActivateWeChatNoAuthStateUI.this.wSX);
                    FreewifiActivateWeChatNoAuthStateUI.this.GE(-2014);
                    d.axU(FreewifiActivateWeChatNoAuthStateUI.this.wSX);
                    AppMethodBeat.o(25171);
                }
            });
        }
        AppMethodBeat.o(25173);
    }

    @Override // com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateStateUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateNoAuthStateUI, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(25174);
        super.onDestroy();
        AppMethodBeat.o(25174);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateStateUI, com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateNoAuthStateUI
    public final int dNP() {
        AppMethodBeat.i(25175);
        j.dNm();
        int axR = d.axR(this.ssid);
        Log.i("MicroMsg.FreeWifi.FreewifiActivateWeChatNoAuthStateUI", "get connect state = %d", Integer.valueOf(axR));
        if (axR == 0) {
            AppMethodBeat.o(25175);
            return -2014;
        }
        AppMethodBeat.o(25175);
        return axR;
    }
}
