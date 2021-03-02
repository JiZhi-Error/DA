package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class bottomsheet_icon_create_biz_chat extends c {
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
                instancePaint3.setColor(-8617851);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(81.0f, 60.0f);
                instancePath.lineTo(72.0f, 60.0f);
                instancePath.lineTo(72.0f, 68.0f);
                instancePath.lineTo(64.0f, 68.0f);
                instancePath.lineTo(64.0f, 77.0f);
                instancePath.lineTo(72.0f, 77.0f);
                instancePath.lineTo(72.0f, 85.0f);
                instancePath.lineTo(81.0f, 85.0f);
                instancePath.lineTo(81.0f, 77.0f);
                instancePath.lineTo(89.0f, 77.0f);
                instancePath.lineTo(89.0f, 68.0f);
                instancePath.lineTo(81.0f, 68.0f);
                instancePath.lineTo(81.0f, 60.0f);
                instancePath.close();
                instancePath.moveTo(33.0f, 66.0f);
                instancePath.lineTo(27.0f, 69.0f);
                instancePath.lineTo(28.0f, 64.0f);
                instancePath.cubicTo(20.127745f, 59.652744f, 15.2f, 52.282616f, 15.0f, 44.0f);
                instancePath.cubicTo(15.2f, 30.296667f, 28.315445f, 19.235294f, 48.0f, 19.0f);
                instancePath.cubicTo(67.684555f, 19.235294f, 80.8f, 30.296667f, 81.0f, 44.0f);
                instancePath.cubicTo(80.8f, 46.829475f, 80.203674f, 49.600197f, 79.0f, 52.0f);
                instancePath.lineTo(88.0f, 52.0f);
                instancePath.cubicTo(88.59775f, 49.54438f, 89.0f, 46.78464f, 89.0f, 44.0f);
                instancePath.cubicTo(89.0f, 25.74804f, 72.60592f, 11.0f, 48.0f, 11.0f);
                instancePath.cubicTo(23.394077f, 11.0f, 7.0f, 25.74804f, 7.0f, 44.0f);
                instancePath.cubicTo(7.0f, 53.683987f, 11.725022f, 62.435818f, 20.0f, 68.0f);
                instancePath.lineTo(15.0f, 81.0f);
                instancePath.lineTo(31.0f, 74.0f);
                instancePath.cubicTo(36.047134f, 75.924774f, 41.76071f, 76.882355f, 48.0f, 77.0f);
                instancePath.cubicTo(50.683678f, 76.882355f, 53.264854f, 76.696144f, 56.0f, 76.0f);
                instancePath.lineTo(56.0f, 68.0f);
                instancePath.cubicTo(53.296288f, 68.428825f, 50.71238f, 68.64706f, 48.0f, 69.0f);
                instancePath.cubicTo(42.51602f, 68.64706f, 37.537712f, 67.78236f, 33.0f, 66.0f);
                instancePath.lineTo(33.0f, 66.0f);
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
