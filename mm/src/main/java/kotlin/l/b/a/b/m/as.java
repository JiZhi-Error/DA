package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;

public final class as {
    public static final boolean at(ab abVar) {
        AppMethodBeat.i(60826);
        p.h(abVar, "$this$isCustomTypeVariable");
        bg hLF = abVar.hLF();
        if (!(hLF instanceof k)) {
            hLF = null;
        }
        k kVar = (k) hLF;
        if (kVar != null) {
            boolean hDZ = kVar.hDZ();
            AppMethodBeat.o(60826);
            return hDZ;
        }
        AppMethodBeat.o(60826);
        return false;
    }

    public static final k au(ab abVar) {
        AppMethodBeat.i(60827);
        p.h(abVar, "$this$getCustomTypeVariable");
        bg hLF = abVar.hLF();
        if (!(hLF instanceof k)) {
            hLF = null;
        }
        k kVar = (k) hLF;
        if (kVar == null) {
            AppMethodBeat.o(60827);
            return null;
        } else if (kVar.hDZ()) {
            AppMethodBeat.o(60827);
            return kVar;
        } else {
            AppMethodBeat.o(60827);
            return null;
        }
    }

    public static final ab av(ab abVar) {
        ab hKC;
        AppMethodBeat.i(60828);
        p.h(abVar, "$this$getSubtypeRepresentative");
        bg hLF = abVar.hLF();
        if (!(hLF instanceof ar)) {
            hLF = null;
        }
        ar arVar = (ar) hLF;
        if (!(arVar == null || (hKC = arVar.hKC()) == null)) {
            abVar = hKC;
        }
        AppMethodBeat.o(60828);
        return abVar;
    }

    public static final ab aw(ab abVar) {
        ab hKD;
        AppMethodBeat.i(60829);
        p.h(abVar, "$this$getSupertypeRepresentative");
        bg hLF = abVar.hLF();
        if (!(hLF instanceof ar)) {
            hLF = null;
        }
        ar arVar = (ar) hLF;
        if (!(arVar == null || (hKD = arVar.hKD()) == null)) {
            abVar = hKD;
        }
        AppMethodBeat.o(60829);
        return abVar;
    }

    public static final boolean b(ab abVar, ab abVar2) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(60830);
        p.h(abVar, "first");
        p.h(abVar2, "second");
        bg hLF = abVar.hLF();
        if (!(hLF instanceof ar)) {
            hLF = null;
        }
        ar arVar = (ar) hLF;
        if (arVar != null) {
            z = arVar.ac(abVar2);
        } else {
            z = false;
        }
        if (!z) {
            bg hLF2 = abVar2.hLF();
            if (!(hLF2 instanceof ar)) {
                hLF2 = null;
            }
            ar arVar2 = (ar) hLF2;
            if (arVar2 != null) {
                z2 = arVar2.ac(abVar);
            } else {
                z2 = false;
            }
            if (!z2) {
                AppMethodBeat.o(60830);
                return false;
            }
        }
        AppMethodBeat.o(60830);
        return true;
    }
}
