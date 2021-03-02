package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_mv_making extends c {
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
                instancePath.moveTo(12.0f, 3.5f);
                instancePath.lineTo(12.0f, 6.0f);
                instancePath.cubicTo(12.0f, 6.512836f, 12.38604f, 6.9355073f, 12.883379f, 6.9932723f);
                instancePath.lineTo(13.0f, 7.0f);
                instancePath.lineTo(16.0f, 7.0f);
                instancePath.lineTo(16.0f, 10.0f);
                instancePath.cubicTo(16.0f, 10.5128355f, 16.38604f, 10.935507f, 16.883379f, 10.993272f);
                instancePath.lineTo(17.0f, 11.0f);
                instancePath.lineTo(19.5f, 11.0f);
                instancePath.lineTo(19.5f, 17.5f);
                instancePath.cubicTo(19.5f, 19.156855f, 18.156855f, 20.5f, 16.5f, 20.5f);
                instancePath.lineTo(5.5f, 20.5f);
                instancePath.cubicTo(3.8431458f, 20.5f, 2.5f, 19.156855f, 2.5f, 17.5f);
                instancePath.lineTo(2.5f, 6.5f);
                instancePath.cubicTo(2.5f, 4.843146f, 3.8431458f, 3.5f, 5.5f, 3.5f);
                instancePath.lineTo(12.0f, 3.5f);
                instancePath.close();
                instancePath.moveTo(9.034748f, 9.094733f);
                instancePath.cubicTo(8.784943f, 9.094733f, 8.579478f, 9.284584f, 8.554771f, 9.527872f);
                instancePath.lineTo(8.55228f, 9.577202f);
                instancePath.lineTo(8.55228f, 15.633935f);
                instancePath.cubicTo(8.55228f, 15.717897f, 8.574191f, 15.800406f, 8.615849f, 15.873306f);
                instancePath.cubicTo(8.739236f, 16.089235f, 9.004194f, 16.173649f, 9.227072f, 16.07646f);
                instancePath.lineTo(9.274119f, 16.052835f);
                instancePath.lineTo(14.573762f, 13.024468f);
                instancePath.cubicTo(14.64856f, 12.981727f, 14.710548f, 12.919737f, 14.75329f, 12.844939f);
                instancePath.cubicTo(14.8766775f, 12.629011f, 14.814886f, 12.357883f, 14.618001f, 12.215209f);
                instancePath.lineTo(14.573762f, 12.186668f);
                instancePath.lineTo(9.274119f, 9.158301f);
                instancePath.cubicTo(9.20122f, 9.116645f, 9.1187105f, 9.094733f, 9.034748f, 9.094733f);
                instancePath.close();
                instancePath.moveTo(18.947279f, 0.5f);
                instancePath.cubicTo(19.16529f, 0.5f, 19.342026f, 0.67673415f, 19.342026f, 0.8947468f);
                instancePath.lineTo(19.341894f, 3.6579742f);
                instancePath.lineTo(22.105253f, 3.6579742f);
                instancePath.cubicTo(22.323265f, 3.6579742f, 22.5f, 3.8347085f, 22.5f, 4.052721f);
                instancePath.lineTo(22.5f, 5.3685436f);
                instancePath.cubicTo(22.5f, 5.5865564f, 22.323265f, 5.7632904f, 22.105253f, 5.7632904f);
                instancePath.lineTo(19.341894f, 5.763159f);
                instancePath.lineTo(19.342026f, 8.526518f);
                instancePath.cubicTo(19.342026f, 8.744531f, 19.16529f, 8.921265f, 18.947279f, 8.921265f);
                instancePath.lineTo(17.631456f, 8.921265f);
                instancePath.cubicTo(17.413445f, 8.921265f, 17.23671f, 8.744531f, 17.23671f, 8.526518f);
                instancePath.lineTo(17.236315f, 5.763159f);
                instancePath.lineTo(14.473482f, 5.7632904f);
                instancePath.cubicTo(14.255469f, 5.7632904f, 14.078735f, 5.5865564f, 14.078735f, 5.3685436f);
                instancePath.lineTo(14.078735f, 4.052721f);
                instancePath.cubicTo(14.078735f, 3.8347085f, 14.255469f, 3.6579742f, 14.473482f, 3.6579742f);
                instancePath.lineTo(17.236315f, 3.6579742f);
                instancePath.lineTo(17.23671f, 0.8947468f);
                instancePath.cubicTo(17.23671f, 0.67673415f, 17.413445f, 0.5f, 17.631456f, 0.5f);
                instancePath.lineTo(18.947279f, 0.5f);
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
