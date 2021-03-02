package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class app_attach_file_icon_pic extends c {
    private final int height = 90;
    private final int width = 90;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 90;
            case 1:
                return 90;
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
                instancePaint3.setColor(-855310);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(90.0f, 0.0f);
                instancePath.lineTo(90.0f, 90.0f);
                instancePath.lineTo(0.0f, 90.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(WebView.NIGHT_MODE_COLOR);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 21.0f, 0.0f, 1.0f, 27.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.saveLayerAlpha(null, 153, 31);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(44.0f, 21.962822f);
                instancePath2.lineTo(44.0f, 4.0f);
                instancePath2.lineTo(4.0f, 4.0f);
                instancePath2.lineTo(4.0f, 20.913124f);
                instancePath2.lineTo(14.878189f, 12.518221f);
                instancePath2.cubicTo(15.9883175f, 11.620444f, 17.771101f, 11.663985f, 18.841188f, 12.6042f);
                instancePath2.lineTo(29.616116f, 22.07142f);
                instancePath2.lineTo(35.061848f, 17.385994f);
                instancePath2.cubicTo(36.17116f, 16.44265f, 37.936134f, 16.461815f, 39.013035f, 17.428202f);
                instancePath2.lineTo(44.0f, 21.962822f);
                instancePath2.close();
                instancePath2.moveTo(44.0f, 29.16303f);
                instancePath2.lineTo(44.0f, 27.369196f);
                instancePath2.lineTo(36.995003f, 20.999496f);
                instancePath2.lineTo(32.650444f, 24.737488f);
                instancePath2.lineTo(34.997852f, 26.8f);
                instancePath2.lineTo(28.937702f, 26.8f);
                instancePath2.lineTo(16.771114f, 16.110018f);
                instancePath2.lineTo(4.0f, 25.965727f);
                instancePath2.lineTo(4.0f, 32.0f);
                instancePath2.lineTo(44.0f, 32.0f);
                instancePath2.lineTo(44.0f, 29.16303f);
                instancePath2.close();
                instancePath2.moveTo(-2.220446E-15f, 2.4f);
                instancePath2.cubicTo(-2.382771E-15f, 1.0745167f, 1.0745167f, 2.4348735E-16f, 2.4f, 0.0f);
                instancePath2.lineTo(45.6f, -2.220446E-15f);
                instancePath2.cubicTo(46.925484f, -2.4639335E-15f, 48.0f, 1.0745167f, 48.0f, 2.4f);
                instancePath2.lineTo(48.0f, 33.6f);
                instancePath2.cubicTo(48.0f, 34.925484f, 46.925484f, 36.0f, 45.6f, 36.0f);
                instancePath2.lineTo(2.4f, 36.0f);
                instancePath2.cubicTo(1.0745167f, 36.0f, 1.623249E-16f, 34.925484f, 0.0f, 33.6f);
                instancePath2.lineTo(-2.220446E-15f, 2.4f);
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
