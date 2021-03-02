package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_people_nearby extends c {
    private final int height = 72;
    private final int width = 72;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 72;
            case 1:
                return 72;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 6.0f, 0.0f, 1.0f, 12.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(18.3921f, 24.5868f);
                instancePath.cubicTo(28.5321f, 24.5868f, 36.7821f, 33.5808f, 36.7821f, 44.6358f);
                instancePath.lineTo(36.7821f, 47.9268f);
                instancePath.lineTo(33.1821f, 47.9268f);
                instancePath.lineTo(33.1821f, 44.6358f);
                instancePath.cubicTo(33.1821f, 35.5668f, 26.5491f, 28.1868f, 18.3921f, 28.1868f);
                instancePath.cubicTo(10.2351f, 28.1868f, 3.5991f, 35.5668f, 3.5991f, 44.6358f);
                instancePath.lineTo(3.5991f, 47.9268f);
                instancePath.lineTo(-9.0E-4f, 47.9268f);
                instancePath.lineTo(-9.0E-4f, 44.6358f);
                instancePath.cubicTo(-9.0E-4f, 33.5808f, 8.2491f, 24.5868f, 18.3921f, 24.5868f);
                instancePath.close();
                instancePath.moveTo(45.0495f, 28.8942f);
                instancePath.cubicTo(53.026577f, 28.8942f, 59.55111f, 35.880653f, 59.880455f, 44.603077f);
                instancePath.lineTo(59.8935f, 45.2952f);
                instancePath.lineTo(59.8935f, 47.9262f);
                instancePath.lineTo(56.2965f, 47.9262f);
                instancePath.lineTo(56.2965f, 45.2952f);
                instancePath.cubicTo(56.2965f, 38.2362f, 51.2505f, 32.4942f, 45.0495f, 32.4942f);
                instancePath.cubicTo(43.1775f, 32.4942f, 41.3265f, 33.0312f, 39.6885f, 34.0452f);
                instancePath.cubicTo(39.1665f, 32.9562f, 38.5815f, 31.9092f, 37.9185f, 30.9192f);
                instancePath.cubicTo(40.0965f, 29.5992f, 42.5535f, 28.8942f, 45.0495f, 28.8942f);
                instancePath.close();
                instancePath.moveTo(45.3102f, 8.3781f);
                instancePath.cubicTo(49.9392f, 8.3781f, 53.7072f, 12.1431f, 53.7072f, 16.7751f);
                instancePath.cubicTo(53.7072f, 21.4041f, 49.9392f, 25.1721f, 45.3102f, 25.1721f);
                instancePath.cubicTo(40.6782f, 25.1721f, 36.9072f, 21.4041f, 36.9072f, 16.7751f);
                instancePath.cubicTo(36.9072f, 12.1431f, 40.6782f, 8.3781f, 45.3102f, 8.3781f);
                instancePath.close();
                instancePath.moveTo(45.3102f, 11.9781f);
                instancePath.cubicTo(42.6612f, 11.9781f, 40.5072f, 14.1291f, 40.5072f, 16.7751f);
                instancePath.cubicTo(40.5072f, 19.4181f, 42.6612f, 21.5721f, 45.3102f, 21.5721f);
                instancePath.cubicTo(47.9532f, 21.5721f, 50.1072f, 19.4181f, 50.1072f, 16.7751f);
                instancePath.cubicTo(50.1072f, 14.1291f, 47.9532f, 11.9781f, 45.3102f, 11.9781f);
                instancePath.close();
                instancePath.moveTo(18.0759f, 6.0E-4f);
                instancePath.cubicTo(23.6139f, 6.0E-4f, 28.1229f, 4.5066f, 28.1229f, 10.0446f);
                instancePath.cubicTo(28.1229f, 15.5856f, 23.6139f, 20.0916f, 18.0759f, 20.0916f);
                instancePath.cubicTo(12.5319f, 20.0916f, 8.0229f, 15.5856f, 8.0229f, 10.0446f);
                instancePath.cubicTo(8.0229f, 4.5066f, 12.5319f, 6.0E-4f, 18.0759f, 6.0E-4f);
                instancePath.close();
                instancePath.moveTo(18.0759f, 3.6006f);
                instancePath.cubicTo(14.5179f, 3.6006f, 11.6259f, 6.4926f, 11.6259f, 10.0446f);
                instancePath.cubicTo(11.6259f, 13.5996f, 14.5179f, 16.4916f, 18.0759f, 16.4916f);
                instancePath.cubicTo(21.6309f, 16.4916f, 24.5199f, 13.5996f, 24.5199f, 10.0446f);
                instancePath.cubicTo(24.5199f, 6.4926f, 21.6309f, 3.6006f, 18.0759f, 3.6006f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
