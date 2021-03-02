package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class v_verify extends c {
    private final int height = 16;
    private final int width = 16;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 16;
            case 1:
                return 16;
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
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(-1);
                instancePaint5.setColor(855638016);
                instancePaint5.setStrokeWidth(0.5f);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.25f, 0.25f);
                instancePath.lineTo(15.75f, 0.25f);
                instancePath.lineTo(15.75f, 15.75f);
                instancePath.lineTo(0.25f, 15.75f);
                instancePath.lineTo(0.25f, 0.25f);
                instancePath.close();
                canvas.saveLayerAlpha(null, 0, 31);
                Paint instancePaint6 = c.instancePaint(instancePaint4, looper);
                Paint instancePaint7 = c.instancePaint(instancePaint5, looper);
                canvas.drawPath(instancePath, instancePaint6);
                canvas.drawPath(instancePath, instancePaint7);
                canvas.restore();
                canvas.save();
                Paint instancePaint8 = c.instancePaint(instancePaint, looper);
                instancePaint8.setColor(-352965);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(11.023459f, 2.055746f);
                instancePath2.lineTo(11.879267f, 4.1206417f);
                instancePath2.lineTo(13.944254f, 4.9765406f);
                instancePath2.cubicTo(14.318434f, 5.131531f, 14.496121f, 5.5605073f, 14.341131f, 5.9346867f);
                instancePath2.lineTo(13.485154f, 7.9994445f);
                instancePath2.lineTo(14.341131f, 10.065313f);
                instancePath2.cubicTo(14.496121f, 10.439493f, 14.318434f, 10.868469f, 13.944254f, 11.023459f);
                instancePath2.lineTo(11.878266f, 11.878815f);
                instancePath2.lineTo(11.023459f, 13.944254f);
                instancePath2.cubicTo(10.868469f, 14.318434f, 10.439493f, 14.496121f, 10.065313f, 14.341131f);
                instancePath2.lineTo(8.000387f, 13.485085f);
                instancePath2.lineTo(5.9346867f, 14.341131f);
                instancePath2.cubicTo(5.5605073f, 14.496121f, 5.131531f, 14.318434f, 4.9765406f, 13.944254f);
                instancePath2.lineTo(4.1210175f, 11.878197f);
                instancePath2.lineTo(2.055746f, 11.023459f);
                instancePath2.cubicTo(1.6815667f, 10.868469f, 1.5038787f, 10.439493f, 1.6588689f, 10.065313f);
                instancePath2.lineTo(2.5138235f, 7.9999356f);
                instancePath2.lineTo(1.6588689f, 5.9346867f);
                instancePath2.cubicTo(1.5038787f, 5.5605073f, 1.6815667f, 5.131531f, 2.055746f, 4.9765406f);
                instancePath2.lineTo(4.1207113f, 4.1205654f);
                instancePath2.lineTo(4.9765406f, 2.055746f);
                instancePath2.cubicTo(5.131531f, 1.6815667f, 5.5605073f, 1.5038787f, 5.9346867f, 1.6588689f);
                instancePath2.lineTo(7.9998965f, 2.5137541f);
                instancePath2.lineTo(10.065313f, 1.6588689f);
                instancePath2.cubicTo(10.439493f, 1.5038787f, 10.868469f, 1.6815667f, 11.023459f, 2.055746f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint8);
                canvas.restore();
                canvas.save();
                Paint instancePaint9 = c.instancePaint(instancePaint, looper);
                instancePaint9.setColor(-1);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(7.215625f, 9.426211f);
                instancePath3.lineTo(10.948503f, 5.693333f);
                instancePath3.lineTo(11.656855f, 6.401685f);
                instancePath3.lineTo(7.688609f, 10.368281f);
                instancePath3.cubicTo(7.428278f, 10.628649f, 7.006168f, 10.628562f, 6.7458725f, 10.368158f);
                instancePath3.cubicTo(6.7458487f, 10.368134f, 6.7458243f, 10.36811f, 6.745873f, 10.368012f);
                instancePath3.lineTo(4.6666665f, 8.287303f);
                instancePath3.lineTo(4.6666665f, 8.287303f);
                instancePath3.lineTo(5.3716917f, 7.582278f);
                instancePath3.lineTo(7.215625f, 9.426211f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint9);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
