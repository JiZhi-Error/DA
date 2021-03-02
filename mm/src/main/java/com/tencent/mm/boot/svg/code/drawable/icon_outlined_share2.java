package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icon_outlined_share2 extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint2, looper);
                instancePaint3.setStrokeWidth(1.0f);
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(-2565928);
                instancePaint5.setColor(-6842473);
                instancePaint5.setStrokeWidth(3.0f);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(1.5f, 1.5f);
                instancePath.lineTo(70.5f, 1.5f);
                instancePath.lineTo(70.5f, 70.5f);
                instancePath.lineTo(1.5f, 70.5f);
                instancePath.lineTo(1.5f, 1.5f);
                instancePath.close();
                canvas.saveLayerAlpha(null, 0, 31);
                Paint instancePaint6 = c.instancePaint(instancePaint4, looper);
                Paint instancePaint7 = c.instancePaint(instancePaint5, looper);
                canvas.drawPath(instancePath, instancePaint6);
                canvas.drawPath(instancePath, instancePaint7);
                canvas.restore();
                canvas.save();
                Paint instancePaint8 = c.instancePaint(instancePaint, looper);
                instancePaint8.setColor(WebView.NIGHT_MODE_COLOR);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(43.31274f, 10.211309f);
                instancePath2.cubicTo(41.577324f, 10.30839f, 40.2f, 11.746392f, 40.2f, 13.506086f);
                instancePath2.lineTo(40.199f, 21.24f);
                instancePath2.lineTo(40.044308f, 21.255146f);
                instancePath2.cubicTo(20.565948f, 23.300108f, 9.707446f, 39.42255f, 11.299459f, 60.22188f);
                instancePath2.lineTo(11.347f, 60.802f);
                instancePath2.lineTo(11.34624f, 60.714478f);
                instancePath2.cubicTo(11.34624f, 60.993927f, 11.363081f, 61.195847f, 11.4496155f, 61.46426f);
                instancePath2.cubicTo(11.622453f, 62.000366f, 11.960901f, 62.469864f, 12.702336f, 62.67577f);
                instancePath2.cubicTo(13.503584f, 62.89829f, 14.087827f, 62.613834f, 14.509784f, 62.176414f);
                instancePath2.cubicTo(14.743529f, 61.9341f, 14.84062f, 61.77636f, 14.988257f, 61.418777f);
                instancePath2.lineTo(15.997783f, 58.757233f);
                instancePath2.cubicTo(16.030773f, 58.672237f, 16.061438f, 58.593914f, 16.088976f, 58.52446f);
                instancePath2.cubicTo(17.321796f, 55.415096f, 18.772772f, 52.53561f, 20.66736f, 49.795597f);
                instancePath2.lineTo(20.932741f, 49.416924f);
                instancePath2.cubicTo(25.560638f, 42.90194f, 31.644575f, 38.925037f, 39.606014f, 38.449684f);
                instancePath2.lineTo(40.199f, 38.421f);
                instancePath2.lineTo(40.2f, 48.263485f);
                instancePath2.cubicTo(40.2f, 49.13866f, 40.547676f, 49.978027f, 41.166546f, 50.596897f);
                instancePath2.cubicTo(42.455276f, 51.885628f, 44.544724f, 51.885628f, 45.833454f, 50.596897f);
                instancePath2.lineTo(62.15147f, 34.278877f);
                instancePath2.cubicTo(64.025986f, 32.40436f, 64.025986f, 29.36517f, 62.15147f, 27.490654f);
                instancePath2.lineTo(45.833454f, 11.172633f);
                instancePath2.cubicTo(45.21458f, 10.553763f, 44.375214f, 10.206086f, 43.5f, 10.206086f);
                instancePath2.lineTo(43.31274f, 10.211309f);
                instancePath2.close();
                instancePath2.moveTo(43.799f, 14.23f);
                instancePath2.lineTo(59.60589f, 30.036238f);
                instancePath2.lineTo(59.693363f, 30.133673f);
                instancePath2.cubicTo(60.072433f, 30.60488f, 60.043274f, 31.295906f, 59.60589f, 31.733294f);
                instancePath2.lineTo(43.799f, 47.539f);
                instancePath2.lineTo(43.799717f, 34.855274f);
                instancePath2.lineTo(42.044476f, 34.811653f);
                instancePath2.cubicTo(31.420433f, 34.54762f, 23.445093f, 39.448505f, 17.706284f, 47.748154f);
                instancePath2.lineTo(17.270338f, 48.391457f);
                instancePath2.cubicTo(16.5848f, 49.423798f, 15.956025f, 50.47109f, 15.373592f, 51.537834f);
                instancePath2.lineTo(14.906f, 52.417f);
                instancePath2.lineTo(14.947525f, 51.970737f);
                instancePath2.cubicTo(16.453726f, 36.505753f, 26.271027f, 25.613407f, 42.103127f, 24.69897f);
                instancePath2.lineTo(43.799213f, 24.601007f);
                instancePath2.lineTo(43.799f, 14.23f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                canvas.drawPath(instancePath2, instancePaint8);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
