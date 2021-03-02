package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_live_like extends c {
    private final int height = 8;
    private final int width = 10;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 10;
            case 1:
                return 8;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -1.0f, 0.0f, 1.0f, -2.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(2.267767f, 2.8890872f);
                instancePath.cubicTo(3.2440777f, 1.9127766f, 4.82699f, 1.9127766f, 5.803301f, 2.8890872f);
                instancePath.cubicTo(5.8947043f, 2.9804907f, 6.012555f, 3.0941706f, 6.156854f, 3.230127f);
                instancePath.cubicTo(6.301153f, 3.0941706f, 6.4190044f, 2.9804907f, 6.5104074f, 2.8890872f);
                instancePath.cubicTo(7.486718f, 1.9127766f, 9.069631f, 1.9127766f, 10.045941f, 2.8890872f);
                instancePath.cubicTo(11.01317f, 3.8563163f, 11.022168f, 5.4189143f, 10.072933f, 6.3972197f);
                instancePath.lineTo(6.863924f, 9.6065645f);
                instancePath.cubicTo(6.4734573f, 9.997147f, 5.840292f, 9.99718f, 5.4497476f, 9.606676f);
                instancePath.cubicTo(5.449735f, 9.606664f, 5.449723f, 9.606651f, 5.4497476f, 9.606602f);
                instancePath.lineTo(2.2405705f, 6.3974247f);
                instancePath.lineTo(2.2405705f, 6.3974247f);
                instancePath.cubicTo(1.2915407f, 5.4189143f, 1.3005378f, 3.8563163f, 2.267767f, 2.8890872f);
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
