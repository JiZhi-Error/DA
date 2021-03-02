package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class translation_icon_loading extends c {
    private final int height = 34;
    private final int width = 34;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 34;
            case 1:
                return 34;
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-1);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(13.0f, 0.0f);
                instancePath.lineTo(21.0f, 0.0f);
                instancePath.cubicTo(27.69f, 0.44f, 33.42f, 6.1f, 34.0f, 13.0f);
                instancePath.lineTo(34.0f, 21.0f);
                instancePath.cubicTo(33.56f, 27.72f, 27.92f, 33.41f, 21.0f, 34.0f);
                instancePath.lineTo(13.0f, 34.0f);
                instancePath.cubicTo(6.3f, 33.58f, 0.58f, 27.91f, 0.0f, 21.0f);
                instancePath.lineTo(0.0f, 13.0f);
                instancePath.cubicTo(0.44f, 6.3f, 6.1f, 0.62f, 13.0f, 0.0f);
                instancePath.lineTo(13.0f, 0.0f);
                instancePath.close();
                instancePath.moveTo(11.0f, 4.0f);
                instancePath.cubicTo(6.2619376f, 5.2345805f, 2.7374582f, 10.576861f, 3.0f, 16.0f);
                instancePath.cubicTo(2.4991837f, 21.251474f, 4.504662f, 27.081224f, 9.0f, 30.0f);
                instancePath.cubicTo(12.725139f, 31.349081f, 16.597101f, 31.030733f, 20.0f, 31.0f);
                instancePath.cubicTo(25.691252f, 30.483572f, 30.4766f, 25.668554f, 31.0f, 20.0f);
                instancePath.cubicTo(31.181498f, 15.700277f, 31.231138f, 10.626603f, 28.0f, 7.0f);
                instancePath.cubicTo(23.973688f, 2.3992918f, 17.004154f, 2.5186725f, 11.0f, 4.0f);
                instancePath.lineTo(11.0f, 4.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(15.0f, 6.0f);
                instancePath2.cubicTo(16.379942f, 5.8667493f, 17.790102f, 5.85669f, 19.0f, 6.0f);
                instancePath2.cubicTo(19.059246f, 9.588673f, 19.079391f, 12.747278f, 19.0f, 16.0f);
                instancePath2.cubicTo(21.940002f, 15.9260025f, 24.79054f, 15.9260025f, 28.0f, 16.0f);
                instancePath2.cubicTo(28.124561f, 17.243765f, 28.124561f, 18.642f, 28.0f, 20.0f);
                instancePath2.cubicTo(23.410599f, 19.647926f, 19.089464f, 20.5432f, 15.0f, 19.0f);
                instancePath2.cubicTo(15.100726f, 15.040789f, 15.090653f, 10.715309f, 15.0f, 6.0f);
                instancePath2.lineTo(15.0f, 6.0f);
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
