package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class album_icon_nor extends c {
    private final int height = 120;
    private final int width = 120;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 120;
            case 1:
                return 120;
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
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 15.0f, 0.0f, 1.0f, 15.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 7.5f, 0.0f, 1.0f, 13.125f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(70.5f, 40.908176f);
                instancePath.lineTo(70.5f, 6.375f);
                instancePath.lineTo(4.5f, 6.375f);
                instancePath.lineTo(4.5f, 39.720825f);
                instancePath.lineTo(23.247171f, 24.55972f);
                instancePath.cubicTo(24.981747f, 23.156944f, 27.767345f, 23.224977f, 29.439358f, 24.694063f);
                instancePath.lineTo(46.22596f, 39.443348f);
                instancePath.lineTo(54.784134f, 32.165615f);
                instancePath.cubicTo(56.51744f, 30.69164f, 59.27521f, 30.721584f, 60.957867f, 32.231564f);
                instancePath.lineTo(70.5f, 40.908176f);
                instancePath.close();
                instancePath.moveTo(70.5f, 46.851036f);
                instancePath.lineTo(57.84819f, 35.467094f);
                instancePath.lineTo(49.64241f, 42.445156f);
                instancePath.lineTo(54.684147f, 46.875f);
                instancePath.lineTo(48.041878f, 46.875f);
                instancePath.lineTo(26.27271f, 27.900312f);
                instancePath.lineTo(4.5f, 45.508213f);
                instancePath.lineTo(4.5f, 57.375f);
                instancePath.lineTo(70.5f, 57.375f);
                instancePath.lineTo(70.5f, 46.851036f);
                instancePath.close();
                instancePath.moveTo(3.7192616f, 1.875f);
                instancePath.lineTo(71.28074f, 1.875f);
                instancePath.cubicTo(73.2926f, 1.875f, 75.0f, 3.6792638f, 75.0f, 5.904936f);
                instancePath.lineTo(75.0f, 57.845062f);
                instancePath.cubicTo(75.0f, 60.07932f, 73.33483f, 61.875f, 71.28074f, 61.875f);
                instancePath.lineTo(3.7192616f, 61.875f);
                instancePath.cubicTo(1.7073959f, 61.875f, 0.0f, 60.070736f, 0.0f, 57.845062f);
                instancePath.lineTo(0.0f, 5.904936f);
                instancePath.cubicTo(0.0f, 3.6706808f, 1.6651702f, 1.875f, 3.7192616f, 1.875f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
