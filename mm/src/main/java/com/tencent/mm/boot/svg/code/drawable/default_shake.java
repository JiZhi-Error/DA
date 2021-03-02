package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class default_shake extends c {
    private final int height = 192;
    private final int width = 192;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 192;
            case 1:
                return 192;
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
                Paint instancePaint3 = c.instancePaint(instancePaint2, looper);
                instancePaint3.setStrokeWidth(1.0f);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-14187817);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(192.0f, 0.0f);
                instancePath.lineTo(192.0f, 192.0f);
                instancePath.lineTo(0.0f, 192.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                instancePaint5.setColor(-1);
                instancePaint5.setStrokeWidth(9.0f);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(67.52295f, 44.723057f);
                instancePath2.cubicTo(62.305767f, 46.1451f, 59.20868f, 51.596455f, 60.60351f, 56.89179f);
                instancePath2.lineTo(84.891624f, 149.09908f);
                instancePath2.cubicTo(86.2873f, 154.39764f, 91.612236f, 157.54996f, 96.86527f, 156.11813f);
                instancePath2.lineTo(143.41838f, 143.4292f);
                instancePath2.cubicTo(148.63556f, 142.00716f, 151.73265f, 136.5558f, 150.33781f, 131.26047f);
                instancePath2.lineTo(126.049706f, 39.05318f);
                instancePath2.cubicTo(124.65403f, 33.75462f, 119.329094f, 30.602308f, 114.07606f, 32.034122f);
                instancePath2.lineTo(67.52295f, 44.723057f);
                instancePath2.lineTo(67.52295f, 44.723057f);
                instancePath2.close();
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint, looper);
                instancePaint6.setColor(-1);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(91.67919f, 139.06816f);
                instancePath3.cubicTo(87.20898f, 140.27698f, 84.56129f, 144.93335f, 85.75994f, 149.44794f);
                instancePath3.lineTo(85.75994f, 149.44794f);
                instancePath3.cubicTo(86.96104f, 153.97171f, 91.58298f, 156.65242f, 96.02875f, 155.45023f);
                instancePath3.lineTo(144.26404f, 142.40675f);
                instancePath3.cubicTo(148.73424f, 141.19795f, 151.38194f, 136.54156f, 150.18329f, 132.02698f);
                instancePath3.lineTo(150.18329f, 132.02698f);
                instancePath3.cubicTo(148.9822f, 127.503204f, 144.36024f, 124.822495f, 139.91447f, 126.02469f);
                instancePath3.lineTo(91.67919f, 139.06816f);
                instancePath3.lineTo(91.67919f, 139.06816f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint6);
                canvas.restore();
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint, looper);
                instancePaint7.setColor(-1);
                Path instancePath4 = c.instancePath(looper);
                instancePath4.moveTo(57.190487f, 71.99279f);
                instancePath4.cubicTo(60.6047f, 68.44723f, 62.616844f, 66.206894f, 72.68736f, 66.206894f);
                instancePath4.cubicTo(82.75788f, 66.206894f, 95.2417f, 77.25949f, 95.2417f, 77.25949f);
                instancePath4.cubicTo(95.2417f, 77.25949f, 94.297516f, 83.83633f, 87.07851f, 85.58789f);
                instancePath4.cubicTo(79.8623f, 87.34228f, 68.70764f, 84.29969f, 68.70764f, 84.29969f);
                instancePath4.lineTo(82.75789f, 139.6217f);
                instancePath4.cubicTo(82.75789f, 139.6217f, 63.39384f, 167.91832f, 54.868153f, 159.99243f);
                instancePath4.cubicTo(49.846596f, 155.32349f, 41.53447f, 148.98222f, 34.6358f, 142.95221f);
                instancePath4.cubicTo(30.892817f, 139.68112f, 29.36696f, 136.37608f, 33.877087f, 132.9918f);
                instancePath4.cubicTo(42.397156f, 126.60526f, 59.479103f, 112.16973f, 59.79383f, 108.07238f);
                instancePath4.cubicTo(60.24344f, 102.271576f, 53.413784f, 95.40541f, 53.413784f, 88.68497f);
                instancePath4.cubicTo(53.413784f, 81.927734f, 53.773468f, 75.53836f, 57.190487f, 71.99279f);
                instancePath4.close();
                instancePath4.moveTo(123.78036f, 62.37758f);
                instancePath4.cubicTo(120.0429f, 63.379025f, 117.82778f, 67.23131f, 118.82819f, 70.96488f);
                instancePath4.cubicTo(119.83064f, 74.70608f, 123.67509f, 76.926544f, 127.410545f, 75.92563f);
                instancePath4.lineTo(141.11108f, 72.25458f);
                instancePath4.cubicTo(144.84854f, 71.253136f, 147.06366f, 67.40085f, 146.06325f, 63.667274f);
                instancePath4.cubicTo(145.0608f, 59.926083f, 141.21635f, 57.705616f, 137.4809f, 58.706528f);
                instancePath4.lineTo(123.78036f, 62.37758f);
                instancePath4.close();
                instancePath4.moveTo(127.410545f, 75.92563f);
                instancePath4.cubicTo(123.67309f, 76.92708f, 121.45798f, 80.77936f, 122.45838f, 84.51293f);
                instancePath4.cubicTo(123.46083f, 88.25413f, 127.305275f, 90.474594f, 131.04073f, 89.47368f);
                instancePath4.lineTo(144.74127f, 85.80263f);
                instancePath4.cubicTo(148.47873f, 84.801186f, 150.69385f, 80.948906f, 149.69344f, 77.215324f);
                instancePath4.cubicTo(148.691f, 73.47414f, 144.84654f, 71.25367f, 141.11108f, 72.25458f);
                instancePath4.lineTo(127.410545f, 75.92563f);
                instancePath4.close();
                instancePath4.moveTo(131.04073f, 89.47368f);
                instancePath4.cubicTo(127.30328f, 90.47513f, 125.088165f, 94.32741f, 126.08857f, 98.06099f);
                instancePath4.cubicTo(127.09102f, 101.80218f, 130.93547f, 104.022644f, 134.67091f, 103.02173f);
                instancePath4.lineTo(148.37148f, 99.35068f);
                instancePath4.cubicTo(152.10892f, 98.349236f, 154.32404f, 94.496956f, 153.32362f, 90.763374f);
                instancePath4.cubicTo(152.32118f, 87.02219f, 148.47673f, 84.80172f, 144.74127f, 85.80263f);
                instancePath4.lineTo(131.04073f, 89.47368f);
                instancePath4.close();
                instancePath4.moveTo(140.12512f, 101.56028f);
                instancePath4.cubicTo(136.3837f, 102.5628f, 134.16536f, 106.41594f, 135.16577f, 110.14951f);
                instancePath4.cubicTo(136.16823f, 113.8907f, 140.0104f, 116.11178f, 143.75531f, 115.10834f);
                instancePath4.lineTo(151.99448f, 112.90066f);
                instancePath4.cubicTo(155.73589f, 111.89815f, 157.95422f, 108.045006f, 156.95381f, 104.311424f);
                instancePath4.cubicTo(155.95137f, 100.57024f, 152.10919f, 98.34916f, 148.36429f, 99.35261f);
                instancePath4.lineTo(140.12512f, 101.56028f);
                instancePath4.close();
                WeChatSVGRenderC2Java.setFillType(instancePath4, 2);
                canvas.drawPath(instancePath4, instancePaint7);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
