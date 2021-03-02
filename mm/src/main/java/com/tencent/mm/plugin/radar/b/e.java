package com.tencent.mm.plugin.radar.b;

import android.content.Context;
import android.os.Message;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.plugin.radar.b.c;
import com.tencent.mm.pluginsdk.model.lbs.Location;
import com.tencent.mm.protocal.protobuf.diy;
import com.tencent.mm.protocal.protobuf.diz;
import com.tencent.mm.protocal.protobuf.dja;
import com.tencent.mm.protocal.protobuf.djb;
import com.tencent.mm.protocal.protobuf.djd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000§\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0012*\u0001\n\u0018\u0000 d2\u00020\u0001:\u0006cdefghB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0014\u0010=\u001a\u00020>2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020@0\"J\u0010\u0010A\u001a\u00020/2\b\u0010B\u001a\u0004\u0018\u00010#J\u001a\u0010C\u001a\u0004\u0018\u00010\u00182\u0006\u0010B\u001a\u00020#2\b\b\u0002\u0010D\u001a\u00020\u0016J\u0010\u0010C\u001a\u0004\u0018\u00010\u00182\u0006\u0010E\u001a\u00020\u0010J\u001a\u0010F\u001a\u0004\u0018\u00010\u00182\u0006\u0010E\u001a\u00020\u00102\u0006\u0010D\u001a\u00020\u0016H\u0002J\u0006\u0010G\u001a\u00020>J\u0006\u0010H\u001a\u00020>J\u001a\u0010I\u001a\u00020>2\u0006\u0010J\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\u0006\u0010K\u001a\u00020>J0\u0010L\u001a\u00020>2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020N2\u000e\u0010P\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"2\u0006\u0010Q\u001a\u00020NH\u0002J0\u0010R\u001a\u00020>2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020N2\u000e\u0010P\u001a\n\u0012\u0004\u0012\u00020@\u0018\u00010\"2\u0006\u0010Q\u001a\u00020NH\u0002J\u0006\u0010S\u001a\u00020>J*\u0010T\u001a\u00020>2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020N2\b\u0010U\u001a\u0004\u0018\u00010\u00102\u0006\u0010V\u001a\u00020WH\u0016J\u0016\u0010X\u001a\u00020>2\u0006\u0010B\u001a\u00020#2\u0006\u0010Y\u001a\u00020\u0018J\u0016\u0010X\u001a\u00020>2\u0006\u0010E\u001a\u00020\u00102\u0006\u0010Y\u001a\u00020\u0018J\b\u0010Z\u001a\u00020>H\u0002J\b\u0010[\u001a\u00020>H\u0002J\u001a\u0010\\\u001a\u00020>2\u0006\u0010]\u001a\u00020\u00102\b\u0010Y\u001a\u0004\u0018\u00010\u0018H\u0002J\u0010\u0010^\u001a\u00020>2\b\u0010B\u001a\u0004\u0018\u00010#J\u0006\u0010_\u001a\u00020>J\b\u0010`\u001a\u00020>H\u0002J\u0006\u0010a\u001a\u00020>J\u000e\u0010b\u001a\u00020>2\u0006\u0010B\u001a\u00020#J\u0010\u0010b\u001a\u00020>2\u0006\u0010]\u001a\u00020\u0010H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R&\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R&\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00180\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"X\u0004¢\u0006\u0002\n\u0000R\"\u0010$\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u0002\n\u0000R&\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020/0\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0012\"\u0004\b1\u0010\u0014R&\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00180\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0012\"\u0004\b4\u0010\u0014R\u000e\u00105\u001a\u000206X\u000e¢\u0006\u0002\n\u0000R&\u00107\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u0002090\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0012\"\u0004\b;\u0010\u0014R\u0010\u0010<\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006i"}, hxF = {"Lcom/tencent/mm/plugin/radar/model/RadarManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "delegate", "Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarDelegate;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarDelegate;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "delayRadarRemove", "com/tencent/mm/plugin/radar/model/RadarManager$delayRadarRemove$1", "Lcom/tencent/mm/plugin/radar/model/RadarManager$delayRadarRemove$1;", "delayRadarSearch", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "encodeUserNameMap", "", "", "getEncodeUserNameMap", "()Ljava/util/Map;", "setEncodeUserNameMap", "(Ljava/util/Map;)V", "isCancel", "", "lastStateTable", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "getLastStateTable", "setLastStateTable", FirebaseAnalytics.b.LOCATION, "Lcom/tencent/mm/pluginsdk/model/lbs/Location;", "locationGeo", "Lcom/tencent/mm/modelgeo/LocationGeo;", "mOnLocationGet", "Lcom/tencent/mm/modelgeo/IGetLocation$IOnLocationGet;", "members", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "radarMemberList", "Lcom/tencent/mm/protocal/protobuf/RadarMember;", "getRadarMemberList", "()Ljava/util/LinkedList;", "setRadarMemberList", "(Ljava/util/LinkedList;)V", "sceneRadarRelationChain", "Lcom/tencent/mm/plugin/radar/model/NetSceneRadarRelationChain;", "sceneRadarSearch", "Lcom/tencent/mm/plugin/radar/model/NetSceneRadarSearch;", "selectedStatusMap", "Lcom/tencent/mm/plugin/radar/model/RadarManager$ChooseStatus;", "getSelectedStatusMap", "setSelectedStatusMap", "stateTable", "getStateTable", "setStateTable", "status", "Lcom/tencent/mm/plugin/radar/model/RadarManager$Status;", "tempLatestChangeStatTable", "", "Lcom/tencent/mm/plugin/radar/model/RadarManager$LatestChangeStat;", "getTempLatestChangeStatTable", "setTempLatestChangeStatTable", "ticket", "doRadarRelationChain", "", "memList", "Lcom/tencent/mm/protocal/protobuf/RadarChatRoomMember;", "getChooseStatus", "member", "getState", "old", ch.COL_USERNAME, "getStateImpl", "onCreate", "onDestroy", "onLocationGot", "isOk", "onPause", "onRadarMemberReturn", "errType", "", "errCode", "radarMembers", "count", "onRadarRelationChainReturn", "onResume", "onSceneEnd", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "putState", "state", "radarRemove", "reset", "saveLastState", "name", "setChooseStatus", "startRadarSearch", "stop", "stopRadarSearch", "syncStateToLastState", "ChooseStatus", "Companion", "LatestChangeStat", "RadarDelegate", "RadarStatus", "Status", "plugin-radar_release"})
public final class e implements com.tencent.mm.ak.i {
    private static final int ByU = 3000;
    private static final int ByV = 5000;
    private static final int ByW = 1;
    public static final b ByX = new b((byte) 0);
    private static final String TAG = TAG;
    private Location ByI;
    private b ByJ;
    private f ByK = f.Stopped;
    public LinkedList<diz> ByL;
    public Map<String, String> ByM = new LinkedHashMap();
    private Map<String, c.e> ByN = new LinkedHashMap();
    private Map<String, c.e> ByO = new LinkedHashMap();
    public Map<Long, c> ByP = new LinkedHashMap();
    public Map<String, a> ByQ = new LinkedHashMap();
    private final MTimerHandler ByR = new MTimerHandler(new h(this), false);
    private final g ByS = new g();
    private final d ByT;
    private final Context context;
    private String dHx;
    public final b.a gmA = new i(this);
    public com.tencent.mm.modelgeo.d iOv;
    private boolean ifz;
    private final LinkedList<djb> jfV = new LinkedList<>();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/radar/model/RadarManager$ChooseStatus;", "", "(Ljava/lang/String;I)V", "Selected", "UnSelected", "plugin-radar_release"})
    public enum a {
        Selected,
        UnSelected;

        static {
            AppMethodBeat.i(138549);
            AppMethodBeat.o(138549);
        }

        public static a valueOf(String str) {
            AppMethodBeat.i(138551);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(138551);
            return aVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J0\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\nH&J0\u0010\u0010\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\nH&¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarDelegate;", "", "onLocationGot", "", "isOk", "", FirebaseAnalytics.b.LOCATION, "Lcom/tencent/mm/pluginsdk/model/lbs/Location;", "onRadarMemberReturn", "errType", "", "errCode", "radarMembers", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "count", "onRadarRelationChainReturn", "redarChatMember", "Lcom/tencent/mm/protocal/protobuf/RadarChatRoomMember;", "plugin-radar_release"})
    public interface d {
        void a(int i2, int i3, LinkedList<djb> linkedList);

        void b(int i2, int i3, LinkedList<diy> linkedList);

        void sV(boolean z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarStatus;", "", "(Ljava/lang/String;I)V", "SEARCHING", "SEARCH_RETRUN", "RALATIONCHAIN", "RALATIONCHAIN_RETRUN", "CREATING_CHAT", "plugin-radar_release"})
    /* renamed from: com.tencent.mm.plugin.radar.b.e$e  reason: collision with other inner class name */
    public enum EnumC1621e {
        SEARCHING,
        SEARCH_RETRUN,
        RALATIONCHAIN,
        RALATIONCHAIN_RETRUN,
        CREATING_CHAT;

        static {
            AppMethodBeat.i(138556);
            AppMethodBeat.o(138556);
        }

        public static EnumC1621e valueOf(String str) {
            AppMethodBeat.i(138558);
            EnumC1621e eVar = (EnumC1621e) Enum.valueOf(EnumC1621e.class, str);
            AppMethodBeat.o(138558);
            return eVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/radar/model/RadarManager$Status;", "", "(Ljava/lang/String;I)V", "Stopped", "Locating", "RadarSearching", "Waiting", "plugin-radar_release"})
    public enum f {
        Stopped,
        Locating,
        RadarSearching,
        Waiting;

        static {
            AppMethodBeat.i(138559);
            AppMethodBeat.o(138559);
        }

        public static f valueOf(String str) {
            AppMethodBeat.i(138561);
            f fVar = (f) Enum.valueOf(f.class, str);
            AppMethodBeat.o(138561);
            return fVar;
        }
    }

    public e(d dVar, Context context2) {
        p.h(dVar, "delegate");
        p.h(context2, "context");
        AppMethodBeat.i(138581);
        this.ByT = dVar;
        this.context = context2;
        AppMethodBeat.o(138581);
    }

    public static final /* synthetic */ void f(e eVar) {
        AppMethodBeat.i(138584);
        eVar.stop();
        AppMethodBeat.o(138584);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onTimerExpired"})
    static final class h implements MTimerHandler.CallBack {
        final /* synthetic */ e Bzo;

        h(e eVar) {
            this.Bzo = eVar;
        }

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(138564);
            if (!this.Bzo.ifz) {
                this.Bzo.ByK = f.RadarSearching;
                Log.d(e.TAG, "status: %s", this.Bzo.ByK);
                Location location = this.Bzo.ByI;
                if (location == null) {
                    Log.e(e.TAG, "error! location is null!");
                    AppMethodBeat.o(138564);
                } else if (location.gnj()) {
                    Log.e(e.TAG, "error! location is null!");
                    AppMethodBeat.o(138564);
                } else {
                    Log.d(e.TAG, "do once search");
                    e eVar = this.Bzo;
                    float f2 = location.iUY;
                    float f3 = location.iUZ;
                    int i2 = location.accuracy;
                    int i3 = location.dTl;
                    String str = location.mac;
                    p.g(str, "it.mac");
                    String str2 = location.dTn;
                    p.g(str2, "it.cellId");
                    eVar.ByJ = new b(1, f2, f3, i2, i3, str, str2);
                    com.tencent.mm.kernel.g.azz().b(this.Bzo.ByJ);
                    AppMethodBeat.o(138564);
                }
            } else {
                Log.d(e.TAG, "cancel radar searching");
                AppMethodBeat.o(138564);
            }
            return false;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/radar/model/RadarManager$delayRadarRemove$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-radar_release"})
    public static final class g extends MMHandler {
        g() {
        }

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(138563);
            p.h(message, "msg");
            if (message.what == e.ByW) {
                com.tencent.mm.kernel.g.azz().b(new b());
            }
            AppMethodBeat.o(138563);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\n¢\u0006\u0002\b\f"}, hxF = {"<anonymous>", "", "isOk", "fLongitude", "", "fLatitude", "locType", "", "<anonymous parameter 4>", "", "maccuracy", "<anonymous parameter 6>", "onGetLocation"})
    static final class i implements b.a {
        final /* synthetic */ e Bzo;

        i(e eVar) {
            this.Bzo = eVar;
        }

        @Override // com.tencent.mm.modelgeo.b.a
        public final boolean a(boolean z, float f2, float f3, int i2, double d2, double d3) {
            AppMethodBeat.i(138565);
            if (this.Bzo.ifz) {
                Log.d(e.TAG, "cancel location");
                AppMethodBeat.o(138565);
                return false;
            } else if (this.Bzo.ByI != null) {
                AppMethodBeat.o(138565);
                return false;
            } else {
                if (z) {
                    e eVar = this.Bzo;
                    Location unused = this.Bzo.ByI;
                    e.a(eVar, true);
                    o.a(2006, f2, f3, (int) d3);
                    Log.d(e.TAG, "lat:%f lng:%f accuracy:%f", Float.valueOf(f3), Float.valueOf(f2), Double.valueOf(d3));
                    this.Bzo.ByI = new Location(f3, f2, (int) d3, i2, "", "");
                    this.Bzo.ByR.startTimer(0);
                } else {
                    e eVar2 = this.Bzo;
                    Location unused2 = this.Bzo.ByI;
                    e.a(eVar2, false);
                    e.f(this.Bzo);
                }
                AppMethodBeat.o(138565);
                return false;
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/radar/model/RadarManager$LatestChangeStat;", "", "member", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "state", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "(Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;)V", "getMember", "()Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "getState", "()Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "component1", "component2", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "toString", "", "plugin-radar_release"})
    public static final class c {
        public final djb Bzb;
        public final c.e Bzc;

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0020, code lost:
            if (kotlin.g.b.p.j(r3.Bzc, r4.Bzc) != false) goto L_0x0022;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 138555(0x21d3b, float:1.94157E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x0022
                boolean r0 = r4 instanceof com.tencent.mm.plugin.radar.b.e.c
                if (r0 == 0) goto L_0x0027
                com.tencent.mm.plugin.radar.b.e$c r4 = (com.tencent.mm.plugin.radar.b.e.c) r4
                com.tencent.mm.protocal.protobuf.djb r0 = r3.Bzb
                com.tencent.mm.protocal.protobuf.djb r1 = r4.Bzb
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0027
                com.tencent.mm.plugin.radar.b.c$e r0 = r3.Bzc
                com.tencent.mm.plugin.radar.b.c$e r1 = r4.Bzc
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
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.radar.b.e.c.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            int i2 = 0;
            AppMethodBeat.i(138554);
            djb djb = this.Bzb;
            int hashCode = (djb != null ? djb.hashCode() : 0) * 31;
            c.e eVar = this.Bzc;
            if (eVar != null) {
                i2 = eVar.hashCode();
            }
            int i3 = hashCode + i2;
            AppMethodBeat.o(138554);
            return i3;
        }

        public final String toString() {
            AppMethodBeat.i(138553);
            String str = "LatestChangeStat(member=" + this.Bzb + ", state=" + this.Bzc + ")";
            AppMethodBeat.o(138553);
            return str;
        }

        public c(djb djb, c.e eVar) {
            p.h(djb, "member");
            p.h(eVar, "state");
            AppMethodBeat.i(138552);
            this.Bzb = djb;
            this.Bzc = eVar;
            AppMethodBeat.o(138552);
        }
    }

    public final void eHj() {
        AppMethodBeat.i(138566);
        eHk();
        this.ifz = false;
        this.ByI = null;
        this.ByK = f.Stopped;
        this.ByR.stopTimer();
        Log.d(TAG, "start radar");
        if (this.iOv == null) {
            this.iOv = com.tencent.mm.modelgeo.d.bca();
        }
        this.ByK = f.Locating;
        com.tencent.mm.modelgeo.d dVar = this.iOv;
        if (dVar != null) {
            dVar.b(this.gmA);
        }
        Log.d(TAG, "status: %s", this.ByK);
        AppMethodBeat.o(138566);
    }

    public final void eHk() {
        AppMethodBeat.i(138567);
        switch (f.$EnumSwitchMapping$0[this.ByK.ordinal()]) {
            case 1:
                AppMethodBeat.o(138567);
                return;
            case 2:
                stop();
                break;
            case 3:
                if (this.ByJ != null) {
                    stop();
                    com.tencent.mm.kernel.g.azz().a(this.ByJ);
                    eHl();
                    break;
                }
                break;
            case 4:
                stop();
                eHl();
                break;
        }
        Log.d(TAG, "stop radar");
        AppMethodBeat.o(138567);
    }

    private final void eHl() {
        AppMethodBeat.i(138568);
        this.ByS.sendEmptyMessageDelayed(ByW, (long) ByV);
        AppMethodBeat.o(138568);
    }

    public final void onResume() {
        AppMethodBeat.i(138569);
        com.tencent.mm.modelgeo.d dVar = this.iOv;
        if (dVar != null) {
            dVar.b(this.gmA);
            AppMethodBeat.o(138569);
            return;
        }
        AppMethodBeat.o(138569);
    }

    public final void stop() {
        AppMethodBeat.i(138570);
        this.ifz = true;
        this.ByK = f.Stopped;
        this.ByR.stopTimer();
        AppMethodBeat.o(138570);
    }

    private final void a(int i2, int i3, LinkedList<djb> linkedList) {
        AppMethodBeat.i(138571);
        this.ByT.a(i2, i3, linkedList);
        AppMethodBeat.o(138571);
    }

    private final void b(int i2, int i3, LinkedList<diy> linkedList) {
        AppMethodBeat.i(138572);
        this.ByT.b(i2, i3, linkedList);
        AppMethodBeat.o(138572);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        int i4;
        LinkedList<djb> linkedList = null;
        AppMethodBeat.i(138573);
        p.h(qVar, "scene");
        switch (qVar.getType()) {
            case 425:
                if (this.ByJ == qVar) {
                    if (((b) qVar).dJY == 1) {
                        this.ByK = f.Waiting;
                        if (i2 == 0 && i3 == 0) {
                            String str2 = TAG;
                            Object[] objArr = new Object[2];
                            com.tencent.mm.ak.d dVar = ((b) qVar).rr;
                            djd djd = (djd) (dVar != null ? dVar.aYK() : null);
                            if (djd != null) {
                                i4 = djd.gsq;
                            } else {
                                i4 = 0;
                            }
                            objArr[0] = Integer.valueOf(i4);
                            objArr[1] = this.dHx;
                            Log.d(str2, "rader members count: %s ticket: %s", objArr);
                            this.ByR.startTimer((long) ByU);
                            com.tencent.mm.ak.d dVar2 = ((b) qVar).rr;
                            djd djd2 = (djd) (dVar2 != null ? dVar2.aYK() : null);
                            if (djd2 != null) {
                                linkedList = djd2.KGQ;
                            }
                            if (linkedList != null) {
                                Iterator<djb> it = linkedList.iterator();
                                while (it.hasNext()) {
                                    djb next = it.next();
                                    com.tencent.mm.plugin.c.a bqE = com.tencent.mm.plugin.c.a.bqE();
                                    p.g(bqE, "PinAntispam.instance()");
                                    bqE.aTp().mP(next.UserName, next.LRO);
                                }
                            }
                            if (linkedList != null) {
                                this.jfV.clear();
                                this.jfV.addAll(linkedList);
                            }
                            a(i2, i3, this.jfV);
                            Log.d(TAG, "status: %s", this.ByK);
                            AppMethodBeat.o(138573);
                            return;
                        }
                        stop();
                        a(i2, i3, null);
                        AppMethodBeat.o(138573);
                        return;
                    }
                    a(i2, i3, null);
                    AppMethodBeat.o(138573);
                    return;
                }
                break;
            case 602:
                Log.d(TAG, " MMFunc_MMRadarRelationChain ");
                if (i2 != 0 || i3 != 0) {
                    b(i2, i3, null);
                    break;
                } else {
                    com.tencent.mm.bw.a aYK = ((a) qVar).rr.aYK();
                    if (aYK == null) {
                        t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RadarRelationChainResponse");
                        AppMethodBeat.o(138573);
                        throw tVar;
                    }
                    dja dja = (dja) aYK;
                    this.dHx = dja.Bri;
                    if (dja.gsq > 0) {
                        b(i2, i3, dja.KGQ);
                        AppMethodBeat.o(138573);
                        return;
                    }
                    b(i2, i3, null);
                    AppMethodBeat.o(138573);
                    return;
                }
        }
        AppMethodBeat.o(138573);
    }

    public final void a(String str, c.e eVar) {
        AppMethodBeat.i(138574);
        c.e eVar2 = this.ByN.get(str);
        if (!(eVar2 == null || eVar2 == eVar)) {
            this.ByO.put(str, eVar2);
        }
        AppMethodBeat.o(138574);
    }

    public final void b(String str, c.e eVar) {
        AppMethodBeat.i(138575);
        p.h(str, ch.COL_USERNAME);
        p.h(eVar, "state");
        if (!n.aL(str)) {
            a(str, eVar);
            this.ByN.put(str, eVar);
        }
        AppMethodBeat.o(138575);
    }

    public static /* synthetic */ c.e a(e eVar, djb djb) {
        AppMethodBeat.i(138577);
        c.e a2 = eVar.a(djb, false);
        AppMethodBeat.o(138577);
        return a2;
    }

    public final c.e a(djb djb, boolean z) {
        AppMethodBeat.i(138576);
        p.h(djb, "member");
        String str = djb.UserName;
        p.g(str, "member.UserName");
        c.e bX = bX(str, z);
        if (bX == null) {
            String str2 = djb.LuX;
            p.g(str2, "member.EncodeUserName");
            bX = bX(str2, z);
        }
        AppMethodBeat.o(138576);
        return bX;
    }

    public final c.e aKO(String str) {
        AppMethodBeat.i(138578);
        p.h(str, ch.COL_USERNAME);
        c.e bX = bX(str, false);
        AppMethodBeat.o(138578);
        return bX;
    }

    private final c.e bX(String str, boolean z) {
        AppMethodBeat.i(138579);
        if (z) {
            c.e eVar = this.ByO.get(str);
            AppMethodBeat.o(138579);
            return eVar;
        }
        c.e eVar2 = this.ByN.get(str);
        AppMethodBeat.o(138579);
        return eVar2;
    }

    public final void a(djb djb) {
        AppMethodBeat.i(138580);
        if (djb != null) {
            com.tencent.mm.plugin.radar.ui.g gVar = com.tencent.mm.plugin.radar.ui.g.BAY;
            String b2 = com.tencent.mm.plugin.radar.ui.g.b(djb);
            if (this.ByQ.containsKey(b2)) {
                this.ByQ.remove(b2);
                AppMethodBeat.o(138580);
                return;
            }
            this.ByQ.put(b2, a.Selected);
        }
        AppMethodBeat.o(138580);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/radar/model/RadarManager$Companion;", "", "()V", "REMOVE_RADAR_POSITION", "", "RadarRemoveDelay", "RadarTimerInterval", "TAG", "", "plugin-radar_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(138582);
        AppMethodBeat.o(138582);
    }

    public static final /* synthetic */ void a(e eVar, boolean z) {
        AppMethodBeat.i(138583);
        eVar.ByT.sV(z);
        AppMethodBeat.o(138583);
    }
}
