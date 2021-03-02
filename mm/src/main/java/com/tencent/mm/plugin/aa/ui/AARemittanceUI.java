package com.tencent.mm.plugin.aa.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.aa.model.b.g;
import com.tencent.mm.plugin.aa.model.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.r;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.vending.g.d;
import com.tencent.mm.wallet_core.c.ag;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class AARemittanceUI extends BaseAAPresenterActivity {
    private String dFw;
    private String dXh;
    private Dialog jUV = null;
    private int jVe;
    protected ScrollView jVf;
    private WcPayKeyboard jVg;
    private TextView jVh;
    private ImageView jVi;
    private WalletFormView jVj;
    private RelativeLayout jVk;
    private TextView jVl;
    private RelativeLayout jVm;
    private TextView jVn;
    private TextView jVo;
    protected double jVp;
    private String jVq;
    private String jVr;
    private String jVs;
    private String jVt;
    private long jVu;
    private String jVv;
    private g jVw = ((g) aq(g.class));
    private Runnable jVx = new Runnable() {
        /* class com.tencent.mm.plugin.aa.ui.AARemittanceUI.AnonymousClass5 */

        public final void run() {
            AppMethodBeat.i(212966);
            if (AARemittanceUI.this.state == 2 && AARemittanceUI.this.isHandleAutoShowNormalStWcKb()) {
                AARemittanceUI.this.showNormalStWcKb();
            }
            AppMethodBeat.o(212966);
        }
    };
    protected String mDesc = "";
    private int state = 0;

    @Override // com.tencent.mm.plugin.aa.ui.BaseAAPresenterActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public AARemittanceUI() {
        AppMethodBeat.i(212988);
        AppMethodBeat.o(212988);
    }

    static /* synthetic */ void a(AARemittanceUI aARemittanceUI, boolean z) {
        AppMethodBeat.i(213007);
        aARemittanceUI.gf(z);
        AppMethodBeat.o(213007);
    }

    static /* synthetic */ void b(AARemittanceUI aARemittanceUI) {
        AppMethodBeat.i(213004);
        aARemittanceUI.bmw();
        AppMethodBeat.o(213004);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.ae;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.aa.ui.BaseAAPresenterActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(212989);
        super.onCreate(bundle);
        this.jVq = getIntent().getStringExtra("user_name");
        this.jVr = getIntent().getStringExtra("user_real_name");
        this.jVv = getIntent().getStringExtra("chatroom");
        initView();
        addSceneEndListener(2878);
        this.state = 1;
        AppMethodBeat.o(212989);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(212990);
        super.initView();
        this.jVf = (ScrollView) findViewById(R.id.h9a);
        this.jVg = (WcPayKeyboard) findViewById(R.id.joy);
        this.jVh = (TextView) findViewById(R.id.as);
        this.jVi = (ImageView) findViewById(R.id.ap);
        this.jVj = (WalletFormView) findViewById(R.id.ar);
        this.jVk = (RelativeLayout) findViewById(R.id.jg1);
        this.jVl = (TextView) findViewById(R.id.jg4);
        this.jVm = (RelativeLayout) findViewById(R.id.jfz);
        final int intExtra = getIntent().getIntExtra("amount_remind_bit", 4);
        if (LocaleUtil.getApplicationLanguage().equals(LocaleUtil.CHINA) || LocaleUtil.getApplicationLanguage().equals(LocaleUtil.TAIWAN) || LocaleUtil.getApplicationLanguage().equals(LocaleUtil.HONGKONG)) {
            this.jVk.post(new Runnable() {
                /* class com.tencent.mm.plugin.aa.ui.AARemittanceUI.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(212964);
                    AARemittanceUI.this.jVe = AARemittanceUI.this.jVk.getWidth();
                    AARemittanceUI.this.jVm.setVisibility(8);
                    Log.d("MicroMsg.AARemittanceUI", "post: mMaxUnitWidth:%s", Integer.valueOf(AARemittanceUI.this.jVe));
                    AppMethodBeat.o(212964);
                }
            });
            this.jVj.setmWalletFormViewListener(new WalletFormView.c() {
                /* class com.tencent.mm.plugin.aa.ui.AARemittanceUI.AnonymousClass4 */

                @Override // com.tencent.mm.wallet_core.ui.formview.WalletFormView.c
                public final void p(CharSequence charSequence) {
                    AppMethodBeat.i(212965);
                    if (Util.isEqual(intExtra, 0)) {
                        Log.i("MicroMsg.AARemittanceUI", "mAmountRemindBit == 0");
                        AARemittanceUI.this.jVm.setVisibility(8);
                        AppMethodBeat.o(212965);
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
                    if (i3 >= intExtra) {
                        int k = AARemittanceUI.this.jVj.k(charSequence, AARemittanceUI.this.jVe, i2);
                        if (k != 0) {
                            AARemittanceUI.this.jVm.setVisibility(0);
                            AARemittanceUI.this.jVl.setText(ag.aR(MMApplicationContext.getContext(), i3));
                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) AARemittanceUI.this.jVk.getLayoutParams();
                            layoutParams.leftMargin = k;
                            AARemittanceUI.this.jVk.setLayoutParams(layoutParams);
                            AppMethodBeat.o(212965);
                            return;
                        }
                        AARemittanceUI.this.jVm.setVisibility(8);
                        AppMethodBeat.o(212965);
                        return;
                    }
                    AARemittanceUI.this.jVm.setVisibility(8);
                    AppMethodBeat.o(212965);
                }
            });
        } else {
            this.jVm.setVisibility(8);
        }
        this.jVg.fEW();
        this.jVg.setActionText(getString(R.string.aw));
        ((RelativeLayout.LayoutParams) this.jVg.getLayoutParams()).addRule(12);
        gf(false);
        setWPKeyboard(this.jVj.getContentEt(), true, false);
        this.jVj.setmContentAbnormalMoneyCheck(true);
        this.jVj.post(new Runnable() {
            /* class com.tencent.mm.plugin.aa.ui.AARemittanceUI.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(212963);
                AARemittanceUI.this.jVj.getContentEt().requestFocus();
                AppMethodBeat.o(212963);
            }
        });
        final AnonymousClass15 r0 = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.aa.ui.AARemittanceUI.AnonymousClass15 */

            public final void onClick(View view) {
                AppMethodBeat.i(212985);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/aa/ui/AARemittanceUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                AARemittanceUI.this.jVp = Util.getDouble(AARemittanceUI.this.jVj.getText(), 0.0d);
                if (!AARemittanceUI.this.jVj.bql()) {
                    AARemittanceUI.a(AARemittanceUI.this, AARemittanceUI.this.getString(R.string.i7f));
                } else if (AARemittanceUI.this.jVp < 0.01d) {
                    AARemittanceUI.a(AARemittanceUI.this, AARemittanceUI.this.getString(R.string.g1j));
                } else {
                    AARemittanceUI.this.hideWcKb();
                    AARemittanceUI.g(AARemittanceUI.this);
                }
                a.a(this, "com/tencent/mm/plugin/aa/ui/AARemittanceUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(212985);
            }
        };
        this.jVj.getContentEt().setOnEditorActionListener(new TextView.OnEditorActionListener() {
            /* class com.tencent.mm.plugin.aa.ui.AARemittanceUI.AnonymousClass16 */

            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                AppMethodBeat.i(212986);
                if (keyEvent == null || keyEvent.getAction() != 1 || keyEvent.getKeyCode() != 66 || !AARemittanceUI.this.jVg.isShown()) {
                    AppMethodBeat.o(212986);
                } else {
                    Log.i("MicroMsg.AARemittanceUI", "click pay");
                    r0.onClick(null);
                    AppMethodBeat.o(212986);
                }
                return true;
            }
        });
        this.jVj.a(new TextWatcher() {
            /* class com.tencent.mm.plugin.aa.ui.AARemittanceUI.AnonymousClass17 */

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(212987);
                double d2 = Util.getDouble(editable.toString(), 0.0d);
                if (!AARemittanceUI.this.jVj.bql() || d2 < 0.01d) {
                    AARemittanceUI.a(AARemittanceUI.this, false);
                    AppMethodBeat.o(212987);
                    return;
                }
                AARemittanceUI.a(AARemittanceUI.this, true);
                AppMethodBeat.o(212987);
            }
        });
        this.jVj.hib();
        this.jVn = (TextView) findViewById(R.id.h13);
        this.jVo = (TextView) findViewById(R.id.gw);
        bmw();
        setMMTitle("");
        hideActionbarLine();
        this.jVf.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.aa.ui.AARemittanceUI.AnonymousClass14 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(212984);
                if (!AARemittanceUI.this.mWcKeyboard.isShown() || !AARemittanceUI.this.mWcKeyboard.hgP()) {
                    AppMethodBeat.o(212984);
                    return false;
                }
                AARemittanceUI.this.mWcKeyboard.hgN();
                AppMethodBeat.o(212984);
                return true;
            }
        });
        a.b.c(this.jVi, this.jVq);
        String displayName = ((com.tencent.mm.plugin.messenger.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(this.jVq);
        this.jVh.setText(displayName + getString(R.string.f2a, new Object[]{this.jVr}));
        ImageView imageView = (ImageView) findViewById(R.id.jfy);
        if (ao.isDarkMode()) {
            findViewById(R.id.jg3).setVisibility(8);
            findViewById(R.id.jg0).setVisibility(0);
            imageView.setBackgroundResource(R.drawable.crl);
            AppMethodBeat.o(212990);
            return;
        }
        findViewById(R.id.jg3).setVisibility(0);
        findViewById(R.id.jg0).setVisibility(8);
        imageView.setBackgroundResource(R.drawable.crk);
        AppMethodBeat.o(212990);
    }

    private void bmw() {
        AppMethodBeat.i(212991);
        if (Util.isNullOrNil(this.mDesc)) {
            String string = getString(R.string.ax);
            f.a(this.jVo, string, 0, string.length(), new e(new e.a() {
                /* class com.tencent.mm.plugin.aa.ui.AARemittanceUI.AnonymousClass1 */

                @Override // com.tencent.mm.wallet_core.ui.e.a
                public final void bmr() {
                    AppMethodBeat.i(212962);
                    AARemittanceUI.a(AARemittanceUI.this);
                    AppMethodBeat.o(212962);
                }
            }), getContext());
            this.jVo.setVisibility(0);
            this.jVn.setVisibility(8);
            AppMethodBeat.o(212991);
            return;
        }
        String string2 = getString(R.string.fkf);
        String string3 = getString(R.string.b6m, new Object[]{this.mDesc, string2});
        SpannableString c2 = l.c(this, string3);
        f.a(this.jVn, string3, c2.length() - string2.length(), c2.length(), new e(new e.a() {
            /* class com.tencent.mm.plugin.aa.ui.AARemittanceUI.AnonymousClass10 */

            @Override // com.tencent.mm.wallet_core.ui.e.a
            public final void bmr() {
                AppMethodBeat.i(212978);
                AARemittanceUI.a(AARemittanceUI.this);
                AppMethodBeat.o(212978);
            }
        }), getContext());
        this.jVn.setVisibility(0);
        this.jVo.setVisibility(8);
        AppMethodBeat.o(212991);
    }

    @Override // com.tencent.mm.plugin.aa.ui.BaseAAPresenterActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onResume() {
        AppMethodBeat.i(212992);
        super.onResume();
        Log.i("MicroMsg.AARemittanceUI", "onResume()");
        if (this.state == 3 && isHandleAutoShowNormalStWcKb()) {
            showNormalStWcKb();
        }
        this.state = 2;
        AppMethodBeat.o(212992);
    }

    @Override // com.tencent.mm.plugin.aa.ui.BaseAAPresenterActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onPause() {
        AppMethodBeat.i(212993);
        super.onPause();
        Log.i("MicroMsg.AARemittanceUI", "onPause()");
        if (!this.jVg.hgQ()) {
            this.state = 3;
        }
        AppMethodBeat.o(212993);
    }

    @Override // com.tencent.mm.ui.widget.a.c, com.tencent.mm.ui.MMActivity
    public void onDialogDismiss(Dialog dialog) {
        AppMethodBeat.i(212994);
        Log.i("MicroMsg.AARemittanceUI", "onDialogDismiss()");
        MMHandlerThread.postToMainThreadDelayed(this.jVx, 300);
        AppMethodBeat.o(212994);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean isHandleAutoShowNormalStWcKb() {
        AppMethodBeat.i(212995);
        boolean hgR = this.jVg.hgR();
        AppMethodBeat.o(212995);
        return hgR;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(212996);
        if (this.jVg == null || !this.jVg.onKeyUp(i2, keyEvent)) {
            boolean onKeyUp = super.onKeyUp(i2, keyEvent);
            AppMethodBeat.o(212996);
            return onKeyUp;
        }
        AppMethodBeat.o(212996);
        return true;
    }

    @Override // com.tencent.mm.plugin.aa.ui.BaseAAPresenterActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(212997);
        super.onDestroy();
        removeSceneEndListener(2878);
        AppMethodBeat.o(212997);
    }

    @Override // com.tencent.mm.plugin.aa.ui.BaseAAPresenterActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(212998);
        Log.i("MicroMsg.AARemittanceUI", "errType:" + i2 + " errCode:" + i3 + " errMsg:" + str + " scenetype:" + qVar.getType());
        AppMethodBeat.o(212998);
        return false;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(212999);
        super.onActivityResult(i2, i3, intent);
        if (i2 == 233) {
            b(i3, intent);
            AppMethodBeat.o(212999);
            return;
        }
        if (i2 == 222 && i3 == -1) {
            String stringExtra = intent.getStringExtra("Select_Conv_User");
            Log.i("MicroMsg.AARemittanceUI", "select chatroom：%s", stringExtra);
            if (!Util.isNullOrNil(stringExtra)) {
                Intent intent2 = new Intent(getContext(), LaunchAAUI.class);
                intent2.putExtra("enter_scene", 3);
                intent2.putExtra("chatroom_name", stringExtra);
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/aa/ui/AARemittanceUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/aa/ui/AARemittanceUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
        }
        AppMethodBeat.o(212999);
    }

    private void gf(boolean z) {
        AppMethodBeat.i(213000);
        this.jVg.DH(z);
        AppMethodBeat.o(213000);
    }

    public final void b(int i2, Intent intent) {
        AppMethodBeat.i(213001);
        if (i2 == -1) {
            Log.i("MicroMsg.AARemittanceUI", "pay success, payMsgId: %s", this.dXh);
            RealnameGuideHelper realnameGuideHelper = (RealnameGuideHelper) intent.getParcelableExtra("key_realname_guide_helper");
            if (realnameGuideHelper != null) {
                Log.i("MicroMsg.AARemittanceUI", "do realname guide");
                Intent intent2 = new Intent();
                intent2.putExtra("key_realname_guide_helper", realnameGuideHelper);
                c.b(this, "wallet_core", ".id_verify.RealnameDialogActivity", intent2);
            }
            i.SB(this.jVv);
            setResult(-1);
            finish();
            this.jVw.jUm.w(this.dXh, this.jVq, this.jVt).f(new com.tencent.mm.vending.c.a<Void, Void>() {
                /* class com.tencent.mm.plugin.aa.ui.AARemittanceUI.AnonymousClass8 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.vending.c.a
                public final /* synthetic */ Void call(Void r4) {
                    AppMethodBeat.i(212975);
                    Log.i("MicroMsg.AARemittanceUI", "insert msg finish");
                    Void r0 = QZL;
                    AppMethodBeat.o(212975);
                    return r0;
                }
            });
            h.INSTANCE.idkeyStat(407, 12, 1, false);
            this.jVw.jUn.b(this.jVu, this.dFw, intent.getStringExtra("key_trans_id"));
            AppMethodBeat.o(213001);
            return;
        }
        hideLoading();
        AppMethodBeat.o(213001);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void hideLoading() {
        AppMethodBeat.i(213002);
        if (this.jUV != null && this.jUV.isShowing()) {
            this.jUV.dismiss();
            this.jUV = null;
        }
        AppMethodBeat.o(213002);
    }

    static /* synthetic */ void a(AARemittanceUI aARemittanceUI) {
        AppMethodBeat.i(213003);
        com.tencent.f.h.RTc.n(new Runnable() {
            /* class com.tencent.mm.plugin.aa.ui.AARemittanceUI.AnonymousClass11 */

            public final void run() {
                AppMethodBeat.i(212979);
                AARemittanceUI.this.showCircleStWcKb();
                AppMethodBeat.o(212979);
            }
        }, 300);
        com.tencent.mm.plugin.wallet_core.ui.view.a.a(aARemittanceUI, aARemittanceUI.getString(R.string.ax), aARemittanceUI.mDesc, aARemittanceUI.getString(R.string.g1o), true, 20, new h.b() {
            /* class com.tencent.mm.plugin.aa.ui.AARemittanceUI.AnonymousClass12 */

            @Override // com.tencent.mm.ui.base.h.b
            public final boolean onFinish(CharSequence charSequence) {
                AppMethodBeat.i(212981);
                if (!Util.isNullOrNil(charSequence.toString())) {
                    AARemittanceUI.this.mDesc = charSequence.toString();
                    AARemittanceUI.b(AARemittanceUI.this);
                } else {
                    AARemittanceUI.this.mDesc = null;
                    AARemittanceUI.b(AARemittanceUI.this);
                }
                com.tencent.f.h.RTc.n(new Runnable() {
                    /* class com.tencent.mm.plugin.aa.ui.AARemittanceUI.AnonymousClass12.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(212980);
                        AARemittanceUI.this.hideVKB();
                        AARemittanceUI.this.showNormalStWcKb();
                        AppMethodBeat.o(212980);
                    }
                }, 300);
                AppMethodBeat.o(212981);
                return true;
            }
        }, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.aa.ui.AARemittanceUI.AnonymousClass13 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(212983);
                com.tencent.f.h.RTc.n(new Runnable() {
                    /* class com.tencent.mm.plugin.aa.ui.AARemittanceUI.AnonymousClass13.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(212982);
                        AARemittanceUI.this.hideVKB();
                        AARemittanceUI.this.showNormalStWcKb();
                        AppMethodBeat.o(212982);
                    }
                }, 300);
                AppMethodBeat.o(212983);
            }
        });
        AppMethodBeat.o(213003);
    }

    static /* synthetic */ void a(AARemittanceUI aARemittanceUI, String str) {
        AppMethodBeat.i(213005);
        Log.i("MicroMsg.AARemittanceUI", "showErrorDialog,errMsg:%s", str);
        f.a aVar = new f.a(aARemittanceUI.getContext());
        aVar.aC("");
        f.a Dq = aVar.bow(str).Dq(true);
        Dq.JnN = true;
        Dq.apa(R.string.ed6).b(new f.c() {
            /* class com.tencent.mm.plugin.aa.ui.AARemittanceUI.AnonymousClass9 */

            @Override // com.tencent.mm.ui.widget.a.f.c
            public final void e(boolean z, String str) {
                AppMethodBeat.i(212977);
                com.tencent.f.h.RTc.n(new Runnable() {
                    /* class com.tencent.mm.plugin.aa.ui.AARemittanceUI.AnonymousClass9.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(212976);
                        AARemittanceUI.this.showNormalStWcKb();
                        AppMethodBeat.o(212976);
                    }
                }, 300);
                AppMethodBeat.o(212977);
            }
        }).show();
        AppMethodBeat.o(213005);
    }

    static /* synthetic */ void g(AARemittanceUI aARemittanceUI) {
        AppMethodBeat.i(213006);
        aARemittanceUI.jUV = com.tencent.mm.wallet_core.ui.h.a((Context) aARemittanceUI, false, (DialogInterface.OnCancelListener) null);
        aARemittanceUI.jVu = com.tencent.mm.wallet_core.ui.f.nF(aARemittanceUI.jVj.getText(), "100");
        aARemittanceUI.jVw.jUl.j(aARemittanceUI.jVu, aARemittanceUI.mDesc).f(new com.tencent.mm.vending.c.a<Void, r>() {
            /* class com.tencent.mm.plugin.aa.ui.AARemittanceUI.AnonymousClass7 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Void call(r rVar) {
                AppMethodBeat.i(212974);
                final r rVar2 = rVar;
                if (!AARemittanceUI.this.mKindaEnable) {
                    AARemittanceUI.this.hideLoading();
                }
                if (rVar2 != null) {
                    Object[] objArr = new Object[2];
                    objArr[0] = rVar2.KBE;
                    objArr[1] = Integer.valueOf(rVar2.KBE != null ? rVar2.KBE.cSx : 0);
                    Log.i("MicroMsg.AARemittanceUI", "aapay return, alertItem: %s, alertItem.flag: %s", objArr);
                    if (rVar2.KBE == null || rVar2.KBE.cSx != 1) {
                        Log.d("MicroMsg.AARemittanceUI", "aapay return, reqKey: %s", rVar2.wFL);
                        AARemittanceUI.a(AARemittanceUI.this, rVar2);
                    } else {
                        String str = rVar2.KBE.dQx;
                        String str2 = rVar2.KBE.lHA;
                        String str3 = rVar2.KBE.lHB;
                        d.a aVar = new d.a(AARemittanceUI.this);
                        aVar.boo(str);
                        aVar.bou(str3).c(new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.aa.ui.AARemittanceUI.AnonymousClass7.AnonymousClass1 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(212971);
                                Log.i("MicroMsg.AARemittanceUI", "click aaPay doPay");
                                AARemittanceUI.a(AARemittanceUI.this, rVar2);
                                AARemittanceUI.this.jUV = com.tencent.mm.wallet_core.ui.h.b(AARemittanceUI.this, false, null);
                                AppMethodBeat.o(212971);
                            }
                        });
                        aVar.bov(str2).d(new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.aa.ui.AARemittanceUI.AnonymousClass7.AnonymousClass2 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(212973);
                                com.tencent.f.h.RTc.n(new Runnable() {
                                    /* class com.tencent.mm.plugin.aa.ui.AARemittanceUI.AnonymousClass7.AnonymousClass2.AnonymousClass1 */

                                    public final void run() {
                                        AppMethodBeat.i(212972);
                                        AARemittanceUI.this.showNormalStWcKb();
                                        AppMethodBeat.o(212972);
                                    }
                                }, 300);
                                AppMethodBeat.o(212973);
                            }
                        });
                        aVar.hbn().show();
                        AARemittanceUI.this.hideLoading();
                    }
                }
                Void r0 = QZL;
                AppMethodBeat.o(212974);
                return r0;
            }
        }).a(new d.a() {
            /* class com.tencent.mm.plugin.aa.ui.AARemittanceUI.AnonymousClass6 */

            @Override // com.tencent.mm.vending.g.d.a
            public final void cn(Object obj) {
                AppMethodBeat.i(212970);
                Log.i("MicroMsg.AARemittanceUI", "aapay failed: %s", obj);
                AARemittanceUI.this.hideLoading();
                if (obj == null) {
                    AARemittanceUI.a(AARemittanceUI.this, AARemittanceUI.this.getString(R.string.ap));
                } else if (obj instanceof com.tencent.mm.protocal.protobuf.a) {
                    final com.tencent.mm.protocal.protobuf.a aVar = (com.tencent.mm.protocal.protobuf.a) obj;
                    String str = aVar.dQx;
                    String str2 = aVar.lHA;
                    String str3 = aVar.lHB;
                    d.a aVar2 = new d.a(AARemittanceUI.this);
                    aVar2.boo(str);
                    aVar2.bou(str3).c(new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.aa.ui.AARemittanceUI.AnonymousClass6.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(212967);
                            com.tencent.mm.wallet_core.ui.f.p(AARemittanceUI.this.getContext(), aVar.qwt, false);
                            AppMethodBeat.o(212967);
                        }
                    });
                    aVar2.bov(str2).d(new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.aa.ui.AARemittanceUI.AnonymousClass6.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(212969);
                            com.tencent.f.h.RTc.n(new Runnable() {
                                /* class com.tencent.mm.plugin.aa.ui.AARemittanceUI.AnonymousClass6.AnonymousClass2.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(212968);
                                    AARemittanceUI.this.showNormalStWcKb();
                                    AppMethodBeat.o(212968);
                                }
                            }, 300);
                            AppMethodBeat.o(212969);
                        }
                    });
                    aVar2.hbn().show();
                    AppMethodBeat.o(212970);
                    return;
                } else if ((obj instanceof String) && !obj.toString().equalsIgnoreCase("ok")) {
                    AARemittanceUI.a(AARemittanceUI.this, obj.toString());
                    AppMethodBeat.o(212970);
                    return;
                }
                AppMethodBeat.o(212970);
            }
        });
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(13721, 4, 11, 4);
        AppMethodBeat.o(213006);
    }

    static /* synthetic */ void a(AARemittanceUI aARemittanceUI, r rVar) {
        boolean z = true;
        AppMethodBeat.i(213008);
        if (aARemittanceUI.getIntent().getIntExtra("enter_scene", 0) != 1) {
            z = false;
        }
        aARemittanceUI.jVs = rVar.wFL;
        aARemittanceUI.dXh = rVar.dXf;
        aARemittanceUI.jVt = rVar.KBu;
        aARemittanceUI.dFw = rVar.KBM;
        i.a(aARemittanceUI, aARemittanceUI.jVs, z, rVar.Cpg, aARemittanceUI.jVq);
        AppMethodBeat.o(213008);
    }
}
