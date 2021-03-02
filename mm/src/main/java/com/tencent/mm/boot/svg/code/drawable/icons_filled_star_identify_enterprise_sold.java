package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_star_identify_enterprise_sold extends c {
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 3.571429f, 0.0f, 1.0f, 3.571429f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-15432210);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(23.73465f, 0.9581761f);
                instancePath.lineTo(26.126421f, 6.731255f);
                instancePath.lineTo(31.898968f, 9.122494f);
                instancePath.cubicTo(32.497654f, 9.370478f, 32.781956f, 10.05684f, 32.53397f, 10.655527f);
                instancePath.lineTo(30.142637f, 16.42726f);
                instancePath.lineTo(32.53397f, 22.201616f);
                instancePath.cubicTo(32.781956f, 22.800303f, 32.497654f, 23.486666f, 31.898968f, 23.73465f);
                instancePath.lineTo(26.125225f, 26.126146f);
                instancePath.lineTo(23.73465f, 31.898968f);
                instancePath.cubicTo(23.486666f, 32.497654f, 22.800303f, 32.781956f, 22.201616f, 32.53397f);
                instancePath.lineTo(16.429222f, 30.142363f);
                instancePath.lineTo(10.655527f, 32.53397f);
                instancePath.cubicTo(10.05684f, 32.781956f, 9.370478f, 32.497654f, 9.122494f, 31.898968f);
                instancePath.lineTo(6.7303348f, 26.124952f);
                instancePath.lineTo(0.9581761f, 23.73465f);
                instancePath.cubicTo(0.35948908f, 23.486666f, 0.07518837f, 22.800303f, 0.32317263f, 22.201616f);
                instancePath.lineTo(2.7141187f, 16.428947f);
                instancePath.lineTo(0.32317263f, 10.655527f);
                instancePath.cubicTo(0.07518837f, 10.05684f, 0.35948908f, 9.370478f, 0.9581761f, 9.122494f);
                instancePath.lineTo(6.731529f, 6.730061f);
                instancePath.lineTo(9.122494f, 0.9581761f);
                instancePath.cubicTo(9.370478f, 0.35948908f, 10.05684f, 0.07518837f, 10.655527f, 0.32317263f);
                instancePath.lineTo(16.427532f, 2.7138445f);
                instancePath.lineTo(22.201616f, 0.32317263f);
                instancePath.cubicTo(22.800303f, 0.07518837f, 23.486666f, 0.35948908f, 23.73465f, 0.9581761f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-1);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(14.467633f, 19.994099f);
                instancePath2.lineTo(23.799828f, 10.661904f);
                instancePath2.lineTo(25.570707f, 12.432784f);
                instancePath2.lineTo(15.225742f, 22.77345f);
                instancePath2.cubicTo(14.809213f, 23.190039f, 14.133837f, 23.1899f, 13.717364f, 22.773252f);
                instancePath2.cubicTo(13.717325f, 22.773214f, 13.717287f, 22.773176f, 13.717364f, 22.773022f);
                instancePath2.lineTo(8.095238f, 17.14683f);
                instancePath2.lineTo(8.095238f, 17.14683f);
                instancePath2.lineTo(9.8578005f, 15.384266f);
                instancePath2.lineTo(14.467633f, 19.994099f);
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
