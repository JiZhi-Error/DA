package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class voice2txt_hint_trans_chs extends c {
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
                canvas.saveLayerAlpha(null, 128, 31);
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-1);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 3.0f, 0.0f, 1.0f, 3.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(1.0f, 0.0f);
                instancePath.lineTo(17.0f, 0.0f);
                instancePath.cubicTo(17.552284f, -1.0145306E-16f, 18.0f, 0.44771525f, 18.0f, 1.0f);
                instancePath.lineTo(18.0f, 17.0f);
                instancePath.cubicTo(18.0f, 17.552284f, 17.552284f, 18.0f, 17.0f, 18.0f);
                instancePath.lineTo(1.0f, 18.0f);
                instancePath.cubicTo(0.44771525f, 18.0f, 6.7635376E-17f, 17.552284f, 0.0f, 17.0f);
                instancePath.lineTo(0.0f, 1.0f);
                instancePath.cubicTo(-6.7635376E-17f, 0.44771525f, 0.44771525f, 1.0145306E-16f, 1.0f, 0.0f);
                instancePath.close();
                instancePath.moveTo(4.198f, 5.848f);
                instancePath.lineTo(4.198f, 6.992f);
                instancePath.lineTo(5.87f, 6.992f);
                instancePath.cubicTo(6.332f, 8.587f, 7.157f, 9.984f, 8.345f, 11.194f);
                instancePath.cubicTo(7.201f, 12.162f, 5.749f, 12.866f, 4.0f, 13.317f);
                instancePath.lineTo(4.616f, 14.329f);
                instancePath.cubicTo(6.409f, 13.823f, 7.927f, 13.02f, 9.159f, 11.931f);
                instancePath.cubicTo(10.325f, 12.899f, 11.788f, 13.713f, 13.548f, 14.373f);
                instancePath.lineTo(14.186f, 13.394f);
                instancePath.cubicTo(12.514f, 12.778f, 11.106f, 12.03f, 9.973f, 11.128f);
                instancePath.cubicTo(10.985f, 10.017f, 11.755f, 8.642f, 12.283f, 6.992f);
                instancePath.lineTo(13.944f, 6.992f);
                instancePath.lineTo(13.944f, 5.848f);
                instancePath.lineTo(9.786f, 5.848f);
                instancePath.cubicTo(9.456f, 5.133f, 9.093f, 4.517f, 8.697f, 4.0f);
                instancePath.lineTo(7.542f, 4.418f);
                instancePath.cubicTo(7.938f, 4.869f, 8.279f, 5.342f, 8.554f, 5.848f);
                instancePath.lineTo(4.198f, 5.848f);
                instancePath.close();
                instancePath.moveTo(6.97f, 6.992f);
                instancePath.lineTo(11.095f, 6.992f);
                instancePath.cubicTo(10.666f, 8.323f, 10.017f, 9.467f, 9.159f, 10.413f);
                instancePath.cubicTo(8.147f, 9.423f, 7.421f, 8.29f, 6.97f, 6.992f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
