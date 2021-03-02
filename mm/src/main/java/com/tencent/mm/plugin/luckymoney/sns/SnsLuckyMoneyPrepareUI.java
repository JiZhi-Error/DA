package com.tencent.mm.plugin.luckymoney.sns;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.plugin.luckymoney.model.aq;
import com.tencent.mm.plugin.luckymoney.model.ba;
import com.tencent.mm.plugin.luckymoney.model.bf;
import com.tencent.mm.plugin.luckymoney.model.o;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyCanShareListUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyIndexUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMoneyInputView;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMyRecordUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNumInputView;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyTextInputView;
import com.tencent.mm.plugin.luckymoney.ui.c;
import com.tencent.mm.plugin.luckymoney.ui.h;
import com.tencent.mm.plugin.luckymoney.ui.i;
import com.tencent.mm.plugin.wallet_core.ui.l;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.wallet_core.ui.f;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.util.Map;

@a(19)
public class SnsLuckyMoneyPrepareUI extends LuckyMoneyBaseUI implements h {
    private static final String yQK = (HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e1p) + "/touch/product/wechathongbao_platform_app.html?scene_id=kf7");
    private MTimerHandler klF = null;
    private ScrollView lTw;
    private int mChannel;
    protected View mKBLayout;
    protected MyKeyboardWindow mKeyboard;
    private com.tencent.mm.wallet_core.ui.a mTenpayKBStateListener;
    private int mType;
    private TextView nAB;
    protected TextView qAC = null;
    protected Button rlN = null;
    protected Dialog tipDialog = null;
    private o yPZ;
    protected LuckyMoneyNumInputView yQL = null;
    protected LuckyMoneyTextInputView yQN = null;
    protected Button yQO = null;
    private TextView yQS;
    private c yQU = new c();
    private int yUr;
    protected LuckyMoneyMoneyInputView yYI = null;
    private View yYJ;
    private View yYK;
    private ViewGroup yYL;
    private String yYM;
    private int yYN;
    private boolean yYO;
    private String yYP;

    @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SnsLuckyMoneyPrepareUI() {
        AppMethodBeat.i(65387);
        AppMethodBeat.o(65387);
    }

    static /* synthetic */ int d(SnsLuckyMoneyPrepareUI snsLuckyMoneyPrepareUI) {
        AppMethodBeat.i(65399);
        int efB = snsLuckyMoneyPrepareUI.efB();
        AppMethodBeat.o(65399);
        return efB;
    }

    static /* synthetic */ View g(SnsLuckyMoneyPrepareUI snsLuckyMoneyPrepareUI) {
        AppMethodBeat.i(65400);
        View contentView = snsLuckyMoneyPrepareUI.getContentView();
        AppMethodBeat.o(65400);
        return contentView;
    }

    static /* synthetic */ View h(SnsLuckyMoneyPrepareUI snsLuckyMoneyPrepareUI) {
        AppMethodBeat.i(65401);
        View contentView = snsLuckyMoneyPrepareUI.getContentView();
        AppMethodBeat.o(65401);
        return contentView;
    }

    static /* synthetic */ void n(SnsLuckyMoneyPrepareUI snsLuckyMoneyPrepareUI) {
        AppMethodBeat.i(65403);
        snsLuckyMoneyPrepareUI.efZ();
        AppMethodBeat.o(65403);
    }

    static /* synthetic */ void o(SnsLuckyMoneyPrepareUI snsLuckyMoneyPrepareUI) {
        AppMethodBeat.i(65404);
        snsLuckyMoneyPrepareUI.efZ();
        AppMethodBeat.o(65404);
    }

    static {
        AppMethodBeat.i(213335);
        AppMethodBeat.o(213335);
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(65388);
        super.onCreate(bundle);
        this.mType = getIntent().getIntExtra("key_type", 1);
        this.yUr = getIntent().getIntExtra("key_way", 3);
        this.yYO = getIntent().getIntExtra("key_from", 0) == 1;
        this.mChannel = getIntent().getIntExtra("pay_channel", -1);
        doSceneProgress(new aq("v1.0", 0), false);
        com.tencent.mm.plugin.luckymoney.b.a.eex();
        this.yPZ = com.tencent.mm.plugin.luckymoney.b.a.eey().efe();
        Log.d("MicroMsg.LuckyMoneyPrepareUI", "type=" + this.mType + ", fromAppPanel=" + this.yYO + ", config " + this.yPZ);
        initView();
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11701, 4, 0, 0, Integer.valueOf(efB()), 1);
        AppMethodBeat.o(65388);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(65389);
        getResources().getDrawable(R.drawable.cbq);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(65363);
                SnsLuckyMoneyPrepareUI.this.finish();
                AppMethodBeat.o(65363);
                return true;
            }
        });
        this.yYJ = findViewById(R.id.f3l);
        this.yYK = findViewById(R.id.f3o);
        this.rlN = (Button) findViewById(R.id.f3n);
        this.yQN = (LuckyMoneyTextInputView) findViewById(R.id.f58);
        this.yQN.setHintText(getString(R.string.eof));
        this.yQO = (Button) findViewById(R.id.f3c);
        this.mKeyboard = (MyKeyboardWindow) findViewById(R.id.ijb);
        this.mKBLayout = findViewById(R.id.ija);
        this.nAB = (TextView) findViewById(R.id.f3a);
        this.yQL = (LuckyMoneyNumInputView) findViewById(R.id.f38);
        this.yYI = (LuckyMoneyMoneyInputView) findViewById(R.id.exy);
        this.qAC = (TextView) findViewById(R.id.f3p);
        this.yYL = (ViewGroup) findViewById(R.id.f3j);
        this.lTw = (ScrollView) findViewById(R.id.f4s);
        this.yQS = (TextView) findViewById(R.id.f3h);
        if (this.mType == 1) {
            this.yYI.setTitle(getString(R.string.esk));
            this.yYI.setShowGroupIcon(true);
        } else {
            this.yYI.setTitle(getString(R.string.esl));
            this.yYI.setShowGroupIcon(false);
        }
        this.yYI.setOnInputValidChangerListener(this);
        this.yQL.setOnInputValidChangerListener(this);
        this.yQN.setOnInputValidChangerListener(this);
        final EditText editText = (EditText) this.yYI.findViewById(R.id.f0o);
        final EditText editText2 = (EditText) this.yQL.findViewById(R.id.f0o);
        f.setNoSystemInputOnEditText(editText);
        ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(editText, 0);
        editText.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI.AnonymousClass19 */

            public final void onClick(View view) {
                AppMethodBeat.i(65384);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                editText.setOnClickListener(null);
                editText2.setOnClickListener(null);
                SnsLuckyMoneyPrepareUI.this.ak(SnsLuckyMoneyPrepareUI.this.yYI, 2);
                SnsLuckyMoneyPrepareUI.this.ak(SnsLuckyMoneyPrepareUI.this.yQL, 0);
                SnsLuckyMoneyPrepareUI.this.mKeyboard.setXMode(2);
                SnsLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText) view);
                SnsLuckyMoneyPrepareUI.k(SnsLuckyMoneyPrepareUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(65384);
            }
        });
        TextView textView = (TextView) this.yYI.findViewById(R.id.exz);
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI.AnonymousClass20 */

                public final void onClick(View view) {
                    AppMethodBeat.i(65385);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    editText.setOnClickListener(null);
                    editText2.setOnClickListener(null);
                    SnsLuckyMoneyPrepareUI.this.ak(SnsLuckyMoneyPrepareUI.this.yYI, 2);
                    SnsLuckyMoneyPrepareUI.this.ak(SnsLuckyMoneyPrepareUI.this.yQL, 0);
                    SnsLuckyMoneyPrepareUI.this.mKeyboard.setXMode(2);
                    SnsLuckyMoneyPrepareUI.k(SnsLuckyMoneyPrepareUI.this);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(65385);
                }
            });
        }
        f.setNoSystemInputOnEditText(editText2);
        ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(editText2, 0);
        editText2.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI.AnonymousClass21 */

            public final void onClick(View view) {
                AppMethodBeat.i(65386);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                editText.setOnClickListener(null);
                editText2.setOnClickListener(null);
                SnsLuckyMoneyPrepareUI.this.ak(SnsLuckyMoneyPrepareUI.this.yYI, 2);
                SnsLuckyMoneyPrepareUI.this.ak(SnsLuckyMoneyPrepareUI.this.yQL, 0);
                SnsLuckyMoneyPrepareUI.this.mKeyboard.setXMode(0);
                SnsLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText) view);
                SnsLuckyMoneyPrepareUI.k(SnsLuckyMoneyPrepareUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(65386);
            }
        });
        if (this.yPZ != null) {
            if (this.mType == 1) {
                this.yYI.setMaxAmount(this.yPZ.yPy);
            } else {
                this.yYI.setMaxAmount(this.yPZ.yPw);
            }
            this.yYI.setMinAmount(this.yPZ.yPx);
        }
        if (!this.yYO || getIntent().getIntExtra("key_chatroom_num", 0) > 1) {
            this.yQL.setNum("");
        } else {
            this.yQL.setNum("1");
        }
        this.yQL.setMaxNum(this.yPZ.yPv);
        this.yQL.setMinNum(1);
        Log.d("MicroMsg.LuckyMoneyPrepareUI", "init num=" + this.yQL.getInput());
        this.yYI.setMaxLen(12);
        if (this.yYO) {
            if (getIntent().getIntExtra("key_chatroom_num", 0) > 0) {
                String string = getString(R.string.epw);
                String string2 = getString(R.string.ept);
                String string3 = getString(R.string.epv);
                String string4 = getString(R.string.epu);
                final SpannableString spannableString = new SpannableString(string + string2);
                l lVar = new l(this);
                spannableString.setSpan(lVar, string.length(), string.length() + string2.length(), 33);
                final SpannableString spannableString2 = new SpannableString(string3 + string4);
                l lVar2 = new l(this);
                spannableString2.setSpan(lVar2, string3.length(), string3.length() + string4.length(), 33);
                lVar.IgH = new l.a() {
                    /* class com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI.AnonymousClass11 */

                    @Override // com.tencent.mm.plugin.wallet_core.ui.l.a
                    public final void onClick(View view) {
                        AppMethodBeat.i(65375);
                        int input = SnsLuckyMoneyPrepareUI.this.yQL.getInput();
                        double input2 = SnsLuckyMoneyPrepareUI.this.yYI.getInput();
                        SnsLuckyMoneyPrepareUI.this.mType = 0;
                        SnsLuckyMoneyPrepareUI.this.yYI.setType(SnsLuckyMoneyPrepareUI.this.mType);
                        SnsLuckyMoneyPrepareUI.this.yYI.setShowGroupIcon(false);
                        SnsLuckyMoneyPrepareUI.this.yYI.setTitle(SnsLuckyMoneyPrepareUI.this.getString(R.string.esl));
                        if (input2 > 0.0d && input > 0) {
                            SnsLuckyMoneyPrepareUI.this.yYI.setAmount(f.formatMoney2f(input2 / ((double) input)));
                        }
                        SnsLuckyMoneyPrepareUI.this.yYI.setMaxAmount(SnsLuckyMoneyPrepareUI.this.yPZ.yPw);
                        SnsLuckyMoneyPrepareUI.this.nAB.setText(spannableString2);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11701, 4, 0, 0, Integer.valueOf(SnsLuckyMoneyPrepareUI.d(SnsLuckyMoneyPrepareUI.this)), 3);
                        AppMethodBeat.o(65375);
                    }
                };
                lVar2.IgH = new l.a() {
                    /* class com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI.AnonymousClass15 */

                    @Override // com.tencent.mm.plugin.wallet_core.ui.l.a
                    public final void onClick(View view) {
                        AppMethodBeat.i(65379);
                        int input = SnsLuckyMoneyPrepareUI.this.yQL.getInput();
                        double input2 = SnsLuckyMoneyPrepareUI.this.yYI.getInput();
                        SnsLuckyMoneyPrepareUI.this.mType = 1;
                        SnsLuckyMoneyPrepareUI.this.yYI.setType(SnsLuckyMoneyPrepareUI.this.mType);
                        SnsLuckyMoneyPrepareUI.this.yYI.setTitle(SnsLuckyMoneyPrepareUI.this.getString(R.string.esk));
                        SnsLuckyMoneyPrepareUI.this.yYI.setShowGroupIcon(true);
                        if (input2 > 0.0d && input > 0) {
                            SnsLuckyMoneyPrepareUI.this.yYI.setAmount(f.formatMoney2f(input2 * ((double) input)));
                        }
                        SnsLuckyMoneyPrepareUI.this.yYI.setMaxAmount(SnsLuckyMoneyPrepareUI.this.yPZ.yPy);
                        SnsLuckyMoneyPrepareUI.this.nAB.setText(spannableString);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11701, 4, 0, 0, Integer.valueOf(SnsLuckyMoneyPrepareUI.d(SnsLuckyMoneyPrepareUI.this)), 2);
                        AppMethodBeat.o(65379);
                    }
                };
                this.nAB.setMovementMethod(LinkMovementMethod.getInstance());
                this.nAB.setText(spannableString);
                this.nAB.setVisibility(0);
            } else {
                this.yQL.setVisibility(8);
            }
        } else if (this.mType == 1) {
            this.nAB.setText(this.yPZ.yUR);
            this.nAB.setVisibility(0);
        } else if (this.mType == 0) {
            this.nAB.setText(this.yPZ.yUS);
            this.nAB.setVisibility(0);
        }
        this.yQO.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI.AnonymousClass16 */

            public final void onClick(View view) {
                long E;
                ba baVar;
                AppMethodBeat.i(65381);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(11701, 4, 0, 0, Integer.valueOf(SnsLuckyMoneyPrepareUI.d(SnsLuckyMoneyPrepareUI.this)), 4);
                if (SnsLuckyMoneyPrepareUI.this.yYI.eeH() != 0) {
                    u.makeText(SnsLuckyMoneyPrepareUI.this.getContext(), (int) R.string.i7f, 0).show();
                } else {
                    int input = SnsLuckyMoneyPrepareUI.this.yQL.getInput();
                    double input2 = SnsLuckyMoneyPrepareUI.this.yYI.getInput();
                    long j2 = 0;
                    if (SnsLuckyMoneyPrepareUI.this.mType == 1) {
                        E = f.E(input2);
                        g.aAi();
                        g.aAh().azQ().set(356354, Integer.valueOf(input));
                    } else {
                        E = f.E(((double) input) * input2);
                        j2 = f.E(input2);
                        g.aAi();
                        g.aAh().azQ().set(356353, Integer.valueOf(input));
                    }
                    String input3 = SnsLuckyMoneyPrepareUI.this.yQN.getInput();
                    if (Util.isNullOrNil(input3)) {
                        input3 = SnsLuckyMoneyPrepareUI.this.getString(R.string.eof);
                    }
                    String stringExtra = SnsLuckyMoneyPrepareUI.this.getIntent().getStringExtra("key_username");
                    if (!SnsLuckyMoneyPrepareUI.this.yYO || Util.isNullOrNil(stringExtra)) {
                        baVar = new ba(input, E, j2, SnsLuckyMoneyPrepareUI.this.mType, input3, af.efj(), null, null, z.aTY(), z.aUa(), SnsLuckyMoneyPrepareUI.this.yUr, "");
                    } else {
                        baVar = new ba(input, E, j2, SnsLuckyMoneyPrepareUI.this.mType, input3, af.efj(), stringExtra, af.Ir(stringExtra), z.aTY(), z.aUa(), SnsLuckyMoneyPrepareUI.this.yUr, "");
                    }
                    SnsLuckyMoneyPrepareUI.this.doSceneProgress(baVar, false);
                    if (SnsLuckyMoneyPrepareUI.this.tipDialog != null) {
                        SnsLuckyMoneyPrepareUI.this.tipDialog.show();
                    } else {
                        SnsLuckyMoneyPrepareUI.this.tipDialog = com.tencent.mm.wallet_core.ui.h.a((Context) SnsLuckyMoneyPrepareUI.this.getContext(), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                            /* class com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI.AnonymousClass16.AnonymousClass1 */

                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.i(65380);
                                if (SnsLuckyMoneyPrepareUI.this.tipDialog != null && SnsLuckyMoneyPrepareUI.this.tipDialog.isShowing()) {
                                    SnsLuckyMoneyPrepareUI.this.tipDialog.hide();
                                }
                                if (SnsLuckyMoneyPrepareUI.g(SnsLuckyMoneyPrepareUI.this).getVisibility() == 8 || SnsLuckyMoneyPrepareUI.h(SnsLuckyMoneyPrepareUI.this).getVisibility() == 4) {
                                    Log.i("MicroMsg.LuckyMoneyPrepareUI", "usr cancel, & visibility not visiable, so finish");
                                    SnsLuckyMoneyPrepareUI.this.finish();
                                }
                                SnsLuckyMoneyPrepareUI.this.zbX.forceCancel();
                                AppMethodBeat.o(65380);
                            }
                        });
                    }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(65381);
            }
        });
        this.qAC.setText(f.D(0.0d));
        this.yQU.a(this.yQL);
        this.yQU.a(this.yYI);
        this.yQU.a(this.yQN);
        this.yQU.t((TextView) findViewById(R.id.f3e));
        if (this.yYO && this.mType == 1) {
            TextView textView2 = (TextView) findViewById(R.id.f3i);
            textView2.setText(getString(R.string.eqp, new Object[]{Integer.valueOf(getIntent().getIntExtra("key_chatroom_num", 8))}));
            textView2.setVisibility(0);
        }
        this.klF = new MTimerHandler(new MTimerHandler.CallBack() {
            /* class com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI.AnonymousClass17 */

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                double d2;
                AppMethodBeat.i(65382);
                if (SnsLuckyMoneyPrepareUI.this.yYI.eeH() == 3 || SnsLuckyMoneyPrepareUI.this.yQL.eeH() == 3) {
                    d2 = 0.0d;
                } else {
                    int input = SnsLuckyMoneyPrepareUI.this.yQL.getInput();
                    d2 = SnsLuckyMoneyPrepareUI.this.yYI.getInput();
                    if (SnsLuckyMoneyPrepareUI.this.mType == 0) {
                        d2 *= (double) input;
                    }
                }
                if (d2 == 0.0d || d2 > SnsLuckyMoneyPrepareUI.this.yPZ.yPy || SnsLuckyMoneyPrepareUI.this.yQU.egk()) {
                    SnsLuckyMoneyPrepareUI.this.yQO.setClickable(false);
                    SnsLuckyMoneyPrepareUI.this.yQO.setEnabled(false);
                } else {
                    SnsLuckyMoneyPrepareUI.this.yQO.setClickable(true);
                    SnsLuckyMoneyPrepareUI.this.yQO.setEnabled(true);
                }
                Log.i("MicroMsg.LuckyMoneyPrepareUI", "onTimeExpired & check: amount=" + d2 + ", hasErr=" + SnsLuckyMoneyPrepareUI.this.yQU.egk());
                SnsLuckyMoneyPrepareUI.this.klF.stopped();
                AppMethodBeat.o(65382);
                return false;
            }
        }, false);
        if (this.lTw != null) {
            this.lTw.setOnTouchListener(new View.OnTouchListener() {
                /* class com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI.AnonymousClass18 */

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(65383);
                    if (motionEvent.getAction() == 0) {
                        SnsLuckyMoneyPrepareUI.this.hideTenpayKB();
                        SnsLuckyMoneyPrepareUI.this.hideVKB();
                    }
                    AppMethodBeat.o(65383);
                    return false;
                }
            });
        }
        this.yYI.setType(this.mType);
        if (!this.yYO || getIntent().getIntExtra("key_chatroom_num", 0) != 0) {
            this.yQL.requestFocus();
            AppMethodBeat.o(65389);
            return;
        }
        this.yYI.requestFocus();
        AppMethodBeat.o(65389);
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(65390);
        super.onDestroy();
        this.yQU.clear();
        this.klF.stopped();
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
        AppMethodBeat.o(65390);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.b4_;
    }

    @Override // android.support.v4.app.SupportActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.i(65391);
        if (keyEvent.getKeyCode() == 4 && this.yYJ.getVisibility() == 0) {
            this.yYJ.setVisibility(8);
            efZ();
            AppMethodBeat.o(65391);
            return true;
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.o(65391);
        return dispatchKeyEvent;
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI
    public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(65392);
        if (qVar instanceof ba) {
            if (this.tipDialog != null && this.tipDialog.isShowing()) {
                this.tipDialog.hide();
            }
            if (i2 == 0 && i3 == 0) {
                ba baVar = (ba) qVar;
                this.yYN = baVar.qwe;
                this.yYM = baVar.yQE;
                this.yYP = baVar.yXH;
                PayInfo payInfo = new PayInfo();
                payInfo.dDL = baVar.wFL;
                payInfo.dVv = 37;
                payInfo.channel = this.mChannel;
                com.tencent.mm.pluginsdk.wallet.f.a(this, payInfo, 1);
                AppMethodBeat.o(65392);
                return true;
            } else if (i3 == 401) {
                this.yQO.setEnabled(false);
                this.yQO.setClickable(false);
                this.klF.startTimer(5000);
                com.tencent.mm.ui.base.h.cD(this, str);
                AppMethodBeat.o(65392);
                return true;
            } else {
                com.tencent.mm.ui.base.h.cD(this, str);
                AppMethodBeat.o(65392);
                return true;
            }
        } else {
            if (qVar instanceof bf) {
                if (i2 == 0 && i3 == 0) {
                    if (this.yYO) {
                        com.tencent.mm.ui.base.h.cD(this, getString(R.string.dzo));
                        finish();
                    } else {
                        ega();
                        this.yYK.postDelayed(new Runnable() {
                            /* class com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI.AnonymousClass2 */

                            public final void run() {
                                AppMethodBeat.i(65364);
                                Intent intent = new Intent();
                                intent.setClass(SnsLuckyMoneyPrepareUI.this.getContext(), LuckyMoneyIndexUI.class);
                                intent.addFlags(67108864);
                                AppCompatActivity context = SnsLuckyMoneyPrepareUI.this.getContext();
                                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$11", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                context.startActivity((Intent) bl.pG(0));
                                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$11", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                SnsLuckyMoneyPrepareUI.this.finish();
                                AppMethodBeat.o(65364);
                            }
                        }, 1000);
                    }
                    AppMethodBeat.o(65392);
                    return true;
                } else if (i3 == 402) {
                    com.tencent.mm.ui.base.h.c(getContext(), str, "", getString(R.string.es0), getString(R.string.sz), new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI.AnonymousClass3 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(65365);
                            Intent intent = new Intent();
                            intent.setClass(SnsLuckyMoneyPrepareUI.this.getContext(), LuckyMoneyMyRecordUI.class);
                            intent.putExtra("key_type", 1);
                            SnsLuckyMoneyPrepareUI snsLuckyMoneyPrepareUI = SnsLuckyMoneyPrepareUI.this;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                            com.tencent.mm.hellhoundlib.a.a.a(snsLuckyMoneyPrepareUI, bl.axQ(), "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$12", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            snsLuckyMoneyPrepareUI.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(snsLuckyMoneyPrepareUI, "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$12", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            AppMethodBeat.o(65365);
                        }
                    }, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI.AnonymousClass4 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                        }
                    });
                    AppMethodBeat.o(65392);
                    return true;
                }
            } else if (qVar instanceof aq) {
                if (i2 == 0 && i3 == 0) {
                    final aq aqVar = (aq) qVar;
                    com.tencent.mm.plugin.luckymoney.b.a.eex();
                    this.yPZ = com.tencent.mm.plugin.luckymoney.b.a.eey().efe();
                    Log.d("MicroMsg.LuckyMoneyPrepareUI", "update config:" + this.yPZ);
                    if (this.mType == 1) {
                        this.yYI.setMaxAmount(this.yPZ.yPy);
                    } else {
                        this.yYI.setMaxAmount(this.yPZ.yPw);
                    }
                    this.yYI.setMinAmount(this.yPZ.yPx);
                    this.yQL.setMaxNum(this.yPZ.yPv);
                    if (aqVar.yXl && this.yYO) {
                        TextView textView = (TextView) findViewById(R.id.f3f);
                        textView.setOnClickListener(new View.OnClickListener() {
                            /* class com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI.AnonymousClass5 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(65366);
                                b bVar = new b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                com.tencent.mm.plugin.report.service.h.INSTANCE.a(11701, 4, 0, 0, Integer.valueOf(SnsLuckyMoneyPrepareUI.d(SnsLuckyMoneyPrepareUI.this)), 9);
                                Intent intent = new Intent();
                                intent.setClass(SnsLuckyMoneyPrepareUI.this.getContext(), LuckyMoneyCanShareListUI.class);
                                SnsLuckyMoneyPrepareUI snsLuckyMoneyPrepareUI = SnsLuckyMoneyPrepareUI.this;
                                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                com.tencent.mm.hellhoundlib.a.a.a(snsLuckyMoneyPrepareUI, bl.axQ(), "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$14", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                snsLuckyMoneyPrepareUI.startActivity((Intent) bl.pG(0));
                                com.tencent.mm.hellhoundlib.a.a.a(snsLuckyMoneyPrepareUI, "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$14", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(65366);
                            }
                        });
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11701, 4, 0, 0, Integer.valueOf(efB()), 8);
                        textView.setVisibility(0);
                    }
                    if (!Util.isNullOrNil(aqVar.jTx)) {
                        Log.i("MicroMsg.LuckyMoneyPrepareUI", "Put notice :" + aqVar.jTx);
                        this.yQS.setText(aqVar.jTx);
                        if (!Util.isNullOrNil(aqVar.yXn)) {
                            this.yQS.setOnClickListener(new View.OnClickListener() {
                                /* class com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI.AnonymousClass6 */

                                public final void onClick(View view) {
                                    AppMethodBeat.i(65367);
                                    b bVar = new b();
                                    bVar.bm(view);
                                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                    f.p(SnsLuckyMoneyPrepareUI.this.getContext(), aqVar.yXn, false);
                                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                    AppMethodBeat.o(65367);
                                }
                            });
                        }
                        this.yQS.setVisibility(0);
                    } else {
                        this.yQS.setVisibility(8);
                    }
                    i.c cVar = new i.c();
                    cVar.textColor = getResources().getColor(R.color.ae6);
                    i.a(this, this.yYL, aqVar.yXp, cVar);
                }
                AppMethodBeat.o(65392);
                return true;
            }
            AppMethodBeat.o(65392);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(65393);
        switch (i2) {
            case 1:
                if (i3 == -1) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(11701, 4, 0, 0, Integer.valueOf(efB()), 5);
                    String stringExtra = getIntent().getStringExtra("key_username");
                    if (this.yYO && !Util.isNullOrNil(stringExtra)) {
                        com.tencent.mm.ui.base.h.cD(this, getString(R.string.dzo));
                        Map<String, String> parseXml = XmlParser.parseXml(this.yYP, "msg", null);
                        if (parseXml != null) {
                            String str = parseXml.get(".msg.appmsg.wcpayinfo.paymsgid");
                            if (com.tencent.mm.plugin.luckymoney.b.a.eex().eeB().aDu(str)) {
                                Log.i("MicroMsg.LuckyMoneyPrepareUI", "insert a local msg for luckymoney");
                                if (!af.ac(this.yYP, stringExtra, 1)) {
                                    Log.e("MicroMsg.LuckyMoneyPrepareUI", "LuckyMoneyUtil.sendLocalMsg fail!");
                                    com.tencent.mm.plugin.luckymoney.b.a.eex().eeB().aDv(str);
                                }
                            } else {
                                Log.e("MicroMsg.LuckyMoneyPrepareUI", "it is a duplicate msg");
                            }
                            finish();
                            break;
                        } else {
                            Log.e("MicroMsg.LuckyMoneyPrepareUI", "luckymoneyPrepareUI onActivityResult values is null");
                            finish();
                            AppMethodBeat.o(65393);
                            return;
                        }
                    } else {
                        ega();
                        new MMHandler().postDelayed(new Runnable() {
                            /* class com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI.AnonymousClass7 */

                            public final void run() {
                                AppMethodBeat.i(65368);
                                SnsLuckyMoneyPrepareUI.this.yYJ.setVisibility(0);
                                ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                                scaleAnimation.setDuration(800);
                                scaleAnimation.setStartOffset(200);
                                scaleAnimation.setInterpolator(new BounceInterpolator());
                                SnsLuckyMoneyPrepareUI.this.findViewById(R.id.f3m).startAnimation(scaleAnimation);
                                AppMethodBeat.o(65368);
                            }
                        }, 200);
                        this.rlN.setOnClickListener(new View.OnClickListener() {
                            /* class com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI.AnonymousClass8 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(65370);
                                b bVar = new b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                com.tencent.mm.plugin.report.service.h.INSTANCE.a(11701, 4, 0, 0, Integer.valueOf(SnsLuckyMoneyPrepareUI.d(SnsLuckyMoneyPrepareUI.this)), 6);
                                af.a((MMActivity) SnsLuckyMoneyPrepareUI.this, SnsLuckyMoneyPrepareUI.this.mType, SnsLuckyMoneyPrepareUI.this.yYN, false);
                                SnsLuckyMoneyPrepareUI.this.yYJ.postDelayed(new Runnable() {
                                    /* class com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI.AnonymousClass8.AnonymousClass1 */

                                    public final void run() {
                                        AppMethodBeat.i(65369);
                                        SnsLuckyMoneyPrepareUI.this.yYJ.setVisibility(8);
                                        SnsLuckyMoneyPrepareUI.n(SnsLuckyMoneyPrepareUI.this);
                                        AppMethodBeat.o(65369);
                                    }
                                }, 100);
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(65370);
                            }
                        });
                        ((ImageView) findViewById(R.id.f3d)).setOnClickListener(new View.OnClickListener() {
                            /* class com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI.AnonymousClass9 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(65371);
                                b bVar = new b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                SnsLuckyMoneyPrepareUI.this.yYJ.setVisibility(8);
                                SnsLuckyMoneyPrepareUI.o(SnsLuckyMoneyPrepareUI.this);
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(65371);
                            }
                        });
                        break;
                    }
                }
                break;
            case 2:
                if (i3 != -1 || intent == null) {
                    if (i3 == 0) {
                        Intent intent2 = new Intent();
                        intent2.setClass(getContext(), LuckyMoneyMyRecordUI.class);
                        intent2.putExtra("key_type", 1);
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                        com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        break;
                    }
                } else {
                    String stringExtra2 = intent.getStringExtra("Select_Conv_User");
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(11701, 4, 0, 0, Integer.valueOf(efB()), 7, stringExtra2);
                    if (Util.isNullOrNil(stringExtra2)) {
                        finish();
                        break;
                    } else {
                        doSceneProgress(new bf(stringExtra2.replaceAll(",", "|"), this.yYM, "v1.0"));
                        break;
                    }
                }
                break;
        }
        super.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(65393);
    }

    /* access modifiers changed from: protected */
    public final void ak(View view, final int i2) {
        AppMethodBeat.i(65394);
        this.mKeyboard = (MyKeyboardWindow) findViewById(R.id.ijb);
        this.mKBLayout = findViewById(R.id.ija);
        View findViewById = findViewById(R.id.ijc);
        final EditText editText = (EditText) view.findViewById(R.id.f0o);
        if (this.mKeyboard == null || editText == null || this.mKBLayout == null) {
            AppMethodBeat.o(65394);
            return;
        }
        f.setNoSystemInputOnEditText(editText);
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            /* class com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI.AnonymousClass10 */
            final /* synthetic */ boolean val$isShowSysKB = false;

            public final void onFocusChange(final View view, boolean z) {
                AppMethodBeat.i(65374);
                if (!view.isFocused() || this.val$isShowSysKB) {
                    new MMHandler().postDelayed(new Runnable() {
                        /* class com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI.AnonymousClass10.AnonymousClass2 */

                        public final void run() {
                            AppMethodBeat.i(65373);
                            SnsLuckyMoneyPrepareUI.this.hideTenpayKB();
                            ((InputMethodManager) SnsLuckyMoneyPrepareUI.this.getContext().getSystemService("input_method")).showSoftInput(editText, 0);
                            AppMethodBeat.o(65373);
                        }
                    }, 200);
                    AppMethodBeat.o(65374);
                    return;
                }
                ((InputMethodManager) SnsLuckyMoneyPrepareUI.this.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                new MMHandler().postDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI.AnonymousClass10.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(65372);
                        if (!SnsLuckyMoneyPrepareUI.this.mKBLayout.isShown() && view.isShown()) {
                            SnsLuckyMoneyPrepareUI.k(SnsLuckyMoneyPrepareUI.this);
                        }
                        SnsLuckyMoneyPrepareUI.b(SnsLuckyMoneyPrepareUI.this, i2);
                        SnsLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText) view);
                        ((InputMethodManager) SnsLuckyMoneyPrepareUI.this.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                        AppMethodBeat.o(65372);
                    }
                }, 300);
                AppMethodBeat.o(65374);
            }
        });
        editText.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI.AnonymousClass12 */
            final /* synthetic */ boolean val$isShowSysKB = false;

            public final void onClick(View view) {
                AppMethodBeat.i(65376);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (!SnsLuckyMoneyPrepareUI.this.mKBLayout.isShown() && !this.val$isShowSysKB) {
                    SnsLuckyMoneyPrepareUI.k(SnsLuckyMoneyPrepareUI.this);
                    SnsLuckyMoneyPrepareUI.b(SnsLuckyMoneyPrepareUI.this, i2);
                } else if (this.val$isShowSysKB) {
                    SnsLuckyMoneyPrepareUI.this.hideTenpayKB();
                    ((InputMethodManager) SnsLuckyMoneyPrepareUI.this.getContext().getSystemService("input_method")).showSoftInput(editText, 0);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(65376);
            }
        });
        TextView textView = (TextView) view.findViewById(R.id.exz);
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI.AnonymousClass13 */
                final /* synthetic */ boolean val$isShowSysKB = false;

                public final void onClick(View view) {
                    AppMethodBeat.i(65377);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (!SnsLuckyMoneyPrepareUI.this.mKBLayout.isShown() && !this.val$isShowSysKB) {
                        SnsLuckyMoneyPrepareUI.k(SnsLuckyMoneyPrepareUI.this);
                        SnsLuckyMoneyPrepareUI.b(SnsLuckyMoneyPrepareUI.this, i2);
                    } else if (this.val$isShowSysKB) {
                        SnsLuckyMoneyPrepareUI.this.hideTenpayKB();
                        ((InputMethodManager) SnsLuckyMoneyPrepareUI.this.getContext().getSystemService("input_method")).showSoftInput(editText, 0);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(65377);
                }
            });
        }
        findViewById.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI.AnonymousClass14 */

            public final void onClick(View view) {
                AppMethodBeat.i(65378);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                SnsLuckyMoneyPrepareUI.this.hideTenpayKB();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/sns/SnsLuckyMoneyPrepareUI$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(65378);
            }
        });
        AppMethodBeat.o(65394);
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(65395);
        if (i2 != 4 || this.mKBLayout == null || !this.mKBLayout.isShown()) {
            boolean onKeyUp = super.onKeyUp(i2, keyEvent);
            AppMethodBeat.o(65395);
            return onKeyUp;
        }
        hideTenpayKB();
        AppMethodBeat.o(65395);
        return true;
    }

    /* access modifiers changed from: protected */
    public final void hideTenpayKB() {
        AppMethodBeat.i(65396);
        if (this.mKBLayout != null && this.mKBLayout.isShown()) {
            this.mKBLayout.setVisibility(8);
            this.mTenpayKBStateListener.onVisibleStateChange(false);
        }
        AppMethodBeat.o(65396);
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.h
    public final void eeI() {
        double d2;
        double d3;
        boolean z;
        boolean z2;
        AppMethodBeat.i(65397);
        com.tencent.mm.plugin.luckymoney.b.a.eex();
        this.yPZ = com.tencent.mm.plugin.luckymoney.b.a.eey().efe();
        if (this.yYI.eeH() == 3 || this.yQL.eeH() == 3) {
            d2 = 0.0d;
            d3 = 0.0d;
        } else {
            int input = this.yQL.getInput();
            d3 = this.yYI.getInput();
            if (this.mType == 0) {
                d3 *= (double) input;
                d2 = this.yYI.getInput();
            } else {
                d2 = input > 0 ? this.yYI.getInput() / ((double) input) : 0.0d;
            }
        }
        if (this.yQU.egj()) {
            this.yQO.setClickable(false);
            this.yQO.setEnabled(false);
        } else {
            if (d3 == 0.0d || d2 == 0.0d) {
                z = true;
            } else if (d3 > this.yPZ.yPy && this.yPZ.yPy > 0.0d) {
                this.yQU.aeu(getString(R.string.esj, new Object[]{new StringBuilder().append(Math.round(this.yPZ.yPy)).toString(), Util.nullAs(this.yPZ.yPB, "")}));
                z = true;
            } else if (d2 > 0.0d) {
                if (this.mType == 0) {
                    if (d2 > this.yPZ.yPw && this.yPZ.yPw > 0.0d) {
                        this.yQU.aeu(getString(R.string.er1, new Object[]{new StringBuilder().append(Math.round(this.yPZ.yPw)).toString(), Util.nullAs(this.yPZ.yPB, "")}));
                        z2 = true;
                    }
                    z2 = false;
                } else {
                    if (d2 > this.yPZ.yPz && this.yPZ.yPz > 0.0d) {
                        this.yQU.aeu(getString(R.string.er1, new Object[]{new StringBuilder().append(Math.round(this.yPZ.yPz)).toString(), Util.nullAs(this.yPZ.yPB, "")}));
                        this.yQL.onError();
                        this.yYI.onError();
                        z2 = true;
                    }
                    z2 = false;
                }
                if (!z2) {
                    if (this.mType == 0) {
                        if (d2 < this.yPZ.yPx) {
                            this.yQU.aeu(getString(R.string.er3, new Object[]{f.formatMoney2f(this.yPZ.yPx), Util.nullAs(this.yPZ.yPB, "")}));
                            z = true;
                        }
                    } else if (d2 < 0.01d) {
                        this.yQU.aeu(getString(R.string.er3, new Object[]{"0.01", Util.nullAs(this.yPZ.yPB, "")}));
                        this.yQL.onError();
                        this.yYI.onError();
                        z = true;
                    }
                }
                z = z2;
            } else {
                z = false;
            }
            if (z) {
                this.yQO.setClickable(false);
                this.yQO.setEnabled(false);
            } else {
                this.yQO.setClickable(true);
                this.yQO.setEnabled(true);
            }
        }
        this.qAC.setText(f.D(d3));
        AppMethodBeat.o(65397);
    }

    private int efB() {
        AppMethodBeat.i(65398);
        if (!this.yYO) {
            AppMethodBeat.o(65398);
            return 3;
        } else if (getIntent().getIntExtra("key_chatroom_num", 0) > 0) {
            AppMethodBeat.o(65398);
            return 2;
        } else {
            AppMethodBeat.o(65398);
            return 1;
        }
    }

    static /* synthetic */ void k(SnsLuckyMoneyPrepareUI snsLuckyMoneyPrepareUI) {
        AppMethodBeat.i(65402);
        if (snsLuckyMoneyPrepareUI.mKBLayout != null && !snsLuckyMoneyPrepareUI.mKBLayout.isShown()) {
            snsLuckyMoneyPrepareUI.mKBLayout.setVisibility(0);
            snsLuckyMoneyPrepareUI.mTenpayKBStateListener.onVisibleStateChange(true);
        }
        AppMethodBeat.o(65402);
    }

    static /* synthetic */ void b(SnsLuckyMoneyPrepareUI snsLuckyMoneyPrepareUI, int i2) {
        AppMethodBeat.i(65405);
        snsLuckyMoneyPrepareUI.mKeyboard.setXMode(i2);
        AppMethodBeat.o(65405);
    }
}
