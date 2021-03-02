package com.tencent.mm.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

public class CheckBoxLicenseView extends LinearLayout {
    private CompoundButton.OnCheckedChangeListener RiF;
    private View.OnClickListener RiG;

    public CheckBoxLicenseView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public CheckBoxLicenseView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(206165);
        View inflate = inflate(getContext(), R.layout.vr, this);
        View findViewById = inflate.findViewById(R.id.ijd);
        final CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.ije);
        TextView textView = (TextView) inflate.findViewById(R.id.ijh);
        findViewById.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.view.CheckBoxLicenseView.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(206164);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/view/CheckBoxLicenseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                checkBox.performClick();
                a.a(this, "com/tencent/mm/view/CheckBoxLicenseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(206164);
            }
        });
        if (this.RiF != null) {
            checkBox.setOnCheckedChangeListener(this.RiF);
        }
        if (this.RiG != null) {
            textView.setOnClickListener(this.RiG);
        }
        AppMethodBeat.o(206165);
    }

    public void setCheckStateChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        AppMethodBeat.i(206166);
        this.RiF = onCheckedChangeListener;
        ((CheckBox) findViewById(R.id.ije)).setOnCheckedChangeListener(onCheckedChangeListener);
        AppMethodBeat.o(206166);
    }

    public void setLicenseClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(206167);
        this.RiG = onClickListener;
        ((TextView) findViewById(R.id.ijh)).setOnClickListener(onClickListener);
        AppMethodBeat.o(206167);
    }

    public void setTermText(CharSequence charSequence) {
        AppMethodBeat.i(206168);
        ((TextView) findViewById(R.id.ijh)).setText(charSequence);
        AppMethodBeat.o(206168);
    }

    public void setTermTip(CharSequence charSequence) {
        AppMethodBeat.i(206169);
        ((TextView) findViewById(R.id.ijg)).setText(charSequence);
        AppMethodBeat.o(206169);
    }
}
