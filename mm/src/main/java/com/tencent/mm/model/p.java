package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.webview.core.g;
import com.tencent.mm.protocal.protobuf.bub;
import com.tencent.mm.protocal.protobuf.dkr;
import com.tencent.mm.protocal.protobuf.dku;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.z;
import com.tencent.thumbplayer.core.thirdparties.LocalCache;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Result;
import kotlin.f;
import kotlin.g;
import kotlin.k.j;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u0000 \u00032\u00020\u0001:\u0003\u0003\u0004\u0005B\u0005¢\u0006\u0002\u0010\u0002\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/model/BizTLRecFeedsDataUtil;", "", "()V", "Companion", "EnRecommendFeedsInfoSwitchOption", "GetRecommendFeedScene", "plugin-biz_release"})
public final class p {
    private static final f iBW = g.ah(b.iCd);
    private static List<z> iBX = new LinkedList();
    private static final AtomicLong iBY = new AtomicLong(0);
    private static final String iBZ;
    public static final a iCa = new a((byte) 0);

    public static final int aTH() {
        AppMethodBeat.i(212400);
        int aTH = a.aTH();
        AppMethodBeat.o(212400);
        return aTH;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, hxF = {"Lcom/tencent/mm/model/BizTLRecFeedsDataUtil$GetRecommendFeedScene;", "", "scene", "", "(Ljava/lang/String;II)V", "getScene", "()I", "GET_RECOMMEND_FEEDS_SCENE_PRELOAD", "GET_RECOMMEND_FEEDS_SCENE_ENTER", "GET_RECOMMEND_FEEDS_SCENE_LOAD_MORE", "plugin-biz_release"})
    public enum d {
        GET_RECOMMEND_FEEDS_SCENE_PRELOAD(1),
        GET_RECOMMEND_FEEDS_SCENE_ENTER(2),
        GET_RECOMMEND_FEEDS_SCENE_LOAD_MORE(3);
        
        final int scene;

        public static d valueOf(String str) {
            AppMethodBeat.i(212397);
            d dVar = (d) Enum.valueOf(d.class, str);
            AppMethodBeat.o(212397);
            return dVar;
        }

        private d(int i2) {
            this.scene = i2;
        }

        static {
            AppMethodBeat.i(212395);
            AppMethodBeat.o(212395);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, hxF = {"Lcom/tencent/mm/model/BizTLRecFeedsDataUtil$EnRecommendFeedsInfoSwitchOption;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "RECOMMEND_FEEDS_UNDEFINED", "RECOMMEND_FEEDS_CLOSE", "RECOMMEND_FEEDS_OPEN", "plugin-biz_release"})
    public enum c {
        RECOMMEND_FEEDS_UNDEFINED(0),
        RECOMMEND_FEEDS_CLOSE(1),
        RECOMMEND_FEEDS_OPEN(2);
        
        public final int value;

        public static c valueOf(String str) {
            AppMethodBeat.i(212394);
            c cVar = (c) Enum.valueOf(c.class, str);
            AppMethodBeat.o(212394);
            return cVar;
        }

        private c(int i2) {
            this.value = i2;
        }

        static {
            AppMethodBeat.i(212392);
            AppMethodBeat.o(212392);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017J\b\u0010\"\u001a\u0004\u0018\u00010#J\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017J\b\u0010%\u001a\u00020\u0004H\u0007J\u001b\u0010&\u001a\u0004\u0018\u00010#2\u0006\u0010'\u001a\u00020(H@ø\u0001\u0000¢\u0006\u0002\u0010)J\b\u0010*\u001a\u0004\u0018\u00010\u0007J\b\u0010+\u001a\u00020\u0004H\u0007J\b\u0010,\u001a\u00020\u001eH\u0007J\u000e\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0018J\u001c\u00100\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00182\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u000702J\u000e\u00103\u001a\u00020.2\u0006\u00104\u001a\u00020#J\u0014\u00105\u001a\u00020.2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017J\u0010\u00106\u001a\u00020.2\b\u00107\u001a\u0004\u0018\u000108J\n\u00109\u001a\u00020\u0007*\u00020:R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR#\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\f8FX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u0002\u0004\n\u0002\b\u0019¨\u0006;"}, hxF = {"Lcom/tencent/mm/model/BizTLRecFeedsDataUtil$Companion;", "", "()V", "DEFAULT_PRELOAD_INTERVAL", "", "DEFAULT_PROTECTION_TIME", "TAG", "", "firstScreenDataKey", "getFirstScreenDataKey", "()Ljava/lang/String;", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "Lkotlin/Lazy;", "orderFlag", "Ljava/util/concurrent/atomic/AtomicLong;", "getOrderFlag", "()Ljava/util/concurrent/atomic/AtomicLong;", "recList", "", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "getRecList", "()Ljava/util/List;", "setRecList", "(Ljava/util/List;)V", "filterRecommendFeed", "", "feed", "Lcom/tencent/mm/protocal/protobuf/RecommendCardMsg;", "list", "getFirstScreen", "Lcom/tencent/mm/protocal/protobuf/GetRecommendFeedsResp;", "getLastSaveRecList", "getProtectionTime", "getRecommendFeeds", "getRecFeedScene", "Lcom/tencent/mm/model/BizTLRecFeedsDataUtil$GetRecommendFeedScene;", "(Lcom/tencent/mm/model/BizTLRecFeedsDataUtil$GetRecommendFeedScene;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRecommendFeedsWording", "getSubscribeMsgLimit", "isRecFeedSvrOpen", "onRemove", "", "info", "recommendCardFeedback", "negativeFeedbackReason", "Ljava/util/LinkedList;", "saveFirstScreen", "resp", "saveLastRecList", "updateSvrSwitch", "recommendFeedsInfo", "Lcom/tencent/mm/protocal/protobuf/RecommendFeedsInfo;", "getString", "Lcom/tencent/mm/protocal/protobuf/RecommendFeedsConfig;", "plugin-biz_release"})
    public static final class a {
        public static MultiProcessMMKV aTI() {
            AppMethodBeat.i(212385);
            f fVar = p.iBW;
            a aVar = p.iCa;
            MultiProcessMMKV multiProcessMMKV = (MultiProcessMMKV) fVar.getValue();
            AppMethodBeat.o(212385);
            return multiProcessMMKV;
        }

        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x00be  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static java.lang.Object a(com.tencent.mm.model.p.d r11, kotlin.d.d<? super com.tencent.mm.protocal.protobuf.bub> r12) {
            /*
            // Method dump skipped, instructions count: 224
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.model.p.a.a(com.tencent.mm.model.p$d, kotlin.d.d):java.lang.Object");
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\n¢\u0006\u0002\b\n¨\u0006\u000b"}, hxF = {"<anonymous>", "", "errType", "errCode", "<anonymous parameter 2>", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "<anonymous parameter 4>", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback", "com/tencent/mm/model/BizTLRecFeedsDataUtil$Companion$getRecommendFeeds$2$1"})
        /* renamed from: com.tencent.mm.model.p$a$a  reason: collision with other inner class name */
        static final class C0448a implements aa.a {
            final /* synthetic */ kotlin.d.d iCb;
            final /* synthetic */ d iCc;

            C0448a(kotlin.d.d dVar, d dVar2) {
                this.iCb = dVar;
                this.iCc = dVar2;
            }

            @Override // com.tencent.mm.ak.aa.a
            public final int a(int i2, int i3, String str, com.tencent.mm.ak.d dVar, q qVar) {
                Integer num;
                int i4;
                int i5;
                MultiProcessMMKV singleMMKV;
                LinkedList<dkr> linkedList;
                String str2 = null;
                AppMethodBeat.i(212380);
                kotlin.g.b.p.h(dVar, "rr");
                kotlin.g.b.p.h(qVar, "<anonymous parameter 4>");
                Log.i("Micromsg.BizTLRecFeedsDataUtil", "getRecommendFeeds callback " + i2 + ", " + i3);
                if (i2 == 0 && i3 == 0) {
                    o oVar = o.iBV;
                    o.Aa(2);
                    com.tencent.mm.bw.a aYK = dVar.aYK();
                    if (!(aYK instanceof bub)) {
                        aYK = null;
                    }
                    bub bub = (bub) aYK;
                    if (bub == null) {
                        AppMethodBeat.o(212380);
                    } else {
                        g.a aVar = com.tencent.mm.plugin.webview.core.g.ILB;
                        if (g.a.KB() && (singleMMKV = MultiProcessMMKV.getSingleMMKV("brandService")) != null && singleMMKV.decodeInt("BizTimeLineRecFeedStatus", 1) == 0 && (linkedList = bub.MaI) != null) {
                            linkedList.clear();
                        }
                        StringBuilder sb = new StringBuilder("getRecommendFeeds card size=");
                        LinkedList<dkr> linkedList2 = bub.MaI;
                        if (linkedList2 != null) {
                            num = Integer.valueOf(linkedList2.size());
                        } else {
                            num = null;
                        }
                        StringBuilder append = sb.append(num).append(' ');
                        dku dku = bub.MaJ;
                        if (dku != null) {
                            a aVar2 = p.iCa;
                            kotlin.g.b.p.h(dku, "$this$getString");
                            str2 = "NextReqTime=" + dku.MON + " ProtectionTime=" + dku.MOO + " SubscribeMsgLimit=" + dku.MOP;
                        }
                        Log.i("Micromsg.BizTLRecFeedsDataUtil", append.append(str2).toString());
                        if (bub.Buffer != null && bub.Buffer.zy.length > 0) {
                            a aVar3 = p.iCa;
                            a.aTI().encode("GetRecommendFeedsBuffer", bub.Buffer.toByteArray());
                        }
                        if (d.GET_RECOMMEND_FEEDS_SCENE_ENTER.scene == this.iCc.scene) {
                            a aVar4 = p.iCa;
                            a.aTI().encode("RecommendFeedsWording", bub.MaK);
                            a aVar5 = p.iCa;
                            MultiProcessMMKV aTI = a.aTI();
                            dku dku2 = bub.MaJ;
                            aTI.encode("NextReqTime", dku2 != null ? dku2.MON : 600);
                            a aVar6 = p.iCa;
                            MultiProcessMMKV aTI2 = a.aTI();
                            dku dku3 = bub.MaJ;
                            if (dku3 != null) {
                                i4 = dku3.MOO;
                            } else {
                                i4 = 1800;
                            }
                            aTI2.encode("ProtectionTime", i4);
                            a aVar7 = p.iCa;
                            MultiProcessMMKV aTI3 = a.aTI();
                            dku dku4 = bub.MaJ;
                            if (dku4 != null) {
                                i5 = dku4.MOP;
                            } else {
                                i5 = 0;
                            }
                            aTI3.encode("SubscribeMsgLimit", i5);
                        }
                        kotlin.d.d dVar2 = this.iCb;
                        Result.Companion companion = Result.Companion;
                        dVar2.resumeWith(Result.m46constructorimpl(bub));
                        AppMethodBeat.o(212380);
                    }
                } else {
                    o oVar2 = o.iBV;
                    o.Aa(3);
                    kotlin.d.d dVar3 = this.iCb;
                    Result.Companion companion2 = Result.Companion;
                    dVar3.resumeWith(Result.m46constructorimpl(null));
                    AppMethodBeat.o(212380);
                }
                return 0;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\n¢\u0006\u0002\b\n"}, hxF = {"<anonymous>", "", "errType", "errCode", "<anonymous parameter 2>", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "<anonymous parameter 4>", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
        public static final class b implements aa.a {
            public static final b iCe = new b();

            static {
                AppMethodBeat.i(212384);
                AppMethodBeat.o(212384);
            }

            b() {
            }

            @Override // com.tencent.mm.ak.aa.a
            public final int a(int i2, int i3, String str, com.tencent.mm.ak.d dVar, q qVar) {
                AppMethodBeat.i(212383);
                kotlin.g.b.p.h(dVar, "rr");
                kotlin.g.b.p.h(qVar, "<anonymous parameter 4>");
                Log.i("Micromsg.BizTLRecFeedsDataUtil", "recommendCardFeedback callback " + i2 + ", " + i3);
                if (i2 == 0 && i3 == 0) {
                    AppMethodBeat.o(212383);
                } else {
                    AppMethodBeat.o(212383);
                }
                return 0;
            }
        }

        public static boolean a(dkr dkr, List<z> list) {
            AppMethodBeat.i(212387);
            kotlin.g.b.p.h(dkr, "feed");
            kotlin.g.b.p.h(list, "list");
            if (!af.b(dkr)) {
                AppMethodBeat.o(212387);
                return false;
            }
            for (T t : list) {
                if (t.NQr != null && kotlin.g.b.p.j(dkr.KUk, t.NQr.KUk)) {
                    o oVar = o.iBV;
                    o.Aa(4);
                    Log.i("Micromsg.BizTLRecFeedsDataUtil", "filterRecommendFeed cardId repeat " + dkr.KUk);
                    AppMethodBeat.o(212387);
                    return false;
                }
            }
            AppMethodBeat.o(212387);
            return true;
        }

        public static void a(bub bub) {
            AppMethodBeat.i(212388);
            kotlin.g.b.p.h(bub, "resp");
            try {
                aTI().encode(p.iBZ, bub.toByteArray());
                AppMethodBeat.o(212388);
            } catch (Exception e2) {
                Log.printErrStackTrace("Micromsg.BizTLRecFeedsDataUtil", e2, "saveFirstScreen", new Object[0]);
                AppMethodBeat.o(212388);
            }
        }

        public static bub aTJ() {
            Object obj;
            byte[] decodeBytes;
            boolean z = true;
            AppMethodBeat.i(212389);
            MultiProcessMMKV aTI = aTI();
            kotlin.g.b.p.g(aTI, "mmkv");
            String str = p.iBZ;
            if (aTI.containsKey(str) && (decodeBytes = aTI.decodeBytes(str)) != null) {
                if (decodeBytes.length == 0) {
                    z = false;
                }
                if (z) {
                    try {
                        Object newInstance = bub.class.newInstance();
                        ((com.tencent.mm.bw.a) newInstance).parseFrom(decodeBytes);
                        obj = (com.tencent.mm.bw.a) newInstance;
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", e2, "decode ProtoBuffer", new Object[0]);
                    }
                    bub bub = (bub) obj;
                    AppMethodBeat.o(212389);
                    return bub;
                }
            }
            obj = null;
            bub bub2 = (bub) obj;
            AppMethodBeat.o(212389);
            return bub2;
        }

        public static int aTH() {
            AppMethodBeat.i(212390);
            int decodeInt = aTI().decodeInt("SubscribeMsgLimit", 0);
            Log.i("Micromsg.BizTLRecFeedsDataUtil", "subscribeMsgLimit = ".concat(String.valueOf(decodeInt)));
            if (decodeInt <= 0) {
                AppMethodBeat.o(212390);
                return 2000;
            }
            AppMethodBeat.o(212390);
            return decodeInt;
        }

        public static boolean aTK() {
            AppMethodBeat.i(212391);
            boolean decodeBool = aTI().decodeBool("BizTLRecommendFeedsSvrOpen", false);
            Log.i("Micromsg.BizTLRecFeedsDataUtil", "BizTLRecommendFeedsSvrOpen = ".concat(String.valueOf(decodeBool)));
            AppMethodBeat.o(212391);
            return decodeBool;
        }
    }

    static {
        AppMethodBeat.i(212398);
        StringBuilder sb = new StringBuilder("FirstScreenData:");
        kotlin.g.b.p.g(com.tencent.mm.kernel.g.aAf(), "MMKernel.account()");
        iBZ = sb.append(com.tencent.mm.kernel.a.ayV()).toString();
        AppMethodBeat.o(212398);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "invoke"})
    static final class b extends kotlin.g.b.q implements kotlin.g.a.a<MultiProcessMMKV> {
        public static final b iCd = new b();

        static {
            AppMethodBeat.i(212382);
            AppMethodBeat.o(212382);
        }

        b() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ MultiProcessMMKV invoke() {
            AppMethodBeat.i(212381);
            MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("BizTimeLineRecFeeds");
            AppMethodBeat.o(212381);
            return mmkv;
        }
    }

    public static final int aTG() {
        AppMethodBeat.i(212399);
        int na = j.na(j.mZ(a.aTI().decodeInt("ProtectionTime", 1800), ab.gBc()), LocalCache.TIME_DAY);
        Log.i("Micromsg.BizTLRecFeedsDataUtil", "protectionTime = ".concat(String.valueOf(na)));
        AppMethodBeat.o(212399);
        return na;
    }
}
