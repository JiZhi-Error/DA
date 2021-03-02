package com.tencent.mm.pluginsdk.ui.emoji;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class RTChattingEmojiViewTo extends RTChattingEmojiView {
    public RTChattingEmojiViewTo(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(104741);
        initView();
        AppMethodBeat.o(104741);
    }

    public RTChattingEmojiViewTo(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(104742);
        initView();
        AppMethodBeat.o(104742);
    }

    @Override // com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView
    public final void initView() {
        AppMethodBeat.i(104743);
        super.initView();
        grE();
        AppMethodBeat.o(104743);
    }
}
