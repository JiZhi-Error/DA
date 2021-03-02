package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class fts_web_video_brightness_icon extends c {
    private final int height = 144;
    private final int width = 144;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 144;
            case 1:
                return 144;
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
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(144.0f, 0.0f);
                instancePath.lineTo(144.0f, 144.0f);
                instancePath.lineTo(0.0f, 144.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.saveLayerAlpha(null, 0, 31);
                canvas.drawPath(instancePath, c.instancePaint(instancePaint3, looper));
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-1);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(72.0f, 102.0f);
                instancePath2.cubicTo(55.431458f, 102.0f, 42.0f, 88.56854f, 42.0f, 72.0f);
                instancePath2.cubicTo(42.0f, 55.431458f, 55.431458f, 42.0f, 72.0f, 42.0f);
                instancePath2.cubicTo(88.56854f, 42.0f, 102.0f, 55.431458f, 102.0f, 72.0f);
                instancePath2.cubicTo(102.0f, 88.56854f, 88.56854f, 102.0f, 72.0f, 102.0f);
                instancePath2.close();
                instancePath2.moveTo(72.0f, 96.0f);
                instancePath2.cubicTo(85.25484f, 96.0f, 96.0f, 85.25484f, 96.0f, 72.0f);
                instancePath2.cubicTo(96.0f, 58.745167f, 85.25484f, 48.0f, 72.0f, 48.0f);
                instancePath2.cubicTo(72.0f, 64.35864f, 72.0f, 82.30664f, 72.0f, 96.0f);
                instancePath2.close();
                instancePath2.moveTo(3.0f, 69.0f);
                instancePath2.lineTo(30.0f, 69.0f);
                instancePath2.lineTo(30.0f, 75.0f);
                instancePath2.lineTo(3.0f, 75.0f);
                instancePath2.lineTo(3.0f, 69.0f);
                instancePath2.close();
                instancePath2.moveTo(69.0f, 3.0f);
                instancePath2.lineTo(75.0f, 3.0f);
                instancePath2.lineTo(75.0f, 30.0f);
                instancePath2.lineTo(69.0f, 30.0f);
                instancePath2.lineTo(69.0f, 3.0f);
                instancePath2.close();
                instancePath2.moveTo(69.0f, 114.0f);
                instancePath2.lineTo(75.0f, 114.0f);
                instancePath2.lineTo(75.0f, 141.0f);
                instancePath2.lineTo(69.0f, 141.0f);
                instancePath2.lineTo(69.0f, 114.0f);
                instancePath2.close();
                instancePath2.moveTo(114.0f, 69.0f);
                instancePath2.lineTo(141.0f, 69.0f);
                instancePath2.lineTo(141.0f, 75.0f);
                instancePath2.lineTo(114.0f, 75.0f);
                instancePath2.lineTo(114.0f, 69.0f);
                instancePath2.close();
                instancePath2.moveTo(25.330952f, 21.088312f);
                instancePath2.lineTo(44.422836f, 40.180195f);
                instancePath2.lineTo(40.180195f, 44.422836f);
                instancePath2.lineTo(21.088312f, 25.330952f);
                instancePath2.lineTo(25.330952f, 21.088312f);
                instancePath2.close();
                instancePath2.moveTo(118.669044f, 21.088312f);
                instancePath2.lineTo(122.91169f, 25.330952f);
                instancePath2.lineTo(103.8198f, 44.422836f);
                instancePath2.lineTo(99.57716f, 40.180195f);
                instancePath2.lineTo(118.669044f, 21.088312f);
                instancePath2.close();
                instancePath2.moveTo(40.180195f, 99.57716f);
                instancePath2.lineTo(44.422836f, 103.8198f);
                instancePath2.lineTo(25.330952f, 122.91169f);
                instancePath2.lineTo(21.088312f, 118.669044f);
                instancePath2.lineTo(40.180195f, 99.57716f);
                instancePath2.close();
                instancePath2.moveTo(103.8198f, 99.57716f);
                instancePath2.lineTo(122.91169f, 118.669044f);
                instancePath2.lineTo(118.669044f, 122.91169f);
                instancePath2.lineTo(99.57716f, 103.8198f);
                instancePath2.lineTo(103.8198f, 99.57716f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
