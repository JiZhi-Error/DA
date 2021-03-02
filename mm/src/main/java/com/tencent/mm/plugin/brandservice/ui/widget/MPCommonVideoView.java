package com.tencent.mm.plugin.brandservice.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.CommonVideoView;

public class MPCommonVideoView extends CommonVideoView {
    public MPCommonVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MPCommonVideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @Override // com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public final void BT(long j2) {
        AppMethodBeat.i(6259);
        super.BT(j2);
        this.hAk.postDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.brandservice.ui.widget.MPCommonVideoView.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(6258);
                if (MPCommonVideoView.this.qbJ != null) {
                    MPCommonVideoView.this.qbJ.setOneTimeVideoTextureUpdateCallback(MPCommonVideoView.this);
                }
                AppMethodBeat.o(6258);
            }
        }, j2);
        AppMethodBeat.o(6259);
    }
}
