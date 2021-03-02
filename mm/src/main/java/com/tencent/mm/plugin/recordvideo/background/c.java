package com.tencent.mm.plugin.recordvideo.background;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.g.c.ha;
import com.tencent.mm.plugin.appbrand.jsapi.i.m;
import com.tencent.mm.protocal.protobuf.aio;
import com.tencent.mm.protocal.protobuf.ald;
import com.tencent.mm.protocal.protobuf.dlg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClientBase;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 ;2\u00020\u0001:\u0002;<B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u00104\u001a\u00020\nJ\b\u00105\u001a\u000206H\u0014J\b\u00107\u001a\u0004\u0018\u000108J\u0006\u00109\u001a\u00020:R\u001c\u0010\u0003\u001a\u00020\u00048FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u00020\n8FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u00020\n8FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001c\u0010\u0012\u001a\u00020\n8FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001c\u0010\u0015\u001a\u00020\n8FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001c\u0010\u0018\u001a\u00020\n8FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\u001c\u0010\u001b\u001a\u00020\u001c8FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u00020\"8FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010)\u001a\u00020(2\u0006\u0010'\u001a\u00020(8F@FX\u000e¢\u0006\f\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u0010/\u001a\u00020.2\u0006\u0010'\u001a\u00020.8F@FX\u000e¢\u0006\f\u001a\u0004\b0\u00101\"\u0004\b2\u00103¨\u0006="}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "Lcom/tencent/mm/autogen/table/BaseVideoEditInfo;", "()V", "editorProtoData", "Lcom/tencent/mm/protocal/protobuf/EditorProtoData;", "getEditorProtoData", "()Lcom/tencent/mm/protocal/protobuf/EditorProtoData;", "setEditorProtoData", "(Lcom/tencent/mm/protocal/protobuf/EditorProtoData;)V", "fromChatting", "", "getFromChatting", "()Z", "setFromChatting", "(Z)V", "fromFav", "getFromFav", "setFromFav", "fromGame", "getFromGame", "setFromGame", "fromSns", "getFromSns", "setFromSns", "fromStory", "getFromStory", "setFromStory", ch.COL_LOCALID, "", "getLocalId", "()J", "setLocalId", "(J)V", FirebaseAnalytics.b.LOCATION, "Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;", m.NAME, "()Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;", "setLocation", "(Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;)V", "value", "", "mixRetryTime", "getMixRetryTime", "()I", "setMixRetryTime", "(I)V", "", "taskId", "getTaskId", "()Ljava/lang/String;", "setTaskId", "(Ljava/lang/String;)V", "checkMix", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getExtraConfig", "Lcom/tencent/mm/protocal/protobuf/ExtraConfig;", "getReportInfo", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordMediaReportInfo;", "Companion", "STATUS", "plugin-recordvideo_release"})
public final class c extends ha {
    public static final a BKh = new a((byte) 0);
    private static final String[] INDEX_CREATE = ha.INDEX_CREATE;
    private static final String TABLE = TABLE;
    private static final IAutoDBItem.MAutoDBInfo iBg = ha.ajs();
    private dlg BKf = new dlg();
    private aio BKg = new aio();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R9\u0010\u0003\u001a(\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005 \u0006*\u0014\u0012\u000e\b\u0001\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00040\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\n\u001a\n \u0006*\u0004\u0018\u00010\u000b0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData$Companion;", "", "()V", "INDEX_CREATE", "", "", "kotlin.jvm.PlatformType", "getINDEX_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "INFO", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getINFO", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "TABLE", "getTABLE", "()Ljava/lang/String;", "plugin-recordvideo_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public c() {
        AppMethodBeat.i(75181);
        AppMethodBeat.o(75181);
    }

    static {
        AppMethodBeat.i(75182);
        AppMethodBeat.o(75182);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData$STATUS;", "", "()V", "FAIL", "", "getFAIL", "()I", TMAssistantDownloadSDKClientBase.CONNTECTSTATE_INIT, "getINIT", "OK", "getOK", "plugin-recordvideo_release"})
    public static final class b {
        private static final int BKi = 1;
        private static final int BKj = 3;
        public static final b BKk = new b();
        private static final int OK = 2;

        static {
            AppMethodBeat.i(75175);
            AppMethodBeat.o(75175);
        }

        private b() {
        }

        public static int eIO() {
            return BKi;
        }

        public static int bTk() {
            return OK;
        }

        public static int eIP() {
            return BKj;
        }
    }

    public final dlg eIH() {
        AppMethodBeat.i(75176);
        dlg dlg = new dlg();
        try {
            dlg.parseFrom(this.field_location);
        } catch (Exception e2) {
            Log.printDebugStack("safeParser", "", e2);
            dlg = null;
        }
        dlg dlg2 = dlg;
        if (dlg2 == null) {
            dlg2 = new dlg();
        }
        AppMethodBeat.o(75176);
        return dlg2;
    }

    public final String bjl() {
        AppMethodBeat.i(75177);
        String str = this.field_taskId;
        p.g(str, "field_taskId");
        AppMethodBeat.o(75177);
        return str;
    }

    public final aio eII() {
        AppMethodBeat.i(75178);
        aio aio = new aio();
        try {
            aio.parseFrom(this.field_baseItemData);
        } catch (Exception e2) {
            Log.printDebugStack("safeParser", "", e2);
        }
        AppMethodBeat.o(75178);
        return aio;
    }

    public final boolean eIJ() {
        return this.field_fromScene == 3;
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        AppMethodBeat.i(75179);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = iBg;
        p.g(mAutoDBInfo, "INFO");
        AppMethodBeat.o(75179);
        return mAutoDBInfo;
    }

    public final ald eIK() {
        AppMethodBeat.i(75180);
        ald ald = new ald();
        try {
            ald.parseFrom(this.field_extraConfig);
        } catch (Exception e2) {
            Log.printDebugStack("safeParser", "", e2);
            ald = null;
        }
        ald ald2 = ald;
        AppMethodBeat.o(75180);
        return ald2;
    }
}
