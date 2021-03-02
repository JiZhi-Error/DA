package kotlin.l.b.a.b.m;

import android.support.constraint.ConstraintLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bv;
import com.tencent.mm.plugin.appbrand.jsapi.pay.n;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.b;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.h;
import kotlin.l.b.a.b.m.a.i;
import kotlin.l.b.a.b.m.a.p;

public class bc {
    static final /* synthetic */ boolean $assertionsDisabled = (!bc.class.desiredAssertionStatus());
    public static final aj TOL = u.buo("DONT_CARE");
    public static final aj TOM = u.bun("Cannot be inferred");
    public static final aj TON = new a("NO_EXPECTED_TYPE");
    public static final aj TOO = new a("UNIT_EXPECTED_TYPE");

    private static /* synthetic */ void atM(int i2) {
        String str;
        int i3;
        Throwable illegalStateException;
        AppMethodBeat.i(60902);
        switch (i2) {
            case 4:
            case 6:
            case 7:
            case 9:
            case 11:
            case 15:
            case 17:
            case 19:
            case 26:
            case 35:
            case 47:
            case 52:
            case 55:
            case 56:
            case n.CTRL_INDEX:
            case 58:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 4:
            case 6:
            case 7:
            case 9:
            case 11:
            case 15:
            case 17:
            case 19:
            case 26:
            case 35:
            case 47:
            case 52:
            case 55:
            case 56:
            case n.CTRL_INDEX:
            case 58:
                i3 = 2;
                break;
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 4:
            case 6:
            case 7:
            case 9:
            case 11:
            case 15:
            case 17:
            case 19:
            case 26:
            case 35:
            case 47:
            case 52:
            case 55:
            case 56:
            case n.CTRL_INDEX:
            case 58:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils";
                break;
            case 5:
            case 8:
            case 10:
            case 18:
            case 23:
            case 25:
            case 27:
            case 28:
            case 29:
            case 30:
            case 38:
            case 40:
            default:
                objArr[0] = "type";
                break;
            case 12:
                objArr[0] = "typeConstructor";
                break;
            case 13:
                objArr[0] = "unsubstitutedMemberScope";
                break;
            case 14:
                objArr[0] = "refinedTypeFactory";
                break;
            case 16:
                objArr[0] = "parameters";
                break;
            case 20:
                objArr[0] = "subType";
                break;
            case 21:
                objArr[0] = "superType";
                break;
            case 22:
                objArr[0] = "substitutor";
                break;
            case 24:
                objArr[0] = "result";
                break;
            case 31:
            case 33:
                objArr[0] = "clazz";
                break;
            case 32:
                objArr[0] = "typeArguments";
                break;
            case 34:
                objArr[0] = "projections";
                break;
            case 36:
                objArr[0] = "a";
                break;
            case 37:
                objArr[0] = "b";
                break;
            case 39:
                objArr[0] = "typeParameters";
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_CREATOR:
                objArr[0] = "typeParameterConstructors";
                break;
            case 42:
                objArr[0] = "specialType";
                break;
            case 43:
            case 44:
                objArr[0] = "isSpecialType";
                break;
            case 45:
                objArr[0] = "parameterDescriptor";
                break;
            case 46:
            case 50:
                objArr[0] = "numberValueTypeConstructor";
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
            case 49:
                objArr[0] = "supertypes";
                break;
            case 51:
            case 54:
                objArr[0] = "expectedType";
                break;
            case 53:
                objArr[0] = "literalTypeConstructor";
                break;
        }
        switch (i2) {
            case 4:
                objArr[1] = "makeNullableAsSpecified";
                break;
            case 6:
            case 7:
            case 9:
                objArr[1] = "makeNullableIfNeeded";
                break;
            case 11:
            case 15:
                objArr[1] = "makeUnsubstitutedType";
                break;
            case 17:
                objArr[1] = "getDefaultTypeProjections";
                break;
            case 19:
                objArr[1] = "getImmediateSupertypes";
                break;
            case 26:
                objArr[1] = "getAllSupertypes";
                break;
            case 35:
                objArr[1] = "substituteProjectionsForParameters";
                break;
            case 47:
                objArr[1] = "getDefaultPrimitiveNumberType";
                break;
            case 52:
            case 55:
            case 56:
            case n.CTRL_INDEX:
            case 58:
                objArr[1] = "getPrimitiveNumberType";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils";
                break;
        }
        switch (i2) {
            case 1:
                objArr[2] = "makeNullable";
                break;
            case 2:
                objArr[2] = "makeNotNullable";
                break;
            case 3:
                objArr[2] = "makeNullableAsSpecified";
                break;
            case 4:
            case 6:
            case 7:
            case 9:
            case 11:
            case 15:
            case 17:
            case 19:
            case 26:
            case 35:
            case 47:
            case 52:
            case 55:
            case 56:
            case n.CTRL_INDEX:
            case 58:
                break;
            case 5:
            case 8:
                objArr[2] = "makeNullableIfNeeded";
                break;
            case 10:
                objArr[2] = "canHaveSubtypes";
                break;
            case 12:
            case 13:
            case 14:
                objArr[2] = "makeUnsubstitutedType";
                break;
            case 16:
                objArr[2] = "getDefaultTypeProjections";
                break;
            case 18:
                objArr[2] = "getImmediateSupertypes";
                break;
            case 20:
            case 21:
            case 22:
                objArr[2] = "createSubstitutedSupertype";
                break;
            case 23:
            case 24:
                objArr[2] = "collectAllSupertypes";
                break;
            case 25:
                objArr[2] = "getAllSupertypes";
                break;
            case 27:
                objArr[2] = "isNullableType";
                break;
            case 28:
                objArr[2] = "acceptsNullable";
                break;
            case 29:
                objArr[2] = "hasNullableSuperType";
                break;
            case 30:
                objArr[2] = "getClassDescriptor";
                break;
            case 31:
            case 32:
                objArr[2] = "substituteParameters";
                break;
            case 33:
            case 34:
                objArr[2] = "substituteProjectionsForParameters";
                break;
            case 36:
            case 37:
                objArr[2] = "equalTypes";
                break;
            case 38:
            case 39:
                objArr[2] = "dependsOnTypeParameters";
                break;
            case 40:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_CREATOR:
                objArr[2] = "dependsOnTypeConstructors";
                break;
            case 42:
            case 43:
            case 44:
                objArr[2] = "contains";
                break;
            case 45:
                objArr[2] = "makeStarProjection";
                break;
            case 46:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                objArr[2] = "getDefaultPrimitiveNumberType";
                break;
            case 49:
                objArr[2] = "findByFqName";
                break;
            case 50:
            case 51:
            case 53:
            case 54:
                objArr[2] = "getPrimitiveNumberType";
                break;
            case bv.CTRL_INDEX:
                objArr[2] = "isTypeParameter";
                break;
            case 60:
                objArr[2] = "isReifiedTypeParameter";
                break;
            case PlayerException.EXCEPTION_TYPE_INITLIB:
                objArr[2] = "isNonReifiedTypeParameter";
                break;
            case 62:
                objArr[2] = "getTypeParameterDescriptorOrNull";
                break;
            default:
                objArr[2] = "noExpectedType";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 4:
            case 6:
            case 7:
            case 9:
            case 11:
            case 15:
            case 17:
            case 19:
            case 26:
            case 35:
            case 47:
            case 52:
            case 55:
            case 56:
            case n.CTRL_INDEX:
            case 58:
                illegalStateException = new IllegalStateException(format);
                break;
            default:
                illegalStateException = new IllegalArgumentException(format);
                break;
        }
        AppMethodBeat.o(60902);
        throw illegalStateException;
    }

    static {
        AppMethodBeat.i(60901);
        AppMethodBeat.o(60901);
    }

    public static class a extends n {
        private final String name;

        private static /* synthetic */ void atM(int i2) {
            String str;
            int i3;
            Throwable illegalStateException;
            AppMethodBeat.i(60884);
            switch (i2) {
                case 1:
                case 4:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                case 2:
                case 3:
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
            switch (i2) {
                case 1:
                case 4:
                    i3 = 2;
                    break;
                case 2:
                case 3:
                default:
                    i3 = 3;
                    break;
            }
            Object[] objArr = new Object[i3];
            switch (i2) {
                case 1:
                case 4:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils$SpecialType";
                    break;
                case 2:
                    objArr[0] = "delegate";
                    break;
                case 3:
                    objArr[0] = "kotlinTypeRefiner";
                    break;
                default:
                    objArr[0] = "newAnnotations";
                    break;
            }
            switch (i2) {
                case 1:
                    objArr[1] = "toString";
                    break;
                case 2:
                case 3:
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils$SpecialType";
                    break;
                case 4:
                    objArr[1] = "refine";
                    break;
            }
            switch (i2) {
                case 1:
                case 4:
                    break;
                case 2:
                    objArr[2] = "replaceDelegate";
                    break;
                case 3:
                    objArr[2] = "refine";
                    break;
                default:
                    objArr[2] = "replaceAnnotations";
                    break;
            }
            String format = String.format(str, objArr);
            switch (i2) {
                case 1:
                case 4:
                    illegalStateException = new IllegalStateException(format);
                    break;
                case 2:
                case 3:
                default:
                    illegalStateException = new IllegalArgumentException(format);
                    break;
            }
            AppMethodBeat.o(60884);
            throw illegalStateException;
        }

        @Override // kotlin.l.b.a.b.m.bg
        public final /* synthetic */ bg EF(boolean z) {
            AppMethodBeat.i(60881);
            aj EG = EG(z);
            AppMethodBeat.o(60881);
            return EG;
        }

        @Override // kotlin.l.b.a.b.m.bg
        public final /* synthetic */ bg b(g gVar) {
            AppMethodBeat.i(60882);
            aj d2 = d(gVar);
            AppMethodBeat.o(60882);
            return d2;
        }

        @Override // kotlin.l.b.a.b.m.n, kotlin.l.b.a.b.m.ab
        public final /* synthetic */ ab d(i iVar) {
            AppMethodBeat.i(60883);
            a n = n(iVar);
            AppMethodBeat.o(60883);
            return n;
        }

        @Override // kotlin.l.b.a.b.m.bg, kotlin.l.b.a.b.m.n
        public final /* synthetic */ bg e(i iVar) {
            AppMethodBeat.i(60880);
            a n = n(iVar);
            AppMethodBeat.o(60880);
            return n;
        }

        @Override // kotlin.l.b.a.b.m.n
        public final /* synthetic */ aj i(i iVar) {
            AppMethodBeat.i(60879);
            a n = n(iVar);
            AppMethodBeat.o(60879);
            return n;
        }

        public a(String str) {
            this.name = str;
        }

        /* access modifiers changed from: protected */
        @Override // kotlin.l.b.a.b.m.n
        public final aj hDW() {
            AppMethodBeat.i(60873);
            IllegalStateException illegalStateException = new IllegalStateException(this.name);
            AppMethodBeat.o(60873);
            throw illegalStateException;
        }

        @Override // kotlin.l.b.a.b.m.aj
        public final aj d(g gVar) {
            AppMethodBeat.i(60874);
            if (gVar == null) {
                atM(0);
            }
            IllegalStateException illegalStateException = new IllegalStateException(this.name);
            AppMethodBeat.o(60874);
            throw illegalStateException;
        }

        @Override // kotlin.l.b.a.b.m.aj
        public final aj EG(boolean z) {
            AppMethodBeat.i(60875);
            IllegalStateException illegalStateException = new IllegalStateException(this.name);
            AppMethodBeat.o(60875);
            throw illegalStateException;
        }

        @Override // kotlin.l.b.a.b.m.aj
        public final String toString() {
            AppMethodBeat.i(60876);
            String str = this.name;
            if (str == null) {
                atM(1);
            }
            AppMethodBeat.o(60876);
            return str;
        }

        @Override // kotlin.l.b.a.b.m.n
        public final n b(aj ajVar) {
            AppMethodBeat.i(60877);
            if (ajVar == null) {
                atM(2);
            }
            IllegalStateException illegalStateException = new IllegalStateException(this.name);
            AppMethodBeat.o(60877);
            throw illegalStateException;
        }

        private a n(i iVar) {
            AppMethodBeat.i(60878);
            if (iVar == null) {
                atM(3);
            }
            AppMethodBeat.o(60878);
            return this;
        }
    }

    public static boolean aA(ab abVar) {
        AppMethodBeat.i(60885);
        if (abVar == null) {
            atM(0);
        }
        if (abVar == TON || abVar == TOO) {
            AppMethodBeat.o(60885);
            return true;
        }
        AppMethodBeat.o(60885);
        return false;
    }

    public static boolean aB(ab abVar) {
        AppMethodBeat.i(60886);
        if (abVar == null || abVar.hKE() != TOL.hKE()) {
            AppMethodBeat.o(60886);
            return false;
        }
        AppMethodBeat.o(60886);
        return true;
    }

    public static ab aC(ab abVar) {
        AppMethodBeat.i(60887);
        if (abVar == null) {
            atM(1);
        }
        ab b2 = b(abVar, true);
        AppMethodBeat.o(60887);
        return b2;
    }

    public static ab aD(ab abVar) {
        AppMethodBeat.i(60888);
        if (abVar == null) {
            atM(2);
        }
        ab b2 = b(abVar, false);
        AppMethodBeat.o(60888);
        return b2;
    }

    public static ab b(ab abVar, boolean z) {
        AppMethodBeat.i(60889);
        if (abVar == null) {
            atM(3);
        }
        bg EF = abVar.hLF().EF(z);
        if (EF == null) {
            atM(4);
        }
        AppMethodBeat.o(60889);
        return EF;
    }

    public static ab c(ab abVar, boolean z) {
        AppMethodBeat.i(60890);
        if (abVar == null) {
            atM(8);
        }
        if (z) {
            ab aC = aC(abVar);
            AppMethodBeat.o(60890);
            return aC;
        }
        if (abVar == null) {
            atM(9);
        }
        AppMethodBeat.o(60890);
        return abVar;
    }

    public static aj a(h hVar, kotlin.l.b.a.b.j.f.h hVar2, b<i, aj> bVar) {
        AppMethodBeat.i(60891);
        if (u.L(hVar)) {
            aj bun = u.bun("Unsubstituted type for ".concat(String.valueOf(hVar)));
            if (bun == null) {
                atM(11);
            }
            AppMethodBeat.o(60891);
            return bun;
        }
        at hzz = hVar.hzz();
        if (hzz == null) {
            atM(12);
        }
        if (hVar2 == null) {
            atM(13);
        }
        List<av> kI = kI(hzz.getParameters());
        g.a aVar = g.TiC;
        aj a2 = ac.a(g.a.hBP(), hzz, kI, false, hVar2, bVar);
        AppMethodBeat.o(60891);
        return a2;
    }

    public static List<av> kI(List<as> list) {
        AppMethodBeat.i(60892);
        if (list == null) {
            atM(16);
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (as asVar : list) {
            arrayList.add(new ax(asVar.hAG()));
        }
        List<av> p = j.p(arrayList);
        if (p == null) {
            atM(17);
        }
        AppMethodBeat.o(60892);
        return p;
    }

    public static boolean aE(ab abVar) {
        ab abVar2;
        AppMethodBeat.i(60893);
        if (abVar == null) {
            atM(27);
        }
        if (abVar.hEa()) {
            AppMethodBeat.o(60893);
            return true;
        } else if (y.al(abVar) && aE(y.am(abVar).TNW)) {
            AppMethodBeat.o(60893);
            return true;
        } else if (aH(abVar)) {
            if (abVar == null) {
                atM(29);
            }
            if (!(abVar.hKE().hzS() instanceof e)) {
                if (abVar == null) {
                    atM(18);
                }
                ba az = ba.az(abVar);
                Collection<ab> hBV = abVar.hKE().hBV();
                ArrayList<ab> arrayList = new ArrayList(hBV.size());
                for (ab abVar3 : hBV) {
                    if (abVar == null) {
                        atM(20);
                    }
                    if (abVar3 == null) {
                        atM(21);
                    }
                    if (az == null) {
                        atM(22);
                    }
                    ab c2 = az.c(abVar3, bh.INVARIANT);
                    if (c2 != null) {
                        abVar2 = c(c2, abVar.hEa());
                    } else {
                        abVar2 = null;
                    }
                    if (abVar2 != null) {
                        arrayList.add(abVar2);
                    }
                }
                for (ab abVar4 : arrayList) {
                    if (aE(abVar4)) {
                        AppMethodBeat.o(60893);
                        return true;
                    }
                }
            }
            AppMethodBeat.o(60893);
            return false;
        } else {
            at hKE = abVar.hKE();
            if (hKE instanceof aa) {
                for (ab abVar5 : hKE.hBV()) {
                    if (aE(abVar5)) {
                        AppMethodBeat.o(60893);
                        return true;
                    }
                }
            }
            AppMethodBeat.o(60893);
            return false;
        }
    }

    public static boolean aF(ab abVar) {
        AppMethodBeat.i(60894);
        if (abVar == null) {
            atM(28);
        }
        if (abVar.hEa()) {
            AppMethodBeat.o(60894);
            return true;
        } else if (!y.al(abVar) || !aF(y.am(abVar).TNW)) {
            AppMethodBeat.o(60894);
            return false;
        } else {
            AppMethodBeat.o(60894);
            return true;
        }
    }

    public static e aG(ab abVar) {
        AppMethodBeat.i(60895);
        if (abVar == null) {
            atM(30);
        }
        h hzS = abVar.hKE().hzS();
        if (hzS instanceof e) {
            e eVar = (e) hzS;
            AppMethodBeat.o(60895);
            return eVar;
        }
        AppMethodBeat.o(60895);
        return null;
    }

    public static boolean b(ab abVar, b<bg, Boolean> bVar) {
        AppMethodBeat.i(60896);
        if (bVar == null) {
            atM(43);
        }
        boolean a2 = a(abVar, bVar, new HashSet());
        AppMethodBeat.o(60896);
        return a2;
    }

    private static boolean a(ab abVar, b<bg, Boolean> bVar, HashSet<ab> hashSet) {
        AppMethodBeat.i(60897);
        if (bVar == null) {
            atM(44);
        }
        if (abVar == null) {
            AppMethodBeat.o(60897);
            return false;
        } else if (hashSet.contains(abVar)) {
            AppMethodBeat.o(60897);
            return false;
        } else {
            hashSet.add(abVar);
            bg hLF = abVar.hLF();
            if (bVar.invoke(hLF).booleanValue()) {
                AppMethodBeat.o(60897);
                return true;
            }
            v vVar = hLF instanceof v ? (v) hLF : null;
            if (vVar != null && (a(vVar.TNV, bVar, hashSet) || a(vVar.TNW, bVar, hashSet))) {
                AppMethodBeat.o(60897);
                return true;
            } else if (!(hLF instanceof l) || !a(((l) hLF).TNE, bVar, hashSet)) {
                at hKE = abVar.hKE();
                if (hKE instanceof aa) {
                    for (ab abVar2 : ((aa) hKE).TOe) {
                        if (a(abVar2, bVar, hashSet)) {
                            AppMethodBeat.o(60897);
                            return true;
                        }
                    }
                    AppMethodBeat.o(60897);
                    return false;
                }
                for (av avVar : abVar.hKB()) {
                    if (!avVar.hLH() && a(avVar.hBy(), bVar, hashSet)) {
                        AppMethodBeat.o(60897);
                        return true;
                    }
                }
                AppMethodBeat.o(60897);
                return false;
            } else {
                AppMethodBeat.o(60897);
                return true;
            }
        }
    }

    public static av d(as asVar) {
        AppMethodBeat.i(60898);
        if (asVar == null) {
            atM(45);
        }
        ao aoVar = new ao(asVar);
        AppMethodBeat.o(60898);
        return aoVar;
    }

    public static boolean aH(ab abVar) {
        AppMethodBeat.i(60899);
        if (abVar == null) {
            atM(59);
        }
        if (aI(abVar) != null || (abVar.hKE() instanceof p)) {
            AppMethodBeat.o(60899);
            return true;
        }
        AppMethodBeat.o(60899);
        return false;
    }

    private static as aI(ab abVar) {
        AppMethodBeat.i(60900);
        if (abVar == null) {
            atM(62);
        }
        if (abVar.hKE().hzS() instanceof as) {
            as asVar = (as) abVar.hKE().hzS();
            AppMethodBeat.o(60900);
            return asVar;
        }
        AppMethodBeat.o(60900);
        return null;
    }
}
