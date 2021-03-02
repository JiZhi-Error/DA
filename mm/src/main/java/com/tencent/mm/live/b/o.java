package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.at;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0015\u0018\u0000 \u00052\u00020\u0001:\u0013\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/live/model/LiveConstants;", "", "()V", "AnchorErrStastus", "ChatRoomLiveFlag", "Companion", "Confetti", "FinderLiveMsgType", "FinderLiveMsgTypeExtraKey", "LiveConfigBitSet", "LiveMsgType", "LiveStatus", "Log", "MMKV", "MenuItem", "RequestCode", "TestMMKV", "ThresHold", "TimeOut", "TrtcRole", "UIRouter", "emMMFinderLiveScene", "plugin-logic_release"})
public final class o {
    private static final String hGi = (HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e2l) + "/security/readtemplate?t=weixin_report/w_type&scene=%d&liveid=%s&liveidentityid=%s&liveroomid=%s");
    private static final String hGj = (HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e2f) + "/cgi-bin/mmsupport-bin/newreadtemplate?t=live_forensic/index");
    private static final int hGk = 5;
    public static final a hGl = new a((byte) 0);

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006¨\u0006\r"}, hxF = {"Lcom/tencent/mm/live/model/LiveConstants$Companion;", "", "()V", "ExposeH5Url", "", "getExposeH5Url", "()Ljava/lang/String;", "SHARE_RETRY_MAX_COUNT", "", "getSHARE_RETRY_MAX_COUNT", "()I", "VISITOR_GUIDE_URL", "getVISITOR_GUIDE_URL", "plugin-logic_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(207607);
        AppMethodBeat.o(207607);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/live/model/LiveConstants$UIRouter;", "", "()V", "ROUTER_TO_ANCHOR_LIVE", "", "getROUTER_TO_ANCHOR_LIVE", "()I", "ROUTER_TO_REPLAY_LIVE", "getROUTER_TO_REPLAY_LIVE", "ROUTER_TO_VISITOR_LIVE", "getROUTER_TO_VISITOR_LIVE", "plugin-logic_release"})
    public static final class k {
        private static final int hHk = 0;
        private static final int hHl = 1;
        private static final int hHm = 2;
        public static final k hHn = new k();

        static {
            AppMethodBeat.i(207604);
            AppMethodBeat.o(207604);
        }

        private k() {
        }

        public static int aFM() {
            return hHk;
        }

        public static int aFN() {
            return hHl;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, hxF = {"Lcom/tencent/mm/live/model/LiveConstants$TrtcRole;", "", "()V", "TRTC_ROLE_ANCHOR", "", "getTRTC_ROLE_ANCHOR", "()I", "TRTC_ROLE_AUDIENCE", "getTRTC_ROLE_AUDIENCE", "plugin-logic_release"})
    public static final class j {
        private static final int hHh = 0;
        private static final int hHi = 1;
        public static final j hHj = new j();

        static {
            AppMethodBeat.i(207603);
            AppMethodBeat.o(207603);
        }

        private j() {
        }

        public static int aFK() {
            return hHh;
        }

        public static int aFL() {
            return hHi;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/live/model/LiveConstants$MenuItem;", "", "()V", "MENU_BAN_COMMENT", "", "getMENU_BAN_COMMENT", "()I", "MENU_QUIT_LIVE", "getMENU_QUIT_LIVE", "MENU_QUIT_LIVE_BUT_NOT_CLOSE", "getMENU_QUIT_LIVE_BUT_NOT_CLOSE", "plugin-logic_release"})
    public static final class g {
        private static final int hGX = 0;
        private static final int hGY = 1;
        private static final int hGZ = 2;
        public static final g hHa = new g();

        static {
            AppMethodBeat.i(207600);
            AppMethodBeat.o(207600);
        }

        private g() {
        }

        public static int aFE() {
            return hGX;
        }

        public static int aFF() {
            return hGY;
        }

        public static int aFG() {
            return hGZ;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, hxF = {"Lcom/tencent/mm/live/model/LiveConstants$Confetti;", "", "()V", "CONFETTI_SIZE", "", "getCONFETTI_SIZE", "()I", "HIGH_LIGHT_CONFETTI_SIZE", "getHIGH_LIGHT_CONFETTI_SIZE", "plugin-logic_release"})
    public static final class b {
        private static final int hGm = at.fromDPToPix(MMApplicationContext.getContext(), 40);
        private static final int hGn = at.fromDPToPix(MMApplicationContext.getContext(), 48);
        public static final b hGo = new b();

        static {
            AppMethodBeat.i(207595);
            AppMethodBeat.o(207595);
        }

        private b() {
        }

        public static int aFl() {
            return hGm;
        }

        public static int aFm() {
            return hGn;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, hxF = {"Lcom/tencent/mm/live/model/LiveConstants$TimeOut;", "", "()V", "GET_MESSAGE_TIMEOUT", "", "getGET_MESSAGE_TIMEOUT", "()J", "REPLAY_TIMEOUT", "getREPLAY_TIMEOUT", "plugin-logic_release"})
    public static final class i {
        private static final long hHe = hHe;
        private static final long hHf = hHf;
        public static final i hHg = new i();

        static {
            AppMethodBeat.i(207602);
            AppMethodBeat.o(207602);
        }

        private i() {
        }

        public static long aFJ() {
            return hHf;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/live/model/LiveConstants$LiveStatus;", "", "()V", "MM_LIVE_STATUS_END", "", "getMM_LIVE_STATUS_END", "()I", "MM_LIVE_STATUS_OPEN", "getMM_LIVE_STATUS_OPEN", "MM_LIVE_STATUS_REPLAY", "getMM_LIVE_STATUS_REPLAY", "MM_LIVE_STATUS_REPLAY_END", "getMM_LIVE_STATUS_REPLAY_END", "MM_LIVE_STATUS_REPLAY_SEND_MSG", "getMM_LIVE_STATUS_REPLAY_SEND_MSG", "plugin-logic_release"})
    public static final class e {
        private static final int hGM = 1;
        private static final int hGN = 2;
        private static final int hGO = 3;
        private static final int hGP = 4;
        private static final int hGQ = 5;
        public static final e hGR = new e();

        static {
            AppMethodBeat.i(207598);
            AppMethodBeat.o(207598);
        }

        private e() {
        }

        public static int aFA() {
            return hGP;
        }

        public static int aFB() {
            return hGQ;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/live/model/LiveConstants$LiveMsgType;", "", "()V", "MM_LIVE_ANNOUNCEMENT", "", "getMM_LIVE_ANNOUNCEMENT", "()I", "MM_LIVE_SYS_MSG", "getMM_LIVE_SYS_MSG", "MM_LIVE_TEXT_MSG", "getMM_LIVE_TEXT_MSG", "plugin-logic_release"})
    public static final class d {
        private static final int hGI = 1;
        private static final int hGJ = 10001;
        private static final int hGK = 2;
        public static final d hGL = new d();

        static {
            AppMethodBeat.i(207597);
            AppMethodBeat.o(207597);
        }

        private d() {
        }

        public static int aFy() {
            return hGI;
        }

        public static int aFz() {
            return hGJ;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b'\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0014\u0010\u0013\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0014\u0010\u0015\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006R\u0014\u0010\u0017\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0006R\u0014\u0010\u0019\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0006R\u0014\u0010\u001b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0006R\u0014\u0010\u001d\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0006R\u0014\u0010\u001f\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0006R\u0014\u0010!\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0006R\u0014\u0010#\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0006R\u0014\u0010%\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0006R\u0014\u0010'\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0006R\u0014\u0010)\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0006¨\u0006+"}, hxF = {"Lcom/tencent/mm/live/model/LiveConstants$FinderLiveMsgType;", "", "()V", "MMFinder_LiveMsg_Allow_Comment_Single", "", "getMMFinder_LiveMsg_Allow_Comment_Single", "()I", "MMFinder_LiveMsg_Ban_Comment", "getMMFinder_LiveMsg_Ban_Comment", "MMFinder_LiveMsg_Ban_Comment_Single", "getMMFinder_LiveMsg_Ban_Comment_Single", "MMFinder_LiveMsg_End_Promote_Product", "getMMFinder_LiveMsg_End_Promote_Product", "MMFinder_LiveMsg_Join_live", "getMMFinder_LiveMsg_Join_live", "MMFinder_LiveMsg_LOCAL_ANNOUCEMENT", "getMMFinder_LiveMsg_LOCAL_ANNOUCEMENT", "MMFinder_LiveMsg_LOCAL_Location", "getMMFinder_LiveMsg_LOCAL_Location", "MMFinder_LiveMsg_LOCAL_TOP_COMMENT", "getMMFinder_LiveMsg_LOCAL_TOP_COMMENT", "MMFinder_LiveMsg_Promote_Product", "getMMFinder_LiveMsg_Promote_Product", "MMFinder_LiveMsg_Type_AcceptPk", "getMMFinder_LiveMsg_Type_AcceptPk", "MMFinder_LiveMsg_Type_AudienceShopping", "getMMFinder_LiveMsg_Type_AudienceShopping", "MMFinder_LiveMsg_Type_CloseLive", "getMMFinder_LiveMsg_Type_CloseLive", "MMFinder_LiveMsg_Type_ClosePk", "getMMFinder_LiveMsg_Type_ClosePk", "MMFinder_LiveMsg_Type_Comment", "getMMFinder_LiveMsg_Type_Comment", "MMFinder_LiveMsg_Type_Like", "getMMFinder_LiveMsg_Type_Like", "MMFinder_LiveMsg_Type_Live_Like", "getMMFinder_LiveMsg_Type_Live_Like", "MMFinder_LiveMsg_Type_Live_Reward", "getMMFinder_LiveMsg_Type_Live_Reward", "MMFinder_LiveMsg_Type_Sys", "getMMFinder_LiveMsg_Type_Sys", "MMFinder_LiveMsg_Type_Top_Like", "getMMFinder_LiveMsg_Type_Top_Like", "plugin-logic_release"})
    public static final class c {
        private static final int hGA = hGA;
        private static final int hGB = hGB;
        private static final int hGC = 10011;
        private static final int hGD = hGD;
        private static final int hGE = hGE;
        private static final int hGF = hGF;
        private static final int hGG = hGG;
        public static final c hGH = new c();
        private static final int hGp = 1;
        private static final int hGq = 2;
        private static final int hGr = 3;
        private static final int hGs = 10001;
        private static final int hGt = 10002;
        private static final int hGu = 10003;
        private static final int hGv = 10004;
        private static final int hGw = hGw;
        private static final int hGx = hGx;
        private static final int hGy = 10007;
        private static final int hGz = hGz;
        private static final int vxH = vxH;

        static {
            AppMethodBeat.i(207596);
            AppMethodBeat.o(207596);
        }

        private c() {
        }

        public static int aFn() {
            return hGp;
        }

        public static int aFo() {
            return hGs;
        }

        public static int aFp() {
            return hGw;
        }

        public static int aFq() {
            return hGx;
        }

        public static int aFr() {
            return hGy;
        }

        public static int aFs() {
            return hGz;
        }

        public static int aFt() {
            return hGA;
        }

        public static int aFu() {
            return hGB;
        }

        public static int aFv() {
            return hGD;
        }

        public static int aFw() {
            return hGF;
        }

        public static int aFx() {
            return hGG;
        }

        public static int caa() {
            return vxH;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, hxF = {"Lcom/tencent/mm/live/model/LiveConstants$emMMFinderLiveScene;", "", "()V", "MMFinderLive_Scene_Author", "", "getMMFinderLive_Scene_Author", "()I", "MMFinderLive_Scene_Viewer", "getMMFinderLive_Scene_Viewer", "plugin-logic_release"})
    public static final class m {
        private static final int hHA = 2;
        public static final m hHB = new m();
        private static final int hHz = 1;

        static {
            AppMethodBeat.i(207606);
            AppMethodBeat.o(207606);
        }

        private m() {
        }

        public static int aFV() {
            return hHz;
        }

        public static int aFW() {
            return hHA;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006¨\u0006\r"}, hxF = {"Lcom/tencent/mm/live/model/LiveConstants$MMKV;", "", "()V", "ANCHOR_VERIFY", "", "getANCHOR_VERIFY", "()Ljava/lang/String;", "KEY_ANCHOR_LIVE_ID", "getKEY_ANCHOR_LIVE_ID", "KEY_VISITOR_MIC_DIALOG", "getKEY_VISITOR_MIC_DIALOG", "TAG_LIVE_CORE", "getTAG_LIVE_CORE", "plugin-logic_release"})
    public static final class f {
        private static final String hGS = hGS;
        private static final String hGT = hGT;
        private static final String hGU = hGU;
        private static final String hGV = hGV;
        public static final f hGW = new f();

        static {
            AppMethodBeat.i(207599);
            AppMethodBeat.o(207599);
        }

        private f() {
        }

        public static String aFC() {
            return hGS;
        }

        public static String aFD() {
            return hGU;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, hxF = {"Lcom/tencent/mm/live/model/LiveConstants$TestMMKV;", "", "()V", "TEST_MMKV_LIVE_FACE_VERIFY", "", "getTEST_MMKV_LIVE_FACE_VERIFY", "()Ljava/lang/String;", "TEST_MMKV_LIVE_SKIP_MOBILE_VERIFY", "getTEST_MMKV_LIVE_SKIP_MOBILE_VERIFY", "plugin-logic_release"})
    public static final class h {
        private static final String hHb = hHb;
        private static final String hHc = hHc;
        public static final h hHd = new h();

        static {
            AppMethodBeat.i(207601);
            AppMethodBeat.o(207601);
        }

        private h() {
        }

        public static String aFH() {
            return hHb;
        }

        public static String aFI() {
            return hHc;
        }
    }
}
