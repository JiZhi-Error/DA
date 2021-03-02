package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class download_wait_wifi_dark extends c {
    private final int height = 25;
    private final int width = 24;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 24;
            case 1:
                return 25;
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
                instancePaint3.setColor(-2130706433);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -300.0f, 0.0f, 1.0f, -361.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 80.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray3 = c.setMatrixFloatArray(matrixFloatArray2, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 256.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray3);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray4 = c.setMatrixFloatArray(matrixFloatArray3, -1.0f, -1.2246469E-16f, 336.0f, 1.2246469E-16f, -1.0f, 62.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray4);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray5 = c.setMatrixFloatArray(matrixFloatArray4, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 12.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray5);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                float[] matrixFloatArray6 = c.setMatrixFloatArray(matrixFloatArray5, 1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 25.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray6);
                canvas.concat(instanceMatrix);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(12.0f, 14.631578f);
                instancePath.cubicTo(12.616123f, 14.631578f, 13.1739645f, 14.896249f, 13.577975f, 15.324244f);
                instancePath.lineTo(11.996474f, 17.0f);
                instancePath.lineTo(10.420135f, 15.326248f);
                instancePath.cubicTo(10.824295f, 14.897076f, 11.3829155f, 14.631578f, 12.0f, 14.631578f);
                instancePath.close();
                instancePath.moveTo(12.0f, 11.315789f);
                instancePath.cubicTo(13.479392f, 11.315789f, 14.818777f, 11.951595f, 15.788511f, 12.979636f);
                instancePath.lineTo(14.524904f, 14.318941f);
                instancePath.cubicTo(13.878475f, 13.634061f, 12.985869f, 13.210526f, 12.0f, 13.210526f);
                instancePath.cubicTo(11.012694f, 13.210526f, 10.118925f, 13.635295f, 9.472273f, 14.321935f);
                instancePath.lineTo(8.209602f, 12.981636f);
                instancePath.cubicTo(9.179486f, 11.95242f, 10.519649f, 11.315789f, 12.0f, 11.315789f);
                instancePath.close();
                instancePath.moveTo(12.0f, 8.0f);
                instancePath.cubicTo(14.343145f, 8.0f, 16.464466f, 9.0073595f, 18.0f, 10.636039f);
                instancePath.lineTo(16.736841f, 11.975821f);
                instancePath.cubicTo(15.524578f, 10.690021f, 13.849852f, 9.894737f, 12.0f, 9.894737f);
                instancePath.cubicTo(10.149678f, 9.894737f, 8.47457f, 10.690425f, 7.262234f, 11.9768f);
                instancePath.lineTo(6.0f, 10.636039f);
                instancePath.cubicTo(7.535534f, 9.0073595f, 9.656855f, 8.0f, 12.0f, 8.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
