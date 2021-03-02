package com.tencent.mm.g.a;

import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.storage.ca;

public final class kg extends IEvent {
    public a dPi;
    public b dPj;

    public static final class a {
        public ca dCM;
        public ImageView dPk;
        public ImageView dPl;
        public ProgressBar dPm;
        public int dPn;

        /* renamed from: h  reason: collision with root package name */
        public int f1455h;
        public int w;
    }

    public static final class b {
    }

    public kg() {
        this((byte) 0);
    }

    private kg(byte b2) {
        AppMethodBeat.i(55663);
        this.dPi = new a();
        this.dPj = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(55663);
    }
}
