package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_quote extends c {
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
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-1);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(36.0f, 6.0f);
                instancePath.cubicTo(52.568542f, 6.0f, 66.0f, 19.431458f, 66.0f, 36.0f);
                instancePath.cubicTo(66.0f, 52.568542f, 52.568542f, 66.0f, 36.0f, 66.0f);
                instancePath.cubicTo(19.431458f, 66.0f, 6.0f, 52.568542f, 6.0f, 36.0f);
                instancePath.cubicTo(6.0f, 19.431458f, 19.431458f, 6.0f, 36.0f, 6.0f);
                instancePath.close();
                instancePath.moveTo(30.689013f, 24.0f);
                instancePath.cubicTo(25.153582f, 26.820965f, 22.424442f, 31.386164f, 22.50159f, 37.6956f);
                instancePath.lineTo(22.50159f, 37.6956f);
                instancePath.lineTo(22.50159f, 48.0f);
                instancePath.lineTo(32.805992f, 48.0f);
                instancePath.lineTo(32.805992f, 37.6956f);
                instancePath.lineTo(27.652996f, 37.6956f);
                instancePath.cubicTo(27.652996f, 33.263943f, 29.370663f, 30.041195f, 32.805992f, 28.027359f);
                instancePath.cubicTo(31.394672f, 25.342453f, 30.689013f, 24.0f, 30.689013f, 24.0f);
                instancePath.close();
                instancePath.moveTo(47.36901f, 24.0f);
                instancePath.cubicTo(41.833584f, 26.820965f, 39.104443f, 31.386164f, 39.18159f, 37.6956f);
                instancePath.lineTo(39.18159f, 37.6956f);
                instancePath.lineTo(39.18159f, 48.0f);
                instancePath.lineTo(49.485992f, 48.0f);
                instancePath.lineTo(49.485992f, 37.6956f);
                instancePath.lineTo(44.332996f, 37.6956f);
                instancePath.cubicTo(44.332996f, 33.263943f, 46.050663f, 30.041195f, 49.485992f, 28.027359f);
                instancePath.cubicTo(48.074673f, 25.342453f, 47.36901f, 24.0f, 47.36901f, 24.0f);
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
