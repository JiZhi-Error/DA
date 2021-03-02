package com.tencent.mm.plugin.finder.newxml;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.f;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.protocal.protobuf.bbi;
import com.tencent.mm.protocal.protobuf.bbj;
import com.tencent.mm.protocal.protobuf.bdo;
import com.tencent.mm.protocal.protobuf.fhk;
import com.tencent.mm.protocal.protobuf.fhn;
import com.tencent.mm.protocal.protobuf.fhp;
import com.tencent.mm.protocal.protobuf.fht;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import kotlin.g.b.q;
import kotlin.k.j;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\b2\u0006\u0010\t\u001a\u00020\nH\u0016J$\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\bH\u0002J\u001c\u0010\u000f\u001a\u00020\f2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\bH\u0002J\u001c\u0010\u0010\u001a\u00020\f2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\bH\u0002J(\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0012j\b\u0012\u0004\u0012\u00020\u0006`\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u001c\u0010\u0018\u001a\u00020\u00152\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\bH\u0002¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/finder/newxml/FinderPromotionConsumer;", "Lcom/tencent/mm/plugin/messenger/foundation/api/INewXmlConsumer;", "()V", "consumeNewXml", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgReturn;", "subType", "", "values", "", "p2", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;", "dealWithPromotion", "", "msgType", "", "dealWithRedPackFinder", "dealWithRedPackWx", "getRedDotTitleFinder", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "promotion", "Lcom/tencent/mm/protocal/protobuf/FinderPromotionMsg;", "posArray", "", "transXmlToFinderPromotionMsg", "Companion", "plugin-finder_release"})
public final class b implements p {
    public static final a USx = new a((byte) 0);

    static {
        AppMethodBeat.i(261258);
        AppMethodBeat.o(261258);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"getWordingAcLocale", "", "wording", "Lcom/tencent/mm/protocal/protobuf/Wording;", "invoke"})
    /* renamed from: com.tencent.mm.plugin.finder.newxml.b$b  reason: collision with other inner class name */
    public static final class C1252b extends q implements kotlin.g.a.b<fht, String> {
        final /* synthetic */ b USy;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1252b(b bVar) {
            super(1);
            this.USy = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ String invoke(fht fht) {
            AppMethodBeat.i(261253);
            String a2 = a(fht);
            AppMethodBeat.o(261253);
            return a2;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0016, code lost:
            if (r0 != null) goto L_0x001b;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static java.lang.String a(com.tencent.mm.protocal.protobuf.fht r2) {
            /*
                r1 = 261254(0x3fc86, float:3.66095E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r1)
                if (r2 == 0) goto L_0x0018
                boolean r0 = com.tencent.mm.sdk.platformtools.LocaleUtil.isSimplifiedChineseAppLang()
                if (r0 != 0) goto L_0x0028
                boolean r0 = com.tencent.mm.sdk.platformtools.LocaleUtil.isTraditionalChineseAppLang()
                if (r0 == 0) goto L_0x001f
                java.lang.String r0 = r2.Vkm
            L_0x0016:
                if (r0 != 0) goto L_0x001b
            L_0x0018:
                java.lang.String r0 = ""
            L_0x001b:
                com.tencent.matrix.trace.core.AppMethodBeat.o(r1)
                return r0
            L_0x001f:
                boolean r0 = com.tencent.mm.sdk.platformtools.LocaleUtil.isChineseAppLang()
                if (r0 != 0) goto L_0x0028
                java.lang.String r0 = r2.KIt
                goto L_0x0016
            L_0x0028:
                java.lang.String r0 = r2.Vkl
                goto L_0x0016
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.newxml.b.C1252b.a(com.tencent.mm.protocal.protobuf.fht):java.lang.String");
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/newxml/FinderPromotionConsumer$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.p
    public final h.b a(String str, Map<String, String> map, h.a aVar) {
        AppMethodBeat.i(261255);
        kotlin.g.b.p.h(map, "values");
        kotlin.g.b.p.h(aVar, "p2");
        if (kotlin.g.b.p.j(str, "FinderPromotion")) {
            Log.i("Finder.FinderPromotionConsumer", "[FinderPromotionConsumer]");
            switch (Util.safeParseInt(map.get(".sysmsg.msg.msg_type"))) {
                case 1:
                    int safeParseInt = Util.safeParseInt(map.get(".sysmsg.msg.msg_action"));
                    Log.i("Finder.FinderPromotionConsumer", "[dealWithRedPackFinder] msgAction:".concat(String.valueOf(safeParseInt)));
                    switch (safeParseInt) {
                        case 1:
                            fhk cD = cD(map);
                            ArrayList<String> a2 = a(cD, new int[]{2, 3});
                            f redDotManager = ((PluginFinder) g.ah(PluginFinder.class)).getRedDotManager();
                            bbi bbi = new bbi();
                            bbi.LKM = String.valueOf(cl.aWA());
                            bbi.priority = 0;
                            bbi.type = HardCoderJNI.FUNC_REG_SYSTEM_EVENT_CALLBACK;
                            bbj bbj = new bbj();
                            bbj.LXl = 1;
                            fhn fhn = cD.VjB;
                            bbj.VjF = new com.tencent.mm.bw.b(fhn != null ? fhn.toByteArray() : null);
                            bbi.LKL = new com.tencent.mm.bw.b(bbj.toByteArray());
                            bbi.MQX = cD.MQX;
                            bbi.pRN = j.mZ(cD.pSb - cl.aWB(), 0);
                            bdo bdo = new bdo();
                            bdo.xGz = 3;
                            String str2 = (String) kotlin.a.j.L(a2, 0);
                            if (str2 == null) {
                                str2 = "";
                            }
                            bdo.title = str2;
                            bdo.LNm = 1;
                            bdo.path = "ProfileEntrance";
                            bbi.GaM.add(bdo);
                            bdo bdo2 = new bdo();
                            bdo2.xGz = 20;
                            String str3 = (String) kotlin.a.j.L(a2, 1);
                            if (str3 == null) {
                                str3 = "";
                            }
                            bdo2.title = str3;
                            bdo2.LNm = 1;
                            bdo2.path = "FinderProfileBanner";
                            bdo2.Bvg = "ProfileEntrance";
                            bbi.GaM.add(bdo2);
                            f.a(redDotManager, bbi, "checkFinderRedPackRedDot", null, true, null, 20);
                            Log.i("Finder.FinderPromotionConsumer", "[dealWithRedPackFinder] starttime" + bbi.MQX + ", endtime" + cD.pSb + ", title1:" + bdo.title + " ,title2:" + bdo2.title + ", expire_time" + bbi.pRN);
                            break;
                        case 2:
                            ((PluginFinder) g.ah(PluginFinder.class)).getRedDotManager().Iy(HardCoderJNI.FUNC_REG_SYSTEM_EVENT_CALLBACK);
                            break;
                    }
                case 2:
                    int safeParseInt2 = Util.safeParseInt(map.get(".sysmsg.msg.msg_action"));
                    Log.i("Finder.FinderPromotionConsumer", "[dealWithRedPackWx] msgAction:".concat(String.valueOf(safeParseInt2)));
                    switch (safeParseInt2) {
                        case 1:
                            fhk cD2 = cD(map);
                            ArrayList<String> a3 = a(cD2, new int[]{1});
                            f redDotManager2 = ((PluginFinder) g.ah(PluginFinder.class)).getRedDotManager();
                            bbi bbi2 = new bbi();
                            bbi2.LKM = String.valueOf(cl.aWA());
                            bbi2.priority = cD2.priority;
                            bbi2.type = HardCoderJNI.FUNC_GPU_HIGH_FREQ;
                            bbj bbj2 = new bbj();
                            bbj2.LXl = 1;
                            fhn fhn2 = cD2.VjB;
                            bbj2.VjF = new com.tencent.mm.bw.b(fhn2 != null ? fhn2.toByteArray() : null);
                            bbi2.LKL = new com.tencent.mm.bw.b(bbj2.toByteArray());
                            bbi2.MQX = cD2.MQX;
                            bbi2.pRN = j.mZ(cD2.pSb - cl.aWB(), 0);
                            bdo bdo3 = new bdo();
                            bdo3.xGz = 20;
                            String str4 = (String) kotlin.a.j.L(a3, 0);
                            if (str4 == null) {
                                str4 = "";
                            }
                            bdo3.title = str4;
                            bdo3.LNm = 1;
                            bdo3.path = "CreateFinderEntrance";
                            bbi2.GaM.add(bdo3);
                            f.a(redDotManager2, bbi2, "checkFinderRedPackRedDot", null, true, null, 20);
                            Log.i("Finder.FinderPromotionConsumer", "[dealWithRedPackFinder] starttime" + bbi2.MQX + ", endtime" + cD2.pSb + ", title:" + bdo3.title + ", expire_time" + bbi2.pRN);
                            break;
                        case 2:
                            ((PluginFinder) g.ah(PluginFinder.class)).getRedDotManager().Iy(HardCoderJNI.FUNC_GPU_HIGH_FREQ);
                            break;
                    }
            }
        }
        AppMethodBeat.o(261255);
        return null;
    }

    private static fhk cD(Map<String, String> map) {
        AppMethodBeat.i(261256);
        fhk fhk = new fhk();
        fhk.priority = Util.safeParseInt(map.get(".sysmsg.msg.priority"));
        fhk.Vjz = Util.safeParseInt(map.get(".sysmsg.msg.msg_action"));
        fhk.MQX = Util.safeParseInt(map.get(".sysmsg.msg.start_time"));
        fhk.pSb = Util.safeParseInt(map.get(".sysmsg.msg.end_time"));
        fhk.ybm = Util.safeParseInt(map.get(".sysmsg.msg.msg_type"));
        fhk.VjA = Util.safeParseInt(map.get(".sysmsg.msg.msg_ext"));
        fhn fhn = new fhn();
        fhn.VjW = map.get(".sysmsg.msg.miniapp_msg.miniapp_name");
        fhn.KDW = map.get(".sysmsg.msg.miniapp_msg.miniapp_path");
        fhn.KDY = Util.safeParseInt(map.get(".sysmsg.msg.miniapp_msg.miniapp_scene"));
        fhk.VjB = fhn;
        String str = ".sysmsg.msg.path_info";
        int i2 = 1;
        LinkedList<fhp> linkedList = new LinkedList<>();
        while (map.containsKey(str)) {
            fht fht = new fht();
            fht.Vkl = map.get(str + ".wording.zh_cn");
            fht.Vkm = map.get(str + ".wording.zh_tw");
            fht.KIt = map.get(str + ".wording.en");
            fhp fhp = new fhp();
            fhp.Vki = fht;
            fhp.Vkh = Util.safeParseInt(map.get(str + ".msg_position"));
            linkedList.add(fhp);
            str = str + i2;
            i2++;
        }
        fhk.VjC = linkedList;
        AppMethodBeat.o(261256);
        return fhk;
    }

    private final ArrayList<String> a(fhk fhk, int[] iArr) {
        AppMethodBeat.i(261257);
        HashMap hashMap = new HashMap();
        LinkedList<fhp> linkedList = fhk.VjC;
        kotlin.g.b.p.g(linkedList, "promotion.path_infos");
        for (T t : linkedList) {
            HashMap hashMap2 = hashMap;
            Integer valueOf = Integer.valueOf(t.Vkh);
            fht fht = t.Vki;
            if (fht == null) {
                fht = new fht();
            }
            hashMap2.put(valueOf, fht);
        }
        ArrayList<String> arrayList = new ArrayList<>();
        new C1252b(this);
        for (int i2 : iArr) {
            arrayList.add(C1252b.a((fht) hashMap.get(Integer.valueOf(i2))));
        }
        AppMethodBeat.o(261257);
        return arrayList;
    }
}
