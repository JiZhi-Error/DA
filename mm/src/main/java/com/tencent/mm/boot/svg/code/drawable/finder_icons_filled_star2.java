package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class finder_icons_filled_star2 extends c {
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
                c.instanceMatrix(looper);
                c.instanceMatrixArray(looper);
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
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(-352965);
                instancePaint4.setStrokeWidth(1.6f);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(11.935771f, 4.0701456f);
                instancePath.cubicTo(12.127955f, 4.0996704f, 12.159882f, 4.1315956f, 12.179347f, 4.171038f);
                instancePath.lineTo(12.179347f, 4.171038f);
                instancePath.lineTo(14.701567f, 9.281612f);
                instancePath.lineTo(20.341421f, 10.101131f);
                instancePath.cubicTo(20.396074f, 10.109074f, 20.442335f, 10.138416f, 20.472948f, 10.179438f);
                instancePath.cubicTo(20.503561f, 10.220459f, 20.518524f, 10.273158f, 20.510582f, 10.327812f);
                instancePath.cubicTo(20.504257f, 10.37134f, 20.483759f, 10.411569f, 20.452263f, 10.44227f);
                instancePath.lineTo(20.452263f, 10.44227f);
                instancePath.lineTo(16.371227f, 14.420298f);
                instancePath.lineTo(17.33463f, 20.037363f);
                instancePath.cubicTo(17.343964f, 20.091797f, 17.330353f, 20.144861f, 17.3008f, 20.186651f);
                instancePath.cubicTo(17.271246f, 20.228441f, 17.22575f, 20.258957f, 17.171316f, 20.268293f);
                instancePath.cubicTo(17.127964f, 20.275728f, 17.08337f, 20.268665f, 17.04444f, 20.248198f);
                instancePath.lineTo(17.04444f, 20.248198f);
                instancePath.lineTo(12.0f, 17.59618f);
                instancePath.lineTo(6.9555616f, 20.248198f);
                instancePath.cubicTo(6.9066772f, 20.273897f, 6.8520036f, 20.277351f, 6.803126f, 20.262157f);
                instancePath.cubicTo(6.7542486f, 20.246964f, 6.711167f, 20.213123f, 6.685467f, 20.16424f);
                instancePath.cubicTo(6.664999f, 20.125307f, 6.657936f, 20.080713f, 6.6653714f, 20.037363f);
                instancePath.lineTo(6.6653714f, 20.037363f);
                instancePath.lineTo(7.6287737f, 14.420298f);
                instancePath.lineTo(3.5477371f, 10.44227f);
                instancePath.cubicTo(3.5081887f, 10.40372f, 3.48801f, 10.352789f, 3.4873557f, 10.301609f);
                instancePath.cubicTo(3.4867017f, 10.250429f, 3.505572f, 10.198998f, 3.5441222f, 10.159451f);
                instancePath.cubicTo(3.5748239f, 10.127954f, 3.6150525f, 10.107456f, 3.6585798f, 10.101131f);
                instancePath.lineTo(3.6585798f, 10.101131f);
                instancePath.lineTo(9.298433f, 9.281612f);
                instancePath.lineTo(11.820653f, 4.171038f);
                instancePath.cubicTo(11.845095f, 4.121513f, 11.887298f, 4.086583f, 11.935771f, 4.0701456f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
