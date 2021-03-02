package com.tencent.magicbrush.handler;

import android.view.MotionEvent;
import com.tencent.magicbrush.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public class JsTouchEventHandler {
    private IntBuffer cML;
    private FloatBuffer cMM;
    private b cMN = new b(this);

    public interface a {
        void aY(long j2);
    }

    private native long nativeCreateTouchEvent(int i2, int i3, int i4, IntBuffer intBuffer, FloatBuffer floatBuffer, long j2);

    private native void nativeFreeTouchEvent(long j2);

    static /* synthetic */ void a(JsTouchEventHandler jsTouchEventHandler, long j2) {
        AppMethodBeat.i(139995);
        jsTouchEventHandler.nativeFreeTouchEvent(j2);
        AppMethodBeat.o(139995);
    }

    public JsTouchEventHandler() {
        AppMethodBeat.i(139991);
        il(10);
        AppMethodBeat.o(139991);
    }

    public final long a(MotionEvent motionEvent, float f2) {
        int i2 = -1;
        AppMethodBeat.i(139992);
        il(motionEvent.getPointerCount());
        int p = p(motionEvent);
        if (p == -1) {
            AppMethodBeat.o(139992);
            return 0;
        }
        int pointerCount = motionEvent.getPointerCount();
        for (int i3 = 0; i3 < pointerCount; i3++) {
            this.cML.put(motionEvent.getPointerId(i3));
            this.cMM.put(motionEvent.getX(i3) / f2);
            this.cMM.put(motionEvent.getY(i3) / f2);
        }
        int p2 = p(motionEvent);
        if (p != 1) {
            i2 = motionEvent.getActionIndex();
        }
        long nativeCreateTouchEvent = nativeCreateTouchEvent(p2, i2, pointerCount, this.cML, this.cMM, motionEvent.getEventTime());
        AppMethodBeat.o(139992);
        return nativeCreateTouchEvent;
    }

    public static class b implements a {
        private WeakReference<JsTouchEventHandler> cMO;

        public b(JsTouchEventHandler jsTouchEventHandler) {
            AppMethodBeat.i(139989);
            this.cMO = new WeakReference<>(jsTouchEventHandler);
            AppMethodBeat.o(139989);
        }

        @Override // com.tencent.magicbrush.handler.JsTouchEventHandler.a
        public final void aY(long j2) {
            AppMethodBeat.i(139990);
            JsTouchEventHandler jsTouchEventHandler = this.cMO.get();
            if (jsTouchEventHandler != null) {
                JsTouchEventHandler.a(jsTouchEventHandler, j2);
            }
            AppMethodBeat.o(139990);
        }
    }

    public final a Rw() {
        return this.cMN;
    }

    private void il(int i2) {
        int i3;
        AppMethodBeat.i(139993);
        if (this.cML == null || this.cML.capacity() < i2) {
            if (this.cML != null) {
                i3 = this.cML.capacity();
                while (i3 < i2) {
                    i3 *= 2;
                }
            } else {
                i3 = i2;
            }
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(this.cML == null ? 0 : this.cML.capacity());
            objArr[1] = Integer.valueOf(i2);
            objArr[2] = Integer.valueOf(i3);
            c.C0193c.i("MicroMsg.JsTouchEventHandler", "Should Create A New Buffer, Current = [%d], Request = [%d], ShouldBe = [%d]", objArr);
            this.cML = ByteBuffer.allocateDirect(i3 * 4).order(ByteOrder.nativeOrder()).asIntBuffer();
            this.cMM = ByteBuffer.allocateDirect(i3 * 2 * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            AppMethodBeat.o(139993);
            return;
        }
        this.cML.clear();
        this.cMM.clear();
        AppMethodBeat.o(139993);
    }

    private static int p(MotionEvent motionEvent) {
        AppMethodBeat.i(139994);
        switch (motionEvent.getActionMasked()) {
            case 0:
            case 5:
                AppMethodBeat.o(139994);
                return 0;
            case 1:
            case 6:
                AppMethodBeat.o(139994);
                return 2;
            case 2:
                AppMethodBeat.o(139994);
                return 1;
            case 3:
                AppMethodBeat.o(139994);
                return 3;
            case 4:
            default:
                AppMethodBeat.o(139994);
                return -1;
        }
    }
}
