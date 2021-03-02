package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.audio.l;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class connect_pc extends c {
    private final int height = l.CTRL_INDEX;
    private final int width = 378;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 378;
            case 1:
                return l.CTRL_INDEX;
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
                instancePaint3.setColor(-13158344);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 2.0f, 0.0f, 1.0f, 3.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(14.0f, 226.0f);
                instancePath.lineTo(360.0f, 226.0f);
                instancePath.lineTo(360.0f, 14.0f);
                instancePath.lineTo(14.0f, 14.0f);
                instancePath.lineTo(14.0f, 226.0f);
                instancePath.close();
                instancePath.moveTo(13.0f, 227.0f);
                instancePath.lineTo(361.0f, 227.0f);
                instancePath.lineTo(361.0f, 13.0f);
                instancePath.lineTo(13.0f, 13.0f);
                instancePath.lineTo(13.0f, 227.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(371.0002f, 225.9932f);
                instancePath2.cubicTo(371.0002f, 232.0622f, 366.0632f, 237.0002f, 359.9932f, 237.0002f);
                instancePath2.lineTo(206.0002f, 237.0002f);
                instancePath2.lineTo(206.0002f, 237.0002f);
                instancePath2.lineTo(168.0002f, 237.0002f);
                instancePath2.lineTo(168.0002f, 237.0002f);
                instancePath2.lineTo(14.0062f, 237.0002f);
                instancePath2.cubicTo(7.9382f, 237.0002f, 3.0002f, 232.0622f, 3.0002f, 225.9932f);
                instancePath2.lineTo(3.0002f, 14.0072f);
                instancePath2.cubicTo(3.0002f, 7.9372f, 7.9382f, 3.0002f, 14.0062f, 3.0002f);
                instancePath2.lineTo(359.9932f, 3.0002f);
                instancePath2.cubicTo(366.0632f, 3.0002f, 371.0002f, 7.9372f, 371.0002f, 14.0072f);
                instancePath2.lineTo(371.0002f, 225.9932f);
                instancePath2.close();
                instancePath2.moveTo(256.0002f, 278.7302f);
                instancePath2.lineTo(256.0002f, 284.0002f);
                instancePath2.lineTo(118.0002f, 284.0002f);
                instancePath2.lineTo(118.0002f, 278.7302f);
                instancePath2.lineTo(171.0002f, 273.7302f);
                instancePath2.lineTo(171.0002f, 240.0002f);
                instancePath2.lineTo(203.0002f, 240.0002f);
                instancePath2.lineTo(203.0002f, 273.7302f);
                instancePath2.lineTo(256.0002f, 278.7302f);
                instancePath2.close();
                instancePath2.moveTo(359.9932f, 2.0E-4f);
                instancePath2.lineTo(14.0072f, 2.0E-4f);
                instancePath2.cubicTo(6.2762f, 2.0E-4f, 2.0E-4f, 6.2712f, 2.0E-4f, 14.0072f);
                instancePath2.lineTo(2.0E-4f, 225.9932f);
                instancePath2.cubicTo(2.0E-4f, 233.7342f, 6.2712f, 240.0002f, 14.0072f, 240.0002f);
                instancePath2.lineTo(168.0002f, 240.0002f);
                instancePath2.lineTo(168.0002f, 271.0002f);
                instancePath2.lineTo(115.0002f, 276.0002f);
                instancePath2.lineTo(115.0002f, 287.0002f);
                instancePath2.lineTo(259.0002f, 287.0002f);
                instancePath2.lineTo(259.0002f, 276.0002f);
                instancePath2.lineTo(206.0002f, 271.0002f);
                instancePath2.lineTo(206.0002f, 240.0002f);
                instancePath2.lineTo(359.9932f, 240.0002f);
                instancePath2.cubicTo(367.7242f, 240.0002f, 374.0002f, 233.7292f, 374.0002f, 225.9932f);
                instancePath2.lineTo(374.0002f, 14.0072f);
                instancePath2.cubicTo(374.0002f, 6.2652f, 367.7292f, 2.0E-4f, 359.9932f, 2.0E-4f);
                instancePath2.lineTo(359.9932f, 2.0E-4f);
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
