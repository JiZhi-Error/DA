package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class fts_weapp_search_default_icon extends c {
    private final int height = 40;
    private final int width = 40;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 40;
            case 1:
                return 40;
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
                instancePaint3.setColor(-855310);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(39.94915f, 0.0f);
                instancePath.lineTo(39.94915f, 39.94915f);
                instancePath.lineTo(0.0f, 39.94915f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-3355444);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 11.506849f, 0.0f, 1.0f, 13.150685f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(16.2035f, 12.888432f);
                instancePath2.cubicTo(16.194273f, 12.974248f, 16.184774f, 13.061666f, 16.175003f, 13.150685f);
                instancePath2.lineTo(11.088048f, 13.150685f);
                instancePath2.lineTo(0.14068314f, 13.150685f);
                instancePath2.lineTo(0.14068314f, 12.759707f);
                instancePath2.cubicTo(0.052240293f, 12.619041f, 0.0f, 12.449673f, 0.0f, 12.267411f);
                instancePath2.lineTo(0.0f, 0.8832736f);
                instancePath2.cubicTo(0.0f, 0.39357388f, 0.3649688f, 1.33781874E-14f, 0.81518066f, 1.33781874E-14f);
                instancePath2.lineTo(15.623176f, 1.33781874E-14f);
                instancePath2.cubicTo(16.064133f, 1.33781874E-14f, 16.438356f, 0.39545506f, 16.438356f, 0.8832736f);
                instancePath2.lineTo(16.438356f, 12.267411f);
                instancePath2.cubicTo(16.438356f, 12.510094f, 16.348722f, 12.729167f, 16.2035f, 12.888432f);
                instancePath2.close();
                instancePath2.moveTo(14.79452f, 7.983133f);
                instancePath2.lineTo(14.79452f, 1.6438357f);
                instancePath2.lineTo(1.6438357f, 1.6438357f);
                instancePath2.lineTo(1.6438357f, 7.9357524f);
                instancePath2.lineTo(5.008241f, 5.168386f);
                instancePath2.cubicTo(5.4077787f, 4.83975f, 6.049406f, 4.855688f, 6.4345326f, 5.1998596f);
                instancePath2.lineTo(10.301113f, 8.65526f);
                instancePath2.lineTo(12.272379f, 6.9502635f);
                instancePath2.cubicTo(12.671624f, 6.6049466f, 13.306842f, 6.611962f, 13.69442f, 6.9657135f);
                instancePath2.lineTo(14.79452f, 7.983133f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
