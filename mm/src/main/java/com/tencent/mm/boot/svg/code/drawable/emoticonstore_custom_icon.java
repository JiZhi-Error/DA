package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class emoticonstore_custom_icon extends c {
    private final int height = 72;
    private final int width = 72;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 72;
            case 1:
                return 72;
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
                instancePaint3.setColor(-436207616);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 9.0f, 0.0f, 1.0f, 15.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(48.853916f, 22.935286f);
                instancePath.cubicTo(53.186268f, 18.470255f, 53.135693f, 11.344611f, 48.730064f, 6.9389825f);
                instancePath.cubicTo(44.278088f, 2.4870057f, 37.06001f, 2.4870057f, 32.60803f, 6.9389825f);
                instancePath.cubicTo(32.031235f, 7.515777f, 31.29962f, 8.221499f, 30.409842f, 9.059835f);
                instancePath.lineTo(27.941126f, 11.385826f);
                instancePath.lineTo(25.47241f, 9.059835f);
                instancePath.cubicTo(24.582632f, 8.221499f, 23.851015f, 7.515777f, 23.274221f, 6.9389825f);
                instancePath.cubicTo(18.822245f, 2.4870057f, 11.604163f, 2.4870057f, 7.152186f, 6.9389825f);
                instancePath.cubicTo(2.7466114f, 11.344558f, 2.6957495f, 18.470612f, 6.989021f, 22.897852f);
                instancePath.lineTo(27.940998f, 43.850048f);
                instancePath.lineTo(48.853916f, 22.935286f);
                instancePath.close();
                instancePath.moveTo(4.6066017f, 4.3933983f);
                instancePath.cubicTo(10.464466f, -1.4644661f, 19.96194f, -1.4644661f, 25.819805f, 4.3933983f);
                instancePath.cubicTo(26.368225f, 4.941818f, 27.075333f, 5.623898f, 27.941126f, 6.4396367f);
                instancePath.cubicTo(28.80692f, 5.623898f, 29.514027f, 4.941818f, 30.062447f, 4.3933983f);
                instancePath.cubicTo(35.92031f, -1.4644661f, 45.417786f, -1.4644661f, 51.27565f, 4.3933983f);
                instancePath.cubicTo(57.079025f, 10.196773f, 57.133007f, 19.572361f, 51.4376f, 25.442194f);
                instancePath.lineTo(30.062447f, 46.819805f);
                instancePath.cubicTo(28.890934f, 47.99144f, 26.99144f, 47.99154f, 25.819805f, 46.820026f);
                instancePath.lineTo(4.4434233f, 25.443422f);
                instancePath.cubicTo(-1.2507558f, 19.572361f, -1.1967729f, 10.196773f, 4.6066017f, 4.3933983f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
