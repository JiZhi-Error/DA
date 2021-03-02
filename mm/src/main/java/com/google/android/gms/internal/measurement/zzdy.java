package com.google.android.gms.internal.measurement;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzdy {
    private final zzgl zzacw;
    private String zzadl;
    private String zzadm;
    private String zzadn;
    private String zzado;
    private long zzadp;
    private long zzadq;
    private long zzadr;
    private long zzads;
    private String zzadt;
    private long zzadu;
    private long zzadv;
    private boolean zzadw;
    private long zzadx;
    private boolean zzady;
    private boolean zzadz;
    private long zzaea;
    private long zzaeb;
    private long zzaec;
    private long zzaed;
    private long zzaee;
    private long zzaef;
    private String zzaeg;
    private boolean zzaeh;
    private long zzaei;
    private long zzaej;
    private String zzth;
    private final String zzti;

    zzdy(zzgl zzgl, String str) {
        AppMethodBeat.i(1048);
        Preconditions.checkNotNull(zzgl);
        Preconditions.checkNotEmpty(str);
        this.zzacw = zzgl;
        this.zzti = str;
        this.zzacw.zzab();
        AppMethodBeat.o(1048);
    }

    public final String getAppInstanceId() {
        AppMethodBeat.i(1051);
        this.zzacw.zzab();
        String str = this.zzadl;
        AppMethodBeat.o(1051);
        return str;
    }

    public final String getGmpAppId() {
        AppMethodBeat.i(1053);
        this.zzacw.zzab();
        String str = this.zzadm;
        AppMethodBeat.o(1053);
        return str;
    }

    public final boolean isMeasurementEnabled() {
        AppMethodBeat.i(1073);
        this.zzacw.zzab();
        boolean z = this.zzadw;
        AppMethodBeat.o(1073);
        return z;
    }

    public final void setAppVersion(String str) {
        AppMethodBeat.i(1064);
        this.zzacw.zzab();
        this.zzaeh = (!zzka.zzs(this.zzth, str)) | this.zzaeh;
        this.zzth = str;
        AppMethodBeat.o(1064);
    }

    public final void setMeasurementEnabled(boolean z) {
        AppMethodBeat.i(1074);
        this.zzacw.zzab();
        this.zzaeh = (this.zzadw != z) | this.zzaeh;
        this.zzadw = z;
        AppMethodBeat.o(1074);
    }

    public final void zzaa(long j2) {
        AppMethodBeat.i(1098);
        this.zzacw.zzab();
        this.zzaeh = (this.zzadx != j2) | this.zzaeh;
        this.zzadx = j2;
        AppMethodBeat.o(1098);
    }

    public final String zzag() {
        AppMethodBeat.i(1063);
        this.zzacw.zzab();
        String str = this.zzth;
        AppMethodBeat.o(1063);
        return str;
    }

    public final String zzah() {
        AppMethodBeat.i(1050);
        this.zzacw.zzab();
        String str = this.zzti;
        AppMethodBeat.o(1050);
        return str;
    }

    public final void zzal(String str) {
        AppMethodBeat.i(1052);
        this.zzacw.zzab();
        this.zzaeh = (!zzka.zzs(this.zzadl, str)) | this.zzaeh;
        this.zzadl = str;
        AppMethodBeat.o(1052);
    }

    public final void zzam(String str) {
        AppMethodBeat.i(1054);
        this.zzacw.zzab();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.zzaeh = (!zzka.zzs(this.zzadm, str)) | this.zzaeh;
        this.zzadm = str;
        AppMethodBeat.o(1054);
    }

    public final void zzan(String str) {
        AppMethodBeat.i(1056);
        this.zzacw.zzab();
        this.zzaeh = (!zzka.zzs(this.zzadn, str)) | this.zzaeh;
        this.zzadn = str;
        AppMethodBeat.o(1056);
    }

    public final void zzao(String str) {
        AppMethodBeat.i(1058);
        this.zzacw.zzab();
        this.zzaeh = (!zzka.zzs(this.zzado, str)) | this.zzaeh;
        this.zzado = str;
        AppMethodBeat.o(1058);
    }

    public final void zzap(String str) {
        AppMethodBeat.i(1068);
        this.zzacw.zzab();
        this.zzaeh = (!zzka.zzs(this.zzadt, str)) | this.zzaeh;
        this.zzadt = str;
        AppMethodBeat.o(1068);
    }

    public final void zzaq(String str) {
        AppMethodBeat.i(1096);
        this.zzacw.zzab();
        this.zzaeh = (!zzka.zzs(this.zzaeg, str)) | this.zzaeh;
        this.zzaeg = str;
        AppMethodBeat.o(1096);
    }

    public final void zzd(boolean z) {
        AppMethodBeat.i(1100);
        this.zzacw.zzab();
        this.zzaeh = this.zzady != z;
        this.zzady = z;
        AppMethodBeat.o(1100);
    }

    public final void zze(boolean z) {
        AppMethodBeat.i(1102);
        this.zzacw.zzab();
        this.zzaeh = this.zzadz != z;
        this.zzadz = z;
        AppMethodBeat.o(1102);
    }

    public final void zzgh() {
        AppMethodBeat.i(1049);
        this.zzacw.zzab();
        this.zzaeh = false;
        AppMethodBeat.o(1049);
    }

    public final String zzgi() {
        AppMethodBeat.i(1055);
        this.zzacw.zzab();
        String str = this.zzadn;
        AppMethodBeat.o(1055);
        return str;
    }

    public final String zzgj() {
        AppMethodBeat.i(1057);
        this.zzacw.zzab();
        String str = this.zzado;
        AppMethodBeat.o(1057);
        return str;
    }

    public final long zzgk() {
        AppMethodBeat.i(1059);
        this.zzacw.zzab();
        long j2 = this.zzadq;
        AppMethodBeat.o(1059);
        return j2;
    }

    public final long zzgl() {
        AppMethodBeat.i(1061);
        this.zzacw.zzab();
        long j2 = this.zzadr;
        AppMethodBeat.o(1061);
        return j2;
    }

    public final long zzgm() {
        AppMethodBeat.i(1065);
        this.zzacw.zzab();
        long j2 = this.zzads;
        AppMethodBeat.o(1065);
        return j2;
    }

    public final String zzgn() {
        AppMethodBeat.i(1067);
        this.zzacw.zzab();
        String str = this.zzadt;
        AppMethodBeat.o(1067);
        return str;
    }

    public final long zzgo() {
        AppMethodBeat.i(1069);
        this.zzacw.zzab();
        long j2 = this.zzadu;
        AppMethodBeat.o(1069);
        return j2;
    }

    public final long zzgp() {
        AppMethodBeat.i(1071);
        this.zzacw.zzab();
        long j2 = this.zzadv;
        AppMethodBeat.o(1071);
        return j2;
    }

    public final long zzgq() {
        AppMethodBeat.i(1076);
        this.zzacw.zzab();
        long j2 = this.zzadp;
        AppMethodBeat.o(1076);
        return j2;
    }

    public final long zzgr() {
        AppMethodBeat.i(1077);
        this.zzacw.zzab();
        long j2 = this.zzaei;
        AppMethodBeat.o(1077);
        return j2;
    }

    public final long zzgs() {
        AppMethodBeat.i(1079);
        this.zzacw.zzab();
        long j2 = this.zzaej;
        AppMethodBeat.o(1079);
        return j2;
    }

    public final void zzgt() {
        AppMethodBeat.i(1081);
        this.zzacw.zzab();
        long j2 = this.zzadp + 1;
        if (j2 > 2147483647L) {
            this.zzacw.zzge().zzip().zzg("Bundle index overflow. appId", zzfg.zzbm(this.zzti));
            j2 = 0;
        }
        this.zzaeh = true;
        this.zzadp = j2;
        AppMethodBeat.o(1081);
    }

    public final long zzgu() {
        AppMethodBeat.i(1082);
        this.zzacw.zzab();
        long j2 = this.zzaea;
        AppMethodBeat.o(1082);
        return j2;
    }

    public final long zzgv() {
        AppMethodBeat.i(1084);
        this.zzacw.zzab();
        long j2 = this.zzaeb;
        AppMethodBeat.o(1084);
        return j2;
    }

    public final long zzgw() {
        AppMethodBeat.i(1086);
        this.zzacw.zzab();
        long j2 = this.zzaec;
        AppMethodBeat.o(1086);
        return j2;
    }

    public final long zzgx() {
        AppMethodBeat.i(1088);
        this.zzacw.zzab();
        long j2 = this.zzaed;
        AppMethodBeat.o(1088);
        return j2;
    }

    public final long zzgy() {
        AppMethodBeat.i(1090);
        this.zzacw.zzab();
        long j2 = this.zzaef;
        AppMethodBeat.o(1090);
        return j2;
    }

    public final long zzgz() {
        AppMethodBeat.i(1092);
        this.zzacw.zzab();
        long j2 = this.zzaee;
        AppMethodBeat.o(1092);
        return j2;
    }

    public final String zzha() {
        AppMethodBeat.i(1094);
        this.zzacw.zzab();
        String str = this.zzaeg;
        AppMethodBeat.o(1094);
        return str;
    }

    public final String zzhb() {
        AppMethodBeat.i(1095);
        this.zzacw.zzab();
        String str = this.zzaeg;
        zzaq(null);
        AppMethodBeat.o(1095);
        return str;
    }

    public final long zzhc() {
        AppMethodBeat.i(1097);
        this.zzacw.zzab();
        long j2 = this.zzadx;
        AppMethodBeat.o(1097);
        return j2;
    }

    public final boolean zzhd() {
        AppMethodBeat.i(1099);
        this.zzacw.zzab();
        boolean z = this.zzady;
        AppMethodBeat.o(1099);
        return z;
    }

    public final boolean zzhe() {
        AppMethodBeat.i(1101);
        this.zzacw.zzab();
        boolean z = this.zzadz;
        AppMethodBeat.o(1101);
        return z;
    }

    public final void zzm(long j2) {
        AppMethodBeat.i(1060);
        this.zzacw.zzab();
        this.zzaeh = (this.zzadq != j2) | this.zzaeh;
        this.zzadq = j2;
        AppMethodBeat.o(1060);
    }

    public final void zzn(long j2) {
        AppMethodBeat.i(1062);
        this.zzacw.zzab();
        this.zzaeh = (this.zzadr != j2) | this.zzaeh;
        this.zzadr = j2;
        AppMethodBeat.o(1062);
    }

    public final void zzo(long j2) {
        AppMethodBeat.i(1066);
        this.zzacw.zzab();
        this.zzaeh = (this.zzads != j2) | this.zzaeh;
        this.zzads = j2;
        AppMethodBeat.o(1066);
    }

    public final void zzp(long j2) {
        AppMethodBeat.i(1070);
        this.zzacw.zzab();
        this.zzaeh = (this.zzadu != j2) | this.zzaeh;
        this.zzadu = j2;
        AppMethodBeat.o(1070);
    }

    public final void zzq(long j2) {
        AppMethodBeat.i(1072);
        this.zzacw.zzab();
        this.zzaeh = (this.zzadv != j2) | this.zzaeh;
        this.zzadv = j2;
        AppMethodBeat.o(1072);
    }

    public final void zzr(long j2) {
        boolean z = true;
        AppMethodBeat.i(1075);
        Preconditions.checkArgument(j2 >= 0);
        this.zzacw.zzab();
        boolean z2 = this.zzaeh;
        if (this.zzadp == j2) {
            z = false;
        }
        this.zzaeh = z2 | z;
        this.zzadp = j2;
        AppMethodBeat.o(1075);
    }

    public final void zzs(long j2) {
        AppMethodBeat.i(1078);
        this.zzacw.zzab();
        this.zzaeh = (this.zzaei != j2) | this.zzaeh;
        this.zzaei = j2;
        AppMethodBeat.o(1078);
    }

    public final void zzt(long j2) {
        AppMethodBeat.i(1080);
        this.zzacw.zzab();
        this.zzaeh = (this.zzaej != j2) | this.zzaeh;
        this.zzaej = j2;
        AppMethodBeat.o(1080);
    }

    public final void zzu(long j2) {
        AppMethodBeat.i(1083);
        this.zzacw.zzab();
        this.zzaeh = (this.zzaea != j2) | this.zzaeh;
        this.zzaea = j2;
        AppMethodBeat.o(1083);
    }

    public final void zzv(long j2) {
        AppMethodBeat.i(1085);
        this.zzacw.zzab();
        this.zzaeh = (this.zzaeb != j2) | this.zzaeh;
        this.zzaeb = j2;
        AppMethodBeat.o(1085);
    }

    public final void zzw(long j2) {
        AppMethodBeat.i(1087);
        this.zzacw.zzab();
        this.zzaeh = (this.zzaec != j2) | this.zzaeh;
        this.zzaec = j2;
        AppMethodBeat.o(1087);
    }

    public final void zzx(long j2) {
        AppMethodBeat.i(1089);
        this.zzacw.zzab();
        this.zzaeh = (this.zzaed != j2) | this.zzaeh;
        this.zzaed = j2;
        AppMethodBeat.o(1089);
    }

    public final void zzy(long j2) {
        AppMethodBeat.i(1091);
        this.zzacw.zzab();
        this.zzaeh = (this.zzaef != j2) | this.zzaeh;
        this.zzaef = j2;
        AppMethodBeat.o(1091);
    }

    public final void zzz(long j2) {
        AppMethodBeat.i(1093);
        this.zzacw.zzab();
        this.zzaeh = (this.zzaee != j2) | this.zzaeh;
        this.zzaee = j2;
        AppMethodBeat.o(1093);
    }
}
