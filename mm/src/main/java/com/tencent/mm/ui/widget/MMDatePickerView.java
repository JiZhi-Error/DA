package com.tencent.mm.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.aa;

public class MMDatePickerView extends LinearLayout implements View.OnClickListener {
    private Button QCF;
    private Button QCG;
    private Button QCH;
    private MMSpinnerDatePicker qCk;

    public MMDatePickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(143347);
        init(context);
        AppMethodBeat.o(143347);
    }

    public MMDatePickerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(143348);
        init(context);
        AppMethodBeat.o(143348);
    }

    private void init(Context context) {
        AppMethodBeat.i(143349);
        View inflate = aa.jQ(context).inflate(R.layout.b80, this);
        this.QCF = (Button) inflate.findViewById(R.id.jsm);
        this.QCG = (Button) inflate.findViewById(R.id.fjm);
        this.QCH = (Button) inflate.findViewById(R.id.bks);
        this.qCk = (MMSpinnerDatePicker) inflate.findViewById(R.id.ffw);
        this.QCF.setOnClickListener(this);
        this.QCG.setOnClickListener(this);
        this.QCH.setOnClickListener(this);
        AppMethodBeat.o(143349);
    }

    public void onClick(View view) {
        AppMethodBeat.i(143350);
        b bVar = new b();
        bVar.bm(view);
        a.b("com/tencent/mm/ui/widget/MMDatePickerView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        int id = view.getId();
        if (id == R.id.jsm) {
            this.qCk.setPickerMode(0);
        } else if (id == R.id.fjm) {
            this.qCk.setPickerMode(1);
        } else {
            this.qCk.setPickerMode(2);
        }
        a.a(this, "com/tencent/mm/ui/widget/MMDatePickerView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(143350);
    }
}
