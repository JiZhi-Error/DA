package com.tencent.mm.plugin.honey_pay.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.plugin.wallet_core.ui.q;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.math.RoundingMode;

public class HoneyPayGiveCardUI extends HoneyPayBaseUI {
    private ScrollView jVf;
    private String mRa;
    private String mTrueName;
    private int qjx;
    private ImageView qyu;
    private String rcG;
    private long ykN = 100000;
    private long ykO = 0;
    private String yla;
    private WalletFormView yli;
    private TextView ylj;
    private TextView ylk;
    private TextView yll;
    private TextView ylm;
    private TextView yln;
    private CdnImageView ylo;
    private MMEditText ylp;

    @Override // com.tencent.mm.plugin.honey_pay.ui.HoneyPayBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(HoneyPayGiveCardUI honeyPayGiveCardUI, View view, View view2) {
        AppMethodBeat.i(64768);
        honeyPayGiveCardUI.scrollToFormEditPosAfterShowTenPay(view, view2, 10);
        AppMethodBeat.o(64768);
    }

    static /* synthetic */ void f(HoneyPayGiveCardUI honeyPayGiveCardUI) {
        AppMethodBeat.i(64767);
        honeyPayGiveCardUI.dYU();
        AppMethodBeat.o(64767);
    }

    static /* synthetic */ void i(HoneyPayGiveCardUI honeyPayGiveCardUI) {
        AppMethodBeat.i(64769);
        honeyPayGiveCardUI.qg(false);
        AppMethodBeat.o(64769);
    }

    static /* synthetic */ void j(HoneyPayGiveCardUI honeyPayGiveCardUI) {
        AppMethodBeat.i(64770);
        honeyPayGiveCardUI.qf(false);
        AppMethodBeat.o(64770);
    }

    @Override // com.tencent.mm.plugin.honey_pay.ui.HoneyPayBaseUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(64757);
        this.wwG = R.color.ul;
        super.onCreate(bundle);
        getWindow().setBackgroundDrawableResource(R.color.afz);
        this.ykN = getIntent().getLongExtra("key_max_credit_line", 0);
        this.ykO = getIntent().getLongExtra("key_min_credit_line", 0);
        this.mTrueName = getIntent().getStringExtra("key_true_name");
        this.mRa = getIntent().getStringExtra("key_username");
        this.yla = getIntent().getStringExtra("key_wishing");
        this.rcG = getIntent().getStringExtra("key_icon_url");
        this.qjx = getIntent().getIntExtra("key_cardtype", 0);
        if (this.qjx == 0) {
            Log.w(this.TAG, "error card type!!");
            finish();
        }
        initView();
        setMMTitle(R.string.e0h);
        AppMethodBeat.o(64757);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(64758);
        this.jVf = (ScrollView) findViewById(R.id.drx);
        this.yli = (WalletFormView) findViewById(R.id.drv);
        this.ylj = (TextView) findViewById(R.id.drr);
        this.ylk = (TextView) findViewById(R.id.dry);
        this.qyu = (ImageView) findViewById(R.id.drp);
        this.yll = (TextView) findViewById(R.id.drs);
        this.ylm = (TextView) findViewById(R.id.drt);
        this.yln = (TextView) findViewById(R.id.ds0);
        this.ylp = (MMEditText) findViewById(R.id.drz);
        a.b.a(this.qyu, this.mRa, 0.06f, false);
        String ht = f.ht(this.mRa, 10);
        if (!Util.isNullOrNil(this.mTrueName)) {
            ht = String.format("%s(%s)", ht, this.mTrueName);
        }
        this.ylj.setText(l.b(getContext(), ht, this.ylj.getTextSize()));
        this.yli.setContentPadding$3b4dfe4b(0);
        this.yli.getTitleTv().setText(ah.hhz());
        this.yli.a(new TextWatcher() {
            /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayGiveCardUI.AnonymousClass1 */

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(64748);
                if (editable.toString().startsWith(".")) {
                    editable.insert(0, AppEventsConstants.EVENT_PARAM_VALUE_NO);
                }
                String obj = editable.toString();
                int indexOf = obj.indexOf(".");
                int length = obj.length();
                if (indexOf >= 0 && length - indexOf > 2) {
                    editable.delete(indexOf + 3, length);
                }
                HoneyPayGiveCardUI.a(HoneyPayGiveCardUI.this);
                AppMethodBeat.o(64748);
            }
        });
        this.yli.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayGiveCardUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(64749);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/honey_pay/ui/HoneyPayGiveCardUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                HoneyPayGiveCardUI.this.yli.d(HoneyPayGiveCardUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/honey_pay/ui/HoneyPayGiveCardUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(64749);
            }
        });
        this.ylm.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayGiveCardUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(64750);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/honey_pay/ui/HoneyPayGiveCardUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                HoneyPayGiveCardUI.this.ylm.setVisibility(8);
                HoneyPayGiveCardUI.this.yli.setVisibility(0);
                HoneyPayGiveCardUI.this.yli.d(HoneyPayGiveCardUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/honey_pay/ui/HoneyPayGiveCardUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(64750);
            }
        });
        this.yll.setClickable(true);
        this.yll.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayGiveCardUI.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(64751);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/honey_pay/ui/HoneyPayGiveCardUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.d(HoneyPayGiveCardUI.this.TAG, "click give btn");
                if (HoneyPayGiveCardUI.a(HoneyPayGiveCardUI.this)) {
                    HoneyPayGiveCardUI.this.hideTenpayKB();
                    HoneyPayGiveCardUI.d(HoneyPayGiveCardUI.this);
                } else {
                    Log.w(HoneyPayGiveCardUI.this.TAG, "over limit when click");
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/honey_pay/ui/HoneyPayGiveCardUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(64751);
            }
        });
        this.yln.setClickable(true);
        this.yln.setOnTouchListener(new o(this));
        this.ylp.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayGiveCardUI.AnonymousClass5 */

            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                AppMethodBeat.i(64752);
                if (i2 == 6 || i2 == 5) {
                    HoneyPayGiveCardUI.this.yla = HoneyPayGiveCardUI.this.ylp.getText().toString();
                    HoneyPayGiveCardUI.this.hideVKB();
                    HoneyPayGiveCardUI.f(HoneyPayGiveCardUI.this);
                }
                AppMethodBeat.o(64752);
                return false;
            }
        });
        this.ylp.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayGiveCardUI.AnonymousClass6 */

            public final void onFocusChange(View view, boolean z) {
                AppMethodBeat.i(64753);
                if (!z) {
                    HoneyPayGiveCardUI.this.yla = HoneyPayGiveCardUI.this.ylp.getText().toString();
                    HoneyPayGiveCardUI.f(HoneyPayGiveCardUI.this);
                }
                AppMethodBeat.o(64753);
            }
        });
        dYU();
        setTenpayKBStateListener(new com.tencent.mm.wallet_core.ui.a() {
            /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayGiveCardUI.AnonymousClass7 */

            @Override // com.tencent.mm.wallet_core.ui.a
            public final void onVisibleStateChange(boolean z) {
                AppMethodBeat.i(64754);
                if (z) {
                    HoneyPayGiveCardUI.a(HoneyPayGiveCardUI.this, HoneyPayGiveCardUI.this.jVf, HoneyPayGiveCardUI.this.yll);
                    AppMethodBeat.o(64754);
                    return;
                }
                HoneyPayGiveCardUI.this.jVf.scrollTo(0, 0);
                HoneyPayGiveCardUI.this.yli.eIi();
                if (Util.isNullOrNil(HoneyPayGiveCardUI.this.yli.getText())) {
                    HoneyPayGiveCardUI.this.yli.setVisibility(8);
                    HoneyPayGiveCardUI.this.ylm.setVisibility(0);
                    HoneyPayGiveCardUI.i(HoneyPayGiveCardUI.this);
                    HoneyPayGiveCardUI.j(HoneyPayGiveCardUI.this);
                }
                AppMethodBeat.o(64754);
            }
        });
        setEditFocusListener(this.yli, 2, false);
        this.yli.postDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayGiveCardUI.AnonymousClass8 */

            public final void run() {
                AppMethodBeat.i(64755);
                HoneyPayGiveCardUI.this.yli.d(HoneyPayGiveCardUI.this);
                AppMethodBeat.o(64755);
            }
        }, 100);
        this.ylo = (CdnImageView) findViewById(R.id.drw);
        if (!Util.isNullOrNil(this.rcG)) {
            this.ylo.gI(this.rcG, c.dYO());
            AppMethodBeat.o(64758);
            return;
        }
        this.ylo.setImageResource(c.dYO());
        AppMethodBeat.o(64758);
    }

    private void dYU() {
        AppMethodBeat.i(64759);
        this.yln.setVisibility(0);
        this.ylp.setVisibility(8);
        this.ylp.setText(this.yla);
        this.ylp.setSelection(this.yla.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        String string = getString(R.string.e0y);
        SpannableString b2 = l.b(getContext(), this.yla, this.yln.getTextSize());
        spannableStringBuilder.append((CharSequence) b2);
        spannableStringBuilder.append((CharSequence) " ");
        spannableStringBuilder.append((CharSequence) string);
        spannableStringBuilder.setSpan(new q(1, new q.a() {
            /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayGiveCardUI.AnonymousClass9 */

            @Override // com.tencent.mm.plugin.wallet_core.ui.q.a
            public final void dF(View view) {
                AppMethodBeat.i(64756);
                HoneyPayGiveCardUI.this.hideTenpayKB();
                HoneyPayGiveCardUI.this.yln.setVisibility(8);
                HoneyPayGiveCardUI.this.ylp.setVisibility(0);
                HoneyPayGiveCardUI.this.ylp.requestFocus();
                HoneyPayGiveCardUI.this.showVKB();
                AppMethodBeat.o(64756);
            }
        }), b2.length() + 1, spannableStringBuilder.length(), 34);
        this.yln.setText(spannableStringBuilder);
        AppMethodBeat.o(64759);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(64760);
        super.onDestroy();
        AppMethodBeat.o(64760);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        return false;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.aun;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(64761);
        super.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(64761);
    }

    private void qf(boolean z) {
        AppMethodBeat.i(64762);
        if (!z || this.ylk.isShown()) {
            if (!z && this.ylk.isShown()) {
                this.ylk.startAnimation(AnimationUtils.loadAnimation(this, R.anim.d5));
                this.ylk.setVisibility(8);
            }
            AppMethodBeat.o(64762);
            return;
        }
        this.ylk.setText(getString(R.string.e0v, new Object[]{ah.hhz() + f.a(new StringBuilder().append(this.ykO).toString(), "100", 2, RoundingMode.HALF_UP)}));
        this.ylk.startAnimation(AnimationUtils.loadAnimation(this, R.anim.cc));
        this.ylk.setVisibility(0);
        AppMethodBeat.o(64762);
    }

    private void qg(boolean z) {
        AppMethodBeat.i(64763);
        if (!z || this.ylk.isShown()) {
            if (!z && this.ylk.isShown()) {
                this.ylk.startAnimation(AnimationUtils.loadAnimation(this, R.anim.d5));
                this.ylk.setVisibility(8);
            }
            AppMethodBeat.o(64763);
            return;
        }
        this.ylk.setText(getString(R.string.e0r, new Object[]{ah.hhz() + f.b(new StringBuilder().append(this.ykN).toString(), "100", 2, RoundingMode.HALF_UP).toString()}));
        this.ylk.startAnimation(AnimationUtils.loadAnimation(this, R.anim.cc));
        this.ylk.setVisibility(0);
        AppMethodBeat.o(64763);
    }

    private void qh(boolean z) {
        AppMethodBeat.i(64764);
        this.yll.setEnabled(z);
        AppMethodBeat.o(64764);
    }

    static /* synthetic */ boolean a(HoneyPayGiveCardUI honeyPayGiveCardUI) {
        AppMethodBeat.i(64765);
        if (Util.isNullOrNil(honeyPayGiveCardUI.yli.getText())) {
            Log.d(honeyPayGiveCardUI.TAG, "no input, hide alert");
            honeyPayGiveCardUI.qg(false);
            honeyPayGiveCardUI.qf(false);
            honeyPayGiveCardUI.qh(false);
            AppMethodBeat.o(64765);
            return false;
        }
        int nE = f.nE(honeyPayGiveCardUI.yli.getText(), "100");
        Log.d(honeyPayGiveCardUI.TAG, "current fen: %s", Integer.valueOf(nE));
        if (((long) nE) < honeyPayGiveCardUI.ykO) {
            honeyPayGiveCardUI.qf(true);
            honeyPayGiveCardUI.qh(false);
            AppMethodBeat.o(64765);
            return false;
        } else if (((long) nE) > honeyPayGiveCardUI.ykN) {
            honeyPayGiveCardUI.qg(true);
            honeyPayGiveCardUI.qh(false);
            AppMethodBeat.o(64765);
            return false;
        } else if (nE == 0) {
            honeyPayGiveCardUI.qh(false);
            AppMethodBeat.o(64765);
            return false;
        } else {
            honeyPayGiveCardUI.qg(false);
            honeyPayGiveCardUI.qf(false);
            honeyPayGiveCardUI.qh(true);
            AppMethodBeat.o(64765);
            return true;
        }
    }

    static /* synthetic */ void d(HoneyPayGiveCardUI honeyPayGiveCardUI) {
        AppMethodBeat.i(64766);
        Log.i(honeyPayGiveCardUI.TAG, "go to pwd ui");
        long nF = f.nF(honeyPayGiveCardUI.yli.getText(), "100");
        String stringExtra = honeyPayGiveCardUI.getIntent().getStringExtra("key_take_message");
        Intent intent = new Intent(honeyPayGiveCardUI.getContext(), HoneyPayCheckPwdUI.class);
        intent.putExtra("key_scene", 1);
        intent.putExtra("key_credit_line", nF);
        intent.putExtra("key_take_message", stringExtra);
        intent.putExtra("key_username", honeyPayGiveCardUI.mRa);
        intent.putExtra("key_wishing", honeyPayGiveCardUI.yla);
        intent.putExtra("key_cardtype", honeyPayGiveCardUI.qjx);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(honeyPayGiveCardUI, bl.axQ(), "com/tencent/mm/plugin/honey_pay/ui/HoneyPayGiveCardUI", "gotoPwdUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        honeyPayGiveCardUI.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(honeyPayGiveCardUI, "com/tencent/mm/plugin/honey_pay/ui/HoneyPayGiveCardUI", "gotoPwdUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(64766);
    }
}
