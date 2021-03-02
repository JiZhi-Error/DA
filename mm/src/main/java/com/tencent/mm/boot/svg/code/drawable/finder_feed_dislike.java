package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class finder_feed_dislike extends c {
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
                c.instancePaint(instancePaint2, looper).setStrokeWidth(1.0f);
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-436207616);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 3.0f, 0.0f, 1.0f, 3.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(1.6540151f, 3.351f);
                instancePath.lineTo(2.503048f, 4.198969f);
                instancePath.cubicTo(2.4627702f, 4.2359505f, 2.4230971f, 4.273959f, 2.384062f, 4.312994f);
                instancePath.cubicTo(0.9155371f, 5.781519f, 0.8985832f, 8.156871f, 2.3296735f, 9.632617f);
                instancePath.lineTo(9.313666f, 16.616682f);
                instancePath.lineTo(12.116015f, 13.813f);
                instancePath.lineTo(12.964015f, 14.661f);
                instancePath.lineTo(10.020815f, 17.606602f);
                instancePath.cubicTo(9.630311f, 17.997147f, 8.997147f, 17.997179f, 8.606602f, 17.606676f);
                instancePath.lineTo(1.4811411f, 10.481141f);
                instancePath.cubicTo(-0.4169186f, 8.52412f, -0.3989243f, 5.3989244f, 1.5355339f, 3.464466f);
                instancePath.lineTo(1.6540151f, 3.351f);
                instancePath.close();
                instancePath.moveTo(1.6970569f, 0.0f);
                instancePath.lineTo(3.849036f, 2.1508493f);
                instancePath.cubicTo(5.498065f, 1.73694f, 7.316948f, 2.1748123f, 8.606602f, 3.464466f);
                instancePath.cubicTo(8.789409f, 3.6472728f, 9.02511f, 3.8746326f, 9.313708f, 4.1465454f);
                instancePath.cubicTo(9.602306f, 3.8746326f, 9.838009f, 3.6472728f, 10.020815f, 3.464466f);
                instancePath.cubicTo(11.973436f, 1.5118446f, 15.139261f, 1.5118446f, 17.091883f, 3.464466f);
                instancePath.cubicTo(19.02634f, 5.3989244f, 19.044336f, 8.52412f, 17.145866f, 10.480731f);
                instancePath.lineTo(14.6610155f, 12.964f);
                instancePath.lineTo(18.424978f, 16.727922f);
                instancePath.lineTo(17.57645f, 17.57645f);
                instancePath.lineTo(0.8485287f, 0.84852815f);
                instancePath.lineTo(1.6970569f, 0.0f);
                instancePath.close();
                instancePath.moveTo(4.9007835f, 3.2037935f);
                instancePath.lineTo(13.813015f, 12.116f);
                instancePath.lineTo(16.28464f, 9.645095f);
                instancePath.cubicTo(17.728756f, 8.156752f, 17.711899f, 5.781537f, 16.243355f, 4.312994f);
                instancePath.cubicTo(14.759362f, 2.829002f, 12.353335f, 2.829002f, 10.869344f, 4.312994f);
                instancePath.cubicTo(10.677078f, 4.505259f, 10.433207f, 4.7405f, 10.136614f, 5.019945f);
                instancePath.lineTo(9.313708f, 5.795275f);
                instancePath.lineTo(8.490803f, 5.019945f);
                instancePath.cubicTo(8.194211f, 4.7405f, 7.9503384f, 4.505259f, 7.758074f, 4.312994f);
                instancePath.cubicTo(6.9727583f, 3.527679f, 5.9292336f, 3.1579454f, 4.9007835f, 3.2037935f);
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
