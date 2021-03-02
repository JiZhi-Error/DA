package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.freewifi.g;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ih;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.e;

public class FreeWifiCopyPwdUI extends MMActivity {
    public static int wRe = 111;
    private String appId;
    private int channelId;
    private String dFd;
    private MMHandler hAk = new MMHandler() {
        /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiCopyPwdUI.AnonymousClass4 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(24998);
            b bVar = (b) message.obj;
            if (bVar.uEf == FreeWifiCopyPwdUI.this.wRf) {
                FreeWifiCopyPwdUI.a(FreeWifiCopyPwdUI.this, bVar.data);
                AppMethodBeat.o(24998);
                return;
            }
            FreeWifiCopyPwdUI.b(FreeWifiCopyPwdUI.this, bVar.data);
            AppMethodBeat.o(24998);
        }
    };
    private Intent intent;
    private String ssid;
    private int wPz;
    private int wRf = 1;
    private int wRg = 2;
    protected TextView wRh;
    protected TextView wRi;
    protected TextView wRj;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FreeWifiCopyPwdUI() {
        AppMethodBeat.i(25001);
        AppMethodBeat.o(25001);
    }

    static /* synthetic */ void a(FreeWifiCopyPwdUI freeWifiCopyPwdUI) {
        AppMethodBeat.i(25006);
        freeWifiCopyPwdUI.goBack();
        AppMethodBeat.o(25006);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(25002);
        super.onCreate(bundle);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiCopyPwdUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(24995);
                FreeWifiCopyPwdUI.a(FreeWifiCopyPwdUI.this);
                AppMethodBeat.o(24995);
                return true;
            }
        });
        this.intent = getIntent();
        this.ssid = getIntent().getStringExtra("free_wifi_ssid");
        this.dFd = this.intent.getStringExtra("free_wifi_ap_key");
        this.appId = this.intent.getStringExtra("free_wifi_appid");
        this.channelId = this.intent.getIntExtra("free_wifi_channel_id", 0);
        this.wPz = this.intent.getIntExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 0);
        ((TextView) findViewById(R.id.d_t)).setText(this.ssid);
        ClipboardHelper.setText(getContext(), "wifi password", getIntent().getStringExtra("free_wifi_passowrd"));
        ((Button) findViewById(R.id.d__)).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiCopyPwdUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(24996);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/freewifi/ui/FreeWifiCopyPwdUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                FreeWifiCopyPwdUI.this.startActivityForResult(new Intent("android.settings.WIFI_SETTINGS"), FreeWifiCopyPwdUI.wRe);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/freewifi/ui/FreeWifiCopyPwdUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(24996);
            }
        });
        this.wRh = (TextView) findViewById(R.id.d_b);
        this.wRi = (TextView) findViewById(R.id.d_a);
        this.wRj = (TextView) findViewById(R.id.d_c);
        String dNe = d.dNe();
        String stringExtra = getIntent().getStringExtra("free_wifi_ap_key");
        int intExtra = getIntent().getIntExtra("free_wifi_protocol_type", 0);
        h.INSTANCE.a(12651, 6, dNe, 0, stringExtra, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(intExtra));
        AppMethodBeat.o(25002);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent2) {
        AppMethodBeat.i(25003);
        if (i2 == wRe && m.dML() && !Util.isNullOrNil(this.ssid) && this.ssid.equals(d.dNf())) {
            Log.i("MicroMsg.FreeWifi.FreeWifiCopyPwdUI", "sessionKey=%s, step=%d, desc=connect ssid succeeded. ", m.aw(this.intent), Integer.valueOf(m.ax(this.intent)));
            k.a dMF = k.dMF();
            dMF.ssid = this.ssid;
            dMF.bssid = m.axN("MicroMsg.FreeWifi.FreeWifiCopyPwdUI");
            dMF.dFe = m.axO("MicroMsg.FreeWifi.FreeWifiCopyPwdUI");
            dMF.dFd = this.dFd;
            dMF.wNb = this.appId;
            dMF.quX = m.aw(this.intent);
            dMF.wNc = m.ay(this.intent);
            dMF.wNd = k.b.AddNetwork.wNO;
            dMF.wNe = k.b.AddNetwork.name;
            dMF.result = 0;
            dMF.channel = m.az(this.intent);
            dMF.dMH().dMG();
            m.a(this.intent, this.dFd, this.wPz, this.channelId, new m.a() {
                /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiCopyPwdUI.AnonymousClass3 */

                @Override // com.tencent.mm.plugin.freewifi.m.a
                public final void f(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(24997);
                    if (i2 == 0 && i3 == 0) {
                        if (!(qVar instanceof com.tencent.mm.plugin.freewifi.d.a)) {
                            AppMethodBeat.o(24997);
                            return;
                        }
                        ih dNz = ((com.tencent.mm.plugin.freewifi.d.a) qVar).dNz();
                        if (dNz != null) {
                            Log.i("MicroMsg.FreeWifi.FreeWifiCopyPwdUI", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s, qingHuaiPageUrl: %s", dNz.KGX, dNz.oUJ, dNz.UserName, Integer.valueOf(dNz.KMt), dNz.KMu, dNz.keb, dNz.KMv);
                            FreeWifiCopyPwdUI.a(FreeWifiCopyPwdUI.this, new b(FreeWifiCopyPwdUI.this.wRf, dNz));
                            AppMethodBeat.o(24997);
                            return;
                        }
                        Log.i("MicroMsg.FreeWifi.FreeWifiCopyPwdUI", "backPageInfo is null");
                        FreeWifiCopyPwdUI freeWifiCopyPwdUI = FreeWifiCopyPwdUI.this;
                        FreeWifiCopyPwdUI freeWifiCopyPwdUI2 = FreeWifiCopyPwdUI.this;
                        int i4 = FreeWifiCopyPwdUI.this.wRg;
                        a aVar = new a();
                        aVar.wRo = m.a(FreeWifiCopyPwdUI.this.wPz, k.b.GetBackPageReturn, 21);
                        FreeWifiCopyPwdUI.a(freeWifiCopyPwdUI, new b(i4, aVar));
                        AppMethodBeat.o(24997);
                    } else if (!m.gC(i2, i3) || m.eP(str)) {
                        FreeWifiCopyPwdUI freeWifiCopyPwdUI3 = FreeWifiCopyPwdUI.this;
                        FreeWifiCopyPwdUI freeWifiCopyPwdUI4 = FreeWifiCopyPwdUI.this;
                        int i5 = FreeWifiCopyPwdUI.this.wRg;
                        a aVar2 = new a();
                        aVar2.wRo = m.a(FreeWifiCopyPwdUI.this.wPz, k.b.GetBackPageReturn, i3);
                        FreeWifiCopyPwdUI.a(freeWifiCopyPwdUI3, new b(i5, aVar2));
                        AppMethodBeat.o(24997);
                    } else {
                        FreeWifiCopyPwdUI freeWifiCopyPwdUI5 = FreeWifiCopyPwdUI.this;
                        FreeWifiCopyPwdUI freeWifiCopyPwdUI6 = FreeWifiCopyPwdUI.this;
                        int i6 = FreeWifiCopyPwdUI.this.wRg;
                        a aVar3 = new a();
                        aVar3.text = str;
                        aVar3.wRo = m.a(FreeWifiCopyPwdUI.this.wPz, k.b.GetBackPageReturn, i3);
                        FreeWifiCopyPwdUI.a(freeWifiCopyPwdUI5, new b(i6, aVar3));
                        AppMethodBeat.o(24997);
                    }
                }
            }, "MicroMsg.FreeWifi.FreeWifiCopyPwdUI");
        }
        AppMethodBeat.o(25003);
    }

    public class b {
        Object data;
        int uEf;

        public b(int i2, Object obj) {
            this.uEf = i2;
            this.data = obj;
        }
    }

    public static class a {
        public static a wRm = new a();
        String text;
        private int wRn;
        String wRo;

        static {
            AppMethodBeat.i(25000);
            AppMethodBeat.o(25000);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(25004);
        if (i2 == 4 && keyEvent.getRepeatCount() == 0) {
            goBack();
            AppMethodBeat.o(25004);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(25004);
        return onKeyDown;
    }

    private void goBack() {
        AppMethodBeat.i(25005);
        l.S(d.dNe(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
        k.a dMF = k.dMF();
        dMF.dFd = this.dFd;
        dMF.quX = m.aw(this.intent);
        dMF.wNd = k.b.CopyPwdPageUIClosedByGoBack.wNO;
        dMF.wNe = k.b.CopyPwdPageUIClosedByGoBack.name;
        dMF.channel = m.az(this.intent);
        dMF.wNc = m.ay(this.intent);
        dMF.result = 0;
        dMF.resultMsg = "";
        dMF.dMH().c(this.intent, true).dMG();
        g.jRt.h(new Intent(), this);
        finish();
        AppMethodBeat.o(25005);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.amg;
    }

    static /* synthetic */ void a(FreeWifiCopyPwdUI freeWifiCopyPwdUI, b bVar) {
        AppMethodBeat.i(25007);
        Message obtain = Message.obtain();
        obtain.obj = bVar;
        freeWifiCopyPwdUI.hAk.sendMessage(obtain);
        AppMethodBeat.o(25007);
    }

    static /* synthetic */ void a(FreeWifiCopyPwdUI freeWifiCopyPwdUI, Object obj) {
        AppMethodBeat.i(25008);
        if (obj instanceof ih) {
            ih ihVar = (ih) obj;
            Intent intent2 = freeWifiCopyPwdUI.getIntent();
            intent2.putExtra("free_wifi_appid", ihVar.KGX);
            intent2.putExtra("free_wifi_app_nickname", ihVar.oUJ);
            intent2.putExtra("free_wifi_app_username", ihVar.UserName);
            intent2.putExtra("free_wifi_signature", ihVar.keb);
            intent2.putExtra("free_wifi_finish_actioncode", ihVar.KMt);
            intent2.putExtra("free_wifi_finish_url", ihVar.KMu);
            intent2.putExtra(e.h.Ozc, ihVar.wSO);
            if (ihVar.KMt == 2) {
                if (!Util.isNullOrNil(ihVar.UserName)) {
                    Intent intent3 = new Intent();
                    intent3.putExtra("Contact_User", ihVar.UserName);
                    c.b(freeWifiCopyPwdUI, Scopes.PROFILE, ".ui.ContactInfoUI", intent3);
                    c.report();
                    Log.i("MicroMsg.FreeWifi.FreeWifiCopyPwdUI", "sessionKey=%s, step=%d, method=toSuccess, desc=connect succeeded.", m.aw(freeWifiCopyPwdUI.getIntent()), Integer.valueOf(m.ax(freeWifiCopyPwdUI.getIntent())));
                    k.a dMF = k.dMF();
                    dMF.dFd = freeWifiCopyPwdUI.dFd;
                    dMF.quX = m.aw(intent2);
                    dMF.wNd = k.b.FrontPageUIClosedByGoContactInfoUI.wNO;
                    dMF.wNe = k.b.FrontPageUIClosedByGoContactInfoUI.name;
                    dMF.channel = m.az(intent2);
                    dMF.wNc = m.ay(intent2);
                    dMF.result = 0;
                    dMF.resultMsg = "";
                    dMF.dMH().c(intent2, true).dMG();
                    AppMethodBeat.o(25008);
                    return;
                }
                intent2.setClass(freeWifiCopyPwdUI, FreeWifiSuccUI.class);
            } else if (m.eP(ihVar.KMv)) {
                intent2.setClass(freeWifiCopyPwdUI, FreeWifiSuccUI.class);
            } else {
                intent2.putExtra("free_wifi_qinghuai_url", ihVar.KMv);
                intent2.setClass(freeWifiCopyPwdUI, FreeWifiSuccWebViewUI.class);
            }
            k.a dMF2 = k.dMF();
            dMF2.dFd = freeWifiCopyPwdUI.dFd;
            dMF2.quX = m.aw(intent2);
            dMF2.wNd = k.b.FrontPageUIClosedByGoSuc.wNO;
            dMF2.wNe = k.b.FrontPageUIClosedByGoSuc.name;
            dMF2.channel = m.az(intent2);
            dMF2.wNc = m.ay(intent2);
            dMF2.result = 0;
            dMF2.resultMsg = "";
            dMF2.dMH().c(intent2, true).dMG();
            freeWifiCopyPwdUI.finish();
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
            com.tencent.mm.hellhoundlib.a.a.a(freeWifiCopyPwdUI, bl.axQ(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiCopyPwdUI", "toSuccess", "(Ljava/lang/Object;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            freeWifiCopyPwdUI.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(freeWifiCopyPwdUI, "com/tencent/mm/plugin/freewifi/ui/FreeWifiCopyPwdUI", "toSuccess", "(Ljava/lang/Object;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            c.report();
            Log.i("MicroMsg.FreeWifi.FreeWifiCopyPwdUI", "sessionKey=%s, step=%d, method=toSuccess, desc=connect succeeded.", m.aw(freeWifiCopyPwdUI.getIntent()), Integer.valueOf(m.ax(freeWifiCopyPwdUI.getIntent())));
        }
        AppMethodBeat.o(25008);
    }

    static /* synthetic */ void b(FreeWifiCopyPwdUI freeWifiCopyPwdUI, Object obj) {
        String string;
        AppMethodBeat.i(25009);
        if (obj instanceof a) {
            a aVar = (a) obj;
            Log.i("MicroMsg.FreeWifi.FreeWifiCopyPwdUI", "sessionKey=%s, step=%d, desc=Connect failed. errcode=%s", m.aw(freeWifiCopyPwdUI.intent), Integer.valueOf(m.ax(freeWifiCopyPwdUI.intent)), aVar.wRo);
            freeWifiCopyPwdUI.wRh.setVisibility(0);
            if (!m.eP(aVar.text)) {
                string = aVar.text;
            } else {
                if (aVar.wRn == 0) {
                    aVar.wRn = R.string.dhm;
                }
                string = freeWifiCopyPwdUI.getString(aVar.wRn);
            }
            freeWifiCopyPwdUI.wRh.setText(string);
            freeWifiCopyPwdUI.wRh.setVisibility(0);
            freeWifiCopyPwdUI.wRi.setVisibility(0);
            freeWifiCopyPwdUI.wRj.setVisibility(0);
            final String str = freeWifiCopyPwdUI.getString(R.string.di2) + ": " + aVar.wRo;
            freeWifiCopyPwdUI.wRj.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiCopyPwdUI.AnonymousClass5 */

                public final void onClick(View view) {
                    AppMethodBeat.i(24999);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/freewifi/ui/FreeWifiCopyPwdUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Intent intent = new Intent();
                    intent.putExtra("free_wifi_show_detail_error", 1);
                    intent.putExtra("free_wifi_error_ui_error_msg", FreeWifiCopyPwdUI.this.getString(R.string.dhl));
                    intent.putExtra("free_wifi_error_ui_error_msg_detail1", str);
                    intent.setClass(FreeWifiCopyPwdUI.this, FreeWifiErrorUI.class);
                    FreeWifiCopyPwdUI freeWifiCopyPwdUI = FreeWifiCopyPwdUI.this;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(freeWifiCopyPwdUI, bl.axQ(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiCopyPwdUI$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    freeWifiCopyPwdUI.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(freeWifiCopyPwdUI, "com/tencent/mm/plugin/freewifi/ui/FreeWifiCopyPwdUI$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/freewifi/ui/FreeWifiCopyPwdUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(24999);
                }
            });
            Log.i("MicroMsg.FreeWifi.FreeWifiCopyPwdUI", "sessionKey=%s, step=%d, method=Protocol.toFail, desc=connect failed.", m.aw(freeWifiCopyPwdUI.getIntent()), Integer.valueOf(m.ax(freeWifiCopyPwdUI.getIntent())));
        }
        AppMethodBeat.o(25009);
    }
}
