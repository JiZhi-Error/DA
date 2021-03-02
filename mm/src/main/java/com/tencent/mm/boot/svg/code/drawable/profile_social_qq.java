package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class profile_social_qq extends c {
    private final int height = 76;
    private final int width = 76;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 76;
            case 1:
                return 76;
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
                instancePaint3.setColor(-789517);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 4.0f);
                instancePath.cubicTo(0.0f, 1.7908609f, 1.7908609f, 0.0f, 4.0f, 0.0f);
                instancePath.lineTo(72.0f, 0.0f);
                instancePath.cubicTo(74.20914f, 0.0f, 76.0f, 1.7908609f, 76.0f, 4.0f);
                instancePath.lineTo(76.0f, 72.0f);
                instancePath.cubicTo(76.0f, 74.20914f, 74.20914f, 76.0f, 72.0f, 76.0f);
                instancePath.lineTo(4.0f, 76.0f);
                instancePath.cubicTo(1.7908609f, 76.0f, 0.0f, 74.20914f, 0.0f, 72.0f);
                instancePath.lineTo(0.0f, 4.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-5658199);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 13.0f, 0.0f, 1.0f, 12.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(11.583784f, 5.263718f);
                instancePath2.cubicTo(15.113784f, 0.93371826f, 21.073784f, -0.28628173f, 26.403784f, 0.053718258f);
                instancePath2.cubicTo(31.023785f, 0.17371826f, 35.813786f, 1.9637183f, 38.623783f, 5.7737184f);
                instancePath2.cubicTo(42.543785f, 10.853719f, 43.273785f, 17.463718f, 43.843784f, 23.603718f);
                instancePath2.cubicTo(48.673782f, 27.943718f, 51.873783f, 35.12372f, 48.313786f, 41.25372f);
                instancePath2.cubicTo(46.263783f, 40.443718f, 45.183784f, 38.43372f, 43.783783f, 36.87372f);
                instancePath2.cubicTo(42.833782f, 39.27372f, 41.543785f, 41.52372f, 39.793785f, 43.443718f);
                instancePath2.cubicTo(42.843784f, 44.30372f, 47.663784f, 46.923717f, 45.073784f, 50.723717f);
                instancePath2.cubicTo(41.733784f, 53.063717f, 37.273785f, 52.57372f, 33.433784f, 52.193718f);
                instancePath2.cubicTo(30.393784f, 51.993717f, 27.863785f, 50.30372f, 25.473783f, 48.603718f);
                instancePath2.cubicTo(23.133783f, 48.543716f, 21.713783f, 51.02372f, 19.473783f, 51.493717f);
                instancePath2.cubicTo(15.313784f, 52.68372f, 10.753784f, 52.93372f, 6.563784f, 51.73372f);
                instancePath2.cubicTo(4.513784f, 51.353718f, 3.3337839f, 48.82372f, 4.403784f, 47.013718f);
                instancePath2.cubicTo(5.553784f, 44.93372f, 8.053783f, 44.353718f, 10.073784f, 43.473717f);
                instancePath2.cubicTo(8.263783f, 41.53372f, 6.953784f, 39.223717f, 6.013784f, 36.763718f);
                instancePath2.cubicTo(4.7137837f, 38.43372f, 3.5937839f, 40.423717f, 1.5337839f, 41.263718f);
                instancePath2.cubicTo(-2.066216f, 35.11372f, 1.1737839f, 27.883718f, 6.053784f, 23.563719f);
                instancePath2.cubicTo(6.563784f, 17.223719f, 7.323784f, 10.363718f, 11.583784f, 5.263718f);
                instancePath2.lineTo(11.583784f, 5.263718f);
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
