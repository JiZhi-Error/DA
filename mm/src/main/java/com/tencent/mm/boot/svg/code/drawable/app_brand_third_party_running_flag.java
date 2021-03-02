package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class app_brand_third_party_running_flag extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint2, looper);
                instancePaint3.setStrokeWidth(1.0f);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(16777215);
                instancePaint5.setColor(-1);
                instancePaint5.setStrokeWidth(1.2f);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(14.72445f, 3.0f);
                instancePath.cubicTo(16.5315f, 3.0f, 17.4348f, 3.0f, 18.40755f, 3.3075f);
                instancePath.cubicTo(19.46955f, 3.69405f, 20.30595f, 4.53045f, 20.6925f, 5.59245f);
                instancePath.cubicTo(21.0f, 6.56505f, 21.0f, 7.46865f, 21.0f, 9.27555f);
                instancePath.lineTo(21.0f, 14.72445f);
                instancePath.cubicTo(21.0f, 16.5315f, 21.0f, 17.4348f, 20.6925f, 18.40755f);
                instancePath.cubicTo(20.30595f, 19.46955f, 19.46955f, 20.30595f, 18.40755f, 20.69235f);
                instancePath.cubicTo(17.4348f, 21.0f, 16.5315f, 21.0f, 14.72445f, 21.0f);
                instancePath.lineTo(9.27555f, 21.0f);
                instancePath.cubicTo(7.4685f, 21.0f, 6.56505f, 21.0f, 5.59245f, 20.69235f);
                instancePath.cubicTo(4.53045f, 20.30595f, 3.69405f, 19.46955f, 3.3075f, 18.40755f);
                instancePath.cubicTo(3.0f, 17.4348f, 3.0f, 16.5315f, 3.0f, 14.72445f);
                instancePath.lineTo(3.0f, 9.27555f);
                instancePath.cubicTo(3.0f, 7.46865f, 3.0f, 6.56505f, 3.3075f, 5.59245f);
                instancePath.cubicTo(3.69405f, 4.53045f, 4.53045f, 3.69405f, 5.59245f, 3.3075f);
                instancePath.cubicTo(6.56505f, 3.0f, 7.4685f, 3.0f, 9.27555f, 3.0f);
                instancePath.lineTo(14.72445f, 3.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.drawPath(instancePath, instancePaint5);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
