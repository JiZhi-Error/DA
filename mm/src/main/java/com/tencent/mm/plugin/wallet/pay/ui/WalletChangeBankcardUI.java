package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.aah;
import com.tencent.mm.g.a.aai;
import com.tencent.mm.g.a.zv;
import com.tencent.mm.g.a.zy;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet.pay.ui.a;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.af;
import com.tencent.mm.plugin.wallet_core.model.g;
import com.tencent.mm.plugin.wallet_core.ui.f;
import com.tencent.mm.plugin.wallet_core.ui.k;
import com.tencent.mm.plugin.wallet_core.ui.s;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.thumbplayer.api.TPPlayerMgr;
import java.util.ArrayList;

@a(3)
public class WalletChangeBankcardUI extends WalletBaseUI implements a.AbstractC1904a {
    public static int HFZ = 1;
    private IListener Cuh = new IListener<aah>() {
        /* class com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI.AnonymousClass1 */

        {
            AppMethodBeat.i(160865);
            this.__eventId = aah.class.getName().hashCode();
            AppMethodBeat.o(160865);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(aah aah) {
            AppMethodBeat.i(69306);
            final aah aah2 = aah;
            Log.i("MicroMsg.WalletChangeBankcardUI", "realnameNotifyListener %s", Integer.valueOf(aah2.ehe.result));
            zv zvVar = new zv();
            if (aah2.ehe.result == -1) {
                zvVar.efR.scene = 17;
            } else if (aah2.ehe.result == 0) {
                zvVar.efR.scene = 18;
            } else {
                zvVar.efR.scene = 0;
            }
            zvVar.efS.efJ = new Runnable() {
                /* class com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI.AnonymousClass1.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(69305);
                    if (-1 == aah2.ehe.result) {
                        WalletChangeBankcardUI.a(WalletChangeBankcardUI.this);
                    }
                    AppMethodBeat.o(69305);
                }
            };
            EventCenter.instance.publish(zvVar);
            AppMethodBeat.o(69306);
            return false;
        }
    };
    protected Orders CwO = null;
    protected Button Cwg;
    protected Authen HDR = null;
    protected ListView HGa;
    public s HGb;
    protected int HGc;
    public k HGd = null;
    protected String HGe = null;
    public FavorPayInfo HGf;
    private a HGg;
    f HGh = null;
    private boolean HGi = false;
    public ArrayList<Bankcard> Hva;
    protected Bankcard Hvb = null;
    protected int dVv = 0;
    public String krw;
    protected PayInfo mPayInfo = null;
    protected TextView qbW;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletChangeBankcardUI() {
        AppMethodBeat.i(69313);
        AppMethodBeat.o(69313);
    }

    static /* synthetic */ void a(WalletChangeBankcardUI walletChangeBankcardUI) {
        AppMethodBeat.i(69334);
        walletChangeBankcardUI.fOp();
        AppMethodBeat.o(69334);
    }

    static /* synthetic */ View d(WalletChangeBankcardUI walletChangeBankcardUI) {
        AppMethodBeat.i(69335);
        View contentView = walletChangeBankcardUI.getContentView();
        AppMethodBeat.o(69335);
        return contentView;
    }

    private void fOp() {
        AppMethodBeat.i(69314);
        d by = com.tencent.mm.wallet_core.a.by(this);
        if (by != null) {
            by.g(this, 1);
        } else {
            finish();
        }
        aai aai = new aai();
        aai.ehf.result = -1;
        EventCenter.instance.publish(aai);
        AppMethodBeat.o(69314);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(69315);
        super.onActivityResult(i2, i3, intent);
        Log.i("MicroMsg.WalletChangeBankcardUI", "onActivityResult %d %d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == HFZ) {
            fOp();
        }
        AppMethodBeat.o(69315);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(69316);
        super.onCreate(bundle);
        setMMTitle(R.string.ish);
        Bundle input = getInput();
        input.putInt("key_err_code", 0);
        this.HGc = input.getInt("key_support_bankcard", 1);
        this.HDR = (Authen) input.getParcelable("key_authen");
        this.CwO = (Orders) input.getParcelable("key_orders");
        this.mPayInfo = (PayInfo) input.getParcelable("key_pay_info");
        this.HGf = (FavorPayInfo) input.getParcelable("key_favor_pay_info");
        this.dVv = this.mPayInfo == null ? 0 : this.mPayInfo.dVv;
        Log.i("MicroMsg.WalletChangeBankcardUI", "pay_scene %d", Integer.valueOf(this.dVv));
        if (getInput().getBoolean("key_is_filter_bank_type")) {
            xU(true);
        } else {
            this.Hva = fOq();
        }
        if (!(this.CwO == null || this.CwO.HZd == null || this.CwO.HZd.size() <= 0)) {
            this.HGe = getString(R.string.ian, new Object[]{com.tencent.mm.wallet_core.ui.f.d(this.CwO.dDO, this.CwO.AOl), this.CwO.HZd.get(0).desc});
        }
        initView();
        ab.mg(7, 0);
        EventCenter.instance.addListener(this.Cuh);
        if (getInput().getBoolean("key_is_filter_bank_type") && this.HGd != null) {
            this.HGd.IfX = false;
        }
        AppMethodBeat.o(69316);
    }

    private ArrayList<Bankcard> fOq() {
        AppMethodBeat.i(69317);
        if (this.dVv == 8) {
            ArrayList<Bankcard> yh = af.yh(true);
            AppMethodBeat.o(69317);
            return yh;
        }
        ArrayList<Bankcard> yh2 = af.yh(false);
        AppMethodBeat.o(69317);
        return yh2;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(69318);
        if (this.HGg != null) {
            this.HGg.closeTipDialog();
            this.HGg.release();
        }
        EventCenter.instance.removeListener(this.Cuh);
        this.HGh = null;
        super.onDestroy();
        AppMethodBeat.o(69318);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(69319);
        this.Cwg = (Button) findViewById(R.id.g9c);
        this.Cwg.setEnabled(false);
        this.Cwg.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(69308);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pay/ui/WalletChangeBankcardUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                WalletChangeBankcardUI.this.fOs();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pay/ui/WalletChangeBankcardUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(69308);
            }
        });
        if (Util.isNullOrNil(getInput().getString("key_pwd1"))) {
            this.Cwg.setText(R.string.x_);
        } else {
            this.Cwg.setText(R.string.ip9);
        }
        this.HGa = (ListView) findViewById(R.id.hmo);
        this.HGd = fOr();
        this.HGa.setAdapter((ListAdapter) this.HGd);
        this.HGa.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI.AnonymousClass4 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(69309);
                b bVar = new b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pay/ui/WalletChangeBankcardUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                WalletChangeBankcardUI.this.aex(i2);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pay/ui/WalletChangeBankcardUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(69309);
            }
        });
        updateView();
        AppMethodBeat.o(69319);
    }

    /* access modifiers changed from: protected */
    public k fOr() {
        AppMethodBeat.i(69320);
        k kVar = new k(this, this.Hva, this.HGc, this.CwO);
        AppMethodBeat.o(69320);
        return kVar;
    }

    public final void updateView() {
        AppMethodBeat.i(69321);
        this.qbW = (TextView) findViewById(R.id.dyz);
        if (this.HGf != null && !Util.isNullOrNil(this.HGf.HXM)) {
            this.qbW.setVisibility(0);
            this.qbW.setText(this.HGf.HXM);
            AppMethodBeat.o(69321);
        } else if (getInput().getInt("key_main_bankcard_state", 0) != 0) {
            this.qbW.setVisibility(0);
            this.qbW.setText(this.HGe);
            AppMethodBeat.o(69321);
        } else {
            this.qbW.setVisibility(8);
            AppMethodBeat.o(69321);
        }
    }

    /* access modifiers changed from: protected */
    public void aex(int i2) {
        int i3 = 0;
        AppMethodBeat.i(69322);
        int size = this.Hva != null ? this.Hva.size() : 0;
        Log.i("MicroMsg.WalletChangeBankcardUI", "on select bankcard: %s, %s", Integer.valueOf(i2), Integer.valueOf(size));
        if (this.Hva == null || i2 >= size) {
            if (size == i2) {
                g fQl = g.fQl();
                if (fQl.bJw()) {
                    h.c(this, fQl.ANp, getString(R.string.zb), true);
                    AppMethodBeat.o(69322);
                    return;
                }
                if (this.mPayInfo != null) {
                    i3 = this.mPayInfo.dVv;
                }
                com.tencent.mm.wallet_core.c.af.f(i3, this.mPayInfo == null ? "" : this.mPayInfo.dDL, 14, "");
                getInput().putInt("key_err_code", -1003);
                getInput().putBoolean("key_has_click_bind_new_card", true);
                com.tencent.mm.wallet_core.a.l(this, getInput());
            }
            AppMethodBeat.o(69322);
            return;
        }
        Bankcard bankcard = this.Hva.get(i2);
        this.Hvb = bankcard;
        if (this.mPayInfo != null) {
            i3 = this.mPayInfo.dVv;
        }
        com.tencent.mm.wallet_core.c.af.f(i3, this.mPayInfo == null ? "" : this.mPayInfo.dDL, 13, this.Hvb.field_bindSerial);
        this.HGd.IfW = bankcard.field_bindSerial;
        this.Cwg.setEnabled(true);
        this.HGd.notifyDataSetChanged();
        fOs();
        AppMethodBeat.o(69322);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onResume() {
        AppMethodBeat.i(69323);
        getInput().putInt("key_err_code", 0);
        super.onResume();
        if (this.HGh != null) {
            this.HGh.fSA();
        }
        AppMethodBeat.o(69323);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean isTransparent() {
        AppMethodBeat.i(69324);
        if (super.isTransparent()) {
            AppMethodBeat.o(69324);
            return true;
        } else if (this.mPayInfo == null || !this.mPayInfo.crp) {
            AppMethodBeat.o(69324);
            return false;
        } else if (this.mPayInfo.crp) {
            AppMethodBeat.o(69324);
            return true;
        } else {
            com.tencent.mm.plugin.wallet.a.s.fOg();
            if (!com.tencent.mm.plugin.wallet.a.s.fOh().fRk()) {
                AppMethodBeat.o(69324);
                return false;
            }
            AppMethodBeat.o(69324);
            return false;
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.c8h;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        boolean z;
        int i3 = 0;
        AppMethodBeat.i(69325);
        if (i2 == 4 && this.HGf != null && this.Hva.size() == 0) {
            FavorPayInfo favorPayInfo = this.HGf;
            if (favorPayInfo == null || favorPayInfo.HXJ == 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                Log.i("MicroMsg.WalletChangeBankcardUI", "favor need bankcard bind but usr cancel");
                String string = getInput().getString("key_is_cur_bankcard_bind_serial");
                if (Util.isNullOrNil(string)) {
                    Log.e("MicroMsg.WalletChangeBankcardUI", "curBankcardBindSerial null & finish");
                    boolean onKeyUp = super.onKeyUp(i2, keyEvent);
                    AppMethodBeat.o(69325);
                    return onKeyUp;
                }
                ArrayList<Bankcard> fOq = fOq();
                if (fOq != null && this.Hvb == null) {
                    while (true) {
                        if (i3 >= fOq.size()) {
                            break;
                        } else if (string.equals(fOq.get(i3).field_bindSerial)) {
                            Log.i("MicroMsg.WalletChangeBankcardUI", "get cur bankcard, bind_serial:".concat(String.valueOf(string)));
                            this.Hvb = fOq.get(i3);
                            break;
                        } else {
                            i3++;
                        }
                    }
                    if (this.Hvb == null) {
                        Log.e("MicroMsg.WalletChangeBankcardUI", "mDefaultBankcard still null & finish");
                        boolean onKeyUp2 = super.onKeyUp(i2, keyEvent);
                        AppMethodBeat.o(69325);
                        return onKeyUp2;
                    }
                }
                fOs();
                AppMethodBeat.o(69325);
                return true;
            }
        }
        boolean onKeyUp3 = super.onKeyUp(i2, keyEvent);
        AppMethodBeat.o(69325);
        return onKeyUp3;
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        boolean z;
        boolean z2 = false;
        int i4 = 0;
        AppMethodBeat.i(69326);
        if (i2 != 0 || i3 != 0) {
            Bundle bundle = new Bundle();
            bundle.putString("pwd", this.krw);
            getInput().putBoolean("key_need_verify_sms", false);
            ((com.tencent.mm.plugin.fingerprint.d.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.fingerprint.d.a.class)).a(this.HDR.BDB.Ijy == 1, true, bundle);
            switch (i3) {
                case 100000:
                case TPPlayerMgr.EVENT_ID_APP_ENTER_BACKGROUND /*{ENCODED_INT: 100001}*/:
                case 100102:
                    this.mPayInfo.Kxu = i3;
                    fOs();
                    AppMethodBeat.o(69326);
                    return true;
                case 100100:
                case 100101:
                    this.mPayInfo.Kxu = i3;
                    if (i3 == 100100) {
                        z2 = true;
                    }
                    if (this.HGg == null) {
                        this.HGg = new a(this, this);
                    }
                    this.HGg.b(z2, this.mPayInfo.dNP, this.mPayInfo.dDL);
                    Log.i("MicroMsg.WalletChangeBankcardUI", "mRegenFingerPrintRsaKey.genRsaKey isGenRsa is ".concat(String.valueOf(z2)));
                    AppMethodBeat.o(69326);
                    return true;
            }
        } else if (qVar instanceof com.tencent.mm.plugin.wallet.pay.a.c.f) {
            AppMethodBeat.o(69326);
            return true;
        } else if (qVar instanceof com.tencent.mm.plugin.wallet.pay.a.a.b) {
            Bundle input = getInput();
            com.tencent.mm.plugin.wallet.pay.a.a.b bVar = (com.tencent.mm.plugin.wallet.pay.a.a.b) qVar;
            if (!Util.isNullOrNil(this.krw)) {
                input.putString("key_pwd1", this.krw);
            }
            input.putString("kreq_token", bVar.getToken());
            input.putParcelable("key_authen", bVar.HFI);
            input.putBoolean("key_need_verify_sms", !bVar.HFG);
            input.putParcelable("key_pay_info", this.mPayInfo);
            input.putInt("key_pay_flag", 3);
            input.putInt("key_can_verify_tail", bVar.HFM);
            input.putString("key_verify_tail_wording", bVar.HFN);
            RealnameGuideHelper realnameGuideHelper = bVar.AJr;
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
            if (realnameGuideHelper != null) {
                input.putParcelable("key_realname_guide_helper", realnameGuideHelper);
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString("pwd", this.krw);
            com.tencent.mm.plugin.fingerprint.d.a aVar = (com.tencent.mm.plugin.fingerprint.d.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.fingerprint.d.a.class);
            if (aVar.dJO()) {
                i4 = 1;
            } else if (aVar.dJR()) {
                i4 = 2;
            }
            bundle2.putInt("key_open_biometric_type", i4);
            aVar.a(bVar.fOm(), true, bundle2);
            if (bVar.isPaySuccess) {
                input.putParcelable("key_orders", bVar.HFH);
                if (this.mPayInfo != null && this.mPayInfo.dVv == 8) {
                    zy zyVar = new zy();
                    zyVar.egE.egF = this.HDR.ANo;
                    EventCenter.instance.publish(zyVar);
                }
            }
            com.tencent.mm.wallet_core.a.l(this, input);
            AppMethodBeat.o(69326);
            return true;
        }
        AppMethodBeat.o(69326);
        return false;
    }

    /* access modifiers changed from: protected */
    public void fOs() {
        AppMethodBeat.i(69327);
        Log.i("MicroMsg.WalletChangeBankcardUI", "pay with old bankcard!");
        getInput().getString("key_pwd1");
        this.HGi = false;
        setContentViewVisibility(4);
        this.HGb = s.a(this, this.CwO, this.HGf, this.Hvb, this.mPayInfo, new s.c() {
            /* class com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI.AnonymousClass5 */

            @Override // com.tencent.mm.plugin.wallet_core.ui.s.c
            public final void a(String str, FavorPayInfo favorPayInfo, boolean z) {
                AppMethodBeat.i(69310);
                if (WalletChangeBankcardUI.this.HGi) {
                    Log.w("MicroMsg.WalletChangeBankcardUI", "has receive cancel");
                    com.tencent.mm.plugin.report.service.h.INSTANCE.n(965, 3, 1);
                    AppMethodBeat.o(69310);
                    return;
                }
                WalletChangeBankcardUI.this.HGf = favorPayInfo;
                WalletChangeBankcardUI.this.getInput().putParcelable("key_favor_pay_info", WalletChangeBankcardUI.this.HGf);
                if (WalletChangeBankcardUI.this.HGf == null || !z) {
                    WalletChangeBankcardUI.this.krw = str;
                    WalletChangeBankcardUI.this.hideVKB();
                    WalletChangeBankcardUI.this.aUW(str);
                    WalletChangeBankcardUI.this.HGh = null;
                    AppMethodBeat.o(69310);
                    return;
                }
                if (WalletChangeBankcardUI.this.HGf != null) {
                    WalletChangeBankcardUI.this.xU(true);
                    WalletChangeBankcardUI.this.HGd.h(WalletChangeBankcardUI.this.Hva, false);
                }
                if (WalletChangeBankcardUI.this.HGb != null) {
                    WalletChangeBankcardUI.this.HGb.dismiss();
                }
                WalletChangeBankcardUI.this.updateView();
                WalletChangeBankcardUI.this.setContentViewVisibility(0);
                AppMethodBeat.o(69310);
            }
        }, new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI.AnonymousClass6 */

            public final void onClick(View view) {
                AppMethodBeat.i(69311);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pay/ui/WalletChangeBankcardUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (WalletChangeBankcardUI.this.HGb != null) {
                    WalletChangeBankcardUI.this.HGb.dismiss();
                }
                WalletChangeBankcardUI.this.xU(false);
                WalletChangeBankcardUI.this.HGd.h(WalletChangeBankcardUI.this.Hva, true);
                WalletChangeBankcardUI.this.HGf = (FavorPayInfo) view.getTag();
                if (WalletChangeBankcardUI.this.HGf != null) {
                    WalletChangeBankcardUI.this.HGf.HXM = "";
                }
                WalletChangeBankcardUI.this.getInput().putParcelable("key_favor_pay_info", WalletChangeBankcardUI.this.HGf);
                WalletChangeBankcardUI.this.updateView();
                WalletChangeBankcardUI.this.setContentViewVisibility(0);
                WalletChangeBankcardUI.this.HGh = null;
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pay/ui/WalletChangeBankcardUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(69311);
            }
        }, new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI.AnonymousClass7 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(69312);
                Log.i("MicroMsg.WalletChangeBankcardUI", "WalletPwdDialog event2 %s", Util.getStack().toString());
                WalletChangeBankcardUI.this.HGi = true;
                if (dialogInterface != null) {
                    dialogInterface.dismiss();
                }
                WalletChangeBankcardUI.this.krw = null;
                if (WalletChangeBankcardUI.d(WalletChangeBankcardUI.this).getVisibility() != 0) {
                    WalletChangeBankcardUI.this.dJG();
                }
                WalletChangeBankcardUI.this.HGh = null;
                AppMethodBeat.o(69312);
            }
        });
        this.HGh = this.HGb;
        AppMethodBeat.o(69327);
    }

    /* access modifiers changed from: protected */
    public void aUW(String str) {
        boolean z;
        AppMethodBeat.i(69328);
        this.HDR.HUO = str;
        boolean z2 = getInput().getBoolean("key_has_click_bind_new_card", false);
        int i2 = getInput().getInt("key_pay_flag");
        if (z2 && i2 == 3) {
            Log.i("MicroMsg.WalletChangeBankcardUI", "fix authen flag after bind card fail");
            this.HDR.cSx = 3;
        }
        if (this.Hvb != null) {
            getInput().putString("key_mobile", this.Hvb.field_mobile);
            getInput().putParcelable("key_bankcard", this.Hvb);
            this.HDR.ANo = this.Hvb.field_bindSerial;
            this.HDR.dDj = this.Hvb.field_bankcardType;
            if (this.HGf != null) {
                this.HDR.HUY = this.HGf.HXI;
            } else {
                this.HDR.HUY = null;
            }
            if (this.CwO.HZe != null) {
                this.HDR.HUX = this.CwO.HZe.HEt;
            }
            if (this.CwO != null && this.CwO.HQg == 3) {
                if (this.Hvb.fQe()) {
                    this.HDR.cSx = 3;
                } else {
                    this.HDR.cSx = 6;
                }
                Bundle input = getInput();
                if (!this.Hvb.fQe()) {
                    z = true;
                } else {
                    z = false;
                }
                input.putBoolean("key_is_oversea", z);
            }
        }
        getInput().putString("key_pwd1", str);
        getInput().putParcelable("key_authen", this.HDR);
        com.tencent.mm.plugin.wallet.pay.a.a.b a2 = com.tencent.mm.plugin.wallet.pay.a.a.a(this.HDR, this.CwO, false);
        if (a2 != null) {
            a2.setProcessName("PayProcess");
            a2.setProcessBundle(getInput());
            if (this.mPayInfo.dVv == 6 && this.mPayInfo.Kxr == 100) {
                a2.setScene(100);
            } else {
                a2.setScene(this.mPayInfo.dVv);
            }
            doSceneProgress(a2);
        }
        AppMethodBeat.o(69328);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean needConfirmFinish() {
        return true;
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void cleanUiData(int i2) {
        AppMethodBeat.i(69329);
        if (i2 == 0) {
            dJG();
            AppMethodBeat.o(69329);
        } else if (i2 == 1) {
            getInput().putString("key_pwd1", "");
            fOs();
            AppMethodBeat.o(69329);
        } else {
            Log.w("MicroMsg.WalletChangeBankcardUI", "hy: clean ui data not handled");
            AppMethodBeat.o(69329);
        }
    }

    public final void dJG() {
        AppMethodBeat.i(69330);
        cancelQRPay();
        d by = com.tencent.mm.wallet_core.a.by(this);
        if (by != null) {
            by.b(this, getInput());
            AppMethodBeat.o(69330);
            return;
        }
        finish();
        AppMethodBeat.o(69330);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    /* access modifiers changed from: protected */
    public final void xU(boolean z) {
        AppMethodBeat.i(69331);
        this.Hva = fOq();
        if (this.HGf != null) {
            if ((this.HGf.HXJ != 0) && z) {
                String str = this.HGf.HXK;
                ArrayList<Bankcard> arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < this.Hva.size(); i2++) {
                    Bankcard bankcard = this.Hva.get(i2);
                    if (Util.isNullOrNil(str)) {
                        if (!bankcard.field_bankcardType.equalsIgnoreCase("CFT")) {
                            arrayList.add(bankcard);
                        }
                    } else if (bankcard.field_bankcardType.equals(str)) {
                        arrayList.add(bankcard);
                    }
                }
                this.Hva = arrayList;
                AppMethodBeat.o(69331);
                return;
            }
        }
        AppMethodBeat.o(69331);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onProgressFinish() {
        return true;
    }

    @Override // com.tencent.mm.plugin.wallet.pay.ui.a.AbstractC1904a
    public final void d(boolean z, String str, String str2) {
        AppMethodBeat.i(69332);
        Log.i("MicroMsg.WalletChangeBankcardUI", "onGenFinish callback");
        if (z) {
            Log.i("MicroMsg.WalletChangeBankcardUI", "onGenFinish callback, result.isSuccess is true");
            this.mPayInfo.dNR = str;
            this.mPayInfo.dNS = str2;
            aUW(this.krw);
            AppMethodBeat.o(69332);
            return;
        }
        Log.e("MicroMsg.WalletChangeBankcardUI", "onGenFinish callback, result.isSuccess is false");
        aUW(this.krw);
        AppMethodBeat.o(69332);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onPause() {
        AppMethodBeat.i(69333);
        super.onPause();
        if (this.HGh != null) {
            this.HGh.onActivityPause();
        }
        AppMethodBeat.o(69333);
    }
}
