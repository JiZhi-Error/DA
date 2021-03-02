package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.ar;

public class RedesignVideoPlayerSeekBar extends VideoPlayerSeekBar {
    long Kwt = 0;
    long dtZ = 0;
    long iVn = 0;
    private ImageView mDf;

    public RedesignVideoPlayerSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RedesignVideoPlayerSeekBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @Override // com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar, com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar
    public final void init() {
        AppMethodBeat.i(134009);
        super.init();
        this.mDf = (ImageView) this.contentView.findViewById(R.id.gcy);
        AppMethodBeat.o(134009);
    }

    @Override // com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar, com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar
    public int getLayoutId() {
        return R.layout.bm5;
    }

    @Override // com.tencent.mm.pluginsdk.ui.h, com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar
    public final void hP(boolean z) {
        AppMethodBeat.i(134010);
        setIsPlay(z);
        AppMethodBeat.o(134010);
    }

    @Override // com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar, com.tencent.mm.plugin.sight.decode.ui.a, com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar
    public void setIsPlay(boolean z) {
        AppMethodBeat.i(134011);
        this.dLB = z;
        if (z) {
            this.mCP.setImageDrawable(ar.m(getContext(), R.raw.icons_filled_pause, -1));
            this.mCP.setContentDescription(getContext().getString(R.string.xc));
            AppMethodBeat.o(134011);
            return;
        }
        this.mCP.setImageDrawable(ar.m(getContext(), R.raw.icons_filled_play, -1));
        this.mCP.setContentDescription(getContext().getString(R.string.xu));
        AppMethodBeat.o(134011);
    }

    public final boolean aiS(int i2) {
        int i3;
        AppMethodBeat.i(134012);
        int videoTotalTime = getVideoTotalTime();
        if (((long) i2) == this.iVn && ((long) videoTotalTime) == this.dtZ) {
            AppMethodBeat.o(134012);
            return false;
        } else if (System.currentTimeMillis() - this.Kwt < 300) {
            AppMethodBeat.o(134012);
            return false;
        } else if (i2 < 0 || videoTotalTime < 0) {
            AppMethodBeat.o(134012);
            return false;
        } else {
            if (i2 > videoTotalTime) {
                i2 = videoTotalTime;
            }
            int barLen = getBarLen();
            if (barLen <= 0) {
                AppMethodBeat.o(134012);
                return true;
            }
            if (videoTotalTime == 0) {
                i3 = 0;
            } else {
                i3 = (int) (((double) barLen) * ((((double) i2) * 1.0d) / ((double) videoTotalTime)));
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mDf.getLayoutParams();
            layoutParams.width = i3;
            this.mDf.setLayoutParams(layoutParams);
            this.iVn = (long) i2;
            this.dtZ = (long) videoTotalTime;
            AppMethodBeat.o(134012);
            return true;
        }
    }
}
