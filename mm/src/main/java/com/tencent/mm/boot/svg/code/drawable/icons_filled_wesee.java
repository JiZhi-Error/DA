package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_wesee extends c {
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
                instancePaint3.setColor(-1);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(8.103399f, 4.0519724f);
                instancePath.lineTo(5.208215f, 5.715081f);
                instancePath.cubicTo(5.07932f, 5.7942767f, 5.0f, 5.9328694f, 5.0f, 6.0813613f);
                instancePath.lineTo(5.0f, 17.911215f);
                instancePath.cubicTo(5.0f, 18.059706f, 5.07932f, 18.1983f, 5.208215f, 18.277494f);
                instancePath.lineTo(8.103399f, 19.940603f);
                instancePath.cubicTo(8.232295f, 20.019798f, 8.390935f, 20.019798f, 8.529745f, 19.940603f);
                instancePath.lineTo(18.791784f, 14.020727f);
                instancePath.cubicTo(18.92068f, 13.941531f, 19.0f, 13.802938f, 19.0f, 13.654447f);
                instancePath.lineTo(19.0f, 10.31833f);
                instancePath.cubicTo(19.0f, 10.169838f, 18.92068f, 10.031245f, 18.791784f, 9.952049f);
                instancePath.lineTo(8.51983f, 4.0519724f);
                instancePath.cubicTo(8.390935f, 3.982676f, 8.232295f, 3.982676f, 8.103399f, 4.0519724f);
                instancePath.close();
                instancePath.moveTo(8.00425f, 18.970457f);
                instancePath.lineTo(6.0113316f, 17.832018f);
                instancePath.lineTo(8.00425f, 16.683681f);
                instancePath.lineTo(8.00425f, 18.970457f);
                instancePath.close();
                instancePath.moveTo(8.00425f, 15.763032f);
                instancePath.lineTo(5.783286f, 17.040062f);
                instancePath.lineTo(5.783286f, 6.942614f);
                instancePath.lineTo(8.00425f, 8.219645f);
                instancePath.lineTo(8.00425f, 15.763032f);
                instancePath.lineTo(8.00425f, 15.763032f);
                instancePath.close();
                instancePath.moveTo(8.00425f, 7.2989945f);
                instancePath.lineTo(6.0212464f, 6.160557f);
                instancePath.lineTo(8.00425f, 5.0320187f);
                instancePath.lineTo(8.00425f, 7.2989945f);
                instancePath.close();
                instancePath.moveTo(18.216713f, 13.179273f);
                instancePath.lineTo(16.15439f, 11.991338f);
                instancePath.lineTo(18.22663f, 10.803403f);
                instancePath.lineTo(18.22663f, 13.179273f);
                instancePath.lineTo(18.216713f, 13.179273f);
                instancePath.close();
                instancePath.moveTo(8.807365f, 5.1409125f);
                instancePath.lineTo(17.621813f, 10.229235f);
                instancePath.lineTo(15.36119f, 11.526063f);
                instancePath.lineTo(8.807365f, 7.7642694f);
                instancePath.lineTo(8.807365f, 5.1409125f);
                instancePath.lineTo(8.807365f, 5.1409125f);
                instancePath.close();
                instancePath.moveTo(8.807365f, 8.675019f);
                instancePath.lineTo(14.558074f, 11.991338f);
                instancePath.lineTo(8.807365f, 15.297757f);
                instancePath.lineTo(8.807365f, 8.675019f);
                instancePath.close();
                instancePath.moveTo(8.807365f, 18.881361f);
                instancePath.lineTo(8.807365f, 16.218407f);
                instancePath.lineTo(15.36119f, 12.446713f);
                instancePath.lineTo(17.631727f, 13.753442f);
                instancePath.lineTo(8.807365f, 18.881361f);
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
