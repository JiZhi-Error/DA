package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_magic extends c {
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
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(72.0f, 0.0f);
                instancePath.lineTo(72.0f, 72.0f);
                instancePath.lineTo(0.0f, 72.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-436207616);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(43.920025f, 10.000783f);
                instancePath2.cubicTo(44.19481f, 10.4123f, 44.32627f, 10.902925f, 44.29406f, 11.396701f);
                instancePath2.lineTo(43.52095f, 23.248135f);
                instancePath2.lineTo(52.845592f, 30.603762f);
                instancePath2.cubicTo(53.821224f, 31.373375f, 53.98823f, 32.788174f, 53.21862f, 33.7638f);
                instancePath2.cubicTo(52.912155f, 34.1523f, 52.486168f, 34.42894f, 52.006603f, 34.55089f);
                instancePath2.lineTo(43.085f, 36.819f);
                instancePath2.lineTo(61.36119f, 57.843174f);
                instancePath2.cubicTo(61.90469f, 58.468395f, 61.83844f, 59.41583f, 61.213215f, 59.959328f);
                instancePath2.lineTo(59.85474f, 61.140232f);
                instancePath2.cubicTo(59.22952f, 61.68373f, 58.28208f, 61.61748f, 57.738586f, 60.99226f);
                instancePath2.lineTo(39.542f, 40.06f);
                instancePath2.lineTo(36.382175f, 48.619194f);
                instancePath2.cubicTo(35.951714f, 49.784897f, 34.657772f, 50.380928f, 33.49207f, 49.950466f);
                instancePath2.cubicTo(33.02788f, 49.779057f, 32.633144f, 49.459404f, 32.36897f, 49.040997f);
                instancePath2.lineTo(26.028326f, 38.998566f);
                instancePath2.lineTo(14.161004f, 38.528625f);
                instancePath2.cubicTo(12.919337f, 38.479458f, 11.952626f, 37.433025f, 12.001796f, 36.19136f);
                instancePath2.cubicTo(12.021375f, 35.69692f, 12.203402f, 35.222725f, 12.519695f, 34.842186f);
                instancePath2.lineTo(20.11125f, 25.708593f);
                instancePath2.lineTo(16.890985f, 14.27688f);
                instancePath2.cubicTo(16.554052f, 13.0807905f, 17.250536f, 11.838029f, 18.446627f, 11.501096f);
                instancePath2.cubicTo(18.922916f, 11.366927f, 19.430151f, 11.39351f, 19.889807f, 11.576729f);
                instancePath2.lineTo(30.922287f, 15.974293f);
                instancePath2.lineTo(40.799377f, 9.379045f);
                instancePath2.cubicTo(41.832806f, 8.68899f, 43.22997f, 8.967351f, 43.920025f, 10.000783f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint3);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
