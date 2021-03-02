package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class chat_reject_title_icon extends c {
    private final int height = 42;
    private final int width = 42;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 42;
            case 1:
                return 42;
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
                canvas.saveLayerAlpha(null, 102, 31);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-1);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -1491.0f, 0.0f, 1.0f, -387.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(1492.763f, 389.7632f);
                instancePath.cubicTo(1492.5024f, 389.2075f, 1492.6007f, 388.5263f, 1493.0635f, 388.06348f);
                instancePath.cubicTo(1493.6508f, 387.47614f, 1494.6017f, 387.4747f, 1495.1901f, 388.0631f);
                instancePath.lineTo(1501.127f, 394.0f);
                instancePath.lineTo(1523.9926f, 394.0f);
                instancePath.cubicTo(1525.6536f, 394.0f, 1527.0f, 395.3431f, 1527.0f, 397.00793f);
                instancePath.lineTo(1527.0f, 416.99207f);
                instancePath.cubicTo(1527.0f, 417.79025f, 1526.6876f, 418.51584f, 1526.1813f, 419.05432f);
                instancePath.lineTo(1530.607f, 423.48016f);
                instancePath.cubicTo(1531.1942f, 424.0673f, 1531.1981f, 425.01532f, 1530.6067f, 425.60675f);
                instancePath.cubicTo(1530.147f, 426.06656f, 1529.4644f, 426.16727f, 1528.9072f, 425.907f);
                instancePath.cubicTo(1528.8348f, 425.75256f, 1528.7347f, 425.60782f, 1528.607f, 425.48016f);
                instancePath.lineTo(1493.1901f, 390.0631f);
                instancePath.cubicTo(1493.0623f, 389.93536f, 1492.9175f, 389.8354f, 1492.763f, 389.7632f);
                instancePath.close();
                instancePath.moveTo(1493.0339f, 394.16092f);
                instancePath.cubicTo(1491.8503f, 394.56543f, 1491.0f, 395.6873f, 1491.0f, 397.00793f);
                instancePath.lineTo(1491.0f, 416.99207f);
                instancePath.cubicTo(1491.0f, 418.6569f, 1492.3418f, 420.0f, 1493.9968f, 420.0f);
                instancePath.lineTo(1500.0f, 420.0f);
                instancePath.lineTo(1500.0f, 426.8875f);
                instancePath.cubicTo(1500.0f, 428.08762f, 1500.6836f, 428.36902f, 1501.5267f, 427.5205f);
                instancePath.lineTo(1509.0f, 420.0f);
                instancePath.lineTo(1518.873f, 420.0f);
                instancePath.lineTo(1493.0339f, 394.16092f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
