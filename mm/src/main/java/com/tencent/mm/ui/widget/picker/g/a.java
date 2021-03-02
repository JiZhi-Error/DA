package com.tencent.mm.ui.widget.picker.g;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.widget.picker.WheelView;
import com.tencent.mm.ui.widget.picker.d.d;

public final class a<T> extends com.tencent.mm.ui.widget.picker.a implements View.OnClickListener {
    public b QUF = new b();
    private Context context;

    public a(Context context2) {
        super(context2);
        AppMethodBeat.i(198525);
        this.context = context2;
        AppMethodBeat.o(198525);
    }

    public final void b(com.tencent.mm.ui.widget.picker.c.a aVar) {
        AppMethodBeat.i(198526);
        this.QSH = aVar;
        Context context2 = this.context;
        ble();
        blb();
        blc();
        b bVar = this.QUF;
        WheelView wheelView = new WheelView(context2);
        bVar.jKW = this.QSH.jKW;
        if (bVar.QUG == null) {
            bVar.QUG = wheelView;
        }
        bVar.QUH = bVar.QUG;
        if (this.QSH.QUC != null) {
            this.QUF.QUC = this.QSH.QUC;
        }
        b bVar2 = this.QUF;
        String str = this.QSH.label;
        if (str != null) {
            bVar2.QUH.setLabel(str);
        }
        b bVar3 = this.QUF;
        bVar3.QUH.setCyclic(this.QSH.jKV);
        Ds(this.QSH.ox);
        this.QUF.setDividerColor(this.QSH.jKu);
        this.QUF.QTM = this.QSH.QTM;
        this.QUF.jLu = this.QSH.jLu;
        this.QUF.QUH.jKn = this.QSH.jKn;
        this.QUF.uQ(this.QSH.kn);
        this.QUF.setDividerColor(this.QSH.jKu);
        AppMethodBeat.o(198526);
    }

    public final void hcw() {
        AppMethodBeat.i(198527);
        if (this.QUF != null) {
            this.QUF.uQ(this.QSH.option);
        }
        AppMethodBeat.o(198527);
    }

    public final void onClick(View view) {
        AppMethodBeat.i(198528);
        b bVar = new b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/picker/view/OptionsPickerView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        if (((String) view.getTag()).equals("submit")) {
            blg();
        }
        dismiss();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/picker/view/OptionsPickerView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(198528);
    }

    public final void blg() {
        AppMethodBeat.i(198529);
        if (this.QSH.QUz != null) {
            this.QSH.QUz.uP(this.QUF.blk()[0]);
        }
        AppMethodBeat.o(198529);
    }

    public final void setOnValueChangedListener(d dVar) {
        this.QSH.QUC = dVar;
        this.QUF.QUC = this.QSH.QUC;
    }

    public final WheelView hcx() {
        AppMethodBeat.i(198530);
        if (this.QUF.QUG == null) {
            this.QUF.QUG = new WheelView(this.context);
        }
        WheelView wheelView = this.QUF.QUG;
        AppMethodBeat.o(198530);
        return wheelView;
    }

    @Override // com.tencent.mm.ui.widget.picker.a
    public final boolean blf() {
        return this.QSH.jLv;
    }
}
