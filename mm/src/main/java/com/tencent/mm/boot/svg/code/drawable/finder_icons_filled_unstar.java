package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class finder_icons_filled_unstar extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(15.363961f, 9.0f);
                instancePath.lineTo(28.024017f, 21.66f);
                instancePath.lineTo(33.30979f, 10.955829f);
                instancePath.cubicTo(34.04306f, 9.470068f, 35.841938f, 8.860051f, 37.327698f, 9.593318f);
                instancePath.cubicTo(37.919334f, 9.885308f, 38.398216f, 10.364191f, 38.69021f, 10.955829f);
                instancePath.lineTo(45.698456f, 25.156092f);
                instancePath.lineTo(61.369377f, 27.433208f);
                instancePath.cubicTo(63.00901f, 27.671463f, 64.14506f, 29.19379f, 63.906803f, 30.833426f);
                instancePath.cubicTo(63.811928f, 31.486336f, 63.504467f, 32.089764f, 63.032017f, 32.55029f);
                instancePath.lineTo(51.692432f, 43.603653f);
                instancePath.lineTo(52.048016f, 45.684f);
                instancePath.lineTo(66.27565f, 59.91169f);
                instancePath.lineTo(63.09367f, 63.09367f);
                instancePath.lineTo(12.18198f, 12.18198f);
                instancePath.lineTo(15.363961f, 9.0f);
                instancePath.close();
                instancePath.moveTo(19.744017f, 26.109858f);
                instancePath.lineTo(54.271202f, 60.630337f);
                instancePath.cubicTo(53.941036f, 61.66234f, 53.061417f, 62.479385f, 51.919655f, 62.675213f);
                instancePath.cubicTo(51.269382f, 62.786743f, 50.60048f, 62.680798f, 50.0165f, 62.37378f);
                instancePath.lineTo(36.0f, 55.00487f);
                instancePath.lineTo(21.983503f, 62.37378f);
                instancePath.cubicTo(20.51697f, 63.144783f, 18.703089f, 62.580944f, 17.932085f, 61.11441f);
                instancePath.cubicTo(17.625069f, 60.53043f, 17.519125f, 59.861523f, 17.630655f, 59.21125f);
                instancePath.lineTo(20.307568f, 43.603653f);
                instancePath.lineTo(8.967983f, 32.55029f);
                instancePath.cubicTo(7.781533f, 31.393785f, 7.7572556f, 29.494446f, 8.913759f, 28.307995f);
                instancePath.cubicTo(9.374285f, 27.835545f, 9.977713f, 27.528084f, 10.630624f, 27.433208f);
                instancePath.lineTo(19.744017f, 26.109858f);
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
