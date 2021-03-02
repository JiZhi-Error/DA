package com.tencent.luggage.game.widget.input;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.widget.input.a.a;
import com.tencent.mm.plugin.appbrand.widget.input.c.b;
import com.tencent.mm.plugin.appbrand.widget.input.z;
import com.tencent.mm.pointers.PInt;

@SuppressLint({"AppCompatCustomView"})
public class WAGamePanelInputEditText extends EditText {
    private final z cxW;
    private final InputFilter cxX;
    private int cxY;
    private final Spannable.Factory cxZ;

    public WAGamePanelInputEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.k2);
    }

    public WAGamePanelInputEditText(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(130724);
        this.cxX = new InputFilter() {
            /* class com.tencent.luggage.game.widget.input.WAGamePanelInputEditText.AnonymousClass2 */

            public final CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
                Spannable spannableStringBuilder;
                AppMethodBeat.i(130722);
                if (TextUtils.isEmpty(charSequence)) {
                    AppMethodBeat.o(130722);
                    return null;
                }
                CharSequence subSequence = charSequence.subSequence(i2, i3);
                if (subSequence instanceof Spannable) {
                    spannableStringBuilder = (Spannable) subSequence;
                } else {
                    spannableStringBuilder = new SpannableStringBuilder(subSequence);
                }
                Spannable a2 = WAGamePanelInputEditText.a(WAGamePanelInputEditText.this, spannableStringBuilder);
                if (a2 == spannableStringBuilder) {
                    AppMethodBeat.o(130722);
                    return null;
                }
                AppMethodBeat.o(130722);
                return a2;
            }
        };
        this.cxY = Integer.MAX_VALUE;
        this.cxZ = new Spannable.Factory() {
            /* class com.tencent.luggage.game.widget.input.WAGamePanelInputEditText.AnonymousClass3 */

            public final Spannable newSpannable(CharSequence charSequence) {
                AppMethodBeat.i(130723);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
                AppMethodBeat.o(130723);
                return spannableStringBuilder;
            }
        };
        this.cxW = new z(this);
        super.setEditableFactory(new Editable.Factory() {
            /* class com.tencent.luggage.game.widget.input.WAGamePanelInputEditText.AnonymousClass1 */

            public final Editable newEditable(CharSequence charSequence) {
                AppMethodBeat.i(130721);
                Editable c2 = WAGamePanelInputEditText.this.cxW.c((Editable) WAGamePanelInputEditText.a(WAGamePanelInputEditText.this, super.newEditable(charSequence)));
                AppMethodBeat.o(130721);
                return c2;
            }
        });
        AppMethodBeat.o(130724);
    }

    public void setComposingDismissedListener(b bVar) {
        this.cxW.ouT = bVar;
    }

    public void setFilters(InputFilter[] inputFilterArr) {
        int i2 = 0;
        AppMethodBeat.i(130725);
        if (this.cxX != null) {
            if (inputFilterArr == null) {
                inputFilterArr = new InputFilter[0];
            }
            InputFilter[] inputFilterArr2 = new InputFilter[(inputFilterArr.length + 1)];
            while (i2 < inputFilterArr.length) {
                inputFilterArr2[i2] = inputFilterArr[i2];
                i2++;
            }
            inputFilterArr2[i2] = this.cxX;
            inputFilterArr = inputFilterArr2;
        }
        super.setFilters(inputFilterArr);
        AppMethodBeat.o(130725);
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        AppMethodBeat.i(130726);
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        editorInfo.imeOptions |= 268435456;
        AppMethodBeat.o(130726);
        return onCreateInputConnection;
    }

    public void setMaxLength(int i2) {
        this.cxY = i2;
    }

    public int getMaxLength() {
        return this.cxY;
    }

    static /* synthetic */ Spannable a(WAGamePanelInputEditText wAGamePanelInputEditText, Spannable spannable) {
        AppMethodBeat.i(130727);
        PInt pInt = new PInt();
        pInt.value = wAGamePanelInputEditText.cxY;
        com.tencent.mm.plugin.appbrand.widget.input.a.b cce = a.cce();
        wAGamePanelInputEditText.getContext();
        Spannable a2 = cce.a(spannable, Math.round(wAGamePanelInputEditText.getTextSize()), pInt, wAGamePanelInputEditText.cxZ);
        AppMethodBeat.o(130727);
        return a2;
    }
}
