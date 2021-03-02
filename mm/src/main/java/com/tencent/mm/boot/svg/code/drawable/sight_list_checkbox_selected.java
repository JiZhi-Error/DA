package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class sight_list_checkbox_selected extends c {
    private final int height = 90;
    private final int width = 90;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 90;
            case 1:
                return 90;
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
                instancePath.moveTo(45.0f, 12.0f);
                instancePath.cubicTo(63.225395f, 12.0f, 78.0f, 26.774603f, 78.0f, 45.0f);
                instancePath.cubicTo(78.0f, 63.225395f, 63.225395f, 78.0f, 45.0f, 78.0f);
                instancePath.cubicTo(26.774603f, 78.0f, 12.0f, 63.225395f, 12.0f, 45.0f);
                instancePath.cubicTo(12.0f, 26.774603f, 26.774603f, 12.0f, 45.0f, 12.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(45.0f, 12.0f);
                instancePath2.cubicTo(63.225395f, 12.0f, 78.0f, 26.774603f, 78.0f, 45.0f);
                instancePath2.cubicTo(78.0f, 63.225395f, 63.225395f, 78.0f, 45.0f, 78.0f);
                instancePath2.cubicTo(26.774603f, 78.0f, 12.0f, 63.225395f, 12.0f, 45.0f);
                instancePath2.cubicTo(12.0f, 26.774603f, 26.774603f, 12.0f, 45.0f, 12.0f);
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 66.0f, 0.0f, 12.0f, 0.0f, 66.0f, 12.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                WeChatSVGRenderC2Java.setLinearGradient(instancePaint5, 0.5f, 0.0f, 0.5f, 1.0f, new int[]{-10560163, -5768183}, new float[]{0.0f, 1.0f}, instanceMatrix, 0);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint8 = c.instancePaint(instancePaint, looper);
                instancePaint8.setColor(-1);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(38.250305f, 53.508274f);
                instancePath3.lineTo(29.74203f, 45.0f);
                instancePath3.lineTo(25.49939f, 49.24264f);
                instancePath3.lineTo(38.22731f, 61.970562f);
                instancePath3.lineTo(38.283035f, 61.914837f);
                instancePath3.lineTo(38.30603f, 61.93783f);
                instancePath3.lineTo(64.62193f, 35.62193f);
                instancePath3.lineTo(60.37929f, 31.37929f);
                instancePath3.lineTo(38.250305f, 53.508274f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint8);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
