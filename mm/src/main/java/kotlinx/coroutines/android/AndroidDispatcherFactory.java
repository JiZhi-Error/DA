package kotlinx.coroutines.android;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.l;
import kotlinx.coroutines.internal.MainDispatcherFactory;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\nH\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, hxF = {"Lkotlinx/coroutines/android/AndroidDispatcherFactory;", "Lkotlinx/coroutines/internal/MainDispatcherFactory;", "()V", "loadPriority", "", "getLoadPriority", "()I", "createDispatcher", "Lkotlinx/coroutines/android/HandlerContext;", "allFactories", "", "hintOnError", "", "kotlinx-coroutines-android"})
public final class AndroidDispatcherFactory implements MainDispatcherFactory {
    @Override // kotlinx.coroutines.internal.MainDispatcherFactory
    public final a createDispatcher(List<? extends MainDispatcherFactory> list) {
        AppMethodBeat.i(187960);
        a aVar = new a(c.k(Looper.getMainLooper()), "Main");
        AppMethodBeat.o(187960);
        return aVar;
    }

    @Override // kotlinx.coroutines.internal.MainDispatcherFactory
    public final String hintOnError() {
        return "For tests Dispatchers.setMain from kotlinx-coroutines-test module can be used";
    }

    @Override // kotlinx.coroutines.internal.MainDispatcherFactory
    public final int getLoadPriority() {
        return 1073741823;
    }
}