package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_followed extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(16.701439f, 19.205538f);
                instancePath.lineTo(21.732363f, 14.174613f);
                instancePath.lineTo(22.775007f, 15.2172575f);
                instancePath.lineTo(17.138197f, 20.852448f);
                instancePath.cubicTo(16.903902f, 21.08678f, 16.524002f, 21.086727f, 16.289722f, 20.852379f);
                instancePath.cubicTo(16.289703f, 20.852362f, 16.289686f, 20.852343f, 16.289722f, 20.852272f);
                instancePath.lineTo(13.473476f, 18.034513f);
                instancePath.lineTo(13.473476f, 18.034513f);
                instancePath.lineTo(14.501945f, 17.006044f);
                instancePath.lineTo(16.701439f, 19.205538f);
                instancePath.close();
                instancePath.moveTo(11.9f, 3.0f);
                instancePath.cubicTo(14.109139f, 3.0f, 15.9f, 4.79298f, 15.9f, 7.0002074f);
                instancePath.lineTo(15.9f, 8.710186f);
                instancePath.cubicTo(15.9f, 9.849296f, 15.300932f, 11.482861f, 14.568088f, 12.351573f);
                instancePath.lineTo(14.206554f, 12.780132f);
                instancePath.cubicTo(13.950578f, 13.083567f, 13.840469f, 13.422942f, 13.865302f, 13.742756f);
                instancePath.lineTo(12.303204f, 13.742263f);
                instancePath.cubicTo(12.282973f, 13.128194f, 12.471308f, 12.494871f, 12.887211f, 11.934546f);
                instancePath.lineTo(13.014172f, 11.77424f);
                instancePath.lineTo(13.375704f, 11.345679f);
                instancePath.cubicTo(13.830907f, 10.806083f, 14.2618475f, 9.68752f, 14.33051f, 8.91238f);
                instancePath.lineTo(14.34f, 8.710186f);
                instancePath.lineTo(14.34f, 7.0002074f);
                instancePath.cubicTo(14.34f, 5.653704f, 13.246735f, 4.56f, 11.9f, 4.56f);
                instancePath.cubicTo(10.616194f, 4.56f, 9.560067f, 5.5568933f, 9.466708f, 6.817743f);
                instancePath.lineTo(9.46f, 6.9995804f);
                instancePath.lineTo(9.46f, 8.7092905f);
                instancePath.cubicTo(9.46f, 9.416367f, 9.851284f, 10.544625f, 10.300522f, 11.182917f);
                instancePath.lineTo(10.424228f, 11.344164f);
                instancePath.lineTo(10.785761f, 11.772665f);
                instancePath.cubicTo(11.9885435f, 13.198244f, 11.622924f, 15.177076f, 10.039527f, 16.07579f);
                instancePath.lineTo(9.8586f, 16.17112f);
                instancePath.lineTo(4.198247f, 18.93331f);
                instancePath.cubicTo(4.1318827f, 18.965694f, 4.0106764f, 19.14753f, 3.9721177f, 19.258875f);
                instancePath.lineTo(3.96f, 19.315464f);
                instancePath.lineTo(3.96f, 19.44f);
                instancePath.lineTo(11.899f, 19.439f);
                instancePath.lineTo(11.899f, 21.0f);
                instancePath.lineTo(3.4014297f, 21.0f);
                instancePath.cubicTo(2.8483553f, 21.0f, 2.4f, 20.555756f, 2.4f, 20.001562f);
                instancePath.lineTo(2.4f, 19.315464f);
                instancePath.cubicTo(2.4f, 18.630375f, 2.898151f, 17.831907f, 3.5140977f, 17.531332f);
                instancePath.lineTo(9.174451f, 14.769143f);
                instancePath.cubicTo(9.995378f, 14.36854f, 10.186259f, 13.481262f, 9.593445f, 12.778639f);
                instancePath.lineTo(9.231913f, 12.350138f);
                instancePath.cubicTo(8.496318f, 11.478285f, 7.9f, 9.849497f, 7.9f, 8.7092905f);
                instancePath.lineTo(7.9f, 6.9995804f);
                instancePath.cubicTo(7.9f, 4.7906733f, 9.695356f, 3.0f, 11.9f, 3.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
