package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class finder_shop extends c {
    private final int height = 72;
    private final int width = 72;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 72;
            case 1:
                return 72;
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
                instancePaint3.setColor(-40634);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 9.0f, 0.0f, 1.0f, 6.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(22.3005f, -1.1368684E-13f);
                instancePath.cubicTo(27.31221f, -1.1368684E-13f, 31.6005f, 4.371098f, 31.6005f, 9.21f);
                instancePath.lineTo(31.6005f, 9.21f);
                instancePath.lineTo(31.6f, 14.997f);
                instancePath.lineTo(39.111f, 14.997f);
                instancePath.cubicTo(40.633446f, 14.997f, 41.905518f, 16.137575f, 42.088737f, 17.633821f);
                instancePath.lineTo(42.105f, 17.808f);
                instancePath.lineTo(42.864f, 29.707f);
                instancePath.lineTo(42.855f, 29.6976f);
                instancePath.cubicTo(26.95956f, 32.10924f, 14.824763f, 43.75048f, 14.583657f, 57.769073f);
                instancePath.lineTo(14.58f, 58.1946f);
                instancePath.cubicTo(14.58f, 58.641243f, 14.598532f, 59.110126f, 14.631631f, 59.613136f);
                instancePath.lineTo(14.659125f, 59.996983f);
                instancePath.lineTo(15.648098f, 59.997887f);
                instancePath.lineTo(3.0f, 59.997f);
                instancePath.cubicTo(1.341f, 59.997f, -5.5138116E-12f, 58.656f, -5.5138116E-12f, 56.997f);
                instancePath.lineTo(7.5E-4f, 56.9025f);
                instancePath.lineTo(7.5E-4f, 56.9025f);
                instancePath.lineTo(0.006f, 56.808f);
                instancePath.lineTo(2.496f, 17.808f);
                instancePath.cubicTo(2.5942223f, 16.285555f, 3.8135474f, 15.088593f, 5.315492f, 15.002017f);
                instancePath.lineTo(5.49f, 14.997f);
                instancePath.lineTo(13.0f, 14.997f);
                instancePath.lineTo(13.0005f, 9.21f);
                instancePath.cubicTo(13.0005f, 4.455991f, 17.139643f, 0.15351585f, 22.037413f, 0.0040150248f);
                instancePath.close();
                instancePath.moveTo(43.206158f, 35.06746f);
                instancePath.lineTo(44.595f, 56.808f);
                instancePath.cubicTo(44.7f, 58.458f, 43.446f, 59.886f, 41.796f, 59.991f);
                instancePath.lineTo(41.6985f, 59.99625f);
                instancePath.lineTo(41.6985f, 59.99625f);
                instancePath.lineTo(41.601f, 59.997f);
                instancePath.lineTo(15.648098f, 59.997887f);
                instancePath.cubicTo(17.094872f, 47.371365f, 28.654066f, 37.223835f, 43.206158f, 35.06746f);
                instancePath.close();
                instancePath.moveTo(22.3005f, 3.6f);
                instancePath.cubicTo(19.29259f, 3.6f, 16.6005f, 6.3440742f, 16.6005f, 9.21f);
                instancePath.lineTo(16.6005f, 9.21f);
                instancePath.lineTo(16.6f, 14.997f);
                instancePath.lineTo(28.0f, 14.997f);
                instancePath.lineTo(28.0005f, 9.21f);
                instancePath.cubicTo(28.0005f, 6.4107237f, 25.432169f, 3.7276974f, 22.509811f, 3.6044192f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(58.1865f, 28.5699f);
                instancePath2.lineTo(58.2735f, 28.5429f);
                instancePath2.cubicTo(59.0145f, 28.3209f, 59.4975f, 27.7149f, 59.4975f, 26.9979f);
                instancePath2.cubicTo(59.4975f, 26.2749f, 59.0145f, 25.6689f, 58.2825f, 25.4529f);
                instancePath2.lineTo(58.1865f, 25.4229f);
                instancePath2.cubicTo(54.0705f, 24.2979f, 53.6715f, 20.3439f, 53.6295f, 19.5189f);
                instancePath2.cubicTo(53.5755f, 18.6519f, 52.8735f, 17.9979f, 51.9975f, 17.9979f);
                instancePath2.cubicTo(51.1215f, 17.9979f, 50.4195f, 18.6519f, 50.3625f, 19.5609f);
                instancePath2.cubicTo(50.3265f, 20.3439f, 49.9275f, 24.2979f, 45.8325f, 25.4169f);
                instancePath2.lineTo(45.7275f, 25.4469f);
                instancePath2.cubicTo(44.9805f, 25.6689f, 44.5005f, 26.2749f, 44.5005f, 26.9979f);
                instancePath2.cubicTo(44.5005f, 27.7149f, 44.9805f, 28.3209f, 45.7425f, 28.5489f);
                instancePath2.lineTo(45.8085f, 28.5699f);
                instancePath2.cubicTo(49.9275f, 29.6949f, 50.3265f, 33.6489f, 50.3655f, 34.4709f);
                instancePath2.cubicTo(50.4195f, 35.3409f, 51.1215f, 35.9979f, 51.9975f, 35.9979f);
                instancePath2.cubicTo(52.8735f, 35.9979f, 53.5755f, 35.3409f, 53.6325f, 34.4319f);
                instancePath2.cubicTo(53.6715f, 33.6489f, 54.0705f, 29.6949f, 58.1865f, 28.5699f);
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
