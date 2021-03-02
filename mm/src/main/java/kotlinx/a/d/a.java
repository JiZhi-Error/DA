package kotlinx.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.l.b;
import kotlinx.a.h;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J(\u0010\u0007\u001a\n\u0012\u0004\u0012\u0002H\t\u0018\u00010\b\"\b\b\u0000\u0010\t*\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\t0\fH\u0016J7\u0010\r\u001a\f\u0012\u0006\b\u0001\u0012\u0002H\t\u0018\u00010\b\"\b\b\u0000\u0010\t*\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\t0\f2\u0006\u0010\u000f\u001a\u0002H\tH\u0016¢\u0006\u0002\u0010\u0010J2\u0010\r\u001a\f\u0012\u0006\b\u0001\u0012\u0002H\t\u0018\u00010\b\"\b\b\u0000\u0010\t*\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\t0\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¨\u0006\u0013"}, hxF = {"Lkotlinx/serialization/modules/EmptyModule;", "Lkotlinx/serialization/modules/SerialModule;", "()V", "dumpTo", "", "collector", "Lkotlinx/serialization/modules/SerialModuleCollector;", "getContextual", "Lkotlinx/serialization/KSerializer;", "T", "", "kclass", "Lkotlin/reflect/KClass;", "getPolymorphic", "baseClass", "value", "(Lkotlin/reflect/KClass;Ljava/lang/Object;)Lkotlinx/serialization/KSerializer;", "serializedClassName", "", "kotlinx-serialization-runtime"})
public final class a implements b {
    public static final a UaI = new a();

    static {
        AppMethodBeat.i(225861);
        AppMethodBeat.o(225861);
    }

    private a() {
    }

    @Override // kotlinx.a.d.b
    public final <T> h<? extends T> a(b<T> bVar, T t) {
        AppMethodBeat.i(225858);
        p.h(bVar, "baseClass");
        p.h(t, "value");
        AppMethodBeat.o(225858);
        return null;
    }

    @Override // kotlinx.a.d.b
    public final <T> h<? extends T> a(b<T> bVar, String str) {
        AppMethodBeat.i(225859);
        p.h(bVar, "baseClass");
        p.h(str, "serializedClassName");
        AppMethodBeat.o(225859);
        return null;
    }

    @Override // kotlinx.a.d.b
    public final void a(d dVar) {
        AppMethodBeat.i(225860);
        p.h(dVar, "collector");
        AppMethodBeat.o(225860);
    }
}
