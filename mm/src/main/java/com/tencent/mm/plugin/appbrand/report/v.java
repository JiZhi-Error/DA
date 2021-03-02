package com.tencent.mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.concurrent.atomic.AtomicInteger;

public final class v {
    public final String mName;
    public final AtomicInteger nHO;
    public volatile a nHP;
    public final c nHQ = new c(this, (byte) 0);
    private final b nHR = new b(this, (byte) 0);
    long nHS;
    public long nHT;

    public interface a {
        void enter();

        void exit();

        long getStartTime();
    }

    public v(String str) {
        AppMethodBeat.i(139919);
        this.mName = str;
        this.nHO = new AtomicInteger(0);
        this.nHP = new d(this, (byte) 0);
        AppMethodBeat.o(139919);
    }

    public final boolean bUz() {
        AppMethodBeat.i(230540);
        boolean z = this.nHO.getAndSet(2) != 2;
        Log.d("Luggage.StayingRecorder", "%s toBackground, changed:%b", this.mName, Boolean.valueOf(z));
        if (z) {
            this.nHP.exit();
            b bVar = this.nHR;
            this.nHP = bVar;
            bVar.enter();
        }
        AppMethodBeat.o(230540);
        return z;
    }

    /* access modifiers changed from: package-private */
    public final class c implements a {
        private long nHW;

        private c() {
        }

        /* synthetic */ c(v vVar, byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.appbrand.report.v.a
        public final void enter() {
            AppMethodBeat.i(139915);
            this.nHW = Util.nowMilliSecond();
            AppMethodBeat.o(139915);
        }

        @Override // com.tencent.mm.plugin.appbrand.report.v.a
        public final void exit() {
            AppMethodBeat.i(139916);
            v.this.nHT = Util.nowMilliSecond() - this.nHW;
            AppMethodBeat.o(139916);
        }

        @Override // com.tencent.mm.plugin.appbrand.report.v.a
        public final long getStartTime() {
            return this.nHW;
        }
    }

    /* access modifiers changed from: package-private */
    public final class b implements a {
        private long nHU;

        private b() {
        }

        /* synthetic */ b(v vVar, byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.appbrand.report.v.a
        public final void enter() {
            AppMethodBeat.i(139911);
            this.nHU = Util.nowMilliSecond();
            AppMethodBeat.o(139911);
        }

        @Override // com.tencent.mm.plugin.appbrand.report.v.a
        public final void exit() {
            AppMethodBeat.i(139912);
            v.this.nHS = Util.nowMilliSecond() - this.nHU;
            AppMethodBeat.o(139912);
        }

        @Override // com.tencent.mm.plugin.appbrand.report.v.a
        public final long getStartTime() {
            return this.nHU;
        }
    }

    public final class d implements a {
        private d() {
        }

        public /* synthetic */ d(v vVar, byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.appbrand.report.v.a
        public final void enter() {
        }

        @Override // com.tencent.mm.plugin.appbrand.report.v.a
        public final void exit() {
        }

        @Override // com.tencent.mm.plugin.appbrand.report.v.a
        public final long getStartTime() {
            return 0;
        }
    }
}
