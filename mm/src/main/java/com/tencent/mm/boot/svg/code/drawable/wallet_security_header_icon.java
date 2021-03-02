package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class wallet_security_header_icon extends c {
    private final int height = 64;
    private final int width = 64;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 64;
            case 1:
                return 64;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 10.0f, 0.0f, 1.0f, 6.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 0.666667f, 0.0f, 1.0f, 0.333333f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-16268960);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(21.333334f, 0.33333334f);
                instancePath.lineTo(42.666668f, 8.333333f);
                instancePath.lineTo(42.666668f, 23.67677f);
                instancePath.cubicTo(42.666668f, 36.600384f, 33.87108f, 47.865562f, 21.333334f, 51.0f);
                instancePath.cubicTo(8.795588f, 47.865562f, 0.0f, 36.600384f, 0.0f, 23.67677f);
                instancePath.lineTo(0.0f, 8.333333f);
                instancePath.lineTo(21.333334f, 0.33333334f);
                instancePath.close();
                instancePath.moveTo(21.333334f, 3.6318178f);
                instancePath.lineTo(3.2f, 10.831818f);
                instancePath.lineTo(3.2f, 23.67677f);
                instancePath.cubicTo(3.2f, 34.86344f, 10.634958f, 44.648228f, 21.333334f, 47.688324f);
                instancePath.cubicTo(32.031708f, 44.648228f, 39.466667f, 34.86344f, 39.466667f, 23.67677f);
                instancePath.lineTo(39.467133f, 21.204887f);
                instancePath.cubicTo(36.813263f, 22.641478f, 33.689526f, 24.33242f, 30.625566f, 25.991001f);
                instancePath.lineTo(29.93517f, 26.364727f);
                instancePath.cubicTo(23.16068f, 30.031889f, 16.877098f, 33.433315f, 16.877098f, 33.433315f);
                instancePath.lineTo(16.717777f, 33.519974f);
                instancePath.cubicTo(16.521044f, 33.612293f, 16.299564f, 33.666668f, 16.064812f, 33.666668f);
                instancePath.cubicTo(15.519867f, 33.666668f, 15.046134f, 33.385174f, 14.797499f, 32.969448f);
                instancePath.lineTo(14.702752f, 32.774612f);
                instancePath.lineTo(10.736067f, 24.60621f);
                instancePath.cubicTo(10.69322f, 24.517288f, 10.666667f, 24.416471f, 10.666667f, 24.318487f);
                instancePath.cubicTo(10.666667f, 23.942408f, 10.991943f, 23.637691f, 11.392655f, 23.637691f);
                instancePath.cubicTo(11.556802f, 23.637691f, 11.705862f, 23.6881f, 11.827765f, 23.773058f);
                instancePath.lineTo(16.507767f, 26.900068f);
                instancePath.cubicTo(16.848734f, 27.10963f, 17.258497f, 27.233103f, 17.697832f, 27.233103f);
                instancePath.cubicTo(17.95914f, 27.233103f, 18.209585f, 27.187792f, 18.441925f, 27.107931f);
                instancePath.cubicTo(18.441925f, 27.107931f, 18.463028f, 27.099138f, 18.503962f, 27.082083f);
                instancePath.lineTo(18.611895f, 27.037111f);
                instancePath.cubicTo(19.680883f, 26.591705f, 25.610056f, 24.121304f, 31.197025f, 21.794615f);
                instancePath.lineTo(31.893238f, 21.504684f);
                instancePath.cubicTo(34.83235f, 20.280748f, 37.614674f, 19.12247f, 39.467327f, 18.35204f);
                instancePath.lineTo(39.466667f, 10.831818f);
                instancePath.lineTo(21.333334f, 3.6318178f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(0.0f, 0.0f);
                instancePath2.lineTo(64.0f, 0.0f);
                instancePath2.lineTo(64.0f, 64.0f);
                instancePath2.lineTo(0.0f, 64.0f);
                instancePath2.lineTo(0.0f, 0.0f);
                instancePath2.close();
                c.done(looper);
                break;
        }
        return 0;
    }
}
