package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class c2c_aa_icon_check extends c {
    private final int height = 40;
    private final int width = 40;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 40;
            case 1:
                return 40;
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
                instancePath.moveTo(20.0f, 0.0f);
                instancePath.cubicTo(31.045694f, 0.0f, 40.0f, 8.954306f, 40.0f, 20.0f);
                instancePath.cubicTo(40.0f, 31.045694f, 31.045694f, 40.0f, 20.0f, 40.0f);
                instancePath.cubicTo(8.954306f, 40.0f, 0.0f, 31.045694f, 0.0f, 20.0f);
                instancePath.cubicTo(0.0f, 8.954306f, 8.954306f, 0.0f, 20.0f, 0.0f);
                instancePath.close();
                instancePath.moveTo(20.0f, 1.1764706f);
                instancePath.cubicTo(9.604051f, 1.1764706f, 1.1764706f, 9.604051f, 1.1764706f, 20.0f);
                instancePath.cubicTo(1.1764706f, 30.395948f, 9.604051f, 38.82353f, 20.0f, 38.82353f);
                instancePath.cubicTo(30.395948f, 38.82353f, 38.82353f, 30.395948f, 38.82353f, 20.0f);
                instancePath.cubicTo(38.82353f, 9.604051f, 30.395948f, 1.1764706f, 20.0f, 1.1764706f);
                instancePath.close();
                instancePath.moveTo(30.23164f, 13.51582f);
                instancePath.lineTo(30.772768f, 14.051357f);
                instancePath.cubicTo(30.849499f, 14.127295f, 30.849628f, 14.250286f, 30.773903f, 14.325228f);
                instancePath.lineTo(17.266922f, 27.692572f);
                instancePath.cubicTo(17.113321f, 27.844584f, 16.863773f, 27.84407f, 16.711462f, 27.693333f);
                instancePath.lineTo(10.573702f, 21.619028f);
                instancePath.cubicTo(10.498121f, 21.544231f, 10.490384f, 21.41671f, 10.558941f, 21.33105f);
                instancePath.lineTo(11.310415f, 20.392082f);
                instancePath.cubicTo(11.377843f, 20.307835f, 11.502753f, 20.286013f, 11.5928f, 20.345577f);
                instancePath.lineTo(16.661976f, 23.698973f);
                instancePath.cubicTo(16.842478f, 23.81838f, 17.127102f, 23.803972f, 17.293428f, 23.67023f);
                instancePath.lineTo(29.941011f, 13.500306f);
                instancePath.cubicTo(30.024792f, 13.432938f, 30.156973f, 13.441925f, 30.23164f, 13.51582f);
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
