package kotlin.l.b.a.b.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.Collection;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.t;
import kotlin.l.b.a.b.f.f;
import kotlin.n.k;

public final class d {
    public final k TQh;
    public final Collection<f> TQi;
    public final b<t, String> TQj;
    public final b[] TQk;
    public final f TjT;

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.g.a.b<? super kotlin.l.b.a.b.b.t, java.lang.String> */
    /* JADX WARN: Multi-variable type inference failed */
    private d(f fVar, k kVar, Collection<f> collection, b<? super t, String> bVar, b... bVarArr) {
        this.TjT = fVar;
        this.TQh = kVar;
        this.TQi = collection;
        this.TQj = bVar;
        this.TQk = bVarArr;
    }

    public /* synthetic */ d(f fVar, b[] bVarArr) {
        this(fVar, bVarArr, AnonymousClass1.TQl);
        AppMethodBeat.i(61289);
        AppMethodBeat.o(61289);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public d(f fVar, b[] bVarArr, b<? super t, String> bVar) {
        this(fVar, null, null, bVar, (b[]) Arrays.copyOf(bVarArr, bVarArr.length));
        p.h(fVar, "name");
        p.h(bVarArr, "checks");
        p.h(bVar, "additionalChecks");
        AppMethodBeat.i(61288);
        AppMethodBeat.o(61288);
    }

    public /* synthetic */ d(k kVar, b[] bVarArr) {
        this(kVar, bVarArr, AnonymousClass2.TQm);
        AppMethodBeat.i(61291);
        AppMethodBeat.o(61291);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    private d(k kVar, b[] bVarArr, b<? super t, String> bVar) {
        this(null, kVar, null, bVar, (b[]) Arrays.copyOf(bVarArr, bVarArr.length));
        p.h(kVar, "regex");
        p.h(bVarArr, "checks");
        p.h(bVar, "additionalChecks");
        AppMethodBeat.i(61290);
        AppMethodBeat.o(61290);
    }

    public /* synthetic */ d(Collection collection, b[] bVarArr) {
        this(collection, bVarArr, AnonymousClass3.TQn);
        AppMethodBeat.i(61293);
        AppMethodBeat.o(61293);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public d(Collection<f> collection, b[] bVarArr, b<? super t, String> bVar) {
        this(null, null, collection, bVar, (b[]) Arrays.copyOf(bVarArr, bVarArr.length));
        p.h(collection, "nameList");
        p.h(bVarArr, "checks");
        p.h(bVar, "additionalChecks");
        AppMethodBeat.i(61292);
        AppMethodBeat.o(61292);
    }
}
