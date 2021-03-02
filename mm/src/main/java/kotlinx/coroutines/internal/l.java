package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.sharp.jni.QLog;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\b\u0010\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00028\u0000¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eJ-\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0012\"\u0004\b\u0001\u0010\u000f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0017\u001a\u00020\u00038F@\u0006¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u000eR\u0013\u0010\u001b\u001a\u00020\u00188F@\u0006¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, hxF = {"Lkotlinx/coroutines/internal/LockFreeTaskQueue;", "", QLog.TAG_REPORTLEVEL_USER, "", "singleConsumer", "<init>", "(Z)V", "element", "addLast", "(Ljava/lang/Object;)Z", "", "close", "()V", "isClosed", "()Z", "R", "Lkotlin/Function1;", "transform", "", "map", "(Lkotlin/jvm/functions/Function1;)Ljava/util/List;", "removeFirstOrNull", "()Ljava/lang/Object;", "isEmpty", "", "getSize", "()I", "size", "kotlinx-coroutines-core"})
public class l<E> {
    private static final AtomicReferenceFieldUpdater TVT = AtomicReferenceFieldUpdater.newUpdater(l.class, Object.class, "_cur");
    private volatile Object _cur = new m(8, false);

    static {
        AppMethodBeat.i(118130);
        AppMethodBeat.o(118130);
    }

    public l() {
        AppMethodBeat.i(118129);
        AppMethodBeat.o(118129);
    }

    public final int getSize() {
        long j2 = ((m) this._cur)._state;
        return (((int) ((j2 & 1152921503533105152L) >> 30)) - ((int) ((1073741823 & j2) >> 0))) & 1073741823;
    }

    public final void close() {
        AppMethodBeat.i(118126);
        while (true) {
            m mVar = (m) this._cur;
            if (mVar.close()) {
                AppMethodBeat.o(118126);
                return;
            }
            TVT.compareAndSet(this, mVar, mVar.hNM());
        }
    }

    public final boolean gg(E e2) {
        AppMethodBeat.i(118127);
        while (true) {
            m mVar = (m) this._cur;
            switch (mVar.gh(e2)) {
                case 0:
                    AppMethodBeat.o(118127);
                    return true;
                case 1:
                    TVT.compareAndSet(this, mVar, mVar.hNM());
                    break;
                case 2:
                    AppMethodBeat.o(118127);
                    return false;
            }
        }
    }

    public final E hNC() {
        AppMethodBeat.i(118128);
        while (true) {
            m mVar = (m) this._cur;
            E e2 = (E) mVar.hNC();
            if (e2 != m.TVX) {
                AppMethodBeat.o(118128);
                return e2;
            }
            TVT.compareAndSet(this, mVar, mVar.hNM());
        }
    }
}
