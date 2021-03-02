package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_ban_comment_off extends c {
    private final int height = 20;
    private final int width = 20;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 20;
            case 1:
                return 20;
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
                instancePaint3.setColor(-1);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(3.443095f, 5.2112093f);
                instancePath.lineTo(14.021553f, 15.788755f);
                instancePath.cubicTo(12.829179f, 16.348253f, 11.458336f, 16.666666f, 10.0f, 16.666666f);
                instancePath.cubicTo(9.1935835f, 16.666666f, 8.41392f, 16.569304f, 7.676393f, 16.387651f);
                instancePath.lineTo(7.3112116f, 16.289864f);
                instancePath.lineTo(4.8254175f, 17.481827f);
                instancePath.cubicTo(4.754461f, 17.515852f, 4.675319f, 17.529087f, 4.5971527f, 17.52f);
                instancePath.cubicTo(4.3971453f, 17.496752f, 4.246765f, 17.335484f, 4.2300954f, 17.1424f);
                instancePath.lineTo(4.2313824f, 17.058012f);
                instancePath.lineTo(4.4831305f, 14.892278f);
                instancePath.cubicTo(2.7558317f, 13.594444f, 1.6666666f, 11.697003f, 1.6666666f, 9.583333f);
                instancePath.cubicTo(1.6666666f, 7.9334235f, 2.3303175f, 6.415267f, 3.443095f, 5.2112093f);
                instancePath.close();
                instancePath.moveTo(3.767767f, 2.0f);
                instancePath.lineTo(5.4284077f, 3.6600688f);
                instancePath.cubicTo(6.7409525f, 2.926673f, 8.311856f, 2.5f, 10.0f, 2.5f);
                instancePath.cubicTo(14.602373f, 2.5f, 18.333334f, 5.671316f, 18.333334f, 9.583333f);
                instancePath.cubicTo(18.333334f, 11.43012f, 17.50185f, 13.1118355f, 16.139734f, 14.372758f);
                instancePath.lineTo(17.909903f, 16.142136f);
                instancePath.lineTo(17.02602f, 17.02602f);
                instancePath.lineTo(15.151068f, 15.151761f);
                instancePath.lineTo(2.8838835f, 2.8838835f);
                instancePath.lineTo(3.767767f, 2.0f);
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
