package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class fts_websearch_relevant_icon extends c {
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
                instancePaint3.setColor(1275068416);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(16.30993f, 15.561403f);
                instancePath.lineTo(20.424265f, 19.675735f);
                instancePath.lineTo(19.575735f, 20.524263f);
                instancePath.lineTo(15.452851f, 16.401379f);
                instancePath.cubicTo(14.24281f, 17.400068f, 12.691467f, 18.0f, 11.0f, 18.0f);
                instancePath.cubicTo(7.134f, 18.0f, 4.0f, 14.866f, 4.0f, 11.0f);
                instancePath.cubicTo(4.0f, 7.134f, 7.134f, 4.0f, 11.0f, 4.0f);
                instancePath.cubicTo(14.866f, 4.0f, 18.0f, 7.134f, 18.0f, 11.0f);
                instancePath.cubicTo(18.0f, 12.742484f, 17.363333f, 14.336264f, 16.30993f, 15.561403f);
                instancePath.close();
                instancePath.moveTo(16.799997f, 11.000012f);
                instancePath.cubicTo(16.799997f, 7.7967553f, 14.203255f, 5.200012f, 10.999997f, 5.200012f);
                instancePath.cubicTo(7.79674f, 5.200012f, 5.199997f, 7.7967553f, 5.199997f, 11.000012f);
                instancePath.cubicTo(5.199997f, 14.20327f, 7.79674f, 16.800013f, 10.999997f, 16.800013f);
                instancePath.cubicTo(14.203255f, 16.800013f, 16.799997f, 14.20327f, 16.799997f, 11.000012f);
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
