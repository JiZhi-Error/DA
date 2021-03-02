package kotlin.l.b.a.b.m.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class a extends ArrayList<m> implements l {
    public a(int i2) {
        super(i2);
    }

    public final /* bridge */ boolean contains(Object obj) {
        AppMethodBeat.i(61218);
        if (!(obj instanceof m)) {
            AppMethodBeat.o(61218);
            return false;
        }
        boolean contains = super.contains((m) obj);
        AppMethodBeat.o(61218);
        return contains;
    }

    public final /* bridge */ int indexOf(Object obj) {
        AppMethodBeat.i(61219);
        if (!(obj instanceof m)) {
            AppMethodBeat.o(61219);
            return -1;
        }
        int indexOf = super.indexOf((m) obj);
        AppMethodBeat.o(61219);
        return indexOf;
    }

    public final /* bridge */ int lastIndexOf(Object obj) {
        AppMethodBeat.i(61220);
        if (!(obj instanceof m)) {
            AppMethodBeat.o(61220);
            return -1;
        }
        int lastIndexOf = super.lastIndexOf((m) obj);
        AppMethodBeat.o(61220);
        return lastIndexOf;
    }

    @Override // java.util.List, java.util.ArrayList
    public final /* bridge */ boolean remove(Object obj) {
        AppMethodBeat.i(61221);
        if (!(obj instanceof m)) {
            AppMethodBeat.o(61221);
            return false;
        }
        boolean remove = super.remove((m) obj);
        AppMethodBeat.o(61221);
        return remove;
    }

    public final /* bridge */ int size() {
        AppMethodBeat.i(61222);
        int size = super.size();
        AppMethodBeat.o(61222);
        return size;
    }
}
