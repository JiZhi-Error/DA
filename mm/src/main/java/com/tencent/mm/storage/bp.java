package com.tencent.mm.storage;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;

public final class bp {
    public static final bp Oql = new bp("timeline");
    public static final bp Oqm = new bp("album_friend");
    public static final bp Oqn = new bp("album_self");
    public static final bp Oqo = new bp("album_stranger");
    public static final bp Oqp = new bp("profile_friend");
    public static final bp Oqq = new bp("profile_stranger");
    public static final bp Oqr = new bp(FFmpegMetadataRetriever.METADATA_KEY_COMMENT);
    public static final bp Oqs = new bp("comment_detail");
    public static final bp Oqt = new bp(FacebookRequestErrorClassification.KEY_OTHER);
    public static final bp Oqu = new bp("snssight");
    public static final bp Oqv = new bp("fts");
    public static final bp Oqw = new bp("storysight");
    public static final bp Oqx = new bp("storyalbum");
    public int hXs = 0;
    public String tag = "";

    static {
        AppMethodBeat.i(133298);
        AppMethodBeat.o(133298);
    }

    public static bp gCU() {
        AppMethodBeat.i(133288);
        bp bpVar = new bp("timeline");
        AppMethodBeat.o(133288);
        return bpVar;
    }

    public static bp gCV() {
        AppMethodBeat.i(133289);
        bp bpVar = new bp("album_friend");
        AppMethodBeat.o(133289);
        return bpVar;
    }

    public static bp gCW() {
        AppMethodBeat.i(133290);
        bp bpVar = new bp("album_self");
        AppMethodBeat.o(133290);
        return bpVar;
    }

    public static bp gCX() {
        AppMethodBeat.i(133291);
        bp bpVar = new bp("album_stranger");
        AppMethodBeat.o(133291);
        return bpVar;
    }

    public static bp gCY() {
        AppMethodBeat.i(133292);
        bp bpVar = new bp("comment_detail");
        AppMethodBeat.o(133292);
        return bpVar;
    }

    public static bp gCZ() {
        AppMethodBeat.i(133293);
        bp bpVar = new bp("snssight");
        AppMethodBeat.o(133293);
        return bpVar;
    }

    public static bp gDa() {
        AppMethodBeat.i(133294);
        bp bpVar = new bp("storysight");
        AppMethodBeat.o(133294);
        return bpVar;
    }

    public bp(String str) {
        this.tag = str;
    }

    public final bp akk(int i2) {
        this.hXs = i2;
        return this;
    }

    public static bp a(bp bpVar, int i2) {
        AppMethodBeat.i(133295);
        bp bpVar2 = new bp(bpVar.tag);
        bpVar2.hXs = i2;
        AppMethodBeat.o(133295);
        return bpVar2;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(133296);
        if (obj instanceof bp) {
            boolean equals = ((bp) obj).tag.equals(this.tag);
            AppMethodBeat.o(133296);
            return equals;
        }
        boolean equals2 = super.equals(obj);
        AppMethodBeat.o(133296);
        return equals2;
    }

    public final String toString() {
        AppMethodBeat.i(133297);
        String str = this.tag + "@" + this.hXs;
        AppMethodBeat.o(133297);
        return str;
    }
}
