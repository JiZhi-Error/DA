package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class mall_index_balance_icon_normal extends c {
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
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 31.0f, 0.0f, 1.0f, 31.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.restore();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-1);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(78.991554f, 14.00827f);
                instancePath.cubicTo(97.66948f, 31.740889f, 97.66948f, 61.25771f, 78.991554f, 78.99145f);
                instancePath.cubicTo(61.258163f, 97.66952f, 31.741741f, 97.66952f, 14.008727f, 78.99145f);
                instancePath.cubicTo(-4.6695757f, 61.25771f, -4.6695757f, 31.740889f, 14.008727f, 14.00827f);
                instancePath.cubicTo(31.740246f, -4.669423f, 61.258163f, -4.669423f, 78.991554f, 14.00827f);
                instancePath.close();
                instancePath.moveTo(86.38453f, 48.423794f);
                instancePath.cubicTo(86.38453f, 25.27637f, 68.759476f, 7.65122f, 48.42406f, 7.65122f);
                instancePath.cubicTo(25.275711f, 7.65122f, 7.6517115f, 25.27637f, 7.6517115f, 48.423794f);
                instancePath.cubicTo(7.6517115f, 68.759315f, 25.276764f, 86.38446f, 45.612175f, 86.38446f);
                instancePath.cubicTo(68.759476f, 86.38446f, 86.38453f, 68.759315f, 86.38453f, 48.423794f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(48.44434f, 43.142254f);
                instancePath2.lineTo(55.190773f, 29.0f);
                instancePath2.lineTo(61.51553f, 29.0f);
                instancePath2.lineTo(54.769096f, 43.142254f);
                instancePath2.lineTo(61.51553f, 43.142254f);
                instancePath2.lineTo(61.51553f, 48.44558f);
                instancePath2.lineTo(49.28777f, 48.44558f);
                instancePath2.lineTo(49.28777f, 53.306904f);
                instancePath2.lineTo(61.51553f, 53.306904f);
                instancePath2.lineTo(61.51553f, 58.61023f);
                instancePath2.lineTo(49.28777f, 58.61023f);
                instancePath2.lineTo(49.28777f, 66.565216f);
                instancePath2.lineTo(44.227966f, 66.565216f);
                instancePath2.lineTo(44.227966f, 58.61023f);
                instancePath2.lineTo(32.0f, 58.61023f);
                instancePath2.lineTo(32.0f, 53.306904f);
                instancePath2.lineTo(44.227966f, 53.306904f);
                instancePath2.lineTo(44.227966f, 48.44558f);
                instancePath2.lineTo(32.0f, 48.44558f);
                instancePath2.lineTo(32.0f, 43.142254f);
                instancePath2.lineTo(38.746433f, 43.142254f);
                instancePath2.lineTo(32.0f, 29.0f);
                instancePath2.lineTo(38.324757f, 29.0f);
                instancePath2.lineTo(45.07119f, 43.142254f);
                instancePath2.lineTo(48.44434f, 43.142254f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
