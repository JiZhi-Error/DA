package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class finder_outlined_self_like extends c {
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
                c.instancePaint(instancePaint2, looper).setStrokeWidth(1.0f);
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-436207616);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(59.312603f, 16.393398f);
                instancePath.cubicTo(63.0088f, 20.089596f, 64.37277f, 25.234852f, 63.404514f, 30.000513f);
                instancePath.lineTo(59.706318f, 30.0008f);
                instancePath.cubicTo(60.74369f, 26.183155f, 59.76101f, 21.932972f, 56.76702f, 18.938982f);
                instancePath.cubicTo(52.315044f, 14.487006f, 45.096962f, 14.487006f, 40.644985f, 18.938982f);
                instancePath.cubicTo(40.06819f, 19.515778f, 39.336575f, 20.221498f, 38.446796f, 21.059835f);
                instancePath.lineTo(35.97808f, 23.385826f);
                instancePath.lineTo(33.509365f, 21.059835f);
                instancePath.cubicTo(32.619587f, 20.221498f, 31.88797f, 19.515778f, 31.311176f, 18.938982f);
                instancePath.cubicTo(26.859198f, 14.487006f, 19.641117f, 14.487006f, 15.189141f, 18.938982f);
                instancePath.cubicTo(10.783566f, 23.344557f, 10.732704f, 30.470612f, 15.025975f, 34.897854f);
                instancePath.lineTo(35.97795f, 55.850048f);
                instancePath.lineTo(36.0f, 55.827f);
                instancePath.lineTo(36.000156f, 59.698513f);
                instancePath.cubicTo(35.225063f, 59.704212f, 34.44818f, 59.411385f, 33.85676f, 58.820026f);
                instancePath.lineTo(12.480378f, 37.443424f);
                instancePath.cubicTo(6.786199f, 31.572361f, 6.840182f, 22.196774f, 12.643557f, 16.393398f);
                instancePath.cubicTo(18.501421f, 10.535534f, 27.998896f, 10.535534f, 33.85676f, 16.393398f);
                instancePath.cubicTo(34.405178f, 16.941818f, 35.112286f, 17.623898f, 35.97808f, 18.439636f);
                instancePath.cubicTo(36.843872f, 17.623898f, 37.55098f, 16.941818f, 38.0994f, 16.393398f);
                instancePath.cubicTo(43.957264f, 10.535534f, 53.45474f, 10.535534f, 59.312603f, 16.393398f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(61.5f, 52.5f);
                instancePath2.lineTo(61.5f, 56.1f);
                instancePath2.lineTo(42.0f, 56.1f);
                instancePath2.lineTo(42.0f, 52.5f);
                instancePath2.lineTo(61.5f, 52.5f);
                instancePath2.close();
                instancePath2.moveTo(61.5f, 43.5f);
                instancePath2.lineTo(61.5f, 47.1f);
                instancePath2.lineTo(42.0f, 47.1f);
                instancePath2.lineTo(42.0f, 43.5f);
                instancePath2.lineTo(61.5f, 43.5f);
                instancePath2.close();
                instancePath2.moveTo(61.5f, 34.5f);
                instancePath2.lineTo(61.5f, 38.1f);
                instancePath2.lineTo(42.0f, 38.1f);
                instancePath2.lineTo(42.0f, 34.5f);
                instancePath2.lineTo(61.5f, 34.5f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
