package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_fire_group extends c {
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
                instancePath.moveTo(11.400269f, 2.517334f);
                instancePath.cubicTo(13.169039f, 2.517334f, 14.561768f, 4.0047607f, 15.030518f, 5.4903564f);
                instancePath.cubicTo(15.552286f, 7.1439815f, 14.414429f, 8.989746f, 15.246948f, 9.6875f);
                instancePath.cubicTo(16.079468f, 10.385254f, 17.137695f, 9.151978f, 17.675499f, 8.222563f);
                instancePath.cubicTo(18.322906f, 9.388592f, 18.786436f, 10.688976f, 19.006195f, 12.058325f);
                instancePath.cubicTo(18.557396f, 11.419344f, 17.83005f, 11.0f, 17.0f, 11.0f);
                instancePath.cubicTo(15.622662f, 11.0f, 14.526316f, 12.156236f, 14.526316f, 13.555392f);
                instancePath.lineTo(14.526316f, 14.22028f);
                instancePath.lineTo(14.535017f, 14.425994f);
                instancePath.cubicTo(14.575209f, 14.916504f, 14.751698f, 15.472079f, 15.003282f, 15.913879f);
                instancePath.lineTo(15.026f, 15.95f);
                instancePath.lineTo(13.452537f, 16.762081f);
                instancePath.cubicTo(12.888078f, 17.052834f, 12.5f, 17.709015f, 12.5f, 18.344902f);
                instancePath.lineTo(12.5f, 18.61111f);
                instancePath.cubicTo(12.5f, 19.378174f, 13.121827f, 20.0f, 13.888889f, 20.0f);
                instancePath.lineTo(15.648956f, 20.000032f);
                instancePath.cubicTo(14.580757f, 20.635218f, 13.332978f, 21.0f, 12.0f, 21.0f);
                instancePath.cubicTo(8.051327f, 21.0f, 4.850294f, 17.798967f, 4.850294f, 13.850294f);
                instancePath.cubicTo(4.850294f, 10.704843f, 6.784547f, 8.523932f, 7.7323046f, 7.6888957f);
                instancePath.cubicTo(7.536916f, 8.592954f, 7.534505f, 10.416115f, 7.8944216f, 10.677346f);
                instancePath.cubicTo(7.898918f, 10.680611f, 7.910906f, 10.667218f, 7.9123416f, 10.657651f);
                instancePath.cubicTo(8.579097f, 6.2137914f, 12.5695505f, 5.1456676f, 11.400269f, 2.517334f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(WebView.NIGHT_MODE_COLOR);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(17.0f, 12.0f);
                instancePath2.cubicTo(17.813892f, 12.0f, 18.473684f, 12.69727f, 18.473684f, 13.555636f);
                instancePath2.lineTo(18.473684f, 14.220628f);
                instancePath2.cubicTo(18.473684f, 14.663615f, 18.252975f, 15.29889f, 17.982979f, 15.636723f);
                instancePath2.lineTo(17.849783f, 15.803385f);
                instancePath2.cubicTo(17.632591f, 16.075148f, 17.700438f, 16.421043f, 18.00415f, 16.577421f);
                instancePath2.lineTo(20.089542f, 17.651161f);
                instancePath2.cubicTo(20.316233f, 17.76788f, 20.5f, 18.076454f, 20.5f, 18.344902f);
                instancePath2.lineTo(20.5f, 18.61111f);
                instancePath2.cubicTo(20.5f, 18.825888f, 20.325888f, 19.0f, 20.11111f, 19.0f);
                instancePath2.lineTo(13.888889f, 19.0f);
                instancePath2.cubicTo(13.674111f, 19.0f, 13.5f, 18.825888f, 13.5f, 18.61111f);
                instancePath2.lineTo(13.5f, 18.344902f);
                instancePath2.cubicTo(13.5f, 18.07848f, 13.683529f, 17.767963f, 13.910457f, 17.651073f);
                instancePath2.lineTo(15.995851f, 16.576889f);
                instancePath2.cubicTo(16.298296f, 16.421099f, 16.368622f, 16.076046f, 16.150217f, 15.802804f);
                instancePath2.lineTo(16.017021f, 15.636165f);
                instancePath2.cubicTo(15.746012f, 15.297111f, 15.526316f, 14.663693f, 15.526316f, 14.22028f);
                instancePath2.lineTo(15.526316f, 13.555392f);
                instancePath2.cubicTo(15.526316f, 12.696373f, 16.187763f, 12.0f, 17.0f, 12.0f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
