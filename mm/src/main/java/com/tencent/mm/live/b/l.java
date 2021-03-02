package com.tencent.mm.live.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.live.core.core.b.e;
import com.tencent.trtc.TRTCCloudDef;
import kotlin.g.a.s;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 +2\u00020\u0001:\u0001+B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u001d\u001a\u00020\u00142w\u0010\u001e\u001as\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u0002\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u0002\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\r\u0012\b\b\u0002\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\r\u0012\b\b\u0002\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\r\u0012\b\b\u0002\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000bJ\u0010\u001f\u001a\u00020\u00142w\u0010\u001e\u001as\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u0002\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\r\u0012\b\b\u0002\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\r\u0012\b\b\u0002\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\r\u0012\b\b\u0002\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\r\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000bJ\u0001\u0010 \u001a\u00020\u00142\u0001\u0010\u001e\u001a\u0001\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u0002\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u0002\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\r\u0012\b\b\u0002\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\r\u0012\b\b\u0002\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\r\u0012\b\b\u0002\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\r\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u0014\u0018\u00010!J,\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u00032\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0010\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020(H\u0002J\u0010\u0010)\u001a\u00020\u00142\u0006\u0010'\u001a\u00020*H\u0002R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0010\n\u001as\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u0002\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u0002\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\r\u0012\b\b\u0002\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\r\u0012\b\b\u0002\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\r\u0012\b\b\u0002\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0015\u001as\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u0002\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\r\u0012\b\b\u0002\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\r\u0012\b\b\u0002\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\r\u0012\b\b\u0002\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\r\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001b¨\u0006,"}, hxF = {"Lcom/tencent/mm/live/model/LaunchLiveRoom;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "name", "", "roomId", "context", "Landroid/content/Context;", "(Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "createCallback", "Lkotlin/Function5;", "", "Lkotlin/ParameterName;", "success", "needFaceVerify", "verifyUrl", "", "errCode", "errMsg", "", "joinCallback", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "liveRoomInfo", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "trtcParams", "getName", "()Ljava/lang/String;", "getRoomId", "createLive", "callback", "joinLive", "launch", "Lkotlin/Function6;", "onSceneEnd", "errType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "processCreateLiveResponse", "response", "Lcom/tencent/mm/protocal/protobuf/CreateLiveResponse;", "processJoinLiveResponse", "Lcom/tencent/mm/protocal/protobuf/JoinLiveResponse;", "Companion", "plugin-logic_release"})
public final class l implements i {
    public static final a hGa = new a((byte) 0);
    private final Context context;
    public s<? super Boolean, ? super Boolean, ? super String, ? super Integer, ? super String, x> hFY;
    public s<? super Boolean, ? super Integer, ? super String, ? super e, ? super TRTCCloudDef.TRTCParams, x> hFZ;
    public final String name;
    public final String roomId;

    static {
        AppMethodBeat.i(207579);
        AppMethodBeat.o(207579);
    }

    public l(String str, String str2, Context context2) {
        p.h(str, "name");
        p.h(str2, "roomId");
        p.h(context2, "context");
        AppMethodBeat.i(207578);
        this.name = str;
        this.roomId = str2;
        this.context = context2;
        AppMethodBeat.o(207578);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/live/model/LaunchLiveRoom$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0112  */
    @Override // com.tencent.mm.ak.i
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onSceneEnd(int r20, int r21, java.lang.String r22, com.tencent.mm.ak.q r23) {
        /*
        // Method dump skipped, instructions count: 669
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.live.b.l.onSceneEnd(int, int, java.lang.String, com.tencent.mm.ak.q):void");
    }
}
