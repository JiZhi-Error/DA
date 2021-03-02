package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.smtt.sdk.WebView;

public class avatar_choose extends c {
    private final int height = 160;
    private final int width = TbsListener.ErrorCode.DECOUPLE_INCURUPDATE_FAIL;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return TbsListener.ErrorCode.DECOUPLE_INCURUPDATE_FAIL;
            case 1:
                return 160;
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
                instancePaint3.setColor(-15028967);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 3.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(212.0f, 0.0f);
                instancePath.cubicTo(216.63023f, 5.5596924f, 222.31512f, 11.159097f, 228.0f, 16.0f);
                instancePath.cubicTo(200.60638f, 43.807625f, 144.0f, 96.0f, 144.0f, 96.0f);
                instancePath.cubicTo(144.0f, 96.0f, 103.635574f, 139.2875f, 84.0f, 160.0f);
                instancePath.cubicTo(55.03448f, 132.87665f, 27.537401f, 105.75329f, 0.0f, 80.0f);
                instancePath.cubicTo(5.6445622f, 72.9511f, 11.329443f, 67.31199f, 16.0f, 60.0f);
                instancePath.cubicTo(38.94748f, 83.276245f, 60.719364f, 104.83991f, 84.0f, 128.0f);
                instancePath.cubicTo(125.47056f, 84.22934f, 168.12732f, 42.0551f, 212.0f, 0.0f);
                instancePath.lineTo(212.0f, 0.0f);
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
