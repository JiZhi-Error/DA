package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class ofm_gamecenter_icon extends c {
    private final int height = 96;
    private final int width = 96;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                instancePaint3.setColor(-1);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 18.0f, 0.0f, 1.0f, 18.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(23.0f, 7.1054274E-15f);
                instancePath.cubicTo(25.038055f, -0.45212156f, 27.033388f, 0.8979728f, 27.0f, 3.0f);
                instancePath.cubicTo(27.103931f, 7.225281f, 26.91246f, 11.799481f, 27.0f, 16.0f);
                instancePath.cubicTo(21.813272f, 17.743927f, 17.741985f, 21.824436f, 16.0f, 27.0f);
                instancePath.cubicTo(11.786217f, 26.912477f, 7.211057f, 27.103909f, 3.0f, 27.0f);
                instancePath.cubicTo(0.28785312f, 27.073683f, -0.9718273f, 23.718597f, 1.0f, 22.0f);
                instancePath.cubicTo(7.190902f, 15.769161f, 13.7412405f, 9.502306f, 20.0f, 3.0f);
                instancePath.cubicTo(21.11793f, 1.9861085f, 22.105518f, 0.84759617f, 23.0f, 7.1054274E-15f);
                instancePath.lineTo(23.0f, 7.1054274E-15f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(33.0f, 3.0f);
                instancePath2.cubicTo(32.901676f, 0.26721036f, 36.287827f, -0.9631879f, 38.0f, 1.0f);
                instancePath2.cubicTo(44.89429f, 7.9521565f, 51.999157f, 15.062245f, 59.0f, 22.0f);
                instancePath2.cubicTo(60.98858f, 23.654861f, 59.73893f, 27.093925f, 57.0f, 27.0f);
                instancePath2.cubicTo(52.77515f, 27.104012f, 48.199818f, 26.912392f, 44.0f, 27.0f);
                instancePath2.cubicTo(42.2539f, 21.81935f, 38.182457f, 17.724747f, 33.0f, 16.0f);
                instancePath2.cubicTo(33.083076f, 11.784545f, 32.901676f, 7.2159348f, 33.0f, 3.0f);
                instancePath2.lineTo(33.0f, 3.0f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint3, looper);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(1.0f, 38.0f);
                instancePath3.cubicTo(-0.68084866f, 36.524372f, -0.106408045f, 33.78191f, 2.0f, 33.0f);
                instancePath3.cubicTo(6.655866f, 32.803898f, 11.513416f, 33.146706f, 16.0f, 33.0f);
                instancePath3.cubicTo(17.741562f, 38.187996f, 21.813036f, 42.281525f, 27.0f, 44.0f);
                instancePath3.cubicTo(26.912455f, 48.23025f, 27.103935f, 52.79766f, 27.0f, 57.0f);
                instancePath3.cubicTo(27.08378f, 59.724396f, 23.747993f, 60.94439f, 22.0f, 59.0f);
                instancePath3.cubicTo(15.121306f, 52.061634f, 7.98615f, 44.963493f, 1.0f, 38.0f);
                instancePath3.lineTo(1.0f, 38.0f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint6);
                canvas.restore();
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint3, looper);
                Path instancePath4 = c.instancePath(looper);
                instancePath4.moveTo(44.0f, 33.0f);
                instancePath4.cubicTo(48.478714f, 33.14441f, 53.31408f, 32.801533f, 58.0f, 33.0f);
                instancePath4.cubicTo(60.083588f, 33.71923f, 60.68801f, 36.482403f, 59.0f, 38.0f);
                instancePath4.cubicTo(52.03472f, 44.93327f, 44.902557f, 52.042892f, 38.0f, 59.0f);
                instancePath4.cubicTo(36.47089f, 60.655113f, 33.73085f, 60.100464f, 33.0f, 58.0f);
                instancePath4.cubicTo(32.804073f, 53.3438f, 33.146576f, 48.493122f, 33.0f, 44.0f);
                instancePath4.cubicTo(38.19349f, 42.270943f, 42.273327f, 38.196777f, 44.0f, 33.0f);
                instancePath4.lineTo(44.0f, 33.0f);
                instancePath4.close();
                WeChatSVGRenderC2Java.setFillType(instancePath4, 2);
                canvas.drawPath(instancePath4, instancePaint7);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
