package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_call_good extends c {
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
                instancePaint3.setColor(-1);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(12.810811f, 1.0f);
                instancePath.cubicTo(13.969112f, 1.0f, 14.818533f, 1.85504f, 15.050193f, 2.9230769f);
                instancePath.cubicTo(15.204633f, 3.5384614f, 15.281854f, 4.230769f, 15.281854f, 4.923077f);
                instancePath.cubicTo(15.281854f, 6.0f, 15.127413f, 7.0f, 14.818533f, 7.923077f);
                instancePath.lineTo(14.818533f, 7.923077f);
                instancePath.lineTo(19.606178f, 7.923077f);
                instancePath.cubicTo(20.378378f, 8.0f, 21.15058f, 8.384615f, 21.6139f, 9.153846f);
                instancePath.cubicTo(21.92278f, 9.615385f, 22.0f, 10.153846f, 22.0f, 10.692307f);
                instancePath.cubicTo(21.95989f, 11.085051f, 21.92981f, 11.328325f, 21.909754f, 11.4221325f);
                instancePath.cubicTo(21.421392f, 13.706489f, 20.455297f, 18.07333f, 20.168217f, 19.284653f);
                instancePath.cubicTo(20.152573f, 19.350664f, 20.135468f, 19.419725f, 20.124044f, 19.466146f);
                instancePath.cubicTo(20.103884f, 19.548065f, 20.074547f, 19.602066f, 20.069498f, 19.615385f);
                instancePath.cubicTo(19.915058f, 20.0f, 19.606178f, 20.384615f, 19.220078f, 20.615385f);
                instancePath.cubicTo(18.833977f, 20.846153f, 18.370657f, 21.0f, 17.907335f, 21.0f);
                instancePath.lineTo(17.907335f, 21.0f);
                instancePath.lineTo(8.019305f, 21.0f);
                instancePath.cubicTo(7.46702f, 21.0f, 7.019305f, 20.552284f, 7.019305f, 20.0f);
                instancePath.lineTo(7.019305f, 20.0f);
                instancePath.lineTo(7.019305f, 8.538462f);
                instancePath.cubicTo(8.075794f, 8.143802f, 8.981717f, 7.374173f, 9.579713f, 6.3720803f);
                instancePath.cubicTo(10.030715f, 5.6163125f, 10.306569f, 4.7283187f, 10.339768f, 3.7692308f);
                instancePath.lineTo(10.339768f, 3.7692308f);
                instancePath.lineTo(10.339768f, 3.5384614f);
                instancePath.cubicTo(10.339768f, 2.1538463f, 11.280368f, 1.0f, 12.810811f, 1.0f);
                instancePath.close();
                instancePath.moveTo(4.3976836f, 8.846154f);
                instancePath.cubicTo(4.9499683f, 8.846154f, 5.3976836f, 9.293869f, 5.3976836f, 9.846154f);
                instancePath.lineTo(5.3976836f, 9.846154f);
                instancePath.lineTo(5.3976836f, 20.0f);
                instancePath.cubicTo(5.3976836f, 20.552284f, 4.9499683f, 21.0f, 4.3976836f, 21.0f);
                instancePath.lineTo(4.3976836f, 21.0f);
                instancePath.lineTo(2.8494208f, 21.0f);
                instancePath.cubicTo(2.3861003f, 21.0f, 2.0f, 20.615385f, 2.0f, 20.153847f);
                instancePath.lineTo(2.0f, 20.153847f);
                instancePath.lineTo(2.0f, 9.692307f);
                instancePath.cubicTo(2.0f, 9.230769f, 2.3861003f, 8.846154f, 2.8494208f, 8.846154f);
                instancePath.lineTo(2.8494208f, 8.846154f);
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
