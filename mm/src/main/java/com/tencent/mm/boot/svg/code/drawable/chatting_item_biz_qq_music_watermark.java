package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class chatting_item_biz_qq_music_watermark extends c {
    private final int height = 39;
    private final int width = 39;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 39;
            case 1:
                return 39;
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
                canvas.saveLayerAlpha(null, 128, 31);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-4210753);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -267.0f, 0.0f, 1.0f, -942.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(290.74658f, 962.3673f);
                instancePath.lineTo(281.66696f, 950.38226f);
                instancePath.cubicTo(281.66696f, 950.38226f, 280.0749f, 947.686f, 281.897f, 946.12305f);
                instancePath.cubicTo(285.0006f, 943.46094f, 288.86172f, 945.6186f, 292.41647f, 942.0f);
                instancePath.cubicTo(293.6008f, 943.90704f, 293.0603f, 947.8834f, 290.84427f, 948.8545f);
                instancePath.cubicTo(288.6282f, 949.82556f, 285.94733f, 949.9153f, 285.94733f, 949.9153f);
                instancePath.lineTo(295.2846f, 966.53125f);
                instancePath.lineTo(295.0269f, 966.30566f);
                instancePath.cubicTo(295.32394f, 967.01917f, 295.48572f, 967.7877f, 295.48572f, 968.5886f);
                instancePath.cubicTo(295.48572f, 972.3405f, 291.93597f, 975.38196f, 287.55713f, 975.38196f);
                instancePath.cubicTo(283.1783f, 975.38196f, 279.62857f, 972.3405f, 279.62857f, 968.5886f);
                instancePath.cubicTo(279.62857f, 964.8368f, 283.1783f, 961.7953f, 287.55713f, 961.7953f);
                instancePath.cubicTo(288.6917f, 961.7953f, 289.77066f, 961.9995f, 290.74658f, 962.3673f);
                instancePath.close();
                instancePath.moveTo(278.57144f, 946.18054f);
                instancePath.lineTo(278.57144f, 948.52997f);
                instancePath.cubicTo(273.52835f, 951.2919f, 270.1143f, 956.6069f, 270.1143f, 962.7102f);
                instancePath.cubicTo(270.1143f, 971.657f, 277.4504f, 978.9097f, 286.5f, 978.9097f);
                instancePath.cubicTo(295.5496f, 978.9097f, 302.8857f, 971.657f, 302.8857f, 962.7102f);
                instancePath.cubicTo(302.8857f, 957.0437f, 299.94287f, 952.0567f, 295.48572f, 949.1616f);
                instancePath.lineTo(295.48572f, 946.719f);
                instancePath.cubicTo(301.1608f, 949.8425f, 305.0f, 955.8331f, 305.0f, 962.7102f);
                instancePath.cubicTo(305.0f, 972.8114f, 296.71725f, 981.0f, 286.5f, 981.0f);
                instancePath.cubicTo(276.28275f, 981.0f, 268.0f, 972.8114f, 268.0f, 962.7102f);
                instancePath.cubicTo(268.0f, 955.4142f, 272.3212f, 949.11597f, 278.57144f, 946.18054f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
