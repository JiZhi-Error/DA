package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class fav_list_icon_miniprogram_default extends c {
    private final int height = 90;
    private final int width = 90;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 90;
            case 1:
                return 90;
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
                instancePaint3.setColor(-855310);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(90.0f, 0.0f);
                instancePath.lineTo(90.0f, 90.0f);
                instancePath.lineTo(0.0f, 90.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-10461088);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 17.0f, 0.0f, 1.0f, 17.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(39.67669f, 30.311752f);
                instancePath2.lineTo(39.126198f, 30.32066f);
                instancePath2.cubicTo(37.461704f, 30.32066f, 36.493164f, 29.099634f, 37.118885f, 27.691906f);
                instancePath2.cubicTo(37.547375f, 26.692091f, 38.514095f, 25.91994f, 39.655792f, 25.666336f);
                instancePath2.cubicTo(42.71041f, 24.929014f, 44.785835f, 22.541672f, 44.785835f, 19.766241f);
                instancePath2.cubicTo(44.785835f, 16.401402f, 41.573277f, 13.659318f, 37.560703f, 13.659318f);
                instancePath2.cubicTo(33.54813f, 13.659318f, 30.33557f, 16.401402f, 30.33557f, 19.766241f);
                instancePath2.lineTo(30.33557f, 36.539402f);
                instancePath2.cubicTo(30.33557f, 42.447212f, 25.055094f, 47.205643f, 18.551119f, 47.205643f);
                instancePath2.cubicTo(12.047142f, 47.205643f, 6.766667f, 42.447212f, 6.766667f, 36.539402f);
                instancePath2.cubicTo(6.766667f, 31.359217f, 10.855467f, 26.937546f, 16.426517f, 26.096806f);
                instancePath2.lineTo(16.873802f, 26.096806f);
                instancePath2.cubicTo(18.133951f, 26.096806f, 19.04164f, 26.851173f, 19.04164f, 27.928501f);
                instancePath2.cubicTo(19.042177f, 28.1131f, 19.037693f, 28.198402f, 19.019466f, 28.307756f);
                instancePath2.cubicTo(18.994898f, 28.455172f, 18.947058f, 28.59627f, 18.881117f, 28.72556f);
                instancePath2.cubicTo(18.479496f, 29.662674f, 17.452799f, 30.474003f, 16.34421f, 30.75113f);
                instancePath2.cubicTo(13.311659f, 31.483124f, 11.214164f, 33.85589f, 11.214164f, 36.539402f);
                instancePath2.cubicTo(11.214164f, 39.904243f, 14.426723f, 42.646324f, 18.439297f, 42.646324f);
                instancePath2.cubicTo(22.451872f, 42.646324f, 25.66443f, 39.904243f, 25.66443f, 36.539402f);
                instancePath2.lineTo(25.66443f, 19.766241f);
                instancePath2.cubicTo(25.66443f, 13.858431f, 30.944906f, 9.1f, 37.448883f, 9.1f);
                instancePath2.cubicTo(43.952858f, 9.1f, 49.233334f, 13.858431f, 49.233334f, 19.766241f);
                instancePath2.cubicTo(49.233334f, 24.97393f, 45.24071f, 29.344097f, 39.67669f, 30.311752f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
