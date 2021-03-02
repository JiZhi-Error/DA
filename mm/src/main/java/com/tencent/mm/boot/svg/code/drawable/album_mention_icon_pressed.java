package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class album_mention_icon_pressed extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-15028967);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(11.488281f, 9.3671875f);
                instancePath.cubicTo(10.421875f, 9.3671875f, 9.777344f, 10.28125f, 9.777344f, 11.8046875f);
                instancePath.cubicTo(9.777344f, 13.328125f, 10.410156f, 14.2421875f, 11.488281f, 14.2421875f);
                instancePath.cubicTo(12.566406f, 14.2421875f, 13.2109375f, 13.316406f, 13.2109375f, 11.8046875f);
                instancePath.cubicTo(13.2109375f, 10.292969f, 12.5546875f, 9.3671875f, 11.488281f, 9.3671875f);
                instancePath.close();
                instancePath.moveTo(11.8515625f, 1.9375f);
                instancePath.cubicTo(17.464844f, 1.9375f, 21.34375f, 5.4414062f, 21.34375f, 10.6796875f);
                instancePath.cubicTo(21.34375f, 14.347656f, 19.550781f, 16.65625f, 16.632812f, 16.65625f);
                instancePath.cubicTo(15.121094f, 16.65625f, 14.03125f, 16.011719f, 13.714844f, 14.886719f);
                instancePath.lineTo(13.515625f, 14.886719f);
                instancePath.cubicTo(13.035156f, 16.058594f, 12.109375f, 16.667969f, 10.761719f, 16.667969f);
                instancePath.cubicTo(8.324219f, 16.667969f, 6.7070312f, 14.699219f, 6.7070312f, 11.722656f);
                instancePath.cubicTo(6.7070312f, 8.875f, 8.265625f, 6.953125f, 10.574219f, 6.953125f);
                instancePath.cubicTo(11.8515625f, 6.953125f, 12.871094f, 7.5742188f, 13.339844f, 8.6171875f);
                instancePath.lineTo(13.5390625f, 8.6171875f);
                instancePath.lineTo(13.5390625f, 7.234375f);
                instancePath.lineTo(16.222656f, 7.234375f);
                instancePath.lineTo(16.222656f, 13.1875f);
                instancePath.cubicTo(16.222656f, 14.0078125f, 16.585938f, 14.511719f, 17.242188f, 14.511719f);
                instancePath.cubicTo(18.261719f, 14.511719f, 18.929688f, 13.175781f, 18.929688f, 10.9609375f);
                instancePath.cubicTo(18.929688f, 6.7070312f, 16.128906f, 4.0f, 11.816406f, 4.0f);
                instancePath.cubicTo(7.328125f, 4.0f, 4.234375f, 7.1523438f, 4.234375f, 11.769531f);
                instancePath.cubicTo(4.234375f, 16.503906f, 7.4101562f, 19.351562f, 12.296875f, 19.351562f);
                instancePath.cubicTo(13.386719f, 19.351562f, 14.5f, 19.210938f, 15.109375f, 19.023438f);
                instancePath.lineTo(15.109375f, 21.109375f);
                instancePath.cubicTo(14.265625f, 21.332031f, 13.175781f, 21.460938f, 12.050781f, 21.460938f);
                instancePath.cubicTo(5.9921875f, 21.460938f, 1.8203125f, 17.640625f, 1.8203125f, 11.7109375f);
                instancePath.cubicTo(1.8203125f, 5.921875f, 5.9335938f, 1.9375f, 11.8515625f, 1.9375f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
