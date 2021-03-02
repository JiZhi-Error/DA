package kotlinx.coroutines.internal;

import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.sharp.jni.QLog;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\b\u001a\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0000\u001a\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u0002H\u00040\fj\b\u0012\u0004\u0012\u0002H\u0004`\r\"\u0004\b\u0000\u0010\u0004H\u0000\u001a*\u0010\u000e\u001a\u0002H\u000f\"\u0004\b\u0000\u0010\u000f*\u00060\u0010j\u0002`\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0013H\b¢\u0006\u0002\u0010\u0014\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0004¢\u0006\u0002\n\u0000*\f\b\u0000\u0010\u0015\"\u00020\u00102\u00020\u0010¨\u0006\u0016"}, hxF = {"REMOVE_FUTURE_ON_CANCEL", "Ljava/lang/reflect/Method;", "identitySet", "", QLog.TAG_REPORTLEVEL_USER, "expectedSize", "", "removeFutureOnCancel", "", "executor", "Ljava/util/concurrent/Executor;", "subscriberList", "", "Lkotlinx/coroutines/internal/SubscribersList;", "withLock", "T", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", NativeProtocol.WEB_DIALOG_ACTION, "Lkotlin/Function0;", "(Ljava/util/concurrent/locks/ReentrantLock;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "ReentrantLock", "kotlinx-coroutines-core"})
public final class d {
    private static final Method TVC;

    static {
        Method method;
        AppMethodBeat.i(118114);
        try {
            method = ScheduledThreadPoolExecutor.class.getMethod("setRemoveOnCancelPolicy", Boolean.TYPE);
        } catch (Throwable th) {
            method = null;
        }
        TVC = method;
        AppMethodBeat.o(118114);
    }

    public static final boolean b(Executor executor) {
        Executor executor2;
        AppMethodBeat.i(192478);
        try {
            if (!(executor instanceof ScheduledExecutorService)) {
                executor2 = null;
            } else {
                executor2 = executor;
            }
            ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) executor2;
            if (scheduledExecutorService == null) {
                AppMethodBeat.o(192478);
                return false;
            }
            Method method = TVC;
            if (method == null) {
                AppMethodBeat.o(192478);
                return false;
            }
            method.invoke(scheduledExecutorService, Boolean.TRUE);
            AppMethodBeat.o(192478);
            return true;
        } catch (Throwable th) {
            AppMethodBeat.o(192478);
            return true;
        }
    }
}
