package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.luckymoney.appbrand.a.g;
import com.tencent.mm.plugin.luckymoney.appbrand.a.h;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyBaseUI;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyMoneyInputView;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNumInputView;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyTextInputView;
import com.tencent.mm.plugin.luckymoney.ui.c;
import com.tencent.mm.plugin.luckymoney.ui.h;
import com.tencent.mm.plugin.wallet_core.ui.l;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.picker.c;
import com.tencent.mm.ui.x;
import com.tencent.mm.wallet_core.ui.MMScrollView;
import com.tencent.mm.wallet_core.ui.f;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.util.ArrayList;

@a(19)
public class WxaLuckyMoneyPrepareUI extends WxaLuckyMoneyBaseUI implements c, h {
    private static final String yQK = (HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e1p) + "/touch/scene_product.html?scene_id=kf7");
    protected View mKBLayout;
    protected MyKeyboardWindow mKeyboard;
    private TextView nAB;
    private TextView qAC = null;
    private a yQJ = null;
    private LuckyMoneyNumInputView yQL = null;
    private WxaLuckyMoneyMoneyInputView yQM = null;
    private LuckyMoneyTextInputView yQN = null;
    private Button yQO = null;
    private LinearLayout yQP;
    private TextView yQQ;
    private MMScrollView yQR;
    private TextView yQS;
    private int yQT = 0;
    private c yQU = new c();
    private h.a yQc = h.a.RANDOM_LUCK;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyBaseUI, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WxaLuckyMoneyPrepareUI() {
        AppMethodBeat.i(64965);
        AppMethodBeat.o(64965);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyBaseUI, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(64966);
        super.onCreate(bundle);
        initView();
        this.yQJ = new d();
        this.yQJ.d(this, getIntent());
        AppMethodBeat.o(64966);
    }

    @Override // com.tencent.mm.plugin.luckymoney.appbrand.ui.b
    public final MMActivity eeF() {
        return this;
    }

    @Override // com.tencent.mm.plugin.luckymoney.appbrand.ui.b
    public final void eeG() {
    }

    static {
        AppMethodBeat.i(213264);
        AppMethodBeat.o(213264);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(64968);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI.AnonymousClass10 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(64956);
                WxaLuckyMoneyPrepareUI.this.setResult(0, new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{user cancel}}"));
                WxaLuckyMoneyPrepareUI.this.finish();
                AppMethodBeat.o(64956);
                return true;
            }
        });
        this.yQN = (LuckyMoneyTextInputView) findViewById(R.id.f58);
        this.yQN.setHintText(getString(R.string.eof));
        final String stringExtra = getIntent().getStringExtra("defaultWishingWord");
        Log.i("MicroMsg.WxaLuckyMoneyPrepareUI", "initView defaultWishingWord = %s", stringExtra);
        if (!Util.isNullOrNil(stringExtra)) {
            this.yQN.setHintText(stringExtra);
        }
        this.yQO = (Button) findViewById(R.id.f3c);
        this.mKeyboard = (MyKeyboardWindow) findViewById(R.id.ijb);
        this.mKBLayout = findViewById(R.id.ija);
        this.nAB = (TextView) findViewById(R.id.f3a);
        this.yQL = (LuckyMoneyNumInputView) findViewById(R.id.f38);
        this.yQM = (WxaLuckyMoneyMoneyInputView) findViewById(R.id.exy);
        this.qAC = (TextView) findViewById(R.id.f3p);
        this.yQR = (MMScrollView) findViewById(R.id.f4s);
        this.yQS = (TextView) findViewById(R.id.f3h);
        this.yQP = (LinearLayout) findViewById(R.id.f3r);
        this.yQQ = (TextView) findViewById(R.id.f3s);
        setMMTitle(R.string.esg);
        if (this.yQc == h.a.RANDOM_LUCK) {
            this.yQM.setTitle(getString(R.string.esk));
            this.yQM.setShowGroupIcon(true);
        } else {
            this.yQM.setTitle(getString(R.string.esl));
            this.yQM.setShowGroupIcon(false);
        }
        this.yQM.setOnInputValidChangerListener(this);
        this.yQM.setHint(getString(R.string.eqa));
        this.yQL.setOnInputValidChangerListener(this);
        this.yQL.setHint(getString(R.string.eqq));
        this.yQL.setNum("");
        this.yQN.setOnInputValidChangerListener(this);
        final EditText editText = (EditText) this.yQM.findViewById(R.id.f0o);
        final EditText editText2 = (EditText) this.yQL.findViewById(R.id.f0o);
        f.setNoSystemInputOnEditText(editText);
        ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(editText, 0);
        editText.addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI.AnonymousClass17 */

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(64964);
                if (editable.toString().startsWith(".")) {
                    editable.insert(0, AppEventsConstants.EVENT_PARAM_VALUE_NO);
                }
                String obj = editable.toString();
                int indexOf = obj.indexOf(".");
                int length = obj.length();
                if (indexOf >= 0 && length - indexOf > 3) {
                    editable.delete(indexOf + 3, length);
                    AppMethodBeat.o(64964);
                } else if (indexOf > 6) {
                    editable.delete(6, indexOf);
                    AppMethodBeat.o(64964);
                } else {
                    if (indexOf == -1 && length > 6) {
                        editable.delete(6, length);
                    }
                    AppMethodBeat.o(64964);
                }
            }
        });
        editText.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(64945);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyPrepareUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                editText.setOnClickListener(null);
                editText2.setOnClickListener(null);
                WxaLuckyMoneyPrepareUI.this.ak(WxaLuckyMoneyPrepareUI.this.yQM, 2);
                WxaLuckyMoneyPrepareUI.this.ak(WxaLuckyMoneyPrepareUI.this.yQL, 0);
                WxaLuckyMoneyPrepareUI.this.mKeyboard.setXMode(2);
                WxaLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText) view);
                WxaLuckyMoneyPrepareUI.this.mKBLayout.setVisibility(0);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyPrepareUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(64945);
            }
        });
        editText.requestFocus();
        TextView textView = (TextView) this.yQM.findViewById(R.id.exz);
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI.AnonymousClass3 */

                public final void onClick(View view) {
                    AppMethodBeat.i(64946);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyPrepareUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    editText.setOnClickListener(null);
                    editText2.setOnClickListener(null);
                    WxaLuckyMoneyPrepareUI.this.ak(WxaLuckyMoneyPrepareUI.this.yQM, 2);
                    WxaLuckyMoneyPrepareUI.this.ak(WxaLuckyMoneyPrepareUI.this.yQL, 0);
                    WxaLuckyMoneyPrepareUI.this.mKeyboard.setXMode(2);
                    WxaLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText(editText);
                    WxaLuckyMoneyPrepareUI.this.mKBLayout.setVisibility(0);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyPrepareUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(64946);
                }
            });
        }
        f.setNoSystemInputOnEditText(editText2);
        ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(editText2, 0);
        editText2.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(64947);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyPrepareUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                editText.setOnClickListener(null);
                editText2.setOnClickListener(null);
                WxaLuckyMoneyPrepareUI.this.ak(WxaLuckyMoneyPrepareUI.this.yQM, 2);
                WxaLuckyMoneyPrepareUI.this.ak(WxaLuckyMoneyPrepareUI.this.yQL, 0);
                WxaLuckyMoneyPrepareUI.this.mKeyboard.setXMode(0);
                WxaLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText) view);
                WxaLuckyMoneyPrepareUI.this.mKBLayout.setVisibility(0);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyPrepareUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(64947);
            }
        });
        ((MMEditText) this.yQN.findViewById(R.id.f4t)).setOnFocusChangeListener(new View.OnFocusChangeListener() {
            /* class com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI.AnonymousClass5 */

            public final void onFocusChange(View view, boolean z) {
                AppMethodBeat.i(64948);
                editText.setOnClickListener(null);
                editText2.setOnClickListener(null);
                WxaLuckyMoneyPrepareUI.this.ak(WxaLuckyMoneyPrepareUI.this.yQM, 2);
                WxaLuckyMoneyPrepareUI.this.ak(WxaLuckyMoneyPrepareUI.this.yQL, 0);
                AppMethodBeat.o(64948);
            }
        });
        g gVar = g.GLOBAL;
        if (this.yQc == h.a.RANDOM_LUCK) {
            this.yQM.setMaxAmount(gVar.yPy);
        } else {
            this.yQM.setMaxAmount(gVar.yPw);
        }
        this.yQM.setMinAmount(gVar.yPx);
        this.yQL.setMaxNum(gVar.yPv);
        h.a aVar = h.a.RANDOM_LUCK;
        this.yQL.setMinNum(1);
        this.yQM.setMaxLen(12);
        String string = getString(R.string.epe);
        String string2 = getString(R.string.ept);
        String string3 = getString(R.string.ep9);
        String string4 = getString(R.string.epu);
        l lVar = new l(this);
        final SpannableString spannableString = new SpannableString(string + string2);
        spannableString.setSpan(lVar, string.length(), string.length() + string2.length(), 33);
        final SpannableString spannableString2 = new SpannableString(string3 + string4);
        l lVar2 = new l(this);
        spannableString2.setSpan(lVar2, string3.length(), string3.length() + string4.length(), 33);
        lVar.IgH = new l.a() {
            /* class com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI.AnonymousClass14 */

            @Override // com.tencent.mm.plugin.wallet_core.ui.l.a
            public final void onClick(View view) {
                AppMethodBeat.i(64960);
                int input = WxaLuckyMoneyPrepareUI.this.yQL.getInput();
                double input2 = WxaLuckyMoneyPrepareUI.this.yQM.getInput();
                WxaLuckyMoneyPrepareUI.this.yQc = h.a.FIX_NORMAL;
                WxaLuckyMoneyPrepareUI.this.yQM.setType(WxaLuckyMoneyPrepareUI.this.yQc);
                WxaLuckyMoneyPrepareUI.this.yQM.setShowGroupIcon(false);
                WxaLuckyMoneyPrepareUI.this.yQM.setTitle(WxaLuckyMoneyPrepareUI.this.getString(R.string.esl));
                if (input2 > 0.0d && input > 0) {
                    WxaLuckyMoneyPrepareUI.this.yQM.setAmount(f.formatMoney2f(input2 / ((double) input)));
                }
                WxaLuckyMoneyPrepareUI.this.yQM.setMaxAmount(g.GLOBAL.yPw);
                WxaLuckyMoneyPrepareUI.this.nAB.setText(spannableString2);
                AppMethodBeat.o(64960);
            }
        };
        lVar2.IgH = new l.a() {
            /* class com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI.AnonymousClass15 */

            @Override // com.tencent.mm.plugin.wallet_core.ui.l.a
            public final void onClick(View view) {
                AppMethodBeat.i(64961);
                int input = WxaLuckyMoneyPrepareUI.this.yQL.getInput();
                double input2 = WxaLuckyMoneyPrepareUI.this.yQM.getInput();
                WxaLuckyMoneyPrepareUI.this.yQc = h.a.RANDOM_LUCK;
                WxaLuckyMoneyPrepareUI.this.yQM.setType(WxaLuckyMoneyPrepareUI.this.yQc);
                WxaLuckyMoneyPrepareUI.this.yQM.setMaxAmount(g.GLOBAL.yPy);
                WxaLuckyMoneyPrepareUI.this.yQM.setTitle(WxaLuckyMoneyPrepareUI.this.getString(R.string.esk));
                WxaLuckyMoneyPrepareUI.this.yQM.setShowGroupIcon(true);
                if (input2 > 0.0d && input > 0) {
                    WxaLuckyMoneyPrepareUI.this.yQM.setAmount(f.formatMoney2f(input2 * ((double) input)));
                }
                WxaLuckyMoneyPrepareUI.this.nAB.setText(spannableString);
                AppMethodBeat.o(64961);
            }
        };
        this.nAB.setMovementMethod(LinkMovementMethod.getInstance());
        this.nAB.setText(spannableString);
        this.nAB.setVisibility(0);
        this.yQO.setClickable(false);
        this.yQO.setEnabled(false);
        this.yQO.setOnClickListener(new x() {
            /* class com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI.AnonymousClass11 */

            @Override // com.tencent.mm.ui.x
            public final void czW() {
                AppMethodBeat.i(64957);
                if (WxaLuckyMoneyPrepareUI.this.yQJ == null) {
                    Log.e("MicroMsg.WxaLuckyMoneyPrepareUI", "Click PrepareBtn but, mLogic == null");
                    AppMethodBeat.o(64957);
                } else if (WxaLuckyMoneyPrepareUI.this.yQM.eeH() != 0) {
                    u.makeText(WxaLuckyMoneyPrepareUI.this.getContext(), (int) R.string.i7f, 0).show();
                    AppMethodBeat.o(64957);
                } else {
                    int input = WxaLuckyMoneyPrepareUI.this.yQL.getInput();
                    double input2 = WxaLuckyMoneyPrepareUI.this.yQM.getInput();
                    String input3 = WxaLuckyMoneyPrepareUI.this.yQN.getInput();
                    if (Util.isNullOrNil(input3)) {
                        if (!Util.isNullOrNil(stringExtra)) {
                            input3 = stringExtra;
                        } else {
                            input3 = WxaLuckyMoneyPrepareUI.this.getString(R.string.eof);
                        }
                    }
                    if (WxaLuckyMoneyPrepareUI.this.yQc == h.a.RANDOM_LUCK) {
                        WxaLuckyMoneyPrepareUI.this.yQJ.d((int) f.E(input2), input, input3, WxaLuckyMoneyPrepareUI.this.yQT);
                        AppMethodBeat.o(64957);
                        return;
                    }
                    if (WxaLuckyMoneyPrepareUI.this.yQc == h.a.FIX_NORMAL) {
                        WxaLuckyMoneyPrepareUI.this.yQJ.e((int) f.E(input2), input, input3, WxaLuckyMoneyPrepareUI.this.yQT);
                    }
                    AppMethodBeat.o(64957);
                }
            }
        });
        this.yQU.a(this.yQL);
        this.yQU.a(this.yQM);
        this.yQU.a(this.yQN);
        this.yQU.t((TextView) findViewById(R.id.f3e));
        if (this.yQR != null) {
            this.yQR.setOnTouchListener(new View.OnTouchListener() {
                /* class com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI.AnonymousClass12 */

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(64958);
                    if (motionEvent.getAction() == 0) {
                        WxaLuckyMoneyPrepareUI.this.hideTenpayKB();
                        WxaLuckyMoneyPrepareUI.this.hideVKB();
                    }
                    AppMethodBeat.o(64958);
                    return false;
                }
            });
        }
        this.yQM.setType(this.yQc);
        addIconOptionMenu(0, R.drawable.af_, new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI.AnonymousClass13 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(64959);
                f.p(WxaLuckyMoneyPrepareUI.this.getContext(), WxaLuckyMoneyPrepareUI.yQK, false);
                AppMethodBeat.o(64959);
                return true;
            }
        });
        int intExtra = getIntent().getIntExtra("range", 0);
        Log.i("MicroMsg.WxaLuckyMoneyPrepareUI", "initRange range = %d", Integer.valueOf(intExtra));
        this.yQP.setVisibility(8);
        if (intExtra == 0) {
            this.yQT = 0;
            AppMethodBeat.o(64968);
        } else if (intExtra == 1) {
            this.yQT = 1;
            AppMethodBeat.o(64968);
        } else {
            final ArrayList arrayList = new ArrayList();
            arrayList.add(getString(R.string.j5m));
            arrayList.add(getString(R.string.j5n));
            this.yQP.setVisibility(0);
            this.yQQ.setText((CharSequence) arrayList.get(this.yQT));
            this.yQP.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI.AnonymousClass16 */

                public final void onClick(View view) {
                    AppMethodBeat.i(64963);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyPrepareUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    final com.tencent.mm.ui.widget.picker.c cVar = new com.tencent.mm.ui.widget.picker.c(WxaLuckyMoneyPrepareUI.this.getContext(), arrayList);
                    cVar.app(WxaLuckyMoneyPrepareUI.this.yQT);
                    cVar.QTc = new c.b() {
                        /* class com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI.AnonymousClass16.AnonymousClass1 */

                        @Override // com.tencent.mm.ui.widget.picker.c.b
                        public final void onResult(boolean z, Object obj, Object obj2) {
                            AppMethodBeat.i(64962);
                            cVar.hide();
                            if (z) {
                                WxaLuckyMoneyPrepareUI.this.yQQ.setText((CharSequence) obj);
                            }
                            WxaLuckyMoneyPrepareUI.this.yQT = cVar.hci();
                            AppMethodBeat.o(64962);
                        }
                    };
                    cVar.show();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyPrepareUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(64963);
                }
            });
            AppMethodBeat.o(64968);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(64969);
        setResult(0, new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{user cancel}}"));
        finish();
        AppMethodBeat.o(64969);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyBaseUI, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(64970);
        super.onDestroy();
        this.yQU.clear();
        if (this.yQJ != null) {
            this.yQJ.onDestroy();
        }
        AppMethodBeat.o(64970);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.ccw;
    }

    /* access modifiers changed from: protected */
    public final void ak(final View view, final int i2) {
        AppMethodBeat.i(64971);
        this.mKeyboard = (MyKeyboardWindow) findViewById(R.id.ijb);
        this.mKBLayout = findViewById(R.id.ija);
        View findViewById = findViewById(R.id.ijc);
        final EditText editText = (EditText) view.findViewById(R.id.f0o);
        if (this.mKeyboard == null || editText == null || this.mKBLayout == null) {
            AppMethodBeat.o(64971);
            return;
        }
        f.setNoSystemInputOnEditText(editText);
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            /* class com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI.AnonymousClass6 */
            final /* synthetic */ boolean val$isShowSysKB = false;

            public final void onFocusChange(final View view, boolean z) {
                AppMethodBeat.i(64951);
                if (!view.isFocused() || this.val$isShowSysKB) {
                    new MMHandler().postDelayed(new Runnable() {
                        /* class com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI.AnonymousClass6.AnonymousClass2 */

                        public final void run() {
                            AppMethodBeat.i(64950);
                            WxaLuckyMoneyPrepareUI.this.hideTenpayKB();
                            ((InputMethodManager) WxaLuckyMoneyPrepareUI.this.getContext().getSystemService("input_method")).showSoftInput(editText, 0);
                            AppMethodBeat.o(64950);
                        }
                    }, 200);
                    AppMethodBeat.o(64951);
                    return;
                }
                ((InputMethodManager) WxaLuckyMoneyPrepareUI.this.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                new MMHandler().postDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI.AnonymousClass6.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(64949);
                        if (!WxaLuckyMoneyPrepareUI.this.mKBLayout.isShown() && view.isShown()) {
                            WxaLuckyMoneyPrepareUI.this.mKBLayout.setVisibility(0);
                        }
                        WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this, i2);
                        WxaLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText) view);
                        ((InputMethodManager) WxaLuckyMoneyPrepareUI.this.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                        AppMethodBeat.o(64949);
                    }
                }, 300);
                AppMethodBeat.o(64951);
            }
        });
        editText.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI.AnonymousClass7 */
            final /* synthetic */ boolean val$isShowSysKB = false;

            public final void onClick(View view) {
                AppMethodBeat.i(64952);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyPrepareUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (!WxaLuckyMoneyPrepareUI.this.mKBLayout.isShown() && !this.val$isShowSysKB) {
                    WxaLuckyMoneyPrepareUI.this.mKBLayout.setVisibility(0);
                    WxaLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText) view);
                    WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this, i2);
                } else if (this.val$isShowSysKB) {
                    WxaLuckyMoneyPrepareUI.this.mKBLayout.setVisibility(8);
                    ((InputMethodManager) WxaLuckyMoneyPrepareUI.this.getContext().getSystemService("input_method")).showSoftInput(editText, 0);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyPrepareUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(64952);
            }
        });
        TextView textView = (TextView) view.findViewById(R.id.exz);
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI.AnonymousClass8 */
                final /* synthetic */ boolean val$isShowSysKB = false;

                public final void onClick(View view) {
                    AppMethodBeat.i(64954);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyPrepareUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (!WxaLuckyMoneyPrepareUI.this.mKBLayout.isShown() || this.val$isShowSysKB) {
                        if (!WxaLuckyMoneyPrepareUI.this.mKBLayout.isShown() && !this.val$isShowSysKB) {
                            ((InputMethodManager) WxaLuckyMoneyPrepareUI.this.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                            new MMHandler().postDelayed(new Runnable() {
                                /* class com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI.AnonymousClass8.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(64953);
                                    WxaLuckyMoneyPrepareUI.this.mKBLayout.setVisibility(0);
                                    view.requestFocus();
                                    if (WxaLuckyMoneyPrepareUI.this.mKeyboard != null) {
                                        WxaLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText(editText);
                                    }
                                    WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this, i2);
                                    AppMethodBeat.o(64953);
                                }
                            }, 200);
                        } else if (this.val$isShowSysKB) {
                            WxaLuckyMoneyPrepareUI.this.mKBLayout.setVisibility(8);
                            ((InputMethodManager) WxaLuckyMoneyPrepareUI.this.getContext().getSystemService("input_method")).showSoftInput(editText, 0);
                        }
                    } else if (WxaLuckyMoneyPrepareUI.this.mKeyboard != null) {
                        WxaLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText(editText);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyPrepareUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(64954);
                }
            });
        }
        findViewById.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI.AnonymousClass9 */

            public final void onClick(View view) {
                AppMethodBeat.i(64955);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyPrepareUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                WxaLuckyMoneyPrepareUI.this.hideTenpayKB();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyPrepareUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(64955);
            }
        });
        AppMethodBeat.o(64971);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(64972);
        if (i2 != 4 || this.mKBLayout == null || !this.mKBLayout.isShown()) {
            boolean onKeyUp = super.onKeyUp(i2, keyEvent);
            AppMethodBeat.o(64972);
            return onKeyUp;
        }
        this.mKBLayout.setVisibility(8);
        AppMethodBeat.o(64972);
        return true;
    }

    /* access modifiers changed from: protected */
    public final void hideTenpayKB() {
        AppMethodBeat.i(64973);
        if (this.mKBLayout != null && this.mKBLayout.isShown()) {
            this.mKBLayout.setVisibility(8);
        }
        AppMethodBeat.o(64973);
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.h
    public final void eeI() {
        AppMethodBeat.i(64974);
        double d2 = 0.0d;
        double d3 = 0.0d;
        if (!(this.yQM.eeH() == 3 || this.yQL.eeH() == 3)) {
            int input = this.yQL.getInput();
            d2 = this.yQM.getInput();
            if (this.yQc == h.a.FIX_NORMAL) {
                d2 *= (double) input;
                d3 = this.yQM.getInput();
            } else if (input > 0) {
                d3 = this.yQM.getInput() / ((double) input);
            }
        }
        boolean egj = this.yQU.egj();
        g gVar = g.GLOBAL;
        if (egj) {
            Log.i("MicroMsg.WxaLuckyMoneyPrepareUI", "has error");
            this.yQO.setClickable(false);
            this.yQO.setEnabled(false);
        } else {
            boolean z = false;
            if (d2 == 0.0d || d3 == 0.0d) {
                z = true;
            } else if (d2 > gVar.yPy && gVar.yPy > 0.0d) {
                this.yQU.aeu(getString(R.string.esj, new Object[]{new StringBuilder().append(Math.round(gVar.yPy)).toString(), Util.nullAs(gVar.yPB, "")}));
                z = true;
            } else if (d3 > 0.0d) {
                Log.i("MicroMsg.WxaLuckyMoneyPrepareUI", "perAmount ".concat(String.valueOf(d3)));
                if (this.yQc == h.a.FIX_NORMAL) {
                    if (d3 > gVar.yPw && gVar.yPw > 0.0d) {
                        this.yQU.aeu(getString(R.string.er1, new Object[]{new StringBuilder().append(Math.round(gVar.yPw)).toString(), Util.nullAs(gVar.yPB, "")}));
                        z = true;
                    }
                } else if (d3 > gVar.yPz && gVar.yPz > 0.0d) {
                    this.yQU.aeu(getString(R.string.er1, new Object[]{new StringBuilder().append(Math.round(gVar.yPz)).toString(), Util.nullAs(gVar.yPB, "")}));
                    z = true;
                    this.yQL.onError();
                    this.yQM.onError();
                }
                Log.i("MicroMsg.WxaLuckyMoneyPrepareUI", "furtherCheckHasErr:" + z + " for max value");
                if (!z) {
                    if (this.yQc == h.a.FIX_NORMAL) {
                        if (d3 < gVar.yPx) {
                            this.yQU.aeu(getString(R.string.er3, new Object[]{f.formatMoney2f(gVar.yPx), Util.nullAs(gVar.yPB, "")}));
                            z = true;
                        }
                    } else if (d3 < 0.01d) {
                        this.yQU.aeu(getString(R.string.er3, new Object[]{"0.01", Util.nullAs(gVar.yPB, "")}));
                        z = true;
                        this.yQL.onError();
                        this.yQM.onError();
                    }
                }
                Log.i("MicroMsg.WxaLuckyMoneyPrepareUI", "furtherCheckHasErr:" + z + " for min value");
            }
            if (z) {
                this.yQO.setClickable(false);
                this.yQO.setEnabled(false);
            } else {
                this.yQO.setClickable(true);
                this.yQO.setEnabled(true);
            }
        }
        String str = gVar.yPA;
        if (Util.isNullOrNil(str)) {
            this.qAC.setText(f.D(d2));
            AppMethodBeat.o(64974);
            return;
        }
        this.qAC.setText(str + f.formatMoney2f(d2));
        AppMethodBeat.o(64974);
    }

    @Override // com.tencent.mm.plugin.luckymoney.appbrand.ui.b
    public final void error(String str) {
        AppMethodBeat.i(64967);
        if (TextUtils.isEmpty(str)) {
            str = getString(R.string.itf);
        }
        com.tencent.mm.ui.base.h.a((Context) this, str, (String) null, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI.AnonymousClass1 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(64944);
                dialogInterface.dismiss();
                AppMethodBeat.o(64944);
            }
        });
        AppMethodBeat.o(64967);
    }

    static /* synthetic */ void b(WxaLuckyMoneyPrepareUI wxaLuckyMoneyPrepareUI, int i2) {
        AppMethodBeat.i(213263);
        wxaLuckyMoneyPrepareUI.mKeyboard.setXMode(i2);
        AppMethodBeat.o(213263);
    }
}
