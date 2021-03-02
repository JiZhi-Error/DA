package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.plugin.wallet_core.model.v;
import com.tencent.mm.plugin.wallet_core.utils.f;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.wallet_core.c.p;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.tenpay.model.m;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

@com.tencent.mm.ui.base.a(19)
public class WalletVerifyCodeUI extends WalletBaseUI implements WalletFormView.a {
    private Orders CwO;
    private Authen HDR;
    private a IkA = null;
    private TextView IkB;
    private TextView IkC;
    private boolean IkD = false;
    private boolean IkE = true;
    private i IkF = new i();
    private p.a IkG = new p.a() {
        /* class com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI.AnonymousClass11 */

        @Override // com.tencent.mm.wallet_core.c.p.a
        public final void fTo() {
            AppMethodBeat.i(71268);
            WalletVerifyCodeUI.this.fTn();
            AppMethodBeat.o(71268);
        }
    };
    private int Ikv = 60000;
    protected WalletFormView Ikw = null;
    private Button Ikx;
    private String Iky;
    private boolean Ikz = false;
    private Button gxv;
    private PayInfo mPayInfo;
    private String mVerifyCode;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletVerifyCodeUI() {
        AppMethodBeat.i(71271);
        AppMethodBeat.o(71271);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        int i2 = 2;
        AppMethodBeat.i(71272);
        super.onCreate(bundle);
        Log.i("MicroMsg.WalletVertifyCodeUI", "on create");
        setMMTitle(R.string.iu6);
        this.mPayInfo = (PayInfo) getInput().getParcelable("key_pay_info");
        this.CwO = (Orders) getInput().getParcelable("key_orders");
        this.Iky = getInput().getString("key_bank_phone");
        this.IkF = new i(getInput());
        this.Ikz = false;
        initView();
        h hVar = h.INSTANCE;
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf((this.mPayInfo == null || this.mPayInfo.dVv == 0) ? 2 : 1);
        if (!this.Ikz) {
            i2 = 1;
        }
        objArr[1] = Integer.valueOf(i2);
        hVar.a(10706, objArr);
        f.fUi();
        f.b(this, getInput(), 4);
        if (this.IkF.fQm()) {
            h.INSTANCE.a(13731, 5);
            if (!Util.isNullOrNil(this.IkF.HWP.title)) {
                setMMTitle(this.IkF.HWP.title);
            }
            if (this.IkB != null) {
                this.IkB.setText(getString(R.string.itw));
            }
            if (this.gxv != null && !Util.isNullOrNil(this.IkF.HWP.Rtt)) {
                this.gxv.setText(this.IkF.HWP.Rtt);
            }
        }
        this.mNetSceneMgr.addSceneEndListener(1580);
        AppMethodBeat.o(71272);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void finish() {
        AppMethodBeat.i(71273);
        Log.i("MicroMsg.WalletVertifyCodeUI", "do finish: %s", Util.getStack());
        super.finish();
        AppMethodBeat.o(71273);
    }

    /* access modifiers changed from: protected */
    public final String fTl() {
        String str;
        Bankcard bankcard;
        AppMethodBeat.i(71274);
        String nullAs = Util.nullAs(getInput().getString("key_mobile"), "");
        if (!Util.isNullOrNil(nullAs) || (bankcard = (Bankcard) getInput().getParcelable("key_bankcard")) == null) {
            str = nullAs;
        } else {
            str = bankcard.field_mobile;
        }
        AppMethodBeat.o(71274);
        return str;
    }

    /* access modifiers changed from: protected */
    public final void fTm() {
        int i2 = 2;
        AppMethodBeat.i(71275);
        Log.i("MicroMsg.WalletVertifyCodeUI", "get verify code!");
        h hVar = h.INSTANCE;
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf((this.mPayInfo == null || this.mPayInfo.dVv == 0) ? 2 : 1);
        if (!this.Ikz) {
            i2 = 1;
        }
        objArr[1] = Integer.valueOf(i2);
        hVar.a(10706, objArr);
        this.Ikz = true;
        this.Ikx.setClickable(false);
        this.Ikx.setEnabled(false);
        if (this.IkA != null) {
            this.IkA.cancel();
            this.IkA = null;
        }
        a aVar = new a((long) this.Ikv);
        this.IkA = aVar;
        aVar.start();
        if (getNetController().B(this.mVerifyCode)) {
            AppMethodBeat.o(71275);
        } else if (resend(false)) {
            AppMethodBeat.o(71275);
        } else {
            this.HDR = (Authen) getInput().getParcelable("key_authen");
            if (this.HDR == null) {
                Log.w("MicroMsg.WalletVertifyCodeUI", "error authen is null");
                AppMethodBeat.o(71275);
                return;
            }
            f.fUi();
            AppMethodBeat.o(71275);
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        int i2;
        String string;
        AppMethodBeat.i(71276);
        d by = com.tencent.mm.wallet_core.a.by(this);
        final Bankcard bankcard = (Bankcard) getInput().getParcelable("key_bankcard");
        this.IkB = (TextView) findViewById(R.id.a4v);
        this.IkC = (TextView) findViewById(R.id.a4w);
        this.Ikw = (WalletFormView) findViewById(R.id.a4e);
        this.Ikw.setOnInputValidChangeListener(this);
        this.Ikx = (Button) findViewById(R.id.djw);
        this.Ikx.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI.AnonymousClass1 */

            public final void onClick(View view) {
                final int i2;
                AppMethodBeat.i(71259);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletVerifyCodeUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                d process = WalletVerifyCodeUI.this.getProcess();
                if (!WalletVerifyCodeUI.this.IkE || process == null || !"PayProcess".equals(process.dKC())) {
                    WalletVerifyCodeUI.this.fTm();
                } else {
                    if (bankcard == null) {
                        i2 = 0;
                    } else if (bankcard.fQb()) {
                        i2 = 1;
                    } else if (bankcard.fQc()) {
                        i2 = 3;
                    } else {
                        i2 = 2;
                    }
                    d.a aVar = new d.a(WalletVerifyCodeUI.this.getContext());
                    aVar.aoO(R.string.itn);
                    aVar.boo(WalletVerifyCodeUI.this.getString(R.string.itm, new Object[]{WalletVerifyCodeUI.this.fTl()}));
                    aVar.Dk(true);
                    aVar.aoV(R.string.itl);
                    aVar.aoW(R.string.itk);
                    aVar.c(new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI.AnonymousClass1.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(71257);
                            WalletVerifyCodeUI.this.fTm();
                            h.INSTANCE.a(15443, 2, 1, Integer.valueOf(i2));
                            AppMethodBeat.o(71257);
                        }
                    });
                    aVar.d(new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI.AnonymousClass1.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            boolean z;
                            AppMethodBeat.i(71258);
                            Bundle input = WalletVerifyCodeUI.this.getInput();
                            input.putInt("key_err_code", 417);
                            input.putBoolean("key_need_show_switch_phone", true);
                            if (bankcard == null || bankcard.fQb()) {
                                z = true;
                            } else {
                                z = false;
                            }
                            input.putBoolean("key_isbalance", z);
                            com.tencent.mm.wallet_core.a.l(WalletVerifyCodeUI.this, input);
                            h.INSTANCE.a(15443, 2, 2, Integer.valueOf(i2));
                            AppMethodBeat.o(71258);
                        }
                    });
                    aVar.hbn().show();
                    h.INSTANCE.a(15443, 1);
                    WalletVerifyCodeUI.this.IkE = false;
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletVerifyCodeUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(71259);
            }
        });
        this.gxv = (Button) findViewById(R.id.a4b);
        this.gxv.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(71260);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletVerifyCodeUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                WalletVerifyCodeUI.this.hideVKB();
                if (WalletVerifyCodeUI.a(WalletVerifyCodeUI.this, WalletVerifyCodeUI.this.IkG)) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletVerifyCodeUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(71260);
                    return;
                }
                WalletVerifyCodeUI.this.fTn();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletVerifyCodeUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(71260);
            }
        });
        updateView();
        this.Ikx.setClickable(false);
        this.Ikx.setEnabled(false);
        if (this.IkA != null) {
            this.IkA.cancel();
            this.IkA = null;
        }
        a aVar = new a((long) this.Ikv);
        this.IkA = aVar;
        aVar.start();
        TextView textView = (TextView) findViewById(R.id.a4u);
        boolean z = getInput().getBoolean("key_is_changing_balance_phone_num");
        boolean z2 = getInput().getBoolean("key_need_show_switch_phone", false);
        if (!z || z2) {
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
        PayInfo payInfo = (PayInfo) getInput().getParcelable("key_pay_info");
        if (payInfo != null) {
            i2 = payInfo.dVv;
        } else {
            i2 = 0;
        }
        if (z2) {
            textView.setText(R.string.itu);
            textView.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI.AnonymousClass5 */

                public final void onClick(View view) {
                    AppMethodBeat.i(71261);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletVerifyCodeUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Log.i("MicroMsg.WalletVertifyCodeUI", "hy: user clicked on the reset info tv and is balance. ");
                    Log.i("MicroMsg.WalletVertifyCodeUI", "forwardProcess and finish!");
                    Bundle input = WalletVerifyCodeUI.this.getInput();
                    input.putInt("key_err_code", 417);
                    input.putBoolean("key_need_show_switch_phone", true);
                    WalletVerifyCodeUI.this.getInput().putBoolean("key_block_bind_new_card", true);
                    input.putBoolean("key_isbalance", bankcard == null || bankcard.fQb());
                    com.tencent.mm.wallet_core.a.l(WalletVerifyCodeUI.this, input);
                    WalletVerifyCodeUI.this.finish();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletVerifyCodeUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(71261);
                }
            });
        } else if (by == null || !by.hgL() || i2 == 11 || i2 == 21) {
            if (z.aUo()) {
                string = getString(R.string.itr);
            } else {
                string = getString(R.string.itq);
            }
            textView.setText(string);
            textView.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI.AnonymousClass8 */

                public final void onClick(View view) {
                    AppMethodBeat.i(71265);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletVerifyCodeUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    WalletVerifyCodeUI.e(WalletVerifyCodeUI.this);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletVerifyCodeUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(71265);
                }
            });
        } else if (bankcard.fQb() || bankcard.fQc()) {
            String string2 = getInput().getString("key_verify_tail_wording", getString(R.string.itu));
            if (Util.isNullOrNil(string2)) {
                string2 = getString(R.string.itu);
            }
            textView.setText(string2);
            textView.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI.AnonymousClass7 */

                public final void onClick(View view) {
                    boolean z;
                    AppMethodBeat.i(71264);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletVerifyCodeUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Log.i("MicroMsg.WalletVertifyCodeUI", "hy: user clicked on the reset info tv and is balance. ");
                    Log.i("MicroMsg.WalletVertifyCodeUI", "forwardProcess3 and finish!");
                    if (WalletVerifyCodeUI.this.IkF != null && WalletVerifyCodeUI.this.IkF.fQm()) {
                        h.INSTANCE.a(13731, 9);
                    }
                    Bundle input = WalletVerifyCodeUI.this.getInput();
                    input.putInt("key_err_code", 417);
                    input.putBoolean("key_need_show_switch_phone", true);
                    if (bankcard == null || bankcard.fQb()) {
                        z = true;
                    } else {
                        z = false;
                    }
                    input.putBoolean("key_isbalance", z);
                    com.tencent.mm.wallet_core.a.l(WalletVerifyCodeUI.this, input);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletVerifyCodeUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(71264);
                }
            });
        } else {
            textView.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI.AnonymousClass6 */

                public final void onClick(View view) {
                    AppMethodBeat.i(71263);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletVerifyCodeUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    com.tencent.mm.ui.base.h.c(WalletVerifyCodeUI.this, WalletVerifyCodeUI.this.getString(R.string.io6, new Object[]{bankcard.field_desc, bankcard.field_mobile}), "", WalletVerifyCodeUI.this.getString(R.string.io5), WalletVerifyCodeUI.this.getString(R.string.sz), new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI.AnonymousClass6.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(71262);
                            Log.i("MicroMsg.WalletVertifyCodeUI", "forwardProcess2 and finish to reset mobile num!");
                            Bundle input = WalletVerifyCodeUI.this.getInput();
                            input.putInt("key_err_code", 408);
                            com.tencent.mm.wallet_core.a.l(WalletVerifyCodeUI.this, input);
                            WalletVerifyCodeUI.this.finish();
                            AppMethodBeat.o(71262);
                        }
                    }, null);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletVerifyCodeUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(71263);
                }
            });
        }
        this.Ikw.requestFocus();
        final String string3 = getInput().getString("key_QADNA_URL");
        if (!Util.isNullOrNil(string3)) {
            addIconOptionMenu(0, R.drawable.crt, new MenuItem.OnMenuItemClickListener() {
                /* class com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI.AnonymousClass9 */

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(71266);
                    com.tencent.mm.wallet_core.ui.f.p(WalletVerifyCodeUI.this.getContext(), string3, false);
                    AppMethodBeat.o(71266);
                    return true;
                }
            });
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI.AnonymousClass10 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(71267);
                WalletVerifyCodeUI.this.hideVKB();
                if (WalletVerifyCodeUI.this.needConfirmFinish()) {
                    WalletVerifyCodeUI.this.showDialog(1000);
                } else {
                    WalletVerifyCodeUI.this.finish();
                }
                AppMethodBeat.o(71267);
                return false;
            }
        });
        AppMethodBeat.o(71276);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onResume() {
        AppMethodBeat.i(71277);
        super.onResume();
        updateView();
        AppMethodBeat.o(71277);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(71278);
        super.onNewIntent(intent);
        updateView();
        AppMethodBeat.o(71278);
    }

    private void updateView() {
        String str;
        AppMethodBeat.i(71279);
        Bankcard bankcard = (Bankcard) getInput().getParcelable("key_bankcard");
        String fTl = fTl();
        if (!Util.isNullOrNil(fTl) || bankcard == null) {
            str = fTl;
        } else {
            str = bankcard.field_mobile;
            getInput().putString("key_mobile", str);
        }
        this.IkC.setText(getString(R.string.ips, new Object[]{str}));
        CharSequence tips = getTips(0);
        if (!Util.isNullOrNil(tips)) {
            this.IkB.setText(tips);
            AppMethodBeat.o(71279);
            return;
        }
        this.IkB.setText(String.format(getString(R.string.ito), str));
        AppMethodBeat.o(71279);
    }

    /* access modifiers changed from: protected */
    public final void fTn() {
        AppMethodBeat.i(71280);
        Bundle input = getInput();
        String string = getInput().getString("key_pwd1");
        this.mVerifyCode = this.Ikw.getText();
        v vVar = new v();
        vVar.kdF = string;
        vVar.BDB = this.mPayInfo;
        vVar.IaW = this.mVerifyCode;
        vVar.token = Util.nullAs(getInput().getString("kreq_token"), "");
        Bankcard bankcard = (Bankcard) input.getParcelable("key_bankcard");
        if (bankcard != null) {
            vVar.dDj = bankcard.field_bankcardType;
            vVar.ANo = bankcard.field_bindSerial;
            vVar.HUU = Util.nullAs(bankcard.field_arrive_type, "");
        } else {
            vVar.dDj = getInput().getString("key_bank_type");
            if (Util.isNullOrNil(vVar.dDj)) {
                vVar.dDj = getInput().getString("key_bind_card_type", "");
            }
        }
        String string2 = input.getString("key_bind_card_user_token", null);
        if (!Util.isNullOrNil(string2)) {
            vVar.HVe = 1;
            vVar.HQm = string2;
        }
        Log.d("MicroMsg.WalletVertifyCodeUI", "payInfo " + vVar.BDB + " mVerifyCode: " + this.mVerifyCode);
        input.putString("key_verify_code", this.mVerifyCode);
        com.tencent.mm.wallet_core.a.by(this);
        Log.i("MicroMsg.WalletVertifyCodeUI", "do verify result : ".concat(String.valueOf(getNetController().r(this.mVerifyCode, vVar))));
        AppMethodBeat.o(71280);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        boolean z;
        AppMethodBeat.i(71281);
        Log.d("MicroMsg.WalletVertifyCodeUI", " errCode: " + i3 + " errMsg :" + str);
        if (qVar instanceof p) {
            if (i3 != 0 && ((p) qVar).isBlock()) {
                com.tencent.mm.ui.base.h.a((Context) getContext(), str, (String) null, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                });
            }
            AppMethodBeat.o(71281);
            return true;
        }
        if (i2 == 0 && i3 == 0) {
            com.tencent.mm.wallet_core.d by = com.tencent.mm.wallet_core.a.by(this);
            if (qVar instanceof ad) {
                getInput().putBoolean("intent_bind_end", true);
                if (by != null && !"realname_verify_process".equals(by.dKC())) {
                    com.tencent.mm.ui.base.h.cD(this, getString(R.string.i7l));
                }
                Log.i("MicroMsg.WalletVertifyCodeUI", "query bound bank card resp!");
                z = true;
            } else {
                if (!(qVar instanceof com.tencent.mm.wallet_core.tenpay.model.q)) {
                    if (by.c(this, (Bundle) null)) {
                        doSceneForceProgress(new ad(getPayReqKey(), 13));
                        Log.i("MicroMsg.WalletVertifyCodeUI", "to query bound bank card!");
                    } else {
                        z = true;
                    }
                }
                z = false;
            }
            if (qVar instanceof com.tencent.mm.plugin.wallet_core.c.v) {
                h.INSTANCE.a(10707, 2, Integer.valueOf(f.fUj()));
            }
            if (this.HDR != null && (qVar instanceof m)) {
                String token = ((m) qVar).getToken();
                if (!Util.isNullOrNil(token)) {
                    getInput().putString("kreq_token", token);
                }
            }
            if (z) {
                Log.i("MicroMsg.WalletVertifyCodeUI", "forwardProcess1 and finish!");
                com.tencent.mm.wallet_core.a.l(this, getInput());
                if (by == null || !by.dKC().equals("PayProcess")) {
                    Log.i("MicroMsg.WalletVertifyCodeUI", "finish self");
                    finish();
                }
                AppMethodBeat.o(71281);
                return true;
            }
        }
        AppMethodBeat.o(71281);
        return false;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.cad;
    }

    /* access modifiers changed from: package-private */
    public class a extends CountDownTimer {
        public a(long j2) {
            super(j2, 1000);
        }

        public final void onTick(long j2) {
            AppMethodBeat.i(71269);
            WalletVerifyCodeUI.this.Ikx.setText(WalletVerifyCodeUI.this.getString(R.string.iu3) + "(" + (j2 / 1000) + ")");
            AppMethodBeat.o(71269);
        }

        public final void onFinish() {
            AppMethodBeat.i(71270);
            WalletVerifyCodeUI.this.Ikx.setClickable(true);
            WalletVerifyCodeUI.this.Ikx.setEnabled(true);
            WalletVerifyCodeUI.this.Ikx.setText(WalletVerifyCodeUI.this.getString(R.string.iu3));
            AppMethodBeat.o(71270);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(71282);
        boolean onKeyUp = super.onKeyUp(i2, keyEvent);
        AppMethodBeat.o(71282);
        return onKeyUp;
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean getCancelable() {
        return false;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(71284);
        this.mNetSceneMgr.removeSceneEndListener(1580);
        super.onDestroy();
        AppMethodBeat.o(71284);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean needConfirmFinish() {
        AppMethodBeat.i(71285);
        boolean booleanExtra = getIntent().getBooleanExtra("key_need_confirm_finish", false);
        if ((this.mPayInfo == null || !this.mPayInfo.crp) && !booleanExtra) {
            boolean needConfirmFinish = super.needConfirmFinish();
            AppMethodBeat.o(71285);
            return needConfirmFinish;
        }
        AppMethodBeat.o(71285);
        return true;
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onPreSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(71286);
        Log.i("MicroMsg.WalletVertifyCodeUI", "onPreSceneEnd %s %s", Integer.valueOf(i3), qVar);
        if ((qVar instanceof p) && i3 == 0) {
            this.IkD = true;
            u.makeText(this, (int) R.string.ils, 0).show();
            Log.i("MicroMsg.WalletVertifyCodeUI", "tag it isCertInstalled ok");
        }
        AppMethodBeat.o(71286);
        return true;
    }

    @Override // com.tencent.mm.wallet_core.ui.formview.WalletFormView.a
    public final void onInputValidChange(boolean z) {
        AppMethodBeat.i(71283);
        if (this.Ikw.hK(null)) {
            this.gxv.setEnabled(true);
            this.gxv.setClickable(true);
            AppMethodBeat.o(71283);
            return;
        }
        this.gxv.setEnabled(false);
        this.gxv.setClickable(false);
        AppMethodBeat.o(71283);
    }

    static /* synthetic */ boolean a(WalletVerifyCodeUI walletVerifyCodeUI, p.a aVar) {
        AppMethodBeat.i(71287);
        if (walletVerifyCodeUI.IkD) {
            Log.i("MicroMsg.WalletVertifyCodeUI", "isCertInstalled passed");
            AppMethodBeat.o(71287);
            return false;
        } else if (walletVerifyCodeUI.IkF.fQo()) {
            Log.i("MicroMsg.WalletVertifyCodeUI", "tryToinstallCert isBlockInstall %s", aVar);
            if (!Util.isNullOrNil(walletVerifyCodeUI.Ikw.getText())) {
                h.INSTANCE.a(13731, 6);
                walletVerifyCodeUI.doSceneProgress(new p(walletVerifyCodeUI.Ikw.getText(), walletVerifyCodeUI.getPayReqKey(), aVar, true));
                AppMethodBeat.o(71287);
                return true;
            }
            Log.i("MicroMsg.WalletVertifyCodeUI", "tryToinstallCert isBlockInstall sms error %s", aVar);
            AppMethodBeat.o(71287);
            return false;
        } else if (walletVerifyCodeUI.IkF.fQn()) {
            Log.i("MicroMsg.WalletVertifyCodeUI", "tryToinstallCert isNeedInstall %s", aVar);
            h.INSTANCE.a(13731, 6);
            walletVerifyCodeUI.doSceneProgress(new p(walletVerifyCodeUI.Ikw.getText(), walletVerifyCodeUI.getPayReqKey(), aVar, false));
            AppMethodBeat.o(71287);
            return true;
        } else {
            Log.i("MicroMsg.WalletVertifyCodeUI", "no need installcert");
            AppMethodBeat.o(71287);
            return false;
        }
    }

    static /* synthetic */ void e(WalletVerifyCodeUI walletVerifyCodeUI) {
        String string;
        AppMethodBeat.i(71288);
        if (walletVerifyCodeUI.Iky == null) {
            walletVerifyCodeUI.Iky = "";
        }
        if (z.aUo()) {
            string = walletVerifyCodeUI.getString(R.string.itt);
        } else {
            string = walletVerifyCodeUI.getString(R.string.its);
        }
        String format = String.format(string, walletVerifyCodeUI.Iky);
        LayoutInflater layoutInflater = (LayoutInflater) walletVerifyCodeUI.getContext().getSystemService("layout_inflater");
        TextView textView = (TextView) layoutInflater.inflate(R.layout.av0, (ViewGroup) null);
        int dimensionPixelSize = layoutInflater.getContext().getResources().getDimensionPixelSize(R.dimen.hs);
        textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        textView.setText(format);
        com.tencent.mm.ui.base.h.a(walletVerifyCodeUI.getContext(), walletVerifyCodeUI.getString(R.string.itu), walletVerifyCodeUI.getString(R.string.idg), textView, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI.AnonymousClass3 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
            }
        });
        AppMethodBeat.o(71288);
    }
}
