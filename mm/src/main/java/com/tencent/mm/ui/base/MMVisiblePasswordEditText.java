package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;

public class MMVisiblePasswordEditText extends EditText {
    final Drawable OUB = getResources().getDrawable(R.raw.login_showpassword_icon);
    final Drawable OUC = getResources().getDrawable(R.raw.login_showpassword_icon_activa);
    private boolean OUD = false;
    public String oxJ = "";

    static /* synthetic */ void b(MMVisiblePasswordEditText mMVisiblePasswordEditText) {
        AppMethodBeat.i(142324);
        mMVisiblePasswordEditText.gLn();
        AppMethodBeat.o(142324);
    }

    public MMVisiblePasswordEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(142318);
        cMn();
        AppMethodBeat.o(142318);
    }

    public MMVisiblePasswordEditText(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(142319);
        cMn();
        AppMethodBeat.o(142319);
    }

    private void cMn() {
        AppMethodBeat.i(142320);
        this.OUB.setBounds(0, 0, this.OUB.getIntrinsicWidth(), this.OUB.getIntrinsicHeight());
        this.OUC.setBounds(0, 0, this.OUC.getIntrinsicWidth(), this.OUC.getIntrinsicHeight());
        Log.d("MicroMsg.MMVisiblePasswordEditText", "closeEye width %d height %d", Integer.valueOf(this.OUB.getIntrinsicWidth()), Integer.valueOf(this.OUB.getIntrinsicHeight()));
        gLn();
        setHeight(this.OUB.getIntrinsicHeight() + (getResources().getDimensionPixelSize(R.dimen.iu) * 5));
        setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.ui.base.MMVisiblePasswordEditText.AnonymousClass1 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean z = true;
                AppMethodBeat.i(142317);
                MMVisiblePasswordEditText mMVisiblePasswordEditText = MMVisiblePasswordEditText.this;
                if (mMVisiblePasswordEditText.getCompoundDrawables()[2] == null) {
                    AppMethodBeat.o(142317);
                } else if (motionEvent.getAction() != 1) {
                    AppMethodBeat.o(142317);
                } else {
                    if (motionEvent.getX() > ((float) ((mMVisiblePasswordEditText.getWidth() - mMVisiblePasswordEditText.getPaddingRight()) - MMVisiblePasswordEditText.this.OUB.getIntrinsicWidth()))) {
                        MMVisiblePasswordEditText mMVisiblePasswordEditText2 = MMVisiblePasswordEditText.this;
                        if (MMVisiblePasswordEditText.this.OUD) {
                            z = false;
                        }
                        mMVisiblePasswordEditText2.OUD = z;
                        MMVisiblePasswordEditText.b(MMVisiblePasswordEditText.this);
                    }
                    AppMethodBeat.o(142317);
                }
                return false;
            }
        });
        AppMethodBeat.o(142320);
    }

    private void gLn() {
        AppMethodBeat.i(142321);
        int selectionStart = getSelectionStart();
        int selectionEnd = getSelectionEnd();
        if (this.OUD) {
            setInputType(1);
            gLo();
        } else {
            setInputType(129);
            gLp();
        }
        setSelection(selectionStart, selectionEnd);
        AppMethodBeat.o(142321);
    }

    private void gLo() {
        AppMethodBeat.i(142322);
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.OUC, getCompoundDrawables()[3]);
        AppMethodBeat.o(142322);
    }

    private void gLp() {
        AppMethodBeat.i(142323);
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.OUB, getCompoundDrawables()[3]);
        AppMethodBeat.o(142323);
    }
}
