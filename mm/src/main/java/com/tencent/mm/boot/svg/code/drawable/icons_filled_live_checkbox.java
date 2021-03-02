package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_live_checkbox extends c {
    private final int height = 16;
    private final int width = 16;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 16;
            case 1:
                return 16;
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
                instancePaint3.setColor(-40634);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(16.0f, 8.098765f);
                instancePath.cubicTo(16.0f, 3.5816295f, 12.41837f, 0.0f, 7.9012346f, 0.0f);
                instancePath.cubicTo(3.5816295f, 0.0f, 0.0f, 3.5816295f, 0.0f, 8.098765f);
                instancePath.cubicTo(0.0f, 12.41837f, 3.5816295f, 16.0f, 7.9012346f, 16.0f);
                instancePath.cubicTo(12.41837f, 16.0f, 16.0f, 12.41837f, 16.0f, 8.098765f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-1);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(6.9093075f, 10.209139f);
                instancePath2.lineTo(4.7071066f, 8.006938f);
                instancePath2.lineTo(4.0f, 8.714046f);
                instancePath2.lineTo(6.437903f, 11.151948f);
                instancePath2.cubicTo(6.698252f, 11.412297f, 7.1203623f, 11.412297f, 7.380712f, 11.151948f);
                instancePath2.lineTo(12.49222f, 6.04044f);
                instancePath2.lineTo(12.49222f, 6.04044f);
                instancePath2.lineTo(11.785113f, 5.3333335f);
                instancePath2.lineTo(6.9093075f, 10.209139f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
