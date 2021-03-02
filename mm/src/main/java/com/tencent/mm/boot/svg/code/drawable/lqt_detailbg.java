package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class lqt_detailbg extends c {
    private final int height = 1334;
    private final int width = 750;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 750;
            case 1:
                return 1334;
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
                instancePaint3.setColor(-870400);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(750.0f, 0.0f);
                instancePath.lineTo(750.0f, 1334.0f);
                instancePath.lineTo(0.0f, 1334.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-877312);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(68.52344f, 1334.0f);
                instancePath2.lineTo(849.0469f, 377.4297f);
                instancePath2.lineTo(5.891446E-14f, 199.80469f);
                instancePath2.lineTo(0.0f, 1334.0f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                canvas.saveLayerAlpha(null, 69, 31);
                Paint instancePaint6 = c.instancePaint(instancePaint5, looper);
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint6);
                canvas.restore();
                Paint instancePaint7 = c.instancePaint(instancePaint, looper);
                instancePaint7.setColor(-748799);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(801.0469f, 102.0f);
                instancePath3.lineTo(-62.109375f, 375.08594f);
                instancePath3.lineTo(-62.109375f, 657.77344f);
                instancePath3.lineTo(785.65625f, 1323.5469f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 1);
                canvas.saveLayerAlpha(null, 39, 31);
                Paint instancePaint8 = c.instancePaint(instancePaint7, looper);
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint8);
                canvas.restore();
                Paint instancePaint9 = c.instancePaint(instancePaint, looper);
                instancePaint9.setColor(-25344);
                Path instancePath4 = c.instancePath(looper);
                instancePath4.moveTo(-88.0f, 1217.8438f);
                instancePath4.lineTo(903.0781f, 1441.7344f);
                instancePath4.lineTo(855.39844f, 671.83594f);
                instancePath4.close();
                WeChatSVGRenderC2Java.setFillType(instancePath4, 1);
                canvas.saveLayerAlpha(null, 103, 31);
                Paint instancePaint10 = c.instancePaint(instancePaint9, looper);
                WeChatSVGRenderC2Java.setFillType(instancePath4, 2);
                canvas.drawPath(instancePath4, instancePaint10);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
