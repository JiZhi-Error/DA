package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_unlock extends c {
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
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-436207616);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(14.8f, 9.0f);
                instancePath.lineTo(14.8f, 6.0f);
                instancePath.cubicTo(14.8f, 3.790861f, 16.59086f, 2.0f, 18.8f, 2.0f);
                instancePath.cubicTo(21.009138f, 2.0f, 22.8f, 3.7908611f, 22.8f, 6.0f);
                instancePath.lineTo(22.8f, 9.0f);
                instancePath.lineTo(21.599998f, 9.0f);
                instancePath.lineTo(21.599998f, 6.0f);
                instancePath.cubicTo(21.599997f, 4.4535995f, 20.346394f, 3.199997f, 18.799995f, 3.199997f);
                instancePath.cubicTo(17.253597f, 3.199997f, 15.999995f, 4.4535995f, 15.999995f, 5.999997f);
                instancePath.lineTo(15.999998f, 9.0f);
                instancePath.lineTo(18.999126f, 9.0f);
                instancePath.cubicTo(19.551893f, 9.0f, 19.999998f, 9.44749f, 19.999998f, 9.998503f);
                instancePath.lineTo(19.999998f, 21.0015f);
                instancePath.cubicTo(19.999998f, 21.552958f, 19.555367f, 22.000002f, 18.999126f, 22.000002f);
                instancePath.lineTo(5.0008698f, 22.000002f);
                instancePath.cubicTo(4.4481034f, 22.000002f, 3.999998f, 21.552513f, 3.999998f, 21.0015f);
                instancePath.lineTo(3.999998f, 9.998504f);
                instancePath.cubicTo(3.999998f, 9.447046f, 4.4446287f, 9.000001f, 5.0008698f, 9.000001f);
                instancePath.close();
                instancePath.moveTo(5.2f, 10.2f);
                instancePath.lineTo(5.2f, 20.8f);
                instancePath.lineTo(18.8f, 20.8f);
                instancePath.lineTo(18.8f, 10.199999f);
                instancePath.close();
                instancePath.moveTo(11.4f, 15.875187f);
                instancePath.cubicTo(10.870229f, 15.64372f, 10.5f, 15.115096f, 10.5f, 14.5f);
                instancePath.cubicTo(10.5f, 13.671573f, 11.171573f, 13.0f, 12.0f, 13.0f);
                instancePath.cubicTo(12.828427f, 13.0f, 13.5f, 13.671573f, 13.5f, 14.5f);
                instancePath.cubicTo(13.5f, 15.115096f, 13.129771f, 15.643721f, 12.599999f, 15.875187f);
                instancePath.lineTo(12.599999f, 18.0f);
                instancePath.lineTo(11.4f, 18.0f);
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
