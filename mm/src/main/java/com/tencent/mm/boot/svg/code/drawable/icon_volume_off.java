package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icon_volume_off extends c {
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
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(32.0f, 0.0f);
                instancePath.lineTo(32.0f, 32.0f);
                instancePath.lineTo(0.0f, 32.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-1);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(10.53033f, 7.46967f);
                instancePath2.lineTo(14.029f, 10.96867f);
                instancePath2.lineTo(16.292892f, 8.707107f);
                instancePath2.cubicTo(16.683418f, 8.316583f, 17.316582f, 8.316583f, 17.707108f, 8.707107f);
                instancePath2.cubicTo(17.894644f, 8.894643f, 18.0f, 9.148997f, 18.0f, 9.414213f);
                instancePath2.lineTo(18.0f, 14.93967f);
                instancePath2.lineTo(26.08668f, 23.02602f);
                instancePath2.lineTo(25.02602f, 24.08668f);
                instancePath2.lineTo(9.46967f, 8.53033f);
                instancePath2.lineTo(10.53033f, 7.46967f);
                instancePath2.close();
                instancePath2.moveTo(10.939f, 11.999213f);
                instancePath2.lineTo(18.0f, 19.060213f);
                instancePath2.lineTo(18.0f, 22.585787f);
                instancePath2.cubicTo(18.0f, 23.138071f, 17.552284f, 23.585787f, 17.0f, 23.585787f);
                instancePath2.cubicTo(16.734783f, 23.585787f, 16.480429f, 23.480429f, 16.292892f, 23.292892f);
                instancePath2.lineTo(13.0f, 19.999214f);
                instancePath2.lineTo(9.0f, 20.0f);
                instancePath2.cubicTo(8.447715f, 20.0f, 8.0f, 19.552284f, 8.0f, 19.0f);
                instancePath2.lineTo(8.0f, 13.0f);
                instancePath2.cubicTo(8.0f, 12.447716f, 8.447715f, 12.0f, 9.0f, 12.0f);
                instancePath2.lineTo(10.939f, 11.999213f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-1);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 20.0f, 0.0f, 1.0f, 9.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(1.0663646f, 2.9346366f);
                instancePath3.cubicTo(2.1066158f, 3.9751425f, 2.75f, 5.412436f, 2.75f, 7.0f);
                instancePath3.cubicTo(2.75f, 8.587819f, 2.1064093f, 10.025319f, 1.065864f, 11.065864f);
                instancePath3.lineTo(0.00520382f, 10.005204f);
                instancePath3.cubicTo(0.77430254f, 9.236105f, 1.25f, 8.173605f, 1.25f, 7.0f);
                instancePath3.cubicTo(1.25f, 5.826395f, 0.77430254f, 4.763895f, 0.00520382f, 3.9947963f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 1);
                canvas.drawPath(instancePath3, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint4, looper);
                Path instancePath4 = c.instancePath(looper);
                instancePath4.moveTo(3.1881764f, 0.81380785f);
                instancePath4.cubicTo(4.771032f, 2.397168f, 5.75f, 4.584259f, 5.75f, 7.0f);
                instancePath4.cubicTo(5.75f, 9.416245f, 4.7706227f, 11.603745f, 3.1871843f, 13.187184f);
                instancePath4.lineTo(2.1265242f, 12.126524f);
                instancePath4.cubicTo(3.4385161f, 10.814532f, 4.25f, 9.002032f, 4.25f, 7.0f);
                instancePath4.cubicTo(4.25f, 4.9984684f, 3.4389217f, 3.186374f, 2.1275082f, 1.8744599f);
                instancePath4.close();
                WeChatSVGRenderC2Java.setFillType(instancePath4, 1);
                canvas.drawPath(instancePath4, instancePaint6);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
