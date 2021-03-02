package com.tencent.mm.game.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.eq;
import com.tencent.mm.sdk.platformtools.Log;
import java.net.URLEncoder;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/game/report/Kv20488;", "", "()V", "Companion", "report-api_release"})
public final class c {
    public static final a hhl = new a((byte) 0);

    static {
        AppMethodBeat.i(190337);
        AppMethodBeat.o(190337);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u001c\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u0004J6\u00103\u001a\u0002042\u0006\u00105\u001a\u00020$2\u0006\u00106\u001a\u00020\u00042\u0006\u00107\u001a\u00020$2\u0006\u00108\u001a\u00020\u00042\u0006\u00109\u001a\u00020$2\u0006\u0010:\u001a\u00020\u0004J>\u0010;\u001a\u0002042\u0006\u00105\u001a\u00020$2\u0006\u00106\u001a\u00020\u00042\u0006\u00107\u001a\u00020$2\u0006\u00108\u001a\u00020\u00042\u0006\u00109\u001a\u00020$2\u0006\u00101\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\u0004J[\u0010<\u001a\u0002042\u0006\u0010=\u001a\u00020\u00182\u0006\u00101\u001a\u00020\u00042\u0006\u00105\u001a\u00020$2\u0006\u00106\u001a\u00020\u00042\u0006\u00107\u001a\u00020$2\u0006\u00108\u001a\u00020\u00042\u0006\u00109\u001a\u00020$2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u0018¢\u0006\u0002\u0010@JJ\u0010A\u001a\u0002042\u0006\u0010=\u001a\u00020\u00182\u0006\u00101\u001a\u00020\u00042\u0006\u00105\u001a\u00020$2\u0006\u00106\u001a\u00020\u00042\u0006\u00107\u001a\u00020$2\u0006\u00108\u001a\u00020\u00042\u0006\u00109\u001a\u00020$2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010$Jb\u0010B\u001a\u0002042\u0006\u0010=\u001a\u00020\u00182\u0006\u00101\u001a\u00020\u00042\u0006\u0010C\u001a\u00020\u00182\u0006\u00105\u001a\u00020$2\u0006\u00106\u001a\u00020\u00042\u0006\u00107\u001a\u00020$2\u0006\u00108\u001a\u00020\u00042\u0006\u00109\u001a\u00020$2\u0006\u0010D\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u00042\n\b\u0002\u0010>\u001a\u0004\u0018\u00010$J\u0016\u0010E\u001a\u0002042\u0006\u0010C\u001a\u00020\u00182\u0006\u00102\u001a\u00020\u0004J\u000e\u0010F\u001a\u0002042\u0006\u00102\u001a\u00020\u0004J\u0006\u0010G\u001a\u000204J\u0016\u0010H\u001a\u0002042\u0006\u0010I\u001a\u00020$2\u0006\u00102\u001a\u00020\u0004J.\u0010J\u001a\u0002042\u0006\u0010=\u001a\u00020\u00182\u0006\u0010C\u001a\u00020\u00182\u0006\u0010K\u001a\u00020$2\u0006\u0010L\u001a\u00020\u00182\u0006\u00102\u001a\u00020\u0004J.\u0010M\u001a\u0002042\u0006\u0010=\u001a\u00020\u00182\u0006\u0010C\u001a\u00020\u00182\u0006\u0010K\u001a\u00020$2\u0006\u0010L\u001a\u00020\u00182\u0006\u00102\u001a\u00020\u0004J.\u0010N\u001a\u0002042\u0006\u0010=\u001a\u00020\u00182\u0006\u0010C\u001a\u00020\u00182\u0006\u0010K\u001a\u00020$2\u0006\u0010L\u001a\u00020\u00182\u0006\u00102\u001a\u00020\u0004J\u000e\u0010O\u001a\u0002042\u0006\u00102\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0018XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0018XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0018XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0018XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0018XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$XT¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006P"}, hxF = {"Lcom/tencent/mm/game/report/Kv20488$Companion;", "", "()V", "ACCOUNT_TYPE_GAME", "", "ACCOUNT_TYPE_WECHAT_GAME", "ACTION_CLICK", "ACTION_CLICK_CANCEL", "ACTION_CONFIRM_ADD_BLACKLIST", "ACTION_CONFIRM_REMOVE_BLACKLIST", "ACTION_DELETE", "ACTION_DIALOG_CANCEL", "ACTION_EXPOSURE", "ACTION_JUMP_APPBRAND", "ACTION_JUMP_H5", "ACTION_JUMP_NATIVE", "ACTION_JUMP_URL", "ACTION_LEFT_SLIDE_OR_LONG_PRESS", "ACTION_SEND_SUCCESS", "ATTACH_ITEM_GIFT", "ATTACH_ITEM_LOCATION", "ATTACH_ITEM_PHOTO", "ATTACH_ITEM_VIDEO", "RED_DOT_TYPE_AVATAR", "", "RED_DOT_TYPE_AVATAR_AND_DOT", "RED_DOT_TYPE_EMPTY", "RED_DOT_TYPE_ICON", "RED_DOT_TYPE_NEW", "RED_DOT_TYPE_NORMAL", "RED_DOT_TYPE_NUMBER_DOT", "SCENEID_BOTTOM_TAB", "SCENEID_CHATTING", "SCENEID_CHATTING_DETAIL", "SCENEID_CONVERSATION_LIST", "TAG", "", "UIAREA_BOTTOM_TAB", "UIAREA_CHATTING", "UIAREA_CHATTING_DETAIL", "UIAREA_CHATTING_PANEL", "UIAREA_CONVERSATION_FUNCTION_BAR", "UIAREA_CONVERSATION_LIST", "UIAREA_EXPOSURE", "createReportStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/GameLifeSessionStruct;", "sceneId", "uiArea", "positionId", "actionId", "sourceId", "reportAttachItemClick", "", "sessionId", "fromAccountType", "fromUsername", "toAccountType", "toUsername", "serName", "reportAttachItemJump", "reportChattingDetailUIItem", "pos", "actionStatus", "roleType", "(IJLjava/lang/String;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "reportChattingItem", "reportConversationItem", "totalNum", "sessionType", "reportConversationLoadInitial", "reportConversationUIExposure", "reportEnterChattingDetailUI", "reportEnterGameTabHome", "defaultTab", "reportGameTabItemClicked", "tabKey", "redDotType", "reportGameTabItemExposure", "reportGameWeappTabClicked", "reportSelfProfileClick", "report-api_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void t(String str, long j2) {
            AppMethodBeat.i(190330);
            p.h(str, "defaultTab");
            eq a2 = a(1, 101, 0, 1, j2);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("default_tab", str);
            a2.rQ(URLEncoder.encode(jSONObject.toString()));
            a2.bfK();
            AppMethodBeat.o(190330);
        }

        public static void a(int i2, int i3, String str, int i4, long j2) {
            AppMethodBeat.i(190331);
            p.h(str, "tabKey");
            eq a2 = a(1, 101, (long) i2, 1, j2);
            a2.mZ((long) i3);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("red_dot", i4);
            jSONObject.put("tab_key", str);
            a2.rQ(URLEncoder.encode(jSONObject.toString()));
            a2.bfK();
            AppMethodBeat.o(190331);
        }

        public static /* synthetic */ void a(int i2, long j2, int i3, String str, long j3, String str2, long j4, String str3, long j5, long j6) {
            AppMethodBeat.i(190333);
            a(i2, j2, i3, str, j3, str2, j4, str3, j5, j6, null);
            AppMethodBeat.o(190333);
        }

        public static void a(int i2, long j2, int i3, String str, long j3, String str2, long j4, String str3, long j5, long j6, String str4) {
            AppMethodBeat.i(190332);
            p.h(str, "sessionId");
            p.h(str2, "fromUsername");
            p.h(str3, "toUsername");
            eq a2 = a(2, 202, (long) i2, j2, j6);
            a2.mZ((long) i3);
            a2.rP(str);
            a2.mX(j3);
            a2.rN(str2);
            a2.mY(j4);
            a2.rO(str3);
            a2.rM(str4);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("session_type", j5);
            a2.rQ(URLEncoder.encode(jSONObject.toString()));
            Log.d("Report.Kv20488", "vir:" + a2.abW());
            a2.bfK();
            AppMethodBeat.o(190332);
        }

        public static void a(String str, long j2, String str2, long j3, String str3, long j4) {
            AppMethodBeat.i(190334);
            p.h(str, "sessionId");
            p.h(str2, "fromUsername");
            p.h(str3, "toUsername");
            eq a2 = a(3, 302, 3, j4, 301);
            a2.rP(str);
            a2.mX(j2);
            a2.rN(str2);
            a2.mY(j3);
            a2.rO(str3);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ser_name", 4L);
            a2.rQ(URLEncoder.encode(jSONObject.toString()));
            a2.bfK();
            AppMethodBeat.o(190334);
        }

        public static void a(int i2, long j2, String str, long j3, String str2, long j4, String str3, String str4) {
            AppMethodBeat.i(190335);
            p.h(str, "sessionId");
            p.h(str2, "fromUsername");
            p.h(str3, "toUsername");
            eq a2 = a(3, 301, (long) i2, j2, 301);
            a2.rP(str);
            a2.mX(j3);
            a2.rN(str2);
            a2.mY(j4);
            a2.rO(str3);
            a2.rM(str4);
            a2.bfK();
            AppMethodBeat.o(190335);
        }

        public static eq a(long j2, long j3, long j4, long j5, long j6) {
            AppMethodBeat.i(190336);
            eq eqVar = new eq();
            eqVar.mS(j2);
            eqVar.mT(j3);
            eqVar.mU(j4);
            eqVar.mV(j5);
            eqVar.mW(j6);
            AppMethodBeat.o(190336);
            return eqVar;
        }
    }
}
