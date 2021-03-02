package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class float_ball_icon_music_default extends c {
    private final int height = 120;
    private final int width = 120;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 120;
            case 1:
                return 120;
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
                instancePaint3.setColor(-10197008);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(120.0f, 0.0f);
                instancePath.lineTo(120.0f, 120.0f);
                instancePath.lineTo(0.0f, 120.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-1);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 33.0f, 0.0f, 1.0f, 30.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(45.0f, 6.9265385f);
                instancePath2.lineTo(15.0f, 13.503461f);
                instancePath2.lineTo(15.0f, 48.587288f);
                instancePath2.lineTo(15.0f, 51.603806f);
                instancePath2.cubicTo(15.0f, 54.412968f, 13.118741f, 57.15209f, 10.588413f, 58.332195f);
                instancePath2.cubicTo(10.118035f, 58.551575f, 7.146579f, 59.215725f, 6.758582f, 59.29378f);
                instancePath2.cubicTo(3.030496f, 60.043785f, 0.1660346f, 56.850475f, 0.00828486f, 53.62134f);
                instancePath2.cubicTo(-0.14946488f, 50.39221f, 1.9681898f, 47.699585f, 4.425209f, 47.205288f);
                instancePath2.lineTo(8.218742f, 46.253464f);
                instancePath2.cubicTo(9.559703f, 45.917004f, 10.5f, 44.711636f, 10.5f, 43.32911f);
                instancePath2.lineTo(10.5f, 12.935236f);
                instancePath2.lineTo(10.5f, 11.881246f);
                instancePath2.cubicTo(10.5f, 10.471695f, 11.481296f, 9.252241f, 12.858213f, 8.950698f);
                instancePath2.lineTo(47.679108f, 1.3249646f);
                instancePath2.cubicTo(48.488354f, 1.1477402f, 49.288048f, 1.6600969f, 49.465275f, 2.4693453f);
                instancePath2.cubicTo(49.488358f, 2.5747495f, 49.5f, 2.6823366f, 49.5f, 2.7902386f);
                instancePath2.lineTo(49.5f, 4.4621887f);
                instancePath2.lineTo(49.5f, 40.601345f);
                instancePath2.lineTo(49.5f, 43.617863f);
                instancePath2.cubicTo(49.5f, 46.427025f, 47.602406f, 49.166145f, 45.050106f, 50.346252f);
                instancePath2.cubicTo(44.575645f, 50.56563f, 41.57839f, 51.229782f, 41.187023f, 51.30784f);
                instancePath2.cubicTo(37.426563f, 52.057846f, 34.53723f, 48.864536f, 34.37811f, 45.635403f);
                instancePath2.cubicTo(34.21899f, 42.40627f, 36.355034f, 39.713642f, 38.833385f, 39.219345f);
                instancePath2.lineTo(42.70845f, 38.261543f);
                instancePath2.cubicTo(44.054424f, 37.928856f, 45.0f, 36.721104f, 45.0f, 35.334625f);
                instancePath2.lineTo(45.0f, 6.9265385f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
