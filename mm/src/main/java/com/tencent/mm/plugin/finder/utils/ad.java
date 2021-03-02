package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;

public final class ad {
    private static final int vYG = 1;
    private static final int vYH = 2;
    private static final ArrayList<c> vYI = new ArrayList<>();
    private static final c vYJ;
    private static final c vYK;
    private static final c vYL;
    private static final c vYM;
    private static final c vYN;
    private static final c vYO;
    private static final c vYP;
    private static final c vYQ;
    private static final c vYR;
    private static final c vYS;
    private static final c vYT;
    private static final c vYU;
    private static final c vYV;
    private static final c vYW;
    private static final c vYX;
    private static final c vYY;
    private static final c vYZ;
    private static final c vZa;
    private static final c vZb;
    private static final c vZc;
    private static final c vZd;
    private static final c vZe;
    private static final c vZf;
    private static final c vZg;
    private static final c vZh;
    private static final c vZi;
    private static final c vZj;
    private static final c vZk;
    private static final c vZl;
    private static final c vZm;
    private static final c vZn;
    private static final c vZo;
    private static final c vZp;
    private static final c vZq;
    private static final c vZr;
    private static final c vZs;
    private static final f<HashMap<String, Integer>> vZt = g.ah(b.vZv);
    public static final a vZu = new a((byte) 0);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(253761);
        c cVar = new c(10, "ViewHolderBegin");
        vYI.add(cVar);
        vYJ = cVar;
        c cVar2 = new c(20, "ViewHolderEnd");
        vYI.add(cVar2);
        vYK = cVar2;
        c cVar3 = new c(30, "ItemSelectedBegin");
        vYI.add(cVar3);
        vYL = cVar3;
        c cVar4 = new c(40, "JoinLiveBegin");
        vYI.add(cVar4);
        vYM = cVar4;
        c cVar5 = new c(50, "ItemSelectedEnd");
        vYI.add(cVar5);
        vYN = cVar5;
        c cVar6 = new c(60, "JoinLiveCgiBack");
        vYI.add(cVar6);
        vYO = cVar6;
        c cVar7 = new c(70, "JoinLiveEnd");
        vYI.add(cVar7);
        vYP = cVar7;
        c cVar8 = new c(80, "StartLive");
        vYI.add(cVar8);
        vYQ = cVar8;
        c cVar9 = new c(90, "JoinLiveFinish");
        vYI.add(cVar9);
        vYR = cVar9;
        c cVar10 = new c(100, "ConnectSucc");
        vYI.add(cVar10);
        vYS = cVar10;
        c cVar11 = new c(110, "FirstFrameEvent");
        vYI.add(cVar11);
        vYT = cVar11;
        c cVar12 = new c(10, "AnchorDoPost");
        vYI.add(cVar12);
        vYU = cVar12;
        c cVar13 = new c(20, "AnchorCreateLive");
        vYI.add(cVar13);
        vYV = cVar13;
        c cVar14 = new c(21, "AnchorCreateLiveFailed");
        vYI.add(cVar14);
        vYW = cVar14;
        c cVar15 = new c(22, "RecheckRealName");
        vYI.add(cVar15);
        vYX = cVar15;
        c cVar16 = new c(30, "AnchorJoinLive");
        vYI.add(cVar16);
        vYY = cVar16;
        c cVar17 = new c(31, "AnchorJoinLiveFailed");
        vYI.add(cVar17);
        vYZ = cVar17;
        c cVar18 = new c(40, "AnchorEnterRoom");
        vYI.add(cVar18);
        vZa = cVar18;
        c cVar19 = new c(41, "AnchorEnterRoomFailed");
        vYI.add(cVar19);
        vZb = cVar19;
        c cVar20 = new c(50, "AnchorShareFeed");
        vYI.add(cVar20);
        vZc = cVar20;
        c cVar21 = new c(51, "AnchorShareFeedFailed");
        vYI.add(cVar21);
        vZd = cVar21;
        c cVar22 = new c(60, "AnchorCancelCreate");
        vYI.add(cVar22);
        vZe = cVar22;
        c cVar23 = new c(70, "AnchorSuccessLive");
        vYI.add(cVar23);
        vZf = cVar23;
        c cVar24 = new c(10, "AnchorLinkSelected");
        vYI.add(cVar24);
        vZg = cVar24;
        c cVar25 = new c(20, "AnchorLinkAcceptSuc");
        vYI.add(cVar25);
        vZh = cVar25;
        c cVar26 = new c(21, "AnchorLinkAcceptFail");
        vYI.add(cVar26);
        vZi = cVar26;
        c cVar27 = new c(30, "AnchorLinkHangupSuc");
        vYI.add(cVar27);
        vZj = cVar27;
        c cVar28 = new c(31, "AnchorLinkHangupFail");
        vYI.add(cVar28);
        vZk = cVar28;
        c cVar29 = new c(10, "VisitorLinkApplySuc");
        vYI.add(cVar29);
        vZl = cVar29;
        c cVar30 = new c(11, "VisitorLinkApplyFail");
        vYI.add(cVar30);
        vZm = cVar30;
        c cVar31 = new c(20, "VisitorLinkAccepted");
        vYI.add(cVar31);
        vZn = cVar31;
        c cVar32 = new c(30, "VisitorLinkHangupSuc");
        vYI.add(cVar32);
        vZo = cVar32;
        c cVar33 = new c(31, "VisitorLinkHangupFail");
        vYI.add(cVar33);
        vZp = cVar33;
        c cVar34 = new c(10, "VisitorRewardSuc");
        vYI.add(cVar34);
        vZq = cVar34;
        c cVar35 = new c(11, "VisitorRewardFail");
        vYI.add(cVar35);
        vZr = cVar35;
        c cVar36 = new c(12, "VisitorRewardConsumeFail");
        vYI.add(cVar36);
        vZs = cVar36;
        AppMethodBeat.o(253761);
    }

    public static final class c {
        final int id;
        public final String name;

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x001c, code lost:
            if (kotlin.g.b.p.j(r3.name, r4.name) != false) goto L_0x001e;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 253760(0x3df40, float:3.55593E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x001e
                boolean r0 = r4 instanceof com.tencent.mm.plugin.finder.utils.ad.c
                if (r0 == 0) goto L_0x0023
                com.tencent.mm.plugin.finder.utils.ad$c r4 = (com.tencent.mm.plugin.finder.utils.ad.c) r4
                int r0 = r3.id
                int r1 = r4.id
                if (r0 != r1) goto L_0x0023
                java.lang.String r0 = r3.name
                java.lang.String r1 = r4.name
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0023
            L_0x001e:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            L_0x0022:
                return r0
            L_0x0023:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x0022
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.utils.ad.c.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            AppMethodBeat.i(253759);
            int i2 = this.id * 31;
            String str = this.name;
            int hashCode = (str != null ? str.hashCode() : 0) + i2;
            AppMethodBeat.o(253759);
            return hashCode;
        }

        public final String toString() {
            AppMethodBeat.i(253758);
            String str = "LiveStage(id=" + this.id + ", name=" + this.name + ")";
            AppMethodBeat.o(253758);
            return str;
        }

        public c(int i2, String str) {
            p.h(str, "name");
            AppMethodBeat.i(253757);
            this.id = i2;
            this.name = str;
            AppMethodBeat.o(253757);
        }
    }

    static final class b extends q implements kotlin.g.a.a<HashMap<String, Integer>> {
        public static final b vZv = new b();

        static {
            AppMethodBeat.i(253756);
            AppMethodBeat.o(253756);
        }

        b() {
            super(0);
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ HashMap<String, Integer> invoke() {
            AppMethodBeat.i(253755);
            HashMap<String, Integer> hashMap = new HashMap<>();
            for (c cVar : ad.vYI) {
                if (!hashMap.containsKey(cVar.name) || !BuildInfo.DEBUG) {
                    hashMap.put(cVar.name, Integer.valueOf(cVar.id));
                } else {
                    RuntimeException runtimeException = new RuntimeException("stageNameIdMap name duplicate:" + cVar.name);
                    AppMethodBeat.o(253755);
                    throw runtimeException;
                }
            }
            AppMethodBeat.o(253755);
            return hashMap;
        }
    }
}
