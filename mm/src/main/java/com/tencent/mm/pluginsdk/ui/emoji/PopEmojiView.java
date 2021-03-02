package com.tencent.mm.pluginsdk.ui.emoji;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.storage.emotion.EmojiInfo;

public class PopEmojiView extends LinearLayout {
    private MMEmojiView Kow;
    private ProgressBar Kox;
    private ViewGroup nmW;

    public PopEmojiView(Context context) {
        super(context);
        AppMethodBeat.i(104715);
        init(context);
        AppMethodBeat.o(104715);
    }

    public PopEmojiView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(104716);
        init(context);
        AppMethodBeat.o(104716);
    }

    public PopEmojiView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(104717);
        init(context);
        AppMethodBeat.o(104717);
    }

    private void init(Context context) {
        AppMethodBeat.i(104718);
        this.nmW = (ViewGroup) inflate(getContext(), R.layout.bin, null);
        this.Kow = (MMEmojiView) this.nmW.findViewById(R.id.dup);
        this.Kow.setIsMaxSizeLimit(true);
        this.Kow.setMaxSize(context.getResources().getDimensionPixelSize(R.dimen.a3i) - (context.getResources().getDimensionPixelSize(R.dimen.ib) * 3));
        this.Kox = (ProgressBar) this.nmW.findViewById(R.id.gl7);
        addView(this.nmW, -1, -1);
        AppMethodBeat.o(104718);
    }

    public void setImageResource(int i2) {
        AppMethodBeat.i(104719);
        if (this.Kow != null) {
            this.Kow.setImageResource(i2);
        }
        AppMethodBeat.o(104719);
    }

    public void setEmojiInfo(EmojiInfo emojiInfo) {
        AppMethodBeat.i(104720);
        if (this.Kow != null) {
            this.Kow.b(emojiInfo, "");
        }
        AppMethodBeat.o(104720);
    }

    public void setImageBitmap(Bitmap bitmap) {
        AppMethodBeat.i(104721);
        if (!(this.Kow == null || bitmap == null || bitmap.isRecycled())) {
            bitmap.setDensity(this.Kow.getEmojiDensity());
            this.Kow.setImageBitmap(bitmap);
        }
        AppMethodBeat.o(104721);
    }
}
