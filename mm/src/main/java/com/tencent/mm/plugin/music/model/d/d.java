package com.tencent.mm.plugin.music.model.d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.c.b;
import com.tencent.mm.plugin.music.e.e;
import com.tencent.mm.plugin.music.model.e.a;

public final class d {
    boolean Alm = false;
    boolean Aln = false;
    boolean Alo = false;
    boolean Alp = false;
    boolean Alq = false;
    boolean Alr = false;
    boolean Als = false;
    boolean Alt = false;
    boolean Alu = false;
    int Alv = 0;
    b Alw;

    /* access modifiers changed from: package-private */
    public final String getMimeType() {
        String str;
        a etY;
        AppMethodBeat.i(63143);
        if (this.Alw != null) {
            str = this.Alw.mimeType;
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str) && (etY = ((e) com.tencent.mm.plugin.music.f.c.b.aS(e.class)).etY()) != null) {
            str = etY.field_mimetype;
        }
        AppMethodBeat.o(63143);
        return str;
    }
}
