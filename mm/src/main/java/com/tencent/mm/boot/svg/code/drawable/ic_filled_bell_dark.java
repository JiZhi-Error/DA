package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class ic_filled_bell_dark extends c {
    private final int height = 48;
    private final int width = 48;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 48;
            case 1:
                return 48;
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-14671840);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 4.0f);
                instancePath.cubicTo(0.0f, 1.7908609f, 1.7908609f, 0.0f, 4.0f, 0.0f);
                instancePath.lineTo(44.0f, 0.0f);
                instancePath.cubicTo(46.20914f, 0.0f, 48.0f, 1.7908609f, 48.0f, 4.0f);
                instancePath.lineTo(48.0f, 44.0f);
                instancePath.cubicTo(48.0f, 46.20914f, 46.20914f, 48.0f, 44.0f, 48.0f);
                instancePath.lineTo(4.0f, 48.0f);
                instancePath.cubicTo(1.7908609f, 48.0f, 0.0f, 46.20914f, 0.0f, 44.0f);
                instancePath.lineTo(0.0f, 4.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-15683841);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 14.0f, 0.0f, 1.0f, 12.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.saveLayerAlpha(null, 204, 31);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(8.75f, 22.5f);
                instancePath2.lineTo(1.4833834f, 22.5f);
                instancePath2.cubicTo(1.217157f, 22.5f, 0.95788467f, 22.414997f, 0.7433345f, 22.257376f);
                instancePath2.cubicTo(0.18700047f, 21.848658f, 0.06733385f, 21.06633f, 0.4760516f, 20.509995f);
                instancePath2.lineTo(0.47601607f, 20.50997f);
                instancePath2.cubicTo(1.8253387f, 18.673313f, 2.5f, 16.836657f, 2.5f, 15.0f);
                instancePath2.lineTo(2.5f, 10.0f);
                instancePath2.cubicTo(2.5f, 6.72167f, 4.60339f, 3.9346135f, 7.534246f, 2.914754f);
                instancePath2.cubicTo(7.5117216f, 2.7798533f, 7.5f, 2.6412954f, 7.5f, 2.5f);
                instancePath2.cubicTo(7.5f, 1.1192881f, 8.619288f, 0.0f, 10.0f, 0.0f);
                instancePath2.cubicTo(11.380712f, 0.0f, 12.5f, 1.1192881f, 12.5f, 2.5f);
                instancePath2.cubicTo(12.5f, 2.6412954f, 12.488278f, 2.7798533f, 12.4657545f, 2.914754f);
                instancePath2.cubicTo(15.39661f, 3.9346135f, 17.5f, 6.72167f, 17.5f, 10.0f);
                instancePath2.lineTo(17.5f, 15.0f);
                instancePath2.cubicTo(17.5f, 16.836636f, 18.174646f, 18.673273f, 19.52394f, 20.509909f);
                instancePath2.cubicTo(19.68157f, 20.724472f, 19.766575f, 20.983759f, 19.766575f, 21.25f);
                instancePath2.cubicTo(19.766575f, 21.940376f, 19.206917f, 22.500036f, 18.51654f, 22.500036f);
                instancePath2.lineTo(11.25f, 22.5f);
                instancePath2.lineTo(11.25f, 22.75f);
                instancePath2.cubicTo(11.25f, 23.440355f, 10.690356f, 24.0f, 10.0f, 24.0f);
                instancePath2.cubicTo(9.309644f, 24.0f, 8.75f, 23.440355f, 8.75f, 22.75f);
                instancePath2.lineTo(8.75f, 22.5f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
