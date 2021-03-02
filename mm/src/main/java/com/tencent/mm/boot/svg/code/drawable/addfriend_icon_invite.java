package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class addfriend_icon_invite extends c {
    private final int height = 108;
    private final int width = 108;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 108;
            case 1:
                return 108;
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
                instancePaint3.setColor(-14187817);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(108.07031f, 0.0f);
                instancePath.lineTo(108.07031f, 108.07031f);
                instancePath.lineTo(0.0f, 108.07031f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-1);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(17.448853f, 35.66546f);
                instancePath2.lineTo(17.448853f, 75.79919f);
                instancePath2.cubicTo(17.448853f, 77.45719f, 18.7972f, 78.80127f, 20.453722f, 78.80127f);
                instancePath2.lineTo(87.61659f, 78.80127f);
                instancePath2.cubicTo(89.27613f, 78.80127f, 90.62146f, 77.452194f, 90.62146f, 75.79919f);
                instancePath2.lineTo(90.62146f, 35.66546f);
                instancePath2.lineTo(58.135864f, 60.45544f);
                instancePath2.cubicTo(55.81595f, 62.361008f, 52.25586f, 62.362236f, 49.93445f, 60.45544f);
                instancePath2.lineTo(17.448853f, 35.66546f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-1);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(19.689577f, 29.269043f);
                instancePath3.cubicTo(18.03435f, 29.269043f, 17.749979f, 30.091743f, 19.05684f, 31.10848f);
                instancePath3.lineTo(51.671455f, 56.482616f);
                instancePath3.cubicTo(52.977234f, 57.49851f, 55.09323f, 57.49935f, 56.400093f, 56.482616f);
                instancePath3.lineTo(89.01471f, 31.10848f);
                instancePath3.cubicTo(90.32048f, 30.092587f, 90.03502f, 29.269043f, 88.38197f, 29.269043f);
                instancePath3.lineTo(19.689577f, 29.269043f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint, looper);
                instancePaint6.setColor(-14187817);
                Path instancePath4 = c.instancePath(looper);
                instancePath4.moveTo(0.0f, 0.0f);
                instancePath4.lineTo(108.07031f, 0.0f);
                instancePath4.lineTo(108.07031f, 108.07031f);
                instancePath4.lineTo(0.0f, 108.07031f);
                instancePath4.lineTo(0.0f, 0.0f);
                instancePath4.close();
                canvas.drawPath(instancePath4, instancePaint6);
                canvas.restore();
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint, looper);
                instancePaint7.setColor(-1);
                Path instancePath5 = c.instancePath(looper);
                instancePath5.moveTo(17.448853f, 35.66546f);
                instancePath5.lineTo(17.448853f, 75.79919f);
                instancePath5.cubicTo(17.448853f, 77.45719f, 18.7972f, 78.80127f, 20.453722f, 78.80127f);
                instancePath5.lineTo(87.61659f, 78.80127f);
                instancePath5.cubicTo(89.27613f, 78.80127f, 90.62146f, 77.452194f, 90.62146f, 75.79919f);
                instancePath5.lineTo(90.62146f, 35.66546f);
                instancePath5.lineTo(58.135864f, 60.45544f);
                instancePath5.cubicTo(55.81595f, 62.361008f, 52.25586f, 62.362236f, 49.93445f, 60.45544f);
                instancePath5.lineTo(17.448853f, 35.66546f);
                instancePath5.lineTo(17.448853f, 35.66546f);
                instancePath5.close();
                WeChatSVGRenderC2Java.setFillType(instancePath5, 2);
                canvas.drawPath(instancePath5, instancePaint7);
                canvas.restore();
                canvas.save();
                Paint instancePaint8 = c.instancePaint(instancePaint, looper);
                instancePaint8.setColor(-1);
                Path instancePath6 = c.instancePath(looper);
                instancePath6.moveTo(19.689577f, 29.269043f);
                instancePath6.cubicTo(18.03435f, 29.269043f, 17.749979f, 30.091743f, 19.05684f, 31.10848f);
                instancePath6.lineTo(51.671455f, 56.482616f);
                instancePath6.cubicTo(52.977234f, 57.49851f, 55.09323f, 57.49935f, 56.400093f, 56.482616f);
                instancePath6.lineTo(89.01471f, 31.10848f);
                instancePath6.cubicTo(90.32048f, 30.092587f, 90.03502f, 29.269043f, 88.38197f, 29.269043f);
                instancePath6.lineTo(19.689577f, 29.269043f);
                instancePath6.lineTo(19.689577f, 29.269043f);
                instancePath6.close();
                WeChatSVGRenderC2Java.setFillType(instancePath6, 2);
                canvas.drawPath(instancePath6, instancePaint8);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
