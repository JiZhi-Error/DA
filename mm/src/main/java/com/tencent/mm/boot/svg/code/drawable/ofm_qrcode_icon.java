package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class ofm_qrcode_icon extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-1);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 13.0f, 0.0f, 1.0f, 17.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(58.470066f, 62.0f);
                instancePath.lineTo(53.9755f, 62.0f);
                instancePath.cubicTo(49.648666f, 62.0f, 44.869793f, 60.384254f, 39.67735f, 47.964252f);
                instancePath.lineTo(27.990025f, 47.964252f);
                instancePath.cubicTo(26.72038f, 47.964252f, 26.0f, 46.286526f, 26.0f, 45.017883f);
                instancePath.lineTo(26.0f, 42.152267f);
                instancePath.cubicTo(26.0f, 40.889736f, 26.725277f, 39.940037f, 27.990025f, 39.940037f);
                instancePath.lineTo(56.19917f, 39.940037f);
                instancePath.cubicTo(58.565826f, 39.940037f, 59.980904f, 37.81265f, 59.980904f, 35.111588f);
                instancePath.cubicTo(59.980904f, 34.687485f, 59.918465f, 34.282936f, 59.829086f, 33.889385f);
                instancePath.lineTo(59.980904f, 33.889385f);
                instancePath.lineTo(59.980904f, 35.0957f);
                instancePath.cubicTo(60.07518f, 34.209602f, 60.04947f, 33.62539f, 59.608704f, 32.087864f);
                instancePath.cubicTo(58.976944f, 29.884235f, 61.3938f, 23.525126f, 65.893265f, 23.017912f);
                instancePath.cubicTo(67.01843f, 22.88958f, 68.386024f, 23.440792f, 68.19258f, 24.996655f);
                instancePath.cubicTo(66.76132f, 36.49023f, 71.0f, 38.654747f, 71.0f, 50.990417f);
                instancePath.cubicTo(71.0f, 56.72376f, 66.5691f, 62.0f, 58.470066f, 62.0f);
                instancePath.close();
                instancePath.moveTo(15.810811f, 21.999079f);
                instancePath.cubicTo(15.610135f, 22.036966f, 10.945946f, 24.189209f, 10.945946f, 26.887762f);
                instancePath.cubicTo(10.945946f, 27.311855f, 11.007973f, 27.717617f, 11.096757f, 28.109934f);
                instancePath.lineTo(10.945946f, 28.109934f);
                instancePath.lineTo(10.945946f, 26.904873f);
                instancePath.cubicTo(10.852297f, 27.789724f, 10.876621f, 28.375145f, 11.315676f, 29.913858f);
                instancePath.cubicTo(11.943243f, 32.114986f, 9.542433f, 38.473946f, 5.072838f, 38.98237f);
                instancePath.cubicTo(3.955135f, 39.109474f, 2.5966215f, 38.559498f, 2.7887838f, 37.003674f);
                instancePath.cubicTo(4.210541f, 25.509153f, 0.0f, 23.343466f, 0.0f, 11.009316f);
                instancePath.cubicTo(0.0f, 5.2761126f, 4.4014864f, 0.0f, 12.446756f, 0.0f);
                instancePath.lineTo(16.911486f, 0.0f);
                instancePath.cubicTo(21.209595f, 0.0f, 26.145006f, 2.5314698f, 31.302979f, 14.951172f);
                instancePath.lineTo(42.725677f, 14.951172f);
                instancePath.cubicTo(43.986893f, 14.951172f, 45.0f, 15.695121f, 45.0f, 16.962511f);
                instancePath.lineTo(45.0f, 19.712397f);
                instancePath.cubicTo(45.0f, 20.976122f, 43.980812f, 21.999079f, 42.725677f, 21.999079f);
                instancePath.lineTo(15.810811f, 21.999079f);
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
