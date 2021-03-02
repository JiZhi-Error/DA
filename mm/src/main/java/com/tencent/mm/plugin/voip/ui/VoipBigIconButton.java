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

public class VoipBigIconButton extends FrameLayout {
    private Drawable HeR = null;
    private Drawable HeS = null;
    private Drawable HeT = null;
    private Drawable HeU = null;
    private View.OnTouchListener HeV = new View.OnTouchListener() {
        /* class com.tencent.mm.plugin.voip.ui.VoipBigIconButton.AnonymousClass1 */

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(115374);
            switch (motionEvent.getAction()) {
                case 0:
                    VoipBigIconButton.this.cIN.setBackgroundDrawable(VoipBigIconButton.this.HeS);
                    VoipBigIconButton.this.cIN.setImageDrawable(VoipBigIconButton.this.HeU);
                    VoipBigIconButton.this.Ws.setTextColor(VoipBigIconButton.this.mContext.getResources().getColor(R.color.BW_100_Alpha_0_8));
                    break;
                case 1:
                    VoipBigIconButton.this.cIN.setBackgroundDrawable(VoipBigIconButton.this.HeR);
                    VoipBigIconButton.this.cIN.setImageDrawable(VoipBigIconButton.this.HeT);
                    VoipBigIconButton.this.Ws.setTextColor(VoipBigIconButton.this.mContext.getResources().getColor(R.color.ag2));
                    break;
            }
            AppMethodBeat.o(115374);
            return false;
        }
    };
    private TextView Ws;
    private ImageView cIN;
    private Context mContext;

    public VoipBigIconButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        String str;
        AppMethodBeat.i(115375);
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.azh, this);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, b.a.VoipButton, 0, 0);
        try {
            this.HeR = obtainStyledAttributes.getDrawable(0);
            this.HeS = obtainStyledAttributes.getDrawable(1);
            this.HeT = obtainStyledAttributes.getDrawable(2);
            this.HeU = obtainStyledAttributes.getDrawable(3);
            int resourceId = obtainStyledAttributes.getResourceId(4, -1);
            int resourceId2 = obtainStyledAttributes.getResourceId(4, 0);
            if (resourceId2 != 0) {
                str = getContext().getString(resourceId2);
            } else {
                str = null;
            }
            obtainStyledAttributes.recycle();
            this.HeS = this.HeS == null ? this.HeR : this.HeS;
            this.HeU = this.HeU == null ? this.HeT : this.HeU;
            this.cIN = (ImageView) findViewById(R.id.a3c);
            this.cIN.setBackgroundDrawable(this.HeR);
            this.cIN.setImageDrawable(this.HeT);
            this.cIN.setOnTouchListener(this.HeV);
            this.cIN.setContentDescription(str);
            this.Ws = (TextView) findViewById(R.id.a3f);
            if (resourceId != -1) {
                this.Ws.setText(getContext().getString(resourceId));
            }
            AppMethodBeat.o(115375);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            AppMethodBeat.o(115375);
            throw th;
        }
    }

    public void setEnabled(boolean z) {
        AppMethodBeat.i(115376);
        this.cIN.setEnabled(z);
        this.Ws.setEnabled(z);
        AppMethodBeat.o(115376);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(115377);
        this.cIN.setOnClickListener(onClickListener);
        AppMethodBeat.o(115377);
    }
}
