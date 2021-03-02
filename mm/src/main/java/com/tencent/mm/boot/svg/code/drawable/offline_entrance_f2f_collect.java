package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class offline_entrance_f2f_collect extends c {
    private final int height = 73;
    private final int width = 73;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 73;
            case 1:
                return 73;
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
                instancePath.moveTo(47.197567f, 20.880615f);
                instancePath.cubicTo(49.75061f, 18.27593f, 54.734123f, 11.859151f, 52.71646f, 9.693311f);
                instancePath.cubicTo(50.6186f, 7.441382f, 47.12471f, 10.099909f, 43.102005f, 10.099909f);
                instancePath.cubicTo(38.419895f, 10.099909f, 33.461906f, 6.347826f, 28.768751f, 6.347826f);
                instancePath.cubicTo(24.075596f, 6.347826f, 21.768908f, 8.151717f, 21.393791f, 9.693311f);
                instancePath.cubicTo(20.369335f, 13.903461f, 24.471415f, 19.043554f, 26.450045f, 20.825512f);
                instancePath.cubicTo(17.056711f, 25.732353f, 10.57971f, 36.775944f, 10.57971f, 46.79578f);
                instancePath.cubicTo(10.57971f, 60.167355f, 22.11471f, 66.652176f, 36.72224f, 66.652176f);
                instancePath.cubicTo(51.329773f, 66.652176f, 63.47826f, 60.167355f, 63.47826f, 46.79578f);
                instancePath.cubicTo(63.47826f, 36.813274f, 56.70752f, 25.814636f, 47.197567f, 20.880615f);
                instancePath.close();
                instancePath.moveTo(43.0405f, 19.180447f);
                instancePath.cubicTo(45.004486f, 18.007338f, 47.713238f, 13.764762f, 47.17403f, 13.226644f);
                instancePath.cubicTo(46.54742f, 12.601296f, 45.27558f, 13.851991f, 42.83166f, 13.851991f);
                instancePath.cubicTo(37.192146f, 13.851991f, 31.270815f, 10.099909f, 28.419573f, 10.099909f);
                instancePath.cubicTo(25.56833f, 10.099909f, 25.28651f, 11.324817f, 25.28651f, 12.601296f);
                instancePath.cubicTo(25.28651f, 14.340447f, 28.844025f, 18.299887f, 30.058945f, 19.301182f);
                instancePath.cubicTo(32.180992f, 18.609077f, 34.41323f, 18.22942f, 36.72224f, 18.22942f);
                instancePath.cubicTo(38.893246f, 18.22942f, 41.009937f, 18.565052f, 43.0405f, 19.180447f);
                instancePath.close();
                instancePath.moveTo(36.813618f, 62.003716f);
                instancePath.cubicTo(48.32105f, 62.003716f, 59.455482f, 58.047215f, 59.455482f, 46.995384f);
                instancePath.cubicTo(59.455482f, 35.943558f, 48.32105f, 22.60685f, 36.81362f, 22.60685f);
                instancePath.cubicTo(25.30619f, 22.60685f, 14.965998f, 35.943558f, 14.965998f, 46.995384f);
                instancePath.cubicTo(14.965998f, 58.047215f, 25.30619f, 62.003716f, 36.813618f, 62.003716f);
                instancePath.close();
                instancePath.moveTo(24.521008f, 42.901672f);
                instancePath.cubicTo(24.348475f, 42.723473f, 24.324863f, 42.421143f, 24.47348f, 42.219334f);
                instancePath.lineTo(25.425287f, 40.92684f);
                instancePath.cubicTo(25.571571f, 40.7282f, 25.856255f, 40.689495f, 26.04206f, 40.826347f);
                instancePath.lineTo(32.63428f, 45.681618f);
                instancePath.cubicTo(32.828632f, 45.82476f, 33.137394f, 45.814117f, 33.333984f, 45.64941f);
                instancePath.lineTo(47.91601f, 33.432472f);
                instancePath.cubicTo(48.108097f, 33.271545f, 48.400536f, 33.27584f, 48.57801f, 33.45076f);
                instancePath.lineTo(49.431164f, 34.29163f);
                instancePath.cubicTo(49.60469f, 34.462658f, 49.61013f, 34.750954f, 49.448505f, 34.929363f);
                instancePath.cubicTo(49.448505f, 34.929363f, 45.16237f, 39.68604f, 42.28657f, 42.510536f);
                instancePath.cubicTo(39.410778f, 45.335033f, 33.302795f, 51.33406f, 33.302795f, 51.33406f);
                instancePath.cubicTo(33.127937f, 51.5058f, 32.848312f, 51.502617f, 32.673786f, 51.322357f);
                instancePath.lineTo(24.521008f, 42.901672f);
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
