package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class ipcall_plus_menu_icon extends c {
    private final int height = 55;
    private final int width = 55;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 55;
            case 1:
                return 55;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                Matrix instanceMatrix = c.instanceMatrix(looper);
                float[] instanceMatrixArray = c.instanceMatrixArray(looper);
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(2.0f, -3.5527137E-15f);
                instancePath.cubicTo(6.0666566f, -0.020621631f, 10.031018f, -0.17034677f, 14.0f, -3.5527137E-15f);
                instancePath.cubicTo(16.641615f, 1.77608f, 15.303518f, 5.678915f, 16.0f, 8.0f);
                instancePath.cubicTo(16.01251f, 10.619844f, 18.548903f, 12.885685f, 17.0f, 15.0f);
                instancePath.cubicTo(15.363433f, 18.066174f, 12.717196f, 20.30207f, 10.0f, 23.0f);
                instancePath.cubicTo(15.303518f, 30.902609f, 22.14379f, 37.620277f, 30.0f, 43.0f);
                instancePath.cubicTo(32.63886f, 40.285385f, 34.845722f, 37.720093f, 38.0f, 36.0f);
                instancePath.cubicTo(38.879982f, 34.635757f, 40.467724f, 35.633923f, 42.0f, 36.0f);
                instancePath.cubicTo(44.901417f, 37.30086f, 48.286602f, 36.941525f, 51.0f, 38.0f);
                instancePath.cubicTo(53.119728f, 38.40883f, 52.929996f, 40.495f, 53.0f, 42.0f);
                instancePath.cubicTo(52.929996f, 44.936844f, 53.15967f, 47.891422f, 53.0f, 51.0f);
                instancePath.cubicTo(51.422142f, 53.810555f, 47.587597f, 52.83235f, 45.0f, 53.0f);
                instancePath.cubicTo(22.583164f, 49.648197f, 3.3704917f, 30.523306f, 3.5527137E-15f, 8.0f);
                instancePath.cubicTo(0.19500868f, 5.509227f, -0.8734715f, 1.5465014f, 2.0f, -3.5527137E-15f);
                instancePath.lineTo(2.0f, -3.5527137E-15f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
