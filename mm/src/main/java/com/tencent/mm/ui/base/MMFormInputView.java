package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ck.a;
import com.tencent.mm.ui.as;

public class MMFormInputView extends LinearLayout {
    private View.OnFocusChangeListener heD;
    private TextView jVO;
    private int layout;
    private Context mContext;
    private EditText nBD;
    private int nBF;
    private int nBG;
    private int[] nBK;

    public MMFormInputView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        AppMethodBeat.i(159168);
        this.mContext = null;
        this.nBF = -1;
        this.nBG = -1;
        this.layout = -1;
        this.heD = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C0296a.FormItemView, i2, 0);
        this.nBG = obtainStyledAttributes.getResourceId(1, -1);
        this.nBF = obtainStyledAttributes.getResourceId(3, -1);
        this.layout = obtainStyledAttributes.getResourceId(2, this.layout);
        obtainStyledAttributes.recycle();
        inflate(context, this.layout, this);
        this.mContext = context;
        AppMethodBeat.o(159168);
    }

    public MMFormInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public void setFocusListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.heD = onFocusChangeListener;
    }

    public void setTitle(String str) {
        AppMethodBeat.i(159170);
        if (this.jVO != null) {
            this.jVO.setText(str);
            AppMethodBeat.o(159170);
            return;
        }
        as.e("MicroMsg.MMFormInputView", "titleTV is null!", new Object[0]);
        AppMethodBeat.o(159170);
    }

    public void setHint(String str) {
        AppMethodBeat.i(159171);
        if (this.nBD != null) {
            this.nBD.setHint(str);
            AppMethodBeat.o(159171);
            return;
        }
        as.e("MicroMsg.MMFormInputView", "contentET is null!", new Object[0]);
        AppMethodBeat.o(159171);
    }

    public void setTitle(int i2) {
        AppMethodBeat.i(159172);
        if (this.jVO != null) {
            this.jVO.setText(i2);
            AppMethodBeat.o(159172);
            return;
        }
        as.e("MicroMsg.MMFormInputView", "titleTV is null!", new Object[0]);
        AppMethodBeat.o(159172);
    }

    public void setHint(int i2) {
        AppMethodBeat.i(159173);
        if (this.nBD != null) {
            this.nBD.setHint(i2);
            AppMethodBeat.o(159173);
            return;
        }
        as.e("MicroMsg.MMFormInputView", "contentET is null!", new Object[0]);
        AppMethodBeat.o(159173);
    }

    public void setText(String str) {
        AppMethodBeat.i(159174);
        if (this.nBD != null) {
            this.nBD.setText(str);
            AppMethodBeat.o(159174);
            return;
        }
        as.e("MicroMsg.MMFormInputView", "contentET is null!", new Object[0]);
        AppMethodBeat.o(159174);
    }

    public void setImeOption(int i2) {
        AppMethodBeat.i(159175);
        if (this.nBD != null) {
            this.nBD.setImeOptions(i2);
            AppMethodBeat.o(159175);
            return;
        }
        as.e("MicroMsg.MMFormInputView", "contentET is null!", new Object[0]);
        AppMethodBeat.o(159175);
    }

    public void setInputType(int i2) {
        AppMethodBeat.i(159176);
        if (this.nBD != null) {
            this.nBD.setInputType(i2);
            AppMethodBeat.o(159176);
            return;
        }
        as.e("MicroMsg.MMFormInputView", "contentET is null!", new Object[0]);
        AppMethodBeat.o(159176);
    }

    public final void addTextChangedListener(TextWatcher textWatcher) {
        AppMethodBeat.i(159177);
        if (textWatcher == null || this.nBD == null) {
            as.w("MicroMsg.MMFormInputView", "watcher : %s, contentET : %s", textWatcher, this.nBD);
            AppMethodBeat.o(159177);
            return;
        }
        this.nBD.addTextChangedListener(textWatcher);
        AppMethodBeat.o(159177);
    }

    public Editable getText() {
        AppMethodBeat.i(159178);
        if (this.nBD != null) {
            Editable text = this.nBD.getText();
            AppMethodBeat.o(159178);
            return text;
        }
        as.e("MicroMsg.MMFormInputView", "contentET is null!", new Object[0]);
        AppMethodBeat.o(159178);
        return null;
    }

    public EditText getContentEditText() {
        return this.nBD;
    }

    public TextView getTitleTextView() {
        return this.jVO;
    }

    public void onFinishInflate() {
        AppMethodBeat.i(159169);
        this.jVO = (TextView) findViewById(R.id.ipm);
        this.nBD = (EditText) findViewById(R.id.bxz);
        if (this.jVO == null || this.nBD == null) {
            as.w("MicroMsg.MMFormInputView", "titleTV : %s, contentET : %s", this.jVO, this.nBD);
        } else {
            if (this.nBF != -1) {
                this.jVO.setText(this.nBF);
            }
            if (this.nBG != -1) {
                this.nBD.setHint(this.nBG);
            }
        }
        if (this.nBD != null) {
            this.nBD.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                /* class com.tencent.mm.ui.base.MMFormInputView.AnonymousClass1 */

                public final void onFocusChange(View view, boolean z) {
                    AppMethodBeat.i(159167);
                    if (view == MMFormInputView.this.nBD) {
                        MMFormInputView.b(MMFormInputView.this);
                        if (z) {
                            MMFormInputView.this.setBackgroundResource(R.drawable.ca2);
                        } else {
                            MMFormInputView.this.setBackgroundResource(R.drawable.ca3);
                        }
                        MMFormInputView.c(MMFormInputView.this);
                    }
                    if (MMFormInputView.this.heD != null) {
                        MMFormInputView.this.heD.onFocusChange(view, z);
                    }
                    AppMethodBeat.o(159167);
                }
            });
        }
        AppMethodBeat.o(159169);
    }

    static /* synthetic */ void b(MMFormInputView mMFormInputView) {
        AppMethodBeat.i(159179);
        mMFormInputView.nBK = new int[]{mMFormInputView.getPaddingLeft(), mMFormInputView.getPaddingTop(), mMFormInputView.getPaddingRight(), mMFormInputView.getPaddingBottom()};
        AppMethodBeat.o(159179);
    }

    static /* synthetic */ void c(MMFormInputView mMFormInputView) {
        AppMethodBeat.i(159180);
        if (mMFormInputView.nBK != null) {
            mMFormInputView.setPadding(mMFormInputView.nBK[0], mMFormInputView.nBK[1], mMFormInputView.nBK[2], mMFormInputView.nBK[3]);
        }
        AppMethodBeat.o(159180);
    }
}
