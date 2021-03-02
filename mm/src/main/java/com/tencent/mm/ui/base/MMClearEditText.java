package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.as;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.g.c.b;

public class MMClearEditText extends EditText {
    private View.OnFocusChangeListener BFz = null;
    private View.OnTouchListener HeV = new View.OnTouchListener() {
        /* class com.tencent.mm.ui.base.MMClearEditText.AnonymousClass3 */

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(159154);
            MMClearEditText mMClearEditText = MMClearEditText.this;
            if (mMClearEditText.getCompoundDrawables()[2] == null) {
                AppMethodBeat.o(159154);
            } else if (motionEvent.getAction() != 1) {
                AppMethodBeat.o(159154);
            } else {
                if (motionEvent.getX() > ((float) ((mMClearEditText.getWidth() - mMClearEditText.getPaddingRight()) - MMClearEditText.this.Kco.getIntrinsicWidth()))) {
                    mMClearEditText.setText("");
                    MMClearEditText.c(MMClearEditText.this);
                }
                AppMethodBeat.o(159154);
            }
            return false;
        }
    };
    public boolean Kcn = false;
    Drawable Kco = at.aN(getContext(), R.attr.l1);
    private boolean OPN = false;
    public String oxJ = "";
    int qRC = 0;

    static /* synthetic */ void a(MMClearEditText mMClearEditText) {
        AppMethodBeat.i(159164);
        mMClearEditText.goL();
        AppMethodBeat.o(159164);
    }

    static /* synthetic */ void c(MMClearEditText mMClearEditText) {
        AppMethodBeat.i(159165);
        mMClearEditText.goN();
        AppMethodBeat.o(159165);
    }

    public MMClearEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(159155);
        cMn();
        AppMethodBeat.o(159155);
    }

    public MMClearEditText(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(159156);
        cMn();
        AppMethodBeat.o(159156);
    }

    private void cMn() {
        AppMethodBeat.i(159157);
        if (this.Kco == null) {
            this.Kco = at.aN(getContext(), R.attr.l1);
        }
        this.Kco.setBounds(0, 0, this.Kco.getIntrinsicWidth(), this.Kco.getIntrinsicHeight());
        as.d("MicroMsg.MMClearEditText", "imgX width %d height %d", Integer.valueOf(this.Kco.getIntrinsicWidth()), Integer.valueOf(this.Kco.getIntrinsicHeight()));
        goL();
        setHeight(this.Kco.getIntrinsicHeight() + (getResources().getDimensionPixelSize(R.dimen.iu) * 5));
        setOnTouchListener(this.HeV);
        addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.ui.base.MMClearEditText.AnonymousClass1 */

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                AppMethodBeat.i(159152);
                MMClearEditText.a(MMClearEditText.this);
                AppMethodBeat.o(159152);
            }

            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        });
        super.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            /* class com.tencent.mm.ui.base.MMClearEditText.AnonymousClass2 */

            public final void onFocusChange(View view, boolean z) {
                AppMethodBeat.i(159153);
                if (MMClearEditText.this.BFz != null) {
                    MMClearEditText.this.BFz.onFocusChange(view, z);
                }
                MMClearEditText.a(MMClearEditText.this);
                AppMethodBeat.o(159153);
            }
        });
        AppMethodBeat.o(159157);
    }

    public boolean onTextContextMenuItem(int i2) {
        AppMethodBeat.i(159158);
        boolean onTextContextMenuItem = super.onTextContextMenuItem(i2);
        if (i2 == 16908322) {
            this.qRC = 0;
            String obj = getText().toString();
            try {
                beu(obj);
            } catch (IndexOutOfBoundsException e2) {
                as.e("MicroMsg.MMClearEditText", "!!MMClearEditText Exception %d", Integer.valueOf(this.qRC));
                if (this.qRC < 3) {
                    this.qRC++;
                    beu(" ".concat(String.valueOf(obj)));
                } else {
                    as.e("MicroMsg.MMClearEditText", "!!MMClearEditText, IndexOutOfBoundsException cannot fix", new Object[0]);
                }
            }
        }
        AppMethodBeat.o(159158);
        return onTextContextMenuItem;
    }

    private void beu(String str) {
        AppMethodBeat.i(159159);
        int selectionStart = getSelectionStart();
        setText(b.c(getContext(), str, getTextSize()));
        int length = getText().length() - str.length();
        if (length > 0) {
            int i2 = selectionStart + length;
            if (i2 <= getText().length()) {
                setSelection(i2);
            }
            AppMethodBeat.o(159159);
            return;
        }
        setSelection(selectionStart);
        AppMethodBeat.o(159159);
    }

    public void setOnFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.BFz = onFocusChangeListener;
    }

    public View.OnTouchListener getDefaultOnTouchListener() {
        return this.HeV;
    }

    private void goL() {
        AppMethodBeat.i(159160);
        if (getText().toString().equals("") || !isFocused()) {
            goN();
            AppMethodBeat.o(159160);
            return;
        }
        goM();
        AppMethodBeat.o(159160);
    }

    private void goM() {
        AppMethodBeat.i(159161);
        if (!this.OPN) {
            setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.Kco, getCompoundDrawables()[3]);
        }
        AppMethodBeat.o(159161);
    }

    private void goN() {
        AppMethodBeat.i(159162);
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], null, getCompoundDrawables()[3]);
        AppMethodBeat.o(159162);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        AppMethodBeat.i(159163);
        if (!(parcelable instanceof TextView.SavedState)) {
            super.onRestoreInstanceState(parcelable);
            AppMethodBeat.o(159163);
            return;
        }
        if (!this.Kcn) {
            parcelable = View.BaseSavedState.EMPTY_STATE;
        }
        super.onRestoreInstanceState(parcelable);
        AppMethodBeat.o(159163);
    }
}
