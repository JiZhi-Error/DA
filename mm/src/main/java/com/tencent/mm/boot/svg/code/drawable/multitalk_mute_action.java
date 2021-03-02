package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.smtt.sdk.WebView;

public class multitalk_mute_action extends c {
    private final int height = 240;
    private final int width = TXLiveConstants.RENDER_ROTATION_180;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return TXLiveConstants.RENDER_ROTATION_180;
            case 1:
                return 240;
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
                instancePaint3.setColor(-1);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 60.0f, 0.0f, 1.0f, 47.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(43.76728f, 70.98263f);
                instancePath.cubicTo(40.498753f, 72.62946f, 36.85723f, 73.66371f, 33.0f, 73.930954f);
                instancePath.lineTo(33.0f, 82.0f);
                instancePath.lineTo(33.0f, 82.0f);
                instancePath.lineTo(47.00086f, 82.0f);
                instancePath.cubicTo(47.55267f, 82.0f, 48.0f, 82.44335f, 48.0f, 83.00937f);
                instancePath.lineTo(48.0f, 84.99063f);
                instancePath.cubicTo(48.0f, 85.54809f, 47.545074f, 86.0f, 47.00086f, 86.0f);
                instancePath.lineTo(14.999142f, 86.0f);
                instancePath.cubicTo(14.447331f, 86.0f, 14.0f, 85.55665f, 14.0f, 84.99063f);
                instancePath.lineTo(14.0f, 83.00937f);
                instancePath.cubicTo(14.0f, 82.45191f, 14.454925f, 82.0f, 14.999142f, 82.0f);
                instancePath.lineTo(29.0f, 82.0f);
                instancePath.lineTo(29.0f, 73.930954f);
                instancePath.lineTo(29.0f, 73.930954f);
                instancePath.cubicTo(14.469449f, 72.92421f, 3.0f, 61.032978f, 3.0f, 46.511883f);
                instancePath.lineTo(3.0f, 41.99816f);
                instancePath.cubicTo(3.0f, 41.45106f, 3.451873f, 41.0f, 4.009287f, 41.0f);
                instancePath.lineTo(5.9903884f, 41.0f);
                instancePath.cubicTo(6.5563583f, 41.0f, 6.9996753f, 41.451767f, 6.9996753f, 42.009052f);
                instancePath.lineTo(6.9996753f, 46.364674f);
                instancePath.cubicTo(6.9996753f, 59.950947f, 18.005663f, 70.0f, 31.0f, 70.0f);
                instancePath.cubicTo(34.46276f, 70.0f, 37.784004f, 69.298294f, 40.793247f, 68.0086f);
                instancePath.lineTo(43.76728f, 70.98263f);
                instancePath.lineTo(43.76728f, 70.98263f);
                instancePath.close();
                instancePath.moveTo(52.101753f, 64.58026f);
                instancePath.cubicTo(56.39767f, 59.748913f, 59.0f, 53.428745f, 59.0f, 46.511883f);
                instancePath.lineTo(59.0f, 41.99816f);
                instancePath.cubicTo(59.0f, 41.44689f, 58.55618f, 41.0f, 57.999897f, 41.0f);
                instancePath.lineTo(55.995884f, 41.0f);
                instancePath.cubicTo(55.443542f, 41.0f, 54.99578f, 41.45739f, 54.99578f, 42.009052f);
                instancePath.lineTo(54.99578f, 46.364674f);
                instancePath.cubicTo(54.99578f, 52.441376f, 52.8483f, 57.762142f, 49.330257f, 61.808765f);
                instancePath.lineTo(52.101753f, 64.58026f);
                instancePath.lineTo(52.101753f, 64.58026f);
                instancePath.close();
                instancePath.moveTo(43.923763f, 56.40227f);
                instancePath.cubicTo(45.858204f, 53.75579f, 47.0f, 50.492767f, 47.0f, 46.962883f);
                instancePath.lineTo(47.0f, 16.976562f);
                instancePath.cubicTo(47.0f, 8.142479f, 39.836555f, 0.9697223f, 31.0f, 0.9697223f);
                instancePath.cubicTo(22.1615f, 0.9697223f, 15.0f, 8.1362295f, 15.0f, 16.976562f);
                instancePath.lineTo(15.0f, 27.478506f);
                instancePath.lineTo(19.0f, 31.478506f);
                instancePath.lineTo(19.0f, 16.970835f);
                instancePath.cubicTo(19.0f, 10.342803f, 24.371126f, 4.9697223f, 31.0f, 4.9697223f);
                instancePath.cubicTo(37.62742f, 4.9697223f, 43.0f, 10.344869f, 43.0f, 16.970835f);
                instancePath.lineTo(43.0f, 46.96861f);
                instancePath.cubicTo(43.0f, 49.389744f, 42.283306f, 51.64342f, 41.050415f, 53.52892f);
                instancePath.lineTo(43.923763f, 56.40227f);
                instancePath.lineTo(43.923763f, 56.40227f);
                instancePath.close();
                instancePath.moveTo(35.197937f, 62.41329f);
                instancePath.cubicTo(33.86017f, 62.776115f, 32.452736f, 62.969723f, 31.0f, 62.969723f);
                instancePath.cubicTo(22.163445f, 62.969723f, 15.0f, 55.796967f, 15.0f, 46.962883f);
                instancePath.lineTo(15.0f, 42.215347f);
                instancePath.lineTo(19.0f, 46.215347f);
                instancePath.lineTo(19.0f, 46.96861f);
                instancePath.cubicTo(19.0f, 53.594574f, 24.372583f, 58.969723f, 31.0f, 58.969723f);
                instancePath.cubicTo(31.245934f, 58.969723f, 31.490135f, 58.962326f, 31.732397f, 58.947746f);
                instancePath.lineTo(35.197937f, 62.41329f);
                instancePath.lineTo(35.197937f, 62.41329f);
                instancePath.close();
                instancePath.moveTo(57.00684f, 79.44923f);
                instancePath.lineTo(0.16473381f, 22.60712f);
                instancePath.lineTo(2.993161f, 19.778692f);
                instancePath.lineTo(59.835266f, 76.6208f);
                instancePath.lineTo(57.00684f, 79.44923f);
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
