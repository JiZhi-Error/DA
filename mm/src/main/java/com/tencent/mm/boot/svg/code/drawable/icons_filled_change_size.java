package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_change_size extends c {
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
                instancePaint3.setColor(-1);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(5.0f, 4.5f);
                instancePath.cubicTo(4.7238574f, 4.5f, 4.5f, 4.7238574f, 4.5f, 5.0f);
                instancePath.lineTo(4.5f, 8.75f);
                instancePath.lineTo(3.0f, 8.75f);
                instancePath.lineTo(3.0f, 4.0f);
                instancePath.cubicTo(3.0f, 3.4477153f, 3.4477153f, 3.0f, 4.0f, 3.0f);
                instancePath.lineTo(8.75f, 3.0f);
                instancePath.lineTo(8.75f, 4.5f);
                instancePath.lineTo(5.0f, 4.5f);
                instancePath.close();
                instancePath.moveTo(5.0f, 19.5f);
                instancePath.lineTo(8.75f, 19.5f);
                instancePath.lineTo(8.75f, 21.0f);
                instancePath.lineTo(4.0f, 21.0f);
                instancePath.cubicTo(3.4477153f, 21.0f, 3.0f, 20.552284f, 3.0f, 20.0f);
                instancePath.lineTo(3.0f, 15.25f);
                instancePath.lineTo(4.5f, 15.25f);
                instancePath.lineTo(4.5f, 19.0f);
                instancePath.cubicTo(4.5f, 19.276142f, 4.7238574f, 19.5f, 5.0f, 19.5f);
                instancePath.close();
                instancePath.moveTo(19.0f, 4.5f);
                instancePath.lineTo(15.25f, 4.5f);
                instancePath.lineTo(15.25f, 3.0f);
                instancePath.lineTo(20.0f, 3.0f);
                instancePath.cubicTo(20.552284f, 3.0f, 21.0f, 3.4477153f, 21.0f, 4.0f);
                instancePath.lineTo(21.0f, 8.75f);
                instancePath.lineTo(19.5f, 8.75f);
                instancePath.lineTo(19.5f, 5.0f);
                instancePath.cubicTo(19.5f, 4.7238574f, 19.276142f, 4.5f, 19.0f, 4.5f);
                instancePath.close();
                instancePath.moveTo(19.0f, 19.5f);
                instancePath.cubicTo(19.276142f, 19.5f, 19.5f, 19.276142f, 19.5f, 19.0f);
                instancePath.lineTo(19.5f, 15.25f);
                instancePath.lineTo(21.0f, 15.25f);
                instancePath.lineTo(21.0f, 20.0f);
                instancePath.cubicTo(21.0f, 20.552284f, 20.552284f, 21.0f, 20.0f, 21.0f);
                instancePath.lineTo(15.25f, 21.0f);
                instancePath.lineTo(15.25f, 19.5f);
                instancePath.lineTo(19.0f, 19.5f);
                instancePath.close();
                instancePath.moveTo(8.0f, 7.0f);
                instancePath.lineTo(16.0f, 7.0f);
                instancePath.cubicTo(16.552284f, 7.0f, 17.0f, 7.4477153f, 17.0f, 8.0f);
                instancePath.lineTo(17.0f, 16.0f);
                instancePath.cubicTo(17.0f, 16.552284f, 16.552284f, 17.0f, 16.0f, 17.0f);
                instancePath.lineTo(8.0f, 17.0f);
                instancePath.cubicTo(7.4477153f, 17.0f, 7.0f, 16.552284f, 7.0f, 16.0f);
                instancePath.lineTo(7.0f, 8.0f);
                instancePath.cubicTo(7.0f, 7.4477153f, 7.4477153f, 7.0f, 8.0f, 7.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
