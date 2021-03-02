package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class actionbar_voip_voice_icon extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-1);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 18.0f, 0.0f, 1.0f, 18.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(1.8112956f, 10.179302f);
                instancePath.cubicTo(4.1568093f, 5.8457093f, 8.318849f, 2.8101974f, 12.401041f, 0.24399146f);
                instancePath.cubicTo(14.297414f, -0.7745027f, 15.375352f, 1.65191f, 16.3435f, 2.8101974f);
                instancePath.cubicTo(18.96848f, 6.844233f, 22.212275f, 10.468874f, 24.487923f, 14.702615f);
                instancePath.cubicTo(24.34819f, 15.102024f, 24.068724f, 15.920814f, 23.91901f, 16.330208f);
                instancePath.cubicTo(21.05449f, 18.586872f, 17.680943f, 20.064688f, 14.36728f, 21.522532f);
                instancePath.cubicTo(15.724684f, 27.084309f, 19.487488f, 31.617607f, 23.36008f, 35.66163f);
                instancePath.cubicTo(27.63191f, 39.965263f, 32.48263f, 44.08917f, 38.451214f, 45.706776f);
                instancePath.cubicTo(40.13799f, 42.261868f, 41.445488f, 38.407566f, 44.240143f, 35.69158f);
                instancePath.cubicTo(47.543823f, 35.581745f, 49.819473f, 38.9268f, 52.584183f, 40.4146f);
                instancePath.cubicTo(54.96962f, 42.581398f, 58.80229f, 43.74967f, 60.0f, 46.795166f);
                instancePath.cubicTo(58.423016f, 50.669437f, 55.338917f, 53.914642f, 52.23485f, 56.700523f);
                instancePath.cubicTo(49.48012f, 59.23677f, 45.42787f, 59.61621f, 42.064304f, 58.12841f);
                instancePath.cubicTo(24.398094f, 51.348434f, 9.915794f, 36.989666f, 2.5099592f, 19.61535f);
                instancePath.cubicTo(1.3122501f, 16.669706f, 0.18440735f, 13.194844f, 1.8112956f, 10.179302f);
                instancePath.lineTo(1.8112956f, 10.179302f);
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
