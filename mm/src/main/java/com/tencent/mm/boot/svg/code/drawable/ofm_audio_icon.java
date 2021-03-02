package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class ofm_audio_icon extends c {
    private final int height = 96;
    private final int width = 96;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 20.0f, 0.0f, 1.0f, 19.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(2.253182f, 8.691923f);
                instancePath.cubicTo(4.7252164f, 5.0494986f, 8.263815f, 2.0657039f, 12.131352f, -3.5527137E-15f);
                instancePath.cubicTo(14.832648f, 0.5189208f, 15.699854f, 3.8819268f, 17.404362f, 5.748046f);
                instancePath.cubicTo(19.068998f, 8.801695f, 22.458078f, 11.346403f, 22.747147f, 14.8590975f);
                instancePath.cubicTo(20.334919f, 17.693203f, 16.547125f, 18.850796f, 13.327498f, 20.52731f);
                instancePath.cubicTo(15.231364f, 26.904047f, 19.736847f, 32.053337f, 24.511461f, 36.50408f);
                instancePath.cubicTo(27.77096f, 39.537773f, 31.52885f, 42.09246f, 35.805073f, 43.459618f);
                instancePath.cubicTo(37.50958f, 40.186424f, 38.596077f, 36.27456f, 41.466827f, 33.8496f);
                instancePath.cubicTo(44.98549f, 34.27871f, 47.477463f, 37.71157f, 50.527634f, 39.43798f);
                instancePath.cubicTo(52.331818f, 41.124474f, 55.501606f, 41.99267f, 56.0f, 44.63717f);
                instancePath.cubicTo(54.056263f, 48.439262f, 51.23535f, 51.89208f, 47.84627f, 54.486683f);
                instancePath.cubicTo(45.08517f, 56.67214f, 41.31731f, 56.213093f, 38.30701f, 54.855915f);
                instancePath.cubicTo(22.009523f, 48.020134f, 8.732305f, 34.40844f, 2.1435351f, 18.00256f);
                instancePath.cubicTo(0.9573573f, 15.048703f, 0.26957348f, 11.486113f, 2.253182f, 8.691923f);
                instancePath.lineTo(2.253182f, 8.691923f);
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
