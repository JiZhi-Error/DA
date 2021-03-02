package com.tencent.mm.plugin.wallet.pwd.ui;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.wallet_core.c.p;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

@a(3)
public class WalletForgotPwdVerifyIdUI extends WalletBaseUI implements View.OnLayoutChangeListener {
    private boolean HJG;
    private TextView HJL;
    private WalletFormView HJM;
    private Button HJN;
    private TextView HJO;
    private LinearLayout HJP;
    ViewGroup.MarginLayoutParams HJQ;
    ViewGroup.MarginLayoutParams HJR;
    private View HJS;
    private boolean HJT = false;
    private boolean HJU = false;
    private boolean HJV = false;
    private boolean HJW = false;
    private TextView hbb;
    private int keyHeight = 0;
    private View lJI;
    private int mEY = 0;
    private MMEditText trx;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(WalletForgotPwdVerifyIdUI walletForgotPwdVerifyIdUI, View view, View view2) {
        AppMethodBeat.i(69696);
        walletForgotPwdVerifyIdUI.scrollToFormEditPosAfterShowTenPay(view, view2, 10);
        AppMethodBeat.o(69696);
    }

    static /* synthetic */ void i(WalletForgotPwdVerifyIdUI walletForgotPwdVerifyIdUI) {
        AppMethodBeat.i(69697);
        walletForgotPwdVerifyIdUI.fPg();
        AppMethodBeat.o(69697);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(69689);
        super.onCreate(bundle);
        Log.i("MicroMsg.WalletForgotPwdVerifyIdUI", "onCreate");
        setActionbarColor(getContext().getResources().getColor(R.color.afz));
        hideActionbarLine();
        setMMTitleVisibility(8);
        this.HJS = findViewById(R.id.h93);
        this.mEY = getWindowManager().getDefaultDisplay().getHeight();
        this.keyHeight = this.mEY / 3;
        this.HJS.addOnLayoutChangeListener(this);
        this.HJG = getInput().getBoolean("key_is_force_bind", false);
        if (!this.HJG) {
            doSceneProgress(new ad(null, 6));
            setContentViewVisibility(4);
        }
        this.trx = (MMEditText) findViewById(R.id.ftd);
        this.HJL = (TextView) findViewById(R.id.dul);
        this.HJM = (WalletFormView) findViewById(R.id.duk);
        this.HJN = (Button) findViewById(R.id.fz0);
        this.HJO = (TextView) findViewById(R.id.gme);
        this.lJI = findViewById(R.id.h8v);
        this.hbb = (TextView) findViewById(R.id.ipm);
        this.HJP = (LinearLayout) findViewById(R.id.ftf);
        this.HJM.setEnabled(false);
        this.HJM.setFocusable(false);
        this.HJN.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdVerifyIdUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(69682);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pwd/ui/WalletForgotPwdVerifyIdUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                String text = WalletForgotPwdVerifyIdUI.this.HJM.getText();
                int fRu = t.fQI().fRu();
                String obj = WalletForgotPwdVerifyIdUI.this.trx.getText().toString();
                if (!Util.isNullOrNil(text) && !Util.isNullOrNil(obj)) {
                    WalletForgotPwdVerifyIdUI.this.getInput().putString("key_identity", text);
                    WalletForgotPwdVerifyIdUI.this.getInput().putInt("key_id_type", fRu);
                    WalletForgotPwdVerifyIdUI.this.getInput().putString("key_true_name", obj);
                    if (WalletForgotPwdVerifyIdUI.this.getProcess() != null) {
                        WalletForgotPwdVerifyIdUI.this.getProcess().dQL.putString("key_identity", text);
                        WalletForgotPwdVerifyIdUI.this.getProcess().dQL.putInt("key_id_type", fRu);
                        WalletForgotPwdVerifyIdUI.this.getProcess().dQL.putString("key_true_name", obj);
                    }
                    WalletForgotPwdVerifyIdUI.this.getNetController().r(text, Integer.valueOf(fRu), obj);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletForgotPwdVerifyIdUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(69682);
            }
        });
        this.HJO.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdVerifyIdUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(69683);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pwd/ui/WalletForgotPwdVerifyIdUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                f.p(WalletForgotPwdVerifyIdUI.this, HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e1p) + "/touch/scene_product.html?scene_id=kf3258", false);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletForgotPwdVerifyIdUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(69683);
            }
        });
        updateView();
        setTenpayKBStateListener(new com.tencent.mm.wallet_core.ui.a() {
            /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdVerifyIdUI.AnonymousClass6 */

            @Override // com.tencent.mm.wallet_core.ui.a
            public final void onVisibleStateChange(boolean z) {
                AppMethodBeat.i(69687);
                if (z) {
                    Log.i("MicroMsg.WalletForgotPwdVerifyIdUI", " TenpayKBS visible");
                    WalletForgotPwdVerifyIdUI.a(WalletForgotPwdVerifyIdUI.this, WalletForgotPwdVerifyIdUI.this.lJI, WalletForgotPwdVerifyIdUI.this.HJM);
                    WalletForgotPwdVerifyIdUI.i(WalletForgotPwdVerifyIdUI.this);
                    AppMethodBeat.o(69687);
                    return;
                }
                Log.i("MicroMsg.WalletForgotPwdVerifyIdUI", " TenpayKBS unvisible");
                WalletForgotPwdVerifyIdUI.j(WalletForgotPwdVerifyIdUI.this);
                WalletForgotPwdVerifyIdUI.this.lJI.scrollTo(0, 0);
                AppMethodBeat.o(69687);
            }
        });
        this.trx.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdVerifyIdUI.AnonymousClass7 */

            public final void onFocusChange(View view, boolean z) {
                AppMethodBeat.i(69688);
                if (z) {
                    Log.i("MicroMsg.WalletForgotPwdVerifyIdUI", " has focus");
                    WalletForgotPwdVerifyIdUI.i(WalletForgotPwdVerifyIdUI.this);
                    AppMethodBeat.o(69688);
                    return;
                }
                Log.i("MicroMsg.WalletForgotPwdVerifyIdUI", " lose focus");
                AppMethodBeat.o(69688);
            }
        });
        this.trx.addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdVerifyIdUI.AnonymousClass4 */

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                AppMethodBeat.i(69685);
                Log.i("MicroMsg.WalletForgotPwdVerifyIdUI", " haveNameext：" + ((Object) WalletForgotPwdVerifyIdUI.this.trx.getText()));
                if (WalletForgotPwdVerifyIdUI.this.trx.getText() == null || "".equals(WalletForgotPwdVerifyIdUI.this.trx.getText().toString())) {
                    WalletForgotPwdVerifyIdUI.this.HJT = false;
                } else {
                    WalletForgotPwdVerifyIdUI.this.HJT = true;
                }
                WalletForgotPwdVerifyIdUI.g(WalletForgotPwdVerifyIdUI.this);
                AppMethodBeat.o(69685);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        this.HJM.a(new TextWatcher() {
            /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdVerifyIdUI.AnonymousClass5 */

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                AppMethodBeat.i(69686);
                if (WalletForgotPwdVerifyIdUI.this.HJM.getText() != null) {
                    WalletForgotPwdVerifyIdUI.this.HJU = true;
                } else {
                    WalletForgotPwdVerifyIdUI.this.HJU = false;
                }
                WalletForgotPwdVerifyIdUI.g(WalletForgotPwdVerifyIdUI.this);
                AppMethodBeat.o(69686);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        AppMethodBeat.o(69689);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void finish() {
        AppMethodBeat.i(69690);
        super.finish();
        getIntent().putExtra("process_id", com.tencent.mm.plugin.wallet.pwd.a.class.hashCode());
        com.tencent.mm.plugin.wallet.pwd.a aVar = (com.tencent.mm.plugin.wallet.pwd.a) com.tencent.mm.wallet_core.a.by(this);
        if (!(aVar == null || aVar.HHO == null)) {
            aVar.HHO.run(-1);
        }
        AppMethodBeat.o(69690);
    }

    private void updateView() {
        AppMethodBeat.i(69691);
        Log.i("MicroMsg.WalletForgotPwdVerifyIdUI", "updateView");
        int i2 = t.fQD().fRN().field_cre_type;
        String str = t.fQD().fRN().field_cre_name;
        String str2 = t.fQD().fRN().field_true_name;
        this.trx.setHint(getString(R.string.iag, new Object[]{f.bps(str2)}));
        if (!Util.isNullOrNil(str)) {
            this.HJL.setText(str);
        } else {
            Log.w("MicroMsg.WalletForgotPwdVerifyIdUI", "creName is null");
        }
        if (i2 == 1) {
            com.tencent.mm.wallet_core.ui.formview.a.d(this.HJM);
            setEditFocusListener(this.HJM, 1, false, false, true);
            AppMethodBeat.o(69691);
            return;
        }
        Log.i("MicroMsg.WalletForgotPwdVerifyIdUI", "no need tenpay keyboard");
        AppMethodBeat.o(69691);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(69692);
        Log.i("MicroMsg.WalletForgotPwdVerifyIdUI", " errCode: %s errMsg: %s  scene: %s", Integer.valueOf(i3), str, qVar);
        if (i2 == 0 && i3 == 0) {
            if (qVar instanceof ad) {
                updateView();
                setContentViewVisibility(0);
            } else if (qVar instanceof com.tencent.mm.plugin.wallet.pwd.a.t) {
                com.tencent.mm.plugin.wallet.pwd.a.t tVar = (com.tencent.mm.plugin.wallet.pwd.a.t) qVar;
                getInput().putInt("key_is_support_face", tVar.HIB);
                getInput().putInt("key_face_action_scene", tVar.scene);
                getInput().putString("key_face_action_package", tVar.packageName);
                getInput().putString("key_face_action_package_sign", tVar.dYK);
                if (tVar.HIC == 1) {
                    com.tencent.mm.wallet_core.c.ad.hhv();
                    String crtNo = com.tencent.mm.wallet_core.c.ad.getCrtNo();
                    com.tencent.mm.wallet_core.c.b.hhj();
                    if (!com.tencent.mm.wallet_core.c.b.isCertExist(crtNo)) {
                        Log.i("MicroMsg.WalletForgotPwdVerifyIdUI", "checkInstallCert, crt not installed");
                        doSceneForceProgress(new p(tVar.HIz, tVar.HIA));
                    } else {
                        Log.i("MicroMsg.WalletForgotPwdVerifyIdUI", "already install cert, go to next process");
                        getProcess().a(this, 0, getInput());
                    }
                } else {
                    Log.i("MicroMsg.WalletForgotPwdVerifyIdUI", "verify realname info finish, go to next process");
                    getProcess().a(this, 0, getInput());
                }
            } else if (qVar instanceof p) {
                Log.i("MicroMsg.WalletForgotPwdVerifyIdUI", "install cert finish, go to next process");
                getProcess().a(this, 0, getInput());
            }
        }
        AppMethodBeat.o(69692);
        return false;
    }

    private void fPg() {
        AppMethodBeat.i(69693);
        Log.i("MicroMsg.WalletForgotPwdVerifyIdUI", " setChangParams()");
        new MMHandler().postDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdVerifyIdUI.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(69684);
                WalletForgotPwdVerifyIdUI.this.hbb.setVisibility(8);
                WalletForgotPwdVerifyIdUI.this.HJO.setVisibility(8);
                WalletForgotPwdVerifyIdUI.this.HJQ = (ViewGroup.MarginLayoutParams) WalletForgotPwdVerifyIdUI.this.HJP.getLayoutParams();
                WalletForgotPwdVerifyIdUI.this.HJQ.topMargin = at.fromDPToPix(WalletForgotPwdVerifyIdUI.this, 47);
                WalletForgotPwdVerifyIdUI.this.HJP.setLayoutParams(WalletForgotPwdVerifyIdUI.this.HJQ);
                WalletForgotPwdVerifyIdUI.this.HJR = (ViewGroup.MarginLayoutParams) WalletForgotPwdVerifyIdUI.this.HJN.getLayoutParams();
                WalletForgotPwdVerifyIdUI.this.HJR.topMargin = at.fromDPToPix(WalletForgotPwdVerifyIdUI.this, 48);
                WalletForgotPwdVerifyIdUI.this.HJN.setLayoutParams(WalletForgotPwdVerifyIdUI.this.HJR);
                AppMethodBeat.o(69684);
            }
        }, 100);
        AppMethodBeat.o(69693);
    }

    public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        AppMethodBeat.i(69694);
        if (i9 == 0 || i5 == 0 || i9 - i5 <= this.keyHeight) {
            if (!(i9 == 0 || i5 == 0 || i5 - i9 <= this.keyHeight)) {
                Log.i("MicroMsg.WalletForgotPwdVerifyIdUI", " down");
            }
            AppMethodBeat.o(69694);
            return;
        }
        Log.i("MicroMsg.WalletForgotPwdVerifyIdUI", " up");
        fPg();
        AppMethodBeat.o(69694);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.c93;
    }

    static /* synthetic */ void g(WalletForgotPwdVerifyIdUI walletForgotPwdVerifyIdUI) {
        AppMethodBeat.i(69695);
        Log.i("MicroMsg.WalletForgotPwdVerifyIdUI", " haveIdentityText：" + walletForgotPwdVerifyIdUI.HJU);
        Log.i("MicroMsg.WalletForgotPwdVerifyIdUI", " haveNameText：" + walletForgotPwdVerifyIdUI.HJT);
        if (!walletForgotPwdVerifyIdUI.HJU || !walletForgotPwdVerifyIdUI.HJT) {
            walletForgotPwdVerifyIdUI.HJN.setEnabled(false);
            AppMethodBeat.o(69695);
            return;
        }
        walletForgotPwdVerifyIdUI.HJN.setEnabled(true);
        AppMethodBeat.o(69695);
    }

    static /* synthetic */ void j(WalletForgotPwdVerifyIdUI walletForgotPwdVerifyIdUI) {
        AppMethodBeat.i(69698);
        Log.i("MicroMsg.WalletForgotPwdVerifyIdUI", " resetParams()");
        walletForgotPwdVerifyIdUI.hbb.setVisibility(0);
        walletForgotPwdVerifyIdUI.HJO.setVisibility(0);
        walletForgotPwdVerifyIdUI.HJQ = (ViewGroup.MarginLayoutParams) walletForgotPwdVerifyIdUI.HJP.getLayoutParams();
        walletForgotPwdVerifyIdUI.HJQ.topMargin = at.fromDPToPix(walletForgotPwdVerifyIdUI, 59);
        walletForgotPwdVerifyIdUI.HJP.setLayoutParams(walletForgotPwdVerifyIdUI.HJQ);
        walletForgotPwdVerifyIdUI.HJR = (ViewGroup.MarginLayoutParams) walletForgotPwdVerifyIdUI.HJN.getLayoutParams();
        walletForgotPwdVerifyIdUI.HJR.topMargin = at.fromDPToPix(walletForgotPwdVerifyIdUI, 114);
        walletForgotPwdVerifyIdUI.HJN.setLayoutParams(walletForgotPwdVerifyIdUI.HJR);
        AppMethodBeat.o(69698);
    }
}
