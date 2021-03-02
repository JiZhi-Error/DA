package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class teen_mode extends c {
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
                instancePaint3.setColor(-436207616);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 2.0f, 0.0f, 1.0f, 2.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(10.666667f, 10.953414f);
                instancePath.lineTo(10.666667f, 17.862661f);
                instancePath.cubicTo(10.666667f, 19.345488f, 9.464598f, 20.547558f, 7.981771f, 20.547558f);
                instancePath.cubicTo(6.558257f, 20.547558f, 5.39349f, 19.43973f, 5.302586f, 18.039194f);
                instancePath.lineTo(5.296875f, 17.862661f);
                instancePath.lineTo(5.296875f, 17.162474f);
                instancePath.lineTo(6.6302085f, 17.162474f);
                instancePath.lineTo(6.6302085f, 17.862661f);
                instancePath.cubicTo(6.6302085f, 18.609108f, 7.2353234f, 19.214224f, 7.981771f, 19.214224f);
                instancePath.cubicTo(8.681565f, 19.214224f, 9.257142f, 18.682384f, 9.326355f, 18.00085f);
                instancePath.lineTo(9.333333f, 17.862661f);
                instancePath.lineTo(9.333333f, 10.953414f);
                instancePath.lineTo(10.666667f, 10.953414f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(10.0f, 8.6153307E-13f);
                instancePath2.cubicTo(15.424225f, 8.6153307E-13f, 19.839767f, 4.3186817f, 19.995737f, 9.705153f);
                instancePath2.lineTo(20.0f, 10.0f);
                instancePath2.lineTo(19.969925f, 10.953414f);
                instancePath2.lineTo(0.0018045113f, 10.953414f);
                instancePath2.lineTo(0.0f, 10.0f);
                instancePath2.cubicTo(0.0f, 4.4771523f, 4.4771523f, 8.6153307E-13f, 10.0f, 8.6153307E-13f);
                instancePath2.close();
                instancePath2.moveTo(10.0f, 1.3333334f);
                instancePath2.cubicTo(5.397627f, 1.3333334f, 1.6331508f, 4.9207954f, 1.3503819f, 9.449663f);
                instancePath2.lineTo(1.3411111f, 9.62f);
                instancePath2.lineTo(18.656666f, 9.62f);
                instancePath2.lineTo(18.649616f, 9.451906f);
                instancePath2.cubicTo(18.372505f, 5.0114174f, 14.751559f, 1.4772092f, 10.275116f, 1.3376172f);
                instancePath2.lineTo(10.0f, 1.3333334f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
