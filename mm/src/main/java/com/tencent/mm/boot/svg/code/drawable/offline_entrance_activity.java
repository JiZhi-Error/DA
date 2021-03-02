package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class offline_entrance_activity extends c {
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
                instancePath.moveTo(18.0f, 3.0f);
                instancePath.cubicTo(18.552284f, 3.0f, 19.0f, 3.4477153f, 19.0f, 4.0f);
                instancePath.lineTo(19.0f, 20.0f);
                instancePath.cubicTo(19.0f, 20.552284f, 18.552284f, 21.0f, 18.0f, 21.0f);
                instancePath.lineTo(6.0f, 21.0f);
                instancePath.cubicTo(5.4477153f, 21.0f, 5.0f, 20.552284f, 5.0f, 20.0f);
                instancePath.lineTo(5.0f, 4.0f);
                instancePath.cubicTo(5.0f, 3.4477153f, 5.4477153f, 3.0f, 6.0f, 3.0f);
                instancePath.lineTo(18.0f, 3.0f);
                instancePath.close();
                instancePath.moveTo(17.8f, 4.2f);
                instancePath.lineTo(6.2f, 4.2f);
                instancePath.lineTo(6.2f, 19.8f);
                instancePath.lineTo(17.8f, 19.8f);
                instancePath.lineTo(17.799f, 14.409f);
                instancePath.lineTo(11.328912f, 17.912493f);
                instancePath.lineTo(11.269167f, 17.94499f);
                instancePath.cubicTo(11.195391f, 17.97961f, 11.112337f, 18.0f, 11.024304f, 18.0f);
                instancePath.cubicTo(10.81995f, 18.0f, 10.6423f, 17.89444f, 10.549062f, 17.738543f);
                instancePath.lineTo(10.513533f, 17.66548f);
                instancePath.lineTo(9.026025f, 14.602328f);
                instancePath.cubicTo(9.009957f, 14.568983f, 9.0f, 14.531177f, 9.0f, 14.494432f);
                instancePath.cubicTo(9.0f, 14.353402f, 9.121979f, 14.239135f, 9.272245f, 14.239135f);
                instancePath.cubicTo(9.333801f, 14.239135f, 9.389698f, 14.258038f, 9.435412f, 14.289897f);
                instancePath.lineTo(11.1904125f, 15.462525f);
                instancePath.cubicTo(11.318275f, 15.541111f, 11.471936f, 15.587414f, 11.636687f, 15.587414f);
                instancePath.cubicTo(11.734677f, 15.587414f, 11.828594f, 15.570422f, 11.915722f, 15.540474f);
                instancePath.cubicTo(11.915722f, 15.540474f, 14.154441f, 14.607664f, 16.365448f, 13.686844f);
                instancePath.lineTo(16.821758f, 13.496811f);
                instancePath.cubicTo(17.154654f, 13.35818f, 17.483322f, 13.221321f, 17.799871f, 13.089524f);
                instancePath.lineTo(17.8f, 4.2f);
                instancePath.close();
                instancePath.moveTo(13.5f, 9.0f);
                instancePath.lineTo(13.5f, 10.2f);
                instancePath.lineTo(7.5f, 10.2f);
                instancePath.lineTo(7.5f, 9.0f);
                instancePath.lineTo(13.5f, 9.0f);
                instancePath.close();
                instancePath.moveTo(13.5f, 6.0f);
                instancePath.lineTo(13.5f, 7.2000003f);
                instancePath.lineTo(7.5f, 7.2000003f);
                instancePath.lineTo(7.5f, 6.0f);
                instancePath.lineTo(13.5f, 6.0f);
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
