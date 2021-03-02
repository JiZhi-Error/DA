package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class spannable_app_brand_link_logo_light extends c {
    private final int height = 20;
    private final int width = 20;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 20;
            case 1:
                return 20;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -4.0f, 0.0f, 1.0f, -18.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 4.0f, 0.0f, 1.0f, 18.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-526345);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(10.0f, 0.0f);
                instancePath.cubicTo(15.522848f, 0.0f, 20.0f, 4.4771523f, 20.0f, 10.0f);
                instancePath.cubicTo(20.0f, 15.522848f, 15.522848f, 20.0f, 10.0f, 20.0f);
                instancePath.cubicTo(4.4771523f, 20.0f, 0.0f, 15.522848f, 0.0f, 10.0f);
                instancePath.cubicTo(0.0f, 4.4771523f, 4.4771523f, 0.0f, 10.0f, 0.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-9074981);
                float[] matrixFloatArray3 = c.setMatrixFloatArray(matrixFloatArray2, 1.0f, 0.0f, 4.0f, 0.0f, 1.0f, 5.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray3);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(9.018617f, 5.18391f);
                instancePath2.lineTo(8.890989f, 5.185274f);
                instancePath2.cubicTo(8.518699f, 5.185274f, 8.302917f, 4.9240637f, 8.442778f, 4.6093974f);
                instancePath2.cubicTo(8.541686f, 4.378609f, 8.766817f, 4.196773f, 9.037075f, 4.136731f);
                instancePath2.cubicTo(9.823048f, 3.9470136f, 10.364232f, 3.329606f, 10.364232f, 2.6050024f);
                instancePath2.cubicTo(10.364232f, 1.7325872f, 9.536904f, 1.0199386f, 8.499616f, 1.0199386f);
                instancePath2.cubicTo(7.4623265f, 1.0199386f, 6.634999f, 1.7325872f, 6.634999f, 2.6050024f);
                instancePath2.lineTo(6.634999f, 6.798293f);
                instancePath2.cubicTo(6.634999f, 8.244568f, 5.3389754f, 9.40652f, 3.747219f, 9.40652f);
                instancePath2.cubicTo(2.155463f, 9.40652f, 0.8594396f, 8.244568f, 0.8594396f, 6.798293f);
                instancePath2.cubicTo(0.8594396f, 5.531107f, 1.861776f, 4.451003f, 3.216069f, 4.245977f);
                instancePath2.lineTo(3.3278902f, 4.245977f);
                instancePath2.cubicTo(3.6141586f, 4.245977f, 3.8115163f, 4.412173f, 3.8115163f, 4.645737f);
                instancePath2.cubicTo(3.8116345f, 4.6863756f, 3.8108742f, 4.7061467f, 3.8067667f, 4.7307916f);
                instancePath2.cubicTo(3.8015287f, 4.7622204f, 3.7912507f, 4.791912f, 3.776102f, 4.8218536f);
                instancePath2.cubicTo(3.6822293f, 5.04089f, 3.4387052f, 5.2302976f, 3.1818047f, 5.2945194f);
                instancePath2.cubicTo(2.4000733f, 5.4832134f, 1.8546473f, 6.097778f, 1.8546473f, 6.798293f);
                instancePath2.cubicTo(1.8546473f, 7.6707087f, 2.681975f, 8.383357f, 3.719264f, 8.383357f);
                instancePath2.cubicTo(4.7565527f, 8.383357f, 5.5838804f, 7.6707087f, 5.5838804f, 6.798293f);
                instancePath2.lineTo(5.5838804f, 2.6050024f);
                instancePath2.cubicTo(5.5838804f, 1.1587276f, 6.879904f, -0.0032243636f, 8.47166f, -0.0032243636f);
                instancePath2.cubicTo(10.0634165f, -0.0032243636f, 11.35944f, 1.1587276f, 11.35944f, 2.6050024f);
                instancePath2.cubicTo(11.35944f, 3.8858726f, 10.373533f, 4.948272f, 9.018617f, 5.18391f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
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
