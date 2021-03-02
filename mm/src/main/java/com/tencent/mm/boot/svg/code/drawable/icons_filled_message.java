package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_message extends c {
    private final int height = 24;
    private final int width = 24;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 24;
            case 1:
                return 24;
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
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 0.70710677f, 0.70710677f, 3.5762787E-7f, -0.70710677f, 0.70710677f, 9.862136f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.6659409f, 1.4259619f);
                instancePath.cubicTo(0.9071914f, 0.9420684f, 1.4950367f, 0.7453674f, 1.9789302f, 0.986618f);
                instancePath.lineTo(1.9789302f, 0.986618f);
                instancePath.lineTo(18.15151f, 9.04964f);
                instancePath.cubicTo(18.341776f, 9.144499f, 18.495995f, 9.298717f, 18.590853f, 9.488983f);
                instancePath.cubicTo(18.832104f, 9.972877f, 18.635403f, 10.560722f, 18.15151f, 10.801972f);
                instancePath.lineTo(18.15151f, 10.801972f);
                instancePath.lineTo(1.9789302f, 18.864994f);
                instancePath.cubicTo(1.7611606f, 18.973566f, 1.5107632f, 18.997149f, 1.276552f, 18.931145f);
                instancePath.cubicTo(0.7561243f, 18.784483f, 0.45312768f, 18.2437f, 0.59979f, 17.723272f);
                instancePath.lineTo(0.59979f, 17.723272f);
                instancePath.lineTo(2.3948362f, 11.351548f);
                instancePath.lineTo(9.34992f, 10.574074f);
                instancePath.cubicTo(9.647224f, 10.540835f, 9.879302f, 10.31128f, 9.922745f, 10.023385f);
                instancePath.lineTo(9.93007f, 9.925448f);
                instancePath.cubicTo(9.93007f, 9.593053f, 9.680258f, 9.313755f, 9.34992f, 9.276823f);
                instancePath.lineTo(9.34992f, 9.276823f);
                instancePath.lineTo(2.3948362f, 8.4985485f);
                instancePath.lineTo(0.59979f, 2.1283402f);
                instancePath.cubicTo(0.54478717f, 1.9331641f, 0.55199695f, 1.7267476f, 0.6187588f, 1.5373397f);
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
