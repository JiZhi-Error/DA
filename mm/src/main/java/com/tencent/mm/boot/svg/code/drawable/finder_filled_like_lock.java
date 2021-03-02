package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class finder_filled_like_lock extends c {
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
                instancePaint3.setColor(-436207616);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(11.285586f, 5.464466f);
                instancePath.cubicTo(11.468393f, 5.6472726f, 11.704096f, 5.874633f, 11.992693f, 6.1465454f);
                instancePath.cubicTo(12.281291f, 5.874633f, 12.5169935f, 5.6472726f, 12.6998005f, 5.464466f);
                instancePath.cubicTo(14.652422f, 3.5118446f, 17.818247f, 3.5118446f, 19.770868f, 5.464466f);
                instancePath.cubicTo(21.705326f, 7.3989244f, 21.72332f, 10.52412f, 19.82485f, 12.480731f);
                instancePath.lineTo(19.676683f, 12.627813f);
                instancePath.cubicTo(19.085428f, 11.355511f, 17.983234f, 10.5f, 16.721153f, 10.5f);
                instancePath.cubicTo(15.3067665f, 10.5f, 14.093185f, 11.574452f, 13.57438f, 13.104225f);
                instancePath.cubicTo(12.694549f, 13.166085f, 12.0f, 13.899432f, 12.0f, 14.795f);
                instancePath.lineTo(12.0f, 14.795f);
                instancePath.lineTo(12.000716f, 19.8995f);
                instancePath.cubicTo(11.742132f, 19.901571f, 11.482896f, 19.803965f, 11.285586f, 19.606676f);
                instancePath.lineTo(4.1601257f, 12.481141f);
                instancePath.cubicTo(2.2620664f, 10.52412f, 2.2800605f, 7.3989244f, 4.214519f, 5.464466f);
                instancePath.cubicTo(6.1671405f, 3.5118446f, 9.332965f, 3.5118446f, 11.285586f, 5.464466f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-436207616);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(16.75f, 11.625f);
                instancePath2.cubicTo(17.992641f, 11.625f, 19.0f, 12.699516f, 19.0f, 14.025f);
                instancePath2.lineTo(19.0f, 14.25f);
                instancePath2.lineTo(19.753452f, 14.25f);
                instancePath2.cubicTo(20.165758f, 14.25f, 20.5f, 14.585024f, 20.5f, 14.996957f);
                instancePath2.lineTo(20.5f, 19.128044f);
                instancePath2.cubicTo(20.5f, 19.540577f, 20.15825f, 19.875f, 19.753452f, 19.875f);
                instancePath2.lineTo(13.746549f, 19.875f);
                instancePath2.cubicTo(13.334241f, 19.875f, 13.0f, 19.539976f, 13.0f, 19.128044f);
                instancePath2.lineTo(13.0f, 14.996957f);
                instancePath2.cubicTo(13.0f, 14.584424f, 13.341748f, 14.25f, 13.746549f, 14.25f);
                instancePath2.lineTo(14.5f, 14.25f);
                instancePath2.lineTo(14.5f, 14.025f);
                instancePath2.cubicTo(14.5f, 12.699516f, 15.5073595f, 11.625f, 16.75f, 11.625f);
                instancePath2.close();
                instancePath2.moveTo(16.75f, 12.525f);
                instancePath2.cubicTo(16.017862f, 12.525f, 15.4f, 13.184053f, 15.4f, 14.025f);
                instancePath2.lineTo(15.4f, 14.25f);
                instancePath2.lineTo(18.1f, 14.25f);
                instancePath2.lineTo(18.1f, 14.025f);
                instancePath2.cubicTo(18.1f, 13.184053f, 17.482138f, 12.525f, 16.75f, 12.525f);
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
