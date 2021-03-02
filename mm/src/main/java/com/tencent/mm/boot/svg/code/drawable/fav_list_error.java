package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class fav_list_error extends c {
    private final int height = 66;
    private final int width = 66;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 66;
            case 1:
                return 66;
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
                instancePaint3.setColor(-564640);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 3.0f, 0.0f, 1.0f, 3.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(57.0f, 30.37037f);
                instancePath.cubicTo(57.0f, 15.087965f, 44.912033f, 3.0f, 29.62963f, 3.0f);
                instancePath.cubicTo(14.985957f, 3.0f, 3.0f, 15.1921425f, 3.0f, 30.37037f);
                instancePath.cubicTo(3.0f, 44.912033f, 15.087965f, 57.0f, 29.62963f, 57.0f);
                instancePath.cubicTo(44.807858f, 57.0f, 57.0f, 45.01404f, 57.0f, 30.37037f);
                instancePath.close();
                instancePath.moveTo(60.0f, 30.37037f);
                instancePath.cubicTo(60.0f, 46.56889f, 46.56889f, 60.0f, 29.62963f, 60.0f);
                instancePath.cubicTo(13.431111f, 60.0f, 0.0f, 46.56889f, 0.0f, 30.37037f);
                instancePath.cubicTo(0.0f, 13.431111f, 13.431111f, 0.0f, 29.62963f, 0.0f);
                instancePath.cubicTo(46.56889f, 0.0f, 60.0f, 13.431111f, 60.0f, 30.37037f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(30.0f, 45.0f);
                instancePath2.cubicTo(31.656855f, 45.0f, 33.0f, 43.656853f, 33.0f, 42.0f);
                instancePath2.cubicTo(33.0f, 40.343147f, 31.656855f, 39.0f, 30.0f, 39.0f);
                instancePath2.cubicTo(28.343145f, 39.0f, 27.0f, 40.343147f, 27.0f, 42.0f);
                instancePath2.cubicTo(27.0f, 43.656853f, 28.343145f, 45.0f, 30.0f, 45.0f);
                instancePath2.close();
                instancePath2.moveTo(28.498575f, 15.0f);
                instancePath2.cubicTo(27.670935f, 15.0f, 27.032139f, 15.674923f, 27.071115f, 16.493433f);
                instancePath2.lineTo(28.0f, 36.0f);
                instancePath2.lineTo(32.0f, 36.0f);
                instancePath2.lineTo(32.928883f, 16.493433f);
                instancePath2.cubicTo(32.96816f, 15.6686325f, 32.33497f, 15.0f, 31.501425f, 15.0f);
                instancePath2.lineTo(28.498575f, 15.0f);
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
