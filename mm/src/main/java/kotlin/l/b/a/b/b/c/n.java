package kotlin.l.b.a.b.b.c;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.g.a.b;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.am;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.az;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.d;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.w;
import kotlin.l.b.a.b.j.f.h;
import kotlin.l.b.a.b.l.c;
import kotlin.l.b.a.b.l.f;
import kotlin.l.b.a.b.l.j;
import kotlin.l.b.a.b.m.a.i;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.at;
import kotlin.x;

public class n extends g {
    static final /* synthetic */ boolean $assertionsDisabled = (!n.class.desiredAssertionStatus());
    private final g Tih;
    private final at Tks;
    private final h Tkx;
    private final f<Set<kotlin.l.b.a.b.f.f>> Tky;

    private static /* synthetic */ void atM(int i2) {
        String str;
        int i3;
        Throwable illegalStateException;
        AppMethodBeat.i(57098);
        switch (i2) {
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                i3 = 2;
                break;
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
                objArr[0] = "enumClass";
                break;
            case 2:
            case 9:
                objArr[0] = "name";
                break;
            case 3:
            case 10:
                objArr[0] = "enumMemberNames";
                break;
            case 4:
            case 11:
                objArr[0] = "annotations";
                break;
            case 5:
            case 12:
                objArr[0] = "source";
                break;
            case 6:
            default:
                objArr[0] = "storageManager";
                break;
            case 7:
                objArr[0] = "containingClass";
                break;
            case 8:
                objArr[0] = "supertype";
                break;
            case 13:
                objArr[0] = "kotlinTypeRefiner";
                break;
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor";
                break;
        }
        switch (i2) {
            case 14:
                objArr[1] = "getUnsubstitutedMemberScope";
                break;
            case 15:
                objArr[1] = "getStaticScope";
                break;
            case 16:
                objArr[1] = "getConstructors";
                break;
            case 17:
                objArr[1] = "getTypeConstructor";
                break;
            case 18:
                objArr[1] = "getKind";
                break;
            case 19:
                objArr[1] = "getModality";
                break;
            case 20:
                objArr[1] = "getVisibility";
                break;
            case 21:
                objArr[1] = "getAnnotations";
                break;
            case 22:
                objArr[1] = "getDeclaredTypeParameters";
                break;
            case 23:
                objArr[1] = "getSealedSubclasses";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor";
                break;
        }
        switch (i2) {
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                objArr[2] = "<init>";
                break;
            case 13:
                objArr[2] = "getUnsubstitutedMemberScope";
                break;
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                break;
            default:
                objArr[2] = "create";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                illegalStateException = new IllegalStateException(format);
                break;
            default:
                illegalStateException = new IllegalArgumentException(format);
                break;
        }
        AppMethodBeat.o(57098);
        throw illegalStateException;
    }

    static {
        AppMethodBeat.i(57097);
        AppMethodBeat.o(57097);
    }

    public static n a(j jVar, e eVar, kotlin.l.b.a.b.f.f fVar, f<Set<kotlin.l.b.a.b.f.f>> fVar2, g gVar, an anVar) {
        AppMethodBeat.i(57084);
        if (jVar == null) {
            atM(0);
        }
        if (eVar == null) {
            atM(1);
        }
        if (fVar == null) {
            atM(2);
        }
        if (fVar2 == null) {
            atM(3);
        }
        if (gVar == null) {
            atM(4);
        }
        if (anVar == null) {
            atM(5);
        }
        n nVar = new n(jVar, eVar, eVar.hAG(), fVar, fVar2, gVar, anVar);
        AppMethodBeat.o(57084);
        return nVar;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private n(j jVar, e eVar, ab abVar, kotlin.l.b.a.b.f.f fVar, f<Set<kotlin.l.b.a.b.f.f>> fVar2, g gVar, an anVar) {
        super(jVar, eVar, fVar, anVar);
        if (jVar == null) {
            atM(6);
        }
        if (eVar == null) {
            atM(7);
        }
        if (abVar == null) {
            atM(8);
        }
        if (fVar == null) {
            atM(9);
        }
        if (fVar2 == null) {
            atM(10);
        }
        if (gVar == null) {
            atM(11);
        }
        if (anVar == null) {
            atM(12);
        }
        AppMethodBeat.i(57085);
        if ($assertionsDisabled || eVar.hzB() == kotlin.l.b.a.b.b.f.ENUM_CLASS) {
            this.Tih = gVar;
            this.Tks = new kotlin.l.b.a.b.m.j(this, Collections.emptyList(), Collections.singleton(abVar), jVar);
            this.Tkx = new a(this, jVar);
            this.Tky = fVar2;
            AppMethodBeat.o(57085);
            return;
        }
        AssertionError assertionError = new AssertionError();
        AppMethodBeat.o(57085);
        throw assertionError;
    }

    @Override // kotlin.l.b.a.b.b.c.t
    public final h a(i iVar) {
        AppMethodBeat.i(57086);
        if (iVar == null) {
            atM(13);
        }
        h hVar = this.Tkx;
        if (hVar == null) {
            atM(14);
        }
        AppMethodBeat.o(57086);
        return hVar;
    }

    @Override // kotlin.l.b.a.b.b.e
    public final h hzy() {
        AppMethodBeat.i(57087);
        h.b bVar = h.b.TKa;
        if (bVar == null) {
            atM(15);
        }
        AppMethodBeat.o(57087);
        return bVar;
    }

    @Override // kotlin.l.b.a.b.b.e
    public final Collection<d> hxW() {
        AppMethodBeat.i(57088);
        List emptyList = Collections.emptyList();
        if (emptyList == null) {
            atM(16);
        }
        AppMethodBeat.o(57088);
        return emptyList;
    }

    @Override // kotlin.l.b.a.b.b.h
    public final at hzz() {
        AppMethodBeat.i(57089);
        at atVar = this.Tks;
        if (atVar == null) {
            atM(17);
        }
        AppMethodBeat.o(57089);
        return atVar;
    }

    @Override // kotlin.l.b.a.b.b.e
    public final e hzA() {
        return null;
    }

    @Override // kotlin.l.b.a.b.b.e
    public final kotlin.l.b.a.b.b.f hzB() {
        AppMethodBeat.i(57090);
        kotlin.l.b.a.b.b.f fVar = kotlin.l.b.a.b.b.f.ENUM_ENTRY;
        if (fVar == null) {
            atM(18);
        }
        AppMethodBeat.o(57090);
        return fVar;
    }

    @Override // kotlin.l.b.a.b.b.e, kotlin.l.b.a.b.b.v
    public final w hzC() {
        AppMethodBeat.i(57091);
        w wVar = w.FINAL;
        if (wVar == null) {
            atM(19);
        }
        AppMethodBeat.o(57091);
        return wVar;
    }

    @Override // kotlin.l.b.a.b.b.e, kotlin.l.b.a.b.b.v, kotlin.l.b.a.b.b.p
    public final ba hzE() {
        AppMethodBeat.i(57092);
        ba baVar = az.ThU;
        if (baVar == null) {
            atM(20);
        }
        AppMethodBeat.o(57092);
        return baVar;
    }

    @Override // kotlin.l.b.a.b.b.i
    public final boolean hzG() {
        return false;
    }

    @Override // kotlin.l.b.a.b.b.e
    public final boolean hzH() {
        return false;
    }

    @Override // kotlin.l.b.a.b.b.e
    public final boolean hzI() {
        return false;
    }

    @Override // kotlin.l.b.a.b.b.e
    public final boolean hzF() {
        return false;
    }

    @Override // kotlin.l.b.a.b.b.v
    public final boolean hzJ() {
        return false;
    }

    @Override // kotlin.l.b.a.b.b.v
    public final boolean hzK() {
        return false;
    }

    @Override // kotlin.l.b.a.b.b.e
    public final d hzD() {
        return null;
    }

    @Override // kotlin.l.b.a.b.b.a.a
    public final g hzL() {
        AppMethodBeat.i(57093);
        g gVar = this.Tih;
        if (gVar == null) {
            atM(21);
        }
        AppMethodBeat.o(57093);
        return gVar;
    }

    public String toString() {
        AppMethodBeat.i(57094);
        String str = "enum entry " + hAH();
        AppMethodBeat.o(57094);
        return str;
    }

    @Override // kotlin.l.b.a.b.b.e, kotlin.l.b.a.b.b.i
    public final List<as> hzO() {
        AppMethodBeat.i(57095);
        List<as> emptyList = Collections.emptyList();
        if (emptyList == null) {
            atM(22);
        }
        AppMethodBeat.o(57095);
        return emptyList;
    }

    @Override // kotlin.l.b.a.b.b.e
    public final Collection<e> hzN() {
        AppMethodBeat.i(57096);
        List emptyList = Collections.emptyList();
        if (emptyList == null) {
            atM(23);
        }
        AppMethodBeat.o(57096);
        return emptyList;
    }

    class a extends kotlin.l.b.a.b.j.f.i {
        static final /* synthetic */ boolean $assertionsDisabled = (!n.class.desiredAssertionStatus());
        private final c<kotlin.l.b.a.b.f.f, Collection<? extends ah>> TkA;
        private final f<Collection<l>> TkB;
        final /* synthetic */ n TkC;
        private final c<kotlin.l.b.a.b.f.f, Collection<? extends am>> Tkz;

        private static /* synthetic */ void atM(int i2) {
            String str;
            int i3;
            Throwable illegalStateException;
            AppMethodBeat.i(57083);
            switch (i2) {
                case 3:
                case 7:
                case 9:
                case 12:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                case 4:
                case 5:
                case 6:
                case 8:
                case 10:
                case 11:
                case 13:
                case 14:
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
            switch (i2) {
                case 3:
                case 7:
                case 9:
                case 12:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                    i3 = 2;
                    break;
                case 4:
                case 5:
                case 6:
                case 8:
                case 10:
                case 11:
                case 13:
                case 14:
                default:
                    i3 = 3;
                    break;
            }
            Object[] objArr = new Object[i3];
            switch (i2) {
                case 1:
                case 4:
                case 5:
                case 8:
                case 10:
                    objArr[0] = "name";
                    break;
                case 2:
                case 6:
                    objArr[0] = FirebaseAnalytics.b.LOCATION;
                    break;
                case 3:
                case 7:
                case 9:
                case 12:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope";
                    break;
                case 11:
                    objArr[0] = "fromSupertypes";
                    break;
                case 13:
                    objArr[0] = "kindFilter";
                    break;
                case 14:
                    objArr[0] = "nameFilter";
                    break;
                case 20:
                    objArr[0] = "p";
                    break;
                default:
                    objArr[0] = "storageManager";
                    break;
            }
            switch (i2) {
                case 3:
                    objArr[1] = "getContributedVariables";
                    break;
                case 4:
                case 5:
                case 6:
                case 8:
                case 10:
                case 11:
                case 13:
                case 14:
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope";
                    break;
                case 7:
                    objArr[1] = "getContributedFunctions";
                    break;
                case 9:
                    objArr[1] = "getSupertypeScope";
                    break;
                case 12:
                    objArr[1] = "resolveFakeOverrides";
                    break;
                case 15:
                    objArr[1] = "getContributedDescriptors";
                    break;
                case 16:
                    objArr[1] = "computeAllDeclarations";
                    break;
                case 17:
                    objArr[1] = "getFunctionNames";
                    break;
                case 18:
                    objArr[1] = "getClassifierNames";
                    break;
                case 19:
                    objArr[1] = "getVariableNames";
                    break;
            }
            switch (i2) {
                case 1:
                case 2:
                    objArr[2] = "getContributedVariables";
                    break;
                case 3:
                case 7:
                case 9:
                case 12:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                    break;
                case 4:
                    objArr[2] = "computeProperties";
                    break;
                case 5:
                case 6:
                    objArr[2] = "getContributedFunctions";
                    break;
                case 8:
                    objArr[2] = "computeFunctions";
                    break;
                case 10:
                case 11:
                    objArr[2] = "resolveFakeOverrides";
                    break;
                case 13:
                case 14:
                    objArr[2] = "getContributedDescriptors";
                    break;
                case 20:
                    objArr[2] = "printScopeStructure";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String format = String.format(str, objArr);
            switch (i2) {
                case 3:
                case 7:
                case 9:
                case 12:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                    illegalStateException = new IllegalStateException(format);
                    break;
                case 4:
                case 5:
                case 6:
                case 8:
                case 10:
                case 11:
                case 13:
                case 14:
                default:
                    illegalStateException = new IllegalArgumentException(format);
                    break;
            }
            AppMethodBeat.o(57083);
            throw illegalStateException;
        }

        static {
            AppMethodBeat.i(57082);
            AppMethodBeat.o(57082);
        }

        static /* synthetic */ Collection a(a aVar, kotlin.l.b.a.b.f.f fVar) {
            AppMethodBeat.i(57079);
            if (fVar == null) {
                atM(8);
            }
            Collection a2 = aVar.a(fVar, aVar.hBZ().b(fVar, kotlin.l.b.a.b.c.a.c.FOR_NON_TRACKED_SCOPE));
            AppMethodBeat.o(57079);
            return a2;
        }

        static /* synthetic */ Collection b(a aVar, kotlin.l.b.a.b.f.f fVar) {
            AppMethodBeat.i(57080);
            if (fVar == null) {
                atM(4);
            }
            Collection a2 = aVar.a(fVar, aVar.hBZ().a(fVar, kotlin.l.b.a.b.c.a.c.FOR_NON_TRACKED_SCOPE));
            AppMethodBeat.o(57080);
            return a2;
        }

        public a(final n nVar, j jVar) {
            if (jVar == null) {
                atM(0);
            }
            this.TkC = nVar;
            AppMethodBeat.i(57071);
            this.Tkz = jVar.U(new b<kotlin.l.b.a.b.f.f, Collection<? extends am>>() {
                /* class kotlin.l.b.a.b.b.c.n.a.AnonymousClass1 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.g.a.b
                public final /* synthetic */ Collection<? extends am> invoke(kotlin.l.b.a.b.f.f fVar) {
                    AppMethodBeat.i(57065);
                    Collection a2 = a.a(a.this, fVar);
                    AppMethodBeat.o(57065);
                    return a2;
                }
            });
            this.TkA = jVar.U(new b<kotlin.l.b.a.b.f.f, Collection<? extends ah>>() {
                /* class kotlin.l.b.a.b.b.c.n.a.AnonymousClass2 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.g.a.b
                public final /* synthetic */ Collection<? extends ah> invoke(kotlin.l.b.a.b.f.f fVar) {
                    AppMethodBeat.i(57066);
                    Collection b2 = a.b(a.this, fVar);
                    AppMethodBeat.o(57066);
                    return b2;
                }
            });
            this.TkB = jVar.al(new kotlin.g.a.a<Collection<l>>() {
                /* class kotlin.l.b.a.b.b.c.n.a.AnonymousClass3 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ Collection<l> invoke() {
                    AppMethodBeat.i(57067);
                    Collection a2 = a.a(a.this);
                    AppMethodBeat.o(57067);
                    return a2;
                }
            });
            AppMethodBeat.o(57071);
        }

        @Override // kotlin.l.b.a.b.j.f.h, kotlin.l.b.a.b.j.f.i
        public final Collection<? extends ah> a(kotlin.l.b.a.b.f.f fVar, kotlin.l.b.a.b.c.a.a aVar) {
            AppMethodBeat.i(57072);
            if (fVar == null) {
                atM(1);
            }
            if (aVar == null) {
                atM(2);
            }
            Collection<? extends ah> invoke = this.TkA.invoke(fVar);
            if (invoke == null) {
                atM(3);
            }
            AppMethodBeat.o(57072);
            return invoke;
        }

        @Override // kotlin.l.b.a.b.j.f.j, kotlin.l.b.a.b.j.f.h, kotlin.l.b.a.b.j.f.i
        public final Collection<? extends am> b(kotlin.l.b.a.b.f.f fVar, kotlin.l.b.a.b.c.a.a aVar) {
            AppMethodBeat.i(57073);
            if (fVar == null) {
                atM(5);
            }
            if (aVar == null) {
                atM(6);
            }
            Collection<? extends am> invoke = this.Tkz.invoke(fVar);
            if (invoke == null) {
                atM(7);
            }
            AppMethodBeat.o(57073);
            return invoke;
        }

        private h hBZ() {
            AppMethodBeat.i(57074);
            Collection<ab> hBV = this.TkC.hzz().hBV();
            if ($assertionsDisabled || hBV.size() == 1) {
                h hAp = hBV.iterator().next().hAp();
                if (hAp == null) {
                    atM(9);
                }
                AppMethodBeat.o(57074);
                return hAp;
            }
            AssertionError assertionError = new AssertionError("Enum entry and its companion object both should have exactly one supertype: ".concat(String.valueOf(hBV)));
            AppMethodBeat.o(57074);
            throw assertionError;
        }

        private <D extends kotlin.l.b.a.b.b.b> Collection<? extends D> a(kotlin.l.b.a.b.f.f fVar, Collection<? extends D> collection) {
            AppMethodBeat.i(57075);
            if (fVar == null) {
                atM(10);
            }
            if (collection == null) {
                atM(11);
            }
            final LinkedHashSet linkedHashSet = new LinkedHashSet();
            kotlin.l.b.a.b.j.i.THP.a(fVar, collection, Collections.emptySet(), this.TkC, new kotlin.l.b.a.b.j.g() {
                /* class kotlin.l.b.a.b.b.c.n.a.AnonymousClass4 */

                private static /* synthetic */ void atM(int i2) {
                    AppMethodBeat.i(57070);
                    Object[] objArr = new Object[3];
                    switch (i2) {
                        case 1:
                            objArr[0] = "fromSuper";
                            break;
                        case 2:
                            objArr[0] = "fromCurrent";
                            break;
                        default:
                            objArr[0] = "fakeOverride";
                            break;
                    }
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope$4";
                    switch (i2) {
                        case 1:
                        case 2:
                            objArr[2] = "conflict";
                            break;
                        default:
                            objArr[2] = "addFakeOverride";
                            break;
                    }
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
                    AppMethodBeat.o(57070);
                    throw illegalArgumentException;
                }

                @Override // kotlin.l.b.a.b.j.h
                public final void e(kotlin.l.b.a.b.b.b bVar) {
                    AppMethodBeat.i(57068);
                    if (bVar == null) {
                        atM(0);
                    }
                    kotlin.l.b.a.b.j.i.a(bVar, (b<kotlin.l.b.a.b.b.b, x>) null);
                    linkedHashSet.add(bVar);
                    AppMethodBeat.o(57068);
                }

                @Override // kotlin.l.b.a.b.j.g
                public final void a(kotlin.l.b.a.b.b.b bVar, kotlin.l.b.a.b.b.b bVar2) {
                    AppMethodBeat.i(57069);
                    if (bVar == null) {
                        atM(1);
                    }
                    if (bVar2 == null) {
                        atM(2);
                    }
                    AppMethodBeat.o(57069);
                }
            });
            AppMethodBeat.o(57075);
            return linkedHashSet;
        }

        @Override // kotlin.l.b.a.b.j.f.j, kotlin.l.b.a.b.j.f.i
        public final Collection<l> a(kotlin.l.b.a.b.j.f.d dVar, b<? super kotlin.l.b.a.b.f.f, Boolean> bVar) {
            AppMethodBeat.i(57076);
            if (dVar == null) {
                atM(13);
            }
            if (bVar == null) {
                atM(14);
            }
            Collection<l> collection = (Collection) this.TkB.invoke();
            if (collection == null) {
                atM(15);
            }
            AppMethodBeat.o(57076);
            return collection;
        }

        @Override // kotlin.l.b.a.b.j.f.h, kotlin.l.b.a.b.j.f.i
        public final Set<kotlin.l.b.a.b.f.f> hCa() {
            AppMethodBeat.i(57077);
            Set<kotlin.l.b.a.b.f.f> set = (Set) this.TkC.Tky.invoke();
            if (set == null) {
                atM(17);
            }
            AppMethodBeat.o(57077);
            return set;
        }

        @Override // kotlin.l.b.a.b.j.f.h, kotlin.l.b.a.b.j.f.i
        public final Set<kotlin.l.b.a.b.f.f> hCb() {
            AppMethodBeat.i(57078);
            Set<kotlin.l.b.a.b.f.f> set = (Set) this.TkC.Tky.invoke();
            if (set == null) {
                atM(19);
            }
            AppMethodBeat.o(57078);
            return set;
        }

        static /* synthetic */ Collection a(a aVar) {
            AppMethodBeat.i(57081);
            HashSet hashSet = new HashSet();
            for (kotlin.l.b.a.b.f.f fVar : (Set) aVar.TkC.Tky.invoke()) {
                hashSet.addAll(aVar.b(fVar, kotlin.l.b.a.b.c.a.c.FOR_NON_TRACKED_SCOPE));
                hashSet.addAll(aVar.a(fVar, kotlin.l.b.a.b.c.a.c.FOR_NON_TRACKED_SCOPE));
            }
            AppMethodBeat.o(57081);
            return hashSet;
        }
    }
}
