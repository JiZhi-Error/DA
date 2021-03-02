package com.tencent.mm.plugin.groupsolitaire.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.Util;

public final class b {
    public String content = "";
    public long createtime = MAlarmHandler.NEXT_FIRE_INTERVAL;
    public String separator = " ";
    public String username = "";
    public int yfH = 0;
    public int yfI = 0;

    public final /* synthetic */ Object clone() {
        AppMethodBeat.i(110402);
        b dXW = dXW();
        AppMethodBeat.o(110402);
        return dXW;
    }

    public final String toString() {
        AppMethodBeat.i(110398);
        String str = "GroupSolitatireItem{username='" + this.username + '\'' + ", asheader=" + this.yfH + ", separator='" + this.separator + '\'' + ", createtime=" + this.createtime + ", content='" + this.content + '\'' + ", orderNum='" + this.yfI + '\'' + '}';
        AppMethodBeat.o(110398);
        return str;
    }

    public final b dXW() {
        Exception e2;
        b bVar;
        AppMethodBeat.i(110399);
        try {
            bVar = new b();
            try {
                bVar.username = this.username;
                bVar.yfH = this.yfH;
                bVar.separator = this.separator;
                bVar.createtime = this.createtime;
                bVar.content = this.content;
                bVar.yfI = this.yfI;
            } catch (Exception e3) {
                e2 = e3;
                Log.i("MicroMsg.groupsolitaire.GroupSolitatireItem", "clone() Exception:%s %s", e2.getClass(), e2.getMessage());
                AppMethodBeat.o(110399);
                return bVar;
            }
        } catch (Exception e4) {
            e2 = e4;
            bVar = null;
            Log.i("MicroMsg.groupsolitaire.GroupSolitatireItem", "clone() Exception:%s %s", e2.getClass(), e2.getMessage());
            AppMethodBeat.o(110399);
            return bVar;
        }
        AppMethodBeat.o(110399);
        return bVar;
    }

    public final int hashCode() {
        AppMethodBeat.i(110400);
        if (Util.isNullOrNil(this.content) || Util.isNullOrNil(this.content.trim())) {
            AppMethodBeat.o(110400);
            return 0;
        }
        int hashCode = this.content.trim().replaceAll(com.tencent.mm.plugin.groupsolitaire.b.b.dXS(), "").replace(" ", "").toLowerCase().hashCode();
        AppMethodBeat.o(110400);
        return hashCode;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(110401);
        b bVar = (b) obj;
        if (Util.isEqual(this.username, bVar.username)) {
            if (Util.isEqual(this.content.trim(), bVar.content.trim())) {
                AppMethodBeat.o(110401);
                return true;
            }
            AppMethodBeat.o(110401);
            return false;
        } else if (Util.isEqual(this.content.trim(), bVar.content.trim())) {
            AppMethodBeat.o(110401);
            return true;
        } else {
            boolean id = id(this.content.trim(), bVar.content.trim());
            AppMethodBeat.o(110401);
            return id;
        }
    }

    public static boolean id(String str, String str2) {
        AppMethodBeat.i(194435);
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
            AppMethodBeat.o(194435);
            return false;
        }
        boolean isEqual = Util.isEqual(str.replaceAll(com.tencent.mm.plugin.groupsolitaire.b.b.dXS(), "").replace(" ", "").toLowerCase(), str2.replaceAll(com.tencent.mm.plugin.groupsolitaire.b.b.dXS(), "").replace(" ", "").toLowerCase());
        AppMethodBeat.o(194435);
        return isEqual;
    }
}
