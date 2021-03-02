package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class new_biz_info_message_voice_icon extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint2, looper);
                instancePaint3.setStrokeWidth(1.0f);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -56.0f, 0.0f, 1.0f, -265.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 56.0f, 0.0f, 1.0f, 265.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(-16139513);
                instancePaint4.setStrokeWidth(6.0f);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(3.0f, 45.0f);
                instancePath.cubicTo(3.0f, 21.804039f, 21.804039f, 3.0f, 45.0f, 3.0f);
                instancePath.lineTo(45.0f, 3.0f);
                instancePath.cubicTo(68.19596f, 3.0f, 87.0f, 21.804039f, 87.0f, 45.0f);
                instancePath.lineTo(87.0f, 45.0f);
                instancePath.cubicTo(87.0f, 68.19596f, 68.19596f, 87.0f, 45.0f, 87.0f);
                instancePath.lineTo(45.0f, 87.0f);
                instancePath.cubicTo(21.804039f, 87.0f, 3.0f, 68.19596f, 3.0f, 45.0f);
                instancePath.lineTo(3.0f, 45.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-16139513);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(49.82215f, 67.367676f);
                instancePath2.lineTo(46.05924f, 63.60476f);
                instancePath2.cubicTo(50.438366f, 58.779804f, 53.118694f, 52.299812f, 53.118694f, 45.175297f);
                instancePath2.cubicTo(53.118694f, 38.068485f, 50.451668f, 31.60299f, 46.091843f, 26.781826f);
                instancePath2.lineTo(49.854874f, 23.018793f);
                instancePath2.cubicTo(55.13197f, 28.813019f, 58.363636f, 36.605614f, 58.363636f, 45.175297f);
                instancePath2.cubicTo(58.363636f, 53.76268f, 55.11861f, 61.56976f, 49.82215f, 67.367676f);
                instancePath2.close();
                instancePath2.moveTo(41.090847f, 58.63637f);
                instancePath2.lineTo(37.32728f, 54.872803f);
                instancePath2.cubicTo(39.788017f, 52.418816f, 41.31758f, 48.98096f, 41.31758f, 45.175297f);
                instancePath2.cubicTo(41.31758f, 41.38734f, 39.80221f, 37.96377f, 37.36156f, 35.512104f);
                instancePath2.lineTo(41.124847f, 31.748817f);
                instancePath2.cubicTo(44.482662f, 35.17379f, 46.56252f, 39.92448f, 46.56252f, 45.175297f);
                instancePath2.cubicTo(46.56252f, 50.443817f, 44.468616f, 55.20883f, 41.090847f, 58.63637f);
                instancePath2.close();
                instancePath2.moveTo(32.620003f, 50.165524f);
                instancePath2.lineTo(27.664072f, 45.209595f);
                instancePath2.lineTo(32.655266f, 40.2184f);
                instancePath2.cubicTo(33.950462f, 41.45147f, 34.761406f, 43.215885f, 34.761406f, 45.175297f);
                instancePath2.cubicTo(34.761406f, 47.152435f, 33.935726f, 48.931026f, 32.620003f, 50.165524f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
