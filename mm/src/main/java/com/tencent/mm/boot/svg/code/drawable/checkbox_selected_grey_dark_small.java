package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class checkbox_selected_grey_dark_small extends c {
    private final int height = 60;
    private final int width = 60;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 60;
            case 1:
                return 60;
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
                instancePaint3.setColor(-16631268);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(60.0f, 30.37037f);
                instancePath.cubicTo(60.0f, 13.431111f, 46.56889f, 0.0f, 29.62963f, 0.0f);
                instancePath.cubicTo(13.431111f, 0.0f, 0.0f, 13.431111f, 0.0f, 30.37037f);
                instancePath.cubicTo(0.0f, 46.56889f, 13.431111f, 60.0f, 29.62963f, 60.0f);
                instancePath.cubicTo(46.56889f, 60.0f, 60.0f, 46.56889f, 60.0f, 30.37037f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-1);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(25.909903f, 38.28427f);
                instancePath2.lineTo(17.65165f, 30.02602f);
                instancePath2.lineTo(15.0f, 32.67767f);
                instancePath2.lineTo(24.142136f, 41.819805f);
                instancePath2.cubicTo(25.118446f, 42.796116f, 26.701359f, 42.796116f, 27.67767f, 41.819805f);
                instancePath2.lineTo(46.845825f, 22.65165f);
                instancePath2.lineTo(46.845825f, 22.65165f);
                instancePath2.lineTo(44.19417f, 20.0f);
                instancePath2.lineTo(25.909903f, 38.28427f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
