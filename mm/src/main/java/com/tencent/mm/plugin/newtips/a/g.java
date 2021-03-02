package com.tencent.mm.plugin.newtips.a;

import android.util.Pair;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.newtips.b.e;
import com.tencent.mm.protocal.protobuf.ehv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.wxmm.v2encoder;
import java.io.Serializable;

public final class g {
    public static boolean a(a aVar, k kVar, boolean z) {
        byte b2;
        AppMethodBeat.i(127223);
        if (aVar.getRoot() == null) {
            AppMethodBeat.o(127223);
            return false;
        }
        try {
            b2 = ((Byte) aVar.getRoot().getTag(R.id.fxm)).byteValue();
        } catch (Exception e2) {
            Log.i("MicroMsg.NewTips.NewTipsHelper", "editOldNewTipsTag() getTag(R.id.new_tips_tag_show_type_old) [%s]", e2.toString());
            b2 = 0;
        }
        Log.d("MicroMsg.NewTips.NewTipsHelper", "editOldNewTipsTag() path:%s origin state:%s", aVar.getPath(), Long.toBinaryString((long) b2));
        switch (kVar) {
            case MMNEWTIPS_SHOWTYPE_REDPOINT:
                if (!z) {
                    b2 = (byte) (b2 & 31);
                    break;
                } else {
                    b2 = (byte) (b2 | 32);
                    break;
                }
            case MMNEWTIPS_SHOWTYPE_NEW:
                if (!z) {
                    b2 = (byte) (b2 & 47);
                    break;
                } else {
                    b2 = (byte) (b2 | v2encoder.enumCODEC_vcodec2);
                    break;
                }
            case MMNEWTIPS_SHOWTYPE_REDPOINT_TITLE:
                if (!z) {
                    b2 = (byte) (b2 & 55);
                    break;
                } else {
                    b2 = (byte) (b2 | 8);
                    break;
                }
            case MMNEWTIPS_SHOWTYPE_REDPOINT_ICON:
                if (!z) {
                    b2 = (byte) (b2 & 59);
                    break;
                } else {
                    b2 = (byte) (b2 | 4);
                    break;
                }
            case MMNEWTIPS_SHOWTYPE_REDPOINT_TITLE_ICON:
                if (!z) {
                    b2 = (byte) (b2 & 61);
                    break;
                } else {
                    b2 = (byte) (b2 | 2);
                    break;
                }
            case MMNEWTIPS_SHOWTYPE_COUNTER:
                if (!z) {
                    b2 = (byte) (b2 & 62);
                    break;
                } else {
                    b2 = (byte) (b2 | 1);
                    break;
                }
        }
        aVar.getRoot().setTag(R.id.fxm, Byte.valueOf(b2));
        Log.d("MicroMsg.NewTips.NewTipsHelper", "editOldNewTipsTag() path:%s showType:%s result:%s", aVar.getPath(), kVar.ADM, Long.toBinaryString((long) b2));
        AppMethodBeat.o(127223);
        return true;
    }

    public static boolean a(final a aVar, final Pair<k, ehv> pair, final boolean z) {
        AppMethodBeat.i(127224);
        if (aVar == null || pair == null) {
            AppMethodBeat.o(127224);
            return false;
        }
        h.RTc.aV(new Runnable() {
            /* class com.tencent.mm.plugin.newtips.a.g.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(127221);
                Pair<Byte, Boolean> b2 = g.b(aVar, pair, z);
                Object[] objArr = new Object[6];
                objArr[0] = aVar.getPath();
                objArr[1] = pair.first != null ? (Serializable) pair.first : BuildConfig.COMMAND;
                objArr[2] = g.a((ehv) pair.second);
                objArr[3] = Boolean.valueOf(z);
                objArr[4] = b2.first;
                objArr[5] = b2.second;
                Log.i("MicroMsg.NewTips.NewTipsHelper", "showNewTipsMainThread() path:%s pair:(%s, %s) show:%s state:%s result:%s", objArr);
                AppMethodBeat.o(127221);
            }
        });
        AppMethodBeat.o(127224);
        return true;
    }

    private static boolean a(a aVar, Pair<k, ehv> pair) {
        AppMethodBeat.i(127225);
        if (aVar == null) {
            AppMethodBeat.o(127225);
            return false;
        }
        Pair<Byte, Boolean> b2 = b(aVar, pair, false);
        Object[] objArr = new Object[6];
        objArr[0] = aVar.getPath();
        objArr[1] = pair.first != null ? (Serializable) pair.first : BuildConfig.COMMAND;
        objArr[2] = a((ehv) pair.second);
        objArr[3] = Boolean.FALSE;
        objArr[4] = b2.first;
        objArr[5] = b2.second;
        Log.i("MicroMsg.NewTips.NewTipsHelper", "showNewTips() path:%s pair:(%s, %s) show:%s state:%s result:%s", objArr);
        AppMethodBeat.o(127225);
        return true;
    }

    static Pair<Byte, Boolean> b(a aVar, Pair<k, ehv> pair, boolean z) {
        boolean z2;
        byte b2;
        AppMethodBeat.i(127226);
        switch ((k) pair.first) {
            case MMNEWTIPS_SHOWTYPE_REDPOINT:
                z2 = aVar.qW(z);
                if (z2 && z) {
                    b2 = 32;
                    break;
                }
                b2 = 0;
                break;
            case MMNEWTIPS_SHOWTYPE_NEW:
                z2 = aVar.qX(z);
                if (z) {
                    b2 = v2encoder.enumCODEC_vcodec2;
                    break;
                }
                b2 = 0;
                break;
            case MMNEWTIPS_SHOWTYPE_REDPOINT_TITLE:
                z2 = aVar.a(z, (ehv) pair.second);
                if (z) {
                    b2 = 8;
                    break;
                }
                b2 = 0;
                break;
            case MMNEWTIPS_SHOWTYPE_REDPOINT_ICON:
                z2 = aVar.b(z, (ehv) pair.second);
                if (z) {
                    b2 = 4;
                    break;
                }
                b2 = 0;
                break;
            case MMNEWTIPS_SHOWTYPE_REDPOINT_TITLE_ICON:
                z2 = aVar.c(z, (ehv) pair.second);
                if (z) {
                    b2 = 2;
                    break;
                }
                b2 = 0;
                break;
            case MMNEWTIPS_SHOWTYPE_COUNTER:
                z2 = aVar.d(z, (ehv) pair.second);
                if (z) {
                    b2 = 1;
                    break;
                }
                b2 = 0;
                break;
            case MMNEWTIPS_SHOWTYPE_NONE:
                g(aVar);
                z2 = false;
                b2 = 0;
                break;
            default:
                z2 = false;
                b2 = 0;
                break;
        }
        Object obj = pair.first;
        if (z) {
            aVar.getRoot().setTag(R.id.fxk, Byte.valueOf(b2));
            aVar.getRoot().setTag(R.id.fxl, pair.second);
        } else {
            aVar.getRoot().setTag(R.id.fxk, 0);
            aVar.getRoot().setTag(R.id.fxl, null);
        }
        Pair<Byte, Boolean> pair2 = new Pair<>(Byte.valueOf(b2), Boolean.valueOf(z2));
        AppMethodBeat.o(127226);
        return pair2;
    }

    public static void a(a aVar) {
        AppMethodBeat.i(127227);
        if (aVar == null) {
            Log.e("MicroMsg.NewTips.NewTipsHelper", "clearCompatTag() iNewTipsView == null");
            AppMethodBeat.o(127227);
            return;
        }
        aVar.a(k.MMNEWTIPS_SHOWTYPE_REDPOINT, false);
        aVar.a(k.MMNEWTIPS_SHOWTYPE_NEW, false);
        aVar.a(k.MMNEWTIPS_SHOWTYPE_REDPOINT_TITLE, false);
        aVar.a(k.MMNEWTIPS_SHOWTYPE_REDPOINT_ICON, false);
        aVar.a(k.MMNEWTIPS_SHOWTYPE_REDPOINT_TITLE_ICON, false);
        aVar.a(k.MMNEWTIPS_SHOWTYPE_COUNTER, false);
        AppMethodBeat.o(127227);
    }

    public static boolean a(boolean z, a aVar) {
        AppMethodBeat.i(127228);
        if (!d(aVar)) {
            AppMethodBeat.o(127228);
            return false;
        } else if (z) {
            g(aVar);
            AppMethodBeat.o(127228);
            return false;
        } else {
            AppMethodBeat.o(127228);
            return true;
        }
    }

    public static boolean b(a aVar) {
        AppMethodBeat.i(127229);
        if (c(aVar) || d(aVar)) {
            AppMethodBeat.o(127229);
            return true;
        }
        AppMethodBeat.o(127229);
        return false;
    }

    public static int aIB(String str) {
        AppMethodBeat.i(127230);
        if (Util.isEqual(str, "me")) {
            AppMethodBeat.o(127230);
            return 1;
        } else if (Util.isEqual(str, "discovery")) {
            AppMethodBeat.o(127230);
            return 2;
        } else if (Util.isEqual(str, "plus")) {
            AppMethodBeat.o(127230);
            return 3;
        } else if (Util.isEqual(str, "plus_receiveorpay")) {
            AppMethodBeat.o(127230);
            return 4;
        } else if (Util.isEqual(str, "pay_receiveorpay")) {
            AppMethodBeat.o(127230);
            return 5;
        } else if (Util.isEqual(str, "topstories")) {
            AppMethodBeat.o(127230);
            return 6;
        } else if (Util.isEqual(str, "topstories_wow")) {
            AppMethodBeat.o(127230);
            return 7;
        } else if (Util.isEqual(str, "topstories_top")) {
            AppMethodBeat.o(127230);
            return 8;
        } else if (Util.isEqual(str, "search")) {
            AppMethodBeat.o(127230);
            return 9;
        } else if (Util.isEqual(str, "dining_nearby")) {
            AppMethodBeat.o(127230);
            return 10;
        } else if (Util.isEqual(str, "shopping")) {
            AppMethodBeat.o(127230);
            return 11;
        } else if (Util.isEqual(str, "game")) {
            AppMethodBeat.o(127230);
            return 12;
        } else if (Util.isEqual(str, WeChatBrands.Business.GROUP_PAY)) {
            AppMethodBeat.o(127230);
            return 13;
        } else if (Util.isEqual(str, "card")) {
            AppMethodBeat.o(127230);
            return 14;
        } else if (Util.isEqual(str, "wallet")) {
            AppMethodBeat.o(127230);
            return 15;
        } else if (Util.isEqual(str, "grouppayreddot")) {
            AppMethodBeat.o(127230);
            return 16;
        } else if (Util.isEqual(str, "facingreceivereddot")) {
            AppMethodBeat.o(127230);
            return 17;
        } else if (Util.isEqual(str, "f2fhongbaoreddot")) {
            AppMethodBeat.o(127230);
            return 18;
        } else if (Util.isEqual(str, "rewardcodereddot")) {
            AppMethodBeat.o(127230);
            return 19;
        } else if (Util.isEqual(str, "transfertoreddot")) {
            AppMethodBeat.o(127230);
            return 20;
        } else if (Util.isEqual(str, "transtobankreddot")) {
            AppMethodBeat.o(127230);
            return 21;
        } else if (Util.isEqual(str, "mobiletransferreddot")) {
            AppMethodBeat.o(127230);
            return 22;
        } else if (Util.isEqual(str, "finder")) {
            AppMethodBeat.o(127230);
            return 24;
        } else if (Util.isEqual(str, "chatroom")) {
            AppMethodBeat.o(127230);
            return 25;
        } else if (Util.isEqual(str, "chatroommgr")) {
            AppMethodBeat.o(127230);
            return 26;
        } else if (Util.isEqual(str, "useww")) {
            AppMethodBeat.o(127230);
            return 27;
        } else if (Util.isEqual(str, "finder_tl_hot_tab")) {
            AppMethodBeat.o(127230);
            return 28;
        } else if (Util.isEqual(str, "finder_tl_nearby_tab")) {
            AppMethodBeat.o(127230);
            return 29;
        } else {
            AppMethodBeat.o(127230);
            return 0;
        }
    }

    public static boolean a(e eVar, k kVar) {
        if (eVar == null) {
            return false;
        }
        if (eVar.ADS) {
            return true;
        }
        int i2 = eVar.path;
        if (kVar == k.MMNEWTIPS_SHOWTYPE_NONE) {
            return true;
        }
        switch (i2) {
            case 1:
                return kVar == k.MMNEWTIPS_SHOWTYPE_REDPOINT || kVar == k.MMNEWTIPS_SHOWTYPE_NEW || kVar == k.MMNEWTIPS_SHOWTYPE_COUNTER;
            case 2:
                return kVar == k.MMNEWTIPS_SHOWTYPE_REDPOINT || kVar == k.MMNEWTIPS_SHOWTYPE_NEW || kVar == k.MMNEWTIPS_SHOWTYPE_COUNTER;
            case 3:
            case 25:
            case 26:
            case 27:
                if (kVar != k.MMNEWTIPS_SHOWTYPE_REDPOINT) {
                    return false;
                }
                break;
            case 4:
                return kVar == k.MMNEWTIPS_SHOWTYPE_REDPOINT || kVar == k.MMNEWTIPS_SHOWTYPE_NEW || kVar == k.MMNEWTIPS_SHOWTYPE_COUNTER;
            case 5:
                return kVar == k.MMNEWTIPS_SHOWTYPE_REDPOINT || kVar == k.MMNEWTIPS_SHOWTYPE_NEW || kVar == k.MMNEWTIPS_SHOWTYPE_COUNTER;
            case 6:
                return kVar == k.MMNEWTIPS_SHOWTYPE_REDPOINT || kVar == k.MMNEWTIPS_SHOWTYPE_NEW || kVar == k.MMNEWTIPS_SHOWTYPE_REDPOINT_TITLE || kVar == k.MMNEWTIPS_SHOWTYPE_REDPOINT_ICON || kVar == k.MMNEWTIPS_SHOWTYPE_REDPOINT_TITLE_ICON || kVar == k.MMNEWTIPS_SHOWTYPE_COUNTER;
            case 7:
                return kVar == k.MMNEWTIPS_SHOWTYPE_REDPOINT || kVar == k.MMNEWTIPS_SHOWTYPE_NEW || kVar == k.MMNEWTIPS_SHOWTYPE_COUNTER;
            case 8:
                return kVar == k.MMNEWTIPS_SHOWTYPE_REDPOINT || kVar == k.MMNEWTIPS_SHOWTYPE_NEW || kVar == k.MMNEWTIPS_SHOWTYPE_COUNTER;
            case 9:
                return kVar == k.MMNEWTIPS_SHOWTYPE_REDPOINT || kVar == k.MMNEWTIPS_SHOWTYPE_NEW || kVar == k.MMNEWTIPS_SHOWTYPE_REDPOINT_TITLE || kVar == k.MMNEWTIPS_SHOWTYPE_REDPOINT_ICON || kVar == k.MMNEWTIPS_SHOWTYPE_REDPOINT_TITLE_ICON || kVar == k.MMNEWTIPS_SHOWTYPE_COUNTER;
            case 10:
                return kVar == k.MMNEWTIPS_SHOWTYPE_REDPOINT || kVar == k.MMNEWTIPS_SHOWTYPE_NEW || kVar == k.MMNEWTIPS_SHOWTYPE_REDPOINT_TITLE || kVar == k.MMNEWTIPS_SHOWTYPE_REDPOINT_ICON || kVar == k.MMNEWTIPS_SHOWTYPE_REDPOINT_TITLE_ICON || kVar == k.MMNEWTIPS_SHOWTYPE_COUNTER;
            case 11:
                return kVar == k.MMNEWTIPS_SHOWTYPE_REDPOINT || kVar == k.MMNEWTIPS_SHOWTYPE_NEW || kVar == k.MMNEWTIPS_SHOWTYPE_REDPOINT_TITLE || kVar == k.MMNEWTIPS_SHOWTYPE_REDPOINT_ICON || kVar == k.MMNEWTIPS_SHOWTYPE_REDPOINT_TITLE_ICON || kVar == k.MMNEWTIPS_SHOWTYPE_COUNTER;
            case 12:
                return kVar == k.MMNEWTIPS_SHOWTYPE_REDPOINT || kVar == k.MMNEWTIPS_SHOWTYPE_NEW || kVar == k.MMNEWTIPS_SHOWTYPE_REDPOINT_TITLE || kVar == k.MMNEWTIPS_SHOWTYPE_REDPOINT_ICON || kVar == k.MMNEWTIPS_SHOWTYPE_REDPOINT_TITLE_ICON || kVar == k.MMNEWTIPS_SHOWTYPE_COUNTER;
            case 13:
                return kVar == k.MMNEWTIPS_SHOWTYPE_REDPOINT || kVar == k.MMNEWTIPS_SHOWTYPE_NEW || kVar == k.MMNEWTIPS_SHOWTYPE_REDPOINT_TITLE || kVar == k.MMNEWTIPS_SHOWTYPE_REDPOINT_ICON || kVar == k.MMNEWTIPS_SHOWTYPE_REDPOINT_TITLE_ICON || kVar == k.MMNEWTIPS_SHOWTYPE_COUNTER;
            case 14:
                return kVar == k.MMNEWTIPS_SHOWTYPE_REDPOINT || kVar == k.MMNEWTIPS_SHOWTYPE_NEW || kVar == k.MMNEWTIPS_SHOWTYPE_REDPOINT_TITLE || kVar == k.MMNEWTIPS_SHOWTYPE_REDPOINT_ICON || kVar == k.MMNEWTIPS_SHOWTYPE_REDPOINT_TITLE_ICON || kVar == k.MMNEWTIPS_SHOWTYPE_COUNTER;
            case 15:
                return kVar == k.MMNEWTIPS_SHOWTYPE_REDPOINT || kVar == k.MMNEWTIPS_SHOWTYPE_NEW || kVar == k.MMNEWTIPS_SHOWTYPE_COUNTER;
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
                return kVar == k.MMNEWTIPS_SHOWTYPE_REDPOINT || kVar == k.MMNEWTIPS_SHOWTYPE_NEW || kVar == k.MMNEWTIPS_SHOWTYPE_REDPOINT_TITLE;
            case 23:
            default:
                return false;
            case 24:
                if (!(kVar == k.MMNEWTIPS_SHOWTYPE_REDPOINT || kVar == k.MMNEWTIPS_SHOWTYPE_NEW || kVar == k.MMNEWTIPS_SHOWTYPE_REDPOINT_TITLE || kVar == k.MMNEWTIPS_SHOWTYPE_REDPOINT_ICON || kVar == k.MMNEWTIPS_SHOWTYPE_REDPOINT_TITLE_ICON || kVar == k.MMNEWTIPS_SHOWTYPE_COUNTER)) {
                    return false;
                }
        }
        return true;
    }

    public static boolean c(a aVar) {
        byte b2;
        AppMethodBeat.i(127231);
        if (aVar == null) {
            Log.i("MicroMsg.NewTips.NewTipsHelper", "isShowCompateNewTips() curNewTip is null");
            AppMethodBeat.o(127231);
            return true;
        } else if (aVar.getRoot() == null) {
            Log.i("MicroMsg.NewTips.NewTipsHelper", "isShowCompateNewTips() path:%s root is null", aVar.getPath());
            AppMethodBeat.o(127231);
            return true;
        } else {
            try {
                b2 = ((Byte) aVar.getRoot().getTag(R.id.fxm)).byteValue();
            } catch (Exception e2) {
                Log.e("MicroMsg.NewTips.NewTipsHelper", "isShowCompateNewTips() path:%s getTag(R.id.new_tips_tag_show_type_old) [%s]", aVar.getPath(), e2.toString());
                b2 = 0;
            }
            Log.i("MicroMsg.NewTips.NewTipsHelper", "isShowCompateNewTips() path:%s state:%s", aVar.getPath(), Long.toBinaryString((long) b2));
            if (b2 != 0) {
                AppMethodBeat.o(127231);
                return true;
            }
            AppMethodBeat.o(127231);
            return false;
        }
    }

    private static boolean d(a aVar) {
        byte b2;
        AppMethodBeat.i(127232);
        if (aVar == null) {
            Log.i("MicroMsg.NewTips.NewTipsHelper", "isShowNewTips() curNewTip is null");
            AppMethodBeat.o(127232);
            return false;
        } else if (aVar.getRoot() == null) {
            Log.i("MicroMsg.NewTips.NewTipsHelper", "isShowNewTips() path:%s root is null", aVar.getPath());
            AppMethodBeat.o(127232);
            return false;
        } else {
            try {
                b2 = ((Byte) aVar.getRoot().getTag(R.id.fxk)).byteValue();
            } catch (Exception e2) {
                Log.e("MicroMsg.NewTips.NewTipsHelper", "isShowNewTips() getTag(R.id.new_tips_tag_show_type_new) [%s]", e2.toString());
                b2 = 0;
            }
            Log.i("MicroMsg.NewTips.NewTipsHelper", "isShowNewTips() path:%s state:%s", aVar.getPath(), Long.toBinaryString((long) b2));
            if (b2 != 0) {
                AppMethodBeat.o(127232);
                return true;
            }
            AppMethodBeat.o(127232);
            return false;
        }
    }

    public static k e(a aVar) {
        byte b2;
        k kVar;
        AppMethodBeat.i(127233);
        if (aVar == null) {
            Log.i("MicroMsg.NewTips.NewTipsHelper", "getShowNewTipsShowType() curNewTip is null");
            k kVar2 = k.MMNEWTIPS_SHOWTYPE_NONE;
            AppMethodBeat.o(127233);
            return kVar2;
        } else if (aVar.getRoot() == null) {
            Log.i("MicroMsg.NewTips.NewTipsHelper", "getShowNewTipsShowType() path:%s root is null", aVar.getPath());
            k kVar3 = k.MMNEWTIPS_SHOWTYPE_NONE;
            AppMethodBeat.o(127233);
            return kVar3;
        } else {
            try {
                b2 = ((Byte) aVar.getRoot().getTag(R.id.fxk)).byteValue();
            } catch (Exception e2) {
                Log.e("MicroMsg.NewTips.NewTipsHelper", "getShowNewTipsShowType() getTag(R.id.new_tips_tag_show_type_new) [%s]", e2.toString());
                b2 = 0;
            }
            Log.i("MicroMsg.NewTips.NewTipsHelper", "getShowNewTipsShowType() path:%s state:%s", aVar.getPath(), Long.toBinaryString((long) b2));
            switch (b2) {
                case 1:
                    kVar = k.MMNEWTIPS_SHOWTYPE_COUNTER;
                    break;
                case 2:
                    kVar = k.MMNEWTIPS_SHOWTYPE_REDPOINT_TITLE_ICON;
                    break;
                case 4:
                    kVar = k.MMNEWTIPS_SHOWTYPE_REDPOINT_ICON;
                    break;
                case 8:
                    kVar = k.MMNEWTIPS_SHOWTYPE_REDPOINT_TITLE;
                    break;
                case 16:
                    kVar = k.MMNEWTIPS_SHOWTYPE_NEW;
                    break;
                case 32:
                    kVar = k.MMNEWTIPS_SHOWTYPE_REDPOINT;
                    break;
                default:
                    kVar = k.MMNEWTIPS_SHOWTYPE_NONE;
                    break;
            }
            AppMethodBeat.o(127233);
            return kVar;
        }
    }

    public static ehv f(a aVar) {
        ehv ehv;
        AppMethodBeat.i(127234);
        if (aVar == null) {
            Log.i("MicroMsg.NewTips.NewTipsHelper", "getCurNewTipsShowTypeAboutInfo() curNewTip is null");
            AppMethodBeat.o(127234);
            return null;
        } else if (aVar.getRoot() == null) {
            Log.i("MicroMsg.NewTips.NewTipsHelper", "getCurNewTipsShowTypeAboutInfo() path:%s root is null", aVar.getPath());
            AppMethodBeat.o(127234);
            return null;
        } else {
            try {
                ehv = (ehv) aVar.getRoot().getTag(R.id.fxk);
            } catch (Exception e2) {
                Log.e("MicroMsg.NewTips.NewTipsHelper", "getCurNewTipsShowTypeAboutInfo() getTag(R.id.new_tips_tag_show_type_new) [%s]", e2.toString());
                ehv = null;
            }
            Log.i("MicroMsg.NewTips.NewTipsHelper", "getCurNewTipsShowTypeAboutInfo() path:%s tipsInfo:%s", aVar.getPath(), a(ehv));
            AppMethodBeat.o(127234);
            return ehv;
        }
    }

    private static void g(a aVar) {
        AppMethodBeat.i(127236);
        k e2 = e(aVar);
        if (e2 != k.MMNEWTIPS_SHOWTYPE_NONE) {
            a(aVar, new Pair(e2, new ehv()));
        }
        AppMethodBeat.o(127236);
    }

    public static String a(ehv ehv) {
        AppMethodBeat.i(127237);
        if (ehv == null) {
            AppMethodBeat.o(127237);
            return BuildConfig.COMMAND;
        }
        String str = "TipsInfo{num=" + ehv.ibS + ", title='" + ehv.title + '\'' + ", url='" + ehv.url + '\'' + '}';
        AppMethodBeat.o(127237);
        return str;
    }
}
