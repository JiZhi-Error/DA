package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class card extends c {
    private final int height = 192;
    private final int width = 192;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 192;
            case 1:
                return 192;
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
                instancePaint3.setColor(-15432210);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(16.0f, 40.006973f);
                instancePath.cubicTo(16.0f, 35.584843f, 19.642445f, 32.0f, 23.934425f, 32.0f);
                instancePath.lineTo(168.06558f, 32.0f);
                instancePath.cubicTo(172.44763f, 32.0f, 176.0f, 35.55705f, 176.0f, 40.006973f);
                instancePath.lineTo(176.0f, 151.99303f);
                instancePath.cubicTo(176.0f, 156.41516f, 172.35756f, 160.0f, 168.06558f, 160.0f);
                instancePath.lineTo(23.934425f, 160.0f);
                instancePath.cubicTo(19.552362f, 160.0f, 16.0f, 156.44295f, 16.0f, 151.99303f);
                instancePath.lineTo(16.0f, 40.006973f);
                instancePath.close();
                instancePath.moveTo(25.6f, 41.6f);
                instancePath.lineTo(25.6f, 150.4f);
                instancePath.lineTo(166.4f, 150.4f);
                instancePath.lineTo(166.4f, 41.6f);
                instancePath.lineTo(25.6f, 41.6f);
                instancePath.close();
                instancePath.moveTo(40.0f, 64.0f);
                instancePath.lineTo(152.0f, 64.0f);
                instancePath.lineTo(152.0f, 73.6f);
                instancePath.lineTo(40.0f, 73.6f);
                instancePath.lineTo(40.0f, 64.0f);
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
