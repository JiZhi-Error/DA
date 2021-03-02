package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class sns_finder_topic_icon_filled extends c {
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
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(10.38f, 3.0f);
                instancePath.lineTo(9.948f, 6.599f);
                instancePath.lineTo(15.348f, 6.599f);
                instancePath.lineTo(15.78f, 3.0f);
                instancePath.lineTo(18.48f, 3.0f);
                instancePath.lineTo(18.048f, 6.599f);
                instancePath.lineTo(21.0f, 6.6f);
                instancePath.lineTo(21.0f, 9.3f);
                instancePath.lineTo(17.724f, 9.299f);
                instancePath.lineTo(17.076f, 14.699f);
                instancePath.lineTo(21.0f, 14.7f);
                instancePath.lineTo(21.0f, 17.4f);
                instancePath.lineTo(16.752f, 17.399f);
                instancePath.lineTo(16.32f, 21.0f);
                instancePath.lineTo(13.62f, 21.0f);
                instancePath.lineTo(14.052f, 17.399f);
                instancePath.lineTo(8.652f, 17.399f);
                instancePath.lineTo(8.22f, 21.0f);
                instancePath.lineTo(5.52f, 21.0f);
                instancePath.lineTo(5.952f, 17.399f);
                instancePath.lineTo(3.0f, 17.4f);
                instancePath.lineTo(3.0f, 14.7f);
                instancePath.lineTo(6.276f, 14.699f);
                instancePath.lineTo(6.924f, 9.299f);
                instancePath.lineTo(3.0f, 9.3f);
                instancePath.lineTo(3.0f, 6.6f);
                instancePath.lineTo(7.248f, 6.599f);
                instancePath.lineTo(7.68f, 3.0f);
                instancePath.lineTo(10.38f, 3.0f);
                instancePath.close();
                instancePath.moveTo(14.376f, 14.699f);
                instancePath.lineTo(15.024f, 9.299f);
                instancePath.lineTo(9.624f, 9.299f);
                instancePath.lineTo(8.976f, 14.699f);
                instancePath.lineTo(14.376f, 14.699f);
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
