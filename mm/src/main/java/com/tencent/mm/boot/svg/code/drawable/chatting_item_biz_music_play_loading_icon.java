package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class chatting_item_biz_music_play_loading_icon extends c {
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
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint2, looper);
                instancePaint3.setStrokeWidth(1.0f);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -122.0f, 0.0f, 1.0f, -1170.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 122.0f, 0.0f, 1.0f, 1170.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(-5066062);
                instancePaint4.setStrokeWidth(6.0f);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(57.391304f, 3.0f);
                instancePath.cubicTo(87.43079f, 3.0f, 111.78261f, 27.351814f, 111.78261f, 57.391304f);
                instancePath.cubicTo(111.78261f, 87.43079f, 87.43079f, 111.78261f, 57.391304f, 111.78261f);
                instancePath.cubicTo(27.351814f, 111.78261f, 3.0f, 87.43079f, 3.0f, 57.391304f);
                instancePath.cubicTo(3.0f, 27.351814f, 27.351814f, 3.0f, 57.391304f, 3.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-5066062);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(76.75181f, 59.59088f);
                instancePath2.lineTo(50.76934f, 76.80847f);
                instancePath2.cubicTo(49.6515f, 77.549225f, 48.144814f, 77.24353f, 47.404064f, 76.125694f);
                instancePath2.cubicTo(47.140537f, 75.72801f, 47.0f, 75.26151f, 47.0f, 74.78445f);
                instancePath2.lineTo(47.0f, 40.34926f);
                instancePath2.cubicTo(47.0f, 39.00826f, 48.087093f, 37.921165f, 49.428093f, 37.921165f);
                instancePath2.cubicTo(49.905163f, 37.921165f, 50.371662f, 38.061703f, 50.76934f, 38.32523f);
                instancePath2.lineTo(76.75181f, 55.542824f);
                instancePath2.cubicTo(77.86965f, 56.283573f, 78.17534f, 57.79026f, 77.43459f, 58.9081f);
                instancePath2.cubicTo(77.255005f, 59.179108f, 77.02282f, 59.411293f, 76.75181f, 59.59088f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
