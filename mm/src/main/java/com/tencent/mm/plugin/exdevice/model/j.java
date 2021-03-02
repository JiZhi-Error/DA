package com.tencent.mm.plugin.exdevice.model;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.List;

public final class j {
    private static j rAp;
    private SparseArray<List<a>> rAq = new SparseArray<>();

    public interface a {
        void h(int i2, Object... objArr);
    }

    private j() {
        AppMethodBeat.i(23375);
        AppMethodBeat.o(23375);
    }

    public static j cKC() {
        AppMethodBeat.i(23376);
        if (rAp == null) {
            rAp = new j();
        }
        j jVar = rAp;
        AppMethodBeat.o(23376);
        return jVar;
    }

    public final boolean a(int i2, a aVar) {
        AppMethodBeat.i(23377);
        if (aVar == null) {
            AppMethodBeat.o(23377);
            return false;
        }
        List<a> list = this.rAq.get(i2);
        if (list == null) {
            list = new LinkedList<>();
            this.rAq.put(i2, list);
        } else if (list.contains(aVar)) {
            AppMethodBeat.o(23377);
            return false;
        }
        boolean add = list.add(aVar);
        AppMethodBeat.o(23377);
        return add;
    }

    public final boolean b(int i2, a aVar) {
        AppMethodBeat.i(23378);
        List<a> list = this.rAq.get(i2);
        if (list != null) {
            list.remove(aVar);
            if (list.size() == 0) {
                this.rAq.remove(i2);
            }
        }
        AppMethodBeat.o(23378);
        return false;
    }

    public final void i(int i2, Object... objArr) {
        AppMethodBeat.i(23379);
        List<a> list = this.rAq.get(i2);
        if (list == null || list.size() == 0) {
            AppMethodBeat.o(23379);
            return;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            list.get(i3).h(i2, objArr);
        }
        AppMethodBeat.o(23379);
    }
}
