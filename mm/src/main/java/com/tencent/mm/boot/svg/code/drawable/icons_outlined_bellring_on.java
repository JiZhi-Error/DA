package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_bellring_on extends c {
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
                instancePath.moveTo(39.0f, 60.00001f);
                instancePath.lineTo(39.0f, 60.6f);
                instancePath.cubicTo(39.0f, 62.256855f, 37.656853f, 63.6f, 36.0f, 63.6f);
                instancePath.cubicTo(34.343147f, 63.6f, 33.0f, 62.256855f, 33.0f, 60.6f);
                instancePath.lineTo(33.0f, 60.0f);
                instancePath.lineTo(15.560121f, 60.0f);
                instancePath.cubicTo(14.921177f, 60.0f, 14.2989235f, 59.795994f, 13.784002f, 59.4177f);
                instancePath.cubicTo(12.448801f, 58.43678f, 12.161601f, 56.55919f, 13.142524f, 55.223988f);
                instancePath.cubicTo(16.380814f, 50.815952f, 18.0f, 46.407974f, 18.0f, 42.0f);
                instancePath.lineTo(18.0f, 30.0f);
                instancePath.cubicTo(18.0f, 22.132008f, 23.048136f, 15.443072f, 30.08219f, 12.995409f);
                instancePath.cubicTo(30.028131f, 12.671648f, 30.0f, 12.339109f, 30.0f, 12.0f);
                instancePath.cubicTo(30.0f, 8.686292f, 32.68629f, 6.0f, 36.0f, 6.0f);
                instancePath.cubicTo(39.31371f, 6.0f, 42.0f, 8.686292f, 42.0f, 12.0f);
                instancePath.cubicTo(42.0f, 12.339109f, 41.971867f, 12.671648f, 41.91781f, 12.995409f);
                instancePath.cubicTo(48.951862f, 15.443072f, 54.0f, 22.132008f, 54.0f, 30.0f);
                instancePath.lineTo(54.0f, 42.0f);
                instancePath.cubicTo(54.0f, 46.40793f, 55.619152f, 50.815853f, 58.857456f, 55.22378f);
                instancePath.cubicTo(59.235767f, 55.73873f, 59.43978f, 56.361023f, 59.43978f, 57.0f);
                instancePath.cubicTo(59.43978f, 58.656902f, 58.0966f, 60.000084f, 56.439697f, 60.000084f);
                instancePath.lineTo(39.0f, 60.00001f);
                instancePath.close();
                instancePath.moveTo(36.000015f, 56.4f);
                instancePath.lineTo(55.277493f, 56.40008f);
                instancePath.cubicTo(52.05459f, 51.70669f, 50.4f, 46.891075f, 50.4f, 42.0f);
                instancePath.lineTo(50.4f, 30.0f);
                instancePath.cubicTo(50.4f, 23.822582f, 46.474163f, 18.392626f, 40.734688f, 16.395443f);
                instancePath.lineTo(37.866898f, 15.397528f);
                instancePath.lineTo(38.366966f, 12.402531f);
                instancePath.cubicTo(38.388844f, 12.27149f, 38.4f, 12.137221f, 38.4f, 12.0f);
                instancePath.cubicTo(38.4f, 10.674517f, 37.325485f, 9.6f, 36.0f, 9.6f);
                instancePath.cubicTo(34.674515f, 9.6f, 33.6f, 10.674517f, 33.6f, 12.0f);
                instancePath.cubicTo(33.6f, 12.137221f, 33.611156f, 12.27149f, 33.633034f, 12.402531f);
                instancePath.lineTo(34.133102f, 15.397528f);
                instancePath.lineTo(31.26531f, 16.395443f);
                instancePath.cubicTo(25.525837f, 18.392626f, 21.6f, 23.822582f, 21.6f, 30.0f);
                instancePath.lineTo(21.6f, 42.0f);
                instancePath.cubicTo(21.6f, 46.890984f, 19.945477f, 51.706535f, 16.722664f, 56.40008f);
                instancePath.lineTo(36.000015f, 56.4f);
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