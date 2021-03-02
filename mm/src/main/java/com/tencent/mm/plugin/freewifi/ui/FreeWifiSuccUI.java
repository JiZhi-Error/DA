package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.c;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.appbrand.service.s;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.e;

public class FreeWifiSuccUI extends MMActivity implements i {
    private String appUserName;
    private String dNI;
    private Button gwO;
    private CheckBox qeC;
    private String signature;
    private String wPA;
    private int wSD;
    private String wSE;
    private View wSJ;
    private TextView wSK;
    private View wSL;
    private TextView wSM;
    private View wSN;
    private int wSO;
    private boolean wSP = false;
    private boolean wSQ = false;
    private TextView wSw;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(25149);
        super.onCreate(bundle);
        this.dNI = getIntent().getStringExtra("free_wifi_appid");
        this.wPA = getIntent().getStringExtra("free_wifi_app_nickname");
        this.appUserName = getIntent().getStringExtra("free_wifi_app_username");
        this.wSD = getIntent().getIntExtra("free_wifi_finish_actioncode", 0);
        this.wSE = getIntent().getStringExtra("free_wifi_finish_url");
        this.wSO = getIntent().getIntExtra(e.h.Ozc, 0);
        this.signature = getIntent().getStringExtra("free_wifi_signature");
        Log.i("MicroMsg.FreeWifi.FreeWifiSuccUI", "get from intent, appid = %s, appNickName = %s, appUserName = %s, finishActionCode = %d, finishUrl = %s, signature = %s", this.dNI, this.wPA, this.appUserName, Integer.valueOf(this.wSD), this.wSE, this.signature);
        k.a dMF = k.dMF();
        String axO = m.axO("MicroMsg.FreeWifi.FreeWifiSuccUI");
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
        AppMethodBeat.o(25149);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(25150);
        super.onResume();
        initView();
        AppMethodBeat.o(25150);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void finish() {
        AppMethodBeat.i(25151);
        super.finish();
        dOi();
        AppMethodBeat.o(25151);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(25152);
        if (i2 == 4 && keyEvent.getRepeatCount() == 0) {
            finish();
            AppMethodBeat.o(25152);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(25152);
        return onKeyDown;
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(25153);
        Log.i("MicroMsg.FreeWifi.FreeWifiSuccUI", "onSceneEnd, scnee type = %d, errType = %d, errCode = %d", Integer.valueOf(qVar.getType()), Integer.valueOf(i2), Integer.valueOf(i3));
        bg.azz().b(1703, this);
        AppMethodBeat.o(25153);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.amq;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(25154);
        setMMTitle(R.string.dip);
        setBackBtnVisible(false);
        this.wSJ = findViewById(R.id.da0);
        this.wSK = (TextView) findViewById(R.id.da1);
        this.qeC = (CheckBox) findViewById(R.id.d_y);
        this.wSL = findViewById(R.id.d_v);
        this.wSM = (TextView) findViewById(R.id.d_w);
        this.wSN = findViewById(R.id.da2);
        this.wSw = (TextView) findViewById(R.id.d_x);
        this.gwO = (Button) findViewById(R.id.b_r);
        this.gwO.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiSuccUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(25145);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/freewifi/ui/FreeWifiSuccUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                FreeWifiSuccUI.this.finish();
                FreeWifiSuccUI.a(FreeWifiSuccUI.this);
                a.a(this, "com/tencent/mm/plugin/freewifi/ui/FreeWifiSuccUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(25145);
            }
        });
        if (Util.isNullOrNil(this.dNI) || Util.isNullOrNil(this.appUserName) || Util.isNullOrNil(this.wPA)) {
            this.wSJ.setVisibility(8);
            this.wSL.setVisibility(8);
            this.wSN.setVisibility(8);
        } else if (!ab.IT(this.appUserName) || !ab.IS(this.appUserName)) {
            l.b(d.dNe(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0), false);
            this.wSN.setVisibility(8);
            this.wSJ.setVisibility(0);
            if (Util.isNullOrNil(this.signature)) {
                this.wSL.setVisibility(8);
                findViewById(R.id.d_z).setBackgroundColor(getResources().getColor(R.color.afz));
            } else {
                this.wSL.setVisibility(0);
                this.wSM.setText(this.signature);
            }
            this.wSK.setText(getString(R.string.di5, new Object[]{this.wPA}));
            if (this.wSO == 1) {
                this.qeC.setChecked(true);
                this.wSP = true;
            } else {
                this.qeC.setChecked(false);
                this.wSP = false;
            }
            this.qeC.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiSuccUI.AnonymousClass3 */

                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    AppMethodBeat.i(25147);
                    if (z) {
                        FreeWifiSuccUI.this.wSP = true;
                        AppMethodBeat.o(25147);
                        return;
                    }
                    FreeWifiSuccUI.this.wSP = false;
                    AppMethodBeat.o(25147);
                }
            });
        } else {
            l.b(d.dNe(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0), true);
            this.wSJ.setVisibility(8);
            this.wSL.setVisibility(8);
            this.wSN.setVisibility(0);
            this.wSw.setText(this.wPA);
            this.wSN.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiSuccUI.AnonymousClass2 */

                public final void onClick(View view) {
                    AppMethodBeat.i(25146);
                    b bVar = new b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/plugin/freewifi/ui/FreeWifiSuccUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (!Util.isNullOrNil(FreeWifiSuccUI.this.appUserName)) {
                        Intent intent = new Intent();
                        intent.putExtra("Contact_User", FreeWifiSuccUI.this.appUserName);
                        c.b(FreeWifiSuccUI.this, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                    }
                    a.a(this, "com/tencent/mm/plugin/freewifi/ui/FreeWifiSuccUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(25146);
                }
            });
        }
        if (m.az(getIntent()) == 10) {
            final String str = ae.gKy.gJB;
            if (!m.eP(str) && !m.eP(ae.cu(getContext()))) {
                Button button = (Button) findViewById(R.id.da4);
                button.setText(String.format(getString(R.string.dio), ae.cu(getContext())));
                button.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiSuccUI.AnonymousClass4 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(25148);
                        b bVar = new b();
                        bVar.bm(view);
                        a.b("com/tencent/mm/plugin/freewifi/ui/FreeWifiSuccUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        Intent intent = new Intent();
                        intent.putExtra("Contact_User", str);
                        c.b(FreeWifiSuccUI.this, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                        a.a(this, "com/tencent/mm/plugin/freewifi/ui/FreeWifiSuccUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(25148);
                    }
                });
                button.setVisibility(0);
            }
        }
        AppMethodBeat.o(25154);
    }

    private void dOi() {
        AppMethodBeat.i(25155);
        if (this.wSQ) {
            AppMethodBeat.o(25155);
            return;
        }
        this.wSQ = true;
        if (this.wSP && !Util.isNullOrNil(this.dNI) && (!ab.IT(this.appUserName) || !ab.IS(this.appUserName))) {
            bg.azz().a(1703, this);
            bg.azz().a(new com.tencent.mm.plugin.freewifi.model.i(this.dNI, getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_channel_id", 0), m.aw(getIntent())), 0);
        }
        l.c(d.dNe(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0), this.wSP);
        AppMethodBeat.o(25155);
    }

    static /* synthetic */ void a(FreeWifiSuccUI freeWifiSuccUI) {
        AppMethodBeat.i(25156);
        freeWifiSuccUI.dOi();
        k.a dMF = k.dMF();
        String axO = m.axO("MicroMsg.FreeWifi.FreeWifiSuccUI");
        dMF.ssid = NetStatusUtil.getConnectedWifiSsid(MMApplicationContext.getContext());
        dMF.bssid = NetStatusUtil.getConnectedWifiBssid(MMApplicationContext.getContext());
        dMF.dFe = axO;
        dMF.dFd = m.aA(freeWifiSuccUI.getIntent());
        dMF.wNb = freeWifiSuccUI.dNI;
        dMF.quX = m.aw(freeWifiSuccUI.getIntent());
        dMF.wNc = m.ay(freeWifiSuccUI.getIntent());
        dMF.wNd = k.b.BackpageFinished.wNO;
        dMF.wNe = k.b.BackpageFinished.name;
        dMF.channel = m.az(freeWifiSuccUI.getIntent());
        dMF.wNf = freeWifiSuccUI.appUserName;
        dMF.dMH().dMG();
        if (freeWifiSuccUI.wSD != 1 || Util.isNullOrNil(freeWifiSuccUI.wSE)) {
            if (freeWifiSuccUI.wSD != 0 && freeWifiSuccUI.wSD == 3 && !Util.isNullOrNil(freeWifiSuccUI.wSE)) {
                ((s) g.af(s.class)).b(freeWifiSuccUI, freeWifiSuccUI.wSE, 1078, null, null);
                Log.i("MicroMsg.FreeWifi.FreeWifiSuccUI", "jump to wxa after connect wifi success, url is : %s", freeWifiSuccUI.wSE);
            }
            AppMethodBeat.o(25156);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", Uri.parse(freeWifiSuccUI.wSE).buildUpon().appendQueryParameter("lang", LocaleUtil.loadApplicationLanguage(freeWifiSuccUI.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), freeWifiSuccUI)).build().toString());
        intent.putExtra("show_bottom", false);
        intent.putExtra("stastic_scene", 7);
        intent.putExtra("neverBlockLocalRequest", true);
        c.b(freeWifiSuccUI, "webview", ".ui.tools.WebViewUI", intent);
        Log.i("MicroMsg.FreeWifi.FreeWifiSuccUI", "jump to ad page after connect wifi success, url is : %s", intent.getStringExtra("rawUrl"));
        AppMethodBeat.o(25156);
    }
}
