package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_othersticker extends c {
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
                instancePaint3.setColor(-436207616);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, -1.0f, 0.0f, 72.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(50.31325f, 22.40687f);
                instancePath.cubicTo(62.290512f, 22.40687f, 72.0f, 32.165524f, 72.0f, 44.203434f);
                instancePath.cubicTo(72.0f, 56.241344f, 62.290512f, 66.0f, 50.31325f, 66.0f);
                instancePath.cubicTo(38.335995f, 66.0f, 28.626507f, 56.241344f, 28.626507f, 44.203434f);
                instancePath.cubicTo(28.626507f, 32.165524f, 38.335995f, 22.40687f, 50.31325f, 22.40687f);
                instancePath.close();
                instancePath.moveTo(62.192337f, 46.38309f);
                instancePath.lineTo(38.434166f, 46.38309f);
                instancePath.cubicTo(38.982006f, 52.493214f, 44.091278f, 57.281376f, 50.31325f, 57.281376f);
                instancePath.cubicTo(56.53523f, 57.281376f, 61.6445f, 52.493214f, 62.192337f, 46.38309f);
                instancePath.close();
                instancePath.moveTo(21.69233f, 6.0f);
                instancePath.cubicTo(31.04894f, 6.0f, 39.021954f, 11.952352f, 42.06542f, 20.294064f);
                instancePath.cubicTo(36.864563f, 22.09134f, 32.427814f, 25.523762f, 29.368353f, 29.97634f);
                instancePath.lineTo(9.810186f, 29.976221f);
                instancePath.cubicTo(10.358166f, 36.08634f, 15.468755f, 40.874504f, 21.69233f, 40.874504f);
                instancePath.cubicTo(22.92106f, 40.874504f, 24.106407f, 40.687866f, 25.221823f, 40.341263f);
                instancePath.cubicTo(25.009867f, 41.66256f, 24.9f, 43.018448f, 24.9f, 44.4f);
                instancePath.cubicTo(24.9f, 46.069218f, 25.060385f, 47.700977f, 25.366583f, 49.28071f);
                instancePath.cubicTo(24.173265f, 49.486404f, 22.945202f, 49.59313f, 21.69233f, 49.59313f);
                instancePath.cubicTo(9.711987f, 49.59313f, 6.8176575E-12f, 39.834476f, 6.8176575E-12f, 27.796564f);
                instancePath.cubicTo(6.8176575E-12f, 15.758655f, 9.711987f, 6.0f, 21.69233f, 6.0f);
                instancePath.close();
                instancePath.moveTo(60.02931f, 31.474241f);
                instancePath.lineTo(53.167866f, 37.4388f);
                instancePath.lineTo(60.105164f, 42.47196f);
                instancePath.lineTo(61.816578f, 40.124016f);
                instancePath.lineTo(57.820366f, 37.222603f);
                instancePath.lineTo(61.926346f, 33.656532f);
                instancePath.lineTo(60.02931f, 31.474241f);
                instancePath.close();
                instancePath.moveTo(40.59324f, 31.471449f);
                instancePath.lineTo(38.6962f, 33.65374f);
                instancePath.lineTo(42.801544f, 37.21926f);
                instancePath.lineTo(38.80597f, 40.121223f);
                instancePath.lineTo(40.517384f, 42.469166f);
                instancePath.lineTo(47.45468f, 37.43601f);
                instancePath.lineTo(40.59324f, 31.471449f);
                instancePath.close();
                instancePath.moveTo(14.100015f, 17.988111f);
                instancePath.cubicTo(12.302963f, 17.988111f, 10.846165f, 19.451908f, 10.846165f, 21.257595f);
                instancePath.cubicTo(10.846165f, 23.063282f, 12.302963f, 24.52708f, 14.100015f, 24.52708f);
                instancePath.cubicTo(15.897066f, 24.52708f, 17.353865f, 23.063282f, 17.353865f, 21.257595f);
                instancePath.cubicTo(17.353865f, 19.451908f, 15.897066f, 17.988111f, 14.100015f, 17.988111f);
                instancePath.close();
                instancePath.moveTo(29.284645f, 17.988111f);
                instancePath.cubicTo(27.487595f, 17.988111f, 26.030796f, 19.451908f, 26.030796f, 21.257595f);
                instancePath.cubicTo(26.030796f, 23.063282f, 27.487595f, 24.52708f, 29.284645f, 24.52708f);
                instancePath.cubicTo(31.081697f, 24.52708f, 32.538494f, 23.063282f, 32.538494f, 21.257595f);
                instancePath.cubicTo(32.538494f, 19.451908f, 31.081697f, 17.988111f, 29.284645f, 17.988111f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
