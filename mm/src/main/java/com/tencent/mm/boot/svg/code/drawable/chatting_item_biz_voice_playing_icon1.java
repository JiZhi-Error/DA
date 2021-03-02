package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class chatting_item_biz_voice_playing_icon1 extends c {
    private final int height = 44;
    private final int width = 44;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 44;
            case 1:
                return 44;
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
                instancePaint3.setColor(-526345);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(22.0f, 44.0f);
                instancePath.cubicTo(34.150265f, 44.0f, 44.0f, 34.150265f, 44.0f, 22.0f);
                instancePath.cubicTo(44.0f, 9.849735f, 34.150265f, -9.094947E-13f, 22.0f, -9.094947E-13f);
                instancePath.cubicTo(9.849735f, -9.094947E-13f, 0.0f, 9.849735f, 0.0f, 22.0f);
                instancePath.cubicTo(0.0f, 34.150265f, 9.849735f, 44.0f, 22.0f, 44.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-16268960);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(18.200144f, 24.255f);
                instancePath2.cubicTo(18.916761f, 23.537138f, 19.36f, 22.54542f, 19.36f, 21.45f);
                instancePath2.cubicTo(19.36f, 20.35458f, 18.916761f, 19.362862f, 18.200144f, 18.645f);
                instancePath2.lineTo(15.4f, 21.45f);
                instancePath2.lineTo(18.200144f, 24.255f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
