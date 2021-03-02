package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.smtt.sdk.WebView;

public class connected_router_state_error extends c {
    private final int height = 240;
    private final int width = TbsListener.ErrorCode.TPATCH_BACKUP_NOT_VALID;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return TbsListener.ErrorCode.TPATCH_BACKUP_NOT_VALID;
            case 1:
                return 240;
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
                instancePaint3.setColor(-564640);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(220.0f, 121.234566f);
                instancePath.cubicTo(220.0f, 64.77037f, 175.22963f, 20.0f, 118.765434f, 20.0f);
                instancePath.cubicTo(64.77037f, 20.0f, 20.0f, 64.77037f, 20.0f, 121.234566f);
                instancePath.cubicTo(20.0f, 175.22963f, 64.77037f, 220.0f, 118.765434f, 220.0f);
                instancePath.cubicTo(175.22963f, 220.0f, 220.0f, 175.22963f, 220.0f, 121.234566f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-1);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(114.11689f, 70.98039f);
                instancePath2.cubicTo(111.951485f, 70.98039f, 110.27686f, 72.72528f, 110.37761f, 74.90139f);
                instancePath2.lineTo(113.37151f, 139.56976f);
                instancePath2.cubicTo(113.42262f, 140.6737f, 114.36253f, 141.56863f, 115.46362f, 141.56863f);
                instancePath2.lineTo(124.53638f, 141.56863f);
                instancePath2.cubicTo(125.64071f, 141.56863f, 126.57727f, 140.67613f, 126.62849f, 139.56976f);
                instancePath2.lineTo(129.62239f, 74.90139f);
                instancePath2.cubicTo(129.72266f, 72.73588f, 128.0466f, 70.98039f, 125.88311f, 70.98039f);
                instancePath2.lineTo(114.11689f, 70.98039f);
                instancePath2.close();
                instancePath2.moveTo(120.0f, 172.94118f);
                instancePath2.cubicTo(125.41456f, 172.94118f, 129.80392f, 168.5518f, 129.80392f, 163.13725f);
                instancePath2.cubicTo(129.80392f, 157.7227f, 125.41456f, 153.33333f, 120.0f, 153.33333f);
                instancePath2.cubicTo(114.58544f, 153.33333f, 110.196075f, 157.7227f, 110.196075f, 163.13725f);
                instancePath2.cubicTo(110.196075f, 168.5518f, 114.58544f, 172.94118f, 120.0f, 172.94118f);
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
