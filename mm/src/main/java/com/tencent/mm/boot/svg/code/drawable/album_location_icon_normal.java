package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class album_location_icon_normal extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(12.06519f, 21.243166f);
                instancePath.cubicTo(12.06301f, 21.241201f, 12.060856f, 21.239325f, 12.058728f, 21.237535f);
                instancePath.lineTo(12.06519f, 21.243166f);
                instancePath.close();
                instancePath.moveTo(12.246837f, 20.968607f);
                instancePath.cubicTo(12.482933f, 20.755777f, 12.747323f, 20.50781f, 13.032845f, 20.227892f);
                instancePath.cubicTo(13.850634f, 19.426147f, 14.668892f, 18.533524f, 15.430166f, 17.57688f);
                instancePath.cubicTo(17.469343f, 15.014377f, 18.711391f, 12.487102f, 18.795486f, 10.239681f);
                instancePath.cubicTo(18.798492f, 10.159331f, 18.8f, 10.079436f, 18.8f, 10.0f);
                instancePath.cubicTo(18.8f, 6.244464f, 15.755536f, 3.2f, 12.0f, 3.2f);
                instancePath.cubicTo(8.244464f, 3.2f, 5.2f, 6.244464f, 5.2f, 10.0f);
                instancePath.cubicTo(5.2f, 10.079436f, 5.2015066f, 10.159331f, 5.2045135f, 10.239681f);
                instancePath.cubicTo(5.2886076f, 12.487102f, 6.530657f, 15.014377f, 8.569834f, 17.57688f);
                instancePath.cubicTo(9.331108f, 18.533524f, 10.149366f, 19.426147f, 10.967155f, 20.227892f);
                instancePath.cubicTo(11.252677f, 20.50781f, 11.517067f, 20.755777f, 11.753163f, 20.968607f);
                instancePath.cubicTo(11.863493f, 21.068064f, 11.946972f, 21.141392f, 12.0f, 21.187016f);
                instancePath.cubicTo(12.053028f, 21.141392f, 12.136507f, 21.068064f, 12.246837f, 20.968607f);
                instancePath.close();
                instancePath.moveTo(12.03476f, 21.21665f);
                instancePath.cubicTo(12.025222f, 21.208614f, 12.013615f, 21.198729f, 12.0f, 21.187016f);
                instancePath.cubicTo(11.986385f, 21.198729f, 11.974778f, 21.208614f, 11.96524f, 21.21665f);
                instancePath.cubicTo(11.981144f, 21.20063f, 12.014057f, 21.199963f, 12.058728f, 21.237535f);
                instancePath.lineTo(12.03476f, 21.21665f);
                instancePath.close();
                instancePath.moveTo(11.261719f, 22.134476f);
                instancePath.cubicTo(11.261719f, 22.134476f, 4.0f, 16.018278f, 4.0f, 10.0f);
                instancePath.cubicTo(4.0f, 5.581722f, 7.581722f, 2.0f, 12.0f, 2.0f);
                instancePath.cubicTo(16.418278f, 2.0f, 20.0f, 5.581722f, 20.0f, 10.0f);
                instancePath.cubicTo(20.0f, 16.018278f, 12.738281f, 22.134476f, 12.738281f, 22.134476f);
                instancePath.cubicTo(12.333565f, 22.50602f, 11.66946f, 22.502035f, 11.261719f, 22.134476f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(12.0f, 12.0f);
                instancePath2.cubicTo(13.104569f, 12.0f, 14.0f, 11.104569f, 14.0f, 10.0f);
                instancePath2.cubicTo(14.0f, 8.895431f, 13.104569f, 8.0f, 12.0f, 8.0f);
                instancePath2.cubicTo(10.895431f, 8.0f, 10.0f, 8.895431f, 10.0f, 10.0f);
                instancePath2.cubicTo(10.0f, 11.104569f, 10.895431f, 12.0f, 12.0f, 12.0f);
                instancePath2.close();
                instancePath2.moveTo(12.0f, 13.2f);
                instancePath2.cubicTo(10.232689f, 13.2f, 8.8f, 11.767311f, 8.8f, 10.0f);
                instancePath2.cubicTo(8.8f, 8.232689f, 10.232689f, 6.8f, 12.0f, 6.8f);
                instancePath2.cubicTo(13.767311f, 6.8f, 15.2f, 8.232689f, 15.2f, 10.0f);
                instancePath2.cubicTo(15.2f, 11.767311f, 13.767311f, 13.2f, 12.0f, 13.2f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
