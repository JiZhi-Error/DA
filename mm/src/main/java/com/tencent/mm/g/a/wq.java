package com.tencent.mm.g.a;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.sdk.event.IEvent;

public final class wq extends IEvent {
    public a ecI;
    public b ecJ;

    public static final class b {
        public boolean edc;
        public String edd;
    }

    public wq() {
        this((byte) 0);
    }

    private wq(byte b2) {
        AppMethodBeat.i(153187);
        this.ecI = new a();
        this.ecJ = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(153187);
    }

    public static final class a {
        public String appId;
        public int appVersion;
        public Context context;
        public String dCw;
        public Bundle dFP;
        public String ecK;
        public int ecL;
        public Parcelable ecM;
        public String ecN;
        public String ecO;
        public boolean ecP;
        public boolean ecQ = true;
        public LaunchParamsOptional ecR = new LaunchParamsOptional();
        public int ecS;
        public Runnable ecT;
        public int ecU;
        public String ecV;
        public String ecW;
        public String ecX;
        public String ecY;
        public String ecZ;
        public String eda;
        public String edb;
        public int scene;
        public String userName;

        public a() {
            AppMethodBeat.i(153186);
            AppMethodBeat.o(153186);
        }
    }
}
