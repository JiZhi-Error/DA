package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class bottomsheet_icon_facefriend extends c {
    private final int height = 96;
    private final int width = 96;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                instancePaint3.setColor(-8617851);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(88.98887f, 65.823074f);
                instancePath.cubicTo(88.89869f, 63.170345f, 87.255264f, 60.917454f, 84.9405f, 59.961655f);
                instancePath.lineTo(84.9405f, 59.71703f);
                instancePath.lineTo(68.109055f, 54.481007f);
                instancePath.lineTo(68.71548f, 54.481007f);
                instancePath.cubicTo(68.71548f, 54.481007f, 66.46022f, 54.097507f, 66.46022f, 52.20633f);
                instancePath.lineTo(66.46022f, 53.968163f);
                instancePath.lineTo(66.44624f, 53.963623f);
                instancePath.lineTo(66.44624f, 49.67024f);
                instancePath.cubicTo(66.45075f, 49.66706f, 66.45481f, 49.663883f, 66.45932f, 49.66071f);
                instancePath.lineTo(66.45932f, 51.29274f);
                instancePath.cubicTo(66.45932f, 50.144054f, 67.36151f, 49.03304f, 67.36151f, 49.03304f);
                instancePath.lineTo(67.33626f, 49.03304f);
                instancePath.cubicTo(72.19574f, 45.30106f, 75.48529f, 38.039978f, 75.47853f, 29.270761f);
                instancePath.cubicTo(75.46906f, 17.741253f, 68.396255f, 10.0f, 59.679577f, 10.0f);
                instancePath.cubicTo(53.00083f, 10.0f, 47.299126f, 14.547539f, 45.000137f, 21.85764f);
                instancePath.cubicTo(54.34443f, 25.274193f, 61.041206f, 34.628414f, 61.05248f, 47.25033f);
                instancePath.cubicTo(61.060143f, 55.714108f, 58.636265f, 63.1649f, 54.675816f, 68.67596f);
                instancePath.lineTo(55.6763f, 69.0f);
                instancePath.lineTo(76.62464f, 69.0f);
                instancePath.lineTo(88.300835f, 69.0f);
                instancePath.lineTo(89.00014f, 69.0f);
                instancePath.lineTo(89.00014f, 65.823074f);
                instancePath.lineTo(88.98887f, 65.823074f);
                instancePath.close();
                instancePath.moveTo(61.913708f, 77.961655f);
                instancePath.lineTo(61.913708f, 77.71748f);
                instancePath.lineTo(44.97163f, 72.48101f);
                instancePath.lineTo(45.581596f, 72.48101f);
                instancePath.cubicTo(45.581596f, 72.48101f, 43.31146f, 72.09751f, 43.31146f, 70.20633f);
                instancePath.lineTo(43.31146f, 71.967705f);
                instancePath.lineTo(43.29739f, 71.96362f);
                instancePath.lineTo(43.29739f, 68.124084f);
                instancePath.cubicTo(43.30193f, 68.12091f, 43.306015f, 68.11773f, 43.31055f, 68.115005f);
                instancePath.lineTo(43.31055f, 69.74658f);
                instancePath.cubicTo(43.31055f, 68.59744f, 44.218697f, 67.486885f, 44.218697f, 67.486885f);
                instancePath.lineTo(44.191013f, 67.486885f);
                instancePath.cubicTo(49.083927f, 63.71043f, 52.3961f, 56.04134f, 52.388836f, 47.270763f);
                instancePath.cubicTo(52.37976f, 35.741253f, 45.260277f, 28.0f, 36.48607f, 28.0f);
                instancePath.cubicTo(27.711407f, 28.0f, 20.60463f, 35.741253f, 20.61416f, 47.270763f);
                instancePath.cubicTo(20.621422f, 56.412132f, 24.235397f, 63.911938f, 29.476868f, 67.486885f);
                instancePath.lineTo(29.235874f, 67.486885f);
                instancePath.cubicTo(29.235874f, 67.486885f, 30.144022f, 68.59744f, 30.144022f, 69.74658f);
                instancePath.lineTo(30.144022f, 67.928474f);
                instancePath.cubicTo(30.148106f, 67.9312f, 30.152191f, 67.93438f, 30.156729f, 67.9371f);
                instancePath.lineTo(30.156729f, 71.96362f);
                instancePath.lineTo(30.143114f, 71.967705f);
                instancePath.lineTo(30.143114f, 70.20633f);
                instancePath.cubicTo(30.143114f, 72.09751f, 27.872974f, 72.48101f, 27.872974f, 72.48101f);
                instancePath.lineTo(28.482944f, 72.48101f);
                instancePath.lineTo(11.540868f, 77.71748f);
                instancePath.lineTo(11.540868f, 77.79736f);
                instancePath.cubicTo(8.977545f, 78.634705f, 7.108152f, 81.00197f, 7.0114827f, 83.823074f);
                instancePath.lineTo(7.000137f, 83.823074f);
                instancePath.lineTo(7.000137f, 87.0f);
                instancePath.lineTo(7.704506f, 87.0f);
                instancePath.lineTo(19.457306f, 87.0f);
                instancePath.lineTo(53.54297f, 87.0f);
                instancePath.lineTo(65.29577f, 87.0f);
                instancePath.lineTo(66.00014f, 87.0f);
                instancePath.lineTo(66.00014f, 83.823074f);
                instancePath.lineTo(65.98879f, 83.823074f);
                instancePath.cubicTo(65.89802f, 81.1708f, 64.24375f, 78.91746f, 61.913708f, 77.961655f);
                instancePath.lineTo(61.913708f, 77.961655f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
