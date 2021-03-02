package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class login_auth_state_not_selected extends c {
    private final int height = 48;
    private final int width = 48;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 48;
            case 1:
                return 48;
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
                instancePaint3.setColor(-5592406);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -70.0f, 0.0f, 1.0f, -199.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 69.0f, 0.0f, 1.0f, 98.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray3 = c.setMatrixFloatArray(matrixFloatArray2, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 101.67347f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray3);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 6.3265305f);
                instancePath.cubicTo(0.0f, 2.9596574f, 2.6835413f, 0.3265306f, 6.0f, 0.3265306f);
                instancePath.lineTo(42.0f, 0.3265306f);
                instancePath.cubicTo(45.31085f, 0.3265306f, 48.0f, 2.9541647f, 48.0f, 6.3265305f);
                instancePath.lineTo(48.0f, 41.32653f);
                instancePath.cubicTo(48.0f, 44.693405f, 45.31646f, 47.32653f, 42.0f, 47.32653f);
                instancePath.lineTo(6.0f, 47.32653f);
                instancePath.cubicTo(2.6891508f, 47.32653f, 0.0f, 44.698895f, 0.0f, 41.32653f);
                instancePath.lineTo(0.0f, 6.3265305f);
                instancePath.lineTo(0.0f, 6.3265305f);
                instancePath.close();
                instancePath.moveTo(4.0f, 6.3265305f);
                instancePath.cubicTo(4.0f, 5.198393f, 4.89154f, 4.3265305f, 6.0f, 4.3265305f);
                instancePath.lineTo(42.0f, 4.3265305f);
                instancePath.cubicTo(43.10578f, 4.3265305f, 44.0f, 5.195782f, 44.0f, 6.3265305f);
                instancePath.lineTo(44.0f, 41.32653f);
                instancePath.cubicTo(44.0f, 42.45467f, 43.10846f, 43.32653f, 42.0f, 43.32653f);
                instancePath.lineTo(6.0f, 43.32653f);
                instancePath.cubicTo(4.894218f, 43.32653f, 4.0f, 42.45728f, 4.0f, 41.32653f);
                instancePath.lineTo(4.0f, 6.3265305f);
                instancePath.lineTo(4.0f, 6.3265305f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
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
