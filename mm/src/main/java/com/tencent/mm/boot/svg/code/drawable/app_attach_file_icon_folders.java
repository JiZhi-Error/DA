package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class app_attach_file_icon_folders extends c {
    private final int height = 90;
    private final int width = 90;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 90;
            case 1:
                return 90;
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
                instancePaint3.setColor(-2049700);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(86.25f, 32.25337f);
                instancePath.lineTo(86.25f, 28.75f);
                instancePath.cubicTo(86.25f, 26.678932f, 84.57107f, 25.0f, 82.5f, 25.0f);
                instancePath.lineTo(7.5f, 25.0f);
                instancePath.cubicTo(5.428932f, 25.0f, 3.75f, 26.678932f, 3.75f, 28.75f);
                instancePath.lineTo(3.75f, 32.25337f);
                instancePath.cubicTo(4.8531504f, 31.615229f, 6.133923f, 31.25f, 7.5f, 31.25f);
                instancePath.lineTo(82.5f, 31.25f);
                instancePath.cubicTo(83.86607f, 31.25f, 85.14685f, 31.615229f, 86.25f, 32.25337f);
                instancePath.close();
                instancePath.moveTo(3.75f, 10.0f);
                instancePath.lineTo(29.6967f, 10.0f);
                instancePath.cubicTo(30.691261f, 10.0f, 31.645088f, 10.395088f, 32.34835f, 11.09835f);
                instancePath.lineTo(37.65165f, 16.40165f);
                instancePath.cubicTo(38.35491f, 17.104912f, 39.30874f, 17.5f, 40.303303f, 17.5f);
                instancePath.lineTo(86.25f, 17.5f);
                instancePath.cubicTo(88.32107f, 17.5f, 90.0f, 19.178932f, 90.0f, 21.25f);
                instancePath.lineTo(90.0f, 76.25f);
                instancePath.cubicTo(90.0f, 78.32107f, 88.32107f, 80.0f, 86.25f, 80.0f);
                instancePath.lineTo(3.75f, 80.0f);
                instancePath.cubicTo(1.6789322f, 80.0f, 2.5363266E-16f, 78.32107f, 0.0f, 76.25f);
                instancePath.lineTo(-8.881784E-16f, 13.75f);
                instancePath.cubicTo(-1.1418111E-15f, 11.678932f, 1.6789322f, 10.0f, 3.75f, 10.0f);
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
