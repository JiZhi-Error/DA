package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class sns_collapse_video_play extends c {
    private final int height = 120;
    private final int width = 120;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 120;
            case 1:
                return 120;
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
                canvas.saveLayerAlpha(null, 204, 31);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-1);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(60.0f, 115.0f);
                instancePath.cubicTo(90.37566f, 115.0f, 115.0f, 90.37566f, 115.0f, 60.0f);
                instancePath.cubicTo(115.0f, 29.624338f, 90.37566f, 5.0f, 60.0f, 5.0f);
                instancePath.cubicTo(29.624338f, 5.0f, 5.0f, 29.624338f, 5.0f, 60.0f);
                instancePath.cubicTo(5.0f, 90.37566f, 29.624338f, 115.0f, 60.0f, 115.0f);
                instancePath.close();
                instancePath.moveTo(60.0f, 120.0f);
                instancePath.cubicTo(26.862915f, 120.0f, 0.0f, 93.137085f, 0.0f, 60.0f);
                instancePath.cubicTo(0.0f, 26.862915f, 26.862915f, 0.0f, 60.0f, 0.0f);
                instancePath.cubicTo(93.137085f, 0.0f, 120.0f, 26.862915f, 120.0f, 60.0f);
                instancePath.cubicTo(120.0f, 93.137085f, 93.137085f, 120.0f, 60.0f, 120.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-1);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(46.5f, 38.223152f);
                instancePath2.cubicTo(46.5f, 36.562f, 47.656143f, 35.89766f, 49.079807f, 36.73782f);
                instancePath2.lineTo(85.92019f, 58.478794f);
                instancePath2.cubicTo(87.34498f, 59.31962f, 87.34386f, 60.68353f, 85.92019f, 61.52369f);
                instancePath2.lineTo(49.079807f, 83.26466f);
                instancePath2.cubicTo(47.655018f, 84.10549f, 46.5f, 83.43548f, 46.5f, 81.779335f);
                instancePath2.lineTo(46.5f, 38.223152f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(855638016);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(60.0f, 0.0f);
                instancePath3.cubicTo(93.137085f, 0.0f, 120.0f, 26.862915f, 120.0f, 60.0f);
                instancePath3.cubicTo(120.0f, 93.137085f, 93.137085f, 120.0f, 60.0f, 120.0f);
                instancePath3.cubicTo(26.862915f, 120.0f, 0.0f, 93.137085f, 0.0f, 60.0f);
                instancePath3.cubicTo(0.0f, 26.862915f, 26.862915f, 0.0f, 60.0f, 0.0f);
                instancePath3.close();
                canvas.drawPath(instancePath3, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint, looper);
                instancePaint6.setColor(-1);
                Path instancePath4 = c.instancePath(looper);
                instancePath4.moveTo(60.0f, 117.0f);
                instancePath4.cubicTo(91.48023f, 117.0f, 117.0f, 91.48023f, 117.0f, 60.0f);
                instancePath4.cubicTo(117.0f, 28.51977f, 91.48023f, 3.0f, 60.0f, 3.0f);
                instancePath4.cubicTo(28.51977f, 3.0f, 3.0f, 28.51977f, 3.0f, 60.0f);
                instancePath4.cubicTo(3.0f, 91.48023f, 28.51977f, 117.0f, 60.0f, 117.0f);
                instancePath4.close();
                instancePath4.moveTo(60.0f, 120.0f);
                instancePath4.cubicTo(26.862915f, 120.0f, 0.0f, 93.137085f, 0.0f, 60.0f);
                instancePath4.cubicTo(0.0f, 26.862915f, 26.862915f, 0.0f, 60.0f, 0.0f);
                instancePath4.cubicTo(93.137085f, 0.0f, 120.0f, 26.862915f, 120.0f, 60.0f);
                instancePath4.cubicTo(120.0f, 93.137085f, 93.137085f, 120.0f, 60.0f, 120.0f);
                instancePath4.close();
                WeChatSVGRenderC2Java.setFillType(instancePath4, 1);
                canvas.drawPath(instancePath4, instancePaint6);
                canvas.restore();
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint, looper);
                instancePaint7.setColor(-1);
                Path instancePath5 = c.instancePath(looper);
                instancePath5.moveTo(46.5f, 38.223152f);
                instancePath5.cubicTo(46.5f, 36.562f, 47.656143f, 35.89766f, 49.079807f, 36.73782f);
                instancePath5.lineTo(85.92019f, 58.478794f);
                instancePath5.cubicTo(87.34498f, 59.31962f, 87.34386f, 60.68353f, 85.92019f, 61.52369f);
                instancePath5.lineTo(49.079807f, 83.26466f);
                instancePath5.cubicTo(47.655018f, 84.10549f, 46.5f, 83.43548f, 46.5f, 81.779335f);
                instancePath5.lineTo(46.5f, 38.223152f);
                instancePath5.close();
                WeChatSVGRenderC2Java.setFillType(instancePath5, 2);
                canvas.drawPath(instancePath5, instancePaint7);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
