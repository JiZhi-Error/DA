package com.tencent.mm.plugin.expt.roomexpt;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class c implements Comparable<c> {
    String dFl;
    String nickname;
    float score;

    c() {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(c cVar) {
        c cVar2 = cVar;
        if (this.score > cVar2.score) {
            return -1;
        }
        if (this.score < cVar2.score) {
            return 1;
        }
        return 0;
    }

    public final String toString() {
        AppMethodBeat.i(122426);
        String format = String.format("chatroom[%s %s] score[%f]", this.dFl, this.nickname, Float.valueOf(this.score));
        AppMethodBeat.o(122426);
        return format;
    }
}
