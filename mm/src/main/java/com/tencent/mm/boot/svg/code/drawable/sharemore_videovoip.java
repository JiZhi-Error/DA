package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class sharemore_videovoip extends c {
    private final int height = 54;
    private final int width = 54;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 54;
            case 1:
                return 54;
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
                instancePath.moveTo(35.48387f, 28.66256f);
                instancePath.lineTo(35.48387f, 37.66291f);
                instancePath.cubicTo(35.48387f, 38.4582f, 34.83916f, 39.10291f, 34.043873f, 39.10291f);
                instancePath.lineTo(6.44f, 39.10291f);
                instancePath.cubicTo(5.64471f, 39.10291f, 5.0f, 38.4582f, 5.0f, 37.66291f);
                instancePath.lineTo(5.0f, 16.157227f);
                instancePath.cubicTo(5.0f, 15.361936f, 5.64471f, 14.717226f, 6.44f, 14.717226f);
                instancePath.lineTo(34.043873f, 14.717226f);
                instancePath.cubicTo(34.83916f, 14.717226f, 35.48387f, 15.361936f, 35.48387f, 16.157227f);
                instancePath.lineTo(35.48387f, 25.287582f);
                instancePath.cubicTo(38.18783f, 22.945694f, 46.986294f, 14.808152f, 47.822582f, 14.082182f);
                instancePath.cubicTo(48.88459f, 13.782787f, 50.0f, 14.307455f, 50.0f, 15.557618f);
                instancePath.lineTo(50.0f, 38.42688f);
                instancePath.cubicTo(50.0f, 39.543766f, 48.99135f, 40.27374f, 47.822582f, 39.902317f);
                instancePath.cubicTo(47.261726f, 39.311028f, 38.312565f, 31.01308f, 35.48387f, 28.66256f);
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
