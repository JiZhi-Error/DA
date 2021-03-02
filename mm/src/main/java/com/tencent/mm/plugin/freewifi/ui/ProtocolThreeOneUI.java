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
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.freewifi.a.a;
import com.tencent.mm.plugin.freewifi.g;
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

@Deprecated
public class ProtocolThreeOneUI extends MMActivity {
    protected String appUserName;
    protected int channelId;
    private String dFd;
    private int dHO = 1;
    private String dHx;
    protected String dNI;
    protected String iAR;
    private Intent intent;
    private boolean isTimeout = false;
    private final c jaR;
    protected String pFJ;
    protected String signature;
    protected int source;
    protected String ssid;
    protected String wPA;
    private String wPJ;
    private int wPK = 0;
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
        /* class com.tencent.mm.plugin.freewifi.ui.ProtocolThreeOneUI.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(25181);
            if (!Util.isNullOrNil(ProtocolThreeOneUI.this.ssid)) {
                ProtocolThreeOneUI.this.dHO = ProtocolThreeOneUI.this.dNP();
                if (ProtocolThreeOneUI.this.dHO != 2) {
                    ProtocolThreeOneUI.this.isTimeout = true;
                    Log.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.connectTimeoutHandler, desc=wifi connecttimeout. state=%s", m.aw(ProtocolThreeOneUI.this.getIntent()), Integer.valueOf(m.ax(ProtocolThreeOneUI.this.getIntent())), d.Ne(ProtocolThreeOneUI.this.dHO));
                    d.a(ProtocolThreeOneUI.this.ssid, 3, ProtocolThreeOneUI.this.getIntent());
                    ProtocolThreeOneUI.a(ProtocolThreeOneUI.this, 31, "AUTH_TIMEOUT");
                }
            }
            AppMethodBeat.o(25181);
            return false;
        }
    }, false);

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ProtocolThreeOneUI() {
        AppMethodBeat.i(25194);
        c.a aVar = new c.a();
        aVar.jbd = true;
        aVar.jbe = true;
        aVar.jbq = R.drawable.bdo;
        aVar.iaT = true;
        aVar.jbx = 0.0f;
        this.jaR = aVar.bdv();
        AppMethodBeat.o(25194);
    }

    static /* synthetic */ void a(ProtocolThreeOneUI protocolThreeOneUI, int i2, String str) {
        AppMethodBeat.i(25204);
        protocolThreeOneUI.bt(i2, str);
        AppMethodBeat.o(25204);
    }

    static /* synthetic */ void c(ProtocolThreeOneUI protocolThreeOneUI) {
        AppMethodBeat.i(25205);
        protocolThreeOneUI.goBack();
        AppMethodBeat.o(25205);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        boolean z;
        AppMethodBeat.i(25195);
        super.onCreate(bundle);
        this.intent = getIntent();
        this.dFd = getIntent().getStringExtra("free_wifi_ap_key");
        this.dHx = getIntent().getStringExtra("free_wifi_schema_ticket");
        this.wPJ = getIntent().getStringExtra("free_wifi_portal_ap_info_authurl_with_params");
        Log.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.onCreate, desc=it goes into Protocol31 connect frontpage. apKey=%s, ticket=%s", m.aw(getIntent()), Integer.valueOf(m.ax(getIntent())), this.dFd, this.dHx);
        initView();
        if (Util.isNullOrNil(this.ssid)) {
            Log.e("MicroMsg.FreeWifi.Protocol31UI", "ssid is null");
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
            aya.field_wifiType = 3;
            aya.field_connectState = 1;
            if (z) {
                j.dNn().insert(aya);
            } else {
                j.dNn().update(aya, new String[0]);
            }
            Log.i("MicroMsg.FreeWifi.Protocol31UI", "ssid : %s, mid : %s, source : %d", this.ssid, this.wQO, Integer.valueOf(this.source));
            this.wQU = new MStorage.IOnStorageChange() {
                /* class com.tencent.mm.plugin.freewifi.ui.ProtocolThreeOneUI.AnonymousClass5 */
                private int wSH = -999999999;

                @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
                public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
                    AppMethodBeat.i(25185);
                    ProtocolThreeOneUI.this.dHO = ProtocolThreeOneUI.this.dNP();
                    if (this.wSH != ProtocolThreeOneUI.this.dHO) {
                        this.wSH = ProtocolThreeOneUI.this.dHO;
                        ProtocolThreeOneUI.this.Ng(ProtocolThreeOneUI.this.dHO);
                    }
                    AppMethodBeat.o(25185);
                }
            };
            j.dNn().add(this.wQU);
            Log.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.initModel, desc=Initializing the model behind the view, so anything that changes the model will notify the view. model : field_ssidmd5=%s, field_ssid=%s, field_url=%s, field_mid=%s, field_wifiType=%d, field_connectState=%d", m.aw(getIntent()), Integer.valueOf(m.ax(getIntent())), aya.field_ssidmd5, aya.field_ssid, aya.field_url, aya.field_mid, Integer.valueOf(aya.field_wifiType), Integer.valueOf(aya.field_connectState));
            Log.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.initModel, desc=it initializes the front page. ", m.aw(getIntent()), Integer.valueOf(m.ax(getIntent())));
            d.a(this.ssid, 4, getIntent());
        }
        l.Q(d.dNe(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
        AppMethodBeat.o(25195);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(25196);
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
        Log.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.initView, desc=Initializing the view. ssid=%s, mid=%s, fullUrl=%s, source=%d, channel=%d, appid=%s, headImgUrl=%s, welcomeMsg=%s, privacyUrl=%s", m.aw(getIntent()), Integer.valueOf(m.ax(getIntent())), this.ssid, this.wQO, this.pFJ, Integer.valueOf(this.source), Integer.valueOf(this.channelId), this.dNI, this.iAR, this.wRC, this.wRE);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.freewifi.ui.ProtocolThreeOneUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(25182);
                ProtocolThreeOneUI.c(ProtocolThreeOneUI.this);
                AppMethodBeat.o(25182);
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
            /* class com.tencent.mm.plugin.freewifi.ui.ProtocolThreeOneUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(25183);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/freewifi/ui/ProtocolThreeOneUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                l.R(d.dNe(), ProtocolThreeOneUI.this.getIntent().getStringExtra("free_wifi_ap_key"), ProtocolThreeOneUI.this.getIntent().getIntExtra("free_wifi_protocol_type", 0));
                int dNP = ProtocolThreeOneUI.this.dNP();
                Log.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.connectWifiBtn.setOnClickListener, desc=User click the connect button and starts the connect wifi process. state=%s", m.aw(ProtocolThreeOneUI.this.getIntent()), Integer.valueOf(m.ax(ProtocolThreeOneUI.this.getIntent())), d.Ne(dNP));
                if (dNP == 2) {
                    ProtocolThreeOneUI.this.finish();
                } else {
                    d.a(ProtocolThreeOneUI.this.ssid, 1, ProtocolThreeOneUI.this.getIntent());
                    ProtocolThreeOneUI.this.connect();
                }
                a.a(this, "com/tencent/mm/plugin/freewifi/ui/ProtocolThreeOneUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(25183);
            }
        });
        this.wRz = (Button) findViewById(R.id.j1n);
        this.wRz.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.freewifi.ui.ProtocolThreeOneUI.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(25184);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/freewifi/ui/ProtocolThreeOneUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent();
                intent.putExtra("rawUrl", ProtocolThreeOneUI.this.wRE);
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                com.tencent.mm.br.c.b(ProtocolThreeOneUI.this.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                a.a(this, "com/tencent/mm/plugin/freewifi/ui/ProtocolThreeOneUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(25184);
            }
        });
        if (Util.isNullOrNil(this.ssid)) {
            this.wRx.setText(getString(R.string.din));
            this.wRy.setVisibility(4);
        }
        setMMTitle(getString(R.string.dip));
        AppMethodBeat.o(25196);
    }

    /* access modifiers changed from: protected */
    public final void connect() {
        AppMethodBeat.i(25197);
        this.dHO = dNP();
        Log.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.connect, desc=it starts connecting wifi by protocol 3.1. current connect state=%s", m.aw(getIntent()), Integer.valueOf(m.ax(getIntent())), d.Ne(this.dHO));
        if (this.dHO != 2) {
            this.wTa.startTimer(15000);
            Log.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.connect, desc=it starts connectTimeoutHandler. timeout=%d s", m.aw(getIntent()), Integer.valueOf(m.ax(getIntent())), 60);
            final String str = this.wPJ;
            j.dNq().dMZ().post(new Runnable() {
                /* class com.tencent.mm.plugin.freewifi.ui.ProtocolThreeOneUI.AnonymousClass6 */

                public final void run() {
                    AppMethodBeat.i(25188);
                    Log.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.httpAuthentication, desc=it sends http request for authentication. http url=%s", m.aw(ProtocolThreeOneUI.this.getIntent()), Integer.valueOf(m.ax(ProtocolThreeOneUI.this.getIntent())), str);
                    com.tencent.mm.plugin.freewifi.a.a.dMN();
                    com.tencent.mm.plugin.freewifi.a.a.a(str, new a.AbstractC1369a() {
                        /* class com.tencent.mm.plugin.freewifi.ui.ProtocolThreeOneUI.AnonymousClass6.AnonymousClass1 */

                        @Override // com.tencent.mm.plugin.freewifi.a.a.AbstractC1369a
                        public final void d(HttpURLConnection httpURLConnection) {
                            AppMethodBeat.i(25186);
                            int responseCode = httpURLConnection.getResponseCode();
                            Log.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.HttpAuthentication.onSuccess, desc=it receives http response for authentication. http response status code=%d", m.aw(ProtocolThreeOneUI.this.getIntent()), Integer.valueOf(m.ax(ProtocolThreeOneUI.this.getIntent())), Integer.valueOf(responseCode));
                            if (ProtocolThreeOneUI.this.isTimeout) {
                                AppMethodBeat.o(25186);
                            } else if (responseCode == 200) {
                                ProtocolThreeOneUI.e(ProtocolThreeOneUI.this);
                                AppMethodBeat.o(25186);
                            } else if (responseCode == 302) {
                                ProtocolThreeOneUI.a(ProtocolThreeOneUI.this, httpURLConnection.getHeaderField("Location"));
                                AppMethodBeat.o(25186);
                            } else {
                                Log.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.httpAuthentication, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", m.aw(ProtocolThreeOneUI.this.getIntent()), Integer.valueOf(m.ax(ProtocolThreeOneUI.this.getIntent())));
                                d.a(ProtocolThreeOneUI.this.ssid, 3, ProtocolThreeOneUI.this.getIntent());
                                ProtocolThreeOneUI.a(ProtocolThreeOneUI.this, 32, "INVALID_HTTP_RESP_CODE");
                                AppMethodBeat.o(25186);
                            }
                        }

                        @Override // com.tencent.mm.plugin.freewifi.a.a.AbstractC1369a
                        public final void o(Exception exc) {
                            AppMethodBeat.i(25187);
                            Log.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.httpAuthentication, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s", m.aw(ProtocolThreeOneUI.this.getIntent()), Integer.valueOf(m.ax(ProtocolThreeOneUI.this.getIntent())), exc.getMessage());
                            d.a(ProtocolThreeOneUI.this.ssid, 3, ProtocolThreeOneUI.this.getIntent());
                            ProtocolThreeOneUI.a(ProtocolThreeOneUI.this, 101, m.l(exc));
                            AppMethodBeat.o(25187);
                        }
                    });
                    AppMethodBeat.o(25188);
                }
            });
            AppMethodBeat.o(25197);
            return;
        }
        d.a(this.ssid, 2, getIntent());
        AppMethodBeat.o(25197);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* access modifiers changed from: protected */
    public final void Ng(int i2) {
        AppMethodBeat.i(25198);
        Log.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.onConnectStateChange, desc=it receives notifications whenever the connect state of model changes and then updates the view accordingly. state=%d", m.aw(getIntent()), Integer.valueOf(m.ax(getIntent())), Integer.valueOf(i2));
        switch (i2) {
            case 1:
                this.wRh.setVisibility(4);
                this.wRy.setText(R.string.b9i);
                this.wSy = h.a((Context) getContext(), getString(R.string.b9i), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                    /* class com.tencent.mm.plugin.freewifi.ui.ProtocolThreeOneUI.AnonymousClass9 */

                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(25193);
                        d.a(ProtocolThreeOneUI.this.ssid, 4, ProtocolThreeOneUI.this.getIntent());
                        Log.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.toConnecting.ProgressDlg.onCancel, desc=it changes the connect state of the model to CONNECT_STATE_WAIT_START because the user cancles the connect process in progress. state=%d", m.aw(ProtocolThreeOneUI.this.getIntent()), Integer.valueOf(m.ax(ProtocolThreeOneUI.this.getIntent())), 4);
                        AppMethodBeat.o(25193);
                    }
                });
                Log.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.toConnecting, desc=it adds a loading ui on the connect front page.", m.aw(getIntent()), Integer.valueOf(m.ax(getIntent())));
                AppMethodBeat.o(25198);
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
                com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/freewifi/ui/ProtocolThreeOneUI", "toSuccess", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/freewifi/ui/ProtocolThreeOneUI", "toSuccess", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                c.report();
                Log.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.toSuccess, desc=connect succeeded.", m.aw(getIntent()), Integer.valueOf(m.ax(getIntent())));
                break;
            case 3:
                if (this.wSy != null) {
                    this.wSy.dismiss();
                }
                this.wTa.stopTimer();
                this.wRh.setVisibility(0);
                this.wRy.setText(R.string.dil);
                Log.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.toFail, desc=connect failed.", m.aw(getIntent()), Integer.valueOf(m.ax(getIntent())));
                AppMethodBeat.o(25198);
                return;
            case 4:
                if (this.wSy != null) {
                    this.wSy.dismiss();
                }
                this.wTa.stopTimer();
                this.wRh.setVisibility(4);
                this.wRy.setText(R.string.b9l);
                if (m.az(getIntent()) == 10 && !m.eP(ae.gKy.gJB) && !m.eP(ae.cu(getContext()))) {
                    this.wRy.setText(String.format(getString(R.string.dhj), ae.cu(getContext())));
                }
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
                Log.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.toConnectStart, desc=it initializes the connect front page.", m.aw(getIntent()), Integer.valueOf(m.ax(getIntent())));
                AppMethodBeat.o(25198);
                return;
        }
        AppMethodBeat.o(25198);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.ami;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(25199);
        if (i2 == 4 && keyEvent.getRepeatCount() == 0) {
            goBack();
            AppMethodBeat.o(25199);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(25199);
        return onKeyDown;
    }

    private void goBack() {
        AppMethodBeat.i(25200);
        l.S(d.dNe(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
        g.jRt.h(new Intent(), this);
        finish();
        AppMethodBeat.o(25200);
    }

    /* access modifiers changed from: protected */
    public final int dNP() {
        AppMethodBeat.i(25201);
        if (Util.isNullOrNil(this.ssid)) {
            Log.d("MicroMsg.FreeWifi.Protocol31UI", "Illegal SSID");
            AppMethodBeat.o(25201);
            return 0;
        }
        com.tencent.mm.plugin.freewifi.g.c aya = j.dNn().aya(this.ssid);
        if (aya == null || !aya.field_ssid.equalsIgnoreCase(this.ssid)) {
            AppMethodBeat.o(25201);
            return 0;
        }
        int i2 = aya.field_connectState;
        AppMethodBeat.o(25201);
        return i2;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    private void bt(int i2, String str) {
        AppMethodBeat.i(25202);
        k.a dMF = k.dMF();
        dMF.ssid = this.ssid;
        dMF.bssid = m.axN("MicroMsg.FreeWifi.Protocol31UI");
        dMF.dFe = m.axO("MicroMsg.FreeWifi.Protocol31UI");
        dMF.dFd = this.dFd;
        dMF.wNb = this.dNI;
        dMF.quX = m.aw(this.intent);
        dMF.wNc = m.ay(this.intent);
        dMF.wNd = k.b.ThreeOneAuth.wNO;
        dMF.wNe = k.b.ThreeOneAuth.name;
        dMF.result = i2;
        dMF.resultMsg = str;
        dMF.channel = m.az(this.intent);
        dMF.wNf = this.appUserName;
        dMF.dMH().dMG();
        AppMethodBeat.o(25202);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(25203);
        super.onDestroy();
        if (this.wQU != null) {
            j.dNn().remove(this.wQU);
        }
        this.wTa.stopTimer();
        j.dNq().release();
        AppMethodBeat.o(25203);
    }

    static /* synthetic */ void e(ProtocolThreeOneUI protocolThreeOneUI) {
        AppMethodBeat.i(25206);
        protocolThreeOneUI.bt(0, "");
        j.dNq().dMZ().post(new Runnable() {
            /* class com.tencent.mm.plugin.freewifi.ui.ProtocolThreeOneUI.AnonymousClass8 */

            public final void run() {
                AppMethodBeat.i(25192);
                String dNb = d.dNb();
                String dNf = d.dNf();
                int dNc = d.dNc();
                Log.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.getBackPageInfoAfterConnectSuccess, desc=it starts net request [apauth.getBackPage]  for backpage info. fullUrl=%s, nowApMac=%s, nowNetworkSSID=%s, rssi=%d", m.aw(ProtocolThreeOneUI.this.getIntent()), Integer.valueOf(m.ax(ProtocolThreeOneUI.this.getIntent())), ProtocolThreeOneUI.this.pFJ, dNb, dNf, Integer.valueOf(dNc));
                new com.tencent.mm.plugin.freewifi.d.a(ProtocolThreeOneUI.this.pFJ, dNb, dNf, dNc, ProtocolThreeOneUI.this.channelId, m.aw(ProtocolThreeOneUI.this.getIntent())).c(new i() {
                    /* class com.tencent.mm.plugin.freewifi.ui.ProtocolThreeOneUI.AnonymousClass8.AnonymousClass1 */

                    @Override // com.tencent.mm.ak.i
                    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
                        AppMethodBeat.i(25191);
                        Log.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getA8Key.callback, desc=net request [apauth.getBackPage] returns. errType=%d, errCode=%d, errMsg=%s", m.aw(ProtocolThreeOneUI.this.getIntent()), Integer.valueOf(m.ax(ProtocolThreeOneUI.this.getIntent())), Integer.valueOf(i2), Integer.valueOf(i3), str);
                        if (i2 == 0 && i3 == 0) {
                            if (!(qVar instanceof com.tencent.mm.plugin.freewifi.d.a)) {
                                AppMethodBeat.o(25191);
                                return;
                            }
                            ih dNz = ((com.tencent.mm.plugin.freewifi.d.a) qVar).dNz();
                            if (dNz != null) {
                                Log.i("MicroMsg.FreeWifi.Protocol31UI", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s", dNz.KGX, dNz.oUJ, dNz.UserName, Integer.valueOf(dNz.KMt), dNz.KMu, dNz.keb);
                                ProtocolThreeOneUI.this.dNI = dNz.KGX;
                                ProtocolThreeOneUI.this.wPA = dNz.oUJ;
                                ProtocolThreeOneUI.this.appUserName = dNz.UserName;
                                ProtocolThreeOneUI.this.wSD = dNz.KMt;
                                ProtocolThreeOneUI.this.wSE = dNz.KMu;
                                ProtocolThreeOneUI.this.signature = dNz.keb;
                                ProtocolThreeOneUI.this.wSF = dNz.KMv;
                                Log.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getBackPageInfoAfterConnectSuccess, desc=net request [apauth.getBackPage] gets response. backpageinfo:  appid: %s, appNickName: %s, appUserName: %s, finishActionCode: %s, finishUrl: %s, signature: %s, qingHuaiPageUrl: %s", m.aw(ProtocolThreeOneUI.this.getIntent()), Integer.valueOf(m.ax(ProtocolThreeOneUI.this.getIntent())), ProtocolThreeOneUI.this.dNI, ProtocolThreeOneUI.this.wPA, ProtocolThreeOneUI.this.appUserName, Integer.valueOf(ProtocolThreeOneUI.this.wSD), ProtocolThreeOneUI.this.wSE, ProtocolThreeOneUI.this.signature, ProtocolThreeOneUI.this.wSF);
                            }
                            d.a(ProtocolThreeOneUI.this.ssid, 2, ProtocolThreeOneUI.this.getIntent());
                            Log.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.initModel, desc=it changes the connect state of the model to CONNECT_STATE_CONNECT_SUCCESS. state=%d", m.aw(ProtocolThreeOneUI.this.getIntent()), Integer.valueOf(m.ax(ProtocolThreeOneUI.this.getIntent())), 2);
                        }
                        AppMethodBeat.o(25191);
                    }
                });
                AppMethodBeat.o(25192);
            }
        });
        AppMethodBeat.o(25206);
    }

    static /* synthetic */ void a(ProtocolThreeOneUI protocolThreeOneUI, String str) {
        AppMethodBeat.i(25207);
        protocolThreeOneUI.wPK++;
        if (protocolThreeOneUI.wPK > 3) {
            Log.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.handle302Authentication, desc=Connection fail. Too many 302, exceeding 3 times", m.aw(protocolThreeOneUI.getIntent()), Integer.valueOf(m.ax(protocolThreeOneUI.getIntent())));
            d.a(protocolThreeOneUI.ssid, 3, protocolThreeOneUI.getIntent());
            protocolThreeOneUI.bt(33, "AUTH_302_TIMES_EXCESS");
            AppMethodBeat.o(25207);
            return;
        }
        Log.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.handle302Authentication, desc=it discovers 302 Location and redirects. http response header Location=%s", m.aw(protocolThreeOneUI.getIntent()), Integer.valueOf(m.ax(protocolThreeOneUI.getIntent())), str);
        if (m.eP(str)) {
            d.a(protocolThreeOneUI.ssid, 3, protocolThreeOneUI.getIntent());
            protocolThreeOneUI.bt(34, "EMPTY_AUTH_LOCATION");
            AppMethodBeat.o(25207);
            return;
        }
        AnonymousClass7 r0 = new a.AbstractC1369a() {
            /* class com.tencent.mm.plugin.freewifi.ui.ProtocolThreeOneUI.AnonymousClass7 */

            @Override // com.tencent.mm.plugin.freewifi.a.a.AbstractC1369a
            public final void d(HttpURLConnection httpURLConnection) {
                AppMethodBeat.i(25189);
                int responseCode = httpURLConnection.getResponseCode();
                Log.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.handle302Authentication.onSuccess, desc=it receives http response for authentication(after 302). http response status code=%d", m.aw(ProtocolThreeOneUI.this.getIntent()), Integer.valueOf(m.ax(ProtocolThreeOneUI.this.getIntent())), Integer.valueOf(responseCode));
                if (responseCode == 200) {
                    ProtocolThreeOneUI.e(ProtocolThreeOneUI.this);
                    AppMethodBeat.o(25189);
                } else if (responseCode == 302) {
                    ProtocolThreeOneUI.a(ProtocolThreeOneUI.this, httpURLConnection.getHeaderField("Location"));
                    AppMethodBeat.o(25189);
                } else {
                    Log.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.handle302Authentication, desc=http response status code is not 200, so it fails to connect wifi. ", m.aw(ProtocolThreeOneUI.this.getIntent()), Integer.valueOf(m.ax(ProtocolThreeOneUI.this.getIntent())));
                    d.a(ProtocolThreeOneUI.this.ssid, 3, ProtocolThreeOneUI.this.getIntent());
                    ProtocolThreeOneUI.a(ProtocolThreeOneUI.this, 32, "INVALID_HTTP_RESP_CODE");
                    AppMethodBeat.o(25189);
                }
            }

            @Override // com.tencent.mm.plugin.freewifi.a.a.AbstractC1369a
            public final void o(Exception exc) {
                AppMethodBeat.i(25190);
                Log.e("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.handle302Authentication.onException, desc=exception happens during http. e.getMessage()=%s", m.aw(ProtocolThreeOneUI.this.getIntent()), Integer.valueOf(m.ax(ProtocolThreeOneUI.this.getIntent())), exc.getMessage());
                d.a(ProtocolThreeOneUI.this.ssid, 3, ProtocolThreeOneUI.this.getIntent());
                ProtocolThreeOneUI.a(ProtocolThreeOneUI.this, 101, m.l(exc));
                AppMethodBeat.o(25190);
            }
        };
        Uri parse = Uri.parse(str);
        if ("post".equalsIgnoreCase(parse.getQueryParameter(FirebaseAnalytics.b.METHOD))) {
            com.tencent.mm.plugin.freewifi.a.a.dMN();
            com.tencent.mm.plugin.freewifi.a.a.a(str, parse.getEncodedQuery(), r0);
            AppMethodBeat.o(25207);
            return;
        }
        com.tencent.mm.plugin.freewifi.a.a.dMN();
        com.tencent.mm.plugin.freewifi.a.a.a(str, r0);
        AppMethodBeat.o(25207);
    }
}
