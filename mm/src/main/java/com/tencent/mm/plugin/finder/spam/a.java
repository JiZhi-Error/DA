package com.tencent.mm.plugin.finder.spam;

import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ab.i;
import com.tencent.mm.g.a.ht;
import com.tencent.mm.n.h;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.avr;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.a.f;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0004J\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0004J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004J \u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004J \u0010\u0013\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004J \u0010\u0014\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004J\u0018\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004J \u0010\u0016\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004J \u0010\u0017\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004J \u0010\u0018\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ \u0010\u001b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\u0016\u0010\u001c\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nJ\u0018\u0010\u001d\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0004R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/plugin/finder/spam/FinderSpamLogic;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "canFeedRetry", "", "errType", "", "errCode", "checkFunctionSpam", "business", "getFunctionSpamAction", "getFunctionSpamTip", "handleFinderBlackList", "", "errMsg", "handleFinderCommonTips", "handleFinderNotRealname", "handleFinderOpLogSpam", "handleFinderSpamErrCode", "handleFinderSpamTips", "handleLiveErrorPageDialog", "errPage", "Lcom/tencent/mm/protocal/protobuf/FinderLiveErrorPage;", "handleLiveErrorPageFullPage", "needDeleteAction", "needOpLogTips", "showSpamDialog", "plugin-finder_release"})
public final class a {
    private static final String TAG = TAG;
    public static final a vwk = new a();

    static {
        AppMethodBeat.i(166880);
        AppMethodBeat.o(166880);
    }

    private a() {
    }

    public static boolean gi(int i2, int i3) {
        if (i2 == 4 && (i3 == -4007 || i3 == -4006)) {
            return true;
        }
        return false;
    }

    public static boolean gj(int i2, int i3) {
        if (i2 == 4 && (i3 == -4007 || i3 == -4006 || i3 == -4005 || i3 == -4059 || i3 == -4065)) {
            return false;
        }
        return true;
    }

    public static boolean ba(int i2, String str) {
        AppMethodBeat.i(251497);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(251497);
            return true;
        } else if (i2 == -4007 || i2 == -4006 || i2 == -4005) {
            AppMethodBeat.o(251497);
            return false;
        } else {
            AppMethodBeat.o(251497);
            return true;
        }
    }

    public static void avm(String str) {
        AppMethodBeat.i(166871);
        p.h(str, "errMsg");
        f.a aVar = new f.a(MMApplicationContext.getContext());
        aVar.bow(str).apa(R.string.j34);
        aVar.Dq(true);
        aVar.b(C1278a.vwl);
        aVar.show();
        AppMethodBeat.o(166871);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "b", "", "s", "", "onDialogClick"})
    /* renamed from: com.tencent.mm.plugin.finder.spam.a$a  reason: collision with other inner class name */
    public static final class C1278a implements f.c {
        public static final C1278a vwl = new C1278a();

        static {
            AppMethodBeat.i(166870);
            AppMethodBeat.o(166870);
        }

        C1278a() {
        }

        @Override // com.tencent.mm.ui.widget.a.f.c
        public final void e(boolean z, String str) {
            AppMethodBeat.i(166869);
            p.h(str, "s");
            AppMethodBeat.o(166869);
        }
    }

    public static void t(int i2, int i3, String str) {
        AppMethodBeat.i(251498);
        if (i2 == 4 && i3 == -4019) {
            if (str != null) {
                avm(str);
            }
            e.INSTANCE.idkeyStat(1264, 6, 1, false);
        }
        AppMethodBeat.o(251498);
    }

    public static void u(int i2, int i3, String str) {
        AppMethodBeat.i(251499);
        if (i2 != 4 || (!(i3 == -5000 || i3 == -5300) || str == null)) {
            AppMethodBeat.o(251499);
            return;
        }
        avm(str);
        AppMethodBeat.o(251499);
    }

    public static void v(int i2, int i3, String str) {
        AppMethodBeat.i(166874);
        if (i2 == 4) {
            if (i3 == -4006) {
                if (str != null) {
                    avm(str);
                }
                e.INSTANCE.idkeyStat(1264, 0, 1, false);
                AppMethodBeat.o(166874);
                return;
            } else if (i3 == -4007) {
                if (str != null) {
                    avm(str);
                }
                e.INSTANCE.idkeyStat(1264, 1, 1, false);
                AppMethodBeat.o(166874);
                return;
            } else if (i3 == -4017) {
                if (str != null) {
                    avm(str);
                }
                e.INSTANCE.idkeyStat(1264, 2, 1, false);
                AppMethodBeat.o(166874);
                return;
            } else if (i3 == -4019) {
                if (str != null) {
                    avm(str);
                }
                e.INSTANCE.idkeyStat(1264, 6, 1, false);
            }
        }
        AppMethodBeat.o(166874);
    }

    public static void w(int i2, int i3, String str) {
        AppMethodBeat.i(166875);
        if (i2 == 4 && i3 == -4010) {
            if (str != null) {
                avm(str);
            }
            e.INSTANCE.idkeyStat(1264, 4, 1, false);
        }
        AppMethodBeat.o(166875);
    }

    public static void x(int i2, int i3, String str) {
        AppMethodBeat.i(166876);
        if (i2 == 4 && i3 == -4013 && str != null) {
            avm(str);
            ht htVar = new ht();
            htVar.dMp.errCode = i3;
            htVar.dMp.errMsg = str;
            EventCenter.instance.publish(htVar);
            AppMethodBeat.o(166876);
            return;
        }
        AppMethodBeat.o(166876);
    }

    public static int avn(String str) {
        AppMethodBeat.i(166877);
        p.h(str, "business");
        String value = h.aqJ().getValue("FinderSpamObject");
        Log.i(TAG, "getFunctionSpamAction ".concat(String.valueOf(value)));
        if (Util.isNullOrNil(value)) {
            AppMethodBeat.o(166877);
            return 0;
        }
        try {
            int optInt = new i(value).FK(str).optInt(NativeProtocol.WEB_DIALOG_ACTION, 0);
            AppMethodBeat.o(166877);
            return optInt;
        } catch (Exception e2) {
            Log.i(TAG, "getFunctionSpamAction spamValue ".concat(String.valueOf(value)));
            AppMethodBeat.o(166877);
            return 0;
        }
    }

    public static String avo(String str) {
        AppMethodBeat.i(166878);
        p.h(str, "business");
        String value = h.aqJ().getValue("FinderSpamObject");
        if (Util.isNullOrNil(value)) {
            AppMethodBeat.o(166878);
            return "";
        }
        try {
            String optString = new i(value).FK(str).optString("tip", "");
            p.g(optString, "obj.optJSONObject(business).optString(\"tip\", \"\")");
            AppMethodBeat.o(166878);
            return optString;
        } catch (Exception e2) {
            Log.i(TAG, "getFunctionSpamTip spamValue ".concat(String.valueOf(value)));
            AppMethodBeat.o(166878);
            return "";
        }
    }

    public static boolean avp(String str) {
        AppMethodBeat.i(166879);
        p.h(str, "business");
        if (avn(str) != 0) {
            avm(avo(str));
            e.INSTANCE.idkeyStat(1264, 3, 1, false);
            Log.i(TAG, "function spam ".concat(String.valueOf(str)));
            AppMethodBeat.o(166879);
            return true;
        }
        AppMethodBeat.o(166879);
        return false;
    }

    public static boolean a(int i2, int i3, avr avr) {
        AppMethodBeat.i(251500);
        if (i2 == 4 && ((i3 == -200011 || i3 == -200012 || i3 == -200008 || i3 == -200009 || i3 == -200010 || i3 == -200046) && avr != null)) {
            if (!(avr.type == 1)) {
                avr = null;
            }
            if (avr != null) {
                String str = avr.dQx;
                if (str == null) {
                    str = "";
                }
                avm(str);
                AppMethodBeat.o(251500);
                return true;
            }
        }
        AppMethodBeat.o(251500);
        return false;
    }

    public static boolean b(int i2, int i3, avr avr) {
        if (i2 != 4) {
            return false;
        }
        if ((i3 == -200011 || i3 == -200012 || i3 == -200046) && avr != null && avr.type == 2) {
            return true;
        }
        return false;
    }
}
