package com.tencent.mm.plugin.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.widget.a.f;
import java.util.ArrayList;

public class c {
    public static c qZt;
    public ArrayList<String> qZu = new ArrayList<>();
    public boolean qZv = true;
    public boolean qZw = false;

    public c() {
        AppMethodBeat.i(108415);
        AppMethodBeat.o(108415);
    }

    static /* synthetic */ void b(c cVar, EmojiInfo emojiInfo) {
        AppMethodBeat.i(108421);
        cVar.c(emojiInfo, false);
        AppMethodBeat.o(108421);
    }

    public static c cFD() {
        AppMethodBeat.i(108416);
        if (qZt == null) {
            synchronized (c.class) {
                try {
                    qZt = new c();
                } catch (Throwable th) {
                    AppMethodBeat.o(108416);
                    throw th;
                }
            }
        }
        c cVar = qZt;
        AppMethodBeat.o(108416);
        return cVar;
    }

    public static void b(EmojiInfo emojiInfo, boolean z) {
        AppMethodBeat.i(108417);
        if (emojiInfo != null) {
            emojiInfo.field_reserved4 = 0;
            k.getEmojiStorageMgr().OpN.M(emojiInfo);
            k.cGd().u(emojiInfo);
            if (z) {
                h.INSTANCE.idkeyStat(231, 0, 1, false);
                AppMethodBeat.o(108417);
                return;
            }
            h.INSTANCE.idkeyStat(231, 1, 1, false);
        }
        AppMethodBeat.o(108417);
    }

    private void c(EmojiInfo emojiInfo, boolean z) {
        AppMethodBeat.i(108418);
        if (this.qZu == null) {
            this.qZu = new ArrayList<>();
        }
        this.qZu.add(emojiInfo.field_groupId);
        g.aAg().hqi.a(new com.tencent.mm.plugin.emoji.f.h(emojiInfo.field_groupId), 0);
        if (z) {
            h.INSTANCE.idkeyStat(231, 3, 1, false);
            AppMethodBeat.o(108418);
            return;
        }
        h.INSTANCE.idkeyStat(231, 2, 1, false);
        AppMethodBeat.o(108418);
    }

    private static boolean cFE() {
        AppMethodBeat.i(108419);
        if (NetStatusUtil.is3G(MMApplicationContext.getContext()) || NetStatusUtil.is4G(MMApplicationContext.getContext()) || NetStatusUtil.is2G(MMApplicationContext.getContext())) {
            AppMethodBeat.o(108419);
            return true;
        }
        AppMethodBeat.o(108419);
        return false;
    }

    static /* synthetic */ void a(c cVar, final EmojiInfo emojiInfo) {
        AppMethodBeat.i(108420);
        if (emojiInfo != null && !cVar.qZu.contains(emojiInfo.field_groupId)) {
            if (!cFE() || cVar.qZw) {
                if (cFE()) {
                    cVar.c(emojiInfo, false);
                    Log.i("MicroMsg.emoji.EmojiFileCheckerMgr", "smiley pannel emotion broken. try to recover in mobile netword:%s", emojiInfo.field_groupId);
                    AppMethodBeat.o(108420);
                    return;
                }
                cVar.c(emojiInfo, true);
                Log.i("MicroMsg.emoji.EmojiFileCheckerMgr", "smiley pannel emotion broken. try to recover in wifi netword:%s", emojiInfo.field_groupId);
            } else if (cVar.qZv) {
                new f.a(MMApplicationContext.getContext()).bow(MMApplicationContext.getContext().getString(R.string.bv2)).b(new f.c() {
                    /* class com.tencent.mm.plugin.emoji.e.c.AnonymousClass4 */

                    @Override // com.tencent.mm.ui.widget.a.f.c
                    public final void e(boolean z, String str) {
                        AppMethodBeat.i(108414);
                        c.b(c.this, emojiInfo);
                        c.this.qZw = true;
                        Log.i("MicroMsg.emoji.EmojiFileCheckerMgr", "smiley pannel emotion broken. try to recover in mobile netword:%s", emojiInfo.field_groupId);
                        AppMethodBeat.o(108414);
                    }
                }).a(new f.c() {
                    /* class com.tencent.mm.plugin.emoji.e.c.AnonymousClass3 */

                    @Override // com.tencent.mm.ui.widget.a.f.c
                    public final void e(boolean z, String str) {
                        c.this.qZw = false;
                    }
                }).show();
                cVar.qZv = false;
                AppMethodBeat.o(108420);
                return;
            } else {
                Log.i("MicroMsg.emoji.EmojiFileCheckerMgr", "has alert recover.");
                AppMethodBeat.o(108420);
                return;
            }
        }
        AppMethodBeat.o(108420);
    }
}
