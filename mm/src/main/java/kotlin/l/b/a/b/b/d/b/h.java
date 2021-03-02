package kotlin.l.b.a.b.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.d.b.d;
import kotlin.l.b.a.b.d.a.e.e;
import kotlin.l.b.a.b.f.f;

public final class h extends d implements e {
    private final Object[] apH;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(f fVar, Object[] objArr) {
        super(fVar);
        p.h(objArr, "values");
        AppMethodBeat.i(57423);
        this.apH = objArr;
        AppMethodBeat.o(57423);
    }

    @Override // kotlin.l.b.a.b.d.a.e.e
    public final List<d> hCH() {
        AppMethodBeat.i(57422);
        Object[] objArr = this.apH;
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            if (obj == null) {
                p.hyc();
            }
            arrayList.add(d.a.a(obj, null));
        }
        ArrayList arrayList2 = arrayList;
        AppMethodBeat.o(57422);
        return arrayList2;
    }
}
