package com.tencent.mm.plugin.downloader_app.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.c.a.a.f;
import com.tencent.mm.plugin.downloader.c.b.c;
import com.tencent.mm.plugin.game.commlib.c.b;
import com.tencent.mm.sdk.platformtools.Util;

public final class i extends b {
    public String appId = "";
    public String appName;
    public String iconUrl;
    public boolean isSelected = false;
    public String jumpUrl;
    public boolean maw = true;
    public boolean pSk = false;
    public String packageName;
    public int position;
    public boolean qLf;
    public String qLg;
    public int qLh = 0;
    public c qLi;
    public f qLj;
    public com.tencent.mm.plugin.downloader.c.b.b qLk;
    public int type;

    public i(int i2) {
        this.type = i2;
    }

    public i() {
    }

    public final boolean cCd() {
        return this.type == 2 || this.type == 4 || this.type == 6;
    }

    @Override // com.tencent.mm.plugin.game.commlib.c.b
    public final Object cCe() {
        AppMethodBeat.i(8905);
        Integer valueOf = Integer.valueOf(this.type);
        AppMethodBeat.o(8905);
        return valueOf;
    }

    @Override // com.tencent.mm.plugin.game.commlib.c.b
    public final int a(b bVar) {
        AppMethodBeat.i(8906);
        int compare = Integer.compare(this.type, ((Integer) bVar.cCe()).intValue());
        AppMethodBeat.o(8906);
        return compare;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(8907);
        if (obj == null || !(obj instanceof i) || Util.isNullOrNil(((i) obj).appId) || Util.isNullOrNil(this.appId)) {
            AppMethodBeat.o(8907);
            return false;
        }
        boolean equals = ((i) obj).appId.equals(this.appId);
        AppMethodBeat.o(8907);
        return equals;
    }
}
