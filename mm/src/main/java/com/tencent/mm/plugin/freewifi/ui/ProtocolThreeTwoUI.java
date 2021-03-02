package com.tencent.mm.plugin.freewifi.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.freewifi.a;
import com.tencent.mm.plugin.freewifi.a.a;
import com.tencent.mm.plugin.freewifi.g;
import com.tencent.mm.plugin.freewifi.h;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.protobuf.ih;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import java.net.HttpURLConnection;
import java.net.UnknownHostException;

@Deprecated
public class ProtocolThreeTwoUI extends MMActivity {
    protected String appUserName;
    protected int channelId;
    private String dFd;
    private int dHO = 1;
    protected String dNI;
    private String dmc;
    protected String iAR;
    private Intent intent;
    private final c jaR;
    private String openId;
    protected String pFJ;
    private String sign;
    protected String signature;
    protected int source;
    protected String ssid;
    protected String wPA;
    private a wPE;
    private int wPK = 0;
    private String wPU;
    protected String wQO;
    private MStorage.IOnStorageChange wQU;
    protected String wRC;
    protected String wRD;
    protected String wRE;
    private TextView wRh;
    private ImageView wRv;
    private TextView wRw;
    private TextView wRx;
    private Button wRy;
    private Button wRz;
    protected int wSD;
    protected String wSE;
    protected String wSF;
    private q wSy;
    private MTimerHandler wTa = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.freewifi.ui.ProtocolThreeTwoUI.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(25233);
            if (!Util.isNullOrNil(ProtocolThreeTwoUI.this.ssid)) {
                ProtocolThreeTwoUI.this.dHO = ProtocolThreeTwoUI.this.dNP();
                if (ProtocolThreeTwoUI.this.dHO != 2) {
                    Log.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.connectTimeoutHandler, desc=wifi connecttimeout. state=%s", m.aw(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(m.ax(ProtocolThreeTwoUI.this.getIntent())), d.Ne(ProtocolThreeTwoUI.this.dHO));
                    d.a(ProtocolThreeTwoUI.this.ssid, 3, ProtocolThreeTwoUI.this.getIntent());
                    ProtocolThreeTwoUI.a(ProtocolThreeTwoUI.this, 33, "AUTH_302_TIMES_EXCESS");
                }
            }
            AppMethodBeat.o(25233);
            return false;
        }
    }, false);

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ProtocolThreeTwoUI() {
        AppMethodBeat.i(25256);
        c.a aVar = new c.a();
        aVar.jbd = true;
        aVar.jbe = true;
        aVar.jbq = R.drawable.bdo;
        aVar.iaT = true;
        aVar.jbx = 0.0f;
        this.jaR = aVar.bdv();
        AppMethodBeat.o(25256);
    }

    static /* synthetic */ void a(ProtocolThreeTwoUI protocolThreeTwoUI, int i2, String str) {
        AppMethodBeat.i(25266);
        protocolThreeTwoUI.bt(i2, str);
        AppMethodBeat.o(25266);
    }

    static /* synthetic */ void b(ProtocolThreeTwoUI protocolThreeTwoUI) {
        AppMethodBeat.i(25267);
        protocolThreeTwoUI.goBack();
        AppMethodBeat.o(25267);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        boolean z;
        AppMethodBeat.i(25257);
        super.onCreate(bundle);
        this.intent = getIntent();
        this.dFd = getIntent().getStringExtra("free_wifi_ap_key");
        this.openId = getIntent().getStringExtra("free_wifi_openid");
        this.wPU = getIntent().getStringExtra("free_wifi_tid");
        this.dmc = getIntent().getStringExtra("ConstantsFreeWifi.FREE_WIFI_TIMESTAMP");
        this.sign = getIntent().getStringExtra("ConstantsFreeWifi.FREE_WIFI_SIGN");
        Log.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.onCreate, desc=it goes into Protocol32 connect frontpage. apKey=%s", m.aw(getIntent()), Integer.valueOf(m.ax(getIntent())), this.dFd);
        initView();
        if (Util.isNullOrNil(this.ssid)) {
            Log.e("MicroMsg.FreeWifi.Protocol32UI", "ssid is null");
        } else {
            com.tencent.mm.plugin.freewifi.g.c aya = j.dNn().aya(this.ssid);
            if (aya == null) {
                aya = new com.tencent.mm.plugin.freewifi.g.c();
                aya.field_ssidmd5 = MD5Util.getMD5String(this.ssid);
                aya.field_ssid = this.ssid;
                z = true;
            } else {
                z = false;
            }
            aya.field_url = this.pFJ;
            aya.field_mid = this.wQO;
            aya.field_wifiType = 32;
            aya.field_connectState = 1;
            if (z) {
                j.dNn().insert(aya);
            } else {
                j.dNn().update(aya, new String[0]);
            }
            Log.i("MicroMsg.FreeWifi.Protocol32UI", "ssid : %s, mid : %s, source : %d", this.ssid, this.wQO, Integer.valueOf(this.source));
            this.wQU = new MStorage.IOnStorageChange() {
                /* class com.tencent.mm.plugin.freewifi.ui.ProtocolThreeTwoUI.AnonymousClass7 */
                private int wSH = -999999999;

                @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
                public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
                    AppMethodBeat.i(25240);
                    ProtocolThreeTwoUI.this.dHO = ProtocolThreeTwoUI.this.dNP();
                    if (this.wSH != ProtocolThreeTwoUI.this.dHO) {
                        this.wSH = ProtocolThreeTwoUI.this.dHO;
                        ProtocolThreeTwoUI.this.Ng(ProtocolThreeTwoUI.this.dHO);
                    }
                    AppMethodBeat.o(25240);
                }
            };
            j.dNn().add(this.wQU);
            Log.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.initModel, desc=Initializing the model behind the view, so anything that changes the model will notify the view. model : field_ssidmd5=%s, field_ssid=%s, field_url=%s, field_mid=%s, field_wifiType=%d, field_connectState=%d", m.aw(getIntent()), Integer.valueOf(m.ax(getIntent())), aya.field_ssidmd5, aya.field_ssid, aya.field_url, aya.field_mid, Integer.valueOf(aya.field_wifiType), Integer.valueOf(aya.field_connectState));
            Log.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.initModel, desc=it initializes the front page. ", m.aw(getIntent()), Integer.valueOf(m.ax(getIntent())));
            d.a(this.ssid, 4, getIntent());
        }
        l.Q(d.dNe(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
        AppMethodBeat.o(25257);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(25258);
        this.ssid = getIntent().getStringExtra("free_wifi_ssid");
        this.wQO = getIntent().getStringExtra("free_wifi_mid");
        this.pFJ = getIntent().getStringExtra("free_wifi_url");
        this.source = getIntent().getIntExtra("free_wifi_source", 1);
        this.channelId = getIntent().getIntExtra("free_wifi_channel_id", 0);
        this.dNI = getIntent().getStringExtra("free_wifi_appid");
        this.iAR = getIntent().getStringExtra("free_wifi_head_img_url");
        this.wRC = getIntent().getStringExtra("free_wifi_welcome_msg");
        this.wRD = getIntent().getStringExtra("free_wifi_welcome_sub_title");
        this.wRE = getIntent().getStringExtra("free_wifi_privacy_url");
        this.wPA = getIntent().getStringExtra("free_wifi_app_nickname");
        Log.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.initView, desc=Initializing the view. ssid=%s, mid=%s, fullUrl=%s, source=%d, channel=%d, appid=%s, headImgUrl=%s, welcomeMsg=%s, privacyUrl=%s", m.aw(getIntent()), Integer.valueOf(m.ax(getIntent())), this.ssid, this.wQO, this.pFJ, Integer.valueOf(this.source), Integer.valueOf(this.channelId), this.dNI, this.iAR, this.wRC, this.wRE);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.freewifi.ui.ProtocolThreeTwoUI.AnonymousClass4 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(25237);
                ProtocolThreeTwoUI.b(ProtocolThreeTwoUI.this);
                AppMethodBeat.o(25237);
                return true;
            }
        });
        findViewById(R.id.j1m).setVisibility(0);
        this.wRv = (ImageView) findViewById(R.id.d_2);
        this.wRw = (TextView) findViewById(R.id.da8);
        this.wRx = (TextView) findViewById(R.id.d_u);
        this.wRh = (TextView) findViewById(R.id.d_9);
        this.wRy = (Button) findViewById(R.id.b_q);
        this.wRy.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.freewifi.ui.ProtocolThreeTwoUI.AnonymousClass5 */

            public final void onClick(View view) {
                AppMethodBeat.i(25238);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/freewifi/ui/ProtocolThreeTwoUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                l.R(d.dNe(), ProtocolThreeTwoUI.this.getIntent().getStringExtra("free_wifi_ap_key"), ProtocolThreeTwoUI.this.getIntent().getIntExtra("free_wifi_protocol_type", 0));
                int dNP = ProtocolThreeTwoUI.this.dNP();
                Log.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.connectWifiBtn.setOnClickListener, desc=User click the connect button and starts the connect wifi process. state=%s", m.aw(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(m.ax(ProtocolThreeTwoUI.this.getIntent())), d.Ne(dNP));
                if (dNP == 2) {
                    ProtocolThreeTwoUI.this.finish();
                } else {
                    d.a(ProtocolThreeTwoUI.this.ssid, 1, ProtocolThreeTwoUI.this.getIntent());
                    ProtocolThreeTwoUI.this.connect();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/freewifi/ui/ProtocolThreeTwoUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(25238);
            }
        });
        this.wRz = (Button) findViewById(R.id.j1n);
        this.wRz.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.freewifi.ui.ProtocolThreeTwoUI.AnonymousClass6 */

            public final void onClick(View view) {
                AppMethodBeat.i(25239);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/freewifi/ui/ProtocolThreeTwoUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent();
                intent.putExtra("rawUrl", ProtocolThreeTwoUI.this.wRE);
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                com.tencent.mm.br.c.b(ProtocolThreeTwoUI.this.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/freewifi/ui/ProtocolThreeTwoUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(25239);
            }
        });
        if (Util.isNullOrNil(this.ssid)) {
            this.wRx.setText(getString(R.string.din));
            this.wRy.setVisibility(4);
        }
        setMMTitle(getString(R.string.dip));
        AppMethodBeat.o(25258);
    }

    /* access modifiers changed from: protected */
    public final void connect() {
        AppMethodBeat.i(25259);
        this.dHO = dNP();
        Log.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=connect, desc=it starts connecting wifi by protocol 3.1. current connect state=%s", m.aw(getIntent()), Integer.valueOf(m.ax(getIntent())), d.Ne(this.dHO));
        if (this.dHO != 2) {
            this.wTa.startTimer(45000);
            Log.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=connect, desc=it starts connectTimeoutHandler. timeout=%d s", m.aw(getIntent()), Integer.valueOf(m.ax(getIntent())), 60);
            this.wPE = new a(this.ssid, this);
            j.dNq().dMZ().post(new Runnable() {
                /* class com.tencent.mm.plugin.freewifi.ui.ProtocolThreeTwoUI.AnonymousClass8 */

                public final void run() {
                    AppMethodBeat.i(25241);
                    ProtocolThreeTwoUI.c(ProtocolThreeTwoUI.this);
                    AppMethodBeat.o(25241);
                }
            });
            AppMethodBeat.o(25259);
            return;
        }
        d.a(this.ssid, 2, getIntent());
        AppMethodBeat.o(25259);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* access modifiers changed from: protected */
    public final void Ng(int i2) {
        AppMethodBeat.i(25260);
        Log.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.onConnectStateChange, desc=it receives notifications whenever the connect state of model changes and then updates the view accordingly. state=%d", m.aw(getIntent()), Integer.valueOf(m.ax(getIntent())), Integer.valueOf(i2));
        switch (i2) {
            case 1:
                this.wRh.setVisibility(4);
                this.wRy.setText(R.string.b9i);
                this.wSy = h.a((Context) getContext(), getString(R.string.b9i), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                    /* class com.tencent.mm.plugin.freewifi.ui.ProtocolThreeTwoUI.AnonymousClass3 */

                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(25236);
                        d.a(ProtocolThreeTwoUI.this.ssid, 4, ProtocolThreeTwoUI.this.getIntent());
                        Log.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.toConnecting.ProgressDlg.onCancel, desc=it changes the connect state of the model to CONNECT_STATE_WAIT_START because the user cancles the connect process in progress. state=%d", m.aw(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(m.ax(ProtocolThreeTwoUI.this.getIntent())), 4);
                        AppMethodBeat.o(25236);
                    }
                });
                Log.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.toConnecting, desc=it adds a loading ui on the connect front page.", m.aw(getIntent()), Integer.valueOf(m.ax(getIntent())));
                AppMethodBeat.o(25260);
                return;
            case 2:
                if (this.wSy != null) {
                    this.wSy.dismiss();
                }
                this.wTa.stopTimer();
                this.wRy.setText(R.string.b9f);
                this.wRy.setClickable(false);
                Intent intent2 = getIntent();
                intent2.putExtra("free_wifi_appid", this.dNI);
                intent2.putExtra("free_wifi_app_nickname", this.wPA);
                intent2.putExtra("free_wifi_app_username", this.appUserName);
                intent2.putExtra("free_wifi_signature", this.signature);
                intent2.putExtra("free_wifi_finish_actioncode", this.wSD);
                intent2.putExtra("free_wifi_finish_url", this.wSE);
                if (Util.isNullOrNil(this.wSF)) {
                    intent2.setClass(this, FreeWifiSuccUI.class);
                } else {
                    intent2.putExtra("free_wifi_qinghuai_url", this.wSF);
                    intent2.setClass(this, FreeWifiSuccWebViewUI.class);
                }
                finish();
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/freewifi/ui/ProtocolThreeTwoUI", "toSuccess", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/freewifi/ui/ProtocolThreeTwoUI", "toSuccess", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                c.report();
                Log.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.toSuccess, desc=connect succeeded.", m.aw(getIntent()), Integer.valueOf(m.ax(getIntent())));
                break;
            case 3:
                if (this.wSy != null) {
                    this.wSy.dismiss();
                }
                this.wTa.stopTimer();
                this.wRh.setVisibility(0);
                this.wRy.setText(R.string.dil);
                Log.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.toFail, desc=connect failed.", m.aw(getIntent()), Integer.valueOf(m.ax(getIntent())));
                AppMethodBeat.o(25260);
                return;
            case 4:
                if (this.wSy != null) {
                    this.wSy.dismiss();
                }
                this.wTa.stopTimer();
                this.wRh.setVisibility(4);
                this.wRy.setText(R.string.b9l);
                if (this.source == 3) {
                    this.wRx.setText(getString(R.string.f0d, new Object[]{this.ssid}));
                } else if (Util.isNullOrNil(this.wRD)) {
                    this.wRx.setText(getString(R.string.b9h));
                } else {
                    this.wRx.setText(this.wRD);
                }
                if (!Util.isNullOrNil(this.dNI)) {
                    if (!Util.isNullOrNil(this.wPA)) {
                        this.wRw.setText(this.wPA);
                    }
                    if (!Util.isNullOrNil(this.iAR)) {
                        com.tencent.mm.av.q.bcV().a(this.iAR, this.wRv, this.jaR);
                    }
                }
                Log.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.toConnectStart, desc=it initializes the connect front page.", m.aw(getIntent()), Integer.valueOf(m.ax(getIntent())));
                AppMethodBeat.o(25260);
                return;
        }
        AppMethodBeat.o(25260);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.ami;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(25261);
        if (i2 == 4 && keyEvent.getRepeatCount() == 0) {
            goBack();
            AppMethodBeat.o(25261);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(25261);
        return onKeyDown;
    }

    private void goBack() {
        AppMethodBeat.i(25262);
        l.S(d.dNe(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
        g.jRt.h(new Intent(), this);
        finish();
        AppMethodBeat.o(25262);
    }

    /* access modifiers changed from: protected */
    public final int dNP() {
        AppMethodBeat.i(25263);
        if (Util.isNullOrNil(this.ssid)) {
            Log.d("MicroMsg.FreeWifi.Protocol32UI", "Illegal SSID");
            AppMethodBeat.o(25263);
            return 0;
        }
        com.tencent.mm.plugin.freewifi.g.c aya = j.dNn().aya(this.ssid);
        if (aya == null || !aya.field_ssid.equalsIgnoreCase(this.ssid)) {
            AppMethodBeat.o(25263);
            return 0;
        }
        int i2 = aya.field_connectState;
        AppMethodBeat.o(25263);
        return i2;
    }

    private void bt(int i2, String str) {
        AppMethodBeat.i(25264);
        k.a dMF = k.dMF();
        dMF.ssid = this.ssid;
        dMF.bssid = m.axN("MicroMsg.FreeWifi.Protocol32UI");
        dMF.dFe = m.axO("MicroMsg.FreeWifi.Protocol32UI");
        dMF.dFd = this.dFd;
        dMF.wNb = this.dNI;
        dMF.quX = m.aw(this.intent);
        dMF.wNc = m.ay(this.intent);
        dMF.wNd = k.b.ThreeTwoAuth.wNO;
        dMF.wNe = k.b.ThreeTwoAuth.name;
        dMF.result = i2;
        dMF.resultMsg = str;
        dMF.channel = m.az(this.intent);
        dMF.wNf = this.appUserName;
        dMF.dMH().dMG();
        AppMethodBeat.o(25264);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(25265);
        super.onDestroy();
        if (this.wQU != null) {
            j.dNn().remove(this.wQU);
        }
        this.wTa.stopTimer();
        j.dNq().release();
        AppMethodBeat.o(25265);
    }

    static /* synthetic */ void c(ProtocolThreeTwoUI protocolThreeTwoUI) {
        AppMethodBeat.i(25268);
        Log.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=connectSsid, desc=it starts to connect ssid. ssid=%s", m.aw(protocolThreeTwoUI.getIntent()), Integer.valueOf(m.ax(protocolThreeTwoUI.getIntent())), protocolThreeTwoUI.ssid);
        protocolThreeTwoUI.wPE.a(new a.AbstractC1368a() {
            /* class com.tencent.mm.plugin.freewifi.ui.ProtocolThreeTwoUI.AnonymousClass9 */

            @Override // com.tencent.mm.plugin.freewifi.a.AbstractC1368a
            public final void onSuccess() {
                AppMethodBeat.i(25249);
                k.a dMF = k.dMF();
                dMF.ssid = ProtocolThreeTwoUI.this.ssid;
                dMF.bssid = m.axN("MicroMsg.FreeWifi.Protocol32UI");
                dMF.dFe = m.axO("MicroMsg.FreeWifi.Protocol32UI");
                dMF.dFd = ProtocolThreeTwoUI.this.dFd;
                dMF.wNb = ProtocolThreeTwoUI.this.dNI;
                dMF.quX = m.aw(ProtocolThreeTwoUI.this.intent);
                dMF.wNc = m.ay(ProtocolThreeTwoUI.this.intent);
                dMF.wNd = k.b.AddNetwork.wNO;
                dMF.wNe = k.b.AddNetwork.name;
                dMF.result = 0;
                dMF.channel = m.az(ProtocolThreeTwoUI.this.intent);
                dMF.wNf = ProtocolThreeTwoUI.this.appUserName;
                dMF.dMH().dMG();
                final String dMC = h.b.wMW.dMC();
                Log.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=connect, desc=An attempt to connect to ssid succeeded and then tries to access blackUrl. ssid=%s, blackUrl = %s", m.aw(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(m.ax(ProtocolThreeTwoUI.this.getIntent())), ProtocolThreeTwoUI.this.ssid, dMC);
                AnonymousClass1 r1 = new a.AbstractC1369a() {
                    /* class com.tencent.mm.plugin.freewifi.ui.ProtocolThreeTwoUI.AnonymousClass9.AnonymousClass1 */
                    int wPW = 0;
                    private final int wPX = 3;
                    private int wPY = 0;
                    private a.AbstractC1369a wPZ = new a.AbstractC1369a() {
                        /* class com.tencent.mm.plugin.freewifi.ui.ProtocolThreeTwoUI.AnonymousClass9.AnonymousClass1.AnonymousClass1 */

                        @Override // com.tencent.mm.plugin.freewifi.a.a.AbstractC1369a
                        public final void d(HttpURLConnection httpURLConnection) {
                            AppMethodBeat.i(25242);
                            int responseCode = httpURLConnection.getResponseCode();
                            if (responseCode == 200) {
                                Log.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.black, desc=it still cannot get authurl and extend (now http returns 200), so it fails to connect wifi. ", m.aw(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(m.ax(ProtocolThreeTwoUI.this.getIntent())));
                                d.a(ProtocolThreeTwoUI.this.ssid, 3, ProtocolThreeTwoUI.this.getIntent());
                                ProtocolThreeTwoUI.a(ProtocolThreeTwoUI.this, 35, "CANNOT_GET_AUTHURL_AFTER_BLACK_URL");
                                AppMethodBeat.o(25242);
                            } else if (responseCode == 302) {
                                AnonymousClass1.a(AnonymousClass1.this, httpURLConnection.getHeaderField("Location"));
                                AppMethodBeat.o(25242);
                            } else {
                                Log.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.black, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", m.aw(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(m.ax(ProtocolThreeTwoUI.this.getIntent())));
                                d.a(ProtocolThreeTwoUI.this.ssid, 3, ProtocolThreeTwoUI.this.getIntent());
                                ProtocolThreeTwoUI.a(ProtocolThreeTwoUI.this, 32, "INVALID_HTTP_RESP_CODE");
                                AppMethodBeat.o(25242);
                            }
                        }

                        @Override // com.tencent.mm.plugin.freewifi.a.a.AbstractC1369a
                        public final void o(Exception exc) {
                            AppMethodBeat.i(25243);
                            Log.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.black, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s", m.aw(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(m.ax(ProtocolThreeTwoUI.this.getIntent())), exc.getMessage());
                            d.a(ProtocolThreeTwoUI.this.ssid, 3, ProtocolThreeTwoUI.this.getIntent());
                            ProtocolThreeTwoUI.a(ProtocolThreeTwoUI.this, 101, m.l(exc));
                            AppMethodBeat.o(25243);
                        }
                    };

                    {
                        AppMethodBeat.i(25244);
                        AppMethodBeat.o(25244);
                    }

                    static /* synthetic */ void a(AnonymousClass1 r1, String str) {
                        AppMethodBeat.i(25248);
                        r1.axX(str);
                        AppMethodBeat.o(25248);
                    }

                    @Override // com.tencent.mm.plugin.freewifi.a.a.AbstractC1369a
                    public final void d(HttpURLConnection httpURLConnection) {
                        AppMethodBeat.i(25245);
                        int responseCode = httpURLConnection.getResponseCode();
                        if (responseCode == 200) {
                            Log.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=Access to blackurl returns 200 directly, so we believe that the device is already authenticated. Authentication ended.", m.aw(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(m.ax(ProtocolThreeTwoUI.this.getIntent())));
                            ProtocolThreeTwoUI.f(ProtocolThreeTwoUI.this);
                            AppMethodBeat.o(25245);
                        } else if (responseCode == 302) {
                            axX(httpURLConnection.getHeaderField("Location"));
                            AppMethodBeat.o(25245);
                        } else {
                            Log.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", m.aw(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(m.ax(ProtocolThreeTwoUI.this.getIntent())));
                            d.a(ProtocolThreeTwoUI.this.ssid, 3, ProtocolThreeTwoUI.this.getIntent());
                            ProtocolThreeTwoUI.a(ProtocolThreeTwoUI.this, 32, "INVALID_HTTP_RESP_CODE");
                            AppMethodBeat.o(25245);
                        }
                    }

                    @Override // com.tencent.mm.plugin.freewifi.a.a.AbstractC1369a
                    public final void o(Exception exc) {
                        AppMethodBeat.i(25246);
                        Log.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s", m.aw(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(m.ax(ProtocolThreeTwoUI.this.getIntent())), exc.getMessage());
                        if (exc instanceof UnknownHostException) {
                            ProtocolThreeTwoUI.a(ProtocolThreeTwoUI.this, 102, m.l(exc));
                            int i2 = this.wPW + 1;
                            this.wPW = i2;
                            if (i2 <= 3) {
                                try {
                                    Thread.sleep(3000);
                                    com.tencent.mm.plugin.freewifi.a.a.dMN();
                                    com.tencent.mm.plugin.freewifi.a.a.a(dMC, this);
                                    AppMethodBeat.o(25246);
                                } catch (InterruptedException e2) {
                                    AppMethodBeat.o(25246);
                                }
                            } else {
                                d.a(ProtocolThreeTwoUI.this.ssid, 3, ProtocolThreeTwoUI.this.getIntent());
                                ProtocolThreeTwoUI.a(ProtocolThreeTwoUI.this, 101, m.l(exc));
                                AppMethodBeat.o(25246);
                            }
                        } else {
                            d.a(ProtocolThreeTwoUI.this.ssid, 3, ProtocolThreeTwoUI.this.getIntent());
                            ProtocolThreeTwoUI.a(ProtocolThreeTwoUI.this, 101, m.l(exc));
                            AppMethodBeat.o(25246);
                        }
                    }

                    private void axX(String str) {
                        AppMethodBeat.i(25247);
                        Uri parse = Uri.parse(str);
                        String queryParameter = parse.getQueryParameter("authUrl");
                        String axL = m.axL(parse.getQueryParameter("extend"));
                        Log.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=Access to blackUrl returns 302 and now trying to  get authurl and extend from location. location=%s, authUrl=%s, extend=%s", m.aw(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(m.ax(ProtocolThreeTwoUI.this.getIntent())), str, queryParameter, axL);
                        if (m.eP(queryParameter)) {
                            this.wPY++;
                            if (this.wPY < 3) {
                                com.tencent.mm.plugin.freewifi.a.a.dMN();
                                com.tencent.mm.plugin.freewifi.a.a.a(str, this.wPZ);
                                AppMethodBeat.o(25247);
                                return;
                            }
                            Log.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=Connection fail. Too many 302, exceeding 3 times", m.aw(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(m.ax(ProtocolThreeTwoUI.this.getIntent())));
                            d.a(ProtocolThreeTwoUI.this.ssid, 3, ProtocolThreeTwoUI.this.getIntent());
                            ProtocolThreeTwoUI.a(ProtocolThreeTwoUI.this, 36, "BLACK_302_TIMES_EXCESS");
                            AppMethodBeat.o(25247);
                            return;
                        }
                        StringBuilder sb = new StringBuilder(queryParameter);
                        if (queryParameter.indexOf("?") != -1) {
                            sb.append("&extend=").append(axL);
                        } else {
                            sb.append("?extend=").append(axL);
                        }
                        sb.append("&openId=").append(m.axL(ProtocolThreeTwoUI.this.openId)).append("&tid=").append(m.axL(ProtocolThreeTwoUI.this.wPU)).append("&timestamp=").append(ProtocolThreeTwoUI.this.dmc).append("&sign=").append(ProtocolThreeTwoUI.this.sign);
                        ProtocolThreeTwoUI.a(ProtocolThreeTwoUI.this, sb.toString());
                        AppMethodBeat.o(25247);
                    }
                };
                com.tencent.mm.plugin.freewifi.a.a.dMN();
                com.tencent.mm.plugin.freewifi.a.a.a(dMC, r1);
                AppMethodBeat.o(25249);
            }

            @Override // com.tencent.mm.plugin.freewifi.a.AbstractC1368a
            public final void onFail(int i2) {
                AppMethodBeat.i(25250);
                Log.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=connect, desc=An attempt to connect to ssid failed. ssid=%s, errCode=%d", m.aw(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(m.ax(ProtocolThreeTwoUI.this.getIntent())), ProtocolThreeTwoUI.this.ssid, Integer.valueOf(i2));
                d.a(ProtocolThreeTwoUI.this.ssid, 3, ProtocolThreeTwoUI.this.getIntent());
                k.a dMF = k.dMF();
                dMF.ssid = ProtocolThreeTwoUI.this.ssid;
                dMF.bssid = m.axN("MicroMsg.FreeWifi.Protocol32UI");
                dMF.dFe = m.axO("MicroMsg.FreeWifi.Protocol32UI");
                dMF.dFd = ProtocolThreeTwoUI.this.dFd;
                dMF.wNb = ProtocolThreeTwoUI.this.dNI;
                dMF.quX = m.aw(ProtocolThreeTwoUI.this.intent);
                dMF.wNc = m.ay(ProtocolThreeTwoUI.this.intent);
                dMF.wNd = k.b.AddNetwork.wNO;
                dMF.wNe = k.b.AddNetwork.name;
                dMF.result = i2;
                dMF.channel = m.az(ProtocolThreeTwoUI.this.intent);
                dMF.wNf = ProtocolThreeTwoUI.this.appUserName;
                dMF.dMH().dMG();
                AppMethodBeat.o(25250);
            }
        });
        AppMethodBeat.o(25268);
    }

    static /* synthetic */ void f(ProtocolThreeTwoUI protocolThreeTwoUI) {
        AppMethodBeat.i(25269);
        protocolThreeTwoUI.bt(0, "");
        j.dNq().dMZ().post(new Runnable() {
            /* class com.tencent.mm.plugin.freewifi.ui.ProtocolThreeTwoUI.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(25235);
                String dNb = d.dNb();
                String dNf = d.dNf();
                int dNc = d.dNc();
                Log.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.getBackPageInfoAfterConnectSuccess, desc=it starts net request [apauth.getBackPage]  for backpage info. fullUrl=%s, nowApMac=%s, nowNetworkSSID=%s, rssi=%d", m.aw(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(m.ax(ProtocolThreeTwoUI.this.getIntent())), ProtocolThreeTwoUI.this.pFJ, dNb, dNf, Integer.valueOf(dNc));
                new com.tencent.mm.plugin.freewifi.d.a(ProtocolThreeTwoUI.this.pFJ, dNb, dNf, dNc, ProtocolThreeTwoUI.this.channelId, m.aw(ProtocolThreeTwoUI.this.getIntent())).c(new i() {
                    /* class com.tencent.mm.plugin.freewifi.ui.ProtocolThreeTwoUI.AnonymousClass2.AnonymousClass1 */

                    @Override // com.tencent.mm.ak.i
                    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
                        AppMethodBeat.i(25234);
                        Log.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getA8Key.callback, desc=net request [apauth.getBackPage] returns. errType=%d, errCode=%d, errMsg=%s", m.aw(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(m.ax(ProtocolThreeTwoUI.this.getIntent())), Integer.valueOf(i2), Integer.valueOf(i3), str);
                        if (i2 == 0 && i3 == 0) {
                            if (!(qVar instanceof com.tencent.mm.plugin.freewifi.d.a)) {
                                AppMethodBeat.o(25234);
                                return;
                            }
                            ih dNz = ((com.tencent.mm.plugin.freewifi.d.a) qVar).dNz();
                            if (dNz != null) {
                                Log.i("MicroMsg.FreeWifi.Protocol32UI", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s", dNz.KGX, dNz.oUJ, dNz.UserName, Integer.valueOf(dNz.KMt), dNz.KMu, dNz.keb);
                                ProtocolThreeTwoUI.this.dNI = dNz.KGX;
                                ProtocolThreeTwoUI.this.wPA = dNz.oUJ;
                                ProtocolThreeTwoUI.this.appUserName = dNz.UserName;
                                ProtocolThreeTwoUI.this.wSD = dNz.KMt;
                                ProtocolThreeTwoUI.this.wSE = dNz.KMu;
                                ProtocolThreeTwoUI.this.signature = dNz.keb;
                                ProtocolThreeTwoUI.this.wSF = dNz.KMv;
                                Log.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getBackPageInfoAfterConnectSuccess, desc=net request [apauth.getBackPage] gets response. backpageinfo:  appid: %s, appNickName: %s, appUserName: %s, finishActionCode: %s, finishUrl: %s, signature: %s, qingHuaiPageUrl: %s", m.aw(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(m.ax(ProtocolThreeTwoUI.this.getIntent())), ProtocolThreeTwoUI.this.dNI, ProtocolThreeTwoUI.this.wPA, ProtocolThreeTwoUI.this.appUserName, Integer.valueOf(ProtocolThreeTwoUI.this.wSD), ProtocolThreeTwoUI.this.wSE, ProtocolThreeTwoUI.this.signature, ProtocolThreeTwoUI.this.wSF);
                            }
                            d.a(ProtocolThreeTwoUI.this.ssid, 2, ProtocolThreeTwoUI.this.getIntent());
                            Log.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.initModel, desc=it changes the connect state of the model to CONNECT_STATE_CONNECT_SUCCESS. state=%d", m.aw(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(m.ax(ProtocolThreeTwoUI.this.getIntent())), 2);
                        }
                        AppMethodBeat.o(25234);
                    }
                });
                AppMethodBeat.o(25235);
            }
        });
        AppMethodBeat.o(25269);
    }

    static /* synthetic */ void a(ProtocolThreeTwoUI protocolThreeTwoUI, final String str) {
        AppMethodBeat.i(25270);
        j.dNq().dMZ().post(new Runnable() {
            /* class com.tencent.mm.plugin.freewifi.ui.ProtocolThreeTwoUI.AnonymousClass10 */

            public final void run() {
                AppMethodBeat.i(25253);
                Log.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.httpAuthentication, desc=it sends http request for authentication. http url=%s", m.aw(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(m.ax(ProtocolThreeTwoUI.this.getIntent())), str);
                com.tencent.mm.plugin.freewifi.a.a.dMN();
                com.tencent.mm.plugin.freewifi.a.a.a(str, new a.AbstractC1369a() {
                    /* class com.tencent.mm.plugin.freewifi.ui.ProtocolThreeTwoUI.AnonymousClass10.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.freewifi.a.a.AbstractC1369a
                    public final void d(HttpURLConnection httpURLConnection) {
                        AppMethodBeat.i(25251);
                        int responseCode = httpURLConnection.getResponseCode();
                        Log.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.HttpAuthentication.onSuccess, desc=it receives http response for authentication. http response status code=%d", m.aw(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(m.ax(ProtocolThreeTwoUI.this.getIntent())), Integer.valueOf(responseCode));
                        if (responseCode == 200) {
                            ProtocolThreeTwoUI.f(ProtocolThreeTwoUI.this);
                            AppMethodBeat.o(25251);
                        } else if (responseCode == 302) {
                            ProtocolThreeTwoUI.b(ProtocolThreeTwoUI.this, httpURLConnection.getHeaderField("Location"));
                            AppMethodBeat.o(25251);
                        } else {
                            Log.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.httpAuthentication, desc=http response status code is neither 200 nor 302, so it fs to connect wifi. ", m.aw(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(m.ax(ProtocolThreeTwoUI.this.getIntent())));
                            d.a(ProtocolThreeTwoUI.this.ssid, 3, ProtocolThreeTwoUI.this.getIntent());
                            ProtocolThreeTwoUI.a(ProtocolThreeTwoUI.this, 32, "INVALID_HTTP_RESP_CODE");
                            AppMethodBeat.o(25251);
                        }
                    }

                    @Override // com.tencent.mm.plugin.freewifi.a.a.AbstractC1369a
                    public final void o(Exception exc) {
                        AppMethodBeat.i(25252);
                        Log.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.httpAuthentication, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s", m.aw(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(m.ax(ProtocolThreeTwoUI.this.getIntent())), exc.getMessage());
                        d.a(ProtocolThreeTwoUI.this.ssid, 3, ProtocolThreeTwoUI.this.getIntent());
                        ProtocolThreeTwoUI.a(ProtocolThreeTwoUI.this, 101, m.l(exc));
                        AppMethodBeat.o(25252);
                    }
                });
                AppMethodBeat.o(25253);
            }
        });
        AppMethodBeat.o(25270);
    }

    static /* synthetic */ void b(ProtocolThreeTwoUI protocolThreeTwoUI, String str) {
        AppMethodBeat.i(25271);
        protocolThreeTwoUI.wPK++;
        if (protocolThreeTwoUI.wPK > 3) {
            Log.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication, desc=Connection fail. Too many 302, exceeding 3 times", m.aw(protocolThreeTwoUI.getIntent()), Integer.valueOf(m.ax(protocolThreeTwoUI.getIntent())));
            d.a(protocolThreeTwoUI.ssid, 3, protocolThreeTwoUI.getIntent());
            protocolThreeTwoUI.bt(33, "AUTH_302_TIMES_EXCESS");
            AppMethodBeat.o(25271);
            return;
        }
        Log.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication, desc=it discovers 302 Location and redirects. http response header Location=%s", m.aw(protocolThreeTwoUI.getIntent()), Integer.valueOf(m.ax(protocolThreeTwoUI.getIntent())), str);
        if (m.eP(str)) {
            d.a(protocolThreeTwoUI.ssid, 3, protocolThreeTwoUI.getIntent());
            protocolThreeTwoUI.bt(34, "EMPTY_AUTH_LOCATION");
            AppMethodBeat.o(25271);
            return;
        }
        AnonymousClass11 r0 = new a.AbstractC1369a() {
            /* class com.tencent.mm.plugin.freewifi.ui.ProtocolThreeTwoUI.AnonymousClass11 */

            @Override // com.tencent.mm.plugin.freewifi.a.a.AbstractC1369a
            public final void d(HttpURLConnection httpURLConnection) {
                AppMethodBeat.i(25254);
                int responseCode = httpURLConnection.getResponseCode();
                Log.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication.onSuccess, desc=it receives http response for authentication(after 302). http response status code=%d", m.aw(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(m.ax(ProtocolThreeTwoUI.this.getIntent())), Integer.valueOf(responseCode));
                if (responseCode == 200) {
                    ProtocolThreeTwoUI.f(ProtocolThreeTwoUI.this);
                    AppMethodBeat.o(25254);
                } else if (responseCode == 302) {
                    ProtocolThreeTwoUI.b(ProtocolThreeTwoUI.this, httpURLConnection.getHeaderField("Location"));
                    AppMethodBeat.o(25254);
                } else {
                    Log.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication, desc=http response status code is not 200, so it fails to connect wifi. ", m.aw(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(m.ax(ProtocolThreeTwoUI.this.getIntent())));
                    d.a(ProtocolThreeTwoUI.this.ssid, 3, ProtocolThreeTwoUI.this.getIntent());
                    ProtocolThreeTwoUI.a(ProtocolThreeTwoUI.this, 32, "INVALID_HTTP_RESP_CODE");
                    AppMethodBeat.o(25254);
                }
            }

            @Override // com.tencent.mm.plugin.freewifi.a.a.AbstractC1369a
            public final void o(Exception exc) {
                AppMethodBeat.i(25255);
                Log.e("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication.onException, desc=exception happens during http. e.getMessage()=%s", m.aw(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(m.ax(ProtocolThreeTwoUI.this.getIntent())), exc.getMessage());
                ProtocolThreeTwoUI.a(ProtocolThreeTwoUI.this, 101, m.l(exc));
                AppMethodBeat.o(25255);
            }
        };
        Uri parse = Uri.parse(str);
        if ("post".equalsIgnoreCase(parse.getQueryParameter(FirebaseAnalytics.b.METHOD))) {
            com.tencent.mm.plugin.freewifi.a.a.dMN();
            com.tencent.mm.plugin.freewifi.a.a.a(str, parse.getEncodedQuery(), r0);
            AppMethodBeat.o(25271);
            return;
        }
        com.tencent.mm.plugin.freewifi.a.a.dMN();
        com.tencent.mm.plugin.freewifi.a.a.a(str, r0);
        AppMethodBeat.o(25271);
    }
}
