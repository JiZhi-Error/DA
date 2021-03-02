package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class websearch_icon_novel extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint2, looper);
                instancePaint3.setStrokeWidth(1.0f);
                canvas.save();
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -265.0f, 0.0f, 1.0f, -671.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 66.0f, 0.0f, 1.0f, 602.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray3 = c.setMatrixFloatArray(matrixFloatArray2, 1.0f, 0.0f, 198.0f, 0.0f, 1.0f, 68.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray3);
                canvas.concat(instanceMatrix);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(0.0f, 0.0f);
                instancePath.lineTo(18.0f, 0.0f);
                instancePath.lineTo(18.0f, 18.0f);
                instancePath.lineTo(0.0f, 18.0f);
                instancePath.lineTo(0.0f, 0.0f);
                instancePath.close();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(-5066062);
                instancePaint5.setColor(-5066062);
                instancePaint5.setStrokeWidth(0.2f);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(16.273369f, 4.9895744f);
                instancePath2.cubicTo(16.236847f, 4.9764895f, 15.897717f, 4.8631916f, 15.20087f, 4.8631916f);
                instancePath2.cubicTo(14.215761f, 4.8631916f, 12.576522f, 5.093936f, 10.146522f, 6.0692554f);
                instancePath2.cubicTo(11.12087f, 5.16f, 12.914674f, 3.9513829f, 15.672717f, 3.8023405f);
                instancePath2.cubicTo(15.852391f, 3.7927659f, 15.990326f, 3.6424468f, 15.980217f, 3.466915f);
                instancePath2.cubicTo(15.970435f, 3.2907448f, 15.810327f, 3.15f, 15.637174f, 3.1662767f);
                instancePath2.cubicTo(12.882391f, 3.3146808f, 11.03413f, 4.423404f, 9.940761f, 5.3712764f);
                instancePath2.cubicTo(10.647717f, 4.251064f, 12.105978f, 2.8346808f, 15.084783f, 2.1596808f);
                instancePath2.cubicTo(15.260218f, 2.1197872f, 15.36913f, 1.9487234f, 15.329021f, 1.7770213f);
                instancePath2.cubicTo(15.288587f, 1.6053191f, 15.1151085f, 1.4987234f, 14.938044f, 1.5382979f);
                instancePath2.cubicTo(11.057935f, 2.4175532f, 9.562174f, 4.4645743f, 8.9908695f, 5.757766f);
                instancePath2.cubicTo(8.419239f, 4.4645743f, 6.923478f, 2.4175532f, 3.0433695f, 1.5382979f);
                instancePath2.cubicTo(2.8679347f, 1.4984043f, 2.6931522f, 1.6053191f, 2.6523912f, 1.7770213f);
                instancePath2.cubicTo(2.6119566f, 1.9487234f, 2.7211957f, 2.1197872f, 2.8966305f, 2.1596808f);
                instancePath2.cubicTo(5.9302173f, 2.8468084f, 7.383913f, 4.2781916f, 8.075217f, 5.4009576f);
                instancePath2.cubicTo(6.986087f, 4.4470215f, 5.1280437f, 3.3162766f, 2.3442392f, 3.1662767f);
                instancePath2.cubicTo(2.163261f, 3.1512766f, 2.0109782f, 3.2910638f, 2.0011957f, 3.466915f);
                instancePath2.cubicTo(1.991087f, 3.6424468f, 2.1286957f, 3.7927659f, 2.3083696f, 3.8023405f);
                instancePath2.cubicTo(5.0996737f, 3.9532979f, 6.9061956f, 5.190319f, 7.872065f, 6.102766f);
                instancePath2.cubicTo(5.3977175f, 5.0964894f, 3.7545652f, 4.862872f, 2.7756522f, 4.862872f);
                instancePath2.cubicTo(2.0892391f, 4.862872f, 1.7576087f, 4.977447f, 1.7220652f, 4.990213f);
                instancePath2.cubicTo(1.5851088f, 5.0406384f, 1.4990218f, 5.1746807f, 1.5120652f, 5.3170214f);
                instancePath2.lineTo(2.2979348f, 13.944894f);
                instancePath2.cubicTo(2.3129349f, 14.109574f, 2.4541304f, 14.235319f, 2.6223912f, 14.235319f);
                instancePath2.cubicTo(2.6240218f, 14.235319f, 2.6259782f, 14.235319f, 2.6279347f, 14.235319f);
                instancePath2.lineTo(2.767174f, 14.234042f);
                instancePath2.cubicTo(6.0361958f, 14.234042f, 8.7482605f, 16.10234f, 8.775326f, 16.121489f);
                instancePath2.cubicTo(8.781522f, 16.126276f, 8.79f, 16.124361f, 8.796522f, 16.128191f);
                instancePath2.cubicTo(8.803696f, 16.13266f, 8.807282f, 16.141277f, 8.815108f, 16.145426f);
                instancePath2.cubicTo(8.862391f, 16.169361f, 8.913587f, 16.18117f, 8.965109f, 16.18117f);
                instancePath2.cubicTo(9.015978f, 16.18117f, 9.067174f, 16.169361f, 9.11413f, 16.145426f);
                instancePath2.cubicTo(9.121631f, 16.141596f, 9.124891f, 16.133297f, 9.132391f, 16.129148f);
                instancePath2.cubicTo(9.138913f, 16.125319f, 9.147065f, 16.126915f, 9.153261f, 16.122446f);
                instancePath2.cubicTo(9.180653f, 16.103617f, 11.926304f, 14.234042f, 15.196957f, 14.234042f);
                instancePath2.lineTo(15.336196f, 14.235319f);
                instancePath2.cubicTo(15.338152f, 14.235319f, 15.340109f, 14.235319f, 15.341413f, 14.235319f);
                instancePath2.cubicTo(15.509348f, 14.235319f, 15.650543f, 14.110212f, 15.66587f, 13.94617f);
                instancePath2.lineTo(16.48663f, 5.318617f);
                instancePath2.cubicTo(16.5f, 5.1743617f, 16.412283f, 5.0390425f, 16.273369f, 4.9895744f);
                instancePath2.close();
                instancePath2.moveTo(2.1867392f, 5.53883f);
                instancePath2.cubicTo(2.3223913f, 5.5187235f, 2.5173912f, 5.5002127f, 2.7756522f, 5.5002127f);
                instancePath2.cubicTo(3.821087f, 5.5002127f, 5.680761f, 5.785532f, 8.639348f, 7.127234f);
                instancePath2.lineTo(8.639348f, 15.279255f);
                instancePath2.cubicTo(7.683261f, 14.721064f, 5.5040216f, 13.639468f, 2.9207609f, 13.59766f);
                instancePath2.lineTo(2.1867392f, 5.53883f);
                instancePath2.close();
                instancePath2.moveTo(15.044348f, 13.597979f);
                instancePath2.cubicTo(12.453913f, 13.639468f, 10.2525f, 14.726171f, 9.290544f, 15.282447f);
                instancePath2.lineTo(9.290544f, 7.127234f);
                instancePath2.cubicTo(12.250109f, 5.785532f, 14.134239f, 5.5002127f, 15.200543f, 5.5002127f);
                instancePath2.cubicTo(15.468587f, 5.5002127f, 15.670761f, 5.5193615f, 15.810652f, 5.5397873f);
                instancePath2.lineTo(15.044348f, 13.597979f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.drawPath(instancePath2, instancePaint5);
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
