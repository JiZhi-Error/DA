package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class mall_index_offline_icon_normal extends c {
    private final int height = 93;
    private final int width = 93;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 93;
            case 1:
                return 93;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 11.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(5.2173915f, 0.0f);
                instancePath.cubicTo(2.2700827f, 0.0f, -7.1054274E-15f, 2.4263568f, -7.1054274E-15f, 5.2173915f);
                instancePath.lineTo(-7.1054274E-15f, 65.21739f);
                instancePath.cubicTo(-7.1054274E-15f, 68.00842f, 2.2700827f, 70.434784f, 5.2173915f, 70.434784f);
                instancePath.lineTo(86.08696f, 70.434784f);
                instancePath.cubicTo(89.03313f, 70.434784f, 91.304344f, 68.00842f, 91.304344f, 65.21739f);
                instancePath.lineTo(91.304344f, 5.2173915f);
                instancePath.cubicTo(91.304344f, 2.4263568f, 89.03313f, 0.0f, 86.08696f, 0.0f);
                instancePath.lineTo(5.2173915f, 0.0f);
                instancePath.close();
                instancePath.moveTo(67.82609f, 6.521739f);
                instancePath.lineTo(80.933716f, 6.521739f);
                instancePath.cubicTo(82.835846f, 6.521739f, 84.78261f, 8.498771f, 84.78261f, 11.73913f);
                instancePath.lineTo(84.78261f, 24.782608f);
                instancePath.lineTo(91.304344f, 24.782608f);
                instancePath.lineTo(91.304344f, 44.347828f);
                instancePath.lineTo(84.78261f, 44.347828f);
                instancePath.lineTo(84.78261f, 58.695652f);
                instancePath.cubicTo(84.78261f, 61.936012f, 82.835846f, 63.913044f, 80.933716f, 63.913044f);
                instancePath.lineTo(67.82609f, 63.913044f);
                instancePath.lineTo(67.82609f, 70.434784f);
                instancePath.lineTo(24.782608f, 70.434784f);
                instancePath.lineTo(24.782608f, 63.913044f);
                instancePath.lineTo(10.370634f, 63.913044f);
                instancePath.cubicTo(8.467525f, 63.913044f, 6.521739f, 61.936012f, 6.521739f, 58.695652f);
                instancePath.lineTo(6.521739f, 44.347828f);
                instancePath.lineTo(7.1054274E-15f, 44.347828f);
                instancePath.lineTo(8.303451E-15f, 24.782608f);
                instancePath.lineTo(6.521739f, 24.782608f);
                instancePath.lineTo(6.521739f, 11.73913f);
                instancePath.cubicTo(6.521739f, 8.498771f, 8.467525f, 6.521739f, 10.370634f, 6.521739f);
                instancePath.lineTo(24.782608f, 6.521739f);
                instancePath.lineTo(24.782608f, 0.0f);
                instancePath.lineTo(67.82609f, 0.0f);
                instancePath.lineTo(67.82609f, 6.521739f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(29.608696f, 34.347828f);
                instancePath2.lineTo(27.0f, 39.565216f);
                instancePath2.lineTo(38.739132f, 53.913044f);
                instancePath2.lineTo(64.82609f, 22.608696f);
                instancePath2.lineTo(62.217392f, 20.0f);
                instancePath2.lineTo(38.739132f, 42.173912f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
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
