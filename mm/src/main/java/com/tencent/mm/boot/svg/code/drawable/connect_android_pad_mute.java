package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShowUpdatableMessageSubscribeButton;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.smtt.sdk.WebView;

public class connect_android_pad_mute extends c {
    private final int height = TbsListener.ErrorCode.ERROR_CANLOADX5_RETURN_NULL;
    private final int width = JsApiShowUpdatableMessageSubscribeButton.CTRL_INDEX;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return JsApiShowUpdatableMessageSubscribeButton.CTRL_INDEX;
            case 1:
                return TbsListener.ErrorCode.ERROR_CANLOADX5_RETURN_NULL;
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
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                float[] matrixFloatArray = c.setMatrixFloatArray(instanceMatrixArray, 1.0f, 0.0f, 21.0f, 0.0f, 1.0f, 28.0f, 0.0f, 0.0f, 1.0f);
                instanceMatrix.reset();
                instanceMatrix.setValues(matrixFloatArray);
                canvas.concat(instanceMatrix);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(354.0f, 252.0f);
                instancePath.lineTo(12.0f, 252.0f);
                instancePath.cubicTo(5.372583f, 252.0f, 0.0f, 246.62741f, 0.0f, 240.0f);
                instancePath.lineTo(0.0f, 12.0f);
                instancePath.cubicTo(0.0f, 5.372583f, 5.372583f, 0.0f, 12.0f, 0.0f);
                instancePath.lineTo(354.0f, 0.0f);
                instancePath.cubicTo(360.6274f, 0.0f, 366.0f, 5.372583f, 366.0f, 12.0f);
                instancePath.lineTo(366.0f, 48.0f);
                instancePath.lineTo(363.0f, 48.0f);
                instancePath.lineTo(363.0f, 12.0f);
                instancePath.cubicTo(363.0f, 7.2069573f, 359.25323f, 3.2890174f, 354.5288f, 3.015278f);
                instancePath.lineTo(354.0f, 3.0f);
                instancePath.lineTo(12.0f, 3.0f);
                instancePath.cubicTo(7.2069573f, 3.0f, 3.2890174f, 6.74676f, 3.015278f, 11.471182f);
                instancePath.lineTo(3.0f, 12.0f);
                instancePath.lineTo(3.0f, 240.0f);
                instancePath.cubicTo(3.0f, 244.79305f, 6.74676f, 248.71098f, 11.471182f, 248.98473f);
                instancePath.lineTo(12.0f, 249.0f);
                instancePath.lineTo(361.93695f, 249.00047f);
                instancePath.cubicTo(359.8216f, 250.86728f, 357.0431f, 252.0f, 354.0f, 252.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint3, looper);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(183.0f, 9.0f);
                instancePath2.cubicTo(184.65686f, 9.0f, 186.0f, 10.343145f, 186.0f, 12.0f);
                instancePath2.cubicTo(186.0f, 13.656855f, 184.65686f, 15.0f, 183.0f, 15.0f);
                instancePath2.cubicTo(181.34314f, 15.0f, 180.0f, 13.656855f, 180.0f, 12.0f);
                instancePath2.cubicTo(180.0f, 10.343145f, 181.34314f, 9.0f, 183.0f, 9.0f);
                instancePath2.close();
                canvas.drawPath(instancePath2, instancePaint5);
                canvas.restore();
                canvas.save();
                Paint instancePaint6 = c.instancePaint(instancePaint3, looper);
                Path instancePath3 = c.instancePath(looper);
                instancePath3.moveTo(357.0f, 60.5f);
                instancePath3.cubicTo(357.0f, 60.223858f, 357.22385f, 60.0f, 357.5f, 60.0f);
                instancePath3.lineTo(374.5f, 60.0f);
                instancePath3.cubicTo(374.77615f, 60.0f, 375.0f, 60.223858f, 375.0f, 60.5f);
                instancePath3.lineTo(375.0f, 62.5f);
                instancePath3.cubicTo(375.0f, 62.776142f, 374.77615f, 63.0f, 374.5f, 63.0f);
                instancePath3.lineTo(357.5f, 63.0f);
                instancePath3.cubicTo(357.22385f, 63.0f, 357.0f, 62.776142f, 357.0f, 62.5f);
                instancePath3.lineTo(357.0f, 60.5f);
                instancePath3.close();
                canvas.drawPath(instancePath3, instancePaint6);
                canvas.restore();
                canvas.save();
                Paint instancePaint7 = c.instancePaint(instancePaint3, looper);
                Path instancePath4 = c.instancePath(looper);
                instancePath4.moveTo(408.0f, 48.0f);
                instancePath4.cubicTo(416.28427f, 48.0f, 423.0f, 54.71573f, 423.0f, 63.0f);
                instancePath4.lineTo(423.0f, 237.0f);
                instancePath4.cubicTo(423.0f, 245.28427f, 416.28427f, 252.0f, 408.0f, 252.0f);
                instancePath4.lineTo(324.0f, 252.0f);
                instancePath4.cubicTo(315.71573f, 252.0f, 309.0f, 245.28427f, 309.0f, 237.0f);
                instancePath4.lineTo(309.0f, 63.0f);
                instancePath4.cubicTo(309.0f, 54.71573f, 315.71573f, 48.0f, 324.0f, 48.0f);
                instancePath4.lineTo(408.0f, 48.0f);
                instancePath4.close();
                instancePath4.moveTo(408.0f, 51.0f);
                instancePath4.lineTo(324.0f, 51.0f);
                instancePath4.cubicTo(317.57343f, 51.0f, 312.32675f, 56.051907f, 312.01468f, 62.401077f);
                instancePath4.lineTo(312.0f, 63.0f);
                instancePath4.lineTo(312.0f, 237.0f);
                instancePath4.cubicTo(312.0f, 243.42659f, 317.0519f, 248.67323f, 323.4011f, 248.98532f);
                instancePath4.lineTo(324.0f, 249.0f);
                instancePath4.lineTo(408.0f, 249.0f);
                instancePath4.cubicTo(414.42657f, 249.0f, 419.67325f, 243.94809f, 419.98532f, 237.59892f);
                instancePath4.lineTo(420.0f, 237.0f);
                instancePath4.lineTo(420.0f, 63.0f);
                instancePath4.cubicTo(420.0f, 56.573414f, 414.9481f, 51.326763f, 408.5989f, 51.014687f);
                instancePath4.lineTo(408.0f, 51.0f);
                instancePath4.close();
                WeChatSVGRenderC2Java.setFillType(instancePath4, 1);
                canvas.drawPath(instancePath4, instancePaint7);
                canvas.restore();
                canvas.save();
                Paint instancePaint8 = c.instancePaint(instancePaint3, looper);
                Path instancePath5 = c.instancePath(looper);
                instancePath5.moveTo(411.0f, 72.0f);
                instancePath5.cubicTo(412.65686f, 72.0f, 414.0f, 73.34315f, 414.0f, 75.0f);
                instancePath5.lineTo(414.0f, 222.0f);
                instancePath5.cubicTo(414.0f, 223.65686f, 412.65686f, 225.0f, 411.0f, 225.0f);
                instancePath5.lineTo(321.0f, 225.0f);
                instancePath5.cubicTo(319.34314f, 225.0f, 318.0f, 223.65686f, 318.0f, 222.0f);
                instancePath5.lineTo(318.0f, 75.0f);
                instancePath5.cubicTo(318.0f, 73.34315f, 319.34314f, 72.0f, 321.0f, 72.0f);
                instancePath5.lineTo(411.0f, 72.0f);
                instancePath5.close();
                instancePath5.moveTo(411.0f, 75.0f);
                instancePath5.lineTo(321.0f, 75.0f);
                instancePath5.lineTo(321.0f, 222.0f);
                instancePath5.lineTo(411.0f, 222.0f);
                instancePath5.lineTo(411.0f, 75.0f);
                instancePath5.close();
                WeChatSVGRenderC2Java.setFillType(instancePath5, 1);
                canvas.drawPath(instancePath5, instancePaint8);
                canvas.restore();
                canvas.save();
                Paint instancePaint9 = c.instancePaint(instancePaint3, looper);
                instancePaint9.setColor(-436207616);
                Path instancePath6 = c.instancePath(looper);
                instancePath6.moveTo(366.0f, 127.0f);
                instancePath6.cubicTo(368.20914f, 127.0f, 370.0f, 128.79086f, 370.0f, 131.0f);
                instancePath6.cubicTo(370.0f, 131.22607f, 369.98123f, 131.44777f, 369.94522f, 131.6636f);
                instancePath6.cubicTo(374.63458f, 133.29538f, 378.0f, 137.75467f, 378.0f, 143.0f);
                instancePath6.lineTo(378.0f, 151.0f);
                instancePath6.cubicTo(378.0f, 153.07217f, 378.53674f, 155.14436f, 379.61023f, 157.21654f);
                instancePath6.lineTo(386.84995f, 164.45584f);
                instancePath6.lineTo(385.1529f, 166.1529f);
                instancePath6.lineTo(351.69705f, 132.69705f);
                instancePath6.lineTo(353.3941f, 131.0f);
                instancePath6.lineTo(357.2171f, 134.82309f);
                instancePath6.cubicTo(358.53476f, 133.40842f, 360.1901f, 132.31247f, 362.05478f, 131.6636f);
                instancePath6.cubicTo(362.01877f, 131.44777f, 362.0f, 131.22607f, 362.0f, 131.0f);
                instancePath6.cubicTo(362.0f, 128.79086f, 363.79086f, 127.0f, 366.0f, 127.0f);
                instancePath6.close();
                instancePath6.moveTo(352.3734f, 163.00006f);
                instancePath6.cubicTo(351.94745f, 163.00006f, 351.53262f, 162.864f, 351.18933f, 162.6118f);
                instancePath6.cubicTo(350.2992f, 161.95786f, 350.10773f, 160.70613f, 350.7617f, 159.816f);
                instancePath6.cubicTo(352.92053f, 156.8773f, 354.0f, 153.93864f, 354.0f, 151.0f);
                instancePath6.lineTo(354.0f, 143.0f);
                instancePath6.cubicTo(354.0f, 141.61897f, 354.23328f, 140.29245f, 354.6626f, 139.05766f);
                instancePath6.lineTo(356.60895f, 141.00302f);
                instancePath6.cubicTo(356.47177f, 141.6496f, 356.4f, 142.31796f, 356.4f, 143.0f);
                instancePath6.lineTo(356.4f, 151.0f);
                instancePath6.cubicTo(356.4f, 154.26065f, 355.297f, 157.47102f, 353.14844f, 160.60005f);
                instancePath6.lineTo(376.20636f, 160.6f);
                instancePath6.lineTo(378.60635f, 163.0f);
                instancePath6.lineTo(368.0f, 163.0f);
                instancePath6.lineTo(368.0f, 163.4f);
                instancePath6.cubicTo(368.0f, 164.50456f, 367.10458f, 165.4f, 366.0f, 165.4f);
                instancePath6.cubicTo(364.89542f, 165.4f, 364.0f, 164.50456f, 364.0f, 163.4f);
                instancePath6.lineTo(364.0f, 163.0f);
                instancePath6.lineTo(352.3734f, 163.00006f);
                instancePath6.close();
                instancePath6.moveTo(366.0f, 129.4f);
                instancePath6.cubicTo(365.11633f, 129.4f, 364.4f, 130.11635f, 364.4f, 131.0f);
                instancePath6.cubicTo(364.4f, 131.09148f, 364.40744f, 131.181f, 364.42203f, 131.26836f);
                instancePath6.lineTo(364.7554f, 133.26501f);
                instancePath6.lineTo(362.84354f, 133.9303f);
                instancePath6.cubicTo(361.30933f, 134.46416f, 359.9695f, 135.36595f, 358.91486f, 136.52026f);
                instancePath6.lineTo(375.8012f, 153.40761f);
                instancePath6.cubicTo(375.66736f, 152.60846f, 375.6f, 151.80576f, 375.6f, 151.0f);
                instancePath6.lineTo(375.6f, 143.0f);
                instancePath6.cubicTo(375.6f, 138.88173f, 372.9828f, 135.26175f, 369.15646f, 133.9303f);
                instancePath6.lineTo(367.2446f, 133.26501f);
                instancePath6.lineTo(367.57797f, 131.26836f);
                instancePath6.cubicTo(367.59256f, 131.181f, 367.6f, 131.09148f, 367.6f, 131.0f);
                instancePath6.cubicTo(367.6f, 130.11635f, 366.88367f, 129.4f, 366.0f, 129.4f);
                instancePath6.close();
                WeChatSVGRenderC2Java.setFillType(instancePath6, 2);
                canvas.drawPath(instancePath6, instancePaint9);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}