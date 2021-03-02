package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_remove_bg extends c {
    private final int height = 32;
    private final int width = 32;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 32;
            case 1:
                return 32;
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
                Paint instancePaint3 = c.instancePaint(instancePaint2, looper);
                instancePaint3.setStrokeWidth(1.0f);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(WebView.NIGHT_MODE_COLOR);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 4.0f, 0.0f, 1.0f, 4.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(4.8703823f, 23.2f);
                instancePath.lineTo(1.8181819f, 23.2f);
                instancePath.cubicTo(1.2558556f, 23.2f, 0.8f, 22.744144f, 0.8f, 22.181818f);
                instancePath.lineTo(0.8f, 18.120138f);
                instancePath.lineTo(2.3047714f, 18.120138f);
                instancePath.lineTo(2.3047714f, 21.8f);
                instancePath.lineTo(4.8703823f, 21.8f);
                instancePath.lineTo(21.666151f, 21.784334f);
                instancePath.lineTo(21.666151f, 18.11097f);
                instancePath.lineTo(23.197655f, 18.11097f);
                instancePath.lineTo(23.197655f, 22.181818f);
                instancePath.cubicTo(23.197655f, 22.744144f, 22.741798f, 23.2f, 22.179474f, 23.2f);
                instancePath.lineTo(4.8703823f, 23.2f);
                instancePath.close();
                instancePath.moveTo(1.8181819f, 0.8f);
                instancePath.lineTo(5.916729f, 0.8f);
                instancePath.lineTo(5.916729f, 2.347675f);
                instancePath.lineTo(2.3225772f, 2.347675f);
                instancePath.lineTo(2.3225772f, 5.883533f);
                instancePath.lineTo(0.8f, 5.883533f);
                instancePath.lineTo(0.8f, 1.8181819f);
                instancePath.cubicTo(0.8f, 1.2558556f, 1.2558556f, 0.8f, 1.8181819f, 0.8f);
                instancePath.close();
                instancePath.moveTo(22.179474f, 0.8f);
                instancePath.cubicTo(22.741798f, 0.8f, 23.197655f, 1.2558556f, 23.197655f, 1.8181819f);
                instancePath.lineTo(23.197655f, 5.9032164f);
                instancePath.lineTo(21.644531f, 5.9032164f);
                instancePath.lineTo(21.644531f, 2.3631027f);
                instancePath.lineTo(18.140741f, 2.3631027f);
                instancePath.lineTo(18.140741f, 0.8f);
                instancePath.lineTo(22.179474f, 0.8f);
                instancePath.close();
                instancePath.moveTo(8.945455f, 0.8f);
                instancePath.lineTo(15.054545f, 0.8f);
                instancePath.lineTo(15.054545f, 2.3272727f);
                instancePath.lineTo(8.945455f, 2.3272727f);
                instancePath.lineTo(8.945455f, 0.8f);
                instancePath.close();
                instancePath.moveTo(0.8f, 8.942418f);
                instancePath.lineTo(2.3272727f, 8.942418f);
                instancePath.lineTo(2.3272727f, 15.037204f);
                instancePath.lineTo(0.8f, 15.037204f);
                instancePath.lineTo(0.8f, 8.942418f);
                instancePath.close();
                instancePath.moveTo(21.672728f, 8.945455f);
                instancePath.lineTo(23.2f, 8.945455f);
                instancePath.lineTo(23.2f, 15.04024f);
                instancePath.lineTo(21.672728f, 15.04024f);
                instancePath.lineTo(21.672728f, 8.945455f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint4, looper);
                Paint instancePaint7 = c.instancePaint(instancePaint3, looper);
                instancePaint6.setColor(-100663296);
                instancePaint7.setColor(WebView.NIGHT_MODE_COLOR);
                instancePaint7.setStrokeWidth(1.4f);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(3.6129918f, 21.103752f);
                instancePath2.lineTo(20.387997f, 21.103752f);
                instancePath2.cubicTo(20.26201f, 20.916302f, 20.099764f, 20.75753f, 19.931206f, 20.675081f);
                instancePath2.lineTo(14.370157f, 17.954939f);
                instancePath2.cubicTo(13.151746f, 17.358963f, 12.857854f, 15.951832f, 13.730429f, 14.914611f);
                instancePath2.lineTo(14.085618f, 14.4924f);
                instancePath2.cubicTo(14.70045f, 13.761557f, 15.229825f, 12.311421f, 15.229825f, 11.35559f);
                instancePath2.lineTo(15.229825f, 9.670945f);
                instancePath2.cubicTo(15.229825f, 7.8818307f, 13.782598f, 6.43f, 12.0f, 6.43f);
                instancePath2.cubicTo(10.219405f, 6.43f, 8.770175f, 7.8819757f, 8.770175f, 9.670327f);
                instancePath2.lineTo(8.770175f, 11.354709f);
                instancePath2.cubicTo(8.770175f, 12.312657f, 9.297517f, 13.757827f, 9.914351f, 14.490951f);
                instancePath2.lineTo(10.269541f, 14.913103f);
                instancePath2.cubicTo(11.143951f, 15.952363f, 10.846876f, 17.358044f, 9.629946f, 17.95354f);
                instancePath2.lineTo(4.068897f, 20.67481f);
                instancePath2.cubicTo(3.9011364f, 20.756903f, 3.739076f, 20.916063f, 3.6129918f, 21.103752f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                canvas.drawPath(instancePath2, instancePaint6);
                canvas.drawPath(instancePath2, instancePaint7);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
