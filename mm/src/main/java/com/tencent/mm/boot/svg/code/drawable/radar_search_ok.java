package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class radar_search_ok extends c {
    private final int height = 48;
    private final int width = 48;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 48;
            case 1:
                return 48;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 8.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(40.739872f, 0.951031f);
                instancePath.cubicTo(42.90053f, -1.4607488f, 46.528423f, 1.1793065f, 46.95051f, 3.7101865f);
                instancePath.cubicTo(47.27209f, 5.1890144f, 45.9556f, 6.2311416f, 45.05114f, 7.1938686f);
                instancePath.cubicTo(36.941135f, 15.133884f, 28.891432f, 23.153301f, 20.801529f, 31.113167f);
                instancePath.cubicTo(19.515184f, 32.60192f, 17.123386f, 32.065968f, 16.058132f, 30.616915f);
                instancePath.cubicTo(11.405182f, 25.892607f, 6.5914383f, 21.327097f, 1.9485373f, 16.592863f);
                instancePath.cubicTo(-1.2271264f, 13.724532f, 4.350384f, 8.295546f, 7.24466f, 11.362377f);
                instancePath.cubicTo(11.103695f, 15.084259f, 14.862233f, 18.905392f, 18.701168f, 22.6372f);
                instancePath.cubicTo(26.077553f, 15.44156f, 33.33334f, 8.116896f, 40.739872f, 0.951031f);
                instancePath.lineTo(40.739872f, 0.951031f);
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
