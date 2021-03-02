package kotlin.l.b.a.b.d.a.a;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.LinkedHashSet;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.b;
import kotlin.l.b.a.b.b.d;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.j.g;
import kotlin.l.b.a.b.j.i;
import kotlin.l.b.a.b.k.a.r;
import kotlin.x;

public final class a {
    public static /* synthetic */ void atM(int i2) {
        String str;
        int i3;
        Throwable illegalStateException;
        AppMethodBeat.i(57652);
        switch (i2) {
            case 18:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 18:
                i3 = 2;
                break;
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
            case 7:
            case 13:
                objArr[0] = "membersFromSupertypes";
                break;
            case 2:
            case 8:
            case 14:
                objArr[0] = "membersFromCurrent";
                break;
            case 3:
            case 9:
            case 15:
                objArr[0] = "classDescriptor";
                break;
            case 4:
            case 10:
            case 16:
                objArr[0] = "errorReporter";
                break;
            case 5:
            case 11:
            case 17:
                objArr[0] = "overridingUtil";
                break;
            case 6:
            case 12:
            case 19:
            default:
                objArr[0] = "name";
                break;
            case 18:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils";
                break;
            case 20:
                objArr[0] = "annotationClass";
                break;
            case 21:
                objArr[0] = "member";
                break;
            case 22:
            case 23:
                objArr[0] = FirebaseAnalytics.b.METHOD;
                break;
        }
        switch (i2) {
            case 18:
                objArr[1] = "resolveOverrides";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils";
                break;
        }
        switch (i2) {
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                objArr[2] = "resolveOverridesForStaticMembers";
                break;
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
                objArr[2] = "resolveOverrides";
                break;
            case 18:
                break;
            case 19:
            case 20:
                objArr[2] = "getAnnotationParameterByName";
                break;
            case 21:
                objArr[2] = "isObjectMethodInInterface";
                break;
            case 22:
                objArr[2] = "isObjectMethod";
                break;
            case 23:
                objArr[2] = "isMethodWithOneObjectParameter";
                break;
            default:
                objArr[2] = "resolveOverridesForNonStaticMembers";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 18:
                illegalStateException = new IllegalStateException(format);
                break;
            default:
                illegalStateException = new IllegalArgumentException(format);
                break;
        }
        AppMethodBeat.o(57652);
        throw illegalStateException;
    }

    public static <D extends b> Collection<D> a(f fVar, Collection<D> collection, Collection<D> collection2, e eVar, r rVar, i iVar) {
        AppMethodBeat.i(57648);
        if (fVar == null) {
            atM(0);
        }
        if (collection == null) {
            atM(1);
        }
        if (collection2 == null) {
            atM(2);
        }
        if (eVar == null) {
            atM(3);
        }
        if (rVar == null) {
            atM(4);
        }
        if (iVar == null) {
            atM(5);
        }
        Collection<D> a2 = a(fVar, collection, collection2, eVar, rVar, iVar, false);
        AppMethodBeat.o(57648);
        return a2;
    }

    public static <D extends b> Collection<D> b(f fVar, Collection<D> collection, Collection<D> collection2, e eVar, r rVar, i iVar) {
        AppMethodBeat.i(57649);
        if (fVar == null) {
            atM(6);
        }
        if (collection == null) {
            atM(7);
        }
        if (collection2 == null) {
            atM(8);
        }
        if (eVar == null) {
            atM(9);
        }
        if (rVar == null) {
            atM(10);
        }
        if (iVar == null) {
            atM(11);
        }
        Collection<D> a2 = a(fVar, collection, collection2, eVar, rVar, iVar, true);
        AppMethodBeat.o(57649);
        return a2;
    }

    private static <D extends b> Collection<D> a(f fVar, Collection<D> collection, Collection<D> collection2, e eVar, final r rVar, i iVar, final boolean z) {
        AppMethodBeat.i(57650);
        if (fVar == null) {
            atM(12);
        }
        if (collection == null) {
            atM(13);
        }
        if (collection2 == null) {
            atM(14);
        }
        if (eVar == null) {
            atM(15);
        }
        if (rVar == null) {
            atM(16);
        }
        if (iVar == null) {
            atM(17);
        }
        final LinkedHashSet linkedHashSet = new LinkedHashSet();
        iVar.a(fVar, collection, collection2, eVar, new g() {
            /* class kotlin.l.b.a.b.d.a.a.a.AnonymousClass1 */

            private static /* synthetic */ void atM(int i2) {
                AppMethodBeat.i(57647);
                Object[] objArr = new Object[3];
                switch (i2) {
                    case 1:
                        objArr[0] = "fromSuper";
                        break;
                    case 2:
                        objArr[0] = "fromCurrent";
                        break;
                    case 3:
                        objArr[0] = "member";
                        break;
                    case 4:
                        objArr[0] = "overridden";
                        break;
                    default:
                        objArr[0] = "fakeOverride";
                        break;
                }
                objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils$1";
                switch (i2) {
                    case 1:
                    case 2:
                        objArr[2] = "conflict";
                        break;
                    case 3:
                    case 4:
                        objArr[2] = "setOverriddenDescriptors";
                        break;
                    default:
                        objArr[2] = "addFakeOverride";
                        break;
                }
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
                AppMethodBeat.o(57647);
                throw illegalArgumentException;
            }

            @Override // kotlin.l.b.a.b.j.h
            public final void e(b bVar) {
                AppMethodBeat.i(57644);
                if (bVar == null) {
                    atM(0);
                }
                i.a(bVar, new kotlin.g.a.b<b, x>() {
                    /* class kotlin.l.b.a.b.d.a.a.a.AnonymousClass1.AnonymousClass1 */

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // kotlin.g.a.b
                    public final /* synthetic */ x invoke(b bVar) {
                        AppMethodBeat.i(57643);
                        b bVar2 = bVar;
                        if (bVar2 == null) {
                            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "descriptor", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils$1$1", "invoke"));
                            AppMethodBeat.o(57643);
                            throw illegalArgumentException;
                        }
                        rVar.h(bVar2);
                        x xVar = x.SXb;
                        AppMethodBeat.o(57643);
                        return xVar;
                    }
                });
                linkedHashSet.add(bVar);
                AppMethodBeat.o(57644);
            }

            @Override // kotlin.l.b.a.b.j.g
            public final void a(b bVar, b bVar2) {
                AppMethodBeat.i(57645);
                if (bVar == null) {
                    atM(1);
                }
                if (bVar2 == null) {
                    atM(2);
                }
                AppMethodBeat.o(57645);
            }

            @Override // kotlin.l.b.a.b.j.h
            public final void a(b bVar, Collection<? extends b> collection) {
                AppMethodBeat.i(57646);
                if (bVar == null) {
                    atM(3);
                }
                if (collection == null) {
                    atM(4);
                }
                if (!z || bVar.hAA() == b.a.FAKE_OVERRIDE) {
                    super.a(bVar, collection);
                    AppMethodBeat.o(57646);
                    return;
                }
                AppMethodBeat.o(57646);
            }
        });
        AppMethodBeat.o(57650);
        return linkedHashSet;
    }

    public static av b(f fVar, e eVar) {
        AppMethodBeat.i(57651);
        if (fVar == null) {
            atM(19);
        }
        if (eVar == null) {
            atM(20);
        }
        Collection<d> hxW = eVar.hxW();
        if (hxW.size() != 1) {
            AppMethodBeat.o(57651);
            return null;
        }
        for (av avVar : hxW.iterator().next().hAw()) {
            if (avVar.hAH().equals(fVar)) {
                AppMethodBeat.o(57651);
                return avVar;
            }
        }
        AppMethodBeat.o(57651);
        return null;
    }
}
