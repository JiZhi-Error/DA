package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class app_brand_game_actionbar_option_light extends c {
    private final int height = 120;
    private final int width = 120;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 120;
            case 1:
                return 120;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -921.0f, 0.0f, 1.0f, -39.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 921.0f, 0.0f, 1.0f, 39.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(855638016);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 60.0f);
                instancePath.cubicTo(0.0f, 26.862915f, 26.862915f, 0.0f, 60.0f, 0.0f);
                instancePath.lineTo(60.0f, 0.0f);
                instancePath.cubicTo(93.137085f, 0.0f, 120.0f, 26.862915f, 120.0f, 60.0f);
                instancePath.lineTo(120.0f, 60.0f);
                instancePath.cubicTo(120.0f, 93.137085f, 93.137085f, 120.0f, 60.0f, 120.0f);
                instancePath.lineTo(60.0f, 120.0f);
                instancePath.cubicTo(26.862915f, 120.0f, 0.0f, 93.137085f, 0.0f, 60.0f);
                instancePath.lineTo(0.0f, 60.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-1);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(40.5f, 60.75f);
                instancePath2.cubicTo(40.5f, 64.47735f, 37.47735f, 67.5f, 33.75f, 67.5f);
                instancePath2.cubicTo(30.02265f, 67.5f, 27.0f, 64.47735f, 27.0f, 60.75f);
                instancePath2.cubicTo(27.0f, 57.0213f, 30.02265f, 54.0f, 33.75f, 54.0f);
                instancePath2.cubicTo(37.47735f, 54.0f, 40.5f, 57.0213f, 40.5f, 60.75f);
                instancePath2.close();
                instancePath2.moveTo(59.25f, 49.5f);
                instancePath2.cubicTo(65.46225f, 49.5f, 70.5f, 54.5355f, 70.5f, 60.75f);
                instancePath2.cubicTo(70.5f, 66.96225f, 65.46225f, 72.0f, 59.25f, 72.0f);
                instancePath2.cubicTo(53.03775f, 72.0f, 48.0f, 66.96225f, 48.0f, 60.75f);
                instancePath2.cubicTo(48.0f, 54.5355f, 53.03775f, 49.5f, 59.25f, 49.5f);
                instancePath2.close();
                instancePath2.moveTo(93.0f, 60.75f);
                instancePath2.cubicTo(93.0f, 64.47735f, 89.97735f, 67.5f, 86.25f, 67.5f);
                instancePath2.cubicTo(82.52265f, 67.5f, 79.5f, 64.47735f, 79.5f, 60.75f);
                instancePath2.cubicTo(79.5f, 57.0213f, 82.52265f, 54.0f, 86.25f, 54.0f);
                instancePath2.cubicTo(89.97735f, 54.0f, 93.0f, 57.0213f, 93.0f, 60.75f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
