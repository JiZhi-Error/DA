package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class wallet_security_digital_certificate_privacy extends c {
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
                canvas.save();
                Paint instancePaint3 = c.instancePaint(instancePaint, looper);
                instancePaint3.setColor(-16268960);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(16.0f, 5.99359f);
                instancePath.cubicTo(22.108109f, 5.99359f, 26.36755f, 10.72465f, 28.632223f, 14.876172f);
                instancePath.lineTo(28.763138f, 15.119671f);
                instancePath.lineTo(29.011135f, 15.601697f);
                instancePath.lineTo(29.128204f, 15.839744f);
                instancePath.lineTo(29.011135f, 16.077791f);
                instancePath.lineTo(28.763138f, 16.559816f);
                instancePath.lineTo(28.56504f, 16.925581f);
                instancePath.lineTo(28.356598f, 17.294083f);
                instancePath.lineTo(28.062618f, 17.788277f);
                instancePath.cubicTo(25.68803f, 21.667862f, 21.629042f, 25.685898f, 16.0f, 25.685898f);
                instancePath.cubicTo(10.490726f, 25.685898f, 6.485403f, 21.837023f, 4.0912385f, 18.036058f);
                instancePath.lineTo(3.9373825f, 17.788277f);
                instancePath.lineTo(3.6434028f, 17.294083f);
                instancePath.lineTo(3.4349594f, 16.925581f);
                instancePath.lineTo(3.2368622f, 16.559816f);
                instancePath.lineTo(2.988865f, 16.077791f);
                instancePath.lineTo(2.871795f, 15.839744f);
                instancePath.lineTo(2.988865f, 15.601697f);
                instancePath.lineTo(3.2368622f, 15.119671f);
                instancePath.cubicTo(5.4661236f, 10.912001f, 9.772125f, 5.99359f, 16.0f, 5.99359f);
                instancePath.close();
                instancePath.moveTo(16.0f, 7.6602564f);
                instancePath.cubicTo(11.442336f, 7.6602564f, 7.5043116f, 10.817129f, 4.894744f, 15.556579f);
                instancePath.lineTo(4.741f, 15.839f);
                instancePath.lineTo(4.954403f, 16.228586f);
                instancePath.lineTo(5.075791f, 16.442001f);
                instancePath.lineTo(5.3589106f, 16.918198f);
                instancePath.cubicTo(8.028928f, 21.280455f, 11.734427f, 24.01923f, 16.0f, 24.01923f);
                instancePath.cubicTo(20.158934f, 24.01923f, 23.785448f, 21.415682f, 26.428839f, 17.258987f);
                instancePath.lineTo(26.63023f, 16.936195f);
                instancePath.lineTo(26.913593f, 16.460106f);
                instancePath.lineTo(27.042109f, 16.23461f);
                instancePath.lineTo(27.258f, 15.84f);
                instancePath.lineTo(27.113935f, 15.573203f);
                instancePath.cubicTo(24.555195f, 10.925222f, 20.735983f, 7.804577f, 16.309782f, 7.66513f);
                instancePath.lineTo(16.0f, 7.6602564f);
                instancePath.close();
                WeChatSVGRenderC2Java.setFillType(instancePath, 1);
                canvas.drawPath(instancePath, instancePaint3);
                canvas.restore();
                canvas.save();
                Paint instancePaint4 = c.instancePaint(instancePaint, looper);
                instancePaint4.setColor(-16268960);
                Path instancePath2 = c.instancePath(looper);
                instancePath2.moveTo(16.0f, 10.630342f);
                instancePath2.cubicTo(13.122927f, 10.630342f, 10.790598f, 12.96267f, 10.790598f, 15.839744f);
                instancePath2.cubicTo(10.790598f, 18.716816f, 13.122927f, 21.049145f, 16.0f, 21.049145f);
                instancePath2.cubicTo(18.877073f, 21.049145f, 21.209402f, 18.716816f, 21.209402f, 15.839744f);
                instancePath2.cubicTo(21.209402f, 12.96267f, 18.877073f, 10.630342f, 16.0f, 10.630342f);
                instancePath2.close();
                instancePath2.moveTo(16.0f, 12.2970085f);
                instancePath2.cubicTo(17.956598f, 12.2970085f, 19.542734f, 13.883145f, 19.542734f, 15.839744f);
                instancePath2.cubicTo(19.542734f, 17.796343f, 17.956598f, 19.382479f, 16.0f, 19.382479f);
                instancePath2.cubicTo(14.043402f, 19.382479f, 12.457265f, 17.796343f, 12.457265f, 15.839744f);
                instancePath2.cubicTo(12.457265f, 13.883145f, 14.043402f, 12.2970085f, 16.0f, 12.2970085f);
                instancePath2.close();
                WeChatSVGRenderC2Java.setFillType(instancePath2, 1);
                canvas.drawPath(instancePath2, instancePaint4);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
