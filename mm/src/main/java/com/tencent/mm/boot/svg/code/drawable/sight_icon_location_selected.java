package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class sight_icon_location_selected extends c {
    private final int height = 60;
    private final int width = 60;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 60;
            case 1:
                return 60;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 13.0f, 0.0f, 1.0f, 7.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(1.0f, 22.0f);
                instancePath.cubicTo(-2.8734941f, 12.371129f, 4.898239f, 1.1049721f, 15.0f, 0.0f);
                instancePath.cubicTo(23.440092f, -1.1542573f, 32.25474f, 5.2435603f, 34.0f, 14.0f);
                instancePath.cubicTo(34.841976f, 18.579012f, 32.585667f, 23.21743f, 30.0f, 27.0f);
                instancePath.cubicTo(26.478588f, 33.613884f, 21.885744f, 39.461887f, 17.0f, 45.0f);
                instancePath.cubicTo(10.874953f, 37.892426f, 4.7478185f, 30.494947f, 1.0f, 22.0f);
                instancePath.lineTo(1.0f, 22.0f);
                instancePath.close();
                instancePath.moveTo(13.0f, 7.0f);
                instancePath.cubicTo(6.5172105f, 9.0244465f, 4.703988f, 19.022913f, 10.0f, 24.0f);
                instancePath.cubicTo(15.73359f, 28.731422f, 25.8115f, 25.191965f, 27.0f, 18.0f);
                instancePath.cubicTo(28.446182f, 10.514218f, 20.211548f, 3.7152615f, 13.0f, 7.0f);
                instancePath.lineTo(13.0f, 7.0f);
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
