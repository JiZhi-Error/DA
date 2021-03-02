package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import java.util.ArrayList;
import java.util.Iterator;

public final class h {
    public ArrayList<ca> tkt;
    public boolean tku;
    ArrayList<b> tkv;

    public interface b {
        void clear();

        void gSm();
    }

    /* synthetic */ h(byte b2) {
        this();
    }

    public static final class a {
        private static final h Pys = new h((byte) 0);

        static {
            AppMethodBeat.i(36078);
            AppMethodBeat.o(36078);
        }
    }

    private h() {
        AppMethodBeat.i(36079);
        this.tkt = new ArrayList<>();
        this.tku = false;
        this.tkv = new ArrayList<>();
        AppMethodBeat.o(36079);
    }

    public final void cC(ca caVar) {
        AppMethodBeat.i(36080);
        if (caVar == null) {
            AppMethodBeat.o(36080);
            return;
        }
        Log.i("MicroMsg.ImageGallerySelectedHandle", "add : %s", Long.valueOf(caVar.field_msgId));
        this.tkt.remove(caVar);
        this.tkt.remove(NO(caVar.field_msgId));
        this.tkt.add(caVar);
        gSo();
        AppMethodBeat.o(36080);
    }

    private ca NO(long j2) {
        AppMethodBeat.i(36081);
        Iterator<ca> it = this.tkt.iterator();
        while (it.hasNext()) {
            ca next = it.next();
            if (next.field_msgId == j2) {
                AppMethodBeat.o(36081);
                return next;
            }
        }
        AppMethodBeat.o(36081);
        return null;
    }

    public final void cD(ca caVar) {
        AppMethodBeat.i(36082);
        if (caVar == null) {
            AppMethodBeat.o(36082);
            return;
        }
        Log.i("MicroMsg.ImageGallerySelectedHandle", "remove : %s", Long.valueOf(caVar.field_msgId));
        this.tkt.remove(caVar);
        this.tkt.remove(NO(caVar.field_msgId));
        gSo();
        AppMethodBeat.o(36082);
    }

    public final void clear() {
        AppMethodBeat.i(36083);
        Log.i("MicroMsg.ImageGallerySelectedHandle", "clear..");
        this.tkt.clear();
        cyf();
        AppMethodBeat.o(36083);
    }

    public final void detach() {
        AppMethodBeat.i(36084);
        this.tkv.clear();
        clear();
        this.tku = false;
        AppMethodBeat.o(36084);
    }

    public final boolean cE(ca caVar) {
        AppMethodBeat.i(36085);
        if (caVar == null) {
            AppMethodBeat.o(36085);
            return false;
        }
        Iterator<ca> it = this.tkt.iterator();
        while (it.hasNext()) {
            if (it.next().field_msgId == caVar.field_msgId) {
                AppMethodBeat.o(36085);
                return true;
            }
        }
        AppMethodBeat.o(36085);
        return false;
    }

    private void gSo() {
        AppMethodBeat.i(36086);
        Iterator<b> it = this.tkv.iterator();
        while (it.hasNext()) {
            it.next().gSm();
        }
        AppMethodBeat.o(36086);
    }

    private void cyf() {
        AppMethodBeat.i(36087);
        Iterator<b> it = this.tkv.iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
        AppMethodBeat.o(36087);
    }

    public final void a(b bVar) {
        AppMethodBeat.i(36088);
        this.tkv.remove(bVar);
        this.tkv.add(bVar);
        AppMethodBeat.o(36088);
    }
}
