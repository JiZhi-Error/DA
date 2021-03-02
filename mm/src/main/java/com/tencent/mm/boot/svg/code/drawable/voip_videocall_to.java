package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class voip_videocall_to extends c {
    private final int height = 72;
    private final int width = 72;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 72;
            case 1:
                return 72;
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
                canvas.saveLayerAlpha(null, 230, 31);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, -1.0f, 0.0f, 72.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.restore();
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 9.0f, 0.0f, 1.0f, 18.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                float[] matrixFloatArray3 = c.setMatrixFloatArray(matrixFloatArray2, -1.0f, 0.0f, 66.650795f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray3);
                canvas.concat(instanceMatrix);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(15.814285f, 31.066668f);
                instancePath.lineTo(50.83651f, 31.066668f);
                instancePath.lineTo(50.83651f, 3.6f);
                instancePath.lineTo(15.814285f, 3.6f);
                instancePath.lineTo(15.814285f, 31.066668f);
                instancePath.close();
                instancePath.moveTo(14.401286f, 2.220446E-16f);
                instancePath.lineTo(52.249508f, -1.110223E-16f);
                instancePath.cubicTo(53.457355f, -3.3290015E-16f, 54.43651f, 0.9791533f, 54.43651f, 2.187f);
                instancePath.lineTo(54.43651f, 32.479668f);
                instancePath.cubicTo(54.43651f, 33.687515f, 53.457355f, 34.666668f, 52.249508f, 34.666668f);
                instancePath.lineTo(14.401286f, 34.666668f);
                instancePath.cubicTo(13.193439f, 34.666668f, 12.214286f, 33.687515f, 12.214286f, 32.479668f);
                instancePath.lineTo(12.214286f, 2.187f);
                instancePath.cubicTo(12.214286f, 0.9791533f, 13.193439f, 1.1100563E-15f, 14.401286f, 2.220446E-16f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                float[] matrixFloatArray4 = c.setMatrixFloatArray(matrixFloatArray3, -1.0f, 0.0f, 15.079366f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray4);
                canvas.concat(instanceMatrix);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(3.6f, 19.946148f);
                instancePath2.lineTo(11.479365f, 27.687836f);
                instancePath2.lineTo(11.479365f, 6.7578244f);
                instancePath2.lineTo(3.6f, 14.499511f);
                instancePath2.lineTo(3.6f, 19.946148f);
                instancePath2.close();
                instancePath2.moveTo(0.0f, 12.989721f);
                instancePath2.lineTo(11.3596115f, 1.8286f);
                instancePath2.cubicTo(12.221183f, 0.9820839f, 13.605861f, 0.99428797f, 14.452377f, 1.8558587f);
                instancePath2.cubicTo(14.854209f, 2.2648373f, 15.079365f, 2.8152597f, 15.079365f, 3.3886118f);
                instancePath2.lineTo(15.079365f, 31.057047f);
                instancePath2.cubicTo(15.079365f, 32.264893f, 14.100212f, 33.24405f, 12.892365f, 33.24405f);
                instancePath2.cubicTo(12.319013f, 33.24405f, 11.768591f, 33.01889f, 11.3596115f, 32.617058f);
                instancePath2.lineTo(0.0f, 21.455938f);
                instancePath2.lineTo(0.0f, 12.989721f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
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
