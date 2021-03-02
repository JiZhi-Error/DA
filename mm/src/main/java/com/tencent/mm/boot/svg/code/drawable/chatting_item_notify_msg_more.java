package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class chatting_item_notify_msg_more extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint2, looper);
                instancePaint3.setStrokeWidth(1.0f);
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-2565928);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(24.0f, 0.0f);
                instancePath.lineTo(24.0f, 24.0f);
                instancePath.lineTo(0.0f, 24.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.saveLayerAlpha(null, 0, 31);
                canvas.drawPath(instancePath, c.instancePaint(instancePaint4, looper));
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                instancePaint5.setStrokeWidth(1.0f);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 1.5f, 0.0f, 1.0f, 5.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint5, looper);
                instancePaint6.setColor(855638016);
                instancePaint6.setStrokeWidth(0.5f);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(0.25f, 7.0f);
                instancePath2.cubicTo(0.25f, 3.2720778f, 3.2720778f, 0.25f, 7.0f, 0.25f);
                instancePath2.lineTo(14.0f, 0.25f);
                instancePath2.cubicTo(17.727922f, 0.25f, 20.75f, 3.2720778f, 20.75f, 7.0f);
                instancePath2.lineTo(20.75f, 7.0f);
                instancePath2.cubicTo(20.75f, 10.727922f, 17.727922f, 13.75f, 14.0f, 13.75f);
                instancePath2.lineTo(7.0f, 13.75f);
                instancePath2.cubicTo(3.2720778f, 13.75f, 0.25f, 10.727922f, 0.25f, 7.0f);
                instancePath2.lineTo(0.25f, 7.0f);
                instancePath2.close();
                canvas.drawPath(instancePath2, instancePaint6);
                canvas.restore();
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint, looper);
                instancePaint7.setColor(855638016);
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 0.70710677f, -0.70710677f, 7.9091887f, 0.70710677f, 0.70710677f, -5.2091885f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(10.7426405f, 3.9426408f);
                instancePath3.lineTo(10.7426405f, 6.441641f);
                instancePath3.lineTo(13.2426405f, 6.442641f);
                instancePath3.lineTo(13.2426405f, 7.442641f);
                instancePath3.lineTo(10.7426405f, 7.441641f);
                instancePath3.lineTo(10.7426405f, 9.94264f);
                instancePath3.lineTo(9.7426405f, 9.94264f);
                instancePath3.lineTo(9.7426405f, 7.441641f);
                instancePath3.lineTo(7.2426405f, 7.442641f);
                instancePath3.lineTo(7.2426405f, 6.442641f);
                instancePath3.lineTo(9.7426405f, 6.441641f);
                instancePath3.lineTo(9.7426405f, 3.9426408f);
                instancePath3.lineTo(10.7426405f, 3.9426408f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint7);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
