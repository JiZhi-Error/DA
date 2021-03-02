package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AutoCompleteTextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Util;

public class MMAutoCompleteTextView extends AutoCompleteTextView {
    final Drawable Kco = getResources().getDrawable(R.drawable.a_5);
    private a OPw;

    static /* synthetic */ void a(MMAutoCompleteTextView mMAutoCompleteTextView) {
        AppMethodBeat.i(141845);
        mMAutoCompleteTextView.goN();
        AppMethodBeat.o(141845);
    }

    static /* synthetic */ void b(MMAutoCompleteTextView mMAutoCompleteTextView) {
        AppMethodBeat.i(141846);
        mMAutoCompleteTextView.goL();
        AppMethodBeat.o(141846);
    }

    public MMAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(141840);
        this.Kco.setBounds(0, 0, this.Kco.getIntrinsicWidth(), this.Kco.getIntrinsicHeight());
        goL();
        setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.ui.base.MMAutoCompleteTextView.AnonymousClass1 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(141836);
                MMAutoCompleteTextView mMAutoCompleteTextView = MMAutoCompleteTextView.this;
                if (mMAutoCompleteTextView.getCompoundDrawables()[2] == null) {
                    AppMethodBeat.o(141836);
                } else if (motionEvent.getAction() != 1) {
                    AppMethodBeat.o(141836);
                } else {
                    if (motionEvent.getX() > ((float) ((mMAutoCompleteTextView.getWidth() - mMAutoCompleteTextView.getPaddingRight()) - MMAutoCompleteTextView.this.Kco.getIntrinsicWidth()))) {
                        mMAutoCompleteTextView.setText("");
                        MMAutoCompleteTextView.a(MMAutoCompleteTextView.this);
                    }
                    AppMethodBeat.o(141836);
                }
                return false;
            }
        });
        addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.ui.base.MMAutoCompleteTextView.AnonymousClass2 */

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                AppMethodBeat.i(141837);
                MMAutoCompleteTextView.b(MMAutoCompleteTextView.this);
                AppMethodBeat.o(141837);
            }

            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        });
        setOnFocusChangeListener(new View.OnFocusChangeListener() {
            /* class com.tencent.mm.ui.base.MMAutoCompleteTextView.AnonymousClass3 */

            public final void onFocusChange(View view, boolean z) {
                AppMethodBeat.i(141838);
                MMAutoCompleteTextView.b(MMAutoCompleteTextView.this);
                AppMethodBeat.o(141838);
            }
        });
        AppMethodBeat.o(141840);
    }

    private void goL() {
        AppMethodBeat.i(141841);
        if (getText().toString().equals("") || !isFocused()) {
            goN();
            AppMethodBeat.o(141841);
            return;
        }
        goM();
        AppMethodBeat.o(141841);
    }

    private void goM() {
        AppMethodBeat.i(141842);
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.Kco, getCompoundDrawables()[3]);
        AppMethodBeat.o(141842);
    }

    private void goN() {
        AppMethodBeat.i(141843);
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], null, getCompoundDrawables()[3]);
        AppMethodBeat.o(141843);
    }

    public void setSpilter(String str) {
        AppMethodBeat.i(141844);
        if (!Util.isNullOrNil(str)) {
            this.OPw = new a(str);
            addTextChangedListener(this.OPw);
        }
        AppMethodBeat.o(141844);
    }

    class a implements TextWatcher {
        private String OPy;

        public a(String str) {
            this.OPy = str;
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.i(141839);
            if (editable.toString().endsWith(this.OPy)) {
                MMAutoCompleteTextView.this.showDropDown();
            }
            AppMethodBeat.o(141839);
        }
    }
}
