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

public class connect_icon_filetransfer_off_regular extends c {
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
                canvas.saveLayerAlpha(null, 128, 31);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 0.333333f, 0.0f, 1.0f, 0.333333f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-1);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.6666667f, 80.666664f);
                instancePath.cubicTo(0.6666667f, 36.554592f, 36.554333f, 0.6666667f, 80.666664f, 0.6666667f);
                instancePath.cubicTo(124.779f, 0.6666667f, 160.66667f, 36.554592f, 160.66667f, 80.666664f);
                instancePath.cubicTo(160.66667f, 124.77874f, 124.779f, 160.66667f, 80.666664f, 160.66667f);
                instancePath.cubicTo(36.554333f, 160.66667f, 0.6666667f, 124.77874f, 0.6666667f, 80.666664f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-11711155);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(106.666664f, 96.666664f);
                instancePath2.cubicTo(106.666664f, 101.28787f, 104.28978f, 103.666664f, 99.666664f, 103.666664f);
                instancePath2.lineTo(60.666668f, 103.666664f);
                instancePath2.cubicTo(56.043552f, 103.666664f, 53.666668f, 101.28787f, 53.666668f, 96.666664f);
                instancePath2.lineTo(53.666668f, 57.666668f);
                instancePath2.lineTo(71.666664f, 57.666668f);
                instancePath2.lineTo(77.666664f, 64.666664f);
                instancePath2.lineTo(106.666664f, 64.666664f);
                instancePath2.lineTo(106.666664f, 98.666664f);
                instancePath2.lineTo(106.666664f, 96.666664f);
                instancePath2.close();
                instancePath2.moveTo(79.666664f, 61.666668f);
                instancePath2.lineTo(73.666664f, 54.666668f);
                instancePath2.lineTo(53.666668f, 54.666668f);
                instancePath2.cubicTo(52.0857f, 54.666668f, 50.666668f, 56.086094f, 50.666668f, 57.666668f);
                instancePath2.lineTo(50.666668f, 96.666664f);
                instancePath2.cubicTo(50.666668f, 102.8492f, 54.57398f, 106.666664f, 60.666668f, 106.666664f);
                instancePath2.lineTo(99.666664f, 106.666664f);
                instancePath2.cubicTo(105.75935f, 106.666664f, 109.666664f, 102.8492f, 109.666664f, 96.666664f);
                instancePath2.lineTo(109.666664f, 64.666664f);
                instancePath2.cubicTo(109.666664f, 62.701645f, 108.24101f, 61.27891f, 106.666664f, 61.666668f);
                instancePath2.lineTo(79.666664f, 61.666668f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-11711155);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(59.666668f, 78.666664f);
                instancePath3.lineTo(100.666664f, 78.666664f);
                instancePath3.lineTo(100.666664f, 75.666664f);
                instancePath3.lineTo(59.666668f, 75.666664f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 1);
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint5);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
