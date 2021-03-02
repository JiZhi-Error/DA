package com.tencent.mm.picker.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.picker.base.a.b;

public final class c implements b<Integer> {
    public int jJW;
    public int jJX;
    private com.tencent.mm.picker.base.a.a jJY;

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.tencent.mm.picker.base.a.b
    public final /* synthetic */ Integer getItem(int i2) {
        AppMethodBeat.i(175294);
        Integer uH = uH(i2);
        AppMethodBeat.o(175294);
        return uH;
    }

    public c(int i2, int i3, com.tencent.mm.picker.base.a.a aVar) {
        AppMethodBeat.i(175289);
        a(i2, i3, aVar);
        AppMethodBeat.o(175289);
    }

    private void a(int i2, int i3, com.tencent.mm.picker.base.a.a aVar) {
        AppMethodBeat.i(175290);
        this.jJY = aVar;
        if (this.jJY == null) {
            this.jJY = new a();
        }
        this.jJW = i2;
        this.jJX = i3;
        AppMethodBeat.o(175290);
    }

    public c(int i2, int i3) {
        AppMethodBeat.i(175291);
        a(i2, i3, null);
        AppMethodBeat.o(175291);
    }

    private Integer uH(int i2) {
        AppMethodBeat.i(175292);
        if (i2 < 0 || i2 >= getItemsCount()) {
            AppMethodBeat.o(175292);
            return null;
        }
        Integer valueOf = Integer.valueOf(this.jJW + i2);
        AppMethodBeat.o(175292);
        return valueOf;
    }

    @Override // com.tencent.mm.picker.base.a.b
    public final String uG(int i2) {
        AppMethodBeat.i(175293);
        Integer uH = uH(i2);
        String Sf = this.jJY.Sf(uH == null ? "" : uH.toString());
        AppMethodBeat.o(175293);
        return Sf;
    }

    @Override // com.tencent.mm.picker.base.a.b
    public final int getItemsCount() {
        return (this.jJX - this.jJW) + 1;
    }

    /* access modifiers changed from: package-private */
    public class a implements com.tencent.mm.picker.base.a.a {
        a() {
        }

        @Override // com.tencent.mm.picker.base.a.a
        public final String Sf(String str) {
            return str;
        }
    }
}
