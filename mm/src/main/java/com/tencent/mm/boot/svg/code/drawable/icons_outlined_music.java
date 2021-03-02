package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_music extends c {
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
                instancePath.moveTo(58.79186f, 8.409542f);
                instancePath.cubicTo(58.56803f, 7.437919f, 57.607574f, 6.8242946f, 56.63186f, 7.029542f);
                instancePath.lineTo(21.801859f, 14.679542f);
                instancePath.cubicTo(20.253098f, 15.024884f, 19.169397f, 16.423613f, 19.221859f, 18.009542f);
                instancePath.lineTo(19.221859f, 49.20954f);
                instancePath.cubicTo(19.230822f, 50.51106f, 18.309982f, 51.633724f, 17.031858f, 51.879543f);
                instancePath.lineTo(12.021859f, 52.929543f);
                instancePath.cubicTo(8.994896f, 53.69592f, 6.9650936f, 56.537643f, 7.221859f, 59.649544f);
                instancePath.cubicTo(7.3592567f, 62.90464f, 9.966761f, 65.512146f, 13.221859f, 65.64954f);
                instancePath.cubicTo(13.60065f, 65.6924f, 13.9830675f, 65.6924f, 14.361858f, 65.64954f);
                instancePath.cubicTo(14.571858f, 65.64954f, 17.721859f, 64.92954f, 18.261858f, 64.689545f);
                instancePath.cubicTo(20.995121f, 63.378006f, 22.758251f, 60.640514f, 22.82186f, 57.609543f);
                instancePath.lineTo(22.82186f, 18.609543f);
                instancePath.lineTo(55.19186f, 11.499542f);
                instancePath.lineTo(55.19186f, 41.22954f);
                instancePath.cubicTo(55.188976f, 42.526836f, 54.273525f, 43.642937f, 53.001858f, 43.899544f);
                instancePath.lineTo(47.78186f, 45.00954f);
                instancePath.cubicTo(44.80291f, 45.824276f, 42.832962f, 48.65292f, 43.10186f, 51.72954f);
                instancePath.cubicTo(43.253216f, 54.978493f, 45.85291f, 57.578186f, 49.10186f, 57.72954f);
                instancePath.cubicTo(49.490597f, 57.7739f, 49.88312f, 57.7739f, 50.27186f, 57.72954f);
                instancePath.cubicTo(51.597874f, 57.466736f, 52.909588f, 57.136303f, 54.20186f, 56.73954f);
                instancePath.cubicTo(56.93488f, 55.464977f, 58.72044f, 52.763447f, 58.821857f, 49.749542f);
                instancePath.lineTo(58.821857f, 8.799542f);
                instancePath.cubicTo(58.82681f, 8.668822f, 58.816742f, 8.537967f, 58.79186f, 8.409542f);
                instancePath.close();
                instancePath.moveTo(55.22186f, 46.929543f);
                instancePath.lineTo(55.22186f, 49.629543f);
                instancePath.cubicTo(55.1205f, 51.186485f, 54.209362f, 52.57597f, 52.821857f, 53.289543f);
                instancePath.cubicTo(52.22186f, 53.499542f, 50.03186f, 53.97954f, 49.551857f, 54.069542f);
                instancePath.lineTo(49.10186f, 54.069542f);
                instancePath.cubicTo(47.75794f, 53.90634f, 46.736618f, 52.78289f, 46.70186f, 51.429543f);
                instancePath.cubicTo(46.596306f, 50.14698f, 47.320515f, 48.939964f, 48.501858f, 48.429543f);
                instancePath.lineTo(53.72186f, 47.379543f);
                instancePath.cubicTo(54.237686f, 47.288513f, 54.741104f, 47.13749f, 55.22186f, 46.929543f);
                instancePath.close();
                instancePath.moveTo(19.221859f, 54.909542f);
                instancePath.lineTo(19.221859f, 57.609543f);
                instancePath.cubicTo(19.130981f, 59.169193f, 18.232416f, 60.568222f, 16.851858f, 61.29954f);
                instancePath.cubicTo(16.281858f, 61.47954f, 14.091859f, 61.95954f, 13.641859f, 62.07954f);
                instancePath.cubicTo(12.914038f, 62.138298f, 12.194885f, 61.88948f, 11.658997f, 61.393497f);
                instancePath.cubicTo(11.123108f, 60.897514f, 10.819491f, 60.199726f, 10.821858f, 59.469543f);
                instancePath.cubicTo(10.711464f, 58.194347f, 11.422289f, 56.98956f, 12.591859f, 56.469543f);
                instancePath.lineTo(17.75186f, 55.449543f);
                instancePath.cubicTo(18.261635f, 55.328793f, 18.75514f, 55.147507f, 19.221859f, 54.909542f);
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
