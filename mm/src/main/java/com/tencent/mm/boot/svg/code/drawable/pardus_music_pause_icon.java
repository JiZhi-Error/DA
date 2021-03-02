package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class pardus_music_pause_icon extends c {
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
                Matrix instanceMatrix = c.instanceMatrix(looper);
                float[] instanceMatrixArray = c.instanceMatrixArray(looper);
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-420614675);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(11.0f, 22.0f);
                instancePath.cubicTo(17.075132f, 22.0f, 22.0f, 17.075132f, 22.0f, 11.0f);
                instancePath.cubicTo(22.0f, 4.9248676f, 17.075132f, 0.0f, 11.0f, 0.0f);
                instancePath.cubicTo(4.9248676f, 0.0f, 0.0f, 4.9248676f, 0.0f, 11.0f);
                instancePath.cubicTo(0.0f, 17.075132f, 4.9248676f, 22.0f, 11.0f, 22.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-436207616);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(7.7f, 7.65f);
                instancePath2.cubicTo(7.7f, 7.3738575f, 7.923857f, 7.15f, 8.2f, 7.15f);
                instancePath2.lineTo(9.4f, 7.15f);
                instancePath2.cubicTo(9.676142f, 7.15f, 9.9f, 7.3738575f, 9.9f, 7.65f);
                instancePath2.lineTo(9.9f, 14.9f);
                instancePath2.cubicTo(9.9f, 15.176142f, 9.676142f, 15.4f, 9.4f, 15.4f);
                instancePath2.lineTo(8.2f, 15.4f);
                instancePath2.cubicTo(7.923857f, 15.4f, 7.7f, 15.176142f, 7.7f, 14.9f);
                instancePath2.lineTo(7.7f, 7.65f);
                instancePath2.close();
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-436207616);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(12.65f, 7.65f);
                instancePath3.cubicTo(12.65f, 7.3738575f, 12.8738575f, 7.15f, 13.15f, 7.15f);
                instancePath3.lineTo(14.349999f, 7.15f);
                instancePath3.cubicTo(14.626142f, 7.15f, 14.849999f, 7.3738575f, 14.849999f, 7.65f);
                instancePath3.lineTo(14.849999f, 14.9f);
                instancePath3.cubicTo(14.849999f, 15.176142f, 14.626142f, 15.4f, 14.349999f, 15.4f);
                instancePath3.lineTo(13.15f, 15.4f);
                instancePath3.cubicTo(12.8738575f, 15.4f, 12.65f, 15.176142f, 12.65f, 14.9f);
                instancePath3.lineTo(12.65f, 7.65f);
                instancePath3.close();
                canvas.drawPath(instancePath3, instancePaint5);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}