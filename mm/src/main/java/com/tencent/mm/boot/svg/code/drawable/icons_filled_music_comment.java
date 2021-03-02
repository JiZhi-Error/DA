package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_music_comment extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(19.0f, 4.5f);
                instancePath.cubicTo(20.380713f, 4.5f, 21.5f, 5.619288f, 21.5f, 7.0f);
                instancePath.lineTo(21.5f, 15.5f);
                instancePath.cubicTo(21.5f, 16.880713f, 20.380713f, 18.0f, 19.0f, 18.0f);
                instancePath.lineTo(12.455f, 18.0f);
                instancePath.lineTo(7.9787197f, 21.005764f);
                instancePath.cubicTo(7.923774f, 21.042656f, 7.862335f, 21.068089f, 7.798067f, 21.080944f);
                instancePath.lineTo(7.7f, 21.090654f);
                instancePath.cubicTo(7.4545403f, 21.090654f, 7.2503915f, 20.91378f, 7.2080555f, 20.68053f);
                instancePath.lineTo(7.2f, 20.590654f);
                instancePath.lineTo(7.2f, 18.0f);
                instancePath.lineTo(5.0f, 18.0f);
                instancePath.cubicTo(3.6192882f, 18.0f, 2.5f, 16.880713f, 2.5f, 15.5f);
                instancePath.lineTo(2.5f, 7.0f);
                instancePath.cubicTo(2.5f, 5.619288f, 3.6192882f, 4.5f, 5.0f, 4.5f);
                instancePath.lineTo(19.0f, 4.5f);
                instancePath.close();
                instancePath.moveTo(12.103492f, 7.0f);
                instancePath.lineTo(12.060873f, 7.0038433f);
                instancePath.cubicTo(11.993414f, 7.0196695f, 11.943186f, 7.0802236f, 11.943186f, 7.1525097f);
                instancePath.lineTo(11.943186f, 7.1525097f);
                instancePath.lineTo(11.943736f, 11.939682f);
                instancePath.cubicTo(11.752537f, 11.872033f, 11.546762f, 11.83522f, 11.33239f, 11.83522f);
                instancePath.cubicTo(10.320389f, 11.83522f, 9.5f, 12.655609f, 9.5f, 13.66761f);
                instancePath.cubicTo(9.5f, 14.679611f, 10.320389f, 15.5f, 11.33239f, 15.5f);
                instancePath.lineTo(11.33239f, 15.5f);
                instancePath.lineTo(11.440057f, 15.496889f);
                instancePath.cubicTo(12.401943f, 15.441156f, 13.16478f, 14.643468f, 13.16478f, 13.66761f);
                instancePath.lineTo(13.16478f, 13.66761f);
                instancePath.lineTo(13.16478f, 8.937868f);
                instancePath.lineTo(14.8368635f, 9.105346f);
                instancePath.lineTo(14.879482f, 9.101502f);
                instancePath.cubicTo(14.946941f, 9.085676f, 14.997169f, 9.025122f, 14.997169f, 8.952836f);
                instancePath.lineTo(14.997169f, 8.952836f);
                instancePath.lineTo(14.997169f, 7.427368f);
                instancePath.cubicTo(14.997169f, 7.3489184f, 14.937724f, 7.2832327f, 14.859664f, 7.275427f);
                instancePath.lineTo(14.859664f, 7.275427f);
                instancePath.lineTo(12.103492f, 7.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
