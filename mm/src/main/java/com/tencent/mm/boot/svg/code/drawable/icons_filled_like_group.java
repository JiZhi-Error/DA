package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_like_group extends c {
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
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(11.285586f, 5.7781744f);
                instancePath.lineTo(11.671766f, 6.155344f);
                instancePath.lineTo(11.992693f, 6.460254f);
                instancePath.lineTo(12.455042f, 6.018928f);
                instancePath.lineTo(12.6998005f, 5.7781744f);
                instancePath.cubicTo(14.652422f, 3.8255532f, 17.818247f, 3.8255532f, 19.770868f, 5.7781744f);
                instancePath.cubicTo(21.705326f, 7.7126327f, 21.72332f, 10.837829f, 19.82485f, 12.794439f);
                instancePath.lineTo(19.473f, 13.144709f);
                instancePath.lineTo(19.473684f, 12.555636f);
                instancePath.cubicTo(19.473684f, 11.156527f, 18.378468f, 10.0f, 17.0f, 10.0f);
                instancePath.cubicTo(15.622662f, 10.0f, 14.526316f, 11.156236f, 14.526316f, 12.555392f);
                instancePath.lineTo(14.526316f, 13.22028f);
                instancePath.lineTo(14.535017f, 13.425994f);
                instancePath.cubicTo(14.575209f, 13.916504f, 14.751698f, 14.472079f, 15.003282f, 14.913879f);
                instancePath.lineTo(15.026f, 14.95f);
                instancePath.lineTo(13.452537f, 15.76208f);
                instancePath.cubicTo(12.888078f, 16.052834f, 12.5f, 16.709015f, 12.5f, 17.344902f);
                instancePath.lineTo(12.5f, 17.61111f);
                instancePath.cubicTo(12.5f, 18.293787f, 12.992534f, 18.861423f, 13.641635f, 18.978056f);
                instancePath.lineTo(12.699763f, 19.920273f);
                instancePath.cubicTo(12.339333f, 20.28081f, 11.772105f, 20.308573f, 11.379798f, 20.003569f);
                instancePath.lineTo(11.285586f, 19.920311f);
                instancePath.lineTo(4.1601257f, 12.794849f);
                instancePath.cubicTo(2.2620664f, 10.837829f, 2.2800605f, 7.7126327f, 4.214519f, 5.7781744f);
                instancePath.cubicTo(6.1671405f, 3.8255532f, 9.332965f, 3.8255532f, 11.285586f, 5.7781744f);
                instancePath.close();
                instancePath.moveTo(17.0f, 11.0f);
                instancePath.cubicTo(17.813892f, 11.0f, 18.473684f, 11.69727f, 18.473684f, 12.555636f);
                instancePath.lineTo(18.473684f, 13.220628f);
                instancePath.cubicTo(18.473684f, 13.663615f, 18.252975f, 14.29889f, 17.982979f, 14.636723f);
                instancePath.lineTo(17.849783f, 14.803385f);
                instancePath.cubicTo(17.632591f, 15.075148f, 17.700438f, 15.421043f, 18.00415f, 15.57742f);
                instancePath.lineTo(20.089542f, 16.651161f);
                instancePath.cubicTo(20.316233f, 16.76788f, 20.5f, 17.076454f, 20.5f, 17.344902f);
                instancePath.lineTo(20.5f, 17.61111f);
                instancePath.cubicTo(20.5f, 17.825888f, 20.325888f, 18.0f, 20.11111f, 18.0f);
                instancePath.lineTo(13.888889f, 18.0f);
                instancePath.cubicTo(13.674111f, 18.0f, 13.5f, 17.825888f, 13.5f, 17.61111f);
                instancePath.lineTo(13.5f, 17.344902f);
                instancePath.cubicTo(13.5f, 17.07848f, 13.683529f, 16.767963f, 13.910457f, 16.651073f);
                instancePath.lineTo(15.995851f, 15.576889f);
                instancePath.cubicTo(16.298296f, 15.421099f, 16.368622f, 15.076047f, 16.150217f, 14.802804f);
                instancePath.lineTo(16.017021f, 14.636165f);
                instancePath.cubicTo(15.746012f, 14.297111f, 15.526316f, 13.663693f, 15.526316f, 13.22028f);
                instancePath.lineTo(15.526316f, 12.555392f);
                instancePath.cubicTo(15.526316f, 11.696373f, 16.187763f, 11.0f, 17.0f, 11.0f);
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
