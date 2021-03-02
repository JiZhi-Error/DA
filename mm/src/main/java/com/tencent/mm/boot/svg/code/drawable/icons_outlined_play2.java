package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_play2 extends c {
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
                instancePaint3.setColor(-436207616);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(12.0f, 0.0f);
                instancePath.cubicTo(18.627417f, 0.0f, 24.0f, 5.372583f, 24.0f, 12.0f);
                instancePath.cubicTo(24.0f, 18.627417f, 18.627417f, 24.0f, 12.0f, 24.0f);
                instancePath.cubicTo(5.372583f, 24.0f, 0.0f, 18.627417f, 0.0f, 12.0f);
                instancePath.cubicTo(0.0f, 5.372583f, 5.372583f, 0.0f, 12.0f, 0.0f);
                instancePath.close();
                instancePath.moveTo(12.0f, 0.72f);
                instancePath.cubicTo(5.770228f, 0.72f, 0.72f, 5.770228f, 0.72f, 12.0f);
                instancePath.cubicTo(0.72f, 18.229773f, 5.770228f, 23.28f, 12.0f, 23.28f);
                instancePath.cubicTo(18.229773f, 23.28f, 23.28f, 18.229773f, 23.28f, 12.0f);
                instancePath.cubicTo(23.28f, 5.770228f, 18.229773f, 0.72f, 12.0f, 0.72f);
                instancePath.close();
                instancePath.moveTo(9.6f, 7.633908f);
                instancePath.cubicTo(9.704416f, 7.633908f, 9.807025f, 7.661157f, 9.897683f, 7.712962f);
                instancePath.lineTo(16.488344f, 11.479054f);
                instancePath.cubicTo(16.776054f, 11.64346f, 16.876013f, 12.009973f, 16.711607f, 12.297684f);
                instancePath.cubicTo(16.658453f, 12.390702f, 16.581364f, 12.4677925f, 16.488344f, 12.520946f);
                instancePath.lineTo(9.897683f, 16.287039f);
                instancePath.cubicTo(9.609973f, 16.451445f, 9.24346f, 16.351486f, 9.079054f, 16.063776f);
                instancePath.cubicTo(9.027249f, 15.973117f, 9.0f, 15.870508f, 9.0f, 15.766092f);
                instancePath.lineTo(9.0f, 8.233908f);
                instancePath.cubicTo(9.0f, 7.902537f, 9.268629f, 7.633908f, 9.6f, 7.633908f);
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
