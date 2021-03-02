package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class app_brand_profile_preview_video_play_btn extends c {
    private final int height = 45;
    private final int width = 45;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 45;
            case 1:
                return 45;
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
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(1275068416);
                instancePaint5.setColor(-1);
                instancePaint5.setStrokeWidth(2.3f);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(22.5f, 1.1499996f);
                instancePath.cubicTo(34.29128f, 1.1499996f, 43.85f, 10.70872f, 43.85f, 22.5f);
                instancePath.cubicTo(43.85f, 34.29128f, 34.29128f, 43.85f, 22.5f, 43.85f);
                instancePath.cubicTo(10.70872f, 43.85f, 1.1499996f, 34.29128f, 1.1499996f, 22.5f);
                instancePath.cubicTo(1.1499996f, 10.70872f, 10.70872f, 1.1499996f, 22.5f, 1.1499996f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint4);
                canvas.drawPath(instancePath, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint, looper);
                instancePaint6.setColor(-1);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(29.748446f, 23.296038f);
                instancePath2.lineTo(19.473919f, 30.033487f);
                instancePath2.cubicTo(19.03428f, 30.321777f, 18.444176f, 30.199085f, 18.155884f, 29.759445f);
                instancePath2.cubicTo(18.05418f, 29.60435f, 18.0f, 29.422918f, 18.0f, 29.23745f);
                instancePath2.lineTo(18.0f, 15.762551f);
                instancePath2.cubicTo(18.0f, 15.236818f, 18.426191f, 14.810628f, 18.951923f, 14.810628f);
                instancePath2.cubicTo(19.137392f, 14.810628f, 19.318823f, 14.864809f, 19.473919f, 14.966513f);
                instancePath2.lineTo(29.748446f, 21.703962f);
                instancePath2.cubicTo(30.188086f, 21.992252f, 30.310778f, 22.582357f, 30.022488f, 23.021997f);
                instancePath2.cubicTo(29.950897f, 23.131168f, 29.857618f, 23.22445f, 29.748446f, 23.296038f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint6);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
