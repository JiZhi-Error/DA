package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.g;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

@Deprecated
public class FreeWifiActivateAuthStateUI extends FreeWifiActivateStateUI {
    @Override // com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateStateUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateStateUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(24962);
        super.onCreate(bundle);
        if (this.source != 2) {
            d.a(this.ssid, 1, getIntent());
        }
        Log.i("MicroMsg.FreeWifi.FreeWifiActivateAuthStateUI", "now it is from qrcode, try to auth");
        AppMethodBeat.o(24962);
    }

    @Override // com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateStateUI, com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(24963);
        super.initView();
        this.wQN = (Button) findViewById(R.id.dp6);
        this.wQN.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateAuthStateUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(24959);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/freewifi/ui/FreeWifiActivateAuthStateUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                String string = FreeWifiActivateAuthStateUI.this.getString(R.string.di3);
                Intent intent = new Intent();
                intent.putExtra("rawUrl", string);
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                c.b(FreeWifiActivateAuthStateUI.this, "webview", ".ui.tools.WebViewUI", intent);
                a.a(this, "com/tencent/mm/plugin/freewifi/ui/FreeWifiActivateAuthStateUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(24959);
            }
        });
        setMMTitle(R.string.dip);
        AppMethodBeat.o(24963);
    }

    @Override // com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateStateUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(24964);
        super.onDestroy();
        AppMethodBeat.o(24964);
    }

    @Override // com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver.a
    public final void a(NetworkInfo.State state) {
        AppMethodBeat.i(24965);
        Log.i("MicroMsg.FreeWifi.FreeWifiActivateAuthStateUI", "now network state : %s", state.toString());
        if (state == NetworkInfo.State.CONNECTED && d.axS(this.ssid)) {
            dNT();
            dNV();
        }
        AppMethodBeat.o(24965);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateStateUI
    public final void bpf() {
        AppMethodBeat.i(24966);
        j.dNs().a(this.ssid, new g.b() {
            /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateAuthStateUI.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.freewifi.model.g.b
            public final void dV(String str, int i2) {
                AppMethodBeat.i(24961);
                String dNb = d.dNb();
                Log.i("MicroMsg.FreeWifi.FreeWifiActivateAuthStateUI", "get ap auth data : %s, url : %s, mac : %s", str, FreeWifiActivateAuthStateUI.this.pFJ, dNb);
                if (!Util.isNullOrNil(str)) {
                    new com.tencent.mm.plugin.freewifi.d.a(FreeWifiActivateAuthStateUI.this.pFJ, FreeWifiActivateAuthStateUI.this.ssid, dNb, FreeWifiActivateAuthStateUI.this.wQO, str, "", i2, m.aw(FreeWifiActivateAuthStateUI.this.getIntent())).c(new i() {
                        /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateAuthStateUI.AnonymousClass2.AnonymousClass1 */

                        @Override // com.tencent.mm.ak.i
                        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                            AppMethodBeat.i(24960);
                            Log.i("MicroMsg.FreeWifi.FreeWifiActivateAuthStateUI", "errType : %d, errCode : %d, errMsg : %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                            FreeWifiActivateAuthStateUI.this.wQQ = false;
                            if (i2 == 0 && i3 == 0) {
                                String dNv = ((com.tencent.mm.plugin.freewifi.d.a) qVar).dNv();
                                Log.i("MicroMsg.FreeWifi.FreeWifiActivateAuthStateUI", "authUrl : %s", dNv);
                                j.dNs().a(FreeWifiActivateAuthStateUI.this.ssid, dNv, FreeWifiActivateAuthStateUI.this.getIntent());
                                AppMethodBeat.o(24960);
                            } else if (i3 == -2014) {
                                d.a(FreeWifiActivateAuthStateUI.this.ssid, -2014, FreeWifiActivateAuthStateUI.this.getIntent());
                                AppMethodBeat.o(24960);
                            } else {
                                d.a(FreeWifiActivateAuthStateUI.this.ssid, 3, FreeWifiActivateAuthStateUI.this.getIntent());
                                AppMethodBeat.o(24960);
                            }
                        }
                    });
                }
                AppMethodBeat.o(24961);
            }
        }, this.channelId, getIntent());
        AppMethodBeat.o(24966);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateStateUI
    public final void dNO() {
        AppMethodBeat.i(24967);
        dNS();
        d.axT(this.ssid);
        AppMethodBeat.o(24967);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateStateUI
    public final int dNP() {
        AppMethodBeat.i(24968);
        j.dNm();
        int axR = d.axR(this.ssid);
        AppMethodBeat.o(24968);
        return axR;
    }
}
