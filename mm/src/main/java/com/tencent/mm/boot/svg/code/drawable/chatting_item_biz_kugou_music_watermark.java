package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class chatting_item_biz_kugou_music_watermark extends c {
    private final int height = 39;
    private final int width = 39;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 39;
            case 1:
                return 39;
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
                instancePaint3.setColor(-1710619);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -322.0f, 0.0f, 1.0f, -941.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 323.0f, 0.0f, 1.0f, 942.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(18.5f, 0.0f);
                instancePath.cubicTo(8.282732f, -6.256272E-16f, 1.2512544E-15f, 8.282732f, 0.0f, 18.5f);
                instancePath.cubicTo(-1.2512544E-15f, 28.717268f, 8.282732f, 37.0f, 18.5f, 37.0f);
                instancePath.cubicTo(28.717268f, 37.0f, 37.0f, 28.717268f, 37.0f, 18.5f);
                instancePath.cubicTo(37.0f, 13.593495f, 35.0509f, 8.887947f, 31.581476f, 5.4185247f);
                instancePath.cubicTo(28.112053f, 1.9491016f, 23.406506f, 3.004368E-16f, 18.5f, 0.0f);
                instancePath.close();
                instancePath.moveTo(18.470951f, 34.999973f);
                instancePath.cubicTo(9.3658285f, 34.983944f, 1.9946595f, 27.595451f, 2.0000029f, 18.490316f);
                instancePath.cubicTo(2.0053463f, 9.385182f, 9.385182f, 2.0053463f, 18.490316f, 2.0000029f);
                instancePath.cubicTo(27.595451f, 1.9946595f, 34.983944f, 9.3658285f, 34.999973f, 18.470951f);
                instancePath.cubicTo(35.007698f, 22.857082f, 33.26873f, 27.065794f, 30.167261f, 30.167261f);
                instancePath.cubicTo(27.065794f, 33.26873f, 22.857082f, 35.007698f, 18.470951f, 34.999973f);
                instancePath.lineTo(18.470951f, 34.999973f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(14.230769f, 27.508078f);
                instancePath2.lineTo(9.961538f, 27.508078f);
                instancePath2.lineTo(11.66923f, 9.961538f);
                instancePath2.lineTo(16.066538f, 9.961538f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint3, looper);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(21.150963f, 16.820768f);
                instancePath3.cubicTo(20.627676f, 17.163134f, 20.287874f, 17.724329f, 20.22702f, 18.346695f);
                instancePath3.cubicTo(20.166168f, 18.969063f, 20.390827f, 19.58545f, 20.837887f, 20.022692f);
                instancePath3.cubicTo(22.147118f, 21.801538f, 26.530195f, 27.508078f, 26.530195f, 27.508078f);
                instancePath3.lineTo(20.980194f, 27.508078f);
                instancePath3.cubicTo(19.115963f, 24.861155f, 18.247887f, 23.452307f, 16.525963f, 21.033077f);
                instancePath3.cubicTo(15.165143f, 19.326057f, 15.424838f, 16.843111f, 17.109425f, 15.454616f);
                instancePath3.cubicTo(17.820963f, 14.743077f, 20.254425f, 12.409231f, 22.801733f, 9.961538f);
                instancePath3.lineTo(28.10981f, 9.961538f);
                instancePath3.lineTo(21.150963f, 16.820768f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 1);
                canvas.drawPath(instancePath3, instancePaint6);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
