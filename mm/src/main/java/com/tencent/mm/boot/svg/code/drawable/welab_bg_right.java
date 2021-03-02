package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tavkit.component.TAVPlayer;
import com.tencent.thumbplayer.api.TPOptionalID;

public class welab_bg_right extends c {
    private final int height = 696;
    private final int width = TAVPlayer.VIDEO_PLAYER_WIDTH;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return TAVPlayer.VIDEO_PLAYER_WIDTH;
            case 1:
                return 696;
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
                canvas.saveLayerAlpha(null, 51, 31);
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-1);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 0.70710677f, 0.70710677f, 0.10347748f, -0.70710677f, 0.70710677f, 314.05887f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(-1);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(338.17682f, 421.62106f);
                instancePath.lineTo(105.54254f, 421.62106f);
                instancePath.cubicTo(69.57901f, 369.38614f, -1.5916157E-12f, 314.71432f, -1.5916157E-12f, 224.86458f);
                instancePath.cubicTo(-1.5916157E-12f, 100.6753f, 99.32996f, 1.3195332E-12f, 221.85968f, 1.364242E-12f);
                instancePath.cubicTo(344.3894f, 1.3704833E-12f, 443.71936f, 100.6753f, 443.71936f, 224.86458f);
                instancePath.cubicTo(443.71936f, 314.71432f, 374.14035f, 369.38614f, 338.17682f, 421.62106f);
                instancePath.close();
                instancePath.moveTo(144.20879f, 451.20853f);
                instancePath.lineTo(299.51056f, 451.20853f);
                instancePath.cubicTo(305.63705f, 451.20853f, 310.60355f, 456.17606f, 310.60355f, 462.3038f);
                instancePath.lineTo(310.60355f, 469.70065f);
                instancePath.cubicTo(310.60355f, 475.82843f, 305.63705f, 480.79596f, 299.51056f, 480.79596f);
                instancePath.lineTo(144.20879f, 480.79596f);
                instancePath.cubicTo(138.0823f, 480.79596f, 133.11581f, 475.82843f, 133.11581f, 469.70065f);
                instancePath.lineTo(133.11581f, 462.3038f);
                instancePath.cubicTo(133.11581f, 456.17606f, 138.0823f, 451.20853f, 144.20879f, 451.20853f);
                instancePath.close();
                instancePath.moveTo(166.39476f, 510.3834f);
                instancePath.lineTo(277.3246f, 510.3834f);
                instancePath.cubicTo(283.45108f, 510.3834f, 288.41757f, 515.35095f, 288.41757f, 521.4787f);
                instancePath.lineTo(288.41757f, 528.87555f);
                instancePath.cubicTo(288.41757f, 535.0033f, 283.45108f, 539.9708f, 277.3246f, 539.9708f);
                instancePath.lineTo(166.39476f, 539.9708f);
                instancePath.cubicTo(160.26828f, 539.9708f, 155.30177f, 535.0033f, 155.30177f, 528.87555f);
                instancePath.lineTo(155.30177f, 521.4787f);
                instancePath.cubicTo(155.30177f, 515.35095f, 160.26828f, 510.3834f, 166.39476f, 510.3834f);
                instancePath.close();
                instancePath.moveTo(228.58931f, 274.01355f);
                instancePath.cubicTo(234.95694f, 286.75146f, 253.13435f, 286.75146f, 259.50198f, 274.01355f);
                instancePath.lineTo(288.41757f, 216.17035f);
                instancePath.lineTo(317.33316f, 274.01355f);
                instancePath.cubicTo(321.60043f, 282.54987f, 331.97977f, 286.0106f, 340.51608f, 281.74335f);
                instancePath.cubicTo(349.0524f, 277.47607f, 352.51312f, 267.09674f, 348.24585f, 258.56042f);
                instancePath.lineTo(303.87393f, 169.7981f);
                instancePath.cubicTo(297.5063f, 157.06018f, 279.32886f, 157.06018f, 272.96124f, 169.7981f);
                instancePath.lineTo(244.04565f, 227.64131f);
                instancePath.lineTo(215.13005f, 169.7981f);
                instancePath.cubicTo(208.76242f, 157.06018f, 190.58499f, 157.06018f, 184.21736f, 169.7981f);
                instancePath.lineTo(155.30177f, 227.64131f);
                instancePath.lineTo(126.386185f, 169.7981f);
                instancePath.cubicTo(122.11892f, 161.2618f, 111.73958f, 157.80106f, 103.20328f, 162.06831f);
                instancePath.cubicTo(94.66697f, 166.33559f, 91.20623f, 176.71492f, 95.473495f, 185.25122f);
                instancePath.lineTo(139.84543f, 274.01355f);
                instancePath.cubicTo(146.21306f, 286.75146f, 164.39049f, 286.75146f, 170.75812f, 274.01355f);
                instancePath.lineTo(199.6737f, 216.17035f);
                instancePath.lineTo(228.58931f, 274.01355f);
                instancePath.close();
                canvas.saveLayerAlpha(null, TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH, 31);
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint5);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
