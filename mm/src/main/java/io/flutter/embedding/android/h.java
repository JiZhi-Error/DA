package io.flutter.embedding.android;

import android.util.LongSparseArray;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicLong;

public final class h {
    private static h SNM;
    public final LongSparseArray<MotionEvent> SNK = new LongSparseArray<>();
    public final PriorityQueue<Long> SNL = new PriorityQueue<>();

    public static class a {
        private static final AtomicLong SNN = new AtomicLong(0);
        final long id;

        static {
            AppMethodBeat.i(215098);
            AppMethodBeat.o(215098);
        }

        private a(long j2) {
            this.id = j2;
        }

        public static a Pa(long j2) {
            AppMethodBeat.i(215096);
            a aVar = new a(j2);
            AppMethodBeat.o(215096);
            return aVar;
        }

        public static a hwE() {
            AppMethodBeat.i(215097);
            a Pa = Pa(SNN.incrementAndGet());
            AppMethodBeat.o(215097);
            return Pa;
        }
    }

    public static h hwD() {
        AppMethodBeat.i(215118);
        if (SNM == null) {
            SNM = new h();
        }
        h hVar = SNM;
        AppMethodBeat.o(215118);
        return hVar;
    }

    private h() {
        AppMethodBeat.i(215119);
        AppMethodBeat.o(215119);
    }

    public final a aD(MotionEvent motionEvent) {
        AppMethodBeat.i(215120);
        a hwE = a.hwE();
        this.SNK.put(hwE.id, MotionEvent.obtain(motionEvent));
        this.SNL.add(Long.valueOf(hwE.id));
        AppMethodBeat.o(215120);
        return hwE;
    }
}
