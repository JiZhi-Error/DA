package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class bottomsheet_icon_blacklist extends c {
    private final int height = 96;
    private final int width = 96;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                instancePaint3.setColor(-8683387);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(48.0f, 80.0f);
                instancePath.cubicTo(40.60533f, 80.0f, 33.802223f, 77.48534f, 28.383556f, 73.27333f);
                instancePath.lineTo(73.27333f, 28.383556f);
                instancePath.cubicTo(77.48534f, 33.802223f, 80.0f, 40.60533f, 80.0f, 48.0f);
                instancePath.cubicTo(80.0f, 65.67289f, 65.67289f, 80.0f, 48.0f, 80.0f);
                instancePath.moveTo(16.0f, 48.0f);
                instancePath.cubicTo(16.0f, 30.326666f, 30.326666f, 16.0f, 48.0f, 16.0f);
                instancePath.cubicTo(55.39467f, 16.0f, 62.197777f, 18.514668f, 67.61645f, 22.726667f);
                instancePath.lineTo(22.726667f, 67.61645f);
                instancePath.cubicTo(18.514668f, 62.197777f, 16.0f, 55.39467f, 16.0f, 48.0f);
                instancePath.moveTo(70.627556f, 25.372889f);
                instancePath.lineTo(70.62711f, 25.372444f);
                instancePath.lineTo(70.627556f, 25.372889f);
                instancePath.moveTo(48.0f, 8.0f);
                instancePath.cubicTo(25.908443f, 8.0f, 8.0f, 25.908443f, 8.0f, 48.0f);
                instancePath.cubicTo(8.0f, 70.09155f, 25.908443f, 88.0f, 48.0f, 88.0f);
                instancePath.cubicTo(70.09155f, 88.0f, 88.0f, 70.09155f, 88.0f, 48.0f);
                instancePath.cubicTo(88.0f, 25.908443f, 70.09155f, 8.0f, 48.0f, 8.0f);
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
