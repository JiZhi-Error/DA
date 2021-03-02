package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class app_brand_auth_icon extends c {
    private final int height = 42;
    private final int width = 42;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 42;
            case 1:
                return 42;
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
                Paint instancePaint3 = c.instancePaint(instancePaint2, looper);
                instancePaint3.setStrokeWidth(1.0f);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -275.0f, 0.0f, 1.0f, -1626.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 126.0f, 0.0f, 1.0f, 1626.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray3 = c.setMatrixFloatArray(matrixFloatArray2, 1.0f, 0.0f, 149.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray3);
                canvas.concat(instanceMatrix);
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(-70474);
                instancePaint5.setColor(-36352);
                instancePaint5.setStrokeWidth(5.4f);
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint4, looper);
                Paint instancePaint7 = c.instancePaint(instancePaint5, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(42.0f, 21.25926f);
                instancePath.cubicTo(42.0f, 9.401778f, 32.59822f, 0.0f, 20.74074f, 0.0f);
                instancePath.cubicTo(9.401778f, 0.0f, 0.0f, 9.401778f, 0.0f, 21.25926f);
                instancePath.cubicTo(0.0f, 32.59822f, 9.401778f, 42.0f, 20.74074f, 42.0f);
                instancePath.cubicTo(32.59822f, 42.0f, 42.0f, 32.59822f, 42.0f, 21.25926f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint6);
                canvas.drawPath(instancePath, instancePaint7);
                canvas.restore();
                canvas.save();
                Paint instancePaint8 = c.instancePaint(instancePaint, looper);
                instancePaint8.setColor(-36352);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(7.1932015f, 22.069902f);
                instancePath2.cubicTo(7.0209723f, 21.90468f, 7.0013413f, 21.619408f, 7.147708f, 21.434807f);
                instancePath2.lineTo(8.144134f, 20.17808f);
                instancePath2.cubicTo(8.291237f, 19.992548f, 8.567782f, 19.95389f, 8.763619f, 20.093018f);
                instancePath2.lineTo(15.588285f, 24.941442f);
                instancePath2.cubicTo(15.783314f, 25.079996f, 16.094162f, 25.074368f, 16.278591f, 24.931952f);
                instancePath2.lineTo(33.272747f, 11.8091545f);
                instancePath2.cubicTo(33.45896f, 11.6653595f, 33.751038f, 11.677971f, 33.93421f, 11.845651f);
                instancePath2.lineTo(34.814766f, 12.651727f);
                instancePath2.cubicTo(34.993866f, 12.815679f, 34.995564f, 13.079486f, 34.821854f, 13.237947f);
                instancePath2.lineTo(16.258057f, 30.172258f);
                instancePath2.cubicTo(16.08287f, 30.332067f, 15.798551f, 30.325104f, 15.629005f, 30.162458f);
                instancePath2.lineTo(7.1932015f, 22.069902f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint8);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
