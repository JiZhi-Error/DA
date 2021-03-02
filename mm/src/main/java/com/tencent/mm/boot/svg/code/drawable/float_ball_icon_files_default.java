package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class float_ball_icon_files_default extends c {
    private final int height = 48;
    private final int width = 48;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 48;
            case 1:
                return 48;
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
                instancePaint3.setColor(-855310);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(48.0f, 0.0f);
                instancePath.lineTo(48.0f, 48.0f);
                instancePath.lineTo(0.0f, 48.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-436207616);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(25.6f, 15.298995f);
                instancePath2.lineTo(25.6f, 20.0f);
                instancePath2.cubicTo(25.6f, 20.220915f, 25.779085f, 20.4f, 26.0f, 20.4f);
                instancePath2.lineTo(30.702787f, 20.4f);
                instancePath2.lineTo(25.6f, 15.298995f);
                instancePath2.close();
                instancePath2.moveTo(17.995808f, 14.0f);
                instancePath2.lineTo(25.997904f, 14.0f);
                instancePath2.lineTo(32.0f, 20.0f);
                instancePath2.lineTo(32.0f, 33.001354f);
                instancePath2.cubicTo(32.0f, 33.55423f, 31.554161f, 34.0f, 31.004192f, 34.0f);
                instancePath2.lineTo(17.995808f, 34.0f);
                instancePath2.cubicTo(17.44892f, 34.0f, 17.0f, 33.55289f, 17.0f, 33.001354f);
                instancePath2.lineTo(17.0f, 14.998646f);
                instancePath2.cubicTo(17.0f, 14.44577f, 17.445839f, 14.0f, 17.995808f, 14.0f);
                instancePath2.close();
                instancePath2.moveTo(24.6945f, 23.448f);
                instancePath2.cubicTo(24.034496f, 23.448f, 23.515501f, 23.639997f, 23.1375f, 24.024f);
                instancePath2.cubicTo(22.753498f, 24.402002f, 22.5615f, 24.917997f, 22.5615f, 25.572f);
                instancePath2.lineTo(23.5155f, 25.572f);
                instancePath2.cubicTo(23.5155f, 25.169998f, 23.596498f, 24.861002f, 23.7585f, 24.645f);
                instancePath2.cubicTo(23.938501f, 24.393f, 24.232498f, 24.267f, 24.6405f, 24.267f);
                instancePath2.cubicTo(24.964502f, 24.267f, 25.2165f, 24.356998f, 25.3965f, 24.537f);
                instancePath2.cubicTo(25.570501f, 24.723001f, 25.6575f, 24.968998f, 25.6575f, 25.275f);
                instancePath2.cubicTo(25.6575f, 25.503f, 25.5765f, 25.721998f, 25.4145f, 25.932f);
                instancePath2.lineTo(25.2615f, 26.103f);
                instancePath2.cubicTo(24.703497f, 26.601002f, 24.3615f, 26.973f, 24.2355f, 27.219f);
                instancePath2.cubicTo(24.1215f, 27.447f, 24.0645f, 27.731998f, 24.0645f, 28.074f);
                instancePath2.lineTo(24.0645f, 28.227f);
                instancePath2.lineTo(25.0275f, 28.227f);
                instancePath2.lineTo(25.0275f, 28.074f);
                instancePath2.cubicTo(25.0275f, 27.845999f, 25.075499f, 27.645f, 25.1715f, 27.471f);
                instancePath2.cubicTo(25.2495f, 27.314999f, 25.3725f, 27.162f, 25.5405f, 27.012f);
                instancePath2.cubicTo(25.960503f, 26.651999f, 26.2155f, 26.418001f, 26.3055f, 26.31f);
                instancePath2.cubicTo(26.5275f, 26.015999f, 26.6385f, 25.650002f, 26.6385f, 25.212f);
                instancePath2.cubicTo(26.6385f, 24.671997f, 26.461502f, 24.243002f, 26.1075f, 23.925f);
                instancePath2.cubicTo(25.753498f, 23.606998f, 25.282503f, 23.448f, 24.6945f, 23.448f);
                instancePath2.close();
                instancePath2.moveTo(24.5415f, 28.713f);
                instancePath2.cubicTo(24.349499f, 28.713f, 24.1965f, 28.772999f, 24.0825f, 28.893f);
                instancePath2.cubicTo(23.950499f, 29.007f, 23.8845f, 29.16f, 23.8845f, 29.352f);
                instancePath2.cubicTo(23.8845f, 29.532001f, 23.950499f, 29.685f, 24.0825f, 29.811f);
                instancePath2.cubicTo(24.202501f, 29.937f, 24.3555f, 30.0f, 24.5415f, 30.0f);
                instancePath2.cubicTo(24.7215f, 30.0f, 24.880499f, 29.94f, 25.0185f, 29.82f);
                instancePath2.cubicTo(25.1445f, 29.694f, 25.2075f, 29.538f, 25.2075f, 29.352f);
                instancePath2.cubicTo(25.2075f, 29.16f, 25.1445f, 29.007f, 25.0185f, 28.893f);
                instancePath2.cubicTo(24.898499f, 28.772999f, 24.739502f, 28.713f, 24.5415f, 28.713f);
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
