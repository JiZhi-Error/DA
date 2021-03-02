package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class wecoin_notice_icon extends c {
    private final int height = 18;
    private final int width = 21;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 21;
            case 1:
                return 18;
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
                instancePaint3.setColor(-15658735);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -1574.0f, 0.0f, 1.0f, -6077.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 191.0f, 0.0f, 1.0f, 5493.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray3 = c.setMatrixFloatArray(matrixFloatArray2, 1.0f, 0.0f, 87.0f, 0.0f, 1.0f, 40.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray3);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray4 = c.setMatrixFloatArray(matrixFloatArray3, 1.0f, 0.0f, 1294.0f, 0.0f, 1.0f, 541.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray4);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(15.333333f, 3.536165f);
                instancePath.cubicTo(15.701523f, 3.536165f, 16.0f, 3.834642f, 16.0f, 4.2028317f);
                instancePath.lineTo(16.0f, 4.2028317f);
                instancePath.lineTo(16.0f, 19.797169f);
                instancePath.cubicTo(16.0f, 19.922115f, 15.964887f, 20.044546f, 15.898665f, 20.150501f);
                instancePath.cubicTo(15.703526f, 20.462725f, 15.292225f, 20.55764f, 14.9800005f, 20.362501f);
                instancePath.lineTo(14.9800005f, 20.362501f);
                instancePath.lineTo(8.0f, 16.0f);
                instancePath.lineTo(6.0f, 16.0f);
                instancePath.cubicTo(3.790861f, 16.0f, 2.0f, 14.209139f, 2.0f, 12.0f);
                instancePath.cubicTo(2.0f, 9.790861f, 3.790861f, 8.0f, 6.0f, 8.0f);
                instancePath.lineTo(6.0f, 8.0f);
                instancePath.lineTo(8.0f, 8.0f);
                instancePath.lineTo(14.9800005f, 3.6374996f);
                instancePath.cubicTo(15.085955f, 3.571278f, 15.208387f, 3.536165f, 15.333333f, 3.536165f);
                instancePath.close();
                instancePath.moveTo(18.442959f, 15.105398f);
                instancePath.lineTo(22.446865f, 17.105398f);
                instancePath.lineTo(21.553135f, 18.894602f);
                instancePath.lineTo(17.549229f, 16.894602f);
                instancePath.lineTo(18.442959f, 15.105398f);
                instancePath.close();
                instancePath.moveTo(22.0f, 11.0f);
                instancePath.lineTo(22.0f, 13.0f);
                instancePath.lineTo(17.996094f, 13.0f);
                instancePath.lineTo(17.996094f, 11.0f);
                instancePath.lineTo(22.0f, 11.0f);
                instancePath.close();
                instancePath.moveTo(21.553135f, 5.105398f);
                instancePath.lineTo(22.446865f, 6.894602f);
                instancePath.lineTo(18.442959f, 8.894602f);
                instancePath.lineTo(17.549229f, 7.105398f);
                instancePath.lineTo(21.553135f, 5.105398f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
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
