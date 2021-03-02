package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class sight_draft_entrance extends c {
    private final int height = 90;
    private final int width = 90;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 90;
            case 1:
                return 90;
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
                instancePaint3.setColor(-6052957);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 10.0f, 0.0f, 1.0f, 18.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 3.990053f);
                instancePath.cubicTo(0.0f, 1.7864076f, 1.7890275f, 0.0f, 4.0042577f, 0.0f);
                instancePath.lineTo(27.995743f, 0.0f);
                instancePath.cubicTo(30.207233f, 0.0f, 32.0f, 1.7842933f, 32.0f, 3.990053f);
                instancePath.lineTo(32.0f, 20.009947f);
                instancePath.cubicTo(32.0f, 22.213593f, 30.210972f, 24.0f, 27.995743f, 24.0f);
                instancePath.lineTo(4.0042577f, 24.0f);
                instancePath.cubicTo(1.7927673f, 24.0f, 0.0f, 22.215706f, 0.0f, 20.009947f);
                instancePath.lineTo(0.0f, 3.990053f);
                instancePath.close();
                instancePath.moveTo(3.0f, 3.9933977f);
                instancePath.cubicTo(3.0f, 3.4447594f, 3.4512787f, 3.0f, 4.0032997f, 3.0f);
                instancePath.lineTo(27.9967f, 3.0f);
                instancePath.cubicTo(28.550808f, 3.0f, 29.0f, 3.4449463f, 29.0f, 3.9933977f);
                instancePath.lineTo(29.0f, 20.006603f);
                instancePath.cubicTo(29.0f, 20.55524f, 28.548721f, 21.0f, 27.9967f, 21.0f);
                instancePath.lineTo(4.0032997f, 21.0f);
                instancePath.cubicTo(3.4491925f, 21.0f, 3.0f, 20.555054f, 3.0f, 20.006603f);
                instancePath.lineTo(3.0f, 3.9933977f);
                instancePath.close();
                instancePath.moveTo(0.0f, 33.99005f);
                instancePath.cubicTo(0.0f, 31.786407f, 1.7890275f, 30.0f, 4.0042577f, 30.0f);
                instancePath.lineTo(27.995743f, 30.0f);
                instancePath.cubicTo(30.207233f, 30.0f, 32.0f, 31.784294f, 32.0f, 33.99005f);
                instancePath.lineTo(32.0f, 50.00995f);
                instancePath.cubicTo(32.0f, 52.213593f, 30.210972f, 54.0f, 27.995743f, 54.0f);
                instancePath.lineTo(4.0042577f, 54.0f);
                instancePath.cubicTo(1.7927673f, 54.0f, 0.0f, 52.215706f, 0.0f, 50.00995f);
                instancePath.lineTo(0.0f, 33.99005f);
                instancePath.close();
                instancePath.moveTo(3.0f, 33.993397f);
                instancePath.cubicTo(3.0f, 33.44476f, 3.4512787f, 33.0f, 4.0032997f, 33.0f);
                instancePath.lineTo(27.9967f, 33.0f);
                instancePath.cubicTo(28.550808f, 33.0f, 29.0f, 33.444946f, 29.0f, 33.993397f);
                instancePath.lineTo(29.0f, 50.006603f);
                instancePath.cubicTo(29.0f, 50.55524f, 28.548721f, 51.0f, 27.9967f, 51.0f);
                instancePath.lineTo(4.0032997f, 51.0f);
                instancePath.cubicTo(3.4491925f, 51.0f, 3.0f, 50.555054f, 3.0f, 50.006603f);
                instancePath.lineTo(3.0f, 33.993397f);
                instancePath.close();
                instancePath.moveTo(38.0f, 33.99005f);
                instancePath.cubicTo(38.0f, 31.786407f, 39.78903f, 30.0f, 42.004257f, 30.0f);
                instancePath.lineTo(65.99574f, 30.0f);
                instancePath.cubicTo(68.20723f, 30.0f, 70.0f, 31.784294f, 70.0f, 33.99005f);
                instancePath.lineTo(70.0f, 50.00995f);
                instancePath.cubicTo(70.0f, 52.213593f, 68.210976f, 54.0f, 65.99574f, 54.0f);
                instancePath.lineTo(42.004257f, 54.0f);
                instancePath.cubicTo(39.792767f, 54.0f, 38.0f, 52.215706f, 38.0f, 50.00995f);
                instancePath.lineTo(38.0f, 33.99005f);
                instancePath.close();
                instancePath.moveTo(41.0f, 33.993397f);
                instancePath.cubicTo(41.0f, 33.44476f, 41.45128f, 33.0f, 42.0033f, 33.0f);
                instancePath.lineTo(65.996704f, 33.0f);
                instancePath.cubicTo(66.550804f, 33.0f, 67.0f, 33.444946f, 67.0f, 33.993397f);
                instancePath.lineTo(67.0f, 50.006603f);
                instancePath.cubicTo(67.0f, 50.55524f, 66.54872f, 51.0f, 65.996704f, 51.0f);
                instancePath.lineTo(42.0033f, 51.0f);
                instancePath.cubicTo(41.449192f, 51.0f, 41.0f, 50.555054f, 41.0f, 50.006603f);
                instancePath.lineTo(41.0f, 33.993397f);
                instancePath.close();
                instancePath.moveTo(38.0f, 3.990053f);
                instancePath.cubicTo(38.0f, 1.7864076f, 39.78903f, 0.0f, 42.004257f, 0.0f);
                instancePath.lineTo(65.99574f, 0.0f);
                instancePath.cubicTo(68.20723f, 0.0f, 70.0f, 1.7842933f, 70.0f, 3.990053f);
                instancePath.lineTo(70.0f, 20.009947f);
                instancePath.cubicTo(70.0f, 22.213593f, 68.210976f, 24.0f, 65.99574f, 24.0f);
                instancePath.lineTo(42.004257f, 24.0f);
                instancePath.cubicTo(39.792767f, 24.0f, 38.0f, 22.215706f, 38.0f, 20.009947f);
                instancePath.lineTo(38.0f, 3.990053f);
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
