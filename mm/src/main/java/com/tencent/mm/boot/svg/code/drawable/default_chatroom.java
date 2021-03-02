package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class default_chatroom extends c {
    private final int height = 120;
    private final int width = 120;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 120;
            case 1:
                return 120;
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-16268960);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 12.0f);
                instancePath.cubicTo(0.0f, 5.3725824f, 5.3725824f, 0.0f, 12.0f, 0.0f);
                instancePath.lineTo(108.0f, 0.0f);
                instancePath.cubicTo(114.62742f, 0.0f, 120.0f, 5.3725824f, 120.0f, 12.0f);
                instancePath.lineTo(120.0f, 108.0f);
                instancePath.cubicTo(120.0f, 114.62742f, 114.62742f, 120.0f, 108.0f, 120.0f);
                instancePath.lineTo(12.0f, 120.0f);
                instancePath.cubicTo(5.3725824f, 120.0f, 0.0f, 114.62742f, 0.0f, 108.0f);
                instancePath.lineTo(0.0f, 12.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-1);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 24.0f, 0.0f, 1.0f, 24.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(44.260315f, 12.026479f);
                instancePath2.cubicTo(44.50461f, 12.008928f, 44.75127f, 12.0f, 45.0f, 12.0f);
                instancePath2.cubicTo(50.580982f, 12.0f, 55.105263f, 16.48245f, 55.105263f, 22.000519f);
                instancePath2.lineTo(55.105263f, 26.275465f);
                instancePath2.cubicTo(55.105263f, 29.12324f, 53.591827f, 33.20715f, 51.74043f, 35.378933f);
                instancePath2.lineTo(50.827084f, 36.450333f);
                instancePath2.cubicTo(49.337765f, 38.197376f, 49.803f, 40.420994f, 51.885597f, 41.426277f);
                instancePath2.lineTo(66.18544f, 48.328896f);
                instancePath2.cubicTo(67.739876f, 49.07923f, 69.0f, 51.062923f, 69.0f, 52.78866f);
                instancePath2.lineTo(69.0f, 54.503906f);
                instancePath2.cubicTo(69.0f, 55.88246f, 67.86082f, 57.0f, 66.47007f, 57.0f);
                instancePath2.lineTo(63.54414f, 57.0f);
                instancePath2.cubicTo(63.17732f, 53.856773f, 61.040966f, 50.727318f, 58.235985f, 49.359085f);
                instancePath2.lineTo(41.254925f, 41.075943f);
                instancePath2.cubicTo(40.895622f, 40.900677f, 40.910355f, 40.971035f, 41.171318f, 40.66169f);
                instancePath2.lineTo(42.255917f, 39.37601f);
                instancePath2.cubicTo(45.004707f, 36.1176f, 47.1f, 30.393791f, 47.1f, 26.130558f);
                instancePath2.lineTo(47.1f, 21.000622f);
                instancePath2.cubicTo(47.1f, 17.660835f, 46.04925f, 14.565118f, 44.260315f, 12.026479f);
                instancePath2.close();
                instancePath2.moveTo(23.495739f, 37.050415f);
                instancePath2.cubicTo(21.288954f, 34.434856f, 19.5f, 29.548489f, 19.5f, 26.127872f);
                instancePath2.lineTo(19.5f, 20.998741f);
                instancePath2.cubicTo(19.5f, 14.37202f, 24.886068f, 9.0f, 31.5f, 9.0f);
                instancePath2.cubicTo(38.12742f, 9.0f, 43.5f, 14.378941f, 43.5f, 21.000622f);
                instancePath2.lineTo(43.5f, 26.130558f);
                instancePath2.cubicTo(43.5f, 29.547888f, 41.702797f, 34.44858f, 39.50426f, 37.054718f);
                instancePath2.lineTo(38.419662f, 38.340397f);
                instancePath2.cubicTo(36.651096f, 40.43685f, 37.203564f, 43.105194f, 39.676647f, 44.31153f);
                instancePath2.lineTo(56.657707f, 52.594673f);
                instancePath2.cubicTo(58.503605f, 53.49508f, 60.0f, 55.87551f, 60.0f, 57.94639f);
                instancePath2.lineTo(60.0f, 60.004684f);
                instancePath2.cubicTo(60.0f, 61.65895f, 58.647224f, 63.0f, 56.995712f, 63.0f);
                instancePath2.lineTo(6.0042887f, 63.0f);
                instancePath2.cubicTo(4.345066f, 63.0f, 3.0f, 61.667267f, 3.0f, 60.004684f);
                instancePath2.lineTo(3.0f, 57.94639f);
                instancePath2.cubicTo(3.0f, 55.891125f, 4.494453f, 53.495724f, 6.342293f, 52.593998f);
                instancePath2.lineTo(23.323353f, 44.30743f);
                instancePath2.cubicTo(25.78613f, 43.10562f, 26.358778f, 40.443787f, 24.580336f, 38.33592f);
                instancePath2.lineTo(23.495739f, 37.050415f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
