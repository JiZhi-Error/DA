package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class finder_filled_activity extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-16268960);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 0.89879405f, -0.43837115f, 6.7182755f, 0.43837115f, 0.89879405f, -2.8844147f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(8.847653f, 21.693031f);
                instancePath.lineTo(1.6535866f, 6.839659f);
                instancePath.cubicTo(1.5393606f, 6.5933547f, 1.6374756f, 6.3007708f, 1.8771449f, 6.1729965f);
                instancePath.cubicTo(1.900391f, 6.1420126f, 1.9298693f, 6.116235f, 1.9636836f, 6.097321f);
                instancePath.cubicTo(2.677745f, 5.5880694f, 3.4674206f, 5.19408f, 4.303834f, 4.92976f);
                instancePath.cubicTo(5.1528125f, 4.660108f, 6.0348926f, 4.508536f, 6.9252353f, 4.4793124f);
                instancePath.lineTo(7.2858133f, 4.4793124f);
                instancePath.cubicTo(8.293078f, 4.481297f, 9.294437f, 4.63311f, 10.256975f, 4.92976f);
                instancePath.cubicTo(11.380366f, 5.3256264f, 12.554385f, 5.5598016f, 13.743763f, 5.625252f);
                instancePath.cubicTo(14.93367f, 5.625252f, 15.456508f, 5.1712003f, 16.116365f, 4.594627f);
                instancePath.lineTo(16.27502f, 4.4576907f);
                instancePath.cubicTo(16.440296f, 4.3022056f, 16.657457f, 4.213596f, 16.884396f, 4.2090435f);
                instancePath.cubicTo(17.011053f, 4.209268f, 17.135416f, 4.242826f, 17.244974f, 4.30634f);
                instancePath.cubicTo(17.638004f, 4.540573f, 17.627188f, 5.0270567f, 17.587523f, 5.354983f);
                instancePath.cubicTo(17.52369f, 5.7695546f, 17.41363f, 6.1756835f, 17.259398f, 6.5657873f);
                instancePath.cubicTo(16.820477f, 7.741183f, 16.139988f, 8.811624f, 15.261796f, 9.708112f);
                instancePath.cubicTo(14.769872f, 10.205898f, 14.190518f, 10.609f, 13.552657f, 10.897294f);
                instancePath.lineTo(13.43006f, 10.947744f);
                instancePath.cubicTo(12.888613f, 11.168726f, 12.309384f, 11.282542f, 11.724527f, 11.282878f);
                instancePath.lineTo(11.345921f, 11.282878f);
                instancePath.cubicTo(10.963708f, 11.250445f, 10.599524f, 11.236032f, 10.264187f, 11.236032f);
                instancePath.cubicTo(7.3795633f, 11.236032f, 6.7161f, 12.389178f, 6.1319637f, 13.398181f);
                instancePath.lineTo(6.1031175f, 13.452235f);
                instancePath.lineTo(9.889724f, 21.267807f);
                instancePath.cubicTo(9.94452f, 21.393011f, 9.94452f, 21.535395f, 9.889724f, 21.660599f);
                instancePath.cubicTo(9.8332815f, 21.802046f, 9.72116f, 21.914099f, 9.579626f, 21.970507f);
                instancePath.cubicTo(9.512542f, 21.99458f, 9.44177f, 22.006773f, 9.370491f, 22.006588f);
                instancePath.cubicTo(9.150907f, 22.00928f, 8.948571f, 21.88795f, 8.847653f, 21.693031f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
