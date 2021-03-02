package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_live_nearby extends c {
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
                instancePath.moveTo(10.573107f, 12.5f);
                instancePath.lineTo(13.426832f, 12.5f);
                instancePath.cubicTo(14.295221f, 12.5f, 15.0f, 13.241355f, 15.0f, 14.157275f);
                instancePath.cubicTo(15.0f, 14.205889f, 14.997903f, 14.255607f, 14.992659f, 14.30422f);
                instancePath.lineTo(13.962876f, 21.148779f);
                instancePath.cubicTo(13.8892565f, 21.6381f, 13.468834f, 22.0f, 12.974006f, 22.0f);
                instancePath.lineTo(11.024885f, 22.0f);
                instancePath.cubicTo(10.530057f, 22.0f, 10.109634f, 21.6381f, 10.036015f, 21.148779f);
                instancePath.lineTo(9.006232f, 14.30422f);
                instancePath.cubicTo(8.929671f, 13.392719f, 9.567328f, 12.588388f, 10.43257f, 12.506629f);
                instancePath.cubicTo(10.479766f, 12.50221f, 10.525912f, 12.5f, 10.573107f, 12.5f);
                instancePath.close();
                instancePath.moveTo(13.79958f, 14.175524f);
                instancePath.cubicTo(13.799681f, 14.174585f, 13.8f, 14.167937f, 13.8f, 14.157275f);
                instancePath.cubicTo(13.8f, 13.891019f, 13.618591f, 13.7f, 13.426832f, 13.7f);
                instancePath.lineTo(10.573107f, 13.7f);
                instancePath.cubicTo(10.563783f, 13.7f, 10.554969f, 13.7004175f, 10.545459f, 13.701307f);
                instancePath.cubicTo(10.349497f, 13.719825f, 10.179384f, 13.934272f, 10.192877f, 14.125687f);
                instancePath.lineTo(11.197045f, 20.8f);
                instancePath.lineTo(12.801871f, 20.8f);
                instancePath.lineTo(13.79958f, 14.175524f);
                instancePath.close();
                instancePath.moveTo(12.0f, 11.6f);
                instancePath.cubicTo(10.426629f, 11.6f, 9.15f, 10.323371f, 9.15f, 8.75f);
                instancePath.cubicTo(9.15f, 7.176629f, 10.426629f, 5.9f, 12.0f, 5.9f);
                instancePath.cubicTo(13.573371f, 5.9f, 14.85f, 7.176629f, 14.85f, 8.75f);
                instancePath.cubicTo(14.85f, 10.323371f, 13.573371f, 11.6f, 12.0f, 11.6f);
                instancePath.close();
                instancePath.moveTo(12.0f, 10.4f);
                instancePath.cubicTo(12.910629f, 10.4f, 13.65f, 9.660629f, 13.65f, 8.75f);
                instancePath.cubicTo(13.65f, 7.8393707f, 12.910629f, 7.1f, 12.0f, 7.1f);
                instancePath.cubicTo(11.089371f, 7.1f, 10.35f, 7.8393707f, 10.35f, 8.75f);
                instancePath.cubicTo(10.35f, 9.660629f, 11.089371f, 10.4f, 12.0f, 10.4f);
                instancePath.close();
                instancePath.moveTo(7.5901847f, 2.470671f);
                instancePath.lineTo(8.142132f, 3.5362008f);
                instancePath.cubicTo(5.3745265f, 4.9698277f, 3.6f, 7.826949f, 3.6f, 11.0f);
                instancePath.cubicTo(3.6f, 13.837717f, 5.017167f, 16.43411f, 7.3315477f, 17.984367f);
                instancePath.lineTo(6.6637216f, 18.981367f);
                instancePath.cubicTo(4.02019f, 17.210634f, 2.4f, 14.242281f, 2.4f, 11.0f);
                instancePath.cubicTo(2.4f, 7.3741994f, 4.4282527f, 4.10856f, 7.5901847f, 2.470671f);
                instancePath.close();
                instancePath.moveTo(17.341055f, 18.978165f);
                instancePath.lineTo(16.672632f, 17.981565f);
                instancePath.cubicTo(18.984625f, 16.430904f, 20.4f, 13.835936f, 20.4f, 11.0f);
                instancePath.cubicTo(20.4f, 7.8265576f, 18.625032f, 4.9691405f, 15.856895f, 3.5356972f);
                instancePath.lineTo(16.408703f, 2.4700952f);
                instancePath.cubicTo(19.571243f, 4.1077747f, 21.6f, 7.3737516f, 21.6f, 11.0f);
                instancePath.cubicTo(21.6f, 14.240244f, 19.981857f, 17.206972f, 17.341055f, 18.978165f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
