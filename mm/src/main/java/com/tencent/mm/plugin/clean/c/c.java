package com.tencent.mm.plugin.clean.c;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.f.b.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public final class c {
    public long dFm;
    public String filePath;
    public long jsm;
    public int msgType;
    public List<a> qpJ = new ArrayList();
    public long size;
    public String thumbPath;
    public int type;
    public String userName;

    public c() {
        AppMethodBeat.i(22824);
        AppMethodBeat.o(22824);
    }

    public final String toString() {
        AppMethodBeat.i(22825);
        switch (this.type) {
            case 1:
                String format = String.format("%-8s    %-10s  %s\r\n", "IMG", Util.getSizeMB(this.size), this.filePath);
                AppMethodBeat.o(22825);
                return format;
            case 2:
                String format2 = String.format("%-8s    %-10s  %s\r\n", "VOICE", Util.getSizeMB(this.size), this.filePath);
                AppMethodBeat.o(22825);
                return format2;
            case 3:
                String format3 = String.format("%-8s    %-10s  %s\r\n", ShareConstants.VIDEO_URL, Util.getSizeMB(this.size), this.filePath);
                AppMethodBeat.o(22825);
                return format3;
            case 4:
                String format4 = String.format("%-8s    %-10s  %s\r\n", "ATTACH", Util.getSizeMB(this.size), this.filePath);
                AppMethodBeat.o(22825);
                return format4;
            default:
                AppMethodBeat.o(22825);
                return "";
        }
    }

    public final long cyL() {
        AppMethodBeat.i(22826);
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(this.jsm);
        long j2 = (long) (instance.get(2) + (instance.get(1) * 100));
        AppMethodBeat.o(22826);
        return j2;
    }
}
