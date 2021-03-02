package kotlinx.coroutines.android;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0011\u0010\b\u001a\u00020\u0001H@ø\u0001\u0000¢\u0006\u0002\u0010\t\u001a\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\rH\u0002\u001a\u0016\u0010\u000e\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\rH\u0002\u001a\u001d\u0010\u000f\u001a\u00020\u0003*\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007¢\u0006\u0002\b\u0013\u001a\u0014\u0010\u0014\u001a\u00020\u0010*\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0000X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0004\u0010\u0005\"\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, hxF = {"MAX_DELAY", "", "Main", "Lkotlinx/coroutines/android/HandlerDispatcher;", "Main$annotations", "()V", "choreographer", "Landroid/view/Choreographer;", "awaitFrame", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "postFrameCallback", "", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "updateChoreographerAndPostFrameCallback", "asCoroutineDispatcher", "Landroid/os/Handler;", "name", "", "from", "asHandler", "Landroid/os/Looper;", "async", "", "kotlinx-coroutines-android"})
public final class c {
    public static final b TVv;

    public static final Handler k(Looper looper) {
        AppMethodBeat.i(107779);
        if (Build.VERSION.SDK_INT < 16) {
            Handler handler = new Handler(looper);
            AppMethodBeat.o(107779);
            return handler;
        } else if (Build.VERSION.SDK_INT >= 28) {
            Object invoke = Handler.class.getDeclaredMethod("createAsync", Looper.class).invoke(null, looper);
            if (invoke == null) {
                t tVar = new t("null cannot be cast to non-null type android.os.Handler");
                AppMethodBeat.o(107779);
                throw tVar;
            }
            Handler handler2 = (Handler) invoke;
            AppMethodBeat.o(107779);
            return handler2;
        } else {
            try {
                Constructor declaredConstructor = Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE);
                Handler handler3 = (Handler) declaredConstructor.newInstance(looper, null, Boolean.TRUE);
                AppMethodBeat.o(107779);
                return handler3;
            } catch (NoSuchMethodException e2) {
                Handler handler4 = new Handler(looper);
                AppMethodBeat.o(107779);
                return handler4;
            }
        }
    }

    static {
        Object r0;
        AppMethodBeat.i(107780);
        try {
            Result.Companion companion = Result.Companion;
            r0 = Result.m46constructorimpl(new a(k(Looper.getMainLooper()), "Main"));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            r0 = Result.m46constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m52isFailureimpl(r0)) {
            r0 = null;
        }
        TVv = (b) r0;
        AppMethodBeat.o(107780);
    }
}
