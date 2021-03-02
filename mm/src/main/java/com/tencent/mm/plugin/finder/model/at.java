package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cl;
import com.tencent.mm.plugin.finder.utils.al;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.vfs.s;
import kotlin.g.b.p;

public final class at extends cl {
    private static final IAutoDBItem.MAutoDBInfo info = cl.ajs();
    public static final a uON = new a((byte) 0);
    private String filePath = "";

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(166400);
        AppMethodBeat.o(166400);
    }

    public final String getFilePath() {
        AppMethodBeat.i(248806);
        al alVar = al.waC;
        String am = al.am(this.field_fileFormat, this.field_originMediaId, this.field_url);
        AppMethodBeat.o(248806);
        return am;
    }

    public final boolean dkN() {
        return this.field_totalSize > 0 && this.field_cacheSize > 0 && this.field_state == 3;
    }

    public final boolean dkO() {
        return this.field_totalSize > 0 && this.field_cacheSize > 0 && this.field_state >= 2;
    }

    public final int dkP() {
        if (this.field_totalSize <= 0) {
            return 0;
        }
        return (int) ((((float) this.field_cacheSize) / ((float) this.field_totalSize)) * 100.0f);
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        AppMethodBeat.i(166398);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = info;
        p.g(mAutoDBInfo, "info");
        AppMethodBeat.o(166398);
        return mAutoDBInfo;
    }

    public final String toString() {
        AppMethodBeat.i(166399);
        String str = this.field_mediaId + ", " + this.field_fileFormat + ", codingFormat=" + this.field_reqFormat + " cacheSize=" + this.field_cacheSize + " totalSize=" + this.field_totalSize + " percent=" + dkP() + ", " + getFilePath() + ", " + this.field_url;
        AppMethodBeat.o(166399);
        return str;
    }

    public final int hashCode() {
        AppMethodBeat.i(248808);
        int hashCode = this.field_mediaId.hashCode();
        AppMethodBeat.o(248808);
        return hashCode;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(248809);
        if (obj instanceof at) {
            boolean j2 = p.j(this.field_mediaId, ((at) obj).field_mediaId);
            AppMethodBeat.o(248809);
            return j2;
        }
        AppMethodBeat.o(248809);
        return false;
    }

    @Override // com.tencent.mm.g.c.cl
    public final void reset() {
        this.field_cacheSize = 0;
        this.field_totalSize = 0;
        this.field_hasPlayed = false;
        this.field_reqFormat = 0;
        this.field_fileFormat = "";
        this.field_state = 0;
        this.field_moovReady = false;
        this.field_audioBitrate = 0;
        this.field_videoBitrate = 0;
        this.field_frameRate = 0;
    }

    public final int aui(String str) {
        boolean z;
        AppMethodBeat.i(248807);
        p.h(str, "path");
        if (this.field_totalSize <= 0 || this.field_cacheSize != this.field_totalSize) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            AppMethodBeat.o(248807);
            return 1;
        } else if (!s.YS(str)) {
            AppMethodBeat.o(248807);
            return 2;
        } else {
            AppMethodBeat.o(248807);
            return 0;
        }
    }
}
