package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_me_hl extends c {
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
                instancePaint3.setColor(-16726153);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(7.5f, 60.0f);
                instancePath.lineTo(7.5f, 57.94639f);
                instancePath.cubicTo(7.5f, 55.891125f, 8.994452f, 53.495724f, 10.842293f, 52.593998f);
                instancePath.lineTo(27.823353f, 44.30743f);
                instancePath.cubicTo(30.28613f, 43.10562f, 30.858778f, 40.443787f, 29.080336f, 38.33592f);
                instancePath.lineTo(27.995739f, 37.050415f);
                instancePath.cubicTo(25.788954f, 34.434856f, 24.0f, 29.548489f, 24.0f, 26.127872f);
                instancePath.lineTo(24.0f, 20.998741f);
                instancePath.cubicTo(24.0f, 14.37202f, 29.386068f, 9.0f, 36.0f, 9.0f);
                instancePath.cubicTo(42.62742f, 9.0f, 48.0f, 14.378941f, 48.0f, 21.000622f);
                instancePath.lineTo(48.0f, 26.130558f);
                instancePath.cubicTo(48.0f, 29.547888f, 46.202797f, 34.44858f, 44.00426f, 37.054718f);
                instancePath.lineTo(42.919662f, 38.340397f);
                instancePath.cubicTo(41.151096f, 40.43685f, 41.703564f, 43.105194f, 44.176647f, 44.31153f);
                instancePath.lineTo(61.157707f, 52.594673f);
                instancePath.cubicTo(63.003605f, 53.49508f, 64.5f, 55.87551f, 64.5f, 57.94639f);
                instancePath.lineTo(64.5f, 60.0f);
                instancePath.cubicTo(64.5f, 61.656853f, 63.156853f, 63.0f, 61.5f, 63.0f);
                instancePath.lineTo(10.5f, 63.0f);
                instancePath.cubicTo(8.843145f, 63.0f, 7.5f, 61.656853f, 7.5f, 60.0f);
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
