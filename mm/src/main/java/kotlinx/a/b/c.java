package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;
import kotlin.l.b;
import kotlinx.a.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0002\u001a \u0010\u0000\u001a\u00020\u00012\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00052\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0000¨\u0006\u0007"}, hxF = {"throwSubtypeNotRegistered", "", "subClassName", "", "baseClass", "Lkotlin/reflect/KClass;", "subClass", "kotlinx-serialization-runtime"})
public final class c {
    static final Void a(String str, b<?> bVar) {
        AppMethodBeat.i(225391);
        t tVar = new t(str + " is not registered for polymorphic serialization in the scope of " + bVar, (byte) 0);
        AppMethodBeat.o(225391);
        throw tVar;
    }
}
