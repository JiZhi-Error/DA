package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class app_brand_we_app_logo_share extends c {
    private final int height = 34;
    private final int width = 34;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 34;
            case 1:
                return 34;
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
                instancePaint3.setColor(-9074981);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -1316.0f, 0.0f, 1.0f, -1235.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(1336.0f, 1238.0f);
                instancePath.cubicTo(1333.0627f, 1239.8434f, 1331.3f, 1242.5377f, 1331.0f, 1246.0f);
                instancePath.lineTo(1331.0f, 1258.0f);
                instancePath.cubicTo(1331.3f, 1260.69f, 1329.0835f, 1262.5555f, 1326.0f, 1263.0f);
                instancePath.cubicTo(1323.616f, 1262.5555f, 1321.4f, 1260.69f, 1321.0f, 1258.0f);
                instancePath.cubicTo(1321.4f, 1256.7511f, 1322.0f, 1256.0f, 1324.0f, 1255.0f);
                instancePath.cubicTo(1326.0f, 1254.0f, 1326.4275f, 1253.3217f, 1327.0f, 1252.0f);
                instancePath.cubicTo(1327.2383f, 1251.0723f, 1326.3385f, 1249.9856f, 1325.0f, 1250.0f);
                instancePath.cubicTo(1324.3485f, 1249.9856f, 1323.9459f, 1250.0533f, 1324.0f, 1250.0f);
                instancePath.cubicTo(1321.2493f, 1250.845f, 1319.327f, 1252.3094f, 1318.0f, 1254.0f);
                instancePath.cubicTo(1317.4279f, 1255.4584f, 1317.0f, 1256.8778f, 1317.0f, 1258.0f);
                instancePath.cubicTo(1317.0f, 1263.1372f, 1321.1943f, 1267.0f, 1326.0f, 1267.0f);
                instancePath.cubicTo(1328.1688f, 1267.0f, 1329.8623f, 1266.5117f, 1331.0f, 1266.0f);
                instancePath.cubicTo(1333.9373f, 1264.1566f, 1335.7f, 1261.4623f, 1336.0f, 1258.0f);
                instancePath.lineTo(1336.0f, 1246.0f);
                instancePath.cubicTo(1335.7f, 1243.31f, 1337.9159f, 1241.4445f, 1341.0f, 1241.0f);
                instancePath.cubicTo(1343.3835f, 1241.4445f, 1345.6f, 1243.31f, 1346.0f, 1246.0f);
                instancePath.cubicTo(1345.6f, 1247.3188f, 1344.3795f, 1248.7866f, 1343.0f, 1249.0f);
                instancePath.cubicTo(1341.5052f, 1249.8116f, 1340.5818f, 1250.6356f, 1340.0f, 1252.0f);
                instancePath.cubicTo(1339.7491f, 1252.9462f, 1340.6445f, 1254.0283f, 1342.0f, 1254.0f);
                instancePath.cubicTo(1342.5894f, 1254.0283f, 1342.9523f, 1253.9661f, 1343.0f, 1254.0f);
                instancePath.cubicTo(1345.7672f, 1253.1422f, 1347.6779f, 1251.6823f, 1349.0f, 1250.0f);
                instancePath.cubicTo(1349.5721f, 1248.5422f, 1350.0f, 1247.1222f, 1350.0f, 1246.0f);
                instancePath.cubicTo(1350.0f, 1240.8628f, 1345.8057f, 1237.0f, 1341.0f, 1237.0f);
                instancePath.cubicTo(1338.8312f, 1237.0f, 1337.1377f, 1237.4883f, 1336.0f, 1238.0f);
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
