package com.tencent.mm.picker.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.picker.base.a.b;
import java.util.List;

public final class a<T> implements b {
    private List<T> iHf;

    public a(List<T> list) {
        this.iHf = list;
    }

    @Override // com.tencent.mm.picker.base.a.b
    public final Object getItem(int i2) {
        AppMethodBeat.i(175284);
        if (i2 < 0 || i2 >= this.iHf.size()) {
            AppMethodBeat.o(175284);
            return "";
        }
        T t = this.iHf.get(i2);
        AppMethodBeat.o(175284);
        return t;
    }

    @Override // com.tencent.mm.picker.base.a.b
    public final String uG(int i2) {
        AppMethodBeat.i(175285);
        Object item = getItem(i2);
        if (item == null) {
            item = "";
        } else if (!(item instanceof String)) {
            item = item.toString();
        }
        String str = (String) item;
        AppMethodBeat.o(175285);
        return str;
    }

    @Override // com.tencent.mm.picker.base.a.b
    public final int getItemsCount() {
        AppMethodBeat.i(175286);
        int size = this.iHf.size();
        AppMethodBeat.o(175286);
        return size;
    }
}
