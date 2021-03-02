package kotlin.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.aq;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.n;
import kotlin.l.b.a.b.j.f.h;
import kotlin.l.b.a.b.j.f.m;
import kotlin.l.b.a.b.l.f;
import kotlin.l.b.a.b.l.j;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.ac;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.b.a.b.m.at;
import kotlin.l.b.a.b.m.bh;
import kotlin.l.b.a.b.m.u;

public abstract class e extends k implements as {
    private final j TcN;
    private final f<aj> TjU;
    private final bh Tke;
    final boolean Tkf;
    private final f<at> Tkg;
    private final int index;

    private static /* synthetic */ void atM(int i2) {
        String str;
        int i3;
        switch (i2) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                i3 = 2;
                break;
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
                objArr[0] = "containingDeclaration";
                break;
            case 2:
                objArr[0] = "annotations";
                break;
            case 3:
                objArr[0] = "name";
                break;
            case 4:
                objArr[0] = "variance";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
                objArr[0] = "supertypeLoopChecker";
                break;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        switch (i2) {
            case 7:
                objArr[1] = "getVariance";
                break;
            case 8:
                objArr[1] = "getUpperBounds";
                break;
            case 9:
                objArr[1] = "getTypeConstructor";
                break;
            case 10:
                objArr[1] = "getDefaultType";
                break;
            case 11:
                objArr[1] = "getOriginal";
                break;
            case 12:
                objArr[1] = "getStorageManager";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor";
                break;
        }
        switch (i2) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                throw new IllegalStateException(format);
            default:
                throw new IllegalArgumentException(format);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void H(ab abVar);

    /* access modifiers changed from: protected */
    public abstract List<ab> hBW();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected e(final j jVar, l lVar, g gVar, final kotlin.l.b.a.b.f.f fVar, bh bhVar, boolean z, int i2, an anVar, final aq aqVar) {
        super(lVar, gVar, fVar, anVar);
        if (jVar == null) {
            atM(0);
        }
        if (lVar == null) {
            atM(1);
        }
        if (gVar == null) {
            atM(2);
        }
        if (fVar == null) {
            atM(3);
        }
        if (bhVar == null) {
            atM(4);
        }
        if (anVar == null) {
            atM(5);
        }
        if (aqVar == null) {
            atM(6);
        }
        this.Tke = bhVar;
        this.Tkf = z;
        this.index = i2;
        this.Tkg = jVar.al(new kotlin.g.a.a<at>() {
            /* class kotlin.l.b.a.b.b.c.e.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ at invoke() {
                AppMethodBeat.i(57002);
                a aVar = new a(e.this, jVar, aqVar);
                AppMethodBeat.o(57002);
                return aVar;
            }
        });
        this.TjU = jVar.al(new kotlin.g.a.a<aj>() {
            /* class kotlin.l.b.a.b.b.c.e.AnonymousClass2 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ aj invoke() {
                AppMethodBeat.i(57004);
                g.a aVar = g.TiC;
                aj a2 = ac.a(g.a.hBP(), e.this.hzz(), Collections.emptyList(), false, new kotlin.l.b.a.b.j.f.g(jVar.al(new kotlin.g.a.a<h>() {
                    /* class kotlin.l.b.a.b.b.c.e.AnonymousClass2.AnonymousClass1 */

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ h invoke() {
                        AppMethodBeat.i(57003);
                        h c2 = m.c("Scope for type parameter " + fVar.sG(), e.this.hyo());
                        AppMethodBeat.o(57003);
                        return c2;
                    }
                })));
                AppMethodBeat.o(57004);
                return a2;
            }
        });
        this.TcN = jVar;
    }

    @Override // kotlin.l.b.a.b.b.as
    public final bh hAJ() {
        bh bhVar = this.Tke;
        if (bhVar == null) {
            atM(7);
        }
        return bhVar;
    }

    @Override // kotlin.l.b.a.b.b.as
    public final boolean hAK() {
        return this.Tkf;
    }

    @Override // kotlin.l.b.a.b.b.as
    public final int getIndex() {
        return this.index;
    }

    @Override // kotlin.l.b.a.b.b.as
    public final boolean hAC() {
        return false;
    }

    @Override // kotlin.l.b.a.b.b.as
    public final List<ab> hyo() {
        List<ab> hLx = ((a) hzz()).hBV();
        if (hLx == null) {
            atM(8);
        }
        return hLx;
    }

    @Override // kotlin.l.b.a.b.b.as, kotlin.l.b.a.b.b.h
    public final at hzz() {
        at atVar = (at) this.Tkg.invoke();
        if (atVar == null) {
            atM(9);
        }
        return atVar;
    }

    @Override // kotlin.l.b.a.b.b.h
    public final aj hAG() {
        aj ajVar = (aj) this.TjU.invoke();
        if (ajVar == null) {
            atM(10);
        }
        return ajVar;
    }

    @Override // kotlin.l.b.a.b.b.as
    /* renamed from: hAD */
    public final as hBT() {
        as asVar = (as) super.hAE();
        if (asVar == null) {
            atM(11);
        }
        return asVar;
    }

    @Override // kotlin.l.b.a.b.b.l
    public final <R, D> R a(n<R, D> nVar, D d2) {
        return nVar.a(this, d2);
    }

    @Override // kotlin.l.b.a.b.b.as
    public final j hAI() {
        j jVar = this.TcN;
        if (jVar == null) {
            atM(12);
        }
        return jVar;
    }

    /* access modifiers changed from: package-private */
    public class a extends kotlin.l.b.a.b.m.h {
        final /* synthetic */ e Tkj;
        private final aq Tkm;

        private static /* synthetic */ void atM(int i2) {
            String str;
            int i3;
            Throwable illegalStateException;
            AppMethodBeat.i(57014);
            switch (i2) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
            switch (i2) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    i3 = 2;
                    break;
                default:
                    i3 = 3;
                    break;
            }
            Object[] objArr = new Object[i3];
            switch (i2) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor$TypeParameterTypeConstructor";
                    break;
                case 6:
                    objArr[0] = "type";
                    break;
                default:
                    objArr[0] = "storageManager";
                    break;
            }
            switch (i2) {
                case 1:
                    objArr[1] = "computeSupertypes";
                    break;
                case 2:
                    objArr[1] = "getParameters";
                    break;
                case 3:
                    objArr[1] = "getDeclarationDescriptor";
                    break;
                case 4:
                    objArr[1] = "getBuiltIns";
                    break;
                case 5:
                    objArr[1] = "getSupertypeLoopChecker";
                    break;
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor$TypeParameterTypeConstructor";
                    break;
            }
            switch (i2) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    break;
                case 6:
                    objArr[2] = "reportSupertypeLoopError";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String format = String.format(str, objArr);
            switch (i2) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    illegalStateException = new IllegalStateException(format);
                    break;
                default:
                    illegalStateException = new IllegalArgumentException(format);
                    break;
            }
            AppMethodBeat.o(57014);
            throw illegalStateException;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(e eVar, j jVar, aq aqVar) {
            super(jVar);
            if (jVar == null) {
                atM(0);
            }
            this.Tkj = eVar;
            AppMethodBeat.i(57005);
            this.Tkm = aqVar;
            AppMethodBeat.o(57005);
        }

        @Override // kotlin.l.b.a.b.m.h
        public final Collection<ab> hzR() {
            AppMethodBeat.i(57006);
            List<ab> hBW = this.Tkj.hBW();
            if (hBW == null) {
                atM(1);
            }
            AppMethodBeat.o(57006);
            return hBW;
        }

        @Override // kotlin.l.b.a.b.m.at
        public final List<as> getParameters() {
            AppMethodBeat.i(57007);
            List<as> emptyList = Collections.emptyList();
            if (emptyList == null) {
                atM(2);
            }
            AppMethodBeat.o(57007);
            return emptyList;
        }

        @Override // kotlin.l.b.a.b.m.at
        public final boolean hzU() {
            return true;
        }

        @Override // kotlin.l.b.a.b.m.at
        public final kotlin.l.b.a.b.b.h hzS() {
            AppMethodBeat.i(57008);
            e eVar = this.Tkj;
            if (eVar == null) {
                atM(3);
            }
            AppMethodBeat.o(57008);
            return eVar;
        }

        @Override // kotlin.l.b.a.b.m.at
        public final kotlin.l.b.a.b.a.g hBh() {
            AppMethodBeat.i(57009);
            kotlin.l.b.a.b.a.g G = kotlin.l.b.a.b.j.d.a.G(this.Tkj);
            if (G == null) {
                atM(4);
            }
            AppMethodBeat.o(57009);
            return G;
        }

        public final String toString() {
            AppMethodBeat.i(57010);
            String fVar = this.Tkj.hAH().toString();
            AppMethodBeat.o(57010);
            return fVar;
        }

        @Override // kotlin.l.b.a.b.m.h
        public final aq hzV() {
            AppMethodBeat.i(57011);
            aq aqVar = this.Tkm;
            if (aqVar == null) {
                atM(5);
            }
            AppMethodBeat.o(57011);
            return aqVar;
        }

        @Override // kotlin.l.b.a.b.m.h
        public final void H(ab abVar) {
            AppMethodBeat.i(57012);
            if (abVar == null) {
                atM(6);
            }
            this.Tkj.H(abVar);
            AppMethodBeat.o(57012);
        }

        @Override // kotlin.l.b.a.b.m.h
        public final ab hBX() {
            AppMethodBeat.i(57013);
            aj bun = u.bun("Cyclic upper bounds");
            AppMethodBeat.o(57013);
            return bun;
        }
    }
}
