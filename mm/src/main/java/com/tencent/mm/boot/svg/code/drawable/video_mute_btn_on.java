package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class video_mute_btn_on extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-419430401);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 2.0f, 0.0f, 1.0f, 4.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(9.3f, 0.7f);
                instancePath.cubicTo(9.7f, 0.3f, 10.3f, 0.3f, 10.7f, 0.7f);
                instancePath.cubicTo(10.9f, 0.9f, 11.0f, 1.1f, 11.0f, 1.4f);
                instancePath.lineTo(11.0f, 14.6f);
                instancePath.cubicTo(11.0f, 15.2f, 10.6f, 15.6f, 10.0f, 15.6f);
                instancePath.cubicTo(9.7f, 15.6f, 9.5f, 15.5f, 9.3f, 15.3f);
                instancePath.lineTo(5.5f, 11.5f);
                instancePath.lineTo(1.0f, 11.5f);
                instancePath.cubicTo(0.4f, 11.5f, 0.0f, 11.1f, 0.0f, 10.5f);
                instancePath.lineTo(0.0f, 5.5f);
                instancePath.cubicTo(0.0f, 4.9f, 0.4f, 4.5f, 1.0f, 4.5f);
                instancePath.lineTo(5.5f, 4.5f);
                instancePath.lineTo(9.3f, 0.7f);
                instancePath.close();
                instancePath.moveTo(16.2f, 13.9f);
                instancePath.lineTo(15.1f, 12.8f);
                instancePath.lineTo(15.2f, 12.7f);
                instancePath.cubicTo(16.5f, 11.4f, 17.1f, 9.8f, 17.1f, 8.0f);
                instancePath.cubicTo(17.1f, 6.2f, 16.4f, 4.6f, 15.2f, 3.3f);
                instancePath.lineTo(15.1f, 3.2f);
                instancePath.lineTo(16.2f, 2.1f);
                instancePath.lineTo(16.3f, 2.2f);
                instancePath.cubicTo(17.8f, 3.7f, 18.7f, 5.8f, 18.7f, 8.0f);
                instancePath.cubicTo(18.7f, 10.2f, 17.9f, 12.2f, 16.3f, 13.8f);
                instancePath.lineTo(16.2f, 13.9f);
                instancePath.close();
                instancePath.moveTo(14.2f, 11.9f);
                instancePath.lineTo(13.1f, 10.8f);
                instancePath.lineTo(13.2f, 10.7f);
                instancePath.cubicTo(13.9f, 10.0f, 14.3f, 9.0f, 14.3f, 8.0f);
                instancePath.cubicTo(14.3f, 7.0f, 13.9f, 6.0f, 13.2f, 5.3f);
                instancePath.lineTo(13.1f, 5.2f);
                instancePath.lineTo(14.2f, 4.1f);
                instancePath.lineTo(14.3f, 4.2f);
                instancePath.cubicTo(15.3f, 5.2f, 15.9f, 6.6f, 15.9f, 8.0f);
                instancePath.cubicTo(15.9f, 9.4f, 15.3f, 10.8f, 14.3f, 11.8f);
                instancePath.lineTo(14.2f, 11.9f);
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
