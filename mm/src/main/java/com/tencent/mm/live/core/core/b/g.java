package com.tencent.mm.live.core.core.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.core.e;
import com.tencent.mm.storage.ar;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b6\u0018\u0000 U2\u00020\u0001:\u0006UVWXYZB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0004J\u0006\u0010'\u001a\u00020%J\u0006\u0010(\u001a\u00020%J\u0006\u0010)\u001a\u00020%J\u0006\u0010*\u001a\u00020%J\b\u0010+\u001a\u00020\u000bH\u0002J\u0006\u0010,\u001a\u00020\u0012J\u000e\u0010-\u001a\u00020%2\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010.\u001a\u00020%J\b\u0010/\u001a\u0004\u0018\u00010\u0004J\u0006\u00100\u001a\u00020\u0016J\u0006\u00101\u001a\u00020\u0016J\b\u00102\u001a\u0004\u0018\u00010\u0004J\b\u00103\u001a\u0004\u0018\u00010\u0004J\u0006\u00104\u001a\u00020\u000bJ\u0006\u00105\u001a\u00020\u000bJ\u0006\u00106\u001a\u00020\u000bJ\u0006\u00107\u001a\u00020\u000bJ\u0006\u00108\u001a\u00020\u000bJ\u0017\u00109\u001a\u00020\u000b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010:J\u0006\u0010;\u001a\u00020\u000bJ\u0006\u0010<\u001a\u00020\u000bJ\u0006\u0010=\u001a\u00020\u000bJ\u0006\u0010>\u001a\u00020\u000bJ\u0006\u0010?\u001a\u00020\u000bJ\u0006\u0010@\u001a\u00020%J\u0006\u0010A\u001a\u00020%J\u0006\u0010B\u001a\u00020%J\u0006\u0010C\u001a\u00020%J\u0006\u0010D\u001a\u00020%J\u0006\u0010E\u001a\u00020%J\u0006\u0010F\u001a\u00020%J\u0010\u0010G\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0004J\u0010\u0010H\u001a\u00020%2\b\u0010I\u001a\u0004\u0018\u00010\u0004J\u0010\u0010J\u001a\u00020%2\b\u0010I\u001a\u0004\u0018\u00010\u0004J\u000e\u0010K\u001a\u00020%2\u0006\u0010L\u001a\u00020\u000bJ\u0010\u0010M\u001a\u00020%2\b\u0010I\u001a\u0004\u0018\u00010\u0004J\u000e\u0010N\u001a\u00020%2\u0006\u0010O\u001a\u00020\u0016J\u000e\u0010P\u001a\u00020%2\u0006\u0010Q\u001a\u00020\u0016J\u000e\u0010R\u001a\u00020%2\u0006\u0010S\u001a\u00020\u0014J\u0006\u0010T\u001a\u00020%R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0006j\b\u0012\u0004\u0012\u00020\u0004`\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0010\u0010#\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006["}, hxF = {"Lcom/tencent/mm/live/core/core/model/LiveStatus;", "", "()V", "anchorID", "", "availableAudioUsers", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "floatMode", "Lcom/tencent/mm/live/core/core/model/LiveStatus$MiniWindowMode;", "isDebugMode", "", "()Z", "setDebugMode", "(Z)V", "linkMicStatus", "Lcom/tencent/mm/live/core/core/model/LiveStatus$LinkMicStatus;", "liveID", "", "liveRoomStatus", "Lcom/tencent/mm/live/core/core/model/LiveStatus$LiveRoomStatus;", "networkQuality", "", "networkType", "pkLinkMicRole", "Lcom/tencent/mm/live/core/core/model/LiveStatus$PKLinkMicRole;", "pkLinkMicStatus", "Lcom/tencent/mm/live/core/core/model/LiveStatus$PKLinkMicStatus;", "pkUserId", "resumeFromPermissionCheck", "selfSdkID", "getSelfSdkID", "()Ljava/lang/String;", "setSelfSdkID", "(Ljava/lang/String;)V", "videoMicID", "addAvailableAudioUser", "", "sdkID", "audioLinkMic", "changeToFloatMode", "changeToNormalMode", "changeToPermissionMode", "checkInRoom", "currentRoomID", "enterRoom", "exitRoom", "getAnchorID", "getNetworkQuality", com.tencent.mm.plugin.appbrand.jsapi.z.f.NAME, "getPkUserID", "getVideoMicID", "isEnterRoom", "isFloatMode", "isInAudioLinkMic", "isInPkLinkMic", "isInPkWaitMic", "isInRoom", "(Ljava/lang/Long;)Z", "isInVideoLinkMic", "isNormalMode", "isPkRoleAccept", "isPkRoleApply", "isResumeFromPermissionCheck", "noLinkMic", "noPkLink", "pkLinkMic", "pkRoleAccept", "pkRoleApply", "pkRoleDefault", "pkWaitMic", "removeAvailableAudioUser", "setAnchorID", "id", "setPkUserID", "setResumeFromPermissionCheck", "value", "setVideoMicID", "updateNetworkQuality", "quality", "updateNetworkType", "type", "updateStart", "status", "videoLinkMic", "Companion", "LinkMicStatus", "LiveRoomStatus", "MiniWindowMode", "PKLinkMicRole", "PKLinkMicStatus", "plugin-core_release"})
public final class g {
    public static final a hzM = new a((byte) 0);
    public c hzA = c.LIVE_OUT_ROOM;
    public b hzB = b.NO_LINK_MIC;
    public f hzC = f.NO_PK;
    public e hzD = e.ROLE_DEFAULT;
    public d hzE = d.NORMAL_MODE;
    public long hzF = -1;
    public String hzG = "";
    private String hzH = "";
    public String hzI = "";
    public String hzJ;
    private ArrayList<String> hzK = new ArrayList<>();
    public int hzL;
    public boolean hzz;
    public boolean isDebugMode;
    public int networkType;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/live/core/core/model/LiveStatus$LinkMicStatus;", "", "(Ljava/lang/String;I)V", "NO_LINK_MIC", "AUDIO_LINK_MIC", "VIDEO_LINK_MIC", "PK_LINK_MIC", "plugin-core_release"})
    public enum b {
        NO_LINK_MIC,
        AUDIO_LINK_MIC,
        VIDEO_LINK_MIC,
        PK_LINK_MIC;

        static {
            AppMethodBeat.i(196468);
            AppMethodBeat.o(196468);
        }

        public static b valueOf(String str) {
            AppMethodBeat.i(196470);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(196470);
            return bVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/live/core/core/model/LiveStatus$LiveRoomStatus;", "", "(Ljava/lang/String;I)V", "LIVE_OUT_ROOM", "LIVE_IN_ROOM", "LIVE_JOIN_ROOM", "plugin-core_release"})
    public enum c {
        LIVE_OUT_ROOM,
        LIVE_IN_ROOM,
        LIVE_JOIN_ROOM;

        static {
            AppMethodBeat.i(196471);
            AppMethodBeat.o(196471);
        }

        public static c valueOf(String str) {
            AppMethodBeat.i(196473);
            c cVar = (c) Enum.valueOf(c.class, str);
            AppMethodBeat.o(196473);
            return cVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/live/core/core/model/LiveStatus$MiniWindowMode;", "", "(Ljava/lang/String;I)V", "NORMAL_MODE", "FLOAT_MODE", "PERMISSION_MODE", "plugin-core_release"})
    public enum d {
        NORMAL_MODE,
        FLOAT_MODE,
        PERMISSION_MODE;

        static {
            AppMethodBeat.i(196474);
            AppMethodBeat.o(196474);
        }

        public static d valueOf(String str) {
            AppMethodBeat.i(196476);
            d dVar = (d) Enum.valueOf(d.class, str);
            AppMethodBeat.o(196476);
            return dVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/live/core/core/model/LiveStatus$PKLinkMicRole;", "", "(Ljava/lang/String;I)V", "ROLE_DEFAULT", "ROLE_APPLY_PK", "ROLE_ACCEPT_PK", "plugin-core_release"})
    public enum e {
        ROLE_DEFAULT,
        ROLE_APPLY_PK,
        ROLE_ACCEPT_PK;

        static {
            AppMethodBeat.i(196477);
            AppMethodBeat.o(196477);
        }

        public static e valueOf(String str) {
            AppMethodBeat.i(196479);
            e eVar = (e) Enum.valueOf(e.class, str);
            AppMethodBeat.o(196479);
            return eVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/live/core/core/model/LiveStatus$PKLinkMicStatus;", "", "(Ljava/lang/String;I)V", "NO_PK", "PK_WAITING", "PK_LINKING", "plugin-core_release"})
    public enum f {
        NO_PK,
        PK_WAITING,
        PK_LINKING;

        static {
            AppMethodBeat.i(196480);
            AppMethodBeat.o(196480);
        }

        public static f valueOf(String str) {
            AppMethodBeat.i(196482);
            f fVar = (f) Enum.valueOf(f.class, str);
            AppMethodBeat.o(196482);
            return fVar;
        }
    }

    static {
        AppMethodBeat.i(196485);
        AppMethodBeat.o(196485);
    }

    public g() {
        boolean z = true;
        AppMethodBeat.i(196484);
        e.h hVar = e.h.hya;
        this.hzL = e.h.aCS();
        this.networkType = -1;
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        p.g(aAh, "MMKernel.storage()");
        this.isDebugMode = aAh.azQ().getInt(ar.a.USERINFO_LIVE_DEBUG_VIEW_INT_SYNC, 0) != 1 ? false : z;
        AppMethodBeat.o(196484);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/live/core/core/model/LiveStatus$Companion;", "", "()V", "LIVE_DEFAULT", "", "plugin-core_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final boolean isFloatMode() {
        return this.hzE == d.FLOAT_MODE;
    }

    public final boolean isNormalMode() {
        return this.hzE == d.NORMAL_MODE;
    }

    public final boolean bmy() {
        return this.hzD == e.ROLE_APPLY_PK;
    }

    public final boolean b(Long l) {
        AppMethodBeat.i(196483);
        if (l == null) {
            boolean aDs = aDs();
            AppMethodBeat.o(196483);
            return aDs;
        }
        if (l.longValue() == this.hzF) {
            boolean aDs2 = aDs();
            AppMethodBeat.o(196483);
            return aDs2;
        }
        AppMethodBeat.o(196483);
        return false;
    }

    private final boolean aDs() {
        return this.hzA == c.LIVE_IN_ROOM;
    }

    public final boolean aDt() {
        return this.hzB == b.VIDEO_LINK_MIC;
    }

    public final boolean aDu() {
        return this.hzB == b.AUDIO_LINK_MIC;
    }
}
