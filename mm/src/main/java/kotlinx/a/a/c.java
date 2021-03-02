package kotlinx.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.a.b.as;
import kotlinx.a.h;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010&\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a@\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\t0\u00070\u0001\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\b0\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\t0\u0001\u001a@\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\t0\r0\u0001\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\b0\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\t0\u0001\u001aZ\u0010\u000e\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u00120\u000f0\u0001\"\u0004\b\u0000\u0010\u0010\"\u0004\b\u0001\u0010\u0011\"\u0004\b\u0002\u0010\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00100\u00012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0001\"-\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0016"}, hxF = {"nullable", "Lkotlinx/serialization/KSerializer;", "T", "", "getNullable", "(Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "MapEntrySerializer", "", "K", "V", "keySerializer", "valueSerializer", "PairSerializer", "Lkotlin/Pair;", "TripleSerializer", "Lkotlin/Triple;", "A", "B", "C", "aSerializer", "bSerializer", "cSerializer", "kotlinx-serialization-runtime"})
public final class c {
    public static final <T> h<T> a(h<T> hVar) {
        AppMethodBeat.i(225617);
        p.h(hVar, "$this$nullable");
        if (hVar.fWv().hOB()) {
            AppMethodBeat.o(225617);
            return hVar;
        }
        as asVar = new as(hVar);
        AppMethodBeat.o(225617);
        return asVar;
    }
}
