package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outline_miniprogram_live extends c {
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
                instancePaint3.setColor(-10197008);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 2.0f, 0.0f, 1.0f, 5.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(1.2f, 1.7f);
                instancePath.lineTo(1.2f, 12.3f);
                instancePath.lineTo(13.8f, 12.3f);
                instancePath.lineTo(13.8f, 1.7f);
                instancePath.lineTo(1.2f, 1.7f);
                instancePath.close();
                instancePath.moveTo(1.0f, 0.5f);
                instancePath.lineTo(14.0f, 0.5f);
                instancePath.cubicTo(14.552284f, 0.5f, 15.0f, 0.9477152f, 15.0f, 1.5f);
                instancePath.lineTo(15.0f, 12.5f);
                instancePath.cubicTo(15.0f, 13.052284f, 14.552284f, 13.5f, 14.0f, 13.5f);
                instancePath.lineTo(1.0f, 13.5f);
                instancePath.cubicTo(0.44771525f, 13.5f, 0.0f, 13.052284f, 0.0f, 12.5f);
                instancePath.lineTo(0.0f, 1.5f);
                instancePath.cubicTo(0.0f, 0.9477152f, 0.44771525f, 0.5f, 1.0f, 0.5f);
                instancePath.close();
                instancePath.moveTo(17.2f, 8.42325f);
                instancePath.lineTo(19.8f, 10.50325f);
                instancePath.lineTo(19.8f, 3.4967499f);
                instancePath.lineTo(17.2f, 5.57675f);
                instancePath.lineTo(17.2f, 8.42325f);
                instancePath.close();
                instancePath.moveTo(16.0f, 5.0f);
                instancePath.lineTo(19.375305f, 2.299756f);
                instancePath.cubicTo(19.806566f, 1.9547465f, 20.43586f, 2.024668f, 20.780869f, 2.4559298f);
                instancePath.cubicTo(20.92272f, 2.6332428f, 21.0f, 2.8535533f, 21.0f, 3.0806248f);
                instancePath.lineTo(21.0f, 10.919375f);
                instancePath.cubicTo(21.0f, 11.47166f, 20.552284f, 11.919375f, 20.0f, 11.919375f);
                instancePath.cubicTo(19.772928f, 11.919375f, 19.552618f, 11.842094f, 19.375305f, 11.700244f);
                instancePath.lineTo(16.0f, 9.0f);
                instancePath.lineTo(16.0f, 5.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(5.9f, 8.299999f);
                instancePath2.cubicTo(6.5075135f, 8.299999f, 7.0f, 8.792486f, 7.0f, 9.4f);
                instancePath2.cubicTo(7.0f, 10.007513f, 6.5075135f, 10.5f, 5.9f, 10.5f);
                instancePath2.cubicTo(5.2924867f, 10.5f, 4.8f, 10.007513f, 4.8f, 9.4f);
                instancePath2.cubicTo(4.8f, 8.792486f, 5.2924867f, 8.299999f, 5.9f, 8.299999f);
                instancePath2.close();
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
