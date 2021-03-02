package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.b.a.kz;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.wallet_core.c.p;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.a;

@a(3)
public class WalletIdCardCheckUI extends WalletBaseUI implements TextView.OnEditorActionListener, WalletFormView.a {
    private WalletFormView HJY;
    private TextView HJZ;
    private TextView HKa;
    private Button HKb;
    private RelativeLayout HKc;
    private int HKd = 1;
    private TextView hbb;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(WalletIdCardCheckUI walletIdCardCheckUI, boolean z) {
        AppMethodBeat.i(214089);
        walletIdCardCheckUI.ya(z);
        AppMethodBeat.o(214089);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.c8j;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(69703);
        super.onCreate(bundle);
        setMMTitle("");
        setActionbarColor(getResources().getColor(R.color.afz));
        addSceneEndListener(1580);
        initView();
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletIdCardCheckUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(69699);
                Log.i("Micromsg.WalletIdCardCheckUI", "onbackbtn click");
                WalletIdCardCheckUI.this.finish();
                AppMethodBeat.o(69699);
                return false;
            }
        });
        AppMethodBeat.o(69703);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void forceCancel() {
        AppMethodBeat.i(69704);
        Log.d("Micromsg.WalletIdCardCheckUI", "check pwd ");
        cleanScenes();
        AppMethodBeat.o(69704);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onResume() {
        AppMethodBeat.i(69705);
        super.onResume();
        AppMethodBeat.o(69705);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onPause() {
        AppMethodBeat.i(69706);
        super.onPause();
        AppMethodBeat.o(69706);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(69707);
        super.onDestroy();
        removeSceneEndListener(1580);
        AppMethodBeat.o(69707);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        String str;
        String str2;
        AppMethodBeat.i(69708);
        this.HJY = (WalletFormView) findViewById(R.id.duk);
        this.HKa = (TextView) findViewById(R.id.jew);
        this.HJZ = (TextView) findViewById(R.id.jex);
        this.HKc = (RelativeLayout) findViewById(R.id.h8y);
        this.hbb = (TextView) findViewById(R.id.jf3);
        ao.a(this.hbb.getPaint(), 0.8f);
        this.HJY.setOnInputValidChangeListener(this);
        this.HJY.setOnEditorActionListener(this);
        int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix((Context) getContext(), 16);
        int fromDPToPix2 = com.tencent.mm.cb.a.fromDPToPix((Context) getContext(), 8);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(fromDPToPix, fromDPToPix);
        layoutParams.gravity = 17;
        layoutParams.rightMargin = fromDPToPix2;
        this.HJY.getInfoIv().setLayoutParams(layoutParams);
        this.HJY.getInfoIv().setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.HJY.getInfoIv().setClearBtnDrawableId$255f295(getResources().getColor(R.color.FG_2));
        this.HKa.setVisibility(4);
        this.HKb = (Button) findViewById(R.id.dz5);
        com.tencent.mm.wallet_core.ui.formview.a.d(this.HJY);
        setEditFocusListener(this.HJY, 1, false);
        this.HJY.getContentEt().post(new Runnable() {
            /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletIdCardCheckUI.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(69700);
                WalletIdCardCheckUI.this.HJY.getContentEt().requestFocus();
                AppMethodBeat.o(69700);
            }
        });
        this.HJY.getContentEt().setSingleLine(false);
        this.HKb.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletIdCardCheckUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(69701);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pwd/ui/WalletIdCardCheckUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (WalletIdCardCheckUI.b(WalletIdCardCheckUI.this)) {
                    kz kzVar = new kz();
                    kzVar.eEH = 1;
                    kzVar.eXI = 1;
                    kzVar.bfK();
                    h.INSTANCE.a(13731, 2);
                    String text = WalletIdCardCheckUI.this.HJY.getText();
                    int i2 = WalletIdCardCheckUI.this.HKd;
                    t.fQI();
                    WalletIdCardCheckUI.this.doSceneProgress(new p(text, i2));
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletIdCardCheckUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(69701);
            }
        });
        this.HKd = t.fQI().fRu();
        an fQI = t.fQI();
        if (fQI.IbK != null) {
            str = fQI.IbK.field_cre_name;
        } else {
            str = "";
        }
        Log.i("Micromsg.WalletIdCardCheckUI", "mIdentityType %d %s", Integer.valueOf(this.HKd), str);
        if (Util.isNullOrNil(str)) {
            str2 = t.fQQ().av(this, this.HKd);
        } else {
            str2 = str;
        }
        WalletFormView walletFormView = this.HJY;
        int i2 = this.HKd;
        com.tencent.mm.wallet_core.ui.formview.a.b logicDelegate = walletFormView.getLogicDelegate();
        if (logicDelegate instanceof a.C2170a) {
            ((a.C2170a) logicDelegate).aqn(i2);
        }
        this.HJY.setTitleText(str2);
        ViewGroup.LayoutParams layoutParams2 = this.HJY.getTitleTv().getLayoutParams();
        layoutParams2.width = -2;
        this.HJY.getTitleTv().setLayoutParams(layoutParams2);
        if (Util.isNullOrNil(this.HJY.getText())) {
            this.HKb.setEnabled(false);
        }
        this.HJY.eIj();
        if (this.HKd == 1) {
            setEditFocusListener(this.HJY, 1, false);
        } else {
            setEditFocusListener(this.HJY, 1, true);
        }
        this.HJY.setHint(getString(R.string.ili, new Object[]{f.bpv(t.fQI().getTrueName())}));
        setTenpayKBStateListener(new com.tencent.mm.wallet_core.ui.a() {
            /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletIdCardCheckUI.AnonymousClass4 */

            @Override // com.tencent.mm.wallet_core.ui.a
            public final void onVisibleStateChange(boolean z) {
                AppMethodBeat.i(214083);
                WalletIdCardCheckUI.a(WalletIdCardCheckUI.this, z);
                AppMethodBeat.o(214083);
            }
        });
        ya(this.mKeyboard.getVisibility() == 0);
        this.HJY.setmWalletFormViewListener(new WalletFormView.c() {
            /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletIdCardCheckUI.AnonymousClass5 */

            @Override // com.tencent.mm.wallet_core.ui.formview.WalletFormView.c
            public final void p(CharSequence charSequence) {
                AppMethodBeat.i(214084);
                if (charSequence.length() > 0) {
                    WalletIdCardCheckUI.this.HKb.setEnabled(true);
                    AppMethodBeat.o(214084);
                    return;
                }
                WalletIdCardCheckUI.this.HKb.setEnabled(false);
                AppMethodBeat.o(214084);
            }
        });
        AppMethodBeat.o(69708);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        return false;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(69709);
        if (this.mKBLayout == null || !this.mKBLayout.isShown()) {
            boolean onKeyUp = super.onKeyUp(i2, keyEvent);
            AppMethodBeat.o(69709);
            return onKeyUp;
        }
        this.mKBLayout.setVisibility(8);
        AppMethodBeat.o(69709);
        return true;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onPreSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(69710);
        Log.d("Micromsg.WalletIdCardCheckUI", " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0 && (qVar instanceof p)) {
            kz kzVar = new kz();
            kzVar.eEH = 1;
            kzVar.eXI = 2;
            kzVar.bfK();
            final Toast makeText = Toast.makeText(getContext(), "", 0);
            View inflate = View.inflate(getContext(), R.layout.pd, null);
            ((WeImageView) inflate.findViewById(R.id.irc)).setImageResource(R.raw.icons_filled_done);
            ((TextView) inflate.findViewById(R.id.ird)).setText(getString(R.string.ill));
            makeText.setGravity(17, 0, 0);
            makeText.setView(inflate);
            makeText.show();
            com.tencent.f.h.RTc.n(new Runnable() {
                /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletIdCardCheckUI.AnonymousClass6 */

                public final void run() {
                    AppMethodBeat.i(214085);
                    makeText.cancel();
                    WalletIdCardCheckUI.this.setResult(-1);
                    WalletIdCardCheckUI.this.finish();
                    AppMethodBeat.o(214085);
                }
            }, 750);
        }
        AppMethodBeat.o(69710);
        return true;
    }

    @Override // com.tencent.mm.wallet_core.ui.formview.WalletFormView.a
    public final void onInputValidChange(boolean z) {
        AppMethodBeat.i(69711);
        this.HKa.setVisibility(4);
        AppMethodBeat.o(69711);
    }

    public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
        return false;
    }

    private void ya(final boolean z) {
        AppMethodBeat.i(214088);
        this.mKeyboard.post(new Runnable() {
            /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletIdCardCheckUI.AnonymousClass8 */

            public final void run() {
                AppMethodBeat.i(214087);
                if (z) {
                    if (WalletIdCardCheckUI.this.HKb.getHeight() + com.tencent.mm.cb.a.fromDPToPix((Context) WalletIdCardCheckUI.this.getContext(), 32) + WalletIdCardCheckUI.this.mKeyboard.getHeight() + com.tencent.mm.cb.a.fromDPToPix((Context) WalletIdCardCheckUI.this.getContext(), 30) > ((WalletIdCardCheckUI.this.HKc.getHeight() - WalletIdCardCheckUI.this.HJY.getTop()) - WalletIdCardCheckUI.this.HJY.getHeight()) - com.tencent.mm.cb.a.fromDPToPix((Context) WalletIdCardCheckUI.this.getContext(), 32)) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) WalletIdCardCheckUI.this.hbb.getLayoutParams();
                        layoutParams.topMargin = com.tencent.mm.cb.a.fromDPToPix((Context) WalletIdCardCheckUI.this.getContext(), 25);
                        WalletIdCardCheckUI.this.hbb.setLayoutParams(layoutParams);
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) WalletIdCardCheckUI.this.HKb.getLayoutParams();
                        layoutParams2.removeRule(12);
                        layoutParams2.addRule(3, R.id.duk);
                        layoutParams2.topMargin = com.tencent.mm.cb.a.fromDPToPix((Context) WalletIdCardCheckUI.this.getContext(), 32);
                        WalletIdCardCheckUI.this.HKb.setLayoutParams(layoutParams2);
                        AppMethodBeat.o(214087);
                        return;
                    }
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) WalletIdCardCheckUI.this.HKb.getLayoutParams();
                    layoutParams3.removeRule(3);
                    layoutParams3.addRule(12);
                    layoutParams3.bottomMargin = com.tencent.mm.cb.a.fromDPToPix((Context) WalletIdCardCheckUI.this.getContext(), 32) + WalletIdCardCheckUI.this.mKeyboard.getHeight() + com.tencent.mm.cb.a.fromDPToPix((Context) WalletIdCardCheckUI.this.getContext(), 30);
                    WalletIdCardCheckUI.this.HKb.setLayoutParams(layoutParams3);
                    AppMethodBeat.o(214087);
                    return;
                }
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) WalletIdCardCheckUI.this.HKb.getLayoutParams();
                layoutParams4.removeRule(3);
                layoutParams4.addRule(12);
                layoutParams4.bottomMargin = com.tencent.mm.cb.a.fromDPToPix((Context) WalletIdCardCheckUI.this.getContext(), 96);
                WalletIdCardCheckUI.this.HKb.setLayoutParams(layoutParams4);
                AppMethodBeat.o(214087);
            }
        });
        AppMethodBeat.o(214088);
    }

    static /* synthetic */ boolean b(WalletIdCardCheckUI walletIdCardCheckUI) {
        AppMethodBeat.i(69712);
        boolean z = true;
        if (!walletIdCardCheckUI.HJY.hK(walletIdCardCheckUI.HKa)) {
            z = false;
            walletIdCardCheckUI.HKa.setText(R.string.i_6);
            walletIdCardCheckUI.HKa.setTextColor(walletIdCardCheckUI.getResources().getColor(R.color.a5c));
        }
        if (z) {
            walletIdCardCheckUI.HKa.setVisibility(4);
        } else {
            com.tencent.mm.ui.base.h.a(walletIdCardCheckUI.getContext(), walletIdCardCheckUI.getContext().getString(R.string.i_6), "", walletIdCardCheckUI.getContext().getString(R.string.idg), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletIdCardCheckUI.AnonymousClass7 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(214086);
                    Log.i("Micromsg.WalletIdCardCheckUI", "click AlertDialog");
                    AppMethodBeat.o(214086);
                }
            });
        }
        walletIdCardCheckUI.HKa.setVisibility(4);
        AppMethodBeat.o(69712);
        return z;
    }
}
