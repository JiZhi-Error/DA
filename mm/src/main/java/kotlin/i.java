package kotlin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.a;
import kotlin.g.b.p;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\u001a*\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\u001a(\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004¨\u0006\t"}, hxF = {"lazy", "Lkotlin/Lazy;", "T", "initializer", "Lkotlin/Function0;", "lock", "", "mode", "Lkotlin/LazyThreadSafetyMode;", "kotlin-stdlib"}, hxG = 1)
public class i {
    public static final <T> f<T> ah(a<? extends T> aVar) {
        AppMethodBeat.i(129243);
        p.h(aVar, "initializer");
        q qVar = new q(aVar, (byte) 0);
        AppMethodBeat.o(129243);
        return qVar;
    }

    public static final <T> f<T> a(k kVar, a<? extends T> aVar) {
        AppMethodBeat.i(129244);
        p.h(kVar, "mode");
        p.h(aVar, "initializer");
        switch (h.$EnumSwitchMapping$0[kVar.ordinal()]) {
            case 1:
                q qVar = new q(aVar, (byte) 0);
                AppMethodBeat.o(129244);
                return qVar;
            case 2:
                p pVar = new p(aVar);
                AppMethodBeat.o(129244);
                return pVar;
            case 3:
                y yVar = new y(aVar);
                AppMethodBeat.o(129244);
                return yVar;
            default:
                m mVar = new m();
                AppMethodBeat.o(129244);
                throw mVar;
        }
    }
}
