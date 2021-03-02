package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class emoticonstore_emoji_icon_dark extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-1);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 6.0f, 0.0f, 1.0f, 6.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(30.0f, 60.0f);
                instancePath.cubicTo(13.4314575f, 60.0f, 0.0f, 46.568542f, 0.0f, 30.0f);
                instancePath.cubicTo(0.0f, 13.4314575f, 13.4314575f, 0.0f, 30.0f, 0.0f);
                instancePath.cubicTo(46.568542f, 0.0f, 60.0f, 13.4314575f, 60.0f, 30.0f);
                instancePath.cubicTo(60.0f, 46.568542f, 46.568542f, 60.0f, 30.0f, 60.0f);
                instancePath.close();
                instancePath.moveTo(30.0f, 48.0f);
                instancePath.cubicTo(38.607063f, 48.0f, 45.674892f, 41.40975f, 46.432735f, 33.0f);
                instancePath.lineTo(13.567265f, 33.0f);
                instancePath.cubicTo(14.325108f, 41.40975f, 21.392937f, 48.0f, 30.0f, 48.0f);
                instancePath.close();
                instancePath.moveTo(19.5f, 25.5f);
                instancePath.cubicTo(21.985281f, 25.5f, 24.0f, 23.485281f, 24.0f, 21.0f);
                instancePath.cubicTo(24.0f, 18.514719f, 21.985281f, 16.5f, 19.5f, 16.5f);
                instancePath.cubicTo(17.014719f, 16.5f, 15.0f, 18.514719f, 15.0f, 21.0f);
                instancePath.cubicTo(15.0f, 23.485281f, 17.014719f, 25.5f, 19.5f, 25.5f);
                instancePath.close();
                instancePath.moveTo(40.5f, 25.5f);
                instancePath.cubicTo(42.985283f, 25.5f, 45.0f, 23.485281f, 45.0f, 21.0f);
                instancePath.cubicTo(45.0f, 18.514719f, 42.985283f, 16.5f, 40.5f, 16.5f);
                instancePath.cubicTo(38.014717f, 16.5f, 36.0f, 18.514719f, 36.0f, 21.0f);
                instancePath.cubicTo(36.0f, 23.485281f, 38.014717f, 25.5f, 40.5f, 25.5f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
