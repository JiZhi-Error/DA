package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.smtt.sdk.WebView;

public class connect_icon_lock_off_pressed extends c {
    private final int height = TbsListener.ErrorCode.STARTDOWNLOAD_3;
    private final int width = TbsListener.ErrorCode.STARTDOWNLOAD_3;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return TbsListener.ErrorCode.STARTDOWNLOAD_3;
            case 1:
                return TbsListener.ErrorCode.STARTDOWNLOAD_3;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 0.333333f, 0.0f, 1.0f, 0.222222f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.05f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-1);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.6666667f, 80.727776f);
                instancePath.cubicTo(0.6666667f, 36.615704f, 36.554333f, 0.7277778f, 80.666664f, 0.7277778f);
                instancePath.cubicTo(124.779f, 0.7277778f, 160.66667f, 36.615704f, 160.66667f, 80.727776f);
                instancePath.cubicTo(160.66667f, 124.83985f, 124.779f, 160.72778f, 80.666664f, 160.72778f);
                instancePath.cubicTo(36.554333f, 160.72778f, 0.6666667f, 124.83985f, 0.6666667f, 80.727776f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-16139513);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(94.666664f, 75.727776f);
                instancePath2.lineTo(94.666664f, 72.727776f);
                instancePath2.lineTo(94.666664f, 65.727776f);
                instancePath2.cubicTo(94.666664f, 57.59596f, 88.18667f, 50.72778f, 80.150536f, 50.72778f);
                instancePath2.lineTo(79.18279f, 50.72778f);
                instancePath2.cubicTo(71.13917f, 50.72778f, 64.666664f, 57.594822f, 64.666664f, 65.727776f);
                instancePath2.lineTo(64.666664f, 72.727776f);
                instancePath2.lineTo(64.666664f, 75.727776f);
                instancePath2.lineTo(94.666664f, 75.727776f);
                instancePath2.close();
                instancePath2.moveTo(67.666664f, 66.39445f);
                instancePath2.cubicTo(67.666664f, 59.320904f, 72.80921f, 53.72778f, 78.666664f, 53.72778f);
                instancePath2.lineTo(80.666664f, 53.72778f);
                instancePath2.cubicTo(86.524124f, 53.72778f, 91.666664f, 59.320904f, 91.666664f, 66.39445f);
                instancePath2.lineTo(91.666664f, 72.727776f);
                instancePath2.lineTo(67.666664f, 72.727776f);
                instancePath2.lineTo(67.666664f, 66.39445f);
                instancePath2.close();
                instancePath2.moveTo(94.666664f, 72.727776f);
                instancePath2.lineTo(94.666664f, 75.727776f);
                instancePath2.lineTo(101.666664f, 75.727776f);
                instancePath2.lineTo(101.666664f, 107.727776f);
                instancePath2.lineTo(57.666668f, 107.727776f);
                instancePath2.lineTo(57.666668f, 75.727776f);
                instancePath2.lineTo(64.666664f, 75.727776f);
                instancePath2.lineTo(64.666664f, 72.727776f);
                instancePath2.lineTo(57.666668f, 72.727776f);
                instancePath2.cubicTo(56.894035f, 72.88537f, 56.49158f, 73.059715f, 55.666668f, 73.727776f);
                instancePath2.cubicTo(55.42945f, 73.78284f, 54.912796f, 74.532776f, 54.666668f, 75.727776f);
                instancePath2.cubicTo(54.68995f, 75.62584f, 54.666668f, 107.727776f, 54.666668f, 107.727776f);
                instancePath2.cubicTo(54.666668f, 108.5316f, 55.248734f, 109.55201f, 55.666668f, 109.727776f);
                instancePath2.cubicTo(56.664536f, 110.51654f, 57.305363f, 110.727776f, 57.666668f, 110.727776f);
                instancePath2.lineTo(101.666664f, 110.727776f);
                instancePath2.cubicTo(103.168816f, 110.727776f, 104.666664f, 109.22566f, 104.666664f, 107.727776f);
                instancePath2.lineTo(104.666664f, 75.727776f);
                instancePath2.cubicTo(104.666664f, 74.228775f, 103.17769f, 72.727776f, 101.666664f, 72.727776f);
                instancePath2.lineTo(94.666664f, 72.727776f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
