package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class error_offline_info extends c {
    private final int height = 53;
    private final int width = 53;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 53;
            case 1:
                return 53;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 0.434783f, 0.0f, 1.0f, 0.391304f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-16896);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(52.173912f, 26.27763f);
                instancePath.cubicTo(52.173912f, 11.621121f, 40.494686f, 0.0f, 25.764894f, 0.0f);
                instancePath.cubicTo(11.679227f, 0.0f, 0.0f, 11.621121f, 0.0f, 26.27763f);
                instancePath.cubicTo(0.0f, 40.29322f, 11.679227f, 51.91434f, 25.764894f, 51.91434f);
                instancePath.cubicTo(40.494686f, 51.91434f, 52.173912f, 40.29322f, 52.173912f, 26.27763f);
                instancePath.lineTo(52.173912f, 26.27763f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-1);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(23.805798f, 13.323138f);
                instancePath2.lineTo(23.805798f, 13.323138f);
                instancePath2.cubicTo(23.804459f, 13.294402f, 23.80379f, 13.265638f, 23.80379f, 13.23687f);
                instancePath2.cubicTo(23.80379f, 12.213226f, 24.633615f, 11.383399f, 25.657259f, 11.383399f);
                instancePath2.lineTo(25.657259f, 11.383399f);
                instancePath2.lineTo(27.465271f, 11.383399f);
                instancePath2.cubicTo(27.494038f, 11.383399f, 27.522802f, 11.384069f, 27.551538f, 11.385408f);
                instancePath2.cubicTo(28.574074f, 11.433053f, 29.364378f, 12.300605f, 29.316732f, 13.323138f);
                instancePath2.lineTo(29.316732f, 13.323138f);
                instancePath2.lineTo(28.500492f, 30.840899f);
                instancePath2.cubicTo(28.47699f, 31.345303f, 28.0612f, 31.74217f, 27.556248f, 31.74217f);
                instancePath2.lineTo(27.556248f, 31.74217f);
                instancePath2.lineTo(25.566282f, 31.74217f);
                instancePath2.cubicTo(25.06133f, 31.74217f, 24.64554f, 31.345303f, 24.622036f, 30.840899f);
                instancePath2.lineTo(23.805798f, 13.323138f);
                instancePath2.lineTo(23.805798f, 13.323138f);
                instancePath2.close();
                instancePath2.moveTo(26.561264f, 40.790512f);
                instancePath2.cubicTo(24.989546f, 40.790512f, 23.715414f, 39.52455f, 23.715414f, 37.962906f);
                instancePath2.cubicTo(23.715414f, 36.401264f, 24.989546f, 35.1353f, 26.561264f, 35.1353f);
                instancePath2.cubicTo(28.132984f, 35.1353f, 29.407114f, 36.401264f, 29.407114f, 37.962906f);
                instancePath2.cubicTo(29.407114f, 39.52455f, 28.132984f, 40.790512f, 26.561264f, 40.790512f);
                instancePath2.lineTo(26.561264f, 40.790512f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
