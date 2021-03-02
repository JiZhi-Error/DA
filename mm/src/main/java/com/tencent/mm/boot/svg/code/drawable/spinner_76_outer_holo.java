package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class spinner_76_outer_holo extends c {
    private final int height = 228;
    private final int width = 228;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 228;
            case 1:
                return 228;
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
                canvas.saveLayerAlpha(null, 230, 31);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(114.0f, 0.0f);
                instancePath.cubicTo(176.96046f, 0.0f, 228.0f, 51.03954f, 228.0f, 114.0f);
                instancePath.cubicTo(228.0f, 176.96046f, 176.96046f, 228.0f, 114.0f, 228.0f);
                instancePath.lineTo(114.0f, 208.05f);
                instancePath.cubicTo(165.94238f, 208.05f, 208.05f, 165.94238f, 208.05f, 114.0f);
                instancePath.cubicTo(208.05f, 62.05762f, 165.94238f, 19.95f, 114.0f, 19.95f);
                instancePath.lineTo(114.0f, 0.0f);
                instancePath.close();
                Paint instancePaint4 = c.instancePaint(looper);
                instancePaint4.setFlags(385);
                instancePaint4.setStyle(Paint.Style.FILL);
                Paint instancePaint5 = c.instancePaint(looper);
                instancePaint5.setFlags(385);
                instancePaint5.setStyle(Paint.Style.STROKE);
                instancePaint4.setColor(WebView.NIGHT_MODE_COLOR);
                instancePaint5.setStrokeWidth(1.0f);
                instancePaint5.setStrokeCap(Paint.Cap.BUTT);
                instancePaint5.setStrokeJoin(Paint.Join.MITER);
                instancePaint5.setStrokeMiter(4.0f);
                instancePaint5.setPathEffect(null);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 228.0f, 0.0f, 114.0f, 0.0f, 228.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                WeChatSVGRenderC2Java.setLinearGradient(instancePaint3, 0.94086915f, 0.0f, 0.94086915f, 0.90559083f, new int[]{6316128, 1281384544}, new float[]{0.0f, 1.0f}, instanceMatrix, 0);
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(114.0f, 0.0f);
                instancePath2.lineTo(114.0f, 19.95f);
                instancePath2.cubicTo(62.05762f, 19.95f, 19.95f, 62.05762f, 19.95f, 114.0f);
                instancePath2.cubicTo(19.95f, 165.94238f, 62.05762f, 208.05f, 114.0f, 208.05f);
                instancePath2.lineTo(114.0f, 228.0f);
                instancePath2.cubicTo(51.03954f, 228.0f, 0.0f, 176.96046f, 0.0f, 114.0f);
                instancePath2.cubicTo(0.0f, 51.03954f, 51.03954f, 0.0f, 114.0f, 0.0f);
                instancePath2.close();
                Paint instancePaint7 = c.instancePaint(looper);
                instancePaint7.setFlags(385);
                instancePaint7.setStyle(Paint.Style.FILL);
                Paint instancePaint8 = c.instancePaint(looper);
                instancePaint8.setFlags(385);
                instancePaint8.setStyle(Paint.Style.STROKE);
                instancePaint7.setColor(WebView.NIGHT_MODE_COLOR);
                instancePaint8.setStrokeWidth(1.0f);
                instancePaint8.setStrokeCap(Paint.Cap.BUTT);
                instancePaint8.setStrokeJoin(Paint.Join.MITER);
                instancePaint8.setStrokeMiter(4.0f);
                instancePaint8.setPathEffect(null);
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 114.0f, 0.0f, 0.0f, 0.0f, 228.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                WeChatSVGRenderC2Java.setLinearGradient(instancePaint6, 1.0f, 0.08673706f, 1.0f, 0.9062866f, new int[]{-10461088, 1281384544}, new float[]{0.0f, 1.0f}, instanceMatrix, 0);
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint6);
                canvas.restore();
                canvas.save();
                Paint instancePaint9 = c.instancePaint(instancePaint, looper);
                instancePaint9.setColor(-10461088);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(115.425f, 0.0f);
                instancePath3.cubicTo(120.934044f, 0.0f, 125.4f, 4.4659595f, 125.4f, 9.975f);
                instancePath3.cubicTo(125.4f, 15.484041f, 120.934044f, 19.95f, 115.425f, 19.95f);
                instancePath3.cubicTo(109.91596f, 19.95f, 105.450005f, 15.484041f, 105.450005f, 9.975f);
                instancePath3.cubicTo(105.450005f, 4.4659595f, 109.91596f, 0.0f, 115.425f, 0.0f);
                instancePath3.close();
                canvas.drawPath(instancePath3, instancePaint9);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
