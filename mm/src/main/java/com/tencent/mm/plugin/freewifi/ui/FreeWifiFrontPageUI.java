package com.tencent.mm.plugin.freewifi.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.q;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.plugin.freewifi.g;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.protobuf.ih;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.e;
import com.tencent.thumbplayer.core.common.TPCodecParamers;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FreeWifiFrontPageUI extends MMActivity {
    protected int channelId;
    protected String className;
    protected String dFd;
    protected String dNI;
    private MMHandler hAk = new MMHandler() {
        /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.AnonymousClass1 */

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(25018);
            c cVar = (c) message.obj;
            switch (AnonymousClass3.wRJ[cVar.wRH.ordinal()]) {
                case 1:
                    FreeWifiFrontPageUI.this.dNZ();
                    AppMethodBeat.o(25018);
                    return;
                case 2:
                    FreeWifiFrontPageUI.this.dOa();
                    AppMethodBeat.o(25018);
                    return;
                case 3:
                    FreeWifiFrontPageUI.this.m22do(cVar.data);
                    AppMethodBeat.o(25018);
                    return;
                case 4:
                    FreeWifiFrontPageUI.this.dp(cVar.data);
                    break;
            }
            AppMethodBeat.o(25018);
        }
    };
    protected String iAR;
    protected Intent intent;
    private final com.tencent.mm.av.a.a.c jaR;
    protected String pFJ;
    private boolean rHi = true;
    protected int source;
    protected String ssid;
    protected String wPA;
    protected int wPz;
    protected Dialog wRA;
    protected View wRB;
    protected String wRC;
    protected String wRD;
    protected String wRE;
    protected com.tencent.mm.plugin.freewifi.e.a wRF;
    private Lock wRG;
    private d wRH;
    protected TextView wRh;
    protected TextView wRi;
    protected TextView wRj;
    protected ImageView wRv;
    protected TextView wRw;
    protected TextView wRx;
    protected Button wRy;
    protected Button wRz;

    public static class b {
        public ih wRL;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FreeWifiFrontPageUI() {
        AppMethodBeat.i(25033);
        c.a aVar = new c.a();
        aVar.jbd = true;
        aVar.jbe = true;
        aVar.jbq = R.drawable.bdo;
        aVar.iaT = true;
        aVar.jbx = 0.0f;
        this.jaR = aVar.bdv();
        AppMethodBeat.o(25033);
    }

    static /* synthetic */ void a(FreeWifiFrontPageUI freeWifiFrontPageUI) {
        AppMethodBeat.i(25050);
        freeWifiFrontPageUI.goBack();
        AppMethodBeat.o(25050);
    }

    static /* synthetic */ void b(FreeWifiFrontPageUI freeWifiFrontPageUI) {
        AppMethodBeat.i(25051);
        freeWifiFrontPageUI.dNY();
        AppMethodBeat.o(25051);
    }

    private d dNX() {
        AppMethodBeat.i(25034);
        try {
            this.wRG.lock();
            return this.wRH;
        } finally {
            this.wRG.unlock();
            AppMethodBeat.o(25034);
        }
    }

    public final void a(d dVar, Object obj) {
        AppMethodBeat.i(25035);
        try {
            this.wRG.lock();
            this.wRH = dVar;
            Message obtain = Message.obtain();
            obtain.obj = new c(dVar, obj);
            this.hAk.sendMessage(obtain);
        } finally {
            this.wRG.unlock();
            AppMethodBeat.o(25035);
        }
    }

    public enum d {
        START,
        CONNECTING,
        FAIL,
        SUCCESS;

        public static d valueOf(String str) {
            AppMethodBeat.i(25031);
            d dVar = (d) Enum.valueOf(d.class, str);
            AppMethodBeat.o(25031);
            return dVar;
        }

        static {
            AppMethodBeat.i(25032);
            AppMethodBeat.o(25032);
        }
    }

    public static class c {
        Object data;
        d wRH;

        public c(d dVar, Object obj) {
            this.wRH = dVar;
            this.data = obj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] wRJ = new int[d.values().length];

        static {
            AppMethodBeat.i(25020);
            try {
                wRJ[d.START.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                wRJ[d.CONNECTING.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                wRJ[d.FAIL.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                wRJ[d.SUCCESS.ordinal()] = 4;
                AppMethodBeat.o(25020);
            } catch (NoSuchFieldError e5) {
                AppMethodBeat.o(25020);
            }
        }
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(25036);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(25036);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(25037);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.AnonymousClass4 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(25021);
                FreeWifiFrontPageUI.a(FreeWifiFrontPageUI.this);
                AppMethodBeat.o(25021);
                return true;
            }
        });
        if (this.wRA != null) {
            this.wRA.dismiss();
        }
        this.wRG = new ReentrantLock();
        this.className = getClass().getSimpleName();
        this.intent = getIntent();
        this.ssid = getIntent().getStringExtra("free_wifi_ssid");
        this.pFJ = getIntent().getStringExtra("free_wifi_url");
        this.dFd = getIntent().getStringExtra("free_wifi_ap_key");
        this.source = getIntent().getIntExtra("free_wifi_source", 1);
        this.channelId = getIntent().getIntExtra("free_wifi_channel_id", 0);
        this.wPz = this.intent.getIntExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 0);
        this.dNI = getIntent().getStringExtra("free_wifi_appid");
        this.iAR = getIntent().getStringExtra("free_wifi_head_img_url");
        this.wRC = getIntent().getStringExtra("free_wifi_welcome_msg");
        this.wRD = getIntent().getStringExtra("free_wifi_welcome_sub_title");
        this.wRE = getIntent().getStringExtra("free_wifi_privacy_url");
        this.wPA = getIntent().getStringExtra("free_wifi_app_nickname");
        Log.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=%s.initView, desc=Initializing the view. ssid=%s, fullUrl=%s, apKey=%s, source=%d, channel=%d, protocolNumber=%d, appid=%s, headImgUrl=%s, welcomeMsg=%s, privacyUrl=%s", m.aw(getIntent()), Integer.valueOf(m.ax(getIntent())), this.className, this.ssid, this.pFJ, this.dFd, Integer.valueOf(this.source), Integer.valueOf(this.channelId), Integer.valueOf(this.wPz), this.dNI, this.iAR, this.wRC, this.wRE);
        this.wRB = findViewById(R.id.j1m);
        this.wRv = (ImageView) findViewById(R.id.d_2);
        this.wRw = (TextView) findViewById(R.id.da8);
        this.wRx = (TextView) findViewById(R.id.d_u);
        this.wRh = (TextView) findViewById(R.id.d_9);
        this.wRi = (TextView) findViewById(R.id.d_7);
        this.wRj = (TextView) findViewById(R.id.d_8);
        this.wRy = (Button) findViewById(R.id.b_q);
        this.wRy.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.AnonymousClass5 */

            public final void onClick(View view) {
                AppMethodBeat.i(25022);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/freewifi/ui/FreeWifiFrontPageUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                FreeWifiFrontPageUI.b(FreeWifiFrontPageUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/freewifi/ui/FreeWifiFrontPageUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(25022);
            }
        });
        this.wRz = (Button) findViewById(R.id.j1n);
        this.wRz.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.AnonymousClass6 */

            public final void onClick(View view) {
                AppMethodBeat.i(25023);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/freewifi/ui/FreeWifiFrontPageUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent();
                intent.putExtra("rawUrl", FreeWifiFrontPageUI.this.wRE);
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                com.tencent.mm.br.c.b(FreeWifiFrontPageUI.this.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/freewifi/ui/FreeWifiFrontPageUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(25023);
            }
        });
        if (Util.isNullOrNil(this.ssid)) {
            this.wRx.setText(getString(R.string.din));
            this.wRy.setVisibility(4);
        }
        setMMTitle(getString(R.string.dip));
        a(d.START, null);
        AppMethodBeat.o(25037);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x002e  */
    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onResume() {
        /*
        // Method dump skipped, instructions count: 278
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.onResume():void");
    }

    private void dNY() {
        AppMethodBeat.i(25039);
        l.R(com.tencent.mm.plugin.freewifi.model.d.dNe(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
        Log.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, class=%s, desc=User click the connect button and starts the connect wifi process. uiState=%s", m.aw(getIntent()), Integer.valueOf(m.ax(getIntent())), this.className, dNX().name());
        if (dNX() == d.START || dNX() == d.FAIL) {
            boolean booleanExtra = this.intent.getBooleanExtra("ConstantsFreeWifi.FREE_WIFI_SHOULD_BIND_PHONE", false);
            int dMK = m.dMK();
            Log.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, class=%s, desc=It makes a decision whether to bind phone number. shoudBindPhone=%b, userPhoneState=%d(0 means no phone number. 1 means having a china phone number. 2 means having a foreign number.)", m.aw(getIntent()), Integer.valueOf(m.ax(getIntent())), this.className, Boolean.valueOf(booleanExtra), Integer.valueOf(dMK));
            if (!booleanExtra || dMK != 1 || this.wPz == 33) {
                this.wRH = d.CONNECTING;
                dOa();
                this.wRF.connect();
            } else {
                h.a(this, (int) R.string.dhh, (int) R.string.dhi, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.AnonymousClass8 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(25025);
                        m.fT(FreeWifiFrontPageUI.this);
                        AppMethodBeat.o(25025);
                    }
                }, (DialogInterface.OnClickListener) null);
                AppMethodBeat.o(25039);
                return;
            }
        }
        AppMethodBeat.o(25039);
    }

    /* access modifiers changed from: protected */
    public final void dNZ() {
        AppMethodBeat.i(25040);
        this.wRh.setVisibility(4);
        if (this.wPz == 31) {
            this.wRy.setVisibility(8);
        } else {
            this.wRy.setVisibility(0);
            this.wRy.setText(R.string.b9l);
        }
        if (m.az(getIntent()) == 10 && !m.eP(ae.gKy.gJB) && !m.eP(ae.cu(getContext()))) {
            this.wRy.setText(String.format(getString(R.string.dhj), ae.cu(getContext())));
        }
        if (!Util.isNullOrNil(this.wRD)) {
            this.wRx.setText(this.wRD);
        } else if (this.wPz == 33) {
            this.wRx.setText(getString(R.string.b9h) + ": " + this.ssid);
        } else {
            this.wRx.setText(getString(R.string.b9h));
        }
        if (!Util.isNullOrNil(this.dNI)) {
            if (!Util.isNullOrNil(this.wPA)) {
                this.wRw.setText(this.wPA);
            }
            if (!Util.isNullOrNil(this.iAR)) {
                q.bcV().a(this.iAR, this.wRv, this.jaR);
            }
        }
        Log.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=Protocol.toConnectStart, desc=it initializes the connect front page.", m.aw(getIntent()), Integer.valueOf(m.ax(getIntent())));
        AppMethodBeat.o(25040);
    }

    /* access modifiers changed from: protected */
    public final void dOa() {
        AppMethodBeat.i(25041);
        this.wRh.setVisibility(4);
        this.wRi.setVisibility(4);
        this.wRj.setVisibility(4);
        this.wRy.setText(R.string.b9i);
        this.wRA = b(getContext(), new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.AnonymousClass9 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(25026);
                com.tencent.mm.plugin.freewifi.model.d.a(FreeWifiFrontPageUI.this.ssid, 4, FreeWifiFrontPageUI.this.getIntent());
                Log.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=Protocol.toConnecting.ProgressDlg.onCancel, desc=it changes the connect state of the model to CONNECT_STATE_WAIT_START because the user cancles the connect process in progress. state=%d", m.aw(FreeWifiFrontPageUI.this.getIntent()), Integer.valueOf(m.ax(FreeWifiFrontPageUI.this.getIntent())), 4);
                AppMethodBeat.o(25026);
            }
        });
        Log.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=Protocol.toConnecting, desc=it adds a loading ui on the connect front page.", m.aw(getIntent()), Integer.valueOf(m.ax(getIntent())));
        this.wRA.show();
        AppMethodBeat.o(25041);
    }

    private static Dialog b(Context context, DialogInterface.OnCancelListener onCancelListener) {
        AppMethodBeat.i(25042);
        View inflate = View.inflate(context, R.layout.amo, null);
        i iVar = new i(context, R.style.k9);
        iVar.setCancelable(true);
        iVar.setContentView(inflate);
        iVar.setOnCancelListener(onCancelListener);
        AppMethodBeat.o(25042);
        return iVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: do  reason: not valid java name */
    public final void m22do(Object obj) {
        String string;
        AppMethodBeat.i(25043);
        if (!(obj instanceof a)) {
            AppMethodBeat.o(25043);
            return;
        }
        a aVar = (a) obj;
        Log.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, desc=Connect failed. errcode=%s", m.aw(this.intent), Integer.valueOf(m.ax(this.intent)), aVar.wRo);
        if (this.wRA != null) {
            this.wRA.dismiss();
        }
        this.wRh.setVisibility(0);
        if (!m.eP(aVar.text)) {
            string = aVar.text;
        } else {
            if (aVar.wRn == 0) {
                aVar.wRn = R.string.dhm;
            }
            string = getString(aVar.wRn);
        }
        this.wRh.setText(string);
        this.wRh.setVisibility(0);
        this.wRi.setVisibility(0);
        this.wRj.setVisibility(0);
        final String str = getString(R.string.di2) + ": " + aVar.wRo;
        this.wRj.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.AnonymousClass10 */

            public final void onClick(View view) {
                AppMethodBeat.i(25027);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/freewifi/ui/FreeWifiFrontPageUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent();
                intent.putExtra("free_wifi_show_detail_error", 1);
                intent.putExtra("free_wifi_error_ui_error_msg", FreeWifiFrontPageUI.this.getString(R.string.dhl));
                intent.putExtra("free_wifi_error_ui_error_msg_detail1", str);
                intent.setClass(FreeWifiFrontPageUI.this, FreeWifiErrorUI.class);
                FreeWifiFrontPageUI freeWifiFrontPageUI = FreeWifiFrontPageUI.this;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(freeWifiFrontPageUI, bl.axQ(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiFrontPageUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                freeWifiFrontPageUI.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(freeWifiFrontPageUI, "com/tencent/mm/plugin/freewifi/ui/FreeWifiFrontPageUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/freewifi/ui/FreeWifiFrontPageUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(25027);
            }
        });
        this.wRy.setVisibility(0);
        this.wRy.setText(R.string.dil);
        Log.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=Protocol.toFail, desc=connect failed.", m.aw(getIntent()), Integer.valueOf(m.ax(getIntent())));
        AppMethodBeat.o(25043);
    }

    /* access modifiers changed from: protected */
    public final void dp(Object obj) {
        AppMethodBeat.i(25044);
        if (!(obj instanceof b)) {
            AppMethodBeat.o(25044);
            return;
        }
        ih ihVar = ((b) obj).wRL;
        if (!(this.wPz == 31 || this.wRA == null)) {
            this.wRA.dismiss();
        }
        this.wRy.setText(R.string.b9f);
        this.wRy.setClickable(false);
        Intent intent2 = getIntent();
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
                com.tencent.mm.br.c.b(this, Scopes.PROFILE, ".ui.ContactInfoUI", intent3);
                c.report();
                Log.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=toSuccess, desc=connect succeeded.", m.aw(getIntent()), Integer.valueOf(m.ax(getIntent())));
                k.a dMF = k.dMF();
                dMF.dFd = this.dFd;
                dMF.quX = m.aw(intent2);
                dMF.wNd = k.b.FrontPageUIClosedByGoContactInfoUI.wNO;
                dMF.wNe = k.b.FrontPageUIClosedByGoContactInfoUI.name;
                dMF.channel = m.az(intent2);
                dMF.wNc = m.ay(intent2);
                dMF.result = 0;
                dMF.resultMsg = "";
                dMF.dMH().c(intent2, true).dMG();
                AppMethodBeat.o(25044);
                return;
            }
            intent2.setClass(this, FreeWifiSuccUI.class);
        } else if (m.eP(ihVar.KMv)) {
            intent2.setClass(this, FreeWifiSuccUI.class);
        } else {
            intent2.putExtra("free_wifi_qinghuai_url", ihVar.KMv);
            intent2.setClass(this, FreeWifiSuccWebViewUI.class);
        }
        k.a dMF2 = k.dMF();
        dMF2.dFd = this.dFd;
        dMF2.quX = m.aw(intent2);
        dMF2.wNd = k.b.FrontPageUIClosedByGoSuc.wNO;
        dMF2.wNe = k.b.FrontPageUIClosedByGoSuc.name;
        dMF2.channel = m.az(intent2);
        dMF2.wNc = m.ay(intent2);
        dMF2.result = 0;
        dMF2.resultMsg = "";
        dMF2.dMH().c(intent2, true).dMG();
        finish();
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
        com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiFrontPageUI", "toSuccess", "(Ljava/lang/Object;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/freewifi/ui/FreeWifiFrontPageUI", "toSuccess", "(Ljava/lang/Object;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        c.report();
        Log.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=toSuccess, desc=connect succeeded.", m.aw(getIntent()), Integer.valueOf(m.ax(getIntent())));
        AppMethodBeat.o(25044);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void finish() {
        AppMethodBeat.i(25045);
        super.finish();
        k.a dMF = k.dMF();
        dMF.dFd = this.dFd;
        dMF.quX = m.aw(this.intent);
        dMF.wNd = k.b.FrontPageUIClosed.wNO;
        dMF.wNe = k.b.FrontPageUIClosed.name;
        dMF.channel = m.az(this.intent);
        dMF.wNc = m.ay(this.intent);
        dMF.result = 0;
        dMF.resultMsg = "";
        dMF.dMH().c(this.intent, true).dMG();
        AppMethodBeat.o(25045);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.ami;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(25046);
        if (i2 == 4 && keyEvent.getRepeatCount() == 0) {
            goBack();
            AppMethodBeat.o(25046);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(25046);
        return onKeyDown;
    }

    private void goBack() {
        AppMethodBeat.i(25047);
        l.S(com.tencent.mm.plugin.freewifi.model.d.dNe(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
        k.a dMF = k.dMF();
        dMF.dFd = this.dFd;
        dMF.quX = m.aw(this.intent);
        dMF.wNd = k.b.FrontPageUIClosedByGoBack.wNO;
        dMF.wNe = k.b.FrontPageUIClosedByGoBack.name;
        dMF.channel = m.az(this.intent);
        dMF.wNc = m.ay(this.intent);
        dMF.result = 0;
        dMF.resultMsg = "";
        dMF.dMH().c(this.intent, true).dMG();
        g.jRt.h(new Intent(), this);
        finish();
        AppMethodBeat.o(25047);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(25048);
        super.onDestroy();
        j.dNq().release();
        AppMethodBeat.o(25048);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(25049);
        if (iArr == null || iArr.length <= 0) {
            Log.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i2), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(25049);
            return;
        }
        Log.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i2), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i2) {
            case TPCodecParamers.TP_PROFILE_H264_MAIN /*{ENCODED_INT: 77}*/:
                if (iArr.length > 0 && iArr[0] == -1) {
                    this.rHi = false;
                    h.a((Context) this, getString(R.string.fl_), getString(R.string.flp), getString(R.string.e_k), getString(R.string.amn), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.AnonymousClass11 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(25028);
                            FreeWifiFrontPageUI freeWifiFrontPageUI = FreeWifiFrontPageUI.this;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            com.tencent.mm.hellhoundlib.a.a.a(freeWifiFrontPageUI, bl.axQ(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiFrontPageUI$9", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            freeWifiFrontPageUI.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(freeWifiFrontPageUI, "com/tencent/mm/plugin/freewifi/ui/FreeWifiFrontPageUI$9", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            FreeWifiFrontPageUI.this.finish();
                            AppMethodBeat.o(25028);
                        }
                    }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(25019);
                            FreeWifiFrontPageUI.this.finish();
                            AppMethodBeat.o(25019);
                        }
                    });
                    break;
                }
        }
        AppMethodBeat.o(25049);
    }

    public static class a {
        public static a wRK = new a();
        public String text;
        public int wRn;
        public String wRo;

        static {
            AppMethodBeat.i(25029);
            AppMethodBeat.o(25029);
        }
    }
}
