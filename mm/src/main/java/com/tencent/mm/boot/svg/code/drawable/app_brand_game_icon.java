package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class app_brand_game_icon extends c {
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
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 2.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 2.364199f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-363518);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(14.047222f, 7.7636366f);
                instancePath.cubicTo(13.317105f, 9.086945f, 11.4021635f, 9.4689f, 9.769939f, 8.616678f);
                instancePath.cubicTo(8.137714f, 7.7644567f, 7.406192f, 6.0006833f, 8.136028f, 4.6771016f);
                instancePath.cubicTo(8.866145f, 3.3537936f, 10.781087f, 2.9718387f, 12.413592f, 3.8243337f);
                instancePath.cubicTo(14.045817f, 4.676555f, 14.77734f, 6.440328f, 14.047222f, 7.7636366f);
                instancePath.moveTo(14.302398f, 2.8900888f);
                instancePath.cubicTo(10.474764f, -0.49419f, 4.921883f, -0.615311f, 1.8999625f, 2.6196856f);
                instancePath.cubicTo(-1.1219579f, 5.854682f, -0.46856207f, 11.220642f, 3.3590727f, 14.604921f);
                instancePath.cubicTo(7.1867075f, 17.989473f, 12.739588f, 18.110868f, 15.761789f, 14.875872f);
                instancePath.cubicTo(18.783428f, 11.640875f, 18.130314f, 6.274641f, 14.302398f, 2.8900888f);
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.restore();
                canvas.save();
                float[] matrixFloatArray3 = c.setMatrixFloatArray(matrixFloatArray2, 1.0f, 0.0f, 15.969142f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray3);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-363518);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(2.0522249f, 0.09713904f);
                instancePath2.cubicTo(3.5456207f, -0.27451873f, 5.1365337f, 0.80649734f, 5.605293f, 2.5118449f);
                instancePath2.cubicTo(6.0740514f, 4.216925f, 5.2430444f, 5.9006147f, 3.7496488f, 6.2722726f);
                instancePath2.cubicTo(2.255972f, 6.6439304f, 0.6653396f, 5.562647f, 0.1965808f, 3.8575668f);
                instancePath2.cubicTo(-0.272178f, 2.1524866f, 0.55854803f, 0.4687968f, 2.0522249f, 0.09713904f);
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
