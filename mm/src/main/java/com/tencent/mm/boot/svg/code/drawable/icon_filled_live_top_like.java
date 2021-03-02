package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icon_filled_live_top_like extends c {
    private final int height = 16;
    private final int width = 16;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 16;
            case 1:
                return 16;
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
                instancePath.moveTo(12.856425f, 8.430063f);
                instancePath.cubicTo(13.81917f, 7.4378347f, 13.807932f, 5.854358f, 12.828903f, 4.8753295f);
                instancePath.cubicTo(11.839575f, 3.8860013f, 10.235558f, 3.8860013f, 9.246229f, 4.8753295f);
                instancePath.cubicTo(9.1180525f, 5.003506f, 8.955471f, 5.160333f, 8.757743f, 5.34663f);
                instancePath.lineTo(8.209139f, 5.863517f);
                instancePath.lineTo(7.6605353f, 5.34663f);
                instancePath.cubicTo(7.462807f, 5.160333f, 7.3002257f, 5.003506f, 7.172049f, 4.8753295f);
                instancePath.cubicTo(6.1827207f, 3.8860013f, 4.578703f, 3.8860013f, 3.5893748f, 4.8753295f);
                instancePath.cubicTo(2.610358f, 5.8543463f, 2.5990555f, 7.4379134f, 3.5531158f, 8.421745f);
                instancePath.lineTo(8.20911f, 13.077788f);
                instancePath.lineTo(12.856425f, 8.430063f);
                instancePath.close();
                instancePath.moveTo(3.0236893f, 4.309644f);
                instancePath.cubicTo(4.325437f, 3.0078964f, 6.435987f, 3.0078964f, 7.7377343f, 4.309644f);
                instancePath.cubicTo(7.859606f, 4.431515f, 8.016741f, 4.5830884f, 8.209139f, 4.764364f);
                instancePath.cubicTo(8.401538f, 4.5830884f, 8.558672f, 4.431515f, 8.680544f, 4.309644f);
                instancePath.cubicTo(9.982291f, 3.0078964f, 12.092841f, 3.0078964f, 13.394588f, 4.309644f);
                instancePath.cubicTo(14.684228f, 5.5992827f, 14.696223f, 7.682747f, 13.430577f, 8.987154f);
                instancePath.lineTo(8.680544f, 13.737735f);
                instancePath.cubicTo(8.420208f, 13.998097f, 7.9980974f, 13.998119f, 7.7377343f, 13.737783f);
                instancePath.lineTo(2.9874275f, 8.987428f);
                instancePath.cubicTo(1.7220542f, 7.682747f, 1.7340505f, 5.5992827f, 3.0236893f, 4.309644f);
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
