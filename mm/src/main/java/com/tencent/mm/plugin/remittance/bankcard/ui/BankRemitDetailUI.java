package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.remittance.bankcard.a.l;
import com.tencent.mm.protocal.protobuf.dhs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.c.r;

@a(19)
public class BankRemitDetailUI extends BankRemitBaseUI {
    private TextView CkA;
    private TextView CkB;
    private TextView CkC;
    private TextView CkD;
    private View CkE;
    private View CkF;
    private ViewGroup CkG;
    private String CkH;
    private ImageView Ckv;
    private ImageView Ckw;
    private ImageView Ckx;
    private TextView Cky;
    private TextView Ckz;
    private int jZJ;
    private int mState;
    private Button nAa;
    private LinearLayout ncf;

    @Override // com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBaseUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(67513);
        super.onCreate(bundle);
        addSceneEndListener(1579);
        this.CkH = getIntent().getStringExtra("key_transfer_bill_id");
        this.jZJ = getIntent().getIntExtra("key_enter_scene", 0);
        Log.i("MicroMsg.BankRemitDetailUI", "billId: %s, enterScene: %s", this.CkH, Integer.valueOf(this.jZJ));
        initView();
        Log.i("MicroMsg.BankRemitDetailUI", "do query detail");
        doSceneProgress(new l(this.CkH));
        if (this.jZJ == 0) {
            showHomeBtn(false);
            enableBackMenu(false);
            setMMTitle(R.string.abi);
        } else {
            showHomeBtn(true);
            enableBackMenu(true);
            setMMTitle(R.string.abh);
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitDetailUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(67508);
                Log.i("MicroMsg.BankRemitDetailUI", "back press");
                BankRemitDetailUI.this.finish();
                AppMethodBeat.o(67508);
                return false;
            }
        });
        AppMethodBeat.o(67513);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(67514);
        this.Ckv = (ImageView) findViewById(R.id.acp);
        this.Ckw = (ImageView) findViewById(R.id.acq);
        this.Ckx = (ImageView) findViewById(R.id.acr);
        this.Cky = (TextView) findViewById(R.id.acx);
        this.Ckz = (TextView) findViewById(R.id.acy);
        this.CkA = (TextView) findViewById(R.id.acz);
        this.CkB = (TextView) findViewById(R.id.acm);
        this.CkC = (TextView) findViewById(R.id.acn);
        this.CkD = (TextView) findViewById(R.id.aco);
        this.CkE = findViewById(R.id.acv);
        this.CkF = findViewById(R.id.acw);
        this.ncf = (LinearLayout) findViewById(R.id.acg);
        this.CkG = (ViewGroup) findViewById(R.id.acl);
        if (this.jZJ == 1) {
            findViewById(R.id.ack).setVisibility(8);
            AppMethodBeat.o(67514);
            return;
        }
        this.nAa = (Button) findViewById(R.id.acj);
        this.nAa.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitDetailUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(67509);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/bankcard/ui/BankRemitDetailUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.BankRemitDetailUI", "click finish btn");
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(MMApplicationContext.getPackageName(), "com.tencent.mm.ui.LauncherUI"));
                intent.addFlags(67108864);
                BankRemitDetailUI bankRemitDetailUI = BankRemitDetailUI.this;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(bankRemitDetailUI, bl.axQ(), "com/tencent/mm/plugin/remittance/bankcard/ui/BankRemitDetailUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                bankRemitDetailUI.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(bankRemitDetailUI, "com/tencent/mm/plugin/remittance/bankcard/ui/BankRemitDetailUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/bankcard/ui/BankRemitDetailUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(67509);
            }
        });
        AppMethodBeat.o(67514);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBaseUI
    public final void dYP() {
        AppMethodBeat.i(67515);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.afz)));
        View customView = getSupportActionBar().getCustomView();
        if (customView != null) {
            View findViewById = customView.findViewById(R.id.brt);
            if (findViewById != null) {
                findViewById.setBackgroundColor(getResources().getColor(R.color.ua));
            }
            View findViewById2 = customView.findViewById(16908308);
            if (findViewById2 != null && (findViewById2 instanceof TextView)) {
                ((TextView) findViewById2).setTextColor(getResources().getColor(R.color.a2x));
            }
        }
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(getResources().getColor(R.color.afz));
        }
        BankRemitBaseUI.aC(this);
        getContentView().setFitsSystemWindows(true);
        AppMethodBeat.o(67515);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(67516);
        if (qVar instanceof l) {
            final l lVar = (l) qVar;
            lVar.a(new r.a() {
                /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitDetailUI.AnonymousClass5 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(67512);
                    Log.i("MicroMsg.BankRemitDetailUI", "state: %s, amount: %s, fee: %s, account: %s", Integer.valueOf(lVar.CiT.state), Integer.valueOf(lVar.CiT.yRL), Integer.valueOf(lVar.CiT.MMC), lVar.CiT.MMD);
                    BankRemitDetailUI.this.mState = lVar.CiT.state;
                    BankRemitDetailUI.a(BankRemitDetailUI.this, lVar.CiT.state, lVar.CiT.MMB);
                    BankRemitDetailUI.a(BankRemitDetailUI.this, lVar.CiT);
                    BankRemitDetailUI.this.CkG.setVisibility(0);
                    AppMethodBeat.o(67512);
                }
            }).b(new r.a() {
                /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitDetailUI.AnonymousClass4 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(67511);
                    Log.e("MicroMsg.BankRemitDetailUI", "detail reponse error: %s, %s", Integer.valueOf(lVar.CiT.dDN), lVar.CiT.qwn);
                    if (!Util.isNullOrNil(lVar.CiT.qwn)) {
                        Toast.makeText(BankRemitDetailUI.this, lVar.CiT.qwn, 1).show();
                        AppMethodBeat.o(67511);
                        return;
                    }
                    Toast.makeText(BankRemitDetailUI.this, (int) R.string.ab5, 1).show();
                    AppMethodBeat.o(67511);
                }
            }).c(new r.a() {
                /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitDetailUI.AnonymousClass3 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(67510);
                    Log.e("MicroMsg.BankRemitDetailUI", "net error: %s", qVar);
                    Toast.makeText(BankRemitDetailUI.this, (int) R.string.ab5, 1).show();
                    AppMethodBeat.o(67510);
                }
            });
        }
        AppMethodBeat.o(67516);
        return true;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.ic;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(67517);
        super.onDestroy();
        removeSceneEndListener(1579);
        AppMethodBeat.o(67517);
    }

    static /* synthetic */ void a(BankRemitDetailUI bankRemitDetailUI, int i2, String str) {
        boolean z = true;
        AppMethodBeat.i(67518);
        switch (i2) {
            case 1:
                bankRemitDetailUI.Ckw.setScaleType(ImageView.ScaleType.CENTER_CROP);
                bankRemitDetailUI.Ckw.setImageResource(R.raw.bank_remit_waiting);
                bankRemitDetailUI.CkC.setTextColor(bankRemitDetailUI.getResources().getColor(R.color.a2x));
                bankRemitDetailUI.Ckz.setText(R.string.aba);
                if (!Util.isNullOrNil(str)) {
                    bankRemitDetailUI.CkC.setText(str);
                    bankRemitDetailUI.CkC.setVisibility(0);
                    break;
                }
                break;
            case 2:
                bankRemitDetailUI.CkF.setBackground(bankRemitDetailUI.getResources().getDrawable(R.drawable.f3));
                bankRemitDetailUI.Ckx.setScaleType(ImageView.ScaleType.CENTER_CROP);
                bankRemitDetailUI.Ckx.setImageResource(R.raw.bank_remit_success);
                bankRemitDetailUI.CkA.setTextColor(bankRemitDetailUI.getResources().getColor(R.color.a2x));
                if (!Util.isNullOrNil(str)) {
                    bankRemitDetailUI.CkD.setText(str);
                    bankRemitDetailUI.CkD.setVisibility(0);
                    break;
                }
                break;
            case 3:
                bankRemitDetailUI.Ckw.setScaleType(ImageView.ScaleType.CENTER_CROP);
                bankRemitDetailUI.Ckw.setImageResource(R.raw.bank_remit_delay);
                bankRemitDetailUI.Ckz.setTextColor(bankRemitDetailUI.getResources().getColor(R.color.a2x));
                bankRemitDetailUI.Ckz.setText(R.string.abc);
                if (!Util.isNullOrNil(str)) {
                    bankRemitDetailUI.CkC.setText(str);
                    bankRemitDetailUI.CkC.setVisibility(0);
                    break;
                }
                break;
            case 4:
                bankRemitDetailUI.Ckw.setScaleType(ImageView.ScaleType.CENTER_CROP);
                bankRemitDetailUI.Ckw.setImageResource(R.raw.bank_remit_fail);
                bankRemitDetailUI.Ckz.setTextColor(bankRemitDetailUI.getResources().getColor(R.color.a2x));
                bankRemitDetailUI.Ckz.setText(R.string.abf);
                if (!Util.isNullOrNil(str)) {
                    bankRemitDetailUI.CkC.setText(str);
                    bankRemitDetailUI.CkC.setVisibility(0);
                    break;
                }
                break;
            case 5:
                bankRemitDetailUI.Ckx.setScaleType(ImageView.ScaleType.CENTER_CROP);
                bankRemitDetailUI.Ckx.setImageResource(R.raw.bank_remit_fail);
                bankRemitDetailUI.CkA.setTextColor(bankRemitDetailUI.getResources().getColor(R.color.a2x));
                bankRemitDetailUI.CkA.setText(R.string.abd);
                if (!Util.isNullOrNil(str)) {
                    bankRemitDetailUI.CkD.setText(str);
                    bankRemitDetailUI.CkD.setVisibility(0);
                    break;
                }
                break;
            default:
                Log.w("MicroMsg.BankRemitDetailUI", "unknown state: %s", Integer.valueOf(bankRemitDetailUI.mState));
                z = false;
                break;
        }
        if (z) {
            bankRemitDetailUI.findViewById(R.id.ad1).setVisibility(8);
        }
        AppMethodBeat.o(67518);
    }

    static /* synthetic */ void a(BankRemitDetailUI bankRemitDetailUI, dhs dhs) {
        AppMethodBeat.i(67519);
        BankRemitDetailItemView bankRemitDetailItemView = new BankRemitDetailItemView((Context) bankRemitDetailUI, true);
        BankRemitDetailItemView bankRemitDetailItemView2 = new BankRemitDetailItemView((Context) bankRemitDetailUI, true);
        bankRemitDetailItemView.b(R.string.ab7, ah.hhz() + com.tencent.mm.plugin.remittance.bankcard.model.a.VX(dhs.yRL));
        bankRemitDetailItemView2.b(R.string.ab4, ah.hhz() + com.tencent.mm.plugin.remittance.bankcard.model.a.VX(dhs.MMC));
        bankRemitDetailUI.ncf.addView(bankRemitDetailItemView);
        bankRemitDetailUI.ncf.addView(bankRemitDetailItemView2);
        if (bankRemitDetailUI.jZJ == 1) {
            BankRemitDetailItemView bankRemitDetailItemView3 = new BankRemitDetailItemView(bankRemitDetailUI);
            BankRemitDetailItemView bankRemitDetailItemView4 = new BankRemitDetailItemView(bankRemitDetailUI);
            BankRemitDetailItemView bankRemitDetailItemView5 = new BankRemitDetailItemView(bankRemitDetailUI);
            BankRemitDetailItemView bankRemitDetailItemView6 = new BankRemitDetailItemView(bankRemitDetailUI);
            BankRemitDetailItemView bankRemitDetailItemView7 = new BankRemitDetailItemView(bankRemitDetailUI);
            bankRemitDetailItemView3.b(R.string.ab9, dhs.Cjv);
            bankRemitDetailItemView4.b(R.string.ab8, dhs.MMD);
            bankRemitDetailItemView5.a(bankRemitDetailItemView5.getContext().getString(R.string.ab2), dhs.Cjw, true);
            bankRemitDetailItemView6.b(R.string.abg, dhs.MME);
            if (dhs.state == 2) {
                bankRemitDetailItemView7.b(R.string.ab1, dhs.MMG);
            } else {
                bankRemitDetailItemView7.b(R.string.ab3, dhs.MMF);
            }
            bankRemitDetailUI.ncf.addView(bankRemitDetailItemView3);
            bankRemitDetailUI.ncf.addView(bankRemitDetailItemView4);
            bankRemitDetailUI.ncf.addView(bankRemitDetailItemView5);
            bankRemitDetailUI.ncf.addView(bankRemitDetailItemView6);
            bankRemitDetailUI.ncf.addView(bankRemitDetailItemView7);
        } else {
            bankRemitDetailUI.ncf.setBackgroundResource(R.drawable.f0);
        }
        if (!Util.isNullOrNil(dhs.jCp)) {
            BankRemitDetailItemView bankRemitDetailItemView8 = new BankRemitDetailItemView(bankRemitDetailUI);
            bankRemitDetailItemView8.b(R.string.ab_, dhs.jCp);
            bankRemitDetailUI.ncf.addView(bankRemitDetailItemView8);
        }
        bankRemitDetailUI.findViewById(R.id.ach).setVisibility(8);
        AppMethodBeat.o(67519);
    }
}
