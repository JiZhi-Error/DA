package com.tencent.mm.ui.widget.picker.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class a<T> implements e {
    private List<T> iHf;

    public a(List<T> list) {
        this.iHf = list;
    }

    @Override // com.tencent.mm.ui.widget.picker.a.e
    public final Object getItem(int i2) {
        AppMethodBeat.i(198497);
        if (i2 < 0 || i2 >= this.iHf.size()) {
            AppMethodBeat.o(198497);
            return "";
        }
        T t = this.iHf.get(i2);
        AppMethodBeat.o(198497);
        return t;
    }

    @Override // com.tencent.mm.ui.widget.picker.a.e
    public final String uG(int i2) {
        AppMethodBeat.i(198498);
        Object item = getItem(i2);
        if (item == null) {
            item = "";
        } else if (!(item instanceof String)) {
            item = item.toString();
        }
        String str = (String) item;
        AppMethodBeat.o(198498);
        return str;
    }

    @Override // com.tencent.mm.ui.widget.picker.a.e
    public final int getItemsCount() {
        AppMethodBeat.i(198499);
        int size = this.iHf.size();
        AppMethodBeat.o(198499);
        return size;
    }
}
