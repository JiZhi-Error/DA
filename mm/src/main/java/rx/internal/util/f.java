package rx.internal.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Queue;
import rx.internal.a.c;
import rx.internal.util.unsafe.SpmcArrayQueue;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.j;

public final class f implements j {
    public static final int SIZE = xZa;
    private static final c<Object> Unm = c.hQG();
    public static final d<Queue<Object>> Uno = new d<Queue<Object>>() {
        /* class rx.internal.util.f.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* access modifiers changed from: protected */
        @Override // rx.internal.util.d
        public final /* synthetic */ Queue<Object> hQQ() {
            AppMethodBeat.i(90194);
            SpscArrayQueue spscArrayQueue = new SpscArrayQueue(f.SIZE);
            AppMethodBeat.o(90194);
            return spscArrayQueue;
        }
    };
    public static final d<Queue<Object>> Unp = new d<Queue<Object>>() {
        /* class rx.internal.util.f.AnonymousClass2 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* access modifiers changed from: protected */
        @Override // rx.internal.util.d
        public final /* synthetic */ Queue<Object> hQQ() {
            AppMethodBeat.i(90195);
            SpmcArrayQueue spmcArrayQueue = new SpmcArrayQueue(f.SIZE);
            AppMethodBeat.o(90195);
            return spmcArrayQueue;
        }
    };
    static int xZa;
    private final d<Queue<Object>> Unn;
    private Queue<Object> dxk;

    static {
        AppMethodBeat.i(90197);
        xZa = 128;
        if (e.isAndroid()) {
            xZa = 16;
        }
        String property = System.getProperty("rx.ring-buffer.size");
        if (property != null) {
            try {
                xZa = Integer.parseInt(property);
            } catch (NumberFormatException e2) {
                System.err.println("Failed to set 'rx.buffer.size' with value " + property + " => " + e2.getMessage());
            }
        }
        AppMethodBeat.o(90197);
    }

    @Override // rx.j
    public final boolean hQB() {
        return this.dxk == null;
    }

    @Override // rx.j
    public final void hQA() {
        AppMethodBeat.i(90196);
        Queue<Object> queue = this.dxk;
        d<Queue<Object>> dVar = this.Unn;
        if (!(dVar == null || queue == null)) {
            queue.clear();
            this.dxk = null;
            if (queue != null) {
                dVar.aIT.offer(queue);
            }
        }
        AppMethodBeat.o(90196);
    }
}
