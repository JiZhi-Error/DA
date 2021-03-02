package com.tencent.mm.emoji.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.emoji.b.c.j;
import com.tencent.mm.emoji.loader.d.i;
import com.tencent.mm.emoji.loader.e;
import com.tencent.mm.g.b.a.jx;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.protocal.protobuf.cji;
import com.tencent.mm.protocal.protobuf.dkt;
import com.tencent.mm.protocal.protobuf.dlc;
import com.tencent.mm.protocal.protobuf.dld;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.g;
import com.tencent.mm.vending.e.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0007H\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u000e\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u0007J\u001a\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\u00152\b\u0010\u001d\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0010\u001a\u00020\u0007R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/emoji/model/search/EmojiSuggestRemote;", "Lcom/tencent/mm/emoji/model/search/IEmojiSuggest;", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "(Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;)V", "TAG", "", "getLifeCycleKeeper", "()Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "remoteShuffle", "", "getRemoteShuffle", "()Z", "setRemoteShuffle", "(Z)V", "sessionId", ch.COL_USERNAME, "checkMatch", "desc", "checkPrefetch", "", "rsp", "Lcom/tencent/mm/protocal/protobuf/RecommendPanelEmojiResponse;", "checkUpdate", "searchSuggest", "callback", "Lcom/tencent/mm/emoji/model/search/IEmojiSuggest$SuggestCallback;", "setRequestInfo", "chatId", "plugin-emojisdk_release"})
public final class f implements j {
    private final String TAG;
    boolean gZB;
    private final b<com.tencent.mm.vending.e.a> gZm;
    public String sessionId;
    public String username;

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/RecommendPanelEmojiResponse;", "kotlin.jvm.PlatformType", "call"})
    public static final class a<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ f gZC;
        final /* synthetic */ jx gZD;
        final /* synthetic */ String gZs;

        a(f fVar, jx jxVar, String str) {
            this.gZC = fVar;
            this.gZD = jxVar;
            this.gZs = str;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            LinkedList<dkt> linkedList;
            LinkedList<dkt> linkedList2;
            AppMethodBeat.i(199943);
            c.a aVar = (c.a) obj;
            int i2 = aVar.errType;
            int i3 = aVar.errCode;
            dld dld = (dld) aVar.iLC;
            Log.i(this.gZC.TAG, "checkUpdate: cgi result: " + i2 + ", " + i3 + ", " + ((dld == null || (linkedList2 = dld.LVc) == null) ? null : Integer.valueOf(linkedList2.size())));
            this.gZD.ta(Util.nowMilliSecond());
            this.gZD.tc((long) i3);
            if (i2 == 0 && i3 == 0) {
                this.gZD.tb(1);
                if (!(dld == null || (linkedList = dld.LVc) == null)) {
                    if (!linkedList.isEmpty()) {
                        bj gCJ = bj.gCJ();
                        p.g(gCJ, "EmojiStorageMgr.getInstance()");
                        g gCO = gCJ.gCO();
                        c cVar = new c();
                        cVar.field_desc = this.gZs;
                        cVar.field_updateTime = (int) Util.nowSecond();
                        cVar.field_content = dld.toByteArray();
                        gCO.a(cVar);
                        f.a(this.gZC, dld);
                    }
                }
                d dVar = d.gZA;
                d.pl(41);
            } else {
                this.gZD.tb(2);
            }
            Boolean valueOf = Boolean.valueOf(this.gZD.bfK());
            AppMethodBeat.o(199943);
            return valueOf;
        }
    }

    private /* synthetic */ f() {
        this(null);
    }

    public f(b<com.tencent.mm.vending.e.a> bVar) {
        this.gZm = bVar;
        this.TAG = "MicroMsg.EmojiSuggestMatchWord";
    }

    public static boolean ET(String str) {
        AppMethodBeat.i(199944);
        p.h(str, "desc");
        g gVar = g.gZH;
        boolean EV = g.EV(str);
        AppMethodBeat.o(199944);
        return EV;
    }

    public final void a(String str, j.b bVar) {
        EmojiInfo emojiInfo;
        boolean z;
        int i2;
        AppMethodBeat.i(199945);
        p.h(str, "desc");
        boolean a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_emoji_suggest_remote_enable, false);
        Log.i(this.TAG, "searchSuggest: remoteEnable ".concat(String.valueOf(a2)));
        g gVar = g.gZH;
        long avK = g.avK();
        g gVar2 = g.gZH;
        int avJ = g.avJ();
        g gVar3 = g.gZH;
        m mVar = new m(avK, avJ, g.avM().size(), null, 8);
        if (a2) {
            bj gCJ = bj.gCJ();
            p.g(gCJ, "EmojiStorageMgr.getInstance()");
            c blp = gCJ.gCO().blp(str);
            if (blp != null) {
                Log.i(this.TAG, "searchSuggest: has cache " + blp.field_updateTime);
                d dVar = d.gZA;
                d.pl(32);
                dld dld = new dld();
                try {
                    dld.parseFrom(blp.field_content);
                } catch (Exception e2) {
                    Log.printDebugStack("safeParser", "", e2);
                }
                String str2 = dld.SessionId;
                if (str2 == null) {
                    str2 = "";
                }
                p.h(str2, "<set-?>");
                mVar.gZQ = str2;
                if (bVar != null) {
                    LinkedList<dkt> linkedList = dld.LVc;
                    p.g(linkedList, "rsp.Emoji");
                    LinkedList<dkt> linkedList2 = linkedList;
                    ArrayList arrayList = new ArrayList(kotlin.a.j.a(linkedList2, 10));
                    int i3 = 0;
                    for (T t : linkedList2) {
                        int i4 = i3 + 1;
                        if (i3 < 0) {
                            kotlin.a.j.hxH();
                        }
                        T t2 = t;
                        bj gCJ2 = bj.gCJ();
                        p.g(gCJ2, "EmojiStorageMgr.getInstance()");
                        EmojiInfo blk = gCJ2.cgN().blk(t2.MOJ.Md5);
                        if (blk == null) {
                            EmojiInfo emojiInfo2 = new EmojiInfo();
                            com.tencent.mm.plugin.emoji.h.b.a(t2.MOJ, emojiInfo2);
                            emojiInfo2.field_catalog = EmojiInfo.VkQ;
                            emojiInfo = emojiInfo2;
                        } else {
                            emojiInfo = blk;
                        }
                        com.tencent.mm.emoji.b.j auL = com.tencent.mm.emoji.b.j.auL();
                        p.g(auL, "EmojiStorageCache.getInstance()");
                        ArrayList<EmojiGroupInfo> auP = auL.auP();
                        p.g(auP, "EmojiStorageCache.getInstance().emojiGroupInfoList");
                        ArrayList<EmojiGroupInfo> arrayList2 = auP;
                        if (!(arrayList2 instanceof Collection) || !arrayList2.isEmpty()) {
                            Iterator<T> it = arrayList2.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                T next = it.next();
                                p.g(next, LocaleUtil.ITALIAN);
                                if (p.j(next.hYf(), emojiInfo.field_groupId)) {
                                    z = true;
                                    break;
                                }
                            }
                        }
                        z = false;
                        if (t2.MOM == 1) {
                            if (z) {
                                i2 = 0;
                                arrayList.add(new l(emojiInfo, i2, i3 + 1));
                                i3 = i4;
                            } else {
                                Log.i(this.TAG, "searchSuggest: delete local emoji " + emojiInfo.getMd5());
                            }
                        }
                        i2 = 1;
                        arrayList.add(new l(emojiInfo, i2, i3 + 1));
                        i3 = i4;
                    }
                    bVar.a(arrayList, mVar);
                }
            } else {
                Log.i(this.TAG, "searchSuggest: no cache");
                if (bVar != null) {
                    bVar.a(v.SXr, mVar);
                }
            }
            EU(str);
            AppMethodBeat.o(199945);
        } else if (bVar != null) {
            bVar.a(v.SXr, mVar);
            AppMethodBeat.o(199945);
        } else {
            AppMethodBeat.o(199945);
        }
    }

    private void EU(String str) {
        AppMethodBeat.i(199946);
        p.h(str, "desc");
        bj gCJ = bj.gCJ();
        p.g(gCJ, "EmojiStorageMgr.getInstance()");
        c blp = gCJ.gCO().blp(str);
        Log.i(this.TAG, "checkUpdate: " + str + ", " + (blp != null ? Integer.valueOf(blp.field_updateTime) : null));
        if (blp != null) {
            int a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_emoji_suggest_remote_request_interval, 24);
            Log.i(c.TAG, "needUpdate: config ".concat(String.valueOf(a2)));
            if (!(Util.secondsToNow((long) blp.field_updateTime) > 3600 * ((long) a2))) {
                AppMethodBeat.o(199946);
                return;
            }
        }
        cji cji = new cji();
        if (this.gZB) {
            com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(PluginEmoji.class);
            p.g(ah, "MMKernel.plugin(PluginEmoji::class.java)");
            ArrayList<String> amr = ((PluginEmoji) ah).getEmojiMgr().amr(str);
            int a3 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_emoji_suggest_remote_shuffle_size, 20);
            Log.i(this.TAG, "checkUpdate: shuffle " + a3 + ", local " + amr.size());
            int min = Math.min(a3, amr.size());
            for (int i2 = 0; i2 < min; i2++) {
                cji.MoI.add(amr.get(i2));
            }
        }
        dlc dlc = new dlc();
        dlc.KXA = str;
        dlc.MOZ = this.username;
        dlc.SessionId = this.sessionId;
        dlc.Scene = 4;
        dlc.MPa = new com.tencent.mm.bw.b(cji.toByteArray());
        jx jxVar = new jx();
        jxVar.xi(this.sessionId);
        jxVar.sZ(Util.nowMilliSecond());
        d dVar = d.gZA;
        d.pl(40);
        new com.tencent.mm.emoji.b.b(dlc).aYI().g(new a(this, jxVar, str));
        AppMethodBeat.o(199946);
    }

    public static final /* synthetic */ void a(f fVar, dld dld) {
        LinkedList<dkt> linkedList;
        AppMethodBeat.i(199947);
        int a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_emoji_suggest_remote_prefetch, 0);
        boolean isWifi = NetStatusUtil.isWifi(MMApplicationContext.getContext());
        Log.i(fVar.TAG, "checkPrefetch: config: " + a2 + ", isWifi: " + isWifi);
        if (((a2 != 1 || !isWifi) && a2 != 2) || (linkedList = dld.LVc) == null) {
            AppMethodBeat.o(199947);
            return;
        }
        Iterator<T> it = linkedList.iterator();
        while (it.hasNext()) {
            EmojiInfo emojiInfo = new EmojiInfo();
            com.tencent.mm.plugin.emoji.h.b.a(it.next().MOJ, emojiInfo);
            emojiInfo.field_catalog = EmojiInfo.VkQ;
            e eVar = e.gVM;
            e.a(emojiInfo, (i.a) null);
        }
        AppMethodBeat.o(199947);
    }
}
