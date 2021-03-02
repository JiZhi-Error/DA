package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class app_attach_file_icon_sound extends c {
    private final int height = 90;
    private final int width = 90;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 90;
            case 1:
                return 90;
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
                instancePaint3.setColor(-855310);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(90.0f, 0.0f);
                instancePath.lineTo(90.0f, 90.0f);
                instancePath.lineTo(0.0f, 90.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(WebView.NIGHT_MODE_COLOR);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 30.0f, 0.0f, 1.0f, 24.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.saveLayerAlpha(null, 153, 31);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(13.125807f, 35.88405f);
                instancePath2.cubicTo(5.7260823f, 34.961723f, 9.368011E-16f, 28.64956f, 0.0f, 21.0f);
                instancePath2.lineTo(0.0f, 17.25f);
                instancePath2.lineTo(3.75f, 17.25f);
                instancePath2.lineTo(3.75f, 21.0f);
                instancePath2.cubicTo(3.75f, 27.213203f, 8.786797f, 32.25f, 15.0f, 32.25f);
                instancePath2.cubicTo(21.213203f, 32.25f, 26.25f, 27.213203f, 26.25f, 21.0f);
                instancePath2.lineTo(26.25f, 17.25f);
                instancePath2.lineTo(30.0f, 17.25f);
                instancePath2.lineTo(30.0f, 21.0f);
                instancePath2.cubicTo(30.0f, 28.649282f, 24.274334f, 34.961266f, 16.875f, 35.88395f);
                instancePath2.lineTo(16.875f, 42.0f);
                instancePath2.lineTo(13.12812f, 42.0f);
                instancePath2.lineTo(13.125807f, 35.88405f);
                instancePath2.close();
                instancePath2.moveTo(15.0f, 0.0f);
                instancePath2.cubicTo(19.142136f, -7.6089796E-16f, 22.5f, 3.3578644f, 22.5f, 7.5f);
                instancePath2.lineTo(22.5f, 21.0f);
                instancePath2.cubicTo(22.5f, 25.142136f, 19.142136f, 28.5f, 15.0f, 28.5f);
                instancePath2.cubicTo(10.857864f, 28.5f, 7.5f, 25.142136f, 7.5f, 21.0f);
                instancePath2.lineTo(7.5f, 7.5f);
                instancePath2.cubicTo(7.5f, 3.3578644f, 10.857864f, 7.6089796E-16f, 15.0f, 0.0f);
                instancePath2.close();
                instancePath2.moveTo(15.0f, 3.75f);
                instancePath2.cubicTo(12.928932f, 3.75f, 11.25f, 5.428932f, 11.25f, 7.5f);
                instancePath2.lineTo(11.25f, 21.0f);
                instancePath2.cubicTo(11.25f, 23.071068f, 12.928932f, 24.75f, 15.0f, 24.75f);
                instancePath2.cubicTo(17.071068f, 24.75f, 18.75f, 23.071068f, 18.75f, 21.0f);
                instancePath2.lineTo(18.75f, 7.5f);
                instancePath2.cubicTo(18.75f, 5.428932f, 17.071068f, 3.75f, 15.0f, 3.75f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
