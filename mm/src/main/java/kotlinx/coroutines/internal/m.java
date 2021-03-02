package kotlinx.coroutines.internal;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.sharp.jni.QLog;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.l;
import kotlinx.coroutines.an;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0016\b\u0000\u0018\u0000 /*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001:\u0002/0B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00028\u0000¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0000j\b\u0012\u0004\u0012\u00028\u0000`\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0000j\b\u0012\u0004\u0012\u00028\u0000`\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0011\u0010\u0010J\r\u0010\u0012\u001a\u00020\u0005¢\u0006\u0004\b\u0012\u0010\u0013J3\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u000e2\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\t\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u0005¢\u0006\u0004\b\u0017\u0010\u0013J-\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00010\u001b\"\u0004\b\u0001\u0010\u00182\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0019¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0013\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u0000¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\"\u0010#J3\u0010&\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u000e2\u0006\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u0003H\u0002¢\u0006\u0004\b&\u0010'R\u0016\u0010\u0004\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010(R\u0013\u0010)\u001a\u00020\u00058F@\u0006¢\u0006\u0006\u001a\u0004\b)\u0010\u0013R\u0016\u0010*\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010(R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010+R\u0013\u0010.\u001a\u00020\u00038F@\u0006¢\u0006\u0006\u001a\u0004\b,\u0010-¨\u00061"}, hxF = {"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "", QLog.TAG_REPORTLEVEL_USER, "", "capacity", "", "singleConsumer", "<init>", "(IZ)V", "element", "addLast", "(Ljava/lang/Object;)I", "", "state", "Lkotlinx/coroutines/internal/Core;", "allocateNextCopy", "(J)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "allocateOrGetNextCopy", "close", "()Z", FirebaseAnalytics.b.INDEX, "fillPlaceholder", "(ILjava/lang/Object;)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "isClosed", "R", "Lkotlin/Function1;", "transform", "", "map", "(Lkotlin/jvm/functions/Function1;)Ljava/util/List;", "markFrozen", "()J", "next", "()Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "removeFirstOrNull", "()Ljava/lang/Object;", "oldHead", "newHead", "removeSlowPath", "(II)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "I", "isEmpty", "mask", "Z", "getSize", "()I", "size", "Companion", "Placeholder", "kotlinx-coroutines-core"})
public final class m<E> {
    private static final AtomicReferenceFieldUpdater TVO = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "_next");
    private static final AtomicLongFieldUpdater TVU = AtomicLongFieldUpdater.newUpdater(m.class, "_state");
    public static final u TVX = new u("REMOVE_FROZEN");
    public static final a TVY = new a((byte) 0);
    private AtomicReferenceArray TVV = new AtomicReferenceArray(this.bwA);
    private final boolean TVW;
    private volatile Object _next = null;
    volatile long _state = 0;
    private final int bwA;
    private final int mask = (this.bwA - 1);

    public m(int i2, boolean z) {
        boolean z2 = true;
        AppMethodBeat.i(118086);
        this.bwA = i2;
        this.TVW = z;
        if (!(this.mask <= 1073741823)) {
            IllegalStateException illegalStateException = new IllegalStateException("Check failed.".toString());
            AppMethodBeat.o(118086);
            throw illegalStateException;
        }
        if (!((this.bwA & this.mask) != 0 ? false : z2)) {
            IllegalStateException illegalStateException2 = new IllegalStateException("Check failed.".toString());
            AppMethodBeat.o(118086);
            throw illegalStateException2;
        }
        AppMethodBeat.o(118086);
    }

    public final boolean isEmpty() {
        long j2 = this._state;
        return ((int) ((1073741823 & j2) >> 0)) == ((int) ((j2 & 1152921503533105152L) >> 30));
    }

    private final m<E> x(int i2, E e2) {
        AppMethodBeat.i(118081);
        Object obj = this.TVV.get(this.mask & i2);
        if (!(obj instanceof b) || ((b) obj).index != i2) {
            AppMethodBeat.o(118081);
            return null;
        }
        this.TVV.set(this.mask & i2, e2);
        AppMethodBeat.o(118081);
        return this;
    }

    public final m<E> hNM() {
        AppMethodBeat.i(118082);
        m<E> Pm = Pm(hNN());
        AppMethodBeat.o(118082);
        return Pm;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v7, resolved type: java.util.concurrent.atomic.AtomicReferenceArray */
    /* JADX WARN: Multi-variable type inference failed */
    private final m<E> Pn(long j2) {
        AppMethodBeat.i(118085);
        m<E> mVar = new m<>(this.bwA * 2, this.TVW);
        int i2 = (int) ((1152921503533105152L & j2) >> 30);
        for (int i3 = (int) ((1073741823 & j2) >> 0); (this.mask & i3) != (this.mask & i2); i3++) {
            Object obj = this.TVV.get(this.mask & i3);
            if (obj == null) {
                obj = new b(i3);
            }
            mVar.TVV.set(mVar.mask & i3, obj);
        }
        mVar._state = -1152921504606846977L & j2;
        AppMethodBeat.o(118085);
        return mVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore$Placeholder;", "", FirebaseAnalytics.b.INDEX, "", "(I)V", "kotlinx-coroutines-core"})
    public static final class b {
        public final int index;

        public b(int i2) {
            this.index = i2;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0016\u001a\u00020\u0004*\u00020\tJ\u0012\u0010\u0017\u001a\u00020\t*\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0004J\u0012\u0010\u0019\u001a\u00020\t*\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0004JP\u0010\u001b\u001a\u0002H\u001c\"\u0004\b\u0001\u0010\u001c*\u00020\t26\u0010\u001d\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\"\u0012\u0004\u0012\u0002H\u001c0\u001eH\b¢\u0006\u0002\u0010#J\u0015\u0010$\u001a\u00020\t*\u00020\t2\u0006\u0010%\u001a\u00020\tH\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u00138\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006&"}, hxF = {"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore$Companion;", "", "()V", "ADD_CLOSED", "", "ADD_FROZEN", "ADD_SUCCESS", "CAPACITY_BITS", "CLOSED_MASK", "", "CLOSED_SHIFT", "FROZEN_MASK", "FROZEN_SHIFT", "HEAD_MASK", "HEAD_SHIFT", "INITIAL_CAPACITY", "MAX_CAPACITY_MASK", "MIN_ADD_SPIN_CAPACITY", "REMOVE_FROZEN", "Lkotlinx/coroutines/internal/Symbol;", "TAIL_MASK", "TAIL_SHIFT", "addFailReason", "updateHead", "newHead", "updateTail", "newTail", "withState", "T", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "head", "tail", "(JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "wo", FacebookRequestErrorClassification.KEY_OTHER, "kotlinx-coroutines-core"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static int Po(long j2) {
            return (2305843009213693952L & j2) != 0 ? 2 : 1;
        }

        public static long au(long j2, int i2) {
            return (-1073741824 & j2) | (((long) i2) << 0);
        }

        public static long av(long j2, int i2) {
            return (-1152921503533105153L & j2) | (((long) i2) << 30);
        }
    }

    static {
        AppMethodBeat.i(118088);
        AppMethodBeat.o(118088);
    }

    public final boolean close() {
        long j2;
        AppMethodBeat.i(192473);
        do {
            j2 = this._state;
            if ((j2 & 2305843009213693952L) != 0) {
                AppMethodBeat.o(192473);
                return true;
            } else if ((1152921504606846976L & j2) != 0) {
                AppMethodBeat.o(192473);
                return false;
            }
        } while (!TVU.compareAndSet(this, j2, j2 | 2305843009213693952L));
        AppMethodBeat.o(192473);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0081  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int gh(E r15) {
        /*
        // Method dump skipped, instructions count: 144
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.m.gh(java.lang.Object):int");
    }

    public final Object hNC() {
        AppMethodBeat.i(192474);
        while (true) {
            long j2 = this._state;
            if ((1152921504606846976L & j2) != 0) {
                u uVar = TVX;
                AppMethodBeat.o(192474);
                return uVar;
            }
            int i2 = (int) ((1073741823 & j2) >> 0);
            if ((((int) ((1152921503533105152L & j2) >> 30)) & this.mask) == (this.mask & i2)) {
                AppMethodBeat.o(192474);
                return null;
            }
            Object obj = this.TVV.get(this.mask & i2);
            if (obj == null) {
                if (this.TVW) {
                    AppMethodBeat.o(192474);
                    return null;
                }
            } else if (obj instanceof b) {
                AppMethodBeat.o(192474);
                return null;
            } else {
                int i3 = (i2 + 1) & 1073741823;
                if (TVU.compareAndSet(this, j2, a.au(j2, i3))) {
                    this.TVV.set(this.mask & i2, null);
                    AppMethodBeat.o(192474);
                    return obj;
                } else if (this.TVW) {
                    m<E> mVar = this;
                    do {
                        mVar = mVar.nc(i2, i3);
                    } while (mVar != null);
                    AppMethodBeat.o(192474);
                    return obj;
                }
            }
        }
    }

    private final m<E> nc(int i2, int i3) {
        long j2;
        int i4;
        AppMethodBeat.i(192475);
        do {
            j2 = this._state;
            i4 = (int) ((1073741823 & j2) >> 0);
            if (an.hMK()) {
                if (!(i4 == i2)) {
                    AssertionError assertionError = new AssertionError();
                    AppMethodBeat.o(192475);
                    throw assertionError;
                }
            }
            if ((1152921504606846976L & j2) != 0) {
                m<E> hNM = hNM();
                AppMethodBeat.o(192475);
                return hNM;
            }
        } while (!TVU.compareAndSet(this, j2, a.au(j2, i3)));
        this.TVV.set(this.mask & i4, null);
        AppMethodBeat.o(192475);
        return null;
    }

    private final long hNN() {
        long j2;
        long j3;
        AppMethodBeat.i(118083);
        do {
            j2 = this._state;
            if ((j2 & 1152921504606846976L) != 0) {
                AppMethodBeat.o(118083);
                return j2;
            }
            j3 = j2 | 1152921504606846976L;
        } while (!TVU.compareAndSet(this, j2, j3));
        AppMethodBeat.o(118083);
        return j3;
    }

    private final m<E> Pm(long j2) {
        AppMethodBeat.i(118084);
        while (true) {
            m<E> mVar = (m) this._next;
            if (mVar != null) {
                AppMethodBeat.o(118084);
                return mVar;
            }
            TVO.compareAndSet(this, null, Pn(j2));
        }
    }
}
