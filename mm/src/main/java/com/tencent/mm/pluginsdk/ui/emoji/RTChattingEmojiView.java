package com.tencent.mm.pluginsdk.ui.emoji;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.emoji.view.EmojiStatusView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.emotion.EmojiInfo;

public class RTChattingEmojiView extends FrameLayout {
    private TextView GRM;
    private int KoA;
    private int KoB;
    private int KoC;
    public ChattingEmojiView KoD;
    private ProgressBar KoE;
    private int Koy;
    private int Koz;
    private int mStatus = -1;
    private EmojiInfo rfq;
    private boolean xQE = true;

    static /* synthetic */ void a(RTChattingEmojiView rTChattingEmojiView, int i2) {
        AppMethodBeat.i(104736);
        rTChattingEmojiView.aiJ(i2);
        AppMethodBeat.o(104736);
    }

    public RTChattingEmojiView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RTChattingEmojiView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public void initView() {
        AppMethodBeat.i(104725);
        this.Koy = getContext().getResources().getDimensionPixelSize(R.dimen.a3i);
        this.Koz = getContext().getResources().getDimensionPixelSize(R.dimen.a3f);
        this.KoB = getContext().getResources().getDimensionPixelSize(R.dimen.a3l);
        this.KoC = getContext().getResources().getDimensionPixelSize(R.dimen.a3k);
        this.KoD = new ChattingEmojiView(getContext());
        this.KoE = new ProgressBar(getContext());
        this.KoE.setIndeterminateDrawable(getResources().getDrawable(R.drawable.ape));
        this.GRM = new TextView(getContext());
        this.GRM.setText(R.string.bte);
        this.GRM.setTextColor(getResources().getColor(R.color.mu));
        int fromDPToPix = a.fromDPToPix(getContext(), 32);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(fromDPToPix, fromDPToPix);
        layoutParams.gravity = 17;
        addView(this.KoE, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        addView(this.GRM, layoutParams2);
        AppMethodBeat.o(104725);
    }

    public final void grD() {
        AppMethodBeat.i(104726);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 3;
        addView(this.KoD, layoutParams);
        AppMethodBeat.o(104726);
    }

    public final void grE() {
        AppMethodBeat.i(104727);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 5;
        addView(this.KoD, layoutParams);
        AppMethodBeat.o(104727);
    }

    public final void a(EmojiInfo emojiInfo, long j2) {
        AppMethodBeat.i(104728);
        a(emojiInfo, j2, new be(""));
        AppMethodBeat.o(104728);
    }

    public final void a(EmojiInfo emojiInfo, long j2, be beVar) {
        boolean z = false;
        AppMethodBeat.i(104729);
        Log.i("MicroMsg.emoji.RTChattingEmojiView", "setEmojiInfo %s msgId %s", emojiInfo.field_md5, Long.valueOf(j2));
        this.rfq = emojiInfo;
        if (this.rfq.NA()) {
            this.KoD.setStatus(1);
            aiJ(2);
            ca Hb = ((l) g.af(l.class)).eiy().Hb(j2);
            boolean z2 = Hb.field_status == 2 || Hb.field_status == 3 || Hb.field_status == 5;
            ChattingEmojiView chattingEmojiView = this.KoD;
            if (!beVar.jsi) {
                z = true;
            }
            chattingEmojiView.a(z, z2, ((PluginEmoji) g.ah(PluginEmoji.class)).getEmojiMgr().q(emojiInfo), ((PluginEmoji) g.ah(PluginEmoji.class)).getEmojiMgr().r(emojiInfo), emojiInfo.getName(), String.valueOf(j2 + emojiInfo.getName()));
            AppMethodBeat.o(104729);
            return;
        }
        this.xQE = true;
        this.KoD.setStatusListener(new EmojiStatusView.b() {
            /* class com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView.AnonymousClass1 */

            @Override // com.tencent.mm.emoji.view.EmojiStatusView.b
            public final void po(int i2) {
                AppMethodBeat.i(104724);
                if (i2 == 0) {
                    RTChattingEmojiView.a(RTChattingEmojiView.this, RTChattingEmojiView.this.xQE ? 0 : 1);
                    AppMethodBeat.o(104724);
                } else if (i2 == -1) {
                    RTChattingEmojiView.a(RTChattingEmojiView.this, 3);
                    AppMethodBeat.o(104724);
                } else {
                    RTChattingEmojiView.a(RTChattingEmojiView.this, 2);
                    AppMethodBeat.o(104724);
                }
            }
        });
        this.KoD.a(this.rfq, j2);
        AppMethodBeat.o(104729);
    }

    public void setImageBitmap(Bitmap bitmap) {
        AppMethodBeat.i(104730);
        aiJ(2);
        if (!(this.KoD == null || bitmap == null || bitmap.isRecycled())) {
            bitmap.setDensity(this.KoD.getEmojiDensity());
            this.KoD.setImageBitmap(bitmap);
        }
        AppMethodBeat.o(104730);
    }

    public boolean performClick() {
        AppMethodBeat.i(104731);
        Log.i("MicroMsg.emoji.RTChattingEmojiView", "performClick: %s", Integer.valueOf(this.mStatus));
        if (this.mStatus == 3) {
            this.xQE = false;
            this.KoD.reload();
            AppMethodBeat.o(104731);
            return true;
        } else if (this.mStatus == 2) {
            boolean performClick = super.performClick();
            AppMethodBeat.o(104731);
            return performClick;
        } else {
            Log.d("MicroMsg.emoji.RTChattingEmojiView", "do nothing when loading");
            AppMethodBeat.o(104731);
            return true;
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private void aiJ(int i2) {
        AppMethodBeat.i(104732);
        this.mStatus = i2;
        switch (i2) {
            case 0:
                this.KoE.setVisibility(0);
                this.GRM.setVisibility(4);
                this.KoD.setVisibility(4);
                setBackgroundResource(R.drawable.b0w);
                AppMethodBeat.o(104732);
                return;
            case 1:
                this.KoE.setVisibility(0);
                this.GRM.setVisibility(4);
                this.KoD.setVisibility(4);
                setBackgroundResource(R.drawable.nt);
                AppMethodBeat.o(104732);
                return;
            case 2:
                this.KoD.setVisibility(0);
                this.KoE.setVisibility(4);
                this.GRM.setVisibility(4);
                setBackgroundResource(R.drawable.b0w);
                break;
            case 3:
                Drawable drawable = getResources().getDrawable(R.drawable.emoji_download_icon_samll);
                drawable.setBounds(0, 0, this.KoA, this.KoA);
                Log.d("MicroMsg.emoji.RTChattingEmojiView", "iconSize:%d hashcode:%d", Integer.valueOf(this.KoA), Integer.valueOf(hashCode()));
                this.GRM.setCompoundDrawables(null, drawable, null, null);
                this.GRM.setText(R.string.bte);
                this.GRM.setVisibility(0);
                this.KoE.setVisibility(4);
                this.KoD.setVisibility(4);
                setBackgroundResource(R.drawable.nt);
                AppMethodBeat.o(104732);
                return;
        }
        AppMethodBeat.o(104732);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int i4;
        AppMethodBeat.i(104733);
        if (this.mStatus == 0 || this.mStatus == 1 || this.mStatus == 3) {
            if (this.rfq == null || this.rfq.field_height == 0) {
                i4 = this.Koy;
            } else {
                i4 = Math.max((int) (((float) this.rfq.field_height) * this.KoD.getEmojiDensityScale()), this.Koz);
            }
            if (i4 > this.Koy) {
                i4 = this.Koy;
            }
            this.KoA = this.KoB;
            if (i4 >= this.Koz && i4 < this.Koz + (this.KoB - this.KoC)) {
                this.KoA = (i4 - this.Koz) + this.KoC;
            }
        }
        super.onMeasure(i2, i3);
        AppMethodBeat.o(104733);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(104734);
        super.onAttachedToWindow();
        AppMethodBeat.o(104734);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(104735);
        super.onDetachedFromWindow();
        AppMethodBeat.o(104735);
    }
}
