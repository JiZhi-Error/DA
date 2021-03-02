package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class game_logo extends c {
    private final int height = 64;
    private final int width = 64;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 64;
            case 1:
                return 64;
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
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(64.0f, 0.0f);
                instancePath.lineTo(64.0f, 64.0f);
                instancePath.lineTo(0.0f, 64.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 14.0f, 0.0f, 1.0f, 14.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-15616);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(10.4624405f, 16.854254f);
                instancePath2.cubicTo(11.012562f, 13.594092f, 13.590585f, 11.023504f, 16.854254f, 10.484127f);
                instancePath2.lineTo(16.854254f, 1.0373106f);
                instancePath2.cubicTo(16.854254f, 0.46435454f, 16.389896f, 3.5527137E-14f, 15.817086f, 3.5527137E-14f);
                instancePath2.lineTo(15.572806f, 3.5527137E-14f);
                instancePath2.cubicTo(15.297821f, 3.5527137E-14f, 15.034029f, 0.10935776f, 14.839513f, 0.3038724f);
                instancePath2.lineTo(0.30372387f, 14.839531f);
                instancePath2.cubicTo(0.10920749f, 15.033894f, -4.1922021E-13f, 15.297835f, -4.1922021E-13f, 15.572818f);
                instancePath2.lineTo(-4.1922021E-13f, 15.817095f);
                instancePath2.cubicTo(-4.1922021E-13f, 16.3899f, 0.4643587f, 16.854254f, 1.0371686f, 16.854254f);
                instancePath2.lineTo(10.4624405f, 16.854254f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-15683841);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(19.101488f, 10.490272f);
                instancePath3.cubicTo(22.347433f, 11.043116f, 24.907736f, 13.606618f, 25.455734f, 16.854254f);
                instancePath3.lineTo(34.74585f, 16.854254f);
                instancePath3.cubicTo(35.413944f, 16.854254f, 35.95574f, 16.312603f, 35.95574f, 15.64435f);
                instancePath3.lineTo(35.95574f, 15.619847f);
                instancePath3.cubicTo(35.95574f, 15.299031f, 35.828236f, 14.991223f, 35.601353f, 14.764338f);
                instancePath3.lineTo(21.191387f, 0.35439494f);
                instancePath3.cubicTo(20.964502f, 0.12735832f, 20.656698f, 3.5527137E-14f, 20.335884f, 3.5527137E-14f);
                instancePath3.lineTo(20.311382f, 3.5527137E-14f);
                instancePath3.cubicTo(19.643135f, 3.5527137E-14f, 19.101488f, 0.54165095f, 19.101488f, 1.209904f);
                instancePath3.lineTo(19.101488f, 10.490272f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint, looper);
                instancePaint6.setColor(-372399);
                Path instancePath4 = c.instancePath(looper);
                instancePath4.moveTo(16.854254f, 25.485985f);
                instancePath4.cubicTo(13.585773f, 24.945852f, 11.005052f, 22.368458f, 10.460077f, 19.101488f);
                instancePath4.lineTo(1.2098931f, 19.101488f);
                instancePath4.cubicTo(0.5417974f, 19.101488f, -4.1922021E-13f, 19.643135f, -4.1922021E-13f, 20.311382f);
                instancePath4.lineTo(-4.1922021E-13f, 20.32212f);
                instancePath4.cubicTo(-4.1922021E-13f, 20.642933f, 0.12750843f, 20.950739f, 0.35439175f, 21.177622f);
                instancePath4.lineTo(14.778121f, 35.601353f);
                instancePath4.cubicTo(15.005004f, 35.828236f, 15.312809f, 35.95574f, 15.633622f, 35.95574f);
                instancePath4.lineTo(15.6443615f, 35.95574f);
                instancePath4.cubicTo(16.312609f, 35.95574f, 16.854254f, 35.413944f, 16.854254f, 34.74585f);
                instancePath4.lineTo(16.854254f, 25.485985f);
                instancePath4.close();
                WeChatSVGRenderC2Java.setFillType(instancePath4, 2);
                canvas.drawPath(instancePath4, instancePaint6);
                canvas.restore();
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint, looper);
                instancePaint7.setColor(-16268960);
                Path instancePath5 = c.instancePath(looper);
                instancePath5.moveTo(25.458155f, 19.101488f);
                instancePath5.cubicTo(24.915146f, 22.355904f, 22.352272f, 24.926037f, 19.101488f, 25.479784f);
                instancePath5.lineTo(19.101488f, 34.74585f);
                instancePath5.cubicTo(19.101488f, 35.413944f, 19.643135f, 35.95574f, 20.311382f, 35.95574f);
                instancePath5.lineTo(20.346624f, 35.95574f);
                instancePath5.cubicTo(20.667437f, 35.95574f, 20.975243f, 35.828236f, 21.202126f, 35.601353f);
                instancePath5.lineTo(35.601353f, 21.202126f);
                instancePath5.cubicTo(35.828236f, 20.975243f, 35.95574f, 20.667437f, 35.95574f, 20.346624f);
                instancePath5.lineTo(35.95574f, 20.311382f);
                instancePath5.cubicTo(35.95574f, 19.643135f, 35.413944f, 19.101488f, 34.74585f, 19.101488f);
                instancePath5.lineTo(25.458155f, 19.101488f);
                instancePath5.close();
                WeChatSVGRenderC2Java.setFillType(instancePath5, 2);
                canvas.drawPath(instancePath5, instancePaint7);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
