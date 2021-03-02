package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class album_group_icon_pressed extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-15028967);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(2.5f, 20.0f);
                instancePath.lineTo(2.5f, 19.315464f);
                instancePath.cubicTo(2.5f, 18.630375f, 2.9981508f, 17.831907f, 3.6140976f, 17.531332f);
                instancePath.lineTo(9.27445f, 14.769143f);
                instancePath.cubicTo(10.095377f, 14.36854f, 10.286259f, 13.481262f, 9.693445f, 12.778639f);
                instancePath.lineTo(9.331913f, 12.350138f);
                instancePath.cubicTo(8.596317f, 11.478285f, 8.0f, 9.849497f, 8.0f, 8.7092905f);
                instancePath.lineTo(8.0f, 6.9995804f);
                instancePath.cubicTo(8.0f, 4.7906733f, 9.795356f, 3.0f, 12.0f, 3.0f);
                instancePath.cubicTo(14.209139f, 3.0f, 16.0f, 4.79298f, 16.0f, 7.0002074f);
                instancePath.lineTo(16.0f, 8.710186f);
                instancePath.cubicTo(16.0f, 9.849296f, 15.400932f, 11.482861f, 14.668087f, 12.351573f);
                instancePath.lineTo(14.306555f, 12.780132f);
                instancePath.cubicTo(13.717032f, 13.4789505f, 13.901188f, 14.368398f, 14.725549f, 14.770511f);
                instancePath.lineTo(20.385902f, 17.531557f);
                instancePath.cubicTo(21.001202f, 17.831692f, 21.5f, 18.62517f, 21.5f, 19.315464f);
                instancePath.lineTo(21.5f, 20.0f);
                instancePath.cubicTo(21.5f, 20.552284f, 21.052284f, 21.0f, 20.5f, 21.0f);
                instancePath.lineTo(3.5f, 21.0f);
                instancePath.cubicTo(2.9477153f, 21.0f, 2.5f, 20.552284f, 2.5f, 20.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
