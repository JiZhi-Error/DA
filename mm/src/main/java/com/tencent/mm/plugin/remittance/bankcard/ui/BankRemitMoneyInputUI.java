package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.util.GmsVersion;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.cb.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.remittance.bankcard.a.n;
import com.tencent.mm.plugin.remittance.bankcard.model.BankcardElemParcel;
import com.tencent.mm.plugin.wallet_core.ui.q;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.dx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.x;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.c.ag;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class BankRemitMoneyInputUI extends BankRemitBaseUI {
    private CdnImageView Cjq;
    private TextView Cjs;
    public String CkH;
    private TextView CkS;
    private WalletFormView CkT;
    private LinearLayout CkU;
    private TextView CkV;
    private TextView CkW;
    private TextView CkX;
    private TextView CkY;
    private BankcardElemParcel CkZ;
    private String Cla;
    private String Clb;
    private String Clc;
    private String Cld;
    private int Cle;
    private int Clf;
    private q Clg;
    private long Clh;
    public int Cli = 0;
    private int Clj;
    private int Clk;
    private final int HARDCODE_TENPAY_KEYBOARD_HEIGHT = a.fromDPToPix(MMApplicationContext.getContext(), 270);
    private ScrollView jVf;
    private Button krs;
    private String mBankType;
    private String mDesc;
    public String zfX;

    @Override // com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public BankRemitMoneyInputUI() {
        AppMethodBeat.i(67556);
        AppMethodBeat.o(67556);
    }

    static /* synthetic */ void c(BankRemitMoneyInputUI bankRemitMoneyInputUI) {
        AppMethodBeat.i(67565);
        bankRemitMoneyInputUI.eNh();
        AppMethodBeat.o(67565);
    }

    static /* synthetic */ void k(BankRemitMoneyInputUI bankRemitMoneyInputUI) {
        AppMethodBeat.i(67570);
        bankRemitMoneyInputUI.bmw();
        AppMethodBeat.o(67570);
    }

    @Override // com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBaseUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(67557);
        super.onCreate(bundle);
        hideActionbarLine();
        addSceneEndListener(1380);
        addSceneEndListener(2739);
        int intValue = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_WALLET_BANK_REMIT_MIN_POUNDAGE_INT_SYNC, (Object) 10)).intValue();
        if (intValue < 0) {
            intValue = 10;
        }
        this.Clj = intValue;
        int intValue2 = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_WALLET_BANK_REMIT_MAX_TRANSFER_AMOUNT_INT_SYNC, Integer.valueOf((int) GmsVersion.VERSION_LONGHORN))).intValue();
        if (intValue2 <= 0) {
            intValue2 = 5000000;
        }
        this.Clk = intValue2;
        Log.i("MicroMsg.BankRemitMoneyInputUI", "minFee: %s, maxAmount: %s", Integer.valueOf(this.Clj), Integer.valueOf(this.Clk));
        this.zfX = getIntent().getStringExtra("key_unique_id");
        this.CkZ = (BankcardElemParcel) getIntent().getParcelableExtra("key_bank_card_elem_parcel");
        this.Cla = getIntent().getStringExtra("key_payee_name");
        this.Clb = getIntent().getStringExtra("key_bank_card_seqno");
        this.Clc = getIntent().getStringExtra("key_bank_card_tailno");
        this.Cld = getIntent().getStringExtra("key_encrypt_data");
        this.Cle = getIntent().getIntExtra("key_enter_time_scene", 0);
        this.Clf = getIntent().getIntExtra("key_input_type", 0);
        Log.d("MicroMsg.BankRemitMoneyInputUI", "set uniqueId:%s", this.zfX);
        if (this.CkZ == null) {
            Log.w("MicroMsg.BankRemitMoneyInputUI", "bankcard elem is null");
            this.CkZ = new BankcardElemParcel();
        }
        this.mBankType = this.CkZ.dDj;
        initView();
        setMMTitle(R.string.acb);
        b.hgC();
        this.mKindaEnable = b.b(b.a.clicfg_kinda_open, true);
        AppMethodBeat.o(67557);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean shouldEnsureSoterConnection() {
        return true;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(67558);
        this.jVf = (ScrollView) findViewById(R.id.h9a);
        this.Cjq = (CdnImageView) findViewById(R.id.ad_);
        this.Cjs = (TextView) findViewById(R.id.adb);
        this.CkS = (TextView) findViewById(R.id.adg);
        this.CkT = (WalletFormView) findViewById(R.id.ada);
        this.CkU = (LinearLayout) findViewById(R.id.adc);
        this.CkV = (TextView) this.CkU.findViewById(R.id.add);
        this.CkW = (TextView) this.CkU.findViewById(R.id.ade);
        this.CkX = (TextView) this.CkU.findViewById(R.id.adi);
        this.CkY = (TextView) this.CkU.findViewById(R.id.adh);
        this.krs = (Button) findViewById(R.id.adf);
        this.CkV.setText(getString(R.string.abj, new Object[]{this.CkZ.Cje}));
        this.Cjq.setUrl(this.CkZ.CiX);
        this.Cjs.setText(getString(R.string.ac4, new Object[]{this.CkZ.ynT, this.Clc}));
        this.CkS.setText(this.Cla);
        this.CkT.setTitleText(ah.hhz());
        setEditFocusListener(this.CkT, 2, false);
        this.CkT.setmContentAbnormalMoneyCheck(true);
        this.CkT.a(new TextWatcher() {
            /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitMoneyInputUI.AnonymousClass1 */

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(67544);
                if (editable.toString().startsWith(".")) {
                    editable.insert(0, AppEventsConstants.EVENT_PARAM_VALUE_NO);
                }
                String obj = editable.toString();
                int indexOf = obj.indexOf(".");
                int length = obj.length();
                if (indexOf >= 0 && length - indexOf > 2) {
                    WalletFormView.a(BankRemitMoneyInputUI.this.CkT.getContentEt(), obj, indexOf + 3, length);
                }
                String obj2 = editable.toString();
                if (Util.isNullOrNil(obj2) || Util.getDouble(obj2, 0.0d) <= 0.0d) {
                    BankRemitMoneyInputUI.this.CkU.setVisibility(8);
                } else {
                    BankRemitMoneyInputUI.this.CkU.setVisibility(0);
                }
                BankRemitMoneyInputUI.a(BankRemitMoneyInputUI.this, obj2);
                BankRemitMoneyInputUI.c(BankRemitMoneyInputUI.this);
                AppMethodBeat.o(67544);
            }
        });
        this.CkY.setClickable(true);
        this.CkY.setOnTouchListener(new o(this));
        final int intExtra = getIntent().getIntExtra("key_reason_len", 10);
        this.Clg = new q(new q.a() {
            /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitMoneyInputUI.AnonymousClass8 */

            @Override // com.tencent.mm.plugin.wallet_core.ui.q.a
            public final void dF(View view) {
                AppMethodBeat.i(67554);
                com.tencent.mm.plugin.wallet_core.ui.view.a.a(BankRemitMoneyInputUI.this, BankRemitMoneyInputUI.this.getString(R.string.abz), BankRemitMoneyInputUI.this.mDesc, BankRemitMoneyInputUI.this.getString(R.string.acd, new Object[]{new StringBuilder().append(intExtra).toString()}), true, intExtra * 2, new h.b() {
                    /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitMoneyInputUI.AnonymousClass8.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.base.h.b
                    public final boolean onFinish(CharSequence charSequence) {
                        AppMethodBeat.i(67551);
                        if (!Util.isNullOrNil(charSequence.toString())) {
                            BankRemitMoneyInputUI.this.mDesc = charSequence.toString();
                            BankRemitMoneyInputUI.k(BankRemitMoneyInputUI.this);
                        } else {
                            BankRemitMoneyInputUI.this.mDesc = null;
                            BankRemitMoneyInputUI.k(BankRemitMoneyInputUI.this);
                        }
                        AppMethodBeat.o(67551);
                        return true;
                    }
                }, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitMoneyInputUI.AnonymousClass8.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(67553);
                        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                            /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitMoneyInputUI.AnonymousClass8.AnonymousClass2.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(67552);
                                BankRemitMoneyInputUI.this.hideVKB();
                                AppMethodBeat.o(67552);
                            }
                        }, 500);
                        AppMethodBeat.o(67553);
                    }
                });
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(14673, 4);
                AppMethodBeat.o(67554);
            }
        });
        bmw();
        this.krs.setOnClickListener(new x() {
            /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitMoneyInputUI.AnonymousClass3 */

            @Override // com.tencent.mm.ui.x
            public final void czW() {
                AppMethodBeat.i(67546);
                Log.d("MicroMsg.BankRemitMoneyInputUI", "on click next");
                double jK = com.tencent.mm.plugin.remittance.bankcard.model.a.jK(BankRemitMoneyInputUI.this.CkT.getText(), "100");
                if (jK <= 0.0d) {
                    Log.w("MicroMsg.BankRemitMoneyInputUI", "illegal money: %s", Double.valueOf(jK));
                    Toast.makeText(BankRemitMoneyInputUI.this, (int) R.string.abn, 1).show();
                    AppMethodBeat.o(67546);
                    return;
                }
                BankRemitMoneyInputUI.d(BankRemitMoneyInputUI.this);
                AppMethodBeat.o(67546);
            }
        });
        eNh();
        setTenpayKBStateListener(new com.tencent.mm.wallet_core.ui.a() {
            /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitMoneyInputUI.AnonymousClass4 */

            @Override // com.tencent.mm.wallet_core.ui.a
            public final void onVisibleStateChange(boolean z) {
                AppMethodBeat.i(67547);
                if (z) {
                    BankRemitMoneyInputUI.e(BankRemitMoneyInputUI.this);
                    AppMethodBeat.o(67547);
                    return;
                }
                BankRemitMoneyInputUI.this.jVf.scrollTo(0, 0);
                AppMethodBeat.o(67547);
            }
        });
        AppMethodBeat.o(67558);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(67559);
        if (qVar instanceof com.tencent.mm.plugin.remittance.bankcard.a.o) {
            final com.tencent.mm.plugin.remittance.bankcard.a.o oVar = (com.tencent.mm.plugin.remittance.bankcard.a.o) qVar;
            oVar.a(new r.a() {
                /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitMoneyInputUI.AnonymousClass7 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
                    AppMethodBeat.i(67550);
                    Log.i("MicroMsg.BankRemitMoneyInputUI", "reqKey: %s, billId: %s", oVar.CiW.wFL, oVar.CiW.KZa);
                    Log.d("MicroMsg.BankRemitMoneyInputUI", "name: %s, bank: %s", oVar.CiW.Cjv, oVar.CiW.ynT);
                    BankRemitMoneyInputUI.this.CkH = oVar.CiW.KZa;
                    if (!BankRemitMoneyInputUI.a(BankRemitMoneyInputUI.this, oVar)) {
                        BankRemitMoneyInputUI.a(BankRemitMoneyInputUI.this, oVar.CiW.wFL, oVar.CiW.Cjv, oVar.CiW.ynT, oVar.CiW.Cju);
                        AppMethodBeat.o(67550);
                        return;
                    }
                    if (BankRemitMoneyInputUI.this.mKindaEnable) {
                        BankRemitMoneyInputUI.this.hideLoading();
                    }
                    AppMethodBeat.o(67550);
                }
            }).b(new r.a() {
                /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitMoneyInputUI.AnonymousClass6 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
                    AppMethodBeat.i(67549);
                    Log.e("MicroMsg.BankRemitMoneyInputUI", "request order error: %s, %s", Integer.valueOf(oVar.CiW.dDN), oVar.CiW.qwn);
                    BankRemitMoneyInputUI.a(BankRemitMoneyInputUI.this, oVar);
                    if (BankRemitMoneyInputUI.this.mKindaEnable) {
                        BankRemitMoneyInputUI.this.hideLoading();
                    }
                    AppMethodBeat.o(67549);
                }
            }).c(new r.a() {
                /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitMoneyInputUI.AnonymousClass5 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
                    AppMethodBeat.i(67548);
                    Log.e("MicroMsg.BankRemitMoneyInputUI", "net error: %s", qVar);
                    if (BankRemitMoneyInputUI.this.mKindaEnable) {
                        BankRemitMoneyInputUI.this.hideLoading();
                    }
                    AppMethodBeat.o(67548);
                }
            });
        }
        AppMethodBeat.o(67559);
        return false;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(67560);
        super.onDestroy();
        removeSceneEndListener(1380);
        removeSceneEndListener(2739);
        AppMethodBeat.o(67560);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.ih;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onActivityResult(int i2, int i3, Intent intent) {
        n nVar;
        AppMethodBeat.i(67561);
        if (i2 == 1) {
            if (i3 == -1) {
                Log.i("MicroMsg.BankRemitMoneyInputUI", "goto detail");
                Intent intent2 = new Intent(getContext(), BankRemitDetailUI.class);
                intent2.putExtra("key_transfer_bill_id", this.CkH);
                intent2.putExtra("key_enter_scene", 0);
                startActivityForResult(intent2, 2);
                String str = "";
                if (intent != null) {
                    str = intent.getStringExtra("key_trans_id");
                }
                aDI(str);
                this.Cli = 1;
                nVar = new n(this.CkH, this.zfX, 1);
            } else if (ag.bH(intent)) {
                finish();
                AppMethodBeat.o(67561);
                return;
            } else if (ag.bI(intent)) {
                AppMethodBeat.o(67561);
                return;
            } else {
                Log.i("MicroMsg.BankRemitMoneyInputUI", "pay failed: %d", Integer.valueOf(i3));
                this.Cli = intent.getIntExtra("key_pay_reslut_type", 0);
                nVar = new n(this.CkH, this.zfX, this.Cli);
                Log.i("MicroMsg.BankRemitMoneyInputUI", "onActivityResult() requestCode == REQ_PAY resultCode != RESULT_OK  mUnpayType:%s", Integer.valueOf(this.Cli));
            }
            doSceneProgress(nVar, false);
            AppMethodBeat.o(67561);
        } else if (i2 == 2) {
            Log.d("MicroMsg.BankRemitMoneyInputUI", "return from detail");
            Intent intent3 = new Intent();
            intent3.addFlags(67108864);
            c.b(getContext(), "offline", ".ui.WalletOfflineCoinPurseUI", intent3);
            AppMethodBeat.o(67561);
        } else {
            super.onActivityResult(i2, i3, intent);
            AppMethodBeat.o(67561);
        }
    }

    private void bmw() {
        AppMethodBeat.i(67562);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (!Util.isNullOrNil(this.mDesc)) {
            spannableStringBuilder.append((CharSequence) l.c(getContext(), this.mDesc));
            spannableStringBuilder.append((CharSequence) getString(R.string.aby));
            spannableStringBuilder.setSpan(this.Clg, this.mDesc.length(), spannableStringBuilder.length(), 34);
        } else {
            spannableStringBuilder.append((CharSequence) getString(R.string.abz));
            spannableStringBuilder.setSpan(this.Clg, 0, spannableStringBuilder.length(), 18);
        }
        this.CkY.setText(spannableStringBuilder);
        AppMethodBeat.o(67562);
    }

    private void eNh() {
        AppMethodBeat.i(67563);
        if (Util.getDouble(this.CkT.getText(), 0.0d) <= 0.0d || Util.isNullOrNil(this.Clb) || Util.isNullOrNil(this.Clc) || Util.isNullOrNil(this.mBankType) || Util.isNullOrNil(this.Cld)) {
            Log.i("MicroMsg.BankRemitMoneyInputUI", "disable btn: money: %s, seqNo: %s, tail: %s, bankType: %s, encrypt: %s", this.CkT.getText(), Boolean.valueOf(Util.isNullOrNil(this.Clb)), Boolean.valueOf(Util.isNullOrNil(this.Clc)), Boolean.valueOf(Util.isNullOrNil(this.mBankType)), Boolean.valueOf(Util.isNullOrNil(this.Cld)));
            this.krs.setEnabled(false);
            AppMethodBeat.o(67563);
            return;
        }
        this.krs.setEnabled(true);
        AppMethodBeat.o(67563);
    }

    public final void aDI(String str) {
        AppMethodBeat.i(213702);
        Log.i("MicroMsg.BankRemitMoneyInputUI", "do business callback: %s, %s", this.CkH, str);
        doSceneProgress(new com.tencent.mm.plugin.remittance.bankcard.a.c(this.CkH, str), false);
        AppMethodBeat.o(213702);
    }

    static /* synthetic */ void a(BankRemitMoneyInputUI bankRemitMoneyInputUI, String str) {
        AppMethodBeat.i(67564);
        double d2 = Util.getDouble(str, 0.0d);
        long round = Math.round(Util.getDouble(str, 0.0d) * 100.0d);
        if (bankRemitMoneyInputUI.CkZ.CiY >= 0 && round > 0) {
            double jK = com.tencent.mm.plugin.remittance.bankcard.model.a.jK(String.valueOf(round), new StringBuilder().append(bankRemitMoneyInputUI.CkZ.CiY).toString());
            bankRemitMoneyInputUI.Clh = com.tencent.mm.plugin.remittance.bankcard.model.a.jI(String.valueOf(jK), "10000");
            bankRemitMoneyInputUI.Clj = (int) bankRemitMoneyInputUI.CkZ.Cjf;
            Log.d("MicroMsg.BankRemitMoneyInputUI", "moneyYuan: %s, money: %s, a: %s, fee: %s, min: %s", Double.valueOf(d2), Long.valueOf(round), Double.valueOf(jK), Long.valueOf(bankRemitMoneyInputUI.Clh), Long.valueOf(bankRemitMoneyInputUI.CkZ.Cjf));
            if (bankRemitMoneyInputUI.Clh < ((long) bankRemitMoneyInputUI.Clj) && bankRemitMoneyInputUI.CkZ.CiY > 0) {
                bankRemitMoneyInputUI.Clh = (long) bankRemitMoneyInputUI.Clj;
            }
            double jJ = com.tencent.mm.plugin.remittance.bankcard.model.a.jJ(new StringBuilder().append(bankRemitMoneyInputUI.Clh).toString(), "100");
            bankRemitMoneyInputUI.CkW.setText(f.D(jJ));
            bankRemitMoneyInputUI.CkX.setText(f.D(d2 + jJ));
        }
        AppMethodBeat.o(67564);
    }

    static /* synthetic */ void d(BankRemitMoneyInputUI bankRemitMoneyInputUI) {
        AppMethodBeat.i(67566);
        int round = (int) Math.round(Util.getDouble(bankRemitMoneyInputUI.CkT.getText(), 0.0d) * 100.0d);
        Log.i("MicroMsg.BankRemitMoneyInputUI", "do request order, money: %s, fee: %s, desc: %s, input: %s, timeScene: %s", Integer.valueOf(round), Long.valueOf(bankRemitMoneyInputUI.Clh), bankRemitMoneyInputUI.mDesc, Integer.valueOf(bankRemitMoneyInputUI.Clf), Integer.valueOf(bankRemitMoneyInputUI.Cle));
        com.tencent.mm.plugin.remittance.bankcard.a.o oVar = new com.tencent.mm.plugin.remittance.bankcard.a.o(bankRemitMoneyInputUI.Clb, bankRemitMoneyInputUI.Clc, bankRemitMoneyInputUI.mBankType, bankRemitMoneyInputUI.Cle, round, bankRemitMoneyInputUI.mDesc, (int) bankRemitMoneyInputUI.Clh, bankRemitMoneyInputUI.Clf, bankRemitMoneyInputUI.Cld, Util.nullAsNil(bankRemitMoneyInputUI.zfX), new com.tencent.mm.bw.b((bankRemitMoneyInputUI.CkH).getBytes()), bankRemitMoneyInputUI.Cli);
        oVar.t(bankRemitMoneyInputUI);
        if (bankRemitMoneyInputUI.mKindaEnable) {
            bankRemitMoneyInputUI.showLoading();
            bankRemitMoneyInputUI.doSceneProgress(oVar, false);
            AppMethodBeat.o(67566);
            return;
        }
        bankRemitMoneyInputUI.doSceneProgress(oVar);
        AppMethodBeat.o(67566);
    }

    static /* synthetic */ void e(BankRemitMoneyInputUI bankRemitMoneyInputUI) {
        AppMethodBeat.i(67567);
        if (bankRemitMoneyInputUI.jVf != null) {
            int[] iArr = new int[2];
            bankRemitMoneyInputUI.krs.getLocationInWindow(iArr);
            int height = iArr[1] + bankRemitMoneyInputUI.krs.getHeight();
            int jo = a.jo(bankRemitMoneyInputUI);
            int fromDPToPix = (jo - height) - a.fromDPToPix((Context) bankRemitMoneyInputUI, 30);
            Log.d("MicroMsg.BankRemitMoneyInputUI", "scrollToFormEditPosAfterShowTenPay, editText locationY: %s, height: %s, diff: %s, hardcodeKeyboardHeight: %s", Integer.valueOf(height), Integer.valueOf(jo), Integer.valueOf(fromDPToPix), Integer.valueOf(bankRemitMoneyInputUI.HARDCODE_TENPAY_KEYBOARD_HEIGHT));
            if (fromDPToPix > 0 && fromDPToPix < bankRemitMoneyInputUI.HARDCODE_TENPAY_KEYBOARD_HEIGHT) {
                final int i2 = bankRemitMoneyInputUI.HARDCODE_TENPAY_KEYBOARD_HEIGHT - fromDPToPix;
                Log.d("MicroMsg.BankRemitMoneyInputUI", "scrollToFormEditPosAfterShowTenPay, scrollDistance: %s", Integer.valueOf(i2));
                bankRemitMoneyInputUI.jVf.post(new Runnable() {
                    /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitMoneyInputUI.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(67545);
                        BankRemitMoneyInputUI.this.jVf.scrollBy(0, i2);
                        AppMethodBeat.o(67545);
                    }
                });
            }
        }
        AppMethodBeat.o(67567);
    }

    static /* synthetic */ boolean a(BankRemitMoneyInputUI bankRemitMoneyInputUI, final com.tencent.mm.plugin.remittance.bankcard.a.o oVar) {
        AppMethodBeat.i(67568);
        final dx dxVar = oVar.CiW.MRU;
        if (dxVar == null || dxVar.cSx != 1) {
            AppMethodBeat.o(67568);
            return false;
        }
        Log.i("MicroMsg.BankRemitMoneyInputUI", "show alert item");
        h.a((Context) bankRemitMoneyInputUI, dxVar.dQx, "", dxVar.lHB, dxVar.lHA, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitMoneyInputUI.AnonymousClass9 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(67555);
                if (Util.isNullOrNil(dxVar.qwt)) {
                    if (BankRemitMoneyInputUI.this.mKindaEnable) {
                        BankRemitMoneyInputUI.this.showLoading();
                    }
                    BankRemitMoneyInputUI.a(BankRemitMoneyInputUI.this, oVar.CiW.wFL, oVar.CiW.Cjv, oVar.CiW.ynT, oVar.CiW.Cju);
                    AppMethodBeat.o(67555);
                    return;
                }
                if (!Util.isNullOrNil(dxVar.qwt)) {
                    f.p(BankRemitMoneyInputUI.this.getContext(), dxVar.qwt, false);
                }
                AppMethodBeat.o(67555);
            }
        }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitMoneyInputUI.AnonymousClass10 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
            }
        });
        AppMethodBeat.o(67568);
        return true;
    }

    static /* synthetic */ void a(BankRemitMoneyInputUI bankRemitMoneyInputUI, String str, String str2, String str3, String str4) {
        AppMethodBeat.i(67569);
        Log.i("MicroMsg.BankRemitMoneyInputUI", "do start pay");
        PayInfo payInfo = new PayInfo();
        payInfo.dDL = str;
        payInfo.dVv = 49;
        payInfo.channel = com.tencent.mm.plugin.remittance.mobile.a.b.eNt();
        Bundle bundle = new Bundle();
        payInfo.iqp = bundle;
        if (bankRemitMoneyInputUI.mKindaEnable) {
            bundle.putString("key_transfer_bill_id", bankRemitMoneyInputUI.CkH);
            bundle.putString("extinfo_key_2", str2);
            bundle.putString("extinfo_key_3", str3);
            bundle.putString("extinfo_key_4", str4);
            ((com.tencent.mm.pluginsdk.wallet.a) g.af(com.tencent.mm.pluginsdk.wallet.a.class)).startSNSPay(bankRemitMoneyInputUI, payInfo);
            AppMethodBeat.o(67569);
            return;
        }
        bundle.putString("extinfo_key_1", bankRemitMoneyInputUI.getString(R.string.ac4, new Object[]{str3, str4}) + str2);
        com.tencent.mm.pluginsdk.wallet.f.a(bankRemitMoneyInputUI, payInfo, 1);
        AppMethodBeat.o(67569);
    }
}
