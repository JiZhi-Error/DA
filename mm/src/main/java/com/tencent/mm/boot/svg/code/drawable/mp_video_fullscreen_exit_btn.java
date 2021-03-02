package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class mp_video_fullscreen_exit_btn extends c {
    private final int height = 33;
    private final int width = 32;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 32;
            case 1:
                return 33;
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
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(32.0f, 0.0f);
                instancePath.lineTo(32.0f, 32.0f);
                instancePath.lineTo(0.0f, 32.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.saveLayerAlpha(null, 0, 31);
                canvas.drawPath(instancePath, c.instancePaint(instancePaint3, looper));
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-1);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 4.0f, 0.0f, 1.0f, 3.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.416667f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(24.0f, 17.916666f);
                instancePath2.lineTo(24.0f, 23.25f);
                instancePath2.cubicTo(24.0f, 23.98638f, 23.403046f, 24.583334f, 22.666666f, 24.583334f);
                instancePath2.lineTo(17.333334f, 24.583334f);
                instancePath2.lineTo(17.333334f, 22.983334f);
                instancePath2.lineTo(22.4f, 22.983334f);
                instancePath2.lineTo(22.4f, 17.916666f);
                instancePath2.lineTo(24.0f, 17.916666f);
                instancePath2.close();
                instancePath2.moveTo(8.698144f, 14.559919f);
                instancePath2.cubicTo(9.434524f, 14.559919f, 10.031477f, 15.156873f, 10.031477f, 15.893252f);
                instancePath2.lineTo(10.031477f, 21.226585f);
                instancePath2.lineTo(8.431478f, 21.226585f);
                instancePath2.lineTo(8.431478f, 17.291279f);
                instancePath2.lineTo(1.135565f, 24.58719f);
                instancePath2.lineTo(0.0041941307f, 23.45582f);
                instancePath2.lineTo(7.300095f, 16.15992f);
                instancePath2.lineTo(3.3648107f, 16.15992f);
                instancePath2.lineTo(3.3648107f, 14.559919f);
                instancePath2.lineTo(8.698144f, 14.559919f);
                instancePath2.close();
                instancePath2.moveTo(22.864435f, 0.57947576f);
                instancePath2.lineTo(23.995806f, 1.7108467f);
                instancePath2.lineTo(16.699905f, 9.006747f);
                instancePath2.lineTo(20.63519f, 9.006747f);
                instancePath2.lineTo(20.63519f, 10.606748f);
                instancePath2.lineTo(15.301856f, 10.606748f);
                instancePath2.cubicTo(14.565476f, 10.606748f, 13.968523f, 10.009794f, 13.968523f, 9.273415f);
                instancePath2.lineTo(13.968523f, 3.940081f);
                instancePath2.lineTo(15.568522f, 3.940081f);
                instancePath2.lineTo(15.568522f, 7.875388f);
                instancePath2.lineTo(22.864435f, 0.57947576f);
                instancePath2.close();
                instancePath2.moveTo(6.6666665f, 0.5833333f);
                instancePath2.lineTo(6.6666665f, 2.1833334f);
                instancePath2.lineTo(1.6f, 2.1833334f);
                instancePath2.lineTo(1.6f, 7.25f);
                instancePath2.lineTo(0.0f, 7.25f);
                instancePath2.lineTo(0.0f, 1.9166666f);
                instancePath2.cubicTo(0.0f, 1.180287f, 0.5969537f, 0.5833333f, 1.3333334f, 0.5833333f);
                instancePath2.lineTo(6.6666665f, 0.5833333f);
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
