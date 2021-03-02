package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class face_agreement_icon extends c {
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
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-436207616);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(12.0f, 2.0f);
                instancePath.cubicTo(17.522848f, 2.0f, 22.0f, 6.4771523f, 22.0f, 12.0f);
                instancePath.cubicTo(22.0f, 14.621013f, 20.991644f, 17.00651f, 19.341703f, 18.789722f);
                instancePath.lineTo(19.191257f, 18.948812f);
                instancePath.lineTo(19.18168f, 18.958708f);
                instancePath.cubicTo(19.098303f, 19.04474f, 19.013393f, 19.129278f, 18.926996f, 19.212278f);
                instancePath.lineTo(19.191257f, 18.948812f);
                instancePath.cubicTo(19.075485f, 19.0686f, 18.956747f, 19.185501f, 18.835161f, 19.2994f);
                instancePath.cubicTo(18.651676f, 19.471281f, 18.461792f, 19.636257f, 18.265837f, 19.793993f);
                instancePath.cubicTo(18.255802f, 19.802069f, 18.245636f, 19.81022f, 18.235453f, 19.818354f);
                instancePath.cubicTo(17.018574f, 20.789932f, 15.570991f, 21.483093f, 13.987981f, 21.802397f);
                instancePath.lineTo(13.993273f, 21.801327f);
                instancePath.lineTo(13.94694f, 21.810585f);
                instancePath.cubicTo(13.848104f, 21.830088f, 13.748744f, 21.848135f, 13.648885f, 21.864702f);
                instancePath.lineTo(13.993273f, 21.801327f);
                instancePath.cubicTo(13.832484f, 21.833849f, 13.670297f, 21.862514f, 13.50681f, 21.887222f);
                instancePath.cubicTo(13.425931f, 21.899446f, 13.344571f, 21.910725f, 13.262904f, 21.921015f);
                instancePath.cubicTo(13.235492f, 21.92447f, 13.207821f, 21.927841f, 13.180116f, 21.931097f);
                instancePath.cubicTo(13.061891f, 21.944994f, 12.9432125f, 21.956816f, 12.823942f, 21.966541f);
                instancePath.cubicTo(12.80477f, 21.968105f, 12.78547f, 21.969624f, 12.766153f, 21.971088f);
                instancePath.cubicTo(12.657919f, 21.979288f, 12.549258f, 21.985762f, 12.440145f, 21.990488f);
                instancePath.cubicTo(12.420732f, 21.991327f, 12.401696f, 21.992098f, 12.382647f, 21.992813f);
                instancePath.cubicTo(12.348767f, 21.994091f, 12.314358f, 21.99521f, 12.279904f, 21.996159f);
                instancePath.lineTo(12.0f, 22.0f);
                instancePath.lineTo(12.0f, 22.0f);
                instancePath.cubicTo(11.871711f, 22.0f, 11.743985f, 21.997583f, 11.616867f, 21.992796f);
                instancePath.lineTo(12.0f, 22.0f);
                instancePath.cubicTo(11.85265f, 22.0f, 11.706043f, 21.996813f, 11.560246f, 21.990503f);
                instancePath.cubicTo(11.450742f, 21.985762f, 11.342081f, 21.979288f, 11.233902f, 21.971092f);
                instancePath.cubicTo(11.21453f, 21.969624f, 11.19523f, 21.968105f, 11.175944f, 21.966534f);
                instancePath.cubicTo(11.0567875f, 21.956816f, 10.938109f, 21.944994f, 10.820061f, 21.931118f);
                instancePath.cubicTo(10.792179f, 21.927841f, 10.764508f, 21.92447f, 10.736873f, 21.920986f);
                instancePath.cubicTo(10.655429f, 21.910725f, 10.574069f, 21.899446f, 10.493028f, 21.887197f);
                instancePath.cubicTo(10.460691f, 21.88231f, 10.428245f, 21.877243f, 10.395849f, 21.87202f);
                instancePath.lineTo(10.351115f, 21.864702f);
                instancePath.cubicTo(10.251256f, 21.848135f, 10.151896f, 21.830088f, 10.05306f, 21.810585f);
                instancePath.cubicTo(10.03787f, 21.807587f, 10.022292f, 21.804476f, 10.006727f, 21.801327f);
                instancePath.cubicTo(8.445631f, 21.486446f, 7.011841f, 20.804447f, 5.803744f, 19.849495f);
                instancePath.lineTo(5.763346f, 19.817394f);
                instancePath.lineTo(5.7412f, 19.79965f);
                instancePath.cubicTo(5.533797f, 19.633007f, 5.333181f, 19.458261f, 5.1398325f, 19.275894f);
                instancePath.cubicTo(5.124214f, 19.261164f, 5.1085668f, 19.24631f, 5.0929675f, 19.231405f);
                instancePath.cubicTo(4.9992957f, 19.141909f, 4.907434f, 19.050686f, 4.817361f, 18.95772f);
                instancePath.cubicTo(4.814609f, 18.954878f, 4.8116746f, 18.951847f, 4.8087425f, 18.948812f);
                instancePath.lineTo(4.6582956f, 18.789722f);
                instancePath.cubicTo(3.008356f, 17.00651f, 2.0f, 14.621013f, 2.0f, 12.0f);
                instancePath.cubicTo(2.0f, 6.4771523f, 6.4771523f, 2.0f, 12.0f, 2.0f);
                instancePath.close();
                instancePath.moveTo(12.0f, 3.2f);
                instancePath.cubicTo(7.139894f, 3.2f, 3.2f, 7.139894f, 3.2f, 12.0f);
                instancePath.cubicTo(3.2f, 14.517331f, 4.2569966f, 16.787786f, 5.951381f, 18.391758f);
                instancePath.lineTo(9.27445f, 16.769142f);
                instancePath.cubicTo(10.095377f, 16.36854f, 10.286259f, 15.481262f, 9.693445f, 14.778639f);
                instancePath.lineTo(9.331913f, 14.350138f);
                instancePath.cubicTo(8.780216f, 13.696248f, 8.306864f, 12.616582f, 8.104669f, 11.636593f);
                instancePath.lineTo(8.065674f, 11.430277f);
                instancePath.cubicTo(8.479546f, 11.465987f, 8.893426f, 11.496062f, 9.307315f, 11.520503f);
                instancePath.cubicTo(9.482027f, 12.269322f, 9.850622f, 13.104048f, 10.249079f, 13.576312f);
                instancePath.lineTo(10.610611f, 14.004812f);
                instancePath.cubicTo(11.706636f, 15.30386f, 11.325214f, 17.103651f, 9.800719f, 17.847588f);
                instancePath.lineTo(6.975996f, 19.22586f);
                instancePath.cubicTo(8.400521f, 20.218163f, 10.132313f, 20.8f, 12.0f, 20.8f);
                instancePath.cubicTo(13.86681f, 20.8f, 15.597853f, 20.21871f, 17.021997f, 19.227257f);
                instancePath.lineTo(14.199456f, 17.849041f);
                instancePath.cubicTo(12.672874f, 17.104393f, 12.295573f, 15.302913f, 13.389337f, 14.006369f);
                instancePath.lineTo(13.750869f, 13.577808f);
                instancePath.cubicTo(14.147896f, 13.107175f, 14.517166f, 12.270244f, 14.692764f, 11.51964f);
                instancePath.cubicTo(15.106942f, 11.496019f, 15.520545f, 11.465961f, 15.934144f, 11.430277f);
                instancePath.cubicTo(15.75972f, 12.460998f, 15.257115f, 13.65334f, 14.668087f, 14.351573f);
                instancePath.lineTo(14.306555f, 14.780132f);
                instancePath.cubicTo(13.717032f, 15.4789505f, 13.901188f, 16.368397f, 14.725549f, 16.77051f);
                instancePath.lineTo(18.048618f, 18.391758f);
                instancePath.cubicTo(19.743004f, 16.787786f, 20.8f, 14.517331f, 20.8f, 12.0f);
                instancePath.cubicTo(20.8f, 7.139894f, 16.860106f, 3.2f, 12.0f, 3.2f);
                instancePath.close();
                instancePath.moveTo(11.999847f, 9.8f);
                instancePath.cubicTo(13.999883f, 9.8f, 15.999933f, 9.933333f, 18.0f, 10.2f);
                instancePath.lineTo(18.0f, 10.6f);
                instancePath.cubicTo(15.999863f, 10.866667f, 13.999812f, 11.0f, 11.999847f, 11.0f);
                instancePath.cubicTo(9.999883f, 11.0f, 7.9999332f, 10.866667f, 6.0f, 10.6f);
                instancePath.lineTo(6.0f, 10.2f);
                instancePath.cubicTo(7.9998627f, 9.933333f, 9.999812f, 9.8f, 11.999847f, 9.8f);
                instancePath.close();
                instancePath.moveTo(12.0f, 5.0f);
                instancePath.cubicTo(14.209139f, 5.0f, 16.0f, 6.79298f, 16.0f, 9.000208f);
                instancePath.lineTo(16.000229f, 9.375468f);
                instancePath.cubicTo(15.600269f, 9.340381f, 15.200301f, 9.310555f, 14.800328f, 9.285992f);
                instancePath.lineTo(14.8f, 9.000208f);
                instancePath.cubicTo(14.8f, 7.454914f, 13.545589f, 6.2f, 12.0f, 6.2f);
                instancePath.cubicTo(10.456308f, 6.2f, 9.2f, 7.4552026f, 9.2f, 8.99958f);
                instancePath.lineTo(9.200204f, 9.285944f);
                instancePath.cubicTo(8.800191f, 9.310505f, 8.400188f, 9.340328f, 8.000197f, 9.375416f);
                instancePath.lineTo(8.0f, 8.99958f);
                instancePath.cubicTo(8.0f, 6.7906733f, 9.795356f, 5.0f, 12.0f, 5.0f);
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
