package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class fts_websearch_icon extends c {
    private final int height = 41;
    private final int width = 40;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 40;
            case 1:
                return 41;
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
                instancePaint3.setColor(-372399);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 2.0f, 0.0f, 1.0f, 2.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(18.772556f, 3.5759952f);
                instancePath.cubicTo(19.052969f, 2.9365315f, 19.074936f, 2.2434814f, 18.83378f, 1.6249421f);
                instancePath.cubicTo(18.592627f, 1.0053818f, 18.119196f, 0.5414772f, 17.500887f, 0.31794563f);
                instancePath.lineTo(16.979788f, 0.13013826f);
                instancePath.cubicTo(16.740969f, 0.04337942f, 16.49701f, 0.0f, 16.254454f, 0.0f);
                instancePath.cubicTo(15.232818f, 0.0f, 14.37569f, 0.78644335f, 14.170522f, 1.9132875f);
                instancePath.lineTo(13.081587f, 7.893013f);
                instancePath.cubicTo(12.819402f, 9.330658f, 13.208707f, 10.672358f, 13.968625f, 10.946924f);
                instancePath.cubicTo(14.066302f, 10.982138f, 14.170522f, 11.0f, 14.278948f, 11.0f);
                instancePath.cubicTo(15.006151f, 11.0f, 15.860941f, 10.209984f, 16.357271f, 9.078036f);
                instancePath.lineTo(18.772556f, 3.5759952f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(8.995767f, 14.805049f);
                instancePath2.cubicTo(9.072482f, 13.81314f, 8.097905f, 12.72122f, 6.777158f, 12.321181f);
                instancePath2.lineTo(2.7135763f, 11.086558f);
                instancePath2.cubicTo(2.5260484f, 11.0292425f, 2.3361526f, 11.0f, 2.1495714f, 11.0f);
                instancePath2.cubicTo(1.043819f, 11.0f, 0.16300532f, 12.014133f, 0.054087505f, 13.410761f);
                instancePath2.lineTo(1.0215474E-4f, 14.119018f);
                instancePath2.cubicTo(-0.0055805137f, 14.971732f, 0.22598822f, 15.734964f, 0.65360904f, 16.266596f);
                instancePath2.cubicTo(1.0386099f, 16.746174f, 1.5481558f, 17.0f, 2.127788f, 17.0f);
                instancePath2.cubicTo(2.1694608f, 17.0f, 2.212081f, 16.998245f, 2.254701f, 16.995907f);
                instancePath2.lineTo(6.4361978f, 16.728628f);
                instancePath2.cubicTo(7.793882f, 16.641485f, 8.918103f, 15.796959f, 8.995767f, 14.805049f);
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint3, looper);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(11.986993f, 19.054195f);
                instancePath3.cubicTo(11.155705f, 18.762688f, 10.011075f, 19.676445f, 9.425617f, 21.090944f);
                instancePath3.lineTo(5.2171283f, 31.25997f);
                instancePath3.cubicTo(4.9310994f, 31.951962f, 4.9274917f, 32.69953f, 5.2073364f, 33.36537f);
                instancePath3.cubicTo(5.487696f, 34.0323f, 6.016463f, 34.53195f, 6.696748f, 34.771698f);
                instancePath3.lineTo(7.2703514f, 34.973846f);
                instancePath3.lineTo(7.327557f, 34.986378f);
                instancePath3.cubicTo(7.420839f, 34.995094f, 7.519789f, 35.0f, 7.622863f, 35.0f);
                instancePath3.cubicTo(8.819546f, 35.0f, 10.157954f, 34.41371f, 10.4522295f, 33.103832f);
                instancePath3.lineTo(12.876001f, 22.307108f);
                instancePath3.cubicTo(13.21872f, 20.779274f, 12.828073f, 19.350063f, 11.986993f, 19.054195f);
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint6);
                canvas.restore();
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint3, looper);
                Path instancePath4 = c.instancePath(looper);
                instancePath4.moveTo(19.488386f, 20.241226f);
                instancePath4.cubicTo(18.80132f, 19.475615f, 17.931036f, 19.0f, 17.215666f, 19.0f);
                instancePath4.cubicTo(16.912018f, 19.0f, 16.645426f, 19.089312f, 16.44471f, 19.259329f);
                instancePath4.cubicTo(15.754558f, 19.842548f, 15.880648f, 21.296293f, 16.732918f, 22.569801f);
                instancePath4.lineTo(24.960207f, 34.870148f);
                instancePath4.cubicTo(25.44038f, 35.58787f, 26.186117f, 36.0f, 27.00442f, 36.0f);
                instancePath4.cubicTo(27.580835f, 36.0f, 28.12843f, 35.794476f, 28.58956f, 35.405483f);
                instancePath4.lineTo(29.058413f, 35.00842f);
                instancePath4.cubicTo(29.61424f, 34.5398f, 29.946194f, 33.88233f, 29.994057f, 33.158688f);
                instancePath4.cubicTo(30.04192f, 32.43504f, 29.799517f, 31.736685f, 29.310593f, 31.192202f);
                instancePath4.lineTo(19.488386f, 20.241226f);
                instancePath4.close();
                WeChatSVGRenderC2Java.setFillType(instancePath4, 2);
                canvas.drawPath(instancePath4, instancePaint7);
                canvas.restore();
                canvas.save();
                Paint instancePaint8 = c.instancePaint(instancePaint3, looper);
                Path instancePath5 = c.instancePath(looper);
                instancePath5.moveTo(33.181255f, 15.722694f);
                instancePath5.lineTo(33.181255f, 15.722694f);
                instancePath5.lineTo(33.181255f, 15.724368f);
                instancePath5.lineTo(33.181255f, 15.722694f);
                instancePath5.close();
                instancePath5.moveTo(35.96208f, 12.519454f);
                instancePath5.cubicTo(35.87719f, 10.947126f, 34.59592f, 9.797732f, 33.074745f, 10.029843f);
                instancePath5.lineTo(20.595829f, 11.953684f);
                instancePath5.cubicTo(19.089943f, 12.186353f, 17.95051f, 13.118144f, 18.001656f, 14.074485f);
                instancePath5.cubicTo(18.052275f, 15.033616f, 19.286615f, 15.804714f, 20.81201f, 15.829265f);
                instancePath5.lineTo(33.13749f, 15.999442f);
                instancePath5.lineTo(33.181255f, 16.0f);
                instancePath5.cubicTo(33.982704f, 16.0f, 34.78574f, 15.636211f, 35.329353f, 15.026362f);
                instancePath5.cubicTo(35.79599f, 14.504113f, 36.032734f, 13.845722f, 35.996353f, 13.172824f);
                instancePath5.lineTo(35.96208f, 12.519454f);
                instancePath5.close();
                WeChatSVGRenderC2Java.setFillType(instancePath5, 2);
                canvas.drawPath(instancePath5, instancePaint8);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
