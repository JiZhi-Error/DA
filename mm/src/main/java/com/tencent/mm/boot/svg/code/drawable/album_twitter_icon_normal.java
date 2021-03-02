package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class album_twitter_icon_normal extends c {
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
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 3.0f, 0.0f, 1.0f, 3.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(15.75f, 0.0f);
                instancePath.cubicTo(16.992f, 0.0f, 18.0f, 1.008f, 18.0f, 2.25f);
                instancePath.lineTo(18.0f, 15.75f);
                instancePath.cubicTo(18.0f, 16.992f, 16.992f, 18.0f, 15.75f, 18.0f);
                instancePath.lineTo(2.25f, 18.0f);
                instancePath.cubicTo(1.008f, 18.0f, 0.0f, 16.992f, 0.0f, 15.75f);
                instancePath.lineTo(0.0f, 2.25f);
                instancePath.cubicTo(0.0f, 1.008f, 1.008f, 0.0f, 2.25f, 0.0f);
                instancePath.lineTo(15.75f, 0.0f);
                instancePath.close();
                instancePath.moveTo(11.1645f, 4.428f);
                instancePath.cubicTo(9.891f, 4.428f, 8.856f, 5.463f, 8.856f, 6.7365f);
                instancePath.cubicTo(8.856f, 6.9165f, 8.8785f, 7.092f, 8.9145f, 7.263f);
                instancePath.cubicTo(6.9975f, 7.1685f, 5.2965f, 6.246f, 4.158f, 4.851f);
                instancePath.cubicTo(3.96f, 5.193f, 3.8475f, 5.589f, 3.8475f, 6.012f);
                instancePath.cubicTo(3.8475f, 6.813f, 4.257f, 7.5195f, 4.8735f, 7.9335f);
                instancePath.cubicTo(4.4955f, 7.92f, 4.14f, 7.8165f, 3.8295f, 7.6455f);
                instancePath.lineTo(3.8295f, 7.677f);
                instancePath.lineTo(3.8295f, 7.677f);
                instancePath.cubicTo(3.8295f, 8.793f, 4.626f, 9.729f, 5.679f, 9.9405f);
                instancePath.cubicTo(5.4855f, 9.9945f, 5.283f, 10.0215f, 5.0715f, 10.0215f);
                instancePath.cubicTo(4.923f, 10.0215f, 4.779f, 10.008f, 4.6395f, 9.981f);
                instancePath.cubicTo(4.932f, 10.899f, 5.787f, 11.565f, 6.795f, 11.583f);
                instancePath.cubicTo(6.003f, 12.204f, 5.0085f, 12.573f, 3.9285f, 12.573f);
                instancePath.cubicTo(3.744f, 12.573f, 3.5595f, 12.564f, 3.3795f, 12.5415f);
                instancePath.cubicTo(4.3965f, 13.1895f, 5.6115f, 13.572f, 6.912f, 13.572f);
                instancePath.cubicTo(11.1555f, 13.572f, 13.4775f, 10.053f, 13.4775f, 7.0065f);
                instancePath.cubicTo(13.4775f, 6.9075f, 13.4775f, 6.8085f, 13.473f, 6.7095f);
                instancePath.cubicTo(13.923f, 6.3855f, 14.3145f, 5.976f, 14.625f, 5.5125f);
                instancePath.cubicTo(14.211f, 5.697f, 13.7655f, 5.8185f, 13.2975f, 5.877f);
                instancePath.cubicTo(13.7745f, 5.5935f, 14.139f, 5.139f, 14.3145f, 4.599f);
                instancePath.cubicTo(13.869f, 4.8645f, 13.374f, 5.0535f, 12.8475f, 5.157f);
                instancePath.cubicTo(12.4245f, 4.707f, 11.826f, 4.428f, 11.1645f, 4.428f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
