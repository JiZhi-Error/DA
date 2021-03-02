package com.tencent.mm.live.core.core.b;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.trtc.TRTCCloudDef;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 $2\u00020\u0001:\u0001$B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J'\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\b\u0010\"\u001a\u00020#H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006%"}, hxF = {"Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "", "trtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "jumpInfo", "Lcom/tencent/mm/live/core/core/model/LiveJumpInfo;", "(Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;Lcom/tencent/mm/live/core/core/model/LiveJumpInfo;)V", "getJumpInfo", "()Lcom/tencent/mm/live/core/core/model/LiveJumpInfo;", "setJumpInfo", "(Lcom/tencent/mm/live/core/core/model/LiveJumpInfo;)V", "getLiveRoomInfo", "()Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "setLiveRoomInfo", "(Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;)V", "renderModel", "Lcom/tencent/mm/live/core/core/model/LiveRenderModel;", "getRenderModel", "()Lcom/tencent/mm/live/core/core/model/LiveRenderModel;", "getTrtcParams", "()Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "setTrtcParams", "(Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;)V", "component1", "component2", "component3", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "toString", "", "Companion", "plugin-core_release"})
public final class f {
    private static final TRTCCloudDef.TRTCParams hzw = new TRTCCloudDef.TRTCParams(1400188366, "852082", "eJwtzE0LgkAUheH-creF3pnG8SK0iGhnEOiiwE01U1w-YlBTI-rvibo8zwvnC2mceJ2tIQLpIaynzca*Wn7wxBRIJLmUxhRX59hAJBSiINpoPRc7OK4tRBoVIc7WcjWKCEhK0oFYtOHneFvcM99w5ueZX6hdyQntb6XrkiqPV314HK7qlL9TbM-hof9ctvD7AxQcMac_", 12081, "", "");
    private static final e hzx = new e(APMidasPayAPI.ENV_TEST, 12081, 0, null, 0, 0, 0, null, null, 0, 8188);
    public static final a hzy = new a((byte) 0);
    public e hwP;
    public final d hzt = new d((byte) 0);
    public TRTCCloudDef.TRTCParams hzu;
    public b hzv;

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002a, code lost:
        if (kotlin.g.b.p.j(r3.hzv, r4.hzv) != false) goto L_0x002c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r2 = 196467(0x2ff73, float:2.75309E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            if (r3 == r4) goto L_0x002c
            boolean r0 = r4 instanceof com.tencent.mm.live.core.core.b.f
            if (r0 == 0) goto L_0x0031
            com.tencent.mm.live.core.core.b.f r4 = (com.tencent.mm.live.core.core.b.f) r4
            com.tencent.trtc.TRTCCloudDef$TRTCParams r0 = r3.hzu
            com.tencent.trtc.TRTCCloudDef$TRTCParams r1 = r4.hzu
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0031
            com.tencent.mm.live.core.core.b.e r0 = r3.hwP
            com.tencent.mm.live.core.core.b.e r1 = r4.hwP
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0031
            com.tencent.mm.live.core.core.b.b r0 = r3.hzv
            com.tencent.mm.live.core.core.b.b r1 = r4.hzv
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0031
        L_0x002c:
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
        L_0x0030:
            return r0
        L_0x0031:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x0030
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.live.core.core.b.f.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(196466);
        TRTCCloudDef.TRTCParams tRTCParams = this.hzu;
        int hashCode = (tRTCParams != null ? tRTCParams.hashCode() : 0) * 31;
        e eVar = this.hwP;
        int hashCode2 = ((eVar != null ? eVar.hashCode() : 0) + hashCode) * 31;
        b bVar = this.hzv;
        if (bVar != null) {
            i2 = bVar.hashCode();
        }
        int i3 = hashCode2 + i2;
        AppMethodBeat.o(196466);
        return i3;
    }

    public f(TRTCCloudDef.TRTCParams tRTCParams, e eVar, b bVar) {
        p.h(tRTCParams, "trtcParams");
        p.h(eVar, "liveRoomInfo");
        p.h(bVar, "jumpInfo");
        AppMethodBeat.i(196464);
        this.hzu = tRTCParams;
        this.hwP = eVar;
        this.hzv = bVar;
        this.hzt.hzi = false;
        this.hzt.hzg = false;
        AppMethodBeat.o(196464);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/live/core/core/model/LiveRoomModel$Companion;", "", "()V", "testLiveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "getTestLiveRoomInfo", "()Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "testTrtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "getTestTrtcParams", "()Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "plugin-core_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(196465);
        AppMethodBeat.o(196465);
    }

    public final String toString() {
        AppMethodBeat.i(196463);
        String str = "LiveRoomModel(liveRoomInfo=" + this.hwP + ", trtcParams=(sdkAppId:" + this.hzu.sdkAppId + ",uid:" + this.hzu.userId + ",roomId:" + this.hzu.roomId + "))";
        AppMethodBeat.o(196463);
        return str;
    }
}
