package com.tencent.mm.emoji.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/emoji/model/search/SuggestWordInfo;", "", "wordVersion", "", "wordType", "", "wordSize", "preloadSessionId", "", "(JIILjava/lang/String;)V", "getPreloadSessionId", "()Ljava/lang/String;", "setPreloadSessionId", "(Ljava/lang/String;)V", "getWordSize", "()I", "setWordSize", "(I)V", "getWordType", "setWordType", "getWordVersion", "()J", "setWordVersion", "(J)V", "plugin-emojisdk_release"})
public final class m {
    public int gZE;
    public long gZF;
    public int gZP;
    public String gZQ;

    public m() {
        this(0, 0, 0, null, 15);
    }

    private m(long j2, int i2, int i3, String str) {
        p.h(str, "preloadSessionId");
        AppMethodBeat.i(199959);
        this.gZF = j2;
        this.gZE = i2;
        this.gZP = i3;
        this.gZQ = str;
        AppMethodBeat.o(199959);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m(long j2, int i2, int i3, String str, int i4) {
        this((i4 & 1) != 0 ? 0 : j2, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) == 0 ? i3 : 0, (i4 & 8) != 0 ? "-1" : str);
        AppMethodBeat.i(199960);
        AppMethodBeat.o(199960);
    }
}
