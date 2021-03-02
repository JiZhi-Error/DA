package com.tencent.mm.pluginsdk.ui.chat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.ac;
import com.tencent.mm.storage.emotion.EmojiInfo;

public final class k extends ac implements j {
    @Override // com.tencent.mm.pluginsdk.ui.chat.j
    public final void N(boolean z, int i2) {
    }

    @Override // com.tencent.mm.pluginsdk.ui.chat.j
    public final void eio() {
    }

    @Override // com.tencent.mm.pluginsdk.ui.chat.j
    public final void B(EmojiInfo emojiInfo) {
        AppMethodBeat.i(104687);
        this.djc.a(emojiInfo);
        AppMethodBeat.o(104687);
    }

    @Override // com.tencent.mm.pluginsdk.ui.chat.j
    public final void ein() {
        AppMethodBeat.i(104689);
        this.djc.onHide();
        AppMethodBeat.o(104689);
    }
}
