package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class fav_note_toolbar_album extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 6.0f, 0.0f, 1.0f, 10.5f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(56.4f, 32.72654f);
                instancePath.lineTo(56.4f, 5.1f);
                instancePath.lineTo(3.6f, 5.1f);
                instancePath.lineTo(3.6f, 31.776659f);
                instancePath.lineTo(18.597736f, 19.647776f);
                instancePath.cubicTo(19.985397f, 18.525555f, 22.213877f, 18.57998f, 23.551487f, 19.75525f);
                instancePath.lineTo(36.98077f, 31.55468f);
                instancePath.lineTo(43.82731f, 25.732492f);
                instancePath.cubicTo(45.21395f, 24.553312f, 47.42017f, 24.577269f, 48.766293f, 25.785252f);
                instancePath.lineTo(56.4f, 32.72654f);
                instancePath.close();
                instancePath.moveTo(56.399998f, 37.480827f);
                instancePath.lineTo(46.278553f, 28.373676f);
                instancePath.lineTo(39.71393f, 33.956127f);
                instancePath.lineTo(43.74732f, 37.5f);
                instancePath.lineTo(38.433502f, 37.5f);
                instancePath.lineTo(21.01817f, 22.32025f);
                instancePath.lineTo(3.6f, 36.40657f);
                instancePath.lineTo(3.6f, 45.9f);
                instancePath.lineTo(56.4f, 45.9f);
                instancePath.lineTo(56.4f, 37.480827f);
                instancePath.close();
                instancePath.moveTo(2.9754093f, 1.5f);
                instancePath.lineTo(57.02459f, 1.5f);
                instancePath.cubicTo(58.634083f, 1.5f, 60.0f, 2.943411f, 60.0f, 4.723949f);
                instancePath.lineTo(60.0f, 46.27605f);
                instancePath.cubicTo(60.0f, 48.063454f, 58.667866f, 49.5f, 57.02459f, 49.5f);
                instancePath.lineTo(2.9754093f, 49.5f);
                instancePath.cubicTo(1.3659167f, 49.5f, 0.0f, 48.056587f, 0.0f, 46.27605f);
                instancePath.lineTo(0.0f, 4.723949f);
                instancePath.cubicTo(0.0f, 2.9365447f, 1.3321362f, 1.5f, 2.9754093f, 1.5f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
