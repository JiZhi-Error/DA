package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_little_like extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint2, looper);
                instancePaint3.setStrokeWidth(1.0f);
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(WebView.NIGHT_MODE_COLOR);
                instancePaint4.setStrokeWidth(6.6f);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(57.942196f, 21.72685f);
                instancePath.cubicTo(55.65763f, 19.442284f, 52.663338f, 18.3f, 49.66905f, 18.3f);
                instancePath.cubicTo(46.674755f, 18.3f, 43.680466f, 19.442284f, 41.395897f, 21.72685f);
                instancePath.cubicTo(41.163303f, 21.959446f, 40.9035f, 22.215006f, 40.61644f, 22.493475f);
                instancePath.lineTo(36.955902f, 25.987568f);
                instancePath.lineTo(34.678135f, 23.841486f);
                instancePath.cubicTo(34.31987f, 23.503931f, 33.988186f, 23.188755f, 33.68307f, 22.895971f);
                instancePath.lineTo(32.499275f, 21.739794f);
                instancePath.cubicTo(30.213083f, 19.446598f, 27.213144f, 18.3f, 24.213203f, 18.3f);
                instancePath.cubicTo(21.218912f, 18.3f, 18.22462f, 19.442284f, 15.940054f, 21.72685f);
                instancePath.cubicTo(13.678576f, 23.988329f, 12.536377f, 26.945248f, 12.5134f, 29.909332f);
                instancePath.cubicTo(12.490443f, 32.870785f, 13.584305f, 35.83961f, 15.795814f, 38.12891f);
                instancePath.lineTo(36.941f, 59.27432f);
                instancePath.lineTo(58.085415f, 38.127476f);
                instancePath.cubicTo(60.297375f, 35.83884f, 61.391483f, 32.870426f, 61.3687f, 29.909258f);
                instancePath.cubicTo(61.345894f, 26.945274f, 60.203682f, 23.988337f, 57.942196f, 21.72685f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint5);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
