package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class ic_sex_male extends c {
    private final int height = 61;
    private final int width = 61;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 61;
            case 1:
                return 61;
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
                instancePaint3.setColor(-10970130);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(24.357143f, 31.267857f);
                instancePath.cubicTo(26.82522f, 35.67271f, 22.368435f, 37.603485f, 20.517857f, 38.94643f);
                instancePath.cubicTo(12.49915f, 43.23181f, 9.0f, 44.938072f, 9.0f, 46.625f);
                instancePath.lineTo(9.0f, 50.464287f);
                instancePath.cubicTo(9.0f, 51.156628f, 9.728162f, 52.0f, 10.535714f, 52.0f);
                instancePath.lineTo(50.464287f, 52.0f);
                instancePath.cubicTo(51.27184f, 52.0f, 52.0f, 51.156628f, 52.0f, 50.464287f);
                instancePath.lineTo(52.0f, 46.625f);
                instancePath.cubicTo(52.0f, 44.938072f, 48.50085f, 43.23181f, 40.482143f, 38.94643f);
                instancePath.cubicTo(38.631565f, 37.603485f, 34.17478f, 35.67271f, 36.642857f, 31.267857f);
                instancePath.cubicTo(39.24307f, 27.868282f, 41.103214f, 26.426222f, 41.25f, 20.517857f);
                instancePath.cubicTo(41.103214f, 14.887795f, 36.947693f, 9.0f, 30.5f, 9.0f);
                instancePath.cubicTo(24.052307f, 9.0f, 19.896786f, 14.887795f, 19.75f, 20.517857f);
                instancePath.cubicTo(19.896786f, 26.426222f, 21.756931f, 27.868282f, 24.357143f, 31.267857f);
                instancePath.close();
                instancePath.moveTo(30.714453f, 42.92168f);
                instancePath.cubicTo(26.309618f, 42.92168f, 23.007446f, 38.011597f, 23.007446f, 38.011597f);
                instancePath.cubicTo(23.007446f, 38.011597f, 24.622948f, 50.719337f, 30.714453f, 50.719337f);
                instancePath.cubicTo(36.805958f, 50.719337f, 38.079346f, 38.011597f, 38.079346f, 38.011597f);
                instancePath.cubicTo(38.079346f, 38.011597f, 35.11929f, 42.92168f, 30.714453f, 42.92168f);
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
