package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class icons_filled_call_end extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-1);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, -0.70710677f, -0.70710677f, 16.485281f, 0.70710677f, -0.70710677f, 8.666666f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(9.212483f, 8.421594f);
                instancePath.cubicTo(9.089102f, 8.380463f, 9.037693f, 8.401029f, 8.924594f, 8.462725f);
                instancePath.cubicTo(8.554449f, 8.668381f, 7.6496515f, 9.161954f, 7.1149983f, 9.439589f);
                instancePath.cubicTo(6.981335f, 9.511568f, 6.8373904f, 9.552699f, 6.6728816f, 9.552699f);
                instancePath.cubicTo(6.498091f, 9.552699f, 6.3438644f, 9.501286f, 6.2102013f, 9.4190235f);
                instancePath.cubicTo(5.4596305f, 8.976864f, 4.750187f, 8.462725f, 4.1435614f, 7.8457584f);
                instancePath.cubicTo(3.5369358f, 7.2390747f, 3.0228462f, 6.529563f, 2.5807292f, 5.77892f);
                instancePath.cubicTo(2.4984748f, 5.645244f, 2.447066f, 5.4807196f, 2.447066f, 5.3161955f);
                instancePath.cubicTo(2.447066f, 5.161954f, 2.488193f, 5.007712f, 2.5601656f, 4.874036f);
                instancePath.cubicTo(2.837774f, 4.3290486f, 3.3312998f, 3.4241645f, 3.5369358f, 3.0642674f);
                instancePath.cubicTo(3.5986264f, 2.9511569f, 3.61919f, 2.88946f, 3.5780628f, 2.7763495f);
                instancePath.lineTo(2.7041106f, 0.45244217f);
                instancePath.cubicTo(2.591011f, 0.18508998f, 2.3339663f, 0.010282776f, 2.0255127f, 0.0f);
                instancePath.cubicTo(1.9021311f, 0.0f, 1.7581861f, 0.051413883f, 1.7273407f, 0.06169666f);
                instancePath.cubicTo(0.7197253f, 0.4318766f, 0.0f, 1.3881748f, 0.0f, 2.5192802f);
                instancePath.cubicTo(0.0f, 2.8380463f, 0.08225432f, 3.1362467f, 0.09253611f, 3.2082262f);
                instancePath.cubicTo(0.586062f, 5.367609f, 1.6862135f, 7.2904882f, 3.1976366f, 8.802056f);
                instancePath.cubicTo(4.7090597f, 10.313624f, 6.6317544f, 11.413881f, 8.790931f, 11.907455f);
                instancePath.cubicTo(8.862903f, 11.9280205f, 9.161075f, 12.0f, 9.47981f, 12.0f);
                instancePath.cubicTo(10.610807f, 12.0f, 11.567014f, 11.280206f, 11.937158f, 10.272493f);
                instancePath.cubicTo(11.94744f, 10.241645f, 12.0091305f, 10.097687f, 11.998849f, 9.974293f);
                instancePath.cubicTo(11.978285f, 9.66581f, 11.803494f, 9.40874f, 11.536168f, 9.2956295f);
                instancePath.lineTo(9.212483f, 8.421594f);
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
