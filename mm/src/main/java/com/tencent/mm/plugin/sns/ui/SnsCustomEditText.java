package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.cedit.api.MMCustomEditText;

public class SnsCustomEditText extends MMCustomEditText {
    private boolean EDp = false;
    private int EDq = 0;
    private int EDr = 0;
    private int EDs = 10;
    private Context context;
    private int nUS = 0;
    private boolean yFT = false;

    public SnsCustomEditText(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        AppMethodBeat.i(203569);
        this.context = context2;
        addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.plugin.sns.ui.SnsCustomEditText.AnonymousClass1 */

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                AppMethodBeat.i(203567);
                try {
                    if (SnsCustomEditText.this.EDp) {
                        if (charSequence == null || charSequence.length() < a.DCT) {
                            SnsCustomEditText.this.nUS = 0;
                            AppMethodBeat.o(203567);
                            return;
                        } else if (charSequence.length() - SnsCustomEditText.this.EDq > a.DCT) {
                            SnsCustomEditText.this.nUS = charSequence.length() - SnsCustomEditText.this.EDq;
                        }
                    }
                    AppMethodBeat.o(203567);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.SnsEditText", e2, "", new Object[0]);
                    AppMethodBeat.o(203567);
                }
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                AppMethodBeat.i(203568);
                if (charSequence != null) {
                    SnsCustomEditText.this.EDq = charSequence.length();
                }
                AppMethodBeat.o(203568);
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        AppMethodBeat.o(203569);
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c, com.tencent.mm.ui.widget.cedit.api.PasterEditTextCompact
    public int getPasterLen() {
        return this.nUS;
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.c, com.tencent.mm.ui.widget.cedit.api.MMCustomEditText
    public void setPasterLen(int i2) {
        this.nUS = i2;
    }

    @Override // com.tencent.mm.ui.widget.cedit.api.PasterEditTextCompact, com.tencent.mm.ui.widget.cedit.api.MMCustomEditText, com.tencent.mm.ui.widget.cedit.edit.CustomTextView
    public final boolean onTextContextMenuItem(int i2) {
        AppMethodBeat.i(203570);
        if (i2 == 16908322) {
            this.EDp = true;
        }
        boolean onTextContextMenuItem = super.onTextContextMenuItem(i2);
        AppMethodBeat.o(203570);
        return onTextContextMenuItem;
    }
}
