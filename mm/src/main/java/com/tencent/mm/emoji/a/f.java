package com.tencent.mm.emoji.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.emoji.b.a;
import com.tencent.mm.emoji.e.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.s;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/emoji/egg/EmojiEggUtil;", "", "()V", "Companion", "plugin-emojisdk_release"})
public final class f {
    private static final String TAG = TAG;
    private static final String dFG = dFG;
    private static final String gVw;
    private static long gVx;
    private static b gVy = new b();
    public static final a gVz = new a((byte) 0);

    public static final String r(ca caVar) {
        AppMethodBeat.i(199898);
        String r = a.r(caVar);
        AppMethodBeat.o(199898);
        return r;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0004J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\u0006\u0010\u0019\u001a\u00020\u0012R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/emoji/egg/EmojiEggUtil$Companion;", "", "()V", "TAG", "", "animConfig", "Lcom/tencent/mm/emoji/egg/EmojiAnimConfig;", "getAnimConfig", "()Lcom/tencent/mm/emoji/egg/EmojiAnimConfig;", "setAnimConfig", "(Lcom/tencent/mm/emoji/egg/EmojiAnimConfig;)V", "assetDir", "configName", "lastCheckTick", "", "localDir", "versionName", "checkAnimUpdate", "", "getAnimItem", "Lcom/tencent/mm/emoji/egg/EmojiAnimConfig$EmojiAnimItem;", "key", "getMsgContent", "msgInfo", "Lcom/tencent/mm/storage/MsgInfo;", "initAnimConfig", "plugin-emojisdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static String r(ca caVar) {
            AppMethodBeat.i(199894);
            p.h(caVar, "msgInfo");
            String content = caVar.getContent();
            if (ab.Eq(caVar.ajO())) {
                content = bp.Kq(content);
            }
            if (caVar.gDx() || caVar.gDy()) {
                k.b aD = k.b.aD(content, caVar.ajQ());
                content = aD != null ? aD.title : null;
            }
            AppMethodBeat.o(199894);
            return content;
        }

        public static void auy() {
            AppMethodBeat.i(199895);
            int EY = b.EY(f.gVw + "config.conf");
            int EY2 = b.EY("assets:///panel/config.conf");
            String str = f.gVw + f.dFG;
            String str2 = "assets:///panel/" + f.dFG;
            if (EY <= 0 || EY < EY2 || !s.YS(str)) {
                a.C0319a aVar = com.tencent.mm.emoji.b.a.gWU;
                a.C0319a.a(str2, f.gVy);
            } else {
                a.C0319a aVar2 = com.tencent.mm.emoji.b.a.gWU;
                a.C0319a.a(str, f.gVy);
            }
            Log.i(f.TAG, "initAnimConfig: version:" + EY + ", " + EY2 + "; content " + f.gVy.gUV.size());
            AppMethodBeat.o(199895);
        }

        public static void auz() {
            AppMethodBeat.i(199896);
            if (!MMApplicationContext.isMainProcess()) {
                AppMethodBeat.o(199896);
            } else if (!g.aAc()) {
                AppMethodBeat.o(199896);
            } else {
                if (Util.ticksToNow(f.gVx) > 1800000) {
                    f.gVx = Util.currentTicks();
                    com.tencent.mm.pluginsdk.j.a.a.b.gnC().g(37, 7, -1, false);
                    com.tencent.mm.pluginsdk.j.a.a.b.gnC();
                    com.tencent.mm.pluginsdk.j.a.a.b.ahP(37);
                    Log.i(f.TAG, "checkAnimUpdate: " + f.gVy.gUV.size() + ", " + f.gVx);
                }
                AppMethodBeat.o(199896);
            }
        }
    }

    static {
        AppMethodBeat.i(199897);
        StringBuilder sb = new StringBuilder();
        com.tencent.mm.emoji.e.a aVar = com.tencent.mm.emoji.e.a.hdT;
        gVw = sb.append(com.tencent.mm.emoji.e.a.awv()).append("panel/").toString();
        a.auy();
        AppMethodBeat.o(199897);
    }
}
