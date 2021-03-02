package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class c2c_remittance_icon extends c {
    private final int height = 30;
    private final int width = 30;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 30;
            case 1:
                return 30;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -2.0f, 0.0f, 1.0f, -2.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(17.0f, 2.8333333f);
                instancePath.cubicTo(24.824034f, 2.8333333f, 31.166666f, 9.175966f, 31.166666f, 17.0f);
                instancePath.cubicTo(31.166666f, 24.824034f, 24.824034f, 31.166666f, 17.0f, 31.166666f);
                instancePath.cubicTo(9.175966f, 31.166666f, 2.8333333f, 24.824034f, 2.8333333f, 17.0f);
                instancePath.cubicTo(2.8333333f, 9.175966f, 9.175966f, 2.8333333f, 17.0f, 2.8333333f);
                instancePath.close();
                instancePath.moveTo(17.0f, 4.5333333f);
                instancePath.cubicTo(10.11485f, 4.5333333f, 4.5333333f, 10.11485f, 4.5333333f, 17.0f);
                instancePath.cubicTo(4.5333333f, 23.885149f, 10.11485f, 29.466667f, 17.0f, 29.466667f);
                instancePath.cubicTo(23.885149f, 29.466667f, 29.466667f, 23.885149f, 29.466667f, 17.0f);
                instancePath.cubicTo(29.466667f, 10.11485f, 23.885149f, 4.5333333f, 17.0f, 4.5333333f);
                instancePath.close();
                instancePath.moveTo(23.375f, 18.246666f);
                instancePath.cubicTo(23.766201f, 18.246666f, 24.083334f, 18.563799f, 24.083334f, 18.955f);
                instancePath.cubicTo(24.083334f, 19.164644f, 23.990467f, 19.363518f, 23.829727f, 19.498102f);
                instancePath.lineTo(19.351057f, 23.248005f);
                instancePath.cubicTo(19.111101f, 23.448915f, 18.753706f, 23.417263f, 18.552795f, 23.177305f);
                instancePath.cubicTo(18.392162f, 22.985455f, 18.376373f, 22.71096f, 18.51395f, 22.501957f);
                instancePath.lineTo(20.195972f, 19.946667f);
                instancePath.lineTo(9.981667f, 19.946667f);
                instancePath.lineTo(9.981667f, 18.246666f);
                instancePath.lineTo(23.375f, 18.246666f);
                instancePath.close();
                instancePath.moveTo(15.512205f, 10.827898f);
                instancePath.cubicTo(15.672838f, 11.019749f, 15.688626f, 11.294245f, 15.55105f, 11.503247f);
                instancePath.lineTo(13.869027f, 14.0585375f);
                instancePath.lineTo(24.083334f, 14.0585375f);
                instancePath.lineTo(24.083334f, 15.758537f);
                instancePath.lineTo(10.690001f, 15.758537f);
                instancePath.cubicTo(10.298799f, 15.758537f, 9.981667f, 15.441405f, 9.981667f, 15.050203f);
                instancePath.cubicTo(9.981667f, 14.840561f, 10.0745325f, 14.641686f, 10.235272f, 14.507103f);
                instancePath.lineTo(14.713943f, 10.757199f);
                instancePath.cubicTo(14.953899f, 10.556288f, 15.311294f, 10.587941f, 15.512205f, 10.827898f);
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
