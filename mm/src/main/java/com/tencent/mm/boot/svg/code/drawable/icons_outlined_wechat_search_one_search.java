package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_wechat_search_one_search extends c {
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
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(11.105988f, 11.837371f);
                instancePath.lineTo(18.249708f, 19.713781f);
                instancePath.cubicTo(18.435225f, 19.918325f, 18.4198f, 20.234531f, 18.215256f, 20.420048f);
                instancePath.cubicTo(18.210081f, 20.424742f, 18.20481f, 20.429327f, 18.199442f, 20.4338f);
                instancePath.lineTo(17.21343f, 21.255474f);
                instancePath.cubicTo(17.001293f, 21.432257f, 16.68601f, 21.403595f, 16.509228f, 21.191456f);
                instancePath.cubicTo(16.501387f, 21.182045f, 16.49389f, 21.172348f, 16.486761f, 21.162388f);
                instancePath.lineTo(10.284617f, 12.497627f);
                instancePath.cubicTo(10.126413f, 12.276607f, 10.17375f, 11.969687f, 10.391195f, 11.806603f);
                instancePath.lineTo(10.435628f, 11.773278f);
                instancePath.cubicTo(10.642127f, 11.618404f, 10.932577f, 11.646174f, 11.105988f, 11.837371f);
                instancePath.close();
                instancePath.moveTo(7.3311005f, 12.02933f);
                instancePath.lineTo(7.44166f, 12.062498f);
                instancePath.cubicTo(7.6979837f, 12.139395f, 7.848318f, 12.404481f, 7.7827425f, 12.663932f);
                instancePath.lineTo(5.7336955f, 20.77103f);
                instancePath.cubicTo(5.6660295f, 21.038754f, 5.394142f, 21.200932f, 5.1264186f, 21.133266f);
                instancePath.cubicTo(5.1123304f, 21.129705f, 5.098404f, 21.125532f, 5.084679f, 21.120758f);
                instancePath.lineTo(3.8023257f, 20.674723f);
                instancePath.cubicTo(3.54151f, 20.584003f, 3.403619f, 20.299028f, 3.4943376f, 20.038214f);
                instancePath.cubicTo(3.4977164f, 20.0285f, 3.501394f, 20.018892f, 3.5053656f, 20.009405f);
                instancePath.lineTo(6.7262063f, 12.315174f);
                instancePath.cubicTo(6.825003f, 12.07916f, 7.0860324f, 11.95581f, 7.3311005f, 12.02933f);
                instancePath.close();
                instancePath.moveTo(21.519138f, 7.8015513f);
                instancePath.cubicTo(21.52089f, 7.815428f, 21.522057f, 7.8293715f, 21.52264f, 7.843346f);
                instancePath.lineTo(21.578089f, 9.174148f);
                instancePath.cubicTo(21.589586f, 9.45005f, 21.37524f, 9.683033f, 21.099339f, 9.69453f);
                instancePath.cubicTo(21.090803f, 9.694885f, 21.082258f, 9.695022f, 21.073715f, 9.69494f);
                instancePath.lineTo(11.695192f, 9.604761f);
                instancePath.cubicTo(11.4209385f, 9.602124f, 11.2f, 9.379051f, 11.2f, 9.104785f);
                instancePath.lineTo(11.2f, 9.04086f);
                instancePath.cubicTo(11.2f, 8.788926f, 11.387439f, 8.576343f, 11.63739f, 8.544795f);
                instancePath.lineTo(20.960463f, 7.368097f);
                instancePath.cubicTo(21.234432f, 7.3335185f, 21.484558f, 7.5275826f, 21.519138f, 7.8015513f);
                instancePath.close();
                instancePath.moveTo(1.1923689f, 7.509456f);
                instancePath.cubicTo(1.2130234f, 7.5112524f, 1.2335463f, 7.5143313f, 1.2538186f, 7.5186753f);
                instancePath.lineTo(5.86275f, 8.506304f);
                instancePath.cubicTo(6.1117263f, 8.559655f, 6.280841f, 8.791593f, 6.255504f, 9.044957f);
                instancePath.lineTo(6.2442374f, 9.157627f);
                instancePath.cubicTo(6.219011f, 9.409893f, 6.008974f, 9.603352f, 5.7554893f, 9.607799f);
                instancePath.lineTo(1.0549756f, 9.690264f);
                instancePath.cubicTo(0.7788757f, 9.695107f, 0.5511258f, 9.475211f, 0.54628193f, 9.199111f);
                instancePath.cubicTo(0.545977f, 9.181729f, 0.54657876f, 9.164345f, 0.54808474f, 9.147026f);
                instancePath.lineTo(0.65093374f, 7.964262f);
                instancePath.cubicTo(0.6748559f, 7.6891575f, 0.91726464f, 7.485534f, 1.1923689f, 7.509456f);
                instancePath.close();
                instancePath.moveTo(10.375024f, 0.7691986f);
                instancePath.cubicTo(10.395004f, 0.77350205f, 10.414701f, 0.7790266f, 10.434006f, 0.7857411f);
                instancePath.lineTo(11.687366f, 1.2216924f);
                instancePath.cubicTo(11.948181f, 1.312411f, 12.086072f, 1.5973856f, 11.995354f, 1.8582011f);
                instancePath.cubicTo(11.990866f, 1.8711057f, 11.985849f, 1.8838208f, 11.98032f, 1.8963144f);
                instancePath.lineTo(9.695178f, 7.0590425f);
                instancePath.cubicTo(9.58626f, 7.305116f, 9.302122f, 7.420849f, 9.052268f, 7.320907f);
                instancePath.lineTo(8.89199f, 7.256796f);
                instancePath.cubicTo(8.665615f, 7.166246f, 8.537558f, 6.925626f, 8.588894f, 6.687279f);
                instancePath.lineTo(9.780954f, 1.1527115f);
                instancePath.cubicTo(9.839098f, 0.8827597f, 10.105072f, 0.71105516f, 10.375024f, 0.7691986f);
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
