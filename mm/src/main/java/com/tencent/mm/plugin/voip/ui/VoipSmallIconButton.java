package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.voip.b;

public class VoipSmallIconButton extends FrameLayout {
    private Drawable HeT = null;
    private Drawable HeU = null;
    private View.OnTouchListener HeV = new View.OnTouchListener() {
        /* class com.tencent.mm.plugin.voip.ui.VoipSmallIconButton.AnonymousClass1 */

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(115389);
            switch (motionEvent.getAction()) {
                case 0:
                    VoipSmallIconButton.this.cIN.setImageDrawable(VoipSmallIconButton.this.HeU);
                    VoipSmallIconButton.this.Ws.setTextColor(VoipSmallIconButton.this.mContext.getResources().getColor(R.color.BW_100_Alpha_0_8));
                    break;
                case 1:
                    VoipSmallIconButton.this.cIN.setImageDrawable(VoipSmallIconButton.this.HeT);
                    VoipSmallIconButton.this.Ws.setTextColor(VoipSmallIconButton.this.mContext.getResources().getColor(R.color.ag2));
                    break;
            }
            AppMethodBeat.o(115389);
            return false;
        }
    };
    private TextView Ws;
    private ImageView cIN;
    private Context mContext;

    public void setOnClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(115390);
        this.cIN.setOnClickListener(onClickListener);
        AppMethodBeat.o(115390);
    }

    public VoipSmallIconButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(115391);
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.azi, this);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, b.a.VoipButton, 0, 0);
        try {
            this.HeT = obtainStyledAttributes.getDrawable(2);
            this.HeU = obtainStyledAttributes.getDrawable(3);
            String string = obtainStyledAttributes.getString(4);
            int resourceId = obtainStyledAttributes.getResourceId(4, -1);
            obtainStyledAttributes.recycle();
            this.cIN = (ImageView) findViewById(R.id.hsx);
            this.cIN.setImageDrawable(this.HeT);
            this.cIN.setOnTouchListener(this.HeV);
            this.cIN.setContentDescription(string);
            this.Ws = (TextView) findViewById(R.id.hsz);
            if (resourceId != -1) {
                this.Ws.setText(getContext().getString(resourceId));
            }
            AppMethodBeat.o(115391);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            AppMethodBeat.o(115391);
            throw th;
        }
    }

    public void setEnabled(boolean z) {
        AppMethodBeat.i(115392);
        this.cIN.setEnabled(z);
        this.Ws.setEnabled(z);
        AppMethodBeat.o(115392);
    }
}
