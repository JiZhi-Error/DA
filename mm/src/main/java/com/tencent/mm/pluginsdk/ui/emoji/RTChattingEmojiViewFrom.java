package com.tencent.mm.pluginsdk.ui.emoji;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class RTChattingEmojiViewFrom extends RTChattingEmojiView {
    public RTChattingEmojiViewFrom(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(104738);
        initView();
        AppMethodBeat.o(104738);
    }

    public RTChattingEmojiViewFrom(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(104739);
        initView();
        AppMethodBeat.o(104739);
    }

    @Override // com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView
    public final void initView() {
        AppMethodBeat.i(104740);
        super.initView();
        grD();
        AppMethodBeat.o(104740);
    }
}
