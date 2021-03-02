package com.tencent.mm.g.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class fy extends IEvent {
    public a dJy;
    public b dJz;

    public static final class a {
        public String appId;
        public Context context;
        public String[] dBX;
        public int dIT = 0;
        public String[] selectionArgs;
        public Uri uri;
    }

    public static final class b {
        public Cursor dIU;
    }

    public fy() {
        this((byte) 0);
    }

    private fy(byte b2) {
        AppMethodBeat.i(19807);
        this.dJy = new a();
        this.dJz = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(19807);
    }
}
