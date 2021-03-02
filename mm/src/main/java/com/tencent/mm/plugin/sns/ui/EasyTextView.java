package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;

public class EasyTextView extends View {
    private static final Paint iuG = new Paint();
    private static int textSize = -1;
    private Context context;
    private String text = "";

    static {
        AppMethodBeat.i(97853);
        iuG.setAntiAlias(true);
        iuG.setFilterBitmap(true);
        iuG.setColor(737373);
        AppMethodBeat.o(97853);
    }

    public EasyTextView(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        AppMethodBeat.i(97850);
        this.context = context2;
        if (textSize == -1) {
            textSize = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, 12.0f);
            iuG.setTextSize((float) textSize);
        }
        iuG.setColor(this.context.getResources().getColor(R.color.fm));
        AppMethodBeat.o(97850);
    }

    public void setTextSize(int i2) {
        AppMethodBeat.i(97851);
        iuG.setTextSize((float) i2);
        AppMethodBeat.o(97851);
    }

    public void setText(String str) {
        if (str == null) {
            str = "";
        }
        this.text = str;
    }

    public void draw(Canvas canvas) {
        AppMethodBeat.i(97852);
        super.draw(canvas);
        canvas.drawText(this.text, 0.0f, (float) (getHeight() / 2), iuG);
        AppMethodBeat.o(97852);
    }
}
