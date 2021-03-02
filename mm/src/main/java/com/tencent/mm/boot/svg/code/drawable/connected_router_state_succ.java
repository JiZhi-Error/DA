package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class connected_router_state_succ extends c {
    private final int height = 240;
    private final int width = 240;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 240;
            case 1:
                return 240;
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
                instancePaint3.setColor(-16139513);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(213.0f, 121.14815f);
                instancePath.cubicTo(213.0f, 68.636444f, 171.36356f, 27.0f, 118.85185f, 27.0f);
                instancePath.cubicTo(68.636444f, 27.0f, 27.0f, 68.636444f, 27.0f, 121.14815f);
                instancePath.cubicTo(27.0f, 171.36356f, 68.636444f, 213.0f, 118.85185f, 213.0f);
                instancePath.cubicTo(171.36356f, 213.0f, 213.0f, 171.36356f, 213.0f, 121.14815f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-1);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(73.845436f, 126.13097f);
                instancePath2.cubicTo(73.46136f, 125.73346f, 73.40951f, 125.05811f, 73.74635f, 124.59977f);
                instancePath2.lineTo(77.93406f, 118.90164f);
                instancePath2.cubicTo(78.26342f, 118.45349f, 78.884964f, 118.36194f, 79.323456f, 118.69801f);
                instancePath2.lineTo(104.235695f, 137.79182f);
                instancePath2.cubicTo(104.67368f, 138.1275f, 105.378365f, 138.10837f, 105.79235f, 137.76349f);
                instancePath2.lineTo(166.43353f, 87.244484f);
                instancePath2.cubicTo(166.85526f, 86.89315f, 167.5176f, 86.92481f, 167.91162f, 87.31395f);
                instancePath2.lineTo(171.86308f, 91.2164f);
                instancePath2.cubicTo(172.25768f, 91.6061f, 172.26135f, 92.23321f, 171.86464f, 92.623634f);
                instancePath2.lineTo(105.73968f, 157.70047f);
                instancePath2.cubicTo(105.34595f, 158.08797f, 104.711266f, 158.07556f, 104.33132f, 157.68234f);
                instancePath2.lineTo(73.845436f, 126.13097f);
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
