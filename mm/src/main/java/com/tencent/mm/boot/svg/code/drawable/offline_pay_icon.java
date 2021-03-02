package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class offline_pay_icon extends c {
    private final int height = 73;
    private final int width = 68;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 68;
            case 1:
                return 73;
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
                canvas.saveLayerAlpha(null, 230, 31);
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-12414890);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(19.8f, 13.5f);
                instancePath.lineTo(7.014761f, 13.5f);
                instancePath.cubicTo(5.1207285f, 13.5f, 3.6f, 15.027811f, 3.6f, 16.91246f);
                instancePath.lineTo(3.6f, 29.7f);
                instancePath.lineTo(7.2f, 29.7f);
                instancePath.lineTo(7.2f, 20.517391f);
                instancePath.cubicTo(7.2f, 18.630018f, 8.731914f, 17.1f, 10.622746f, 17.1f);
                instancePath.lineTo(19.8f, 17.1f);
                instancePath.lineTo(19.8f, 13.5f);
                instancePath.close();
                instancePath.moveTo(47.7f, 13.5f);
                instancePath.lineTo(60.485237f, 13.5f);
                instancePath.cubicTo(62.37116f, 13.5f, 63.9f, 15.027175f, 63.9f, 16.91246f);
                instancePath.lineTo(63.9f, 29.7f);
                instancePath.lineTo(60.3f, 29.7f);
                instancePath.lineTo(60.3f, 20.517391f);
                instancePath.cubicTo(60.3f, 18.629005f, 58.767586f, 17.1f, 56.877254f, 17.1f);
                instancePath.lineTo(47.7f, 17.1f);
                instancePath.lineTo(47.7f, 13.5f);
                instancePath.close();
                instancePath.moveTo(63.9f, 43.2f);
                instancePath.lineTo(63.9f, 55.987537f);
                instancePath.cubicTo(63.9f, 57.87219f, 62.379272f, 59.4f, 60.485237f, 59.4f);
                instancePath.lineTo(47.7f, 59.4f);
                instancePath.lineTo(47.7f, 55.8f);
                instancePath.lineTo(56.877254f, 55.8f);
                instancePath.cubicTo(58.768085f, 55.8f, 60.3f, 54.26998f, 60.3f, 52.38261f);
                instancePath.lineTo(60.3f, 43.2f);
                instancePath.lineTo(63.9f, 43.2f);
                instancePath.close();
                instancePath.moveTo(19.8f, 59.4f);
                instancePath.lineTo(7.014761f, 59.4f);
                instancePath.cubicTo(5.1288404f, 59.4f, 3.6f, 57.872826f, 3.6f, 55.987537f);
                instancePath.lineTo(3.6f, 43.2f);
                instancePath.lineTo(7.2f, 43.2f);
                instancePath.lineTo(7.2f, 52.38261f);
                instancePath.cubicTo(7.2f, 54.270996f, 8.732416f, 55.8f, 10.622746f, 55.8f);
                instancePath.lineTo(19.8f, 55.8f);
                instancePath.lineTo(19.8f, 59.4f);
                instancePath.close();
                instancePath.moveTo(20.108116f, 36.142143f);
                instancePath.cubicTo(19.937948f, 35.946686f, 19.946568f, 35.64093f, 20.131533f, 35.45503f);
                instancePath.lineTo(20.838032f, 34.74497f);
                instancePath.cubicTo(21.021133f, 34.560947f, 21.341198f, 34.526764f, 21.565907f, 34.677326f);
                instancePath.lineTo(28.990614f, 39.65209f);
                instancePath.cubicTo(29.209509f, 39.79875f, 29.55232f, 39.78469f, 29.761065f, 39.61685f);
                instancePath.lineTo(49.556328f, 23.700794f);
                instancePath.cubicTo(49.76294f, 23.53467f, 50.077003f, 23.547306f, 50.261967f, 23.733206f);
                instancePath.lineTo(50.968468f, 24.443266f);
                instancePath.cubicTo(51.151566f, 24.627289f, 51.159294f, 24.928797f, 50.980556f, 25.12167f);
                instancePath.cubicTo(50.980556f, 25.12167f, 44.03342f, 32.66838f, 40.34348f, 35.788235f);
                instancePath.cubicTo(37.325737f, 39.566574f, 29.73397f, 46.481808f, 29.73397f, 46.481808f);
                instancePath.cubicTo(29.54232f, 46.65754f, 29.251432f, 46.644333f, 29.07884f, 46.44609f);
                instancePath.lineTo(20.108116f, 36.142143f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
