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
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.freewifi.a.a;
import com.tencent.mm.plugin.freewifi.d.f;
import com.tencent.mm.plugin.freewifi.g;
import com.tencent.mm.plugin.freewifi.g.c;
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
public class ProtocolThreeThreeUI extends MMActivity {
    protected String appId;
    protected String appUserName;
    protected String bssid;
    protected int channelId;
    private int dHO = 1;
    protected String dmc;
    protected String extend;
    protected String sign;
    protected String signature;
    protected int source;
    protected String ssid;
    protected String wPA;
    private int wPK = 0;
    protected String wPN;
    protected String wPO;
    private Uri wPP;
    private String wPQ;
    private MStorage.IOnStorageChange wQU;
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
        /* class com.tencent.mm.plugin.freewifi.ui.ProtocolThreeThreeUI.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(25208);
            if (!Util.isNullOrNil(ProtocolThreeThreeUI.this.ssid)) {
                ProtocolThreeThreeUI.this.dHO = ProtocolThreeThreeUI.this.dNP();
                if (ProtocolThreeThreeUI.this.dHO != 2) {
                    Log.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.connectTimeoutHandler, desc=wifi connecttimeout. state=%s", m.aw(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(m.ax(ProtocolThreeThreeUI.this.getIntent())), d.Ne(ProtocolThreeThreeUI.this.dHO));
                    d.a(ProtocolThreeThreeUI.this.ssid, 3, ProtocolThreeThreeUI.this.getIntent());
                }
            }
            AppMethodBeat.o(25208);
            return false;
        }
    }, false);

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ProtocolThreeThreeUI() {
        AppMethodBeat.i(25221);
        AppMethodBeat.o(25221);
    }

    static /* synthetic */ void b(ProtocolThreeThreeUI protocolThreeThreeUI) {
        AppMethodBeat.i(25230);
        protocolThreeThreeUI.goBack();
        AppMethodBeat.o(25230);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        boolean z;
        AppMethodBeat.i(25222);
        super.onCreate(bundle);
        this.wPQ = getIntent().getStringExtra("free_wifi_schema_uri");
        this.wPP = Uri.parse(this.wPQ);
        this.appId = this.wPP.getQueryParameter("appId");
        this.wPN = this.wPP.getQueryParameter("shopId");
        this.wPO = this.wPP.getQueryParameter("authUrl");
        this.extend = this.wPP.getQueryParameter("extend");
        this.dmc = this.wPP.getQueryParameter(AppMeasurement.Param.TIMESTAMP);
        this.sign = this.wPP.getQueryParameter("sign");
        Log.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.onCreate, desc=it goes into Protocol33 connect frontpage. uri = %s", m.aw(getIntent()), Integer.valueOf(m.ax(getIntent())), this.wPQ);
        initView();
        if (Util.isNullOrNil(this.ssid)) {
            Log.e("MicroMsg.FreeWifi.Protocol33UI", "ssid is null");
        } else {
            c aya = j.dNn().aya(this.ssid);
            if (aya == null) {
                aya = new c();
                aya.field_ssidmd5 = MD5Util.getMD5String(this.ssid);
                aya.field_ssid = this.ssid;
                z = true;
            } else {
                z = false;
            }
            aya.field_url = "";
            aya.field_mid = "";
            aya.field_wifiType = 33;
            aya.field_connectState = 1;
            if (z) {
                j.dNn().insert(aya);
            } else {
                j.dNn().update(aya, new String[0]);
            }
            Log.i("MicroMsg.FreeWifi.Protocol33UI", "ssid : %s, mid : %s, source : %d", this.ssid, "", Integer.valueOf(this.source));
            this.wQU = new MStorage.IOnStorageChange() {
                /* class com.tencent.mm.plugin.freewifi.ui.ProtocolThreeThreeUI.AnonymousClass5 */
                private int wSH = -999999999;

                @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
                public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
                    AppMethodBeat.i(25212);
                    ProtocolThreeThreeUI.this.dHO = ProtocolThreeThreeUI.this.dNP();
                    if (this.wSH != ProtocolThreeThreeUI.this.dHO) {
                        this.wSH = ProtocolThreeThreeUI.this.dHO;
                        ProtocolThreeThreeUI.this.Ng(ProtocolThreeThreeUI.this.dHO);
                    }
                    AppMethodBeat.o(25212);
                }
            };
            j.dNn().add(this.wQU);
            Log.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.initModel, desc=Initializing the model behind the view, so anything that changes the model will notify the view. model : field_ssidmd5=%s, field_ssid=%s, field_url=%s, field_mid=%s, field_wifiType=%d, field_connectState=%d", m.aw(getIntent()), Integer.valueOf(m.ax(getIntent())), aya.field_ssidmd5, aya.field_ssid, aya.field_url, aya.field_mid, Integer.valueOf(aya.field_wifiType), Integer.valueOf(aya.field_connectState));
            Log.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.initModel, desc=it initializes the front page. ", m.aw(getIntent()), Integer.valueOf(m.ax(getIntent())));
            d.a(this.ssid, 4, getIntent());
        }
        l.Q(d.dNe(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
        AppMethodBeat.o(25222);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(25223);
        this.ssid = m.axM("MicroMsg.FreeWifi.Protocol33UI");
        this.bssid = m.axN("MicroMsg.FreeWifi.Protocol33UI");
        this.source = getIntent().getIntExtra("free_wifi_source", 1);
        this.channelId = getIntent().getIntExtra("free_wifi_channel_id", 0);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.freewifi.ui.ProtocolThreeThreeUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(25209);
                ProtocolThreeThreeUI.b(ProtocolThreeThreeUI.this);
                AppMethodBeat.o(25209);
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
            /* class com.tencent.mm.plugin.freewifi.ui.ProtocolThreeThreeUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(25210);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/freewifi/ui/ProtocolThreeThreeUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                l.R(d.dNe(), ProtocolThreeThreeUI.this.getIntent().getStringExtra("free_wifi_ap_key"), ProtocolThreeThreeUI.this.getIntent().getIntExtra("free_wifi_protocol_type", 0));
                int dNP = ProtocolThreeThreeUI.this.dNP();
                Log.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.connectWifiBtn.setOnClickListener, desc=User click the connect button and starts the connect wifi process. state=%s", m.aw(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(m.ax(ProtocolThreeThreeUI.this.getIntent())), d.Ne(dNP));
                if (dNP == 2) {
                    ProtocolThreeThreeUI.this.finish();
                } else {
                    d.a(ProtocolThreeThreeUI.this.ssid, 1, ProtocolThreeThreeUI.this.getIntent());
                    ProtocolThreeThreeUI.this.connect();
                }
                a.a(this, "com/tencent/mm/plugin/freewifi/ui/ProtocolThreeThreeUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(25210);
            }
        });
        this.wRz = (Button) findViewById(R.id.j1n);
        this.wRz.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.freewifi.ui.ProtocolThreeThreeUI.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(25211);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/freewifi/ui/ProtocolThreeThreeUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                a.a(this, "com/tencent/mm/plugin/freewifi/ui/ProtocolThreeThreeUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(25211);
            }
        });
        if (Util.isNullOrNil(this.ssid)) {
            this.wRx.setText(getString(R.string.din));
            this.wRy.setVisibility(4);
        }
        setMMTitle(getString(R.string.dip));
        AppMethodBeat.o(25223);
    }

    /* access modifiers changed from: protected */
    public final void connect() {
        AppMethodBeat.i(25224);
        if (m.eP(this.ssid)) {
            Log.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, desc=it cannot get ssid, so it fails. ", m.aw(getIntent()), Integer.valueOf(m.ax(getIntent())));
            d.a(this.ssid, 3, getIntent());
            AppMethodBeat.o(25224);
        } else if (m.eP(this.wPO)) {
            Log.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, desc=authurl is empty, so it fails. ", m.aw(getIntent()), Integer.valueOf(m.ax(getIntent())));
            d.a(this.ssid, 3, getIntent());
            AppMethodBeat.o(25224);
        } else {
            this.dHO = dNP();
            Log.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.connect, desc=it starts connecting wifi by protocol 3.1. current connect state=%s", m.aw(getIntent()), Integer.valueOf(m.ax(getIntent())), d.Ne(this.dHO));
            if (this.dHO != 2) {
                this.wTa.startTimer(30000);
                Log.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.connect, desc=it starts connectTimeoutHandler. timeout=%d s", m.aw(getIntent()), Integer.valueOf(m.ax(getIntent())), 60);
                m.eP(this.wPO);
                StringBuilder sb = new StringBuilder(this.wPO);
                if (this.wPO.indexOf("?") == -1) {
                    sb.append("?extend=").append(this.extend);
                } else {
                    sb.append("&extend=").append(this.extend);
                }
                final String sb2 = sb.toString();
                j.dNq().dMZ().post(new Runnable() {
                    /* class com.tencent.mm.plugin.freewifi.ui.ProtocolThreeThreeUI.AnonymousClass6 */

                    public final void run() {
                        AppMethodBeat.i(25215);
                        Log.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.httpAuthentication, desc=it sends http request for authentication. http url=%s", m.aw(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(m.ax(ProtocolThreeThreeUI.this.getIntent())), sb2);
                        com.tencent.mm.plugin.freewifi.a.a.dMN();
                        com.tencent.mm.plugin.freewifi.a.a.a(sb2, new a.AbstractC1369a() {
                            /* class com.tencent.mm.plugin.freewifi.ui.ProtocolThreeThreeUI.AnonymousClass6.AnonymousClass1 */

                            @Override // com.tencent.mm.plugin.freewifi.a.a.AbstractC1369a
                            public final void d(HttpURLConnection httpURLConnection) {
                                AppMethodBeat.i(25213);
                                int responseCode = httpURLConnection.getResponseCode();
                                Log.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.HttpAuthentication.onSuccess, desc=it receives http response for authentication. http response status code=%d", m.aw(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(m.ax(ProtocolThreeThreeUI.this.getIntent())), Integer.valueOf(responseCode));
                                if (responseCode == 200) {
                                    ProtocolThreeThreeUI.c(ProtocolThreeThreeUI.this);
                                    AppMethodBeat.o(25213);
                                } else if (responseCode == 302) {
                                    ProtocolThreeThreeUI.a(ProtocolThreeThreeUI.this, httpURLConnection.getHeaderField("Location"));
                                    AppMethodBeat.o(25213);
                                } else {
                                    Log.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.httpAuthentication, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", m.aw(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(m.ax(ProtocolThreeThreeUI.this.getIntent())));
                                    d.a(ProtocolThreeThreeUI.this.ssid, 3, ProtocolThreeThreeUI.this.getIntent());
                                    AppMethodBeat.o(25213);
                                }
                            }

                            @Override // com.tencent.mm.plugin.freewifi.a.a.AbstractC1369a
                            public final void o(Exception exc) {
                                AppMethodBeat.i(25214);
                                Log.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.httpAuthentication, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s", m.aw(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(m.ax(ProtocolThreeThreeUI.this.getIntent())), exc.getMessage());
                                d.a(ProtocolThreeThreeUI.this.ssid, 3, ProtocolThreeThreeUI.this.getIntent());
                                AppMethodBeat.o(25214);
                            }
                        });
                        AppMethodBeat.o(25215);
                    }
                });
                AppMethodBeat.o(25224);
                return;
            }
            d.a(this.ssid, 2, getIntent());
            AppMethodBeat.o(25224);
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* access modifiers changed from: protected */
    public final void Ng(int i2) {
        AppMethodBeat.i(25225);
        Log.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.onConnectStateChange, desc=it receives notifications whenever the connect state of model changes and then updates the view accordingly. state=%d", m.aw(getIntent()), Integer.valueOf(m.ax(getIntent())), Integer.valueOf(i2));
        switch (i2) {
            case 1:
                this.wRh.setVisibility(4);
                this.wRy.setText(R.string.b9i);
                this.wSy = h.a((Context) getContext(), getString(R.string.b9i), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                    /* class com.tencent.mm.plugin.freewifi.ui.ProtocolThreeThreeUI.AnonymousClass9 */

                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(25220);
                        d.a(ProtocolThreeThreeUI.this.ssid, 4, ProtocolThreeThreeUI.this.getIntent());
                        Log.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.toConnecting.ProgressDlg.onCancel, desc=it changes the connect state of the model to CONNECT_STATE_WAIT_START because the user cancles the connect process in progress. state=%d", m.aw(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(m.ax(ProtocolThreeThreeUI.this.getIntent())), 4);
                        AppMethodBeat.o(25220);
                    }
                });
                Log.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.toConnecting, desc=it adds a loading ui on the connect front page.", m.aw(getIntent()), Integer.valueOf(m.ax(getIntent())));
                AppMethodBeat.o(25225);
                return;
            case 2:
                if (this.wSy != null) {
                    this.wSy.dismiss();
                }
                this.wTa.stopTimer();
                this.wRy.setText(R.string.b9f);
                this.wRy.setClickable(false);
                Intent intent = getIntent();
                intent.putExtra("free_wifi_appid", this.appId);
                intent.putExtra("free_wifi_app_nickname", this.wPA);
                intent.putExtra("free_wifi_app_username", this.appUserName);
                intent.putExtra("free_wifi_signature", this.signature);
                intent.putExtra("free_wifi_finish_actioncode", this.wSD);
                intent.putExtra("free_wifi_finish_url", this.wSE);
                if (Util.isNullOrNil(this.wSF)) {
                    intent.setClass(this, FreeWifiSuccUI.class);
                } else {
                    intent.putExtra("free_wifi_qinghuai_url", this.wSF);
                    intent.setClass(this, FreeWifiSuccWebViewUI.class);
                }
                finish();
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/freewifi/ui/ProtocolThreeThreeUI", "toSuccess", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/freewifi/ui/ProtocolThreeThreeUI", "toSuccess", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                c.report();
                Log.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.toSuccess, desc=connect succeeded.", m.aw(getIntent()), Integer.valueOf(m.ax(getIntent())));
                break;
            case 3:
                if (this.wSy != null) {
                    this.wSy.dismiss();
                }
                this.wTa.stopTimer();
                this.wRh.setVisibility(0);
                this.wRy.setText(R.string.dil);
                Log.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.toFail, desc=connect failed.", m.aw(getIntent()), Integer.valueOf(m.ax(getIntent())));
                AppMethodBeat.o(25225);
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
                } else {
                    this.wRx.setText(getString(R.string.b9j, new Object[]{this.ssid}));
                }
                Log.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.toConnectStart, desc=it initializes the connect front page.", m.aw(getIntent()), Integer.valueOf(m.ax(getIntent())));
                AppMethodBeat.o(25225);
                return;
        }
        AppMethodBeat.o(25225);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.ami;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(25226);
        if (i2 == 4 && keyEvent.getRepeatCount() == 0) {
            goBack();
            AppMethodBeat.o(25226);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(25226);
        return onKeyDown;
    }

    private void goBack() {
        AppMethodBeat.i(25227);
        l.S(d.dNe(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
        g.jRt.h(new Intent(), this);
        finish();
        AppMethodBeat.o(25227);
    }

    /* access modifiers changed from: protected */
    public final int dNP() {
        AppMethodBeat.i(25228);
        if (Util.isNullOrNil(this.ssid)) {
            Log.d("MicroMsg.FreeWifi.Protocol33UI", "Illegal SSID");
            AppMethodBeat.o(25228);
            return 0;
        }
        c aya = j.dNn().aya(this.ssid);
        if (aya == null || !aya.field_ssid.equalsIgnoreCase(this.ssid)) {
            AppMethodBeat.o(25228);
            return 0;
        }
        int i2 = aya.field_connectState;
        AppMethodBeat.o(25228);
        return i2;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(25229);
        super.onDestroy();
        if (this.wQU != null) {
            j.dNn().remove(this.wQU);
        }
        this.wTa.stopTimer();
        j.dNq().release();
        AppMethodBeat.o(25229);
    }

    static /* synthetic */ void c(ProtocolThreeThreeUI protocolThreeThreeUI) {
        AppMethodBeat.i(25231);
        j.dNq().dMZ().post(new Runnable() {
            /* class com.tencent.mm.plugin.freewifi.ui.ProtocolThreeThreeUI.AnonymousClass8 */

            public final void run() {
                AppMethodBeat.i(25219);
                Log.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.getBackPageInfoAfterConnectSuccess, desc=it starts net request [apauth.getBackPageFor33]  for backpage info. fullUrl=%s, nowApMac=%s, nowNetworkSSID=%s, rssi=%d", m.aw(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(m.ax(ProtocolThreeThreeUI.this.getIntent())), "", d.dNb(), d.dNf(), Integer.valueOf(d.dNc()));
                new f(ProtocolThreeThreeUI.this.ssid, ProtocolThreeThreeUI.this.bssid, ProtocolThreeThreeUI.this.appId, ProtocolThreeThreeUI.this.wPN, ProtocolThreeThreeUI.this.wPO, ProtocolThreeThreeUI.this.extend, ProtocolThreeThreeUI.this.dmc, ProtocolThreeThreeUI.this.sign).c(new i() {
                    /* class com.tencent.mm.plugin.freewifi.ui.ProtocolThreeThreeUI.AnonymousClass8.AnonymousClass1 */

                    @Override // com.tencent.mm.ak.i
                    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
                        AppMethodBeat.i(25218);
                        Log.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getA8Key.callback, desc=net request [apauth.getBackPageFor33] returns. errType=%d, errCode=%d, errMsg=%s", m.aw(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(m.ax(ProtocolThreeThreeUI.this.getIntent())), Integer.valueOf(i2), Integer.valueOf(i3), str);
                        if (i2 == 0 && i3 == 0) {
                            ih dNz = ((f) qVar).dNz();
                            if (dNz != null) {
                                Log.i("MicroMsg.FreeWifi.Protocol33UI", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s", dNz.KGX, dNz.oUJ, dNz.UserName, Integer.valueOf(dNz.KMt), dNz.KMu, dNz.keb);
                                ProtocolThreeThreeUI.this.wPA = dNz.oUJ;
                                ProtocolThreeThreeUI.this.appUserName = dNz.UserName;
                                ProtocolThreeThreeUI.this.wSD = dNz.KMt;
                                ProtocolThreeThreeUI.this.wSE = dNz.KMu;
                                ProtocolThreeThreeUI.this.signature = dNz.keb;
                                ProtocolThreeThreeUI.this.wSF = dNz.KMv;
                                Log.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getBackPageInfoAfterConnectSuccess, desc=net request [apauth.getBackPageFor33] gets response. backpageinfo:  appid: %s, appNickName: %s, appUserName: %s, finishActionCode: %s, finishUrl: %s, signature: %s, qingHuaiPageUrl: %s", m.aw(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(m.ax(ProtocolThreeThreeUI.this.getIntent())), ProtocolThreeThreeUI.this.appId, ProtocolThreeThreeUI.this.wPA, ProtocolThreeThreeUI.this.appUserName, Integer.valueOf(ProtocolThreeThreeUI.this.wSD), ProtocolThreeThreeUI.this.wSE, ProtocolThreeThreeUI.this.signature, ProtocolThreeThreeUI.this.wSF);
                            }
                            d.a(ProtocolThreeThreeUI.this.ssid, 2, ProtocolThreeThreeUI.this.getIntent());
                            Log.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.initModel, desc=it changes the connect state of the model to CONNECT_STATE_CONNECT_SUCCESS. state=%d", m.aw(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(m.ax(ProtocolThreeThreeUI.this.getIntent())), 2);
                            AppMethodBeat.o(25218);
                        } else if (i3 == -30032) {
                            Intent intent = new Intent();
                            intent.putExtra("free_wifi_error_ui_error_msg", ProtocolThreeThreeUI.this.getString(R.string.dhr));
                            intent.setClass(ProtocolThreeThreeUI.this, FreeWifiErrorUI.class);
                            ProtocolThreeThreeUI.this.finish();
                            ProtocolThreeThreeUI protocolThreeThreeUI = ProtocolThreeThreeUI.this;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                            com.tencent.mm.hellhoundlib.a.a.a(protocolThreeThreeUI, bl.axQ(), "com/tencent/mm/plugin/freewifi/ui/ProtocolThreeThreeUI$8$1", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            protocolThreeThreeUI.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(protocolThreeThreeUI, "com/tencent/mm/plugin/freewifi/ui/ProtocolThreeThreeUI$8$1", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            AppMethodBeat.o(25218);
                        } else {
                            d.a(ProtocolThreeThreeUI.this.ssid, 3, ProtocolThreeThreeUI.this.getIntent());
                            Log.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, desc=NetSceneGetBackPageFor33 returns unkown errcode. errCode=%d", m.aw(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(m.ax(ProtocolThreeThreeUI.this.getIntent())), Integer.valueOf(i3));
                            AppMethodBeat.o(25218);
                        }
                    }
                });
                AppMethodBeat.o(25219);
            }
        });
        AppMethodBeat.o(25231);
    }

    static /* synthetic */ void a(ProtocolThreeThreeUI protocolThreeThreeUI, String str) {
        AppMethodBeat.i(25232);
        protocolThreeThreeUI.wPK++;
        if (protocolThreeThreeUI.wPK > 3) {
            Log.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.handle302Authentication, desc=Connection fail. Too many 302, exceeding 3 times", m.aw(protocolThreeThreeUI.getIntent()), Integer.valueOf(m.ax(protocolThreeThreeUI.getIntent())));
            d.a(protocolThreeThreeUI.ssid, 3, protocolThreeThreeUI.getIntent());
            AppMethodBeat.o(25232);
            return;
        }
        Log.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.handle302Authentication, desc=it discovers 302 Location and redirects. http response header Location=%s", m.aw(protocolThreeThreeUI.getIntent()), Integer.valueOf(m.ax(protocolThreeThreeUI.getIntent())), str);
        if (m.eP(str)) {
            d.a(protocolThreeThreeUI.ssid, 3, protocolThreeThreeUI.getIntent());
            AppMethodBeat.o(25232);
            return;
        }
        AnonymousClass7 r0 = new a.AbstractC1369a() {
            /* class com.tencent.mm.plugin.freewifi.ui.ProtocolThreeThreeUI.AnonymousClass7 */

            @Override // com.tencent.mm.plugin.freewifi.a.a.AbstractC1369a
            public final void d(HttpURLConnection httpURLConnection) {
                AppMethodBeat.i(25216);
                int responseCode = httpURLConnection.getResponseCode();
                Log.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.handle302Authentication.onSuccess, desc=it receives http response for authentication(after 302). http response status code=%d", m.aw(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(m.ax(ProtocolThreeThreeUI.this.getIntent())), Integer.valueOf(responseCode));
                if (responseCode == 200) {
                    ProtocolThreeThreeUI.c(ProtocolThreeThreeUI.this);
                    AppMethodBeat.o(25216);
                } else if (responseCode == 302) {
                    ProtocolThreeThreeUI.a(ProtocolThreeThreeUI.this, httpURLConnection.getHeaderField("Location"));
                    AppMethodBeat.o(25216);
                } else {
                    Log.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.handle302Authentication, desc=http response status code is not 200, so it fails to connect wifi. ", m.aw(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(m.ax(ProtocolThreeThreeUI.this.getIntent())));
                    d.a(ProtocolThreeThreeUI.this.ssid, 3, ProtocolThreeThreeUI.this.getIntent());
                    AppMethodBeat.o(25216);
                }
            }

            @Override // com.tencent.mm.plugin.freewifi.a.a.AbstractC1369a
            public final void o(Exception exc) {
                AppMethodBeat.i(25217);
                Log.e("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.handle302Authentication.onException, desc=exception happens during http. e.getMessage()=%s", m.aw(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(m.ax(ProtocolThreeThreeUI.this.getIntent())), exc.getMessage());
                AppMethodBeat.o(25217);
            }
        };
        Uri parse = Uri.parse(str);
        if ("post".equalsIgnoreCase(parse.getQueryParameter(FirebaseAnalytics.b.METHOD))) {
            com.tencent.mm.plugin.freewifi.a.a.dMN();
            com.tencent.mm.plugin.freewifi.a.a.a(str, parse.getEncodedQuery(), r0);
            AppMethodBeat.o(25232);
            return;
        }
        com.tencent.mm.plugin.freewifi.a.a.dMN();
        com.tencent.mm.plugin.freewifi.a.a.a(str, r0);
        AppMethodBeat.o(25232);
    }
}
