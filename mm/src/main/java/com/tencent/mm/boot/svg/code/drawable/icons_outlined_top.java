package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_top extends c {
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
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(12.707107f, 6.2218256f);
                instancePath.lineTo(18.778175f, 12.292893f);
                instancePath.cubicTo(19.1687f, 12.683417f, 19.1687f, 13.316583f, 18.778175f, 13.707107f);
                instancePath.cubicTo(18.59064f, 13.894643f, 18.336285f, 14.0f, 18.071068f, 14.0f);
                instancePath.lineTo(15.999932f, 13.999932f);
                instancePath.lineTo(16.0f, 21.0f);
                instancePath.cubicTo(16.0f, 21.552284f, 15.552284f, 22.0f, 15.0f, 22.0f);
                instancePath.lineTo(9.0f, 22.0f);
                instancePath.cubicTo(8.447715f, 22.0f, 8.0f, 21.552284f, 8.0f, 21.0f);
                instancePath.lineTo(7.9999323f, 13.999932f);
                instancePath.lineTo(5.928932f, 14.0f);
                instancePath.cubicTo(5.3766475f, 14.0f, 4.928932f, 13.552284f, 4.928932f, 13.0f);
                instancePath.cubicTo(4.928932f, 12.734783f, 5.034289f, 12.48043f, 5.2218256f, 12.292893f);
                instancePath.lineTo(11.292893f, 6.2218256f);
                instancePath.cubicTo(11.683417f, 5.831301f, 12.316583f, 5.831301f, 12.707107f, 6.2218256f);
                instancePath.close();
                instancePath.moveTo(12.0f, 7.212f);
                instancePath.lineTo(6.411f, 12.8f);
                instancePath.lineTo(9.199921f, 12.799892f);
                instancePath.lineTo(9.2f, 20.8f);
                instancePath.lineTo(14.8f, 20.8f);
                instancePath.lineTo(14.799921f, 12.799892f);
                instancePath.lineTo(17.588f, 12.8f);
                instancePath.lineTo(12.0f, 7.212f);
                instancePath.close();
                instancePath.moveTo(20.0f, 3.0f);
                instancePath.lineTo(20.0f, 4.2f);
                instancePath.lineTo(4.0f, 4.2f);
                instancePath.lineTo(4.0f, 3.0f);
                instancePath.lineTo(20.0f, 3.0f);
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
