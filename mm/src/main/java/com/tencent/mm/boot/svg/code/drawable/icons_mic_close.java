package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_mic_close extends c {
    private final int height = 120;
    private final int width = 120;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 120;
            case 1:
                return 120;
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
                Paint instancePaint3 = c.instancePaint(instancePaint2, looper);
                instancePaint3.setStrokeWidth(1.0f);
                canvas.saveLayerAlpha(null, 204, 31);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 4.0f, 0.0f, 1.0f, 4.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(-1);
                instancePaint4.setStrokeWidth(5.0f);
                instancePaint4.setStrokeCap(Paint.Cap.ROUND);
                instancePaint4.setStrokeJoin(Paint.Join.MITER);
                instancePaint4.setPathEffect(new DashPathEffect(new float[]{14.0f, 14.0f}, 0.0f));
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(30.766623f, -1.2430084E-15f);
                instancePath.lineTo(81.233376f, 1.2430084E-15f);
                instancePath.cubicTo(91.9316f, -7.2222365E-16f, 95.811035f, 1.1139073f, 99.722145f, 3.2055924f);
                instancePath.cubicTo(103.63326f, 5.2972775f, 106.70272f, 8.36674f, 108.79441f, 12.277852f);
                instancePath.cubicTo(110.88609f, 16.188963f, 112.0f, 20.068398f, 112.0f, 30.766623f);
                instancePath.lineTo(112.0f, 81.233376f);
                instancePath.cubicTo(112.0f, 91.9316f, 110.88609f, 95.811035f, 108.79441f, 99.722145f);
                instancePath.cubicTo(106.70272f, 103.63326f, 103.63326f, 106.70272f, 99.722145f, 108.79441f);
                instancePath.cubicTo(95.811035f, 110.88609f, 91.9316f, 112.0f, 81.233376f, 112.0f);
                instancePath.lineTo(30.766623f, 112.0f);
                instancePath.cubicTo(20.068398f, 112.0f, 16.188963f, 110.88609f, 12.277852f, 108.79441f);
                instancePath.cubicTo(8.36674f, 106.70272f, 5.2972775f, 103.63326f, 3.2055924f, 99.722145f);
                instancePath.cubicTo(1.1139073f, 95.811035f, 4.8148243E-16f, 91.9316f, -8.2867224E-16f, 81.233376f);
                instancePath.lineTo(8.2867224E-16f, 30.766623f);
                instancePath.cubicTo(-4.8148243E-16f, 20.068398f, 1.1139073f, 16.188963f, 3.2055924f, 12.277852f);
                instancePath.cubicTo(5.2972775f, 8.36674f, 8.36674f, 5.2972775f, 12.277852f, 3.2055924f);
                instancePath.cubicTo(16.188963f, 1.1139073f, 20.068398f, 7.2222365E-16f, 30.766623f, -1.2430084E-15f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint, looper);
                instancePaint6.setColor(-1);
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, -0.70710677f, -0.70710677f, 91.35534f, 0.70710677f, -0.70710677f, 60.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray3 = c.setMatrixFloatArray(matrixFloatArray2, 1.0f, 0.0f, 0.586807f, 0.0f, 1.0f, 0.586807f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray3);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint6, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(33.925903f, 31.532888f);
                instancePath2.cubicTo(33.552586f, 31.408436f, 33.397038f, 31.470661f, 33.05483f, 31.65734f);
                instancePath2.cubicTo(31.934872f, 32.2796f, 29.197203f, 33.773014f, 27.579489f, 34.61306f);
                instancePath2.cubicTo(27.17506f, 34.830853f, 26.739521f, 34.955303f, 26.241764f, 34.955303f);
                instancePath2.cubicTo(25.712896f, 34.955303f, 25.246248f, 34.79974f, 24.84182f, 34.550835f);
                instancePath2.cubicTo(22.570797f, 33.212982f, 20.424215f, 31.65734f, 18.588734f, 29.790567f);
                instancePath2.cubicTo(16.75325f, 27.954908f, 15.197757f, 25.80812f, 13.860032f, 23.536882f);
                instancePath2.cubicTo(13.611153f, 23.132414f, 13.455604f, 22.63461f, 13.455604f, 22.136803f);
                instancePath2.cubicTo(13.455604f, 21.67011f, 13.580043f, 21.203417f, 13.797812f, 20.79895f);
                instancePath2.cubicTo(14.637778f, 19.149967f, 16.131052f, 16.412035f, 16.75325f, 15.323086f);
                instancePath2.cubicTo(16.939909f, 14.9808445f, 17.002129f, 14.794167f, 16.87769f, 14.451925f);
                instancePath2.lineTo(14.233351f, 7.4204183f);
                instancePath2.cubicTo(13.891142f, 6.6114836f, 13.113395f, 6.082565f, 12.180099f, 6.051452f);
                instancePath2.cubicTo(11.80678f, 6.051452f, 11.371242f, 6.2070165f, 11.277912f, 6.238129f);
                instancePath2.cubicTo(8.229144f, 7.3581924f, 6.051452f, 10.251689f, 6.051452f, 13.674104f);
                instancePath2.cubicTo(6.051452f, 14.638602f, 6.300331f, 15.540875f, 6.331441f, 15.758666f);
                instancePath2.cubicTo(7.824715f, 22.292368f, 11.153472f, 28.110474f, 15.7266245f, 32.684063f);
                instancePath2.cubicTo(20.299776f, 37.257656f, 26.117325f, 40.58673f, 32.6504f, 42.08015f);
                instancePath2.cubicTo(32.868168f, 42.142376f, 33.770355f, 42.360165f, 34.73476f, 42.360165f);
                instancePath2.cubicTo(38.15685f, 42.360165f, 41.050068f, 40.182262f, 42.17002f, 37.1332f);
                instancePath2.cubicTo(42.20113f, 37.039864f, 42.38779f, 36.604286f, 42.35668f, 36.23093f);
                instancePath2.cubicTo(42.29446f, 35.297543f, 41.765594f, 34.519722f, 40.956738f, 34.177483f);
                instancePath2.lineTo(33.925903f, 31.532888f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint7);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
