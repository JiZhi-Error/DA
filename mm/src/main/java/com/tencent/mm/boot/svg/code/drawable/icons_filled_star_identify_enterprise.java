package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_star_identify_enterprise extends c {
    private final int height = 72;
    private final int width = 72;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 72;
            case 1:
                return 72;
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
                instancePaint3.setColor(-15432210);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(49.13859f, 8.140941f);
                instancePath.lineTo(53.44235f, 18.53124f);
                instancePath.lineTo(63.834362f, 22.836712f);
                instancePath.cubicTo(64.912f, 23.283083f, 65.423744f, 24.518536f, 64.97737f, 25.596172f);
                instancePath.lineTo(60.672184f, 35.985615f);
                instancePath.lineTo(64.97737f, 46.37913f);
                instancePath.cubicTo(65.423744f, 47.456768f, 64.912f, 48.692223f, 63.834362f, 49.13859f);
                instancePath.lineTo(53.441765f, 53.441395f);
                instancePath.lineTo(49.13859f, 63.834362f);
                instancePath.cubicTo(48.692223f, 64.912f, 47.456768f, 65.423744f, 46.37913f, 64.97737f);
                instancePath.lineTo(35.98739f, 60.671234f);
                instancePath.lineTo(25.596172f, 64.97737f);
                instancePath.cubicTo(24.518536f, 65.423744f, 23.283083f, 64.912f, 22.836712f, 63.834362f);
                instancePath.lineTo(18.53161f, 53.44081f);
                instancePath.lineTo(8.140941f, 49.13859f);
                instancePath.cubicTo(7.063304f, 48.692223f, 6.551563f, 47.456768f, 6.9979343f, 46.37913f);
                instancePath.lineTo(11.301771f, 35.98644f);
                instancePath.lineTo(6.9979343f, 25.596172f);
                instancePath.cubicTo(6.551563f, 24.518536f, 7.063304f, 23.283083f, 8.140941f, 22.836712f);
                instancePath.lineTo(18.532192f, 18.530659f);
                instancePath.lineTo(22.836712f, 8.140941f);
                instancePath.cubicTo(23.283083f, 7.063304f, 24.518536f, 6.551563f, 25.596172f, 6.9979343f);
                instancePath.lineTo(35.98657f, 11.300819f);
                instancePath.lineTo(46.37913f, 6.9979343f);
                instancePath.cubicTo(47.456768f, 6.551563f, 48.692223f, 7.063304f, 49.13859f, 8.140941f);
                instancePath.close();
                instancePath.moveTo(49.26826f, 25.62f);
                instancePath.lineTo(32.47031f, 42.41795f);
                instancePath.lineTo(24.172613f, 34.12025f);
                instancePath.lineTo(21.0f, 37.292862f);
                instancePath.lineTo(31.119827f, 47.42001f);
                instancePath.lineTo(31.119827f, 47.42001f);
                instancePath.lineTo(31.24193f, 47.53261f);
                instancePath.cubicTo(31.996153f, 48.16834f, 33.124615f, 48.131176f, 33.834908f, 47.420784f);
                instancePath.lineTo(33.834908f, 47.420784f);
                instancePath.lineTo(52.455845f, 28.807583f);
                instancePath.lineTo(49.26826f, 25.62f);
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
