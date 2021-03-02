package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class app_attach_file_icon_keynote extends c {
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
                instancePaint3.setColor(-14776843);
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
                instancePaint4.setColor(-15177020);
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
                instancePath3.moveTo(33.0f, 70.0f);
                instancePath3.lineTo(33.0f, 58.0f);
                instancePath3.lineTo(21.0f, 58.0f);
                instancePath3.cubicTo(19.343145f, 58.0f, 18.0f, 56.656853f, 18.0f, 55.0f);
                instancePath3.lineTo(50.0f, 55.0f);
                instancePath3.cubicTo(50.0f, 56.656853f, 48.656853f, 58.0f, 47.0f, 58.0f);
                instancePath3.lineTo(35.0f, 58.0f);
                instancePath3.lineTo(35.0f, 70.0f);
                instancePath3.lineTo(41.0f, 70.0f);
                instancePath3.cubicTo(41.552284f, 70.0f, 42.0f, 70.447716f, 42.0f, 71.0f);
                instancePath3.cubicTo(42.0f, 71.552284f, 41.552284f, 72.0f, 41.0f, 72.0f);
                instancePath3.lineTo(27.0f, 72.0f);
                instancePath3.cubicTo(26.447716f, 72.0f, 26.0f, 71.552284f, 26.0f, 71.0f);
                instancePath3.cubicTo(26.0f, 70.447716f, 26.447716f, 70.0f, 27.0f, 70.0f);
                instancePath3.lineTo(33.0f, 70.0f);
                instancePath3.close();
                instancePath3.moveTo(22.963263f, 40.0f);
                instancePath3.lineTo(45.03674f, 40.0f);
                instancePath3.cubicTo(45.75458f, 40.0f, 46.371803f, 40.508587f, 46.50906f, 41.213184f);
                instancePath3.lineTo(49.0f, 54.0f);
                instancePath3.lineTo(19.0f, 54.0f);
                instancePath3.lineTo(21.490938f, 41.213184f);
                instancePath3.cubicTo(21.628197f, 40.508587f, 22.245419f, 40.0f, 22.963263f, 40.0f);
                instancePath3.close();
                instancePath3.moveTo(27.941095f, 50.631794f);
                instancePath3.lineTo(31.59338f, 47.182507f);
                instancePath3.lineTo(34.927055f, 49.438576f);
                instancePath3.cubicTo(35.184135f, 49.606796f, 35.52287f, 49.573586f, 35.734356f, 49.359222f);
                instancePath3.lineTo(40.37784f, 44.271843f);
                instancePath3.lineTo(39.46163f, 43.371574f);
                instancePath3.lineTo(35.17892f, 48.090324f);
                instancePath3.lineTo(31.900051f, 45.83415f);
                instancePath3.cubicTo(31.664028f, 45.665886f, 31.341633f, 45.699165f, 31.127651f, 45.91366f);
                instancePath3.lineTo(27.10436f, 49.731842f);
                instancePath3.lineTo(27.941095f, 50.631794f);
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
