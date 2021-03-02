package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class fix_tools_logo extends c {
    private final int height = 60;
    private final int width = 60;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 60;
            case 1:
                return 60;
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
                instancePaint3.setColor(-5592406);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 6.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(47.93003f, 28.93863f);
                instancePath.cubicTo(46.569485f, 28.93863f, 45.48105f, 27.860409f, 45.48105f, 26.512636f);
                instancePath.cubicTo(45.48105f, 25.164862f, 46.569485f, 24.086643f, 47.93003f, 24.086643f);
                instancePath.cubicTo(49.290573f, 24.086643f, 50.37901f, 25.164862f, 50.37901f, 26.512636f);
                instancePath.cubicTo(50.37901f, 27.79302f, 49.290573f, 28.93863f, 47.93003f, 28.93863f);
                instancePath.moveTo(35.860058f, 28.93863f);
                instancePath.cubicTo(34.499516f, 28.93863f, 33.41108f, 27.860409f, 33.41108f, 26.512636f);
                instancePath.cubicTo(33.41108f, 25.164862f, 34.499516f, 24.086643f, 35.860058f, 24.086643f);
                instancePath.cubicTo(37.220604f, 24.086643f, 38.309036f, 25.164862f, 38.309036f, 26.512636f);
                instancePath.cubicTo(38.309036f, 27.79302f, 37.220604f, 28.93863f, 35.860058f, 28.93863f);
                instancePath.moveTo(53.770905f, 42.55556f);
                instancePath.cubicTo(57.588737f, 39.833344f, 60.0f, 35.78321f, 60.0f, 31.334707f);
                instancePath.cubicTo(60.0f, 23.101652f, 51.962456f, 16.462093f, 41.982506f, 16.462093f);
                instancePath.cubicTo(32.00256f, 16.462093f, 23.965015f, 23.101652f, 23.965015f, 31.334707f);
                instancePath.cubicTo(23.965015f, 39.56776f, 32.00256f, 46.207317f, 41.982506f, 46.207317f);
                instancePath.cubicTo(44.058872f, 46.207317f, 46.001278f, 45.94174f, 47.876705f, 45.410572f);
                instancePath.cubicTo(48.010666f, 45.344177f, 48.211605f, 45.344177f, 48.41254f, 45.344177f);
                instancePath.cubicTo(48.74744f, 45.344177f, 49.082336f, 45.476967f, 49.350254f, 45.60976f);
                instancePath.lineTo(53.302048f, 47.86721f);
                instancePath.cubicTo(53.436005f, 47.933605f, 53.502987f, 48.0f, 53.636944f, 48.0f);
                instancePath.cubicTo(53.971844f, 48.0f, 54.23976f, 47.734417f, 54.23976f, 47.40244f);
                instancePath.cubicTo(54.23976f, 47.26965f, 54.172783f, 47.136856f, 54.172783f, 46.93767f);
                instancePath.cubicTo(54.172783f, 46.871273f, 53.636944f, 45.078594f, 53.369026f, 43.949867f);
                instancePath.cubicTo(53.302048f, 43.817078f, 53.302048f, 43.684288f, 53.302048f, 43.551495f);
                instancePath.cubicTo(53.23507f, 43.086727f, 53.436005f, 42.75475f, 53.770905f, 42.55556f);
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(28.688047f, 14.902527f);
                instancePath2.cubicTo(27.125906f, 14.902527f, 25.889214f, 13.677441f, 25.889214f, 12.129964f);
                instancePath2.cubicTo(25.889214f, 10.582487f, 27.125906f, 9.357401f, 28.688047f, 9.357401f);
                instancePath2.cubicTo(30.250187f, 9.357401f, 31.486881f, 10.582487f, 31.486881f, 12.129964f);
                instancePath2.cubicTo(31.486881f, 13.612963f, 30.250187f, 14.902527f, 28.688047f, 14.902527f);
                instancePath2.moveTo(14.344024f, 14.902527f);
                instancePath2.cubicTo(12.781883f, 14.902527f, 11.54519f, 13.677441f, 11.54519f, 12.129964f);
                instancePath2.cubicTo(11.54519f, 10.582487f, 12.781883f, 9.357401f, 14.344024f, 9.357401f);
                instancePath2.cubicTo(15.906163f, 9.357401f, 17.142857f, 10.582487f, 17.142857f, 12.129964f);
                instancePath2.cubicTo(17.142857f, 13.612963f, 15.906163f, 14.902527f, 14.344024f, 14.902527f);
                instancePath2.moveTo(21.683867f, 0.0f);
                instancePath2.cubicTo(9.734243f, 0.0f, 0.0f, 7.9528785f, 0.0f, 17.827703f);
                instancePath2.cubicTo(0.0f, 23.195896f, 2.8867068f, 28.033897f, 7.518864f, 31.281322f);
                instancePath2.cubicTo(7.8545275f, 31.54642f, 8.123058f, 31.944063f, 8.123058f, 32.474255f);
                instancePath2.cubicTo(8.123058f, 32.606804f, 8.055925f, 32.805626f, 8.055925f, 32.93817f);
                instancePath2.cubicTo(7.720262f, 34.263653f, 7.116068f, 36.450695f, 7.048935f, 36.516968f);
                instancePath2.cubicTo(6.9818025f, 36.71579f, 6.9146695f, 36.84834f, 6.9146695f, 37.04716f);
                instancePath2.cubicTo(6.9146695f, 37.444805f, 7.2503333f, 37.776173f, 7.6531296f, 37.776173f);
                instancePath2.cubicTo(7.787395f, 37.776173f, 7.9216604f, 37.7099f, 8.055925f, 37.643627f);
                instancePath2.lineTo(12.822349f, 34.92639f);
                instancePath2.cubicTo(13.158012f, 34.72757f, 13.560808f, 34.59502f, 13.963605f, 34.59502f);
                instancePath2.cubicTo(14.165003f, 34.59502f, 14.366401f, 34.59502f, 14.567799f, 34.661297f);
                instancePath2.cubicTo(16.783178f, 35.257763f, 19.199957f, 35.655407f, 21.616734f, 35.655407f);
                instancePath2.lineTo(22.825123f, 35.655407f);
                instancePath2.cubicTo(22.355194f, 34.263653f, 22.086662f, 32.805626f, 22.086662f, 31.281322f);
                instancePath2.cubicTo(22.086662f, 22.334333f, 30.948181f, 15.044195f, 41.82368f, 15.044195f);
                instancePath2.lineTo(43.03207f, 15.044195f);
                instancePath2.cubicTo(41.488018f, 6.4948506f, 32.492233f, 0.0f, 21.683867f, 0.0f);
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
