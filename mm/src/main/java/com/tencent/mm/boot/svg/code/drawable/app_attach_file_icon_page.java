package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class app_attach_file_icon_page extends c {
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
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 11.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-28160);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(46.0f, 0.0f);
                instancePath.lineTo(68.0f, 22.0f);
                instancePath.lineTo(68.0f, 87.0f);
                instancePath.cubicTo(68.0f, 88.65685f, 66.65685f, 90.0f, 65.0f, 90.0f);
                instancePath.lineTo(3.0f, 90.0f);
                instancePath.cubicTo(1.3431457f, 90.0f, 2.0290612E-16f, 88.65685f, 0.0f, 87.0f);
                instancePath.lineTo(0.0f, 3.0f);
                instancePath.cubicTo(-2.0290612E-16f, 1.3431457f, 1.3431457f, 3.043592E-16f, 3.0f, 0.0f);
                instancePath.lineTo(46.0f, 0.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-3378176);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(68.0f, 22.0f);
                instancePath2.lineTo(49.0f, 22.0f);
                instancePath2.cubicTo(47.343147f, 22.0f, 46.0f, 20.656855f, 46.0f, 19.0f);
                instancePath2.lineTo(46.0f, 0.0f);
                instancePath2.lineTo(68.0f, 22.0f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-1);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(37.10621f, 52.971058f);
                instancePath3.cubicTo(34.776943f, 55.213036f, 30.973436f, 58.62498f, 25.695686f, 63.2069f);
                instancePath3.lineTo(24.528019f, 62.039234f);
                instancePath3.cubicTo(29.109938f, 56.761486f, 32.521885f, 52.957977f, 34.763863f, 50.62871f);
                instancePath3.lineTo(37.10621f, 52.971058f);
                instancePath3.close();
                instancePath3.moveTo(38.017532f, 52.078514f);
                instancePath3.lineTo(35.656406f, 49.71739f);
                instancePath3.cubicTo(37.835155f, 47.538635f, 40.33514f, 45.1877f, 43.15635f, 42.66457f);
                instancePath3.lineTo(43.15633f, 42.66455f);
                instancePath3.cubicTo(43.654514f, 42.219006f, 44.41396f, 42.240166f, 44.88656f, 42.712765f);
                instancePath3.lineTo(45.022152f, 42.84841f);
                instancePath3.cubicTo(45.494728f, 43.320988f, 45.51589f, 44.080395f, 45.070366f, 44.578552f);
                instancePath3.cubicTo(42.547234f, 47.39977f, 40.19629f, 49.899757f, 38.017532f, 52.078514f);
                instancePath3.close();
                instancePath3.moveTo(24.729465f, 64.04455f);
                instancePath3.cubicTo(24.411987f, 64.3194f, 24.089516f, 64.59821f, 23.76205f, 64.881f);
                instancePath3.lineTo(21.824629f, 66.26161f);
                instancePath3.cubicTo(21.711334f, 66.34235f, 21.554043f, 66.31595f, 21.473309f, 66.20266f);
                instancePath3.cubicTo(21.410967f, 66.11517f, 21.410967f, 65.99777f, 21.473309f, 65.91029f);
                instancePath3.lineTo(22.853926f, 63.97287f);
                instancePath3.cubicTo(23.136705f, 63.645405f, 23.415522f, 63.322933f, 23.690374f, 63.005455f);
                instancePath3.lineTo(24.729465f, 64.04455f);
                instancePath3.close();
                instancePath3.moveTo(21.076923f, 67.44615f);
                instancePath3.lineTo(47.661537f, 67.44615f);
                instancePath3.cubicTo(48.069378f, 67.44615f, 48.4f, 67.77677f, 48.4f, 68.184616f);
                instancePath3.cubicTo(48.4f, 68.59245f, 48.069378f, 68.92308f, 47.661537f, 68.92308f);
                instancePath3.lineTo(21.076923f, 68.92308f);
                instancePath3.cubicTo(20.669083f, 68.92308f, 20.33846f, 68.59245f, 20.33846f, 68.184616f);
                instancePath3.cubicTo(20.33846f, 67.77677f, 20.669083f, 67.44615f, 21.076923f, 67.44615f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint5);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
