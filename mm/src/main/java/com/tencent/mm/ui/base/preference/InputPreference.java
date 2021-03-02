package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;

public class InputPreference extends Preference {
    private String FMO;
    private String OYu;
    private EditText OYv;
    private Button OYw;
    private a OYx;
    private View.OnClickListener OYy;
    private TextView.OnEditorActionListener OYz;

    public interface a {
    }

    public InputPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InputPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(142574);
        this.OYy = new View.OnClickListener() {
            /* class com.tencent.mm.ui.base.preference.InputPreference.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(142572);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/preference/InputPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (!(InputPreference.this.OYx == null || InputPreference.this.OYv == null)) {
                    if (InputPreference.this.OYv.getText() == null) {
                        a unused = InputPreference.this.OYx;
                    } else {
                        a unused2 = InputPreference.this.OYx;
                        InputPreference.this.OYv.getText();
                    }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/preference/InputPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(142572);
            }
        };
        this.OYz = new TextView.OnEditorActionListener() {
            /* class com.tencent.mm.ui.base.preference.InputPreference.AnonymousClass2 */

            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                AppMethodBeat.i(142573);
                if (3 != i2 || InputPreference.this.OYx == null || InputPreference.this.OYv == null) {
                    AppMethodBeat.o(142573);
                    return false;
                }
                if (InputPreference.this.OYv.getText() == null) {
                    a unused = InputPreference.this.OYx;
                } else {
                    a unused2 = InputPreference.this.OYx;
                    InputPreference.this.OYv.getText();
                }
                AppMethodBeat.o(142573);
                return true;
            }
        };
        AppMethodBeat.o(142574);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(142575);
        super.onBindView(view);
        this.OYv = (EditText) view.findViewById(R.id.bxz);
        this.OYv.setHint(this.FMO);
        this.OYv.setOnEditorActionListener(this.OYz);
        this.OYw = (Button) view.findViewById(R.id.agf);
        this.OYw.setText(this.OYu);
        this.OYw.setOnClickListener(this.OYy);
        AppMethodBeat.o(142575);
    }
}
