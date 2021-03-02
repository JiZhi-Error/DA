package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_sound extends c {
    private final int height = 24;
    private final int width = 24;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 24;
            case 1:
                return 24;
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
                instancePaint3.setColor(-436207616);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(9.6f, 5.0f);
                instancePath.cubicTo(10.152285f, 5.0f, 10.6f, 5.4477153f, 10.6f, 6.0f);
                instancePath.lineTo(10.6f, 18.0f);
                instancePath.cubicTo(10.6f, 18.552284f, 10.152285f, 19.0f, 9.6f, 19.0f);
                instancePath.cubicTo(9.047715f, 19.0f, 8.6f, 18.552284f, 8.6f, 18.0f);
                instancePath.lineTo(8.6f, 6.0f);
                instancePath.cubicTo(8.6f, 5.4477153f, 9.047715f, 5.0f, 9.6f, 5.0f);
                instancePath.close();
                instancePath.moveTo(18.4f, 8.0f);
                instancePath.cubicTo(18.952284f, 8.0f, 19.4f, 8.447715f, 19.4f, 9.0f);
                instancePath.lineTo(19.4f, 15.0f);
                instancePath.cubicTo(19.4f, 15.552284f, 18.952284f, 16.0f, 18.4f, 16.0f);
                instancePath.cubicTo(17.847715f, 16.0f, 17.4f, 15.552284f, 17.4f, 15.0f);
                instancePath.lineTo(17.4f, 9.0f);
                instancePath.cubicTo(17.4f, 8.447715f, 17.847715f, 8.0f, 18.4f, 8.0f);
                instancePath.close();
                instancePath.moveTo(5.2f, 8.0f);
                instancePath.cubicTo(5.7522845f, 8.0f, 6.2f, 8.447715f, 6.2f, 9.0f);
                instancePath.lineTo(6.2f, 15.0f);
                instancePath.cubicTo(6.2f, 15.552284f, 5.7522845f, 16.0f, 5.2f, 16.0f);
                instancePath.cubicTo(4.647715f, 16.0f, 4.2f, 15.552284f, 4.2f, 15.0f);
                instancePath.lineTo(4.2f, 9.0f);
                instancePath.cubicTo(4.2f, 8.447715f, 4.647715f, 8.0f, 5.2f, 8.0f);
                instancePath.close();
                instancePath.moveTo(14.0f, 9.0f);
                instancePath.cubicTo(14.552284f, 9.0f, 15.0f, 9.447715f, 15.0f, 10.0f);
                instancePath.lineTo(15.0f, 14.0f);
                instancePath.cubicTo(15.0f, 14.552284f, 14.552284f, 15.0f, 14.0f, 15.0f);
                instancePath.cubicTo(13.447716f, 15.0f, 13.0f, 14.552284f, 13.0f, 14.0f);
                instancePath.lineTo(13.0f, 10.0f);
                instancePath.cubicTo(13.0f, 9.447715f, 13.447716f, 9.0f, 14.0f, 9.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
