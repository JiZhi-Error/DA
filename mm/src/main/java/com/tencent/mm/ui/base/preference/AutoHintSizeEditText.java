package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.graphics.Paint;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class AutoHintSizeEditText extends EditText {
    private float OXe;
    private Paint OXf;
    private String OXg = "";
    private int OXh = Integer.MIN_VALUE;
    private float OXi;

    static /* synthetic */ void a(AutoHintSizeEditText autoHintSizeEditText, Editable editable, CharSequence charSequence, int i2) {
        AppMethodBeat.i(142499);
        autoHintSizeEditText.a(editable, charSequence, i2);
        AppMethodBeat.o(142499);
    }

    public AutoHintSizeEditText(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(142494);
        init();
        AppMethodBeat.o(142494);
    }

    public AutoHintSizeEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(142495);
        init();
        AppMethodBeat.o(142495);
    }

    private void init() {
        AppMethodBeat.i(142496);
        this.OXe = getTextSize();
        this.OXi = this.OXe;
        this.OXf = new Paint(getPaint());
        addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.ui.base.preference.AutoHintSizeEditText.AnonymousClass1 */

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(142493);
                AutoHintSizeEditText.a(AutoHintSizeEditText.this, editable, AutoHintSizeEditText.this.getHint(), (AutoHintSizeEditText.this.getWidth() - AutoHintSizeEditText.this.getPaddingLeft()) - AutoHintSizeEditText.this.getPaddingRight());
                AppMethodBeat.o(142493);
            }
        });
        AppMethodBeat.o(142496);
    }

    private void a(Editable editable, CharSequence charSequence, int i2) {
        AppMethodBeat.i(142497);
        if (editable != null && !Util.isNullOrNil(editable.toString())) {
            if (getTextSize() != this.OXe) {
                Log.v("MicroMsg.AutoHintSizeEdittext", "content not null, reset text size %f", Float.valueOf(this.OXe));
                setTextSize(0, this.OXe);
            }
            AppMethodBeat.o(142497);
        } else if (charSequence == null || Util.isNullOrNil(charSequence.toString())) {
            if (getTextSize() != this.OXe) {
                Log.v("MicroMsg.AutoHintSizeEdittext", "hint is null, reset text size %f", Float.valueOf(this.OXe));
                setTextSize(0, this.OXe);
            }
            AppMethodBeat.o(142497);
        } else {
            String charSequence2 = charSequence.toString();
            if (!this.OXg.equals(charSequence2) || this.OXh != i2) {
                this.OXg = charSequence2;
                this.OXh = i2;
                if (getPaint().measureText(charSequence2) > ((float) i2)) {
                    int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.kc);
                    int fromDPToPix = a.fromDPToPix(getContext(), 1);
                    for (int i3 = ((int) this.OXe) - fromDPToPix; i3 > dimensionPixelSize; i3 -= fromDPToPix) {
                        this.OXf.setTextSize((float) i3);
                        if (this.OXf.measureText(charSequence2) < ((float) i2)) {
                            Log.v("MicroMsg.AutoHintSizeEdittext", "get new hint text size %d", Integer.valueOf(i3));
                            this.OXi = (float) i3;
                            setTextSize(0, (float) i3);
                            AppMethodBeat.o(142497);
                            return;
                        }
                    }
                }
                AppMethodBeat.o(142497);
                return;
            }
            if (getTextSize() != this.OXi) {
                Log.v("MicroMsg.AutoHintSizeEdittext", "use last hint text size %f", Float.valueOf(this.OXi));
                setTextSize(0, this.OXi);
            }
            AppMethodBeat.o(142497);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(142498);
        Log.d("MicroMsg.AutoHintSizeEdittext", "on layout, changed %B", Boolean.valueOf(z));
        super.onLayout(z, i2, i3, i4, i5);
        if (z) {
            a(getText(), getHint(), ((i4 - i2) - getPaddingLeft()) - getPaddingRight());
        }
        AppMethodBeat.o(142498);
    }
}
