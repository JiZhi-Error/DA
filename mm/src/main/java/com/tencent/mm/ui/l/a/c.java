package com.tencent.mm.ui.l.a;

import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.chatting.e.a;
import java.lang.ref.WeakReference;

public final class c {
    public WeakReference<a> QlK;
    public WeakReference<FrameLayout> QlL;
    public long QlM;
    public long msgId;

    public c(a aVar, FrameLayout frameLayout, long j2, long j3) {
        AppMethodBeat.i(234364);
        this.QlK = new WeakReference<>(aVar);
        this.QlL = new WeakReference<>(frameLayout);
        this.msgId = j2;
        this.QlM = j3;
        AppMethodBeat.o(234364);
    }

    public final String toString() {
        AppMethodBeat.i(234365);
        String str = "MagicEmojiMsgDataModel{chattingContext=" + this.QlK + ", holder=" + this.QlL + ", msgId=" + this.msgId + ", msgReceiveTimestamp=" + this.QlM + '}';
        AppMethodBeat.o(234365);
        return str;
    }
}
