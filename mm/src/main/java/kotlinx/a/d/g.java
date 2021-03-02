package kotlinx.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.l.b;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001f\b\u0016\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004¢\u0006\u0002\u0010\u0006B\u0013\b\u0016\u0012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0004¢\u0006\u0002\u0010\bB\u000f\b\u0000\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000b¨\u0006\f"}, hxF = {"Lkotlinx/serialization/modules/SerializerAlreadyRegisteredException;", "Ljava/lang/IllegalArgumentException;", "Lkotlin/IllegalArgumentException;", "baseClass", "Lkotlin/reflect/KClass;", "concreteClass", "(Lkotlin/reflect/KClass;Lkotlin/reflect/KClass;)V", "forClass", "(Lkotlin/reflect/KClass;)V", "msg", "", "(Ljava/lang/String;)V", "kotlinx-serialization-runtime"})
public final class g extends IllegalArgumentException {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(String str) {
        super(str);
        p.h(str, "msg");
        AppMethodBeat.i(225871);
        AppMethodBeat.o(225871);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public g(b<?> bVar, b<?> bVar2) {
        this("Serializer for " + bVar2 + " already registered in the scope of " + bVar);
        p.h(bVar, "baseClass");
        p.h(bVar2, "concreteClass");
        AppMethodBeat.i(225872);
        AppMethodBeat.o(225872);
    }
}
