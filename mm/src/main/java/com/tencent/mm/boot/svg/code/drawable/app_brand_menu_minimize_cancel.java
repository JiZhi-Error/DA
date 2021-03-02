package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class app_brand_menu_minimize_cancel extends c {
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
                instancePaint3.setColor(-436207616);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 6.0f, 0.0f, 1.0f, 6.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(6.393304f, 11.485108f);
                instancePath.lineTo(8.959925f, 14.0515995f);
                instancePath.cubicTo(5.5962305f, 18.482311f, 3.6f, 24.008034f, 3.6f, 30.0f);
                instancePath.cubicTo(3.6f, 44.58032f, 15.4196825f, 56.4f, 30.0f, 56.4f);
                instancePath.cubicTo(35.991966f, 56.4f, 41.51769f, 54.40377f, 45.9484f, 51.040077f);
                instancePath.lineTo(48.514893f, 53.606697f);
                instancePath.cubicTo(43.415726f, 57.611588f, 36.986786f, 60.0f, 30.0f, 60.0f);
                instancePath.cubicTo(13.4314575f, 60.0f, 0.0f, 46.568542f, 0.0f, 30.0f);
                instancePath.cubicTo(0.0f, 23.013216f, 2.388412f, 16.584274f, 6.393304f, 11.485108f);
                instancePath.close();
                instancePath.moveTo(30.0f, 0.0f);
                instancePath.cubicTo(46.568542f, 0.0f, 60.0f, 13.4314575f, 60.0f, 30.0f);
                instancePath.cubicTo(60.0f, 36.987175f, 57.61132f, 43.416447f, 53.60602f, 48.51575f);
                instancePath.lineTo(58.274937f, 53.183765f);
                instancePath.lineTo(55.72935f, 55.72935f);
                instancePath.lineTo(5.545586f, 5.5455847f);
                instancePath.lineTo(8.09117f, 3.0f);
                instancePath.lineTo(11.484251f, 6.3939776f);
                instancePath.cubicTo(16.583553f, 2.3886797f, 23.012823f, 0.0f, 30.0f, 0.0f);
                instancePath.close();
                instancePath.moveTo(14.982403f, 20.073132f);
                instancePath.lineTo(17.59371f, 22.684984f);
                instancePath.cubicTo(16.326931f, 24.828817f, 15.6f, 27.329515f, 15.6f, 30.0f);
                instancePath.cubicTo(15.6f, 37.9529f, 22.0471f, 44.4f, 30.0f, 44.4f);
                instancePath.cubicTo(32.670483f, 44.4f, 35.171185f, 43.67307f, 37.315018f, 42.406292f);
                instancePath.lineTo(39.92687f, 45.017597f);
                instancePath.cubicTo(37.081257f, 46.902374f, 33.66881f, 48.0f, 30.0f, 48.0f);
                instancePath.cubicTo(20.058874f, 48.0f, 12.0f, 39.941124f, 12.0f, 30.0f);
                instancePath.cubicTo(12.0f, 26.33119f, 13.097625f, 22.918743f, 14.982403f, 20.073132f);
                instancePath.close();
                instancePath.moveTo(30.0f, 3.6f);
                instancePath.cubicTo(24.008106f, 3.6f, 18.482447f, 5.596181f, 14.0517645f, 8.9598f);
                instancePath.lineTo(20.073467f, 14.982182f);
                instancePath.cubicTo(22.919012f, 13.097538f, 26.331333f, 12.0f, 30.0f, 12.0f);
                instancePath.cubicTo(39.941124f, 12.0f, 48.0f, 20.058874f, 48.0f, 30.0f);
                instancePath.cubicTo(48.0f, 33.668667f, 46.902462f, 37.08099f, 45.01782f, 39.926533f);
                instancePath.lineTo(51.0402f, 45.948235f);
                instancePath.cubicTo(54.40382f, 41.51755f, 56.4f, 35.991894f, 56.4f, 30.0f);
                instancePath.cubicTo(56.4f, 15.4196825f, 44.58032f, 3.6f, 30.0f, 3.6f);
                instancePath.close();
                instancePath.moveTo(30.0f, 15.6f);
                instancePath.cubicTo(27.329443f, 15.6f, 24.828678f, 16.326971f, 22.684807f, 17.593815f);
                instancePath.lineTo(42.406185f, 37.315193f);
                instancePath.cubicTo(43.67303f, 35.17132f, 44.4f, 32.67056f, 44.4f, 30.0f);
                instancePath.cubicTo(44.4f, 22.0471f, 37.9529f, 15.6f, 30.0f, 15.6f);
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
