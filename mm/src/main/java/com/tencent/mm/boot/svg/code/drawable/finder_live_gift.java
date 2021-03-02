package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class finder_live_gift extends c {
    private final int height = 32;
    private final int width = 32;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 32;
            case 1:
                return 32;
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
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 3.0f, 0.0f, 1.0f, 3.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(16.553778f, 0.20216076f);
                instancePath.cubicTo(17.641445f, 0.16948648f, 18.712675f, 0.5082409f, 19.574352f, 1.1584836f);
                instancePath.cubicTo(20.653656f, 1.973036f, 21.288818f, 3.183052f, 21.373253f, 4.476594f);
                instancePath.lineTo(21.373253f, 4.476594f);
                instancePath.lineTo(21.38f, 4.645f);
                instancePath.lineTo(23.876923f, 4.645378f);
                instancePath.cubicTo(24.778467f, 4.645378f, 25.518295f, 5.337758f, 25.593676f, 6.2197814f);
                instancePath.lineTo(25.593676f, 6.2197814f);
                instancePath.lineTo(25.6f, 6.368455f);
                instancePath.lineTo(25.6f, 12.043697f);
                instancePath.lineTo(24.4f, 12.043f);
                instancePath.lineTo(24.4f, 22.153847f);
                instancePath.cubicTo(24.4f, 23.559067f, 23.304657f, 24.708458f, 21.921192f, 24.794794f);
                instancePath.lineTo(21.921192f, 24.794794f);
                instancePath.lineTo(21.753847f, 24.8f);
                instancePath.lineTo(3.8461537f, 24.8f);
                instancePath.cubicTo(2.3847234f, 24.8f, 1.2f, 23.615276f, 1.2f, 22.153847f);
                instancePath.lineTo(1.2f, 22.153847f);
                instancePath.lineTo(1.2f, 12.043f);
                instancePath.lineTo(7.3896445E-13f, 12.043697f);
                instancePath.lineTo(7.3896445E-13f, 6.368455f);
                instancePath.cubicTo(7.3896445E-13f, 5.416826f, 0.77144784f, 4.645378f, 1.7229867f, 4.645378f);
                instancePath.lineTo(1.7229867f, 4.645378f);
                instancePath.lineTo(4.215f, 4.645f);
                instancePath.cubicTo(4.251651f, 3.368342f, 4.8271027f, 2.1527257f, 5.841667f, 1.3043054f);
                instancePath.lineTo(5.841667f, 1.3043054f);
                instancePath.lineTo(6.0252457f, 1.1584597f);
                instancePath.cubicTo(6.8869395f, 0.5082048f, 7.9581776f, 0.16949078f, 9.046115f, 0.20215756f);
                instancePath.cubicTo(10.344837f, 0.24099822f, 11.561226f, 0.7965853f, 12.435936f, 1.7615949f);
                instancePath.lineTo(12.435936f, 1.7615949f);
                instancePath.lineTo(12.598747f, 1.9526916f);
                instancePath.lineTo(12.799f, 2.202f);
                instancePath.lineTo(13.000877f, 1.9526191f);
                instancePath.cubicTo(13.812224f, 0.9441147f, 15.007891f, 0.32033297f, 16.308807f, 0.21566615f);
                instancePath.lineTo(16.308807f, 0.21566615f);
                instancePath.close();
                instancePath.moveTo(11.5f, 12.042997f);
                instancePath.lineTo(2.8f, 12.042997f);
                instancePath.lineTo(2.8f, 22.153847f);
                instancePath.cubicTo(2.8f, 22.693102f, 3.2080102f, 23.137064f, 3.732164f, 23.193861f);
                instancePath.lineTo(3.8461537f, 23.2f);
                instancePath.lineTo(11.5f, 23.199997f);
                instancePath.lineTo(11.5f, 12.042997f);
                instancePath.close();
                instancePath.moveTo(22.8f, 12.042997f);
                instancePath.lineTo(13.5f, 12.042997f);
                instancePath.lineTo(13.5f, 23.199997f);
                instancePath.lineTo(21.753847f, 23.2f);
                instancePath.cubicTo(22.293102f, 23.2f, 22.737062f, 22.79199f, 22.793861f, 22.267836f);
                instancePath.lineTo(22.8f, 22.153847f);
                instancePath.lineTo(22.8f, 12.042997f);
                instancePath.close();
                instancePath.moveTo(23.876833f, 6.245378f);
                instancePath.lineTo(1.7230769f, 6.245378f);
                instancePath.cubicTo(1.6551034f, 6.245378f, 1.6f, 6.300482f, 1.6f, 6.368455f);
                instancePath.lineTo(1.6f, 6.368455f);
                instancePath.lineTo(1.6f, 10.443f);
                instancePath.lineTo(24.0f, 10.443f);
                instancePath.lineTo(24.0f, 6.368455f);
                instancePath.cubicTo(24.0f, 6.3140764f, 23.964733f, 6.2679343f, 23.91578f, 6.2516527f);
                instancePath.lineTo(23.91578f, 6.2516527f);
                instancePath.lineTo(23.876833f, 6.245378f);
                instancePath.close();
                instancePath.moveTo(8.99819f, 1.8014396f);
                instancePath.cubicTo(8.273149f, 1.7796693f, 7.559055f, 2.005458f, 6.9889445f, 2.4356773f);
                instancePath.cubicTo(6.2627945f, 2.9835107f, 5.848604f, 3.7991545f, 5.8137226f, 4.645645f);
                instancePath.lineTo(12.711f, 4.6449976f);
                instancePath.lineTo(11.367142f, 2.9737608f);
                instancePath.lineTo(11.235118f, 2.8187022f);
                instancePath.cubicTo(10.66955f, 2.195086f, 9.86443f, 1.8273461f, 8.99819f, 1.8014396f);
                instancePath.close();
                instancePath.moveTo(16.601822f, 1.8014393f);
                instancePath.lineTo(16.388458f, 1.8147959f);
                instancePath.cubicTo(15.541453f, 1.8957527f, 14.771023f, 2.3048418f, 14.247453f, 2.9556398f);
                instancePath.lineTo(14.247453f, 2.9556398f);
                instancePath.lineTo(12.887f, 4.6449976f);
                instancePath.lineTo(19.783585f, 4.6454754f);
                instancePath.cubicTo(19.750408f, 3.8591f, 19.395658f, 3.1075153f, 18.773144f, 2.5672543f);
                instancePath.lineTo(18.610546f, 2.4356194f);
                instancePath.cubicTo(18.040546f, 2.0054839f, 17.326466f, 1.7796705f, 16.601822f, 1.8014393f);
                instancePath.lineTo(16.601822f, 1.8014393f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
