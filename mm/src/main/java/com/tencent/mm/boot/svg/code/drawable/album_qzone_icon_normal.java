package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class album_qzone_icon_normal extends c {
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
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(21.721962f, 9.453671f);
                instancePath.lineTo(15.541582f, 8.317529f);
                instancePath.cubicTo(15.434511f, 8.296709f, 15.339336f, 8.2312765f, 15.288775f, 8.133128f);
                instancePath.lineTo(12.30863f, 2.6725035f);
                instancePath.cubicTo(12.246172f, 2.5565097f, 12.121256f, 2.5f, 11.999313f, 2.5f);
                instancePath.cubicTo(11.874397f, 2.5f, 11.752456f, 2.559484f, 11.689998f, 2.6725035f);
                instancePath.lineTo(8.709852f, 8.133128f);
                instancePath.cubicTo(8.656317f, 8.228302f, 8.5641165f, 8.296709f, 8.457046f, 8.317529f);
                instancePath.lineTo(2.2766654f, 9.453671f);
                instancePath.cubicTo(2.011962f, 9.501259f, 1.907865f, 9.825446f, 2.0952394f, 10.018769f);
                instancePath.lineTo(6.5892506f, 14.643644f);
                instancePath.cubicTo(6.6695538f, 14.726922f, 6.705244f, 14.839941f, 6.687399f, 14.952961f);
                instancePath.lineTo(5.661301f, 21.136314f);
                instancePath.cubicTo(5.6196623f, 21.401018f, 5.893288f, 21.60624f, 6.1371727f, 21.490244f);
                instancePath.lineTo(11.844656f, 18.780752f);
                instancePath.cubicTo(11.895217f, 18.756958f, 11.948752f, 18.745062f, 12.002288f, 18.745062f);
                instancePath.cubicTo(12.055823f, 18.745062f, 12.109359f, 18.756958f, 12.159921f, 18.780752f);
                instancePath.lineTo(17.867403f, 21.490244f);
                instancePath.cubicTo(18.111288f, 21.60624f, 18.381939f, 21.401018f, 18.343275f, 21.136314f);
                instancePath.lineTo(17.569984f, 16.478724f);
                instancePath.cubicTo(18.542545f, 15.78871f, 19.015444f, 15.196845f, 19.071953f, 15.107619f);
                instancePath.cubicTo(19.137386f, 15.006496f, 19.095747f, 14.920244f, 19.095747f, 14.920244f);
                instancePath.cubicTo(19.095747f, 14.920244f, 19.095747f, 14.920244f, 19.095747f, 14.920244f);
                instancePath.cubicTo(17.528345f, 15.571593f, 13.721374f, 16.666098f, 9.042962f, 16.505491f);
                instancePath.cubicTo(8.477865f, 16.487646f, 7.915742f, 16.422215f, 7.600477f, 16.365704f);
                instancePath.cubicTo(7.261419f, 16.303246f, 7.2078834f, 15.940394f, 7.416077f, 15.767891f);
                instancePath.cubicTo(8.727697f, 14.667438f, 13.093818f, 11.544532f, 13.162225f, 11.490996f);
                instancePath.cubicTo(13.242528f, 11.428538f, 13.245502f, 11.336338f, 13.174122f, 11.276854f);
                instancePath.cubicTo(13.072999f, 11.190602f, 10.684719f, 10.348905f, 7.032406f, 10.908053f);
                instancePath.cubicTo(6.782573f, 10.946718f, 6.6368375f, 10.604686f, 6.8807216f, 10.476795f);
                instancePath.cubicTo(7.9097934f, 9.932517f, 10.256434f, 9.260348f, 12.647689f, 9.278193f);
                instancePath.cubicTo(14.316213f, 9.293065f, 15.758698f, 9.792729f, 16.169138f, 10.093123f);
                instancePath.cubicTo(16.38328f, 10.250756f, 16.335691f, 10.444078f, 16.160215f, 10.592789f);
                instancePath.cubicTo(15.262008f, 11.354183f, 12.710147f, 13.120855f, 11.820862f, 13.804921f);
                instancePath.cubicTo(11.716765f, 13.885224f, 11.755429f, 14.01014f, 11.868449f, 14.051779f);
                instancePath.cubicTo(13.397186f, 14.637696f, 15.687318f, 14.819122f, 17.302307f, 14.833993f);
                instancePath.lineTo(21.915285f, 10.015795f);
                instancePath.cubicTo(22.087788f, 9.825446f, 21.983692f, 9.501259f, 21.721962f, 9.453671f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
