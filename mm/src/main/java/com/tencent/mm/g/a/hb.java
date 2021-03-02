package com.tencent.mm.g.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amq;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.and;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MStorage;
import java.util.List;

public final class hb extends IEvent {
    public a dLm;
    public b dLn;

    public static final class a {
        public Context context;
        public long dFW;
        public q dGJ;
        public anb dGb;
        public aml dLo;
        public Intent dLp;
        public MStorage.IOnStorageChange dLq;
        public Runnable dLr;
        public String dLs;
        public int dLt = 0;
        public int dLu = 0;
        public String dLv;
        public String dLw;
        public and dLx;
        public String desc;
        public MMHandler handler;
        public String path;
        public String title;
        public String toUser;
        public int type = 0;
    }

    public static final class b {
        public List bzh;
        public List dLA;
        public boolean dLB = false;
        public boolean dLC = false;
        public boolean dLD = false;
        public double dLE = 0.0d;
        public String dLF;
        public amq dLy;
        public ISQLiteDatabase dLz;
        public String path;
        public int ret = -1;
        public String thumbPath;
        public String thumbUrl;
    }

    public hb() {
        this((byte) 0);
    }

    private hb(byte b2) {
        AppMethodBeat.i(127405);
        this.dLm = new a();
        this.dLn = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(127405);
    }
}
