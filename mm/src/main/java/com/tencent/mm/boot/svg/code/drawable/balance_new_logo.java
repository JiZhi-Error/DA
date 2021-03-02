package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class balance_new_logo extends c {
    private final int height = 40;
    private final int width = 40;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 40;
            case 1:
                return 40;
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
                Paint instancePaint3 = c.instancePaint(instancePaint2, looper);
                instancePaint3.setStrokeWidth(1.0f);
                c.instancePaint(instancePaint3, looper).setStrokeWidth(1.0f);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 3.333333f, 0.0f, 1.0f, 3.333333f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-15616);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(16.666666f, 33.333332f);
                instancePath.cubicTo(7.4619207f, 33.333332f, 0.0f, 25.871412f, 0.0f, 16.666666f);
                instancePath.cubicTo(0.0f, 7.4619207f, 7.4619207f, 0.0f, 16.666666f, 0.0f);
                instancePath.cubicTo(25.871412f, 0.0f, 33.333332f, 7.4619207f, 33.333332f, 16.666666f);
                instancePath.cubicTo(33.333332f, 25.871412f, 25.871412f, 33.333332f, 16.666666f, 33.333332f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-1);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(17.333323f, 15.333354f);
                instancePath2.lineTo(20.0f, 10.0f);
                instancePath2.lineTo(22.5f, 10.0f);
                instancePath2.lineTo(19.833323f, 15.333354f);
                instancePath2.lineTo(22.5f, 15.333354f);
                instancePath2.lineTo(22.5f, 17.333353f);
                instancePath2.lineTo(17.666708f, 17.333353f);
                instancePath2.lineTo(17.666708f, 19.166666f);
                instancePath2.lineTo(22.5f, 19.166666f);
                instancePath2.lineTo(22.5f, 21.166666f);
                instancePath2.lineTo(17.666708f, 21.166666f);
                instancePath2.lineTo(17.666708f, 24.166666f);
                instancePath2.lineTo(15.666707f, 24.166666f);
                instancePath2.lineTo(15.666707f, 21.166666f);
                instancePath2.lineTo(10.833333f, 21.166666f);
                instancePath2.lineTo(10.833333f, 19.166666f);
                instancePath2.lineTo(15.666707f, 19.166666f);
                instancePath2.lineTo(15.666707f, 17.333353f);
                instancePath2.lineTo(10.833333f, 17.333353f);
                instancePath2.lineTo(10.833333f, 15.333354f);
                instancePath2.lineTo(13.5000105f, 15.333354f);
                instancePath2.lineTo(10.833333f, 10.0f);
                instancePath2.lineTo(13.333333f, 10.0f);
                instancePath2.lineTo(16.00001f, 15.333354f);
                instancePath2.lineTo(17.333323f, 15.333354f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.restore();
                Paint instancePaint6 = c.instancePaint(instancePaint, looper);
                instancePaint6.setColor(-1);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(0.0f, 0.0f);
                instancePath3.lineTo(40.0f, 0.0f);
                instancePath3.lineTo(40.0f, 40.0f);
                instancePath3.lineTo(0.0f, 40.0f);
                instancePath3.lineTo(0.0f, 0.0f);
                instancePath3.close();
                canvas.saveLayerAlpha(null, 0, 31);
                canvas.drawPath(instancePath3, c.instancePaint(instancePaint6, looper));
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
