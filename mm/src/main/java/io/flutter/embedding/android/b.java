package io.flutter.embedding.android;

import android.graphics.Matrix;
import android.os.Build;
import android.view.InputDevice;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.b.a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class b {
    private static final Matrix SMt = new Matrix();
    private final a SMr;
    private final h SMs = h.hwD();
    private final boolean SMu;

    static {
        AppMethodBeat.i(215042);
        AppMethodBeat.o(215042);
    }

    public b(a aVar, boolean z) {
        AppMethodBeat.i(215039);
        this.SMr = aVar;
        this.SMu = z;
        AppMethodBeat.o(215039);
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(9979);
        boolean a2 = a(motionEvent, SMt);
        AppMethodBeat.o(9979);
        return a2;
    }

    public final boolean a(MotionEvent motionEvent, Matrix matrix) {
        AppMethodBeat.i(215040);
        int pointerCount = motionEvent.getPointerCount();
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(pointerCount * 29 * 8);
        allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        int actionMasked = motionEvent.getActionMasked();
        int atn = atn(motionEvent.getActionMasked());
        boolean z = actionMasked == 0 || actionMasked == 5;
        boolean z2 = !z && (actionMasked == 1 || actionMasked == 6);
        if (z) {
            a(motionEvent, motionEvent.getActionIndex(), atn, 0, matrix, allocateDirect);
        } else if (z2) {
            for (int i2 = 0; i2 < pointerCount; i2++) {
                if (i2 != motionEvent.getActionIndex() && motionEvent.getToolType(i2) == 1) {
                    a(motionEvent, i2, 5, 1, matrix, allocateDirect);
                }
            }
            a(motionEvent, motionEvent.getActionIndex(), atn, 0, matrix, allocateDirect);
        } else {
            for (int i3 = 0; i3 < pointerCount; i3++) {
                a(motionEvent, i3, atn, 0, matrix, allocateDirect);
            }
        }
        if (allocateDirect.position() % 232 != 0) {
            AssertionError assertionError = new AssertionError("Packet position is not on field boundary");
            AppMethodBeat.o(215040);
            throw assertionError;
        }
        this.SMr.dispatchPointerDataPacket(allocateDirect, allocateDirect.position());
        AppMethodBeat.o(215040);
        return true;
    }

    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        boolean z;
        AppMethodBeat.i(9980);
        boolean z2 = Build.VERSION.SDK_INT >= 18 && motionEvent.isFromSource(2);
        if (motionEvent.getActionMasked() == 7 || motionEvent.getActionMasked() == 8) {
            z = true;
        } else {
            z = false;
        }
        if (!z2 || !z) {
            AppMethodBeat.o(9980);
            return false;
        }
        int atn = atn(motionEvent.getActionMasked());
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(motionEvent.getPointerCount() * 29 * 8);
        allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        a(motionEvent, motionEvent.getActionIndex(), atn, 0, SMt, allocateDirect);
        if (allocateDirect.position() % 232 != 0) {
            AssertionError assertionError = new AssertionError("Packet position is not on field boundary.");
            AppMethodBeat.o(9980);
            throw assertionError;
        }
        this.SMr.dispatchPointerDataPacket(allocateDirect, allocateDirect.position());
        AppMethodBeat.o(9980);
        return true;
    }

    private void a(MotionEvent motionEvent, int i2, int i3, int i4, Matrix matrix, ByteBuffer byteBuffer) {
        long buttonState;
        InputDevice.MotionRange motionRange;
        AppMethodBeat.i(215041);
        if (i3 == -1) {
            AppMethodBeat.o(215041);
            return;
        }
        long j2 = 0;
        if (this.SMu) {
            j2 = this.SMs.aD(motionEvent).id;
        }
        int ato = ato(motionEvent.getToolType(i2));
        int i5 = motionEvent.getActionMasked() == 8 ? 1 : 0;
        byteBuffer.putLong(j2);
        byteBuffer.putLong(motionEvent.getEventTime() * 1000);
        byteBuffer.putLong((long) i3);
        byteBuffer.putLong((long) ato);
        byteBuffer.putLong((long) i5);
        byteBuffer.putLong((long) motionEvent.getPointerId(i2));
        byteBuffer.putLong(0);
        float[] fArr = {motionEvent.getX(i2), motionEvent.getY(i2)};
        matrix.mapPoints(fArr);
        byteBuffer.putDouble((double) fArr[0]);
        byteBuffer.putDouble((double) fArr[1]);
        byteBuffer.putDouble(0.0d);
        byteBuffer.putDouble(0.0d);
        if (ato == 1) {
            buttonState = (long) (motionEvent.getButtonState() & 31);
            if (buttonState == 0 && motionEvent.getSource() == 8194 && (i3 == 4 || i3 == 5)) {
                buttonState = 1;
            }
        } else {
            buttonState = ato == 2 ? (long) ((motionEvent.getButtonState() >> 4) & 15) : 0;
        }
        byteBuffer.putLong(buttonState);
        byteBuffer.putLong(0);
        byteBuffer.putLong(0);
        byteBuffer.putDouble((double) motionEvent.getPressure(i2));
        double d2 = 0.0d;
        double d3 = 1.0d;
        if (!(motionEvent.getDevice() == null || (motionRange = motionEvent.getDevice().getMotionRange(2)) == null)) {
            d2 = (double) motionRange.getMin();
            d3 = (double) motionRange.getMax();
        }
        byteBuffer.putDouble(d2);
        byteBuffer.putDouble(d3);
        if (ato == 2) {
            byteBuffer.putDouble((double) motionEvent.getAxisValue(24, i2));
            byteBuffer.putDouble(0.0d);
        } else {
            byteBuffer.putDouble(0.0d);
            byteBuffer.putDouble(0.0d);
        }
        byteBuffer.putDouble((double) motionEvent.getSize(i2));
        byteBuffer.putDouble((double) motionEvent.getToolMajor(i2));
        byteBuffer.putDouble((double) motionEvent.getToolMinor(i2));
        byteBuffer.putDouble(0.0d);
        byteBuffer.putDouble(0.0d);
        byteBuffer.putDouble((double) motionEvent.getAxisValue(8, i2));
        if (ato == 2) {
            byteBuffer.putDouble((double) motionEvent.getAxisValue(25, i2));
        } else {
            byteBuffer.putDouble(0.0d);
        }
        byteBuffer.putLong((long) i4);
        if (i5 == 1) {
            byteBuffer.putDouble((double) (-motionEvent.getAxisValue(10)));
            byteBuffer.putDouble((double) (-motionEvent.getAxisValue(9)));
            AppMethodBeat.o(215041);
            return;
        }
        byteBuffer.putDouble(0.0d);
        byteBuffer.putDouble(0.0d);
        AppMethodBeat.o(215041);
    }

    private static int atn(int i2) {
        if (i2 == 0) {
            return 4;
        }
        if (i2 == 1) {
            return 6;
        }
        if (i2 == 5) {
            return 4;
        }
        if (i2 == 6) {
            return 6;
        }
        if (i2 == 2) {
            return 5;
        }
        if (i2 == 7) {
            return 3;
        }
        if (i2 == 3) {
            return 0;
        }
        if (i2 == 8) {
            return 3;
        }
        return -1;
    }

    private static int ato(int i2) {
        switch (i2) {
            case 1:
                return 0;
            case 2:
                return 2;
            case 3:
                return 1;
            case 4:
                return 3;
            default:
                return 4;
        }
    }
}
