package kotlinx.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.a.c.a;
import kotlinx.a.c.f;
import kotlinx.a.c.v;
import kotlinx.a.n;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0014J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, hxF = {"Lkotlinx/serialization/json/internal/JsonPrimitiveInput;", "Lkotlinx/serialization/json/internal/AbstractJsonTreeInput;", "json", "Lkotlinx/serialization/json/Json;", "value", "Lkotlinx/serialization/json/JsonPrimitive;", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/JsonPrimitive;)V", "getValue", "()Lkotlinx/serialization/json/JsonPrimitive;", "currentElement", "Lkotlinx/serialization/json/JsonElement;", "tag", "", "decodeElementIndex", "", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "kotlinx-serialization-runtime"})
public final class e extends a {
    private final v Uak;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(a aVar, v vVar) {
        super(aVar, vVar, (byte) 0);
        p.h(aVar, "json");
        p.h(vVar, "value");
        AppMethodBeat.i(225648);
        this.Uak = vVar;
        gz("primitive");
        AppMethodBeat.o(225648);
    }

    @Override // kotlinx.a.a
    public final int b(n nVar) {
        AppMethodBeat.i(225646);
        p.h(nVar, "descriptor");
        AppMethodBeat.o(225646);
        return 0;
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.a.c.a.a
    public final f buH(String str) {
        AppMethodBeat.i(225647);
        p.h(str, "tag");
        if (!(str == "primitive")) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("This input can only handle primitives with 'primitive' tag".toString());
            AppMethodBeat.o(225647);
            throw illegalArgumentException;
        }
        v vVar = this.Uak;
        AppMethodBeat.o(225647);
        return vVar;
    }

    @Override // kotlinx.a.c.a.a
    public final /* bridge */ /* synthetic */ f hOU() {
        return this.Uak;
    }
}
