package com.tencent.mm.g.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aak extends IEvent {
    public a ehi;
    public b ehj;

    public static final class a {
        public String callingPackage;
        public Context context;
        public int dIT = 0;
        public Uri uri;
    }

    public static final class b {
        public Cursor dIU;
    }

    public aak() {
        this((byte) 0);
    }

    private aak(byte b2) {
        AppMethodBeat.i(19848);
        this.ehi = new a();
        this.ehj = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(19848);
    }
}
