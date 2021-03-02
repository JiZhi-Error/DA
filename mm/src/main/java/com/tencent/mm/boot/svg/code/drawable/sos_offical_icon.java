package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class sos_offical_icon extends c {
    private final int height = 42;
    private final int width = 42;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 42;
            case 1:
                return 42;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 2.0f, 0.0f, 1.0f, 2.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(-4210753);
                instancePaint4.setStrokeWidth(2.3841698f);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(13.255814f, 19.44186f);
                instancePath.cubicTo(15.75252f, 23.571234f, 11.813965f, 25.277498f, 9.72093f, 26.511627f);
                instancePath.cubicTo(3.0922725f, 30.251368f, 0.0f, 31.759228f, 0.0f, 33.581394f);
                instancePath.lineTo(0.0f, 36.23256f);
                instancePath.cubicTo(0.0f, 37.254696f, 0.64349174f, 38.0f, 1.7674419f, 38.0f);
                instancePath.lineTo(36.23256f, 38.0f);
                instancePath.cubicTo(37.356506f, 38.0f, 38.0f, 37.254696f, 38.0f, 36.23256f);
                instancePath.lineTo(38.0f, 33.581394f);
                instancePath.cubicTo(38.0f, 31.759228f, 34.907726f, 30.251368f, 28.27907f, 26.511627f);
                instancePath.cubicTo(26.186035f, 25.277498f, 22.24748f, 23.571234f, 24.744186f, 19.44186f);
                instancePath.cubicTo(26.726433f, 16.674295f, 28.370281f, 15.399918f, 28.27907f, 10.604651f);
                instancePath.cubicTo(28.370281f, 5.2031674f, 24.697962f, 0.0f, 19.44186f, 0.0f);
                instancePath.cubicTo(13.302039f, 0.0f, 9.629718f, 5.2031674f, 9.72093f, 10.604651f);
                instancePath.cubicTo(9.629718f, 15.399918f, 11.273568f, 16.674295f, 13.255814f, 19.44186f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-4737097);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(16.347082f, 34.10343f);
                instancePath2.lineTo(18.393309f, 36.05255f);
                instancePath2.lineTo(18.393309f, 36.05255f);
                instancePath2.cubicTo(18.723711f, 36.36727f, 19.241936f, 36.370655f, 19.57642f, 36.060276f);
                instancePath2.lineTo(21.677546f, 34.110565f);
                instancePath2.lineTo(21.677546f, 34.110565f);
                instancePath2.cubicTo(22.181849f, 33.642605f, 22.36036f, 32.91999f, 22.131973f, 32.27103f);
                instancePath2.lineTo(18.981232f, 23.318182f);
                instancePath2.lineTo(15.904492f, 32.292583f);
                instancePath2.lineTo(15.904492f, 32.292583f);
                instancePath2.cubicTo(15.6856785f, 32.930836f, 15.858533f, 33.63807f, 16.347082f, 34.10343f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
