package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class friendactivity_comment_likeicon_normal extends c {
    private final int height = 54;
    private final int width = 60;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 60;
            case 1:
                return 54;
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
                instancePaint3.setColor(-1);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 4.0f, 0.0f, 1.0f, 2.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(6.1010113f, 2.057324f);
                instancePath.cubicTo(12.419818f, -2.0276875f, 21.226343f, 0.35939744f, 26.002764f, 5.80275f);
                instancePath.cubicTo(29.913458f, 1.4081168f, 36.07305f, -0.88907796f, 41.88436f, 0.33942184f);
                instancePath.cubicTo(46.15329f, 1.198373f, 49.516685f, 4.71408f, 50.899857f, 8.769128f);
                instancePath.cubicTo(52.929836f, 14.562054f, 52.034256f, 21.104065f, 49.168404f, 26.457527f);
                instancePath.cubicTo(44.093456f, 36.205624f, 35.60536f, 43.86627f, 26.002764f, 49.0f);
                instancePath.cubicTo(15.315523f, 43.22705f, 5.722878f, 34.327915f, 1.2648852f, 22.801992f);
                instancePath.cubicTo(-1.1929812f, 15.840492f, -0.31730413f, 6.591787f, 6.1010113f, 2.057324f);
                instancePath.lineTo(6.1010113f, 2.057324f);
                instancePath.lineTo(6.1010113f, 2.057324f);
                instancePath.close();
                instancePath.moveTo(6.614176f, 11.27121f);
                instancePath.cubicTo(5.3116097f, 15.999485f, 6.10707f, 21.24757f, 8.751974f, 25.366068f);
                instancePath.cubicTo(13.007686f, 32.263554f, 19.450912f, 37.44166f, 26.003513f, 42.0f);
                instancePath.cubicTo(31.064629f, 38.52127f, 35.90699f, 34.642685f, 39.924065f, 29.96439f);
                instancePath.cubicTo(43.255054f, 26.065813f, 46.138596f, 21.297552f, 45.979504f, 15.979492f);
                instancePath.cubicTo(46.198254f, 12.1209f, 44.686882f, 7.2526755f, 40.441113f, 6.3430076f);
                instancePath.cubicTo(34.624313f, 4.603642f, 30.24928f, 9.891713f, 26.003513f, 12.950597f);
                instancePath.cubicTo(21.837292f, 9.991676f, 17.651184f, 4.8135653f, 11.963644f, 6.2630367f);
                instancePath.cubicTo(9.358513f, 6.6728873f, 7.3300896f, 8.782118f, 6.614176f, 11.27121f);
                instancePath.lineTo(6.614176f, 11.27121f);
                instancePath.lineTo(6.614176f, 11.27121f);
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
