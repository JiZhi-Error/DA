package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.MMEditText;

public class SnsEditText extends MMEditText {
    private boolean EDp = false;
    private int EDq = 0;
    private int EDr = 0;
    private int EDs = 10;
    private Context context;
    private int nUS = 0;
    private float y;
    private boolean yFT = false;

    public SnsEditText(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        AppMethodBeat.i(98694);
        this.context = context2;
        addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.plugin.sns.ui.SnsEditText.AnonymousClass1 */

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                AppMethodBeat.i(98692);
                try {
                    if (SnsEditText.this.EDp) {
                        if (charSequence == null || charSequence.length() < a.DCT) {
                            SnsEditText.this.nUS = 0;
                            AppMethodBeat.o(98692);
                            return;
                        } else if (charSequence.length() - SnsEditText.this.EDq > a.DCT) {
                            SnsEditText.this.nUS = charSequence.length() - SnsEditText.this.EDq;
                        }
                    }
                    AppMethodBeat.o(98692);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.SnsEditText", e2, "", new Object[0]);
                    AppMethodBeat.o(98692);
                }
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                AppMethodBeat.i(98693);
                if (charSequence != null) {
                    SnsEditText.this.EDq = charSequence.length();
                }
                AppMethodBeat.o(98693);
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        AppMethodBeat.o(98694);
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c, com.tencent.mm.ui.widget.edittext.PasterEditText
    public int getPasterLen() {
        return this.nUS;
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c, com.tencent.mm.ui.widget.MMEditText
    public void setPasterLen(int i2) {
        this.nUS = i2;
    }

    @Override // com.tencent.mm.ui.widget.MMEditText, com.tencent.mm.ui.widget.edittext.PasterEditText
    public boolean onTextContextMenuItem(int i2) {
        AppMethodBeat.i(98695);
        if (i2 == 16908322) {
            this.EDp = true;
        }
        boolean onTextContextMenuItem = super.onTextContextMenuItem(i2);
        AppMethodBeat.o(98695);
        return onTextContextMenuItem;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(98696);
        if (motionEvent.getAction() == 2) {
            if (Math.abs(this.y - motionEvent.getY()) > ((float) this.EDs)) {
                this.yFT = true;
            }
        } else if (motionEvent.getAction() != 1) {
            this.yFT = false;
        } else if (this.yFT) {
            this.yFT = false;
            AppMethodBeat.o(98696);
            return true;
        }
        this.y = motionEvent.getY();
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.o(98696);
        return onTouchEvent;
    }
}
