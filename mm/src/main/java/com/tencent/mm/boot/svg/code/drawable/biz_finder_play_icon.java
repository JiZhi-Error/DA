package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class biz_finder_play_icon extends c {
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
                instancePath.moveTo(9.524097f, 4.9379063f);
                instancePath.lineTo(19.616055f, 11.148342f);
                instancePath.cubicTo(20.086412f, 11.437793f, 20.233067f, 12.05374f, 19.943617f, 12.524097f);
                instancePath.cubicTo(19.861572f, 12.657418f, 19.749376f, 12.769615f, 19.616055f, 12.851658f);
                instancePath.lineTo(9.524097f, 19.062094f);
                instancePath.cubicTo(9.05374f, 19.351545f, 8.437793f, 19.204891f, 8.148342f, 18.734533f);
                instancePath.cubicTo(8.0513525f, 18.576925f, 8.0f, 18.395494f, 8.0f, 18.210436f);
                instancePath.lineTo(8.0f, 5.7895646f);
                instancePath.cubicTo(8.0f, 5.23728f, 8.447715f, 4.7895646f, 9.0f, 4.7895646f);
                instancePath.cubicTo(9.18506f, 4.7895646f, 9.366489f, 4.8409166f, 9.524097f, 4.9379063f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-1);
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint5, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(9.524097f, 4.9379063f);
                instancePath2.lineTo(19.616055f, 11.148342f);
                instancePath2.cubicTo(20.086412f, 11.437793f, 20.233067f, 12.05374f, 19.943617f, 12.524097f);
                instancePath2.cubicTo(19.861572f, 12.657418f, 19.749376f, 12.769615f, 19.616055f, 12.851658f);
                instancePath2.lineTo(9.524097f, 19.062094f);
                instancePath2.cubicTo(9.05374f, 19.351545f, 8.437793f, 19.204891f, 8.148342f, 18.734533f);
                instancePath2.cubicTo(8.0513525f, 18.576925f, 8.0f, 18.395494f, 8.0f, 18.210436f);
                instancePath2.lineTo(8.0f, 5.7895646f);
                instancePath2.cubicTo(8.0f, 5.23728f, 8.447715f, 4.7895646f, 9.0f, 4.7895646f);
                instancePath2.cubicTo(9.18506f, 4.7895646f, 9.366489f, 4.8409166f, 9.524097f, 4.9379063f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint6);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
