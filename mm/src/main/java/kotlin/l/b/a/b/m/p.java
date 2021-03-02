package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.List;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.c.ai;
import kotlin.l.b.a.b.b.l;

public final class p {
    private static /* synthetic */ void atM(int i2) {
        String str;
        int i3;
        Throwable illegalStateException;
        AppMethodBeat.i(60641);
        switch (i2) {
            case 4:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 4:
                i3 = 2;
                break;
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
            case 6:
                objArr[0] = "originalSubstitution";
                break;
            case 2:
            case 7:
                objArr[0] = "newContainingDeclaration";
                break;
            case 3:
            case 8:
                objArr[0] = "result";
                break;
            case 4:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/DescriptorSubstitutor";
                break;
            case 5:
            default:
                objArr[0] = "typeParameters";
                break;
        }
        switch (i2) {
            case 4:
                objArr[1] = "substituteTypeParameters";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/types/DescriptorSubstitutor";
                break;
        }
        switch (i2) {
            case 4:
                break;
            default:
                objArr[2] = "substituteTypeParameters";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 4:
                illegalStateException = new IllegalStateException(format);
                break;
            default:
                illegalStateException = new IllegalArgumentException(format);
                break;
        }
        AppMethodBeat.o(60641);
        throw illegalStateException;
    }

    public static ba a(List<as> list, ay ayVar, l lVar, List<as> list2) {
        AppMethodBeat.i(60639);
        if (list == null) {
            atM(0);
        }
        if (ayVar == null) {
            atM(1);
        }
        if (lVar == null) {
            atM(2);
        }
        if (list2 == null) {
            atM(3);
        }
        ba a2 = a(list, ayVar, lVar, list2, null);
        if (a2 == null) {
            AssertionError assertionError = new AssertionError("Substitution failed");
            AppMethodBeat.o(60639);
            throw assertionError;
        }
        if (a2 == null) {
            atM(4);
        }
        AppMethodBeat.o(60639);
        return a2;
    }

    public static ba a(List<as> list, ay ayVar, l lVar, List<as> list2, boolean[] zArr) {
        AppMethodBeat.i(60640);
        if (list == null) {
            atM(5);
        }
        if (ayVar == null) {
            atM(6);
        }
        if (lVar == null) {
            atM(7);
        }
        if (list2 == null) {
            atM(8);
        }
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        int i2 = 0;
        for (as asVar : list) {
            ai a2 = ai.a(lVar, asVar.hzL(), asVar.hAK(), asVar.hAJ(), asVar.hAH(), i2, an.ThK, asVar.hAI());
            hashMap.put(asVar.hzz(), new ax(a2.hAG()));
            hashMap2.put(asVar, a2);
            list2.add(a2);
            i2++;
        }
        ba b2 = ba.b(ayVar, au.cB(hashMap));
        for (as asVar2 : list) {
            ai aiVar = (ai) hashMap2.get(asVar2);
            for (ab abVar : asVar2.hyo()) {
                ab c2 = b2.c(abVar, bh.IN_VARIANCE);
                if (c2 == null) {
                    AppMethodBeat.o(60640);
                    return null;
                }
                if (!(c2 == abVar || zArr == null)) {
                    zArr[0] = true;
                }
                aiVar.K(c2);
            }
            aiVar.setInitialized();
        }
        AppMethodBeat.o(60640);
        return b2;
    }
}
