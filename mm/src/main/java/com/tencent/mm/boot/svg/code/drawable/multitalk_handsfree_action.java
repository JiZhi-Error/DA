package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.smtt.sdk.WebView;

public class multitalk_handsfree_action extends c {
    private final int height = 240;
    private final int width = TXLiveConstants.RENDER_ROTATION_180;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return TXLiveConstants.RENDER_ROTATION_180;
            case 1:
                return 240;
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
                Paint instancePaint3 = c.instancePaint(instancePaint2, looper);
                instancePaint3.setStrokeWidth(1.0f);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 48.0f, 0.0f, 1.0f, 54.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(-1);
                instancePaint4.setStrokeWidth(4.0f);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(14.0f, 46.0f);
                instancePath.lineTo(36.0f, 61.0f);
                instancePath.lineTo(36.0f, 11.0f);
                instancePath.lineTo(14.0f, 26.0f);
                instancePath.lineTo(0.0f, 26.0f);
                instancePath.lineTo(0.0f, 46.0f);
                instancePath.lineTo(14.0f, 46.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-1);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(75.00751f, 72.117966f);
                instancePath2.cubicTo(80.96203f, 61.445175f, 84.35507f, 49.148323f, 84.35507f, 36.058983f);
                instancePath2.cubicTo(84.35507f, 22.969645f, 80.96203f, 10.672792f, 75.00751f, 0.0f);
                instancePath2.lineTo(75.00751f, 0.0f);
                instancePath2.lineTo(71.0f, 2.9665983f);
                instancePath2.cubicTo(76.36485f, 12.796429f, 79.413895f, 24.071636f, 79.413895f, 36.058983f);
                instancePath2.cubicTo(79.413895f, 48.046333f, 76.36485f, 59.321537f, 71.0f, 69.15137f);
                instancePath2.lineTo(75.00751f, 72.117966f);
                instancePath2.close();
                instancePath2.moveTo(62.93931f, 63.29133f);
                instancePath2.cubicTo(67.135056f, 55.157722f, 69.50414f, 45.92836f, 69.50414f, 36.145664f);
                instancePath2.cubicTo(69.50414f, 26.36297f, 67.135056f, 17.133606f, 62.93931f, 9.0f);
                instancePath2.lineTo(62.93931f, 9.0f);
                instancePath2.lineTo(59.0f, 11.916111f);
                instancePath2.cubicTo(62.71647f, 19.272243f, 64.81003f, 27.587996f, 64.81003f, 36.392723f);
                instancePath2.cubicTo(64.81003f, 45.053913f, 62.784172f, 53.241943f, 59.180466f, 60.50881f);
                instancePath2.lineTo(62.93931f, 63.29133f);
                instancePath2.lineTo(62.93931f, 63.29133f);
                instancePath2.close();
                instancePath2.moveTo(51.07929f, 54.336704f);
                instancePath2.cubicTo(53.565243f, 48.789673f, 54.94784f, 42.640472f, 54.94784f, 36.16835f);
                instancePath2.cubicTo(54.94784f, 29.69623f, 53.565243f, 23.547031f, 51.07929f, 18.0f);
                instancePath2.lineTo(51.07929f, 18.0f);
                instancePath2.lineTo(47.0f, 21.019733f);
                instancePath2.cubicTo(48.937286f, 25.685192f, 50.006668f, 30.801888f, 50.006668f, 36.16835f);
                instancePath2.cubicTo(50.006668f, 41.534813f, 48.937286f, 46.651512f, 47.0f, 51.316967f);
                instancePath2.lineTo(51.07929f, 54.336704f);
                instancePath2.lineTo(51.07929f, 54.336704f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
