package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class finder_feed_discomment extends c {
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
                Matrix instanceMatrix = c.instanceMatrix(looper);
                float[] instanceMatrixArray = c.instanceMatrixArray(looper);
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 3.0f, 0.0f, 1.0f, 3.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.55863357f, 2.2561524f);
                instancePath.lineTo(1.503f, 3.2f);
                instancePath.lineTo(1.35f, 3.2f);
                instancePath.cubicTo(1.2671573f, 3.2f, 1.2f, 3.2671573f, 1.2f, 3.35f);
                instancePath.lineTo(1.1986467f, 14.24041f);
                instancePath.lineTo(1.2007385f, 14.313252f);
                instancePath.cubicTo(1.207889f, 14.388082f, 1.2727705f, 14.447385f, 1.3498533f, 14.447385f);
                instancePath.lineTo(5.6981726f, 14.446854f);
                instancePath.lineTo(5.6994967f, 16.367403f);
                instancePath.lineTo(7.5979095f, 14.446978f);
                instancePath.lineTo(12.75f, 14.447f);
                instancePath.lineTo(13.95f, 15.647f);
                instancePath.lineTo(8.099f, 15.647f);
                instancePath.lineTo(6.0398417f, 17.730036f);
                instancePath.cubicTo(5.6902833f, 18.08341f, 5.120443f, 18.086504f, 4.7670684f, 17.736944f);
                instancePath.cubicTo(4.5961676f, 17.56789f, 4.5f, 17.337492f, 4.5f, 17.097103f);
                instancePath.lineTo(4.499f, 15.647f);
                instancePath.lineTo(1.35f, 15.647385f);
                instancePath.cubicTo(0.64827347f, 15.647385f, 0.07159619f, 15.111986f, 0.0061799204f, 14.427399f);
                instancePath.lineTo(0.0f, 14.297385f);
                instancePath.lineTo(0.0f, 3.35f);
                instancePath.cubicTo(0.0f, 2.900018f, 0.22015701f, 2.5014563f, 0.55863357f, 2.2561524f);
                instancePath.close();
                instancePath.moveTo(1.6970569f, 0.0f);
                instancePath.lineTo(3.697f, 2.0f);
                instancePath.lineTo(16.65f, 2.0f);
                instancePath.cubicTo(17.351727f, 2.0f, 17.928404f, 2.5353992f, 17.99382f, 3.219986f);
                instancePath.lineTo(18.0f, 3.35f);
                instancePath.lineTo(18.0f, 14.297385f);
                instancePath.cubicTo(18.0f, 14.839593f, 17.680351f, 15.307143f, 17.219215f, 15.521871f);
                instancePath.lineTo(18.424978f, 16.727922f);
                instancePath.lineTo(17.57645f, 17.57645f);
                instancePath.lineTo(3.2f, 3.2f);
                instancePath.lineTo(2.0f, 2.0f);
                instancePath.lineTo(0.8485287f, 0.84852815f);
                instancePath.lineTo(1.6970569f, 0.0f);
                instancePath.close();
                instancePath.moveTo(16.144f, 14.447f);
                instancePath.lineTo(16.65f, 14.447385f);
                instancePath.cubicTo(16.732843f, 14.447385f, 16.8f, 14.380228f, 16.8f, 14.297385f);
                instancePath.lineTo(16.8f, 3.35f);
                instancePath.cubicTo(16.8f, 3.2671573f, 16.732843f, 3.2f, 16.65f, 3.2f);
                instancePath.lineTo(4.897f, 3.2f);
                instancePath.lineTo(16.144f, 14.447f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
