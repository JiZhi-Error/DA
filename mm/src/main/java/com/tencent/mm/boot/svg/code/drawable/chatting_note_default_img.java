package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.k.r;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class chatting_note_default_img extends c {
    private final int height = r.CTRL_INDEX;
    private final int width = r.CTRL_INDEX;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return r.CTRL_INDEX;
            case 1:
                return r.CTRL_INDEX;
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
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-921103);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(136.0f, 0.0f);
                instancePath.lineTo(136.0f, 136.0f);
                instancePath.lineTo(0.0f, 136.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 34.0f, 0.0f, 1.0f, 42.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                instancePaint5.setColor(-3552823);
                instancePaint5.setStrokeWidth(3.0f);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(1.5f, 6.0f);
                instancePath2.cubicTo(1.5f, 3.5147185f, 3.5147185f, 1.5f, 6.0f, 1.5f);
                instancePath2.lineTo(63.0f, 1.5f);
                instancePath2.cubicTo(65.48528f, 1.5f, 67.5f, 3.5147185f, 67.5f, 6.0f);
                instancePath2.lineTo(67.5f, 47.0f);
                instancePath2.cubicTo(67.5f, 49.485283f, 65.48528f, 51.5f, 63.0f, 51.5f);
                instancePath2.lineTo(6.0f, 51.5f);
                instancePath2.cubicTo(3.5147185f, 51.5f, 1.5f, 49.485283f, 1.5f, 47.0f);
                instancePath2.lineTo(1.5f, 6.0f);
                instancePath2.close();
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint, looper);
                instancePaint6.setColor(-3552823);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(2.0f, 40.47622f);
                instancePath3.lineTo(23.9226f, 20.0f);
                instancePath3.lineTo(48.016544f, 43.06765f);
                instancePath3.lineTo(44.84195f, 35.311966f);
                instancePath3.lineTo(54.734417f, 27.538553f);
                instancePath3.lineTo(68.0f, 40.47622f);
                instancePath3.lineTo(68.0f, 50.245495f);
                instancePath3.lineTo(2.0f, 50.245495f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 1);
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint6);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
