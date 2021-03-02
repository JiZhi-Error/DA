package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class finder_filled_fav extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-2565928);
                canvas.saveLayerAlpha(null, 0, 31);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(72.0f, 0.0f);
                instancePath.lineTo(72.0f, 72.0f);
                instancePath.lineTo(0.0f, 72.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(WebView.NIGHT_MODE_COLOR);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(57.57f, 19.5f);
                instancePath2.cubicTo(58.912052f, 19.5f, 60.0f, 20.587948f, 60.0f, 21.93f);
                instancePath2.lineTo(60.0f, 60.57f);
                instancePath2.cubicTo(60.0f, 61.912052f, 58.912052f, 63.0f, 57.57f, 63.0f);
                instancePath2.lineTo(14.43f, 63.0f);
                instancePath2.cubicTo(13.087948f, 63.0f, 12.0f, 61.912052f, 12.0f, 60.57f);
                instancePath2.lineTo(12.0f, 21.93f);
                instancePath2.cubicTo(12.0f, 20.587948f, 13.087948f, 19.5f, 14.43f, 19.5f);
                instancePath2.lineTo(57.57f, 19.5f);
                instancePath2.close();
                instancePath2.moveTo(36.64146f, 27.156868f);
                instancePath2.cubicTo(35.923527f, 26.786366f, 35.054295f, 27.094593f, 34.69997f, 27.845312f);
                instancePath2.lineTo(34.69997f, 27.845312f);
                instancePath2.lineTo(31.313517f, 35.020367f);
                instancePath2.lineTo(23.741177f, 36.170937f);
                instancePath2.cubicTo(23.425682f, 36.218876f, 23.1341f, 36.37423f, 22.91157f, 36.612946f);
                instancePath2.cubicTo(22.352736f, 37.212433f, 22.364468f, 38.172123f, 22.937773f, 38.756477f);
                instancePath2.lineTo(22.937773f, 38.756477f);
                instancePath2.lineTo(28.41717f, 44.341476f);
                instancePath2.lineTo(27.12366f, 52.227623f);
                instancePath2.cubicTo(27.069767f, 52.55619f, 27.12096f, 52.89417f, 27.269314f, 53.189243f);
                instancePath2.cubicTo(27.641869f, 53.93025f, 28.518354f, 54.21514f, 29.226997f, 53.825573f);
                instancePath2.lineTo(29.226997f, 53.825573f);
                instancePath2.lineTo(35.999905f, 50.102238f);
                instancePath2.lineTo(42.772816f, 53.825573f);
                instancePath2.cubicTo(43.055f, 53.9807f, 43.37822f, 54.034233f, 43.69244f, 53.97788f);
                instancePath2.cubicTo(44.481525f, 53.836357f, 45.01149f, 53.052742f, 44.876152f, 52.227623f);
                instancePath2.lineTo(44.876152f, 52.227623f);
                instancePath2.lineTo(43.58264f, 44.341476f);
                instancePath2.lineTo(49.06204f, 38.756477f);
                instancePath2.cubicTo(49.290333f, 38.523785f, 49.4389f, 38.218887f, 49.484745f, 37.888985f);
                instancePath2.cubicTo(49.599873f, 37.060516f, 49.050922f, 36.29132f, 48.258636f, 36.170937f);
                instancePath2.lineTo(48.258636f, 36.170937f);
                instancePath2.lineTo(40.686295f, 35.020367f);
                instancePath2.lineTo(37.29984f, 27.845312f);
                instancePath2.cubicTo(37.15875f, 27.546371f, 36.92735f, 27.304405f, 36.64146f, 27.156868f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint, looper);
                instancePaint6.setColor(WebView.NIGHT_MODE_COLOR);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(16.5f, 11.958f);
                instancePath3.cubicTo(16.5f, 11.152769f, 17.15277f, 10.5f, 17.958f, 10.5f);
                instancePath3.lineTo(54.042f, 10.5f);
                instancePath3.cubicTo(54.847233f, 10.5f, 55.5f, 11.152769f, 55.5f, 11.958f);
                instancePath3.lineTo(55.5f, 12.642f);
                instancePath3.cubicTo(55.5f, 13.447231f, 54.847233f, 14.1f, 54.042f, 14.1f);
                instancePath3.lineTo(17.958f, 14.1f);
                instancePath3.cubicTo(17.15277f, 14.1f, 16.5f, 13.447231f, 16.5f, 12.642f);
                instancePath3.lineTo(16.5f, 11.958f);
                instancePath3.close();
                canvas.drawPath(instancePath3, instancePaint6);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
