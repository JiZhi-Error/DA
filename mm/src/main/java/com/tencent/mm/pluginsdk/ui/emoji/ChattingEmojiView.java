package com.tencent.mm.pluginsdk.ui.emoji;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.emoji.loader.e;
import com.tencent.mm.emoji.view.EmojiStatusView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiInfo;

public class ChattingEmojiView extends EmojiStatusView {
    protected int Kor;
    protected int Kos;
    private String cacheKey;
    private EmojiInfo gWm;

    public ChattingEmojiView(Context context) {
        this(context, null);
    }

    public ChattingEmojiView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChattingEmojiView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(104704);
        this.Kor = context.getResources().getDimensionPixelSize(R.dimen.a3i);
        this.Kos = context.getResources().getDimensionPixelSize(R.dimen.a3g);
        setDefaultImageResource(0);
        setGameUseCover(false);
        AppMethodBeat.o(104704);
    }

    public final void a(EmojiInfo emojiInfo, long j2) {
        AppMethodBeat.i(104705);
        this.gWm = emojiInfo;
        this.cacheKey = String.valueOf(j2);
        setImageDrawable(null);
        reload();
        AppMethodBeat.o(104705);
    }

    @Override // com.tencent.mm.emoji.view.EmojiStatusView
    public final void reload() {
        AppMethodBeat.i(104706);
        if (this.gWm != null) {
            setStatusNotify(0);
            e eVar = e.gVM;
            e.a(this.gWm, this, this.cacheKey);
            AppMethodBeat.o(104706);
            return;
        }
        e eVar2 = e.gVM;
        e.cl(this);
        AppMethodBeat.o(104706);
    }

    @Override // android.support.v7.widget.AppCompatImageView
    public void setImageDrawable(Drawable drawable) {
        AppMethodBeat.i(104707);
        super.setImageDrawable(drawable);
        AppMethodBeat.o(104707);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int intrinsicWidth;
        int intrinsicHeight;
        AppMethodBeat.i(104708);
        super.onMeasure(i2, i3);
        if (getStatus() == 1 || this.gWm == null) {
            intrinsicWidth = getIntrinsicWidth();
            intrinsicHeight = getIntrinsicHeight();
        } else {
            int emojiDensityScale = (int) (((float) this.gWm.field_width) * getEmojiDensityScale());
            int emojiDensityScale2 = (int) (((float) this.gWm.field_height) * getEmojiDensityScale());
            if (emojiDensityScale <= 0) {
                emojiDensityScale = this.Kor;
            }
            if (emojiDensityScale2 <= 0) {
                emojiDensityScale2 = this.Kor;
            }
            intrinsicWidth = Math.max(0, emojiDensityScale);
            intrinsicHeight = Math.max(0, emojiDensityScale2);
        }
        if (intrinsicWidth <= 0) {
            intrinsicWidth = this.Kor;
        }
        if (intrinsicHeight <= 0) {
            intrinsicHeight = this.Kor;
        }
        if (intrinsicHeight < this.Kos || intrinsicWidth < this.Kos) {
            if (intrinsicWidth < intrinsicHeight) {
                float f2 = ((float) this.Kos) / ((float) intrinsicWidth);
                intrinsicWidth = this.Kos;
                intrinsicHeight = (int) (((float) intrinsicHeight) * f2);
            } else if (intrinsicHeight < intrinsicWidth) {
                float f3 = ((float) this.Kos) / ((float) intrinsicHeight);
                intrinsicHeight = this.Kos;
                intrinsicWidth = (int) (((float) intrinsicWidth) * f3);
            } else {
                intrinsicHeight = this.Kos;
                intrinsicWidth = this.Kos;
            }
        }
        if (intrinsicWidth > this.Kor || intrinsicHeight > this.Kor) {
            if (intrinsicWidth > intrinsicHeight) {
                float f4 = ((float) this.Kor) / ((float) intrinsicWidth);
                intrinsicWidth = this.Kor;
                intrinsicHeight = (int) (((float) intrinsicHeight) * f4);
            } else if (intrinsicHeight > intrinsicWidth) {
                float f5 = ((float) this.Kor) / ((float) intrinsicHeight);
                intrinsicHeight = this.Kor;
                intrinsicWidth = (int) (((float) intrinsicWidth) * f5);
            } else {
                intrinsicWidth = this.Kor;
                intrinsicHeight = this.Kor;
            }
        }
        setMeasuredDimension(intrinsicWidth, intrinsicHeight);
        Log.d("MicroMsg.emoji.ChattingEmojiView", "onMeasure width:%d height:%d", Integer.valueOf(intrinsicWidth), Integer.valueOf(intrinsicHeight));
        AppMethodBeat.o(104708);
    }
}
