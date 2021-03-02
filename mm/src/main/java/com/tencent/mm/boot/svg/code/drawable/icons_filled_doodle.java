package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_doodle extends c {
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
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(24.0f, 0.0f);
                instancePath.lineTo(24.0f, 24.0f);
                instancePath.lineTo(0.0f, 24.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-1);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(16.573029f, 16.926754f);
                instancePath2.lineTo(16.701107f, 16.69323f);
                instancePath2.cubicTo(16.738726f, 16.622015f, 16.771893f, 16.556192f, 16.802471f, 16.492044f);
                instancePath2.lineTo(16.904024f, 16.265303f);
                instancePath2.cubicTo(16.930784f, 16.200449f, 16.95088f, 16.145842f, 16.965597f, 16.100037f);
                instancePath2.lineTo(16.98281f, 16.038664f);
                instancePath2.lineTo(16.94387f, 16.055649f);
                instancePath2.cubicTo(16.726522f, 16.148457f, 16.318117f, 16.361279f, 15.743159f, 16.74706f);
                instancePath2.lineTo(15.323806f, 17.037394f);
                instancePath2.lineTo(14.250887f, 17.792751f);
                instancePath2.cubicTo(13.830916f, 18.079798f, 13.626141f, 18.196108f, 13.315362f, 18.34445f);
                instancePath2.cubicTo(12.3956f, 18.783472f, 11.509516f, 18.761793f, 10.994085f, 17.932154f);
                instancePath2.lineTo(10.915831f, 17.794392f);
                instancePath2.lineTo(10.859782f, 17.664839f);
                instancePath2.cubicTo(10.265171f, 15.971412f, 11.106428f, 14.331756f, 13.6474085f, 10.95341f);
                instancePath2.lineTo(14.527189f, 9.790741f);
                instancePath2.cubicTo(16.634024f, 6.9806023f, 17.33257f, 5.68638f, 17.092798f, 5.1618648f);
                instancePath2.lineTo(17.06381f, 5.1106644f);
                instancePath2.lineTo(16.950562f, 5.0690084f);
                instancePath2.cubicTo(14.345053f, 4.275245f, 5.932929f, 12.0644865f, 3.925004f, 16.349222f);
                instancePath2.lineTo(3.8356197f, 16.547455f);
                instancePath2.lineTo(2.0f, 15.753415f);
                instancePath2.cubicTo(2.8347406f, 13.823707f, 5.7845845f, 10.1759f, 8.790505f, 7.4012933f);
                instancePath2.lineTo(9.316054f, 6.9246445f);
                instancePath2.cubicTo(12.882582f, 3.7485921f, 15.935555f, 2.249306f, 18.055056f, 3.3685892f);
                instancePath2.lineTo(18.20847f, 3.455175f);
                instancePath2.lineTo(18.382767f, 3.588067f);
                instancePath2.cubicTo(19.416912f, 4.573392f, 19.3092f, 5.9246187f, 18.460993f, 7.5514574f);
                instancePath2.lineTo(18.25623f, 7.929876f);
                instancePath2.cubicTo(17.882734f, 8.593871f, 17.438951f, 9.24129f, 16.608562f, 10.353336f);
                instancePath2.lineTo(15.469514f, 11.859404f);
                instancePath2.cubicTo(13.780636f, 14.086036f, 12.913852f, 15.48885f, 12.733186f, 16.363907f);
                instancePath2.lineTo(12.72781f, 16.393665f);
                instancePath2.lineTo(12.95797f, 16.250187f);
                instancePath2.cubicTo(13.044601f, 16.193563f, 13.143432f, 16.126678f, 13.261315f, 16.045143f);
                instancePath2.lineTo(14.427343f, 15.22361f);
                instancePath2.cubicTo(16.080923f, 14.078917f, 17.10985f, 13.654128f, 18.129395f, 14.269537f);
                instancePath2.lineTo(18.262377f, 14.355733f);
                instancePath2.lineTo(18.398458f, 14.469071f);
                instancePath2.cubicTo(19.195583f, 15.26259f, 19.139357f, 16.237606f, 18.607851f, 17.352629f);
                instancePath2.cubicTo(18.545763f, 17.48288f, 18.479776f, 17.61088f, 18.401993f, 17.753057f);
                instancePath2.lineTo(18.24281f, 18.034664f);
                instancePath2.lineTo(18.286173f, 18.016106f);
                instancePath2.cubicTo(18.72714f, 17.812517f, 19.262877f, 17.520872f, 19.88807f, 17.14197f);
                instancePath2.lineTo(20.161469f, 16.974241f);
                instancePath2.lineTo(21.216143f, 18.673553f);
                instancePath2.lineTo(20.70194f, 18.98717f);
                instancePath2.cubicTo(18.371616f, 20.380919f, 17.000223f, 20.790165f, 16.120792f, 19.905075f);
                instancePath2.cubicTo(15.619096f, 19.40015f, 15.641642f, 18.802908f, 15.909801f, 18.156067f);
                instancePath2.cubicTo(15.963402f, 18.026772f, 16.027298f, 17.894672f, 16.106846f, 17.745451f);
                instancePath2.lineTo(16.314756f, 17.374825f);
                instancePath2.lineTo(16.573029f, 16.926754f);
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
