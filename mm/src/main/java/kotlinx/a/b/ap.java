package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.a.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, hxF = {"Lkotlinx/serialization/internal/NamedListClassDescriptor;", "Lkotlinx/serialization/internal/ListLikeDescriptor;", "serialName", "", "elementDescriptor", "Lkotlinx/serialization/SerialDescriptor;", "(Ljava/lang/String;Lkotlinx/serialization/SerialDescriptor;)V", "getSerialName", "()Ljava/lang/String;", "kotlinx-serialization-runtime"})
public final class ap extends ah {
    private final String TXI;

    @Override // kotlinx.a.n
    public final String hOz() {
        return this.TXI;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ap(String str, n nVar) {
        super(nVar, (byte) 0);
        p.h(str, "serialName");
        p.h(nVar, "elementDescriptor");
        AppMethodBeat.i(225598);
        this.TXI = str;
        AppMethodBeat.o(225598);
    }
}
