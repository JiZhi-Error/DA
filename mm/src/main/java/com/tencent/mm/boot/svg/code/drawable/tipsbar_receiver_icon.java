package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class tipsbar_receiver_icon extends c {
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
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(96.0f, 0.0f);
                instancePath.lineTo(96.0f, 96.0f);
                instancePath.lineTo(0.0f, 96.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-15028967);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(49.161392f, 74.975655f);
                instancePath2.cubicTo(39.768036f, 74.367f, 36.311947f, 66.23743f, 36.28125f, 60.92039f);
                instancePath2.cubicTo(36.263256f, 57.915203f, 34.37908f, 55.430813f, 32.38482f, 52.801407f);
                instancePath2.cubicTo(31.95294f, 52.23191f, 31.52212f, 51.664536f, 31.111412f, 51.092926f);
                instancePath2.cubicTo(29.10233f, 48.29627f, 28.026867f, 44.694065f, 28.000404f, 40.67374f);
                instancePath2.cubicTo(27.942184f, 31.61689f, 34.17796f, 23.572004f, 42.82929f, 21.543846f);
                instancePath2.cubicTo(48.813137f, 20.142342f, 54.945175f, 21.479275f, 59.654556f, 25.21168f);
                instancePath2.cubicTo(64.36076f, 28.943026f, 67.060005f, 34.524693f, 67.060005f, 40.524487f);
                instancePath2.cubicTo(67.060005f, 44.38709f, 65.93056f, 48.12267f, 63.793392f, 51.32898f);
                instancePath2.lineTo(62.913757f, 52.650036f);
                instancePath2.lineTo(60.27062f, 50.889687f);
                instancePath2.lineTo(61.15131f, 49.567574f);
                instancePath2.cubicTo(62.93916f, 46.88524f, 63.884426f, 43.75726f, 63.884426f, 40.524487f);
                instancePath2.cubicTo(63.884426f, 35.499607f, 61.623413f, 30.826162f, 57.681465f, 27.700302f);
                instancePath2.cubicTo(53.738457f, 24.57444f, 48.58767f, 23.456623f, 43.55332f, 24.635836f);
                instancePath2.cubicTo(36.332058f, 26.328436f, 31.12623f, 33.06391f, 31.175982f, 40.65257f);
                instancePath2.cubicTo(31.19821f, 44.01131f, 32.06726f, 46.980507f, 33.69104f, 49.239426f);
                instancePath2.cubicTo(34.08587f, 49.788807f, 34.49869f, 50.335014f, 34.914696f, 50.88228f);
                instancePath2.cubicTo(37.031746f, 53.674698f, 39.43248f, 56.83867f, 39.45683f, 60.902393f);
                instancePath2.cubicTo(39.477997f, 64.45273f, 41.575996f, 71.30147f, 49.365685f, 71.805336f);
                instancePath2.cubicTo(54.184093f, 72.13348f, 57.47399f, 68.59373f, 58.239307f, 64.954475f);
                instancePath2.cubicTo(59.367695f, 59.583458f, 56.01323f, 55.48586f, 49.036484f, 53.713867f);
                instancePath2.lineTo(48.86077f, 53.657764f);
                instancePath2.cubicTo(47.005173f, 52.947483f, 37.7526f, 48.977966f, 37.7526f, 40.524487f);
                instancePath2.cubicTo(37.7526f, 34.676064f, 41.681847f, 30.746773f, 47.5302f, 30.746773f);
                instancePath2.cubicTo(52.830242f, 30.746773f, 57.307804f, 35.22439f, 57.307804f, 40.524487f);
                instancePath2.cubicTo(57.307804f, 42.870205f, 56.567894f, 44.732174f, 55.923252f, 46.092396f);
                instancePath2.lineTo(55.242622f, 47.526714f);
                instancePath2.lineTo(52.37296f, 46.166492f);
                instancePath2.lineTo(53.05359f, 44.732174f);
                instancePath2.cubicTo(53.587086f, 43.60695f, 54.13223f, 42.226616f, 54.13223f, 40.524487f);
                instancePath2.cubicTo(54.13223f, 37.006966f, 51.046623f, 33.922386f, 47.5302f, 33.922386f);
                instancePath2.cubicTo(43.395603f, 33.922386f, 40.928177f, 36.38984f, 40.928177f, 40.524487f);
                instancePath2.cubicTo(40.928177f, 46.87148f, 48.669178f, 50.17094f, 49.912945f, 50.659985f);
                instancePath2.cubicTo(62.740158f, 53.96368f, 61.909214f, 62.93267f, 61.347137f, 65.6076f);
                instancePath2.cubicTo(60.1817f, 71.15539f, 55.447975f, 75.0f, 49.932f, 75.0f);
                instancePath2.cubicTo(49.67689f, 75.0f, 49.41967f, 74.99153f, 49.161392f, 74.975655f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint3);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
