package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class new_voice2txt_trans_en extends c {
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 0.9945219f, -0.104528464f, 1.3303998f, 0.104528464f, 0.9945219f, -1.2475461f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(13.01f, 18.138f);
                instancePath.lineTo(13.01f, 16.557f);
                instancePath.lineTo(5.853f, 16.557f);
                instancePath.lineTo(5.853f, 12.698f);
                instancePath.lineTo(12.313f, 12.698f);
                instancePath.lineTo(12.313f, 11.117f);
                instancePath.lineTo(5.853f, 11.117f);
                instancePath.lineTo(5.853f, 7.581f);
                instancePath.lineTo(12.721f, 7.581f);
                instancePath.lineTo(12.721f, 6.0f);
                instancePath.lineTo(4.0f, 6.0f);
                instancePath.lineTo(4.0f, 18.138f);
                instancePath.lineTo(13.01f, 18.138f);
                instancePath.close();
                instancePath.moveTo(15.9f, 18.138f);
                instancePath.lineTo(15.9f, 13.473f);
                instancePath.cubicTo(15.96f, 12.843f, 16.185f, 12.348f, 16.545f, 11.988f);
                instancePath.cubicTo(16.875f, 11.658f, 17.28f, 11.508f, 17.73f, 11.508f);
                instancePath.cubicTo(18.93f, 11.508f, 19.545f, 12.168f, 19.545f, 13.488f);
                instancePath.lineTo(19.545f, 18.138f);
                instancePath.lineTo(21.135f, 18.138f);
                instancePath.lineTo(21.135f, 13.353f);
                instancePath.cubicTo(21.135f, 11.223f, 20.16f, 10.173f, 18.24f, 10.173f);
                instancePath.cubicTo(17.76f, 10.173f, 17.325f, 10.263f, 16.935f, 10.473f);
                instancePath.cubicTo(16.545f, 10.668f, 16.2f, 10.953f, 15.9f, 11.343f);
                instancePath.lineTo(15.9f, 10.383f);
                instancePath.lineTo(14.31f, 10.383f);
                instancePath.lineTo(14.31f, 18.138f);
                instancePath.lineTo(15.9f, 18.138f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
