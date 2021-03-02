package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class chatfrom_voice_playing extends c {
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
                canvas.saveLayerAlpha(null, 230, 31);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, -1.0f, 0.0f, 72.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.restore();
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(42.834522f, 12.0f);
                instancePath.cubicTo(48.80635f, 18.142136f, 52.5f, 26.627417f, 52.5f, 36.0f);
                instancePath.cubicTo(52.5f, 45.37258f, 48.80635f, 53.857864f, 42.834522f, 60.0f);
                instancePath.lineTo(39.334347f, 56.4f);
                instancePath.cubicTo(44.410397f, 51.179184f, 47.55f, 43.966694f, 47.55f, 36.0f);
                instancePath.cubicTo(47.55f, 28.033304f, 44.410397f, 20.820816f, 39.334347f, 15.6f);
                instancePath.lineTo(42.834522f, 12.0f);
                instancePath.close();
                instancePath.moveTo(34.667442f, 20.4f);
                instancePath.cubicTo(38.549126f, 24.392387f, 40.95f, 29.907822f, 40.95f, 36.0f);
                instancePath.cubicTo(40.95f, 42.09218f, 38.549126f, 47.607613f, 34.667442f, 51.6f);
                instancePath.lineTo(31.167261f, 48.0f);
                instancePath.cubicTo(34.153175f, 44.928932f, 36.0f, 40.68629f, 36.0f, 36.0f);
                instancePath.cubicTo(36.0f, 31.31371f, 34.153175f, 27.071068f, 31.167261f, 24.0f);
                instancePath.lineTo(34.667442f, 20.4f);
                instancePath.close();
                instancePath.moveTo(26.500357f, 28.8f);
                instancePath.cubicTo(28.291904f, 30.642641f, 29.4f, 33.188225f, 29.4f, 36.0f);
                instancePath.cubicTo(29.4f, 38.811775f, 28.291904f, 41.35736f, 26.500357f, 43.2f);
                instancePath.lineTo(19.5f, 36.0f);
                instancePath.lineTo(26.500357f, 28.8f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
