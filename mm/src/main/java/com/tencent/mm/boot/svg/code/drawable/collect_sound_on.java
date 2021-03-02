package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public class collect_sound_on extends c {
    private final int height = 62;
    private final int width = 62;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.svg.c
    public int doCommand(int i2, Object... objArr) {
        switch (i2) {
            case 0:
                return 62;
            case 1:
                return 62;
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
                Paint instancePaint3 = c.instancePaint(instancePaint2, looper);
                instancePaint3.setStrokeWidth(1.0f);
                Paint instancePaint4 = c.instancePaint(instancePaint3, looper);
                instancePaint4.setColor(-11776948);
                instancePaint4.setStrokeWidth(3.0f);
                canvas.save();
                Paint instancePaint5 = c.instancePaint(instancePaint4, looper);
                Path instancePath = c.instancePath(looper);
                instancePath.moveTo(12.5f, 51.5f);
                instancePath.lineTo(12.5f, 50.833168f);
                instancePath.cubicTo(12.604213f, 50.756973f, 12.7130165f, 50.673367f, 12.825878f, 50.581997f);
                instancePath.cubicTo(13.609306f, 49.947758f, 14.377914f, 49.098545f, 15.08248f, 48.008003f);
                instancePath.cubicTo(17.25971f, 44.638042f, 18.415026f, 39.67215f, 18.092539f, 32.831554f);
                instancePath.cubicTo(18.56658f, 22.598658f, 22.709154f, 17.582647f, 28.795002f, 16.286835f);
                instancePath.lineTo(31.072823f, 15.801835f);
                instancePath.lineTo(29.689184f, 13.928539f);
                instancePath.cubicTo(29.419085f, 13.562856f, 29.272728f, 13.127208f, 29.272728f, 12.666667f);
                instancePath.cubicTo(29.272728f, 11.47552f, 30.26446f, 10.5f, 31.5f, 10.5f);
                instancePath.cubicTo(32.735542f, 10.5f, 33.727272f, 11.47552f, 33.727272f, 12.666667f);
                instancePath.cubicTo(33.727272f, 13.127208f, 33.580914f, 13.562856f, 33.310818f, 13.928539f);
                instancePath.lineTo(31.927177f, 15.801835f);
                instancePath.lineTo(34.204998f, 16.286835f);
                instancePath.cubicTo(40.290844f, 17.582647f, 44.43342f, 22.598658f, 44.90746f, 32.831554f);
                instancePath.cubicTo(44.584972f, 39.67215f, 45.740288f, 44.638042f, 47.91752f, 48.008003f);
                instancePath.cubicTo(48.622086f, 49.098545f, 49.390694f, 49.947758f, 50.17412f, 50.581997f);
                instancePath.cubicTo(50.286983f, 50.673367f, 50.395786f, 50.756973f, 50.5f, 50.833168f);
                instancePath.lineTo(50.5f, 51.5f);
                instancePath.lineTo(12.5f, 51.5f);
                instancePath.close();
                canvas.drawPath(instancePath, instancePaint5);
                canvas.restore();
                c.done(looper);
                break;
        }
        return 0;
    }
}
