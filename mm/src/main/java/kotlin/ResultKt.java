package kotlin;

import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Result;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.p;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001\u001a+\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0000\u0010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00060\bH\bø\u0001\u0000¢\u0006\u0002\u0010\t\u001a\u0001\u0010\n\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u0006\"\u0004\b\u0001\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\u00052!\u0010\f\u001a\u001d\u0012\u0013\u0012\u0011H\u000b¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u0002H\u00060\r2!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u0002H\u00060\rH\bø\u0001\u0000\u0002\u0014\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0000¢\u0006\u0002\u0010\u0012\u001a3\u0010\u0013\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u0006\"\b\b\u0001\u0010\u000b*\u0002H\u0006*\b\u0012\u0004\u0012\u0002H\u000b0\u00052\u0006\u0010\u0014\u001a\u0002H\u0006H\bø\u0001\u0000¢\u0006\u0002\u0010\u0015\u001a[\u0010\u0016\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u0006\"\b\b\u0001\u0010\u000b*\u0002H\u0006*\b\u0012\u0004\u0012\u0002H\u000b0\u00052!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u0002H\u00060\rH\bø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010\u0017\u001a!\u0010\u0018\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\u0005H\bø\u0001\u0000¢\u0006\u0002\u0010\u0019\u001a]\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0000\u0010\u0006\"\u0004\b\u0001\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\u00052!\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u0011H\u000b¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u0002H\u00060\rH\bø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010\u0017\u001aP\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0000\u0010\u0006\"\u0004\b\u0001\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\u00052!\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u0011H\u000b¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u0002H\u00060\rH\bø\u0001\u0000¢\u0006\u0002\u0010\u0017\u001aW\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0005\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\u00052!\u0010\u001d\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\u001e0\rH\bø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010\u0017\u001aW\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0005\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\u00052!\u0010\u001d\u001a\u001d\u0012\u0013\u0012\u0011H\u000b¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u001e0\rH\bø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010\u0017\u001aa\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0000\u0010\u0006\"\b\b\u0001\u0010\u000b*\u0002H\u0006*\b\u0012\u0004\u0012\u0002H\u000b0\u00052!\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u0002H\u00060\rH\bø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010\u0017\u001aT\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0000\u0010\u0006\"\b\b\u0001\u0010\u000b*\u0002H\u0006*\b\u0012\u0004\u0012\u0002H\u000b0\u00052!\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u0002H\u00060\rH\bø\u0001\u0000¢\u0006\u0002\u0010\u0017\u001a@\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\u0006*\u0002H\u000b2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u0002H\u00060\r¢\u0006\u0002\b!H\bø\u0001\u0000¢\u0006\u0002\u0010\u0017\u001a\u0018\u0010\"\u001a\u00020\u001e*\u0006\u0012\u0002\b\u00030\u0005H\u0001ø\u0001\u0000¢\u0006\u0002\u0010#\u0002\u0004\n\u0002\b\u0019¨\u0006$"}, hxF = {"createFailure", "", "exception", "", "runCatching", "Lkotlin/Result;", "R", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "fold", "T", "onSuccess", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "value", "onFailure", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "getOrDefault", "defaultValue", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "getOrElse", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "getOrThrow", "(Ljava/lang/Object;)Ljava/lang/Object;", "map", "transform", "mapCatching", NativeProtocol.WEB_DIALOG_ACTION, "", "recover", "recoverCatching", "Lkotlin/ExtensionFunctionType;", "throwOnFailure", "(Ljava/lang/Object;)V", "kotlin-stdlib"})
public final class ResultKt {
    public static final Object createFailure(Throwable th) {
        AppMethodBeat.i(129575);
        p.h(th, "exception");
        Result.Failure failure = new Result.Failure(th);
        AppMethodBeat.o(129575);
        return failure;
    }

    public static final void throwOnFailure(Object obj) {
        if (obj instanceof Result.Failure) {
            throw ((Result.Failure) obj).exception;
        }
    }

    private static final <R> Object runCatching(a<? extends R> aVar) {
        Object r0;
        AppMethodBeat.i(206193);
        try {
            Result.Companion companion = Result.Companion;
            r0 = Result.m46constructorimpl(aVar.invoke());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            r0 = Result.m46constructorimpl(createFailure(th));
        }
        AppMethodBeat.o(206193);
        return r0;
    }

    private static final <T, R> Object runCatching(T t, b<? super T, ? extends R> bVar) {
        Object r0;
        AppMethodBeat.i(206194);
        try {
            Result.Companion companion = Result.Companion;
            r0 = Result.m46constructorimpl(bVar.invoke(t));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            r0 = Result.m46constructorimpl(createFailure(th));
        }
        AppMethodBeat.o(206194);
        return r0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> T getOrThrow(Object obj) {
        AppMethodBeat.i(206195);
        throwOnFailure(obj);
        AppMethodBeat.o(206195);
        return obj;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    private static final <R, T extends R> R getOrElse(Object obj, b<? super Throwable, ? extends R> bVar) {
        AppMethodBeat.i(206196);
        Throwable r0 = Result.m49exceptionOrNullimpl(obj);
        if (r0 == null) {
            AppMethodBeat.o(206196);
            return obj;
        }
        R r = (R) bVar.invoke(r0);
        AppMethodBeat.o(206196);
        return r;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    private static final <R, T extends R> R getOrDefault(Object obj, R r) {
        AppMethodBeat.i(206197);
        if (Result.m52isFailureimpl(obj)) {
            AppMethodBeat.o(206197);
            return r;
        }
        AppMethodBeat.o(206197);
        return obj;
    }

    private static final <R, T> R fold(Object obj, b<? super T, ? extends R> bVar, b<? super Throwable, ? extends R> bVar2) {
        AppMethodBeat.i(206198);
        Throwable r0 = Result.m49exceptionOrNullimpl(obj);
        if (r0 == null) {
            R r = (R) bVar.invoke(obj);
            AppMethodBeat.o(206198);
            return r;
        }
        R r2 = (R) bVar2.invoke(r0);
        AppMethodBeat.o(206198);
        return r2;
    }

    private static final <R, T> Object map(Object obj, b<? super T, ? extends R> bVar) {
        AppMethodBeat.i(206199);
        if (Result.m53isSuccessimpl(obj)) {
            Result.Companion companion = Result.Companion;
            Object r0 = Result.m46constructorimpl(bVar.invoke(obj));
            AppMethodBeat.o(206199);
            return r0;
        }
        Object r02 = Result.m46constructorimpl(obj);
        AppMethodBeat.o(206199);
        return r02;
    }

    private static final <R, T> Object mapCatching(Object obj, b<? super T, ? extends R> bVar) {
        Object r0;
        AppMethodBeat.i(206200);
        if (Result.m53isSuccessimpl(obj)) {
            try {
                Result.Companion companion = Result.Companion;
                r0 = Result.m46constructorimpl(bVar.invoke(obj));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                r0 = Result.m46constructorimpl(createFailure(th));
            }
            AppMethodBeat.o(206200);
            return r0;
        }
        Object r02 = Result.m46constructorimpl(obj);
        AppMethodBeat.o(206200);
        return r02;
    }

    private static final <R, T extends R> Object recover(Object obj, b<? super Throwable, ? extends R> bVar) {
        AppMethodBeat.i(206201);
        Throwable r0 = Result.m49exceptionOrNullimpl(obj);
        if (r0 == null) {
            AppMethodBeat.o(206201);
            return obj;
        }
        Result.Companion companion = Result.Companion;
        Object r3 = Result.m46constructorimpl(bVar.invoke(r0));
        AppMethodBeat.o(206201);
        return r3;
    }

    private static final <R, T extends R> Object recoverCatching(Object obj, b<? super Throwable, ? extends R> bVar) {
        Object r0;
        AppMethodBeat.i(206202);
        Throwable r02 = Result.m49exceptionOrNullimpl(obj);
        if (r02 == null) {
            AppMethodBeat.o(206202);
            return obj;
        }
        try {
            Result.Companion companion = Result.Companion;
            r0 = Result.m46constructorimpl(bVar.invoke(r02));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            r0 = Result.m46constructorimpl(createFailure(th));
        }
        AppMethodBeat.o(206202);
        return r0;
    }

    private static final <T> Object onFailure(Object obj, b<? super Throwable, x> bVar) {
        AppMethodBeat.i(206203);
        Throwable r0 = Result.m49exceptionOrNullimpl(obj);
        if (r0 != null) {
            bVar.invoke(r0);
        }
        AppMethodBeat.o(206203);
        return obj;
    }

    private static final <T> Object onSuccess(Object obj, b<? super T, x> bVar) {
        AppMethodBeat.i(206204);
        if (Result.m53isSuccessimpl(obj)) {
            bVar.invoke(obj);
        }
        AppMethodBeat.o(206204);
        return obj;
    }
}
