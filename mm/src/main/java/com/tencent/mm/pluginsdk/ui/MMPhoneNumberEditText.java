package com.tencent.mm.pluginsdk.ui;

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
import com.tencent.mm.ce.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.at;

public class MMPhoneNumberEditText extends EditText {
    private View.OnFocusChangeListener BFz = null;
    public boolean Kcn = false;
    public Drawable Kco;
    private a Kcp;
    public boolean Kcq;
    private boolean Kcr = false;
    public String oxJ = "";
    int qRC = 0;

    public interface a {
        void f(MMPhoneNumberEditText mMPhoneNumberEditText);

        void g(MMPhoneNumberEditText mMPhoneNumberEditText);

        void goO();

        void goP();
    }

    static /* synthetic */ void a(MMPhoneNumberEditText mMPhoneNumberEditText) {
        AppMethodBeat.i(31207);
        mMPhoneNumberEditText.goN();
        AppMethodBeat.o(31207);
    }

    static /* synthetic */ void c(MMPhoneNumberEditText mMPhoneNumberEditText) {
        AppMethodBeat.i(31208);
        mMPhoneNumberEditText.goL();
        AppMethodBeat.o(31208);
    }

    public MMPhoneNumberEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(31197);
        init();
        AppMethodBeat.o(31197);
    }

    public MMPhoneNumberEditText(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(31198);
        init();
        AppMethodBeat.o(31198);
    }

    public final void goK() {
        AppMethodBeat.i(31199);
        this.Kcq = true;
        this.Kco = getResources().getDrawable(R.raw.info_icon);
        this.Kco.setBounds(0, 0, this.Kco.getIntrinsicWidth(), this.Kco.getIntrinsicHeight());
        setFocusable(false);
        goM();
        AppMethodBeat.o(31199);
    }

    private void init() {
        AppMethodBeat.i(31200);
        this.Kco = at.aN(getContext(), R.attr.l1);
        this.Kco.setBounds(0, 0, this.Kco.getIntrinsicWidth(), this.Kco.getIntrinsicHeight());
        Log.d("MicroMsg.MMClearEditText", "imgX width %d height %d", Integer.valueOf(this.Kco.getIntrinsicWidth()), Integer.valueOf(this.Kco.getIntrinsicHeight()));
        goL();
        setHeight(this.Kco.getIntrinsicHeight() + (getResources().getDimensionPixelSize(R.dimen.iu) * 5));
        clearFocus();
        setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.pluginsdk.ui.MMPhoneNumberEditText.AnonymousClass1 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(31193);
                MMPhoneNumberEditText mMPhoneNumberEditText = MMPhoneNumberEditText.this;
                if (mMPhoneNumberEditText.getCompoundDrawables()[2] == null) {
                    AppMethodBeat.o(31193);
                } else {
                    if (motionEvent.getAction() == 1 && motionEvent.getX() > ((float) ((mMPhoneNumberEditText.getWidth() - mMPhoneNumberEditText.getPaddingRight()) - MMPhoneNumberEditText.this.Kco.getIntrinsicWidth()))) {
                        if (mMPhoneNumberEditText.isFocused()) {
                            mMPhoneNumberEditText.setText("");
                            MMPhoneNumberEditText.a(mMPhoneNumberEditText);
                        } else if (MMPhoneNumberEditText.this.Kcp != null) {
                            MMPhoneNumberEditText.this.Kcp.f(mMPhoneNumberEditText);
                        }
                    }
                    AppMethodBeat.o(31193);
                }
                return false;
            }
        });
        addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.pluginsdk.ui.MMPhoneNumberEditText.AnonymousClass2 */

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                AppMethodBeat.i(31194);
                MMPhoneNumberEditText.c(MMPhoneNumberEditText.this);
                if (!charSequence.toString().equals("") || MMPhoneNumberEditText.this.Kcr) {
                    if (charSequence.toString().equals("") || !MMPhoneNumberEditText.this.Kcr) {
                        if (MMPhoneNumberEditText.this.Kcp != null && MMPhoneNumberEditText.this.isFocused()) {
                            MMPhoneNumberEditText.this.Kcp.goP();
                        }
                    } else if (MMPhoneNumberEditText.this.Kcp != null && MMPhoneNumberEditText.this.isFocused()) {
                        MMPhoneNumberEditText.this.Kcp.goO();
                        AppMethodBeat.o(31194);
                        return;
                    }
                } else if (MMPhoneNumberEditText.this.Kcp != null && MMPhoneNumberEditText.this.isFocused()) {
                    MMPhoneNumberEditText.this.Kcp.g(MMPhoneNumberEditText.this);
                    AppMethodBeat.o(31194);
                    return;
                }
                AppMethodBeat.o(31194);
            }

            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                AppMethodBeat.i(31195);
                if (Util.isNullOrNil(charSequence.toString())) {
                    MMPhoneNumberEditText.this.Kcr = true;
                    AppMethodBeat.o(31195);
                    return;
                }
                MMPhoneNumberEditText.this.Kcr = false;
                AppMethodBeat.o(31195);
            }
        });
        super.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            /* class com.tencent.mm.pluginsdk.ui.MMPhoneNumberEditText.AnonymousClass3 */

            public final void onFocusChange(View view, boolean z) {
                AppMethodBeat.i(31196);
                if (MMPhoneNumberEditText.this.BFz != null) {
                    MMPhoneNumberEditText.this.BFz.onFocusChange(view, z);
                }
                MMPhoneNumberEditText.c(MMPhoneNumberEditText.this);
                AppMethodBeat.o(31196);
            }
        });
        AppMethodBeat.o(31200);
    }

    public boolean onTextContextMenuItem(int i2) {
        AppMethodBeat.i(31201);
        boolean onTextContextMenuItem = super.onTextContextMenuItem(i2);
        if (i2 == 16908322) {
            this.qRC = 0;
            String obj = getText().toString();
            try {
                beu(obj);
            } catch (IndexOutOfBoundsException e2) {
                Log.e("MicroMsg.MMClearEditText", "!!MMClearEditText Exception %d", Integer.valueOf(this.qRC));
                if (this.qRC < 3) {
                    this.qRC++;
                    beu(" ".concat(String.valueOf(obj)));
                } else {
                    Log.e("MicroMsg.MMClearEditText", "!!MMClearEditText, IndexOutOfBoundsException cannot fix");
                }
            }
        }
        AppMethodBeat.o(31201);
        return onTextContextMenuItem;
    }

    private void beu(String str) {
        AppMethodBeat.i(31202);
        int selectionStart = getSelectionStart();
        setText(g.gxZ().a(getContext(), str, getTextSize()));
        int length = getText().length() - str.length();
        if (length > 0) {
            int i2 = selectionStart + length;
            if (i2 <= getText().length()) {
                setSelection(i2);
            }
            AppMethodBeat.o(31202);
            return;
        }
        setSelection(selectionStart);
        AppMethodBeat.o(31202);
    }

    public void setOnFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.BFz = onFocusChangeListener;
    }

    private void goL() {
        AppMethodBeat.i(31203);
        if (getText().toString().equals("")) {
            goN();
            AppMethodBeat.o(31203);
            return;
        }
        goM();
        AppMethodBeat.o(31203);
    }

    private void goM() {
        AppMethodBeat.i(31204);
        setCompoundDrawablesWithIntrinsicBounds(getCompoundDrawables()[0], getCompoundDrawables()[1], this.Kco, getCompoundDrawables()[3]);
        AppMethodBeat.o(31204);
    }

    private void goN() {
        AppMethodBeat.i(31205);
        setCompoundDrawablesWithIntrinsicBounds(getCompoundDrawables()[0], getCompoundDrawables()[1], (Drawable) null, getCompoundDrawables()[3]);
        AppMethodBeat.o(31205);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        AppMethodBeat.i(31206);
        if (!(parcelable instanceof TextView.SavedState)) {
            super.onRestoreInstanceState(parcelable);
            AppMethodBeat.o(31206);
            return;
        }
        if (!this.Kcn) {
            parcelable = View.BaseSavedState.EMPTY_STATE;
        }
        super.onRestoreInstanceState(parcelable);
        AppMethodBeat.o(31206);
    }

    public void setCallback(a aVar) {
        this.Kcp = aVar;
    }
}
