package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class float_ball_state_message extends c {
    private final int height = 60;
    private final int width = 60;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 60;
            case 1:
                return 60;
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
                instancePaint3.setColor(-16268960);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 5.0f, 0.0f, 1.0f, 5.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(39.583332f, 4.1666665f);
                instancePath.cubicTo(40.733925f, 4.1666665f, 41.666668f, 5.0994067f, 41.666668f, 6.25f);
                instancePath.lineTo(41.666668f, 6.25f);
                instancePath.lineTo(41.666668f, 43.75f);
                instancePath.cubicTo(41.666668f, 44.900593f, 40.733925f, 45.833332f, 39.583332f, 45.833332f);
                instancePath.lineTo(39.583332f, 45.833332f);
                instancePath.lineTo(10.416667f, 45.833332f);
                instancePath.cubicTo(9.266073f, 45.833332f, 8.333333f, 44.900593f, 8.333333f, 43.75f);
                instancePath.lineTo(8.333333f, 43.75f);
                instancePath.lineTo(8.333333f, 6.25f);
                instancePath.cubicTo(8.333333f, 5.0994067f, 9.266073f, 4.1666665f, 10.416667f, 4.1666665f);
                instancePath.lineTo(10.416667f, 4.1666665f);
                instancePath.close();
                instancePath.moveTo(22.916666f, 33.333332f);
                instancePath.lineTo(14.583333f, 33.333332f);
                instancePath.lineTo(14.583333f, 36.458332f);
                instancePath.lineTo(22.916666f, 36.458332f);
                instancePath.lineTo(22.916666f, 33.333332f);
                instancePath.close();
                instancePath.moveTo(22.916666f, 27.083334f);
                instancePath.lineTo(14.583333f, 27.083334f);
                instancePath.lineTo(14.583333f, 30.208334f);
                instancePath.lineTo(22.916666f, 30.208334f);
                instancePath.lineTo(22.916666f, 27.083334f);
                instancePath.close();
                instancePath.moveTo(30.208334f, 20.833334f);
                instancePath.lineTo(14.583333f, 20.833334f);
                instancePath.lineTo(14.583333f, 23.958334f);
                instancePath.lineTo(30.208334f, 23.958334f);
                instancePath.lineTo(30.208334f, 20.833334f);
                instancePath.close();
                instancePath.moveTo(17.708334f, 10.416667f);
                instancePath.cubicTo(15.982444f, 10.416667f, 14.583333f, 11.815777f, 14.583333f, 13.541667f);
                instancePath.cubicTo(14.583333f, 15.267556f, 15.982444f, 16.666666f, 17.708334f, 16.666666f);
                instancePath.cubicTo(19.434223f, 16.666666f, 20.833334f, 15.267556f, 20.833334f, 13.541667f);
                instancePath.cubicTo(20.833334f, 11.815777f, 19.434223f, 10.416667f, 17.708334f, 10.416667f);
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
