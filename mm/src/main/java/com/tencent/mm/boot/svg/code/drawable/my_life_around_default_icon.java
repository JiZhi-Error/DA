package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class my_life_around_default_icon extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint2, looper);
                instancePaint3.setStrokeWidth(1.0f);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(-372399);
                instancePaint4.setStrokeWidth(3.7565217f);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 13.0f, 0.0f, 1.0f, 8.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(33.423096f, 23.393011f);
                instancePath.cubicTo(33.423096f, 28.885603f, 28.958527f, 33.335987f, 23.453514f, 33.335987f);
                instancePath.cubicTo(17.946226f, 33.335987f, 13.483933f, 28.885603f, 13.483933f, 23.393011f);
                instancePath.cubicTo(13.483933f, 17.90042f, 17.946226f, 13.450035f, 23.453514f, 13.450035f);
                instancePath.cubicTo(28.958527f, 13.450035f, 33.423096f, 17.90042f, 33.423096f, 23.393011f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint4, looper);
                instancePaint6.setStrokeJoin(Paint.Join.MITER);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(36.644825f, 43.30803f);
                instancePath2.lineTo(23.453743f, 56.466183f);
                instancePath2.lineTo(14.822849f, 47.85832f);
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                canvas.drawPath(instancePath2, instancePaint6);
                canvas.restore();
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint4, looper);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(40.033207f, 39.928688f);
                instancePath3.cubicTo(49.190014f, 30.796316f, 49.190014f, 15.989706f, 40.033207f, 6.857335f);
                instancePath3.cubicTo(30.876402f, -2.275036f, 16.030172f, -2.275036f, 6.873366f, 6.857335f);
                instancePath3.cubicTo(-2.2834404f, 15.989706f, -2.2834404f, 30.796316f, 6.873366f, 39.928688f);
                instancePath3.lineTo(11.679438f, 44.721935f);
                canvas.drawPath(instancePath3, instancePaint7);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
