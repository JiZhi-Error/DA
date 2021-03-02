package com.tencent.mm.plugin.sns.ad.widget.living;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.thumbplayer.api.TPOptionalID;

public class LivingStatusLayout extends FrameLayout {
    private TextView DAG;
    private View DAH;

    public LivingStatusLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LivingStatusLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(202422);
        super.onFinishInflate();
        try {
            this.DAG = (TextView) findViewById(R.id.fx);
            this.DAH = findViewById(R.id.fw);
            this.DAH.setVisibility(8);
            AppMethodBeat.o(202422);
        } catch (Throwable th) {
            AppMethodBeat.o(202422);
        }
    }

    public void setLiveStatus(int i2) {
        String str;
        int i3;
        AppMethodBeat.i(202423);
        if ((i2 & TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH) == 2) {
            if (this.DAH != null) {
                this.DAH.setVisibility(0);
            }
            if (this.DAG != null) {
                this.DAG.setVisibility(8);
                AppMethodBeat.o(202423);
                return;
            }
        } else {
            if (this.DAH != null) {
                this.DAH.setVisibility(8);
            }
            if (this.DAG != null) {
                this.DAG.setVisibility(0);
                TextView textView = this.DAG;
                int i4 = i2 & TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH;
                if (i4 == 3) {
                    str = getContext().getString(R.string.h44);
                } else if (i4 == 1) {
                    str = getContext().getString(R.string.h45);
                } else {
                    str = "";
                }
                textView.setText(str);
                TextView textView2 = this.DAG;
                if (i4 == 2 || i4 == 1) {
                    i3 = R.drawable.be;
                } else {
                    i3 = R.drawable.bf;
                }
                textView2.setBackgroundResource(i3);
            }
        }
        AppMethodBeat.o(202423);
    }

    public void setVisibility(int i2) {
        AppMethodBeat.i(202424);
        super.setVisibility(i2);
        if (!(this.DAH == null || i2 == 0)) {
            this.DAH.setVisibility(i2);
        }
        AppMethodBeat.o(202424);
    }
}
