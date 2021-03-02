package com.tencent.mm.plugin.recharge.ui.form;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import junit.framework.Assert;

public final class MallFormView extends LinearLayout implements View.OnFocusChangeListener {
    private View.OnClickListener BFA;
    private a BFB;
    private b BFC;
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
    public boolean BFZ;
    private TextView BFu;
    public EditText BFv;
    private WalletIconImageView BFw;
    private TextView BFx;
    private a BFy;
    private View.OnFocusChangeListener BFz;
    private TextView mPa;

    public interface a {
        void onInputValidChange(boolean z);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MallFormView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        boolean z = false;
        AppMethodBeat.i(67287);
        this.mPa = null;
        this.BFu = null;
        this.BFv = null;
        this.BFw = null;
        this.BFx = null;
        this.BFy = null;
        this.BFz = null;
        this.BFA = null;
        this.BFB = null;
        this.BFC = null;
        this.BFD = -1;
        this.BFE = "";
        this.BFF = 0;
        this.BFG = "";
        this.BFH = 8;
        this.BFI = -1;
        this.BFJ = 4;
        this.BFK = "";
        this.BFL = 8;
        this.BFM = "";
        this.BFN = 19;
        this.BFO = R.color.a2x;
        this.BFP = "";
        this.BFQ = Integer.MAX_VALUE;
        this.BFR = 1;
        this.BFS = R.drawable.aij;
        this.BFT = true;
        this.BFU = false;
        this.BFV = true;
        this.BFW = 1;
        this.BFX = 5;
        this.BFY = R.color.x5;
        this.BFZ = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C2011a.MallFormAttrs, i2, 0);
        this.BFD = obtainStyledAttributes.getResourceId(17, this.BFD);
        int resourceId = obtainStyledAttributes.getResourceId(23, 0);
        if (resourceId != 0) {
            this.BFE = context.getString(resourceId);
        }
        this.BFI = obtainStyledAttributes.getResourceId(14, this.BFI);
        int resourceId2 = obtainStyledAttributes.getResourceId(21, 0);
        if (resourceId2 != 0) {
            this.BFK = context.getString(resourceId2);
        }
        this.BFJ = obtainStyledAttributes.getInteger(15, this.BFJ);
        this.BFF = obtainStyledAttributes.getInteger(25, this.BFF);
        this.BFL = obtainStyledAttributes.getInteger(22, this.BFL);
        this.BFH = obtainStyledAttributes.getInteger(20, this.BFH);
        int resourceId3 = obtainStyledAttributes.getResourceId(18, 0);
        if (resourceId3 != 0) {
            this.BFG = context.getString(resourceId3);
        }
        int resourceId4 = obtainStyledAttributes.getResourceId(8, 0);
        if (resourceId4 != 0) {
            this.BFM = context.getString(resourceId4);
        }
        this.BFN = obtainStyledAttributes.getInteger(7, this.BFN);
        this.BFO = obtainStyledAttributes.getColor(13, this.BFO);
        int resourceId5 = obtainStyledAttributes.getResourceId(12, 0);
        if (resourceId5 != 0) {
            this.BFP = context.getString(resourceId5);
        }
        this.BFQ = obtainStyledAttributes.getInteger(10, this.BFQ);
        this.BFR = obtainStyledAttributes.getInteger(11, this.BFR);
        this.BFS = obtainStyledAttributes.getResourceId(2, this.BFS);
        this.BFT = obtainStyledAttributes.getBoolean(4, this.BFT);
        this.BFU = obtainStyledAttributes.getBoolean(3, this.BFU);
        this.BFV = obtainStyledAttributes.getBoolean(4, this.BFV);
        this.BFW = obtainStyledAttributes.getInteger(0, this.BFW);
        this.BFX = obtainStyledAttributes.getInteger(1, this.BFX);
        this.BFY = obtainStyledAttributes.getInteger(9, this.BFY);
        obtainStyledAttributes.recycle();
        Assert.assertTrue(this.BFD > 0 ? true : z);
        setOrientation(1);
        inflate(context, this.BFD, this);
        this.mPa = (TextView) findViewById(R.id.f_j);
        this.BFu = (TextView) findViewById(R.id.f8z);
        this.BFv = (EditText) findViewById(R.id.f6x);
        this.BFw = (WalletIconImageView) findViewById(R.id.f79);
        this.BFx = (TextView) findViewById(R.id.f_i);
        AppMethodBeat.o(67287);
    }

    public MallFormView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public final EditText getContentEditText() {
        return this.BFv;
    }

    public final void setImeOptions(int i2) {
        AppMethodBeat.i(67288);
        if (this.BFv != null) {
            this.BFv.setImeOptions(i2);
        }
        AppMethodBeat.o(67288);
    }

    public final void setInputType(int i2) {
        AppMethodBeat.i(67289);
        if (this.BFv != null) {
            this.BFv.setInputType(i2);
        }
        AppMethodBeat.o(67289);
    }

    public final void setText(String str) {
        AppMethodBeat.i(67290);
        if (this.BFv != null) {
            this.BFv.setText(str);
            this.BFv.setSelection(getInputLength());
        }
        AppMethodBeat.o(67290);
    }

    public final void eIh() {
        AppMethodBeat.i(67291);
        if (this.BFw != null && !Util.isNullOrNil(getText()) && this.BFv != null && this.BFv.isEnabled() && this.BFv.isClickable() && this.BFv.isFocusable() && this.BFv.isFocused()) {
            this.BFw.setToClearState(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.recharge.ui.form.MallFormView.AnonymousClass2 */

                public final void onClick(View view) {
                    AppMethodBeat.i(67286);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/form/MallFormView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    MallFormView.this.eIj();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/form/MallFormView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(67286);
                }
            });
            AppMethodBeat.o(67291);
        } else if (this.BFw != null) {
            this.BFw.gsP();
            AppMethodBeat.o(67291);
        } else {
            Log.v("MicroMsg.WalletFormView", "hy: no info iv");
            AppMethodBeat.o(67291);
        }
    }

    public final a getInputValidChangeListener() {
        return this.BFy;
    }

    /* access modifiers changed from: protected */
    public final void onAttachedToWindow() {
        AppMethodBeat.i(67292);
        super.onAttachedToWindow();
        AppMethodBeat.o(67292);
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        AppMethodBeat.i(67293);
        super.onDetachedFromWindow();
        AppMethodBeat.o(67293);
    }

    /* access modifiers changed from: protected */
    public final void onFinishInflate() {
        AppMethodBeat.i(67294);
        super.onFinishInflate();
        if (getTitleTv() != null) {
            getTitleTv().setText(this.BFE);
            getTitleTv().setVisibility(this.BFF);
        }
        if (getPrefilledTv() != null) {
            getPrefilledTv().setText(this.BFG);
            getPrefilledTv().setVisibility(this.BFH);
        }
        if (getInfoIv() != null) {
            getInfoIv().setImageResource(this.BFI);
            getInfoIv().setVisibility(this.BFJ);
        }
        if (getTipsTv() != null) {
            getTipsTv().setText(this.BFK);
            getTipsTv().setVisibility(this.BFL);
        }
        getContext();
        if (this.BFv != null) {
            this.BFv.setHint(this.BFM);
            this.BFv.setGravity(this.BFN);
            this.BFv.setTextColor(this.BFO);
            setText(this.BFP);
            this.BFv.setBackgroundResource(this.BFS);
            this.BFv.setEnabled(this.BFT);
            this.BFv.setFocusable(this.BFV);
            this.BFv.setClickable(this.BFU);
            this.BFv.setHintTextColor(this.BFY);
            setImeOptions(this.BFX);
            setInputType(this.BFW);
            this.BFv.addTextChangedListener(new TextWatcher() {
                /* class com.tencent.mm.plugin.recharge.ui.form.MallFormView.AnonymousClass1 */
                private boolean BGa = false;

                public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    AppMethodBeat.i(67285);
                    if (MallFormView.this.bql() != this.BGa) {
                        if (MallFormView.this.BFy != null) {
                            MallFormView.this.BFy.onInputValidChange(MallFormView.this.bql());
                        }
                        this.BGa = MallFormView.this.bql();
                    }
                    MallFormView.this.eIh();
                    AppMethodBeat.o(67285);
                }

                public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                public final void afterTextChanged(Editable editable) {
                }
            });
            this.BFv.setOnFocusChangeListener(this);
        }
        eIh();
        if (this.BFv != null) {
            if (this.BFW == 2) {
                this.BFv.setKeyListener(new NumberKeyListener() {
                    /* class com.tencent.mm.plugin.recharge.ui.form.MallFormView.AnonymousClass3 */

                    public final int getInputType() {
                        return 3;
                    }

                    /* access modifiers changed from: protected */
                    public final char[] getAcceptedChars() {
                        return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
                    }
                });
            } else if (this.BFW == 4) {
                this.BFv.setKeyListener(new NumberKeyListener() {
                    /* class com.tencent.mm.plugin.recharge.ui.form.MallFormView.AnonymousClass4 */

                    public final int getInputType() {
                        return 1;
                    }

                    /* access modifiers changed from: protected */
                    public final char[] getAcceptedChars() {
                        return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'x', 'X'};
                    }
                });
            } else if (this.BFW == 128) {
                this.BFv.setTransformationMethod(PasswordTransformationMethod.getInstance());
                this.BFv.setKeyListener(new NumberKeyListener() {
                    /* class com.tencent.mm.plugin.recharge.ui.form.MallFormView.AnonymousClass5 */

                    public final int getInputType() {
                        return 18;
                    }

                    /* access modifiers changed from: protected */
                    public final char[] getAcceptedChars() {
                        return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
                    }
                });
                this.BFv.setRawInputType(18);
            } else if (this.BFW == 3) {
                this.BFv.setKeyListener(new NumberKeyListener() {
                    /* class com.tencent.mm.plugin.recharge.ui.form.MallFormView.AnonymousClass6 */

                    public final int getInputType() {
                        return 3;
                    }

                    /* access modifiers changed from: protected */
                    public final char[] getAcceptedChars() {
                        return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '-'};
                    }
                });
            } else {
                this.BFv.setInputType(this.BFW);
            }
            if (this.BFQ != -1) {
                this.BFv.setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.BFQ)});
            }
        }
        AppMethodBeat.o(67294);
    }

    public final void setHint(String str) {
        AppMethodBeat.i(67295);
        if (this.BFv != null) {
            this.BFv.setHint(str);
        }
        AppMethodBeat.o(67295);
    }

    public final void setOnEditorActionListener(TextView.OnEditorActionListener onEditorActionListener) {
        AppMethodBeat.i(67296);
        this.BFv.setOnEditorActionListener(onEditorActionListener);
        AppMethodBeat.o(67296);
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"WrongCall"})
    public final void onMeasure(int i2, int i3) {
        AppMethodBeat.i(67297);
        if (this.BFB == null || !this.BFB.eIe()) {
            super.onMeasure(i2, i3);
        }
        AppMethodBeat.o(67297);
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(67298);
        if (this.BFB != null && this.BFB.eIf()) {
            AppMethodBeat.o(67298);
            return true;
        } else if (this.BFv != null && c(this.BFv, motionEvent) && !this.BFv.isClickable()) {
            Log.d("MicroMsg.WalletFormView", "hy: click on content but content is not clickable. whole view perform click");
            AppMethodBeat.o(67298);
            return true;
        } else if (!c(this.BFw, motionEvent) || motionEvent.getAction() != 1) {
            AppMethodBeat.o(67298);
            return false;
        } else {
            Log.d("MicroMsg.WalletFormView", "hy: click on info iv");
            this.BFw.performClick();
            AppMethodBeat.o(67298);
            return true;
        }
    }

    private boolean c(View view, MotionEvent motionEvent) {
        AppMethodBeat.i(67299);
        if (view == null || view.getVisibility() != 0) {
            AppMethodBeat.o(67299);
            return false;
        } else if (eJ(view).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            AppMethodBeat.o(67299);
            return true;
        } else {
            AppMethodBeat.o(67299);
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
        AppMethodBeat.i(67300);
        if (view != null) {
            Rect rect = new Rect();
            view.getHitRect(rect);
            Rect g2 = g(view, rect);
            AppMethodBeat.o(67300);
            return g2;
        }
        AppMethodBeat.o(67300);
        return null;
    }

    public final void eIi() {
        AppMethodBeat.i(67301);
        Log.d("MicroMsg.WalletFormView", "shouldClearFocus: %s", Boolean.valueOf(this.BFZ));
        if (this.BFZ) {
            getContentEditText().clearFocus();
            AppMethodBeat.o(67301);
            return;
        }
        this.BFZ = true;
        AppMethodBeat.o(67301);
    }

    public final TextView getTitleTv() {
        return this.mPa;
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
        AppMethodBeat.i(67302);
        if (this.BFv != null) {
            this.BFv.setSelection(i2);
        }
        AppMethodBeat.o(67302);
    }

    public final a getEventDelegate() {
        return this.BFB;
    }

    public final b getLogicDelegate() {
        return this.BFC;
    }

    public final String getText() {
        AppMethodBeat.i(67303);
        if (this.BFv != null) {
            String obj = this.BFv.getText().toString();
            if (this.BFC == null || !this.BFC.eIg()) {
                AppMethodBeat.o(67303);
                return obj;
            }
            String aKW = this.BFC.aKW(obj);
            AppMethodBeat.o(67303);
            return aKW;
        }
        Log.e("MicroMsg.WalletFormView", "hy: no content et. return nil");
        AppMethodBeat.o(67303);
        return "";
    }

    public final KeyListener getKeyListener() {
        AppMethodBeat.i(67304);
        if (this.BFv != null) {
            KeyListener keyListener = this.BFv.getKeyListener();
            AppMethodBeat.o(67304);
            return keyListener;
        }
        Log.w("MicroMsg.WalletFormView", "hy: no content et");
        AppMethodBeat.o(67304);
        return null;
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

    public final void setOnClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(67305);
        super.setOnClickListener(onClickListener);
        AppMethodBeat.o(67305);
    }

    public final void setOnInfoIvClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(67306);
        this.BFA = onClickListener;
        if (getInfoIv() != null) {
            getInfoIv().setOnClickListener(this.BFA);
        }
        AppMethodBeat.o(67306);
    }

    public final void setOnInputValidChangeListener(a aVar) {
        this.BFy = aVar;
    }

    public final void setOnFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.BFz = onFocusChangeListener;
    }

    public final void setEventDelegate(a aVar) {
        this.BFB = aVar;
    }

    public final void setLogicDelegate(b bVar) {
        this.BFC = bVar;
    }

    public final void setKeyListener(KeyListener keyListener) {
        AppMethodBeat.i(67307);
        if (this.BFv != null) {
            this.BFv.setKeyListener(keyListener);
        }
        AppMethodBeat.o(67307);
    }

    public final boolean bql() {
        AppMethodBeat.i(67308);
        if (this.BFv != null) {
            int length = this.BFv.getText() == null ? 0 : this.BFv.getText().length();
            if (length > this.BFQ || length < this.BFR) {
                AppMethodBeat.o(67308);
                return false;
            } else if (this.BFC != null) {
                boolean a2 = this.BFC.a(this);
                AppMethodBeat.o(67308);
                return a2;
            } else {
                AppMethodBeat.o(67308);
                return true;
            }
        } else {
            Log.e("MicroMsg.WalletFormView", "hy: no content edit text. true as default");
            AppMethodBeat.o(67308);
            return true;
        }
    }

    public final void eIj() {
        AppMethodBeat.i(67309);
        if (this.BFv != null) {
            this.BFv.setText("");
        }
        AppMethodBeat.o(67309);
    }

    public final void setFilters(InputFilter[] inputFilterArr) {
        AppMethodBeat.i(67310);
        if (this.BFv != null) {
            this.BFv.setFilters(inputFilterArr);
        }
        AppMethodBeat.o(67310);
    }

    public final int getInputLength() {
        AppMethodBeat.i(67311);
        if (this.BFv != null) {
            int length = this.BFv.getText().length();
            AppMethodBeat.o(67311);
            return length;
        }
        AppMethodBeat.o(67311);
        return 0;
    }

    public final void onFocusChange(View view, boolean z) {
        AppMethodBeat.i(67312);
        if (this.BFz != null) {
            this.BFz.onFocusChange(this, z);
        }
        if (!bql()) {
            if (this.mPa != null) {
                this.mPa.setEnabled(false);
            }
        } else if (this.mPa != null) {
            this.mPa.setEnabled(true);
        }
        eIh();
        AppMethodBeat.o(67312);
    }
}
