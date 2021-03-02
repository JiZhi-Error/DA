package kotlin;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import kotlin.g.b.j;
import kotlin.g.b.p;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b@\u0018\u0000 \u001e*\u0006\b\u0000\u0010\u0001 \u00012\u00060\u0002j\u0002`\u0003:\u0002\u001e\u001fB\u0016\b\u0001\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u0010\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÖ\u0003J\u000f\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0016\u001a\u0004\u0018\u00018\u0000H\b¢\u0006\u0004\b\u0017\u0010\u0007J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u000f\u0010\u001a\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0000X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000e\u0010\u000fø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, hxF = {"Lkotlin/Result;", "T", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "value", "", "constructor-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "isFailure", "", "isFailure-impl", "(Ljava/lang/Object;)Z", "isSuccess", "isSuccess-impl", "value$annotations", "()V", "equals", FacebookRequestErrorClassification.KEY_OTHER, "exceptionOrNull", "", "exceptionOrNull-impl", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "getOrNull", "getOrNull-impl", "hashCode", "", "toString", "", "toString-impl", "(Ljava/lang/Object;)Ljava/lang/String;", "Companion", "Failure", "kotlin-stdlib"})
public final class Result<T> implements Serializable {
    public static final Companion Companion = new Companion(null);
    private final Object value;

    static {
        AppMethodBeat.i(128987);
        AppMethodBeat.o(128987);
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Result m45boximpl(Object obj) {
        AppMethodBeat.i(206227);
        Result result = new Result(obj);
        AppMethodBeat.o(206227);
        return result;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m47equalsimpl(Object obj, Object obj2) {
        AppMethodBeat.i(206229);
        if (!(obj2 instanceof Result) || !p.j(obj, ((Result) obj2).m55unboximpl())) {
            AppMethodBeat.o(206229);
            return false;
        }
        AppMethodBeat.o(206229);
        return true;
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m48equalsimpl0(Object obj, Object obj2) {
        AppMethodBeat.i(206230);
        if (p.j(obj, obj2)) {
            AppMethodBeat.o(206230);
            return true;
        }
        AppMethodBeat.o(206230);
        return false;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m51hashCodeimpl(Object obj) {
        AppMethodBeat.i(206228);
        if (obj != null) {
            int hashCode = obj.hashCode();
            AppMethodBeat.o(206228);
            return hashCode;
        }
        AppMethodBeat.o(206228);
        return 0;
    }

    public static /* synthetic */ void value$annotations() {
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(128989);
        boolean r0 = m47equalsimpl(this.value, obj);
        AppMethodBeat.o(128989);
        return r0;
    }

    public final int hashCode() {
        AppMethodBeat.i(128988);
        int r0 = m51hashCodeimpl(this.value);
        AppMethodBeat.o(128988);
        return r0;
    }

    public final String toString() {
        AppMethodBeat.i(128986);
        String r0 = m54toStringimpl(this.value);
        AppMethodBeat.o(128986);
        return r0;
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ Object m55unboximpl() {
        return this.value;
    }

    private /* synthetic */ Result(Object obj) {
        this.value = obj;
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static Object m46constructorimpl(Object obj) {
        return obj;
    }

    /* renamed from: isSuccess-impl  reason: not valid java name */
    public static final boolean m53isSuccessimpl(Object obj) {
        return !(obj instanceof Failure);
    }

    /* renamed from: isFailure-impl  reason: not valid java name */
    public static final boolean m52isFailureimpl(Object obj) {
        return obj instanceof Failure;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getOrNull-impl  reason: not valid java name */
    private static final T m50getOrNullimpl(Object obj) {
        AppMethodBeat.i(206225);
        if (m52isFailureimpl(obj)) {
            AppMethodBeat.o(206225);
            return null;
        }
        AppMethodBeat.o(206225);
        return obj;
    }

    /* renamed from: exceptionOrNull-impl  reason: not valid java name */
    public static final Throwable m49exceptionOrNullimpl(Object obj) {
        if (obj instanceof Failure) {
            return ((Failure) obj).exception;
        }
        return null;
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m54toStringimpl(Object obj) {
        AppMethodBeat.i(206226);
        if (obj instanceof Failure) {
            String obj2 = obj.toString();
            AppMethodBeat.o(206226);
            return obj2;
        }
        String str = "Success(" + obj + ')';
        AppMethodBeat.o(206226);
        return str;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0001\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\bø\u0001\u0000¢\u0006\u0002\u0010\bJ%\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0001\u0010\u00052\u0006\u0010\n\u001a\u0002H\u0005H\bø\u0001\u0000¢\u0006\u0002\u0010\u000b\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, hxF = {"Lkotlin/Result$Companion;", "", "()V", "failure", "Lkotlin/Result;", "T", "exception", "", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "success", "value", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }

        private final <T> Object success(T t) {
            AppMethodBeat.i(206285);
            Object r0 = Result.m46constructorimpl(t);
            AppMethodBeat.o(206285);
            return r0;
        }

        private final <T> Object failure(Throwable th) {
            AppMethodBeat.i(206286);
            Object r0 = Result.m46constructorimpl(ResultKt.createFailure(th));
            AppMethodBeat.o(206286);
            return r0;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, hxF = {"Lkotlin/Result$Failure;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "exception", "", "(Ljava/lang/Throwable;)V", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "", "hashCode", "", "toString", "", "kotlin-stdlib"})
    public static final class Failure implements Serializable {
        public final Throwable exception;

        public Failure(Throwable th) {
            p.h(th, "exception");
            AppMethodBeat.i(129288);
            this.exception = th;
            AppMethodBeat.o(129288);
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(129285);
            if (!(obj instanceof Failure) || !p.j(this.exception, ((Failure) obj).exception)) {
                AppMethodBeat.o(129285);
                return false;
            }
            AppMethodBeat.o(129285);
            return true;
        }

        public final int hashCode() {
            AppMethodBeat.i(129286);
            int hashCode = this.exception.hashCode();
            AppMethodBeat.o(129286);
            return hashCode;
        }

        public final String toString() {
            AppMethodBeat.i(129287);
            String str = "Failure(" + this.exception + ')';
            AppMethodBeat.o(129287);
            return str;
        }
    }
}
