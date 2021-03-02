package com.tencent.scanlib.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.scanlib.model.DetectCode;
import java.util.List;

public class DetectCodeView extends View {
    private List<DetectCode> ROM;
    private Paint paint = new Paint();

    public DetectCodeView(Context context) {
        super(context);
        AppMethodBeat.i(3567);
        AppMethodBeat.o(3567);
    }

    public DetectCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(3568);
        AppMethodBeat.o(3568);
    }

    public DetectCodeView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(3569);
        AppMethodBeat.o(3569);
    }

    public void setDetectedCodes(List<DetectCode> list) {
        AppMethodBeat.i(3570);
        this.ROM = list;
        if (list != null && !list.isEmpty()) {
            this.paint.reset();
            this.paint.setColor(-65536);
            this.paint.setStyle(Paint.Style.STROKE);
            this.paint.setAntiAlias(true);
            this.paint.setStrokeWidth(getResources().getDimension(R.dimen.ahz));
        }
        postInvalidate();
        AppMethodBeat.o(3570);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(3571);
        super.onDraw(canvas);
        if (this.ROM != null && !this.ROM.isEmpty()) {
            for (DetectCode detectCode : this.ROM) {
                if (detectCode.points.size() == 4) {
                    canvas.drawRect(new Rect(detectCode.points.get(0).x, detectCode.points.get(0).y, detectCode.points.get(2).x, detectCode.points.get(2).y), this.paint);
                }
            }
        }
        AppMethodBeat.o(3571);
    }
}
