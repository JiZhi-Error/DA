package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class panel_icon_aa extends c {
    private final int height = 80;
    private final int width = 66;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 66;
            case 1:
                return 80;
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
                instancePaint3.setColor(-8617594);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -416.0f, 0.0f, 1.0f, -1269.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(482.0f, 1311.7202f);
                instancePath.lineTo(482.0f, 1271.9901f);
                instancePath.cubicTo(482.0f, 1270.3384f, 480.65353f, 1269.0f, 478.9926f, 1269.0f);
                instancePath.lineTo(419.0074f, 1269.0f);
                instancePath.cubicTo(417.3483f, 1269.0f, 416.0f, 1270.3387f, 416.0f, 1271.9901f);
                instancePath.lineTo(416.0f, 1346.0099f);
                instancePath.cubicTo(416.0f, 1347.6616f, 417.34647f, 1349.0f, 419.0074f, 1349.0f);
                instancePath.lineTo(478.9926f, 1349.0f);
                instancePath.cubicTo(480.6517f, 1349.0f, 482.0f, 1347.6613f, 482.0f, 1346.0099f);
                instancePath.lineTo(482.0f, 1316.9371f);
                instancePath.lineTo(449.52548f, 1336.6007f);
                instancePath.lineTo(449.2816f, 1336.748f);
                instancePath.cubicTo(448.97964f, 1336.9077f, 448.63965f, 1337.0f, 448.2788f, 1337.0f);
                instancePath.cubicTo(447.44376f, 1337.0f, 446.71753f, 1336.517f, 446.33582f, 1335.8048f);
                instancePath.lineTo(446.18982f, 1335.4691f);
                instancePath.lineTo(440.107f, 1321.471f);
                instancePath.cubicTo(440.0408f, 1321.3179f, 440.0f, 1321.1458f, 440.0f, 1320.9784f);
                instancePath.cubicTo(440.0f, 1320.3337f, 440.49866f, 1319.8098f, 441.1143f, 1319.8098f);
                instancePath.cubicTo(441.36453f, 1319.8098f, 441.59482f, 1319.8964f, 441.7807f, 1320.0417f);
                instancePath.lineTo(448.9588f, 1325.4017f);
                instancePath.cubicTo(449.48376f, 1325.7621f, 450.11026f, 1325.9731f, 450.78394f, 1325.9731f);
                instancePath.cubicTo(451.18558f, 1325.9731f, 451.5691f, 1325.8942f, 451.92633f, 1325.7583f);
                instancePath.lineTo(482.0f, 1311.7202f);
                instancePath.close();
                instancePath.moveTo(428.0f, 1294.5f);
                instancePath.lineTo(452.0f, 1294.5f);
                instancePath.lineTo(452.0f, 1299.0f);
                instancePath.lineTo(428.0f, 1299.0f);
                instancePath.lineTo(428.0f, 1294.5f);
                instancePath.close();
                instancePath.moveTo(428.0f, 1281.0f);
                instancePath.lineTo(452.0f, 1281.0f);
                instancePath.lineTo(452.0f, 1285.5f);
                instancePath.lineTo(428.0f, 1285.5f);
                instancePath.lineTo(428.0f, 1281.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
