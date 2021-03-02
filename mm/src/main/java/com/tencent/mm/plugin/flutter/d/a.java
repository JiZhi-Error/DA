package com.tencent.mm.plugin.flutter.d;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.view.EmojiStatusView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.d;
import io.flutter.plugin.a.j;
import io.flutter.plugin.a.k;
import io.flutter.plugin.platform.c;

public final class a implements k.c, c {
    private final k wJr;
    private final EmojiStatusView wJs;

    a(Context context, io.flutter.plugin.a.c cVar, int i2, Object obj) {
        AppMethodBeat.i(240948);
        this.wJs = new EmojiStatusView(context);
        this.wJs.setEmojiInfo(((d) g.ah(d.class)).getEmojiMgr().amm(obj.toString()));
        this.wJr = new k(cVar, "com.tencent.mm/emoji_preview_".concat(String.valueOf(i2)));
        this.wJr.a(this);
        AppMethodBeat.o(240948);
    }

    @Override // io.flutter.plugin.a.k.c
    public final void a(j jVar, k.d dVar) {
        AppMethodBeat.i(240949);
        String str = jVar.method;
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1949215755:
                if (str.equals("updateMd5")) {
                    c2 = 0;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                this.wJs.setEmojiInfo(((d) g.ah(d.class)).getEmojiMgr().amm(jVar.SxX.toString()));
                AppMethodBeat.o(240949);
                return;
            default:
                dVar.dLv();
                AppMethodBeat.o(240949);
                return;
        }
    }

    @Override // io.flutter.plugin.platform.c
    public final View getView() {
        return this.wJs;
    }
}
