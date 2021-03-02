package com.tencent.mm.wallet_core.ui.formview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.text.method.PasswordTransformationMethod;
import android.text.style.AbsoluteSizeSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.mm.wallet_core.ui.formview.c;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.lang.reflect.Field;
import junit.framework.Assert;

public final class WalletFormView extends LinearLayout implements View.OnFocusChangeListener {
    private View.OnClickListener BFA;
    private int BFD;
    private String BFE;
    private int BFF;
    private String BFG;
    private int BFH;
    private int BFI;
    private int BFJ;
    private String BFK;
    private int BFL;
    private String BFM;
    private int BFN;
    private int BFO;
    private String BFP;
    private int BFQ;
    private int BFR;
    private int BFS;
    private boolean BFT;
    private boolean BFU;
    private boolean BFV;
    private int BFW;
    private int BFX;
    private int BFY;
    private TextView BFu;
    private WalletIconImageView BFw;
    private TextView BFx;
    private View.OnFocusChangeListener BFz;
    private int OYK;
    private c Rwd;
    public TenpaySecureEditText Rwe;
    private LinearLayout Rwf;
    private a Rwg;
    private com.tencent.mm.wallet_core.ui.formview.a.a Rwh;
    private com.tencent.mm.wallet_core.ui.formview.a.b Rwi;
    private int Rwj;
    private int Rwk;
    private int Rwl;
    private int Rwm;
    private int Rwn;
    private boolean Rwo;
    @Deprecated
    private int Rwp;
    private int Rwq;
    private int Rwr;
    private int Rws;
    private TextView jVl;
    private TextView mPa;

    public interface a {
        void onInputValidChange(boolean z);
    }

    public interface b extends a {
    }

    public interface c {
        void p(CharSequence charSequence);
    }

    static /* synthetic */ void l(WalletFormView walletFormView) {
        AppMethodBeat.i(73200);
        walletFormView.eIh();
        AppMethodBeat.o(73200);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletFormView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        boolean z = false;
        AppMethodBeat.i(73147);
        this.mPa = null;
        this.BFu = null;
        this.Rwe = null;
        this.BFw = null;
        this.BFx = null;
        this.Rwg = null;
        this.BFz = null;
        this.BFA = null;
        this.Rwh = null;
        this.Rwi = null;
        this.BFD = -1;
        this.Rwj = this.BFD;
        this.Rwk = 100;
        this.BFE = "";
        this.BFF = 0;
        this.BFG = "";
        this.BFH = 8;
        this.BFI = -1;
        this.Rwl = -1;
        this.BFJ = 4;
        this.BFK = "";
        this.BFL = 8;
        this.BFM = "";
        this.Rwm = -1;
        this.BFN = 19;
        this.BFO = R.color.a2x;
        this.BFP = "";
        this.Rwn = 0;
        this.BFQ = Integer.MAX_VALUE;
        this.BFR = 1;
        this.BFS = R.drawable.aij;
        this.BFT = true;
        this.BFU = false;
        this.BFV = true;
        this.Rwo = false;
        this.BFW = 1;
        this.BFX = 5;
        this.BFY = R.color.x5;
        this.Rwp = 0;
        this.Rwq = 0;
        this.Rwr = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C2011a.WalletFormAttrs, i2, 0);
        this.BFD = obtainStyledAttributes.getResourceId(23, this.BFD);
        int resourceId = obtainStyledAttributes.getResourceId(30, 0);
        if (resourceId != 0) {
            this.BFE = context.getString(resourceId);
        }
        this.OYK = obtainStyledAttributes.getDimensionPixelSize(32, -1);
        this.BFI = obtainStyledAttributes.getResourceId(20, this.BFI);
        this.Rwl = obtainStyledAttributes.getColor(19, this.Rwl);
        int resourceId2 = obtainStyledAttributes.getResourceId(28, 0);
        if (resourceId2 != 0) {
            this.BFK = context.getString(resourceId2);
        }
        this.BFJ = obtainStyledAttributes.getInteger(21, this.BFJ);
        this.BFF = obtainStyledAttributes.getInteger(31, this.BFF);
        this.BFL = obtainStyledAttributes.getInteger(29, this.BFL);
        this.BFH = obtainStyledAttributes.getInteger(27, this.BFH);
        int resourceId3 = obtainStyledAttributes.getResourceId(25, 0);
        if (resourceId3 != 0) {
            this.BFG = context.getString(resourceId3);
        }
        int resourceId4 = obtainStyledAttributes.getResourceId(11, 0);
        if (resourceId4 != 0) {
            this.BFM = context.getString(resourceId4);
        }
        this.Rwm = obtainStyledAttributes.getDimensionPixelSize(12, -1);
        this.BFN = obtainStyledAttributes.getInteger(10, this.BFN);
        this.BFO = obtainStyledAttributes.getColor(17, this.BFO);
        int resourceId5 = obtainStyledAttributes.getResourceId(16, 0);
        if (resourceId5 != 0) {
            this.BFP = context.getString(resourceId5);
        }
        this.Rwn = obtainStyledAttributes.getInt(9, this.Rwn);
        this.BFQ = obtainStyledAttributes.getInteger(14, this.BFQ);
        this.BFR = obtainStyledAttributes.getInteger(15, this.BFR);
        this.BFS = obtainStyledAttributes.getResourceId(5, this.BFS);
        this.BFT = obtainStyledAttributes.getBoolean(7, this.BFT);
        this.BFU = obtainStyledAttributes.getBoolean(6, this.BFU);
        this.BFV = obtainStyledAttributes.getBoolean(7, this.BFV);
        this.BFW = obtainStyledAttributes.getInteger(0, this.BFW);
        this.BFX = obtainStyledAttributes.getInteger(1, this.BFX);
        this.Rwk = obtainStyledAttributes.getInteger(18, this.Rwk);
        this.BFY = obtainStyledAttributes.getInteger(13, this.BFY);
        this.Rwj = obtainStyledAttributes.getResourceId(24, this.Rwj);
        this.Rwp = obtainStyledAttributes.getInteger(33, 0);
        this.Rwq = obtainStyledAttributes.getInteger(34, -1);
        if (this.Rwp == 1 && this.Rwq == -1) {
            this.Rwq = 4;
        }
        this.Rwr = obtainStyledAttributes.getResourceId(2, 0);
        obtainStyledAttributes.recycle();
        Assert.assertTrue(this.BFD > 0 ? true : z);
        setOrientation(1);
        if (Util.isNullOrNil(this.BFE) || this.BFE.length() <= 6) {
            inflate(context, this.BFD, this);
        } else {
            inflate(context, this.Rwj, this);
        }
        this.mPa = (TextView) findViewById(R.id.jia);
        this.BFu = (TextView) findViewById(R.id.jhs);
        this.Rwe = (TenpaySecureEditText) findViewById(R.id.jf4);
        this.BFw = (WalletIconImageView) findViewById(R.id.jfu);
        this.BFx = (TextView) findViewById(R.id.ji_);
        this.Rwf = (LinearLayout) findViewById(R.id.jg1);
        this.jVl = (TextView) findViewById(R.id.jg4);
        AppMethodBeat.o(73147);
    }

    public WalletFormView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public final void setTitleText(String str) {
        AppMethodBeat.i(73148);
        this.BFE = str;
        hia();
        AppMethodBeat.o(73148);
    }

    public final int k(CharSequence charSequence, int i2, int i3) {
        float measureText;
        AppMethodBeat.i(73149);
        if (this.Rws == 0) {
            this.Rws = (this.Rwe.getLeft() - this.mPa.getLeft()) + this.Rwe.getPaddingLeft();
            Log.d("MicroMsg.WalletFormView", "mMaxUnitLeftOriginWidth:%s", Integer.valueOf(this.Rws));
        }
        if (!Util.isEqual(charSequence.toString(), "")) {
            if (i3 == 1) {
                measureText = this.Rwe.getPaint().measureText("1");
            } else {
                measureText = this.Rwe.getPaint().measureText("2");
            }
            int i4 = (int) (((measureText / 2.0f) + ((float) this.Rws)) - ((float) (i2 / 2)));
            AppMethodBeat.o(73149);
            return i4;
        }
        AppMethodBeat.o(73149);
        return 0;
    }

    public final void setContentPadding$3b4dfe4b(int i2) {
        AppMethodBeat.i(163889);
        if (this.Rwe != null) {
            this.Rwe.setPadding(i2, 0, 0, 0);
        }
        AppMethodBeat.o(163889);
    }

    public final void set3DesValStr(String str) {
        AppMethodBeat.i(73151);
        if (this.Rwe != null && (this.Rwi == null || !this.Rwi.b(this, str))) {
            this.Rwe.set3DesEncrptData(str);
            setSelection(getInputLength());
        }
        AppMethodBeat.o(73151);
    }

    public final String getMD5Value() {
        AppMethodBeat.i(73152);
        String nullAsNil = Util.nullAsNil(this.Rwe.getText().toString());
        if (this.Rwi != null && this.Rwi.eIg()) {
            nullAsNil = this.Rwi.c(this, nullAsNil);
        }
        String mD5String = MD5Util.getMD5String(nullAsNil);
        AppMethodBeat.o(73152);
        return mD5String;
    }

    public final void setImeOptions(int i2) {
        AppMethodBeat.i(73153);
        if (this.Rwe != null) {
            this.Rwe.setImeOptions(i2);
        }
        AppMethodBeat.o(73153);
    }

    public final void setInputType(int i2) {
        AppMethodBeat.i(73154);
        if (this.Rwe != null) {
            this.Rwe.setInputType(i2);
        }
        AppMethodBeat.o(73154);
    }

    public final void setmContentAbnormalMoneyCheck(boolean z) {
        this.Rwo = z;
    }

    public final void setText(String str) {
        AppMethodBeat.i(73155);
        if (this.Rwe != null && (this.Rwi == null || !this.Rwi.a(this, str))) {
            this.Rwe.setText(str);
            this.Rwe.setSelection(getInputLength());
        }
        AppMethodBeat.o(73155);
    }

    public final void setInputEnable(boolean z) {
        AppMethodBeat.i(73156);
        if (this.Rwe != null) {
            this.Rwe.setEnabled(z);
        }
        AppMethodBeat.o(73156);
    }

    public final int getSelectionStart() {
        AppMethodBeat.i(73157);
        if (this.Rwe != null) {
            int selectionStart = this.Rwe.getSelectionStart();
            AppMethodBeat.o(73157);
            return selectionStart;
        }
        AppMethodBeat.o(73157);
        return -1;
    }

    @SuppressLint({"ResourceType"})
    public final void setContentTextColorRes(int i2) {
        AppMethodBeat.i(73158);
        this.BFO = i2;
        if (this.Rwe != null) {
            this.Rwe.setTextColor(getResources().getColor(this.BFO));
        }
        AppMethodBeat.o(73158);
    }

    public final void setContentTextColor(int i2) {
        AppMethodBeat.i(73159);
        if (this.Rwe != null) {
            this.Rwe.setTextColor(i2);
        }
        AppMethodBeat.o(73159);
    }

    private void eIh() {
        AppMethodBeat.i(73160);
        if (this.BFw != null && !Util.isNullOrNil(getText()) && this.Rwe != null && this.Rwe.isEnabled() && this.Rwe.isClickable() && this.Rwe.isFocusable() && this.Rwe.isFocused()) {
            this.BFw.setToClearState(new View.OnClickListener() {
                /* class com.tencent.mm.wallet_core.ui.formview.WalletFormView.AnonymousClass2 */

                public final void onClick(View view) {
                    AppMethodBeat.i(73144);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/wallet_core/ui/formview/WalletFormView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    WalletFormView.this.eIj();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/wallet_core/ui/formview/WalletFormView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(73144);
                }
            });
            AppMethodBeat.o(73160);
        } else if (this.BFw != null) {
            this.BFw.gsP();
            AppMethodBeat.o(73160);
        } else {
            Log.v("MicroMsg.WalletFormView", "hy: no info iv");
            AppMethodBeat.o(73160);
        }
    }

    public final a getInputValidChangeListener() {
        return this.Rwg;
    }

    public final boolean hhZ() {
        AppMethodBeat.i(73161);
        if (this.Rwe != null) {
            boolean isFocusable = this.Rwe.isFocusable();
            AppMethodBeat.o(73161);
            return isFocusable;
        }
        AppMethodBeat.o(73161);
        return false;
    }

    /* access modifiers changed from: protected */
    public final void onAttachedToWindow() {
        AppMethodBeat.i(73162);
        super.onAttachedToWindow();
        AppMethodBeat.o(73162);
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        AppMethodBeat.i(73163);
        super.onDetachedFromWindow();
        AppMethodBeat.o(73163);
    }

    /* access modifiers changed from: protected */
    public final void onFinishInflate() {
        AppMethodBeat.i(73164);
        super.onFinishInflate();
        hia();
        if (getPrefilledTv() != null) {
            getPrefilledTv().setText(this.BFG);
            getPrefilledTv().setVisibility(this.BFH);
        }
        if (getInfoIv() != null) {
            getInfoIv().setImageResource(this.BFI);
            getInfoIv().setVisibility(this.BFJ);
            if (this.Rwl != -1) {
                getInfoIv().setmUserSetImageIconColor(this.Rwl);
            }
        }
        if (getTipsTv() != null) {
            getTipsTv().setText(this.BFK);
            getTipsTv().setVisibility(this.BFL);
        }
        Context context = getContext();
        if (this.Rwe != null) {
            if (this.Rwq >= 0) {
                try {
                    this.Rwe.setTypeface(Typeface.createFromAsset(context.getAssets(), f.aqk(this.Rwq)));
                } catch (Exception e2) {
                    Log.e("MicroMsg.WalletFormView", "setTypeface() Exception:%s %s", e2.getClass().getSimpleName(), e2.getMessage());
                }
            }
            if (this.Rwm == -1) {
                this.Rwe.setHint(this.BFM);
            } else {
                SpannableString spannableString = new SpannableString(this.BFM + "  ");
                spannableString.setSpan(new com.tencent.mm.cf.a(this.Rwm), 0, spannableString.length() - 2, 33);
                spannableString.setSpan(new AbsoluteSizeSpan((int) this.Rwe.getTextSize(), false), spannableString.length() - 2, spannableString.length(), 33);
                this.Rwe.setHint(new SpannedString(spannableString));
            }
            this.Rwe.setGravity(this.BFN);
            this.Rwe.setTextColor(this.BFO);
            setText(this.BFP);
            b.a(this.Rwe, this.Rwn);
            this.Rwe.setBackgroundResource(this.BFS);
            this.Rwe.setEnabled(this.BFT);
            this.Rwe.setFocusable(this.BFV);
            this.Rwe.setClickable(this.BFU);
            this.Rwe.setHintTextColor(this.BFY);
            setImeOptions(this.BFX);
            setInputType(this.BFW);
            this.Rwe.addTextChangedListener(new TextWatcher() {
                /* class com.tencent.mm.wallet_core.ui.formview.WalletFormView.AnonymousClass1 */
                private boolean BGa = false;

                public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    AppMethodBeat.i(73142);
                    if (WalletFormView.this.Rwd != null) {
                        WalletFormView.this.Rwd.p(charSequence);
                    }
                    AppMethodBeat.o(73142);
                }

                public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                public final void afterTextChanged(Editable editable) {
                    AppMethodBeat.i(73143);
                    String obj = editable.toString();
                    if (obj.startsWith(".")) {
                        editable.insert(0, AppEventsConstants.EVENT_PARAM_VALUE_NO);
                    } else if (WalletFormView.this.Rwo && WalletFormView.a(obj, WalletFormView.this.Rwe)) {
                        AppMethodBeat.o(73143);
                        return;
                    }
                    boolean bql = WalletFormView.this.bql();
                    if (WalletFormView.this.Rwg != null) {
                        if (bql != this.BGa) {
                            WalletFormView.this.Rwg.onInputValidChange(bql);
                            this.BGa = WalletFormView.this.bql();
                        }
                        if ((WalletFormView.this.Rwg instanceof b) && bql) {
                            a unused = WalletFormView.this.Rwg;
                        }
                    }
                    WalletFormView.l(WalletFormView.this);
                    AppMethodBeat.o(73143);
                }
            });
            this.Rwe.setOnFocusChangeListener(this);
            try {
                if (!Util.isEqual(this.Rwr, 0)) {
                    Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
                    declaredField.setAccessible(true);
                    declaredField.set(this.Rwe, Integer.valueOf(this.Rwr));
                }
            } catch (Exception e3) {
                Log.e("MicroMsg.WalletFormView", "set textCursorDrawable fail!!");
            }
        }
        eIh();
        if (this.Rwe != null) {
            if (this.BFW == 2) {
                this.Rwe.setKeyListener(new NumberKeyListener() {
                    /* class com.tencent.mm.wallet_core.ui.formview.WalletFormView.AnonymousClass5 */

                    public final int getInputType() {
                        return 3;
                    }

                    /* access modifiers changed from: protected */
                    public final char[] getAcceptedChars() {
                        return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
                    }
                });
            } else if (this.BFW == 4) {
                this.Rwe.setKeyListener(new NumberKeyListener() {
                    /* class com.tencent.mm.wallet_core.ui.formview.WalletFormView.AnonymousClass6 */

                    public final int getInputType() {
                        return 1;
                    }

                    /* access modifiers changed from: protected */
                    public final char[] getAcceptedChars() {
                        return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'x', 'X'};
                    }
                });
            } else if (this.BFW == 128) {
                this.Rwe.setTransformationMethod(PasswordTransformationMethod.getInstance());
                this.Rwe.setKeyListener(new NumberKeyListener() {
                    /* class com.tencent.mm.wallet_core.ui.formview.WalletFormView.AnonymousClass7 */

                    public final int getInputType() {
                        return 18;
                    }

                    /* access modifiers changed from: protected */
                    public final char[] getAcceptedChars() {
                        return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
                    }
                });
                this.Rwe.setRawInputType(18);
            } else if (this.BFW == 3) {
                this.Rwe.setKeyListener(new NumberKeyListener() {
                    /* class com.tencent.mm.wallet_core.ui.formview.WalletFormView.AnonymousClass8 */

                    public final int getInputType() {
                        return 3;
                    }

                    /* access modifiers changed from: protected */
                    public final char[] getAcceptedChars() {
                        return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '-', '+'};
                    }
                });
            } else {
                this.Rwe.setInputType(this.BFW);
            }
            if (this.BFQ != -1) {
                this.Rwe.setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.BFQ)});
            }
        }
        AppMethodBeat.o(73164);
    }

    public final void setHint(CharSequence charSequence) {
        AppMethodBeat.i(73165);
        if (this.Rwe != null) {
            if (this.Rwm == -1) {
                this.Rwe.setHint(charSequence);
                AppMethodBeat.o(73165);
                return;
            }
            SpannableString spannableString = new SpannableString(charSequence);
            spannableString.setSpan(new AbsoluteSizeSpan(this.Rwm, false), 0, spannableString.length(), 33);
            this.Rwe.setHint(new SpannedString(spannableString));
        }
        AppMethodBeat.o(73165);
    }

    public final void setContentClickable(boolean z) {
        AppMethodBeat.i(73166);
        if (this.Rwe != null) {
            this.Rwe.setClickable(z);
        }
        AppMethodBeat.o(73166);
    }

    public final void setContentFocusable(boolean z) {
        AppMethodBeat.i(73167);
        if (this.Rwe != null) {
            this.Rwe.setFocusable(z);
        }
        AppMethodBeat.o(73167);
    }

    public final void setContentEnabled(boolean z) {
        AppMethodBeat.i(73168);
        if (this.Rwe != null) {
            this.Rwe.setEnabled(z);
        }
        AppMethodBeat.o(73168);
    }

    public final void setFilterChar(char[] cArr) {
    }

    public final void setOnEditorActionListener(TextView.OnEditorActionListener onEditorActionListener) {
        AppMethodBeat.i(73169);
        this.Rwe.setOnEditorActionListener(onEditorActionListener);
        AppMethodBeat.o(73169);
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"WrongCall"})
    public final void onMeasure(int i2, int i3) {
        AppMethodBeat.i(73170);
        if (this.Rwh == null || !this.Rwh.hid()) {
            super.onMeasure(i2, i3);
        }
        AppMethodBeat.o(73170);
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(73171);
        if (this.Rwh != null && this.Rwh.hie()) {
            AppMethodBeat.o(73171);
            return true;
        } else if (this.Rwe != null && c(this.Rwe, motionEvent) && !this.Rwe.isClickable()) {
            Log.d("MicroMsg.WalletFormView", "hy: click on content but content is not clickable. whole view perform click");
            AppMethodBeat.o(73171);
            return true;
        } else if (this.BFw == null || !this.BFw.isClickable() || !c(this.BFw, motionEvent) || motionEvent.getAction() != 1) {
            AppMethodBeat.o(73171);
            return false;
        } else {
            Log.d("MicroMsg.WalletFormView", "hy: click on info iv");
            eIh();
            this.BFw.performClick();
            AppMethodBeat.o(73171);
            return true;
        }
    }

    private boolean c(View view, MotionEvent motionEvent) {
        AppMethodBeat.i(73172);
        if (view == null || view.getVisibility() != 0) {
            AppMethodBeat.o(73172);
            return false;
        } else if (eJ(view).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            AppMethodBeat.o(73172);
            return true;
        } else {
            AppMethodBeat.o(73172);
            return false;
        }
    }

    private Rect g(View view, Rect rect) {
        if (view == this.BFw) {
            rect.left -= 50;
            rect.right += 50;
            rect.top -= 25;
            rect.bottom += 25;
        }
        return rect;
    }

    private Rect eJ(View view) {
        AppMethodBeat.i(73173);
        if (view != null) {
            Rect rect = new Rect();
            view.getHitRect(rect);
            Rect g2 = g(view, rect);
            AppMethodBeat.o(73173);
            return g2;
        }
        AppMethodBeat.o(73173);
        return null;
    }

    private void hia() {
        AppMethodBeat.i(73174);
        if (getTitleTv() != null) {
            getTitleTv().setText(this.BFE);
            getTitleTv().setVisibility(this.BFF);
            setTitleWidth(this.OYK);
        }
        AppMethodBeat.o(73174);
    }

    public final TextView getTitleTv() {
        return this.mPa;
    }

    public final float getTitleMeasuredWidth() {
        AppMethodBeat.i(182538);
        float measureText = this.mPa.getPaint().measureText(this.mPa.getText(), 0, this.mPa.getText().length());
        AppMethodBeat.o(182538);
        return measureText;
    }

    public final void setTitleWidth(int i2) {
        ViewGroup.LayoutParams layoutParams;
        AppMethodBeat.i(182539);
        this.OYK = i2;
        if (this.OYK > 0 && (layoutParams = this.mPa.getLayoutParams()) != null) {
            layoutParams.width = this.OYK;
            this.mPa.setLayoutParams(layoutParams);
        }
        AppMethodBeat.o(182539);
    }

    public final WalletIconImageView getInfoIv() {
        return this.BFw;
    }

    public final TextView getTipsTv() {
        return this.BFx;
    }

    public final TextView getPrefilledTv() {
        return this.BFu;
    }

    public final void setSelection(int i2) {
        AppMethodBeat.i(73175);
        if (this.Rwe != null) {
            this.Rwe.setSelection(i2);
        }
        AppMethodBeat.o(73175);
    }

    public final com.tencent.mm.wallet_core.ui.formview.a.a getEventDelegate() {
        return this.Rwh;
    }

    public final com.tencent.mm.wallet_core.ui.formview.a.b getLogicDelegate() {
        return this.Rwi;
    }

    public final String getText() {
        AppMethodBeat.i(73176);
        if (this.Rwe != null) {
            String a2 = c.a.a(this.Rwk, this.Rwe);
            if (this.Rwi == null || !this.Rwi.eIg()) {
                AppMethodBeat.o(73176);
                return a2;
            }
            String c2 = this.Rwi.c(this, a2);
            AppMethodBeat.o(73176);
            return c2;
        }
        Log.e("MicroMsg.WalletFormView", "hy: no content et. return nil");
        AppMethodBeat.o(73176);
        return "";
    }

    public final KeyListener getKeyListener() {
        AppMethodBeat.i(73177);
        if (this.Rwe != null) {
            KeyListener keyListener = this.Rwe.getKeyListener();
            AppMethodBeat.o(73177);
            return keyListener;
        }
        Log.w("MicroMsg.WalletFormView", "hy: no content et");
        AppMethodBeat.o(73177);
        return null;
    }

    public final EditText getContentEt() {
        return this.Rwe;
    }

    public final void setMaxInputLength(int i2) {
        this.BFQ = i2;
    }

    public final void setMinInputLength(int i2) {
        this.BFR = i2;
    }

    public final int getMaxInputLength() {
        return this.BFQ;
    }

    public final int getMinInputLength() {
        return this.BFR;
    }

    public final void setBankcardTail(String str) {
        AppMethodBeat.i(73178);
        if (this.Rwe != null) {
            this.Rwe.setBankcardTailNum(str);
        }
        AppMethodBeat.o(73178);
    }

    public final int getEncrptType() {
        return this.Rwk;
    }

    public final void setOnClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(73179);
        super.setOnClickListener(onClickListener);
        AppMethodBeat.o(73179);
    }

    public final void setOnInfoIvClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(73180);
        this.BFA = onClickListener;
        if (getInfoIv() != null) {
            getInfoIv().setOnClickListener(this.BFA);
        }
        AppMethodBeat.o(73180);
    }

    public final void setOnInputValidChangeListener(a aVar) {
        this.Rwg = aVar;
    }

    public final void setOnFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.BFz = onFocusChangeListener;
    }

    public final void setEventDelegate(com.tencent.mm.wallet_core.ui.formview.a.a aVar) {
        this.Rwh = aVar;
    }

    public final void setLogicDelegate(com.tencent.mm.wallet_core.ui.formview.a.b bVar) {
        this.Rwi = bVar;
    }

    public final void setEncryptType(int i2) {
        this.Rwk = i2;
    }

    public final boolean isPhoneNum() {
        AppMethodBeat.i(73181);
        if (this.Rwe == null) {
            AppMethodBeat.o(73181);
            return false;
        }
        boolean isPhoneNum = this.Rwe.isPhoneNum();
        AppMethodBeat.o(73181);
        return isPhoneNum;
    }

    public final void a(TextWatcher textWatcher) {
        AppMethodBeat.i(73182);
        if (this.Rwe != null) {
            this.Rwe.addTextChangedListener(textWatcher);
        }
        AppMethodBeat.o(73182);
    }

    public final void hib() {
        AppMethodBeat.i(73183);
        if (this.Rwe != null) {
            this.Rwe.addTextChangedListener(new TextWatcher() {
                /* class com.tencent.mm.wallet_core.ui.formview.WalletFormView.AnonymousClass3 */
                final /* synthetic */ int Rwu = 2;
                final /* synthetic */ int Rwv = 7;

                public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                public final void afterTextChanged(Editable editable) {
                    String str;
                    int indexOf;
                    AppMethodBeat.i(73145);
                    String obj = editable.toString();
                    int indexOf2 = obj.indexOf(".");
                    int length = obj.length();
                    if (indexOf2 < 0 || (indexOf = obj.indexOf(".", indexOf2 + 1)) < 0) {
                        boolean z = false;
                        if (this.Rwu < 0 || indexOf2 < 0 || length - indexOf2 <= this.Rwu) {
                            str = obj;
                        } else {
                            str = WalletFormView.aX(obj, this.Rwu + indexOf2 + 1, length);
                            z = true;
                        }
                        if (this.Rwv >= 0) {
                            int selectionStart = WalletFormView.this.Rwe.getSelectionStart();
                            if (indexOf2 > this.Rwv) {
                                if (!Util.isEqual(selectionStart, -1) && indexOf2 - this.Rwv > 0 && selectionStart - (indexOf2 - this.Rwv) >= 0) {
                                    str = WalletFormView.aX(str, selectionStart - (indexOf2 - 7), selectionStart);
                                    z = true;
                                }
                            } else if (Util.isEqual(indexOf2, -1) && length > this.Rwv && selectionStart >= 0 && selectionStart - (length - this.Rwv) >= 0) {
                                str = WalletFormView.aX(str, selectionStart - (length - this.Rwv), selectionStart);
                                z = true;
                            }
                        }
                        if (z) {
                            WalletFormView.a(WalletFormView.this.Rwe, obj, str);
                        }
                        AppMethodBeat.o(73145);
                        return;
                    }
                    WalletFormView.a(WalletFormView.this.Rwe, obj, indexOf, length);
                    AppMethodBeat.o(73145);
                }
            });
        }
        AppMethodBeat.o(73183);
    }

    public static String aX(String str, int i2, int i3) {
        AppMethodBeat.i(73184);
        if (str == null) {
            AppMethodBeat.o(73184);
            return "";
        } else if (i2 >= str.length() || i2 < 0) {
            AppMethodBeat.o(73184);
            return str;
        } else if (i3 >= str.length()) {
            String substring = str.substring(0, i2);
            AppMethodBeat.o(73184);
            return substring;
        } else {
            String str2 = Util.nullAs(str.substring(0, i2), "") + Util.nullAs(str.substring(i3, str.length()), "");
            AppMethodBeat.o(73184);
            return str2;
        }
    }

    public static void a(final EditText editText, String str, final String str2) {
        AppMethodBeat.i(73185);
        if (editText == null) {
            AppMethodBeat.o(73185);
        } else if (Util.isEqual(str, str2)) {
            AppMethodBeat.o(73185);
        } else {
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.wallet_core.ui.formview.WalletFormView.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(73146);
                    int selectionStart = editText.getSelectionStart();
                    int selectionEnd = editText.getSelectionEnd();
                    if (Util.isNullOrNil(str2)) {
                        editText.setText("");
                        AppMethodBeat.o(73146);
                        return;
                    }
                    editText.setText(str2);
                    EditText editText = editText;
                    if (selectionStart > str2.length()) {
                        selectionStart = str2.length();
                    }
                    if (selectionEnd > str2.length()) {
                        selectionEnd = str2.length();
                    }
                    editText.setSelection(selectionStart, selectionEnd);
                    AppMethodBeat.o(73146);
                }
            });
            AppMethodBeat.o(73185);
        }
    }

    public static boolean a(String str, EditText editText) {
        AppMethodBeat.i(73186);
        if (str == null || editText == null) {
            AppMethodBeat.o(73186);
            return false;
        }
        int i2 = 0;
        int i3 = -1;
        while (i2 < str.length() && '0' == str.charAt(i2)) {
            i3 = i2;
            i2++;
        }
        if (i3 == 0 && str.length() > 1 && str.charAt(i3 + 1) != '.') {
            a(editText, str, 0, i3 + 1);
            AppMethodBeat.o(73186);
            return true;
        } else if (i3 > 0) {
            if (str.length() == i3 + 1) {
                a(editText, str, 0, i3);
            } else if (str.charAt(i3 + 1) == '.') {
                a(editText, str, 0, i3);
            } else {
                a(editText, str, 0, i3 + 1);
            }
            AppMethodBeat.o(73186);
            return true;
        } else {
            AppMethodBeat.o(73186);
            return false;
        }
    }

    public static void a(EditText editText, String str, int i2, int i3) {
        AppMethodBeat.i(73187);
        if (editText == null) {
            AppMethodBeat.o(73187);
            return;
        }
        a(editText, str, aX(str, i2, i3));
        AppMethodBeat.o(73187);
    }

    public final void setKeyListener(KeyListener keyListener) {
        AppMethodBeat.i(73188);
        if (this.Rwe != null) {
            this.Rwe.setKeyListener(keyListener);
        }
        AppMethodBeat.o(73188);
    }

    public final boolean bql() {
        AppMethodBeat.i(73189);
        if (this.Rwe != null) {
            int inputLength = this.Rwe.getInputLength();
            if (inputLength > this.BFQ || inputLength < this.BFR) {
                AppMethodBeat.o(73189);
                return false;
            } else if (this.Rwi != null) {
                boolean a2 = this.Rwi.a(this);
                AppMethodBeat.o(73189);
                return a2;
            } else {
                AppMethodBeat.o(73189);
                return true;
            }
        } else {
            Log.e("MicroMsg.WalletFormView", "hy: no content edit text. true as default");
            AppMethodBeat.o(73189);
            return true;
        }
    }

    public final void eIj() {
        AppMethodBeat.i(73190);
        if (this.Rwe != null) {
            this.Rwe.ClearInput();
        }
        AppMethodBeat.o(73190);
    }

    public final void eIi() {
        AppMethodBeat.i(73191);
        if (this.Rwe != null) {
            this.Rwe.clearFocus();
        }
        AppMethodBeat.o(73191);
    }

    public final boolean hK(View view) {
        AppMethodBeat.i(73192);
        if (getVisibility() != 0) {
            if (view != null) {
                view.setVisibility(8);
            }
            AppMethodBeat.o(73192);
            return true;
        } else if (Util.isNullOrNil(getText())) {
            if (view != null) {
                view.setVisibility(4);
            }
            if (this.mPa != null) {
                this.mPa.setEnabled(true);
            }
            AppMethodBeat.o(73192);
            return false;
        } else if (bql()) {
            if (view != null) {
                view.setVisibility(4);
            }
            if (this.mPa != null) {
                this.mPa.setEnabled(true);
            }
            AppMethodBeat.o(73192);
            return true;
        } else {
            if (view != null) {
                view.setVisibility(0);
            }
            if (this.mPa != null) {
                this.mPa.setEnabled(false);
            }
            AppMethodBeat.o(73192);
            return false;
        }
    }

    public final void setFilters(InputFilter[] inputFilterArr) {
        AppMethodBeat.i(73193);
        if (this.Rwe != null) {
            this.Rwe.setFilters(inputFilterArr);
        }
        AppMethodBeat.o(73193);
    }

    public final int getInputLength() {
        AppMethodBeat.i(73194);
        if (this.Rwe != null) {
            int inputLength = this.Rwe.getInputLength();
            AppMethodBeat.o(73194);
            return inputLength;
        }
        AppMethodBeat.o(73194);
        return 0;
    }

    public final void hic() {
        AppMethodBeat.i(73195);
        if (this.Rwe != null) {
            this.Rwe.setFocusable(true);
            this.Rwe.requestFocus();
            ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this.Rwe, 0);
        }
        AppMethodBeat.o(73195);
    }

    public final void d(WalletBaseUI walletBaseUI) {
        AppMethodBeat.i(73196);
        if (this.Rwe != null) {
            this.Rwe.setFocusable(true);
            this.Rwe.requestFocus();
            walletBaseUI.showTenpayKB();
        }
        AppMethodBeat.o(73196);
    }

    public final void setIsSecretAnswer(boolean z) {
        AppMethodBeat.i(73197);
        if (this.Rwe != null) {
            this.Rwe.setIsSecurityAnswerFormat(z);
        }
        AppMethodBeat.o(73197);
    }

    public final void onFocusChange(View view, boolean z) {
        AppMethodBeat.i(73198);
        if (this.BFz != null) {
            this.BFz.onFocusChange(this, z);
        }
        if (this.Rwg != null) {
            this.Rwg.onInputValidChange(bql());
        }
        if (!bql()) {
            if (this.mPa != null) {
                this.mPa.setEnabled(false);
            }
        } else if (this.mPa != null) {
            this.mPa.setEnabled(true);
        }
        eIh();
        AppMethodBeat.o(73198);
    }

    public final void set3DesToView(String str) {
        AppMethodBeat.i(73199);
        if (this.Rwe != null) {
            this.Rwe.set3DesEncrptData(str);
        }
        AppMethodBeat.o(73199);
    }

    public final void setmWalletFormViewListener(c cVar) {
        this.Rwd = cVar;
    }
}
