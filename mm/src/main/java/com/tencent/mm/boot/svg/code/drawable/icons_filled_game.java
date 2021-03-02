package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_game extends c {
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
                instancePath.moveTo(23.600313f, 33.75f);
                instancePath.lineTo(5.9272847f, 33.75f);
                instancePath.cubicTo(6.219718f, 33.021572f, 6.659744f, 32.340256f, 7.2466154f, 31.753386f);
                instancePath.lineTo(31.753386f, 7.2466154f);
                instancePath.cubicTo(32.341805f, 6.6581945f, 33.02293f, 6.218383f, 33.75f, 5.9264426f);
                instancePath.lineTo(33.75f, 23.600313f);
                instancePath.cubicTo(28.594849f, 24.529593f, 24.529593f, 28.594849f, 23.600313f, 33.75f);
                instancePath.close();
                instancePath.moveTo(66.073555f, 33.75f);
                instancePath.lineTo(48.399685f, 33.75f);
                instancePath.cubicTo(47.47041f, 28.594849f, 43.40515f, 24.529593f, 38.25f, 23.600313f);
                instancePath.lineTo(38.25f, 5.9272847f);
                instancePath.cubicTo(38.978428f, 6.219718f, 39.659744f, 6.659744f, 40.246616f, 7.2466154f);
                instancePath.lineTo(64.75339f, 31.753386f);
                instancePath.cubicTo(65.341805f, 32.341805f, 65.78162f, 33.02293f, 66.073555f, 33.75f);
                instancePath.close();
                instancePath.moveTo(66.072716f, 38.25f);
                instancePath.cubicTo(65.78028f, 38.978428f, 65.340256f, 39.659744f, 64.75339f, 40.246616f);
                instancePath.lineTo(40.246616f, 64.75339f);
                instancePath.cubicTo(39.658195f, 65.341805f, 38.97707f, 65.78162f, 38.25f, 66.073555f);
                instancePath.lineTo(38.25f, 48.399685f);
                instancePath.cubicTo(43.40515f, 47.47041f, 47.47041f, 43.40515f, 48.399685f, 38.25f);
                instancePath.lineTo(66.072716f, 38.25f);
                instancePath.close();
                instancePath.moveTo(5.9264426f, 38.25f);
                instancePath.lineTo(23.600313f, 38.25f);
                instancePath.cubicTo(24.529593f, 43.40515f, 28.594849f, 47.47041f, 33.75f, 48.399685f);
                instancePath.lineTo(33.75f, 66.072716f);
                instancePath.cubicTo(33.021572f, 65.78028f, 32.340256f, 65.340256f, 31.753386f, 64.75339f);
                instancePath.lineTo(7.2466154f, 40.246616f);
                instancePath.cubicTo(6.6581945f, 39.658195f, 6.218383f, 38.97707f, 5.9264426f, 38.25f);
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
