package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_moment_off extends c {
    private final int height = 32;
    private final int width = 32;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 32;
            case 1:
                return 32;
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 2.0f, 0.0f, 1.0f, 2.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(-436207616);
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 0.666667f, 0.0f, 1.0f, 0.666667f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(15.042786f, 26.556795f);
                instancePath.cubicTo(14.482807f, 26.629278f, 13.912225f, 26.666666f, 13.333333f, 26.666666f);
                instancePath.cubicTo(6.0f, 26.666666f, 3.0553338E-13f, 20.666666f, 3.0553338E-13f, 13.333333f);
                instancePath.cubicTo(3.0553338E-13f, 6.0f, 6.0f, 7.81597E-14f, 13.333333f, 7.81597E-14f);
                instancePath.cubicTo(20.666666f, 7.81597E-14f, 26.666666f, 6.0f, 26.666666f, 13.333333f);
                instancePath.cubicTo(26.666666f, 13.912228f, 26.629278f, 14.482814f, 26.556795f, 15.042795f);
                instancePath.cubicTo(26.14332f, 14.557369f, 25.674034f, 14.120941f, 25.158861f, 13.743438f);
                instancePath.cubicTo(25.173752f, 13.607915f, 25.187466f, 13.471213f, 25.2f, 13.333333f);
                instancePath.cubicTo(25.2f, 12.133333f, 24.933332f, 11.066667f, 24.666666f, 10.0f);
                instancePath.lineTo(22.268461f, 12.398205f);
                instancePath.cubicTo(21.648937f, 12.247915f, 21.001806f, 12.168266f, 20.336073f, 12.168266f);
                instancePath.cubicTo(20.266241f, 12.168266f, 20.196613f, 12.169143f, 20.1272f, 12.170885f);
                instancePath.lineTo(24.0f, 8.4f);
                instancePath.cubicTo(22.933332f, 6.133333f, 21.066668f, 4.266667f, 18.933332f, 3.0666666f);
                instancePath.lineTo(18.933332f, 12.28827f);
                instancePath.cubicTo(18.364773f, 12.386687f, 17.816366f, 12.543894f, 17.294598f, 12.753404f);
                instancePath.cubicTo(17.027021f, 10.777587f, 15.40237f, 9.333333f, 13.333333f, 9.333333f);
                instancePath.cubicTo(11.066667f, 9.333333f, 9.333333f, 11.066667f, 9.333333f, 13.333333f);
                instancePath.cubicTo(9.333333f, 14.4f, 9.733334f, 15.466667f, 10.533333f, 16.133333f);
                instancePath.cubicTo(11.078894f, 16.788006f, 11.892327f, 17.174807f, 12.754421f, 17.293734f);
                instancePath.cubicTo(12.396258f, 18.185688f, 12.190891f, 19.155483f, 12.170711f, 20.17071f);
                instancePath.lineTo(9.333333f, 17.333334f);
                instancePath.lineTo(9.333333f, 24.4f);
                instancePath.cubicTo(10.533333f, 24.8f, 11.866667f, 25.066668f, 13.333333f, 25.2f);
                instancePath.cubicTo(13.479334f, 25.2f, 13.623361f, 25.196053f, 13.765654f, 25.188639f);
                instancePath.cubicTo(14.138001f, 25.692125f, 14.566832f, 26.151299f, 15.042786f, 26.556795f);
                instancePath.close();
                instancePath.moveTo(17.333334f, 2.2666667f);
                instancePath.cubicTo(16.133333f, 1.8666667f, 14.8f, 1.6f, 13.333333f, 1.6f);
                instancePath.cubicTo(12.133333f, 1.6f, 11.066667f, 1.8666667f, 10.0f, 2.1333334f);
                instancePath.lineTo(17.333334f, 9.333333f);
                instancePath.lineTo(17.333334f, 2.2666667f);
                instancePath.close();
                instancePath.moveTo(8.4f, 2.6666667f);
                instancePath.cubicTo(6.133333f, 3.7333333f, 4.266667f, 5.6f, 3.0666666f, 7.733333f);
                instancePath.lineTo(13.333333f, 7.733333f);
                instancePath.lineTo(8.4f, 2.6666667f);
                instancePath.close();
                instancePath.moveTo(2.2666667f, 9.333333f);
                instancePath.cubicTo(1.8666667f, 10.533333f, 1.6f, 11.866667f, 1.4666667f, 13.333333f);
                instancePath.cubicTo(1.4666667f, 14.533333f, 1.7333333f, 15.6f, 2.0f, 16.666666f);
                instancePath.lineTo(9.333333f, 9.333333f);
                instancePath.lineTo(2.2666667f, 9.333333f);
                instancePath.close();
                instancePath.moveTo(2.6666667f, 18.266666f);
                instancePath.cubicTo(3.7333333f, 20.533333f, 5.6f, 22.4f, 7.733333f, 23.6f);
                instancePath.lineTo(7.733333f, 13.333333f);
                instancePath.lineTo(2.6666667f, 18.266666f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint5);
                canvas.restore();
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(15.835732f, 21.002941f);
                instancePath2.cubicTo(15.835732f, 23.85733f, 18.14887f, 26.170948f, 21.00274f, 26.170948f);
                instancePath2.cubicTo(23.85687f, 26.170948f, 26.170748f, 23.85707f, 26.170748f, 21.002941f);
                instancePath2.cubicTo(26.170748f, 18.148811f, 23.85687f, 15.834932f, 21.00274f, 15.834932f);
                instancePath2.cubicTo(18.14887f, 15.834932f, 15.835732f, 18.14855f, 15.835732f, 21.002941f);
                instancePath2.close();
                instancePath2.moveTo(14.335732f, 21.002941f);
                instancePath2.cubicTo(14.335732f, 17.320383f, 17.320185f, 14.334932f, 21.00274f, 14.334932f);
                instancePath2.cubicTo(24.685297f, 14.334932f, 27.670748f, 17.320383f, 27.670748f, 21.002941f);
                instancePath2.cubicTo(27.670748f, 24.685497f, 24.685297f, 27.670948f, 21.00274f, 27.670948f);
                instancePath2.cubicTo(17.320185f, 27.670948f, 14.335732f, 24.685497f, 14.335732f, 21.002941f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                canvas.drawPath(instancePath2, instancePaint6);
                canvas.restore();
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint3, looper);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(21.785858f, 21.002941f);
                instancePath3.lineTo(24.003195f, 18.785604f);
                instancePath3.lineTo(23.221075f, 18.002487f);
                instancePath3.lineTo(21.00274f, 20.219822f);
                instancePath3.lineTo(18.785406f, 18.002487f);
                instancePath3.lineTo(18.002287f, 18.785604f);
                instancePath3.lineTo(20.220623f, 21.002941f);
                instancePath3.lineTo(18.002287f, 23.220276f);
                instancePath3.lineTo(18.785406f, 24.003393f);
                instancePath3.lineTo(21.00274f, 21.786058f);
                instancePath3.lineTo(23.221075f, 24.003393f);
                instancePath3.lineTo(24.003195f, 23.220276f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 1);
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint7);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}