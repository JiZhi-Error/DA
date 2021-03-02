package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiResumeDownloadTask;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_detail_skin_hb_mask extends c {
    private final int height = JsApiResumeDownloadTask.CTRL_INDEX;
    private final int width = TXLiteAVCode.WARNING_MICROPHONE_DEVICE_EMPTY;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return TXLiteAVCode.WARNING_MICROPHONE_DEVICE_EMPTY;
            case 1:
                return JsApiResumeDownloadTask.CTRL_INDEX;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -96.0f, 0.0f, 1.0f, -71.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 96.0f, 0.0f, 1.0f, 71.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.009927948f, 275.6f);
                instancePath.cubicTo(0.009927948f, 289.88358f, 10.258303f, 306.87317f, 22.900314f, 313.53232f);
                instancePath.cubicTo(22.900314f, 313.53232f, 52.041653f, 329.41473f, 80.79265f, 341.9114f);
                instancePath.cubicTo(220.63646f, 402.69476f, 401.92905f, 439.37936f, 600.00995f, 439.37936f);
                instancePath.cubicTo(798.3458f, 439.37936f, 979.8502f, 402.60025f, 1119.7672f, 341.6765f);
                instancePath.cubicTo(1148.3163f, 329.24542f, 1177.1123f, 313.54172f, 1177.1123f, 313.54172f);
                instancePath.cubicTo(1189.7782f, 306.9105f, 1200.0099f, 289.89032f, 1200.0099f, 275.6f);
                instancePath.lineTo(1200.0099f, 444.0f);
                instancePath.lineTo(0.009927948f, 444.0f);
                instancePath.lineTo(0.009927948f, 275.6f);
                instancePath.close();
                Paint instancePaint4 = c.instancePaint(looper);
                instancePaint4.setFlags(385);
                instancePaint4.setStyle(Paint.Style.FILL);
                Paint instancePaint5 = c.instancePaint(looper);
                instancePaint5.setFlags(385);
                instancePaint5.setStyle(Paint.Style.STROKE);
                instancePaint4.setColor(WebView.NIGHT_MODE_COLOR);
                instancePaint5.setStrokeWidth(1.0f);
                instancePaint5.setStrokeCap(Paint.Cap.BUTT);
                instancePaint5.setStrokeJoin(Paint.Join.MITER);
                instancePaint5.setStrokeMiter(4.0f);
                instancePaint5.setPathEffect(null);
                float[] matrixFloatArray3 = c.setMatrixFloatArray(matrixFloatArray2, 1200.0099f, 0.0f, 0.009927948f, 0.0f, 444.0f, 275.6f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray3);
                WeChatSVGRenderC2Java.setLinearGradient(instancePaint3, 0.5f, 0.0f, 0.5f, 1.0f, new int[]{-1, -1, -1}, new float[]{0.0f, 0.889228f, 1.0f}, instanceMatrix, 0);
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint, looper);
                instancePaint6.setColor(-995729);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(0.0f, 275.6f);
                instancePath2.cubicTo(0.0f, 288.51648f, 10.567902f, 304.75446f, 22.845072f, 311.67966f);
                instancePath2.lineTo(27.106369f, 313.9748f);
                instancePath2.lineTo(32.18714f, 316.65604f);
                instancePath2.cubicTo(33.5395f, 317.3637f, 34.95122f, 318.0979f, 36.417206f, 318.85532f);
                instancePath2.cubicTo(46.190487f, 323.9047f, 56.37047f, 328.95404f, 66.43872f, 333.6655f);
                instancePath2.cubicTo(70.24551f, 335.4469f, 73.96943f, 337.14795f, 77.594154f, 338.758f);
                instancePath2.lineTo(81.43045f, 340.44403f);
                instancePath2.cubicTo(225.107f, 402.89328f, 407.27304f, 437.7794f, 600.00995f, 437.7794f);
                instancePath2.cubicTo(791.06323f, 437.7794f, 971.72656f, 403.49966f, 1114.8042f, 342.07907f);
                instancePath2.lineTo(1119.8541f, 339.89285f);
                instancePath2.cubicTo(1124.3289f, 337.9361f, 1128.9657f, 335.83185f, 1133.7327f, 333.60117f);
                instancePath2.cubicTo(1143.7661f, 328.90585f, 1153.9089f, 323.87387f, 1163.6449f, 318.8418f);
                instancePath2.lineTo(1167.8586f, 316.6501f);
                instancePath2.lineTo(1176.3701f, 312.12424f);
                instancePath2.cubicTo(1188.6996f, 305.66922f, 1199.5293f, 289.5502f, 1199.9944f, 276.46753f);
                instancePath2.lineTo(1200.0099f, 275.6f);
                instancePath2.cubicTo(1200.0099f, 282.0f, 1200.0099f, 286.75137f, 1200.0099f, 289.85416f);
                instancePath2.cubicTo(1200.0099f, 289.8798f, 1199.978f, 292.52603f, 1199.9672f, 292.55164f);
                instancePath2.cubicTo(1195.6947f, 302.57938f, 1187.6565f, 312.11f, 1178.7155f, 317.10852f);
                instancePath2.lineTo(1174.4143f, 319.42285f);
                instancePath2.cubicTo(1172.0438f, 320.68573f, 1169.4094f, 322.07208f, 1166.5516f, 323.55548f);
                instancePath2.lineTo(1165.1042f, 324.30518f);
                instancePath2.cubicTo(1155.3334f, 329.35526f, 1145.154f, 334.4054f, 1135.079f, 339.12012f);
                instancePath2.cubicTo(1131.2466f, 340.91354f, 1127.4967f, 342.62607f, 1123.8458f, 344.247f);
                instancePath2.lineTo(1120.396f, 345.7641f);
                instancePath2.cubicTo(976.22284f, 408.5411f, 793.40686f, 443.6f, 600.0f, 443.6f);
                instancePath2.cubicTo(408.7716f, 443.6f, 227.8939f, 409.32687f, 84.479324f, 347.87006f);
                instancePath2.lineTo(79.00112f, 345.50058f);
                instancePath2.cubicTo(74.507774f, 343.53442f, 69.85443f, 341.4222f, 65.0725f, 339.18448f);
                instancePath2.cubicTo(56.647827f, 335.24213f, 48.148964f, 331.06604f, 39.8741f, 326.85104f);
                instancePath2.lineTo(34.938446f, 324.3189f);
                instancePath2.cubicTo(32.48644f, 323.05206f, 30.185429f, 321.8498f, 28.058937f, 320.72742f);
                instancePath2.lineTo(22.144714f, 317.56854f);
                instancePath2.cubicTo(12.846583f, 312.6708f, 4.403824f, 303.53986f, 0.0f, 293.2f);
                instancePath2.cubicTo(0.0f, 293.17496f, 0.0f, 292.45557f, 0.0f, 292.43054f);
                instancePath2.cubicTo(0.0f, 288.2906f, 0.0f, 282.68042f, 0.0f, 275.6f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                canvas.drawPath(instancePath2, instancePaint6);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
