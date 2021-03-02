package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class lucky_money_topbar_bg extends c {
    private final int height = 450;
    private final int width = 1125;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 1125;
            case 1:
                return 450;
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
                instancePaint3.setColor(-830141);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(1125.0f, 0.0f);
                instancePath.lineTo(1125.0f, 450.0f);
                instancePath.lineTo(0.0f, 450.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-7503);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(935.0221f, 137.7136f);
                instancePath2.lineTo(922.7129f, 142.13159f);
                instancePath2.lineTo(927.98267f, 153.08679f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                canvas.saveLayerAlpha(null, 51, 31);
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                Paint instancePaint6 = c.instancePaint(instancePaint, looper);
                instancePaint6.setColor(-7503);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(361.60098f, 63.0f);
                instancePath3.cubicTo(356.8312f, 63.0f, 351.0058f, 70.35558f, 356.30338f, 74.58397f);
                instancePath3.cubicTo(361.60098f, 78.81235f, 366.37076f, 63.0f, 361.60098f, 63.0f);
                instancePath3.close();
                canvas.saveLayerAlpha(null, 51, 31);
                Paint instancePaint7 = c.instancePaint(instancePaint6, looper);
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint7);
                canvas.restore();
                Paint instancePaint8 = c.instancePaint(instancePaint, looper);
                instancePaint8.setColor(-2130713935);
                Path instancePath4 = c.instancePath(looper);
                instancePath4.moveTo(196.39885f, 372.45007f);
                instancePath4.cubicTo(191.62906f, 372.45007f, 185.80365f, 379.80566f, 191.10124f, 384.03406f);
                instancePath4.cubicTo(196.39885f, 388.26242f, 201.16862f, 372.45007f, 196.39885f, 372.45007f);
                instancePath4.close();
                canvas.saveLayerAlpha(null, 51, 31);
                Paint instancePaint9 = c.instancePaint(instancePaint8, looper);
                WeChatSVGRenderC2Java.setFillType(instancePath4, 2);
                canvas.drawPath(instancePath4, instancePaint9);
                canvas.restore();
                Paint instancePaint10 = c.instancePaint(instancePaint, looper);
                instancePaint10.setColor(-7503);
                Path instancePath5 = c.instancePath(looper);
                instancePath5.moveTo(331.1989f, 330.99368f);
                instancePath5.cubicTo(331.1989f, 330.99368f, 331.79904f, 337.22104f, 334.81866f, 340.22473f);
                instancePath5.cubicTo(337.8383f, 343.22842f, 336.03473f, 330.85147f, 336.03473f, 330.85147f);
                instancePath5.lineTo(331.1989f, 330.99368f);
                instancePath5.close();
                canvas.saveLayerAlpha(null, 51, 31);
                Paint instancePaint11 = c.instancePaint(instancePaint10, looper);
                WeChatSVGRenderC2Java.setFillType(instancePath5, 2);
                canvas.drawPath(instancePath5, instancePaint11);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
