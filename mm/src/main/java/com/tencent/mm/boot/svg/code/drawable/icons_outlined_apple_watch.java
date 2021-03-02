package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_apple_watch extends c {
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
                c.instancePaint(instancePaint2, looper).setStrokeWidth(1.0f);
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(7.291144f, 5.291285f);
                instancePath.cubicTo(8.3017645f, 5.7738757f, 9.0f, 6.805397f, 9.0f, 8.0f);
                instancePath.lineTo(9.0f, 16.0f);
                instancePath.cubicTo(9.0f, 17.194603f, 8.3017645f, 18.226124f, 7.291144f, 18.708715f);
                instancePath.cubicTo(8.648424f, 20.352407f, 10.701873f, 21.4f, 13.0f, 21.4f);
                instancePath.cubicTo(16.04734f, 21.4f, 18.74891f, 19.54101f, 19.86769f, 16.761572f);
                instancePath.cubicTo(20.146275f, 16.069468f, 20.326395f, 15.049353f, 20.131582f, 14.123549f);
                instancePath.cubicTo(20.063347f, 13.79928f, 20.270905f, 13.481092f, 20.595175f, 13.412858f);
                instancePath.cubicTo(20.919443f, 13.344624f, 21.23763f, 13.552181f, 21.305866f, 13.876451f);
                instancePath.cubicTo(21.450941f, 14.56589f, 21.438818f, 15.286123f, 21.311903f, 16.004908f);
                instancePath.cubicTo(21.227242f, 16.484383f, 21.099442f, 16.915134f, 20.98089f, 17.209658f);
                instancePath.cubicTo(19.680756f, 20.43965f, 16.541237f, 22.6f, 13.0f, 22.6f);
                instancePath.cubicTo(10.115187f, 22.6f, 7.5621276f, 21.179594f, 6.0020413f, 19.0f);
                instancePath.cubicTo(6.001361f, 19.0f, 6.0006804f, 19.0f, 6.0f, 19.0f);
                instancePath.cubicTo(4.343146f, 19.0f, 3.0f, 17.656855f, 3.0f, 16.0f);
                instancePath.lineTo(3.0f, 8.0f);
                instancePath.cubicTo(3.0f, 6.343146f, 4.343146f, 5.0f, 6.0f, 5.0f);
                instancePath.cubicTo(6.0006804f, 5.0f, 6.001361f, 5.0f, 6.0020413f, 5.0000005f);
                instancePath.cubicTo(7.5621276f, 2.8204067f, 10.115187f, 1.4f, 13.0f, 1.4f);
                instancePath.cubicTo(16.925592f, 1.4f, 20.323988f, 4.052459f, 21.323439f, 7.8340487f);
                instancePath.cubicTo(21.644276f, 9.499922f, 21.328028f, 10.420356f, 20.336906f, 11.769371f);
                instancePath.cubicTo(20.290562f, 11.832396f, 20.290562f, 11.832396f, 20.245077f, 11.894305f);
                instancePath.cubicTo(19.719492f, 12.610658f, 19.530977f, 12.986295f, 19.483934f, 13.549906f);
                instancePath.cubicTo(19.348747f, 15.169577f, 19.064741f, 16.321024f, 18.597826f, 17.030006f);
                instancePath.cubicTo(18.41557f, 17.306753f, 18.043472f, 17.383352f, 17.766726f, 17.201096f);
                instancePath.cubicTo(17.489979f, 17.018837f, 17.41338f, 16.64674f, 17.595636f, 16.369993f);
                instancePath.cubicTo(17.926023f, 15.868321f, 18.168207f, 14.886435f, 18.288094f, 13.450094f);
                instancePath.cubicTo(18.35827f, 12.609307f, 18.631298f, 12.065268f, 19.277561f, 11.18444f);
                instancePath.cubicTo(19.324015f, 11.121207f, 19.324015f, 11.121207f, 19.36985f, 11.058874f);
                instancePath.cubicTo(20.181807f, 9.953723f, 20.391872f, 9.342331f, 20.15424f, 8.101041f);
                instancePath.cubicTo(19.302414f, 4.8826966f, 16.377766f, 2.6f, 13.0f, 2.6f);
                instancePath.cubicTo(10.701873f, 2.6f, 8.648424f, 3.6475916f, 7.291144f, 5.291285f);
                instancePath.close();
                instancePath.moveTo(17.699333f, 7.3422394f);
                instancePath.cubicTo(17.51032f, 7.070062f, 17.577738f, 6.6961927f, 17.849915f, 6.5071793f);
                instancePath.cubicTo(18.122093f, 6.318166f, 18.495962f, 6.3855834f, 18.684975f, 6.6577606f);
                instancePath.cubicTo(19.058987f, 7.1963334f, 19.399912f, 8.084637f, 19.547157f, 8.892401f);
                instancePath.cubicTo(19.606583f, 9.218399f, 19.390482f, 9.530848f, 19.064484f, 9.590273f);
                instancePath.cubicTo(18.738483f, 9.649698f, 18.426037f, 9.4335985f, 18.36661f, 9.107599f);
                instancePath.cubicTo(18.24838f, 8.459005f, 17.968567f, 7.729931f, 17.699333f, 7.3422394f);
                instancePath.close();
                instancePath.moveTo(6.0f, 6.2f);
                instancePath.cubicTo(5.0058875f, 6.2f, 4.2f, 7.0058875f, 4.2f, 8.0f);
                instancePath.lineTo(4.2f, 16.0f);
                instancePath.cubicTo(4.2f, 16.994112f, 5.0058875f, 17.8f, 6.0f, 17.8f);
                instancePath.cubicTo(6.9941125f, 17.8f, 7.8f, 16.994112f, 7.8f, 16.0f);
                instancePath.lineTo(7.8f, 8.0f);
                instancePath.cubicTo(7.8f, 7.0058875f, 6.9941125f, 6.2f, 6.0f, 6.2f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
