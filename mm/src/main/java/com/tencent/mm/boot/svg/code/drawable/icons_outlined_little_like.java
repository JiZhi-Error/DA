package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_little_like extends c {
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
                instancePath.moveTo(34.819805f, 19.393398f);
                instancePath.lineTo(35.978344f, 20.524906f);
                instancePath.cubicTo(36.27388f, 20.808432f, 36.594807f, 21.11334f, 36.941124f, 21.439636f);
                instancePath.lineTo(38.32817f, 20.11566f);
                instancePath.cubicTo(38.59832f, 19.85352f, 38.84308f, 19.612766f, 39.062447f, 19.393398f);
                instancePath.cubicTo(44.92031f, 13.535534f, 54.417786f, 13.535534f, 60.27565f, 19.393398f);
                instancePath.cubicTo(66.079025f, 25.196774f, 66.133f, 34.57236f, 60.4376f, 40.442192f);
                instancePath.lineTo(39.062447f, 61.819805f);
                instancePath.cubicTo(37.890934f, 62.99144f, 35.99144f, 62.99154f, 34.819805f, 61.820026f);
                instancePath.lineTo(13.443423f, 40.443424f);
                instancePath.cubicTo(7.749244f, 34.57236f, 7.803227f, 25.196774f, 13.606602f, 19.393398f);
                instancePath.cubicTo(19.464466f, 13.535534f, 28.96194f, 13.535534f, 34.819805f, 19.393398f);
                instancePath.close();
                instancePath.moveTo(57.16438f, 22.504667f);
                instancePath.cubicTo(53.024822f, 18.36511f, 46.313274f, 18.36511f, 42.173717f, 22.504667f);
                instancePath.lineTo(40.956974f, 23.693327f);
                instancePath.lineTo(39.958447f, 24.642101f);
                instancePath.lineTo(36.941124f, 27.48498f);
                instancePath.lineTo(32.925278f, 23.693327f);
                instancePath.cubicTo(32.46368f, 23.250423f, 32.058395f, 22.854528f, 31.708536f, 22.504667f);
                instancePath.cubicTo(27.568977f, 18.36511f, 20.85743f, 18.36511f, 16.71787f, 22.504667f);
                instancePath.cubicTo(12.767772f, 26.45477f, 12.58272f, 32.757175f, 16.143637f, 36.88294f);
                instancePath.lineTo(16.554708f, 37.33217f);
                instancePath.lineTo(36.939f, 57.717f);
                instancePath.lineTo(57.279762f, 37.378197f);
                instancePath.cubicTo(61.163967f, 33.375034f, 61.258965f, 27.0712f, 57.587784f, 22.95302f);
                instancePath.lineTo(57.16438f, 22.504667f);
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
