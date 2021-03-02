package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class bottomsheet_icon_cancel_hao_kan extends c {
    private final int height = 96;
    private final int width = 96;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 96;
            case 1:
                return 96;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                Matrix instanceMatrix = c.instanceMatrix(looper);
                float[] instanceMatrixArray = c.instanceMatrixArray(looper);
                Paint instancePaint = c.instancePaint(looper);
                instancePaint.setFlags(385);
                instancePaint.setStyle(Paint.Style.FILL);
                Paint instancePaint2 = c.instancePaint(looper);
                instancePaint2.setFlags(385);
                instancePaint2.setStyle(Paint.Style.STROKE);
                instancePaint.setColor(WebView.NIGHT_MODE_COLOR);
                instancePaint2.setStrokeWidth(1.0f);
                instancePaint2.setStrokeCap(Paint.Cap.BUTT);
                instancePaint2.setStrokeJoin(Paint.Join.MITER);
                instancePaint2.setStrokeMiter(4.0f);
                instancePaint2.setPathEffect(null);
                c.instancePaint(instancePaint2, looper).setStrokeWidth(1.0f);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -102.0f, 0.0f, 1.0f, -1105.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.restore();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-8683388);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(27.860264f, 42.224224f);
                instancePath.lineTo(16.244278f, 48.80972f);
                instancePath.lineTo(11.775919f, 32.292778f);
                instancePath.cubicTo(11.293263f, 30.495869f, 11.832553f, 28.662212f, 13.041141f, 27.405102f);
                instancePath.lineTo(27.860264f, 42.224224f);
                instancePath.close();
                instancePath.moveTo(22.487175f, 24.123215f);
                instancePath.lineTo(32.12214f, 21.56749f);
                instancePath.lineTo(32.157063f, 33.793102f);
                instancePath.lineTo(22.487175f, 24.123215f);
                instancePath.close();
                instancePath.moveTo(58.56243f, 72.92639f);
                instancePath.lineTo(62.774803f, 77.13876f);
                instancePath.lineTo(51.687485f, 88.06427f);
                instancePath.cubicTo(49.64852f, 90.08063f, 46.351482f, 90.08063f, 44.31252f, 88.06427f);
                instancePath.lineTo(32.12214f, 76.00905f);
                instancePath.lineTo(45.397076f, 68.37264f);
                instancePath.cubicTo(47.002213f, 67.42882f, 48.99779f, 67.42882f, 50.646313f, 68.37264f);
                instancePath.lineTo(58.56243f, 72.92639f);
                instancePath.close();
                instancePath.moveTo(72.13884f, 73.77488f);
                instancePath.lineTo(63.84792f, 65.48396f);
                instancePath.lineTo(63.83448f, 60.77914f);
                instancePath.cubicTo(63.83448f, 58.97729f, 64.83227f, 57.261246f, 66.43741f, 56.31742f);
                instancePath.lineTo(79.75572f, 48.76682f);
                instancePath.lineTo(84.22408f, 65.24086f);
                instancePath.cubicTo(84.96158f, 67.986534f, 83.31306f, 70.81801f, 80.536606f, 71.54733f);
                instancePath.lineTo(72.13884f, 73.77488f);
                instancePath.close();
                instancePath.moveTo(32.165524f, 60.82204f);
                instancePath.lineTo(32.12214f, 76.00905f);
                instancePath.lineTo(15.4634f, 71.59023f);
                instancePath.cubicTo(12.686943f, 70.86091f, 11.038423f, 68.029434f, 11.775919f, 65.28376f);
                instancePath.lineTo(16.244278f, 48.80972f);
                instancePath.lineTo(29.562593f, 56.36032f);
                instancePath.cubicTo(31.167734f, 57.261246f, 32.165524f, 58.97729f, 32.165524f, 60.82204f);
                instancePath.close();
                instancePath.moveTo(63.83448f, 36.754498f);
                instancePath.lineTo(63.877865f, 21.56749f);
                instancePath.lineTo(80.536606f, 25.986307f);
                instancePath.cubicTo(83.31306f, 26.715628f, 84.96158f, 29.547104f, 84.22408f, 32.292778f);
                instancePath.lineTo(79.75572f, 48.76682f);
                instancePath.lineTo(66.43741f, 41.216217f);
                instancePath.cubicTo(64.83227f, 40.315292f, 63.83448f, 38.599247f, 63.83448f, 36.754498f);
                instancePath.close();
                instancePath.moveTo(45.397076f, 29.203894f);
                instancePath.lineTo(32.12214f, 21.56749f);
                instancePath.lineTo(44.31252f, 9.512265f);
                instancePath.cubicTo(46.351482f, 7.4959116f, 49.64852f, 7.4959116f, 51.687485f, 9.512265f);
                instancePath.lineTo(63.877865f, 21.56749f);
                instancePath.lineTo(50.60293f, 29.203894f);
                instancePath.cubicTo(48.99779f, 30.147718f, 47.002213f, 30.147718f, 45.397076f, 29.203894f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-8683388);
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 0.70710677f, -0.70710677f, 48.001785f, 0.70710677f, 0.70710677f, -19.882988f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(2.0017858f, 45.401787f);
                instancePath2.cubicTo(2.0017858f, 44.90473f, 2.4047296f, 44.501785f, 2.9017859f, 44.501785f);
                instancePath2.lineTo(93.10178f, 44.501785f);
                instancePath2.cubicTo(93.59884f, 44.501785f, 94.001785f, 44.90473f, 94.001785f, 45.401787f);
                instancePath2.lineTo(94.001785f, 50.601784f);
                instancePath2.cubicTo(94.001785f, 51.09884f, 93.59884f, 51.501785f, 93.10178f, 51.501785f);
                instancePath2.lineTo(2.9017859f, 51.501785f);
                instancePath2.cubicTo(2.4047296f, 51.501785f, 2.0017858f, 51.09884f, 2.0017858f, 50.601784f);
                instancePath2.lineTo(2.0017858f, 45.401787f);
                instancePath2.close();
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}