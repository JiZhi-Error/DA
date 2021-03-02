package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import android.support.annotation.Keep;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001:\u0003-./BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\bHÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u0010$\u001a\u00020\u000eHÆ\u0003J[\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\b\u0010*\u001a\u00020\u0005H\u0016J\t\u0010+\u001a\u00020\u0003HÖ\u0001J\t\u0010,\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u00060"}, hxF = {"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IResInfo;", "id", "", "name", "", "frameCount", "triggerAction", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$TriggerAction;", "resPath", "resPathMd5", "pos", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$Position;", "type", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$StickerBackType;", "(ILjava/lang/String;ILcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$TriggerAction;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$Position;Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$StickerBackType;)V", "getFrameCount", "()I", "getId", "getName", "()Ljava/lang/String;", "getPos", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$Position;", "getResPath", "getResPathMd5", "getTriggerAction", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$TriggerAction;", "getType", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$StickerBackType;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "", "getIdentityDesc", "hashCode", "toString", "Position", "StickerBackType", "TriggerAction", "luggage-xweb-ext_release"})
public final class StickerItemInfo implements h {
    public final TriggerAction cHL;
    public final String cHM;
    private final String cHN;
    public final a cHO;
    public final StickerBackType cHP;
    public final int frameCount;
    public final int id;
    public final String name;

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0054, code lost:
        if (kotlin.g.b.p.j(r3.cHP, r4.cHP) != false) goto L_0x0056;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r2 = 215985(0x34bb1, float:3.0266E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            if (r3 == r4) goto L_0x0056
            boolean r0 = r4 instanceof com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.StickerItemInfo
            if (r0 == 0) goto L_0x005b
            com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.StickerItemInfo r4 = (com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.StickerItemInfo) r4
            int r0 = r3.id
            int r1 = r4.id
            if (r0 != r1) goto L_0x005b
            java.lang.String r0 = r3.name
            java.lang.String r1 = r4.name
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x005b
            int r0 = r3.frameCount
            int r1 = r4.frameCount
            if (r0 != r1) goto L_0x005b
            com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.StickerItemInfo$TriggerAction r0 = r3.cHL
            com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.StickerItemInfo$TriggerAction r1 = r4.cHL
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x005b
            java.lang.String r0 = r3.cHM
            java.lang.String r1 = r4.cHM
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x005b
            java.lang.String r0 = r3.cHN
            java.lang.String r1 = r4.cHN
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x005b
            com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.StickerItemInfo$a r0 = r3.cHO
            com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.StickerItemInfo$a r1 = r4.cHO
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x005b
            com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.StickerItemInfo$StickerBackType r0 = r3.cHP
            com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.StickerItemInfo$StickerBackType r1 = r4.cHP
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x005b
        L_0x0056:
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
        L_0x005a:
            return r0
        L_0x005b:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x005a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.StickerItemInfo.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(215984);
        int i3 = this.id * 31;
        String str = this.name;
        int hashCode = ((((str != null ? str.hashCode() : 0) + i3) * 31) + this.frameCount) * 31;
        TriggerAction triggerAction = this.cHL;
        int hashCode2 = ((triggerAction != null ? triggerAction.hashCode() : 0) + hashCode) * 31;
        String str2 = this.cHM;
        int hashCode3 = ((str2 != null ? str2.hashCode() : 0) + hashCode2) * 31;
        String str3 = this.cHN;
        int hashCode4 = ((str3 != null ? str3.hashCode() : 0) + hashCode3) * 31;
        a aVar = this.cHO;
        int hashCode5 = ((aVar != null ? aVar.hashCode() : 0) + hashCode4) * 31;
        StickerBackType stickerBackType = this.cHP;
        if (stickerBackType != null) {
            i2 = stickerBackType.hashCode();
        }
        int i4 = hashCode5 + i2;
        AppMethodBeat.o(215984);
        return i4;
    }

    public final String toString() {
        AppMethodBeat.i(215983);
        String str = "StickerItemInfo(id=" + this.id + ", name=" + this.name + ", frameCount=" + this.frameCount + ", triggerAction=" + this.cHL + ", resPath=" + this.cHM + ", resPathMd5=" + this.cHN + ", pos=" + this.cHO + ", type=" + this.cHP + ")";
        AppMethodBeat.o(215983);
        return str;
    }

    public StickerItemInfo(int i2, String str, int i3, TriggerAction triggerAction, String str2, String str3, a aVar, StickerBackType stickerBackType) {
        p.h(str, "name");
        p.h(triggerAction, "triggerAction");
        p.h(str2, "resPath");
        p.h(str3, "resPathMd5");
        p.h(stickerBackType, "type");
        AppMethodBeat.i(215982);
        this.id = i2;
        this.name = str;
        this.frameCount = i3;
        this.cHL = triggerAction;
        this.cHM = str2;
        this.cHN = str3;
        this.cHO = aVar;
        this.cHP = stickerBackType;
        AppMethodBeat.o(215982);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.h
    public final String Qc() {
        AppMethodBeat.i(215981);
        String str = "StickerItemInfo(resPath='" + this.cHM + "', resPathMd5='" + this.cHN + "')";
        AppMethodBeat.o(215981);
        return str;
    }

    @Keep
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u001b\b\u0001\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001dB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001c¨\u0006\u001e"}, hxF = {"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$TriggerAction;", "", "jsonVal", "", "(Ljava/lang/String;II)V", "getJsonVal", "()I", "DEFAULT_ACTION_LOOP", "FACE_ACTION_MOUTH_OPEN", "FACE_ACTION_MOUTH_KISS", "FACE_ACTION_LEFT_EYE_BLINK", "FACE_ACTION_RIGHT_EYE_BLINK", "FACE_ACTION_EYE_BLINK", "FACE_ACTION_EYEBROW_UP", "FACE_ACTION_HEAD_SHAKE", "FACE_ACTION_HEAD_NOD", "HAND_ACTION_HEART", "HAND_ACTION_PAPER", "HAND_ACTION_SCISSOR", "HAND_ACTION_FIST", "HAND_ACTION_ONE", "HAND_ACTION_LOVE", "HAND_ACTION_LIKE", "HAND_ACTION_OK", "HAND_ACTION_ROCK", "HAND_ACTION_SIX", "HAND_ACTION_EIGHT", "HAND_ACTION_LIFT", "HAND_ACTION_GOOD_FORTUNE", "Companion", "luggage-xweb-ext_release"})
    public enum TriggerAction {
        DEFAULT_ACTION_LOOP(-1),
        FACE_ACTION_MOUTH_OPEN(10),
        FACE_ACTION_MOUTH_KISS(11),
        FACE_ACTION_LEFT_EYE_BLINK(12),
        FACE_ACTION_RIGHT_EYE_BLINK(13),
        FACE_ACTION_EYE_BLINK(14),
        FACE_ACTION_EYEBROW_UP(15),
        FACE_ACTION_HEAD_SHAKE(16),
        FACE_ACTION_HEAD_NOD(17),
        HAND_ACTION_HEART(100),
        HAND_ACTION_PAPER(101),
        HAND_ACTION_SCISSOR(102),
        HAND_ACTION_FIST(103),
        HAND_ACTION_ONE(104),
        HAND_ACTION_LOVE(105),
        HAND_ACTION_LIKE(106),
        HAND_ACTION_OK(107),
        HAND_ACTION_ROCK(108),
        HAND_ACTION_SIX(109),
        HAND_ACTION_EIGHT(110),
        HAND_ACTION_LIFT(111),
        HAND_ACTION_GOOD_FORTUNE(112);
        
        public static final a Companion = new a((byte) 0);
        private final int jsonVal;

        public static TriggerAction valueOf(String str) {
            AppMethodBeat.i(215979);
            TriggerAction triggerAction = (TriggerAction) Enum.valueOf(TriggerAction.class, str);
            AppMethodBeat.o(215979);
            return triggerAction;
        }

        private TriggerAction(int i2) {
            this.jsonVal = i2;
        }

        public final int getJsonVal() {
            return this.jsonVal;
        }

        static {
            AppMethodBeat.i(215977);
            AppMethodBeat.o(215977);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, hxF = {"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$TriggerAction$Companion;", "", "()V", "from", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$TriggerAction;", "actionInt", "", "luggage-xweb-ext_release"})
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(byte b2) {
                this();
            }
        }

        public static final TriggerAction from(int i2) {
            AppMethodBeat.i(215980);
            TriggerAction[] values = values();
            for (TriggerAction triggerAction : values) {
                if (i2 == triggerAction.getJsonVal()) {
                    AppMethodBeat.o(215980);
                    return triggerAction;
                }
            }
            AppMethodBeat.o(215980);
            return null;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0019"}, hxF = {"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$Position;", "", "x1", "", "y1", "x2", "y2", "(DDDD)V", "getX1", "()D", "getX2", "getY1", "getY2", "component1", "component2", "component3", "component4", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "toString", "", "luggage-xweb-ext_release"})
    public static final class a {
        public final double cHQ;
        public final double cHR;
        public final double cHS;
        public final double cHT;

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0034, code lost:
            if (java.lang.Double.compare(r5.cHT, r6.cHT) == 0) goto L_0x0036;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r6) {
            /*
                r5 = this;
                r4 = 215972(0x34ba4, float:3.02641E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
                if (r5 == r6) goto L_0x0036
                boolean r0 = r6 instanceof com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.StickerItemInfo.a
                if (r0 == 0) goto L_0x003b
                com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.StickerItemInfo$a r6 = (com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.StickerItemInfo.a) r6
                double r0 = r5.cHQ
                double r2 = r6.cHQ
                int r0 = java.lang.Double.compare(r0, r2)
                if (r0 != 0) goto L_0x003b
                double r0 = r5.cHR
                double r2 = r6.cHR
                int r0 = java.lang.Double.compare(r0, r2)
                if (r0 != 0) goto L_0x003b
                double r0 = r5.cHS
                double r2 = r6.cHS
                int r0 = java.lang.Double.compare(r0, r2)
                if (r0 != 0) goto L_0x003b
                double r0 = r5.cHT
                double r2 = r6.cHT
                int r0 = java.lang.Double.compare(r0, r2)
                if (r0 != 0) goto L_0x003b
            L_0x0036:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            L_0x003a:
                return r0
            L_0x003b:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
                goto L_0x003a
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.StickerItemInfo.a.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            AppMethodBeat.i(215971);
            long doubleToLongBits = Double.doubleToLongBits(this.cHQ);
            long doubleToLongBits2 = Double.doubleToLongBits(this.cHR);
            long doubleToLongBits3 = Double.doubleToLongBits(this.cHS);
            long doubleToLongBits4 = Double.doubleToLongBits(this.cHT);
            int i2 = (((((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)))) * 31) + ((int) (doubleToLongBits4 ^ (doubleToLongBits4 >>> 32)));
            AppMethodBeat.o(215971);
            return i2;
        }

        public final String toString() {
            AppMethodBeat.i(215970);
            String str = "Position(x1=" + this.cHQ + ", y1=" + this.cHR + ", x2=" + this.cHS + ", y2=" + this.cHT + ")";
            AppMethodBeat.o(215970);
            return str;
        }

        public a(double d2, double d3, double d4, double d5) {
            this.cHQ = d2;
            this.cHR = d3;
            this.cHS = d4;
            this.cHT = d5;
        }
    }

    @Keep
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, hxF = {"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$StickerBackType;", "", "jsonVal", "", "(Ljava/lang/String;II)V", "getJsonVal", "()I", "BACKGROUND", "HUMAN_REGION", "Companion", "luggage-xweb-ext_release"})
    public enum StickerBackType {
        BACKGROUND(0),
        HUMAN_REGION(1);
        
        public static final a Companion = new a((byte) 0);
        private final int jsonVal;

        public static StickerBackType valueOf(String str) {
            AppMethodBeat.i(215975);
            StickerBackType stickerBackType = (StickerBackType) Enum.valueOf(StickerBackType.class, str);
            AppMethodBeat.o(215975);
            return stickerBackType;
        }

        private StickerBackType(int i2) {
            this.jsonVal = i2;
        }

        public final int getJsonVal() {
            return this.jsonVal;
        }

        static {
            AppMethodBeat.i(215973);
            AppMethodBeat.o(215973);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, hxF = {"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$StickerBackType$Companion;", "", "()V", "from", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$StickerBackType;", "typeInt", "", "luggage-xweb-ext_release"})
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(byte b2) {
                this();
            }
        }

        public static final StickerBackType from(int i2) {
            AppMethodBeat.i(215976);
            StickerBackType[] values = values();
            for (StickerBackType stickerBackType : values) {
                if (i2 == stickerBackType.getJsonVal()) {
                    AppMethodBeat.o(215976);
                    return stickerBackType;
                }
            }
            AppMethodBeat.o(215976);
            return null;
        }
    }
}
