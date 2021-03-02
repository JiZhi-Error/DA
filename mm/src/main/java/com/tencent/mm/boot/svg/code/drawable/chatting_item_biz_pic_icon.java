package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class chatting_item_biz_pic_icon extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-1);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 2.0f, 0.0f, 1.0f, 3.5f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(18.55476f, 10.685851f);
                instancePath.lineTo(18.55476f, 1.9568864f);
                instancePath.lineTo(1.4761076f, 1.9568864f);
                instancePath.lineTo(1.4761076f, 10.368928f);
                instancePath.lineTo(6.1992455f, 6.5492587f);
                instancePath.cubicTo(6.661799f, 6.175185f, 7.4046254f, 6.193327f, 7.8504953f, 6.5850835f);
                instancePath.lineTo(12.326923f, 10.518227f);
                instancePath.lineTo(14.609102f, 8.5774975f);
                instancePath.cubicTo(15.071318f, 8.184438f, 15.806723f, 8.192423f, 16.255432f, 8.595083f);
                instancePath.lineTo(18.55476f, 10.685851f);
                instancePath.close();
                instancePath.moveTo(18.55476f, 12.52428f);
                instancePath.lineTo(15.40987f, 9.694547f);
                instancePath.lineTo(13.2216625f, 11.555364f);
                instancePath.lineTo(14.566126f, 12.736655f);
                instancePath.lineTo(12.794854f, 12.736655f);
                instancePath.lineTo(6.9897428f, 7.6767383f);
                instancePath.lineTo(1.4761076f, 12.135694f);
                instancePath.lineTo(1.4761076f, 15.028442f);
                instancePath.lineTo(18.55476f, 15.028442f);
                instancePath.lineTo(18.55476f, 12.52428f);
                instancePath.close();
                instancePath.moveTo(0.9918031f, 0.5f);
                instancePath.lineTo(19.008198f, 0.5f);
                instancePath.cubicTo(19.544695f, 0.5f, 20.0f, 0.981137f, 20.0f, 1.5746496f);
                instancePath.lineTo(20.0f, 15.42535f);
                instancePath.cubicTo(20.0f, 16.021152f, 19.555954f, 16.5f, 19.008198f, 16.5f);
                instancePath.lineTo(0.9918031f, 16.5f);
                instancePath.cubicTo(0.45530558f, 16.5f, 0.0f, 16.018864f, 0.0f, 15.42535f);
                instancePath.lineTo(0.0f, 1.5746496f);
                instancePath.cubicTo(0.0f, 0.9788482f, 0.44404536f, 0.5f, 0.9918031f, 0.5f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
