package kotlinx.a;

import kotlin.g.a;
import kotlin.g.b.aa;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.l.b;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u0001\u0004\u0005\u0006\u0007\b¨\u0006\t"}, hxF = {"Lkotlinx/serialization/SerialKind;", "", "()V", "toString", "", "Lkotlinx/serialization/PrimitiveKind;", "Lkotlinx/serialization/StructureKind;", "Lkotlinx/serialization/UnionKind;", "Lkotlinx/serialization/PolymorphicKind;", "kotlinx-serialization-runtime"})
public abstract class s {
    private s() {
    }

    public /* synthetic */ s(byte b2) {
        this();
    }

    public String toString() {
        b bp = aa.bp(getClass());
        p.h(bp, "$this$simpleName");
        String simpleName = a.a(bp).getSimpleName();
        if (simpleName == null) {
            p.hyc();
        }
        return simpleName;
    }
}
