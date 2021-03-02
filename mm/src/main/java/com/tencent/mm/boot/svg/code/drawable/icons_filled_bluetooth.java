package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_bluetooth extends c {
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
                c.instanceMatrix(looper);
                c.instanceMatrixArray(looper);
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
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(35.557423f, 5.8705916f);
                instancePath.lineTo(50.848534f, 21.151468f);
                instancePath.cubicTo(52.021313f, 22.32183f, 52.02195f, 24.221327f, 50.85077f, 25.393291f);
                instancePath.cubicTo(50.8505f, 25.393564f, 50.850224f, 25.393835f, 50.849136f, 25.393291f);
                instancePath.lineTo(40.242115f, 35.99924f);
                instancePath.lineTo(40.242115f, 35.99924f);
                instancePath.lineTo(50.849262f, 46.606583f);
                instancePath.cubicTo(52.020676f, 47.77823f, 52.020706f, 49.677643f, 50.84933f, 50.84933f);
                instancePath.lineTo(35.55782f, 66.14209f);
                instancePath.cubicTo(34.972057f, 66.7279f, 34.022312f, 66.727936f, 33.4365f, 66.14217f);
                instancePath.cubicTo(33.15517f, 65.86086f, 32.997116f, 65.47932f, 32.997116f, 65.08147f);
                instancePath.lineTo(32.997116f, 43.244244f);
                instancePath.lineTo(32.997116f, 43.244244f);
                instancePath.lineTo(21.150757f, 55.091885f);
                instancePath.lineTo(16.908117f, 50.849243f);
                instancePath.lineTo(31.755117f, 35.99924f);
                instancePath.lineTo(16.908117f, 21.150757f);
                instancePath.lineTo(21.150757f, 16.908117f);
                instancePath.lineTo(32.997116f, 28.754242f);
                instancePath.lineTo(32.997116f, 6.931607f);
                instancePath.cubicTo(32.997116f, 6.1031795f, 33.66869f, 5.431607f, 34.497116f, 5.431607f);
                instancePath.cubicTo(34.894768f, 5.431607f, 35.276146f, 5.5895042f, 35.557423f, 5.8705916f);
                instancePath.close();
                instancePath.moveTo(38.997116f, 43.24124f);
                instancePath.lineTo(38.997116f, 54.218243f);
                instancePath.lineTo(44.487118f, 48.72824f);
                instancePath.lineTo(38.997116f, 43.24124f);
                instancePath.close();
                instancePath.moveTo(38.997116f, 17.795242f);
                instancePath.lineTo(38.997116f, 28.757242f);
                instancePath.lineTo(44.478115f, 23.276243f);
                instancePath.lineTo(38.997116f, 17.795242f);
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
