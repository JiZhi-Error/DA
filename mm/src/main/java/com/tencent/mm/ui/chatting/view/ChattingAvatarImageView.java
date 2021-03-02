package com.tencent.mm.ui.chatting.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.be;
import com.tencent.mm.plugin.patmsg.ui.AvatarPatTipImageView;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.DoNotCheckLeakForActivities;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class ChattingAvatarImageView extends AvatarPatTipImageView {
    private IListener<be> PGg;
    private Runnable PGh;
    private final String TAG;

    public ChattingAvatarImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChattingAvatarImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(233533);
        this.TAG = "MicroMsg.ChattingAvatarImageView";
        this.PGg = new IListener<be>() {
            /* class com.tencent.mm.ui.chatting.view.ChattingAvatarImageView.AnonymousClass1 */

            {
                AppMethodBeat.i(233529);
                this.__eventId = be.class.getName().hashCode();
                AppMethodBeat.o(233529);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            @DoNotCheckLeakForActivities
            public final /* synthetic */ boolean callback(be beVar) {
                AppMethodBeat.i(233530);
                ChattingAvatarImageView.this.ARv.dismiss();
                ChattingAvatarImageView.this.ARu.eBq();
                ChattingAvatarImageView.this.ARu.eBr();
                ChattingAvatarImageView.this.PGg.dead();
                AppMethodBeat.o(233530);
                return false;
            }
        };
        this.PGh = new Runnable() {
            /* class com.tencent.mm.ui.chatting.view.ChattingAvatarImageView.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(233532);
                final int[] iArr = new int[2];
                ChattingAvatarImageView.this.getLocationOnScreen(iArr);
                int dimensionPixelSize = MMApplicationContext.getResources().getDimensionPixelSize(R.dimen.ct);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.rightMargin = dimensionPixelSize;
                layoutParams.leftMargin = dimensionPixelSize;
                layoutParams.bottomMargin = -MMApplicationContext.getResources().getDimensionPixelSize(R.dimen.bt);
                ChattingAvatarImageView.this.ARv.a(ChattingAvatarImageView.this, layoutParams);
                ChattingAvatarImageView.this.post(new Runnable() {
                    /* class com.tencent.mm.ui.chatting.view.ChattingAvatarImageView.AnonymousClass2.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(233531);
                        int[] iArr = new int[2];
                        View contentView = ChattingAvatarImageView.this.ARv.getContentView();
                        contentView.getLocationOnScreen(iArr);
                        View findViewById = contentView.findViewById(R.id.ioq);
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
                        layoutParams.leftMargin = ((iArr[0] + (ChattingAvatarImageView.this.getWidth() / 2)) - iArr[0]) - (findViewById.getWidth() / 2);
                        findViewById.setLayoutParams(layoutParams);
                        AppMethodBeat.o(233531);
                    }
                });
                AppMethodBeat.o(233532);
            }
        };
        AppMethodBeat.o(233533);
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i2) {
        AppMethodBeat.i(233534);
        super.onVisibilityChanged(view, i2);
        if (this.PGg != null) {
            if (i2 == 8) {
                this.PGg.dead();
                AppMethodBeat.o(233534);
                return;
            } else if (i2 == 0) {
                this.PGg.alive();
            }
        }
        AppMethodBeat.o(233534);
    }

    @Override // com.tencent.mm.plugin.patmsg.a.d, com.tencent.mm.plugin.patmsg.ui.AvatarPatTipImageView
    public final void aJN(String str) {
    }

    @Override // com.tencent.mm.plugin.patmsg.ui.AvatarPatTipImageView, com.tencent.mm.plugin.patmsg.ui.AvatarPatImageView
    public void onDetachedFromWindow() {
        AppMethodBeat.i(233535);
        super.onDetachedFromWindow();
        removeCallbacks(this.PGh);
        this.PGg.dead();
        AppMethodBeat.o(233535);
    }
}
