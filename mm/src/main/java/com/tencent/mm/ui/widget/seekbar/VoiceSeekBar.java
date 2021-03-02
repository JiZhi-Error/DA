package com.tencent.mm.ui.widget.seekbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class VoiceSeekBar extends RelativeLayout {
    protected ImageView QVk = null;
    protected float QVl = 0.0f;
    protected int QVm = 0;
    protected View contentView = null;
    protected ImageView mCM;
    protected ImageView mCN = null;

    public VoiceSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(159692);
        init();
        AppMethodBeat.o(159692);
    }

    public VoiceSeekBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(159693);
        init();
        AppMethodBeat.o(159693);
    }

    private void init() {
        AppMethodBeat.i(159694);
        this.contentView = View.inflate(getContext(), R.layout.c6v, this);
        this.mCM = (ImageView) this.contentView.findViewById(R.id.hgq);
        this.mCN = (ImageView) this.contentView.findViewById(R.id.hgp);
        this.QVk = (ImageView) this.contentView.findViewById(R.id.hgo);
        this.mCN.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            /* class com.tencent.mm.ui.widget.seekbar.VoiceSeekBar.AnonymousClass1 */

            public final boolean onPreDraw() {
                AppMethodBeat.i(159691);
                VoiceSeekBar.this.mCN.getViewTreeObserver().removeOnPreDrawListener(this);
                VoiceSeekBar.this.QVm = VoiceSeekBar.this.mCN.getHeight();
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) VoiceSeekBar.this.mCM.getLayoutParams();
                layoutParams.topMargin = (int) ((1.0f - VoiceSeekBar.this.QVl) * ((float) VoiceSeekBar.this.QVm));
                VoiceSeekBar.this.mCM.setLayoutParams(layoutParams);
                VoiceSeekBar.this.requestLayout();
                AppMethodBeat.o(159691);
                return false;
            }
        });
        AppMethodBeat.o(159694);
    }
}
