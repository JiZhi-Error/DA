package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.c;

public class a extends MTimerHandler {
    private static int rcj = 0;
    private static a rck;
    private static r rcl;
    private static i rcm = new i() {
        /* class com.tencent.mm.plugin.emoji.f.a.AnonymousClass1 */

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
            AppMethodBeat.i(108659);
            if (i2 == 0 && i3 == 0) {
                int unused = a.rcj = 0;
                a.cGm().startTimer(50);
                AppMethodBeat.o(108659);
                return;
            }
            a.cGm().cGo();
            AppMethodBeat.o(108659);
        }
    };

    static {
        AppMethodBeat.i(108667);
        AppMethodBeat.o(108667);
    }

    public static final a cGm() {
        AppMethodBeat.i(108662);
        if (rck == null) {
            synchronized (a.class) {
                try {
                    if (rck == null) {
                        rck = new a();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(108662);
                    throw th;
                }
            }
        } else {
            rck.stopTimer();
        }
        a aVar = rck;
        AppMethodBeat.o(108662);
        return aVar;
    }

    public static void cGn() {
        AppMethodBeat.i(108663);
        rcj = 0;
        rcl = new r("com.tencent.xin.emoticon.tusiji", 1);
        g.aAg().hqi.a(rcl, 0);
        g.aAg().hqi.a(413, rcm);
        Log.d("MicroMsg.emoji.MockTuziDownloading", "add listener");
        AppMethodBeat.o(108663);
    }

    public final void cGo() {
        AppMethodBeat.i(108664);
        stopTimer();
        k.cGk().h(com.tencent.mm.plugin.emoji.h.a.cIr(), 3, rcj, "");
        removeListener();
        AppMethodBeat.o(108664);
    }

    public static void removeListener() {
        AppMethodBeat.i(108665);
        if (rcl != null) {
            g.aAg().hqi.a(rcl);
        }
        g.aAg().hqi.b(413, rcm);
        Log.d("MicroMsg.emoji.MockTuziDownloading", "remove listener");
        AppMethodBeat.o(108665);
    }

    private a() {
        super(new C0958a(), true);
        AppMethodBeat.i(108666);
        AppMethodBeat.o(108666);
    }

    /* renamed from: com.tencent.mm.plugin.emoji.f.a$a  reason: collision with other inner class name */
    public static class C0958a implements MTimerHandler.CallBack {
        public C0958a() {
            AppMethodBeat.i(108660);
            int unused = a.rcj = 0;
            AppMethodBeat.o(108660);
        }

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(108661);
            if (a.rcj >= 100) {
                int unused = a.rcj = 0;
                Log.d("MicroMsg.emoji.EmojiTuziTool", "insert tuzi");
                c cVar = k.getEmojiStorageMgr().OpO;
                EmojiGroupInfo emojiGroupInfo = new EmojiGroupInfo();
                emojiGroupInfo.field_productID = com.tencent.mm.plugin.emoji.h.a.cIr();
                emojiGroupInfo.field_packName = "emoji_custom_all";
                emojiGroupInfo.field_type = EmojiGroupInfo.TYPE_SYSTEM;
                emojiGroupInfo.field_sort = 1;
                emojiGroupInfo.field_idx = 0;
                emojiGroupInfo.field_packType = 4;
                emojiGroupInfo.field_packFlag = 1;
                emojiGroupInfo.field_lastUseTime = System.currentTimeMillis();
                cVar.c(emojiGroupInfo);
                k.cGk().h(com.tencent.mm.plugin.emoji.h.a.cIr(), 7, a.rcj, "");
                a.removeListener();
                AppMethodBeat.o(108661);
                return false;
            }
            k.cGk().h(com.tencent.mm.plugin.emoji.h.a.cIr(), 6, a.rcj, "");
            a.rcj += 2;
            AppMethodBeat.o(108661);
            return true;
        }
    }
}
