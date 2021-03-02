package com.tencent.mm.ui.widget.picker.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class d implements e<Integer> {
    private c QUv;
    private int jJW;
    private int jJX;

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.tencent.mm.ui.widget.picker.a.e
    public /* synthetic */ Integer getItem(int i2) {
        AppMethodBeat.i(198507);
        Integer uH = uH(i2);
        AppMethodBeat.o(198507);
        return uH;
    }

    public d(int i2, int i3, c cVar) {
        AppMethodBeat.i(198502);
        a(i2, i3, cVar);
        AppMethodBeat.o(198502);
    }

    private void a(int i2, int i3, c cVar) {
        AppMethodBeat.i(198503);
        this.QUv = cVar;
        if (this.QUv == null) {
            this.QUv = new a();
        }
        this.jJW = i2;
        this.jJX = i3;
        AppMethodBeat.o(198503);
    }

    public int getMinValue() {
        return this.jJW;
    }

    public int getMaxValue() {
        return this.jJX;
    }

    public d(int i2, int i3) {
        AppMethodBeat.i(198504);
        a(i2, i3, null);
        AppMethodBeat.o(198504);
    }

    public Integer uH(int i2) {
        AppMethodBeat.i(198505);
        if (i2 < 0 || i2 >= getItemsCount()) {
            AppMethodBeat.o(198505);
            return null;
        }
        Integer valueOf = Integer.valueOf(this.jJW + i2);
        AppMethodBeat.o(198505);
        return valueOf;
    }

    @Override // com.tencent.mm.ui.widget.picker.a.e
    public String uG(int i2) {
        AppMethodBeat.i(198506);
        Integer uH = uH(i2);
        String Sf = this.QUv.Sf(uH == null ? "" : uH.toString());
        AppMethodBeat.o(198506);
        return Sf;
    }

    @Override // com.tencent.mm.ui.widget.picker.a.e
    public int getItemsCount() {
        return (this.jJX - this.jJW) + 1;
    }

    /* access modifiers changed from: package-private */
    public class a implements c {
        a() {
        }

        @Override // com.tencent.mm.ui.widget.picker.a.c
        public final String Sf(String str) {
            return str;
        }
    }
}
