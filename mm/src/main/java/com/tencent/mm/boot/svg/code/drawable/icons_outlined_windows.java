package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_outlined_windows extends c {
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
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-436207616);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(15.0f, 2.4f);
                instancePath.cubicTo(16.380713f, 2.4f, 17.510056f, 3.4762385f, 17.594885f, 4.835572f);
                instancePath.lineTo(17.6f, 5.0f);
                instancePath.lineTo(17.599f, 6.399f);
                instancePath.lineTo(19.0f, 6.4f);
                instancePath.cubicTo(20.380713f, 6.4f, 21.510056f, 7.4762387f, 21.594885f, 8.835572f);
                instancePath.lineTo(21.6f, 9.0f);
                instancePath.lineTo(21.6f, 19.0f);
                instancePath.cubicTo(21.6f, 20.43594f, 20.43594f, 21.6f, 19.0f, 21.6f);
                instancePath.lineTo(19.0f, 21.6f);
                instancePath.lineTo(9.0f, 21.6f);
                instancePath.cubicTo(7.5640597f, 21.6f, 6.4f, 20.43594f, 6.4f, 19.0f);
                instancePath.lineTo(6.4f, 19.0f);
                instancePath.lineTo(6.399f, 17.599f);
                instancePath.lineTo(5.0f, 17.6f);
                instancePath.cubicTo(3.6192882f, 17.6f, 2.4899452f, 16.523762f, 2.4051151f, 15.164428f);
                instancePath.lineTo(2.4f, 15.0f);
                instancePath.lineTo(2.4f, 5.0f);
                instancePath.cubicTo(2.4f, 3.6192882f, 3.4762385f, 2.4899452f, 4.835572f, 2.4051151f);
                instancePath.lineTo(5.0f, 2.4f);
                instancePath.lineTo(15.0f, 2.4f);
                instancePath.close();
                instancePath.moveTo(19.0f, 7.6f);
                instancePath.lineTo(9.0f, 7.6f);
                instancePath.cubicTo(8.226801f, 7.6f, 7.6f, 8.226801f, 7.6f, 9.0f);
                instancePath.lineTo(7.6f, 9.0f);
                instancePath.lineTo(7.6f, 19.0f);
                instancePath.cubicTo(7.6f, 19.7732f, 8.226801f, 20.4f, 9.0f, 20.4f);
                instancePath.lineTo(9.0f, 20.4f);
                instancePath.lineTo(19.0f, 20.4f);
                instancePath.cubicTo(19.7732f, 20.4f, 20.4f, 19.7732f, 20.4f, 19.0f);
                instancePath.lineTo(20.4f, 19.0f);
                instancePath.lineTo(20.4f, 9.0f);
                instancePath.cubicTo(20.4f, 8.226801f, 19.7732f, 7.6f, 19.0f, 7.6f);
                instancePath.lineTo(19.0f, 7.6f);
                instancePath.close();
                instancePath.moveTo(15.1348295f, 3.6064088f);
                instancePath.lineTo(15.0f, 3.6f);
                instancePath.lineTo(5.0f, 3.6f);
                instancePath.cubicTo(4.2722836f, 3.6f, 3.674248f, 4.155229f, 3.6064088f, 4.8651705f);
                instancePath.lineTo(3.6f, 5.0f);
                instancePath.lineTo(3.6f, 15.0f);
                instancePath.cubicTo(3.6f, 15.727716f, 4.155229f, 16.325752f, 4.8651705f, 16.39359f);
                instancePath.lineTo(5.0f, 16.4f);
                instancePath.lineTo(6.399f, 16.399f);
                instancePath.lineTo(6.4f, 9.0f);
                instancePath.cubicTo(6.4f, 7.619288f, 7.4762387f, 6.4899454f, 8.835572f, 6.405115f);
                instancePath.lineTo(9.0f, 6.4f);
                instancePath.lineTo(16.399f, 6.399f);
                instancePath.lineTo(16.4f, 5.0f);
                instancePath.cubicTo(16.4f, 4.2722836f, 15.844771f, 3.674248f, 15.1348295f, 3.6064088f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
