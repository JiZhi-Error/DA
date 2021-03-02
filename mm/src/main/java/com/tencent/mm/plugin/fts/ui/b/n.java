package com.tencent.mm.plugin.fts.ui.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.ak.h;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0004J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0016\u001a\u00020\u0010J\u0006\u0010\u0017\u001a\u00020\u0010J\u000e\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/fts/ui/logic/FTSRedDotLogic;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "currentFTSRedDot", "Lcom/tencent/mm/plugin/fts/ui/logic/FTSEducationRedDot;", "getCurrentFTSRedDot", "()Lcom/tencent/mm/plugin/fts/ui/logic/FTSEducationRedDot;", "setCurrentFTSRedDot", "(Lcom/tencent/mm/plugin/fts/ui/logic/FTSEducationRedDot;)V", "receiver", "Lcom/tencent/mm/plugin/messenger/foundation/api/INewXmlReceived;", "clickRedDot", "", "bizType", "", "getCurrRedDotMsgId", "needShowRedDot", "", "onCreate", "onDestroy", "showRedDot", "ui-fts_release"})
public final class n {
    public static final String TAG = TAG;
    public static m UWV;
    private static final q UWW = a.UWY;
    public static final n UWX = new n();

    static {
        AppMethodBeat.i(258242);
        AppMethodBeat.o(258242);
    }

    private n() {
    }

    public static String getTAG() {
        return TAG;
    }

    public static String hVM() {
        String str;
        m mVar = UWV;
        return (mVar == null || (str = mVar.msgId) == null) ? "" : str;
    }

    public static void a(m mVar) {
        UWV = mVar;
    }

    public static void onCreate() {
        AppMethodBeat.i(258238);
        com.tencent.mm.kernel.b.a ah = g.ah(s.class);
        p.g(ah, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
        ((s) ah).getSysCmdMsgExtension().a("mmsearch_fts_reddot", UWW);
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        String a2 = aAh.azQ().a(ar.a.USERINFO_FTS_MAIN_EDUCATION_RED_DOT_STRING, "");
        if (a2 != null) {
            if (!(a2.length() > 0)) {
                a2 = null;
            }
            if (a2 != null) {
                m mVar = new m();
                p.h(a2, "value");
                try {
                    i iVar = new i(a2);
                    String optString = iVar.optString("msgId", "");
                    p.g(optString, "json.optString(\"msgId\", \"\")");
                    mVar.msgId = optString;
                    mVar.UWR = iVar.optLong("h5Version", 0);
                    mVar.UWS = iVar.optLong("exposeExpiredTime", 0);
                    mVar.UWT = iVar.optLong("bizType", 0);
                    mVar.UWU = iVar.optInt("redDotAction", 0);
                    mVar.Rrq = iVar.optLong("exposeTimestamp", 0);
                } catch (Exception e2) {
                }
                Log.i(TAG, "load from saveStr:".concat(String.valueOf(a2)));
                UWV = mVar;
                AppMethodBeat.o(258238);
                return;
            }
        }
        AppMethodBeat.o(258238);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032F\u0010\u0005\u001aB\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004* \u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00070\u00062\u000e\u0010\b\u001a\n \u0004*\u0004\u0018\u00010\t0\tH\n¢\u0006\u0002\b\n"}, hxF = {"<anonymous>", "", "subType", "", "kotlin.jvm.PlatformType", "values", "", "", "addMsgInfo", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;", "onNewXmlReceived"})
    static final class a implements q {
        public static final a UWY = new a();

        static {
            AppMethodBeat.i(258237);
            AppMethodBeat.o(258237);
        }

        a() {
        }

        @Override // com.tencent.mm.plugin.messenger.foundation.a.q
        public final void onNewXmlReceived(String str, Map<String, String> map, h.a aVar) {
            AppMethodBeat.i(258236);
            if (p.j(str, "mmsearch_fts_reddot")) {
                n nVar = n.UWX;
                m mVar = new m();
                if (map != null) {
                    mVar.jjS = Util.safeParseInt(map.get(".sysmsg.mmsearch_fts_reddot.android_cli_version"));
                    String safeFormatString = Util.safeFormatString(map.get(".sysmsg.mmsearch_fts_reddot.msgid"), new Object[0]);
                    p.g(safeFormatString, "Util.safeFormatString(va…S_MAIN_REDPOINT}.msgid\"])");
                    p.h(safeFormatString, "<set-?>");
                    mVar.msgId = safeFormatString;
                    mVar.UWR = Util.safeParseLong(map.get(".sysmsg.mmsearch_fts_reddot.h5_version"));
                    mVar.UWT = Util.safeParseLong(map.get(".sysmsg.mmsearch_fts_reddot.biz_type"));
                    mVar.UWS = Util.safeParseLong(map.get(".sysmsg.mmsearch_fts_reddot.expose_expire_time"));
                    mVar.UWU = Util.safeParseInt(map.get(".sysmsg.mmsearch_fts_reddot.reddot_action"));
                }
                String hVL = mVar.hVL();
                e aAh = g.aAh();
                p.g(aAh, "MMKernel.storage()");
                aAh.azQ().set(ar.a.USERINFO_FTS_MAIN_EDUCATION_RED_DOT_STRING, hVL);
                n nVar2 = n.UWX;
                Log.i(n.getTAG(), "receive reddot ".concat(String.valueOf(hVL)));
                n.a(mVar);
            }
            AppMethodBeat.o(258236);
        }
    }

    public static boolean RO(long j2) {
        AppMethodBeat.i(258239);
        m mVar = UWV;
        if (mVar != null) {
            boolean RO = mVar.RO(j2);
            AppMethodBeat.o(258239);
            return RO;
        }
        AppMethodBeat.o(258239);
        return false;
    }

    public static void RP(long j2) {
        AppMethodBeat.i(258240);
        m mVar = UWV;
        if (mVar == null) {
            AppMethodBeat.o(258240);
        } else if (!mVar.RO(j2) || mVar.Rrq != 0) {
            Log.i(mVar.TAG, "showRedDot not save currentBizType:" + mVar.UWT + " checkBizType:" + j2 + " exposeTimestamp:" + mVar.Rrq + " redDotAction:" + mVar.UWU);
            AppMethodBeat.o(258240);
        } else {
            mVar.Rrq = cl.aWA();
            String hVL = mVar.hVL();
            e aAh = g.aAh();
            p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_FTS_MAIN_EDUCATION_RED_DOT_STRING, hVL);
            Log.i(mVar.TAG, "showRedDot save reddot ".concat(String.valueOf(hVL)));
            AppMethodBeat.o(258240);
        }
    }

    public static void onDestroy() {
        AppMethodBeat.i(258241);
        UWV = null;
        com.tencent.mm.kernel.b.a ah = g.ah(s.class);
        p.g(ah, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
        ((s) ah).getSysCmdMsgExtension().b("mmsearch_fts_reddot", UWW);
        AppMethodBeat.o(258241);
    }
}
