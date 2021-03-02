package kotlin.l.b.a.b.d.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.l.b.a.b.b.a;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.ak;
import kotlin.l.b.a.b.b.am;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.b;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.c.ae;
import kotlin.l.b.a.b.b.c.p;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.t;
import kotlin.l.b.a.b.b.w;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.n.c;
import kotlin.l.b.a.b.n.d;
import kotlin.l.b.a.b.n.i;
import kotlin.o;

public class f extends ae implements b {
    static final /* synthetic */ boolean $assertionsDisabled = (!f.class.desiredAssertionStatus());
    public static final a.AbstractC2276a<av> Tqz = new a.AbstractC2276a<av>() {
        /* class kotlin.l.b.a.b.d.a.b.f.AnonymousClass1 */
    };
    private a TqA;

    private static /* synthetic */ void atM(int i2) {
        String str;
        int i3;
        Throwable illegalStateException;
        AppMethodBeat.i(57722);
        switch (i2) {
            case 12:
            case 17:
            case 20:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 12:
            case 17:
            case 20:
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
            case 15:
                objArr[0] = "annotations";
                break;
            case 2:
            case 7:
                objArr[0] = "name";
                break;
            case 3:
            case 14:
                objArr[0] = "kind";
                break;
            case 4:
            case 8:
            case 16:
                objArr[0] = "source";
                break;
            case 5:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 9:
                objArr[0] = "typeParameters";
                break;
            case 10:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 11:
                objArr[0] = "visibility";
                break;
            case 12:
            case 17:
            case 20:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor";
                break;
            case 13:
                objArr[0] = "newOwner";
                break;
            case 18:
                objArr[0] = "enhancedValueParametersData";
                break;
            case 19:
                objArr[0] = "enhancedReturnType";
                break;
        }
        switch (i2) {
            case 12:
                objArr[1] = "initialize";
                break;
            case 17:
                objArr[1] = "createSubstitutedCopy";
                break;
            case 20:
                objArr[1] = "enhance";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor";
                break;
        }
        switch (i2) {
            case 5:
            case 6:
            case 7:
            case 8:
                objArr[2] = "createJavaMethod";
                break;
            case 9:
            case 10:
            case 11:
                objArr[2] = "initialize";
                break;
            case 12:
            case 17:
            case 20:
                break;
            case 13:
            case 14:
            case 15:
            case 16:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 18:
            case 19:
                objArr[2] = "enhance";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 12:
            case 17:
            case 20:
                illegalStateException = new IllegalStateException(format);
                break;
            default:
                illegalStateException = new IllegalArgumentException(format);
                break;
        }
        AppMethodBeat.o(57722);
        throw illegalStateException;
    }

    static {
        AppMethodBeat.i(57721);
        AppMethodBeat.o(57721);
    }

    @Override // kotlin.l.b.a.b.b.c.p, kotlin.l.b.a.b.b.c.ae
    public final /* synthetic */ p a(l lVar, t tVar, b.a aVar, kotlin.l.b.a.b.f.f fVar, g gVar, an anVar) {
        AppMethodBeat.i(57719);
        if (lVar == null) {
            atM(13);
        }
        if (aVar == null) {
            atM(14);
        }
        if (gVar == null) {
            atM(15);
        }
        if (anVar == null) {
            atM(16);
        }
        f fVar2 = new f(lVar, (am) tVar, gVar, fVar != null ? fVar : hAH(), aVar, anVar);
        fVar2.bo(hCc(), hAx());
        AppMethodBeat.o(57719);
        return fVar2;
    }

    @Override // kotlin.l.b.a.b.d.a.b.b
    public final /* synthetic */ b a(ab abVar, List list, ab abVar2, o oVar) {
        ak a2;
        AppMethodBeat.i(57720);
        if (abVar2 == null) {
            atM(19);
        }
        List<av> a3 = k.a(list, hAw(), this);
        if (abVar == null) {
            a2 = null;
        } else {
            g.a aVar = g.TiC;
            a2 = kotlin.l.b.a.b.j.b.a(this, abVar, g.a.hBP());
        }
        f fVar = (f) hBa().kz(a3).G(abVar2).a(a2).hBd().hBc().hBg();
        if ($assertionsDisabled || fVar != null) {
            if (oVar != null) {
                fVar.a((a.AbstractC2276a) oVar.first, (Object) oVar.second);
            }
            if (fVar == null) {
                atM(20);
            }
            AppMethodBeat.o(57720);
            return fVar;
        }
        AssertionError assertionError = new AssertionError("null after substitution while enhancing " + toString());
        AppMethodBeat.o(57720);
        throw assertionError;
    }

    /* access modifiers changed from: package-private */
    public enum a {
        NON_STABLE_DECLARED(false, false),
        STABLE_DECLARED(true, false),
        NON_STABLE_SYNTHESIZED(false, true),
        STABLE_SYNTHESIZED(true, true);
        
        public final boolean TqF;
        public final boolean TqG;

        public static a valueOf(String str) {
            AppMethodBeat.i(57710);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(57710);
            return aVar;
        }

        static {
            AppMethodBeat.i(57712);
            AppMethodBeat.o(57712);
        }

        private a(boolean z, boolean z2) {
            this.TqF = z;
            this.TqG = z2;
        }

        public static a bp(boolean z, boolean z2) {
            a aVar;
            AppMethodBeat.i(57711);
            if (z) {
                aVar = z2 ? STABLE_SYNTHESIZED : STABLE_DECLARED;
            } else {
                aVar = z2 ? NON_STABLE_SYNTHESIZED : NON_STABLE_DECLARED;
            }
            if (aVar == null) {
                IllegalStateException illegalStateException = new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor$ParameterNamesStatus", "get"));
                AppMethodBeat.o(57711);
                throw illegalStateException;
            }
            AppMethodBeat.o(57711);
            return aVar;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private f(l lVar, am amVar, g gVar, kotlin.l.b.a.b.f.f fVar, b.a aVar, an anVar) {
        super(lVar, amVar, gVar, fVar, aVar, anVar);
        if (lVar == null) {
            atM(0);
        }
        if (gVar == null) {
            atM(1);
        }
        if (fVar == null) {
            atM(2);
        }
        if (aVar == null) {
            atM(3);
        }
        if (anVar == null) {
            atM(4);
        }
        AppMethodBeat.i(57713);
        this.TqA = null;
        AppMethodBeat.o(57713);
    }

    public static f a(l lVar, g gVar, kotlin.l.b.a.b.f.f fVar, an anVar) {
        AppMethodBeat.i(57714);
        if (lVar == null) {
            atM(5);
        }
        if (gVar == null) {
            atM(6);
        }
        if (fVar == null) {
            atM(7);
        }
        if (anVar == null) {
            atM(8);
        }
        f fVar2 = new f(lVar, null, gVar, fVar, b.a.DECLARATION, anVar);
        AppMethodBeat.o(57714);
        return fVar2;
    }

    @Override // kotlin.l.b.a.b.b.c.ae
    public final ae a(ak akVar, ak akVar2, List<? extends as> list, List<av> list2, ab abVar, w wVar, ba baVar, Map<? extends a.AbstractC2276a<?>, ?> map) {
        c.a aVar;
        boolean z;
        AppMethodBeat.i(57715);
        if (list == null) {
            atM(9);
        }
        if (list2 == null) {
            atM(10);
        }
        if (baVar == null) {
            atM(11);
        }
        ae a2 = super.a(akVar, akVar2, list, list2, abVar, wVar, baVar, map);
        i iVar = i.TQu;
        kotlin.g.b.p.h(a2, "functionDescriptor");
        Iterator<d> it = iVar.hLQ().iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = c.a.TQf;
                break;
            }
            d next = it.next();
            kotlin.g.b.p.h(a2, "functionDescriptor");
            if (next.TjT == null || !(!kotlin.g.b.p.j(a2.hAH(), next.TjT))) {
                if (next.TQh != null) {
                    String sG = a2.hAH().sG();
                    kotlin.g.b.p.g(sG, "functionDescriptor.name.asString()");
                    if (!next.TQh.aJ(sG)) {
                        z = false;
                        continue;
                    }
                }
                if (next.TQi == null || next.TQi.contains(a2.hAH())) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
            } else {
                z = false;
                continue;
            }
            if (z) {
                kotlin.g.b.p.h(a2, "functionDescriptor");
                kotlin.l.b.a.b.n.b[] bVarArr = next.TQk;
                int length = bVarArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        String invoke = next.TQj.invoke(a2);
                        if (invoke != null) {
                            aVar = new c.b(invoke);
                        } else {
                            aVar = c.C2364c.TQg;
                        }
                    } else {
                        String i3 = bVarArr[i2].i(a2);
                        if (i3 != null) {
                            aVar = new c.b(i3);
                            break;
                        }
                        i2++;
                    }
                }
            }
        }
        this.TkM = aVar.isSuccess;
        if (a2 == null) {
            atM(12);
        }
        AppMethodBeat.o(57715);
        return a2;
    }

    @Override // kotlin.l.b.a.b.b.c.p
    public final boolean hCc() {
        AppMethodBeat.i(57716);
        if ($assertionsDisabled || this.TqA != null) {
            boolean z = this.TqA.TqF;
            AppMethodBeat.o(57716);
            return z;
        }
        AssertionError assertionError = new AssertionError("Parameter names status was not set: ".concat(String.valueOf(this)));
        AppMethodBeat.o(57716);
        throw assertionError;
    }

    @Override // kotlin.l.b.a.b.b.a, kotlin.l.b.a.b.b.c.p
    public final boolean hAx() {
        AppMethodBeat.i(57717);
        if ($assertionsDisabled || this.TqA != null) {
            boolean z = this.TqA.TqG;
            AppMethodBeat.o(57717);
            return z;
        }
        AssertionError assertionError = new AssertionError("Parameter names status was not set: ".concat(String.valueOf(this)));
        AppMethodBeat.o(57717);
        throw assertionError;
    }

    public final void bo(boolean z, boolean z2) {
        AppMethodBeat.i(57718);
        this.TqA = a.bp(z, z2);
        AppMethodBeat.o(57718);
    }
}
