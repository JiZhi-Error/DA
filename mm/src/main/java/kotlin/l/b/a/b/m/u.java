package kotlin.l.b.a.b.m;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.a.v;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.ad;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.ak;
import kotlin.l.b.a.b.b.am;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.az;
import kotlin.l.b.a.b.b.b;
import kotlin.l.b.a.b.b.c.aa;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.i;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.n;
import kotlin.l.b.a.b.b.w;
import kotlin.l.b.a.b.b.y;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.j.f.h;

public final class u {
    private static final y TNL = new y() {
        /* class kotlin.l.b.a.b.m.u.AnonymousClass1 */

        private static /* synthetic */ void atM(int i2) {
            String str;
            int i3;
            Throwable illegalStateException;
            AppMethodBeat.i(60676);
            switch (i2) {
                case 1:
                case 4:
                case 5:
                case 6:
                case 8:
                case 9:
                case 12:
                case 13:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                case 2:
                case 3:
                case 7:
                case 10:
                case 11:
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
            switch (i2) {
                case 1:
                case 4:
                case 5:
                case 6:
                case 8:
                case 9:
                case 12:
                case 13:
                    i3 = 2;
                    break;
                case 2:
                case 3:
                case 7:
                case 10:
                case 11:
                default:
                    i3 = 3;
                    break;
            }
            Object[] objArr = new Object[i3];
            switch (i2) {
                case 1:
                case 4:
                case 5:
                case 6:
                case 8:
                case 9:
                case 12:
                case 13:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$1";
                    break;
                case 2:
                case 7:
                    objArr[0] = "fqName";
                    break;
                case 3:
                    objArr[0] = "nameFilter";
                    break;
                case 10:
                    objArr[0] = "visitor";
                    break;
                case 11:
                    objArr[0] = "targetModule";
                    break;
                default:
                    objArr[0] = "capability";
                    break;
            }
            switch (i2) {
                case 1:
                    objArr[1] = "getAnnotations";
                    break;
                case 2:
                case 3:
                case 7:
                case 10:
                case 11:
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$1";
                    break;
                case 4:
                    objArr[1] = "getSubPackagesOf";
                    break;
                case 5:
                    objArr[1] = "getName";
                    break;
                case 6:
                    objArr[1] = "getStableName";
                    break;
                case 8:
                    objArr[1] = "getAllDependencyModules";
                    break;
                case 9:
                    objArr[1] = "getExpectedByModules";
                    break;
                case 12:
                    objArr[1] = "getOriginal";
                    break;
                case 13:
                    objArr[1] = "getBuiltIns";
                    break;
            }
            switch (i2) {
                case 1:
                case 4:
                case 5:
                case 6:
                case 8:
                case 9:
                case 12:
                case 13:
                    break;
                case 2:
                case 3:
                    objArr[2] = "getSubPackagesOf";
                    break;
                case 7:
                    objArr[2] = "getPackage";
                    break;
                case 10:
                    objArr[2] = "accept";
                    break;
                case 11:
                    objArr[2] = "shouldSeeInternalsOf";
                    break;
                default:
                    objArr[2] = "getCapability";
                    break;
            }
            String format = String.format(str, objArr);
            switch (i2) {
                case 1:
                case 4:
                case 5:
                case 6:
                case 8:
                case 9:
                case 12:
                case 13:
                    illegalStateException = new IllegalStateException(format);
                    break;
                case 2:
                case 3:
                case 7:
                case 10:
                case 11:
                default:
                    illegalStateException = new IllegalArgumentException(format);
                    break;
            }
            AppMethodBeat.o(60676);
            throw illegalStateException;
        }

        @Override // kotlin.l.b.a.b.b.y
        public final <T> T a(y.a<T> aVar) {
            AppMethodBeat.i(60666);
            if (aVar == null) {
                atM(0);
            }
            AppMethodBeat.o(60666);
            return null;
        }

        @Override // kotlin.l.b.a.b.b.a.a
        public final g hzL() {
            AppMethodBeat.i(60667);
            g.a aVar = g.TiC;
            g hBP = g.a.hBP();
            if (hBP == null) {
                atM(1);
            }
            AppMethodBeat.o(60667);
            return hBP;
        }

        @Override // kotlin.l.b.a.b.b.z
        public final f hAH() {
            AppMethodBeat.i(60669);
            f bua = f.bua("<ERROR MODULE>");
            AppMethodBeat.o(60669);
            return bua;
        }

        @Override // kotlin.l.b.a.b.b.y
        public final ad e(kotlin.l.b.a.b.f.b bVar) {
            AppMethodBeat.i(60670);
            if (bVar == null) {
                atM(7);
            }
            IllegalStateException illegalStateException = new IllegalStateException("Should not be called!");
            AppMethodBeat.o(60670);
            throw illegalStateException;
        }

        @Override // kotlin.l.b.a.b.b.l
        public final <R, D> R a(n<R, D> nVar, D d2) {
            AppMethodBeat.i(60672);
            if (nVar == null) {
                atM(10);
            }
            AppMethodBeat.o(60672);
            return null;
        }

        @Override // kotlin.l.b.a.b.b.y
        public final boolean a(y yVar) {
            AppMethodBeat.i(60673);
            if (yVar == null) {
                atM(11);
            }
            AppMethodBeat.o(60673);
            return false;
        }

        @Override // kotlin.l.b.a.b.b.l
        public final l hAE() {
            AppMethodBeat.i(60674);
            if (this == null) {
                atM(12);
            }
            AppMethodBeat.o(60674);
            return this;
        }

        @Override // kotlin.l.b.a.b.b.l
        public final l hzx() {
            return null;
        }

        @Override // kotlin.l.b.a.b.b.y
        public final kotlin.l.b.a.b.a.g hBh() {
            AppMethodBeat.i(60675);
            kotlin.l.b.a.b.a.d hzb = kotlin.l.b.a.b.a.d.hzb();
            if (hzb == null) {
                atM(13);
            }
            AppMethodBeat.o(60675);
            return hzb;
        }

        @Override // kotlin.l.b.a.b.b.y
        public final Collection<kotlin.l.b.a.b.f.b> a(kotlin.l.b.a.b.f.b bVar, kotlin.g.a.b<? super f, Boolean> bVar2) {
            AppMethodBeat.i(60668);
            if (bVar == null) {
                atM(2);
            }
            if (bVar2 == null) {
                atM(3);
            }
            v vVar = v.SXr;
            if (vVar == null) {
                atM(4);
            }
            AppMethodBeat.o(60668);
            return vVar;
        }

        @Override // kotlin.l.b.a.b.b.y
        public final List<y> hBi() {
            AppMethodBeat.i(60671);
            v vVar = v.SXr;
            if (vVar == null) {
                atM(9);
            }
            AppMethodBeat.o(60671);
            return vVar;
        }
    };
    private static final a TNM = new a(f.bua("<ERROR CLASS>"));
    public static final aj TNN = bun("<LOOP IN SUPERTYPES>");
    private static final ab TNO = bun("<ERROR PROPERTY TYPE>");
    private static final ah TNP;
    private static final Set<ah> TNQ;

    private static /* synthetic */ void atM(int i2) {
        String str;
        int i3;
        Throwable illegalStateException;
        AppMethodBeat.i(60727);
        switch (i2) {
            case 4:
            case 6:
            case 19:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 4:
            case 6:
            case 19:
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
            case 7:
            case 11:
            case 15:
                objArr[0] = "debugMessage";
                break;
            case 4:
            case 6:
            case 19:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils";
                break;
            case 5:
                objArr[0] = "ownerScope";
                break;
            case 8:
            case 9:
            case 16:
            case 17:
                objArr[0] = "debugName";
                break;
            case 10:
                objArr[0] = "typeConstructor";
                break;
            case 12:
            case 14:
                objArr[0] = "arguments";
                break;
            case 13:
                objArr[0] = "presentableName";
                break;
            case 18:
                objArr[0] = "errorClass";
                break;
            case 20:
                objArr[0] = "typeParameterDescriptor";
                break;
            default:
                objArr[0] = "function";
                break;
        }
        switch (i2) {
            case 4:
                objArr[1] = "createErrorProperty";
                break;
            case 6:
                objArr[1] = "createErrorFunction";
                break;
            case 19:
                objArr[1] = "getErrorModule";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils";
                break;
        }
        switch (i2) {
            case 1:
                objArr[2] = "createErrorClass";
                break;
            case 2:
            case 3:
                objArr[2] = "createErrorScope";
                break;
            case 4:
            case 6:
            case 19:
                break;
            case 5:
                objArr[2] = "createErrorFunction";
                break;
            case 7:
                objArr[2] = "createErrorType";
                break;
            case 8:
                objArr[2] = "createErrorTypeWithCustomDebugName";
                break;
            case 9:
            case 10:
                objArr[2] = "createErrorTypeWithCustomConstructor";
                break;
            case 11:
            case 12:
                objArr[2] = "createErrorTypeWithArguments";
                break;
            case 13:
            case 14:
                objArr[2] = "createUnresolvedType";
                break;
            case 15:
                objArr[2] = "createErrorTypeConstructor";
                break;
            case 16:
            case 17:
            case 18:
                objArr[2] = "createErrorTypeConstructorWithCustomDebugName";
                break;
            case 20:
                objArr[2] = "createUninferredParameterType";
                break;
            default:
                objArr[2] = "containsErrorTypeInParameters";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 4:
            case 6:
            case 19:
                illegalStateException = new IllegalStateException(format);
                break;
            default:
                illegalStateException = new IllegalArgumentException(format);
                break;
        }
        AppMethodBeat.o(60727);
        throw illegalStateException;
    }

    static /* synthetic */ at b(String str, a aVar) {
        AppMethodBeat.i(60725);
        at a2 = a(str, aVar);
        AppMethodBeat.o(60725);
        return a2;
    }

    static {
        AppMethodBeat.i(60726);
        a aVar = TNM;
        g.a aVar2 = g.TiC;
        aa a2 = aa.a(aVar, g.a.hBP(), w.OPEN, az.ThU, f.bua("<ERROR PROPERTY>"), b.a.DECLARATION, an.ThK);
        a2.a(TNO, Collections.emptyList(), (ak) null, (ak) null);
        TNP = a2;
        TNQ = Collections.singleton(a2);
        AppMethodBeat.o(60726);
    }

    public static class b implements h {
        private final String debugMessage;

        private static /* synthetic */ void atM(int i2) {
            String str;
            int i3;
            Throwable illegalStateException;
            AppMethodBeat.i(60695);
            switch (i2) {
                case 7:
                case 10:
                case 11:
                case 12:
                case 13:
                case 18:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                case 8:
                case 9:
                case 14:
                case 15:
                case 16:
                case 17:
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
            switch (i2) {
                case 7:
                case 10:
                case 11:
                case 12:
                case 13:
                case 18:
                    i3 = 2;
                    break;
                case 8:
                case 9:
                case 14:
                case 15:
                case 16:
                case 17:
                default:
                    i3 = 3;
                    break;
            }
            Object[] objArr = new Object[i3];
            switch (i2) {
                case 1:
                case 3:
                case 5:
                case 8:
                case 14:
                case 19:
                    objArr[0] = "name";
                    break;
                case 2:
                case 4:
                case 6:
                case 9:
                case 15:
                    objArr[0] = FirebaseAnalytics.b.LOCATION;
                    break;
                case 7:
                case 10:
                case 11:
                case 12:
                case 13:
                case 18:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorScope";
                    break;
                case 16:
                    objArr[0] = "kindFilter";
                    break;
                case 17:
                    objArr[0] = "nameFilter";
                    break;
                case 20:
                    objArr[0] = "p";
                    break;
                default:
                    objArr[0] = "debugMessage";
                    break;
            }
            switch (i2) {
                case 7:
                    objArr[1] = "getContributedVariables";
                    break;
                case 8:
                case 9:
                case 14:
                case 15:
                case 16:
                case 17:
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorScope";
                    break;
                case 10:
                    objArr[1] = "getContributedFunctions";
                    break;
                case 11:
                    objArr[1] = "getFunctionNames";
                    break;
                case 12:
                    objArr[1] = "getVariableNames";
                    break;
                case 13:
                    objArr[1] = "getClassifierNames";
                    break;
                case 18:
                    objArr[1] = "getContributedDescriptors";
                    break;
            }
            switch (i2) {
                case 1:
                case 2:
                    objArr[2] = "getContributedClassifier";
                    break;
                case 3:
                case 4:
                    objArr[2] = "getContributedClassifierIncludeDeprecated";
                    break;
                case 5:
                case 6:
                    objArr[2] = "getContributedVariables";
                    break;
                case 7:
                case 10:
                case 11:
                case 12:
                case 13:
                case 18:
                    break;
                case 8:
                case 9:
                    objArr[2] = "getContributedFunctions";
                    break;
                case 14:
                case 15:
                    objArr[2] = "recordLookup";
                    break;
                case 16:
                case 17:
                    objArr[2] = "getContributedDescriptors";
                    break;
                case 19:
                    objArr[2] = "definitelyDoesNotContainName";
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
                case 7:
                case 10:
                case 11:
                case 12:
                case 13:
                case 18:
                    illegalStateException = new IllegalStateException(format);
                    break;
                case 8:
                case 9:
                case 14:
                case 15:
                case 16:
                case 17:
                default:
                    illegalStateException = new IllegalArgumentException(format);
                    break;
            }
            AppMethodBeat.o(60695);
            throw illegalStateException;
        }

        /* synthetic */ b(String str, byte b2) {
            this(str);
        }

        @Override // kotlin.l.b.a.b.j.f.h
        public final /* synthetic */ Collection a(f fVar, kotlin.l.b.a.b.c.a.a aVar) {
            AppMethodBeat.i(60694);
            if (fVar == null) {
                atM(5);
            }
            if (aVar == null) {
                atM(6);
            }
            Set set = u.TNQ;
            if (set == null) {
                atM(7);
            }
            AppMethodBeat.o(60694);
            return set;
        }

        @Override // kotlin.l.b.a.b.j.f.j, kotlin.l.b.a.b.j.f.h
        public final /* synthetic */ Collection b(f fVar, kotlin.l.b.a.b.c.a.a aVar) {
            AppMethodBeat.i(60693);
            if (fVar == null) {
                atM(8);
            }
            if (aVar == null) {
                atM(9);
            }
            Set singleton = Collections.singleton(u.a(this));
            if (singleton == null) {
                atM(10);
            }
            AppMethodBeat.o(60693);
            return singleton;
        }

        private b(String str) {
            if (str == null) {
                atM(0);
            }
            AppMethodBeat.i(60687);
            this.debugMessage = str;
            AppMethodBeat.o(60687);
        }

        @Override // kotlin.l.b.a.b.j.f.j
        public final kotlin.l.b.a.b.b.h c(f fVar, kotlin.l.b.a.b.c.a.a aVar) {
            AppMethodBeat.i(60688);
            if (fVar == null) {
                atM(1);
            }
            if (aVar == null) {
                atM(2);
            }
            e bul = u.bul(fVar.sG());
            AppMethodBeat.o(60688);
            return bul;
        }

        @Override // kotlin.l.b.a.b.j.f.h
        public final Set<f> hCa() {
            AppMethodBeat.i(60689);
            Set<f> emptySet = Collections.emptySet();
            if (emptySet == null) {
                atM(11);
            }
            AppMethodBeat.o(60689);
            return emptySet;
        }

        @Override // kotlin.l.b.a.b.j.f.h
        public final Set<f> hCb() {
            AppMethodBeat.i(60690);
            Set<f> emptySet = Collections.emptySet();
            if (emptySet == null) {
                atM(12);
            }
            AppMethodBeat.o(60690);
            return emptySet;
        }

        @Override // kotlin.l.b.a.b.j.f.j
        public final Collection<l> a(kotlin.l.b.a.b.j.f.d dVar, kotlin.g.a.b<? super f, Boolean> bVar) {
            AppMethodBeat.i(60691);
            if (dVar == null) {
                atM(16);
            }
            if (bVar == null) {
                atM(17);
            }
            List emptyList = Collections.emptyList();
            if (emptyList == null) {
                atM(18);
            }
            AppMethodBeat.o(60691);
            return emptyList;
        }

        public final String toString() {
            AppMethodBeat.i(60692);
            String str = "ErrorScope{" + this.debugMessage + '}';
            AppMethodBeat.o(60692);
            return str;
        }
    }

    /* access modifiers changed from: package-private */
    public static class c implements h {
        private final String debugMessage;

        private static /* synthetic */ void atM(int i2) {
            AppMethodBeat.i(60704);
            Object[] objArr = new Object[3];
            switch (i2) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 11:
                case 13:
                    objArr[0] = "name";
                    break;
                case 2:
                case 4:
                case 6:
                case 8:
                case 12:
                    objArr[0] = FirebaseAnalytics.b.LOCATION;
                    break;
                case 9:
                    objArr[0] = "kindFilter";
                    break;
                case 10:
                    objArr[0] = "nameFilter";
                    break;
                case 14:
                    objArr[0] = "p";
                    break;
                default:
                    objArr[0] = "message";
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ThrowingScope";
            switch (i2) {
                case 1:
                case 2:
                    objArr[2] = "getContributedClassifier";
                    break;
                case 3:
                case 4:
                    objArr[2] = "getContributedClassifierIncludeDeprecated";
                    break;
                case 5:
                case 6:
                    objArr[2] = "getContributedVariables";
                    break;
                case 7:
                case 8:
                    objArr[2] = "getContributedFunctions";
                    break;
                case 9:
                case 10:
                    objArr[2] = "getContributedDescriptors";
                    break;
                case 11:
                case 12:
                    objArr[2] = "recordLookup";
                    break;
                case 13:
                    objArr[2] = "definitelyDoesNotContainName";
                    break;
                case 14:
                    objArr[2] = "printScopeStructure";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
            AppMethodBeat.o(60704);
            throw illegalArgumentException;
        }

        /* synthetic */ c(String str, byte b2) {
            this(str);
        }

        private c(String str) {
            if (str == null) {
                atM(0);
            }
            AppMethodBeat.i(60696);
            this.debugMessage = str;
            AppMethodBeat.o(60696);
        }

        @Override // kotlin.l.b.a.b.j.f.j
        public final kotlin.l.b.a.b.b.h c(f fVar, kotlin.l.b.a.b.c.a.a aVar) {
            AppMethodBeat.i(60697);
            if (fVar == null) {
                atM(1);
            }
            if (aVar == null) {
                atM(2);
            }
            IllegalStateException illegalStateException = new IllegalStateException(this.debugMessage + ", required name: " + fVar);
            AppMethodBeat.o(60697);
            throw illegalStateException;
        }

        @Override // kotlin.l.b.a.b.j.f.h
        public final Collection<? extends ah> a(f fVar, kotlin.l.b.a.b.c.a.a aVar) {
            AppMethodBeat.i(60698);
            if (fVar == null) {
                atM(5);
            }
            if (aVar == null) {
                atM(6);
            }
            IllegalStateException illegalStateException = new IllegalStateException(this.debugMessage + ", required name: " + fVar);
            AppMethodBeat.o(60698);
            throw illegalStateException;
        }

        @Override // kotlin.l.b.a.b.j.f.j, kotlin.l.b.a.b.j.f.h
        public final Collection<? extends am> b(f fVar, kotlin.l.b.a.b.c.a.a aVar) {
            AppMethodBeat.i(60699);
            if (fVar == null) {
                atM(7);
            }
            if (aVar == null) {
                atM(8);
            }
            IllegalStateException illegalStateException = new IllegalStateException(this.debugMessage + ", required name: " + fVar);
            AppMethodBeat.o(60699);
            throw illegalStateException;
        }

        @Override // kotlin.l.b.a.b.j.f.j
        public final Collection<l> a(kotlin.l.b.a.b.j.f.d dVar, kotlin.g.a.b<? super f, Boolean> bVar) {
            AppMethodBeat.i(60700);
            if (dVar == null) {
                atM(9);
            }
            if (bVar == null) {
                atM(10);
            }
            IllegalStateException illegalStateException = new IllegalStateException(this.debugMessage);
            AppMethodBeat.o(60700);
            throw illegalStateException;
        }

        @Override // kotlin.l.b.a.b.j.f.h
        public final Set<f> hCa() {
            AppMethodBeat.i(60701);
            IllegalStateException illegalStateException = new IllegalStateException();
            AppMethodBeat.o(60701);
            throw illegalStateException;
        }

        @Override // kotlin.l.b.a.b.j.f.h
        public final Set<f> hCb() {
            AppMethodBeat.i(60702);
            IllegalStateException illegalStateException = new IllegalStateException();
            AppMethodBeat.o(60702);
            throw illegalStateException;
        }

        public final String toString() {
            AppMethodBeat.i(60703);
            String str = "ThrowingScope{" + this.debugMessage + '}';
            AppMethodBeat.o(60703);
            return str;
        }
    }

    /* access modifiers changed from: package-private */
    public static class a extends kotlin.l.b.a.b.b.c.h {
        private static /* synthetic */ void atM(int i2) {
            String str;
            int i3;
            Throwable illegalStateException;
            AppMethodBeat.i(60686);
            switch (i2) {
                case 2:
                case 5:
                case 8:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
            switch (i2) {
                case 2:
                case 5:
                case 8:
                    i3 = 2;
                    break;
                default:
                    i3 = 3;
                    break;
            }
            Object[] objArr = new Object[i3];
            switch (i2) {
                case 1:
                    objArr[0] = "substitutor";
                    break;
                case 2:
                case 5:
                case 8:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorClassDescriptor";
                    break;
                case 3:
                    objArr[0] = "typeArguments";
                    break;
                case 4:
                case 7:
                    objArr[0] = "kotlinTypeRefiner";
                    break;
                case 6:
                    objArr[0] = "typeSubstitution";
                    break;
                default:
                    objArr[0] = "name";
                    break;
            }
            switch (i2) {
                case 2:
                    objArr[1] = "substitute";
                    break;
                case 5:
                case 8:
                    objArr[1] = "getMemberScope";
                    break;
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorClassDescriptor";
                    break;
            }
            switch (i2) {
                case 1:
                    objArr[2] = "substitute";
                    break;
                case 2:
                case 5:
                case 8:
                    break;
                case 3:
                case 4:
                case 6:
                case 7:
                    objArr[2] = "getMemberScope";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String format = String.format(str, objArr);
            switch (i2) {
                case 2:
                case 5:
                case 8:
                    illegalStateException = new IllegalStateException(format);
                    break;
                default:
                    illegalStateException = new IllegalArgumentException(format);
                    break;
            }
            AppMethodBeat.o(60686);
            throw illegalStateException;
        }

        /* Return type fixed from 'kotlin.l.b.a.b.b.m' to match base method */
        @Override // kotlin.l.b.a.b.b.c.a, kotlin.l.b.a.b.b.ap
        public final /* synthetic */ i f(ba baVar) {
            AppMethodBeat.i(60685);
            e g2 = g(baVar);
            AppMethodBeat.o(60685);
            return g2;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(f fVar) {
            super(u.hLA(), fVar, w.OPEN, kotlin.l.b.a.b.b.f.CLASS, Collections.emptyList(), an.ThK, kotlin.l.b.a.b.l.b.TMN);
            if (fVar == null) {
                atM(0);
            }
            AppMethodBeat.i(60681);
            g.a aVar = g.TiC;
            kotlin.l.b.a.b.b.c.f a2 = kotlin.l.b.a.b.b.c.f.a(this, g.a.hBP(), an.ThK);
            a2.a(Collections.emptyList(), az.ThT);
            h bum = u.bum(hAH().sG());
            a2.I(new t(u.b("<ERROR>", this), bum));
            a(bum, Collections.singleton(a2), a2);
            AppMethodBeat.o(60681);
        }

        @Override // kotlin.l.b.a.b.b.c.a
        public final e g(ba baVar) {
            AppMethodBeat.i(60682);
            if (baVar == null) {
                atM(1);
            }
            AppMethodBeat.o(60682);
            return this;
        }

        @Override // kotlin.l.b.a.b.b.c.h
        public final String toString() {
            AppMethodBeat.i(60683);
            String sG = hAH().sG();
            AppMethodBeat.o(60683);
            return sG;
        }

        @Override // kotlin.l.b.a.b.b.c.a, kotlin.l.b.a.b.b.c.t
        public final h a(ay ayVar, kotlin.l.b.a.b.m.a.i iVar) {
            AppMethodBeat.i(60684);
            if (ayVar == null) {
                atM(6);
            }
            if (iVar == null) {
                atM(7);
            }
            h bum = u.bum("Error scope for class " + hAH() + " with arguments: " + ayVar);
            if (bum == null) {
                atM(8);
            }
            AppMethodBeat.o(60684);
            return bum;
        }
    }

    public static e bul(String str) {
        AppMethodBeat.i(60712);
        if (str == null) {
            atM(1);
        }
        a aVar = new a(f.bua("<ERROR CLASS: " + str + ">"));
        AppMethodBeat.o(60712);
        return aVar;
    }

    public static h bum(String str) {
        AppMethodBeat.i(60713);
        if (str == null) {
            atM(2);
        }
        h dU = dU(str, false);
        AppMethodBeat.o(60713);
        return dU;
    }

    public static h dU(String str, boolean z) {
        AppMethodBeat.i(60714);
        if (str == null) {
            atM(3);
        }
        if (z) {
            c cVar = new c(str, (byte) 0);
            AppMethodBeat.o(60714);
            return cVar;
        }
        b bVar = new b(str, (byte) 0);
        AppMethodBeat.o(60714);
        return bVar;
    }

    public static aj bun(String str) {
        AppMethodBeat.i(60715);
        if (str == null) {
            atM(7);
        }
        aj S = S(str, Collections.emptyList());
        AppMethodBeat.o(60715);
        return S;
    }

    public static aj a(String str, at atVar) {
        AppMethodBeat.i(60717);
        if (str == null) {
            atM(9);
        }
        if (atVar == null) {
            atM(10);
        }
        t tVar = new t(atVar, bum(str));
        AppMethodBeat.o(60717);
        return tVar;
    }

    public static aj S(String str, List<av> list) {
        AppMethodBeat.i(60718);
        if (str == null) {
            atM(11);
        }
        if (list == null) {
            atM(12);
        }
        t tVar = new t(bup(str), bum(str), list);
        AppMethodBeat.o(60718);
        return tVar;
    }

    public static at bup(String str) {
        AppMethodBeat.i(60719);
        if (str == null) {
            atM(15);
        }
        at a2 = a("[ERROR : " + str + "]", TNM);
        AppMethodBeat.o(60719);
        return a2;
    }

    private static at a(final String str, final a aVar) {
        AppMethodBeat.i(60720);
        if (str == null) {
            atM(17);
        }
        if (aVar == null) {
            atM(18);
        }
        AnonymousClass2 r0 = new at() {
            /* class kotlin.l.b.a.b.m.u.AnonymousClass2 */

            private static /* synthetic */ void atM(int i2) {
                String str;
                int i3;
                Throwable illegalArgumentException;
                AppMethodBeat.i(60680);
                switch (i2) {
                    case 3:
                        str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                        break;
                    default:
                        str = "@NotNull method %s.%s must not return null";
                        break;
                }
                switch (i2) {
                    case 3:
                        i3 = 3;
                        break;
                    default:
                        i3 = 2;
                        break;
                }
                Object[] objArr = new Object[i3];
                switch (i2) {
                    case 3:
                        objArr[0] = "kotlinTypeRefiner";
                        break;
                    default:
                        objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$2";
                        break;
                }
                switch (i2) {
                    case 1:
                        objArr[1] = "getSupertypes";
                        break;
                    case 2:
                        objArr[1] = "getBuiltIns";
                        break;
                    case 3:
                        objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$2";
                        break;
                    case 4:
                        objArr[1] = "refine";
                        break;
                    default:
                        objArr[1] = "getParameters";
                        break;
                }
                switch (i2) {
                    case 3:
                        objArr[2] = "refine";
                        break;
                }
                String format = String.format(str, objArr);
                switch (i2) {
                    case 3:
                        illegalArgumentException = new IllegalArgumentException(format);
                        break;
                    default:
                        illegalArgumentException = new IllegalStateException(format);
                        break;
                }
                AppMethodBeat.o(60680);
                throw illegalArgumentException;
            }

            @Override // kotlin.l.b.a.b.m.at
            public final boolean hzU() {
                return false;
            }

            @Override // kotlin.l.b.a.b.m.at
            public final kotlin.l.b.a.b.b.h hzS() {
                return aVar;
            }

            @Override // kotlin.l.b.a.b.m.at
            public final kotlin.l.b.a.b.a.g hBh() {
                AppMethodBeat.i(60679);
                kotlin.l.b.a.b.a.d hzb = kotlin.l.b.a.b.a.d.hzb();
                if (hzb == null) {
                    atM(2);
                }
                AppMethodBeat.o(60679);
                return hzb;
            }

            public final String toString() {
                return str;
            }

            @Override // kotlin.l.b.a.b.m.at
            public final List<as> getParameters() {
                AppMethodBeat.i(60677);
                v vVar = v.SXr;
                if (vVar == null) {
                    atM(0);
                }
                AppMethodBeat.o(60677);
                return vVar;
            }

            @Override // kotlin.l.b.a.b.m.at
            public final Collection<ab> hBV() {
                AppMethodBeat.i(60678);
                v vVar = v.SXr;
                if (vVar == null) {
                    atM(1);
                }
                AppMethodBeat.o(60678);
                return vVar;
            }
        };
        AppMethodBeat.o(60720);
        return r0;
    }

    public static boolean L(l lVar) {
        AppMethodBeat.i(60721);
        if (lVar == null) {
            AppMethodBeat.o(60721);
            return false;
        } else if ((lVar instanceof a) || (lVar.hzx() instanceof a) || lVar == TNL) {
            AppMethodBeat.o(60721);
            return true;
        } else {
            AppMethodBeat.o(60721);
            return false;
        }
    }

    public static y hLA() {
        AppMethodBeat.i(60722);
        y yVar = TNL;
        if (yVar == null) {
            atM(19);
        }
        AppMethodBeat.o(60722);
        return yVar;
    }

    public static boolean ak(ab abVar) {
        AppMethodBeat.i(60723);
        if (abVar == null || !(abVar.hKE() instanceof d)) {
            AppMethodBeat.o(60723);
            return false;
        }
        AppMethodBeat.o(60723);
        return true;
    }

    public static class d implements at {
        private final as TNT;
        private final at TNU;

        private static /* synthetic */ void atM(int i2) {
            String str;
            int i3;
            Throwable illegalStateException;
            AppMethodBeat.i(60711);
            switch (i2) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 6:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                case 5:
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
            switch (i2) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 6:
                    i3 = 2;
                    break;
                case 5:
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
                case 6:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$UninferredParameterTypeConstructor";
                    break;
                case 5:
                    objArr[0] = "kotlinTypeRefiner";
                    break;
                default:
                    objArr[0] = "descriptor";
                    break;
            }
            switch (i2) {
                case 1:
                    objArr[1] = "getTypeParameterDescriptor";
                    break;
                case 2:
                    objArr[1] = "getParameters";
                    break;
                case 3:
                    objArr[1] = "getSupertypes";
                    break;
                case 4:
                    objArr[1] = "getBuiltIns";
                    break;
                case 5:
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$UninferredParameterTypeConstructor";
                    break;
                case 6:
                    objArr[1] = "refine";
                    break;
            }
            switch (i2) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 6:
                    break;
                case 5:
                    objArr[2] = "refine";
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
                case 6:
                    illegalStateException = new IllegalStateException(format);
                    break;
                case 5:
                default:
                    illegalStateException = new IllegalArgumentException(format);
                    break;
            }
            AppMethodBeat.o(60711);
            throw illegalStateException;
        }

        public final as hLB() {
            AppMethodBeat.i(60705);
            as asVar = this.TNT;
            if (asVar == null) {
                atM(1);
            }
            AppMethodBeat.o(60705);
            return asVar;
        }

        @Override // kotlin.l.b.a.b.m.at
        public final List<as> getParameters() {
            AppMethodBeat.i(60706);
            List<as> parameters = this.TNU.getParameters();
            if (parameters == null) {
                atM(2);
            }
            AppMethodBeat.o(60706);
            return parameters;
        }

        @Override // kotlin.l.b.a.b.m.at
        public final Collection<ab> hBV() {
            AppMethodBeat.i(60707);
            Collection<ab> hBV = this.TNU.hBV();
            if (hBV == null) {
                atM(3);
            }
            AppMethodBeat.o(60707);
            return hBV;
        }

        @Override // kotlin.l.b.a.b.m.at
        public final boolean hzU() {
            AppMethodBeat.i(60708);
            boolean hzU = this.TNU.hzU();
            AppMethodBeat.o(60708);
            return hzU;
        }

        @Override // kotlin.l.b.a.b.m.at
        public final kotlin.l.b.a.b.b.h hzS() {
            AppMethodBeat.i(60709);
            kotlin.l.b.a.b.b.h hzS = this.TNU.hzS();
            AppMethodBeat.o(60709);
            return hzS;
        }

        @Override // kotlin.l.b.a.b.m.at
        public final kotlin.l.b.a.b.a.g hBh() {
            AppMethodBeat.i(60710);
            kotlin.l.b.a.b.a.g G = kotlin.l.b.a.b.j.d.a.G(this.TNT);
            if (G == null) {
                atM(4);
            }
            AppMethodBeat.o(60710);
            return G;
        }
    }

    public static aj buo(String str) {
        AppMethodBeat.i(60716);
        aj a2 = a(str, a(str, TNM));
        AppMethodBeat.o(60716);
        return a2;
    }

    static /* synthetic */ am a(b bVar) {
        AppMethodBeat.i(60724);
        kotlin.l.b.a.b.m.b.a aVar = new kotlin.l.b.a.b.m.b.a(TNM, bVar);
        aVar.b(null, null, Collections.emptyList(), Collections.emptyList(), bun("<ERROR FUNCTION RETURN TYPE>"), w.OPEN, az.ThU);
        AppMethodBeat.o(60724);
        return aVar;
    }
}
