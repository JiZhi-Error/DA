package com.google.android.gms.internal.measurement;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public class zzhg implements zzhi {
    protected final zzgl zzacw;

    zzhg(zzgl zzgl) {
        AppMethodBeat.i(1651);
        Preconditions.checkNotNull(zzgl);
        this.zzacw = zzgl;
        AppMethodBeat.o(1651);
    }

    @Override // com.google.android.gms.internal.measurement.zzec
    public Context getContext() {
        AppMethodBeat.i(1660);
        Context context = this.zzacw.getContext();
        AppMethodBeat.o(1660);
        return context;
    }

    public void zzab() {
        AppMethodBeat.i(1668);
        this.zzacw.zzgd().zzab();
        AppMethodBeat.o(1668);
    }

    @Override // com.google.android.gms.internal.measurement.zzec
    public Clock zzbt() {
        AppMethodBeat.i(1661);
        Clock zzbt = this.zzacw.zzbt();
        AppMethodBeat.o(1661);
        return zzbt;
    }

    public void zzfr() {
        AppMethodBeat.i(1670);
        zzgl.zzfr();
        AppMethodBeat.o(1670);
    }

    public void zzfs() {
        AppMethodBeat.i(1669);
        this.zzacw.zzgd().zzfs();
        AppMethodBeat.o(1669);
    }

    public zzdu zzft() {
        AppMethodBeat.i(1667);
        zzdu zzft = this.zzacw.zzft();
        AppMethodBeat.o(1667);
        return zzft;
    }

    public zzhk zzfu() {
        AppMethodBeat.i(1666);
        zzhk zzfu = this.zzacw.zzfu();
        AppMethodBeat.o(1666);
        return zzfu;
    }

    public zzfb zzfv() {
        AppMethodBeat.i(1665);
        zzfb zzfv = this.zzacw.zzfv();
        AppMethodBeat.o(1665);
        return zzfv;
    }

    public zzeo zzfw() {
        AppMethodBeat.i(1664);
        zzeo zzfw = this.zzacw.zzfw();
        AppMethodBeat.o(1664);
        return zzfw;
    }

    public zzii zzfx() {
        AppMethodBeat.i(1663);
        zzii zzfx = this.zzacw.zzfx();
        AppMethodBeat.o(1663);
        return zzfx;
    }

    public zzif zzfy() {
        AppMethodBeat.i(1662);
        zzif zzfy = this.zzacw.zzfy();
        AppMethodBeat.o(1662);
        return zzfy;
    }

    public zzfc zzfz() {
        AppMethodBeat.i(1659);
        zzfc zzfz = this.zzacw.zzfz();
        AppMethodBeat.o(1659);
        return zzfz;
    }

    public zzfe zzga() {
        AppMethodBeat.i(1658);
        zzfe zzga = this.zzacw.zzga();
        AppMethodBeat.o(1658);
        return zzga;
    }

    public zzka zzgb() {
        AppMethodBeat.i(1657);
        zzka zzgb = this.zzacw.zzgb();
        AppMethodBeat.o(1657);
        return zzgb;
    }

    public zzjh zzgc() {
        AppMethodBeat.i(1656);
        zzjh zzgc = this.zzacw.zzgc();
        AppMethodBeat.o(1656);
        return zzgc;
    }

    @Override // com.google.android.gms.internal.measurement.zzec
    public zzgg zzgd() {
        AppMethodBeat.i(1655);
        zzgg zzgd = this.zzacw.zzgd();
        AppMethodBeat.o(1655);
        return zzgd;
    }

    @Override // com.google.android.gms.internal.measurement.zzec
    public zzfg zzge() {
        AppMethodBeat.i(1654);
        zzfg zzge = this.zzacw.zzge();
        AppMethodBeat.o(1654);
        return zzge;
    }

    public zzfr zzgf() {
        AppMethodBeat.i(1653);
        zzfr zzgf = this.zzacw.zzgf();
        AppMethodBeat.o(1653);
        return zzgf;
    }

    public zzef zzgg() {
        AppMethodBeat.i(1652);
        zzef zzgg = this.zzacw.zzgg();
        AppMethodBeat.o(1652);
        return zzgg;
    }
}
