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

public class wallet_wxcredit_open_card extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(13.0f, 37.996094f);
                instancePath.cubicTo(13.0f, 35.789112f, 14.782292f, 34.0f, 17.007507f, 34.0f);
                instancePath.lineTo(145.9925f, 34.0f);
                instancePath.cubicTo(148.20578f, 34.0f, 150.0f, 35.795326f, 150.0f, 37.996094f);
                instancePath.lineTo(150.0f, 123.00391f);
                instancePath.cubicTo(150.0f, 125.21089f, 148.21771f, 127.0f, 145.9925f, 127.0f);
                instancePath.lineTo(17.007507f, 127.0f);
                instancePath.cubicTo(14.794222f, 127.0f, 13.0f, 125.20467f, 13.0f, 123.00391f);
                instancePath.lineTo(13.0f, 37.996094f);
                instancePath.close();
                instancePath.moveTo(23.0f, 52.0f);
                instancePath.lineTo(140.0f, 52.0f);
                instancePath.lineTo(140.0f, 69.0f);
                instancePath.lineTo(23.0f, 69.0f);
                instancePath.lineTo(23.0f, 52.0f);
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 150.0f, 0.0f, 13.0f, 0.0f, 127.0f, 34.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                WeChatSVGRenderC2Java.setLinearGradient(instancePaint3, 0.5f, 0.0f, 0.5f, 1.0f, new int[]{-9919532, -10117428}, new float[]{0.0f, 1.0f}, instanceMatrix, 0);
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
