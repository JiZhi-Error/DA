package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class balance_manager_lct_link_icon extends c {
    private final int height = 17;
    private final int width = 17;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 17;
            case 1:
                return 17;
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-11048043);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 2.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.37097725f, 3.9374971f);
                instancePath.lineTo(3.945679f, 3.9374971f);
                instancePath.lineTo(8.5f, 15.0f);
                instancePath.lineTo(0.22602811f, 4.231666f);
                instancePath.cubicTo(0.16451833f, 4.1516128f, 0.17955074f, 4.0368533f, 0.25960392f, 3.9753437f);
                instancePath.cubicTo(0.2915445f, 3.9508018f, 0.33069694f, 3.9374971f, 0.37097725f, 3.9374971f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(16.629023f, 3.9374971f);
                instancePath2.lineTo(13.138271f, 3.9374971f);
                instancePath2.lineTo(8.5f, 15.0f);
                instancePath2.lineTo(16.773972f, 4.231666f);
                instancePath2.cubicTo(16.835482f, 4.1516128f, 16.82045f, 4.0368533f, 16.740396f, 3.9753437f);
                instancePath2.cubicTo(16.708456f, 3.9508018f, 16.669304f, 3.9374971f, 16.629023f, 3.9374971f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint3, looper);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(5.1944447f, 3.9374971f);
                instancePath3.lineTo(11.805555f, 3.9374971f);
                instancePath3.lineTo(8.5f, 15.0f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 1);
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint6);
                canvas.restore();
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint3, looper);
                Path instancePath4 = c.instancePath(looper);
                instancePath4.moveTo(4.0353537f, 2.8125f);
                instancePath4.lineTo(6.611111f, 0.0f);
                instancePath4.lineTo(3.9231226f, 5.828671E-16f);
                instancePath4.cubicTo(3.8844628f, 6.929792E-16f, 3.8467984f, 0.012256962f, 3.815543f, 0.035009228f);
                instancePath4.lineTo(0.4541331f, 2.4819179f);
                instancePath4.cubicTo(0.37251288f, 2.5413325f, 0.35451177f, 2.655664f, 0.41392648f, 2.7372842f);
                instancePath4.cubicTo(0.4483286f, 2.7845438f, 0.50325805f, 2.8125f, 0.5617129f, 2.8125f);
                instancePath4.lineTo(4.0353537f, 2.8125f);
                instancePath4.close();
                WeChatSVGRenderC2Java.setFillType(instancePath4, 2);
                canvas.drawPath(instancePath4, instancePaint7);
                canvas.restore();
                canvas.save();
                Paint instancePaint8 = c.instancePaint(instancePaint3, looper);
                Path instancePath5 = c.instancePath(looper);
                instancePath5.moveTo(7.5555553f, 0.0f);
                instancePath5.lineTo(9.444445f, 0.0f);
                instancePath5.lineTo(11.805555f, 2.8125f);
                instancePath5.lineTo(5.1944447f, 2.8125f);
                instancePath5.close();
                WeChatSVGRenderC2Java.setFillType(instancePath5, 1);
                WeChatSVGRenderC2Java.setFillType(instancePath5, 2);
                canvas.drawPath(instancePath5, instancePaint8);
                canvas.restore();
                canvas.save();
                Paint instancePaint9 = c.instancePaint(instancePaint3, looper);
                Path instancePath6 = c.instancePath(looper);
                instancePath6.moveTo(13.150493f, 2.8125f);
                instancePath6.lineTo(10.388889f, 0.0f);
                instancePath6.lineTo(13.17345f, -2.7755576E-17f);
                instancePath6.cubicTo(13.212875f, -2.0513277E-17f, 13.251245f, 0.012746517f, 13.282832f, 0.036337905f);
                instancePath6.lineTo(16.559143f, 2.4832466f);
                instancePath6.cubicTo(16.64003f, 2.5436563f, 16.65663f, 2.6581998f, 16.596218f, 2.7390862f);
                instancePath6.cubicTo(16.561712f, 2.7852888f, 16.507427f, 2.8125f, 16.44976f, 2.8125f);
                instancePath6.lineTo(13.150493f, 2.8125f);
                instancePath6.close();
                WeChatSVGRenderC2Java.setFillType(instancePath6, 2);
                canvas.drawPath(instancePath6, instancePaint9);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
