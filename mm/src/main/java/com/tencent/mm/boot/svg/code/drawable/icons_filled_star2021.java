package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_star2021 extends c {
    private final int height = 18;
    private final int width = 18;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 18;
            case 1:
                return 18;
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
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 0.9659258f, -0.25881904f, 2.6360388f, 0.25881904f, 0.9659258f, -2.0227041f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(8.093609f, 4.2137213f);
                instancePath.lineTo(8.466457f, 2.7136064f);
                instancePath.lineTo(8.466457f, 2.7136064f);
                instancePath.cubicTo(8.547827f, 2.3862267f, 8.879149f, 2.1868038f, 9.206489f, 2.2681835f);
                instancePath.cubicTo(9.424027f, 2.3222659f, 9.594461f, 2.4911892f, 9.6505f, 2.7082589f);
                instancePath.lineTo(10.066191f, 4.3184824f);
                instancePath.cubicTo(10.516483f, 6.0627418f, 11.8702545f, 7.429927f, 13.60999f, 7.897394f);
                instancePath.lineTo(15.297577f, 8.350849f);
                instancePath.lineTo(15.297577f, 8.350849f);
                instancePath.cubicTo(15.623325f, 8.438378f, 15.816449f, 8.773438f, 15.728932f, 9.099229f);
                instancePath.cubicTo(15.670387f, 9.317164f, 15.496468f, 9.485062f, 15.276626f, 9.535872f);
                instancePath.lineTo(13.836809f, 9.868648f);
                instancePath.cubicTo(12.025258f, 10.28734f, 10.595643f, 11.67666f, 10.125341f, 13.475503f);
                instancePath.lineTo(9.650018f, 15.293557f);
                instancePath.lineTo(9.650018f, 15.293557f);
                instancePath.cubicTo(9.56469f, 15.619927f, 9.230976f, 15.815322f, 8.904647f, 15.729983f);
                instancePath.cubicTo(8.689062f, 15.673605f, 8.521291f, 15.504272f, 8.46689f, 15.288155f);
                instancePath.lineTo(8.034374f, 13.569867f);
                instancePath.cubicTo(7.580564f, 11.76699f, 6.163933f, 10.36476f, 4.3565116f, 9.929397f);
                instancePath.lineTo(2.7178726f, 9.534689f);
                instancePath.lineTo(2.7178726f, 9.534689f);
                instancePath.cubicTo(2.3899493f, 9.4557f, 2.1881397f, 9.125798f, 2.2671185f, 8.797833f);
                instancePath.cubicTo(2.318937f, 8.582653f, 2.4830928f, 8.412343f, 2.6962023f, 8.352665f);
                instancePath.lineTo(4.5895596f, 7.822453f);
                instancePath.cubicTo(6.3216634f, 7.3373985f, 7.659738f, 5.959349f, 8.093609f, 4.2137213f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
