package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class finder_live_icon_comment_forbidden extends c {
    private final int height = 12;
    private final int width = 12;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 12;
            case 1:
                return 12;
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
                instancePaint3.setColor(-372399);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(2.0659256f, 3.235363f);
                instancePath.lineTo(8.412821f, 9.90645f);
                instancePath.cubicTo(7.6974225f, 10.259275f, 6.8749566f, 10.460069f, 6.0f, 10.460069f);
                instancePath.cubicTo(5.576631f, 10.460069f, 5.165552f, 10.413056f, 4.7729464f, 10.324555f);
                instancePath.lineTo(4.386727f, 10.222429f);
                instancePath.lineTo(2.8952506f, 10.974167f);
                instancePath.cubicTo(2.8526764f, 10.9956255f, 2.8051913f, 11.003973f, 2.7582915f, 10.998242f);
                instancePath.cubicTo(2.6554308f, 10.985675f, 2.5744462f, 10.909156f, 2.5471084f, 10.810864f);
                instancePath.lineTo(2.5388296f, 10.706879f);
                instancePath.lineTo(2.6898782f, 9.341013f);
                instancePath.cubicTo(1.653499f, 8.522507f, 1.0f, 7.3258452f, 1.0f, 5.992814f);
                instancePath.cubicTo(1.0f, 4.9522276f, 1.3982178f, 3.99474f, 2.0659256f, 3.235363f);
                instancePath.close();
                instancePath.moveTo(2.0606601f, 1.0f);
                instancePath.lineTo(3.2574f, 2.2569728f);
                instancePath.cubicTo(4.044855f, 1.7945688f, 4.987266f, 1.5255594f, 6.0f, 1.5255594f);
                instancePath.cubicTo(8.761424f, 1.5255594f, 11.0f, 3.5256174f, 11.0f, 5.992814f);
                instancePath.cubicTo(11.0f, 7.156989f, 10.501574f, 8.2171545f, 9.6849785f, 9.012259f);
                instancePath.lineTo(10.545941f, 9.919039f);
                instancePath.lineTo(10.015612f, 10.476479f);
                instancePath.lineTo(1.5303301f, 1.5574399f);
                instancePath.lineTo(2.0606601f, 1.0f);
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
