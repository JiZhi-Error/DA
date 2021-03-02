package com.tencent.mm.plugin.finder.utils.fake;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.live.util.n;
import com.tencent.mm.plugin.finder.live.util.p;
import com.tencent.mm.plugin.finder.live.viewmodel.g;
import com.tencent.mm.plugin.finder.storage.s;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aut;
import com.tencent.mm.protocal.protobuf.auz;
import com.tencent.mm.protocal.protobuf.avn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.j.c;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003\u001d\u001e\u001fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017J\u0018\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0018H\u0002R-\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR-\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR\u0019\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0012\u001a\u00020\u0013XT¢\u0006\u0002\n\u0000¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/finder/utils/fake/FinderLiveGiftMockUtil;", "", "()V", "GIFT_COMMAND", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/utils/fake/GiftType;", "Lcom/tencent/mm/plugin/finder/utils/fake/FinderLiveGiftMockUtil$IGiftFactory;", "Lkotlin/collections/HashMap;", "getGIFT_COMMAND", "()Ljava/util/HashMap;", "GIFT_ID", "Lcom/tencent/mm/plugin/finder/utils/fake/FinderLiveGiftMockUtil$GiftInfo;", "getGIFT_ID", "IS_PRECIOUS", "", "getIS_PRECIOUS", "()[Lcom/tencent/mm/plugin/finder/utils/fake/GiftType;", "[Lcom/tencent/mm/plugin/finder/utils/fake/GiftType;", "TAG", "", "executeBatchMockCommand", "", "commandList", "", "Lcom/tencent/mm/plugin/finder/utils/fake/FinderLiveGiftMockUtil$MockCommand;", "executeSingleMockCommand", FirebaseAnalytics.b.INDEX, "", "command", "GiftInfo", "IGiftFactory", "MockCommand", "plugin-finder_release"})
public final class c {
    private static final e[] waM = {e.CALL666, e.ROCKET, e.ISLAND};
    private static final HashMap<e, b> waN;
    private static final HashMap<e, AbstractC1316c> waO = new HashMap<>();
    public static final c waP = new c();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/finder/utils/fake/FinderLiveGiftMockUtil$IGiftFactory;", "", "create", "Lcom/tencent/mm/plugin/finder/utils/fake/FinderLiveGiftMockUtil$MockCommand;", "count", "", "plugin-finder_release"})
    /* renamed from: com.tencent.mm.plugin.finder.utils.fake.c$c  reason: collision with other inner class name */
    public interface AbstractC1316c {
        d Ma(int i2);
    }

    static {
        AppMethodBeat.i(253846);
        HashMap<e, b> hashMap = new HashMap<>();
        hashMap.put(e.LOVE, new b("MMFinderLiveGift100001", "test_爱心"));
        hashMap.put(e.CLAP, new b("MMFinderLiveGift100002", "test_鼓掌"));
        hashMap.put(e.FLOWER, new b("MMFinderLiveGift100003", "test_小花"));
        hashMap.put(e.HEYTEA, new b("MMFinderLiveGift100004", "test_奶茶"));
        hashMap.put(e.CALL666, new b("MMFinderLiveGift100005", "test_打call"));
        hashMap.put(e.ROCKET, new b("MMFinderLiveGift100006", "test_火箭"));
        hashMap.put(e.ISLAND, new b("MMFinderLiveGift100007", "test_桃花岛"));
        waN = hashMap;
        for (Map.Entry<e, b> entry : waN.entrySet()) {
            waO.put(entry.getKey(), new a(entry));
        }
        AppMethodBeat.o(253846);
    }

    private c() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/finder/utils/fake/FinderLiveGiftMockUtil$GiftInfo;", "", "giftId", "", "name", "(Ljava/lang/String;Ljava/lang/String;)V", "getGiftId", "()Ljava/lang/String;", "getName", "component1", "component2", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "toString", "plugin-finder_release"})
    public static final class b {
        final String name;
        final String upZ;

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0020, code lost:
            if (kotlin.g.b.p.j(r3.name, r4.name) != false) goto L_0x0022;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 253838(0x3df8e, float:3.55703E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x0022
                boolean r0 = r4 instanceof com.tencent.mm.plugin.finder.utils.fake.c.b
                if (r0 == 0) goto L_0x0027
                com.tencent.mm.plugin.finder.utils.fake.c$b r4 = (com.tencent.mm.plugin.finder.utils.fake.c.b) r4
                java.lang.String r0 = r3.upZ
                java.lang.String r1 = r4.upZ
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0027
                java.lang.String r0 = r3.name
                java.lang.String r1 = r4.name
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0027
            L_0x0022:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            L_0x0026:
                return r0
            L_0x0027:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x0026
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.utils.fake.c.b.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            int i2 = 0;
            AppMethodBeat.i(253837);
            String str = this.upZ;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.name;
            if (str2 != null) {
                i2 = str2.hashCode();
            }
            int i3 = hashCode + i2;
            AppMethodBeat.o(253837);
            return i3;
        }

        public final String toString() {
            AppMethodBeat.i(253836);
            String str = "GiftInfo(giftId=" + this.upZ + ", name=" + this.name + ")";
            AppMethodBeat.o(253836);
            return str;
        }

        public b(String str, String str2) {
            p.h(str, "giftId");
            p.h(str2, "name");
            AppMethodBeat.i(253835);
            this.upZ = str;
            this.name = str2;
            AppMethodBeat.o(253835);
        }
    }

    public static e[] dEI() {
        return waM;
    }

    public static HashMap<e, b> dEJ() {
        return waN;
    }

    public static HashMap<e, AbstractC1316c> dEK() {
        return waO;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/utils/fake/FinderLiveGiftMockUtil$1$1", "Lcom/tencent/mm/plugin/finder/utils/fake/FinderLiveGiftMockUtil$IGiftFactory;", "create", "Lcom/tencent/mm/plugin/finder/utils/fake/FinderLiveGiftMockUtil$MockCommand;", "count", "", "plugin-finder_release"})
    public static final class a implements AbstractC1316c {
        final /* synthetic */ Map.Entry waQ;

        a(Map.Entry entry) {
            this.waQ = entry;
        }

        @Override // com.tencent.mm.plugin.finder.utils.fake.c.AbstractC1316c
        public final d Ma(int i2) {
            AppMethodBeat.i(253834);
            d dVar = new d(i2);
            String str = ((b) this.waQ.getValue()).name;
            p.h(str, "_nickName");
            dVar.nickname = str;
            e eVar = (e) this.waQ.getKey();
            p.h(eVar, "<set-?>");
            dVar.waR = eVar;
            AppMethodBeat.o(253834);
            return dVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0017J\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\tJ\u0006\u0010!\u001a\u00020\tJ\u000e\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\u0017J\u0006\u0010$\u001a\u00020\u0000J\u0010\u0010\u001a\u001a\u00020\u00002\b\u0010%\u001a\u0004\u0018\u00010\u0017J\b\u0010&\u001a\u00020\u0017H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, hxF = {"Lcom/tencent/mm/plugin/finder/utils/fake/FinderLiveGiftMockUtil$MockCommand;", "", "count", "", "(I)V", "getCount", "()I", "setCount", "executeDelayMs", "", "executeInMainThread", "", "getExecuteInMainThread", "()Z", "setExecuteInMainThread", "(Z)V", "gift", "Lcom/tencent/mm/plugin/finder/utils/fake/GiftType;", "getGift", "()Lcom/tencent/mm/plugin/finder/utils/fake/GiftType;", "setGift", "(Lcom/tencent/mm/plugin/finder/utils/fake/GiftType;)V", "giftComboId", "", "isSelfSend", "nickname", "targetUsername", "build", "Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftShowInfo;", "comboId", "_comboId", "delay", "_executeDelayMs", "getDelayTime", "name", "_nickName", "self", "_targetUsername", "toString", "plugin-finder_release"})
    public static final class d {
        private int count;
        String nickname;
        private String tvp;
        private boolean upQ;
        e waR;
        private String waS;
        boolean waT;
        long waU;

        private /* synthetic */ d() {
            this(1);
        }

        public d(int i2) {
            this.count = i2;
            this.waR = e.LOVE;
            this.waS = "";
            this.tvp = "";
        }

        public final d dEL() {
            AppMethodBeat.i(253839);
            this.upQ = true;
            this.nickname = z.aUa();
            AppMethodBeat.o(253839);
            return this;
        }

        public final d awF(String str) {
            AppMethodBeat.i(253840);
            p.h(str, "_comboId");
            this.waS = str;
            AppMethodBeat.o(253840);
            return this;
        }

        public final d byd(String str) {
            if (str == null) {
                str = "";
            }
            this.tvp = str;
            return this;
        }

        public final p.b dEM() {
            String str;
            String str2;
            p.c cVar;
            FinderContact finderContact;
            String str3;
            String str4 = null;
            AppMethodBeat.i(253841);
            auz auz = new auz();
            p.c cVar2 = p.c.NORMAL_GIFT_SOLO;
            if (Util.isNullOrNil(this.waS)) {
                StringBuilder sb = new StringBuilder();
                c cVar3 = c.waP;
                b bVar = c.dEJ().get(this.waR);
                if (bVar != null) {
                    str3 = bVar.name;
                } else {
                    str3 = null;
                }
                str = sb.append(str3).append('_').append(UUID.randomUUID()).toString();
            } else {
                str = this.waS;
            }
            aut aut = new aut();
            aut.LFE = new avn();
            avn avn = aut.LFE;
            if (avn != null) {
                avn.contact = new FinderContact();
            }
            avn avn2 = aut.LFE;
            if (!(avn2 == null || (finderContact = avn2.contact) == null)) {
                String str5 = this.nickname;
                if (str5 == null) {
                    StringBuilder sb2 = new StringBuilder("测试");
                    c.b bVar2 = kotlin.j.c.SYP;
                    str5 = sb2.append(kotlin.j.c.SYN.nextInt()).toString();
                }
                finderContact.nickname = str5;
            }
            c cVar4 = c.waP;
            b bVar3 = c.dEJ().get(this.waR);
            if (bVar3 != null) {
                str2 = bVar3.upZ;
            } else {
                str2 = null;
            }
            auz.LFM = str2;
            p.b bVar4 = new p.b(aut);
            bVar4.c(cVar2);
            kotlin.g.b.p.h(auz, "<set-?>");
            bVar4.uwU = auz;
            bVar4.upR = str;
            bVar4.upS = 0;
            bVar4.uwV = this.count;
            c cVar5 = c.waP;
            bVar4.uwW = kotlin.a.e.contains(c.dEI(), this.waR);
            bVar4.upQ = this.upQ;
            c cVar6 = c.waP;
            b bVar5 = c.dEJ().get(this.waR);
            if (bVar5 != null) {
                str4 = bVar5.upZ;
            }
            bVar4.upZ = str4;
            bVar4.bxH(this.tvp);
            boolean z = !Util.isNullOrNil(str) && (bVar4.upS > 1 || bVar4.uwV > 1);
            if (this.upQ) {
                if (bVar4.uwW) {
                    if (z) {
                        cVar = p.c.SELF_PRECIOUS_GIFT_COMBO;
                    } else {
                        cVar = p.c.SELF_PRECIOUS_GIFT_SOLO;
                    }
                } else if (z) {
                    cVar = p.c.SELF_NORMAL_GIFT_COMBO;
                } else {
                    cVar = p.c.SELF_NORMAL_GIFT_SOLO;
                }
            } else if (bVar4.uwW) {
                if (z) {
                    cVar = p.c.PRECIOUS_GIFT_COMBO;
                } else {
                    cVar = p.c.PRECIOUS_GIFT_SOLO;
                }
            } else if (z) {
                cVar = p.c.NORMAL_GIFT_COMBO;
            } else {
                cVar = p.c.NORMAL_GIFT_SOLO;
            }
            bVar4.c(cVar);
            AppMethodBeat.o(253841);
            return bVar4;
        }

        public final String toString() {
            String str;
            String str2 = null;
            AppMethodBeat.i(253842);
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder("giftName = ");
            com.tencent.mm.plugin.finder.live.model.e eVar = com.tencent.mm.plugin.finder.live.model.e.uiD;
            Map<String, s> dfw = com.tencent.mm.plugin.finder.live.model.e.dfw();
            c cVar = c.waP;
            b bVar = c.dEJ().get(this.waR);
            if (bVar != null) {
                str = bVar.upZ;
            } else {
                str = null;
            }
            s sVar = dfw.get(str);
            StringBuilder append = sb.append(sb2.append(sVar != null ? sVar.field_name : null).toString()).append(", ").append("comboId = " + this.waS).append(", ").append("count = " + this.count).append(", ").append("executeInMainThread = " + this.waT).append(", ").append("nickname = " + this.nickname + " ,").append("isSelfSend = " + this.upQ + " ,");
            StringBuilder sb3 = new StringBuilder("giftLocalName = ");
            c cVar2 = c.waP;
            b bVar2 = c.dEJ().get(this.waR);
            if (bVar2 != null) {
                str2 = bVar2.name;
            }
            String sb4 = append.append(sb3.append(str2).append(", ").toString()).append("executeDelayMs = " + this.waU).append(", ").append("targetUserName = " + this.tvp).append("\n").toString();
            kotlin.g.b.p.g(sb4, "StringBuilder()\n        …              .toString()");
            AppMethodBeat.o(253842);
            return sb4;
        }
    }

    public static void eD(List<d> list) {
        AppMethodBeat.i(253845);
        kotlin.g.b.p.h(list, "commandList");
        Log.i("Finder.FinderLiveGiftMockUtil", "executeBatchMockCommand: ".concat(String.valueOf(list)));
        int i2 = 0;
        for (T t : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                j.hxH();
            }
            T t2 = t;
            if (t2.waT) {
                com.tencent.mm.ac.d.a(t2.waU, new e(t2));
                i2 = i3;
            } else {
                String str = "FinderLiveGiftMockUtil" + (i2 % 4);
                f fVar = new f(t2);
                long j2 = t2.waU;
                kotlin.g.b.p.h(str, "tag");
                kotlin.g.b.p.h(fVar, "block");
                h.RTc.a(new d.f(str, fVar), j2, str);
                i2 = i3;
            }
        }
        AppMethodBeat.o(253845);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class e extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ d waV;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(d dVar) {
            super(0);
            this.waV = dVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            n nVar;
            n nVar2;
            AppMethodBeat.i(253843);
            StringBuilder sb = new StringBuilder("executeSingleMockCommand ui ");
            o oVar = o.ujN;
            g dfZ = o.dfZ();
            if (dfZ != null) {
                nVar = dfZ.uDw;
            } else {
                nVar = null;
            }
            Log.i("Finder.FinderLiveGiftMockUtil", sb.append(nVar).toString());
            o oVar2 = o.ujN;
            g dfZ2 = o.dfZ();
            if (!(dfZ2 == null || (nVar2 = dfZ2.uDw) == null)) {
                nVar2.a(this.waV.dEM());
            }
            x xVar = x.SXb;
            AppMethodBeat.o(253843);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class f extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ d waV;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(d dVar) {
            super(0);
            this.waV = dVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            n nVar;
            n nVar2;
            AppMethodBeat.i(253844);
            StringBuilder sb = new StringBuilder("executeSingleMockCommand thread ");
            o oVar = o.ujN;
            g dfZ = o.dfZ();
            if (dfZ != null) {
                nVar = dfZ.uDw;
            } else {
                nVar = null;
            }
            Log.i("Finder.FinderLiveGiftMockUtil", sb.append(nVar).toString());
            o oVar2 = o.ujN;
            g dfZ2 = o.dfZ();
            if (!(dfZ2 == null || (nVar2 = dfZ2.uDw) == null)) {
                nVar2.a(this.waV.dEM());
            }
            x xVar = x.SXb;
            AppMethodBeat.o(253844);
            return xVar;
        }
    }
}
