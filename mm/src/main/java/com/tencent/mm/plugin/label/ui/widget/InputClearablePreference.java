package com.tencent.mm.plugin.label.ui.widget;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.widget.MMEditText;

public class InputClearablePreference extends Preference {
    public String jFn;
    private String mText;
    public String yDC;
    public String yDD;
    public int yDE;
    private int yDF;
    public boolean yDG;
    public MMEditText yDH;
    private ImageView yDI;
    public TextView yDJ;
    private int yDK;
    public a yDL;

    public interface a {
        void auW(String str);

        void qD(boolean z);
    }

    static /* synthetic */ void a(InputClearablePreference inputClearablePreference, String str) {
        AppMethodBeat.i(26336);
        inputClearablePreference.aCP(str);
        AppMethodBeat.o(26336);
    }

    public InputClearablePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InputClearablePreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public final void setText(String str) {
        AppMethodBeat.i(26331);
        this.mText = str;
        if (this.yDH != null && !Util.isNullOrNil(str)) {
            this.yDH.setText(l.e(this.mContext, (CharSequence) this.mText, this.yDK));
            aCP(this.mText);
        }
        AppMethodBeat.o(26331);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(26332);
        super.onBindView(view);
        this.yDK = com.tencent.mm.cb.a.aG(this.mContext, R.dimen.hc);
        this.yDH = (MMEditText) view.findViewById(R.id.bxz);
        this.yDI = (ImageView) view.findViewById(R.id.bm9);
        this.yDJ = (TextView) view.findViewById(R.id.c4g);
        if (this.yDH != null) {
            if (this.yDF > 0) {
                this.yDH.setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.yDF), new b()});
            } else {
                this.yDH.setFilters(new InputFilter[]{new b()});
            }
        }
        this.yDH.addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.plugin.label.ui.widget.InputClearablePreference.AnonymousClass1 */

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                AppMethodBeat.i(26324);
                if (charSequence != null) {
                    Log.d("MicroMsg.Label.InputClearablePreference", "cpan[onTextChanged] :%s", charSequence.toString());
                    if (InputClearablePreference.this.yDL != null) {
                        InputClearablePreference.this.yDL.auW(charSequence.toString());
                    }
                }
                AppMethodBeat.o(26324);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                boolean z = false;
                AppMethodBeat.i(26325);
                if (editable != null) {
                    String obj = editable.toString();
                    InputClearablePreference.a(InputClearablePreference.this, obj);
                    InputClearablePreference inputClearablePreference = InputClearablePreference.this;
                    if (!Util.isNullOrNil(obj)) {
                        z = true;
                    }
                    InputClearablePreference.a(inputClearablePreference, z);
                    InputClearablePreference.this.mText = obj;
                    AppMethodBeat.o(26325);
                    return;
                }
                InputClearablePreference.a(InputClearablePreference.this, false);
                AppMethodBeat.o(26325);
            }
        });
        Log.d("MicroMsg.Label.InputClearablePreference", "mText %s", this.mText);
        setText(this.mText);
        if (!Util.isNullOrNil(this.mText)) {
            this.yDH.setSelection(this.mText.length());
        }
        if (this.yDG) {
            new MMHandler().postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.label.ui.widget.InputClearablePreference.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(26328);
                    if (InputClearablePreference.this.yDH != null) {
                        InputClearablePreference.this.yDH.requestFocus();
                        ((InputMethodManager) InputClearablePreference.this.yDH.getContext().getSystemService("input_method")).showSoftInput(InputClearablePreference.this.yDH, 0);
                        InputClearablePreference.this.yDH.setCursorVisible(false);
                        InputClearablePreference.this.yDH.setCursorVisible(true);
                    }
                    AppMethodBeat.o(26328);
                }
            }, 0);
        }
        this.yDH.setHint(this.yDC);
        this.yDI.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.label.ui.widget.InputClearablePreference.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(26326);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/label/ui/widget/InputClearablePreference$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (InputClearablePreference.this.yDH != null) {
                    InputClearablePreference.this.yDH.setText("");
                    InputClearablePreference.this.mText = "";
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/label/ui/widget/InputClearablePreference$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(26326);
            }
        });
        if (this.yDJ != null) {
            this.yDJ.setOnTouchListener(new View.OnTouchListener() {
                /* class com.tencent.mm.plugin.label.ui.widget.InputClearablePreference.AnonymousClass3 */

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(26327);
                    if (InputClearablePreference.this.yDH != null) {
                        InputClearablePreference.this.yDH.clearFocus();
                    }
                    AppMethodBeat.o(26327);
                    return false;
                }
            });
        }
        AppMethodBeat.o(26332);
    }

    private void aCP(String str) {
        boolean z = true;
        AppMethodBeat.i(26333);
        if (!Util.isNullOrNil(str)) {
            int bnP = f.bnP(str);
            g(bnP > this.yDE, f.dp(this.yDE, ""), f.dq(this.yDE, str));
            if (this.yDL != null) {
                a aVar = this.yDL;
                if (bnP > this.yDE) {
                    z = false;
                }
                aVar.qD(z);
            }
        }
        AppMethodBeat.o(26333);
    }

    private void g(boolean z, int i2, int i3) {
        AppMethodBeat.i(26334);
        if (this.yDJ != null) {
            if (z) {
                this.yDJ.setText(String.format(this.jFn, Integer.valueOf(i2), Integer.valueOf(i3)));
                this.yDJ.setVisibility(0);
                AppMethodBeat.o(26334);
                return;
            }
            this.yDJ.setVisibility(8);
        }
        AppMethodBeat.o(26334);
    }

    public final void qF(boolean z) {
        AppMethodBeat.i(26335);
        if (this.yDJ != null) {
            if (z) {
                this.yDJ.setText(this.yDD);
                this.yDJ.setVisibility(0);
                AppMethodBeat.o(26335);
                return;
            }
            this.yDJ.setVisibility(8);
        }
        AppMethodBeat.o(26335);
    }

    class b implements InputFilter {
        public final char[] yDN = {'\n', ',', ';', 12289, 65292, 65307};

        b() {
            AppMethodBeat.i(26329);
            AppMethodBeat.o(26329);
        }

        public final CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
            AppMethodBeat.i(26330);
            Log.d("MicroMsg.Label.InputClearablePreference", "on create tag filter, %s [%d, %d) %s [%d, %d),", charSequence, Integer.valueOf(i2), Integer.valueOf(i3), spanned, Integer.valueOf(i4), Integer.valueOf(i5));
            for (int i6 = i2; i6 < i3; i6++) {
                char[] cArr = new char[(i3 - i2)];
                TextUtils.getChars(charSequence, i2, i3, cArr, 0);
                int length = this.yDN.length;
                for (int i7 = 0; i7 < length; i7++) {
                    if (cArr[i6] == ' ' && i4 == 0 && i6 == 0) {
                        AppMethodBeat.o(26330);
                        return "";
                    } else if (cArr[i6] == this.yDN[i7]) {
                        InputClearablePreference.this.qF(true);
                        AppMethodBeat.o(26330);
                        return "";
                    }
                }
            }
            AppMethodBeat.o(26330);
            return null;
        }
    }

    static /* synthetic */ void a(InputClearablePreference inputClearablePreference, boolean z) {
        AppMethodBeat.i(26337);
        if (inputClearablePreference.yDI != null) {
            if (z) {
                inputClearablePreference.yDI.setVisibility(0);
                AppMethodBeat.o(26337);
                return;
            }
            inputClearablePreference.yDI.setVisibility(8);
        }
        AppMethodBeat.o(26337);
    }
}
