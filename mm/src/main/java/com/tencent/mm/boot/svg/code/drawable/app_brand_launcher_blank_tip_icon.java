package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class app_brand_launcher_blank_tip_icon extends c {
    private final int height = 96;
    private final int width = 105;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 105;
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
                instancePaint3.setColor(-2565928);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -1303.0f, 0.0f, 1.0f, -1088.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(1363.0f, 1092.5238f);
                instancePath.cubicTo(1354.1088f, 1097.0039f, 1348.5f, 1105.5363f, 1348.0f, 1115.1428f);
                instancePath.lineTo(1348.0f, 1155.8572f);
                instancePath.cubicTo(1348.5f, 1163.0183f, 1341.4475f, 1168.9259f, 1333.0f, 1169.4286f);
                instancePath.cubicTo(1324.0508f, 1168.9259f, 1317.0f, 1163.0183f, 1316.5f, 1155.8572f);
                instancePath.cubicTo(1317.0f, 1150.5452f, 1320.5804f, 1146.0714f, 1325.5f, 1143.7937f);
                instancePath.cubicTo(1326.1508f, 1143.7598f, 1333.0f, 1140.7778f, 1334.5f, 1136.254f);
                instancePath.cubicTo(1335.7126f, 1132.5968f, 1331.5f, 1128.7142f, 1327.0f, 1128.7142f);
                instancePath.cubicTo(1322.5f, 1128.7142f, 1321.0f, 1130.2222f, 1318.0f, 1131.7301f);
                instancePath.cubicTo(1315.0f, 1133.2382f, 1310.4043f, 1136.4799f, 1306.0f, 1142.2858f);
                instancePath.cubicTo(1304.3615f, 1146.4514f, 1303.0f, 1150.9463f, 1303.0f, 1155.8572f);
                instancePath.cubicTo(1303.0f, 1170.7678f, 1316.3455f, 1183.0f, 1333.0f, 1183.0f);
                instancePath.cubicTo(1338.5372f, 1183.0f, 1343.9255f, 1181.4536f, 1348.0f, 1178.4762f);
                instancePath.cubicTo(1356.8912f, 1173.9961f, 1362.5f, 1165.4637f, 1363.0f, 1155.8572f);
                instancePath.lineTo(1363.0f, 1115.1428f);
                instancePath.cubicTo(1362.5f, 1107.9817f, 1369.5508f, 1102.0741f, 1378.0f, 1101.5714f);
                instancePath.cubicTo(1386.9475f, 1102.0741f, 1394.0f, 1107.9817f, 1394.5f, 1115.1428f);
                instancePath.cubicTo(1394.0f, 1120.6765f, 1388.5f, 1127.2063f, 1384.0f, 1128.7142f);
                instancePath.cubicTo(1379.5f, 1130.2222f, 1378.033f, 1131.1792f, 1376.5f, 1134.746f);
                instancePath.cubicTo(1375.3835f, 1138.496f, 1378.0f, 1142.2858f, 1384.0f, 1142.2858f);
                instancePath.cubicTo(1384.8744f, 1142.2858f, 1390.6953f, 1141.1154f, 1396.0f, 1137.7618f);
                instancePath.cubicTo(1399.7954f, 1135.3627f, 1403.1697f, 1131.1248f, 1405.0f, 1128.7142f);
                instancePath.cubicTo(1406.6385f, 1124.5504f, 1408.0f, 1120.0537f, 1408.0f, 1115.1428f);
                instancePath.cubicTo(1408.0f, 1100.2322f, 1394.6545f, 1088.0f, 1378.0f, 1088.0f);
                instancePath.cubicTo(1372.4628f, 1088.0f, 1367.0745f, 1089.5464f, 1363.0f, 1092.5238f);
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
