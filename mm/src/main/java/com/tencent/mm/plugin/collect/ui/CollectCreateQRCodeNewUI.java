package com.tencent.mm.plugin.collect.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.collect.model.n;
import com.tencent.mm.plugin.collect.model.t;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.wallet_core.c.ag;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.a;

public class CollectCreateQRCodeNewUI extends WalletBaseUI {
    private int jVe;
    protected ScrollView jVf;
    private WcPayKeyboard jVg;
    private RelativeLayout jVk;
    private TextView jVl;
    private RelativeLayout jVm;
    private TextView jVn;
    private Runnable jVx = new Runnable() {
        /* class com.tencent.mm.plugin.collect.ui.CollectCreateQRCodeNewUI.AnonymousClass8 */

        public final void run() {
            AppMethodBeat.i(213172);
            if (CollectCreateQRCodeNewUI.this.state == 2 && CollectCreateQRCodeNewUI.n(CollectCreateQRCodeNewUI.this)) {
                CollectCreateQRCodeNewUI.this.showNormalStWcKb();
            }
            AppMethodBeat.o(213172);
        }
    };
    private String mDesc = "";
    private WalletFormView qAh;
    private TextView qAi;
    private RelativeLayout qAj;
    private int state = 0;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public CollectCreateQRCodeNewUI() {
        AppMethodBeat.i(213180);
        AppMethodBeat.o(213180);
    }

    static /* synthetic */ void a(CollectCreateQRCodeNewUI collectCreateQRCodeNewUI, boolean z) {
        AppMethodBeat.i(213190);
        collectCreateQRCodeNewUI.gf(z);
        AppMethodBeat.o(213190);
    }

    static /* synthetic */ void l(CollectCreateQRCodeNewUI collectCreateQRCodeNewUI) {
        AppMethodBeat.i(213193);
        collectCreateQRCodeNewUI.bmw();
        AppMethodBeat.o(213193);
    }

    static /* synthetic */ boolean n(CollectCreateQRCodeNewUI collectCreateQRCodeNewUI) {
        AppMethodBeat.i(213194);
        boolean isHandleAutoShowNormalStWcKb = collectCreateQRCodeNewUI.isHandleAutoShowNormalStWcKb();
        AppMethodBeat.o(213194);
        return isHandleAutoShowNormalStWcKb;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.v5;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(213181);
        super.onCreate(bundle);
        addSceneEndListener(1335);
        initView();
        AppMethodBeat.o(213181);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(213182);
        super.onDestroy();
        removeSceneEndListener(1335);
        AppMethodBeat.o(213182);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(213184);
        Log.i("MicroMsg.CollectCreateQRCodeNewUI", "errType: %s ，errCode：%s, errMsg：%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (qVar instanceof t) {
            if (i2 == 0 && i3 == 0) {
                t tVar = (t) qVar;
                Intent intent = new Intent();
                intent.putExtra("ftf_pay_url", tVar.qwI);
                intent.putExtra("key_error_level", tVar.qwK);
                intent.putExtra("ftf_fixed_fee", tVar.qwJ);
                intent.putExtra("ftf_fixed_fee_type", tVar.dFv);
                intent.putExtra("ftf_fixed_desc", tVar.desc);
                setResult(-1, intent);
                hideVKB();
                finish();
                AppMethodBeat.o(213184);
                return true;
            }
        } else if (qVar instanceof n) {
            final n nVar = (n) qVar;
            if (i2 != 0 || i3 != 0) {
                Log.e("MicroMsg.CollectCreateQRCodeNewUI", "net error: %s", nVar);
            } else if (nVar.dDN == 0) {
                Intent intent2 = new Intent();
                intent2.putExtra("ftf_pay_url", nVar.qwo);
                intent2.putExtra("ftf_fixed_fee", ((double) nVar.eht) / 100.0d);
                intent2.putExtra("ftf_fixed_desc", nVar.desc);
                intent2.putExtra("key_currency_unit", nVar.qwx);
                setResult(-1, intent2);
                hideVKB();
                finish();
                AppMethodBeat.o(213184);
                return true;
            } else if (nVar.qwp == 0) {
                h.c(getContext(), nVar.qwn, nVar.qwq, false);
                AppMethodBeat.o(213184);
                return true;
            } else if (nVar.qwp == 1) {
                if (!Util.isNullOrNil(nVar.qwr) && !Util.isNullOrNil(nVar.qws)) {
                    h.c(getContext(), nVar.qwn, nVar.qwq, nVar.qws, nVar.qwr, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.collect.ui.CollectCreateQRCodeNewUI.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(213162);
                            if (!Util.isNullOrNil(nVar.qwt)) {
                                Log.i("MicroMsg.CollectCreateQRCodeNewUI", "goto h5: %s", nVar.qwt);
                                f.p(CollectCreateQRCodeNewUI.this.getContext(), nVar.qwt, true);
                            }
                            AppMethodBeat.o(213162);
                        }
                    }, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.collect.ui.CollectCreateQRCodeNewUI.AnonymousClass9 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                        }
                    });
                }
                AppMethodBeat.o(213184);
                return true;
            }
        }
        AppMethodBeat.o(213184);
        return false;
    }

    private void bmw() {
        AppMethodBeat.i(213185);
        if (!Util.isNullOrNil(this.mDesc)) {
            String string = getString(R.string.b6n);
            SpannableString c2 = l.c(this, getString(R.string.b6m, new Object[]{this.mDesc, string}));
            f.a(this.jVn, c2.toString(), c2.length() - string.length(), c2.length(), new e(new e.a() {
                /* class com.tencent.mm.plugin.collect.ui.CollectCreateQRCodeNewUI.AnonymousClass3 */

                @Override // com.tencent.mm.wallet_core.ui.e.a
                public final void bmr() {
                    AppMethodBeat.i(213164);
                    CollectCreateQRCodeNewUI.k(CollectCreateQRCodeNewUI.this);
                    AppMethodBeat.o(213164);
                }
            }), getContext());
            this.qAi.setVisibility(8);
            this.jVn.setVisibility(0);
            AppMethodBeat.o(213185);
            return;
        }
        String string2 = getString(R.string.b6l);
        f.a(this.qAi, string2, 0, string2.length(), new e(new e.a() {
            /* class com.tencent.mm.plugin.collect.ui.CollectCreateQRCodeNewUI.AnonymousClass4 */

            @Override // com.tencent.mm.wallet_core.ui.e.a
            public final void bmr() {
                AppMethodBeat.i(213165);
                CollectCreateQRCodeNewUI.k(CollectCreateQRCodeNewUI.this);
                AppMethodBeat.o(213165);
            }
        }), getContext());
        this.qAi.setVisibility(0);
        this.jVn.setVisibility(8);
        AppMethodBeat.o(213185);
    }

    private void gf(boolean z) {
        AppMethodBeat.i(213186);
        this.jVg.DH(z);
        AppMethodBeat.o(213186);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onResume() {
        AppMethodBeat.i(213187);
        super.onResume();
        Log.i("MicroMsg.CollectCreateQRCodeNewUI", "onResume()");
        if (this.state == 3 && isHandleAutoShowNormalStWcKb()) {
            showNormalStWcKb();
        }
        this.state = 2;
        AppMethodBeat.o(213187);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onPause() {
        AppMethodBeat.i(213188);
        super.onPause();
        Log.i("MicroMsg.CollectCreateQRCodeNewUI", "onPause()");
        if (!this.jVg.hgQ()) {
            this.state = 3;
        }
        AppMethodBeat.o(213188);
    }

    @Override // com.tencent.mm.ui.widget.a.c, com.tencent.mm.ui.MMActivity
    public void onDialogDismiss(Dialog dialog) {
        AppMethodBeat.i(213189);
        Log.i("MicroMsg.CollectCreateQRCodeNewUI", "onDialogDismiss()");
        MMHandlerThread.postToMainThreadDelayed(this.jVx, 300);
        AppMethodBeat.o(213189);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(213183);
        this.qAh = (WalletFormView) findViewById(R.id.fjf);
        a.f(this.qAh);
        String stringExtra = getIntent().getStringExtra("key_currency_unit");
        if (!Util.isNullOrNil(stringExtra)) {
            this.qAh.getTitleTv().setText(stringExtra);
        } else {
            this.qAh.getTitleTv().setText(ah.hhz());
        }
        this.qAh.a(new TextWatcher() {
            /* class com.tencent.mm.plugin.collect.ui.CollectCreateQRCodeNewUI.AnonymousClass10 */

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(213173);
                double d2 = Util.getDouble(editable.toString(), 0.0d);
                if (!CollectCreateQRCodeNewUI.this.qAh.bql() || d2 < 0.01d) {
                    CollectCreateQRCodeNewUI.a(CollectCreateQRCodeNewUI.this, false);
                    AppMethodBeat.o(213173);
                    return;
                }
                CollectCreateQRCodeNewUI.a(CollectCreateQRCodeNewUI.this, true);
                AppMethodBeat.o(213173);
            }
        });
        this.qAh.hib();
        this.jVn = (TextView) findViewById(R.id.b6o);
        this.qAi = (TextView) findViewById(R.id.b6n);
        bmw();
        this.jVg = (WcPayKeyboard) findViewById(R.id.joy);
        this.jVg.fEW();
        this.jVg.setActionText(getString(R.string.b6h));
        final AnonymousClass13 r0 = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.collect.ui.CollectCreateQRCodeNewUI.AnonymousClass13 */

            public final void onClick(View view) {
                AppMethodBeat.i(213176);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/collect/ui/CollectCreateQRCodeNewUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                double d2 = Util.getDouble(CollectCreateQRCodeNewUI.this.qAh.getText(), 0.0d);
                g.aAi();
                int intValue = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, (Object) 0)).intValue();
                Log.i("MicroMsg.CollectCreateQRCodeNewUI", "wallet region: %s", Integer.valueOf(intValue));
                if (!CollectCreateQRCodeNewUI.this.qAh.bql()) {
                    CollectCreateQRCodeNewUI.a(CollectCreateQRCodeNewUI.this, CollectCreateQRCodeNewUI.this.getString(R.string.i7f));
                } else if (d2 < 0.01d) {
                    CollectCreateQRCodeNewUI.a(CollectCreateQRCodeNewUI.this, CollectCreateQRCodeNewUI.this.getString(R.string.g1j));
                } else if (intValue == 8) {
                    CollectCreateQRCodeNewUI.this.doSceneForceProgress(new n(Math.round(d2 * 100.0d), CollectCreateQRCodeNewUI.this.mDesc, z.aUf()));
                } else {
                    CollectCreateQRCodeNewUI.this.doSceneProgress(new t(d2, "1", CollectCreateQRCodeNewUI.this.mDesc));
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/collect/ui/CollectCreateQRCodeNewUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(213176);
            }
        };
        this.qAh.getContentEt().setOnEditorActionListener(new TextView.OnEditorActionListener() {
            /* class com.tencent.mm.plugin.collect.ui.CollectCreateQRCodeNewUI.AnonymousClass14 */

            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                AppMethodBeat.i(213177);
                if (keyEvent == null || keyEvent.getAction() != 1 || keyEvent.getKeyCode() != 66 || !CollectCreateQRCodeNewUI.this.jVg.isShown()) {
                    AppMethodBeat.o(213177);
                } else {
                    Log.i("MicroMsg.CollectCreateQRCodeNewUI", "click enter");
                    r0.onClick(null);
                    AppMethodBeat.o(213177);
                }
                return true;
            }
        });
        ((RelativeLayout.LayoutParams) this.jVg.getLayoutParams()).addRule(12);
        gf(false);
        setWPKeyboard(this.qAh.getContentEt(), true, false);
        this.qAh.setmContentAbnormalMoneyCheck(true);
        this.qAh.post(new Runnable() {
            /* class com.tencent.mm.plugin.collect.ui.CollectCreateQRCodeNewUI.AnonymousClass15 */

            public final void run() {
                AppMethodBeat.i(213178);
                CollectCreateQRCodeNewUI.this.qAh.getContentEt().requestFocus();
                AppMethodBeat.o(213178);
            }
        });
        this.jVk = (RelativeLayout) findViewById(R.id.jg1);
        this.jVl = (TextView) findViewById(R.id.jg4);
        this.jVm = (RelativeLayout) findViewById(R.id.jfz);
        this.qAj = (RelativeLayout) findViewById(R.id.jg2);
        final int intExtra = getIntent().getIntExtra("amount_remind_bit", 10);
        if (LocaleUtil.getApplicationLanguage().equals(LocaleUtil.CHINA) || LocaleUtil.getApplicationLanguage().equals(LocaleUtil.TAIWAN) || LocaleUtil.getApplicationLanguage().equals(LocaleUtil.HONGKONG)) {
            this.jVk.post(new Runnable() {
                /* class com.tencent.mm.plugin.collect.ui.CollectCreateQRCodeNewUI.AnonymousClass11 */

                public final void run() {
                    AppMethodBeat.i(213174);
                    CollectCreateQRCodeNewUI.this.jVe = CollectCreateQRCodeNewUI.this.jVk.getWidth();
                    CollectCreateQRCodeNewUI.this.jVm.setVisibility(8);
                    Log.d("MicroMsg.CollectCreateQRCodeNewUI", "post: mMaxUnitWidth:%s", Integer.valueOf(CollectCreateQRCodeNewUI.this.jVe));
                    AppMethodBeat.o(213174);
                }
            });
            this.qAh.setmWalletFormViewListener(new WalletFormView.c() {
                /* class com.tencent.mm.plugin.collect.ui.CollectCreateQRCodeNewUI.AnonymousClass12 */

                @Override // com.tencent.mm.wallet_core.ui.formview.WalletFormView.c
                public final void p(CharSequence charSequence) {
                    AppMethodBeat.i(213175);
                    long longValue = Double.valueOf(Util.getDouble(charSequence.toString(), 0.0d)).longValue();
                    int i2 = 0;
                    int i3 = 0;
                    while (longValue != 0) {
                        i2 = (int) (longValue % 10);
                        longValue /= 10;
                        i3++;
                    }
                    if (i3 >= intExtra) {
                        int k = CollectCreateQRCodeNewUI.this.qAh.k(charSequence, CollectCreateQRCodeNewUI.this.jVe, i2);
                        if (k != 0) {
                            CollectCreateQRCodeNewUI.this.jVm.setVisibility(0);
                            CollectCreateQRCodeNewUI.this.jVl.setText(ag.aR(MMApplicationContext.getContext(), i3));
                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) CollectCreateQRCodeNewUI.this.jVk.getLayoutParams();
                            layoutParams.leftMargin = k;
                            CollectCreateQRCodeNewUI.this.jVk.setLayoutParams(layoutParams);
                            AppMethodBeat.o(213175);
                            return;
                        }
                        CollectCreateQRCodeNewUI.this.jVm.setVisibility(8);
                        AppMethodBeat.o(213175);
                        return;
                    }
                    CollectCreateQRCodeNewUI.this.jVm.setVisibility(8);
                    AppMethodBeat.o(213175);
                }
            });
        } else {
            this.jVm.setVisibility(8);
        }
        setMMTitle(R.string.b6k);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.collect.ui.CollectCreateQRCodeNewUI.AnonymousClass16 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(213179);
                CollectCreateQRCodeNewUI.this.setResult(0);
                CollectCreateQRCodeNewUI.this.finish();
                AppMethodBeat.o(213179);
                return true;
            }
        });
        this.jVf = (ScrollView) findViewById(R.id.h9a);
        this.jVf.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.collect.ui.CollectCreateQRCodeNewUI.AnonymousClass2 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(213163);
                if (!CollectCreateQRCodeNewUI.this.mWcKeyboard.isShown() || !CollectCreateQRCodeNewUI.this.mWcKeyboard.hgP()) {
                    AppMethodBeat.o(213163);
                    return false;
                }
                CollectCreateQRCodeNewUI.this.mWcKeyboard.hgN();
                AppMethodBeat.o(213163);
                return true;
            }
        });
        ImageView imageView = (ImageView) findViewById(R.id.jfy);
        if (ao.isDarkMode()) {
            findViewById(R.id.jg3).setVisibility(8);
            findViewById(R.id.jg0).setVisibility(0);
            imageView.setBackgroundResource(R.drawable.crl);
            AppMethodBeat.o(213183);
            return;
        }
        findViewById(R.id.jg3).setVisibility(0);
        findViewById(R.id.jg0).setVisibility(8);
        imageView.setBackgroundResource(R.drawable.crk);
        AppMethodBeat.o(213183);
    }

    static /* synthetic */ void a(CollectCreateQRCodeNewUI collectCreateQRCodeNewUI, String str) {
        AppMethodBeat.i(213191);
        Log.i("MicroMsg.CollectCreateQRCodeNewUI", "showErrorDialog,errMsg:%s", str);
        f.a aVar = new f.a(collectCreateQRCodeNewUI.getContext());
        aVar.aC("");
        f.a Dq = aVar.bow(str).Dq(true);
        Dq.JnN = true;
        Dq.apa(R.string.j34).b(new f.c() {
            /* class com.tencent.mm.plugin.collect.ui.CollectCreateQRCodeNewUI.AnonymousClass7 */

            @Override // com.tencent.mm.ui.widget.a.f.c
            public final void e(boolean z, String str) {
                AppMethodBeat.i(213171);
                com.tencent.f.h.RTc.n(new Runnable() {
                    /* class com.tencent.mm.plugin.collect.ui.CollectCreateQRCodeNewUI.AnonymousClass7.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(213170);
                        CollectCreateQRCodeNewUI.this.showNormalStWcKb();
                        AppMethodBeat.o(213170);
                    }
                }, 300);
                AppMethodBeat.o(213171);
            }
        }).show();
        AppMethodBeat.o(213191);
    }

    static /* synthetic */ void k(CollectCreateQRCodeNewUI collectCreateQRCodeNewUI) {
        AppMethodBeat.i(213192);
        Log.i("MicroMsg.CollectCreateQRCodeNewUI", "onClick() edit desc");
        collectCreateQRCodeNewUI.hideTenpayKB();
        com.tencent.mm.plugin.wallet_core.ui.view.a.a(collectCreateQRCodeNewUI, collectCreateQRCodeNewUI.getString(R.string.b6l), collectCreateQRCodeNewUI.mDesc, "", true, 32, new h.b() {
            /* class com.tencent.mm.plugin.collect.ui.CollectCreateQRCodeNewUI.AnonymousClass5 */

            @Override // com.tencent.mm.ui.base.h.b
            public final boolean onFinish(CharSequence charSequence) {
                AppMethodBeat.i(213167);
                if (!Util.isNullOrNil(charSequence.toString())) {
                    CollectCreateQRCodeNewUI.this.mDesc = charSequence.toString();
                    CollectCreateQRCodeNewUI.l(CollectCreateQRCodeNewUI.this);
                } else {
                    CollectCreateQRCodeNewUI.this.mDesc = "";
                    CollectCreateQRCodeNewUI.l(CollectCreateQRCodeNewUI.this);
                }
                MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.collect.ui.CollectCreateQRCodeNewUI.AnonymousClass5.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(213166);
                        CollectCreateQRCodeNewUI.this.hideVKB();
                        CollectCreateQRCodeNewUI.this.showNormalStWcKb();
                        AppMethodBeat.o(213166);
                    }
                }, 200);
                AppMethodBeat.o(213167);
                return true;
            }
        }, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.collect.ui.CollectCreateQRCodeNewUI.AnonymousClass6 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(213169);
                MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.collect.ui.CollectCreateQRCodeNewUI.AnonymousClass6.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(213168);
                        CollectCreateQRCodeNewUI.this.hideVKB();
                        CollectCreateQRCodeNewUI.this.showNormalStWcKb();
                        AppMethodBeat.o(213168);
                    }
                }, 500);
                AppMethodBeat.o(213169);
            }
        });
        AppMethodBeat.o(213192);
    }
}
