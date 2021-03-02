package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class sight_record_large_icon extends c {
    private final int height = 144;
    private final int width = 144;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 144;
            case 1:
                return 144;
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-2565928);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(6.0f, 51.08541f);
                instancePath.cubicTo(5.843611f, 51.030075f, 5.675318f, 51.0f, 5.5f, 51.0f);
                instancePath.cubicTo(4.665797f, 51.0f, 4.0f, 51.674454f, 4.0f, 52.50644f);
                instancePath.lineTo(4.0f, 60.49356f);
                instancePath.cubicTo(4.0f, 61.32846f, 4.6715727f, 62.0f, 5.5f, 62.0f);
                instancePath.cubicTo(5.6756845f, 62.0f, 5.8439f, 61.970085f, 6.0f, 61.915085f);
                instancePath.lineTo(6.0f, 62.0f);
                instancePath.lineTo(9.0f, 62.0f);
                instancePath.lineTo(9.0f, 51.0f);
                instancePath.lineTo(6.0f, 51.0f);
                instancePath.lineTo(6.0f, 51.08541f);
                instancePath.close();
                instancePath.moveTo(103.0f, 62.0f);
                instancePath.lineTo(132.0f, 44.0f);
                instancePath.lineTo(132.0f, 101.0f);
                instancePath.lineTo(103.0f, 84.0f);
                instancePath.lineTo(103.0f, 62.0f);
                instancePath.close();
                instancePath.moveTo(11.0f, 42.00439f);
                instancePath.cubicTo(11.0f, 37.583687f, 14.586183f, 34.0f, 19.00362f, 34.0f);
                instancePath.lineTo(90.99638f, 34.0f);
                instancePath.cubicTo(95.41666f, 34.0f, 99.0f, 37.584976f, 99.0f, 42.00439f);
                instancePath.lineTo(99.0f, 102.995605f);
                instancePath.cubicTo(99.0f, 107.41631f, 95.41382f, 111.0f, 90.99638f, 111.0f);
                instancePath.lineTo(19.00362f, 111.0f);
                instancePath.cubicTo(14.583343f, 111.0f, 11.0f, 107.41502f, 11.0f, 102.995605f);
                instancePath.lineTo(11.0f, 42.00439f);
                instancePath.close();
                instancePath.moveTo(134.0f, 43.0f);
                instancePath.lineTo(139.0f, 43.0f);
                instancePath.lineTo(139.0f, 103.0f);
                instancePath.lineTo(134.0f, 103.0f);
                instancePath.lineTo(134.0f, 43.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(6.0f, 51.08541f);
                instancePath2.cubicTo(5.843611f, 51.030075f, 5.675318f, 51.0f, 5.5f, 51.0f);
                instancePath2.cubicTo(4.665797f, 51.0f, 4.0f, 51.674454f, 4.0f, 52.50644f);
                instancePath2.lineTo(4.0f, 60.49356f);
                instancePath2.cubicTo(4.0f, 61.32846f, 4.6715727f, 62.0f, 5.5f, 62.0f);
                instancePath2.cubicTo(5.6756845f, 62.0f, 5.8439f, 61.970085f, 6.0f, 61.915085f);
                instancePath2.lineTo(6.0f, 62.0f);
                instancePath2.lineTo(9.0f, 62.0f);
                instancePath2.lineTo(9.0f, 51.0f);
                instancePath2.lineTo(6.0f, 51.0f);
                instancePath2.lineTo(6.0f, 51.08541f);
                instancePath2.close();
                instancePath2.moveTo(103.0f, 62.0f);
                instancePath2.lineTo(132.0f, 44.0f);
                instancePath2.lineTo(132.0f, 101.0f);
                instancePath2.lineTo(103.0f, 84.0f);
                instancePath2.lineTo(103.0f, 62.0f);
                instancePath2.close();
                instancePath2.moveTo(11.0f, 42.00439f);
                instancePath2.cubicTo(11.0f, 37.583687f, 14.586183f, 34.0f, 19.00362f, 34.0f);
                instancePath2.lineTo(90.99638f, 34.0f);
                instancePath2.cubicTo(95.41666f, 34.0f, 99.0f, 37.584976f, 99.0f, 42.00439f);
                instancePath2.lineTo(99.0f, 102.995605f);
                instancePath2.cubicTo(99.0f, 107.41631f, 95.41382f, 111.0f, 90.99638f, 111.0f);
                instancePath2.lineTo(19.00362f, 111.0f);
                instancePath2.cubicTo(14.583343f, 111.0f, 11.0f, 107.41502f, 11.0f, 102.995605f);
                instancePath2.lineTo(11.0f, 42.00439f);
                instancePath2.close();
                instancePath2.moveTo(134.0f, 43.0f);
                instancePath2.lineTo(139.0f, 43.0f);
                instancePath2.lineTo(139.0f, 103.0f);
                instancePath2.lineTo(134.0f, 103.0f);
                instancePath2.lineTo(134.0f, 43.0f);
                instancePath2.close();
                Paint instancePaint6 = c.instancePaint(looper);
                instancePaint6.setFlags(385);
                instancePaint6.setStyle(Paint.Style.FILL);
                Paint instancePaint7 = c.instancePaint(looper);
                instancePaint7.setFlags(385);
                instancePaint7.setStyle(Paint.Style.STROKE);
                instancePaint6.setColor(WebView.NIGHT_MODE_COLOR);
                instancePaint7.setStrokeWidth(1.0f);
                instancePaint7.setStrokeCap(Paint.Cap.BUTT);
                instancePaint7.setStrokeJoin(Paint.Join.MITER);
                instancePaint7.setStrokeMiter(4.0f);
                instancePaint7.setPathEffect(null);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 139.0f, 0.0f, 4.0f, 0.0f, 111.0f, 34.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                WeChatSVGRenderC2Java.setLinearGradient(instancePaint5, 0.5f, 0.0f, 0.5f, 1.0f, new int[]{-9772465, -6687207}, new float[]{0.0f, 1.0f}, instanceMatrix, 0);
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
