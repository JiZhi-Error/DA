package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_duddle extends c {
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
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(72.0f, 0.0f);
                instancePath.lineTo(72.0f, 72.0f);
                instancePath.lineTo(0.0f, 72.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(44.430546f, 20.098555f);
                instancePath2.cubicTo(35.796257f, 22.485422f, 23.661943f, 32.74663f, 16.620869f, 46.05238f);
                instancePath2.lineTo(12.643434f, 43.94762f);
                instancePath2.cubicTo(20.245993f, 29.580816f, 33.361794f, 18.48963f, 43.231533f, 15.761231f);
                instancePath2.cubicTo(47.055542f, 14.704119f, 50.05951f, 15.430939f, 50.94257f, 18.308987f);
                instancePath2.cubicTo(51.626526f, 20.53812f, 50.546776f, 23.27621f, 48.298676f, 26.003262f);
                instancePath2.cubicTo(44.513027f, 30.595423f, 40.259773f, 37.587383f, 38.06009f, 42.7219f);
                instancePath2.cubicTo(37.80053f, 43.327766f, 37.57674f, 43.892372f, 37.3912f, 44.407986f);
                instancePath2.cubicTo(42.81765f, 40.3719f, 46.63874f, 38.876896f, 49.13517f, 40.479836f);
                instancePath2.cubicTo(51.517227f, 42.009335f, 51.378086f, 44.97728f, 49.62865f, 48.784992f);
                instancePath2.cubicTo(50.701393f, 48.220657f, 52.006596f, 47.471478f, 53.518982f, 46.542164f);
                instancePath2.lineTo(55.874874f, 50.37619f);
                instancePath2.cubicTo(51.87137f, 52.836224f, 49.154423f, 54.184273f, 47.411106f, 54.478592f);
                instancePath2.cubicTo(43.4441f, 55.14833f, 42.811646f, 51.909317f, 44.601807f, 48.72885f);
                instancePath2.cubicTo(45.55203f, 47.040653f, 46.138824f, 45.60154f, 46.326122f, 44.58755f);
                instancePath2.cubicTo(46.3457f, 44.481575f, 46.359947f, 44.385365f, 46.36971f, 44.29958f);
                instancePath2.cubicTo(45.48328f, 44.54977f, 42.980667f, 45.798183f, 39.469227f, 48.4765f);
                instancePath2.cubicTo(36.263023f, 50.922f, 33.275475f, 51.461197f, 32.392006f, 48.005173f);
                instancePath2.cubicTo(31.978731f, 46.388496f, 32.57282f, 44.103054f, 33.9237f, 40.949825f);
                instancePath2.cubicTo(36.29147f, 35.422955f, 40.768135f, 28.063726f, 44.826424f, 23.140837f);
                instancePath2.cubicTo(46.042713f, 21.665424f, 46.621895f, 20.39011f, 46.656567f, 19.821276f);
                instancePath2.cubicTo(46.21567f, 19.744463f, 45.457436f, 19.814678f, 44.430546f, 20.098555f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                canvas.drawPath(instancePath2, instancePaint3);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
