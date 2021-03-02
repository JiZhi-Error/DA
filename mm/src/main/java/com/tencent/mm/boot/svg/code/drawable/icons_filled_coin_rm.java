package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_coin_rm extends c {
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
                instancePath.moveTo(36.0f, 6.0f);
                instancePath.cubicTo(52.568542f, 6.0f, 66.0f, 19.431458f, 66.0f, 36.0f);
                instancePath.cubicTo(66.0f, 52.568542f, 52.568542f, 66.0f, 36.0f, 66.0f);
                instancePath.cubicTo(19.431458f, 66.0f, 6.0f, 52.568542f, 6.0f, 36.0f);
                instancePath.cubicTo(6.0f, 19.431458f, 19.431458f, 6.0f, 36.0f, 6.0f);
                instancePath.close();
                instancePath.moveTo(39.97499f, 23.55f);
                instancePath.lineTo(35.55f, 23.55f);
                instancePath.lineTo(35.553f, 48.45f);
                instancePath.lineTo(40.053f, 48.45f);
                instancePath.lineTo(40.053f, 35.031773f);
                instancePath.lineTo(43.125687f, 42.45f);
                instancePath.lineTo(47.47682f, 42.45f);
                instancePath.lineTo(50.553f, 35.043182f);
                instancePath.lineTo(50.553f, 48.45f);
                instancePath.lineTo(55.053f, 48.45f);
                instancePath.lineTo(55.053f, 23.55f);
                instancePath.lineTo(50.646057f, 23.55f);
                instancePath.lineTo(45.30732f, 36.265926f);
                instancePath.lineTo(39.97499f, 23.55f);
                instancePath.close();
                instancePath.moveTo(25.203f, 23.55f);
                instancePath.lineTo(16.953f, 23.55f);
                instancePath.lineTo(16.95f, 48.45f);
                instancePath.lineTo(21.45f, 48.45f);
                instancePath.lineTo(21.45285f, 39.45f);
                instancePath.lineTo(23.652817f, 39.45f);
                instancePath.lineTo(29.22f, 48.45f);
                instancePath.lineTo(34.4935f, 48.45f);
                instancePath.lineTo(28.49916f, 38.73667f);
                instancePath.cubicTo(31.297434f, 37.461887f, 33.153f, 34.655556f, 33.153f, 31.5f);
                instancePath.cubicTo(33.153f, 27.109337f, 29.593664f, 23.55f, 25.203f, 23.55f);
                instancePath.lineTo(25.203f, 23.55f);
                instancePath.close();
                instancePath.moveTo(21.453f, 27.44732f);
                instancePath.lineTo(25.203f, 27.45f);
                instancePath.lineTo(25.593042f, 27.46854f);
                instancePath.cubicTo(27.646803f, 27.66479f, 29.253f, 29.394821f, 29.253f, 31.5f);
                instancePath.cubicTo(29.253f, 33.73675f, 27.439753f, 35.55f, 25.203f, 35.55f);
                instancePath.lineTo(25.203f, 35.55f);
                instancePath.lineTo(21.453f, 35.54732f);
                instancePath.lineTo(21.453f, 27.44732f);
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
