package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icon_line_share extends c {
    private final int height = 48;
    private final int width = 48;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 48;
            case 1:
                return 48;
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
                instancePath.moveTo(16.0f, 14.0f);
                instancePath.lineTo(16.0f, 16.4f);
                instancePath.lineTo(10.4f, 16.4f);
                instancePath.lineTo(10.4f, 41.6f);
                instancePath.lineTo(37.6f, 41.6f);
                instancePath.lineTo(37.6f, 16.4f);
                instancePath.lineTo(32.0f, 16.4f);
                instancePath.lineTo(32.0f, 14.0f);
                instancePath.lineTo(38.002087f, 14.0f);
                instancePath.cubicTo(39.101738f, 14.0f, 40.0f, 14.891677f, 40.0f, 15.991617f);
                instancePath.lineTo(40.0f, 42.008385f);
                instancePath.cubicTo(40.0f, 43.10216f, 39.108322f, 44.0f, 38.008385f, 44.0f);
                instancePath.lineTo(9.991617f, 44.0f);
                instancePath.cubicTo(8.8978405f, 44.0f, 8.0f, 43.108322f, 8.0f, 42.008385f);
                instancePath.lineTo(8.0f, 15.991617f);
                instancePath.cubicTo(8.0f, 14.8978405f, 8.894496f, 14.0f, 9.997913f, 14.0f);
                instancePath.lineTo(16.0f, 14.0f);
                instancePath.close();
                instancePath.moveTo(25.414213f, 5.343146f);
                instancePath.lineTo(31.071068f, 11.0f);
                instancePath.lineTo(29.374012f, 12.697057f);
                instancePath.lineTo(25.199987f, 8.523033f);
                instancePath.lineTo(25.199987f, 27.0f);
                instancePath.lineTo(22.799988f, 27.0f);
                instancePath.lineTo(22.799988f, 8.523057f);
                instancePath.lineTo(18.625988f, 12.697057f);
                instancePath.lineTo(16.928932f, 11.0f);
                instancePath.lineTo(22.585787f, 5.343146f);
                instancePath.cubicTo(23.366835f, 4.562097f, 24.633165f, 4.562097f, 25.414213f, 5.343146f);
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
