package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_finder_me extends c {
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
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(35.995f, 11.25f);
                instancePath.cubicTo(42.070133f, 11.25f, 46.995f, 16.180696f, 46.995f, 22.25057f);
                instancePath.lineTo(46.995f, 26.95301f);
                instancePath.cubicTo(46.995f, 30.085564f, 45.347565f, 34.577866f, 43.33224f, 36.966827f);
                instancePath.lineTo(42.338024f, 38.145367f);
                instancePath.cubicTo(40.71684f, 40.067116f, 41.223267f, 42.513092f, 43.49026f, 43.618904f);
                instancePath.lineTo(59.056232f, 51.211784f);
                instancePath.cubicTo(60.748302f, 52.037155f, 62.12f, 54.21922f, 62.12f, 56.117523f);
                instancePath.lineTo(62.12f, 58.0f);
                instancePath.cubicTo(62.12f, 59.518784f, 60.888783f, 60.75f, 59.37f, 60.75f);
                instancePath.lineTo(12.62f, 60.75f);
                instancePath.cubicTo(11.101217f, 60.75f, 9.87f, 59.518784f, 9.87f, 58.0f);
                instancePath.lineTo(9.87f, 56.117523f);
                instancePath.cubicTo(9.87f, 54.23353f, 11.239915f, 52.037746f, 12.933768f, 51.211166f);
                instancePath.lineTo(28.499739f, 43.615143f);
                instancePath.cubicTo(30.757288f, 42.513485f, 31.282213f, 40.07347f, 29.651974f, 38.14126f);
                instancePath.lineTo(28.65776f, 36.96288f);
                instancePath.cubicTo(26.634874f, 34.565285f, 24.995f, 30.086115f, 24.995f, 26.950548f);
                instancePath.lineTo(24.995f, 22.248846f);
                instancePath.cubicTo(24.995f, 16.17435f, 29.93223f, 11.25f, 35.995f, 11.25f);
                instancePath.close();
                instancePath.moveTo(35.995f, 14.85f);
                instancePath.cubicTo(32.078655f, 14.85f, 28.861853f, 17.907455f, 28.610775f, 21.76292f);
                instancePath.lineTo(28.595f, 22.248846f);
                instancePath.lineTo(28.595f, 26.950548f);
                instancePath.cubicTo(28.595f, 29.059021f, 29.73527f, 32.337437f, 31.071629f, 34.20531f);
                instancePath.lineTo(31.409258f, 34.6414f);
                instancePath.lineTo(32.403473f, 35.81978f);
                instancePath.cubicTo(35.43148f, 39.40868f, 34.51937f, 44.35105f, 30.533972f, 46.610653f);
                instancePath.lineTo(30.078547f, 46.850475f);
                instancePath.lineTo(14.512574f, 54.446495f);
                instancePath.cubicTo(14.113472f, 54.641254f, 13.614578f, 55.384846f, 13.49609f, 55.908707f);
                instancePath.lineTo(13.47f, 56.117523f);
                instancePath.lineTo(13.47f, 57.15f);
                instancePath.lineTo(58.518f, 57.15f);
                instancePath.lineTo(58.52f, 56.117523f);
                instancePath.cubicTo(58.52f, 55.665947f, 58.07466f, 54.897854f, 57.654907f, 54.562443f);
                instancePath.lineTo(57.47795f, 54.447372f);
                instancePath.lineTo(41.91198f, 46.854492f);
                instancePath.cubicTo(37.69424f, 44.797134f, 36.534393f, 39.905018f, 39.26672f, 36.22748f);
                instancePath.lineTo(39.586372f, 35.824074f);
                instancePath.lineTo(40.580585f, 34.645535f);
                instancePath.cubicTo(41.937996f, 33.03646f, 43.1875f, 29.784601f, 43.371696f, 27.501966f);
                instancePath.lineTo(43.395f, 26.95301f);
                instancePath.lineTo(43.395f, 22.25057f);
                instancePath.cubicTo(43.395f, 18.166672f, 40.07966f, 14.85f, 35.995f, 14.85f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
