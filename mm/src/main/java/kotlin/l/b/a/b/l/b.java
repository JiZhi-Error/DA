package kotlin.l.b.a.b.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.g.b.p;
import kotlin.n.n;
import kotlin.x;

public class b implements j {
    static final /* synthetic */ boolean $assertionsDisabled = (!b.class.desiredAssertionStatus());
    private static final String PACKAGE_NAME;
    public static final j TMN = new b("NO_LOCKS", c.TMU, e.TNg) {
        /* class kotlin.l.b.a.b.l.b.AnonymousClass1 */

        /* access modifiers changed from: protected */
        @Override // kotlin.l.b.a.b.l.b
        public final <T> l<T> hLr() {
            AppMethodBeat.i(60494);
            l<T> hLu = l.hLu();
            AppMethodBeat.o(60494);
            return hLu;
        }
    };
    private final c TMO;
    private final String TMP;
    protected final Lock aIR;

    public interface c {
        public static final c TMU = new c() {
            /* class kotlin.l.b.a.b.l.b.c.AnonymousClass1 */

            @Override // kotlin.l.b.a.b.l.b.c
            public final RuntimeException t(Throwable th) {
                AppMethodBeat.i(60507);
                p.h(th, "e");
                AppMethodBeat.o(60507);
                throw th;
            }
        };

        RuntimeException t(Throwable th);
    }

    private static /* synthetic */ void atM(int i2) {
        String str;
        int i3;
        Throwable illegalStateException;
        AppMethodBeat.i(60550);
        switch (i2) {
            case 8:
            case 12:
            case 28:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 8:
            case 12:
            case 28:
                i3 = 2;
                break;
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
            case 3:
            case 6:
                objArr[0] = "exceptionHandlingStrategy";
                break;
            case 2:
            case 5:
            default:
                objArr[0] = "debugText";
                break;
            case 4:
                objArr[0] = "lock";
                break;
            case 7:
            case 9:
            case 11:
            case 13:
                objArr[0] = "compute";
                break;
            case 8:
            case 12:
            case 28:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager";
                break;
            case 10:
            case 14:
                objArr[0] = "map";
                break;
            case 15:
            case 16:
            case 18:
            case 20:
            case 22:
            case 23:
            case 24:
            case 26:
                objArr[0] = "computable";
                break;
            case 17:
            case 19:
                objArr[0] = "onRecursiveCall";
                break;
            case 21:
            case 25:
                objArr[0] = "postCompute";
                break;
            case 27:
                objArr[0] = "throwable";
                break;
        }
        switch (i2) {
            case 8:
                objArr[1] = "createMemoizedFunction";
                break;
            case 12:
                objArr[1] = "createMemoizedFunctionWithNullableValues";
                break;
            case 28:
                objArr[1] = "sanitizeStackTrace";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager";
                break;
        }
        switch (i2) {
            case 2:
            case 3:
            case 4:
                objArr[2] = "<init>";
                break;
            case 5:
            case 6:
                objArr[2] = "replaceExceptionHandling";
                break;
            case 7:
            case 9:
            case 10:
                objArr[2] = "createMemoizedFunction";
                break;
            case 8:
            case 12:
            case 28:
                break;
            case 11:
            case 13:
            case 14:
                objArr[2] = "createMemoizedFunctionWithNullableValues";
                break;
            case 15:
            case 16:
            case 17:
                objArr[2] = "createLazyValue";
                break;
            case 18:
            case 19:
                objArr[2] = "createRecursionTolerantLazyValue";
                break;
            case 20:
            case 21:
                objArr[2] = "createLazyValueWithPostCompute";
                break;
            case 22:
                objArr[2] = "createNullableLazyValue";
                break;
            case 23:
                objArr[2] = "createRecursionTolerantNullableLazyValue";
                break;
            case 24:
            case 25:
                objArr[2] = "createNullableLazyValueWithPostCompute";
                break;
            case 26:
                objArr[2] = "compute";
                break;
            case 27:
                objArr[2] = "sanitizeStackTrace";
                break;
            default:
                objArr[2] = "createWithExceptionHandling";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 8:
            case 12:
            case 28:
                illegalStateException = new IllegalStateException(format);
                break;
            default:
                illegalStateException = new IllegalArgumentException(format);
                break;
        }
        AppMethodBeat.o(60550);
        throw illegalStateException;
    }

    static {
        String substring;
        AppMethodBeat.i(60549);
        String canonicalName = b.class.getCanonicalName();
        p.h(canonicalName, "$this$substringBeforeLast");
        p.h(".", "delimiter");
        p.h("", "missingDelimiterValue");
        int g2 = n.g(canonicalName, ".");
        if (g2 == -1) {
            substring = "";
        } else {
            substring = canonicalName.substring(0, g2);
            p.g(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        }
        PACKAGE_NAME = substring;
        AppMethodBeat.o(60549);
    }

    /* synthetic */ b(String str, c cVar, Lock lock, byte b2) {
        this(str, cVar, lock);
    }

    static /* synthetic */ Throwable s(Throwable th) {
        AppMethodBeat.i(60548);
        Throwable r = r(th);
        AppMethodBeat.o(60548);
        return r;
    }

    private b(String str, c cVar, Lock lock) {
        if (str == null) {
            atM(2);
        }
        if (cVar == null) {
            atM(3);
        }
        if (lock == null) {
            atM(4);
        }
        AppMethodBeat.i(60534);
        this.aIR = lock;
        this.TMO = cVar;
        this.TMP = str;
        AppMethodBeat.o(60534);
    }

    public b(String str) {
        this(str, c.TMU, new ReentrantLock());
        AppMethodBeat.i(60535);
        AppMethodBeat.o(60535);
    }

    public String toString() {
        AppMethodBeat.i(60536);
        String str = getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + " (" + this.TMP + ")";
        AppMethodBeat.o(60536);
        return str;
    }

    @Override // kotlin.l.b.a.b.l.j
    public final <K, V> c<K, V> U(kotlin.g.a.b<? super K, ? extends V> bVar) {
        AppMethodBeat.i(60537);
        j jVar = new j(this, hLq(), bVar);
        AppMethodBeat.o(60537);
        return jVar;
    }

    @Override // kotlin.l.b.a.b.l.j
    public final <K, V> d<K, V> V(kotlin.g.a.b<? super K, ? extends V> bVar) {
        AppMethodBeat.i(60538);
        i iVar = new i(this, hLq(), bVar);
        AppMethodBeat.o(60538);
        return iVar;
    }

    @Override // kotlin.l.b.a.b.l.j
    public final <T> f<T> al(kotlin.g.a.a<? extends T> aVar) {
        AppMethodBeat.i(60539);
        if (aVar == null) {
            atM(15);
        }
        g gVar = new g(this, aVar);
        AppMethodBeat.o(60539);
        return gVar;
    }

    @Override // kotlin.l.b.a.b.l.j
    public final <T> f<T> a(kotlin.g.a.a<? extends T> aVar, final T t) {
        AppMethodBeat.i(60540);
        if (t == null) {
            atM(19);
        }
        AnonymousClass2 r0 = new g<T>(this, aVar) {
            /* class kotlin.l.b.a.b.l.b.AnonymousClass2 */

            /* access modifiers changed from: protected */
            @Override // kotlin.l.b.a.b.l.b.e
            public final l<T> ES(boolean z) {
                AppMethodBeat.i(60496);
                l<T> fD = l.fD(t);
                AppMethodBeat.o(60496);
                return fD;
            }
        };
        AppMethodBeat.o(60540);
        return r0;
    }

    @Override // kotlin.l.b.a.b.l.j
    public final <T> f<T> a(kotlin.g.a.a<? extends T> aVar, final kotlin.g.a.b<? super Boolean, ? extends T> bVar, final kotlin.g.a.b<? super T, x> bVar2) {
        AppMethodBeat.i(60541);
        AnonymousClass3 r0 = new h<T>(this, aVar) {
            /* class kotlin.l.b.a.b.l.b.AnonymousClass3 */

            private static /* synthetic */ void atM(int i2) {
                String str;
                int i3;
                Throwable illegalArgumentException;
                AppMethodBeat.i(186263);
                switch (i2) {
                    case 2:
                        str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                        break;
                    default:
                        str = "@NotNull method %s.%s must not return null";
                        break;
                }
                switch (i2) {
                    case 2:
                        i3 = 3;
                        break;
                    default:
                        i3 = 2;
                        break;
                }
                Object[] objArr = new Object[i3];
                switch (i2) {
                    case 2:
                        objArr[0] = "value";
                        break;
                    default:
                        objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$4";
                        break;
                }
                switch (i2) {
                    case 2:
                        objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$4";
                        break;
                    default:
                        objArr[1] = "recursionDetected";
                        break;
                }
                switch (i2) {
                    case 2:
                        objArr[2] = "doPostCompute";
                        break;
                }
                String format = String.format(str, objArr);
                switch (i2) {
                    case 2:
                        illegalArgumentException = new IllegalArgumentException(format);
                        break;
                    default:
                        illegalArgumentException = new IllegalStateException(format);
                        break;
                }
                AppMethodBeat.o(186263);
                throw illegalArgumentException;
            }

            /* access modifiers changed from: protected */
            @Override // kotlin.l.b.a.b.l.b.e
            public final l<T> ES(boolean z) {
                AppMethodBeat.i(186261);
                if (bVar == null) {
                    l<T> ES = super.ES(z);
                    if (ES == null) {
                        atM(0);
                    }
                    AppMethodBeat.o(186261);
                    return ES;
                }
                l<T> fD = l.fD(bVar.invoke(Boolean.valueOf(z)));
                AppMethodBeat.o(186261);
                return fD;
            }

            /* access modifiers changed from: protected */
            @Override // kotlin.l.b.a.b.l.b.f
            public final void fB(T t) {
                AppMethodBeat.i(186262);
                if (t == null) {
                    atM(2);
                }
                bVar2.invoke(t);
                AppMethodBeat.o(186262);
            }
        };
        AppMethodBeat.o(60541);
        return r0;
    }

    @Override // kotlin.l.b.a.b.l.j
    public final <T> g<T> am(kotlin.g.a.a<? extends T> aVar) {
        AppMethodBeat.i(60542);
        e eVar = new e(this, aVar);
        AppMethodBeat.o(60542);
        return eVar;
    }

    @Override // kotlin.l.b.a.b.l.j
    public final <T> T an(kotlin.g.a.a<? extends T> aVar) {
        AppMethodBeat.i(60543);
        this.aIR.lock();
        try {
            T t = (T) aVar.invoke();
            this.aIR.unlock();
            AppMethodBeat.o(60543);
            return t;
        } catch (Throwable th) {
            this.aIR.unlock();
            AppMethodBeat.o(60543);
            throw th;
        }
    }

    private static <K> ConcurrentMap<K, Object> hLq() {
        AppMethodBeat.i(60544);
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(3, 1.0f, 2);
        AppMethodBeat.o(60544);
        return concurrentHashMap;
    }

    /* access modifiers changed from: protected */
    public <T> l<T> hLr() {
        AppMethodBeat.i(60545);
        IllegalStateException illegalStateException = (IllegalStateException) r(new IllegalStateException("Recursive call in a lazy value under ".concat(String.valueOf(this))));
        AppMethodBeat.o(60545);
        throw illegalStateException;
    }

    /* access modifiers changed from: package-private */
    public static class l<T> {
        static final /* synthetic */ boolean $assertionsDisabled = (!b.class.desiredAssertionStatus());
        final boolean TNf;
        private final T value;

        static {
            AppMethodBeat.i(60533);
            AppMethodBeat.o(60533);
        }

        public static <T> l<T> fD(T t) {
            AppMethodBeat.i(60529);
            l<T> lVar = new l<>(t, false);
            AppMethodBeat.o(60529);
            return lVar;
        }

        public static <T> l<T> hLu() {
            AppMethodBeat.i(60530);
            l<T> lVar = new l<>(null, true);
            AppMethodBeat.o(60530);
            return lVar;
        }

        private l(T t, boolean z) {
            this.value = t;
            this.TNf = z;
        }

        public final T getValue() {
            AppMethodBeat.i(60531);
            if ($assertionsDisabled || !this.TNf) {
                T t = this.value;
                AppMethodBeat.o(60531);
                return t;
            }
            AssertionError assertionError = new AssertionError("A value requested from FALL_THROUGH in ".concat(String.valueOf(this)));
            AppMethodBeat.o(60531);
            throw assertionError;
        }

        public final String toString() {
            AppMethodBeat.i(60532);
            if (this.TNf) {
                AppMethodBeat.o(60532);
                return "FALL_THROUGH";
            }
            String valueOf = String.valueOf(this.value);
            AppMethodBeat.o(60532);
            return valueOf;
        }
    }

    /* access modifiers changed from: package-private */
    public enum k {
        NOT_COMPUTED,
        COMPUTING,
        RECURSION_WAS_DETECTED;

        public static k valueOf(String str) {
            AppMethodBeat.i(60527);
            k kVar = (k) Enum.valueOf(k.class, str);
            AppMethodBeat.o(60527);
            return kVar;
        }

        static {
            AppMethodBeat.i(60528);
            AppMethodBeat.o(60528);
        }
    }

    /* access modifiers changed from: package-private */
    public static class e<T> implements g<T> {
        private final b TMW;
        private final kotlin.g.a.a<? extends T> TMX;
        private volatile Object value;

        private static /* synthetic */ void atM(int i2) {
            String str;
            int i3;
            Throwable illegalStateException;
            AppMethodBeat.i(60513);
            switch (i2) {
                case 2:
                case 3:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
            switch (i2) {
                case 2:
                case 3:
                    i3 = 2;
                    break;
                default:
                    i3 = 3;
                    break;
            }
            Object[] objArr = new Object[i3];
            switch (i2) {
                case 1:
                    objArr[0] = "computable";
                    break;
                case 2:
                case 3:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue";
                    break;
                default:
                    objArr[0] = "storageManager";
                    break;
            }
            switch (i2) {
                case 2:
                    objArr[1] = "recursionDetected";
                    break;
                case 3:
                    objArr[1] = "renderDebugInformation";
                    break;
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue";
                    break;
            }
            switch (i2) {
                case 2:
                case 3:
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String format = String.format(str, objArr);
            switch (i2) {
                case 2:
                case 3:
                    illegalStateException = new IllegalStateException(format);
                    break;
                default:
                    illegalStateException = new IllegalArgumentException(format);
                    break;
            }
            AppMethodBeat.o(60513);
            throw illegalStateException;
        }

        public e(b bVar, kotlin.g.a.a<? extends T> aVar) {
            if (bVar == null) {
                atM(0);
            }
            if (aVar == null) {
                atM(1);
            }
            AppMethodBeat.i(60510);
            this.value = k.NOT_COMPUTED;
            this.TMW = bVar;
            this.TMX = aVar;
            AppMethodBeat.o(60510);
        }

        public final boolean hLt() {
            return (this.value == k.NOT_COMPUTED || this.value == k.COMPUTING) ? false : true;
        }

        @Override // kotlin.g.a.a
        public T invoke() {
            AppMethodBeat.i(60511);
            Object obj = this.value;
            if (!(obj instanceof k)) {
                T t = (T) kotlin.l.b.a.b.o.j.fJ(obj);
                AppMethodBeat.o(60511);
                return t;
            }
            this.TMW.aIR.lock();
            try {
                Object obj2 = this.value;
                if (!(obj2 instanceof k)) {
                    return (T) kotlin.l.b.a.b.o.j.fJ(obj2);
                }
                if (obj2 == k.COMPUTING) {
                    this.value = k.RECURSION_WAS_DETECTED;
                    l<T> ES = ES(true);
                    if (!ES.TNf) {
                        T value2 = ES.getValue();
                        this.TMW.aIR.unlock();
                        AppMethodBeat.o(60511);
                        return value2;
                    }
                }
                if (obj2 == k.RECURSION_WAS_DETECTED) {
                    l<T> ES2 = ES(false);
                    if (!ES2.TNf) {
                        T value3 = ES2.getValue();
                        this.TMW.aIR.unlock();
                        AppMethodBeat.o(60511);
                        return value3;
                    }
                }
                this.value = k.COMPUTING;
                try {
                    T t2 = (T) this.TMX.invoke();
                    fC(t2);
                    this.value = t2;
                    this.TMW.aIR.unlock();
                    AppMethodBeat.o(60511);
                    return t2;
                } catch (Throwable th) {
                    if (kotlin.l.b.a.b.o.c.u(th)) {
                        this.value = k.NOT_COMPUTED;
                        RuntimeException runtimeException = (RuntimeException) th;
                        AppMethodBeat.o(60511);
                        throw runtimeException;
                    }
                    if (this.value == k.COMPUTING) {
                        this.value = kotlin.l.b.a.b.o.j.v(th);
                    }
                    RuntimeException t3 = this.TMW.TMO.t(th);
                    AppMethodBeat.o(60511);
                    throw t3;
                }
            } finally {
                this.TMW.aIR.unlock();
                AppMethodBeat.o(60511);
            }
        }

        /* access modifiers changed from: protected */
        public l<T> ES(boolean z) {
            AppMethodBeat.i(60512);
            l<T> hLr = this.TMW.hLr();
            if (hLr == null) {
                atM(2);
            }
            AppMethodBeat.o(60512);
            return hLr;
        }

        /* access modifiers changed from: protected */
        public void fC(T t) {
        }
    }

    static abstract class f<T> extends e<T> {
        private volatile h<T> TMY;

        private static /* synthetic */ void atM(int i2) {
            Object[] objArr = new Object[3];
            switch (i2) {
                case 1:
                    objArr[0] = "computable";
                    break;
                default:
                    objArr[0] = "storageManager";
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValueWithPostCompute";
            objArr[2] = "<init>";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        /* access modifiers changed from: protected */
        public abstract void fB(T t);

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(b bVar, kotlin.g.a.a<? extends T> aVar) {
            super(bVar, aVar);
            if (bVar == null) {
                atM(0);
            }
            if (aVar == null) {
                atM(1);
            }
            this.TMY = null;
        }

        @Override // kotlin.l.b.a.b.l.b.e, kotlin.g.a.a
        public T invoke() {
            h<T> hVar = this.TMY;
            if (hVar == null || !hVar.hasValue()) {
                return (T) super.invoke();
            }
            if (hVar.hasValue()) {
                return hVar.value;
            }
            throw new IllegalStateException("No value in this thread (hasValue should be checked before)");
        }

        /* access modifiers changed from: protected */
        @Override // kotlin.l.b.a.b.l.b.e
        public final void fC(T t) {
            this.TMY = new h<>(t);
            try {
                fB(t);
            } finally {
                this.TMY = null;
            }
        }
    }

    static abstract class h<T> extends f<T> implements f<T> {
        static final /* synthetic */ boolean $assertionsDisabled = (!b.class.desiredAssertionStatus());

        private static /* synthetic */ void atM(int i2) {
            String str;
            int i3;
            switch (i2) {
                case 2:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
            switch (i2) {
                case 2:
                    i3 = 2;
                    break;
                default:
                    i3 = 3;
                    break;
            }
            Object[] objArr = new Object[i3];
            switch (i2) {
                case 1:
                    objArr[0] = "computable";
                    break;
                case 2:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValueWithPostCompute";
                    break;
                default:
                    objArr[0] = "storageManager";
                    break;
            }
            switch (i2) {
                case 2:
                    objArr[1] = "invoke";
                    break;
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValueWithPostCompute";
                    break;
            }
            switch (i2) {
                case 2:
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String format = String.format(str, objArr);
            switch (i2) {
                case 2:
                    throw new IllegalStateException(format);
                default:
                    throw new IllegalArgumentException(format);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(b bVar, kotlin.g.a.a<? extends T> aVar) {
            super(bVar, aVar);
            if (bVar == null) {
                atM(0);
            }
            if (aVar == null) {
                atM(1);
            }
        }

        @Override // kotlin.l.b.a.b.l.b.f, kotlin.l.b.a.b.l.b.e, kotlin.g.a.a
        public T invoke() {
            T t = (T) super.invoke();
            if ($assertionsDisabled || t != null) {
                if (t == null) {
                    atM(2);
                }
                return t;
            }
            throw new AssertionError("compute() returned null");
        }
    }

    static class g<T> extends e<T> implements f<T> {
        static final /* synthetic */ boolean $assertionsDisabled = (!b.class.desiredAssertionStatus());

        private static /* synthetic */ void atM(int i2) {
            String str;
            int i3;
            Throwable illegalStateException;
            AppMethodBeat.i(60517);
            switch (i2) {
                case 2:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
            switch (i2) {
                case 2:
                    i3 = 2;
                    break;
                default:
                    i3 = 3;
                    break;
            }
            Object[] objArr = new Object[i3];
            switch (i2) {
                case 1:
                    objArr[0] = "computable";
                    break;
                case 2:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValue";
                    break;
                default:
                    objArr[0] = "storageManager";
                    break;
            }
            switch (i2) {
                case 2:
                    objArr[1] = "invoke";
                    break;
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValue";
                    break;
            }
            switch (i2) {
                case 2:
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String format = String.format(str, objArr);
            switch (i2) {
                case 2:
                    illegalStateException = new IllegalStateException(format);
                    break;
                default:
                    illegalStateException = new IllegalArgumentException(format);
                    break;
            }
            AppMethodBeat.o(60517);
            throw illegalStateException;
        }

        static {
            AppMethodBeat.i(60516);
            AppMethodBeat.o(60516);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(b bVar, kotlin.g.a.a<? extends T> aVar) {
            super(bVar, aVar);
            if (bVar == null) {
                atM(0);
            }
            if (aVar == null) {
                atM(1);
            }
            AppMethodBeat.i(60514);
            AppMethodBeat.o(60514);
        }

        @Override // kotlin.l.b.a.b.l.b.e, kotlin.g.a.a
        public T invoke() {
            AppMethodBeat.i(60515);
            T t = (T) super.invoke();
            if ($assertionsDisabled || t != null) {
                if (t == null) {
                    atM(2);
                }
                AppMethodBeat.o(60515);
                return t;
            }
            AssertionError assertionError = new AssertionError("compute() returned null");
            AppMethodBeat.o(60515);
            throw assertionError;
        }
    }

    static class i<K, V> implements d<K, V> {
        final b TMW;
        private final ConcurrentMap<K, Object> TMZ;
        private final kotlin.g.a.b<? super K, ? extends V> TNa;

        private static /* synthetic */ void atM(int i2) {
            String str;
            int i3;
            Throwable illegalStateException;
            AppMethodBeat.i(60521);
            switch (i2) {
                case 3:
                case 4:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
            switch (i2) {
                case 3:
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
                    objArr[0] = "map";
                    break;
                case 2:
                    objArr[0] = "compute";
                    break;
                case 3:
                case 4:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction";
                    break;
                default:
                    objArr[0] = "storageManager";
                    break;
            }
            switch (i2) {
                case 3:
                    objArr[1] = "recursionDetected";
                    break;
                case 4:
                    objArr[1] = "raceCondition";
                    break;
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction";
                    break;
            }
            switch (i2) {
                case 3:
                case 4:
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String format = String.format(str, objArr);
            switch (i2) {
                case 3:
                case 4:
                    illegalStateException = new IllegalStateException(format);
                    break;
                default:
                    illegalStateException = new IllegalArgumentException(format);
                    break;
            }
            AppMethodBeat.o(60521);
            throw illegalStateException;
        }

        public i(b bVar, ConcurrentMap<K, Object> concurrentMap, kotlin.g.a.b<? super K, ? extends V> bVar2) {
            if (bVar == null) {
                atM(0);
            }
            if (concurrentMap == null) {
                atM(1);
            }
            if (bVar2 == null) {
                atM(2);
            }
            AppMethodBeat.i(60518);
            this.TMW = bVar;
            this.TMZ = concurrentMap;
            this.TNa = bVar2;
            AppMethodBeat.o(60518);
        }

        @Override // kotlin.g.a.b
        public V invoke(K k) {
            AppMethodBeat.i(60519);
            Object obj = this.TMZ.get(k);
            if (obj == null || obj == k.COMPUTING) {
                this.TMW.aIR.lock();
                try {
                    Object obj2 = this.TMZ.get(k);
                    if (obj2 == k.COMPUTING) {
                        AssertionError assertionError = (AssertionError) b.s(new AssertionError("Recursion detected on input: " + ((Object) k) + " under " + this.TMW));
                        if (assertionError == null) {
                            atM(3);
                        }
                        AppMethodBeat.o(60519);
                        throw assertionError;
                    } else if (obj2 != null) {
                        return (V) kotlin.l.b.a.b.o.j.fI(obj2);
                    } else {
                        try {
                            this.TMZ.put(k, k.COMPUTING);
                            V v = (V) this.TNa.invoke(k);
                            Object put = this.TMZ.put(k, kotlin.l.b.a.b.o.j.fH(v));
                            if (put != k.COMPUTING) {
                                AssertionError W = W(k, put);
                                AppMethodBeat.o(60519);
                                throw W;
                            }
                            this.TMW.aIR.unlock();
                            AppMethodBeat.o(60519);
                            return v;
                        } catch (Throwable th) {
                            if (kotlin.l.b.a.b.o.c.u(th)) {
                                this.TMZ.remove(k);
                                RuntimeException runtimeException = (RuntimeException) th;
                                AppMethodBeat.o(60519);
                                throw runtimeException;
                            } else if (th == null) {
                                RuntimeException t = this.TMW.TMO.t(th);
                                AppMethodBeat.o(60519);
                                throw t;
                            } else {
                                Object put2 = this.TMZ.put(k, kotlin.l.b.a.b.o.j.v(th));
                                if (put2 != k.COMPUTING) {
                                    AssertionError W2 = W(k, put2);
                                    AppMethodBeat.o(60519);
                                    throw W2;
                                }
                                RuntimeException t2 = this.TMW.TMO.t(th);
                                AppMethodBeat.o(60519);
                                throw t2;
                            }
                        }
                    }
                } finally {
                    this.TMW.aIR.unlock();
                    AppMethodBeat.o(60519);
                }
            } else {
                V v2 = (V) kotlin.l.b.a.b.o.j.fI(obj);
                AppMethodBeat.o(60519);
                return v2;
            }
        }

        private AssertionError W(K k, Object obj) {
            AppMethodBeat.i(60520);
            AssertionError assertionError = (AssertionError) b.s(new AssertionError("Race condition detected on input " + ((Object) k) + ". Old value is " + obj + " under " + this.TMW));
            if (assertionError == null) {
                atM(4);
            }
            AppMethodBeat.o(60520);
            return assertionError;
        }
    }

    static class j<K, V> extends i<K, V> implements c<K, V> {
        static final /* synthetic */ boolean $assertionsDisabled = (!b.class.desiredAssertionStatus());

        private static /* synthetic */ void atM(int i2) {
            String str;
            int i3;
            Throwable illegalStateException;
            AppMethodBeat.i(60525);
            switch (i2) {
                case 3:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
            switch (i2) {
                case 3:
                    i3 = 2;
                    break;
                default:
                    i3 = 3;
                    break;
            }
            Object[] objArr = new Object[i3];
            switch (i2) {
                case 1:
                    objArr[0] = "map";
                    break;
                case 2:
                    objArr[0] = "compute";
                    break;
                case 3:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull";
                    break;
                default:
                    objArr[0] = "storageManager";
                    break;
            }
            switch (i2) {
                case 3:
                    objArr[1] = "invoke";
                    break;
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull";
                    break;
            }
            switch (i2) {
                case 3:
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String format = String.format(str, objArr);
            switch (i2) {
                case 3:
                    illegalStateException = new IllegalStateException(format);
                    break;
                default:
                    illegalStateException = new IllegalArgumentException(format);
                    break;
            }
            AppMethodBeat.o(60525);
            throw illegalStateException;
        }

        static {
            AppMethodBeat.i(60524);
            AppMethodBeat.o(60524);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(b bVar, ConcurrentMap<K, Object> concurrentMap, kotlin.g.a.b<? super K, ? extends V> bVar2) {
            super(bVar, concurrentMap, bVar2);
            if (concurrentMap == null) {
                atM(1);
            }
            if (bVar2 == null) {
                atM(2);
            }
            AppMethodBeat.i(60522);
            AppMethodBeat.o(60522);
        }

        @Override // kotlin.g.a.b, kotlin.l.b.a.b.l.b.i
        public final V invoke(K k) {
            AppMethodBeat.i(60523);
            V v = (V) super.invoke(k);
            if ($assertionsDisabled || v != null) {
                if (v == null) {
                    atM(3);
                }
                AppMethodBeat.o(60523);
                return v;
            }
            AssertionError assertionError = new AssertionError("compute() returned null under " + this.TMW);
            AppMethodBeat.o(60523);
            throw assertionError;
        }
    }

    private static <T extends Throwable> T r(T t) {
        AppMethodBeat.i(60546);
        if (t == null) {
            atM(27);
        }
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                i2 = -1;
                break;
            } else if (!stackTrace[i2].getClassName().startsWith(PACKAGE_NAME)) {
                break;
            } else {
                i2++;
            }
        }
        if ($assertionsDisabled || i2 >= 0) {
            List subList = Arrays.asList(stackTrace).subList(i2, length);
            t.setStackTrace((StackTraceElement[]) subList.toArray(new StackTraceElement[subList.size()]));
            if (t == null) {
                atM(28);
            }
            AppMethodBeat.o(60546);
            return t;
        }
        AssertionError assertionError = new AssertionError("This method should only be called on exceptions created in LockBasedStorageManager");
        AppMethodBeat.o(60546);
        throw assertionError;
    }

    /* renamed from: kotlin.l.b.a.b.l.b$b  reason: collision with other inner class name */
    static class C2357b<K, V> extends i<d<K, V>, V> {
        private static /* synthetic */ void atM(int i2) {
            AppMethodBeat.i(60506);
            Object[] objArr = new Object[3];
            switch (i2) {
                case 1:
                    objArr[0] = "map";
                    break;
                case 2:
                    objArr[0] = "computation";
                    break;
                default:
                    objArr[0] = "storageManager";
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNullableValuesBasedOnMemoizedFunction";
            switch (i2) {
                case 2:
                    objArr[2] = "computeIfAbsent";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
            AppMethodBeat.o(60506);
            throw illegalArgumentException;
        }

        /* synthetic */ C2357b(b bVar, ConcurrentMap concurrentMap, byte b2) {
            this(bVar, concurrentMap);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        private C2357b(b bVar, ConcurrentMap<d<K, V>, Object> concurrentMap) {
            super(bVar, concurrentMap, new kotlin.g.a.b<d<K, V>, V>() {
                /* class kotlin.l.b.a.b.l.b.C2357b.AnonymousClass1 */

                @Override // kotlin.g.a.b
                public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    AppMethodBeat.i(60503);
                    Object invoke = ((d) obj).TMV.invoke();
                    AppMethodBeat.o(60503);
                    return invoke;
                }
            });
            if (bVar == null) {
                atM(0);
            }
            if (concurrentMap == null) {
                atM(1);
            }
            AppMethodBeat.i(60504);
            AppMethodBeat.o(60504);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.l.b.a.b.l.b$b<K, V> */
        /* JADX WARN: Multi-variable type inference failed */
        public V b(K k, kotlin.g.a.a<? extends V> aVar) {
            AppMethodBeat.i(60505);
            if (aVar == null) {
                atM(2);
            }
            V v = (V) invoke(new d(k, aVar));
            AppMethodBeat.o(60505);
            return v;
        }
    }

    @Override // kotlin.l.b.a.b.l.j
    public final <K, V> a<K, V> hLs() {
        AppMethodBeat.i(60547);
        a aVar = new a(this, hLq(), (byte) 0);
        AppMethodBeat.o(60547);
        return aVar;
    }

    static class a<K, V> extends C2357b<K, V> implements a<K, V> {
        static final /* synthetic */ boolean $assertionsDisabled = (!b.class.desiredAssertionStatus());

        private static /* synthetic */ void atM(int i2) {
            String str;
            int i3;
            Throwable illegalStateException;
            AppMethodBeat.i(60502);
            switch (i2) {
                case 3:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
            switch (i2) {
                case 3:
                    i3 = 2;
                    break;
                default:
                    i3 = 3;
                    break;
            }
            Object[] objArr = new Object[i3];
            switch (i2) {
                case 1:
                    objArr[0] = "map";
                    break;
                case 2:
                    objArr[0] = "computation";
                    break;
                case 3:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction";
                    break;
                default:
                    objArr[0] = "storageManager";
                    break;
            }
            switch (i2) {
                case 3:
                    objArr[1] = "computeIfAbsent";
                    break;
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction";
                    break;
            }
            switch (i2) {
                case 2:
                    objArr[2] = "computeIfAbsent";
                    break;
                case 3:
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String format = String.format(str, objArr);
            switch (i2) {
                case 3:
                    illegalStateException = new IllegalStateException(format);
                    break;
                default:
                    illegalStateException = new IllegalArgumentException(format);
                    break;
            }
            AppMethodBeat.o(60502);
            throw illegalStateException;
        }

        static {
            AppMethodBeat.i(60501);
            AppMethodBeat.o(60501);
        }

        /* synthetic */ a(b bVar, ConcurrentMap concurrentMap, byte b2) {
            this(bVar, concurrentMap);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        private a(b bVar, ConcurrentMap<d<K, V>, Object> concurrentMap) {
            super(bVar, concurrentMap, (byte) 0);
            if (bVar == null) {
                atM(0);
            }
            if (concurrentMap == null) {
                atM(1);
            }
            AppMethodBeat.i(60499);
            AppMethodBeat.o(60499);
        }

        @Override // kotlin.l.b.a.b.l.b.C2357b, kotlin.l.b.a.b.l.a
        public final V b(K k, kotlin.g.a.a<? extends V> aVar) {
            AppMethodBeat.i(60500);
            if (aVar == null) {
                atM(2);
            }
            V v = (V) super.b(k, aVar);
            if ($assertionsDisabled || v != null) {
                if (v == null) {
                    atM(3);
                }
                AppMethodBeat.o(60500);
                return v;
            }
            AssertionError assertionError = new AssertionError("computeIfAbsent() returned null under " + this.TMW);
            AppMethodBeat.o(60500);
            throw assertionError;
        }
    }

    /* access modifiers changed from: package-private */
    public static class d<K, V> {
        final kotlin.g.a.a<? extends V> TMV;
        private final K key;

        public d(K k, kotlin.g.a.a<? extends V> aVar) {
            this.key = k;
            this.TMV = aVar;
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(60508);
            if (this == obj) {
                AppMethodBeat.o(60508);
                return true;
            } else if (obj == null || getClass() != obj.getClass()) {
                AppMethodBeat.o(60508);
                return false;
            } else if (!this.key.equals(((d) obj).key)) {
                AppMethodBeat.o(60508);
                return false;
            } else {
                AppMethodBeat.o(60508);
                return true;
            }
        }

        public final int hashCode() {
            AppMethodBeat.i(60509);
            int hashCode = this.key.hashCode();
            AppMethodBeat.o(60509);
            return hashCode;
        }
    }
}
