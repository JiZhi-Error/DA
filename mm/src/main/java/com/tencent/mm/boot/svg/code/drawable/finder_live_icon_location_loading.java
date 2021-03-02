package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class finder_live_icon_location_loading extends c {
    private final int height = 80;
    private final int width = 80;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 80;
            case 1:
                return 80;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -96.0f, 0.0f, 1.0f, -519.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 96.0f, 0.0f, 1.0f, 519.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(40.0f, 0.0f);
                instancePath.cubicTo(62.09139f, 0.0f, 80.0f, 17.90861f, 80.0f, 40.0f);
                instancePath.cubicTo(80.0f, 62.09139f, 62.09139f, 80.0f, 40.0f, 80.0f);
                instancePath.lineTo(40.0f, 73.0f);
                instancePath.cubicTo(58.225395f, 73.0f, 73.0f, 58.225395f, 73.0f, 40.0f);
                instancePath.cubicTo(73.0f, 21.774603f, 58.225395f, 7.0f, 40.0f, 7.0f);
                instancePath.lineTo(40.0f, 0.0f);
                instancePath.close();
                Paint instancePaint4 = c.instancePaint(looper);
                instancePaint4.setFlags(385);
                instancePaint4.setStyle(Paint.Style.FILL);
                Paint instancePaint5 = c.instancePaint(looper);
                instancePaint5.setFlags(385);
                instancePaint5.setStyle(Paint.Style.STROKE);
                instancePaint4.setColor(WebView.NIGHT_MODE_COLOR);
                instancePaint5.setStrokeWidth(1.0f);
                instancePaint5.setStrokeCap(Paint.Cap.BUTT);
                instancePaint5.setStrokeJoin(Paint.Join.MITER);
                instancePaint5.setStrokeMiter(4.0f);
                instancePaint5.setPathEffect(null);
                float[] matrixFloatArray3 = c.setMatrixFloatArray(matrixFloatArray2, 80.0f, 0.0f, 40.0f, 0.0f, 80.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray3);
                WeChatSVGRenderC2Java.setLinearGradient(instancePaint3, 0.94086915f, 0.0f, 0.94086915f, 0.90559083f, new int[]{15592941, 1290661357}, new float[]{0.0f, 1.0f}, instanceMatrix, 0);
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(40.0f, 0.0f);
                instancePath2.lineTo(40.0f, 7.0f);
                instancePath2.cubicTo(21.774603f, 7.0f, 7.0f, 21.774603f, 7.0f, 40.0f);
                instancePath2.cubicTo(7.0f, 58.225395f, 21.774603f, 73.0f, 40.0f, 73.0f);
                instancePath2.lineTo(40.0f, 80.0f);
                instancePath2.cubicTo(17.90861f, 80.0f, 0.0f, 62.09139f, 0.0f, 40.0f);
                instancePath2.cubicTo(0.0f, 17.90861f, 17.90861f, 0.0f, 40.0f, 0.0f);
                instancePath2.close();
                Paint instancePaint7 = c.instancePaint(looper);
                instancePaint7.setFlags(385);
                instancePaint7.setStyle(Paint.Style.FILL);
                Paint instancePaint8 = c.instancePaint(looper);
                instancePaint8.setFlags(385);
                instancePaint8.setStyle(Paint.Style.STROKE);
                instancePaint7.setColor(WebView.NIGHT_MODE_COLOR);
                instancePaint8.setStrokeWidth(1.0f);
                instancePaint8.setStrokeCap(Paint.Cap.BUTT);
                instancePaint8.setStrokeJoin(Paint.Join.MITER);
                instancePaint8.setStrokeMiter(4.0f);
                instancePaint8.setPathEffect(null);
                float[] matrixFloatArray4 = c.setMatrixFloatArray(matrixFloatArray3, 40.0f, 0.0f, 0.0f, 0.0f, 80.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray4);
                WeChatSVGRenderC2Java.setLinearGradient(instancePaint6, 1.0f, 0.08673706f, 1.0f, 0.9062866f, new int[]{-1184275, 1290661357}, new float[]{0.0f, 1.0f}, instanceMatrix, 0);
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint6);
                canvas.restore();
                canvas.save();
                Paint instancePaint9 = c.instancePaint(instancePaint, looper);
                instancePaint9.setColor(-1184275);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(40.5f, 0.0f);
                instancePath3.cubicTo(42.433f, 0.0f, 44.0f, 1.5670033f, 44.0f, 3.5f);
                instancePath3.cubicTo(44.0f, 5.4329967f, 42.433f, 7.0f, 40.5f, 7.0f);
                instancePath3.cubicTo(38.567f, 7.0f, 37.0f, 5.4329967f, 37.0f, 3.5f);
                instancePath3.cubicTo(37.0f, 1.5670033f, 38.567f, 0.0f, 40.5f, 0.0f);
                instancePath3.close();
                canvas.drawPath(instancePath3, instancePaint9);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
