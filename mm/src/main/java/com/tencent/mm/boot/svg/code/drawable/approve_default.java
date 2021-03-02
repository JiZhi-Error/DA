package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class approve_default extends c {
    private final int height = 16;
    private final int width = 15;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 15;
            case 1:
                return 16;
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
                instancePaint3.setColor(-11048043);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(7.624182f, 0.028621675f);
                instancePath.cubicTo(8.509319f, 0.16048354f, 9.499581f, 1.0177877f, 9.499581f, 2.6104255f);
                instancePath.cubicTo(9.499581f, 3.7757175f, 9.310068f, 4.4710493f, 9.25998f, 5.0160246f);
                instancePath.lineTo(9.250553f, 5.149321f);
                instancePath.lineTo(13.112538f, 5.149321f);
                instancePath.cubicTo(13.726087f, 5.149321f, 14.986115f, 5.921881f, 14.769511f, 7.332844f);
                instancePath.cubicTo(14.381703f, 9.8590355f, 13.046923f, 12.510862f, 12.854087f, 12.918297f);
                instancePath.cubicTo(12.250458f, 14.193681f, 11.325146f, 15.007201f, 10.553953f, 15.093657f);
                instancePath.lineTo(10.419558f, 15.101312f);
                instancePath.lineTo(1.116654f, 15.101312f);
                instancePath.cubicTo(0.5391967f, 15.101312f, 0.059571058f, 14.221435f, 0.005142627f, 13.623581f);
                instancePath.lineTo(-9.40581E-13f, 13.515072f);
                instancePath.lineTo(-9.40581E-13f, 6.9973793f);
                instancePath.cubicTo(-9.40581E-13f, 6.2707405f, 0.56460977f, 5.710601f, 1.141133f, 5.643422f);
                instancePath.lineTo(1.2564327f, 5.636656f);
                instancePath.lineTo(1.9645185f, 5.636656f);
                instancePath.cubicTo(1.9645185f, 5.636656f, 3.9314516f, 5.946601f, 4.789839f, 4.5230713f);
                instancePath.cubicTo(5.600806f, 3.1786008f, 5.620325f, 2.1474245f, 5.620325f, 1.1710285f);
                instancePath.cubicTo(5.620325f, 0.19463253f, 6.757516f, -0.10048854f, 7.624182f, 0.028621675f);
                instancePath.close();
                instancePath.moveTo(1.899f, 6.636f);
                instancePath.lineTo(1.2564327f, 6.636656f);
                instancePath.cubicTo(1.1778595f, 6.636656f, 1.0455837f, 6.760737f, 1.0093942f, 6.9169946f);
                instancePath.lineTo(1.0f, 6.9973793f);
                instancePath.lineTo(1.0f, 13.515072f);
                instancePath.cubicTo(1.0f, 13.594543f, 1.0444738f, 13.7487545f, 1.1163504f, 13.893395f);
                instancePath.lineTo(1.21186f, 14.0602255f);
                instancePath.cubicTo(1.2222108f, 14.082277f, 1.2189361f, 14.092658f, 1.1948184f, 14.097434f);
                instancePath.lineTo(1.116654f, 14.101312f);
                instancePath.lineTo(2.165f, 14.101f);
                instancePath.lineTo(2.165f, 6.657f);
                instancePath.lineTo(1.899f, 6.636f);
                instancePath.close();
                instancePath.moveTo(6.7134013f, 1.0945573f);
                instancePath.lineTo(6.639641f, 1.13001f);
                instancePath.cubicTo(6.6263256f, 1.1380619f, 6.622179f, 1.1441379f, 6.6208944f, 1.1536076f);
                instancePath.lineTo(6.620325f, 1.1710285f);
                instancePath.cubicTo(6.620325f, 2.7782068f, 6.4356127f, 3.7307136f, 5.6461964f, 5.0394545f);
                instancePath.cubicTo(5.236177f, 5.719421f, 4.6288266f, 6.173112f, 3.9033165f, 6.4265094f);
                instancePath.cubicTo(3.6571493f, 6.5124874f, 3.4100466f, 6.5725145f, 3.1659217f, 6.6110797f);
                instancePath.lineTo(3.165f, 14.101f);
                instancePath.lineTo(10.419558f, 14.101312f);
                instancePath.cubicTo(10.758117f, 14.101312f, 11.391585f, 13.563651f, 11.859066f, 12.673232f);
                instancePath.lineTo(12.089263f, 12.200935f);
                instancePath.lineTo(12.314814f, 11.716462f);
                instancePath.cubicTo(12.525711f, 11.251521f, 12.7282505f, 10.770104f, 12.917935f, 10.27029f);
                instancePath.cubicTo(13.279127f, 9.31856f, 13.555872f, 8.3986435f, 13.717819f, 7.54822f);
                instancePath.cubicTo(13.741516f, 7.423784f, 13.762628f, 7.3013754f, 13.781091f, 7.1811066f);
                instancePath.cubicTo(13.859824f, 6.668235f, 13.4574995f, 6.2181873f, 13.175264f, 6.156512f);
                instancePath.lineTo(13.112538f, 6.149321f);
                instancePath.lineTo(8.202398f, 6.149321f);
                instancePath.lineTo(8.251658f, 5.1023245f);
                instancePath.lineTo(8.270743f, 4.8576593f);
                instancePath.lineTo(8.384776f, 4.0697064f);
                instancePath.cubicTo(8.461953f, 3.5538096f, 8.499581f, 3.1305816f, 8.499581f, 2.6104255f);
                instancePath.cubicTo(8.499581f, 1.6717453f, 8.02231f, 1.0989679f, 7.476835f, 1.0177065f);
                instancePath.cubicTo(7.2003856f, 0.9765229f, 6.9002132f, 1.0090612f, 6.7134013f, 1.0945573f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
