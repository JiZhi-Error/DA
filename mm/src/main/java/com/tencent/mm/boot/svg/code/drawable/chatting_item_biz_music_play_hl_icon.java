package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class chatting_item_biz_music_play_hl_icon extends c {
    private final int height = 115;
    private final int width = 115;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 115;
            case 1:
                return 115;
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
                Paint instancePaint3 = c.instancePaint(instancePaint2, looper);
                instancePaint3.setStrokeWidth(1.0f);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -330.0f, 0.0f, 1.0f, -386.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 330.0f, 0.0f, 1.0f, 386.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(1711276032);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(57.391304f, 0.0f);
                instancePath.cubicTo(89.08765f, 0.0f, 114.78261f, 25.69496f, 114.78261f, 57.391304f);
                instancePath.cubicTo(114.78261f, 89.08765f, 89.08765f, 114.78261f, 57.391304f, 114.78261f);
                instancePath.cubicTo(25.69496f, 114.78261f, 0.0f, 89.08765f, 0.0f, 57.391304f);
                instancePath.cubicTo(0.0f, 25.69496f, 25.69496f, 0.0f, 57.391304f, 0.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint3, looper);
                instancePaint6.setColor(-1);
                instancePaint6.setStrokeWidth(6.0f);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(57.391304f, 3.0f);
                instancePath2.cubicTo(87.43079f, 3.0f, 111.78261f, 27.351814f, 111.78261f, 57.391304f);
                instancePath2.cubicTo(111.78261f, 87.43079f, 87.43079f, 111.78261f, 57.391304f, 111.78261f);
                instancePath2.cubicTo(27.351814f, 111.78261f, 3.0f, 87.43079f, 3.0f, 57.391304f);
                instancePath2.cubicTo(3.0f, 27.351814f, 27.351814f, 3.0f, 57.391304f, 3.0f);
                instancePath2.close();
                canvas.drawPath(instancePath2, instancePaint6);
                canvas.restore();
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint3, looper);
                instancePaint7.setColor(419430400);
                instancePaint7.setStrokeWidth(6.0f);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(57.391304f, 3.0f);
                instancePath3.cubicTo(87.43079f, 3.0f, 111.78261f, 27.351814f, 111.78261f, 57.391304f);
                instancePath3.cubicTo(111.78261f, 87.43079f, 87.43079f, 111.78261f, 57.391304f, 111.78261f);
                instancePath3.cubicTo(27.351814f, 111.78261f, 3.0f, 87.43079f, 3.0f, 57.391304f);
                instancePath3.cubicTo(3.0f, 27.351814f, 27.351814f, 3.0f, 57.391304f, 3.0f);
                instancePath3.close();
                canvas.drawPath(instancePath3, instancePaint7);
                canvas.restore();
                Paint instancePaint8 = c.instancePaint(instancePaint, looper);
                instancePaint8.setColor(-1);
                canvas.save();
                Paint instancePaint9 = c.instancePaint(instancePaint8, looper);
                Path instancePath4 = c.instancePath(looper);
                instancePath4.moveTo(75.87335f, 59.57144f);
                instancePath4.lineTo(50.798225f, 76.7102f);
                instancePath4.lineTo(50.798225f, 76.7102f);
                instancePath4.cubicTo(49.69112f, 77.4669f, 48.180206f, 77.182846f, 47.423504f, 76.07574f);
                instancePath4.cubicTo(47.147606f, 75.67209f, 47.0f, 75.19454f, 47.0f, 74.70561f);
                instancePath4.lineTo(47.0f, 40.428093f);
                instancePath4.lineTo(47.0f, 40.428093f);
                instancePath4.cubicTo(47.0f, 39.087093f, 48.087093f, 38.0f, 49.428093f, 38.0f);
                instancePath4.cubicTo(49.917027f, 38.0f, 50.39457f, 38.147606f, 50.798225f, 38.423504f);
                instancePath4.lineTo(75.87335f, 55.562263f);
                instancePath4.lineTo(75.87335f, 55.562263f);
                instancePath4.cubicTo(76.98046f, 56.318962f, 77.26452f, 57.829876f, 76.50781f, 58.93698f);
                instancePath4.cubicTo(76.33758f, 59.186047f, 76.12242f, 59.401207f, 75.87335f, 59.57144f);
                instancePath4.close();
                WeChatSVGRenderC2Java.setFillType(instancePath4, 2);
                canvas.drawPath(instancePath4, instancePaint9);
                canvas.restore();
                Paint instancePaint10 = c.instancePaint(instancePaint, looper);
                instancePaint10.setColor(419430400);
                canvas.save();
                Paint instancePaint11 = c.instancePaint(instancePaint10, looper);
                Path instancePath5 = c.instancePath(looper);
                instancePath5.moveTo(75.87335f, 59.57144f);
                instancePath5.lineTo(50.798225f, 76.7102f);
                instancePath5.lineTo(50.798225f, 76.7102f);
                instancePath5.cubicTo(49.69112f, 77.4669f, 48.180206f, 77.182846f, 47.423504f, 76.07574f);
                instancePath5.cubicTo(47.147606f, 75.67209f, 47.0f, 75.19454f, 47.0f, 74.70561f);
                instancePath5.lineTo(47.0f, 40.428093f);
                instancePath5.lineTo(47.0f, 40.428093f);
                instancePath5.cubicTo(47.0f, 39.087093f, 48.087093f, 38.0f, 49.428093f, 38.0f);
                instancePath5.cubicTo(49.917027f, 38.0f, 50.39457f, 38.147606f, 50.798225f, 38.423504f);
                instancePath5.lineTo(75.87335f, 55.562263f);
                instancePath5.lineTo(75.87335f, 55.562263f);
                instancePath5.cubicTo(76.98046f, 56.318962f, 77.26452f, 57.829876f, 76.50781f, 58.93698f);
                instancePath5.cubicTo(76.33758f, 59.186047f, 76.12242f, 59.401207f, 75.87335f, 59.57144f);
                instancePath5.close();
                WeChatSVGRenderC2Java.setFillType(instancePath5, 2);
                canvas.drawPath(instancePath5, instancePaint11);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
