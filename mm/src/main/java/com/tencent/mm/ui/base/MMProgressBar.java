package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.MTimerHandler;

public class MMProgressBar extends LinearLayout {
    private MTimerHandler AIN = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.ui.base.MMProgressBar.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(142058);
            int i2 = MMProgressBar.this.ORQ - MMProgressBar.this.ORP;
            if (i2 > 0) {
                int i3 = (int) (((double) i2) * 0.6d);
                MMProgressBar mMProgressBar = MMProgressBar.this;
                int i4 = MMProgressBar.this.ORP;
                if (i3 <= 0) {
                    i3 = 1;
                }
                mMProgressBar.ORP = i3 + i4;
                MMProgressBar.b(MMProgressBar.this, MMProgressBar.this.ORP);
                MMProgressBar.this.AIN.startTimer((long) (((MMProgressBar.this.max - i2) * 40) / MMProgressBar.this.max));
            }
            AppMethodBeat.o(142058);
            return false;
        }
    }, false);
    private TextView DnJ;
    private int ORP = 0;
    private int ORQ = 0;
    private TextView ORR;
    private a ORS;
    private int max = 100;

    public interface a {
        void acg(int i2);
    }

    public MMProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(142059);
        inflate(getContext(), R.layout.ba4, this);
        this.ORR = (TextView) findViewById(R.id.fga);
        this.DnJ = (TextView) findViewById(R.id.fgb);
        AppMethodBeat.o(142059);
    }

    public void setMax(int i2) {
        this.max = i2;
    }

    public int getMax() {
        return this.max;
    }

    public void setProgress(int i2) {
        AppMethodBeat.i(142060);
        if (i2 > this.max) {
            i2 = this.max;
        }
        this.ORQ = i2;
        if (this.AIN.stopped()) {
            setAutoProgress(true);
        }
        AppMethodBeat.o(142060);
    }

    public int getProgress() {
        return this.ORQ;
    }

    public void setAutoProgress(boolean z) {
        AppMethodBeat.i(142061);
        if (z) {
            this.AIN.startTimer(40);
            AppMethodBeat.o(142061);
            return;
        }
        this.AIN.stopTimer();
        AppMethodBeat.o(142061);
    }

    public void setTips(CharSequence charSequence) {
        AppMethodBeat.i(142062);
        this.DnJ.setText(charSequence);
        AppMethodBeat.o(142062);
    }

    public void setOnProgressChangedListener(a aVar) {
        this.ORS = aVar;
    }

    private int getProgressLength() {
        AppMethodBeat.i(142063);
        int width = (getWidth() * this.ORP) / this.max;
        if (width < BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 20.0f)) {
            width = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 20.0f);
        }
        AppMethodBeat.o(142063);
        return width;
    }

    static /* synthetic */ void b(MMProgressBar mMProgressBar, int i2) {
        AppMethodBeat.i(142064);
        mMProgressBar.ORR.setWidth(mMProgressBar.getProgressLength());
        if (mMProgressBar.ORS != null) {
            mMProgressBar.ORS.acg(i2);
        }
        AppMethodBeat.o(142064);
    }
}
