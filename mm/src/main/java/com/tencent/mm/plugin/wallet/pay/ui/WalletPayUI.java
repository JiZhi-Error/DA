package com.tencent.mm.plugin.wallet.pay.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.aaa;
import com.tencent.mm.g.a.aai;
import com.tencent.mm.g.a.zp;
import com.tencent.mm.g.a.zz;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.a.t;
import com.tencent.mm.plugin.wallet.pay.a.c.c;
import com.tencent.mm.plugin.wallet.pay.a.c.e;
import com.tencent.mm.plugin.wallet.pay.a.c.f;
import com.tencent.mm.plugin.wallet.pay.a.c.i;
import com.tencent.mm.plugin.wallet.pay.a.c.j;
import com.tencent.mm.plugin.wallet.pay.a.d;
import com.tencent.mm.plugin.wallet.pay.ui.a;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog;
import com.tencent.mm.plugin.wallet_core.ui.s;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ErrorCode;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.x;
import com.tencent.mm.wallet_core.c.af;
import com.tencent.mm.wallet_core.c.m;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.ui.MMScrollView;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.thumbplayer.api.TPPlayerMgr;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(7)
public class WalletPayUI extends WalletBaseUI implements a.AbstractC1904a {
    private static boolean HGP = false;
    private static List<b> HGQ = new ArrayList();
    protected com.tencent.mm.plugin.wallet.a CqM = null;
    private String Crn;
    private IListener Cuh = new IListener<aai>() {
        /* class com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.AnonymousClass12 */

        {
            AppMethodBeat.i(160867);
            this.__eventId = aai.class.getName().hashCode();
            AppMethodBeat.o(160867);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(aai aai) {
            AppMethodBeat.i(69399);
            aai aai2 = aai;
            Log.i(WalletPayUI.this.TAG, "WalletRealNameResultNotifyMoreEvent %s", Integer.valueOf(aai2.ehf.result));
            if (aai2.ehf.result == -1) {
                WalletPayUI.this.HHz = true;
                WalletPayUI.this.HHA = true;
                WalletPayUI.this.fOy();
            }
            AppMethodBeat.o(69399);
            return false;
        }
    };
    protected Orders CwO = null;
    protected Button Cwg;
    private d HFT = null;
    private f HGR = null;
    protected com.tencent.mm.plugin.wallet_core.ui.d HGS = null;
    private boolean HGT = false;
    protected boolean HGU = false;
    private d.a HGV;
    protected boolean HGW = false;
    protected String HGX = "";
    protected boolean HGY = false;
    public Bundle HGZ = null;
    public FavorPayInfo HGf = null;
    private a HGg;
    com.tencent.mm.plugin.wallet_core.ui.f HGh;
    private boolean HGi = false;
    private boolean HHA = false;
    private int HHB = 0;
    private Runnable HHC = new Runnable() {
        /* class com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(69386);
            Log.i(WalletPayUI.this.TAG, "auto reset create flag");
            boolean unused = WalletPayUI.HGP = false;
            AppMethodBeat.o(69386);
        }
    };
    private b HHD;
    private long HHE = 0;
    protected boolean HHa = false;
    protected TextView HHb;
    protected TextView HHc;
    private TextView HHd;
    protected TextView HHe;
    protected TextView HHf;
    protected TextView HHg;
    protected ImageView HHh;
    private TextView HHi;
    private TextView HHj;
    protected LinearLayout HHk;
    protected a HHl;
    public Dialog HHm;
    private long HHn = 0;
    private TextView HHo;
    private LinearLayout HHp;
    private boolean HHq = true;
    private boolean HHr = false;
    private boolean HHs = false;
    private boolean HHt = false;
    private boolean HHu = false;
    private int HHv = -1;
    private boolean HHw = false;
    private boolean HHx = false;
    private f HHy;
    private boolean HHz = false;
    protected ArrayList<Bankcard> Hva = null;
    protected Bankcard Hvb = null;
    public String TAG = "MicroMsg.WalletPayUI";
    private boolean isPaySuccess = false;
    public String krw = null;
    protected int mCount = 0;
    protected PayInfo mPayInfo = null;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletPayUI() {
        AppMethodBeat.i(69427);
        AppMethodBeat.o(69427);
    }

    static /* synthetic */ void a(WalletPayUI walletPayUI, f fVar) {
        AppMethodBeat.i(69481);
        walletPayUI.a(fVar);
        AppMethodBeat.o(69481);
    }

    static /* synthetic */ void e(WalletPayUI walletPayUI) {
        AppMethodBeat.i(69475);
        walletPayUI.fOA();
        AppMethodBeat.o(69475);
    }

    static /* synthetic */ void g(WalletPayUI walletPayUI) {
        AppMethodBeat.i(69477);
        walletPayUI.fOF();
        AppMethodBeat.o(69477);
    }

    static /* synthetic */ void i(WalletPayUI walletPayUI) {
        AppMethodBeat.i(69478);
        walletPayUI.setAuthState(true);
        AppMethodBeat.o(69478);
    }

    static /* synthetic */ void k(WalletPayUI walletPayUI) {
        AppMethodBeat.i(69479);
        walletPayUI.setAuthState(true);
        AppMethodBeat.o(69479);
    }

    static /* synthetic */ boolean m(WalletPayUI walletPayUI) {
        AppMethodBeat.i(69480);
        boolean fOk = walletPayUI.fOk();
        AppMethodBeat.o(69480);
        return fOk;
    }

    static {
        AppMethodBeat.i(69482);
        AppMethodBeat.o(69482);
    }

    private void aey(int i2) {
        AppMethodBeat.i(69428);
        this.HHB = i2;
        Log.i(this.TAG, "markForceFinish errorType %s %s", Integer.valueOf(i2), Util.getStack().toString());
        AppMethodBeat.o(69428);
    }

    class b {
        int aHK;
        WeakReference<WalletPayUI> mZg;
        long timestamp;

        private b() {
        }

        /* synthetic */ b(WalletPayUI walletPayUI, byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean shouldEnsureSoterConnection() {
        return true;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        String string;
        AppMethodBeat.i(69429);
        super.onCreate(bundle);
        super.setRequestedOrientation(1);
        this.TAG = "MicroMsg.WalletPayUI@" + hashCode();
        if (HGP) {
            Log.w(this.TAG, "has Undestory WalletPayUI!");
            h.INSTANCE.n(965, 1, 1);
            aey(2);
            finish();
            AppMethodBeat.o(69429);
            return;
        }
        HGP = true;
        long currentTimeMillis = System.currentTimeMillis();
        int intExtra = getIntent().getIntExtra("key_context_hashcode", -1);
        Log.i(this.TAG, "WalletPayUI check %s this %s fromHashCode %s", Integer.valueOf(HGQ.size()), Integer.valueOf(hashCode()), Integer.valueOf(intExtra));
        b[] bVarArr = (b[]) HGQ.toArray(new b[HGQ.size()]);
        for (b bVar : bVarArr) {
            WalletPayUI walletPayUI = bVar.mZg.get();
            if (walletPayUI != null) {
                Log.w(this.TAG, "has old payui, both finish %s", Integer.valueOf(walletPayUI.hashCode()));
                if (intExtra != bVar.aHK || intExtra == -1) {
                    walletPayUI.aey(1);
                    h.INSTANCE.n(965, 40, 1);
                } else {
                    walletPayUI.aey(2);
                    h.INSTANCE.n(965, 41, 1);
                }
                HGQ.remove(bVar);
                walletPayUI.finish();
            }
        }
        this.HHD = new b(this, (byte) 0);
        this.HHD.timestamp = currentTimeMillis;
        this.HHD.aHK = intExtra;
        this.HHD.mZg = new WeakReference<>(this);
        HGQ.add(this.HHD);
        if (!g.aAc()) {
            Log.e(this.TAG, "hy: account not ready. finish now");
            finish();
            AppMethodBeat.o(69429);
            return;
        }
        getWindow().getDecorView().postDelayed(this.HHC, 5000);
        this.HHE = Util.nowMilliSecond();
        EventCenter.instance.addListener(this.Cuh);
        k.aeJ(5);
        this.CqM = com.tencent.mm.plugin.wallet.a.be(getIntent());
        setMMTitle(R.string.io8);
        this.mPayInfo = getPayInfo();
        this.HGW = getIntent().getBooleanExtra("key_is_force_use_given_card", false);
        this.HGX = Util.nullAs(getIntent().getStringExtra("key_force_use_bind_serail"), "");
        this.Crn = getIntent().getStringExtra("key_receiver_true_name");
        if (this.mPayInfo == null || this.mPayInfo.Kxv == 0) {
            this.HHn = System.currentTimeMillis();
        } else {
            this.HHn = this.mPayInfo.Kxv;
        }
        s.fOg();
        if (!s.fOh().fRk()) {
            af.f(this.mPayInfo == null ? 0 : this.mPayInfo.dVv, this.mPayInfo == null ? "" : this.mPayInfo.dDL, 1, "");
        }
        if (!fOx()) {
            Log.d(this.TAG, "PayInfo = " + this.mPayInfo);
            if (this.mPayInfo == null || Util.isNullOrNil(this.mPayInfo.dDL)) {
                if (this.mPayInfo == null || Util.isNullOrNil(this.mPayInfo.errMsg)) {
                    string = getString(R.string.io1);
                } else {
                    string = this.mPayInfo.errMsg;
                }
                com.tencent.mm.ui.base.h.a((Context) this, string, (String) null, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.AnonymousClass23 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(69412);
                        WalletPayUI.this.finish();
                        AppMethodBeat.o(69412);
                    }
                });
            } else {
                fOy();
            }
            com.tencent.mm.plugin.secinforeport.a.d.INSTANCE.asyncReportPaySecurityInfoThroughCgi();
            initView();
        } else {
            Log.i(this.TAG, "hy: pay end on create. finish");
            finish();
        }
        if (this.mPayInfo != null) {
            com.tencent.mm.plugin.wallet.pay.a.b.aUR(this.mPayInfo.KxB);
        }
        AppMethodBeat.o(69429);
    }

    private boolean fOx() {
        AppMethodBeat.i(69430);
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey("intent_pay_end")) {
            Log.i(this.TAG, "hy: pay end. finish the activity");
            if (extras.getBoolean("intent_pay_end", false)) {
                Log.d(this.TAG, "pay done... errCode:" + extras.getInt("intent_pay_end_errcode"));
                Log.d(this.TAG, "pay done INTENT_PAY_APP_URL:" + extras.getString("intent_pay_app_url"));
                Log.d(this.TAG, "pay done INTENT_PAY_END:" + extras.getBoolean("intent_pay_end", false));
                m(-1, getIntent());
                this.isPaySuccess = true;
            } else {
                Log.d(this.TAG, "pay cancel");
                m(0, getIntent());
                this.isPaySuccess = false;
            }
            AppMethodBeat.o(69430);
            return true;
        } else if (extras == null || !extras.getBoolean("key_is_realname_verify_process")) {
            Log.i(this.TAG, "hy: pay not end");
            AppMethodBeat.o(69430);
            return false;
        } else {
            switch (extras.getInt("realname_verify_process_ret", 0)) {
                case -1:
                    AppMethodBeat.o(69430);
                    return true;
                default:
                    AppMethodBeat.o(69430);
                    return false;
            }
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(69431);
        if (this.HGg != null) {
            this.HGg.closeTipDialog();
            this.HGg.release();
        }
        EventCenter.instance.removeListener(this.Cuh);
        this.HGh = null;
        getWindow().getDecorView().removeCallbacks(this.HHC);
        HGQ.remove(this.HHD);
        HGP = false;
        long currentTimeMillis = System.currentTimeMillis();
        b[] bVarArr = (b[]) HGQ.toArray(new b[HGQ.size()]);
        for (b bVar : bVarArr) {
            WalletPayUI walletPayUI = bVar.mZg.get();
            if (walletPayUI != null && currentTimeMillis - bVar.timestamp > 600000) {
                Log.w(this.TAG, "has old payui, both finish");
                h.INSTANCE.n(965, 2, 1);
                HGQ.remove(bVar);
                walletPayUI.aey(1);
                walletPayUI.finish();
            }
        }
        if (this.mPayInfo != null) {
            com.tencent.mm.plugin.wallet.pay.a.b.aUS(this.mPayInfo.KxB);
        }
        setAuthState(false);
        super.onDestroy();
        AppMethodBeat.o(69431);
    }

    /* access modifiers changed from: protected */
    public void fOy() {
        f fVar;
        boolean z;
        int i2 = 2;
        AppMethodBeat.i(69432);
        h.INSTANCE.a(11850, 2, Integer.valueOf(this.mPayInfo.dVv));
        if (this.mPayInfo.dVv == 11) {
            i2 = 3;
        }
        PayInfo payInfo = this.mPayInfo;
        if (payInfo == null || Util.isNullOrNil(payInfo.dDL)) {
            Log.i("MicroMsg.CgiManager", "no payInfo or reqKey");
            fVar = null;
        } else {
            String str = payInfo.dDL;
            Log.i("MicroMsg.CgiManager", "qrorderinfo reqKey: %s", str);
            Log.i("MicroMsg.CgiManager", "qrorderinfo go new split cgi");
            if (str.startsWith("sns_aa_")) {
                fVar = new com.tencent.mm.plugin.wallet.pay.a.c.a(payInfo, i2);
            } else if (str.startsWith("sns_tf_")) {
                fVar = new j(payInfo, i2);
            } else if (str.startsWith("sns_ff_")) {
                fVar = new c(payInfo, i2);
            } else if (str.startsWith("ts_")) {
                fVar = new com.tencent.mm.plugin.wallet.pay.a.c.d(payInfo, i2);
            } else if (str.startsWith("sns_")) {
                fVar = new com.tencent.mm.plugin.wallet.pay.a.c.h(payInfo, i2);
            } else if (str.startsWith("offline_")) {
                fVar = new e(payInfo, i2);
            } else if (str.startsWith("up_")) {
                fVar = new com.tencent.mm.plugin.wallet.pay.a.c.k(payInfo, i2);
            } else if (str.startsWith("seb_ff_")) {
                fVar = new com.tencent.mm.plugin.wallet.pay.a.c.g(payInfo, i2);
            } else if (str.startsWith("tax_")) {
                fVar = new i(payInfo, i2);
            } else if (str.startsWith("dc_")) {
                fVar = new com.tencent.mm.plugin.wallet.pay.a.c.b(payInfo, i2);
            } else {
                fVar = new f(payInfo, i2);
            }
        }
        if (fVar != null) {
            fVar.setProcessName("PayProcess");
            fVar.setProcessSessionId(this.HHn);
            if (this.mPayInfo.dVv == 6 && this.mPayInfo.Kxr == 100) {
                fVar.setScene(100);
            } else {
                fVar.setScene(this.mPayInfo.dVv);
            }
            if (this.mPayInfo.Kxs) {
                z = true;
            } else {
                z = false;
            }
            doSceneProgress(fVar, true, z);
        }
        AppMethodBeat.o(69432);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onResume() {
        AppMethodBeat.i(69433);
        Log.i(this.TAG, "hy: onResume isFromH5RealNameVerify %s", Boolean.valueOf(this.HHz));
        if (!isProcessing()) {
            if (!Util.isNullOrNil(this.HGX)) {
                this.Hvb = fOI();
            } else if (this.Hvb == null) {
                s.fOg();
                this.Hvb = s.fOh().a(null, null, fOL(), false);
            } else {
                s.fOg();
                this.Hvb = s.fOh().a(null, this.Hvb.field_bindSerial, fOL(), false);
            }
        }
        if (this.HHA) {
            Log.i(this.TAG, "onResume isResumePassFinish");
            this.HHA = false;
        } else if (this.HGU && getContentViewVisibility() != 0 && (this.HHm == null || !this.HHm.isShowing())) {
            Log.i(this.TAG, "hy: has started process and is transparent and no pwd appeared. finish self");
            finish();
        } else if (this.HGh != null) {
            this.HGh.fSA();
        }
        super.onResume();
        AppMethodBeat.o(69433);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.c_i;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void finish() {
        Context context;
        AppMethodBeat.i(69434);
        Log.i(this.TAG, "finish %s %s mPayResultType:%s", Integer.valueOf(hashCode()), Util.getStack().toString(), Integer.valueOf(this.mPayResultType));
        cancelQRPay();
        if (this.CwO != null && !this.CwO.HZd.isEmpty()) {
            getIntent().putExtra("key_trans_id", this.CwO.HZd.get(0).dDM);
        }
        if (this.mPayInfo != null) {
            getIntent().putExtra("key_reqKey", this.mPayInfo.dDL);
        }
        if (this.isPaySuccess) {
            if (this.CwO != null) {
                getIntent().putExtra("key_total_fee", this.CwO.dDO);
            }
            getIntent().putExtra("key_pay_reslut_type", 1);
            m(-1, getIntent());
            setResult(-1, getIntent());
        } else {
            if (!(this.mPayInfo == null || this.mPayInfo.dVv != 8 || this.CwO == null)) {
                this.mPayInfo.Kxz = 0;
                doSceneProgress(com.tencent.mm.plugin.wallet.pay.a.a.a(fOC(), this.CwO, true), false);
                if (this.mPayInfo.iqp != null) {
                    h.INSTANCE.a(13956, 3, Long.valueOf(System.currentTimeMillis() - this.mPayInfo.iqp.getLong("extinfo_key_9")));
                }
            }
            m(0, getIntent());
            getIntent().putExtra("key_pay_reslut_type", this.mPayResultType);
            if (this.HHB == 1) {
                getIntent().putExtra("key_pay_reslut_type", 1000);
            } else if (this.HHB == 2) {
                getIntent().putExtra("key_pay_reslut_type", 1001);
            }
            setResult(0, getIntent());
            s.fOg();
            if (s.fOh().fRm()) {
                af.f(this.mPayInfo == null ? 0 : this.mPayInfo.dVv, this.mPayInfo == null ? "" : this.mPayInfo.dDL, 18, "");
            } else {
                s.fOg();
                if (s.fOh().fRl()) {
                    af.f(this.mPayInfo == null ? 0 : this.mPayInfo.dVv, this.mPayInfo == null ? "" : this.mPayInfo.dDL, 4, "");
                } else {
                    af.f(this.mPayInfo == null ? 0 : this.mPayInfo.dVv, this.mPayInfo == null ? "" : this.mPayInfo.dDL, 7, "");
                }
            }
            for (com.tencent.mm.wallet_core.d dVar : com.tencent.mm.wallet_core.a.bpk("PayProcess")) {
                dVar.K("specEndProcessWithoutFinish");
                if (dVar.dQL != null) {
                    dVar.dQL.clear();
                }
                com.tencent.mm.wallet_core.a.remove(dVar.getClass().hashCode());
                dVar.fOj();
            }
        }
        com.tencent.mm.wallet_core.d process = getProcess();
        if (process != null) {
            if (process.RrY != null) {
                context = process.RrY.get();
            } else {
                context = null;
            }
            if (this == context) {
                Log.i(this.TAG, "remove process end callback to prevent ui leak");
                process.hgH();
            }
        }
        super.finish();
        AppMethodBeat.o(69434);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(69435);
        if (i2 != 4) {
            boolean onKeyUp = super.onKeyUp(i2, keyEvent);
            AppMethodBeat.o(69435);
            return onKeyUp;
        } else if (isAuthDoing()) {
            Log.w(this.TAG, "block when authening");
            AppMethodBeat.o(69435);
            return true;
        } else {
            if (this.HHm == null || this.mPayInfo == null || !this.mPayInfo.crp || this.mNetSceneMgr.isProcessing()) {
                hideVKB();
                showDialog(1000);
            } else {
                finish();
            }
            AppMethodBeat.o(69435);
            return true;
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onNewIntent(Intent intent) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(69436);
        Log.i(this.TAG, "onNewIntent");
        setIntent(intent);
        if (!fOx()) {
            Log.w(this.TAG, "hy: pay not end if judge from intent, but should finish this ui, and set cancel event");
            if (intent.getBooleanExtra("send_cancel_event", true)) {
                m(0, getIntent());
            }
            this.isPaySuccess = false;
        }
        if (intent.getBooleanExtra("direc_change_bankcard", false)) {
            xX(true);
            AppMethodBeat.o(69436);
            return;
        }
        if (intent == null || !intent.getBooleanExtra("intent_bind_end", false)) {
            z = false;
        } else {
            this.HHr = true;
            z = true;
        }
        if (z) {
            Log.i(this.TAG, "isFromBindCard is true");
            fOy();
            AppMethodBeat.o(69436);
            return;
        }
        if (intent == null || !intent.getBooleanExtra("key_is_realname_verify_process", false)) {
            z2 = false;
        } else {
            this.HHs = true;
        }
        if (z2) {
            Log.i(this.TAG, "isFromRealNameVerify is true");
            finish();
        } else {
            Log.e(this.TAG, "isFromBindCard is false,isFromRealNameVerify is false");
        }
        finish();
        AppMethodBeat.o(69436);
    }

    private void m(int i2, Intent intent) {
        AppMethodBeat.i(69437);
        if (!(this.mPayInfo == null || this.mPayInfo.dVv != 46 || this.CwO == null)) {
            intent.putExtra("key_total_fee", this.CwO.dDO);
            Log.i(this.TAG, "sentCancelEvent set fee:%s", Double.valueOf(this.CwO.dDO));
        }
        aaa aaa = new aaa();
        aaa.egJ.intent = intent;
        if (this.HHB == 1) {
            aaa.egJ.egK = 1000;
        } else if (this.HHB == 2) {
            aaa.egJ.egK = 1001;
        }
        aaa.egJ.result = i2;
        aaa.egJ.dDL = this.mPayInfo == null ? "" : this.mPayInfo.dDL;
        aaa.egJ.egM = 1;
        if (this.mPayInfo != null && i2 == 0) {
            com.tencent.mm.plugin.wallet.pay.a.b.b.aD(this.mPayInfo.dDL, this.mPayInfo.dVv, this.mPayInfo.channel);
        }
        EventCenter.instance.publish(aaa);
        AppMethodBeat.o(69437);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(69438);
        ao.e(getWindow());
        MMScrollView mMScrollView = (MMScrollView) findViewById(R.id.ji9);
        mMScrollView.a(mMScrollView, mMScrollView);
        this.Cwg = (Button) findViewById(R.id.jhp);
        this.Cwg.setClickable(false);
        this.Cwg.setEnabled(false);
        this.HHb = (TextView) findViewById(R.id.jhe);
        this.HHc = (TextView) findViewById(R.id.jhd);
        this.HHe = (TextView) findViewById(R.id.jgw);
        this.HHj = (TextView) findViewById(R.id.jgs);
        this.HHd = (TextView) findViewById(R.id.jh2);
        this.HHi = (TextView) findViewById(R.id.jhl);
        this.HHd.getPaint().setFlags(16);
        this.HHf = (TextView) findViewById(R.id.jhq);
        this.HHg = (TextView) findViewById(R.id.jhm);
        this.HHg.setOnClickListener(new x() {
            /* class com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.AnonymousClass28 */

            @Override // com.tencent.mm.ui.x
            public final void czW() {
                AppMethodBeat.i(69416);
                WalletPayUI.this.c(false, 0, "");
                AppMethodBeat.o(69416);
            }
        });
        this.HHh = (ImageView) findViewById(R.id.jgp);
        this.HHh.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.AnonymousClass29 */

            public final void onClick(View view) {
                AppMethodBeat.i(69417);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (WalletPayUI.this.HGY) {
                    WalletPayUI.this.HHh.setImageResource(R.drawable.any);
                    WalletPayUI.this.HGY = false;
                } else {
                    WalletPayUI.this.HHh.setImageResource(R.drawable.anz);
                    WalletPayUI.this.HGY = true;
                }
                WalletPayUI.this.HHl.notifyDataSetChanged();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(69417);
            }
        });
        this.HHk = (LinearLayout) findViewById(R.id.jgz);
        this.HHl = new a();
        this.Cwg.setOnClickListener(new x() {
            /* class com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.AnonymousClass30 */

            @Override // com.tencent.mm.ui.x
            public final void czW() {
                AppMethodBeat.i(69418);
                s.fOg();
                if (!s.fOh().fRl()) {
                    af.f(WalletPayUI.this.mPayInfo == null ? 0 : WalletPayUI.this.mPayInfo.dVv, WalletPayUI.this.mPayInfo == null ? "" : WalletPayUI.this.mPayInfo.dDL, 6, "");
                }
                WalletPayUI.this.fOE();
                WalletPayUI.this.HHa = true;
                AppMethodBeat.o(69418);
            }
        });
        this.Cwg.setText(R.string.imv);
        this.HHo = (TextView) findViewById(R.id.g_m);
        this.HHp = (LinearLayout) findViewById(R.id.g_l);
        updateView();
        AppMethodBeat.o(69438);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x014c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateView() {
        /*
        // Method dump skipped, instructions count: 419
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.updateView():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x01b3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void fOz() {
        /*
        // Method dump skipped, instructions count: 533
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.fOz():void");
    }

    private void fOA() {
        AppMethodBeat.i(69441);
        if (this.HHq) {
            this.Cwg.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.AnonymousClass2 */

                public final void onClick(View view) {
                    int i2 = 0;
                    AppMethodBeat.i(69387);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    s.fOg();
                    if (s.fOh().fRl()) {
                        af.f(WalletPayUI.this.mPayInfo == null ? 0 : WalletPayUI.this.mPayInfo.dVv, WalletPayUI.this.mPayInfo == null ? "" : WalletPayUI.this.mPayInfo.dDL, 6, "");
                    }
                    if (WalletPayUI.this.CwO.HZf == 1) {
                        s.fOg();
                        if (s.fOh().fRl()) {
                            if (WalletPayUI.this.mPayInfo != null) {
                                i2 = WalletPayUI.this.mPayInfo.dVv;
                            }
                            af.f(i2, WalletPayUI.this.mPayInfo == null ? "" : WalletPayUI.this.mPayInfo.dDL, 5, "");
                        }
                        WalletPayUI.f(WalletPayUI.this);
                    } else {
                        Log.i(WalletPayUI.this.TAG, "SimpleReg , assigned userinfo pay! payWithNewBankcard");
                        s.fOg();
                        if (s.fOh().fRl()) {
                            af.f(WalletPayUI.this.mPayInfo == null ? 0 : WalletPayUI.this.mPayInfo.dVv, WalletPayUI.this.mPayInfo == null ? "" : WalletPayUI.this.mPayInfo.dDL, 5, "");
                        }
                        WalletPayUI.this.c(false, 0, "");
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(69387);
                }
            });
            AppMethodBeat.o(69441);
            return;
        }
        this.Cwg.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(69388);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                WalletPayUI.this.fOE();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(69388);
            }
        });
        AppMethodBeat.o(69441);
    }

    public final void fOB() {
        boolean z;
        double d2;
        AppMethodBeat.i(69442);
        com.tencent.mm.plugin.wallet.a.j aVJ = this.HGS.aVJ(this.HGf.HXI);
        List<t> fSz = this.HGS.fSz();
        com.tencent.mm.plugin.wallet.a.h hVar = this.HGS.IcO;
        String str = "";
        if (aVJ != null) {
            d2 = aVJ.HEA;
            if (d2 > 0.0d) {
                str = aVJ.HEC;
                z = true;
                if (!Util.isNullOrNil(aVJ.HED)) {
                    str = str + "," + aVJ.HED;
                }
            } else {
                z = false;
            }
        } else {
            z = false;
            d2 = 0.0d;
        }
        if (!z && fSz.size() > 0) {
            str = str + getContext().getString(R.string.ip6);
        }
        if (d2 <= 0.0d || hVar == null || hVar.HEw != 0) {
            this.HHb.setText(com.tencent.mm.wallet_core.ui.f.formatMoney2f(this.CwO.dDO));
            this.HHe.setText(com.tencent.mm.wallet_core.ui.f.bpq(this.CwO.AOl));
            this.HHd.setVisibility(8);
        } else {
            if (aVJ != null) {
                this.HHb.setText(com.tencent.mm.wallet_core.ui.f.formatMoney2f(aVJ.HEz));
            }
            this.HHe.setText(com.tencent.mm.wallet_core.ui.f.bpq(this.CwO.AOl));
            this.HHd.setText(com.tencent.mm.wallet_core.ui.f.d(this.CwO.dDO, this.CwO.AOl));
            this.HHd.setVisibility(0);
        }
        if (!Util.isNullOrNil(str)) {
            this.HHj.setText(str);
        }
        AppMethodBeat.o(69442);
    }

    /* access modifiers changed from: protected */
    public final Authen fOC() {
        AppMethodBeat.i(69443);
        Authen authen = new Authen();
        if (fOD()) {
            authen.cSx = 3;
        } else {
            authen.cSx = 6;
        }
        if (!Util.isNullOrNil(this.krw)) {
            authen.HUO = this.krw;
        }
        if (this.Hvb != null) {
            authen.ANo = this.Hvb.field_bindSerial;
            authen.dDj = this.Hvb.field_bankcardType;
        }
        if (!(this.HGf == null || this.HGS == null || !this.HGS.fSw())) {
            authen.HUY = this.HGf.HXI;
            authen.HUX = this.HGf.HXL;
        }
        authen.BDB = this.mPayInfo;
        AppMethodBeat.o(69443);
        return authen;
    }

    /* access modifiers changed from: protected */
    public final boolean fOD() {
        AppMethodBeat.i(69444);
        if (this.Hvb == null || this.CwO == null || this.CwO.HQg != 3) {
            if (this.CwO == null || Bankcard.aeI(this.CwO.HQg)) {
                AppMethodBeat.o(69444);
                return false;
            }
            AppMethodBeat.o(69444);
            return true;
        } else if (this.Hvb.fQe()) {
            AppMethodBeat.o(69444);
            return true;
        } else {
            AppMethodBeat.o(69444);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public final void fOE() {
        AppMethodBeat.i(69445);
        xW(true);
        AppMethodBeat.o(69445);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void xW(boolean r12) {
        /*
        // Method dump skipped, instructions count: 489
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.xW(boolean):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0080, code lost:
        if (r2.HEs == 0.0d) goto L_0x0082;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void fOF() {
        /*
        // Method dump skipped, instructions count: 645
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.fOF():void");
    }

    private void fOG() {
        AppMethodBeat.i(69448);
        xY(true);
        com.tencent.mm.plugin.wallet_core.utils.f.fUi();
        AppMethodBeat.o(69448);
    }

    private boolean fOk() {
        AppMethodBeat.i(69449);
        int intValue = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_FORCE_USE_NEW_CASHIER_INT_SYNC, (Object) 0)).intValue();
        if (CrashReportFactory.hasDebuger() || BuildInfo.IS_FLAVOR_RED || BuildInfo.IS_FLAVOR_PURPLE) {
            intValue = 1;
        }
        if (intValue == 1 || (this.CwO != null && this.CwO.HZA == 1)) {
            AppMethodBeat.o(69449);
            return true;
        }
        AppMethodBeat.o(69449);
        return false;
    }

    /* access modifiers changed from: protected */
    public void fOs() {
        AppMethodBeat.i(69450);
        xX(false);
        AppMethodBeat.o(69450);
    }

    /* access modifiers changed from: protected */
    public final void xX(boolean z) {
        int i2;
        String str;
        boolean z2;
        boolean z3 = false;
        AppMethodBeat.i(69451);
        if (!bqg()) {
            AppMethodBeat.o(69451);
            return;
        }
        this.HGi = false;
        Log.i(this.TAG, "pay with old bankcard! from statck %s", Util.getStack().toString());
        if (this.mPayInfo == null) {
            i2 = 0;
        } else {
            i2 = this.mPayInfo.dVv;
        }
        if (this.mPayInfo == null) {
            str = "";
        } else {
            str = this.mPayInfo.dDL;
        }
        af.f(i2, str, 8, "");
        if (this.HHm != null) {
            Log.w(this.TAG, "close previous cashier dialog");
            this.HHm.dismiss();
        }
        this.HGi = false;
        if (fOk()) {
            this.HHm = new WcPayCashierDialog(getContext());
            WcPayCashierDialog wcPayCashierDialog = (WcPayCashierDialog) this.HHm;
            PayInfo payInfo = this.mPayInfo;
            Orders orders = this.CwO;
            FavorPayInfo favorPayInfo = this.HGf;
            Bankcard bankcard = this.Hvb;
            if (!this.HGW) {
                z3 = true;
            }
            wcPayCashierDialog.a(payInfo, orders, favorPayInfo, bankcard, z3, z);
            wcPayCashierDialog.IlX = new WcPayCashierDialog.a() {
                /* class com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.AnonymousClass7 */

                @Override // com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog.a
                public final void a(String str, FavorPayInfo favorPayInfo, Bankcard bankcard) {
                    int i2;
                    String str2;
                    AppMethodBeat.i(69392);
                    if (WalletPayUI.this.HGi) {
                        Log.w(WalletPayUI.this.TAG, "has received canceled");
                        h.INSTANCE.n(965, 3, 1);
                        AppMethodBeat.o(69392);
                        return;
                    }
                    WalletPayUI.i(WalletPayUI.this);
                    WalletPayUI.this.hideVKB();
                    WalletPayUI.this.HGf = favorPayInfo;
                    WalletPayUI.this.Hvb = bankcard;
                    String str3 = WalletPayUI.this.TAG;
                    Object[] objArr = new Object[1];
                    objArr[0] = WalletPayUI.this.HGf == null ? "" : WalletPayUI.this.HGf.toString();
                    Log.i(str3, "WalletPwdDialog showAlert with favinfo %s", objArr);
                    if (!Util.isNullOrNil(str)) {
                        if (WalletPayUI.this.mPayInfo == null) {
                            i2 = 0;
                        } else {
                            i2 = WalletPayUI.this.mPayInfo.dVv;
                        }
                        if (WalletPayUI.this.mPayInfo == null) {
                            str2 = "";
                        } else {
                            str2 = WalletPayUI.this.mPayInfo.dDL;
                        }
                        af.f(i2, str2, 9, "");
                    }
                    WalletPayUI.this.krw = str;
                    WalletPayUI.this.xY(false);
                    com.tencent.mm.plugin.wallet_core.utils.f.fUi();
                    AppMethodBeat.o(69392);
                }

                @Override // com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog.a
                public final void onCancel() {
                    AppMethodBeat.i(69393);
                    Log.i(WalletPayUI.this.TAG, "cashier dialog canceled");
                    WalletPayUI.this.HGi = true;
                    af.f(WalletPayUI.this.mPayInfo == null ? 0 : WalletPayUI.this.mPayInfo.dVv, WalletPayUI.this.mPayInfo == null ? "" : WalletPayUI.this.mPayInfo.dDL, 10, "");
                    if (WalletPayUI.this.isTransparent()) {
                        WalletPayUI.this.finish();
                    }
                    AppMethodBeat.o(69393);
                }

                @Override // com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog.a
                public final void fNc() {
                    AppMethodBeat.i(69394);
                    Log.i(WalletPayUI.this.TAG, "click add new bankcard");
                    com.tencent.mm.plugin.wallet_core.model.g fQl = com.tencent.mm.plugin.wallet_core.model.g.fQl();
                    if (fQl.bJw()) {
                        com.tencent.mm.ui.base.h.c(WalletPayUI.this.getContext(), fQl.ANp, WalletPayUI.this.getString(R.string.zb), true);
                        AppMethodBeat.o(69394);
                        return;
                    }
                    af.f(WalletPayUI.this.mPayInfo == null ? 0 : WalletPayUI.this.mPayInfo.dVv, WalletPayUI.this.mPayInfo == null ? "" : WalletPayUI.this.mPayInfo.dDL, 14, "");
                    WalletPayUI.this.HHm.dismiss();
                    WalletPayUI.this.HHm = null;
                    WalletPayUI.this.fOH();
                    AppMethodBeat.o(69394);
                }
            };
            wcPayCashierDialog.show();
            addDialog(wcPayCashierDialog);
            AppMethodBeat.o(69451);
            return;
        }
        if (!this.HGW) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.HHm = com.tencent.mm.plugin.wallet_core.ui.s.a(this, z2, this.CwO, this.HGf, this.Hvb, this.mPayInfo, this.Crn, new s.c() {
            /* class com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.AnonymousClass8 */

            @Override // com.tencent.mm.plugin.wallet_core.ui.s.c
            public final void a(String str, FavorPayInfo favorPayInfo, boolean z) {
                AppMethodBeat.i(69395);
                if (WalletPayUI.this.HGi) {
                    Log.w(WalletPayUI.this.TAG, "has received canceled");
                    h.INSTANCE.n(965, 3, 1);
                    AppMethodBeat.o(69395);
                    return;
                }
                WalletPayUI.k(WalletPayUI.this);
                WalletPayUI.this.hideVKB();
                WalletPayUI.this.HGf = favorPayInfo;
                String str2 = WalletPayUI.this.TAG;
                Object[] objArr = new Object[2];
                objArr[0] = WalletPayUI.this.HGf == null ? "" : WalletPayUI.this.HGf.toString();
                objArr[1] = Boolean.valueOf(z);
                Log.i(str2, "WalletPwdDialog showAlert with favinfo %s isNeedChangeBankcard %s", objArr);
                if (WalletPayUI.this.HGf == null || !z) {
                    if (!Util.isNullOrNil(str)) {
                        af.f(WalletPayUI.this.mPayInfo == null ? 0 : WalletPayUI.this.mPayInfo.dVv, WalletPayUI.this.mPayInfo == null ? "" : WalletPayUI.this.mPayInfo.dDL, 9, "");
                    }
                    WalletPayUI.this.krw = str;
                    WalletPayUI.this.xY(false);
                    com.tencent.mm.plugin.wallet_core.utils.f.fUi();
                    WalletPayUI.this.HGh = null;
                    AppMethodBeat.o(69395);
                    return;
                }
                WalletPayUI.this.bo(-100, true);
                AppMethodBeat.o(69395);
            }
        }, new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.AnonymousClass9 */

            public final void onClick(View view) {
                AppMethodBeat.i(69396);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i(WalletPayUI.this.TAG, "WalletPwdDialog event1 %s", Util.getStack().toString());
                WalletPayUI.this.HGf = (FavorPayInfo) view.getTag();
                if (WalletPayUI.this.HGf != null) {
                    WalletPayUI.this.HGf.HXM = "";
                }
                WalletPayUI.this.d(false, 0, "");
                WalletPayUI.this.HHm.dismiss();
                WalletPayUI.this.krw = null;
                WalletPayUI.this.HHm = null;
                WalletPayUI.this.HGh = null;
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(69396);
            }
        }, new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.AnonymousClass10 */

            public final void onCancel(DialogInterface dialogInterface) {
                int i2 = 0;
                AppMethodBeat.i(69397);
                Log.i(WalletPayUI.this.TAG, "WalletPwdDialog event2 %s", Util.getStack().toString());
                WalletPayUI.this.mPayResultType = 4;
                WalletPayUI.this.HGi = true;
                if (WalletPayUI.this.mPayInfo != null) {
                    i2 = WalletPayUI.this.mPayInfo.dVv;
                }
                af.f(i2, WalletPayUI.this.mPayInfo == null ? "" : WalletPayUI.this.mPayInfo.dDL, 10, "");
                if (dialogInterface != null) {
                    dialogInterface.dismiss();
                }
                WalletPayUI.this.krw = null;
                WalletPayUI.this.HHm = null;
                if (WalletPayUI.this.isTransparent()) {
                    WalletPayUI.this.finish();
                }
                WalletPayUI.this.HGh = null;
                AppMethodBeat.o(69397);
            }
        });
        this.HGh = (com.tencent.mm.plugin.wallet_core.ui.f) this.HHm;
        AppMethodBeat.o(69451);
    }

    /* access modifiers changed from: protected */
    public final void c(boolean z, int i2, String str) {
        String str2;
        AppMethodBeat.i(69452);
        String str3 = this.TAG;
        StringBuilder sb = new StringBuilder("pay with new bankcard! user's wxpay register status :");
        com.tencent.mm.plugin.wallet.a.s.fOg();
        Log.d(str3, sb.append(com.tencent.mm.plugin.wallet.a.s.fOh().fRk()).append(", need confirm ? ").append(z).toString());
        if (z) {
            if (Util.isNullOrNil(str)) {
                str2 = Bankcard.au(this, i2);
            } else {
                str2 = str;
            }
            com.tencent.mm.ui.base.h.c(this, str2, "", getString(R.string.imy), getString(R.string.sz), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.AnonymousClass11 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(69398);
                    WalletPayUI.this.fOH();
                    AppMethodBeat.o(69398);
                }
            }, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.AnonymousClass13 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(69400);
                    if (WalletPayUI.this.isTransparent()) {
                        WalletPayUI.this.finish();
                    }
                    AppMethodBeat.o(69400);
                }
            });
            AppMethodBeat.o(69452);
            return;
        }
        fOH();
        AppMethodBeat.o(69452);
    }

    public final void d(boolean z, final int i2, String str) {
        String str2;
        AppMethodBeat.i(69453);
        Log.d(this.TAG, "pay with select bankcard! need confirm ? ".concat(String.valueOf(z)));
        if (z) {
            if (Util.isNullOrNil(str)) {
                str2 = Bankcard.au(this, i2);
            } else {
                str2 = str;
            }
            com.tencent.mm.ui.base.h.c(this, str2, "", getString(R.string.ing), getString(R.string.sz), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.AnonymousClass14 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(69401);
                    if (WalletPayUI.m(WalletPayUI.this)) {
                        WalletPayUI.this.xX(true);
                        AppMethodBeat.o(69401);
                        return;
                    }
                    WalletPayUI.this.bo(i2, false);
                    AppMethodBeat.o(69401);
                }
            }, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.AnonymousClass15 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(69402);
                    if (WalletPayUI.this.isTransparent()) {
                        WalletPayUI.this.finish();
                    }
                    AppMethodBeat.o(69402);
                }
            });
            AppMethodBeat.o(69453);
        } else if (fOk()) {
            xX(true);
            AppMethodBeat.o(69453);
        } else {
            bo(i2, false);
            AppMethodBeat.o(69453);
        }
    }

    /* access modifiers changed from: protected */
    public final void fOH() {
        AppMethodBeat.i(69454);
        Bundle extras = getIntent().getExtras();
        com.tencent.mm.plugin.wallet.a.s.fOg();
        extras.putInt("key_pay_flag", com.tencent.mm.plugin.wallet.a.s.fOh().fRk() ? 2 : 1);
        extras.putParcelable("key_orders", this.CwO);
        extras.putParcelable("key_pay_info", this.mPayInfo);
        extras.putParcelable("key_favor_pay_info", this.HGf);
        aI(extras);
        AppMethodBeat.o(69454);
    }

    /* access modifiers changed from: protected */
    public final void bo(int i2, boolean z) {
        int i3 = 0;
        AppMethodBeat.i(69455);
        h.INSTANCE.a(13958, 2);
        h.INSTANCE.a(13955, 4);
        if (this.mPayInfo != null) {
            i3 = this.mPayInfo.dVv;
        }
        af.f(i3, this.mPayInfo == null ? "" : this.mPayInfo.dDL, 11, "");
        Bundle input = getInput();
        input.putInt("key_main_bankcard_state", i2);
        input.putParcelable("key_orders", this.CwO);
        input.putParcelable("key_pay_info", this.mPayInfo);
        input.putParcelable("key_authen", fOC());
        input.putString("key_pwd1", this.krw);
        input.putInt("key_pay_flag", 3);
        input.putInt("key_err_code", -1004);
        input.putParcelable("key_favor_pay_info", this.HGf);
        input.putBoolean("key_is_filter_bank_type", z);
        if (this.Hvb != null) {
            input.putString("key_is_cur_bankcard_bind_serial", this.Hvb.field_bindSerial);
        }
        aI(input);
        AppMethodBeat.o(69455);
    }

    private void a(f fVar) {
        AppMethodBeat.i(69456);
        Log.i(this.TAG, "stopRealname realnameGuideFlag %s guide_type %s", fVar.egd, Integer.valueOf(fVar.HFS));
        if ("1".equals(fVar.egd) || "2".equals(fVar.egd)) {
            this.HHy = fVar;
        } else {
            this.HHy = null;
        }
        this.HFT = fVar.HFT;
        this.HHw = true;
        this.CwO = fVar.CwO;
        this.mCount = this.CwO != null ? this.CwO.HZd.size() : 0;
        Log.d(this.TAG, "get mOrders! bankcardTag : " + (this.CwO != null ? Integer.valueOf(this.CwO.HQg) : ""));
        bqg();
        if (!(this.CwO == null || this.CwO.HZe == null)) {
            this.HGS = com.tencent.mm.plugin.wallet_core.ui.e.INSTANCE.a(this.CwO);
            if (this.HGS != null) {
                if (this.HGS.fSz().size() > 0) {
                    this.HGT = true;
                }
                this.HGf = this.HGS.aVM(this.CwO.HZe.HEt);
                this.HGf.HXI = this.HGS.aVN(this.HGf.HXI);
                Log.i(this.TAG, "onSceneEnd init favInfo id favorComposeId %s selectedFavorCompId %s selectedFavorCompId %s  mFavorPayInfo %s", this.CwO.HZe.HEt, this.HGf.HXI, this.HGf.HXI, this.HGf.toString());
            }
        }
        if (!(this.CwO == null || this.Hva == null || this.mPayInfo == null)) {
            com.tencent.mm.plugin.wallet_core.utils.f.a(this.mPayInfo, this.CwO);
            h hVar = h.INSTANCE;
            Object[] objArr = new Object[5];
            objArr[0] = Integer.valueOf(this.mPayInfo.dVv);
            objArr[1] = 0;
            com.tencent.mm.plugin.wallet.a.s.fOg();
            objArr[2] = Integer.valueOf(com.tencent.mm.plugin.wallet.a.s.fOh().fRk() ? 2 : 1);
            objArr[3] = Integer.valueOf((int) (this.CwO.dDO * 100.0d));
            objArr[4] = this.CwO.AOl;
            hVar.a(10690, objArr);
        }
        if (!(this.CwO == null || this.CwO.HZd == null)) {
            LinkedList<String> linkedList = new LinkedList<>();
            for (Orders.Commodity commodity : this.CwO.HZd) {
                linkedList.add(commodity.dDM);
            }
            if (linkedList.size() > 0) {
                zz zzVar = new zz();
                zzVar.egG.egI = linkedList;
                EventCenter.instance.publish(zzVar);
                if (this.CqM != null) {
                    this.CqM.cG(10001, linkedList.get(0));
                }
            }
        }
        if (this.CwO != null && this.CwO.HZB != null && this.CwO.HZB.Iaw == 1 && !Util.isNullOrNil(this.CwO.HZB.ANo)) {
            this.HGW = true;
            this.HGX = this.CwO.HZB.ANo;
        }
        com.tencent.mm.plugin.wallet.a.s.fOg();
        this.Hva = com.tencent.mm.plugin.wallet.a.s.fOh().yk(fOL());
        if (!Util.isNullOrNil(this.HGX)) {
            this.Hvb = fOI();
        } else {
            com.tencent.mm.plugin.wallet.a.s.fOg();
            this.Hvb = com.tencent.mm.plugin.wallet.a.s.fOh().a(null, null, fOL(), false);
        }
        String nullAs = Util.nullAs(getIntent().getStringExtra("key_is_use_default_card"), "");
        if (!Util.isNullOrNil(nullAs)) {
            this.Hvb = aUY(nullAs);
        }
        this.Cwg.setClickable(true);
        if (!Util.isNullOrNil(com.tencent.mm.plugin.wallet_core.model.t.fQI().IbY)) {
            this.HHi.setVisibility(0);
            this.HHi.setText(com.tencent.mm.plugin.wallet_core.model.t.fQI().IbY);
        } else {
            this.HHi.setVisibility(8);
            this.HHi.setText("");
        }
        if (!(this.CwO == null || this.Hva == null || this.mPayInfo == null)) {
            com.tencent.mm.plugin.wallet_core.utils.f.a(this.mPayInfo, this.CwO);
            h hVar2 = h.INSTANCE;
            Object[] objArr2 = new Object[5];
            objArr2[0] = Integer.valueOf(this.mPayInfo.dVv);
            objArr2[1] = 0;
            com.tencent.mm.plugin.wallet.a.s.fOg();
            objArr2[2] = Integer.valueOf(com.tencent.mm.plugin.wallet.a.s.fOh().fRk() ? 2 : 1);
            objArr2[3] = Integer.valueOf((int) (this.CwO.dDO * 100.0d));
            objArr2[4] = this.CwO.AOl;
            hVar2.a(10690, objArr2);
        }
        if (this.HHr) {
            bo(0, false);
        }
        long j2 = getPayInfo().iqp == null ? 0 : getPayInfo().iqp.getLong("wallet_pay_key_check_time");
        if (j2 > 0) {
            h.INSTANCE.idkeyStat(641, 4, 1, true);
            h.INSTANCE.idkeyStat(641, 5, Util.milliSecondsToNow(j2), true);
        }
        if (this.HHE > 0) {
            h.INSTANCE.idkeyStat(641, 7, 1, true);
            h.INSTANCE.idkeyStat(641, 8, Util.milliSecondsToNow(this.HHE), true);
        }
        AppMethodBeat.o(69456);
    }

    @Override // com.tencent.mm.wallet_core.d.f, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onSceneEnd(int i2, int i3, String str, q qVar, boolean z) {
        AppMethodBeat.i(69457);
        super.onSceneEnd(i2, i3, str, qVar, z);
        if (qVar instanceof com.tencent.mm.plugin.wallet.pay.a.a.b) {
            setAuthState(false);
        }
        AppMethodBeat.o(69457);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, final int i3, String str, q qVar) {
        String str2;
        boolean z;
        AppMethodBeat.i(69458);
        Log.i(this.TAG, "errorType %s errCode %s, errmsg %s, scene %s", Integer.valueOf(i2), Integer.valueOf(i3), str, qVar);
        if (i2 == 0 && i3 == 0) {
            if (qVar instanceof f) {
                this.mPayResultType = 1;
                this.HGR = (f) qVar;
                final f fVar = (f) qVar;
                if (fVar.isJumpRemind()) {
                    final m jumpRemind = fVar.getJumpRemind();
                    jumpRemind.hhn();
                    jumpRemind.a(this, new com.tencent.mm.wallet_core.c.f() {
                        /* class com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.AnonymousClass16 */

                        @Override // com.tencent.mm.wallet_core.c.f
                        public final void onCancel() {
                            AppMethodBeat.i(69403);
                            if (jumpRemind.hhm()) {
                                WalletPayUI.a(WalletPayUI.this, fVar);
                                AppMethodBeat.o(69403);
                                return;
                            }
                            WalletPayUI.this.finish();
                            AppMethodBeat.o(69403);
                        }

                        @Override // com.tencent.mm.wallet_core.c.f
                        public final void onEnter() {
                        }

                        @Override // com.tencent.mm.wallet_core.c.f
                        public final void onUrlOk() {
                            AppMethodBeat.i(69404);
                            if (jumpRemind.hhm()) {
                                WalletPayUI.a(WalletPayUI.this, fVar);
                                AppMethodBeat.o(69404);
                                return;
                            }
                            WalletPayUI.this.fOy();
                            AppMethodBeat.o(69404);
                        }

                        @Override // com.tencent.mm.wallet_core.c.f
                        public final void onUrlCancel() {
                            AppMethodBeat.i(69405);
                            if (jumpRemind.hhm()) {
                                WalletPayUI.a(WalletPayUI.this, fVar);
                                AppMethodBeat.o(69405);
                                return;
                            }
                            WalletPayUI.this.finish();
                            AppMethodBeat.o(69405);
                        }
                    });
                    AppMethodBeat.o(69458);
                    return true;
                }
                a(fVar);
            } else if (qVar instanceof com.tencent.mm.plugin.wallet.pay.a.a.b) {
                this.mPayResultType = 1;
                com.tencent.mm.plugin.wallet.pay.a.a.b bVar = (com.tencent.mm.plugin.wallet.pay.a.a.b) qVar;
                Bundle input = getInput();
                input.putParcelable("key_pay_info", this.mPayInfo);
                input.putParcelable("key_bankcard", this.Hvb);
                input.putString("key_bank_type", this.Hvb.field_bankcardType);
                if (!Util.isNullOrNil(this.krw)) {
                    input.putString("key_pwd1", this.krw);
                }
                input.putString("kreq_token", bVar.getToken());
                input.putParcelable("key_authen", bVar.HFI);
                input.putBoolean("key_need_verify_sms", !bVar.HFG);
                input.putInt("key_can_verify_tail", bVar.HFM);
                input.putString("key_verify_tail_wording", bVar.HFN);
                Bundle input2 = getInput();
                if (bVar.HFO == 1) {
                    z = true;
                } else {
                    z = false;
                }
                input2.putBoolean("key_block_bind_new_card", z);
                if (Util.isNullOrNil(bVar.HFJ)) {
                    input.putString("key_mobile", this.Hvb.field_mobile);
                } else {
                    input.putString("key_mobile", bVar.HFJ);
                }
                input.putString("key_QADNA_URL", bVar.HFK);
                if (bVar.isPaySuccess) {
                    if (this.CqM != null) {
                        this.CqM.cG(ErrorCode.ERROR_SYSLIB_OPEN_JPEG_FAIL, "");
                        com.tencent.mm.plugin.wallet.a aVar = this.CqM;
                        h.INSTANCE.a(13455, aVar.HsN, Long.valueOf(System.currentTimeMillis()), aVar.HsO);
                    }
                    input.putParcelable("key_orders", bVar.HFH);
                    if (this.mPayInfo != null) {
                        Log.i(this.TAG, "payscene %d", Integer.valueOf(this.mPayInfo.dVv));
                        if (8 == this.mPayInfo.dVv) {
                            g.aAi();
                            g.aAh().azQ().set(ar.a.USERINFO_ADDRESS_HAS_SHOW_WALLETOFFLINE2_DIALOG_BOOLEAN_SYNC, Boolean.TRUE);
                        }
                    }
                } else {
                    input.putParcelable("key_orders", this.CwO);
                }
                Bundle bundle = new Bundle();
                bundle.putString("pwd", this.krw);
                com.tencent.mm.plugin.fingerprint.b.a.i iVar = (com.tencent.mm.plugin.fingerprint.b.a.i) g.af(com.tencent.mm.plugin.fingerprint.b.a.i.class);
                int i4 = 0;
                if (iVar.dKn()) {
                    i4 = 1;
                } else if (iVar.dKo()) {
                    i4 = 2;
                }
                bundle.putInt("key_open_biometric_type", i4);
                iVar.a(bVar.fOm(), true, this.mPayInfo.HZb, bundle);
                input.putInt("key_pay_flag", 3);
                RealnameGuideHelper realnameGuideHelper = bVar.AJr;
                if (realnameGuideHelper != null) {
                    input.putParcelable("key_realname_guide_helper", realnameGuideHelper);
                }
                aI(input);
                AppMethodBeat.o(69458);
                return true;
            }
            updateView();
            AppMethodBeat.o(69458);
            return true;
        }
        if (qVar instanceof com.tencent.mm.plugin.wallet.pay.a.a.b) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("pwd", this.krw);
            ((com.tencent.mm.plugin.fingerprint.d.a) g.af(com.tencent.mm.plugin.fingerprint.d.a.class)).a(this.mPayInfo.Ijy == 1, false, bundle2);
            if (i3 == -1 || i3 == -500) {
                this.mPayResultType = 3;
            } else {
                this.mPayResultType = 2;
            }
            switch (i3) {
                case 402:
                case 403:
                case 408:
                    com.tencent.mm.plugin.wallet.pay.a.a.b bVar2 = (com.tencent.mm.plugin.wallet.pay.a.a.b) qVar;
                    this.HGZ = getInput();
                    this.HGZ.putParcelable("key_pay_info", this.mPayInfo);
                    this.HGZ.putParcelable("key_bankcard", this.Hvb);
                    if (!Util.isNullOrNil(this.krw)) {
                        this.HGZ.putString("key_pwd1", this.krw);
                    }
                    this.HGZ.putString("kreq_token", bVar2.getToken());
                    this.HGZ.putParcelable("key_authen", bVar2.HFI);
                    this.HGZ.putBoolean("key_need_verify_sms", !bVar2.HFG);
                    this.HGZ.putString("key_mobile", this.Hvb.field_mobile);
                    this.HGZ.putInt("key_err_code", i3);
                    this.HGZ.putParcelable("key_orders", this.CwO);
                    if (Util.isNullOrNil(str)) {
                        str2 = getString(R.string.io6, new Object[]{this.Hvb.field_desc, this.Hvb.field_mobile});
                    } else {
                        str2 = str;
                    }
                    com.tencent.mm.ui.base.h.c(this, str2, "", getString(R.string.io5), getString(R.string.sz), new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.AnonymousClass17 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(69406);
                            WalletPayUI.this.HGZ.putInt("key_pay_flag", 3);
                            WalletPayUI.this.aI(WalletPayUI.this.HGZ);
                            AppMethodBeat.o(69406);
                        }
                    }, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.AnonymousClass18 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(69407);
                            if (WalletPayUI.this.isTransparent()) {
                                WalletPayUI.this.finish();
                            }
                            AppMethodBeat.o(69407);
                        }
                    });
                    AppMethodBeat.o(69458);
                    return true;
                case 404:
                    if (!(this.Hvb == null || this.CwO == null)) {
                        this.Hvb.HVB = this.CwO.dDL;
                        if (this.mPayInfo != null && (this.mPayInfo.dVv == 45 || this.mPayInfo.dVv == 52)) {
                            com.tencent.mm.ui.base.h.a(getContext(), str, "", getString(R.string.x_), new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.AnonymousClass19 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    AppMethodBeat.i(69408);
                                    if (WalletPayUI.this.getProcess() != null) {
                                        com.tencent.mm.wallet_core.a.c(WalletPayUI.this.getContext(), WalletPayUI.this.getInput(), i3);
                                    }
                                    if (WalletPayUI.this.isTransparent()) {
                                        WalletPayUI.this.finish();
                                    }
                                    AppMethodBeat.o(69408);
                                }
                            });
                        } else if (this.Hva == null || this.Hva.size() <= 1) {
                            c(true, 4, str);
                        } else {
                            d(true, 4, str);
                        }
                        AppMethodBeat.o(69458);
                        return true;
                    }
                    break;
                case 100000:
                case TPPlayerMgr.EVENT_ID_APP_ENTER_BACKGROUND /*{ENCODED_INT: 100001}*/:
                case 100102:
                    this.mPayInfo.Kxu = i3;
                    fOs();
                    AppMethodBeat.o(69458);
                    return true;
                case 100100:
                case 100101:
                    this.mPayInfo.Kxu = i3;
                    boolean z2 = false;
                    if (i3 == 100100) {
                        z2 = true;
                    }
                    if (this.HGg == null) {
                        this.HGg = new a(this, this);
                    }
                    this.HGg.b(z2, this.mPayInfo.dNP, this.mPayInfo.dDL);
                    Log.i(this.TAG, "mRegenFingerPrintRsaKey.genRsaKey isGenRsa is ".concat(String.valueOf(z2)));
                    AppMethodBeat.o(69458);
                    return true;
            }
        } else if (qVar instanceof f) {
            this.HHw = true;
            fOJ();
            if (i3 == 416) {
                Log.e(this.TAG, "errCode is 416 need real name verify!");
                this.mPayResultType = 2;
                this.HHt = true;
                Bundle bundle3 = new Bundle();
                bundle3.putString("realname_verify_process_jump_activity", ".pay.ui.WalletPayUI");
                bundle3.putString("realname_verify_process_jump_plugin", "wallet");
                boolean a2 = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, i3, qVar, bundle3, this.mPayInfo != null ? this.mPayInfo.dVv : 0);
                AppMethodBeat.o(69458);
                return a2;
            }
            this.mPayResultType = 3;
            Log.i(this.TAG, "errCode is %d , not need real name verify!", Integer.valueOf(i3));
        }
        AppMethodBeat.o(69458);
        return false;
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean checkProcLife() {
        return false;
    }

    /* access modifiers changed from: protected */
    public class a {
        protected a() {
        }

        public final void notifyDataSetChanged() {
            int i2;
            AppMethodBeat.i(69426);
            WalletPayUI.this.HHk.removeAllViews();
            if (WalletPayUI.this.mCount == 0) {
                i2 = 0;
            } else if (WalletPayUI.this.HGY) {
                i2 = WalletPayUI.this.mCount;
            } else {
                i2 = 1;
            }
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -2);
            for (int i3 = 0; i3 < i2; i3++) {
                View inflate = ((LayoutInflater) WalletPayUI.this.getSystemService("layout_inflater")).inflate(R.layout.c_e, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R.id.jgo);
                TextView textView2 = (TextView) inflate.findViewById(R.id.jh9);
                Orders.Commodity commodity = WalletPayUI.this.CwO.HZd.get(i3);
                String str = "";
                if (WalletPayUI.this.mPayInfo != null && (WalletPayUI.this.mPayInfo.dVv == 32 || WalletPayUI.this.mPayInfo.dVv == 33 || WalletPayUI.this.mPayInfo.dVv == 31 || WalletPayUI.this.mPayInfo.dVv == 48)) {
                    String string = WalletPayUI.this.mPayInfo.iqp.getString("extinfo_key_1", "");
                    if (!Util.isNullOrNil(string)) {
                        g.aAi();
                        as bjJ = ((l) g.af(l.class)).aSN().bjJ(string);
                        if (bjJ != null) {
                            str = bjJ.arJ();
                        } else {
                            Log.e(WalletPayUI.this.TAG, "can not found contact for user::".concat(String.valueOf(string)));
                        }
                    } else {
                        Log.e(WalletPayUI.this.TAG, "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
                    }
                }
                if (commodity != null) {
                    if (!Util.isNullOrNil(str)) {
                        textView2.setText(str);
                        textView2.setVisibility(0);
                        ((TextView) inflate.findViewById(R.id.jh_)).setVisibility(0);
                    } else if (!Util.isNullOrNil(commodity.AOa)) {
                        textView2.setText(commodity.AOa);
                        textView2.setVisibility(0);
                        ((TextView) inflate.findViewById(R.id.jh_)).setVisibility(0);
                    } else {
                        ((TextView) inflate.findViewById(R.id.jh_)).setVisibility(8);
                        textView2.setVisibility(8);
                    }
                    if (!Util.isNullOrNil(commodity.desc)) {
                        textView.setText(commodity.desc);
                        textView.setVisibility(8);
                        ((TextView) inflate.findViewById(R.id.jgq)).setVisibility(8);
                    } else {
                        ((TextView) inflate.findViewById(R.id.jgq)).setVisibility(8);
                        textView.setVisibility(8);
                    }
                    if (!Util.isNullOrNil(str) || !Util.isNullOrNil(commodity.AOa)) {
                        inflate.setVisibility(0);
                    } else {
                        inflate.setVisibility(8);
                    }
                }
                inflate.setLayoutParams(layoutParams);
                inflate.measure(-2, -2);
                WalletPayUI.this.HHk.addView(inflate);
            }
            AppMethodBeat.o(69426);
        }
    }

    /* access modifiers changed from: protected */
    public final boolean bqg() {
        AppMethodBeat.i(69459);
        if (this.CwO == null || this.CwO.HZd == null || this.CwO.HZd.size() <= 0) {
            Log.w(this.TAG, "mOrders info is Illegal!");
            if (this.HGR == null || !this.HGR.isJumpRemind()) {
                String string = getString(R.string.ijv);
                if (this.HGR != null && !Util.isNullOrNil(this.HGR.errMsg)) {
                    string = this.HGR.errMsg;
                }
                Log.i(this.TAG, "checkInfo() errMsg:%s", string);
                com.tencent.mm.ui.base.h.d(getContext(), string, "", new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.AnonymousClass20 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(69409);
                        WalletPayUI.this.finish();
                        AppMethodBeat.o(69409);
                    }
                });
                AppMethodBeat.o(69459);
                return false;
            }
            AppMethodBeat.o(69459);
            return false;
        } else if (!this.HGW || Util.isNullOrNil(this.HGX) || fOI() != null) {
            AppMethodBeat.o(69459);
            return true;
        } else if (this.HGR == null || !this.HGR.isJumpRemind()) {
            Log.w(this.TAG, "hy: should use given bankcard, but resolved as null. show error msg and quit");
            String string2 = getString(R.string.ijv);
            if (this.HGR != null && !Util.isNullOrNil(this.HGR.errMsg)) {
                string2 = this.HGR.errMsg;
            }
            Log.i(this.TAG, "checkInfo() errMsg:%s", string2);
            com.tencent.mm.ui.base.h.d(getContext(), string2, "", new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.AnonymousClass21 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(214053);
                    WalletPayUI.this.finish();
                    AppMethodBeat.o(214053);
                }
            });
            AppMethodBeat.o(69459);
            return false;
        } else {
            AppMethodBeat.o(69459);
            return false;
        }
    }

    private Bankcard fOI() {
        AppMethodBeat.i(69460);
        com.tencent.mm.plugin.wallet.a.s.fOg();
        ArrayList<Bankcard> yj = com.tencent.mm.plugin.wallet.a.s.fOh().yj(true);
        if (yj.size() != 0) {
            Iterator<Bankcard> it = yj.iterator();
            while (it.hasNext()) {
                Bankcard next = it.next();
                if (Util.nullAsNil(this.HGX).equals(next.field_bindSerial)) {
                    Log.i(this.TAG, "hy: get given bankcard");
                    AppMethodBeat.o(69460);
                    return next;
                }
            }
        }
        AppMethodBeat.o(69460);
        return null;
    }

    private Bankcard aUY(String str) {
        AppMethodBeat.i(69461);
        com.tencent.mm.plugin.wallet.a.s.fOg();
        ArrayList<Bankcard> yj = com.tencent.mm.plugin.wallet.a.s.fOh().yj(true);
        if (yj.size() != 0) {
            Iterator<Bankcard> it = yj.iterator();
            while (it.hasNext()) {
                Bankcard next = it.next();
                if (Util.nullAsNil(str).equals(next.field_bindSerial)) {
                    Log.i(this.TAG, "hy: get given bankcard");
                    AppMethodBeat.o(69461);
                    return next;
                }
            }
        }
        AppMethodBeat.o(69461);
        return null;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(69462);
        Log.i(this.TAG, "onAcvityResult requestCode:" + i2 + ", resultCode:" + i3);
        switch (i2) {
            case 0:
                if (i3 == -1) {
                    if (intent != null) {
                        this.HHv = intent.getIntExtra("auto_deduct_flag", -1);
                        if (!(this.CwO == null || this.CwO.HZi == null)) {
                            this.CwO.HZi.HHv = this.HHv;
                        }
                        getPayInfo().Kxw = this.HHv;
                        if (this.HHv == 1) {
                            getPayInfo().Kxx = intent.getStringExtra("deduct_bank_type");
                            getPayInfo().Kxy = intent.getStringExtra("deduct_bind_serial");
                        }
                    }
                    this.HHu = true;
                    onProgressFinish();
                } else {
                    finish();
                }
                h.INSTANCE.a(13958, 3);
                AppMethodBeat.o(69462);
                return;
            case 1:
                this.HHm.dismiss();
                this.HHa = false;
                fOy();
                break;
        }
        AppMethodBeat.o(69462);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onProgressFinish() {
        boolean z = false;
        AppMethodBeat.i(69463);
        Log.i(this.TAG, "onProgressFinish isFromH5RealNameVerify %s", Boolean.valueOf(this.HHz));
        EventCenter.instance.publish(new zp());
        boolean z2 = (this.CwO == null || this.CwO.HZi == null || this.HHu) ? false : true;
        if (!z2 && !fOJ()) {
            af.f(this.mPayInfo == null ? 0 : this.mPayInfo.dVv, this.mPayInfo == null ? "" : this.mPayInfo.dDL, 2, "");
        }
        if (this.HHz) {
            xW(true);
            z = true;
        } else if (this.HHt) {
            z = true;
        } else if (z2) {
            Intent intent = new Intent(this, WalletPayDeductUI.class);
            intent.putExtra("orders", this.CwO);
            startActivityForResult(intent, 0);
            z = true;
        } else if (getContentView().getVisibility() != 0) {
            if (!this.HHa && bqg()) {
                xW(true);
                this.HHa = true;
            }
            z = true;
        } else if (getContentView().getVisibility() == 0 && this.CwO != null && this.CwO.HZi != null && this.Cwg.isEnabled() && !this.HHx) {
            this.Cwg.performClick();
            this.HHx = true;
        }
        AppMethodBeat.o(69463);
        return z;
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean isTransparent() {
        boolean z;
        boolean z2;
        AppMethodBeat.i(69464);
        if (this.HHw) {
            String str = this.TAG;
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(getPayInfo() == null || !getPayInfo().crp);
            objArr[1] = Util.getStack().toString();
            Log.i(str, "case 1 %s,  stack %s", objArr);
            String str2 = this.TAG;
            Object[] objArr2 = new Object[1];
            com.tencent.mm.plugin.wallet.a.s.fOg();
            if (!com.tencent.mm.plugin.wallet.a.s.fOh().fRk()) {
                z = true;
            } else {
                z = false;
            }
            objArr2[0] = Boolean.valueOf(z);
            Log.d(str2, "case 2 %s,", objArr2);
            String str3 = this.TAG;
            Object[] objArr3 = new Object[2];
            objArr3[0] = Integer.valueOf(this.Hva == null ? 0 : this.Hva.size());
            objArr3[1] = this.Hvb == null ? "" : this.Hvb.field_forbidWord;
            Log.d(str3, "case 3 mBankcardList %s, mDefaultBankcard %s", objArr3);
            if (getPayInfo() == null || !getPayInfo().crp) {
                Log.i(this.TAG, "get isTransparent1");
                AppMethodBeat.o(69464);
                return false;
            }
            com.tencent.mm.plugin.wallet.a.s.fOg();
            if (!com.tencent.mm.plugin.wallet.a.s.fOh().fRk()) {
                Log.i(this.TAG, "get isTransparent2");
                AppMethodBeat.o(69464);
                return false;
            } else if (this.Hva == null || (this.Hva.size() != 0 && (this.Hvb == null || Util.isNullOrNil(this.Hvb.field_forbidWord)))) {
                Log.i(this.TAG, "get isTransparent4");
                AppMethodBeat.o(69464);
                return true;
            } else {
                String str4 = this.TAG;
                Object[] objArr4 = new Object[2];
                if (this.Hva == null || this.Hva.size() != 0) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                objArr4[0] = Boolean.valueOf(z2);
                objArr4[1] = Boolean.valueOf(this.Hvb != null && !Util.isNullOrNil(this.Hvb.field_forbidWord));
                Log.i(str4, "get isTransparent3 1 %s 2 %s", objArr4);
                AppMethodBeat.o(69464);
                return false;
            }
        } else {
            Log.i(this.TAG, "get isTransparent5");
            AppMethodBeat.o(69464);
            return true;
        }
    }

    private boolean fOJ() {
        AppMethodBeat.i(69465);
        if (isTransparent()) {
            setContentViewVisibility(4);
            ao.q(this, 0);
            AppMethodBeat.o(69465);
            return false;
        }
        setContentViewVisibility(0);
        ao.q(this, getActionbarColor());
        AppMethodBeat.o(69465);
        return true;
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean getCancelable() {
        return false;
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean needConfirmFinish() {
        return true;
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void cleanUiData(int i2) {
        AppMethodBeat.i(69466);
        if (i2 == 0) {
            if (isTransparent()) {
                finish();
                AppMethodBeat.o(69466);
                return;
            }
        } else if (i2 == 1) {
            fOs();
        }
        AppMethodBeat.o(69466);
    }

    /* access modifiers changed from: protected */
    public void xY(boolean z) {
        AppMethodBeat.i(69467);
        com.tencent.mm.plugin.wallet.pay.a.a.b a2 = com.tencent.mm.plugin.wallet.pay.a.a.a(fOC(), this.CwO, z);
        if (this.CwO != null) {
            Bundle bundle = new Bundle();
            bundle.putString("key_reqKey", this.CwO.dDL);
            if (this.CwO.HZd != null && this.CwO.HZd.size() > 0) {
                bundle.putString("key_TransId", this.CwO.HZd.get(0).dDM);
            }
            bundle.putLong("key_SessionId", this.HHn);
            a2.setProcessName("PayProcess");
            a2.setProcessBundle(bundle);
        }
        if (this.mPayInfo != null) {
            if (this.mPayInfo.dVv == 6 && this.mPayInfo.Kxr == 100) {
                a2.setScene(100);
            } else {
                a2.setScene(this.mPayInfo.dVv);
            }
        }
        doSceneProgress(a2);
        if (!(this.mPayInfo == null || 8 != this.mPayInfo.dVv || this.mPayInfo.iqp == null)) {
            long j2 = this.mPayInfo.iqp.getLong("extinfo_key_9");
            h.INSTANCE.a(13956, 2, Long.valueOf(System.currentTimeMillis() - j2));
        }
        AppMethodBeat.o(69467);
    }

    private boolean fOK() {
        AppMethodBeat.i(69468);
        if (this.CwO != null && this.CwO.HYU) {
            g.aAi();
            if (((Boolean) g.aAh().azQ().get(196614, Boolean.TRUE)).booleanValue()) {
                View inflate = getLayoutInflater().inflate(R.layout.c_h, (ViewGroup) null);
                final CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.ip1);
                ga(inflate);
                ((TextView) inflate.findViewById(R.id.ipe)).setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.AnonymousClass22 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(214054);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$29", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        checkBox.setChecked(!checkBox.isChecked());
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pay/ui/WalletPayUI$29", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(214054);
                    }
                });
                final com.tencent.mm.ui.widget.a.d a2 = com.tencent.mm.ui.base.h.a(this, getString(R.string.io4), inflate, getString(R.string.iak), getString(R.string.iqp), new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.AnonymousClass24 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(69413);
                        if (checkBox.isChecked()) {
                            g.aAi();
                            g.aAh().azQ().set(196614, Boolean.FALSE);
                        }
                        WalletPayUI.this.xW(false);
                        AppMethodBeat.o(69413);
                    }
                }, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.AnonymousClass25 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(214055);
                        WalletPayUI.this.finish();
                        AppMethodBeat.o(214055);
                    }
                });
                a2.setCancelable(false);
                checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    /* class com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.AnonymousClass26 */

                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        AppMethodBeat.i(214056);
                        Button button = a2.getButton(-2);
                        if (z) {
                            button.setEnabled(false);
                            AppMethodBeat.o(214056);
                            return;
                        }
                        button.setEnabled(true);
                        AppMethodBeat.o(214056);
                    }
                });
                AppMethodBeat.o(69468);
                return false;
            }
        }
        AppMethodBeat.o(69468);
        return true;
    }

    private void ga(View view) {
        AppMethodBeat.i(69469);
        TextView textView = (TextView) view.findViewById(R.id.fuy);
        textView.setText(Html.fromHtml(String.format(getResources().getString(R.string.io2), getResources().getString(R.string.i5l))));
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        AppMethodBeat.o(69469);
    }

    /* access modifiers changed from: protected */
    public final boolean fOL() {
        return (this.mPayInfo == null || this.mPayInfo.dVv == 11) ? false : true;
    }

    /* access modifiers changed from: protected */
    public final PayInfo getPayInfo() {
        AppMethodBeat.i(69470);
        if (this.mPayInfo == null) {
            this.mPayInfo = (PayInfo) getIntent().getParcelableExtra("key_pay_info");
        }
        PayInfo payInfo = this.mPayInfo;
        AppMethodBeat.o(69470);
        return payInfo;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    /* access modifiers changed from: protected */
    public void aI(Bundle bundle) {
        AppMethodBeat.i(69471);
        this.HGU = true;
        if (this.CwO != null) {
            bundle.putInt("key_support_bankcard", this.CwO.HQg);
            bundle.putString("key_reqKey", this.CwO.dDL);
            if (this.CwO.HZd != null && this.CwO.HZd.size() > 0) {
                bundle.putString("key_TransId", this.CwO.HZd.get(0).dDM);
            }
            bundle.putLong("key_SessionId", this.HHn);
        }
        if (this.mPayInfo != null) {
            bundle.putInt("key_scene", this.mPayInfo.dVv);
        }
        bundle.putBoolean("key_is_oversea", !fOD());
        bundle.putInt("is_deduct_open", this.HHv);
        this.HGV = new d.a() {
            /* class com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.AnonymousClass27 */

            @Override // com.tencent.mm.wallet_core.d.a
            public final Intent q(int i2, Bundle bundle) {
                AppMethodBeat.i(214057);
                Log.i(WalletPayUI.this.TAG, "pay process end");
                WalletPayUI.this.HGU = false;
                Intent intent = new Intent();
                AppMethodBeat.o(214057);
                return intent;
            }
        };
        com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.pay.b.class, bundle, this.HGV);
        AppMethodBeat.o(69471);
    }

    @Override // com.tencent.mm.plugin.wallet.pay.ui.a.AbstractC1904a
    public final void d(boolean z, String str, String str2) {
        AppMethodBeat.i(69472);
        Log.i(this.TAG, "onGenFinish callback");
        if (z) {
            Log.i(this.TAG, "onGenFinish callback, result.isSuccess is true");
            this.mPayInfo.dNR = str;
            this.mPayInfo.dNS = str2;
            xY(false);
            com.tencent.mm.plugin.wallet_core.utils.f.fUi();
            AppMethodBeat.o(69472);
            return;
        }
        Log.e(this.TAG, "onGenFinish callback, result.isSuccess is false");
        xY(false);
        com.tencent.mm.plugin.wallet_core.utils.f.fUi();
        AppMethodBeat.o(69472);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onPause() {
        AppMethodBeat.i(69473);
        super.onPause();
        if (this.HGh != null) {
            this.HGh.onActivityPause();
        }
        AppMethodBeat.o(69473);
    }

    private boolean b(f fVar) {
        int i2 = 0;
        AppMethodBeat.i(69474);
        if ("1".equals(fVar.egd)) {
            Log.i(this.TAG, "need realname verify");
            this.HHt = true;
            Bundle bundle = new Bundle();
            bundle.putString("realname_verify_process_jump_activity", ".pay.ui.WalletPayUI");
            bundle.putString("realname_verify_process_jump_plugin", "wallet");
            isTransparent();
            if (this.mPayInfo != null) {
                i2 = this.mPayInfo.dVv;
            }
            boolean a2 = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, bundle, null, i2);
            AppMethodBeat.o(69474);
            return a2;
        } else if ("2".equals(fVar.egd)) {
            Log.i(this.TAG, "need upload credit");
            boolean a3 = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, fVar.ege, fVar.egh, fVar.egf, fVar.egg, isTransparent(), (DialogInterface.OnClickListener) null);
            AppMethodBeat.o(69474);
            return a3;
        } else {
            Log.i(this.TAG, "realnameGuideFlag =  " + fVar.egd);
            AppMethodBeat.o(69474);
            return false;
        }
    }

    static /* synthetic */ void f(WalletPayUI walletPayUI) {
        boolean z;
        AppMethodBeat.i(69476);
        Bundle bundle = new Bundle();
        if (walletPayUI.CwO != null) {
            bundle.putString("key_reqKey", walletPayUI.CwO.dDL);
            if (walletPayUI.CwO.HZd != null && walletPayUI.CwO.HZd.size() > 0) {
                bundle.putString("key_TransId", walletPayUI.CwO.HZd.get(0).dDM);
            }
            bundle.putLong("key_SessionId", walletPayUI.HHn);
        }
        if (walletPayUI.mPayInfo != null) {
            bundle.putInt("key_scene", walletPayUI.mPayInfo.dVv);
        }
        if (walletPayUI.mPayInfo == null || walletPayUI.mPayInfo.dVv != 11) {
            bundle.putInt("key_bind_scene", 0);
        } else {
            bundle.putInt("key_bind_scene", 13);
        }
        bundle.putBoolean("key_need_bind_response", true);
        bundle.putInt("key_bind_scene", 0);
        bundle.putBoolean("key_is_bind_bankcard", true);
        if (!walletPayUI.fOD()) {
            z = true;
        } else {
            z = false;
        }
        bundle.putBoolean("key_is_oversea", z);
        com.tencent.mm.wallet_core.a.a(walletPayUI, com.tencent.mm.plugin.wallet.pay.a.class, bundle, (d.a) null);
        AppMethodBeat.o(69476);
    }
}
