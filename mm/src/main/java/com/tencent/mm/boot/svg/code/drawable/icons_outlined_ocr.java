package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_ocr extends c {
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
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(24.0f, 0.0f);
                instancePath.lineTo(24.0f, 24.0f);
                instancePath.lineTo(0.0f, 24.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-436207616);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(4.2f, 16.0f);
                instancePath2.lineTo(4.2f, 19.8f);
                instancePath2.lineTo(8.0f, 19.8f);
                instancePath2.lineTo(8.0f, 21.0f);
                instancePath2.lineTo(4.0f, 21.0f);
                instancePath2.cubicTo(3.4871643f, 21.0f, 3.064493f, 20.61396f, 3.0067277f, 20.116621f);
                instancePath2.lineTo(3.0f, 20.0f);
                instancePath2.lineTo(3.0f, 16.0f);
                instancePath2.lineTo(4.2f, 16.0f);
                instancePath2.close();
                instancePath2.moveTo(21.0f, 16.0f);
                instancePath2.lineTo(21.0f, 20.0f);
                instancePath2.cubicTo(21.0f, 20.552284f, 20.552284f, 21.0f, 20.0f, 21.0f);
                instancePath2.lineTo(16.0f, 21.0f);
                instancePath2.lineTo(16.0f, 19.8f);
                instancePath2.lineTo(19.8f, 19.8f);
                instancePath2.lineTo(19.8f, 16.0f);
                instancePath2.lineTo(21.0f, 16.0f);
                instancePath2.close();
                instancePath2.moveTo(12.85f, 7.0f);
                instancePath2.lineTo(16.3f, 16.5f);
                instancePath2.lineTo(14.848f, 16.5f);
                instancePath2.lineTo(14.011f, 14.2f);
                instancePath2.lineTo(9.994f, 14.2f);
                instancePath2.lineTo(9.157f, 16.5f);
                instancePath2.lineTo(7.7f, 16.5f);
                instancePath2.lineTo(11.16f, 7.0f);
                instancePath2.lineTo(12.85f, 7.0f);
                instancePath2.close();
                instancePath2.moveTo(12.003f, 8.680677f);
                instancePath2.lineTo(10.43f, 13.0f);
                instancePath2.lineTo(13.574f, 13.0f);
                instancePath2.lineTo(12.003f, 8.680677f);
                instancePath2.close();
                instancePath2.moveTo(8.0f, 3.0f);
                instancePath2.lineTo(8.0f, 4.2f);
                instancePath2.lineTo(4.2f, 4.2f);
                instancePath2.lineTo(4.2f, 8.0f);
                instancePath2.lineTo(3.0f, 8.0f);
                instancePath2.lineTo(3.0f, 4.0f);
                instancePath2.cubicTo(3.0f, 3.4477153f, 3.4477153f, 3.0f, 4.0f, 3.0f);
                instancePath2.lineTo(8.0f, 3.0f);
                instancePath2.close();
                instancePath2.moveTo(20.0f, 3.0f);
                instancePath2.cubicTo(20.512836f, 3.0f, 20.935507f, 3.3860402f, 20.993273f, 3.883379f);
                instancePath2.lineTo(21.0f, 4.0f);
                instancePath2.lineTo(21.0f, 8.0f);
                instancePath2.lineTo(19.8f, 8.0f);
                instancePath2.lineTo(19.8f, 4.2f);
                instancePath2.lineTo(16.0f, 4.2f);
                instancePath2.lineTo(16.0f, 3.0f);
                instancePath2.lineTo(20.0f, 3.0f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint3);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
