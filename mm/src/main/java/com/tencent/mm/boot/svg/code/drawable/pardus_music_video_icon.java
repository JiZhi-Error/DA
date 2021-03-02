package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class pardus_music_video_icon extends c {
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
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-420614675);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(12.0f, 1.0f);
                instancePath.cubicTo(18.075132f, 1.0f, 23.0f, 5.9248676f, 23.0f, 12.0f);
                instancePath.cubicTo(23.0f, 18.075132f, 18.075132f, 23.0f, 12.0f, 23.0f);
                instancePath.cubicTo(5.9248676f, 23.0f, 1.0f, 18.075132f, 1.0f, 12.0f);
                instancePath.cubicTo(1.0f, 5.9248676f, 5.9248676f, 1.0f, 12.0f, 1.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(WebView.NIGHT_MODE_COLOR);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 5.4f, 0.0f, 1.0f, 5.4f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(5.295904f, 2.764018f);
                instancePath2.lineTo(10.347847f, 5.8729057f);
                instancePath2.cubicTo(10.658283f, 6.0639434f, 10.7550745f, 6.4704685f, 10.564037f, 6.780905f);
                instancePath2.cubicTo(10.509889f, 6.8688965f, 10.435839f, 6.9429464f, 10.347847f, 6.997095f);
                instancePath2.lineTo(5.2959046f, 10.105983f);
                instancePath2.cubicTo(4.9854684f, 10.29702f, 4.5789433f, 10.200229f, 4.387906f, 9.889792f);
                instancePath2.cubicTo(4.323893f, 9.785771f, 4.2900004f, 9.666028f, 4.2900004f, 9.543888f);
                instancePath2.lineTo(4.2900004f, 3.3261132f);
                instancePath2.cubicTo(4.2900004f, 2.9616053f, 4.5854926f, 2.6661131f, 4.9500003f, 2.6661131f);
                instancePath2.cubicTo(5.0721397f, 2.6661131f, 5.1918836f, 2.7000058f, 5.2959046f, 2.7640185f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
