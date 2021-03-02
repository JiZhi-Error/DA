package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class finder_live_filter_icon extends c {
    private final int height = 32;
    private final int width = 32;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 32;
            case 1:
                return 32;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                c.instanceMatrix(looper);
                c.instanceMatrixArray(looper);
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
                canvas.saveLayerAlpha(null, 230, 31);
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-1);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(22.559334f, 15.505f);
                instancePath.lineTo(22.515663f, 15.504021f);
                instancePath.cubicTo(23.478128f, 15.504021f, 24.38657f, 15.701494f, 25.20435f, 16.057608f);
                instancePath.lineTo(25.097477f, 16.011251f);
                instancePath.cubicTo(25.14201f, 16.030016f, 25.18631f, 16.049263f, 25.230371f, 16.068985f);
                instancePath.lineTo(25.230503f, 16.069065f);
                instancePath.cubicTo(26.546926f, 16.658302f, 27.649307f, 17.672323f, 28.344883f, 18.93726f);
                instancePath.cubicTo(28.852757f, 19.873947f, 29.139109f, 20.949102f, 29.139109f, 22.094057f);
                instancePath.cubicTo(29.139109f, 22.23653f, 29.134588f, 22.37795f, 29.125687f, 22.518183f);
                instancePath.cubicTo(28.968456f, 24.679718f, 27.764595f, 26.596004f, 26.019258f, 27.702894f);
                instancePath.cubicTo(25.015215f, 28.328728f, 23.83096f, 28.693457f, 22.56192f, 28.702116f);
                instancePath.cubicTo(20.965118f, 28.693516f, 19.39486f, 28.111128f, 18.196205f, 27.104904f);
                instancePath.cubicTo(17.861073f, 26.816002f, 17.554844f, 26.49488f, 17.282928f, 26.145828f);
                instancePath.lineTo(17.30894f, 26.097193f);
                instancePath.cubicTo(17.87891f, 24.931684f, 18.198046f, 23.617737f, 18.198046f, 22.223076f);
                instancePath.cubicTo(18.198046f, 20.861973f, 17.94267f, 19.501852f, 17.381609f, 18.292542f);
                instancePath.lineTo(17.279333f, 18.085f);
                instancePath.lineTo(17.29925f, 18.057354f);
                instancePath.cubicTo(18.502554f, 16.541094f, 20.367582f, 15.56206f, 22.451462f, 15.505471f);
                instancePath.lineTo(22.559334f, 15.505f);
                instancePath.close();
                instancePath.moveTo(8.742333f, 15.52f);
                instancePath.lineTo(8.846326f, 15.675359f);
                instancePath.cubicTo(10.290323f, 17.770063f, 12.578234f, 19.22977f, 15.221245f, 19.471058f);
                instancePath.lineTo(15.392097f, 19.483833f);
                instancePath.cubicTo(15.670336f, 20.128092f, 15.851103f, 20.824183f, 15.916115f, 21.551842f);
                instancePath.cubicTo(15.934313f, 21.746893f, 15.943107f, 21.952015f, 15.943107f, 22.158566f);
                instancePath.cubicTo(15.943107f, 22.315434f, 15.937568f, 22.471008f, 15.926674f, 22.625109f);
                instancePath.lineTo(15.91989f, 22.702194f);
                instancePath.lineTo(15.91989f, 22.702194f);
                instancePath.lineTo(15.9006815f, 22.906488f);
                instancePath.cubicTo(15.528915f, 26.162197f, 12.759479f, 28.691326f, 9.39822f, 28.691326f);
                instancePath.cubicTo(5.78357f, 28.691326f, 2.9181721f, 25.946371f, 2.8533332f, 22.158566f);
                instancePath.cubicTo(2.9001355f, 20.65008f, 3.343945f, 19.331469f, 4.0662017f, 18.273823f);
                instancePath.cubicTo(4.855733f, 17.142643f, 5.9839797f, 16.271584f, 7.311688f, 15.822675f);
                instancePath.cubicTo(7.7622623f, 15.67288f, 8.234455f, 15.571679f, 8.721377f, 15.522907f);
                instancePath.lineTo(8.742333f, 15.52f);
                instancePath.close();
                instancePath.moveTo(15.998104f, 4.0f);
                instancePath.cubicTo(19.612724f, 4.0f, 22.62158f, 6.9924293f, 22.62158f, 10.600335f);
                instancePath.cubicTo(22.62158f, 10.692495f, 22.619894f, 10.784044f, 22.616514f, 10.874979f);
                instancePath.cubicTo(22.582138f, 11.702392f, 22.395777f, 12.490646f, 22.084196f, 13.212437f);
                instancePath.lineTo(21.98772f, 13.217168f);
                instancePath.cubicTo(19.259865f, 13.3862295f, 16.796297f, 14.689088f, 15.271612f, 16.926796f);
                instancePath.cubicTo(15.247696f, 16.961895f, 15.225981f, 16.997839f, 15.206438f, 17.03447f);
                instancePath.lineTo(15.154333f, 17.145f);
                instancePath.lineTo(15.091471f, 17.137596f);
                instancePath.cubicTo(13.550178f, 16.92127f, 12.180446f, 16.160961f, 11.177076f, 15.050087f);
                instancePath.cubicTo(11.154839f, 15.025588f, 11.132938f, 15.000861f, 11.111218f, 14.975968f);
                instancePath.lineTo(11.111237f, 14.97609f);
                instancePath.cubicTo(10.204635f, 13.936927f, 9.613746f, 12.609335f, 9.481434f, 11.155513f);
                instancePath.lineTo(9.481106f, 11.155364f);
                instancePath.cubicTo(9.462757f, 10.950292f, 9.4532175f, 10.742555f, 9.4532175f, 10.53276f);
                instancePath.lineTo(9.45515f, 10.368364f);
                instancePath.cubicTo(9.455746f, 10.343061f, 9.456479f, 10.3178005f, 9.457349f, 10.292583f);
                instancePath.lineTo(9.469415f, 10.061202f);
                instancePath.cubicTo(9.583672f, 8.405594f, 10.295812f, 6.9321795f, 11.3965f, 5.851859f);
                instancePath.cubicTo(12.579035f, 4.697159f, 14.204292f, 4.0f, 15.998104f, 4.0f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 2);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
