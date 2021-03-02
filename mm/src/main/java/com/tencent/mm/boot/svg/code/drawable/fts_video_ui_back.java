package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class fts_video_ui_back extends c {
    private final int height = 16;
    private final int width = 20;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 20;
            case 1:
                return 16;
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
                instancePaint3.setColor(-1);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -320.0f, 0.0f, 1.0f, -110.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 108.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray3 = c.setMatrixFloatArray(matrixFloatArray2, 1.0f, 0.0f, 320.0f, 0.0f, 1.0f, 2.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray3);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(20.0f, 16.0f);
                instancePath.lineTo(0.0f, 16.0f);
                instancePath.lineTo(0.0f, 9.25f);
                instancePath.lineTo(0.0f, 9.25f);
                instancePath.cubicTo(-1.6908844E-17f, 9.111929f, 0.11192881f, 9.0f, 0.25f, 9.0f);
                instancePath.lineTo(1.75f, 9.0f);
                instancePath.lineTo(1.75f, 9.0f);
                instancePath.cubicTo(1.8880712f, 9.0f, 2.0f, 9.111929f, 2.0f, 9.25f);
                instancePath.lineTo(2.0f, 14.0f);
                instancePath.lineTo(18.0f, 14.0f);
                instancePath.lineTo(18.0f, 9.25f);
                instancePath.lineTo(18.0f, 9.25f);
                instancePath.cubicTo(18.0f, 9.111929f, 18.111929f, 9.0f, 18.25f, 9.0f);
                instancePath.lineTo(19.75f, 9.0f);
                instancePath.lineTo(19.75f, 9.0f);
                instancePath.cubicTo(19.888071f, 9.0f, 20.0f, 9.111929f, 20.0f, 9.25f);
                instancePath.lineTo(20.0f, 16.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(14.0f, 0.0f);
                instancePath2.lineTo(19.0f, 4.0f);
                instancePath2.lineTo(14.0f, 8.0f);
                instancePath2.lineTo(14.0f, 0.0f);
                instancePath2.close();
                instancePath2.moveTo(5.0f, 11.0f);
                instancePath2.cubicTo(4.9955163f, 7.91632f, 7.619254f, 2.002248f, 14.0f, 2.0f);
                instancePath2.cubicTo(13.975887f, 2.0f, 13.975887f, 3.3333333f, 14.0f, 6.0f);
                instancePath2.cubicTo(10.277842f, 6.0545654f, 7.277841f, 7.7212324f, 5.0f, 11.0f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
