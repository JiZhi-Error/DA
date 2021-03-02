package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.smtt.sdk.WebView;

public class sight_icon_location_normal extends c {
    private final int height = 60;
    private final int width = 60;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 60;
            case 1:
                return 60;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 6.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-2236963);
                canvas.saveLayerAlpha(null, TbsListener.ErrorCode.UNLZMA_FAIURE, 31);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(13.408646f, 1.6899189f);
                instancePath.cubicTo(22.319056f, -1.1299042f, 32.56653f, 5.027872f, 34.52223f, 14.085183f);
                instancePath.cubicTo(36.098763f, 19.346195f, 33.48451f, 24.517532f, 30.890213f, 28.951529f);
                instancePath.cubicTo(27.13846f, 35.01963f, 22.788025f, 40.71906f, 17.988577f, 46.0f);
                instancePath.cubicTo(11.84209f, 39.005245f, 5.845274f, 31.601963f, 2.093522f, 23.012962f);
                instancePath.cubicTo(-1.6183176f, 14.404033f, 4.607994f, 3.9318275f, 13.408646f, 1.6899189f);
                instancePath.lineTo(13.408646f, 1.6899189f);
                instancePath.close();
                instancePath.moveTo(3.2691474f, 20.083824f);
                instancePath.cubicTo(6.0192595f, 28.886927f, 12.3555975f, 35.91335f, 18.006926f, 43.0f);
                instancePath.cubicTo(23.275455f, 36.49554f, 28.846195f, 29.981043f, 32.07984f, 22.171675f);
                instancePath.cubicTo(35.4243f, 14.271968f, 29.178625f, 4.7963343f, 20.978659f, 3.3810122f);
                instancePath.cubicTo(11.398599f, 0.9719528f, 1.2040452f, 10.397397f, 3.2691474f, 20.083824f);
                instancePath.lineTo(3.2691474f, 20.083824f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-1907998);
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 9.0f, 0.0f, 1.0f, 8.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.saveLayerAlpha(null, TbsListener.ErrorCode.TPATCH_FAIL, 31);
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint5, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(7.2950993f, 0.192574f);
                instancePath2.cubicTo(12.620774f, -1.0085815f, 18.16545f, 3.5875754f, 17.996222f, 9.017592f);
                instancePath2.cubicTo(18.175404f, 14.745417f, 11.923957f, 19.470623f, 6.448964f, 17.574585f);
                instancePath2.cubicTo(1.8499701f, 16.333721f, -1.0965714f, 11.032754f, 0.38665384f, 6.4961586f);
                instancePath2.cubicTo(1.2726072f, 3.309622f, 4.0598764f, 0.8378228f, 7.2950993f, 0.192574f);
                instancePath2.lineTo(7.2950993f, 0.192574f);
                instancePath2.close();
                instancePath2.moveTo(6.4085283f, 2.5550814f);
                instancePath2.cubicTo(1.6162406f, 4.3491087f, 0.31749043f, 11.2947f, 4.586251f, 14.351562f);
                instancePath2.cubicTo(8.462366f, 18.069908f, 15.227949f, 15.013046f, 15.912561f, 10.001798f);
                instancePath2.cubicTo(16.778395f, 5.100796f, 11.039731f, 0.35013187f, 6.4085283f, 2.5550814f);
                instancePath2.lineTo(6.4085283f, 2.5550814f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint6);
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
