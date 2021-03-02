package com.tencent.mm.plugin.freewifi.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.freewifi.g;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;

@Deprecated
public abstract class FreeWifiStateUI extends MMActivity implements FreeWifiNetworkReceiver.a, FreeWifiNetworkReceiver.b {
    protected String appUserName;
    protected int channelId;
    protected String dFd;
    private int dHO = 1;
    protected String dNI;
    protected String iAR;
    private final c jaR;
    protected String pFJ;
    protected String signature;
    protected int source;
    protected String ssid;
    protected String wPA;
    protected String wQO;
    protected FreeWifiNetworkReceiver wQP;
    protected boolean wQQ = false;
    private MTimerHandler wQS = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiStateUI.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(25130);
            if (!Util.isNullOrNil(FreeWifiStateUI.this.ssid)) {
                FreeWifiStateUI.this.dHO = FreeWifiStateUI.this.dNP();
                Log.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now auth time out, ssid is %s, the connect state is %d", FreeWifiStateUI.this.ssid, Integer.valueOf(FreeWifiStateUI.this.dHO));
                FreeWifiStateUI.this.wQT.stopTimer();
                k.a dMF = k.dMF();
                dMF.ssid = FreeWifiStateUI.this.ssid;
                dMF.dFd = FreeWifiStateUI.this.dFd;
                dMF.quX = m.aw(FreeWifiStateUI.this.getIntent());
                dMF.wNc = m.ay(FreeWifiStateUI.this.getIntent());
                dMF.wNd = k.b.AddNetwork.wNO;
                dMF.wNe = k.b.AddNetwork.name;
                dMF.result = -16;
                dMF.channel = m.az(FreeWifiStateUI.this.getIntent());
                dMF.wNb = FreeWifiStateUI.this.dNI;
                dMF.wNf = FreeWifiStateUI.this.appUserName;
                dMF.dMH().dMG();
                if (FreeWifiStateUI.this.dHO != 2) {
                    FreeWifiStateUI.this.dNT();
                    FreeWifiStateUI.this.dNR();
                    d.a(FreeWifiStateUI.this.ssid, 3, FreeWifiStateUI.this.getIntent());
                }
            }
            AppMethodBeat.o(25130);
            return false;
        }
    }, false);
    private MTimerHandler wQT = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiStateUI.AnonymousClass2 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(25131);
            if (d.axS(FreeWifiStateUI.this.ssid)) {
                FreeWifiStateUI.this.a(NetworkInfo.State.CONNECTED);
                FreeWifiStateUI.this.wQT.stopTimer();
                AppMethodBeat.o(25131);
                return false;
            }
            AppMethodBeat.o(25131);
            return true;
        }
    }, true);
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
    private q wSy = null;

    @Override // com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver.a
    public abstract void a(NetworkInfo.State state);

    /* access modifiers changed from: protected */
    public abstract void bpf();

    /* access modifiers changed from: protected */
    public abstract void dNO();

    /* access modifiers changed from: protected */
    public abstract int dNP();

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FreeWifiStateUI() {
        c.a aVar = new c.a();
        aVar.jbd = true;
        aVar.jbe = true;
        aVar.jbq = R.drawable.bdo;
        aVar.iaT = true;
        aVar.jbx = 0.0f;
        this.jaR = aVar.bdv();
        this.wQU = new MStorage.IOnStorageChange() {
            /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiStateUI.AnonymousClass3 */
            private int wSH = -999999999;

            @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
            public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
                AppMethodBeat.i(25132);
                FreeWifiStateUI.this.dHO = FreeWifiStateUI.this.dNP();
                if (this.wSH != FreeWifiStateUI.this.dHO) {
                    this.wSH = FreeWifiStateUI.this.dHO;
                    FreeWifiStateUI.this.GE(FreeWifiStateUI.this.dHO);
                }
                AppMethodBeat.o(25132);
            }
        };
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0178  */
    /* JADX WARNING: Removed duplicated region for block: B:4:0x00b0  */
    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r9) {
        /*
        // Method dump skipped, instructions count: 424
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.freewifi.ui.FreeWifiStateUI.onCreate(android.os.Bundle):void");
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiStateUI.AnonymousClass4 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(25133);
                FreeWifiStateUI.this.goBack();
                AppMethodBeat.o(25133);
                return true;
            }
        });
        if (getIntent().getIntExtra("free_wifi_protocol_type", 0) == 1) {
            findViewById(R.id.j1m).setVisibility(0);
        }
        this.wRv = (ImageView) findViewById(R.id.d_2);
        this.wRw = (TextView) findViewById(R.id.da8);
        this.wRx = (TextView) findViewById(R.id.d_u);
        this.wRh = (TextView) findViewById(R.id.d_9);
        this.wRy = (Button) findViewById(R.id.b_q);
        this.wRy.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiStateUI.AnonymousClass5 */

            public final void onClick(View view) {
                AppMethodBeat.i(25134);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/freewifi/ui/FreeWifiStateUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                l.R(d.dNe(), FreeWifiStateUI.this.getIntent().getStringExtra("free_wifi_ap_key"), FreeWifiStateUI.this.getIntent().getIntExtra("free_wifi_protocol_type", 0));
                if (FreeWifiStateUI.this.dNP() == 2) {
                    FreeWifiStateUI.this.finish();
                } else {
                    d.a(FreeWifiStateUI.this.ssid, 1, FreeWifiStateUI.this.getIntent());
                    FreeWifiStateUI.this.wQQ = false;
                    FreeWifiStateUI.this.dNV();
                }
                a.a(this, "com/tencent/mm/plugin/freewifi/ui/FreeWifiStateUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(25134);
            }
        });
        this.wRz = (Button) findViewById(R.id.j1n);
        this.wRz.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiStateUI.AnonymousClass6 */

            public final void onClick(View view) {
                AppMethodBeat.i(25135);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/freewifi/ui/FreeWifiStateUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent();
                intent.putExtra("rawUrl", FreeWifiStateUI.this.wRE);
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                com.tencent.mm.br.c.b(FreeWifiStateUI.this.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                a.a(this, "com/tencent/mm/plugin/freewifi/ui/FreeWifiStateUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(25135);
            }
        });
        if (Util.isNullOrNil(this.ssid)) {
            this.wRx.setText(getString(R.string.din));
            this.wRy.setVisibility(4);
        }
    }

    /* access modifiers changed from: protected */
    public final void dNR() {
        if (this.wQP != null) {
            Log.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now unregister wifi state change receiver");
            this.wQP.wOS = null;
        }
    }

    /* access modifiers changed from: protected */
    public final void dNS() {
        if (this.wQP == null) {
            dNU();
        }
        this.wQP.wOT = this;
    }

    /* access modifiers changed from: protected */
    public final void dNT() {
        if (this.wQP != null) {
            Log.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now unregister network changed receiver");
            this.wQP.wOT = null;
        }
    }

    private void dNU() {
        this.wQP = new FreeWifiNetworkReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        registerReceiver(this.wQP, intentFilter);
    }

    /* access modifiers changed from: protected */
    public final void dNV() {
        if (!d.isWifiEnabled()) {
            this.wQS.startTimer(Util.MILLSECONDS_OF_MINUTE);
            this.wQT.startTimer(1000);
            Log.i("MicroMsg.FreeWifi.FreeWifiStateUI", "wifi is not enable, enable it");
            j.dNq().dMZ().post(new Runnable() {
                /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiStateUI.AnonymousClass7 */

                public final void run() {
                    AppMethodBeat.i(25136);
                    FreeWifiStateUI.d(FreeWifiStateUI.this);
                    AppMethodBeat.o(25136);
                }
            });
            return;
        }
        this.dHO = dNP();
        Log.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now before connect, the connect state : %d", Integer.valueOf(this.dHO));
        if (this.dHO != 2) {
            if (m.ay(getIntent()) == 4) {
                this.wQS.startTimer(30000);
            } else {
                this.wQS.startTimer(Util.MILLSECONDS_OF_MINUTE);
            }
            this.wQT.startTimer(1000);
            if (d.axS(this.ssid)) {
                Log.i("MicroMsg.FreeWifi.FreeWifiStateUI", "start auth now, isAuting : %b", Boolean.valueOf(this.wQQ));
                if (this.wQQ) {
                    Log.d("MicroMsg.FreeWifi.FreeWifiStateUI", "now it is authing");
                    return;
                }
                this.wQS.startTimer(Util.MILLSECONDS_OF_MINUTE);
                this.wQT.startTimer(1000);
                bpf();
                this.wQQ = true;
                return;
            }
            j.dNq().dMZ().post(new Runnable() {
                /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiStateUI.AnonymousClass8 */

                public final void run() {
                    AppMethodBeat.i(25137);
                    Log.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now network ssid is not wechat freewifi :%s", FreeWifiStateUI.this.ssid);
                    FreeWifiStateUI.this.dNO();
                    AppMethodBeat.o(25137);
                }
            });
            return;
        }
        d.a(this.ssid, this.dHO, getIntent());
    }

    /* access modifiers changed from: protected */
    public final void GE(int i2) {
        Log.i("MicroMsg.FreeWifi.FreeWifiStateUI", "Current connection state : %d", Integer.valueOf(i2));
        switch (i2) {
            case -2014:
                if (this.wSy != null) {
                    this.wSy.dismiss();
                }
                this.wQS.stopTimer();
                this.wQT.stopTimer();
                this.wRh.setVisibility(0);
                this.wRy.setText(R.string.dil);
                return;
            case -1:
                return;
            case 1:
                this.wRh.setVisibility(4);
                this.wRy.setText(R.string.b9i);
                this.wSy = h.a((Context) getContext(), getString(R.string.b9i), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                    /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiStateUI.AnonymousClass9 */

                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(25138);
                        d.a(FreeWifiStateUI.this.ssid, 4, FreeWifiStateUI.this.getIntent());
                        AppMethodBeat.o(25138);
                    }
                });
                return;
            case 2:
                if (this.wSy != null) {
                    this.wSy.dismiss();
                }
                this.wQS.stopTimer();
                this.wQT.stopTimer();
                this.wRy.setText(R.string.b9f);
                this.wRy.setClickable(false);
                Intent intent = getIntent();
                intent.putExtra("free_wifi_appid", this.dNI);
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
                a.a(this, bl.axQ(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiStateUI", "updateUIState", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                startActivity((Intent) bl.pG(0));
                a.a(this, "com/tencent/mm/plugin/freewifi/ui/FreeWifiStateUI", "updateUIState", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                c.report();
                return;
            case 3:
                if (this.wSy != null) {
                    this.wSy.dismiss();
                }
                this.wQS.stopTimer();
                this.wQT.stopTimer();
                this.wRh.setVisibility(0);
                this.wRy.setText(R.string.dil);
                return;
            case 4:
                if (this.wSy != null) {
                    this.wSy.dismiss();
                }
                this.wQS.stopTimer();
                this.wQT.stopTimer();
                this.wQQ = false;
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
                    if (!Util.isNullOrNil(this.wRC)) {
                        this.wRw.setText(this.wRC);
                    }
                    if (!Util.isNullOrNil(this.iAR)) {
                        com.tencent.mm.av.q.bcV().a(this.iAR, this.wRv, this.jaR);
                        return;
                    }
                    return;
                }
                return;
            default:
                if (this.wSy != null) {
                    this.wSy.dismiss();
                }
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
                    if (!Util.isNullOrNil(this.wRC)) {
                        this.wRw.setText(this.wRC);
                    }
                    if (!Util.isNullOrNil(this.iAR)) {
                        com.tencent.mm.av.q.bcV().a(this.iAR, this.wRv, this.jaR);
                        return;
                    }
                    return;
                }
                return;
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.ami;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
        j.dNn().remove(this.wQU);
        dNR();
        dNT();
        if (this.wQP != null) {
            unregisterReceiver(this.wQP);
        }
        this.wQS.stopTimer();
        this.wQT.stopTimer();
        j.dNq().release();
    }

    @Override // com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver.b
    public final void Nf(int i2) {
        Log.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now wifi state : %d", Integer.valueOf(i2));
        switch (i2) {
            case 0:
            case 1:
            case 2:
            default:
                return;
            case 3:
                dNR();
                dNV();
                return;
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i2, keyEvent);
        }
        goBack();
        return true;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void goBack() {
        l.S(d.dNe(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
        g.jRt.h(new Intent(), this);
        finish();
    }

    static /* synthetic */ void d(FreeWifiStateUI freeWifiStateUI) {
        if (freeWifiStateUI.wQP == null) {
            freeWifiStateUI.dNU();
        }
        freeWifiStateUI.wQP.wOS = freeWifiStateUI;
        d.dNa();
    }
}
