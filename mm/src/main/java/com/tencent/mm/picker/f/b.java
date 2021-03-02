package com.tencent.mm.picker.f;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.picker.base.view.WheelView;
import com.tencent.mm.picker.c.a;
import com.tencent.mm.picker.f.d;
import java.util.List;

public final class b<T> extends a implements View.OnClickListener {
    private Context context;
    public d jLI = new d();

    public b(Context context2) {
        super(context2);
        AppMethodBeat.i(175345);
        this.context = context2;
        AppMethodBeat.o(175345);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(175346);
        this.jKP = aVar;
        Context context2 = this.context;
        ble();
        blb();
        blc();
        d dVar = this.jLI;
        WheelView wheelView = new WheelView(context2);
        dVar.jKW = this.jKP.jKW;
        if (dVar.jLL == null) {
            dVar.jLL = wheelView;
        }
        dVar.jLM = dVar.jLL;
        if (this.jKP.jKU != null) {
            this.jLI.jKU = this.jKP.jKU;
        }
        d dVar2 = this.jLI;
        String str = this.jKP.label;
        if (str != null) {
            dVar2.jLM.setLabel(str);
        }
        d dVar3 = this.jLI;
        dVar3.jLM.setCyclic(this.jKP.jKV);
        gd(this.jKP.ox);
        this.jLI.setDividerColor(this.jKP.jKu);
        this.jLI.jLw = this.jKP.jLw;
        this.jLI.jLu = this.jKP.jLu;
        this.jLI.jLM.jKn = this.jKP.jKn;
        this.jLI.uQ(this.jKP.kn);
        this.jLI.setDividerColor(this.jKP.jKu);
        AppMethodBeat.o(175346);
    }

    public final void aO(List<T> list) {
        AppMethodBeat.i(175347);
        d dVar = this.jLI;
        dVar.jLN = list;
        dVar.jLM.setAdapter(new com.tencent.mm.picker.a.a(dVar.jLN));
        dVar.jLM.setCurrentItem(0);
        dVar.jLM.setIsOptions(true);
        d.AnonymousClass1 r1 = new com.tencent.mm.picker.base.b.b() {
            /* class com.tencent.mm.picker.f.d.AnonymousClass1 */

            @Override // com.tencent.mm.picker.base.b.b
            public final void onItemSelected(int i2) {
                AppMethodBeat.i(175360);
                if (d.this.jKU != null) {
                    d.this.jKU.uO(d.this.jLM.getCurrentItem());
                }
                AppMethodBeat.o(175360);
            }
        };
        if (list != null && dVar.jLO) {
            dVar.jLM.setOnItemSelectedListener(r1);
        }
        if (this.jLI != null) {
            this.jLI.uQ(this.jKP.option);
        }
        AppMethodBeat.o(175347);
    }

    public final void onClick(View view) {
        AppMethodBeat.i(175348);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/picker/view/OptionsPickerView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        if (((String) view.getTag()).equals("submit")) {
            blg();
        }
        dismiss();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/picker/view/OptionsPickerView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(175348);
    }

    public final void blg() {
        AppMethodBeat.i(175349);
        if (this.jKP.jKR != null) {
            this.jKP.jKR.uP(this.jLI.blk()[0]);
        }
        AppMethodBeat.o(175349);
    }

    public final void a(com.tencent.mm.picker.d.b bVar) {
        this.jKP.jKU = bVar;
        this.jLI.jKU = this.jKP.jKU;
    }

    public final WheelView blh() {
        AppMethodBeat.i(175350);
        if (this.jLI.jLL == null) {
            this.jLI.jLL = new WheelView(this.context);
        }
        WheelView wheelView = this.jLI.jLL;
        AppMethodBeat.o(175350);
        return wheelView;
    }

    @Override // com.tencent.mm.picker.f.a
    public final boolean blf() {
        return this.jKP.jLv;
    }

    public final void setDividerHeight(float f2) {
        AppMethodBeat.i(175351);
        this.jLI.jLM.setDividerHeight(f2);
        AppMethodBeat.o(175351);
    }
}
