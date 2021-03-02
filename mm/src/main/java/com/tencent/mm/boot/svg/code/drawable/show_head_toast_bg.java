package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.p.z;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class show_head_toast_bg extends c {
    private final int height = z.CTRL_INDEX;
    private final int width = z.CTRL_INDEX;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return z.CTRL_INDEX;
            case 1:
                return z.CTRL_INDEX;
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-3355444);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 0.70710677f, 0.70710677f, -41.00714f, -0.70710677f, 0.70710677f, 99.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(168.0f, 99.0f);
                instancePath.lineTo(168.0f, 165.0f);
                instancePath.cubicTo(168.0f, 166.65686f, 166.65686f, 168.0f, 165.0f, 168.0f);
                instancePath.lineTo(99.0f, 168.0f);
                instancePath.cubicTo(60.892353f, 168.0f, 30.0f, 137.10765f, 30.0f, 99.0f);
                instancePath.cubicTo(30.0f, 60.892353f, 60.892353f, 30.0f, 99.0f, 30.0f);
                instancePath.cubicTo(137.10765f, 30.0f, 168.0f, 60.892353f, 168.0f, 99.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
