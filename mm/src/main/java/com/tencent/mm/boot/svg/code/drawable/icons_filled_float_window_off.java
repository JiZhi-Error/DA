package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_float_window_off extends c {
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
                instancePath.moveTo(18.207382f, 11.843421f);
                instancePath.cubicTo(23.185343f, 8.170759f, 29.339167f, 6.0f, 36.0f, 6.0f);
                instancePath.cubicTo(52.568542f, 6.0f, 66.0f, 19.431458f, 66.0f, 36.0f);
                instancePath.cubicTo(66.0f, 42.66083f, 63.829243f, 48.81466f, 60.156578f, 53.792618f);
                instancePath.lineTo(64.637825f, 58.273865f);
                instancePath.lineTo(61.455845f, 61.455845f);
                instancePath.lineTo(10.544156f, 10.544156f);
                instancePath.lineTo(13.726136f, 7.3621755f);
                instancePath.lineTo(18.207382f, 11.843421f);
                instancePath.close();
                instancePath.moveTo(55.853252f, 49.489292f);
                instancePath.cubicTo(58.470295f, 45.645054f, 60.0f, 41.001167f, 60.0f, 36.0f);
                instancePath.cubicTo(60.0f, 22.745167f, 49.254833f, 12.0f, 36.0f, 12.0f);
                instancePath.cubicTo(30.998833f, 12.0f, 26.354946f, 13.529704f, 22.510708f, 16.146746f);
                instancePath.lineTo(26.856148f, 20.492186f);
                instancePath.cubicTo(29.535957f, 18.908682f, 32.66186f, 18.0f, 36.0f, 18.0f);
                instancePath.cubicTo(45.941124f, 18.0f, 54.0f, 26.058874f, 54.0f, 36.0f);
                instancePath.cubicTo(54.0f, 39.33814f, 53.091316f, 42.464043f, 51.507812f, 45.143852f);
                instancePath.lineTo(55.853252f, 49.489292f);
                instancePath.close();
                instancePath.moveTo(47.050407f, 40.686447f);
                instancePath.cubicTo(47.66179f, 39.24665f, 48.0f, 37.662823f, 48.0f, 36.0f);
                instancePath.cubicTo(48.0f, 29.372583f, 42.62742f, 24.0f, 36.0f, 24.0f);
                instancePath.cubicTo(34.337177f, 24.0f, 32.75335f, 24.33821f, 31.313553f, 24.94959f);
                instancePath.lineTo(47.050407f, 40.686447f);
                instancePath.close();
                instancePath.moveTo(11.843421f, 18.207382f);
                instancePath.lineTo(16.146746f, 22.510708f);
                instancePath.cubicTo(13.529704f, 26.354946f, 12.0f, 30.998833f, 12.0f, 36.0f);
                instancePath.cubicTo(12.0f, 49.254833f, 22.745167f, 60.0f, 36.0f, 60.0f);
                instancePath.cubicTo(41.001167f, 60.0f, 45.645054f, 58.470295f, 49.489292f, 55.853252f);
                instancePath.lineTo(53.792618f, 60.156578f);
                instancePath.cubicTo(48.81466f, 63.829243f, 42.66083f, 66.0f, 36.0f, 66.0f);
                instancePath.cubicTo(19.431458f, 66.0f, 6.0f, 52.568542f, 6.0f, 36.0f);
                instancePath.cubicTo(6.0f, 29.339167f, 8.170759f, 23.185343f, 11.843421f, 18.207382f);
                instancePath.close();
                instancePath.moveTo(20.492186f, 26.856148f);
                instancePath.lineTo(24.94959f, 31.313553f);
                instancePath.cubicTo(24.33821f, 32.75335f, 24.0f, 34.337177f, 24.0f, 36.0f);
                instancePath.cubicTo(24.0f, 42.62742f, 29.372583f, 48.0f, 36.0f, 48.0f);
                instancePath.cubicTo(37.662823f, 48.0f, 39.24665f, 47.66179f, 40.686447f, 47.050407f);
                instancePath.lineTo(45.143852f, 51.507812f);
                instancePath.cubicTo(42.464043f, 53.091316f, 39.33814f, 54.0f, 36.0f, 54.0f);
                instancePath.cubicTo(26.058874f, 54.0f, 18.0f, 45.941124f, 18.0f, 36.0f);
                instancePath.cubicTo(18.0f, 32.66186f, 18.908682f, 29.535957f, 20.492186f, 26.856148f);
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
