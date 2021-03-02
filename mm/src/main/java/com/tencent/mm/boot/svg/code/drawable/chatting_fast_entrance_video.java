package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class chatting_fast_entrance_video extends c {
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 14.0f, 0.0f, 1.0f, 27.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(2.388248f, 1.4991292f);
                instancePath.cubicTo(3.7864833f, 0.7005225f, 5.52429f, 1.1497388f, 7.062349f, 1.0f);
                instancePath.cubicTo(20.05595f, 1.0798607f, 33.04955f, 0.9301219f, 46.04315f, 1.0698781f);
                instancePath.cubicTo(48.050617f, 0.9401045f, 49.239117f, 3.1362731f, 48.959473f, 4.913173f);
                instancePath.cubicTo(48.959473f, 15.664417f, 48.96946f, 26.41566f, 48.949482f, 37.15692f);
                instancePath.cubicTo(49.22913f, 38.903873f, 48.000683f, 41.020184f, 46.063126f, 40.90039f);
                instancePath.cubicTo(32.36042f, 41.020184f, 18.647728f, 40.920357f, 4.945021f, 40.950302f);
                instancePath.cubicTo(3.1672647f, 41.259766f, 0.98002523f, 40.101784f, 1.0798992f, 38.095284f);
                instancePath.cubicTo(0.9300882f, 27.403936f, 1.0798992f, 16.702606f, 1.0f, 6.001275f);
                instancePath.cubicTo(1.049937f, 4.434009f, 0.7902647f, 2.4275095f, 2.388248f, 1.4991292f);
                instancePath.lineTo(2.388248f, 1.4991292f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(52.016293f, 14.441051f);
                instancePath2.cubicTo(57.033634f, 10.007826f, 61.711834f, 5.170664f, 66.958595f, 1.0f);
                instancePath2.cubicTo(68.434875f, 3.0297904f, 67.87628f, 5.604898f, 67.97603f, 7.9477406f);
                instancePath2.cubicTo(67.84636f, 18.36935f, 68.1855f, 28.821257f, 67.81644f, 39.23277f);
                instancePath2.cubicTo(67.596985f, 39.667004f, 67.1581f, 40.555668f, 66.93865f, 41.0f);
                instancePath2.cubicTo(61.711834f, 36.87983f, 57.12341f, 32.002274f, 52.066166f, 27.670033f);
                instancePath2.cubicTo(51.956444f, 23.257006f, 52.016293f, 18.854076f, 52.016293f, 14.441051f);
                instancePath2.lineTo(52.016293f, 14.441051f);
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
