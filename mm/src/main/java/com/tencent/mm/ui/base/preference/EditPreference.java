package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.a.d;

public class EditPreference extends Preference {
    a OXD;
    private Preference.a OXy;
    private d kdo;
    String value;
    private EditText vy;

    public interface a {
        void gLD();
    }

    public EditPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EditPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void a(Preference.a aVar) {
        this.OXy = aVar;
    }

    public final void showDialog() {
        final EditText editText;
        AppMethodBeat.i(142539);
        if (this.vy != null) {
            editText = this.vy;
        } else {
            editText = new EditText(this.mContext);
            editText.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            editText.setSingleLine(true);
            editText.setText(this.value);
        }
        ViewGroup.LayoutParams layoutParams = editText.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            int dimensionPixelSize = editText.getResources().getDimensionPixelSize(R.dimen.hs);
            marginLayoutParams.leftMargin = dimensionPixelSize;
            marginLayoutParams.rightMargin = dimensionPixelSize;
            marginLayoutParams.topMargin = dimensionPixelSize;
            marginLayoutParams.bottomMargin = dimensionPixelSize;
        }
        if (editText.getParent() != null) {
            ((ViewGroup) editText.getParent()).removeView(editText);
        }
        this.kdo = h.a(this.mContext, getTitle().toString(), editText, com.tencent.mm.cb.a.aI(this.mContext, R.string.x_), com.tencent.mm.cb.a.aI(this.mContext, R.string.sz), new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.ui.base.preference.EditPreference.AnonymousClass1 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(142537);
                if (EditPreference.this.kdo != null) {
                    EditPreference.this.kdo.dismiss();
                }
                EditPreference.this.value = editText.getText().toString();
                if (EditPreference.this.OXD != null) {
                    EditPreference.this.OXD.gLD();
                }
                if (EditPreference.this.OXy != null) {
                    EditPreference.this.OXy.a(EditPreference.this, EditPreference.this.value);
                }
                AppMethodBeat.o(142537);
            }
        }, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.ui.base.preference.EditPreference.AnonymousClass2 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(142538);
                if (EditPreference.this.kdo != null) {
                    EditPreference.this.kdo.dismiss();
                }
                AppMethodBeat.o(142538);
            }
        });
        AppMethodBeat.o(142539);
    }
}
