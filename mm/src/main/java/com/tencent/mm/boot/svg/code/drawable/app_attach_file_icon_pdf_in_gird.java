package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class app_attach_file_icon_pdf_in_gird extends c {
    private final int height = 80;
    private final int width = 80;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 80;
            case 1:
                return 80;
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
                instancePaint3.setColor(-1);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 3.0f, 0.0f, 1.0f, 23.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(26.599453f, 7.383812E-15f);
                instancePath.lineTo(35.745975f, 0.0f);
                instancePath.cubicTo(46.030285f, 0.0f, 51.298946f, 5.4486866f, 51.298946f, 15.3482685f);
                instancePath.cubicTo(51.298946f, 25.247852f, 46.00221f, 33.253735f, 35.745975f, 33.253735f);
                instancePath.lineTo(26.599453f, 33.253735f);
                instancePath.lineTo(26.599453f, 7.383812E-15f);
                instancePath.close();
                instancePath.moveTo(31.768106f, 5.216272f);
                instancePath.cubicTo(31.768106f, 5.216272f, 28.448256f, 5.216272f, 35.442616f, 5.216272f);
                instancePath.cubicTo(42.436977f, 5.216272f, 46.02019f, 8.955566f, 46.02019f, 15.749397f);
                instancePath.cubicTo(46.02019f, 22.543228f, 42.41788f, 28.037462f, 35.442616f, 28.037462f);
                instancePath.lineTo(31.768106f, 28.037462f);
                instancePath.lineTo(31.768106f, 5.216272f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(0.0f, 33.253735f);
                instancePath2.lineTo(0.0f, 0.0f);
                instancePath2.cubicTo(0.0f, 0.0f, 6.980508f, 8.159173E-16f, 12.058983f, 0.0f);
                instancePath2.cubicTo(17.137459f, -8.0728937E-16f, 20.661282f, 3.5846686f, 21.510666f, 5.115959f);
                instancePath2.cubicTo(21.59788f, 5.27319f, 21.68077f, 5.428216f, 21.75931f, 5.5818195f);
                instancePath2.cubicTo(22.445667f, 6.9241815f, 22.79953f, 8.157933f, 22.79953f, 9.805588f);
                instancePath2.cubicTo(22.79953f, 12.445591f, 21.901007f, 14.838656f, 20.2218f, 16.626867f);
                instancePath2.cubicTo(18.306856f, 18.755327f, 15.92558f, 20.037506f, 11.199739f, 20.213055f);
                instancePath2.cubicTo(6.473898f, 20.037506f, 5.6830688f, 20.213055f, 5.6830688f, 20.213055f);
                instancePath2.lineTo(5.6830688f, 33.253735f);
                instancePath2.lineTo(0.0f, 33.253735f);
                instancePath2.close();
                instancePath2.moveTo(5.6830688f, 16.30085f);
                instancePath2.lineTo(11.36023f, 16.30085f);
                instancePath2.cubicTo(17.764584f, 16.30085f, 17.116463f, 11.837833f, 17.116463f, 9.892929f);
                instancePath2.cubicTo(17.116463f, 7.9480257f, 17.553057f, 3.912204f, 11.36023f, 3.912204f);
                instancePath2.lineTo(5.6830688f, 3.912204f);
                instancePath2.lineTo(5.6830688f, 16.30085f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint3, looper);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(53.198906f, 0.0f);
                instancePath3.lineTo(53.198906f, 33.253735f);
                instancePath3.lineTo(58.410225f, 33.253735f);
                instancePath3.lineTo(58.410225f, 17.604918f);
                instancePath3.lineTo(72.144226f, 17.604918f);
                instancePath3.lineTo(72.144226f, 13.04068f);
                instancePath3.lineTo(58.410225f, 13.04068f);
                instancePath3.lineTo(58.410225f, 5.216272f);
                instancePath3.lineTo(74.09847f, 5.216272f);
                instancePath3.lineTo(74.09847f, 0.0f);
                instancePath3.lineTo(53.198906f, 0.0f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint6);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
