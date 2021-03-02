package com.tencent.mm.plugin.multitalk.d;

import android.graphics.Paint;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.q;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.pb.common.b.a.a.a;
import com.tencent.wecall.talkroom.model.TalkRoom;
import com.tencent.wecall.talkroom.model.c;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\b\u0010\u0007\u001a\u00020\u0006H\u0007J\b\u0010\b\u001a\u00020\u0006H\u0007J\n\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0007J\n\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0007J\b\u0010\u000e\u001a\u00020\u000bH\u0007J\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0004H\u0007J\b\u0010\u0011\u001a\u00020\u000bH\u0007J\u0016\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0004J\u0018\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0006\u0010\u001a\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/utils/MultitalkUtils;", "", "()V", "TAG", "", "canReceiveScreenCast", "", "checkMultitalkBlackBoardProjectCanUse", "checkMultitalkScreenProjectCanUse", "getLocalConfigNavPopWording", "getMemberId", "", ch.COL_USERNAME, "getMulitalkMemberListSizeWording", "getMultitalkMaxLimitedNumber", "getMultitalkScreenCastTitle", "getMultitalkWaitingAcceptWording", "getProjectFpsSetting", "getScreenCastTitleContent", "context", "Landroid/content/Context;", "nickName", "getTextWidth", "content", "textPix", "", "screenCastUseHW", "plugin-multitalk_release"})
public final class e {
    public static final e zZc = new e();

    static {
        AppMethodBeat.i(178995);
        AppMethodBeat.o(178995);
    }

    private e() {
    }

    public static final int epZ() {
        AppMethodBeat.i(178993);
        int a2 = ((b) g.af(b.class)).a(b.a.clicfg_multitalk_max_limited_number, e.b.JSF);
        AppMethodBeat.o(178993);
        return a2;
    }

    public static final boolean eqa() {
        AppMethodBeat.i(240098);
        switch (ae.gKE.gHl) {
            case -1:
                if (BuildInfo.IS_FLAVOR_RED || BuildInfo.DEBUG) {
                    AppMethodBeat.o(240098);
                    return true;
                }
                boolean a2 = ((b) g.af(b.class)).a(b.a.clicfg_multitalk_screen_project_supported, false);
                AppMethodBeat.o(240098);
                return a2;
            case 0:
            default:
                boolean a3 = ((b) g.af(b.class)).a(b.a.clicfg_multitalk_screen_project_supported, false);
                AppMethodBeat.o(240098);
                return a3;
            case 1:
                AppMethodBeat.o(240098);
                return true;
            case 2:
                AppMethodBeat.o(240098);
                return false;
        }
    }

    public static final boolean eqb() {
        AppMethodBeat.i(240099);
        switch (ae.gKE.gHm) {
            case -1:
                if (BuildInfo.IS_FLAVOR_RED || BuildInfo.DEBUG) {
                    AppMethodBeat.o(240099);
                    return true;
                }
                boolean a2 = ((b) g.af(b.class)).a(b.a.clicfg_multitalk_black_board_project_supported, false);
                AppMethodBeat.o(240099);
                return a2;
            case 0:
            default:
                boolean a3 = ((b) g.af(b.class)).a(b.a.clicfg_multitalk_black_board_project_supported, false);
                AppMethodBeat.o(240099);
                return a3;
            case 1:
                AppMethodBeat.o(240099);
                return true;
            case 2:
                AppMethodBeat.o(240099);
                return false;
        }
    }

    public static final int eqc() {
        AppMethodBeat.i(240100);
        int a2 = ((b) g.af(b.class)).a(b.a.clicfg_multitalk_screen_project_fps, 5);
        AppMethodBeat.o(240100);
        return a2;
    }

    public static final int aGF(String str) {
        int i2;
        AppMethodBeat.i(178994);
        if (!Util.isNullOrNil(str)) {
            q eom = ac.eom();
            p.g(eom, "SubCoreMultiTalk.getMultiTalkManager()");
            if (eom.enn() != null) {
                q eom2 = ac.eom();
                p.g(eom2, "SubCoreMultiTalk.getMultiTalkManager()");
                String hjv = eom2.enn().hjv();
                if (ac.eom().aFW(hjv)) {
                    i2 = com.tencent.mm.plugin.multitalk.b.p.INSTANCE.aFz(str);
                } else {
                    TalkRoom brg = c.hqY().brg(hjv);
                    if (brg != null) {
                        Iterator<a.bb> it = brg.hqS().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            a.bb next = it.next();
                            if (p.j(next.dLN, str)) {
                                i2 = next.qrD;
                                break;
                            }
                        }
                    }
                }
                AppMethodBeat.o(178994);
                return i2;
            }
        }
        i2 = -1;
        AppMethodBeat.o(178994);
        return i2;
    }

    public static boolean eqd() {
        AppMethodBeat.i(240101);
        switch (ae.gKE.gHl) {
            case -1:
                if (BuildInfo.IS_FLAVOR_RED || BuildInfo.DEBUG) {
                    AppMethodBeat.o(240101);
                    return true;
                }
                boolean a2 = ((b) g.af(b.class)).a(b.a.clicfg_multitalk_can_receive_screen_cast, false);
                AppMethodBeat.o(240101);
                return a2;
            case 0:
            default:
                boolean a3 = ((b) g.af(b.class)).a(b.a.clicfg_multitalk_can_receive_screen_cast, false);
                AppMethodBeat.o(240101);
                return a3;
            case 1:
                AppMethodBeat.o(240101);
                return true;
            case 2:
                AppMethodBeat.o(240101);
                return false;
        }
    }

    public static boolean eqe() {
        AppMethodBeat.i(240102);
        if (((b) g.af(b.class)).a(b.a.clicfg_multitalk_screen_cast_use_hw_decode, 0) == 1) {
            AppMethodBeat.o(240102);
            return true;
        }
        AppMethodBeat.o(240102);
        return false;
    }

    public static String eqf() {
        AppMethodBeat.i(240103);
        String eqh = eqh();
        if (!Util.isNullOrNil(eqh)) {
            try {
                String optString = new i(eqh).optString("screen_cast_title");
                AppMethodBeat.o(240103);
                return optString;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.MultitalkUtils", e2, "getMultitalkWaitingAcceptWording error", new Object[0]);
            }
        }
        AppMethodBeat.o(240103);
        return null;
    }

    public static final String eqg() {
        AppMethodBeat.i(240104);
        String eqh = eqh();
        if (!Util.isNullOrNil(eqh)) {
            try {
                String optString = new i(eqh).optString("waiting");
                AppMethodBeat.o(240104);
                return optString;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.MultitalkUtils", e2, "getMultitalkWaitingAcceptWording error", new Object[0]);
            }
        }
        AppMethodBeat.o(240104);
        return null;
    }

    private static String eqh() {
        AppMethodBeat.i(240105);
        String a2 = ((b) g.af(b.class)).a(b.a.clicfg_multitalk_navpop_wording, "");
        if (!Util.isNullOrNil(a2)) {
            try {
                i iVar = new i(a2);
                String applicationLanguage = LocaleUtil.getApplicationLanguage();
                Log.i("MicroMsg.MultitalkUtils", "getMultitalkNavpopWording, langCode:%s", applicationLanguage);
                String optString = iVar.optString(applicationLanguage);
                AppMethodBeat.o(240105);
                return optString;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.MultitalkUtils", e2, "getMultitalkNavpopWording error", new Object[0]);
            }
        }
        AppMethodBeat.o(240105);
        return null;
    }

    public static final String eqi() {
        AppMethodBeat.i(240106);
        String eqh = eqh();
        if (!Util.isNullOrNil(eqh)) {
            try {
                String optString = new i(eqh).optString("talking");
                AppMethodBeat.o(240106);
                return optString;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.MultitalkUtils", e2, "getMulitalkMemberListSizeWording error", new Object[0]);
            }
        }
        AppMethodBeat.o(240106);
        return null;
    }

    public static int i(String str, float f2) {
        AppMethodBeat.i(240107);
        Rect rect = new Rect();
        Paint paint = new Paint();
        paint.setTextSize(f2);
        paint.getTextBounds(str, 0, str.length(), rect);
        int width = rect.width();
        AppMethodBeat.o(240107);
        return width;
    }
}
