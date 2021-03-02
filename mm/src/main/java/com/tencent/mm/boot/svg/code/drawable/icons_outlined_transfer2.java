package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_transfer2 extends c {
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
                instancePath.moveTo(36.0f, 66.0f);
                instancePath.cubicTo(19.431458f, 66.0f, 6.0f, 52.568542f, 6.0f, 36.0f);
                instancePath.cubicTo(6.0f, 19.431458f, 19.431458f, 6.0f, 36.0f, 6.0f);
                instancePath.cubicTo(52.568542f, 6.0f, 66.0f, 19.431458f, 66.0f, 36.0f);
                instancePath.cubicTo(66.0f, 52.568542f, 52.568542f, 66.0f, 36.0f, 66.0f);
                instancePath.close();
                instancePath.moveTo(36.0f, 62.4f);
                instancePath.cubicTo(50.58032f, 62.4f, 62.4f, 50.58032f, 62.4f, 36.0f);
                instancePath.cubicTo(62.4f, 21.419683f, 50.58032f, 9.6f, 36.0f, 9.6f);
                instancePath.cubicTo(21.419683f, 9.6f, 9.6f, 21.419683f, 9.6f, 36.0f);
                instancePath.cubicTo(9.6f, 50.58032f, 21.419683f, 62.4f, 36.0f, 62.4f);
                instancePath.close();
                instancePath.moveTo(29.369705f, 29.771019f);
                instancePath.lineTo(51.0f, 29.771019f);
                instancePath.lineTo(51.0f, 33.37102f);
                instancePath.lineTo(27.0f, 33.37102f);
                instancePath.lineTo(22.637648f, 33.371017f);
                instancePath.cubicTo(21.80922f, 33.371017f, 21.137648f, 32.699448f, 21.137648f, 31.87102f);
                instancePath.cubicTo(21.137648f, 31.427069f, 21.334305f, 31.005924f, 21.674694f, 30.720922f);
                instancePath.lineTo(31.158936f, 22.779951f);
                instancePath.cubicTo(31.66708f, 22.354492f, 32.423916f, 22.421522f, 32.849377f, 22.929667f);
                instancePath.cubicTo(33.18954f, 23.335938f, 33.222973f, 23.917223f, 32.931637f, 24.359818f);
                instancePath.lineTo(29.369705f, 29.771019f);
                instancePath.close();
                instancePath.moveTo(42.767944f, 42.24f);
                instancePath.lineTo(21.137648f, 42.24f);
                instancePath.lineTo(21.137648f, 38.64f);
                instancePath.lineTo(45.137646f, 38.64f);
                instancePath.lineTo(49.5f, 38.64f);
                instancePath.cubicTo(50.328426f, 38.64f, 51.0f, 39.311573f, 51.0f, 40.14f);
                instancePath.cubicTo(51.0f, 40.58395f, 50.803345f, 41.005096f, 50.46295f, 41.290096f);
                instancePath.lineTo(40.97871f, 49.231068f);
                instancePath.cubicTo(40.470566f, 49.65653f, 39.71373f, 49.5895f, 39.288273f, 49.081352f);
                instancePath.cubicTo(38.94811f, 48.675083f, 38.914673f, 48.093796f, 39.206013f, 47.651203f);
                instancePath.lineTo(42.767944f, 42.24f);
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
