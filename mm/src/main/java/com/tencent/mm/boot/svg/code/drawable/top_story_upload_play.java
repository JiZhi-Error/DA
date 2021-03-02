package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class top_story_upload_play extends c {
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
                instancePaint3.setColor(-1);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -65.0f, 0.0f, 1.0f, -131.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 65.0f, 0.0f, 1.0f, 131.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(12.0f, 24.0f);
                instancePath.cubicTo(5.372583f, 24.0f, 0.0f, 18.627417f, 0.0f, 12.0f);
                instancePath.cubicTo(0.0f, 5.372583f, 5.372583f, 0.0f, 12.0f, 0.0f);
                instancePath.cubicTo(18.627417f, 0.0f, 24.0f, 5.372583f, 24.0f, 12.0f);
                instancePath.cubicTo(24.0f, 18.627417f, 18.627417f, 24.0f, 12.0f, 24.0f);
                instancePath.close();
                instancePath.moveTo(12.0f, 22.333334f);
                instancePath.cubicTo(17.706942f, 22.333334f, 22.333334f, 17.706942f, 22.333334f, 12.0f);
                instancePath.cubicTo(22.333334f, 6.2930574f, 17.706942f, 1.6666666f, 12.0f, 1.6666666f);
                instancePath.cubicTo(6.2930574f, 1.6666666f, 1.6666666f, 6.2930574f, 1.6666666f, 12.0f);
                instancePath.cubicTo(1.6666666f, 17.706942f, 6.2930574f, 22.333334f, 12.0f, 22.333334f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(13.666667f, 11.666667f);
                instancePath2.lineTo(13.666667f, 13.624764f);
                instancePath2.lineTo(13.666667f, 14.916196f);
                instancePath2.cubicTo(13.666667f, 15.154654f, 13.482121f, 15.333324f, 13.254474f, 15.333315f);
                instancePath2.lineTo(6.4121933f, 15.333003f);
                instancePath2.cubicTo(6.189514f, 15.332993f, 6.0f, 15.146587f, 6.0f, 14.916656f);
                instancePath2.lineTo(6.0f, 9.093866f);
                instancePath2.cubicTo(6.0f, 8.869545f, 6.184545f, 8.677277f, 6.4121933f, 8.676953f);
                instancePath2.lineTo(13.254474f, 8.667252f);
                instancePath2.cubicTo(13.477153f, 8.666935f, 13.666667f, 8.853425f, 13.666667f, 9.083804f);
                instancePath2.lineTo(13.666667f, 11.666667f);
                instancePath2.close();
                instancePath2.moveTo(14.666667f, 10.752296f);
                instancePath2.cubicTo(15.714527f, 9.888178f, 17.115644f, 8.891267f, 17.5f, 8.677538f);
                instancePath2.cubicTo(17.615805f, 8.618451f, 18.0f, 8.80178f, 18.0f, 9.189495f);
                instancePath2.lineTo(18.0f, 14.821027f);
                instancePath2.cubicTo(18.0f, 15.089015f, 17.652575f, 15.344082f, 17.5f, 15.332984f);
                instancePath2.cubicTo(17.179924f, 15.098051f, 15.743977f, 14.046944f, 14.666667f, 13.185655f);
                instancePath2.lineTo(14.666667f, 10.752296f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
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
