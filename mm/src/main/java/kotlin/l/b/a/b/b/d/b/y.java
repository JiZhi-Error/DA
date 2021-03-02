package kotlin.l.b.a.b.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l.b.a.b.d.a.e.a;
import kotlin.l.b.a.b.d.a.e.v;
import kotlin.l.b.a.b.f.b;
import kotlin.l.b.a.b.f.f;

public final class y extends n implements kotlin.l.b.a.b.d.a.e.y {
    private final w Tnw;
    private final Annotation[] Tnx;
    private final String Tny;
    private final boolean Tnz;

    @Override // kotlin.l.b.a.b.d.a.e.d
    public final /* synthetic */ a l(b bVar) {
        AppMethodBeat.i(57514);
        p.h(bVar, "fqName");
        c a2 = g.a(this.Tnx, bVar);
        AppMethodBeat.o(57514);
        return a2;
    }

    @Override // kotlin.l.b.a.b.d.a.e.y
    public final boolean hDj() {
        return this.Tnz;
    }

    public y(w wVar, Annotation[] annotationArr, String str, boolean z) {
        p.h(wVar, "type");
        p.h(annotationArr, "reflectAnnotations");
        AppMethodBeat.i(57517);
        this.Tnw = wVar;
        this.Tnx = annotationArr;
        this.Tny = str;
        this.Tnz = z;
        AppMethodBeat.o(57517);
    }

    @Override // kotlin.l.b.a.b.d.a.e.y
    public final f hAH() {
        AppMethodBeat.i(57515);
        String str = this.Tny;
        if (str != null) {
            f bub = f.bub(str);
            AppMethodBeat.o(57515);
            return bub;
        }
        AppMethodBeat.o(57515);
        return null;
    }

    public final String toString() {
        String str;
        AppMethodBeat.i(57516);
        StringBuilder append = new StringBuilder().append(getClass().getName()).append(": ");
        if (this.Tnz) {
            str = "vararg ";
        } else {
            str = "";
        }
        String sb = append.append(str).append(hAH()).append(": ").append(this.Tnw).toString();
        AppMethodBeat.o(57516);
        return sb;
    }

    @Override // kotlin.l.b.a.b.d.a.e.d
    public final /* synthetic */ Collection hCP() {
        AppMethodBeat.i(57513);
        List<c> a2 = g.a(this.Tnx);
        AppMethodBeat.o(57513);
        return a2;
    }

    @Override // kotlin.l.b.a.b.d.a.e.y
    public final /* bridge */ /* synthetic */ v hDb() {
        return this.Tnw;
    }
}
