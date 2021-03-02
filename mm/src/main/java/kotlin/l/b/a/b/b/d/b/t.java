package kotlin.l.b.a.b.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Modifier;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.az;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.d.a.e.r;
import kotlin.l.b.a.b.d.a.n;

public interface t extends r {
    int getModifiers();

    public static final class a {
        public static boolean a(t tVar) {
            AppMethodBeat.i(57492);
            boolean isAbstract = Modifier.isAbstract(tVar.getModifiers());
            AppMethodBeat.o(57492);
            return isAbstract;
        }

        public static boolean b(t tVar) {
            AppMethodBeat.i(57493);
            boolean isStatic = Modifier.isStatic(tVar.getModifiers());
            AppMethodBeat.o(57493);
            return isStatic;
        }

        public static boolean c(t tVar) {
            AppMethodBeat.i(57494);
            boolean isFinal = Modifier.isFinal(tVar.getModifiers());
            AppMethodBeat.o(57494);
            return isFinal;
        }

        public static ba d(t tVar) {
            ba baVar;
            AppMethodBeat.i(57495);
            int modifiers = tVar.getModifiers();
            if (Modifier.isPublic(modifiers)) {
                ba baVar2 = az.ThU;
                p.g(baVar2, "Visibilities.PUBLIC");
                AppMethodBeat.o(57495);
                return baVar2;
            } else if (Modifier.isPrivate(modifiers)) {
                ba baVar3 = az.ThQ;
                p.g(baVar3, "Visibilities.PRIVATE");
                AppMethodBeat.o(57495);
                return baVar3;
            } else if (Modifier.isProtected(modifiers)) {
                if (Modifier.isStatic(modifiers)) {
                    baVar = n.Tpf;
                } else {
                    baVar = n.Tpg;
                }
                p.g(baVar, "if (Modifier.isStatic(mo…ies.PROTECTED_AND_PACKAGE");
                AppMethodBeat.o(57495);
                return baVar;
            } else {
                ba baVar4 = n.Tpe;
                p.g(baVar4, "JavaVisibilities.PACKAGE_VISIBILITY");
                AppMethodBeat.o(57495);
                return baVar4;
            }
        }
    }
}
