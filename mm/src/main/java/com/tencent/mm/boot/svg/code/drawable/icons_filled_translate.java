package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_translate extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(46.423737f, 27.808594f);
                instancePath.lineTo(51.36328f, 27.808594f);
                instancePath.lineTo(52.652344f, 31.910156f);
                instancePath.lineTo(56.414062f, 31.910156f);
                instancePath.lineTo(50.53125f, 15.0f);
                instancePath.lineTo(46.371094f, 15.0f);
                instancePath.lineTo(42.725563f, 25.5f);
                instancePath.lineTo(30.0f, 25.5f);
                instancePath.lineTo(30.0f, 9.00742f);
                instancePath.cubicTo(30.0f, 7.367283f, 31.346468f, 6.0f, 33.00742f, 6.0f);
                instancePath.lineTo(62.99258f, 6.0f);
                instancePath.cubicTo(64.63271f, 6.0f, 66.0f, 7.346468f, 66.0f, 9.00742f);
                instancePath.lineTo(66.0f, 38.99258f);
                instancePath.cubicTo(66.0f, 40.632717f, 64.653534f, 42.0f, 62.99258f, 42.0f);
                instancePath.lineTo(46.5f, 42.0f);
                instancePath.lineTo(46.5f, 28.478062f);
                instancePath.cubicTo(46.5f, 28.247871f, 46.473606f, 28.023783f, 46.423737f, 27.808594f);
                instancePath.close();
                instancePath.moveTo(48.351562f, 18.234375f);
                instancePath.lineTo(48.433594f, 18.234375f);
                instancePath.lineTo(50.601562f, 25.160156f);
                instancePath.lineTo(46.183594f, 25.160156f);
                instancePath.lineTo(48.351562f, 18.234375f);
                instancePath.close();
                instancePath.moveTo(9.00742f, 30.0f);
                instancePath.lineTo(38.99258f, 30.0f);
                instancePath.cubicTo(40.632717f, 30.0f, 42.0f, 31.346468f, 42.0f, 33.00742f);
                instancePath.lineTo(42.0f, 62.99258f);
                instancePath.cubicTo(42.0f, 64.63271f, 40.653534f, 66.0f, 38.99258f, 66.0f);
                instancePath.lineTo(9.00742f, 66.0f);
                instancePath.cubicTo(7.367283f, 66.0f, 6.0f, 64.653534f, 6.0f, 62.99258f);
                instancePath.lineTo(6.0f, 33.00742f);
                instancePath.cubicTo(6.0f, 31.367283f, 7.346468f, 30.0f, 9.00742f, 30.0f);
                instancePath.close();
                instancePath.moveTo(33.675735f, 44.09066f);
                instancePath.lineTo(33.675735f, 41.006893f);
                instancePath.lineTo(24.55474f, 41.006893f);
                instancePath.lineTo(26.31379f, 40.463978f);
                instancePath.cubicTo(26.096622f, 39.55188f, 25.488558f, 38.18373f, 24.94564f, 37.163048f);
                instancePath.lineTo(21.557844f, 38.162014f);
                instancePath.cubicTo(21.970459f, 39.030678f, 22.361359f, 40.13823f, 22.578526f, 41.006893f);
                instancePath.lineTo(13.631267f, 41.006893f);
                instancePath.lineTo(13.631267f, 44.09066f);
                instancePath.lineTo(17.062496f, 44.09066f);
                instancePath.cubicTo(18.191763f, 47.022408f, 19.581629f, 49.51982f, 21.38411f, 51.604618f);
                instancePath.cubicTo(19.19073f, 53.21165f, 16.476147f, 54.340916f, 13.1535f, 55.079285f);
                instancePath.cubicTo(13.761566f, 55.81765f, 14.717099f, 57.29438f, 15.064565f, 58.054462f);
                instancePath.cubicTo(18.495796f, 57.09893f, 21.362394f, 55.73078f, 23.729507f, 53.86315f);
                instancePath.cubicTo(25.966324f, 55.665634f, 28.680904f, 57.012066f, 32.02527f, 57.88073f);
                instancePath.cubicTo(32.503036f, 57.012066f, 33.43685f, 55.6222f, 34.1535f, 54.927265f);
                instancePath.cubicTo(31.004585f, 54.232334f, 28.376871f, 53.081352f, 26.205206f, 51.517754f);
                instancePath.cubicTo(27.985971f, 49.498104f, 29.375837f, 47.044125f, 30.396519f, 44.09066f);
                instancePath.lineTo(33.675735f, 44.09066f);
                instancePath.close();
                instancePath.moveTo(26.83499f, 44.09066f);
                instancePath.cubicTo(26.096622f, 46.175457f, 25.075941f, 47.934505f, 23.794659f, 49.41124f);
                instancePath.cubicTo(22.339643f, 47.869354f, 21.18866f, 46.08859f, 20.341711f, 44.09066f);
                instancePath.lineTo(26.83499f, 44.09066f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
