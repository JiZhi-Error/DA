package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class top_story_wow_selected extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-15616);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 2.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(5.983979f, 4.1292553f);
                instancePath.lineTo(8.71702f, 1.4265164f);
                instancePath.cubicTo(9.426912f, 0.7244945f, 10.573088f, 0.7244945f, 11.28298f, 1.4265164f);
                instancePath.lineTo(14.016021f, 4.1292553f);
                instancePath.lineTo(17.750269f, 5.1197863f);
                instancePath.cubicTo(18.718977f, 5.374246f, 19.29727f, 6.3645763f, 19.037996f, 7.32983f);
                instancePath.lineTo(18.037163f, 11.019724f);
                instancePath.lineTo(19.038382f, 14.71104f);
                instancePath.cubicTo(19.29727f, 15.674871f, 18.718977f, 16.665201f, 17.751665f, 16.919292f);
                instancePath.lineTo(14.043242f, 17.902971f);
                instancePath.lineTo(11.28298f, 20.62295f);
                instancePath.cubicTo(10.573088f, 21.32497f, 9.426912f, 21.32497f, 8.71702f, 20.62295f);
                instancePath.lineTo(5.983979f, 17.92021f);
                instancePath.lineTo(2.2497308f, 16.92968f);
                instancePath.cubicTo(1.2810234f, 16.675219f, 0.70273095f, 15.684889f, 0.96200293f, 14.719635f);
                instancePath.lineTo(1.9628917f, 11.029538f);
                instancePath.lineTo(0.96161914f, 7.3284082f);
                instancePath.cubicTo(0.70273095f, 6.3645763f, 1.2810234f, 5.374246f, 2.2483342f, 5.120155f);
                instancePath.lineTo(5.983979f, 4.1292553f);
                instancePath.close();
                instancePath.moveTo(6.8952274f, 5.7072816f);
                instancePath.lineTo(6.902388f, 8.214648f);
                instancePath.cubicTo(6.902388f, 8.85835f, 6.556627f, 9.455693f, 5.998684f, 9.783765f);
                instancePath.lineTo(3.8010554f, 11.029725f);
                instancePath.lineTo(5.988231f, 12.269713f);
                instancePath.cubicTo(6.5522313f, 12.586272f, 6.902388f, 13.187037f, 6.902388f, 13.834817f);
                instancePath.lineTo(6.8952274f, 16.342194f);
                instancePath.lineTo(9.088051f, 15.080794f);
                instancePath.cubicTo(9.649613f, 14.750594f, 10.34542f, 14.750594f, 10.916072f, 15.077308f);
                instancePath.lineTo(13.104784f, 16.336365f);
                instancePath.lineTo(13.097611f, 13.824799f);
                instancePath.cubicTo(13.097611f, 13.189026f, 13.445173f, 12.592714f, 14.001316f, 12.2657f);
                instancePath.lineTo(16.198944f, 11.019741f);
                instancePath.lineTo(14.011768f, 9.779753f);
                instancePath.cubicTo(13.447769f, 9.463194f, 13.097611f, 8.862428f, 13.097611f, 8.214648f);
                instancePath.lineTo(13.104773f, 5.707272f);
                instancePath.lineTo(10.911949f, 6.968672f);
                instancePath.cubicTo(10.350303f, 7.298921f, 9.652848f, 7.299452f, 9.090765f, 6.9702644f);
                instancePath.lineTo(6.8952274f, 5.7072816f);
                instancePath.close();
                instancePath.moveTo(5.7023907f, 8.216363f);
                instancePath.lineTo(5.6944814f, 5.4475446f);
                instancePath.lineTo(2.554604f, 6.280412f);
                instancePath.cubicTo(2.2279632f, 6.3662143f, 2.034634f, 6.697292f, 2.1202598f, 7.016077f);
                instancePath.lineTo(2.961651f, 10.126214f);
                instancePath.lineTo(5.3938546f, 8.747316f);
                instancePath.cubicTo(5.5851345f, 8.633258f, 5.7023883f, 8.42943f, 5.7023907f, 8.216363f);
                instancePath.close();
                instancePath.moveTo(5.3986487f, 13.314885f);
                instancePath.lineTo(2.9611948f, 11.933011f);
                instancePath.lineTo(2.1205404f, 15.032347f);
                instancePath.cubicTo(2.034634f, 15.352174f, 2.2279632f, 15.683251f, 2.5560007f, 15.769423f);
                instancePath.lineTo(5.6944814f, 16.601921f);
                instancePath.lineTo(5.702388f, 13.834108f);
                instancePath.cubicTo(5.7021313f, 13.619632f, 5.5855026f, 13.419768f, 5.3986487f, 13.314885f);
                instancePath.close();
                instancePath.moveTo(9.691354f, 16.118095f);
                instancePath.lineTo(7.274271f, 17.508522f);
                instancePath.lineTo(9.560804f, 19.769705f);
                instancePath.cubicTo(9.803174f, 20.009386f, 10.196826f, 20.009386f, 10.439954f, 19.768955f);
                instancePath.lineTo(12.7346f, 17.507797f);
                instancePath.lineTo(10.319393f, 16.11845f);
                instancePath.cubicTo(10.120225f, 16.004623f, 9.884241f, 16.004707f, 9.691354f, 16.118095f);
                instancePath.close();
                instancePath.moveTo(14.297609f, 13.823085f);
                instancePath.lineTo(14.305518f, 16.591904f);
                instancePath.lineTo(17.445396f, 15.759035f);
                instancePath.cubicTo(17.772038f, 15.673233f, 17.965366f, 15.342155f, 17.879843f, 15.02375f);
                instancePath.lineTo(17.038805f, 11.922993f);
                instancePath.lineTo(14.606146f, 13.302149f);
                instancePath.cubicTo(14.415499f, 13.415832f, 14.297612f, 13.619298f, 14.297609f, 13.823085f);
                instancePath.close();
                instancePath.moveTo(14.601352f, 8.73458f);
                instancePath.lineTo(17.038805f, 10.116455f);
                instancePath.lineTo(17.87946f, 7.0171185f);
                instancePath.cubicTo(17.965366f, 6.697292f, 17.772038f, 6.3662143f, 17.443998f, 6.280043f);
                instancePath.lineTo(14.305518f, 5.447545f);
                instancePath.lineTo(14.297612f, 8.215357f);
                instancePath.cubicTo(14.297869f, 8.429834f, 14.414497f, 8.629698f, 14.601352f, 8.73458f);
                instancePath.close();
                instancePath.moveTo(9.691354f, 5.9313707f);
                instancePath.cubicTo(9.883398f, 6.0442615f, 10.116602f, 6.0442615f, 10.308646f, 5.9313707f);
                instancePath.lineTo(12.725729f, 4.540944f);
                instancePath.lineTo(10.439196f, 2.2797613f);
                instancePath.cubicTo(10.196826f, 2.0400796f, 9.803174f, 2.0400796f, 9.560804f, 2.2797613f);
                instancePath.lineTo(7.274271f, 4.540944f);
                instancePath.lineTo(9.691354f, 5.9313707f);
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
