package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class wechat_icon extends c {
    private final int height = 40;
    private final int width = 50;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 50;
            case 1:
                return 40;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -5.0f, 0.0f, 1.0f, -10.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 5.5f, 0.0f, 1.0f, 10.5f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.125f, 14.7265625f);
                instancePath.cubicTo(0.125f, 19.091627f, 2.4916852f, 23.05406f, 6.21875f, 25.742188f);
                instancePath.cubicTo(6.493276f, 25.944246f, 6.6401734f, 26.175379f, 6.6400642f, 26.563416f);
                instancePath.cubicTo(6.640152f, 26.670708f, 6.6250997f, 26.784443f, 6.595362f, 26.922688f);
                instancePath.lineTo(5.8671875f, 29.960938f);
                instancePath.cubicTo(5.817892f, 30.156403f, 5.740183f, 30.286613f, 5.75f, 30.429688f);
                instancePath.cubicTo(5.740183f, 30.754131f, 6.0018015f, 31.015625f, 6.3359375f, 31.015625f);
                instancePath.cubicTo(6.452738f, 31.015625f, 6.5568004f, 30.96808f, 6.6875f, 30.898438f);
                instancePath.lineTo(10.5546875f, 28.671875f);
                instancePath.cubicTo(10.799532f, 28.523726f, 11.074364f, 28.44737f, 11.259872f, 28.44737f);
                instancePath.cubicTo(11.445381f, 28.44737f, 11.755001f, 28.504963f, 11.9609375f, 28.554688f);
                instancePath.cubicTo(13.753814f, 29.01293f, 15.689622f, 29.299446f, 17.703125f, 29.257812f);
                instancePath.cubicTo(18.018276f, 29.299446f, 18.339657f, 29.291105f, 18.640625f, 29.257812f);
                instancePath.cubicTo(18.277805f, 28.1367f, 18.069263f, 26.936419f, 18.054688f, 25.742188f);
                instancePath.cubicTo(18.069263f, 18.33676f, 25.242872f, 12.370381f, 34.109375f, 12.3828125f);
                instancePath.cubicTo(34.413307f, 12.370381f, 34.73051f, 12.380391f, 35.046875f, 12.3828125f);
                instancePath.cubicTo(33.72374f, 5.4160023f, 26.45944f, 0.078125f, 17.703125f, 0.078125f);
                instancePath.cubicTo(7.991104f, 0.078125f, 0.125f, 6.6200376f, 0.125f, 14.7265625f);
                instancePath.close();
                instancePath.moveTo(11.7265625f, 12.3828125f);
                instancePath.cubicTo(10.431959f, 12.3828125f, 9.3828125f, 11.333759f, 9.3828125f, 10.0390625f);
                instancePath.cubicTo(9.3828125f, 8.744784f, 10.431959f, 7.6953125f, 11.7265625f, 7.6953125f);
                instancePath.cubicTo(13.021166f, 7.6953125f, 14.0703125f, 8.744784f, 14.0703125f, 10.0390625f);
                instancePath.cubicTo(14.0703125f, 11.333759f, 13.021166f, 12.3828125f, 11.7265625f, 12.3828125f);
                instancePath.close();
                instancePath.moveTo(34.109375f, 13.5546875f);
                instancePath.cubicTo(42.198986f, 13.5546875f, 48.757812f, 19.00563f, 48.757812f, 25.742188f);
                instancePath.cubicTo(48.757812f, 29.398289f, 46.784225f, 32.70097f, 43.71875f, 34.882812f);
                instancePath.cubicTo(43.44795f, 35.109894f, 43.32267f, 35.369644f, 43.32267f, 35.611515f);
                instancePath.cubicTo(43.32267f, 35.853386f, 43.338406f, 35.92693f, 43.367188f, 36.054688f);
                instancePath.lineTo(43.43837f, 36.3606f);
                instancePath.cubicTo(43.650475f, 37.248222f, 43.96675f, 38.399002f, 43.997406f, 38.5026f);
                instancePath.lineTo(44.039536f, 38.641174f);
                instancePath.cubicTo(44.059147f, 38.711235f, 44.073715f, 38.784096f, 44.070312f, 38.867188f);
                instancePath.cubicTo(44.07598f, 39.117817f, 43.858135f, 39.335938f, 43.601562f, 39.335938f);
                instancePath.cubicTo(43.501774f, 39.335938f, 43.425327f, 39.308712f, 43.31831f, 39.25451f);
                instancePath.lineTo(43.25f, 39.21875f);
                instancePath.lineTo(40.085938f, 37.34375f);
                instancePath.lineTo(39.948334f, 37.272003f);
                instancePath.cubicTo(39.75934f, 37.176872f, 39.548042f, 37.093678f, 39.312202f, 37.139946f);
                instancePath.lineTo(39.022133f, 37.19874f);
                instancePath.cubicTo(38.986717f, 37.20692f, 38.96096f, 37.21401f, 38.914062f, 37.226562f);
                instancePath.cubicTo(37.39464f, 37.66729f, 35.78065f, 37.90543f, 34.109375f, 37.929688f);
                instancePath.cubicTo(26.019346f, 37.90543f, 19.460938f, 32.454487f, 19.460938f, 25.742188f);
                instancePath.cubicTo(19.460938f, 19.00563f, 26.019346f, 13.5546875f, 34.109375f, 13.5546875f);
                instancePath.close();
                instancePath.moveTo(29.130682f, 19.882812f);
                instancePath.cubicTo(28.152256f, 19.882812f, 27.3125f, 20.722479f, 27.3125f, 21.700994f);
                instancePath.cubicTo(27.3125f, 22.793549f, 28.152256f, 23.632812f, 29.130682f, 23.632812f);
                instancePath.cubicTo(30.223547f, 23.632812f, 31.0625f, 22.793549f, 31.0625f, 21.700994f);
                instancePath.cubicTo(31.0625f, 20.722479f, 30.223547f, 19.882812f, 29.130682f, 19.882812f);
                instancePath.close();
                instancePath.moveTo(38.857243f, 19.882812f);
                instancePath.cubicTo(37.87882f, 19.882812f, 37.039062f, 20.722479f, 37.039062f, 21.700994f);
                instancePath.cubicTo(37.039062f, 22.793549f, 37.87882f, 23.632812f, 38.857243f, 23.632812f);
                instancePath.cubicTo(39.950108f, 23.632812f, 40.789062f, 22.793549f, 40.789062f, 21.700994f);
                instancePath.cubicTo(40.789062f, 20.722479f, 39.950108f, 19.882812f, 38.857243f, 19.882812f);
                instancePath.close();
                instancePath.moveTo(23.445312f, 7.6953125f);
                instancePath.cubicTo(24.739592f, 7.6953125f, 25.789062f, 8.744784f, 25.789062f, 10.0390625f);
                instancePath.cubicTo(25.789062f, 11.333759f, 24.739592f, 12.3828125f, 23.445312f, 12.3828125f);
                instancePath.cubicTo(22.150616f, 12.3828125f, 21.101562f, 11.333759f, 21.101562f, 10.0390625f);
                instancePath.cubicTo(21.101562f, 8.744784f, 22.150616f, 7.6953125f, 23.445312f, 7.6953125f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
