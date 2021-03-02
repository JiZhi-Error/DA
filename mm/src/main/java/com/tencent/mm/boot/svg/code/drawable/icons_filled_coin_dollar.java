package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_coin_dollar extends c {
    private final int height = 72;
    private final int width = 72;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 72;
            case 1:
                return 72;
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
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(36.0f, 6.0f);
                instancePath.cubicTo(52.568542f, 6.0f, 66.0f, 19.431458f, 66.0f, 36.0f);
                instancePath.cubicTo(66.0f, 52.568542f, 52.568542f, 66.0f, 36.0f, 66.0f);
                instancePath.cubicTo(19.431458f, 66.0f, 6.0f, 52.568542f, 6.0f, 36.0f);
                instancePath.cubicTo(6.0f, 19.431458f, 19.431458f, 6.0f, 36.0f, 6.0f);
                instancePath.close();
                instancePath.moveTo(38.25f, 17.25f);
                instancePath.lineTo(33.75f, 17.25f);
                instancePath.lineTo(33.750156f, 21.911428f);
                instancePath.cubicTo(28.705769f, 22.645191f, 24.75f, 25.811863f, 24.75f, 30.0f);
                instancePath.cubicTo(24.75f, 34.188137f, 28.705769f, 37.35481f, 33.750156f, 38.08857f);
                instancePath.lineTo(33.750156f, 38.08857f);
                instancePath.lineTo(33.750217f, 45.5237f);
                instancePath.cubicTo(31.063194f, 44.96425f, 29.25f, 43.455738f, 29.25f, 42.0f);
                instancePath.lineTo(29.25f, 42.0f);
                instancePath.lineTo(24.75f, 42.0f);
                instancePath.cubicTo(24.75f, 46.188137f, 28.705769f, 49.35481f, 33.750156f, 50.08857f);
                instancePath.lineTo(33.750156f, 50.08857f);
                instancePath.lineTo(33.75f, 54.75f);
                instancePath.lineTo(38.25f, 54.75f);
                instancePath.lineTo(38.25084f, 50.088425f);
                instancePath.cubicTo(43.294754f, 49.35439f, 47.25f, 46.18786f, 47.25f, 42.0f);
                instancePath.cubicTo(47.25f, 37.81214f, 43.294754f, 34.64561f, 38.25084f, 33.911575f);
                instancePath.lineTo(38.25084f, 33.911575f);
                instancePath.lineTo(38.250786f, 26.476507f);
                instancePath.cubicTo(40.937256f, 27.036127f, 42.75f, 28.544443f, 42.75f, 30.0f);
                instancePath.lineTo(42.75f, 30.0f);
                instancePath.lineTo(47.25f, 30.0f);
                instancePath.cubicTo(47.25f, 25.81214f, 43.294754f, 22.645609f, 38.25084f, 21.911573f);
                instancePath.lineTo(38.25084f, 21.911573f);
                instancePath.lineTo(38.25f, 17.25f);
                instancePath.close();
                instancePath.moveTo(38.250786f, 38.47651f);
                instancePath.cubicTo(40.937256f, 39.03613f, 42.75f, 40.544445f, 42.75f, 42.0f);
                instancePath.cubicTo(42.75f, 43.455555f, 40.937256f, 44.96387f, 38.250786f, 45.52349f);
                instancePath.lineTo(38.250786f, 45.52349f);
                instancePath.close();
                instancePath.moveTo(33.750217f, 26.4763f);
                instancePath.lineTo(33.750217f, 33.5237f);
                instancePath.cubicTo(31.063194f, 32.96425f, 29.25f, 31.455738f, 29.25f, 30.0f);
                instancePath.cubicTo(29.25f, 28.544262f, 31.063194f, 27.035751f, 33.750217f, 26.4763f);
                instancePath.lineTo(33.750217f, 26.4763f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
