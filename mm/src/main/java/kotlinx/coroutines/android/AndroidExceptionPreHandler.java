package kotlinx.coroutines.android;

import android.os.Build;
import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.Thread;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.d.a;
import kotlin.d.f;
import kotlin.l;
import kotlinx.coroutines.CoroutineExceptionHandler;

@Keep
@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\rH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, hxF = {"Lkotlinx/coroutines/android/AndroidExceptionPreHandler;", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "()V", "_preHandler", "", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "preHandler", "Ljava/lang/reflect/Method;", "kotlinx-coroutines-android"})
public final class AndroidExceptionPreHandler extends a implements CoroutineExceptionHandler {
    private volatile Object _preHandler = this;

    public AndroidExceptionPreHandler() {
        super(CoroutineExceptionHandler.TTS);
        AppMethodBeat.i(107783);
        AppMethodBeat.o(107783);
    }

    private final Method preHandler() {
        Method method;
        AppMethodBeat.i(187962);
        Object obj = this._preHandler;
        if (obj != this) {
            Method method2 = (Method) obj;
            AppMethodBeat.o(187962);
            return method2;
        }
        try {
            method = Thread.class.getDeclaredMethod("getUncaughtExceptionPreHandler", new Class[0]);
            if (!(Modifier.isPublic(method.getModifiers()) && Modifier.isStatic(method.getModifiers()))) {
                method = null;
            }
        } catch (Throwable th) {
            method = null;
        }
        this._preHandler = method;
        AppMethodBeat.o(187962);
        return method;
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public final void handleException(f fVar, Throwable th) {
        Object obj;
        AppMethodBeat.i(107782);
        Thread currentThread = Thread.currentThread();
        if (Build.VERSION.SDK_INT >= 28) {
            currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
            AppMethodBeat.o(107782);
            return;
        }
        Method preHandler = preHandler();
        if (preHandler != null) {
            obj = preHandler.invoke(null, new Object[0]);
        } else {
            obj = null;
        }
        if (!(obj instanceof Thread.UncaughtExceptionHandler)) {
            obj = null;
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = (Thread.UncaughtExceptionHandler) obj;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(currentThread, th);
            AppMethodBeat.o(107782);
            return;
        }
        AppMethodBeat.o(107782);
    }
}
