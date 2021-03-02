package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_mini_program extends c {
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
                instancePath.moveTo(62.55f, 25.413738f);
                instancePath.cubicTo(62.55f, 18.25061f, 56.113007f, 12.45f, 48.148563f, 12.45f);
                instancePath.cubicTo(40.184116f, 12.45f, 33.747124f, 18.25061f, 33.747124f, 25.413738f);
                instancePath.lineTo(33.747124f, 46.979233f);
                instancePath.cubicTo(33.747124f, 51.74834f, 29.256884f, 55.58099f, 23.707668f, 55.58099f);
                instancePath.cubicTo(18.158451f, 55.58099f, 13.668211f, 51.74834f, 13.668211f, 46.979233f);
                instancePath.cubicTo(13.668211f, 43.16366f, 16.61802f, 39.82672f, 20.834455f, 38.808975f);
                instancePath.cubicTo(22.039108f, 38.507828f, 23.166615f, 37.616833f, 23.598444f, 36.611534f);
                instancePath.cubicTo(23.658064f, 36.493694f, 23.69515f, 36.384315f, 23.713804f, 36.27239f);
                instancePath.cubicTo(23.728848f, 36.182133f, 23.732689f, 36.109043f, 23.73211f, 35.908947f);
                instancePath.cubicTo(23.73211f, 34.97101f, 22.928375f, 34.303036f, 21.69489f, 34.303036f);
                instancePath.lineTo(21.187166f, 34.297966f);
                instancePath.cubicTo(14.425144f, 35.321667f, 9.45f, 40.70184f, 9.45f, 46.979233f);
                instancePath.cubicTo(9.45f, 54.14236f, 15.886992f, 59.94297f, 23.851439f, 59.94297f);
                instancePath.cubicTo(31.815884f, 59.94297f, 38.252876f, 54.14236f, 38.252876f, 46.979233f);
                instancePath.lineTo(38.252876f, 25.413738f);
                instancePath.cubicTo(38.252876f, 20.64463f, 42.743114f, 16.811981f, 48.29233f, 16.811981f);
                instancePath.cubicTo(53.84155f, 16.811981f, 58.33179f, 20.64463f, 58.33179f, 25.413738f);
                instancePath.cubicTo(58.33179f, 29.344591f, 55.412464f, 32.702663f, 51.154003f, 33.73049f);
                instancePath.cubicTo(49.91159f, 34.00651f, 48.8674f, 34.840534f, 48.411232f, 35.904827f);
                instancePath.cubicTo(47.841995f, 37.18553f, 48.673428f, 38.233707f, 50.3003f, 38.23373f);
                instancePath.lineTo(50.920006f, 38.227108f);
                instancePath.cubicTo(57.70792f, 37.031017f, 62.55f, 31.720058f, 62.55f, 25.413738f);
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
