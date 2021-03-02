package com.tencent.mm.search.c;

import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.j;
import com.tencent.mm.g.b.a.hi;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\bJ\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0006J\u0006\u0010\u0013\u001a\u00020\u000eJ&\u0010\u0014\u001a\u00020\u000e2\u0016\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0016j\b\u0012\u0004\u0012\u00020\u0006`\u00172\u0006\u0010\u0010\u001a\u00020\bJ\u0016\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/search/report/SimilarEmojiReport;", "", "()V", "chatId", "", "source", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", AppMeasurement.Param.TIMESTAMP, "", "getTimestamp", "()J", "setTimestamp", "(J)V", "reportClickEmoji", "", "select", FirebaseAnalytics.b.INDEX, "reportClickSimilarMenu", "emojiInfo", "reportClickSosEntrance", "reportListIdle", "emojiList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "reportShowSimilarMenu", "plugin-emojisdk_release"})
public final class b {
    private static EmojiInfo NJw;
    public static final b NJx = new b();
    private static String gVs = "";
    private static long timestamp;

    static {
        AppMethodBeat.i(105858);
        AppMethodBeat.o(105858);
    }

    private b() {
    }

    public static long getTimestamp() {
        return timestamp;
    }

    public static void c(EmojiInfo emojiInfo, String str) {
        AppMethodBeat.i(200088);
        p.h(emojiInfo, "emojiInfo");
        p.h(str, "chatId");
        timestamp = System.currentTimeMillis();
        NJw = emojiInfo;
        gVs = str;
        hi hiVar = new hi();
        hiVar.qN(timestamp);
        hiVar.qO(1);
        hiVar.uW(emojiInfo.field_groupId);
        hiVar.uX(emojiInfo.getMd5());
        hiVar.vd(str);
        hiVar.bfK();
        a aVar = a.NJv;
        a.gxr();
        AppMethodBeat.o(200088);
    }

    public static void E(EmojiInfo emojiInfo) {
        AppMethodBeat.i(105855);
        p.h(emojiInfo, "emojiInfo");
        hi hiVar = new hi();
        hiVar.qN(timestamp);
        hiVar.qO(2);
        hiVar.uW(emojiInfo.field_groupId);
        hiVar.uX(emojiInfo.getMd5());
        hiVar.vd(gVs);
        hiVar.bfK();
        a aVar = a.NJv;
        a.gxs();
        AppMethodBeat.o(105855);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.search.c.b$b  reason: collision with other inner class name */
    static final class RunnableC2056b implements Runnable {
        final /* synthetic */ ArrayList NJA;
        final /* synthetic */ long NJy;

        RunnableC2056b(long j2, ArrayList arrayList) {
            this.NJy = j2;
            this.NJA = arrayList;
        }

        public final void run() {
            String str = null;
            AppMethodBeat.i(105853);
            hi hiVar = new hi();
            b bVar = b.NJx;
            hiVar.qN(b.getTimestamp());
            hiVar.qO(3);
            b bVar2 = b.NJx;
            EmojiInfo emojiInfo = b.NJw;
            hiVar.uW(emojiInfo != null ? emojiInfo.field_groupId : null);
            b bVar3 = b.NJx;
            EmojiInfo emojiInfo2 = b.NJw;
            if (emojiInfo2 != null) {
                str = emojiInfo2.getMd5();
            }
            hiVar.uX(str);
            hiVar.qP(this.NJy);
            hiVar.agV();
            hiVar.uY("");
            hiVar.uZ("");
            hiVar.va("");
            hiVar.vb("");
            hiVar.vc("");
            for (EmojiInfo emojiInfo3 : this.NJA) {
                hiVar.uY(hiVar.agU() + emojiInfo3.field_groupId + "#");
                hiVar.uZ(hiVar.getMd5() + emojiInfo3.getMd5() + "#");
                hiVar.va(hiVar.agW() + String.valueOf(emojiInfo3.Vlo) + "#");
                hiVar.vc(hiVar.agY() + (j.auL().l(emojiInfo3) ? "2" : "1") + "#");
                if (com.tencent.mm.plugin.emoji.h.b.w(emojiInfo3)) {
                    hiVar.vb(hiVar.agX() + "1".concat(String.valueOf("#")));
                } else {
                    hiVar.vb(hiVar.agX() + "2".concat(String.valueOf("#")));
                }
            }
            b bVar4 = b.NJx;
            hiVar.vd(b.gVs);
            hiVar.bfK();
            AppMethodBeat.o(105853);
        }
    }

    public static void b(ArrayList<EmojiInfo> arrayList, long j2) {
        AppMethodBeat.i(105856);
        p.h(arrayList, "emojiList");
        h.RTc.aX(new RunnableC2056b(j2, arrayList));
        AppMethodBeat.o(105856);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class a implements Runnable {
        final /* synthetic */ long NJy;
        final /* synthetic */ EmojiInfo NJz;

        a(long j2, EmojiInfo emojiInfo) {
            this.NJy = j2;
            this.NJz = emojiInfo;
        }

        public final void run() {
            String str = null;
            AppMethodBeat.i(105852);
            hi hiVar = new hi();
            b bVar = b.NJx;
            hiVar.qN(b.getTimestamp());
            hiVar.qO(4);
            b bVar2 = b.NJx;
            EmojiInfo emojiInfo = b.NJw;
            hiVar.uW(emojiInfo != null ? emojiInfo.field_groupId : null);
            b bVar3 = b.NJx;
            EmojiInfo emojiInfo2 = b.NJw;
            if (emojiInfo2 != null) {
                str = emojiInfo2.getMd5();
            }
            hiVar.uX(str);
            hiVar.qP(this.NJy);
            hiVar.agV();
            hiVar.uY(this.NJz.field_groupId);
            hiVar.uZ(this.NJz.getMd5());
            hiVar.va(String.valueOf(this.NJz.Vlo));
            hiVar.vc(j.auL().l(this.NJz) ? "2" : "1");
            if (com.tencent.mm.plugin.emoji.h.b.w(this.NJz)) {
                hiVar.vb("1");
            } else {
                hiVar.vb("2");
            }
            b bVar4 = b.NJx;
            hiVar.vd(b.gVs);
            hiVar.bfK();
            AppMethodBeat.o(105852);
        }
    }

    public static void b(EmojiInfo emojiInfo, long j2) {
        AppMethodBeat.i(105857);
        p.h(emojiInfo, "select");
        h.RTc.aX(new a(j2, emojiInfo));
        AppMethodBeat.o(105857);
    }

    public static void gxy() {
        String str = null;
        AppMethodBeat.i(169247);
        hi hiVar = new hi();
        hiVar.qN(timestamp);
        hiVar.qO(5);
        EmojiInfo emojiInfo = NJw;
        hiVar.uW(emojiInfo != null ? emojiInfo.field_groupId : null);
        EmojiInfo emojiInfo2 = NJw;
        if (emojiInfo2 != null) {
            str = emojiInfo2.getMd5();
        }
        hiVar.uX(str);
        hiVar.agV();
        hiVar.vd(gVs);
        hiVar.bfK();
        AppMethodBeat.o(169247);
    }
}
