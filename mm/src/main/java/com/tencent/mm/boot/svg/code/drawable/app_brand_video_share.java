package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class app_brand_video_share extends c {
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
                instancePaint3.setColor(-1);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 4.0f, 0.0f, 1.0f, 2.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(14.8f, 6.2f);
                instancePath.lineTo(12.0f, 6.2f);
                instancePath.lineTo(12.0f, 5.0f);
                instancePath.lineTo(15.001043f, 5.0f);
                instancePath.cubicTo(15.55087f, 5.0f, 16.0f, 5.4458385f, 16.0f, 5.9958086f);
                instancePath.lineTo(16.0f, 19.004192f);
                instancePath.cubicTo(16.0f, 19.55108f, 15.554161f, 20.0f, 15.004191f, 20.0f);
                instancePath.lineTo(0.99580854f, 20.0f);
                instancePath.cubicTo(0.4489202f, 20.0f, 8.881784E-16f, 19.554161f, 8.881784E-16f, 19.004192f);
                instancePath.lineTo(0.0f, 5.9958086f);
                instancePath.cubicTo(0.0f, 5.4489202f, 0.4472481f, 5.0f, 0.99895656f, 5.0f);
                instancePath.lineTo(4.0f, 5.0f);
                instancePath.lineTo(4.0f, 6.2f);
                instancePath.lineTo(1.2f, 6.2f);
                instancePath.lineTo(1.2f, 18.8f);
                instancePath.lineTo(14.8f, 18.8f);
                instancePath.lineTo(14.8f, 6.2f);
                instancePath.close();
                instancePath.moveTo(8.599994f, 2.2615163f);
                instancePath.lineTo(8.599994f, 11.5f);
                instancePath.lineTo(7.399994f, 11.5f);
                instancePath.lineTo(7.399994f, 2.2615285f);
                instancePath.lineTo(5.3129945f, 4.3485284f);
                instancePath.lineTo(4.464466f, 3.5f);
                instancePath.lineTo(7.2928934f, 0.67157286f);
                instancePath.cubicTo(7.6834173f, 0.2810486f, 8.316583f, 0.2810486f, 8.707107f, 0.67157286f);
                instancePath.lineTo(11.535534f, 3.5f);
                instancePath.lineTo(10.687006f, 4.3485284f);
                instancePath.lineTo(8.599994f, 2.2615163f);
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
