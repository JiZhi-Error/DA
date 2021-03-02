package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_contacts_hl extends c {
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
                instancePath.moveTo(3.0f, 60.0f);
                instancePath.lineTo(3.0f, 57.94639f);
                instancePath.cubicTo(3.0f, 55.891125f, 4.494453f, 53.495724f, 6.342293f, 52.593998f);
                instancePath.lineTo(23.323353f, 44.30743f);
                instancePath.cubicTo(25.78613f, 43.10562f, 26.358778f, 40.443787f, 24.580336f, 38.33592f);
                instancePath.lineTo(23.495739f, 37.050415f);
                instancePath.cubicTo(21.288954f, 34.434856f, 19.5f, 29.548489f, 19.5f, 26.127872f);
                instancePath.lineTo(19.5f, 20.998741f);
                instancePath.cubicTo(19.5f, 14.37202f, 24.886068f, 9.0f, 31.5f, 9.0f);
                instancePath.cubicTo(38.12742f, 9.0f, 43.5f, 14.378941f, 43.5f, 21.000622f);
                instancePath.lineTo(43.5f, 26.130558f);
                instancePath.cubicTo(43.5f, 29.547888f, 41.702797f, 34.44858f, 39.50426f, 37.054718f);
                instancePath.lineTo(38.419662f, 38.340397f);
                instancePath.cubicTo(36.651096f, 40.43685f, 37.203564f, 43.105194f, 39.676647f, 44.31153f);
                instancePath.lineTo(56.657707f, 52.594673f);
                instancePath.cubicTo(58.503605f, 53.49508f, 60.0f, 55.87551f, 60.0f, 57.94639f);
                instancePath.lineTo(60.0f, 60.0f);
                instancePath.cubicTo(60.0f, 61.656853f, 58.656853f, 63.0f, 57.0f, 63.0f);
                instancePath.lineTo(6.0f, 63.0f);
                instancePath.cubicTo(4.343146f, 63.0f, 3.0f, 61.656853f, 3.0f, 60.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(60.0f, 43.5f);
                instancePath2.lineTo(69.0f, 43.5f);
                instancePath2.lineTo(69.0f, 47.1f);
                instancePath2.lineTo(60.0f, 47.1f);
                instancePath2.lineTo(60.0f, 43.5f);
                instancePath2.close();
                instancePath2.moveTo(54.0f, 34.5f);
                instancePath2.lineTo(69.0f, 34.5f);
                instancePath2.lineTo(69.0f, 38.1f);
                instancePath2.lineTo(54.0f, 38.1f);
                instancePath2.lineTo(54.0f, 34.5f);
                instancePath2.close();
                instancePath2.moveTo(48.0f, 25.5f);
                instancePath2.lineTo(69.0f, 25.5f);
                instancePath2.lineTo(69.0f, 29.1f);
                instancePath2.lineTo(48.0f, 29.1f);
                instancePath2.lineTo(48.0f, 25.5f);
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
