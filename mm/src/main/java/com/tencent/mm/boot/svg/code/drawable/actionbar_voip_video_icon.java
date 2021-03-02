package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class actionbar_voip_video_icon extends c {
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
                instancePaint3.setColor(-1);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 14.0f, 0.0f, 1.0f, 27.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(2.3958402f, 1.5091976f);
                instancePath.cubicTo(3.783774f, 0.71045625f, 5.511202f, 1.1397798f, 7.0389276f, 1.0f);
                instancePath.cubicTo(20.049559f, 1.0898584f, 33.06019f, 0.9301101f, 46.060833f, 1.0698899f);
                instancePath.cubicTo(48.067844f, 0.95007867f, 49.24609f, 3.1366334f, 48.95652f, 4.913833f);
                instancePath.cubicTo(48.93655f, 15.956433f, 49.046387f, 27.009018f, 48.906597f, 38.061604f);
                instancePath.cubicTo(48.97649f, 40.038486f, 46.8896f, 41.276535f, 45.08229f, 40.947056f);
                instancePath.cubicTo(31.3727f, 40.927086f, 17.66311f, 41.026928f, 3.953521f, 40.90712f);
                instancePath.cubicTo(1.9564942f, 41.026928f, 0.73830783f, 38.890297f, 1.047847f, 37.09313f);
                instancePath.cubicTo(1.0079064f, 26.719473f, 1.0678172f, 16.335835f, 1.0178915f, 5.9521966f);
                instancePath.cubicTo(1.0678172f, 4.4046354f, 0.82817405f, 2.4277503f, 2.3958402f, 1.5091976f);
                instancePath.lineTo(2.3958402f, 1.5091976f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(52.01634f, 14.457662f);
                instancePath2.cubicTo(57.03326f, 10.022178f, 61.740986f, 5.203629f, 66.96736f, 1.0f);
                instancePath2.cubicTo(68.35375f, 3.0665324f, 67.924866f, 5.6169353f, 67.97474f, 7.955645f);
                instancePath2.cubicTo(67.94482f, 17.713709f, 67.97474f, 27.471775f, 67.97474f, 37.22984f);
                instancePath2.cubicTo(68.01463f, 38.590725f, 67.675514f, 39.840725f, 66.95739f, 41.0f);
                instancePath2.cubicTo(61.731014f, 36.836693f, 57.08313f, 31.997984f, 52.036285f, 27.612904f);
                instancePath2.cubicTo(51.97644f, 23.227823f, 52.006363f, 18.842741f, 52.01634f, 14.457662f);
                instancePath2.lineTo(52.01634f, 14.457662f);
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
