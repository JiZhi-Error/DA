package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.a.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, hxF = {"Lkotlinx/serialization/internal/PrimitiveArrayDescriptor;", "Lkotlinx/serialization/internal/ListLikeDescriptor;", "primitive", "Lkotlinx/serialization/SerialDescriptor;", "(Lkotlinx/serialization/SerialDescriptor;)V", "serialName", "", "getSerialName", "()Ljava/lang/String;", "kotlinx-serialization-runtime"})
public final class aw extends ah {
    private final String TXI;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public aw(n nVar) {
        super(nVar, (byte) 0);
        p.h(nVar, "primitive");
        AppMethodBeat.i(225531);
        this.TXI = nVar.hOz() + "Array";
        AppMethodBeat.o(225531);
    }

    @Override // kotlinx.a.n
    public final String hOz() {
        return this.TXI;
    }
}
