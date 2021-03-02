package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_winningrecord extends c {
    private final int height = 24;
    private final int width = 24;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 24;
            case 1:
                return 24;
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
                canvas.saveLayerAlpha(null, 230, 31);
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-436207616);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(13.997904f, 2.0f);
                instancePath.lineTo(20.0f, 8.0f);
                instancePath.lineTo(20.0f, 21.001354f);
                instancePath.cubicTo(20.0f, 21.55423f, 19.554161f, 22.0f, 19.004192f, 22.0f);
                instancePath.lineTo(4.9958086f, 22.0f);
                instancePath.cubicTo(4.4489202f, 22.0f, 4.0f, 21.55289f, 4.0f, 21.001354f);
                instancePath.lineTo(4.0f, 2.9986458f);
                instancePath.cubicTo(4.0f, 2.44577f, 4.4458385f, 2.0f, 4.9958086f, 2.0f);
                instancePath.lineTo(13.997904f, 2.0f);
                instancePath.close();
                instancePath.moveTo(12.399f, 3.199f);
                instancePath.lineTo(5.2f, 3.2f);
                instancePath.lineTo(5.2f, 20.8f);
                instancePath.lineTo(18.8f, 20.8f);
                instancePath.lineTo(18.799f, 9.6f);
                instancePath.lineTo(14.0f, 9.6f);
                instancePath.cubicTo(13.116344f, 9.6f, 12.4f, 8.883656f, 12.4f, 8.0f);
                instancePath.lineTo(12.399f, 3.199f);
                instancePath.close();
                instancePath.moveTo(18.702f, 8.4f);
                instancePath.lineTo(13.599f, 3.298f);
                instancePath.lineTo(13.6f, 8.0f);
                instancePath.cubicTo(13.6f, 8.220914f, 13.779086f, 8.4f, 14.0f, 8.4f);
                instancePath.lineTo(18.702f, 8.4f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 7.0f, 0.0f, 1.0f, 9.5f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(0.0f, 3.0f);
                instancePath2.lineTo(7.5f, 3.0f);
                instancePath2.lineTo(7.5f, 4.2f);
                instancePath2.lineTo(0.0f, 4.2f);
                instancePath2.lineTo(0.0f, 3.0f);
                instancePath2.close();
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint3, looper);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(0.0f, 6.0f);
                instancePath3.lineTo(4.0f, 6.0f);
                instancePath3.lineTo(4.0f, 7.2f);
                instancePath3.lineTo(0.0f, 7.2f);
                instancePath3.lineTo(0.0f, 6.0f);
                instancePath3.close();
                canvas.drawPath(instancePath3, instancePaint6);
                canvas.restore();
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint3, looper);
                Path instancePath4 = c.instancePath(looper);
                instancePath4.moveTo(0.0f, -1.110223E-16f);
                instancePath4.lineTo(4.0f, -1.110223E-16f);
                instancePath4.lineTo(4.0f, 1.2f);
                instancePath4.lineTo(0.0f, 1.2f);
                instancePath4.lineTo(0.0f, -1.110223E-16f);
                instancePath4.close();
                canvas.drawPath(instancePath4, instancePaint7);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
