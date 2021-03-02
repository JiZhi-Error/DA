package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class fav_list_success extends c {
    private final int height = 66;
    private final int width = 66;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 66;
            case 1:
                return 66;
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
                instancePaint3.setColor(-15028967);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 3.0f, 0.0f, 1.0f, 3.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(57.0f, 30.37037f);
                instancePath.cubicTo(57.0f, 15.087965f, 44.912033f, 3.0f, 29.62963f, 3.0f);
                instancePath.cubicTo(14.985957f, 3.0f, 3.0f, 15.1921425f, 3.0f, 30.37037f);
                instancePath.cubicTo(3.0f, 44.912033f, 15.087965f, 57.0f, 29.62963f, 57.0f);
                instancePath.cubicTo(44.807858f, 57.0f, 57.0f, 45.01404f, 57.0f, 30.37037f);
                instancePath.close();
                instancePath.moveTo(60.0f, 30.37037f);
                instancePath.cubicTo(60.0f, 46.56889f, 46.56889f, 60.0f, 29.62963f, 60.0f);
                instancePath.cubicTo(13.431111f, 60.0f, 0.0f, 46.56889f, 0.0f, 30.37037f);
                instancePath.cubicTo(0.0f, 13.431111f, 13.431111f, 0.0f, 29.62963f, 0.0f);
                instancePath.cubicTo(46.56889f, 0.0f, 60.0f, 13.431111f, 60.0f, 30.37037f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(16.671656f, 32.738823f);
                instancePath2.cubicTo(16.30071f, 32.33078f, 16.3125f, 31.6875f, 16.710756f, 31.289244f);
                instancePath2.lineTo(17.289244f, 30.710756f);
                instancePath2.cubicTo(17.681784f, 30.318216f, 18.34375f, 30.300781f, 18.75262f, 30.658543f);
                instancePath2.lineTo(25.24738f, 36.341457f);
                instancePath2.cubicTo(25.66304f, 36.705162f, 26.347137f, 36.704933f, 26.759602f, 36.35434f);
                instancePath2.lineTo(45.2404f, 20.645662f);
                instancePath2.cubicTo(45.659916f, 20.289072f, 46.3125f, 20.3125f, 46.71076f, 20.710756f);
                instancePath2.lineTo(47.28924f, 21.289244f);
                instancePath2.cubicTo(47.68178f, 21.681784f, 47.671932f, 22.313156f, 47.28053f, 22.686768f);
                instancePath2.lineTo(26.719471f, 42.313232f);
                instancePath2.cubicTo(26.322119f, 42.692524f, 25.70072f, 42.67079f, 25.328344f, 42.261177f);
                instancePath2.lineTo(16.671656f, 32.738823f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
