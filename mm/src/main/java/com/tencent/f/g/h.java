package com.tencent.f.g;

import com.tencent.f.g.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h {
    public static b RUe;

    public enum a {
        FS_POLICY,
        LINEAR_POLICY,
        CONST_POLICY,
        THROW_POLICY,
        BLOCK_INVOKER_POLICY,
        DEFAULT;

        public static a valueOf(String str) {
            AppMethodBeat.i(183337);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(183337);
            return aVar;
        }

        static {
            AppMethodBeat.i(183338);
            AppMethodBeat.o(183338);
        }
    }

    public static b b(com.tencent.f.a aVar) {
        AppMethodBeat.i(183339);
        if (aVar.RSt != null) {
            b bVar = aVar.RSt;
            AppMethodBeat.o(183339);
            return bVar;
        }
        int max = Math.max(1, aVar.RSq / 2);
        int max2 = Math.max(1, max / 3);
        switch (aVar.RSu) {
            case FS_POLICY:
                e eVar = new e(max, max2);
                AppMethodBeat.o(183339);
                return eVar;
            case CONST_POLICY:
                c cVar = new c(max, max2);
                AppMethodBeat.o(183339);
                return cVar;
            case LINEAR_POLICY:
                f fVar = new f(max, max2);
                AppMethodBeat.o(183339);
                return fVar;
            case THROW_POLICY:
                i iVar = new i(max);
                AppMethodBeat.o(183339);
                return iVar;
            case BLOCK_INVOKER_POLICY:
                a aVar2 = new a(max2, max2);
                AppMethodBeat.o(183339);
                return aVar2;
            default:
                d dVar = new d();
                AppMethodBeat.o(183339);
                return dVar;
        }
    }
}
