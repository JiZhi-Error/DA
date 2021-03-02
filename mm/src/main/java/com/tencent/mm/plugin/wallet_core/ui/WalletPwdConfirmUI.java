package com.tencent.mm.plugin.wallet_core.ui;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.aac;
import com.tencent.mm.g.a.aad;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.v;
import com.tencent.mm.plugin.wallet_core.utils.f;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;

@a(19)
public class WalletPwdConfirmUI extends WalletBaseUI {
    private TextView IiQ;
    private boolean IiR = false;
    private MTimerHandler IiS = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI.AnonymousClass5 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(71111);
            if (WalletPwdConfirmUI.this.IiR) {
                WalletPwdConfirmUI.this.IiR = false;
                WalletPwdConfirmUI.e(WalletPwdConfirmUI.this);
            }
            AppMethodBeat.o(71111);
            return false;
        }
    }, false);
    private IListener gmC = new IListener<aac>() {
        /* class com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI.AnonymousClass6 */

        {
            AppMethodBeat.i(160890);
            this.__eventId = aac.class.getName().hashCode();
            AppMethodBeat.o(160890);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(aac aac) {
            AppMethodBeat.i(71112);
            if (aac instanceof aac) {
                Log.d("Micromsg.WalletPwdConfirmUI", "event WalletPwdConfirmDoSecondaryProgressCallbackEvent");
                WalletPwdConfirmUI.this.IiR = false;
                WalletPwdConfirmUI.e(WalletPwdConfirmUI.this);
            }
            AppMethodBeat.o(71112);
            return false;
        }
    };
    private TextView mPa;
    private PayInfo mPayInfo;
    private TextView pYW;
    protected EditHintPasswdView ykY;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletPwdConfirmUI() {
        AppMethodBeat.i(71113);
        AppMethodBeat.o(71113);
    }

    static /* synthetic */ void a(WalletPwdConfirmUI walletPwdConfirmUI, View view, View view2) {
        AppMethodBeat.i(71120);
        walletPwdConfirmUI.scrollToFormEditPosAfterShowTenPay(view, view2, 30);
        AppMethodBeat.o(71120);
    }

    static /* synthetic */ void e(WalletPwdConfirmUI walletPwdConfirmUI) {
        AppMethodBeat.i(71121);
        walletPwdConfirmUI.fTb();
        AppMethodBeat.o(71121);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(71114);
        super.onCreate(bundle);
        hideTitleView();
        this.mPayInfo = (PayInfo) getInput().getParcelable("key_pay_info");
        initView();
        f.b(this, getInput(), 6);
        findViewById(R.id.b47).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(71107);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletPwdConfirmUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (WalletPwdConfirmUI.this.needConfirmFinish()) {
                    WalletPwdConfirmUI.this.hideVKB();
                    WalletPwdConfirmUI.this.showDialog(1000);
                } else {
                    WalletPwdConfirmUI.this.finish();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletPwdConfirmUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(71107);
            }
        });
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(getResources().getColor(R.color.a2r));
            if (Build.VERSION.SDK_INT >= 23) {
                window.getDecorView().setSystemUiVisibility(8192);
            }
        }
        getContentView().setFitsSystemWindows(true);
        AppMethodBeat.o(71114);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(71115);
        this.mPa = (TextView) findViewById(R.id.jhz);
        this.pYW = (TextView) findViewById(R.id.jhu);
        if (getProcess() != null && "ModifyPwdProcess".equals(getProcess().dKC())) {
            this.mPa.setText(R.string.ij1);
        }
        this.pYW.setText(R.string.ism);
        this.IiQ = (TextView) findViewById(R.id.dyr);
        if (!Util.isNullOrNil(getTips(0))) {
            this.IiQ.setText(R.string.isr);
        } else {
            this.IiQ.setText(R.string.vl);
        }
        this.IiQ.setVisibility(0);
        this.IiQ.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(71108);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletPwdConfirmUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                String string = WalletPwdConfirmUI.this.getInput().getString("key_new_pwd1");
                String md5Value = WalletPwdConfirmUI.this.ykY.getMd5Value();
                String string2 = WalletPwdConfirmUI.this.getInput().getString("kreq_token");
                String string3 = WalletPwdConfirmUI.this.getInput().getString("key_verify_code");
                Log.d("Micromsg.WalletPwdConfirmUI", "mPayInfo " + WalletPwdConfirmUI.this.mPayInfo + " vertifyCode: " + string3);
                if (string == null || !string.equals(md5Value)) {
                    com.tencent.mm.wallet_core.a.s(WalletPwdConfirmUI.this, -1002);
                } else {
                    v vVar = new v();
                    vVar.kdF = WalletPwdConfirmUI.this.ykY.getText();
                    vVar.BDB = WalletPwdConfirmUI.this.mPayInfo;
                    vVar.token = string2;
                    vVar.IaW = string3;
                    vVar.IaX = WalletPwdConfirmUI.this.getInput().getBoolean("key_is_bind_bankcard", true);
                    if (!com.tencent.mm.wallet_core.a.by(WalletPwdConfirmUI.this).fTp()) {
                        vVar.flag = "1";
                    } else {
                        vVar.flag = "4";
                    }
                    FavorPayInfo favorPayInfo = (FavorPayInfo) WalletPwdConfirmUI.this.getInput().getParcelable("key_favor_pay_info");
                    if (favorPayInfo != null) {
                        vVar.HUX = favorPayInfo.HXL;
                        vVar.HUY = favorPayInfo.HXI;
                    }
                    WalletPwdConfirmUI.this.getNetController().r(vVar);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletPwdConfirmUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(71108);
            }
        });
        this.IiQ.setEnabled(false);
        this.IiQ.setClickable(false);
        this.ykY = (EditHintPasswdView) findViewById(R.id.dyp);
        com.tencent.mm.wallet_core.ui.formview.a.a(this.ykY);
        this.ykY.setEditTextMaxLength(6);
        this.ykY.setOnInputValidListener(new EditHintPasswdView.a() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI.AnonymousClass3 */

            @Override // com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a
            public final void onInputValidChange(boolean z) {
                AppMethodBeat.i(71109);
                if (z) {
                    String string = WalletPwdConfirmUI.this.getInput().getString("key_new_pwd1");
                    String md5Value = WalletPwdConfirmUI.this.ykY.getMd5Value();
                    if (string == null || !string.equals(md5Value)) {
                        com.tencent.mm.wallet_core.a.s(WalletPwdConfirmUI.this, -1002);
                        AppMethodBeat.o(71109);
                        return;
                    }
                    WalletPwdConfirmUI.this.IiQ.setEnabled(z);
                    WalletPwdConfirmUI.this.IiQ.setClickable(z);
                    AppMethodBeat.o(71109);
                    return;
                }
                WalletPwdConfirmUI.this.IiQ.setEnabled(z);
                WalletPwdConfirmUI.this.IiQ.setClickable(z);
                AppMethodBeat.o(71109);
            }
        });
        findViewById(R.id.a4v).setVisibility(8);
        setEditFocusListener(this.ykY, 0, false);
        final ScrollView scrollView = (ScrollView) findViewById(R.id.h9a);
        setTenpayKBStateListener(new com.tencent.mm.wallet_core.ui.a() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI.AnonymousClass4 */

            @Override // com.tencent.mm.wallet_core.ui.a
            public final void onVisibleStateChange(boolean z) {
                AppMethodBeat.i(71110);
                if (z) {
                    WalletPwdConfirmUI.a(WalletPwdConfirmUI.this, scrollView, WalletPwdConfirmUI.this.IiQ);
                    AppMethodBeat.o(71110);
                    return;
                }
                scrollView.scrollTo(0, 0);
                AppMethodBeat.o(71110);
            }
        });
        AppMethodBeat.o(71115);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onResume() {
        AppMethodBeat.i(71116);
        this.ykY.requestFocus();
        super.onResume();
        EventCenter.instance.addListener(this.gmC);
        AppMethodBeat.o(71116);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onPause() {
        AppMethodBeat.i(71117);
        super.onPause();
        EventCenter.instance.removeListener(this.gmC);
        AppMethodBeat.o(71117);
    }

    private void fTb() {
        AppMethodBeat.i(71118);
        Bundle input = getInput();
        input.putBoolean("intent_bind_end", true);
        com.tencent.mm.wallet_core.a.l(this, input);
        AppMethodBeat.o(71118);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onProgressFinish() {
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: com.tencent.mm.sdk.event.EventCenter */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        String str2;
        AppMethodBeat.i(71119);
        if (i2 == 0 && i3 == 0) {
            getInput().putString("key_pwd1", this.ykY.getText());
            if (qVar instanceof ad) {
                if (!this.IiR) {
                    fTb();
                }
            } else if (com.tencent.mm.wallet_core.a.by(this) == null || !com.tencent.mm.wallet_core.a.by(this).c(this, (Bundle) null)) {
                com.tencent.mm.wallet_core.a.l(this, getInput());
            } else {
                if (this.mPayInfo != null) {
                    str2 = this.mPayInfo.dDL;
                } else {
                    str2 = "";
                }
                doSceneForceProgress(new ad(str2, 22));
                aad aad = new aad();
                if (EventCenter.instance.hasListener(aad.getClass())) {
                    this.IiR = true;
                    EventCenter.instance.publish(aad);
                }
                this.IiS.startTimer(10000);
            }
            AppMethodBeat.o(71119);
            return true;
        }
        AppMethodBeat.o(71119);
        return false;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.ca3;
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean getCancelable() {
        return false;
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean needConfirmFinish() {
        AppMethodBeat.i(214246);
        if (getProcess() instanceof com.tencent.mm.plugin.wallet_core.id_verify.a) {
            AppMethodBeat.o(214246);
            return false;
        }
        AppMethodBeat.o(214246);
        return true;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }
}
