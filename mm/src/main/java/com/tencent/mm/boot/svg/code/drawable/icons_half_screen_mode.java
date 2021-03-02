package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_half_screen_mode extends c {
    private final int height = 24;
    private final int width = 24;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 24;
            case 1:
                return 24;
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
                instancePaint3.setColor(-436207616);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 4.0f, 0.0f, 1.0f, 4.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 0.5f, 0.0f, 1.0f, 0.5f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(15.0f, 10.0f);
                instancePath.lineTo(15.0f, 14.166667f);
                instancePath.cubicTo(15.0f, 14.626904f, 14.626904f, 15.0f, 14.166667f, 15.0f);
                instancePath.lineTo(10.0f, 15.0f);
                instancePath.lineTo(10.0f, 13.333333f);
                instancePath.lineTo(13.333333f, 13.333333f);
                instancePath.lineTo(13.333333f, 10.0f);
                instancePath.lineTo(15.0f, 10.0f);
                instancePath.close();
                instancePath.moveTo(1.6666666f, 9.998479f);
                instancePath.lineTo(1.6666666f, 13.331813f);
                instancePath.lineTo(5.0f, 13.331813f);
                instancePath.lineTo(5.0f, 14.998479f);
                instancePath.lineTo(0.8333333f, 14.998479f);
                instancePath.cubicTo(0.37309605f, 14.998479f, 0.0f, 14.625383f, 0.0f, 14.165146f);
                instancePath.lineTo(0.0f, 9.998479f);
                instancePath.lineTo(1.6666666f, 9.998479f);
                instancePath.close();
                instancePath.moveTo(5.0f, 0.0f);
                instancePath.lineTo(5.0f, 1.6666666f);
                instancePath.lineTo(1.6666666f, 1.6666666f);
                instancePath.lineTo(1.6666666f, 5.0f);
                instancePath.lineTo(0.0f, 5.0f);
                instancePath.lineTo(0.0f, 0.8333333f);
                instancePath.cubicTo(0.0f, 0.37309605f, 0.37309605f, 0.0f, 0.8333333f, 0.0f);
                instancePath.lineTo(5.0f, 0.0f);
                instancePath.close();
                instancePath.moveTo(14.166667f, 0.0f);
                instancePath.cubicTo(14.626904f, 0.0f, 15.0f, 0.37309605f, 15.0f, 0.8333333f);
                instancePath.lineTo(15.0f, 5.0f);
                instancePath.lineTo(13.333333f, 5.0f);
                instancePath.lineTo(13.333333f, 1.6666666f);
                instancePath.lineTo(10.0f, 1.6666666f);
                instancePath.lineTo(10.0f, 0.0f);
                instancePath.lineTo(14.166667f, 0.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                canvas.save();
                float[] matrixFloatArray3 = c.setMatrixFloatArray(matrixFloatArray2, 1.0f, 0.0f, 2.5f, 0.0f, 1.0f, 2.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray3);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(3.7480695f, 2.4274683f);
                instancePath2.lineTo(9.240287f, 5.5658784f);
                instancePath2.cubicTo(9.480046f, 5.7028832f, 9.563344f, 6.008311f, 9.426339f, 6.2480693f);
                instancePath2.cubicTo(9.382045f, 6.325585f, 9.317802f, 6.389827f, 9.240287f, 6.4341216f);
                instancePath2.lineTo(3.7480695f, 9.572532f);
                instancePath2.cubicTo(3.5083108f, 9.709537f, 3.2028835f, 9.626239f, 3.0658784f, 9.386479f);
                instancePath2.cubicTo(3.0227077f, 9.310931f, 3.0f, 9.225424f, 3.0f, 9.138411f);
                instancePath2.lineTo(3.0f, 2.86159f);
                instancePath2.cubicTo(3.0f, 2.5854475f, 3.2238576f, 2.36159f, 3.5f, 2.36159f);
                instancePath2.cubicTo(3.5870135f, 2.36159f, 3.6725206f, 2.3842976f, 3.7480695f, 2.4274683f);
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
