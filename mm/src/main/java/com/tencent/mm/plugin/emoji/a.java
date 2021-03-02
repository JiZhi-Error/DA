package com.tencent.mm.plugin.emoji;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.storage.emotion.EmojiInfo;

public final class a extends o.e {
    public String fQY;
    public EmojiInfo gWm;
    public int type;

    public static a cEL() {
        AppMethodBeat.i(199779);
        a aVar = new a();
        aVar.jec = o.d.EMOJI;
        AppMethodBeat.o(199779);
        return aVar;
    }

    @Override // com.tencent.mm.modelmulti.o.e
    public final /* bridge */ /* synthetic */ o.e tD(int i2) {
        this.type = i2;
        return this;
    }
}
