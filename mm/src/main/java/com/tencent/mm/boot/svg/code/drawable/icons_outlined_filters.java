package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_filters extends c {
    private final int height = 24;
    private final int width = 24;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 24;
            case 1:
                return 24;
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
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(16.764002f, 11.250007f);
                instancePath.cubicTo(17.243593f, 10.420647f, 17.5f, 9.477839f, 17.5f, 8.5f);
                instancePath.cubicTo(17.5f, 5.462434f, 15.037566f, 3.0f, 12.0f, 3.0f);
                instancePath.cubicTo(8.962434f, 3.0f, 6.5f, 5.462434f, 6.5f, 8.5f);
                instancePath.cubicTo(6.5f, 11.537566f, 8.962434f, 14.0f, 12.0f, 14.0f);
                instancePath.lineTo(12.0f, 12.0f);
                instancePath.cubicTo(10.067003f, 12.0f, 8.5f, 10.432997f, 8.5f, 8.5f);
                instancePath.cubicTo(8.5f, 6.5670033f, 10.067003f, 5.0f, 12.0f, 5.0f);
                instancePath.cubicTo(13.932997f, 5.0f, 15.5f, 6.5670033f, 15.5f, 8.5f);
                instancePath.cubicTo(15.5f, 9.123929f, 15.337409f, 9.721776f, 15.032639f, 10.2488165f);
                instancePath.lineTo(16.764002f, 11.250007f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, -0.5f, 0.8660254f, -1.052558f, -0.8660254f, -0.5f, 29.892305f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(12.778858f, 18.146908f);
                instancePath2.cubicTo(13.314517f, 17.283787f, 13.602885f, 16.286898f, 13.602885f, 15.25f);
                instancePath2.cubicTo(13.602885f, 12.212434f, 11.140451f, 9.75f, 8.102885f, 9.75f);
                instancePath2.cubicTo(5.0653195f, 9.75f, 2.6028857f, 12.212434f, 2.6028857f, 15.25f);
                instancePath2.cubicTo(2.6028857f, 18.287565f, 5.0653195f, 20.75f, 8.102885f, 20.75f);
                instancePath2.lineTo(8.102885f, 18.75f);
                instancePath2.cubicTo(6.169889f, 18.75f, 4.6028857f, 17.182997f, 4.6028857f, 15.25f);
                instancePath2.cubicTo(4.6028857f, 13.317003f, 6.169889f, 11.75f, 8.102885f, 11.75f);
                instancePath2.cubicTo(10.035882f, 11.75f, 11.602885f, 13.317003f, 11.602885f, 15.25f);
                instancePath2.cubicTo(11.602885f, 15.911496f, 11.420044f, 16.543581f, 11.0795145f, 17.092283f);
                instancePath2.lineTo(12.778858f, 18.146908f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint3, looper);
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, -0.5f, -0.8660254f, 37.05256f, 0.8660254f, -0.5f, 9.107696f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(20.71245f, 17.90926f);
                instancePath3.cubicTo(21.159218f, 17.101671f, 21.397114f, 16.191933f, 21.397114f, 15.25f);
                instancePath3.cubicTo(21.397114f, 12.212434f, 18.93468f, 9.75f, 15.897115f, 9.75f);
                instancePath3.cubicTo(12.859549f, 9.75f, 10.397115f, 12.212434f, 10.397115f, 15.25f);
                instancePath3.cubicTo(10.397115f, 18.287565f, 12.859549f, 20.75f, 15.897115f, 20.75f);
                instancePath3.lineTo(15.897115f, 18.75f);
                instancePath3.cubicTo(13.964118f, 18.75f, 12.397115f, 17.182997f, 12.397115f, 15.25f);
                instancePath3.cubicTo(12.397115f, 13.317003f, 13.964118f, 11.75f, 15.897115f, 11.75f);
                instancePath3.cubicTo(17.83011f, 11.75f, 19.397114f, 13.317003f, 19.397114f, 15.25f);
                instancePath3.cubicTo(19.397114f, 15.851086f, 19.246248f, 16.428015f, 18.962397f, 16.941109f);
                instancePath3.lineTo(20.71245f, 17.90926f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 1);
                canvas.drawPath(instancePath3, instancePaint6);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
