package kotlinx.coroutines.android;

import kotlin.l;
import kotlinx.coroutines.at;
import kotlinx.coroutines.bc;
import kotlinx.coroutines.ce;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0001\u0001\u0007¨\u0006\b"}, hxF = {"Lkotlinx/coroutines/android/HandlerDispatcher;", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "()V", "immediate", "getImmediate", "()Lkotlinx/coroutines/android/HandlerDispatcher;", "Lkotlinx/coroutines/android/HandlerContext;", "kotlinx-coroutines-android"})
public abstract class b extends ce implements at {
    private b() {
    }

    public /* synthetic */ b(byte b2) {
        this();
    }

    @Override // kotlinx.coroutines.at
    public bc d(long j2, Runnable runnable) {
        return at.a.e(j2, runnable);
    }
}
