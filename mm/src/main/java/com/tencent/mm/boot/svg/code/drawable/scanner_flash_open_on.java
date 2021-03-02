package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class scanner_flash_open_on extends c {
    private final int height = 32;
    private final int width = 24;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 24;
            case 1:
                return 32;
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
                instancePaint3.setColor(-419430401);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(15.5f, 13.0f);
                instancePath.cubicTo(16.052284f, 13.0f, 16.5f, 13.447716f, 16.5f, 14.0f);
                instancePath.lineTo(16.5f, 16.64922f);
                instancePath.cubicTo(16.5f, 16.876291f, 16.42272f, 17.096601f, 16.280869f, 17.273914f);
                instancePath.lineTo(14.719131f, 19.226086f);
                instancePath.cubicTo(14.577281f, 19.403399f, 14.5f, 19.623709f, 14.5f, 19.85078f);
                instancePath.lineTo(14.5f, 30.0f);
                instancePath.cubicTo(14.5f, 30.552284f, 14.052284f, 31.0f, 13.5f, 31.0f);
                instancePath.lineTo(10.5f, 31.0f);
                instancePath.cubicTo(9.947715f, 31.0f, 9.5f, 30.552284f, 9.5f, 30.0f);
                instancePath.lineTo(9.5f, 19.85078f);
                instancePath.cubicTo(9.5f, 19.623709f, 9.422719f, 19.403399f, 9.280869f, 19.226086f);
                instancePath.lineTo(7.719131f, 17.273914f);
                instancePath.cubicTo(7.5772805f, 17.096601f, 7.5f, 16.876291f, 7.5f, 16.64922f);
                instancePath.lineTo(7.5f, 14.0f);
                instancePath.cubicTo(7.5f, 13.447716f, 7.9477153f, 13.0f, 8.5f, 13.0f);
                instancePath.lineTo(15.5f, 13.0f);
                instancePath.close();
                instancePath.moveTo(12.0f, 19.0f);
                instancePath.cubicTo(11.620304f, 19.0f, 11.306509f, 19.282154f, 11.256846f, 19.64823f);
                instancePath.lineTo(11.25f, 19.75f);
                instancePath.lineTo(11.25f, 21.25f);
                instancePath.cubicTo(11.25f, 21.664213f, 11.585787f, 22.0f, 12.0f, 22.0f);
                instancePath.cubicTo(12.379696f, 22.0f, 12.693491f, 21.717846f, 12.743154f, 21.35177f);
                instancePath.lineTo(12.75f, 21.25f);
                instancePath.lineTo(12.75f, 19.75f);
                instancePath.cubicTo(12.75f, 19.335787f, 12.414213f, 19.0f, 12.0f, 19.0f);
                instancePath.close();
                instancePath.moveTo(15.9f, 11.0f);
                instancePath.cubicTo(16.23137f, 11.0f, 16.5f, 11.268629f, 16.5f, 11.6f);
                instancePath.cubicTo(16.5f, 11.931371f, 16.23137f, 12.2f, 15.9f, 12.2f);
                instancePath.lineTo(8.1f, 12.2f);
                instancePath.cubicTo(7.768629f, 12.2f, 7.5f, 11.931371f, 7.5f, 11.6f);
                instancePath.cubicTo(7.5f, 11.268629f, 7.768629f, 11.0f, 8.1f, 11.0f);
                instancePath.lineTo(15.9f, 11.0f);
                instancePath.close();
                instancePath.moveTo(19.311651f, 6.4393396f);
                instancePath.cubicTo(19.604544f, 6.732233f, 19.604544f, 7.2071066f, 19.311651f, 7.5f);
                instancePath.lineTo(18.25099f, 8.56066f);
                instancePath.cubicTo(17.958097f, 8.853554f, 17.483223f, 8.853554f, 17.19033f, 8.56066f);
                instancePath.cubicTo(16.897436f, 8.267767f, 16.897436f, 7.7928934f, 17.19033f, 7.5f);
                instancePath.lineTo(18.25099f, 6.4393396f);
                instancePath.cubicTo(18.543884f, 6.1464467f, 19.018757f, 6.1464467f, 19.311651f, 6.4393396f);
                instancePath.close();
                instancePath.moveTo(4.6893396f, 6.4393396f);
                instancePath.cubicTo(4.982233f, 6.1464467f, 5.4571066f, 6.1464467f, 5.75f, 6.4393396f);
                instancePath.lineTo(6.8106604f, 7.5f);
                instancePath.cubicTo(7.1035533f, 7.7928934f, 7.1035533f, 8.267767f, 6.8106604f, 8.56066f);
                instancePath.cubicTo(6.517767f, 8.853554f, 6.0428934f, 8.853554f, 5.75f, 8.56066f);
                instancePath.lineTo(4.6893396f, 7.5f);
                instancePath.cubicTo(4.3964467f, 7.2071066f, 4.3964467f, 6.732233f, 4.6893396f, 6.4393396f);
                instancePath.close();
                instancePath.moveTo(11.997767f, 3.5f);
                instancePath.cubicTo(12.411981f, 3.5f, 12.747767f, 3.8357863f, 12.747767f, 4.25f);
                instancePath.lineTo(12.747767f, 5.75f);
                instancePath.cubicTo(12.747767f, 6.1642137f, 12.411981f, 6.5f, 11.997767f, 6.5f);
                instancePath.cubicTo(11.583553f, 6.5f, 11.247767f, 6.1642137f, 11.247767f, 5.75f);
                instancePath.lineTo(11.247767f, 4.25f);
                instancePath.cubicTo(11.247767f, 3.8357863f, 11.583553f, 3.5f, 11.997767f, 3.5f);
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
