package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class finder_share_icon extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-436207616);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(12.0f, 2.5f);
                instancePath.lineTo(20.0f, 5.5f);
                instancePath.lineTo(20.000801f, 9.049226f);
                instancePath.cubicTo(17.133373f, 10.242318f, 11.401675f, 12.630553f, 11.401675f, 12.630553f);
                instancePath.cubicTo(11.300027f, 12.665492f, 11.190457f, 12.685315f, 11.076135f, 12.685315f);
                instancePath.cubicTo(10.883926f, 12.685315f, 10.704655f, 12.631297f, 10.555481f, 12.539613f);
                instancePath.lineTo(10.555481f, 12.539613f);
                instancePath.lineTo(8.50798f, 11.171546f);
                instancePath.cubicTo(8.454648f, 11.1343775f, 8.389434f, 11.112324f, 8.31762f, 11.112324f);
                instancePath.cubicTo(8.142308f, 11.112324f, 8.0f, 11.245636f, 8.0f, 11.4101715f);
                instancePath.cubicTo(8.0f, 11.453039f, 8.011617f, 11.497147f, 8.030363f, 11.53605f);
                instancePath.lineTo(8.030363f, 11.53605f);
                instancePath.lineTo(9.765787f, 15.109726f);
                instancePath.lineTo(9.80724f, 15.194966f);
                instancePath.cubicTo(9.916017f, 15.376846f, 10.123275f, 15.5f, 10.361688f, 15.5f);
                instancePath.cubicTo(10.464393f, 15.5f, 10.56129f, 15.476212f, 10.647361f, 15.435822f);
                instancePath.lineTo(10.647361f, 15.435822f);
                instancePath.lineTo(10.717063f, 15.397909f);
                instancePath.cubicTo(10.717063f, 15.397909f, 16.174868f, 12.443493f, 20.00113f, 10.372263f);
                instancePath.lineTo(20.0f, 11.253789f);
                instancePath.cubicTo(20.0f, 16.100143f, 16.701654f, 20.324587f, 12.0f, 21.5f);
                instancePath.cubicTo(7.298345f, 20.324587f, 4.0f, 16.100143f, 4.0f, 11.253789f);
                instancePath.lineTo(4.0f, 5.5f);
                instancePath.lineTo(12.0f, 2.5f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
