package kotlin.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.b;
import kotlin.l.b.a.b.b.ak;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.n;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.j.c;
import kotlin.l.b.a.b.j.f.h;
import kotlin.l.b.a.b.j.f.l;
import kotlin.l.b.a.b.l.j;
import kotlin.l.b.a.b.m.a.i;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.b.a.b.m.ay;
import kotlin.l.b.a.b.m.ba;
import kotlin.l.b.a.b.m.bc;

public abstract class a extends t {
    static final /* synthetic */ boolean $assertionsDisabled = (!a.class.desiredAssertionStatus());
    private final f TjT;
    protected final kotlin.l.b.a.b.l.f<aj> TjU;
    private final kotlin.l.b.a.b.l.f<h> TjV;
    private final kotlin.l.b.a.b.l.f<ak> TjW;

    private static /* synthetic */ void atM(int i2) {
        String str;
        int i3;
        switch (i2) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 8:
            case 11:
            case 13:
            case 15:
            case 16:
            case 18:
            case 19:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 6:
            case 7:
            case 9:
            case 10:
            case 12:
            case 14:
            case 17:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 8:
            case 11:
            case 13:
            case 15:
            case 16:
            case 18:
            case 19:
                i3 = 2;
                break;
            case 6:
            case 7:
            case 9:
            case 10:
            case 12:
            case 14:
            case 17:
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
                objArr[0] = "name";
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 8:
            case 11:
            case 13:
            case 15:
            case 16:
            case 18:
            case 19:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor";
                break;
            case 6:
            case 12:
                objArr[0] = "typeArguments";
                break;
            case 7:
            case 10:
                objArr[0] = "kotlinTypeRefiner";
                break;
            case 9:
            case 14:
                objArr[0] = "typeSubstitution";
                break;
            case 17:
                objArr[0] = "substitutor";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        switch (i2) {
            case 2:
                objArr[1] = "getName";
                break;
            case 3:
                objArr[1] = "getOriginal";
                break;
            case 4:
                objArr[1] = "getUnsubstitutedInnerClassesScope";
                break;
            case 5:
                objArr[1] = "getThisAsReceiverParameter";
                break;
            case 6:
            case 7:
            case 9:
            case 10:
            case 12:
            case 14:
            case 17:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor";
                break;
            case 8:
            case 11:
            case 13:
            case 15:
                objArr[1] = "getMemberScope";
                break;
            case 16:
                objArr[1] = "getUnsubstitutedMemberScope";
                break;
            case 18:
                objArr[1] = "substitute";
                break;
            case 19:
                objArr[1] = "getDefaultType";
                break;
        }
        switch (i2) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 8:
            case 11:
            case 13:
            case 15:
            case 16:
            case 18:
            case 19:
                break;
            case 6:
            case 7:
            case 9:
            case 10:
            case 12:
            case 14:
                objArr[2] = "getMemberScope";
                break;
            case 17:
                objArr[2] = "substitute";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 8:
            case 11:
            case 13:
            case 15:
            case 16:
            case 18:
            case 19:
                throw new IllegalStateException(format);
            case 6:
            case 7:
            case 9:
            case 10:
            case 12:
            case 14:
            case 17:
            default:
                throw new IllegalArgumentException(format);
        }
    }

    public a(j jVar, f fVar) {
        if (jVar == null) {
            atM(0);
        }
        if (fVar == null) {
            atM(1);
        }
        this.TjT = fVar;
        this.TjU = jVar.al(new kotlin.g.a.a<aj>() {
            /* class kotlin.l.b.a.b.b.c.a.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ aj invoke() {
                AppMethodBeat.i(56993);
                aj a2 = bc.a(a.this, a.this.hAM(), new b<i, aj>() {
                    /* class kotlin.l.b.a.b.b.c.a.AnonymousClass1.AnonymousClass1 */

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // kotlin.g.a.b
                    public final /* synthetic */ aj invoke(i iVar) {
                        AppMethodBeat.i(56992);
                        iVar.M(a.this);
                        aj ajVar = (aj) a.this.TjU.invoke();
                        AppMethodBeat.o(56992);
                        return ajVar;
                    }
                });
                AppMethodBeat.o(56993);
                return a2;
            }
        });
        this.TjV = jVar.al(new kotlin.g.a.a<h>() {
            /* class kotlin.l.b.a.b.b.c.a.AnonymousClass2 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ h invoke() {
                AppMethodBeat.i(56994);
                kotlin.l.b.a.b.j.f.f fVar = new kotlin.l.b.a.b.j.f.f(a.this.hAM());
                AppMethodBeat.o(56994);
                return fVar;
            }
        });
        this.TjW = jVar.al(new kotlin.g.a.a<ak>() {
            /* class kotlin.l.b.a.b.b.c.a.AnonymousClass3 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ ak invoke() {
                AppMethodBeat.i(56995);
                q qVar = new q(a.this);
                AppMethodBeat.o(56995);
                return qVar;
            }
        });
    }

    @Override // kotlin.l.b.a.b.b.z
    public final f hAH() {
        f fVar = this.TjT;
        if (fVar == null) {
            atM(2);
        }
        return fVar;
    }

    @Override // kotlin.l.b.a.b.b.e
    /* renamed from: hAP */
    public final e hAF() {
        if (this == null) {
            atM(3);
        }
        return this;
    }

    @Override // kotlin.l.b.a.b.b.e
    public h hAN() {
        h hVar = (h) this.TjV.invoke();
        if (hVar == null) {
            atM(4);
        }
        return hVar;
    }

    @Override // kotlin.l.b.a.b.b.e
    public final ak hAO() {
        ak akVar = (ak) this.TjW.invoke();
        if (akVar == null) {
            atM(5);
        }
        return akVar;
    }

    @Override // kotlin.l.b.a.b.b.c.t
    public h a(ay ayVar, i iVar) {
        if (ayVar == null) {
            atM(9);
        }
        if (iVar == null) {
            atM(10);
        }
        if (ayVar.isEmpty()) {
            h a2 = a(iVar);
            if (a2 != null) {
                return a2;
            }
            atM(11);
            return a2;
        }
        return new l(a(iVar), ba.d(ayVar));
    }

    @Override // kotlin.l.b.a.b.b.e
    public final h a(ay ayVar) {
        if (ayVar == null) {
            atM(14);
        }
        h a2 = a(ayVar, kotlin.l.b.a.b.j.d.a.d(c.s(this)));
        if (a2 == null) {
            atM(15);
        }
        return a2;
    }

    @Override // kotlin.l.b.a.b.b.e
    public h hAM() {
        h a2 = a(kotlin.l.b.a.b.j.d.a.d(c.s(this)));
        if (a2 == null) {
            atM(16);
        }
        return a2;
    }

    @Override // kotlin.l.b.a.b.b.e, kotlin.l.b.a.b.b.h
    public final aj hAG() {
        aj ajVar = (aj) this.TjU.invoke();
        if (ajVar == null) {
            atM(19);
        }
        return ajVar;
    }

    @Override // kotlin.l.b.a.b.b.l
    public final <R, D> R a(n<R, D> nVar, D d2) {
        return nVar.a(this, d2);
    }

    /* renamed from: g */
    public e f(ba baVar) {
        if (baVar == null) {
            atM(17);
        }
        return baVar.Tlg.isEmpty() ? this : new s(this, baVar);
    }
}
