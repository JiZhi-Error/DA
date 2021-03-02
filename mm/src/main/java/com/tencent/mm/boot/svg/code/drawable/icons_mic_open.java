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

public class icons_mic_open extends c {
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
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 4.0f, 0.0f, 1.0f, 4.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
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
                Paint instancePaint6 = c.instancePaint(looper);
                instancePaint6.setFlags(385);
                instancePaint6.setStyle(Paint.Style.FILL);
                Paint instancePaint7 = c.instancePaint(looper);
                instancePaint7.setFlags(385);
                instancePaint7.setStyle(Paint.Style.STROKE);
                instancePaint6.setColor(WebView.NIGHT_MODE_COLOR);
                instancePaint7.setStrokeWidth(1.0f);
                instancePaint7.setStrokeCap(Paint.Cap.BUTT);
                instancePaint7.setStrokeJoin(Paint.Join.MITER);
                instancePaint7.setStrokeMiter(4.0f);
                instancePaint7.setPathEffect(null);
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 112.0f, 0.0f, -8.2867224E-16f, 0.0f, 112.0f, -1.2430084E-15f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                WeChatSVGRenderC2Java.setLinearGradient(instancePaint5, 1.0f, 0.0f, 0.08367048f, 1.0f, new int[]{-6644737, -6644737}, new float[]{0.0f, 1.0f}, instanceMatrix, 0);
                canvas.drawPath(instancePath, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint8 = c.instancePaint(instancePaint, looper);
                instancePaint8.setColor(-8289281);
                float[] matrixFloatArray3 = c.setMatrixFloatArray(matrixFloatArray2, 1.0f, 0.0f, 32.0f, 0.0f, 1.0f, 32.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray3);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint9 = c.instancePaint(instancePaint8, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(33.359455f, 31.006395f);
                instancePath2.cubicTo(32.99237f, 30.884022f, 32.839417f, 30.945208f, 32.502922f, 31.128769f);
                instancePath2.cubicTo(31.401667f, 31.740637f, 28.709707f, 33.209118f, 27.119003f, 34.03514f);
                instancePath2.cubicTo(26.721329f, 34.249294f, 26.293062f, 34.371666f, 25.803614f, 34.371666f);
                instancePath2.cubicTo(25.283577f, 34.371666f, 24.82472f, 34.2187f, 24.427044f, 33.973953f);
                instancePath2.cubicTo(22.193941f, 32.658436f, 20.0832f, 31.128769f, 18.278364f, 29.293165f);
                instancePath2.cubicTo(16.473528f, 27.488155f, 14.944005f, 25.377213f, 13.628616f, 23.143894f);
                instancePath2.cubicTo(13.383892f, 22.746181f, 13.23094f, 22.256687f, 13.23094f, 21.767193f);
                instancePath2.cubicTo(13.23094f, 21.308292f, 13.353302f, 20.849392f, 13.567435f, 20.451677f);
                instancePath2.cubicTo(14.393377f, 18.830229f, 15.861719f, 16.13801f, 16.473528f, 15.067242f);
                instancePath2.cubicTo(16.65707f, 14.730715f, 16.718252f, 14.547154f, 16.59589f, 14.210627f);
                instancePath2.lineTo(13.995701f, 7.296522f);
                instancePath2.cubicTo(13.659206f, 6.5010943f, 12.894445f, 5.9810066f, 11.976731f, 5.950413f);
                instancePath2.cubicTo(11.609646f, 5.950413f, 11.18138f, 6.10338f, 11.089609f, 6.1339736f);
                instancePath2.cubicTo(8.091744f, 7.2353354f, 5.950413f, 10.08052f, 5.950413f, 13.445792f);
                instancePath2.cubicTo(5.950413f, 14.394187f, 6.195137f, 15.281395f, 6.225727f, 15.495549f);
                instancePath2.cubicTo(7.694069f, 21.92016f, 10.967247f, 27.641123f, 15.464043f, 32.13835f);
                instancePath2.cubicTo(19.960838f, 36.63558f, 25.681253f, 39.90907f, 32.105247f, 41.377552f);
                instancePath2.cubicTo(32.31938f, 41.43874f, 33.206505f, 41.652893f, 34.154808f, 41.652893f);
                instancePath2.cubicTo(37.519756f, 41.652893f, 40.36467f, 39.511356f, 41.465923f, 36.513203f);
                instancePath2.cubicTo(41.496513f, 36.421425f, 41.680058f, 35.99312f, 41.649467f, 35.625996f);
                instancePath2.cubicTo(41.588287f, 34.708195f, 41.06825f, 33.94336f, 40.272896f, 33.60683f);
                instancePath2.lineTo(33.359455f, 31.006395f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint9);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
