package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class app_brand_video_fullscreen_danmaku_showed_btn extends c {
    private final int height = 67;
    private final int width = 156;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 156;
            case 1:
                return 67;
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
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, -353.0f, 0.0f, 1.0f, -237.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                float[] matrixFloatArray2 = c.setMatrixFloatArray(matrixFloatArray, 1.0f, 0.0f, 353.0f, 0.0f, 1.0f, 237.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray2);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(-16139513);
                instancePaint4.setStrokeWidth(4.0f);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(2.0f, 33.5f);
                instancePath.cubicTo(2.0f, 16.10303f, 16.10303f, 2.0f, 33.5f, 2.0f);
                instancePath.lineTo(122.5f, 2.0f);
                instancePath.cubicTo(139.89697f, 2.0f, 154.0f, 16.10303f, 154.0f, 33.5f);
                instancePath.lineTo(154.0f, 33.5f);
                instancePath.cubicTo(154.0f, 50.896973f, 139.89697f, 65.0f, 122.5f, 65.0f);
                instancePath.lineTo(33.5f, 65.0f);
                instancePath.cubicTo(16.10303f, 65.0f, 2.0f, 50.896973f, 2.0f, 33.5f);
                instancePath.lineTo(2.0f, 33.5f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint, looper);
                instancePaint5.setColor(-16139513);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(45.341103f, 26.941479f);
                instancePath2.lineTo(52.543945f, 26.941479f);
                instancePath2.lineTo(52.543945f, 16.137213f);
                instancePath2.lineTo(42.314373f, 16.137213f);
                instancePath2.lineTo(42.314373f, 18.550932f);
                instancePath2.lineTo(49.862038f, 18.550932f);
                instancePath2.lineTo(49.862038f, 24.52776f);
                instancePath2.lineTo(42.88907f, 24.52776f);
                instancePath2.lineTo(41.892933f, 35.561905f);
                instancePath2.lineTo(50.245167f, 35.561905f);
                instancePath2.cubicTo(50.245167f, 40.159462f, 50.0536f, 43.224503f, 49.67047f, 44.680397f);
                instancePath2.cubicTo(49.325653f, 46.059666f, 48.02301f, 46.787613f, 45.762547f, 46.787613f);
                instancePath2.cubicTo(44.804718f, 46.787613f, 43.88521f, 46.710987f, 42.965694f, 46.63436f);
                instancePath2.lineTo(43.65533f, 49.201332f);
                instancePath2.cubicTo(44.57484f, 49.277958f, 45.494354f, 49.354584f, 46.375553f, 49.354584f);
                instancePath2.cubicTo(49.785408f, 49.201332f, 51.739372f, 48.05194f, 52.237442f, 45.82979f);
                instancePath2.cubicTo(52.62057f, 43.837513f, 52.85045f, 39.584766f, 52.85045f, 33.148186f);
                instancePath2.lineTo(44.68978f, 33.148186f);
                instancePath2.lineTo(45.341103f, 26.941479f);
                instancePath2.close();
                instancePath2.moveTo(55.838863f, 20.734772f);
                instancePath2.lineTo(66.987946f, 20.734772f);
                instancePath2.cubicTo(68.13734f, 18.66587f, 69.09516f, 16.520342f, 69.93805f, 14.259875f);
                instancePath2.lineTo(72.58164f, 15.179387f);
                instancePath2.cubicTo(71.73876f, 17.24829f, 70.78094f, 19.125626f, 69.70817f, 20.734772f);
                instancePath2.lineTo(74.68886f, 20.734772f);
                instancePath2.lineTo(74.68886f, 36.098286f);
                instancePath2.lineTo(66.52819f, 36.098286f);
                instancePath2.lineTo(66.52819f, 39.814648f);
                instancePath2.lineTo(76.37463f, 39.814648f);
                instancePath2.lineTo(76.37463f, 42.38162f);
                instancePath2.lineTo(66.52819f, 42.38162f);
                instancePath2.lineTo(66.52819f, 49.737713f);
                instancePath2.lineTo(63.84628f, 49.737713f);
                instancePath2.lineTo(63.84628f, 42.38162f);
                instancePath2.lineTo(54.15309f, 42.38162f);
                instancePath2.lineTo(54.15309f, 39.814648f);
                instancePath2.lineTo(63.84628f, 39.814648f);
                instancePath2.lineTo(63.84628f, 36.098286f);
                instancePath2.lineTo(55.838863f, 36.098286f);
                instancePath2.lineTo(55.838863f, 20.734772f);
                instancePath2.close();
                instancePath2.moveTo(72.19852f, 33.761192f);
                instancePath2.lineTo(72.19852f, 29.623388f);
                instancePath2.lineTo(66.52819f, 29.623388f);
                instancePath2.lineTo(66.52819f, 33.761192f);
                instancePath2.lineTo(72.19852f, 33.761192f);
                instancePath2.close();
                instancePath2.moveTo(63.84628f, 33.761192f);
                instancePath2.lineTo(63.84628f, 29.623388f);
                instancePath2.lineTo(58.290897f, 29.623388f);
                instancePath2.lineTo(58.290897f, 33.761192f);
                instancePath2.lineTo(63.84628f, 33.761192f);
                instancePath2.close();
                instancePath2.moveTo(58.290897f, 27.324608f);
                instancePath2.lineTo(63.84628f, 27.324608f);
                instancePath2.lineTo(63.84628f, 23.071865f);
                instancePath2.lineTo(58.290897f, 23.071865f);
                instancePath2.lineTo(58.290897f, 27.324608f);
                instancePath2.close();
                instancePath2.moveTo(66.52819f, 23.071865f);
                instancePath2.lineTo(66.52819f, 27.324608f);
                instancePath2.lineTo(72.19852f, 27.324608f);
                instancePath2.lineTo(72.19852f, 23.071865f);
                instancePath2.lineTo(66.52819f, 23.071865f);
                instancePath2.close();
                instancePath2.moveTo(60.3598f, 14.489753f);
                instancePath2.cubicTo(61.50919f, 16.060587f, 62.505325f, 17.746359f, 63.348213f, 19.508757f);
                instancePath2.lineTo(60.972805f, 20.543207f);
                instancePath2.cubicTo(60.053295f, 18.550932f, 58.98053f, 16.826847f, 57.83114f, 15.294326f);
                instancePath2.lineTo(60.3598f, 14.489753f);
                instancePath2.close();
                instancePath2.moveTo(95.952576f, 37.515865f);
                instancePath2.lineTo(98.55786f, 37.515865f);
                instancePath2.lineTo(98.55786f, 40.197777f);
                instancePath2.lineTo(107.408165f, 40.197777f);
                instancePath2.cubicTo(105.33926f, 38.97176f, 103.73012f, 37.669117f, 102.58073f, 36.213223f);
                instancePath2.lineTo(92.65765f, 36.213223f);
                instancePath2.cubicTo(91.3167f, 37.669117f, 89.63093f, 39.010075f, 87.60034f, 40.197777f);
                instancePath2.lineTo(95.952576f, 40.197777f);
                instancePath2.lineTo(95.952576f, 37.515865f);
                instancePath2.close();
                instancePath2.moveTo(95.952576f, 42.304993f);
                instancePath2.lineTo(88.71142f, 42.304993f);
                instancePath2.lineTo(88.71142f, 48.703262f);
                instancePath2.lineTo(86.10613f, 48.703262f);
                instancePath2.lineTo(86.10613f, 41.00235f);
                instancePath2.cubicTo(84.49699f, 41.806923f, 82.7729f, 42.53487f, 80.933876f, 43.18619f);
                instancePath2.lineTo(79.74618f, 40.88741f);
                instancePath2.cubicTo(83.88398f, 39.584766f, 87.10227f, 38.05225f, 89.36274f, 36.213223f);
                instancePath2.lineTo(80.704f, 36.213223f);
                instancePath2.lineTo(80.704f, 33.914444f);
                instancePath2.lineTo(91.58489f, 33.914444f);
                instancePath2.cubicTo(92.04465f, 33.263123f, 92.42778f, 32.6118f, 92.73428f, 31.922169f);
                instancePath2.lineTo(84.918434f, 31.922169f);
                instancePath2.lineTo(84.918434f, 21.769222f);
                instancePath2.lineTo(89.36274f, 21.769222f);
                instancePath2.lineTo(89.36274f, 19.317192f);
                instancePath2.lineTo(80.24425f, 19.317192f);
                instancePath2.lineTo(80.24425f, 17.056725f);
                instancePath2.lineTo(89.36274f, 17.056725f);
                instancePath2.lineTo(89.36274f, 14.489753f);
                instancePath2.lineTo(92.00633f, 14.489753f);
                instancePath2.lineTo(92.00633f, 17.056725f);
                instancePath2.lineTo(102.38916f, 17.056725f);
                instancePath2.lineTo(102.38916f, 14.489753f);
                instancePath2.lineTo(105.03275f, 14.489753f);
                instancePath2.lineTo(105.03275f, 17.056725f);
                instancePath2.lineTo(114.15125f, 17.056725f);
                instancePath2.lineTo(114.15125f, 19.317192f);
                instancePath2.lineTo(105.03275f, 19.317192f);
                instancePath2.lineTo(105.03275f, 21.769222f);
                instancePath2.lineTo(109.477066f, 21.769222f);
                instancePath2.lineTo(109.477066f, 31.922169f);
                instancePath2.lineTo(95.301254f, 31.922169f);
                instancePath2.cubicTo(95.033066f, 32.6118f, 94.72656f, 33.263123f, 94.34343f, 33.914444f);
                instancePath2.lineTo(113.65318f, 33.914444f);
                instancePath2.lineTo(113.65318f, 36.213223f);
                instancePath2.lineTo(105.37757f, 36.213223f);
                instancePath2.cubicTo(107.48479f, 38.09056f, 110.62646f, 39.584766f, 114.76426f, 40.65753f);
                instancePath2.lineTo(113.65318f, 42.956314f);
                instancePath2.cubicTo(111.890785f, 42.343304f, 110.35826f, 41.730297f, 109.05562f, 41.078976f);
                instancePath2.lineTo(109.05562f, 45.714848f);
                instancePath2.cubicTo(109.05562f, 47.707123f, 107.94454f, 48.741573f, 105.72239f, 48.741573f);
                instancePath2.lineTo(102.8106f, 48.741573f);
                instancePath2.lineTo(102.23591f, 46.442795f);
                instancePath2.lineTo(104.95613f, 46.51942f);
                instancePath2.cubicTo(105.95227f, 46.51942f, 106.45034f, 46.059666f, 106.45034f, 45.140152f);
                instancePath2.lineTo(106.45034f, 42.304993f);
                instancePath2.lineTo(98.55786f, 42.304993f);
                instancePath2.lineTo(98.55786f, 49.661087f);
                instancePath2.lineTo(95.952576f, 49.661087f);
                instancePath2.lineTo(95.952576f, 42.304993f);
                instancePath2.close();
                instancePath2.moveTo(102.38916f, 19.317192f);
                instancePath2.lineTo(92.00633f, 19.317192f);
                instancePath2.lineTo(92.00633f, 21.769222f);
                instancePath2.lineTo(102.38916f, 21.769222f);
                instancePath2.lineTo(102.38916f, 19.317192f);
                instancePath2.close();
                instancePath2.moveTo(106.87178f, 30.006517f);
                instancePath2.lineTo(106.87178f, 27.707739f);
                instancePath2.lineTo(87.52371f, 27.707739f);
                instancePath2.lineTo(87.52371f, 30.006517f);
                instancePath2.lineTo(106.87178f, 30.006517f);
                instancePath2.close();
                instancePath2.moveTo(87.52371f, 25.907026f);
                instancePath2.lineTo(106.87178f, 25.907026f);
                instancePath2.lineTo(106.87178f, 23.7615f);
                instancePath2.lineTo(87.52371f, 23.7615f);
                instancePath2.lineTo(87.52371f, 25.907026f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 2);
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}