package com.tencent.mm.plugin.game.model;

import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.e.d;
import com.tencent.mm.plugin.game.protobuf.bk;
import com.tencent.mm.plugin.game.protobuf.cf;
import com.tencent.mm.plugin.game.protobuf.ci;
import com.tencent.mm.plugin.game.protobuf.cm;
import com.tencent.mm.plugin.game.protobuf.da;
import com.tencent.mm.plugin.game.ui.GameMediaList;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public final class z extends x {
    private boolean xAG;
    public bk xGX;
    public c xGY;
    public aa xGZ;

    public static class a {
        public String desc;
        public String title;
        public String url;
    }

    public static class b {
        public String desc;
        public String icon;
        public String title;
        public String url;
    }

    public z(com.tencent.mm.bw.a aVar) {
        AppMethodBeat.i(41525);
        if (aVar == null) {
            this.xGX = new bk();
            AppMethodBeat.o(41525);
            return;
        }
        this.xGX = (bk) aVar;
        this.xAG = false;
        amZ();
        AppMethodBeat.o(41525);
    }

    public z(byte[] bArr) {
        AppMethodBeat.i(41526);
        this.xGX = new bk();
        if (bArr == null || bArr.length == 0) {
            AppMethodBeat.o(41526);
            return;
        }
        try {
            this.xGX.parseFrom(bArr);
        } catch (IOException e2) {
            Log.e("MicroMsg.GamePBDataDetail", "Parsing Failed: %s", e2.getMessage());
        }
        this.xAG = true;
        amZ();
        AppMethodBeat.o(41526);
    }

    private void amZ() {
        AppMethodBeat.i(41527);
        this.xGY = dVD();
        if (this.xAG) {
            this.xGZ = new aa(this.xGY.field_appId);
        } else {
            this.xGZ = new aa(this.xGY.field_appId, this.xGX.xLw != null ? this.xGX.xLw.xMZ : null);
        }
        if (!this.xAG) {
            d.c(this.xGY);
            ((f) g.af(f.class)).dSL().b(this.xGY.field_appId, this.xGX);
        }
        AppMethodBeat.o(41527);
    }

    private c dVD() {
        AppMethodBeat.i(41528);
        c a2 = a(this.xGX.xIz);
        if (a2 != null) {
            a2.scene = 12;
            a2.dYu = TXLiteAVCode.WARNING_MICROPHONE_DEVICE_EMPTY;
        }
        AppMethodBeat.o(41528);
        return a2;
    }

    public final String dVE() {
        if (this.xGX.xLA != null) {
            return this.xGX.xLA.title;
        }
        if (this.xGX.xLv != null) {
            return this.xGX.xLv.Title;
        }
        return null;
    }

    public final LinkedList<b> dVF() {
        AppMethodBeat.i(41529);
        if (this.xGX.xLA != null && this.xGX.xLA.pWe != null) {
            LinkedList<b> linkedList = new LinkedList<>();
            Iterator<cm> it = this.xGX.xLA.pWe.iterator();
            while (it.hasNext()) {
                cm next = it.next();
                b bVar = new b();
                bVar.icon = next.icon;
                bVar.desc = next.desc;
                linkedList.add(bVar);
            }
            AppMethodBeat.o(41529);
            return linkedList;
        } else if (this.xGX.xLv == null || this.xGX.xLv.xMi == null) {
            AppMethodBeat.o(41529);
            return null;
        } else {
            LinkedList<b> linkedList2 = new LinkedList<>();
            Iterator<cf> it2 = this.xGX.xLv.xMi.iterator();
            while (it2.hasNext()) {
                cf next2 = it2.next();
                b bVar2 = new b();
                bVar2.icon = next2.xMl;
                bVar2.title = next2.Title;
                bVar2.desc = next2.xKd;
                bVar2.url = next2.xIB;
                linkedList2.add(bVar2);
            }
            AppMethodBeat.o(41529);
            return linkedList2;
        }
    }

    public final int dVG() {
        if (this.xGX.xLA != null) {
            return 2;
        }
        return 1;
    }

    public final LinkedList<GameMediaList.a> getMediaList() {
        AppMethodBeat.i(41530);
        LinkedList<GameMediaList.a> linkedList = new LinkedList<>();
        if (this.xGX.xLt == null || this.xGX.xLt.xuZ == null) {
            AppMethodBeat.o(41530);
            return linkedList;
        }
        Iterator<da> it = this.xGX.xLt.xuZ.iterator();
        while (it.hasNext()) {
            da next = it.next();
            GameMediaList.a aVar = new GameMediaList.a();
            aVar.type = next.xuT;
            aVar.dkZ = next.xMK;
            aVar.url = next.xML;
            linkedList.add(aVar);
        }
        AppMethodBeat.o(41530);
        return linkedList;
    }

    public final String dVH() {
        if (this.xGX.xLt == null || this.xGX.xLt.Title == null) {
            return null;
        }
        return this.xGX.xLt.Title;
    }

    public final String dVI() {
        if (this.xGX.xLt == null || this.xGX.xLt.xKd == null) {
            return null;
        }
        return this.xGX.xLt.xKd;
    }

    public final String dVJ() {
        if (this.xGX.xLu == null) {
            return null;
        }
        return this.xGX.xLu.Title;
    }

    public final LinkedList<ci> dVK() {
        if (this.xGX.xLu == null) {
            return null;
        }
        return this.xGX.xLu.xMn;
    }
}
