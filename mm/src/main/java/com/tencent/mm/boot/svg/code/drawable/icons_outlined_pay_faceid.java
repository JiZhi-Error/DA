package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_pay_faceid extends c {
    private final int height = 72;
    private final int width = 72;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 72;
            case 1:
                return 72;
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 5.0f, 0.0f, 1.0f, 5.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(59.5f, 42.154545f);
                instancePath.cubicTo(60.494114f, 42.154545f, 61.3f, 42.960434f, 61.3f, 43.954544f);
                instancePath.lineTo(61.3f, 51.727272f);
                instancePath.cubicTo(61.3f, 57.014145f, 57.014145f, 61.3f, 51.727272f, 61.3f);
                instancePath.lineTo(43.954544f, 61.3f);
                instancePath.cubicTo(42.960434f, 61.3f, 42.154545f, 60.494114f, 42.154545f, 59.5f);
                instancePath.cubicTo(42.154545f, 58.505886f, 42.960434f, 57.7f, 43.954544f, 57.7f);
                instancePath.lineTo(51.727272f, 57.7f);
                instancePath.cubicTo(55.025917f, 57.7f, 57.7f, 55.025917f, 57.7f, 51.727272f);
                instancePath.lineTo(57.7f, 43.954544f);
                instancePath.cubicTo(57.7f, 42.960434f, 58.505886f, 42.154545f, 59.5f, 42.154545f);
                instancePath.close();
                instancePath.moveTo(2.5f, 42.154545f);
                instancePath.cubicTo(3.4941125f, 42.154545f, 4.3f, 42.960434f, 4.3f, 43.954544f);
                instancePath.lineTo(4.3f, 51.727272f);
                instancePath.cubicTo(4.3f, 55.025917f, 6.974081f, 57.7f, 10.272727f, 57.7f);
                instancePath.lineTo(18.045454f, 57.7f);
                instancePath.cubicTo(19.039568f, 57.7f, 19.845455f, 58.505886f, 19.845455f, 59.5f);
                instancePath.cubicTo(19.845455f, 60.494114f, 19.039568f, 61.3f, 18.045454f, 61.3f);
                instancePath.lineTo(10.272727f, 61.3f);
                instancePath.cubicTo(4.985856f, 61.3f, 0.7f, 57.014145f, 0.7f, 51.727272f);
                instancePath.lineTo(0.7f, 43.954544f);
                instancePath.cubicTo(0.7f, 42.960434f, 1.5058875f, 42.154545f, 2.5f, 42.154545f);
                instancePath.close();
                instancePath.moveTo(41.331837f, 38.789127f);
                instancePath.cubicTo(42.000584f, 39.52468f, 41.946426f, 40.66309f, 41.210873f, 41.331837f);
                instancePath.cubicTo(38.66823f, 43.643543f, 35.235554f, 44.780224f, 31.0f, 44.780224f);
                instancePath.cubicTo(26.764444f, 44.780224f, 23.33177f, 43.643543f, 20.789127f, 41.331837f);
                instancePath.cubicTo(20.053576f, 40.66309f, 19.999416f, 39.52468f, 20.668163f, 38.789127f);
                instancePath.cubicTo(21.33691f, 38.053574f, 22.475319f, 37.999416f, 23.210873f, 38.668163f);
                instancePath.cubicTo(25.038824f, 40.33009f, 27.60615f, 41.180225f, 31.0f, 41.180225f);
                instancePath.cubicTo(34.39385f, 41.180225f, 36.961178f, 40.33009f, 38.789127f, 38.668163f);
                instancePath.cubicTo(39.52468f, 37.999416f, 40.66309f, 38.053574f, 41.331837f, 38.789127f);
                instancePath.close();
                instancePath.moveTo(31.0f, 23.2f);
                instancePath.cubicTo(31.994112f, 23.2f, 32.8f, 24.005888f, 32.8f, 25.0f);
                instancePath.lineTo(32.8f, 34.0f);
                instancePath.cubicTo(32.8f, 34.994114f, 31.994112f, 35.8f, 31.0f, 35.8f);
                instancePath.cubicTo(30.005888f, 35.8f, 29.2f, 34.994114f, 29.2f, 34.0f);
                instancePath.lineTo(29.2f, 25.0f);
                instancePath.cubicTo(29.2f, 24.005888f, 30.005888f, 23.2f, 31.0f, 23.2f);
                instancePath.close();
                instancePath.moveTo(19.0f, 19.0f);
                instancePath.cubicTo(20.656855f, 19.0f, 22.0f, 20.343145f, 22.0f, 22.0f);
                instancePath.cubicTo(22.0f, 23.656855f, 20.656855f, 25.0f, 19.0f, 25.0f);
                instancePath.cubicTo(17.343145f, 25.0f, 16.0f, 23.656855f, 16.0f, 22.0f);
                instancePath.cubicTo(16.0f, 20.343145f, 17.343145f, 19.0f, 19.0f, 19.0f);
                instancePath.close();
                instancePath.moveTo(43.0f, 19.0f);
                instancePath.cubicTo(44.656853f, 19.0f, 46.0f, 20.343145f, 46.0f, 22.0f);
                instancePath.cubicTo(46.0f, 23.656855f, 44.656853f, 25.0f, 43.0f, 25.0f);
                instancePath.cubicTo(41.343147f, 25.0f, 40.0f, 23.656855f, 40.0f, 22.0f);
                instancePath.cubicTo(40.0f, 20.343145f, 41.343147f, 19.0f, 43.0f, 19.0f);
                instancePath.close();
                instancePath.moveTo(18.045454f, 0.7f);
                instancePath.cubicTo(19.039568f, 0.7f, 19.845455f, 1.5058875f, 19.845455f, 2.5f);
                instancePath.cubicTo(19.845455f, 3.4941125f, 19.039568f, 4.3f, 18.045454f, 4.3f);
                instancePath.lineTo(10.272727f, 4.3f);
                instancePath.cubicTo(6.974081f, 4.3f, 4.3f, 6.974081f, 4.3f, 10.272727f);
                instancePath.lineTo(4.3f, 18.045454f);
                instancePath.cubicTo(4.3f, 19.039568f, 3.4941125f, 19.845455f, 2.5f, 19.845455f);
                instancePath.cubicTo(1.5058875f, 19.845455f, 0.7f, 19.039568f, 0.7f, 18.045454f);
                instancePath.lineTo(0.7f, 10.272727f);
                instancePath.cubicTo(0.7f, 4.985856f, 4.985856f, 0.7f, 10.272727f, 0.7f);
                instancePath.lineTo(18.045454f, 0.7f);
                instancePath.close();
                instancePath.moveTo(51.727272f, 0.7f);
                instancePath.cubicTo(57.014145f, 0.7f, 61.3f, 4.985856f, 61.3f, 10.272727f);
                instancePath.lineTo(61.3f, 18.045454f);
                instancePath.cubicTo(61.3f, 19.039568f, 60.494114f, 19.845455f, 59.5f, 19.845455f);
                instancePath.cubicTo(58.505886f, 19.845455f, 57.7f, 19.039568f, 57.7f, 18.045454f);
                instancePath.lineTo(57.7f, 10.272727f);
                instancePath.cubicTo(57.7f, 6.974081f, 55.025917f, 4.3f, 51.727272f, 4.3f);
                instancePath.lineTo(43.954544f, 4.3f);
                instancePath.cubicTo(42.960434f, 4.3f, 42.154545f, 3.4941125f, 42.154545f, 2.5f);
                instancePath.cubicTo(42.154545f, 1.5058875f, 42.960434f, 0.7f, 43.954544f, 0.7f);
                instancePath.lineTo(51.727272f, 0.7f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
