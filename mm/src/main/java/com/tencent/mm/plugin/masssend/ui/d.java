package com.tencent.mm.plugin.masssend.ui;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.chat.j;
import com.tencent.mm.storage.emotion.EmojiInfo;

public final class d implements j {
    private Context context;

    public d(Context context2) {
        this.context = context2;
    }

    @Override // com.tencent.mm.pluginsdk.ui.chat.j
    public final void B(EmojiInfo emojiInfo) {
        AppMethodBeat.i(26512);
        Toast.makeText(this.context, this.context.getString(R.string.ey6), 0).show();
        AppMethodBeat.o(26512);
    }

    @Override // com.tencent.mm.pluginsdk.ui.chat.j
    public final void ein() {
    }

    @Override // com.tencent.mm.pluginsdk.ui.chat.j
    public final void N(boolean z, int i2) {
    }

    @Override // com.tencent.mm.pluginsdk.ui.chat.j
    public final void eio() {
    }
}
