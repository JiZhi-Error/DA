package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class grid_item_video_pic extends c {
    private final int height = 30;
    private final int width = 55;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 55;
            case 1:
                return 30;
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
                instancePaint3.setColor(-1);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 4.0f);
                instancePath.cubicTo(0.0f, 1.7908609f, 1.7908609f, 0.0f, 4.0f, 0.0f);
                instancePath.lineTo(30.0f, 0.0f);
                instancePath.cubicTo(32.20914f, 0.0f, 34.0f, 1.7908609f, 34.0f, 4.0f);
                instancePath.lineTo(34.0f, 26.0f);
                instancePath.cubicTo(34.0f, 28.209139f, 32.20914f, 30.0f, 30.0f, 30.0f);
                instancePath.lineTo(4.0f, 30.0f);
                instancePath.cubicTo(1.7908609f, 30.0f, 0.0f, 28.209139f, 0.0f, 26.0f);
                instancePath.lineTo(0.0f, 4.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(38.71698f, 13.0f);
                instancePath2.cubicTo(43.57647f, 8.820671f, 48.100197f, 4.1560574f, 54.0f, 1.0f);
                instancePath2.cubicTo(54.131836f, 10.646817f, 54.07152f, 20.353184f, 54.0f, 30.0f);
                instancePath2.lineTo(52.981133f, 30.0f);
                instancePath2.cubicTo(47.165295f, 25.652977f, 41.495552f, 21.266256f, 35.660378f, 17.0f);
                instancePath2.cubicTo(34.679802f, 14.844969f, 37.29351f, 13.584531f, 38.71698f, 13.0f);
                instancePath2.lineTo(38.71698f, 13.0f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
