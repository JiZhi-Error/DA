package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_delete_on extends c {
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
                instancePath.moveTo(20.320658f, 19.199991f);
                instancePath.lineTo(22.757717f, 60.142605f);
                instancePath.cubicTo(22.833185f, 61.410458f, 23.88338f, 62.4f, 25.153477f, 62.4f);
                instancePath.lineTo(46.846523f, 62.4f);
                instancePath.cubicTo(48.11662f, 62.4f, 49.166817f, 61.410458f, 49.242283f, 60.142605f);
                instancePath.lineTo(51.679344f, 19.199991f);
                instancePath.lineTo(55.285713f, 19.199991f);
                instancePath.lineTo(52.835922f, 60.35651f);
                instancePath.cubicTo(52.647255f, 63.526142f, 50.021767f, 66.0f, 46.846523f, 66.0f);
                instancePath.lineTo(25.153477f, 66.0f);
                instancePath.cubicTo(21.978235f, 66.0f, 19.352747f, 63.526142f, 19.164078f, 60.35651f);
                instancePath.lineTo(16.714285f, 19.199991f);
                instancePath.lineTo(20.320658f, 19.199991f);
                instancePath.close();
                instancePath.moveTo(28.5f, 27.0f);
                instancePath.lineTo(32.100037f, 27.0f);
                instancePath.lineTo(33.600037f, 54.0f);
                instancePath.lineTo(30.0f, 54.0f);
                instancePath.lineTo(28.5f, 27.0f);
                instancePath.close();
                instancePath.moveTo(39.899963f, 27.0f);
                instancePath.lineTo(43.5f, 27.0f);
                instancePath.lineTo(42.0f, 54.0f);
                instancePath.lineTo(38.399963f, 54.0f);
                instancePath.lineTo(39.899963f, 27.0f);
                instancePath.close();
                instancePath.moveTo(13.37715f, 7.0590982f);
                instancePath.lineTo(60.647923f, 15.394211f);
                instancePath.cubicTo(61.463764f, 15.538066f, 62.008514f, 16.316053f, 61.864662f, 17.131895f);
                instancePath.lineTo(61.5f, 19.199991f);
                instancePath.lineTo(11.274805f, 10.343934f);
                instancePath.lineTo(11.639465f, 8.275838f);
                instancePath.cubicTo(11.78332f, 7.459996f, 12.561308f, 6.915243f, 13.37715f, 7.0590982f);
                instancePath.close();
                instancePath.moveTo(32.249752f, 3.6851237f);
                instancePath.lineTo(44.067444f, 5.768902f);
                instancePath.cubicTo(44.883286f, 5.912757f, 45.42804f, 6.6907444f, 45.284184f, 7.5065856f);
                instancePath.lineTo(44.919525f, 9.574673f);
                instancePath.lineTo(30.147408f, 6.96995f);
                instancePath.lineTo(30.512068f, 4.901863f);
                instancePath.cubicTo(30.655922f, 4.086022f, 31.43391f, 3.5412688f, 32.249752f, 3.6851237f);
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
