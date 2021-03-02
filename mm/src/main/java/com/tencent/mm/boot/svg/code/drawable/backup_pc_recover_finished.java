package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiOpenAdCanvas;
import com.tencent.mm.plugin.appbrand.jsapi.audio.l;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class backup_pc_recover_finished extends c {
    private final int height = l.CTRL_INDEX;
    private final int width = JsApiOpenAdCanvas.CTRL_INDEX;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return JsApiOpenAdCanvas.CTRL_INDEX;
            case 1:
                return l.CTRL_INDEX;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, -1.0f, 0.0f, 473.0f, 0.0f, 1.0f, 2.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-13158344);
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, -1.0f, 0.0f, 470.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(304.0f, 278.731f);
                instancePath.lineTo(304.0f, 284.001f);
                instancePath.lineTo(166.0f, 284.001f);
                instancePath.lineTo(166.0f, 278.731f);
                instancePath.lineTo(219.0f, 273.731f);
                instancePath.lineTo(219.0f, 240.001f);
                instancePath.lineTo(251.0f, 240.001f);
                instancePath.lineTo(251.0f, 273.731f);
                instancePath.lineTo(304.0f, 278.731f);
                instancePath.close();
                instancePath.moveTo(254.0f, 240.0f);
                instancePath.lineTo(366.985f, 240.0f);
                instancePath.lineTo(366.985f, 237.001f);
                instancePath.lineTo(254.0f, 237.001f);
                instancePath.lineTo(216.0f, 237.0f);
                instancePath.lineTo(62.006f, 237.001f);
                instancePath.cubicTo(55.938f, 237.001f, 51.0f, 232.063f, 51.0f, 225.994f);
                instancePath.lineTo(51.0f, 14.007f);
                instancePath.cubicTo(51.0f, 7.938f, 55.938f, 3.001f, 62.006f, 3.001f);
                instancePath.lineTo(407.993f, 3.001f);
                instancePath.cubicTo(414.063f, 3.001f, 419.0f, 7.938f, 419.0f, 14.007f);
                instancePath.lineTo(419.0f, 97.39f);
                instancePath.lineTo(422.0f, 97.39f);
                instancePath.lineTo(422.0f, 14.007f);
                instancePath.cubicTo(422.0f, 6.266f, 415.729f, 0.0f, 407.993f, 0.0f);
                instancePath.lineTo(62.007f, 0.0f);
                instancePath.cubicTo(54.276f, 0.0f, 48.0f, 6.271f, 48.0f, 14.007f);
                instancePath.lineTo(48.0f, 225.994f);
                instancePath.cubicTo(48.0f, 233.735f, 54.271f, 240.0f, 62.007f, 240.0f);
                instancePath.lineTo(216.0f, 240.0f);
                instancePath.lineTo(216.0f, 271.0f);
                instancePath.lineTo(163.0f, 276.0f);
                instancePath.lineTo(163.0f, 287.0f);
                instancePath.lineTo(307.0f, 287.0f);
                instancePath.lineTo(307.0f, 276.0f);
                instancePath.lineTo(254.0f, 271.0f);
                instancePath.lineTo(254.0f, 240.0f);
                instancePath.close();
                instancePath.moveTo(365.9854f, 226.0006f);
                instancePath.lineTo(62.0004f, 226.0006f);
                instancePath.lineTo(62.0004f, 14.0006f);
                instancePath.lineTo(408.0004f, 14.0006f);
                instancePath.lineTo(408.0004f, 95.3906f);
                instancePath.cubicTo(408.0004f, 95.3906f, 408.9994f, 97.02239f, 408.9994f, 95.01775f);
                instancePath.lineTo(408.9994f, 13.0006f);
                instancePath.lineTo(60.9994f, 13.0006f);
                instancePath.lineTo(60.9994f, 227.0006f);
                instancePath.lineTo(365.9854f, 227.0006f);
                instancePath.lineTo(365.9854f, 226.0006f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-15028967);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(185.0f, 117.61729f);
                instancePath2.cubicTo(185.0f, 89.385185f, 207.38518f, 67.0f, 235.61728f, 67.0f);
                instancePath2.cubicTo(262.6148f, 67.0f, 285.0f, 89.385185f, 285.0f, 117.61729f);
                instancePath2.cubicTo(285.0f, 144.61482f, 262.6148f, 167.0f, 235.61728f, 167.0f);
                instancePath2.cubicTo(207.38518f, 167.0f, 185.0f, 144.61482f, 185.0f, 117.61729f);
                instancePath2.close();
                instancePath2.moveTo(188.0f, 117.580246f);
                instancePath2.cubicTo(188.0f, 91.042076f, 209.04207f, 70.0f, 235.58025f, 70.0f);
                instancePath2.cubicTo(260.95792f, 70.0f, 282.0f, 91.042076f, 282.0f, 117.580246f);
                instancePath2.cubicTo(282.0f, 142.95793f, 260.95792f, 164.0f, 235.58025f, 164.0f);
                instancePath2.cubicTo(209.04207f, 164.0f, 188.0f, 142.95793f, 188.0f, 117.580246f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-15028967);
                float[] matrixFloatArray3 = c.setMatrixFloatArray(matrixFloatArray2, -1.0f, 0.0f, 468.67923f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray3);
                canvas.concat(instanceMatrix);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(208.31874f, 119.193306f);
                instancePath3.cubicTo(207.93587f, 118.79706f, 207.89252f, 118.1125f, 208.21802f, 117.66961f);
                instancePath3.lineTo(209.92644f, 115.34499f);
                instancePath3.cubicTo(210.25368f, 114.89973f, 210.8712f, 114.808754f, 211.3054f, 115.14154f);
                instancePath3.lineTo(223.18962f, 124.250114f);
                instancePath3.cubicTo(224.06194f, 124.918686f, 225.45206f, 124.8917f, 226.3035f, 124.18238f);
                instancePath3.lineTo(257.44058f, 98.24268f);
                instancePath3.cubicTo(257.86093f, 97.8925f, 258.5224f, 97.92535f, 258.91693f, 98.31499f);
                instancePath3.lineTo(260.37988f, 99.75982f);
                instancePath3.cubicTo(260.7749f, 100.14993f, 260.7811f, 100.77525f, 260.38577f, 101.1643f);
                instancePath3.lineTo(226.19208f, 134.816f);
                instancePath3.cubicTo(225.4056f, 135.59003f, 224.14778f, 135.57558f, 223.3797f, 134.78064f);
                instancePath3.lineTo(208.31874f, 119.193306f);
                instancePath3.close();
                WeChatSVGRenderC2Java.setFillType(instancePath3, 2);
                canvas.drawPath(instancePath3, instancePaint5);
                canvas.restore();
                canvas.save();
                float[] matrixFloatArray4 = c.setMatrixFloatArray(matrixFloatArray3, -1.0f, 0.0f, 106.0f, 0.0f, 1.0f, 96.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray4);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint, looper);
                instancePaint6.setColor(-13092808);
                Path instancePath4 = c.instancePath(looper);
                instancePath4.moveTo(3.0f, 183.006f);
                instancePath4.lineTo(3.0f, 7.994f);
                instancePath4.cubicTo(3.0f, 5.24f, 5.243f, 3.0f, 8.0f, 3.0f);
                instancePath4.lineTo(98.0f, 3.0f);
                instancePath4.cubicTo(100.757f, 3.0f, 103.0f, 5.24f, 103.0f, 7.994f);
                instancePath4.lineTo(103.0f, 183.006f);
                instancePath4.cubicTo(103.0f, 185.76f, 100.757f, 188.0f, 98.0f, 188.0f);
                instancePath4.lineTo(8.0f, 188.0f);
                instancePath4.cubicTo(5.243f, 188.0f, 3.0f, 185.76f, 3.0f, 183.006f);
                instancePath4.lineTo(3.0f, 183.006f);
                instancePath4.close();
                instancePath4.moveTo(98.0f, 191.0f);
                instancePath4.cubicTo(102.418f, 191.0f, 106.0f, 187.418f, 106.0f, 183.006f);
                instancePath4.lineTo(106.0f, 7.994f);
                instancePath4.cubicTo(106.0f, 3.579f, 102.412f, 0.0f, 98.0f, 0.0f);
                instancePath4.lineTo(8.0f, 0.0f);
                instancePath4.cubicTo(3.582f, 0.0f, 0.0f, 3.582f, 0.0f, 7.994f);
                instancePath4.lineTo(0.0f, 183.006f);
                instancePath4.cubicTo(0.0f, 187.421f, 3.588f, 191.0f, 8.0f, 191.0f);
                instancePath4.lineTo(98.0f, 191.0f);
                instancePath4.close();
                WeChatSVGRenderC2Java.setFillType(instancePath4, 2);
                canvas.drawPath(instancePath4, instancePaint6);
                canvas.restore();
                canvas.save();
                float[] matrixFloatArray5 = c.setMatrixFloatArray(matrixFloatArray4, 1.0f, 0.0f, 35.0f, 0.0f, 1.0f, 77.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray5);
                canvas.concat(instanceMatrix);
                canvas.restore();
                canvas.save();
                float[] matrixFloatArray6 = c.setMatrixFloatArray(matrixFloatArray5, 1.0f, 0.0f, 7.0f, 0.0f, 1.0f, 10.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray6);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint, looper);
                instancePaint7.setColor(-13092808);
                Path instancePath5 = c.instancePath(looper);
                instancePath5.moveTo(1.0f, 157.0f);
                instancePath5.lineTo(91.0f, 157.0f);
                instancePath5.lineTo(91.0f, 11.0f);
                instancePath5.lineTo(1.0f, 11.0f);
                instancePath5.lineTo(1.0f, 157.0f);
                instancePath5.close();
                instancePath5.moveTo(0.0f, 158.0f);
                instancePath5.lineTo(92.0f, 158.0f);
                instancePath5.lineTo(92.0f, 10.0f);
                instancePath5.lineTo(0.0f, 10.0f);
                instancePath5.lineTo(0.0f, 158.0f);
                instancePath5.close();
                WeChatSVGRenderC2Java.setFillType(instancePath5, 2);
                canvas.drawPath(instancePath5, instancePaint7);
                canvas.restore();
                canvas.save();
                Paint instancePaint8 = c.instancePaint(instancePaint, looper);
                instancePaint8.setColor(-6776677);
                Path instancePath6 = c.instancePath(looper);
                instancePath6.moveTo(13.652f, 53.817215f);
                instancePath6.cubicTo(12.7396f, 53.817215f, 12.0f, 53.186596f, 12.0f, 52.40864f);
                instancePath6.cubicTo(12.0f, 51.63062f, 12.7396f, 51.0f, 13.652f, 51.0f);
                instancePath6.lineTo(66.348f, 51.0f);
                instancePath6.cubicTo(67.2604f, 51.0f, 68.0f, 51.63062f, 68.0f, 52.408573f);
                instancePath6.cubicTo(68.0f, 53.186527f, 67.2604f, 53.817215f, 66.348f, 53.817215f);
                instancePath6.lineTo(13.652f, 53.817215f);
                instancePath6.close();
                instancePath6.moveTo(77.994f, 69.387474f);
                instancePath6.lineTo(14.0060005f, 69.387474f);
                instancePath6.cubicTo(12.898087f, 69.387474f, 12.0f, 68.75686f, 12.0f, 67.978905f);
                instancePath6.lineTo(12.0f, 67.978836f);
                instancePath6.cubicTo(12.0f, 67.20088f, 12.898087f, 66.57026f, 14.0060005f, 66.57026f);
                instancePath6.lineTo(77.994f, 66.57026f);
                instancePath6.cubicTo(79.10191f, 66.57026f, 80.0f, 67.20088f, 80.0f, 67.978836f);
                instancePath6.lineTo(80.0f, 67.978905f);
                instancePath6.cubicTo(80.0f, 68.75686f, 79.10191f, 69.387474f, 77.994f, 69.387474f);
                instancePath6.lineTo(77.994f, 69.387474f);
                instancePath6.close();
                instancePath6.moveTo(46.024593f, 84.25f);
                instancePath6.lineTo(13.975407f, 84.25f);
                instancePath6.cubicTo(12.884389f, 84.25f, 12.0f, 83.61937f, 12.0f, 82.84139f);
                instancePath6.lineTo(12.0f, 82.84139f);
                instancePath6.cubicTo(12.0f, 82.063416f, 12.884389f, 81.432785f, 13.975407f, 81.432785f);
                instancePath6.lineTo(46.024593f, 81.432785f);
                instancePath6.cubicTo(47.115612f, 81.432785f, 48.0f, 82.063416f, 48.0f, 82.84139f);
                instancePath6.lineTo(48.0f, 82.84139f);
                instancePath6.cubicTo(47.9999f, 83.61937f, 47.115513f, 84.25f, 46.024593f, 84.25f);
                instancePath6.lineTo(46.024593f, 84.25f);
                instancePath6.close();
                WeChatSVGRenderC2Java.setFillType(instancePath6, 2);
                canvas.drawPath(instancePath6, instancePaint8);
                canvas.restore();
                canvas.save();
                Paint instancePaint9 = c.instancePaint(instancePaint, looper);
                instancePaint9.setColor(-13092808);
                Path instancePath7 = c.instancePath(looper);
                instancePath7.moveTo(39.0f, 3.0f);
                instancePath7.lineTo(53.0f, 3.0f);
                instancePath7.lineTo(53.0f, 0.0f);
                instancePath7.lineTo(39.0f, 0.0f);
                instancePath7.close();
                WeChatSVGRenderC2Java.setFillType(instancePath7, 1);
                WeChatSVGRenderC2Java.setFillType(instancePath7, 2);
                canvas.drawPath(instancePath7, instancePaint9);
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