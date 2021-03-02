package kotlin.l.b.a.b.m.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.List;
import kotlin.l.b.a.b.b.a;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.ak;
import kotlin.l.b.a.b.b.am;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.b;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.c.ae;
import kotlin.l.b.a.b.b.c.p;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.t;
import kotlin.l.b.a.b.b.w;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.ay;
import kotlin.l.b.a.b.m.u;

public final class a extends ae {
    private final u.b TPN;

    private static /* synthetic */ void atM(int i2) {
        String str;
        int i3;
        Throwable illegalStateException;
        AppMethodBeat.i(61217);
        switch (i2) {
            case 6:
            case 7:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 6:
            case 7:
                i3 = 2;
                break;
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
                objArr[0] = "ownerScope";
                break;
            case 2:
                objArr[0] = "newOwner";
                break;
            case 3:
                objArr[0] = "kind";
                break;
            case 4:
                objArr[0] = "annotations";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
            case 7:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl";
                break;
            case 8:
                objArr[0] = "overriddenDescriptors";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i2) {
            case 6:
                objArr[1] = "createSubstitutedCopy";
                break;
            case 7:
                objArr[1] = "copy";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl";
                break;
        }
        switch (i2) {
            case 2:
            case 3:
            case 4:
            case 5:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 6:
            case 7:
                break;
            case 8:
                objArr[2] = "setOverriddenDescriptors";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 6:
            case 7:
                illegalStateException = new IllegalStateException(format);
                break;
            default:
                illegalStateException = new IllegalArgumentException(format);
                break;
        }
        AppMethodBeat.o(61217);
        throw illegalStateException;
    }

    @Override // kotlin.l.b.a.b.b.b, kotlin.l.b.a.b.b.c.p, kotlin.l.b.a.b.b.c.ae
    public final /* bridge */ /* synthetic */ b a(l lVar, w wVar, ba baVar, b.a aVar) {
        return this;
    }

    @Override // kotlin.l.b.a.b.b.c.p, kotlin.l.b.a.b.b.c.ae
    public final /* bridge */ /* synthetic */ t b(l lVar, w wVar, ba baVar, b.a aVar, boolean z) {
        return this;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(e eVar, u.b bVar) {
        super(eVar, null, g.a.hBP(), f.bua("<ERROR FUNCTION>"), b.a.DECLARATION, an.ThK);
        if (eVar == null) {
            atM(0);
        }
        if (bVar == null) {
            atM(1);
        }
        g.a aVar = g.TiC;
        AppMethodBeat.i(61213);
        this.TPN = bVar;
        AppMethodBeat.o(61213);
    }

    @Override // kotlin.l.b.a.b.b.c.p, kotlin.l.b.a.b.b.c.ae
    public final p a(l lVar, t tVar, b.a aVar, f fVar, g gVar, an anVar) {
        AppMethodBeat.i(61214);
        if (lVar == null) {
            atM(2);
        }
        if (aVar == null) {
            atM(3);
        }
        if (gVar == null) {
            atM(4);
        }
        if (anVar == null) {
            atM(5);
        }
        AppMethodBeat.o(61214);
        return this;
    }

    @Override // kotlin.l.b.a.b.b.c.ae
    public final am c(l lVar, w wVar, ba baVar, b.a aVar, boolean z) {
        return this;
    }

    @Override // kotlin.l.b.a.b.b.am, kotlin.l.b.a.b.b.t, kotlin.l.b.a.b.b.c.p, kotlin.l.b.a.b.b.c.ae
    public final t.a<? extends am> hBa() {
        AppMethodBeat.i(61215);
        AnonymousClass1 r0 = new t.a<am>() {
            /* class kotlin.l.b.a.b.m.b.a.AnonymousClass1 */

            private static /* synthetic */ void atM(int i2) {
                String str;
                int i3;
                Throwable illegalStateException;
                AppMethodBeat.i(61212);
                switch (i2) {
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                    case 12:
                    case 14:
                    case 16:
                    case 18:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 30:
                        str = "@NotNull method %s.%s must not return null";
                        break;
                    case 2:
                    case 4:
                    case 6:
                    case 9:
                    case 11:
                    case 13:
                    case 15:
                    case 17:
                    case 19:
                    case 29:
                    default:
                        str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                        break;
                }
                switch (i2) {
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                    case 12:
                    case 14:
                    case 16:
                    case 18:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 30:
                        i3 = 2;
                        break;
                    case 2:
                    case 4:
                    case 6:
                    case 9:
                    case 11:
                    case 13:
                    case 15:
                    case 17:
                    case 19:
                    case 29:
                    default:
                        i3 = 3;
                        break;
                }
                Object[] objArr = new Object[i3];
                switch (i2) {
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                    case 12:
                    case 14:
                    case 16:
                    case 18:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 30:
                        objArr[0] = "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1";
                        break;
                    case 2:
                        objArr[0] = "modality";
                        break;
                    case 4:
                        objArr[0] = "visibility";
                        break;
                    case 6:
                        objArr[0] = "kind";
                        break;
                    case 9:
                        objArr[0] = "name";
                        break;
                    case 11:
                    case 17:
                        objArr[0] = "parameters";
                        break;
                    case 13:
                        objArr[0] = "substitution";
                        break;
                    case 15:
                        objArr[0] = "userDataKey";
                        break;
                    case 19:
                        objArr[0] = "type";
                        break;
                    case 29:
                        objArr[0] = "additionalAnnotations";
                        break;
                    default:
                        objArr[0] = "owner";
                        break;
                }
                switch (i2) {
                    case 1:
                        objArr[1] = "setOwner";
                        break;
                    case 2:
                    case 4:
                    case 6:
                    case 9:
                    case 11:
                    case 13:
                    case 15:
                    case 17:
                    case 19:
                    case 29:
                    default:
                        objArr[1] = "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1";
                        break;
                    case 3:
                        objArr[1] = "setModality";
                        break;
                    case 5:
                        objArr[1] = "setVisibility";
                        break;
                    case 7:
                        objArr[1] = "setKind";
                        break;
                    case 8:
                        objArr[1] = "setCopyOverrides";
                        break;
                    case 10:
                        objArr[1] = "setName";
                        break;
                    case 12:
                        objArr[1] = "setValueParameters";
                        break;
                    case 14:
                        objArr[1] = "setSubstitution";
                        break;
                    case 16:
                        objArr[1] = "putUserData";
                        break;
                    case 18:
                        objArr[1] = "setTypeParameters";
                        break;
                    case 20:
                        objArr[1] = "setReturnType";
                        break;
                    case 21:
                        objArr[1] = "setExtensionReceiverParameter";
                        break;
                    case 22:
                        objArr[1] = "setDispatchReceiverParameter";
                        break;
                    case 23:
                        objArr[1] = "setOriginal";
                        break;
                    case 24:
                        objArr[1] = "setSignatureChange";
                        break;
                    case 25:
                        objArr[1] = "setPreserveSourceElement";
                        break;
                    case 26:
                        objArr[1] = "setDropOriginalInContainingParts";
                        break;
                    case 27:
                        objArr[1] = "setHiddenToOvercomeSignatureClash";
                        break;
                    case 28:
                        objArr[1] = "setHiddenForResolutionEverywhereBesideSupercalls";
                        break;
                    case 30:
                        objArr[1] = "setAdditionalAnnotations";
                        break;
                }
                switch (i2) {
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                    case 12:
                    case 14:
                    case 16:
                    case 18:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 30:
                        break;
                    case 2:
                        objArr[2] = "setModality";
                        break;
                    case 4:
                        objArr[2] = "setVisibility";
                        break;
                    case 6:
                        objArr[2] = "setKind";
                        break;
                    case 9:
                        objArr[2] = "setName";
                        break;
                    case 11:
                        objArr[2] = "setValueParameters";
                        break;
                    case 13:
                        objArr[2] = "setSubstitution";
                        break;
                    case 15:
                        objArr[2] = "putUserData";
                        break;
                    case 17:
                        objArr[2] = "setTypeParameters";
                        break;
                    case 19:
                        objArr[2] = "setReturnType";
                        break;
                    case 29:
                        objArr[2] = "setAdditionalAnnotations";
                        break;
                    default:
                        objArr[2] = "setOwner";
                        break;
                }
                String format = String.format(str, objArr);
                switch (i2) {
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                    case 12:
                    case 14:
                    case 16:
                    case 18:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 30:
                        illegalStateException = new IllegalStateException(format);
                        break;
                    case 2:
                    case 4:
                    case 6:
                    case 9:
                    case 11:
                    case 13:
                    case 15:
                    case 17:
                    case 19:
                    case 29:
                    default:
                        illegalStateException = new IllegalArgumentException(format);
                        break;
                }
                AppMethodBeat.o(61212);
                throw illegalStateException;
            }

            @Override // kotlin.l.b.a.b.b.t.a
            public final t.a<am> h(l lVar) {
                AppMethodBeat.i(61194);
                if (lVar == null) {
                    atM(0);
                }
                if (this == null) {
                    atM(1);
                }
                AppMethodBeat.o(61194);
                return this;
            }

            @Override // kotlin.l.b.a.b.b.t.a
            public final t.a<am> a(w wVar) {
                AppMethodBeat.i(61195);
                if (wVar == null) {
                    atM(2);
                }
                if (this == null) {
                    atM(3);
                }
                AppMethodBeat.o(61195);
                return this;
            }

            @Override // kotlin.l.b.a.b.b.t.a
            public final t.a<am> a(ba baVar) {
                AppMethodBeat.i(61196);
                if (baVar == null) {
                    atM(4);
                }
                if (this == null) {
                    atM(5);
                }
                AppMethodBeat.o(61196);
                return this;
            }

            @Override // kotlin.l.b.a.b.b.t.a
            public final t.a<am> a(b.a aVar) {
                AppMethodBeat.i(61197);
                if (aVar == null) {
                    atM(6);
                }
                if (this == null) {
                    atM(7);
                }
                AppMethodBeat.o(61197);
                return this;
            }

            @Override // kotlin.l.b.a.b.b.t.a
            public final t.a<am> EB(boolean z) {
                AppMethodBeat.i(61198);
                if (this == null) {
                    atM(8);
                }
                AppMethodBeat.o(61198);
                return this;
            }

            @Override // kotlin.l.b.a.b.b.t.a
            public final t.a<am> d(f fVar) {
                AppMethodBeat.i(61199);
                if (fVar == null) {
                    atM(9);
                }
                if (this == null) {
                    atM(10);
                }
                AppMethodBeat.o(61199);
                return this;
            }

            @Override // kotlin.l.b.a.b.b.t.a
            public final t.a<am> kz(List<av> list) {
                AppMethodBeat.i(61200);
                if (list == null) {
                    atM(11);
                }
                if (this == null) {
                    atM(12);
                }
                AppMethodBeat.o(61200);
                return this;
            }

            @Override // kotlin.l.b.a.b.b.t.a
            public final t.a<am> b(ay ayVar) {
                AppMethodBeat.i(61201);
                if (ayVar == null) {
                    atM(13);
                }
                if (this == null) {
                    atM(14);
                }
                AppMethodBeat.o(61201);
                return this;
            }

            @Override // kotlin.l.b.a.b.b.t.a
            public final t.a<am> G(ab abVar) {
                AppMethodBeat.i(61202);
                if (abVar == null) {
                    atM(19);
                }
                if (this == null) {
                    atM(20);
                }
                AppMethodBeat.o(61202);
                return this;
            }

            @Override // kotlin.l.b.a.b.b.t.a
            public final t.a<am> a(ak akVar) {
                AppMethodBeat.i(61203);
                if (this == null) {
                    atM(21);
                }
                AppMethodBeat.o(61203);
                return this;
            }

            @Override // kotlin.l.b.a.b.b.t.a
            public final t.a<am> b(ak akVar) {
                AppMethodBeat.i(61204);
                if (this == null) {
                    atM(22);
                }
                AppMethodBeat.o(61204);
                return this;
            }

            @Override // kotlin.l.b.a.b.b.t.a
            public final t.a<am> d(b bVar) {
                AppMethodBeat.i(61205);
                if (this == null) {
                    atM(23);
                }
                AppMethodBeat.o(61205);
                return this;
            }

            @Override // kotlin.l.b.a.b.b.t.a
            public final t.a<am> hBb() {
                AppMethodBeat.i(61206);
                if (this == null) {
                    atM(24);
                }
                AppMethodBeat.o(61206);
                return this;
            }

            @Override // kotlin.l.b.a.b.b.t.a
            public final t.a<am> hBc() {
                AppMethodBeat.i(61207);
                if (this == null) {
                    atM(25);
                }
                AppMethodBeat.o(61207);
                return this;
            }

            @Override // kotlin.l.b.a.b.b.t.a
            public final t.a<am> hBd() {
                AppMethodBeat.i(61208);
                if (this == null) {
                    atM(26);
                }
                AppMethodBeat.o(61208);
                return this;
            }

            @Override // kotlin.l.b.a.b.b.t.a
            public final t.a<am> hBe() {
                AppMethodBeat.i(61209);
                if (this == null) {
                    atM(27);
                }
                AppMethodBeat.o(61209);
                return this;
            }

            @Override // kotlin.l.b.a.b.b.t.a
            public final t.a<am> hBf() {
                AppMethodBeat.i(61210);
                if (this == null) {
                    atM(28);
                }
                AppMethodBeat.o(61210);
                return this;
            }

            @Override // kotlin.l.b.a.b.b.t.a
            public final t.a<am> a(g gVar) {
                AppMethodBeat.i(61211);
                if (gVar == null) {
                    atM(29);
                }
                if (this == null) {
                    atM(30);
                }
                AppMethodBeat.o(61211);
                return this;
            }

            /* Return type fixed from 'kotlin.l.b.a.b.b.t' to match base method */
            @Override // kotlin.l.b.a.b.b.t.a
            public final /* bridge */ /* synthetic */ am hBg() {
                return a.this;
            }
        };
        AppMethodBeat.o(61215);
        return r0;
    }

    @Override // kotlin.l.b.a.b.b.t, kotlin.l.b.a.b.b.c.p
    public final boolean hAZ() {
        return false;
    }

    @Override // kotlin.l.b.a.b.b.a, kotlin.l.b.a.b.b.c.p
    public final <V> V a(a.AbstractC2276a<V> aVar) {
        return null;
    }

    @Override // kotlin.l.b.a.b.b.b, kotlin.l.b.a.b.b.c.p
    public final void x(Collection<? extends b> collection) {
        AppMethodBeat.i(61216);
        if (collection == null) {
            atM(8);
        }
        AppMethodBeat.o(61216);
    }
}
