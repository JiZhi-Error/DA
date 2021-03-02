package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_mv_music_icon extends c {
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
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(21.162931f, 5.69646f);
                instancePath.cubicTo(21.167744f, 5.742668f, 21.166092f, 5.789322f, 21.158026f, 5.8350744f);
                instancePath.lineTo(18.92888f, 18.477184f);
                instancePath.cubicTo(18.689121f, 19.83692f, 17.392475f, 20.74484f, 16.03274f, 20.505083f);
                instancePath.cubicTo(14.673004f, 20.265326f, 13.765083f, 18.96868f, 14.004841f, 17.608944f);
                instancePath.cubicTo(14.235009f, 16.303596f, 15.439204f, 15.414643f, 16.738178f, 15.557738f);
                instancePath.lineTo(16.901323f, 15.581105f);
                instancePath.lineTo(16.901323f, 15.581105f);
                instancePath.cubicTo(17.406359f, 15.670351f, 17.889755f, 15.363698f, 18.033148f, 14.883964f);
                instancePath.lineTo(18.06013f, 14.769883f);
                instancePath.lineTo(18.06013f, 14.769883f);
                instancePath.lineTo(19.02683f, 9.283521f);
                instancePath.lineTo(11.268818f, 10.090618f);
                instancePath.lineTo(9.718313f, 18.883966f);
                instancePath.cubicTo(9.488146f, 20.189312f, 8.28395f, 21.078266f, 6.984976f, 20.935171f);
                instancePath.lineTo(6.8221736f, 20.911865f);
                instancePath.cubicTo(5.462438f, 20.672108f, 4.554517f, 19.375462f, 4.794275f, 18.015726f);
                instancePath.cubicTo(5.0244427f, 16.710379f, 6.228638f, 15.821425f, 7.5276127f, 15.9645195f);
                instancePath.lineTo(7.690415f, 15.987826f);
                instancePath.cubicTo(7.6905518f, 15.987851f, 7.6906886f, 15.987875f, 7.6908255f, 15.987899f);
                instancePath.cubicTo(8.19583f, 16.077097f, 8.679207f, 15.770491f, 8.822617f, 15.290801f);
                instancePath.lineTo(8.849531f, 15.177132f);
                instancePath.cubicTo(8.849556f, 15.176992f, 8.849581f, 15.176853f, 8.849606f, 15.176714f);
                instancePath.lineTo(10.28077f, 7.0563126f);
                instancePath.cubicTo(10.358271f, 6.616579f, 10.717903f, 6.2815094f, 11.162012f, 6.2352595f);
                instancePath.lineTo(20.61383f, 5.25094f);
                instancePath.cubicTo(20.888487f, 5.222337f, 21.134329f, 5.421803f, 21.162931f, 5.69646f);
                instancePath.close();
                instancePath.moveTo(7.9968905f, 2.7497308f);
                instancePath.cubicTo(8.233397f, 3.7416131f, 7.6210427f, 4.7374187f, 6.6291604f, 4.9739246f);
                instancePath.cubicTo(6.5838647f, 4.984725f, 6.538177f, 4.993808f, 6.492194f, 5.001154f);
                instancePath.lineTo(5.562836f, 5.1496243f);
                instancePath.lineTo(6.9431186f, 10.300907f);
                instancePath.cubicTo(7.229002f, 11.367839f, 6.595837f, 12.464513f, 5.528905f, 12.750397f);
                instancePath.cubicTo(4.4619727f, 13.036281f, 3.3652987f, 12.403115f, 3.079415f, 11.336183f);
                instancePath.cubicTo(2.8065262f, 10.317748f, 3.3710349f, 9.272213f, 4.350872f, 8.930624f);
                instancePath.lineTo(4.4936285f, 8.886693f);
                instancePath.lineTo(4.4936285f, 8.886693f);
                instancePath.cubicTo(4.731164f, 8.823046f, 4.8828583f, 8.598946f, 4.863346f, 8.362249f);
                instancePath.lineTo(4.8478055f, 8.2731f);
                instancePath.lineTo(4.8478055f, 8.2731f);
                instancePath.lineTo(3.7066755f, 4.0174713f);
                instancePath.cubicTo(3.6351676f, 3.7507544f, 3.793405f, 3.476563f, 4.060119f, 3.4050446f);
                instancePath.cubicTo(4.0870504f, 3.397823f, 4.1145387f, 3.3928668f, 4.1422963f, 3.390228f);
                instancePath.cubicTo(5.1335945f, 3.2959902f, 5.8655543f, 3.211915f, 6.338175f, 3.1380024f);
                instancePath.cubicTo(6.9000273f, 3.0501351f, 7.452933f, 2.9207113f, 7.9968905f, 2.7497308f);
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
