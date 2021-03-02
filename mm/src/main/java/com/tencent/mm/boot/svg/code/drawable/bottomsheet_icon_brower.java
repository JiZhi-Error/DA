package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class bottomsheet_icon_brower extends c {
    private final int height = 96;
    private final int width = 96;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                instancePaint3.setColor(-8683387);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(68.0f, 68.0f);
                instancePath.lineTo(68.0f, 73.0f);
                instancePath.cubicTo(62.75382f, 77.365776f, 55.755802f, 80.0f, 48.0f, 80.0f);
                instancePath.cubicTo(43.030067f, 80.0f, 38.205288f, 78.816f, 34.0f, 77.0f);
                instancePath.lineTo(48.0f, 52.0f);
                instancePath.lineTo(44.0f, 48.0f);
                instancePath.lineTo(36.0f, 48.0f);
                instancePath.lineTo(28.0f, 40.0f);
                instancePath.lineTo(44.0f, 24.0f);
                instancePath.lineTo(38.0f, 18.0f);
                instancePath.cubicTo(40.952587f, 16.616444f, 44.470387f, 16.0f, 48.0f, 16.0f);
                instancePath.cubicTo(52.40803f, 16.0f, 56.485584f, 16.82889f, 60.0f, 18.0f);
                instancePath.lineTo(60.0f, 24.0f);
                instancePath.lineTo(64.0f, 28.0f);
                instancePath.lineTo(73.0f, 28.0f);
                instancePath.cubicTo(75.21601f, 30.406666f, 76.81651f, 33.097332f, 78.0f, 36.0f);
                instancePath.lineTo(64.0f, 36.0f);
                instancePath.lineTo(56.0f, 44.0f);
                instancePath.lineTo(56.0f, 56.0f);
                instancePath.lineTo(68.0f, 68.0f);
                instancePath.close();
                instancePath.moveTo(24.0f, 69.0f);
                instancePath.cubicTo(19.024445f, 63.343204f, 16.0f, 55.91894f, 16.0f, 48.0f);
                instancePath.cubicTo(16.0f, 46.501648f, 16.08311f, 45.241016f, 16.0f, 44.0f);
                instancePath.lineTo(24.0f, 52.0f);
                instancePath.lineTo(24.0f, 69.0f);
                instancePath.close();
                instancePath.moveTo(48.0f, 8.0f);
                instancePath.cubicTo(25.908443f, 8.0f, 8.0f, 25.908443f, 8.0f, 48.0f);
                instancePath.cubicTo(8.0f, 70.09155f, 25.908443f, 88.0f, 48.0f, 88.0f);
                instancePath.cubicTo(70.09155f, 88.0f, 88.0f, 70.09155f, 88.0f, 48.0f);
                instancePath.cubicTo(88.0f, 25.908443f, 70.09155f, 8.0f, 48.0f, 8.0f);
                instancePath.lineTo(48.0f, 8.0f);
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
