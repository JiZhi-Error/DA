package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class fav_addtab_normal extends c {
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 2.0f, 0.0f, 1.0f, 3.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(1.2071068f, 11.207107f);
                instancePath.cubicTo(0.8165825f, 10.816583f, 0.8165825f, 10.183417f, 1.2071068f, 9.792893f);
                instancePath.lineTo(10.707107f, 0.29289323f);
                instancePath.cubicTo(10.894643f, 0.10535684f, 11.148997f, 1.073389E-14f, 11.414213f, 1.0214052E-14f);
                instancePath.lineTo(18.0f, 0.0f);
                instancePath.cubicTo(18.552284f, -1.0145306E-16f, 19.0f, 0.44771525f, 19.0f, 1.0f);
                instancePath.lineTo(19.0f, 7.5857863f);
                instancePath.cubicTo(19.0f, 7.8510027f, 18.894644f, 8.105357f, 18.707108f, 8.292893f);
                instancePath.lineTo(9.207107f, 17.792892f);
                instancePath.cubicTo(8.816583f, 18.183418f, 8.183417f, 18.183418f, 7.7928934f, 17.792892f);
                instancePath.lineTo(1.2071068f, 11.207107f);
                instancePath.close();
                instancePath.moveTo(17.8f, 7.5029435f);
                instancePath.lineTo(17.8f, 1.2f);
                instancePath.lineTo(11.497056f, 1.2f);
                instancePath.lineTo(2.1970563f, 10.5f);
                instancePath.lineTo(8.5f, 16.802944f);
                instancePath.lineTo(17.8f, 7.5029435f);
                instancePath.close();
                instancePath.moveTo(14.0f, 6.5f);
                instancePath.cubicTo(13.171573f, 6.5f, 12.5f, 5.8284273f, 12.5f, 5.0f);
                instancePath.cubicTo(12.5f, 4.1715727f, 13.171573f, 3.5f, 14.0f, 3.5f);
                instancePath.cubicTo(14.828427f, 3.5f, 15.5f, 4.1715727f, 15.5f, 5.0f);
                instancePath.cubicTo(15.5f, 5.8284273f, 14.828427f, 6.5f, 14.0f, 6.5f);
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
