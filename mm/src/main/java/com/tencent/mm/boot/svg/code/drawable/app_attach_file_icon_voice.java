package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class app_attach_file_icon_voice extends c {
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 30.0f, 0.0f, 1.0f, 23.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.saveLayerAlpha(null, 153, 31);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(21.213203f, 0.54296666f);
                instancePath2.cubicTo(26.642136f, 6.0343003f, 30.0f, 13.620507f, 30.0f, 22.0f);
                instancePath2.cubicTo(30.0f, 30.379494f, 26.642136f, 37.9657f, 21.213203f, 43.457035f);
                instancePath2.lineTo(18.031223f, 40.23848f);
                instancePath2.cubicTo(22.645815f, 35.570847f, 25.5f, 29.122568f, 25.5f, 22.0f);
                instancePath2.cubicTo(25.5f, 14.877431f, 22.645815f, 8.429155f, 18.031223f, 3.7615216f);
                instancePath2.lineTo(21.213203f, 0.54296666f);
                instancePath2.close();
                instancePath2.moveTo(13.788582f, 8.052928f);
                instancePath2.cubicTo(17.317389f, 11.622295f, 19.5f, 16.55333f, 19.5f, 22.0f);
                instancePath2.cubicTo(19.5f, 27.44667f, 17.317389f, 32.377705f, 13.788582f, 35.94707f);
                instancePath2.lineTo(10.606602f, 32.728516f);
                instancePath2.cubicTo(13.321068f, 29.98285f, 15.0f, 26.189747f, 15.0f, 22.0f);
                instancePath2.cubicTo(15.0f, 17.810253f, 13.321068f, 14.01715f, 10.606602f, 11.271483f);
                instancePath2.lineTo(13.788582f, 8.052928f);
                instancePath2.close();
                instancePath2.moveTo(6.363961f, 15.56289f);
                instancePath2.cubicTo(7.9926405f, 17.21029f, 9.0f, 19.486153f, 9.0f, 22.0f);
                instancePath2.cubicTo(9.0f, 24.513847f, 7.9926405f, 26.78971f, 6.363961f, 28.43711f);
                instancePath2.lineTo(0.0f, 22.0f);
                instancePath2.lineTo(6.363961f, 15.56289f);
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
