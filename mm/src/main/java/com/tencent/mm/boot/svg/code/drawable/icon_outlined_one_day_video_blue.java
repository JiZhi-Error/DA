package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icon_outlined_one_day_video_blue extends c {
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
                instancePaint3.setColor(-15683841);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(53.062035f, 26.549711f);
                instancePath.cubicTo(52.459232f, 25.463072f, 52.85146f, 24.09351f, 53.938095f, 23.490705f);
                instancePath.cubicTo(55.024734f, 22.887901f, 56.3943f, 23.280127f, 56.997105f, 24.366766f);
                instancePath.cubicTo(62.150024f, 33.65563f, 60.592953f, 45.350697f, 52.970562f, 52.97309f);
                instancePath.cubicTo(43.59798f, 62.345673f, 28.40202f, 62.345673f, 19.029438f, 52.97309f);
                instancePath.cubicTo(9.656855f, 43.600506f, 9.656855f, 28.404547f, 19.029438f, 19.031963f);
                instancePath.cubicTo(26.651829f, 11.409573f, 38.346897f, 9.852504f, 47.63576f, 15.005424f);
                instancePath.cubicTo(48.7224f, 15.608228f, 49.114624f, 16.97779f, 48.51182f, 18.06443f);
                instancePath.cubicTo(47.90902f, 19.151068f, 46.539455f, 19.543295f, 45.452816f, 18.94049f);
                instancePath.cubicTo(37.908688f, 14.755447f, 28.404543f, 16.02082f, 22.211418f, 22.213943f);
                instancePath.cubicTo(14.596194f, 29.829168f, 14.596194f, 42.175884f, 22.211418f, 49.791107f);
                instancePath.cubicTo(29.826641f, 57.406334f, 42.17336f, 57.406334f, 49.78858f, 49.791107f);
                instancePath.cubicTo(55.98171f, 43.597984f, 57.247078f, 34.093838f, 53.062035f, 26.549711f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
