package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_documentation extends c {
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
                instancePath.moveTo(19.0f, 2.0f);
                instancePath.cubicTo(19.552284f, 2.0f, 20.0f, 2.4477153f, 20.0f, 3.0f);
                instancePath.lineTo(20.0f, 21.001354f);
                instancePath.cubicTo(20.0f, 21.55423f, 19.554161f, 22.0f, 19.004192f, 22.0f);
                instancePath.lineTo(5.9958086f, 22.0f);
                instancePath.cubicTo(5.4489202f, 22.0f, 5.0f, 21.55289f, 5.0f, 21.001354f);
                instancePath.lineTo(5.0f, 2.9986458f);
                instancePath.cubicTo(5.0f, 2.44577f, 5.4458385f, 2.0f, 5.9958086f, 2.0f);
                instancePath.lineTo(19.0f, 2.0f);
                instancePath.close();
                instancePath.moveTo(13.0f, 13.0f);
                instancePath.lineTo(8.0f, 13.0f);
                instancePath.lineTo(8.0f, 14.5f);
                instancePath.lineTo(13.0f, 14.5f);
                instancePath.lineTo(13.0f, 13.0f);
                instancePath.close();
                instancePath.moveTo(17.0f, 9.0f);
                instancePath.lineTo(8.0f, 9.0f);
                instancePath.lineTo(8.0f, 10.5f);
                instancePath.lineTo(17.0f, 10.5f);
                instancePath.lineTo(17.0f, 9.0f);
                instancePath.close();
                instancePath.moveTo(17.0f, 5.0f);
                instancePath.lineTo(8.0f, 5.0f);
                instancePath.lineTo(8.0f, 6.5f);
                instancePath.lineTo(17.0f, 6.5f);
                instancePath.lineTo(17.0f, 5.0f);
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
