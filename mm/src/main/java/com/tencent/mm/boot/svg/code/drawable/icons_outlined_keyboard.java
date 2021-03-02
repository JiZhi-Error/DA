package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_keyboard extends c {
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
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
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
                instancePath.moveTo(30.0f, 56.4f);
                instancePath.cubicTo(44.58032f, 56.4f, 56.4f, 44.58032f, 56.4f, 30.0f);
                instancePath.cubicTo(56.4f, 15.4196825f, 44.58032f, 3.6f, 30.0f, 3.6f);
                instancePath.cubicTo(15.4196825f, 3.6f, 3.6f, 15.4196825f, 3.6f, 30.0f);
                instancePath.cubicTo(3.6f, 44.58032f, 15.4196825f, 56.4f, 30.0f, 56.4f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(13.5f, 18.0f);
                instancePath2.lineTo(19.5f, 18.0f);
                instancePath2.lineTo(19.5f, 24.0f);
                instancePath2.lineTo(13.5f, 24.0f);
                instancePath2.lineTo(13.5f, 18.0f);
                instancePath2.close();
                instancePath2.moveTo(22.5f, 18.0f);
                instancePath2.lineTo(28.5f, 18.0f);
                instancePath2.lineTo(28.5f, 24.0f);
                instancePath2.lineTo(22.5f, 24.0f);
                instancePath2.lineTo(22.5f, 18.0f);
                instancePath2.close();
                instancePath2.moveTo(31.5f, 18.0f);
                instancePath2.lineTo(37.5f, 18.0f);
                instancePath2.lineTo(37.5f, 24.0f);
                instancePath2.lineTo(31.5f, 24.0f);
                instancePath2.lineTo(31.5f, 18.0f);
                instancePath2.close();
                instancePath2.moveTo(40.5f, 18.0f);
                instancePath2.lineTo(46.5f, 18.0f);
                instancePath2.lineTo(46.5f, 24.0f);
                instancePath2.lineTo(40.5f, 24.0f);
                instancePath2.lineTo(40.5f, 18.0f);
                instancePath2.close();
                instancePath2.moveTo(13.5f, 27.0f);
                instancePath2.lineTo(19.5f, 27.0f);
                instancePath2.lineTo(19.5f, 33.0f);
                instancePath2.lineTo(13.5f, 33.0f);
                instancePath2.lineTo(13.5f, 27.0f);
                instancePath2.close();
                instancePath2.moveTo(22.5f, 27.0f);
                instancePath2.lineTo(28.5f, 27.0f);
                instancePath2.lineTo(28.5f, 33.0f);
                instancePath2.lineTo(22.5f, 33.0f);
                instancePath2.lineTo(22.5f, 27.0f);
                instancePath2.close();
                instancePath2.moveTo(21.0f, 39.0f);
                instancePath2.lineTo(39.0f, 39.0f);
                instancePath2.lineTo(39.0f, 45.0f);
                instancePath2.lineTo(21.0f, 45.0f);
                instancePath2.lineTo(21.0f, 39.0f);
                instancePath2.close();
                instancePath2.moveTo(31.5f, 27.0f);
                instancePath2.lineTo(37.5f, 27.0f);
                instancePath2.lineTo(37.5f, 33.0f);
                instancePath2.lineTo(31.5f, 33.0f);
                instancePath2.lineTo(31.5f, 27.0f);
                instancePath2.close();
                instancePath2.moveTo(40.5f, 27.0f);
                instancePath2.lineTo(46.5f, 27.0f);
                instancePath2.lineTo(46.5f, 33.0f);
                instancePath2.lineTo(40.5f, 33.0f);
                instancePath2.lineTo(40.5f, 27.0f);
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
