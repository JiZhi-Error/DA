package com.tencent.mm.plugin.finder.live.util;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.live.model.e;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aut;
import com.tencent.mm.protocal.protobuf.auz;
import com.tencent.mm.protocal.protobuf.avn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0003 !\"J\u0018\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H&J\b\u0010\u0007\u001a\u00020\bH&J\n\u0010\t\u001a\u0004\u0018\u00010\nH&J\b\u0010\u000b\u001a\u00020\u0003H&J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0006H&J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0006H&J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0013\u001a\u00020\u0011H&J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0006H&J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0013\u001a\u00020\u0011H&J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0006H&J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0013\u001a\u00020\u0011H&J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0006H&J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0013\u001a\u00020\u0011H&J\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001bH&J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0006H&J\b\u0010\u001d\u001a\u00020\u001eH&J\u0010\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001bH&¨\u0006#"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue;", "", "addAll", "", "collection", "", "Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftShowInfo;", "clear", "", "getNextGiftType", "Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftType;", "hasNext", "offer", "giftShowInfo", "peek", "peekByComboId", "comboId", "", "peekByTargetUserName", "targetUserName", "peekNonPrecious", "poll", "pollByComboId", "pollByTargetUserName", "pollNonPrecious", "registerObserver", "observer", "Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftAddingObserver;", "remove", "size", "", "unregisterObserver", "GiftAddingObserver", "GiftShowInfo", "GiftType", "plugin-finder_release"})
public interface p {

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftAddingObserver;", "", "onGiftAdding", "", "giftType", "Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftType;", "plugin-finder_release"})
    public interface a {
        void a(c cVar);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftType;", "", "(Ljava/lang/String;I)V", "SELF_PRECIOUS_GIFT_COMBO", "SELF_PRECIOUS_GIFT_SOLO", "SELF_NORMAL_GIFT_COMBO", "SELF_NORMAL_GIFT_SOLO", "PRECIOUS_GIFT_COMBO", "PRECIOUS_GIFT_SOLO", "NORMAL_GIFT_COMBO", "NORMAL_GIFT_SOLO", "plugin-finder_release"})
    public enum c {
        SELF_PRECIOUS_GIFT_COMBO,
        SELF_PRECIOUS_GIFT_SOLO,
        SELF_NORMAL_GIFT_COMBO,
        SELF_NORMAL_GIFT_SOLO,
        PRECIOUS_GIFT_COMBO,
        PRECIOUS_GIFT_SOLO,
        NORMAL_GIFT_COMBO,
        NORMAL_GIFT_SOLO;

        static {
            AppMethodBeat.i(247289);
            AppMethodBeat.o(247289);
        }

        public static c valueOf(String str) {
            AppMethodBeat.i(247291);
            c cVar = (c) Enum.valueOf(c.class, str);
            AppMethodBeat.o(247291);
            return cVar;
        }
    }

    void a(a aVar);

    void b(a aVar);

    boolean b(b bVar);

    b bxJ(String str);

    b bxK(String str);

    b bxM(String str);

    c dii();

    b dik();

    boolean hasNext();

    int size();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020\u0000H\u0002J\t\u00107\u001a\u00020\u0003HÆ\u0003J\u0013\u00108\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u00109\u001a\u00020!2\b\u00106\u001a\u0004\u0018\u00010:HÖ\u0003J\t\u0010;\u001a\u00020\fHÖ\u0001J\b\u0010<\u001a\u00020\u0006H\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\b\"\u0004\b\u0019\u0010\nR\u001a\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\"\"\u0004\b&\u0010$R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020*X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010/\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u000e\"\u0004\b1\u0010\u0010R\u001a\u00102\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\b\"\u0004\b4\u0010\n¨\u0006="}, hxF = {"Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftShowInfo;", "", "liveMsg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;)V", "comboId", "", "getComboId", "()Ljava/lang/String;", "setComboId", "(Ljava/lang/String;)V", "comboSumCount", "", "getComboSumCount", "()I", "setComboSumCount", "(I)V", "giftExtInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsgLiveRewardInfo;", "getGiftExtInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsgLiveRewardInfo;", "setGiftExtInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsgLiveRewardInfo;)V", "giftId", "getGiftId", "setGiftId", "giftType", "Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftType;", "getGiftType", "()Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftType;", "setGiftType", "(Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftType;)V", "isPreciousGift", "", "()Z", "setPreciousGift", "(Z)V", "isSelfSend", "setSelfSend", "getLiveMsg", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "queueMsgId", "", "getQueueMsgId", "()J", "setQueueMsgId", "(J)V", "rewardCount", "getRewardCount", "setRewardCount", "targetUserName", "getTargetUserName", "setTargetUserName", "compareTo", FacebookRequestErrorClassification.KEY_OTHER, "component1", "copy", "equals", "", "hashCode", "toString", "plugin-finder_release"})
    public static final class b implements Comparable<b> {
        public String UMe;
        public boolean upQ;
        public String upR;
        public int upS;
        public String upZ;
        c uwS;
        long uwT;
        public auz uwU = new auz();
        public int uwV;
        public boolean uwW;
        public final aut uwX;

        public final boolean equals(Object obj) {
            AppMethodBeat.i(247288);
            if (this == obj || ((obj instanceof b) && kotlin.g.b.p.j(this.uwX, ((b) obj).uwX))) {
                AppMethodBeat.o(247288);
                return true;
            }
            AppMethodBeat.o(247288);
            return false;
        }

        public final int hashCode() {
            AppMethodBeat.i(247287);
            aut aut = this.uwX;
            if (aut != null) {
                int hashCode = aut.hashCode();
                AppMethodBeat.o(247287);
                return hashCode;
            }
            AppMethodBeat.o(247287);
            return 0;
        }

        public b(aut aut) {
            byte[] bArr;
            String str;
            c cVar;
            FinderContact finderContact;
            FinderContact finderContact2;
            String str2;
            boolean z = true;
            kotlin.g.b.p.h(aut, "liveMsg");
            AppMethodBeat.i(247286);
            this.uwX = aut;
            avn avn = this.uwX.LFE;
            this.upQ = (avn == null || (finderContact2 = avn.contact) == null || (str2 = finderContact2.username) == null || true != str2.equals(z.aTY())) ? false : true;
            auz auz = this.uwU;
            com.tencent.mm.bw.b bVar = this.uwX.LFB;
            if (bVar != null) {
                bArr = bVar.toByteArray();
            } else {
                bArr = null;
            }
            try {
                auz.parseFrom(bArr);
            } catch (Exception e2) {
                Log.printDebugStack("safeParser", "", e2);
            }
            e eVar = e.uiD;
            this.uwW = e.atB(this.uwU.LFM);
            this.upR = this.uwU.LFP;
            this.upS = this.uwU.LFO;
            this.uwV = this.uwU.LFQ;
            this.upZ = this.uwU.LFM;
            if (Util.isNullOrNil(this.upR) || (this.upS <= 1 && this.uwV <= 1)) {
                z = false;
            }
            avn avn2 = this.uwX.LFz;
            this.UMe = (avn2 == null || (finderContact = avn2.contact) == null || (str = finderContact.username) == null) ? "" : str;
            if (this.upQ) {
                if (this.uwW) {
                    if (z) {
                        cVar = c.SELF_PRECIOUS_GIFT_COMBO;
                    } else {
                        cVar = c.SELF_PRECIOUS_GIFT_SOLO;
                    }
                } else if (z) {
                    cVar = c.SELF_NORMAL_GIFT_COMBO;
                } else {
                    cVar = c.SELF_NORMAL_GIFT_SOLO;
                }
            } else if (this.uwW) {
                if (z) {
                    cVar = c.PRECIOUS_GIFT_COMBO;
                } else {
                    cVar = c.PRECIOUS_GIFT_SOLO;
                }
            } else if (z) {
                cVar = c.NORMAL_GIFT_COMBO;
            } else {
                cVar = c.NORMAL_GIFT_SOLO;
            }
            this.uwS = cVar;
            AppMethodBeat.o(247286);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(b bVar) {
            AppMethodBeat.i(247284);
            b bVar2 = bVar;
            kotlin.g.b.p.h(bVar2, FacebookRequestErrorClassification.KEY_OTHER);
            if (this.uwS != bVar2.uwS) {
                int compareTo = this.uwS.compareTo((Enum) bVar2.uwS);
                AppMethodBeat.o(247284);
                return compareTo;
            }
            int i2 = (this.uwT > bVar2.uwT ? 1 : (this.uwT == bVar2.uwT ? 0 : -1));
            AppMethodBeat.o(247284);
            return i2;
        }

        public final void c(c cVar) {
            AppMethodBeat.i(247283);
            kotlin.g.b.p.h(cVar, "<set-?>");
            this.uwS = cVar;
            AppMethodBeat.o(247283);
        }

        public final void bxH(String str) {
            AppMethodBeat.i(260762);
            kotlin.g.b.p.h(str, "<set-?>");
            this.UMe = str;
            AppMethodBeat.o(260762);
        }

        public final String toString() {
            AppMethodBeat.i(247285);
            String str = "\n" + ("giftId = " + this.upZ) + ", " + ("giftType = " + this.uwS) + ", " + ("queueMsgId = " + this.uwT) + ", " + ("comboId = " + this.upR) + ", " + ("comboSumCount = " + this.upS) + ", " + ("rewardCount = " + this.uwV) + ", " + ("targetUserName = " + this.UMe) + "\n";
            kotlin.g.b.p.g(str, "StringBuilder().append(\"…              .toString()");
            AppMethodBeat.o(247285);
            return str;
        }
    }
}
