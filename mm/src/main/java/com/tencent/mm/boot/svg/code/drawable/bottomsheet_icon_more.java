package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class bottomsheet_icon_more extends c {
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 40.0f, 0.0f, 1.0f, 8.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-8617851);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(8.0f, 65.0f);
                instancePath.cubicTo(3.5817778f, 65.0f, 0.0f, 68.58178f, 0.0f, 73.0f);
                instancePath.cubicTo(0.0f, 77.41822f, 3.5817778f, 81.0f, 8.0f, 81.0f);
                instancePath.cubicTo(12.418222f, 81.0f, 16.0f, 77.41822f, 16.0f, 73.0f);
                instancePath.cubicTo(16.0f, 68.58178f, 12.418222f, 65.0f, 8.0f, 65.0f);
                instancePath.moveTo(8.0f, 32.0f);
                instancePath.cubicTo(3.5817778f, 32.0f, 0.0f, 35.58178f, 0.0f, 40.0f);
                instancePath.cubicTo(0.0f, 44.41822f, 3.5817778f, 48.0f, 8.0f, 48.0f);
                instancePath.cubicTo(12.418222f, 48.0f, 16.0f, 44.41822f, 16.0f, 40.0f);
                instancePath.cubicTo(16.0f, 35.58178f, 12.418222f, 32.0f, 8.0f, 32.0f);
                instancePath.moveTo(16.0f, 8.0f);
                instancePath.cubicTo(16.0f, 3.5817778f, 12.418222f, 0.0f, 8.0f, 0.0f);
                instancePath.cubicTo(3.5817778f, 0.0f, 0.0f, 3.5817778f, 0.0f, 8.0f);
                instancePath.cubicTo(0.0f, 12.418222f, 3.5817778f, 16.0f, 8.0f, 16.0f);
                instancePath.cubicTo(12.418222f, 16.0f, 16.0f, 12.418222f, 16.0f, 8.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
