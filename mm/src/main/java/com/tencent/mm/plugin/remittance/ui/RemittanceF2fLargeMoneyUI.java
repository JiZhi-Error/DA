package com.tencent.mm.plugin.remittance.ui;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.gm;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.wallet_core.c.ag;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tenpay.android.wechat.TenpaySecureEditText;

@a(3)
public class RemittanceF2fLargeMoneyUI extends WalletBaseUI {
    private WalletFormView CmT;
    private int Cnv = 4;
    private RelativeLayout Ctj;
    private double Ctl;
    private int jVe;
    private WcPayKeyboard jVg;
    private RelativeLayout jVk;
    private TextView jVl;
    private RelativeLayout jVm;
    private TextView jVn;
    private String mDesc;
    private TextView mPa;
    private String mTitle;
    private RelativeLayout ncd;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bmt;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(163852);
        super.onCreate(bundle);
        Log.i("MicroMsg.RemittanceF2fLargeMoneyUI", "RemittanceF2fLargeMoneyUI show");
        this.Cnv = getIntent().getIntExtra("key_amount_remind_bit", 4);
        this.mTitle = getIntent().getStringExtra("key_title");
        this.mDesc = getIntent().getStringExtra("key_desc");
        initView();
        AppMethodBeat.o(163852);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(163853);
        super.initView();
        setMMTitle("");
        hideActionbarLine();
        setActionbarColor(getResources().getColor(R.color.afz));
        setBackGroundColorResource(R.color.afz);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.remittance.ui.RemittanceF2fLargeMoneyUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(163846);
                RemittanceF2fLargeMoneyUI.this.finish();
                AppMethodBeat.o(163846);
                return true;
            }
        });
        this.ncd = (RelativeLayout) findViewById(R.id.h9a);
        this.mPa = (TextView) findViewById(R.id.c84);
        this.jVn = (TextView) findViewById(R.id.c83);
        this.CmT = (WalletFormView) findViewById(R.id.h0x);
        this.jVg = (WcPayKeyboard) findViewById(R.id.joy);
        this.jVm = (RelativeLayout) findViewById(R.id.jfz);
        this.Ctj = (RelativeLayout) findViewById(R.id.jg2);
        this.mPa.setText(this.mTitle);
        this.jVn.setText(this.mDesc);
        ((WalletTextView) this.CmT.getTitleTv()).setTypeface(4);
        TenpaySecureEditText tenpaySecureEditText = (TenpaySecureEditText) this.CmT.getContentEt();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tenpaySecureEditText.getLayoutParams();
        layoutParams.leftMargin = 0;
        tenpaySecureEditText.setLayoutParams(layoutParams);
        TextView titleTv = this.CmT.getTitleTv();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) titleTv.getLayoutParams();
        layoutParams2.width = -2;
        titleTv.setLayoutParams(layoutParams2);
        setWPKeyboard(this.CmT.getContentEt(), true, true);
        this.jVg.setActionText(getString(R.string.g1m));
        ((RelativeLayout.LayoutParams) this.jVg.getLayoutParams()).addRule(12);
        this.CmT.hib();
        this.CmT.setContentPadding$3b4dfe4b(com.tencent.mm.cb.a.fromDPToPix((Context) getContext(), 2));
        this.CmT.getContentEt().setOnEditorActionListener(new TextView.OnEditorActionListener() {
            /* class com.tencent.mm.plugin.remittance.ui.RemittanceF2fLargeMoneyUI.AnonymousClass2 */

            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                AppMethodBeat.i(163847);
                if (keyEvent != null && keyEvent.getAction() == 1 && keyEvent.getKeyCode() == 66) {
                    Log.i("MicroMsg.RemittanceF2fLargeMoneyUI", "click enter, mTotalAmt:%s", Double.valueOf(RemittanceF2fLargeMoneyUI.this.Ctl));
                    if (RemittanceF2fLargeMoneyUI.this.Ctl <= 0.0d) {
                        u.makeText(RemittanceF2fLargeMoneyUI.this.getContext(), (int) R.string.i7f, 0).show();
                        AppMethodBeat.o(163847);
                    } else {
                        gm gmVar = new gm();
                        gmVar.dKr.dKs = RemittanceF2fLargeMoneyUI.this.getIntent().getStringExtra("key_amount_remind_sign");
                        gmVar.dKr.dKt = (int) Math.round(RemittanceF2fLargeMoneyUI.this.Ctl * 100.0d);
                        gmVar.dKr.dKq = RemittanceF2fLargeMoneyUI.this;
                        EventCenter.instance.publish(gmVar);
                        AppMethodBeat.o(163847);
                    }
                } else {
                    AppMethodBeat.o(163847);
                }
                return true;
            }
        });
        this.CmT.a(new TextWatcher() {
            /* class com.tencent.mm.plugin.remittance.ui.RemittanceF2fLargeMoneyUI.AnonymousClass3 */

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(163848);
                RemittanceF2fLargeMoneyUI.this.Ctl = Util.getDouble(RemittanceF2fLargeMoneyUI.this.CmT.getText(), 0.0d);
                if (RemittanceF2fLargeMoneyUI.this.Ctl <= 0.0d) {
                    RemittanceF2fLargeMoneyUI.a(RemittanceF2fLargeMoneyUI.this, false);
                    AppMethodBeat.o(163848);
                    return;
                }
                RemittanceF2fLargeMoneyUI.a(RemittanceF2fLargeMoneyUI.this, true);
                AppMethodBeat.o(163848);
            }
        });
        this.Ctj.setVisibility(0);
        if (LocaleUtil.getApplicationLanguage().equals(LocaleUtil.CHINA) || LocaleUtil.getApplicationLanguage().equals(LocaleUtil.TAIWAN) || LocaleUtil.getApplicationLanguage().equals(LocaleUtil.HONGKONG)) {
            this.jVk = (RelativeLayout) findViewById(R.id.jg1);
            this.jVl = (TextView) findViewById(R.id.jg4);
            this.jVk.post(new Runnable() {
                /* class com.tencent.mm.plugin.remittance.ui.RemittanceF2fLargeMoneyUI.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(163849);
                    RemittanceF2fLargeMoneyUI.this.jVe = RemittanceF2fLargeMoneyUI.this.jVk.getWidth();
                    RemittanceF2fLargeMoneyUI.this.jVm.setVisibility(8);
                    Log.d("MicroMsg.RemittanceF2fLargeMoneyUI", "post: mMaxUnitWidth:%s", Integer.valueOf(RemittanceF2fLargeMoneyUI.this.jVe));
                    AppMethodBeat.o(163849);
                }
            });
            this.CmT.setmWalletFormViewListener(new WalletFormView.c() {
                /* class com.tencent.mm.plugin.remittance.ui.RemittanceF2fLargeMoneyUI.AnonymousClass5 */

                @Override // com.tencent.mm.wallet_core.ui.formview.WalletFormView.c
                public final void p(CharSequence charSequence) {
                    AppMethodBeat.i(163850);
                    if (Util.isEqual(RemittanceF2fLargeMoneyUI.this.Cnv, 0)) {
                        Log.i("MicroMsg.RemittanceF2fLargeMoneyUI", "mAmountRemindBit == 0");
                        RemittanceF2fLargeMoneyUI.this.jVm.setVisibility(8);
                        AppMethodBeat.o(163850);
                        return;
                    }
                    long longValue = Double.valueOf(Util.getDouble(charSequence.toString(), 0.0d)).longValue();
                    int i2 = 0;
                    int i3 = 0;
                    while (longValue != 0) {
                        i2 = (int) (longValue % 10);
                        longValue /= 10;
                        i3++;
                    }
                    if (i3 >= RemittanceF2fLargeMoneyUI.this.Cnv) {
                        int left = RemittanceF2fLargeMoneyUI.this.CmT.getLeft() + RemittanceF2fLargeMoneyUI.this.CmT.k(charSequence, RemittanceF2fLargeMoneyUI.this.jVe, i2);
                        if (left != 0) {
                            RemittanceF2fLargeMoneyUI.this.jVm.setVisibility(0);
                            RemittanceF2fLargeMoneyUI.this.jVl.setText(ag.aR(MMApplicationContext.getContext(), i3));
                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) RemittanceF2fLargeMoneyUI.this.jVk.getLayoutParams();
                            layoutParams.leftMargin = left;
                            RemittanceF2fLargeMoneyUI.this.jVk.setLayoutParams(layoutParams);
                            AppMethodBeat.o(163850);
                            return;
                        }
                        RemittanceF2fLargeMoneyUI.this.jVm.setVisibility(8);
                        AppMethodBeat.o(163850);
                        return;
                    }
                    RemittanceF2fLargeMoneyUI.this.jVm.setVisibility(8);
                    AppMethodBeat.o(163850);
                }
            });
        } else {
            this.jVm.setVisibility(8);
        }
        this.ncd.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.remittance.ui.RemittanceF2fLargeMoneyUI.AnonymousClass6 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(163851);
                if (RemittanceF2fLargeMoneyUI.this.mWcKeyboard == null || !RemittanceF2fLargeMoneyUI.this.mWcKeyboard.isShown() || !RemittanceF2fLargeMoneyUI.this.mWcKeyboard.hgP()) {
                    AppMethodBeat.o(163851);
                    return false;
                }
                RemittanceF2fLargeMoneyUI.this.mWcKeyboard.hgN();
                AppMethodBeat.o(163851);
                return true;
            }
        });
        AppMethodBeat.o(163853);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onResume() {
        AppMethodBeat.i(163854);
        super.onResume();
        Log.i("MicroMsg.RemittanceF2fLargeMoneyUI", "onResume()");
        e.eNU().gS(this);
        AppMethodBeat.o(163854);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void finish() {
        AppMethodBeat.i(163855);
        super.finish();
        Log.i("MicroMsg.RemittanceF2fLargeMoneyUI", "finish()");
        AppMethodBeat.o(163855);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        return false;
    }

    static /* synthetic */ void a(RemittanceF2fLargeMoneyUI remittanceF2fLargeMoneyUI, boolean z) {
        AppMethodBeat.i(163856);
        if (remittanceF2fLargeMoneyUI.jVg != null) {
            remittanceF2fLargeMoneyUI.jVg.DH(z);
        }
        AppMethodBeat.o(163856);
    }
}
