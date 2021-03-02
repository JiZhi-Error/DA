package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class scan_success_mark_dot_with_arrow extends c {
    private final int height = 40;
    private final int width = 40;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 40;
            case 1:
                return 40;
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
                Paint instancePaint3 = c.instancePaint(instancePaint2, looper);
                instancePaint3.setStrokeWidth(1.0f);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(-435699360);
                instancePaint5.setColor(-419430401);
                instancePaint5.setStrokeWidth(2.5f);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(20.0f, 1.25f);
                instancePath.cubicTo(30.35534f, 1.25f, 38.75f, 9.64466f, 38.75f, 20.0f);
                instancePath.cubicTo(38.75f, 30.35534f, 30.35534f, 38.75f, 20.0f, 38.75f);
                instancePath.cubicTo(9.64466f, 38.75f, 1.25f, 30.35534f, 1.25f, 20.0f);
                instancePath.cubicTo(1.25f, 9.64466f, 9.64466f, 1.25f, 20.0f, 1.25f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint4);
                canvas.drawPath(instancePath, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint, looper);
                instancePaint6.setColor(-1);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(21.5f, 13.64f);
                instancePath2.lineTo(27.156855f, 19.296854f);
                instancePath2.cubicTo(27.547379f, 19.687378f, 27.547379f, 20.320543f, 27.156855f, 20.711067f);
                instancePath2.lineTo(21.5f, 26.367922f);
                instancePath2.lineTo(19.732233f, 24.600155f);
                instancePath2.lineTo(23.081f, 21.25f);
                instancePath2.lineTo(13.0f, 21.25f);
                instancePath2.lineTo(13.0f, 18.75f);
                instancePath2.lineTo(23.075f, 18.75f);
                instancePath2.lineTo(19.732233f, 15.407767f);
                instancePath2.lineTo(21.5f, 13.64f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint6);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
