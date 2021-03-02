package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class c2c_aa_icon_close extends c {
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
                instancePath.moveTo(27.451965f, 10.0f);
                instancePath.cubicTo(27.884584f, 10.0f, 28.235294f, 10.351369f, 28.235294f, 10.784023f);
                instancePath.lineTo(28.235294f, 29.215977f);
                instancePath.cubicTo(28.235294f, 29.648981f, 27.883663f, 30.0f, 27.451965f, 30.0f);
                instancePath.lineTo(12.548036f, 30.0f);
                instancePath.cubicTo(12.115416f, 30.0f, 11.764706f, 29.648632f, 11.764706f, 29.215977f);
                instancePath.lineTo(11.764706f, 10.784023f);
                instancePath.cubicTo(11.764706f, 10.35102f, 12.116338f, 10.0f, 12.548036f, 10.0f);
                instancePath.lineTo(27.451965f, 10.0f);
                instancePath.close();
                instancePath.moveTo(27.058823f, 11.176471f);
                instancePath.lineTo(12.941176f, 11.176471f);
                instancePath.lineTo(12.941176f, 28.82353f);
                instancePath.lineTo(27.058823f, 28.82353f);
                instancePath.lineTo(27.058823f, 11.176471f);
                instancePath.close();
                instancePath.moveTo(24.890415f, 20.0f);
                instancePath.lineTo(25.722305f, 20.83189f);
                instancePath.lineTo(22.81069f, 23.743505f);
                instancePath.lineTo(25.722305f, 26.65512f);
                instancePath.lineTo(24.890415f, 27.487011f);
                instancePath.lineTo(21.9788f, 24.575396f);
                instancePath.lineTo(19.067184f, 27.487011f);
                instancePath.lineTo(18.235294f, 26.65512f);
                instancePath.lineTo(21.14691f, 23.743505f);
                instancePath.lineTo(18.235294f, 20.83189f);
                instancePath.lineTo(19.067184f, 20.0f);
                instancePath.lineTo(21.9788f, 22.911615f);
                instancePath.lineTo(24.890415f, 20.0f);
                instancePath.close();
                instancePath.moveTo(20.588236f, 15.882353f);
                instancePath.lineTo(20.588236f, 17.058823f);
                instancePath.lineTo(14.705882f, 17.058823f);
                instancePath.lineTo(14.705882f, 15.882353f);
                instancePath.lineTo(20.588236f, 15.882353f);
                instancePath.close();
                instancePath.moveTo(20.588236f, 12.941176f);
                instancePath.lineTo(20.588236f, 14.117647f);
                instancePath.lineTo(14.705882f, 14.117647f);
                instancePath.lineTo(14.705882f, 12.941176f);
                instancePath.lineTo(20.588236f, 12.941176f);
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
