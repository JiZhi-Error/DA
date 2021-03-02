package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.smtt.sdk.WebView;

public class offline_info_icon extends c {
    private final int height = TbsListener.ErrorCode.STARTDOWNLOAD_6;
    private final int width = TbsListener.ErrorCode.STARTDOWNLOAD_6;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return TbsListener.ErrorCode.STARTDOWNLOAD_6;
            case 1:
                return TbsListener.ErrorCode.STARTDOWNLOAD_6;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                c.instanceMatrix(looper);
                c.instanceMatrixArray(looper);
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
                instancePaint3.setColor(-4671304);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(165.0f, 83.51852f);
                instancePath.cubicTo(165.0f, 36.935555f, 128.06444f, 0.0f, 81.48148f, 0.0f);
                instancePath.cubicTo(36.935555f, 0.0f, 0.0f, 36.935555f, 0.0f, 83.51852f);
                instancePath.cubicTo(0.0f, 128.06444f, 36.935555f, 165.0f, 81.48148f, 165.0f);
                instancePath.cubicTo(128.06444f, 165.0f, 165.0f, 128.06444f, 165.0f, 83.51852f);
                instancePath.close();
                instancePath.moveTo(156.0f, 83.40741f);
                instancePath.cubicTo(156.0f, 41.906223f, 123.09378f, 9.0f, 81.59259f, 9.0f);
                instancePath.cubicTo(41.906223f, 9.0f, 9.0f, 41.906223f, 9.0f, 83.40741f);
                instancePath.cubicTo(9.0f, 123.09378f, 41.906223f, 156.0f, 81.59259f, 156.0f);
                instancePath.cubicTo(123.09378f, 156.0f, 156.0f, 123.09378f, 156.0f, 83.40741f);
                instancePath.close();
                instancePath.moveTo(81.06782f, 123.30645f);
                instancePath.cubicTo(79.40914f, 123.30645f, 78.03121f, 121.96418f, 77.99018f, 120.31069f);
                instancePath.lineTo(76.660355f, 66.71527f);
                instancePath.cubicTo(76.6193f, 65.06076f, 77.919846f, 63.719513f, 79.586006f, 63.719513f);
                instancePath.lineTo(85.413994f, 63.719513f);
                instancePath.cubicTo(87.07084f, 63.719513f, 88.38068f, 65.06178f, 88.339645f, 66.71527f);
                instancePath.lineTo(87.00982f, 120.31069f);
                instancePath.cubicTo(86.968765f, 121.9652f, 85.58817f, 123.30645f, 83.93218f, 123.30645f);
                instancePath.lineTo(81.06782f, 123.30645f);
                instancePath.close();
                instancePath.moveTo(82.5f, 41.693546f);
                instancePath.cubicTo(86.41944f, 41.693546f, 89.59677f, 44.87088f, 89.59677f, 48.79032f);
                instancePath.cubicTo(89.59677f, 52.709763f, 86.41944f, 55.887096f, 82.5f, 55.887096f);
                instancePath.cubicTo(78.58056f, 55.887096f, 75.40323f, 52.709763f, 75.40323f, 48.79032f);
                instancePath.cubicTo(75.40323f, 44.87088f, 78.58056f, 41.693546f, 82.5f, 41.693546f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
