package com.tencent.mm.plugin.textstatus.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.util.c;

public final class p {
    public static boolean FXw = c.hdg();
    private static String FXx = "#([^\\n\\s\\t#@\\,，\\.。]{1,32})";
    public static boolean VcB = true;
    private static long VcC = 0;
    private static long VcD = 1;

    static {
        AppMethodBeat.i(222816);
        c cVar = c.QYz;
        AppMethodBeat.o(222816);
    }

    public static boolean fvC() {
        int i2;
        AppMethodBeat.i(222806);
        if (FXw) {
            c cVar = c.QYz;
            i2 = Util.getInt(c.axY(c.np("textstatus", "openTextStatus")), 0);
        } else {
            i2 = 1;
        }
        if (!VcB || ((b) g.af(b.class)).a(b.a.clicfg_text_state_entry_and, i2) != 1) {
            AppMethodBeat.o(222806);
            return false;
        }
        AppMethodBeat.o(222806);
        return true;
    }

    public static boolean fvD() {
        int i2;
        AppMethodBeat.i(222807);
        if (!fvC()) {
            AppMethodBeat.o(222807);
            return false;
        }
        if (FXw) {
            c cVar = c.QYz;
            i2 = Util.getInt(c.axY(c.np("textstatus", "isPlanetOpen")), 0);
        } else {
            i2 = 0;
        }
        if (((b) g.af(b.class)).a(b.a.clicfg_text_state_planet_and, i2) == 1) {
            AppMethodBeat.o(222807);
            return true;
        }
        AppMethodBeat.o(222807);
        return false;
    }

    public static void fvE() {
        AppMethodBeat.i(222808);
        g.aAh().azQ().set(ar.a.USERINFO_TEXT_STATUS_NEW_TIPS_SHOW_BOOLEAN, Boolean.TRUE);
        AppMethodBeat.o(222808);
    }

    public static boolean fvF() {
        int i2;
        AppMethodBeat.i(222809);
        if (!fvC()) {
            AppMethodBeat.o(222809);
            return false;
        } else if (g.aAh().azQ().getBoolean(ar.a.USERINFO_TEXT_STATUS_NEW_TIPS_SHOW_BOOLEAN, false)) {
            AppMethodBeat.o(222809);
            return false;
        } else {
            if (FXw) {
                c cVar = c.QYz;
                i2 = Util.getInt(c.axY(c.np("textstatus", "isNewTipsOpen")), 0);
            } else {
                i2 = 0;
            }
            if (((b) g.af(b.class)).a(b.a.clicfg_text_state_show_new_tips_and, i2) == 1) {
                AppMethodBeat.o(222809);
                return true;
            }
            AppMethodBeat.o(222809);
            return false;
        }
    }

    public static int hXk() {
        AppMethodBeat.i(259503);
        if (!fvC()) {
            AppMethodBeat.o(259503);
        } else {
            AppMethodBeat.o(259503);
        }
        return 0;
    }

    public static String fvG() {
        AppMethodBeat.i(222810);
        if (!fvC()) {
            String str = FXx;
            AppMethodBeat.o(222810);
            return str;
        }
        String a2 = ((b) g.af(b.class)).a(b.a.clicfg_text_state_topic_separator_list_and, FXx);
        AppMethodBeat.o(222810);
        return a2;
    }

    public static boolean fvH() {
        int i2;
        AppMethodBeat.i(222811);
        if (!fvC()) {
            AppMethodBeat.o(222811);
            return false;
        }
        if (FXw) {
            c cVar = c.QYz;
            i2 = Util.getInt(c.axY(c.np("textstatus", "isIconOpenInContact")), 0);
        } else {
            i2 = 1;
        }
        if (((b) g.af(b.class)).a(b.a.clicfg_text_state_icon_contacts_list_and, i2) == 1) {
            AppMethodBeat.o(222811);
            return true;
        }
        AppMethodBeat.o(222811);
        return false;
    }

    public static boolean fvI() {
        int i2;
        AppMethodBeat.i(222812);
        if (!fvC()) {
            AppMethodBeat.o(222812);
            return false;
        }
        if (FXw) {
            c cVar = c.QYz;
            i2 = Util.getInt(c.axY(c.np("textstatus", "isIconOpenInGroup")), 0);
        } else {
            i2 = 0;
        }
        if (((b) g.af(b.class)).a(b.a.clicfg_text_state_icon_group_chat_and, i2) == 1) {
            AppMethodBeat.o(222812);
            return true;
        }
        AppMethodBeat.o(222812);
        return false;
    }

    public static boolean fvJ() {
        int i2;
        AppMethodBeat.i(222813);
        if (!fvC()) {
            AppMethodBeat.o(222813);
            return false;
        }
        if (FXw) {
            c cVar = c.QYz;
            i2 = Util.getInt(c.axY(c.np("textstatus", "isIconOpenInSnsFeeds")), 0);
        } else {
            i2 = 0;
        }
        if (((b) g.af(b.class)).a(b.a.clicfg_text_state_icon_timeline_feed_and, i2) == 1) {
            AppMethodBeat.o(222813);
            return true;
        }
        AppMethodBeat.o(222813);
        return false;
    }

    public static boolean hXl() {
        int i2;
        AppMethodBeat.i(259504);
        if (!fvC()) {
            AppMethodBeat.o(259504);
            return false;
        }
        if (FXw) {
            c cVar = c.QYz;
            i2 = Util.getInt(c.axY(c.np("textstatus", "isFuIconOpenInSnsFeeds")), 0);
        } else {
            i2 = 0;
        }
        if (((b) g.af(b.class)).a(b.a.clicfg_text_state_icon_timeline_feed_fu_and, i2) == 1) {
            AppMethodBeat.o(259504);
            return true;
        }
        AppMethodBeat.o(259504);
        return false;
    }

    public static boolean fvK() {
        int i2;
        AppMethodBeat.i(222814);
        if (!fvC()) {
            AppMethodBeat.o(222814);
            return false;
        }
        if (FXw) {
            c cVar = c.QYz;
            i2 = Util.getInt(c.axY(c.np("textstatus", "isIconOpenInSnsCommentAndLike")), 0);
        } else {
            i2 = 0;
        }
        if (((b) g.af(b.class)).a(b.a.clicfg_text_state_icon_timeline_comments_and_like_and, i2) == 1) {
            AppMethodBeat.o(222814);
            return true;
        }
        AppMethodBeat.o(222814);
        return false;
    }

    public static boolean fvL() {
        int i2;
        AppMethodBeat.i(222815);
        if (!fvC()) {
            AppMethodBeat.o(222815);
            return false;
        }
        if (FXw) {
            c cVar = c.QYz;
            i2 = Util.getInt(c.axY(c.np("textstatus", "isIconOpenInNewMsg")), 0);
        } else {
            i2 = 0;
        }
        if (((b) g.af(b.class)).a(b.a.clicfg_text_state_icon_timeline_notifications_and, i2) == 1) {
            AppMethodBeat.o(222815);
            return true;
        }
        AppMethodBeat.o(222815);
        return false;
    }

    public static boolean hXm() {
        boolean z;
        AppMethodBeat.i(259505);
        int hXn = hXn();
        if (hXn == 1) {
            z = g.aAh().azQ().a(ar.a.USERINFO_TEXT_STATUS_LAST_INPUT_LEVEL_LONG_SYNC, VcD) == VcC;
        } else if (hXn == 2) {
            z = false;
        } else {
            z = true;
        }
        Log.i("MicroMsg.TextStatus.TextStatusSwitch", "result:%s level:%s", Boolean.valueOf(z), Integer.valueOf(hXn));
        AppMethodBeat.o(259505);
        return z;
    }

    public static int hXn() {
        AppMethodBeat.i(259506);
        int a2 = ((b) g.af(b.class)).a(b.a.clicfg_text_state_input_level, 1);
        AppMethodBeat.o(259506);
        return a2;
    }
}
