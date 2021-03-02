package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class file_float_ball_icon_pdf extends c {
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
                c.instanceMatrix(looper);
                c.instanceMatrixArray(looper);
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
                instancePaint3.setColor(-1686720);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(48.0f, 0.0f);
                instancePath.lineTo(48.0f, 48.0f);
                instancePath.lineTo(0.0f, 48.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-1);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(9.44873f, 18.021973f);
                instancePath2.lineTo(14.105469f, 18.021973f);
                instancePath2.cubicTo(16.487793f, 18.021973f, 18.139648f, 19.640625f, 18.139648f, 22.03125f);
                instancePath2.cubicTo(18.139648f, 24.421875f, 16.437988f, 26.040527f, 14.01416f, 26.040527f);
                instancePath2.lineTo(11.590332f, 26.040527f);
                instancePath2.lineTo(11.590332f, 30.0f);
                instancePath2.lineTo(9.44873f, 30.0f);
                instancePath2.lineTo(9.44873f, 18.021973f);
                instancePath2.close();
                instancePath2.moveTo(11.590332f, 19.773438f);
                instancePath2.lineTo(11.590332f, 24.313965f);
                instancePath2.lineTo(13.532715f, 24.313965f);
                instancePath2.cubicTo(15.068359f, 24.313965f, 15.964844f, 23.483887f, 15.964844f, 22.03125f);
                instancePath2.cubicTo(15.964844f, 20.595215f, 15.07666f, 19.773438f, 13.541016f, 19.773438f);
                instancePath2.lineTo(11.590332f, 19.773438f);
                instancePath2.close();
                instancePath2.moveTo(19.700195f, 18.021973f);
                instancePath2.lineTo(24.074707f, 18.021973f);
                instancePath2.cubicTo(27.652344f, 18.021973f, 29.769043f, 20.188477f, 29.769043f, 23.981934f);
                instancePath2.cubicTo(29.769043f, 27.77539f, 27.660645f, 30.0f, 24.074707f, 30.0f);
                instancePath2.lineTo(19.700195f, 30.0f);
                instancePath2.lineTo(19.700195f, 18.021973f);
                instancePath2.close();
                instancePath2.moveTo(21.841797f, 19.831543f);
                instancePath2.lineTo(21.841797f, 28.19043f);
                instancePath2.lineTo(23.850586f, 28.19043f);
                instancePath2.cubicTo(26.257812f, 28.19043f, 27.585938f, 26.721191f, 27.585938f, 23.990234f);
                instancePath2.cubicTo(27.585938f, 21.309082f, 26.24121f, 19.831543f, 23.850586f, 19.831543f);
                instancePath2.lineTo(21.841797f, 19.831543f);
                instancePath2.close();
                instancePath2.moveTo(33.612305f, 30.0f);
                instancePath2.lineTo(31.470703f, 30.0f);
                instancePath2.lineTo(31.470703f, 18.021973f);
                instancePath2.lineTo(39.10742f, 18.021973f);
                instancePath2.lineTo(39.10742f, 19.831543f);
                instancePath2.lineTo(33.612305f, 19.831543f);
                instancePath2.lineTo(33.612305f, 23.367676f);
                instancePath2.lineTo(38.634277f, 23.367676f);
                instancePath2.lineTo(38.634277f, 25.11084f);
                instancePath2.lineTo(33.612305f, 25.11084f);
                instancePath2.lineTo(33.612305f, 30.0f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
