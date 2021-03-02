package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class websearch_icon_acount extends c {
    private final int height = 14;
    private final int width = 16;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 16;
            case 1:
                return 14;
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
                instancePaint3.setColor(-5066062);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -265.0f, 0.0f, 1.0f, -604.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 66.0f, 0.0f, 1.0f, 602.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray3 = c.setMatrixFloatArray(matrixFloatArray2, 1.0f, 0.0f, 198.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray3);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(15.225f, 14.85f);
                instancePath.lineTo(15.225f, 14.486597f);
                instancePath.cubicTo(15.225f, 14.314545f, 15.04851f, 14.032515f, 14.894857f, 13.957565f);
                instancePath.lineTo(10.649592f, 11.88678f);
                instancePath.cubicTo(9.504656f, 11.328295f, 9.22168f, 9.977185f, 10.042003f, 9.004776f);
                instancePath.lineTo(10.313152f, 8.683356f);
                instancePath.cubicTo(10.726646f, 8.193201f, 11.1f, 7.173293f, 11.1f, 6.532639f);
                instancePath.lineTo(11.1f, 5.2501554f);
                instancePath.cubicTo(11.1f, 4.0911856f, 10.159192f, 3.15f, 9.0f, 3.15f);
                instancePath.cubicTo(7.8422318f, 3.15f, 6.9f, 4.091402f, 6.9f, 5.2496853f);
                instancePath.lineTo(6.9f, 6.531968f);
                instancePath.cubicTo(6.9f, 7.1742477f, 7.27181f, 8.190363f, 7.6868086f, 8.682234f);
                instancePath.lineTo(7.957958f, 9.00361f);
                instancePath.cubicTo(8.779977f, 9.977895f, 8.493911f, 11.327738f, 7.3505397f, 11.88569f);
                instancePath.lineTo(3.1052747f, 13.957333f);
                instancePath.cubicTo(2.9527628f, 14.031756f, 2.775f, 14.316507f, 2.775f, 14.486597f);
                instancePath.lineTo(2.775f, 14.85f);
                instancePath.lineTo(15.225f, 14.85f);
                instancePath.close();
                instancePath.moveTo(1.875f, 15.0f);
                instancePath.lineTo(1.875f, 14.486597f);
                instancePath.cubicTo(1.875f, 13.972781f, 2.248613f, 13.373931f, 2.7105732f, 13.1484995f);
                instancePath.lineTo(6.955838f, 11.076858f);
                instancePath.cubicTo(7.5715327f, 10.776405f, 7.7146945f, 10.110947f, 7.270084f, 9.58398f);
                instancePath.lineTo(6.9989347f, 9.262604f);
                instancePath.cubicTo(6.4472384f, 8.608714f, 6.0f, 7.387122f, 6.0f, 6.531968f);
                instancePath.lineTo(6.0f, 5.2496853f);
                instancePath.cubicTo(6.0f, 3.593005f, 7.346517f, 2.25f, 9.0f, 2.25f);
                instancePath.cubicTo(10.656855f, 2.25f, 12.0f, 3.5947351f, 12.0f, 5.2501554f);
                instancePath.lineTo(12.0f, 6.532639f);
                instancePath.cubicTo(12.0f, 7.386972f, 11.550699f, 8.612145f, 11.001065f, 9.2636795f);
                instancePath.lineTo(10.729916f, 9.585099f);
                instancePath.cubicTo(10.287774f, 10.109213f, 10.425891f, 10.7762985f, 11.044162f, 11.077883f);
                instancePath.lineTo(15.289427f, 13.148668f);
                instancePath.cubicTo(15.750901f, 13.37377f, 16.125f, 13.968878f, 16.125f, 14.486597f);
                instancePath.lineTo(16.125f, 15.0f);
                instancePath.cubicTo(16.125f, 15.414213f, 15.789213f, 15.75f, 15.375f, 15.75f);
                instancePath.lineTo(2.625f, 15.75f);
                instancePath.cubicTo(2.2107863f, 15.75f, 1.875f, 15.414213f, 1.875f, 15.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(8.25f, 13.5f);
                instancePath2.lineTo(9.0f, 11.25f);
                instancePath2.lineTo(9.75f, 13.5f);
                instancePath2.lineTo(9.0f, 14.25f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
