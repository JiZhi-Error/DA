package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class actionbar_collect_list_icon extends c {
    private final int height = 96;
    private final int width = 96;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 19.0f, 0.0f, 1.0f, 24.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.9975446f, 38.0f);
                instancePath.cubicTo(0.446616f, 38.0f, 0.0f, 38.446312f, 0.0f, 38.997543f);
                instancePath.lineTo(0.0f, 46.002457f);
                instancePath.cubicTo(0.0f, 46.553383f, 0.4463114f, 47.0f, 0.9975446f, 47.0f);
                instancePath.lineTo(8.002456f, 47.0f);
                instancePath.cubicTo(8.553384f, 47.0f, 9.0f, 46.553688f, 9.0f, 46.002457f);
                instancePath.lineTo(9.0f, 38.997543f);
                instancePath.cubicTo(9.0f, 38.446617f, 8.553689f, 38.0f, 8.002456f, 38.0f);
                instancePath.lineTo(0.9975446f, 38.0f);
                instancePath.lineTo(0.9975446f, 38.0f);
                instancePath.close();
                instancePath.moveTo(0.9975446f, 19.0f);
                instancePath.cubicTo(0.446616f, 19.0f, 0.0f, 19.446312f, 0.0f, 19.997545f);
                instancePath.lineTo(0.0f, 27.002455f);
                instancePath.cubicTo(0.0f, 27.553385f, 0.4463114f, 28.0f, 0.9975446f, 28.0f);
                instancePath.lineTo(8.002456f, 28.0f);
                instancePath.cubicTo(8.553384f, 28.0f, 9.0f, 27.553688f, 9.0f, 27.002455f);
                instancePath.lineTo(9.0f, 19.997545f);
                instancePath.cubicTo(9.0f, 19.446615f, 8.553689f, 19.0f, 8.002456f, 19.0f);
                instancePath.lineTo(0.9975446f, 19.0f);
                instancePath.lineTo(0.9975446f, 19.0f);
                instancePath.close();
                instancePath.moveTo(17.993174f, 38.0f);
                instancePath.cubicTo(17.444658f, 38.0f, 17.0f, 38.446312f, 17.0f, 38.997543f);
                instancePath.lineTo(17.0f, 46.002457f);
                instancePath.cubicTo(17.0f, 46.553383f, 17.446476f, 47.0f, 17.993174f, 47.0f);
                instancePath.lineTo(57.006824f, 47.0f);
                instancePath.cubicTo(57.55534f, 47.0f, 58.0f, 46.553688f, 58.0f, 46.002457f);
                instancePath.lineTo(58.0f, 38.997543f);
                instancePath.cubicTo(58.0f, 38.446617f, 57.553524f, 38.0f, 57.006824f, 38.0f);
                instancePath.lineTo(17.993174f, 38.0f);
                instancePath.lineTo(17.993174f, 38.0f);
                instancePath.close();
                instancePath.moveTo(17.993174f, 19.0f);
                instancePath.cubicTo(17.444658f, 19.0f, 17.0f, 19.446312f, 17.0f, 19.997545f);
                instancePath.lineTo(17.0f, 27.002455f);
                instancePath.cubicTo(17.0f, 27.553385f, 17.446476f, 28.0f, 17.993174f, 28.0f);
                instancePath.lineTo(57.006824f, 28.0f);
                instancePath.cubicTo(57.55534f, 28.0f, 58.0f, 27.553688f, 58.0f, 27.002455f);
                instancePath.lineTo(58.0f, 19.997545f);
                instancePath.cubicTo(58.0f, 19.446615f, 57.553524f, 19.0f, 57.006824f, 19.0f);
                instancePath.lineTo(17.993174f, 19.0f);
                instancePath.lineTo(17.993174f, 19.0f);
                instancePath.close();
                instancePath.moveTo(17.993174f, 0.0f);
                instancePath.cubicTo(17.444658f, 0.0f, 17.0f, 0.4463114f, 17.0f, 0.9975446f);
                instancePath.lineTo(17.0f, 8.002456f);
                instancePath.cubicTo(17.0f, 8.553384f, 17.446476f, 9.0f, 17.993174f, 9.0f);
                instancePath.lineTo(57.006824f, 9.0f);
                instancePath.cubicTo(57.55534f, 9.0f, 58.0f, 8.553689f, 58.0f, 8.002456f);
                instancePath.lineTo(58.0f, 0.9975446f);
                instancePath.cubicTo(58.0f, 0.446616f, 57.553524f, 0.0f, 57.006824f, 0.0f);
                instancePath.lineTo(17.993174f, 0.0f);
                instancePath.lineTo(17.993174f, 0.0f);
                instancePath.close();
                instancePath.moveTo(0.9975446f, 0.0f);
                instancePath.cubicTo(0.446616f, 0.0f, 0.0f, 0.4463114f, 0.0f, 0.9975446f);
                instancePath.lineTo(0.0f, 8.002456f);
                instancePath.cubicTo(0.0f, 8.553384f, 0.4463114f, 9.0f, 0.9975446f, 9.0f);
                instancePath.lineTo(8.002456f, 9.0f);
                instancePath.cubicTo(8.553384f, 9.0f, 9.0f, 8.553689f, 9.0f, 8.002456f);
                instancePath.lineTo(9.0f, 0.9975446f);
                instancePath.cubicTo(9.0f, 0.446616f, 8.553689f, 0.0f, 8.002456f, 0.0f);
                instancePath.lineTo(0.9975446f, 0.0f);
                instancePath.lineTo(0.9975446f, 0.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(0.9975446f, 38.0f);
                instancePath2.cubicTo(0.446616f, 38.0f, 0.0f, 38.446312f, 0.0f, 38.997543f);
                instancePath2.lineTo(0.0f, 46.002457f);
                instancePath2.cubicTo(0.0f, 46.553383f, 0.4463114f, 47.0f, 0.9975446f, 47.0f);
                instancePath2.lineTo(8.002456f, 47.0f);
                instancePath2.cubicTo(8.553384f, 47.0f, 9.0f, 46.553688f, 9.0f, 46.002457f);
                instancePath2.lineTo(9.0f, 38.997543f);
                instancePath2.cubicTo(9.0f, 38.446617f, 8.553689f, 38.0f, 8.002456f, 38.0f);
                instancePath2.lineTo(0.9975446f, 38.0f);
                instancePath2.lineTo(0.9975446f, 38.0f);
                instancePath2.close();
                instancePath2.moveTo(0.9975446f, 19.0f);
                instancePath2.cubicTo(0.446616f, 19.0f, 0.0f, 19.446312f, 0.0f, 19.997545f);
                instancePath2.lineTo(0.0f, 27.002455f);
                instancePath2.cubicTo(0.0f, 27.553385f, 0.4463114f, 28.0f, 0.9975446f, 28.0f);
                instancePath2.lineTo(8.002456f, 28.0f);
                instancePath2.cubicTo(8.553384f, 28.0f, 9.0f, 27.553688f, 9.0f, 27.002455f);
                instancePath2.lineTo(9.0f, 19.997545f);
                instancePath2.cubicTo(9.0f, 19.446615f, 8.553689f, 19.0f, 8.002456f, 19.0f);
                instancePath2.lineTo(0.9975446f, 19.0f);
                instancePath2.lineTo(0.9975446f, 19.0f);
                instancePath2.close();
                instancePath2.moveTo(17.993174f, 38.0f);
                instancePath2.cubicTo(17.444658f, 38.0f, 17.0f, 38.446312f, 17.0f, 38.997543f);
                instancePath2.lineTo(17.0f, 46.002457f);
                instancePath2.cubicTo(17.0f, 46.553383f, 17.446476f, 47.0f, 17.993174f, 47.0f);
                instancePath2.lineTo(57.006824f, 47.0f);
                instancePath2.cubicTo(57.55534f, 47.0f, 58.0f, 46.553688f, 58.0f, 46.002457f);
                instancePath2.lineTo(58.0f, 38.997543f);
                instancePath2.cubicTo(58.0f, 38.446617f, 57.553524f, 38.0f, 57.006824f, 38.0f);
                instancePath2.lineTo(17.993174f, 38.0f);
                instancePath2.lineTo(17.993174f, 38.0f);
                instancePath2.close();
                instancePath2.moveTo(17.993174f, 19.0f);
                instancePath2.cubicTo(17.444658f, 19.0f, 17.0f, 19.446312f, 17.0f, 19.997545f);
                instancePath2.lineTo(17.0f, 27.002455f);
                instancePath2.cubicTo(17.0f, 27.553385f, 17.446476f, 28.0f, 17.993174f, 28.0f);
                instancePath2.lineTo(57.006824f, 28.0f);
                instancePath2.cubicTo(57.55534f, 28.0f, 58.0f, 27.553688f, 58.0f, 27.002455f);
                instancePath2.lineTo(58.0f, 19.997545f);
                instancePath2.cubicTo(58.0f, 19.446615f, 57.553524f, 19.0f, 57.006824f, 19.0f);
                instancePath2.lineTo(17.993174f, 19.0f);
                instancePath2.lineTo(17.993174f, 19.0f);
                instancePath2.close();
                instancePath2.moveTo(17.993174f, 0.0f);
                instancePath2.cubicTo(17.444658f, 0.0f, 17.0f, 0.4463114f, 17.0f, 0.9975446f);
                instancePath2.lineTo(17.0f, 8.002456f);
                instancePath2.cubicTo(17.0f, 8.553384f, 17.446476f, 9.0f, 17.993174f, 9.0f);
                instancePath2.lineTo(57.006824f, 9.0f);
                instancePath2.cubicTo(57.55534f, 9.0f, 58.0f, 8.553689f, 58.0f, 8.002456f);
                instancePath2.lineTo(58.0f, 0.9975446f);
                instancePath2.cubicTo(58.0f, 0.446616f, 57.553524f, 0.0f, 57.006824f, 0.0f);
                instancePath2.lineTo(17.993174f, 0.0f);
                instancePath2.lineTo(17.993174f, 0.0f);
                instancePath2.close();
                instancePath2.moveTo(0.9975446f, 0.0f);
                instancePath2.cubicTo(0.446616f, 0.0f, 0.0f, 0.4463114f, 0.0f, 0.9975446f);
                instancePath2.lineTo(0.0f, 8.002456f);
                instancePath2.cubicTo(0.0f, 8.553384f, 0.4463114f, 9.0f, 0.9975446f, 9.0f);
                instancePath2.lineTo(8.002456f, 9.0f);
                instancePath2.cubicTo(8.553384f, 9.0f, 9.0f, 8.553689f, 9.0f, 8.002456f);
                instancePath2.lineTo(9.0f, 0.9975446f);
                instancePath2.cubicTo(9.0f, 0.446616f, 8.553689f, 0.0f, 8.002456f, 0.0f);
                instancePath2.lineTo(0.9975446f, 0.0f);
                instancePath2.lineTo(0.9975446f, 0.0f);
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