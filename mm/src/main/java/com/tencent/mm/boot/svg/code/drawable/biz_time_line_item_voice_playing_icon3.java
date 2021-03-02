package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class biz_time_line_item_voice_playing_icon3 extends c {
    private final int height = 44;
    private final int width = 44;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 44;
            case 1:
                return 44;
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
                Paint instancePaint3 = c.instancePaint(instancePaint2, looper);
                instancePaint3.setStrokeWidth(1.0f);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(-16339370);
                instancePaint4.setStrokeWidth(1.2f);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(22.594595f, 43.4f);
                instancePath.cubicTo(33.818893f, 43.4f, 43.4f, 33.818893f, 43.4f, 22.594595f);
                instancePath.cubicTo(43.4f, 10.363577f, 33.99429f, 0.6f, 22.594595f, 0.6f);
                instancePath.cubicTo(10.181107f, 0.6f, 0.6f, 10.181107f, 0.6f, 22.594595f);
                instancePath.cubicTo(0.6f, 33.99429f, 10.363577f, 43.4f, 22.594595f, 43.4f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-16268960);
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint5, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(23.815264f, 31.186165f);
                instancePath2.cubicTo(26.139557f, 28.861872f, 27.466667f, 25.724232f, 27.466667f, 22.3709f);
                instancePath2.cubicTo(27.466667f, 19.017567f, 26.139557f, 15.879927f, 23.815264f, 13.5556345f);
                instancePath2.lineTo(25.3709f, 12.0f);
                instancePath2.cubicTo(28.025043f, 14.654144f, 29.666666f, 18.320812f, 29.666666f, 22.3709f);
                instancePath2.cubicTo(29.666666f, 26.420988f, 28.025043f, 30.087654f, 25.3709f, 32.7418f);
                instancePath2.lineTo(23.815264f, 31.186165f);
                instancePath2.close();
                instancePath2.moveTo(20.18545f, 27.556349f);
                instancePath2.cubicTo(21.553268f, 26.18853f, 22.333334f, 24.34425f, 22.333334f, 22.3709f);
                instancePath2.cubicTo(22.333334f, 20.397549f, 21.553268f, 18.553268f, 20.18545f, 17.18545f);
                instancePath2.lineTo(21.741085f, 15.629815f);
                instancePath2.cubicTo(23.466278f, 17.35501f, 24.533333f, 19.738342f, 24.533333f, 22.3709f);
                instancePath2.cubicTo(24.533333f, 25.003456f, 23.466278f, 27.38679f, 21.741085f, 29.111984f);
                instancePath2.lineTo(20.18545f, 27.556349f);
                instancePath2.close();
                instancePath2.moveTo(18.111269f, 25.48217f);
                instancePath2.lineTo(15.0f, 22.3709f);
                instancePath2.lineTo(18.111269f, 19.25963f);
                instancePath2.cubicTo(18.907513f, 20.055874f, 19.4f, 21.155872f, 19.4f, 22.3709f);
                instancePath2.cubicTo(19.4f, 23.585926f, 18.907513f, 24.685926f, 18.111269f, 25.48217f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint6);
                canvas.restore();
                Paint instancePaint7 = c.instancePaint(instancePaint, looper);
                instancePaint7.setColor(419430400);
                canvas.save();
                Paint instancePaint8 = c.instancePaint(instancePaint7, looper);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(23.815264f, 31.186165f);
                instancePath3.cubicTo(26.139557f, 28.861872f, 27.466667f, 25.724232f, 27.466667f, 22.3709f);
                instancePath3.cubicTo(27.466667f, 19.017567f, 26.139557f, 15.879927f, 23.815264f, 13.5556345f);
                instancePath3.lineTo(25.3709f, 12.0f);
                instancePath3.cubicTo(28.025043f, 14.654144f, 29.666666f, 18.320812f, 29.666666f, 22.3709f);
                instancePath3.cubicTo(29.666666f, 26.420988f, 28.025043f, 30.087654f, 25.3709f, 32.7418f);
                instancePath3.lineTo(23.815264f, 31.186165f);
                instancePath3.close();
                instancePath3.moveTo(20.18545f, 27.556349f);
                instancePath3.cubicTo(21.553268f, 26.18853f, 22.333334f, 24.34425f, 22.333334f, 22.3709f);
                instancePath3.cubicTo(22.333334f, 20.397549f, 21.553268f, 18.553268f, 20.18545f, 17.18545f);
                instancePath3.lineTo(21.741085f, 15.629815f);
                instancePath3.cubicTo(23.466278f, 17.35501f, 24.533333f, 19.738342f, 24.533333f, 22.3709f);
                instancePath3.cubicTo(24.533333f, 25.003456f, 23.466278f, 27.38679f, 21.741085f, 29.111984f);
                instancePath3.lineTo(20.18545f, 27.556349f);
                instancePath3.close();
                instancePath3.moveTo(18.111269f, 25.48217f);
                instancePath3.lineTo(15.0f, 22.3709f);
                instancePath3.lineTo(18.111269f, 19.25963f);
                instancePath3.cubicTo(18.907513f, 20.055874f, 19.4f, 21.155872f, 19.4f, 22.3709f);
                instancePath3.cubicTo(19.4f, 23.585926f, 18.907513f, 24.685926f, 18.111269f, 25.48217f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint8);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
