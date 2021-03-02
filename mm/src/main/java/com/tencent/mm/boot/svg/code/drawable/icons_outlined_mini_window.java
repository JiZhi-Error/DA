package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_mini_window extends c {
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
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(19.5f, 3.0f);
                instancePath.cubicTo(20.052284f, 3.0f, 20.5f, 3.4477153f, 20.5f, 4.0f);
                instancePath.lineTo(20.5f, 12.0f);
                instancePath.lineTo(19.3f, 12.0f);
                instancePath.lineTo(19.3f, 4.2f);
                instancePath.lineTo(3.2f, 4.2f);
                instancePath.lineTo(3.2f, 17.8f);
                instancePath.lineTo(12.0f, 17.8f);
                instancePath.lineTo(12.0f, 19.0f);
                instancePath.lineTo(3.0f, 19.0f);
                instancePath.cubicTo(2.4477153f, 19.0f, 2.0f, 18.552284f, 2.0f, 18.0f);
                instancePath.lineTo(2.0f, 4.0f);
                instancePath.cubicTo(2.0f, 3.4477153f, 2.4477153f, 3.0f, 3.0f, 3.0f);
                instancePath.lineTo(19.5f, 3.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(WebView.NIGHT_MODE_COLOR);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(21.0f, 12.8f);
                instancePath2.cubicTo(21.883656f, 12.8f, 22.6f, 13.516344f, 22.6f, 14.4f);
                instancePath2.lineTo(22.6f, 14.4f);
                instancePath2.lineTo(22.6f, 20.0f);
                instancePath2.cubicTo(22.6f, 20.883656f, 21.883656f, 21.6f, 21.0f, 21.6f);
                instancePath2.lineTo(21.0f, 21.6f);
                instancePath2.lineTo(14.4f, 21.6f);
                instancePath2.cubicTo(13.516344f, 21.6f, 12.8f, 20.883656f, 12.8f, 20.0f);
                instancePath2.lineTo(12.8f, 20.0f);
                instancePath2.lineTo(12.8f, 14.4f);
                instancePath2.cubicTo(12.8f, 13.516344f, 13.516344f, 12.8f, 14.4f, 12.8f);
                instancePath2.lineTo(14.4f, 12.8f);
                instancePath2.close();
                instancePath2.moveTo(21.0f, 14.0f);
                instancePath2.lineTo(14.4f, 14.0f);
                instancePath2.cubicTo(14.179086f, 14.0f, 14.0f, 14.179086f, 14.0f, 14.4f);
                instancePath2.lineTo(14.0f, 14.4f);
                instancePath2.lineTo(14.0f, 20.0f);
                instancePath2.cubicTo(14.0f, 20.220915f, 14.179086f, 20.4f, 14.4f, 20.4f);
                instancePath2.lineTo(14.4f, 20.4f);
                instancePath2.lineTo(21.0f, 20.4f);
                instancePath2.cubicTo(21.220915f, 20.4f, 21.4f, 20.220915f, 21.4f, 20.0f);
                instancePath2.lineTo(21.4f, 20.0f);
                instancePath2.lineTo(21.4f, 14.4f);
                instancePath2.cubicTo(21.4f, 14.179086f, 21.220915f, 14.0f, 21.0f, 14.0f);
                instancePath2.lineTo(21.0f, 14.0f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 5.1f, 0.0f, 1.0f, 6.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(WebView.NIGHT_MODE_COLOR);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(0.4008622f, 6.5f);
                instancePath3.lineTo(0.4008622f, 5.3f);
                instancePath3.lineTo(4.385f, 5.2993555f);
                instancePath3.lineTo(0.32f, 1.2338835f);
                instancePath3.lineTo(1.1685282f, 0.38535535f);
                instancePath3.lineTo(5.2f, 4.416355f);
                instancePath3.lineTo(5.2008624f, 0.5f);
                instancePath3.lineTo(6.400862f, 0.5f);
                instancePath3.lineTo(6.4f, 5.6163554f);
                instancePath3.lineTo(6.4011183f, 5.6179457f);
                instancePath3.lineTo(6.4f, 5.6183553f);
                instancePath3.lineTo(6.400862f, 6.0f);
                instancePath3.cubicTo(6.400862f, 6.24546f, 6.223987f, 6.4496083f, 5.990738f, 6.4919443f);
                instancePath3.lineTo(5.900862f, 6.5f);
                instancePath3.lineTo(5.900862f, 6.5f);
                instancePath3.lineTo(0.4008622f, 6.5f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint5);
                canvas.restore();
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint, looper);
                instancePaint6.setColor(WebView.NIGHT_MODE_COLOR);
                Path instancePath4 = c.instancePath(looper);
                instancePath4.moveTo(5.500862f, 12.5f);
                instancePath4.lineTo(5.500862f, 11.3f);
                instancePath4.lineTo(9.485f, 11.2993555f);
                instancePath4.lineTo(5.42f, 7.2338834f);
                instancePath4.lineTo(6.268528f, 6.3853555f);
                instancePath4.lineTo(10.3f, 10.416355f);
                instancePath4.lineTo(10.300862f, 6.5f);
                instancePath4.lineTo(11.500862f, 6.5f);
                instancePath4.lineTo(11.5f, 11.616355f);
                instancePath4.lineTo(11.501119f, 11.617946f);
                instancePath4.lineTo(11.5f, 11.618356f);
                instancePath4.lineTo(11.500862f, 12.0f);
                instancePath4.cubicTo(11.500862f, 12.24546f, 11.323987f, 12.449609f, 11.090737f, 12.491944f);
                instancePath4.lineTo(11.000862f, 12.5f);
                instancePath4.lineTo(11.000862f, 12.5f);
                instancePath4.lineTo(5.500862f, 12.5f);
                instancePath4.close();
                WeChatSVGRenderC2Java.setFillType(instancePath4, 2);
                canvas.drawPath(instancePath4, instancePaint6);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}