package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class lqt_logo extends c {
    private final int height = 48;
    private final int width = 48;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 48;
            case 1:
                return 48;
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
                instancePaint3.setColor(-526345);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(24.0f, 0.0f);
                instancePath.cubicTo(37.254837f, 0.0f, 48.0f, 10.745165f, 48.0f, 24.0f);
                instancePath.cubicTo(48.0f, 37.254837f, 37.254837f, 48.0f, 24.0f, 48.0f);
                instancePath.cubicTo(10.745165f, 48.0f, 0.0f, 37.254837f, 0.0f, 24.0f);
                instancePath.cubicTo(0.0f, 10.745165f, 10.745165f, 0.0f, 24.0f, 0.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-15616);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 10.5f, 0.0f, 1.0f, 12.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(9.433333f, 4.0E-4f);
                instancePath2.lineTo(5.284f, 4.0E-4f);
                instancePath2.cubicTo(5.06f, 4.0E-4f, 4.848f, 0.1004f, 4.7106667f, 0.27373335f);
                instancePath2.lineTo(-4.5593158E-14f, 6.183067f);
                instancePath2.lineTo(6.616f, 6.183067f);
                instancePath2.lineTo(9.433333f, 4.0E-4f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint4, looper);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(26.6664f, 6.182667f);
                instancePath3.lineTo(21.687733f, 0.26f);
                instancePath3.cubicTo(21.549067f, 0.096f, 21.343733f, -3.7895614E-14f, 21.1264f, -3.7895614E-14f);
                instancePath3.lineTo(17.255733f, -3.7895614E-14f);
                instancePath3.lineTo(20.0744f, 6.182667f);
                instancePath3.lineTo(26.6664f, 6.182667f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint6);
                canvas.restore();
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint4, looper);
                Path instancePath4 = c.instancePath(looper);
                instancePath4.moveTo(15.438533f, 4.0E-4f);
                instancePath4.lineTo(11.250533f, 4.0E-4f);
                instancePath4.lineTo(8.4332f, 6.183067f);
                instancePath4.lineTo(18.254534f, 6.183067f);
                instancePath4.close();
                WeChatSVGRenderC2Java.setFillType(instancePath4, 1);
                WeChatSVGRenderC2Java.setFillType(instancePath4, 2);
                canvas.drawPath(instancePath4, instancePaint7);
                canvas.restore();
                canvas.save();
                Paint instancePaint8 = c.instancePaint(instancePaint4, looper);
                Path instancePath5 = c.instancePath(looper);
                instancePath5.moveTo(0.020666666f, 7.8377333f);
                instancePath5.lineTo(10.602f, 21.751066f);
                instancePath5.lineTo(6.4686666f, 7.8377333f);
                instancePath5.close();
                WeChatSVGRenderC2Java.setFillType(instancePath5, 1);
                WeChatSVGRenderC2Java.setFillType(instancePath5, 2);
                canvas.drawPath(instancePath5, instancePaint8);
                canvas.restore();
                canvas.save();
                Paint instancePaint9 = c.instancePaint(instancePaint4, looper);
                Path instancePath6 = c.instancePath(looper);
                instancePath6.moveTo(8.187333f, 7.8377333f);
                instancePath6.lineTo(12.871333f, 23.6404f);
                instancePath6.cubicTo(12.919333f, 23.845734f, 13.11f, 24.0004f, 13.340667f, 24.0004f);
                instancePath6.cubicTo(13.57f, 24.0004f, 13.763333f, 23.845734f, 13.811334f, 23.6404f);
                instancePath6.lineTo(18.492666f, 7.8377333f);
                instancePath6.lineTo(8.187333f, 7.8377333f);
                instancePath6.close();
                WeChatSVGRenderC2Java.setFillType(instancePath6, 2);
                canvas.drawPath(instancePath6, instancePaint9);
                canvas.restore();
                canvas.save();
                Paint instancePaint10 = c.instancePaint(instancePaint4, looper);
                Path instancePath7 = c.instancePath(looper);
                instancePath7.moveTo(26.6664f, 7.8377333f);
                instancePath7.lineTo(16.083733f, 21.751066f);
                instancePath7.lineTo(20.217066f, 7.8377333f);
                instancePath7.close();
                WeChatSVGRenderC2Java.setFillType(instancePath7, 1);
                WeChatSVGRenderC2Java.setFillType(instancePath7, 2);
                canvas.drawPath(instancePath7, instancePaint10);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
