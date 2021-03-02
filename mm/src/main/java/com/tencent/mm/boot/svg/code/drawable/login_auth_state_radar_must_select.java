package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class login_auth_state_radar_must_select extends c {
    private final int height = 48;
    private final int width = 48;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 48;
            case 1:
                return 48;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 2.4f, 0.0f, 0.0f, 0.0f, 2.4f, 0.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                Paint instancePaint3 = c.instancePaint(instancePaint2, looper);
                instancePaint3.setStrokeWidth(1.0f);
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                Paint instancePaint6 = c.instancePaint(instancePaint3, looper);
                instancePaint5.setColor(201326592);
                instancePaint6.setColor(-3552823);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(19.5f, 10.123457f);
                instancePath.cubicTo(19.5f, 4.7531796f, 15.24682f, 0.5f, 9.876543f, 0.5f);
                instancePath.cubicTo(4.71725f, 0.5f, 0.5f, 4.789796f, 0.5f, 10.123457f);
                instancePath.cubicTo(0.5f, 15.24682f, 4.7531796f, 19.5f, 9.876543f, 19.5f);
                instancePath.cubicTo(15.210204f, 19.5f, 19.5f, 15.28275f, 19.5f, 10.123457f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint5);
                canvas.drawPath(instancePath, instancePaint6);
                canvas.restore();
                Paint instancePaint7 = c.instancePaint(instancePaint4, looper);
                instancePaint7.setColor(WebView.NIGHT_MODE_COLOR);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(5.456435f, 10.368831f);
                instancePath2.lineTo(5.506938f, 10.300112f);
                instancePath2.cubicTo(5.663359f, 10.087274f, 5.962703f, 10.041537f, 6.1755424f, 10.197958f);
                instancePath2.cubicTo(6.1781316f, 10.199862f, 6.1807017f, 10.201791f, 6.1832523f, 10.203745f);
                instancePath2.lineTo(8.341835f, 11.858175f);
                instancePath2.cubicTo(8.519238f, 11.994144f, 8.767159f, 11.989105f, 8.938891f, 11.846039f);
                instancePath2.lineTo(15.01762f, 6.7819657f);
                instancePath2.cubicTo(15.194826f, 6.634339f, 15.455153f, 6.645353f, 15.619257f, 6.8074207f);
                instancePath2.lineTo(15.619257f, 6.8074207f);
                instancePath2.cubicTo(15.776759f, 6.9629693f, 15.778342f, 7.2167473f, 15.622794f, 7.3742495f);
                instancePath2.cubicTo(15.621458f, 7.375602f, 15.620112f, 7.376945f, 15.618758f, 7.3782783f);
                instancePath2.lineTo(8.9890175f, 13.902933f);
                instancePath2.cubicTo(8.800759f, 14.088207f, 8.497951f, 14.085789f, 8.312676f, 13.897531f);
                instancePath2.cubicTo(8.311649f, 13.896486f, 8.310627f, 13.895438f, 8.309609f, 13.894385f);
                instancePath2.lineTo(5.497875f, 10.98438f);
                instancePath2.cubicTo(5.3358793f, 10.816722f, 5.318373f, 10.556688f, 5.456435f, 10.368831f);
                instancePath2.close();
                canvas.saveLayerAlpha(null, 76, 31);
                Paint instancePaint8 = c.instancePaint(instancePaint7, looper);
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint8);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
