package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_gift extends c {
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
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(11.3f, 11.157f);
                instancePath.lineTo(11.3f, 21.0f);
                instancePath.lineTo(5.0f, 21.0f);
                instancePath.cubicTo(3.8954306f, 21.0f, 3.0f, 20.10457f, 3.0f, 19.0f);
                instancePath.lineTo(3.0f, 11.157f);
                instancePath.lineTo(11.3f, 11.157f);
                instancePath.close();
                instancePath.moveTo(12.7f, 11.157f);
                instancePath.lineTo(21.0f, 11.157f);
                instancePath.lineTo(21.0f, 19.0f);
                instancePath.cubicTo(21.0f, 20.10457f, 20.10457f, 21.0f, 19.0f, 21.0f);
                instancePath.lineTo(12.7f, 21.0f);
                instancePath.lineTo(12.7f, 11.157f);
                instancePath.close();
                instancePath.moveTo(22.0f, 10.2f);
                instancePath.lineTo(2.0f, 10.2f);
                instancePath.lineTo(2.0f, 6.672269f);
                instancePath.cubicTo(2.0f, 6.119984f, 2.4477153f, 5.672269f, 3.0f, 5.672269f);
                instancePath.lineTo(5.564f, 5.672f);
                instancePath.lineTo(5.5537076f, 5.617042f);
                instancePath.cubicTo(5.3697305f, 4.5297284f, 5.788728f, 3.381781f, 6.7559443f, 2.658424f);
                instancePath.cubicTo(7.3525f, 2.2121634f, 8.096389f, 1.979001f, 8.851833f, 2.001487f);
                instancePath.cubicTo(9.751155f, 2.028149f, 10.588825f, 2.4070837f, 11.180673f, 3.0485508f);
                instancePath.lineTo(11.312805f, 3.2012012f);
                instancePath.lineTo(11.999639f, 4.0477123f);
                instancePath.lineTo(12.686833f, 3.2012012f);
                instancePath.cubicTo(13.282306f, 2.4674659f, 14.179306f, 2.0301998f, 15.148167f, 2.001487f);
                instancePath.cubicTo(15.90325f, 1.979001f, 16.647139f, 2.2121634f, 17.243694f, 2.658424f);
                instancePath.cubicTo(18.21057f, 3.381781f, 18.629871f, 4.5297284f, 18.445929f, 5.617042f);
                instancePath.lineTo(18.434f, 5.672f);
                instancePath.lineTo(21.0f, 5.672269f);
                instancePath.cubicTo(21.552284f, 5.672269f, 22.0f, 6.119984f, 22.0f, 6.672269f);
                instancePath.lineTo(22.0f, 10.2f);
                instancePath.close();
                instancePath.moveTo(8.784667f, 4.078501f);
                instancePath.cubicTo(8.541278f, 4.0715823f, 8.293555f, 4.1428456f, 8.086278f, 4.29748f);
                instancePath.cubicTo(7.648353f, 4.625133f, 7.5445247f, 5.211696f, 7.8262563f, 5.656383f);
                instancePath.lineTo(7.838f, 5.672f);
                instancePath.lineTo(10.574f, 5.672f);
                instancePath.lineTo(9.605473f, 4.478406f);
                instancePath.cubicTo(9.399639f, 4.224833f, 9.095222f, 4.0878415f, 8.784667f, 4.078501f);
                instancePath.close();
                instancePath.moveTo(15.214611f, 4.078501f);
                instancePath.cubicTo(14.94873f, 4.086507f, 14.687094f, 4.1882977f, 14.488146f, 4.3769016f);
                instancePath.lineTo(14.394167f, 4.478406f);
                instancePath.lineTo(13.425f, 5.672f);
                instancePath.lineTo(16.161f, 5.672f);
                instancePath.lineTo(16.173378f, 5.656383f);
                instancePath.cubicTo(16.455065f, 5.211696f, 16.350925f, 4.625133f, 15.913f, 4.29748f);
                instancePath.cubicTo(15.706083f, 4.1428456f, 15.458361f, 4.0715823f, 15.214611f, 4.078501f);
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
