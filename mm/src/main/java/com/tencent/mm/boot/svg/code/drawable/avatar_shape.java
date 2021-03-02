package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class avatar_shape extends c {
    private final int height = 144;
    private final int width = 144;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 144;
            case 1:
                return 144;
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
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-2565928);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(122.59115f, 144.0f);
                instancePath.cubicTo(123.865486f, 144.0f, 125.139824f, 144.0f, 126.159294f, 144.0f);
                instancePath.cubicTo(127.433624f, 144.0f, 128.70796f, 144.0f, 129.72743f, 143.74513f);
                instancePath.cubicTo(131.00177f, 143.74513f, 132.27611f, 143.49026f, 133.29558f, 143.2354f);
                instancePath.cubicTo(134.56992f, 142.98053f, 135.58939f, 142.4708f, 136.86372f, 141.96106f);
                instancePath.cubicTo(137.88318f, 141.45132f, 138.90265f, 140.68672f, 139.92212f, 139.92212f);
                instancePath.cubicTo(140.68672f, 139.15752f, 141.45132f, 138.13805f, 141.96106f, 136.86372f);
                instancePath.cubicTo(142.4708f, 135.84425f, 142.98053f, 134.56992f, 143.2354f, 133.29558f);
                instancePath.cubicTo(143.49026f, 132.02124f, 143.74513f, 131.00177f, 143.74513f, 129.72743f);
                instancePath.cubicTo(143.74513f, 128.4531f, 144.0f, 127.178764f, 144.0f, 126.159294f);
                instancePath.cubicTo(144.0f, 124.88496f, 144.0f, 123.61062f, 144.0f, 122.59115f);
                instancePath.cubicTo(144.0f, 88.94867f, 144.0f, 55.051327f, 144.0f, 21.40885f);
                instancePath.cubicTo(144.0f, 20.134514f, 144.0f, 18.860176f, 144.0f, 17.840708f);
                instancePath.cubicTo(144.0f, 16.566372f, 144.0f, 15.292035f, 143.74513f, 14.272567f);
                instancePath.cubicTo(143.74513f, 12.99823f, 143.49026f, 11.723894f, 143.2354f, 10.704425f);
                instancePath.cubicTo(142.98053f, 9.430088f, 142.4708f, 8.41062f, 141.96106f, 7.1362834f);
                instancePath.cubicTo(141.45132f, 6.116814f, 140.68672f, 5.0973454f, 139.92212f, 4.077876f);
                instancePath.cubicTo(139.15752f, 3.3132744f, 138.13805f, 2.5486727f, 136.86372f, 2.038938f);
                instancePath.cubicTo(135.84425f, 1.5292035f, 134.56992f, 1.019469f, 133.29558f, 0.76460177f);
                instancePath.cubicTo(132.02124f, 0.5097345f, 131.00177f, 0.25486726f, 129.72743f, 0.25486726f);
                instancePath.cubicTo(128.4531f, 0.25486726f, 127.178764f, 0.0f, 126.159294f, 0.0f);
                instancePath.cubicTo(124.88496f, 0.0f, 123.61062f, 0.0f, 122.59115f, 0.0f);
                instancePath.cubicTo(88.94867f, 0.0f, 55.051327f, 0.0f, 21.40885f, 0.0f);
                instancePath.cubicTo(20.134514f, 0.0f, 18.860176f, 0.0f, 17.840708f, 0.0f);
                instancePath.cubicTo(16.566372f, 0.0f, 15.292035f, 0.0f, 14.272567f, 0.25486726f);
                instancePath.cubicTo(12.99823f, 0.25486726f, 11.723894f, 0.5097345f, 10.704425f, 0.76460177f);
                instancePath.cubicTo(9.430088f, 1.019469f, 8.41062f, 1.5292035f, 7.1362834f, 2.038938f);
                instancePath.cubicTo(6.116814f, 2.5486727f, 5.0973454f, 3.3132744f, 4.077876f, 4.077876f);
                instancePath.cubicTo(3.3132744f, 4.842478f, 2.5486727f, 5.861947f, 2.038938f, 7.1362834f);
                instancePath.cubicTo(1.5292035f, 8.155752f, 1.019469f, 9.430088f, 0.76460177f, 10.704425f);
                instancePath.cubicTo(0.5097345f, 11.978761f, 0.25486726f, 12.99823f, 0.25486726f, 14.272567f);
                instancePath.cubicTo(0.25486726f, 15.546903f, 0.0f, 16.82124f, 0.0f, 17.840708f);
                instancePath.cubicTo(0.0f, 19.115044f, 0.0f, 20.389381f, 0.0f, 21.40885f);
                instancePath.cubicTo(0.0f, 55.051327f, 0.0f, 88.94867f, 0.0f, 122.59115f);
                instancePath.cubicTo(0.0f, 123.865486f, 0.0f, 125.139824f, 0.0f, 126.159294f);
                instancePath.cubicTo(0.0f, 127.433624f, 0.0f, 128.70796f, 0.25486726f, 129.72743f);
                instancePath.cubicTo(0.25486726f, 131.00177f, 0.5097345f, 132.27611f, 0.76460177f, 133.29558f);
                instancePath.cubicTo(1.019469f, 134.56992f, 1.5292035f, 135.58939f, 2.038938f, 136.86372f);
                instancePath.cubicTo(2.5486727f, 137.88318f, 3.3132744f, 138.90265f, 4.077876f, 139.92212f);
                instancePath.cubicTo(4.842478f, 140.68672f, 5.861947f, 141.45132f, 7.1362834f, 141.96106f);
                instancePath.cubicTo(8.155752f, 142.4708f, 9.430088f, 142.98053f, 10.704425f, 143.2354f);
                instancePath.cubicTo(11.978761f, 143.49026f, 12.99823f, 143.74513f, 14.272567f, 143.74513f);
                instancePath.cubicTo(15.546903f, 143.74513f, 16.82124f, 144.0f, 17.840708f, 144.0f);
                instancePath.cubicTo(19.115044f, 144.0f, 20.389381f, 144.0f, 21.40885f, 144.0f);
                instancePath.cubicTo(55.051327f, 144.0f, 88.94867f, 144.0f, 122.59115f, 144.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
