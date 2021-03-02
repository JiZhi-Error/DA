package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_pay_minifund extends c {
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
                instancePath.moveTo(19.604445f, 26.17499f);
                instancePath.lineTo(36.0f, 66.0f);
                instancePath.lineTo(6.2137012f, 27.233997f);
                instancePath.cubicTo(5.992266f, 26.945807f, 6.0463824f, 26.532673f, 6.334574f, 26.311237f);
                instancePath.cubicTo(6.44956f, 26.222887f, 6.590509f, 26.17499f, 6.735518f, 26.17499f);
                instancePath.lineTo(19.604445f, 26.17499f);
                instancePath.close();
                instancePath.moveTo(65.26448f, 26.17499f);
                instancePath.cubicTo(65.40949f, 26.17499f, 65.55044f, 26.222887f, 65.66543f, 26.311237f);
                instancePath.cubicTo(65.95362f, 26.532673f, 66.00774f, 26.945807f, 65.7863f, 27.233997f);
                instancePath.lineTo(65.7863f, 27.233997f);
                instancePath.lineTo(36.0f, 66.0f);
                instancePath.lineTo(52.697777f, 26.17499f);
                instancePath.close();
                instancePath.moveTo(47.9f, 26.17499f);
                instancePath.lineTo(36.0f, 66.0f);
                instancePath.lineTo(24.1f, 26.17499f);
                instancePath.lineTo(47.9f, 26.17499f);
                instancePath.close();
                instancePath.moveTo(29.2f, 12.0f);
                instancePath.lineTo(19.927273f, 22.125f);
                instancePath.lineTo(7.422167f, 22.125f);
                instancePath.cubicTo(7.211729f, 22.125f, 7.0139832f, 22.024357f, 6.8901353f, 21.854223f);
                instancePath.cubicTo(6.6762424f, 21.56039f, 6.7410464f, 21.148798f, 7.034879f, 20.934904f);
                instancePath.lineTo(7.034879f, 20.934904f);
                instancePath.lineTo(19.135954f, 12.126033f);
                instancePath.cubicTo(19.248474f, 12.044126f, 19.384068f, 12.0f, 19.523241f, 12.0f);
                instancePath.lineTo(19.523241f, 12.0f);
                instancePath.lineTo(29.2f, 12.0f);
                instancePath.close();
                instancePath.moveTo(39.4f, 12.0f);
                instancePath.lineTo(47.9f, 22.125f);
                instancePath.lineTo(24.1f, 22.125f);
                instancePath.lineTo(32.6f, 12.0f);
                instancePath.lineTo(39.4f, 12.0f);
                instancePath.close();
                instancePath.moveTo(51.51333f, 12.0f);
                instancePath.cubicTo(51.65526f, 12.0f, 51.793385f, 12.045888f, 51.9071f, 12.130816f);
                instancePath.lineTo(63.70182f, 20.939688f);
                instancePath.cubicTo(63.99301f, 21.157164f, 64.05277f, 21.569519f, 63.835293f, 21.86071f);
                instancePath.cubicTo(63.71107f, 22.02704f, 63.515644f, 22.125f, 63.308044f, 22.125f);
                instancePath.lineTo(51.43068f, 22.125f);
                instancePath.lineTo(41.488907f, 12.0f);
                instancePath.lineTo(51.51333f, 12.0f);
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
