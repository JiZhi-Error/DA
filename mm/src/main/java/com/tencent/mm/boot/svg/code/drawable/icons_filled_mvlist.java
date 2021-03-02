package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_mvlist extends c {
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
                instancePath.moveTo(15.75f, 14.685259f);
                instancePath.cubicTo(15.794264f, 14.685259f, 15.837733f, 14.697011f, 15.875968f, 14.719315f);
                instancePath.lineTo(21.129808f, 17.784056f);
                instancePath.cubicTo(21.249071f, 17.853626f, 21.289356f, 18.006704f, 21.219786f, 18.125967f);
                instancePath.cubicTo(21.198057f, 18.16322f, 21.16706f, 18.194216f, 21.129808f, 18.215944f);
                instancePath.lineTo(15.875968f, 21.280685f);
                instancePath.cubicTo(15.756704f, 21.350256f, 15.603625f, 21.30997f, 15.534056f, 21.190708f);
                instancePath.cubicTo(15.511752f, 21.152475f, 15.5f, 21.109005f, 15.5f, 21.064741f);
                instancePath.lineTo(15.5f, 14.935259f);
                instancePath.cubicTo(15.5f, 14.797188f, 15.611929f, 14.685259f, 15.75f, 14.685259f);
                instancePath.close();
                instancePath.moveTo(12.0f, 16.5f);
                instancePath.cubicTo(12.552284f, 16.5f, 13.0f, 16.947716f, 13.0f, 17.5f);
                instancePath.cubicTo(13.0f, 18.052284f, 12.552284f, 18.5f, 12.0f, 18.5f);
                instancePath.lineTo(4.0f, 18.5f);
                instancePath.cubicTo(3.4477153f, 18.5f, 3.0f, 18.052284f, 3.0f, 17.5f);
                instancePath.cubicTo(3.0f, 16.947716f, 3.4477153f, 16.5f, 4.0f, 16.5f);
                instancePath.lineTo(12.0f, 16.5f);
                instancePath.close();
                instancePath.moveTo(20.0f, 10.5f);
                instancePath.cubicTo(20.552284f, 10.5f, 21.0f, 10.947716f, 21.0f, 11.5f);
                instancePath.cubicTo(21.0f, 12.052284f, 20.552284f, 12.5f, 20.0f, 12.5f);
                instancePath.lineTo(4.0f, 12.5f);
                instancePath.cubicTo(3.4477153f, 12.5f, 3.0f, 12.052284f, 3.0f, 11.5f);
                instancePath.cubicTo(3.0f, 10.947716f, 3.4477153f, 10.5f, 4.0f, 10.5f);
                instancePath.lineTo(20.0f, 10.5f);
                instancePath.close();
                instancePath.moveTo(20.0f, 4.5f);
                instancePath.cubicTo(20.552284f, 4.5f, 21.0f, 4.9477153f, 21.0f, 5.5f);
                instancePath.cubicTo(21.0f, 6.0522847f, 20.552284f, 6.5f, 20.0f, 6.5f);
                instancePath.lineTo(4.0f, 6.5f);
                instancePath.cubicTo(3.4477153f, 6.5f, 3.0f, 6.0522847f, 3.0f, 5.5f);
                instancePath.cubicTo(3.0f, 4.9477153f, 3.4477153f, 4.5f, 4.0f, 4.5f);
                instancePath.lineTo(20.0f, 4.5f);
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
