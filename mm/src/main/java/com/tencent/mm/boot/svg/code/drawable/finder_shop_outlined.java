package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class finder_shop_outlined extends c {
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
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(24.0f, 0.0f);
                instancePath.lineTo(24.0f, 24.0f);
                instancePath.lineTo(0.0f, 24.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-40634);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 4.000078f, 0.0f, 1.0f, 2.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(7.4717584f, 0.0f);
                instancePath2.cubicTo(9.150944f, 0.0f, 10.587838f, 1.4569691f, 10.587838f, 3.0700102f);
                instancePath2.lineTo(10.587838f, 3.0700102f);
                instancePath2.lineTo(10.587838f, 4.9998612f);
                instancePath2.lineTo(13.1031f, 4.9998612f);
                instancePath2.cubicTo(13.63391f, 4.9998612f, 14.073162f, 5.4089813f, 14.106213f, 5.9359603f);
                instancePath2.lineTo(14.106213f, 5.9359603f);
                instancePath2.lineTo(14.283186f, 8.691938f);
                instancePath2.lineTo(14.14652f, 8.714044f);
                instancePath2.cubicTo(13.785649f, 8.766919f, 13.438959f, 8.849898f, 13.090148f, 8.92999f);
                instancePath2.lineTo(13.090148f, 8.92999f);
                instancePath2.lineTo(12.915184f, 6.1998944f);
                instancePath2.lineTo(2.0273278f, 6.1998944f);
                instancePath2.lineTo(1.2181607f, 18.799967f);
                instancePath2.lineTo(4.9069214f, 18.799967f);
                instancePath2.cubicTo(5.23463f, 14.33275f, 9.207107f, 10.676887f, 14.358554f, 9.8993025f);
                instancePath2.cubicTo(15.733367f, 9.725235f, 15.947522f, 10.979256f, 15.989392f, 11.418923f);
                instancePath2.cubicTo(15.993748f, 11.45647f, 15.997209f, 11.494238f, 15.999106f, 11.532339f);
                instancePath2.cubicTo(15.999106f, 11.539227f, 16.0f, 11.547224f, 16.0f, 11.554223f);
                instancePath2.cubicTo(10.91778f, 11.710183f, 6.6025205f, 14.747646f, 5.4772573f, 18.799967f);
                instancePath2.lineTo(5.4772573f, 18.799967f);
                instancePath2.lineTo(13.723346f, 18.799967f);
                instancePath2.lineTo(13.361582f, 13.156044f);
                instancePath2.cubicTo(13.751483f, 13.052959f, 14.14451f, 12.958982f, 14.553616f, 12.895998f);
                instancePath2.lineTo(14.553616f, 12.895998f);
                instancePath2.lineTo(14.940614f, 18.936045f);
                instancePath2.cubicTo(14.975784f, 19.486017f, 14.555625f, 19.963009f, 14.002819f, 19.998112f);
                instancePath2.cubicTo(13.9806f, 20.0f, 13.959609f, 20.0f, 13.937501f, 20.0f);
                instancePath2.lineTo(13.937501f, 20.0f);
                instancePath2.lineTo(1.0050105f, 20.0f);
                instancePath2.cubicTo(0.4481849f, 20.0f, 0.0f, 19.552f, 0.0f, 19.000029f);
                instancePath2.lineTo(0.0f, 19.000029f);
                instancePath2.lineTo(8.932435E-4f, 18.936045f);
                instancePath2.lineTo(0.8362992f, 5.9359603f);
                instancePath2.cubicTo(0.8694608f, 5.4089813f, 1.3086016f, 4.9998612f, 1.8394116f, 4.9998612f);
                instancePath2.lineTo(1.8394116f, 4.9998612f);
                instancePath2.lineTo(4.35579f, 4.9998612f);
                instancePath2.lineTo(4.35579f, 3.0700102f);
                instancePath2.cubicTo(4.35579f, 1.4569691f, 5.792572f, 0.0f, 7.4717584f, 0.0f);
                instancePath2.close();
                instancePath2.moveTo(17.433743f, 5.3167486f);
                instancePath2.cubicTo(17.727486f, 5.3167486f, 17.962793f, 5.536078f, 17.980894f, 5.8268046f);
                instancePath2.cubicTo(17.994972f, 6.1033406f, 18.128716f, 7.429151f, 19.508827f, 7.8063574f);
                instancePath2.lineTo(19.508827f, 7.8063574f);
                instancePath2.lineTo(19.541006f, 7.816302f);
                instancePath2.cubicTo(19.78637f, 7.8888154f, 19.94838f, 8.091944f, 19.94838f, 8.3342905f);
                instancePath2.cubicTo(19.94838f, 8.574738f, 19.78637f, 8.777978f, 19.537989f, 8.852391f);
                instancePath2.lineTo(19.537989f, 8.852391f);
                instancePath2.lineTo(19.508827f, 8.861442f);
                instancePath2.cubicTo(18.128716f, 9.238648f, 17.994972f, 10.564235f, 17.9819f, 10.826804f);
                instancePath2.cubicTo(17.962793f, 11.131609f, 17.727486f, 11.351832f, 17.433743f, 11.351832f);
                instancePath2.cubicTo(17.140112f, 11.351832f, 16.904581f, 11.131609f, 16.886593f, 10.839877f);
                instancePath2.cubicTo(16.87352f, 10.564235f, 16.739777f, 9.238648f, 15.358659f, 8.861442f);
                instancePath2.lineTo(15.358659f, 8.861442f);
                instancePath2.lineTo(15.336536f, 8.854403f);
                instancePath2.cubicTo(15.081118f, 8.777978f, 14.920223f, 8.574738f, 14.920223f, 8.3342905f);
                instancePath2.cubicTo(14.920223f, 8.091944f, 15.081118f, 7.8888154f, 15.331509f, 7.8142905f);
                instancePath2.lineTo(15.331509f, 7.8142905f);
                instancePath2.lineTo(15.366816f, 7.8042345f);
                instancePath2.cubicTo(16.739777f, 7.429151f, 16.87352f, 6.1033406f, 16.885475f, 5.840883f);
                instancePath2.cubicTo(16.904581f, 5.536078f, 17.140112f, 5.3167486f, 17.433743f, 5.3167486f);
                instancePath2.close();
                instancePath2.moveTo(7.4717584f, 1.2000333f);
                instancePath2.cubicTo(6.4639564f, 1.2000333f, 5.5620036f, 2.1146936f, 5.5620036f, 3.0700102f);
                instancePath2.lineTo(5.5620036f, 3.0700102f);
                instancePath2.lineTo(5.5620036f, 4.9998612f);
                instancePath2.lineTo(9.381624f, 4.9998612f);
                instancePath2.lineTo(9.381624f, 3.0700102f);
                instancePath2.cubicTo(9.381624f, 2.1146936f, 8.47956f, 1.2000333f, 7.4717584f, 1.2000333f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
