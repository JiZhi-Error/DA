package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.api.TPOptionalID;

public final class zzabv {
    private final byte[] buffer;
    private int zzbrd = 64;
    private int zzbre = 67108864;
    private int zzbri;
    private int zzbrk = Integer.MAX_VALUE;
    private final int zzbwp;
    private final int zzbwq;
    private int zzbwr;
    private int zzbws;
    private int zzbwt;
    private int zzbwu;

    private zzabv(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(40234);
        this.buffer = bArr;
        this.zzbwp = i2;
        int i4 = i2 + i3;
        this.zzbwr = i4;
        this.zzbwq = i4;
        this.zzbws = i2;
        AppMethodBeat.o(40234);
    }

    public static zzabv zza(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(40222);
        zzabv zzabv = new zzabv(bArr, 0, i3);
        AppMethodBeat.o(40222);
        return zzabv;
    }

    private final void zzan(int i2) {
        AppMethodBeat.i(40241);
        if (i2 < 0) {
            zzacd zzvi = zzacd.zzvi();
            AppMethodBeat.o(40241);
            throw zzvi;
        } else if (this.zzbws + i2 > this.zzbrk) {
            zzan(this.zzbrk - this.zzbws);
            zzacd zzvh = zzacd.zzvh();
            AppMethodBeat.o(40241);
            throw zzvh;
        } else if (i2 <= this.zzbwr - this.zzbws) {
            this.zzbws += i2;
            AppMethodBeat.o(40241);
        } else {
            zzacd zzvh2 = zzacd.zzvh();
            AppMethodBeat.o(40241);
            throw zzvh2;
        }
    }

    public static zzabv zzi(byte[] bArr) {
        AppMethodBeat.i(40221);
        zzabv zza = zza(bArr, 0, bArr.length);
        AppMethodBeat.o(40221);
        return zza;
    }

    private final void zzta() {
        this.zzbwr += this.zzbri;
        int i2 = this.zzbwr;
        if (i2 > this.zzbrk) {
            this.zzbri = i2 - this.zzbrk;
            this.zzbwr -= this.zzbri;
            return;
        }
        this.zzbri = 0;
    }

    private final byte zzvd() {
        AppMethodBeat.i(40240);
        if (this.zzbws == this.zzbwr) {
            zzacd zzvh = zzacd.zzvh();
            AppMethodBeat.o(40240);
            throw zzvh;
        }
        byte[] bArr = this.buffer;
        int i2 = this.zzbws;
        this.zzbws = i2 + 1;
        byte b2 = bArr[i2];
        AppMethodBeat.o(40240);
        return b2;
    }

    public final int getPosition() {
        return this.zzbws - this.zzbwp;
    }

    public final String readString() {
        AppMethodBeat.i(40227);
        int zzuy = zzuy();
        if (zzuy < 0) {
            zzacd zzvi = zzacd.zzvi();
            AppMethodBeat.o(40227);
            throw zzvi;
        } else if (zzuy > this.zzbwr - this.zzbws) {
            zzacd zzvh = zzacd.zzvh();
            AppMethodBeat.o(40227);
            throw zzvh;
        } else {
            String str = new String(this.buffer, this.zzbws, zzuy, zzacc.UTF_8);
            this.zzbws = zzuy + this.zzbws;
            AppMethodBeat.o(40227);
            return str;
        }
    }

    public final void zza(zzace zzace) {
        AppMethodBeat.i(40229);
        int zzuy = zzuy();
        if (this.zzbwu >= this.zzbrd) {
            zzacd zzvk = zzacd.zzvk();
            AppMethodBeat.o(40229);
            throw zzvk;
        }
        int zzaf = zzaf(zzuy);
        this.zzbwu++;
        zzace.zzb(this);
        zzaj(0);
        this.zzbwu--;
        zzal(zzaf);
        AppMethodBeat.o(40229);
    }

    public final void zza(zzace zzace, int i2) {
        AppMethodBeat.i(40228);
        if (this.zzbwu >= this.zzbrd) {
            zzacd zzvk = zzacd.zzvk();
            AppMethodBeat.o(40228);
            throw zzvk;
        }
        this.zzbwu++;
        zzace.zzb(this);
        zzaj((i2 << 3) | 4);
        this.zzbwu--;
        AppMethodBeat.o(40228);
    }

    public final int zzaf(int i2) {
        AppMethodBeat.i(40235);
        if (i2 < 0) {
            zzacd zzvi = zzacd.zzvi();
            AppMethodBeat.o(40235);
            throw zzvi;
        }
        int i3 = this.zzbws + i2;
        int i4 = this.zzbrk;
        if (i3 > i4) {
            zzacd zzvh = zzacd.zzvh();
            AppMethodBeat.o(40235);
            throw zzvh;
        }
        this.zzbrk = i3;
        zzta();
        AppMethodBeat.o(40235);
        return i4;
    }

    public final void zzaj(int i2) {
        AppMethodBeat.i(40224);
        if (this.zzbwt != i2) {
            zzacd zzacd = new zzacd("Protocol message end-group tag did not match expected tag.");
            AppMethodBeat.o(40224);
            throw zzacd;
        }
        AppMethodBeat.o(40224);
    }

    public final boolean zzak(int i2) {
        int zzuw;
        AppMethodBeat.i(40225);
        switch (i2 & 7) {
            case 0:
                zzuy();
                AppMethodBeat.o(40225);
                return true;
            case 1:
                zzvb();
                AppMethodBeat.o(40225);
                return true;
            case 2:
                zzan(zzuy());
                AppMethodBeat.o(40225);
                return true;
            case 3:
                break;
            case 4:
                AppMethodBeat.o(40225);
                return false;
            case 5:
                zzva();
                AppMethodBeat.o(40225);
                return true;
            default:
                zzacd zzacd = new zzacd("Protocol message tag had invalid wire type.");
                AppMethodBeat.o(40225);
                throw zzacd;
        }
        do {
            zzuw = zzuw();
            if (zzuw != 0) {
            }
            zzaj(((i2 >>> 3) << 3) | 4);
            AppMethodBeat.o(40225);
            return true;
        } while (zzak(zzuw));
        zzaj(((i2 >>> 3) << 3) | 4);
        AppMethodBeat.o(40225);
        return true;
    }

    public final void zzal(int i2) {
        AppMethodBeat.i(40236);
        this.zzbrk = i2;
        zzta();
        AppMethodBeat.o(40236);
    }

    public final void zzam(int i2) {
        AppMethodBeat.i(40238);
        zzd(i2, this.zzbwt);
        AppMethodBeat.o(40238);
    }

    public final byte[] zzc(int i2, int i3) {
        AppMethodBeat.i(40237);
        if (i3 == 0) {
            byte[] bArr = zzach.zzbxs;
            AppMethodBeat.o(40237);
            return bArr;
        }
        byte[] bArr2 = new byte[i3];
        System.arraycopy(this.buffer, this.zzbwp + i2, bArr2, 0, i3);
        AppMethodBeat.o(40237);
        return bArr2;
    }

    /* access modifiers changed from: package-private */
    public final void zzd(int i2, int i3) {
        AppMethodBeat.i(40239);
        if (i2 > this.zzbws - this.zzbwp) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(new StringBuilder(50).append("Position ").append(i2).append(" is beyond current ").append(this.zzbws - this.zzbwp).toString());
            AppMethodBeat.o(40239);
            throw illegalArgumentException;
        } else if (i2 < 0) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(new StringBuilder(24).append("Bad position ").append(i2).toString());
            AppMethodBeat.o(40239);
            throw illegalArgumentException2;
        } else {
            this.zzbws = this.zzbwp + i2;
            this.zzbwt = i3;
            AppMethodBeat.o(40239);
        }
    }

    public final int zzuw() {
        AppMethodBeat.i(40223);
        if (this.zzbws == this.zzbwr) {
            this.zzbwt = 0;
            AppMethodBeat.o(40223);
            return 0;
        }
        this.zzbwt = zzuy();
        if (this.zzbwt == 0) {
            zzacd zzacd = new zzacd("Protocol message contained an invalid tag (zero).");
            AppMethodBeat.o(40223);
            throw zzacd;
        }
        int i2 = this.zzbwt;
        AppMethodBeat.o(40223);
        return i2;
    }

    public final boolean zzux() {
        AppMethodBeat.i(40226);
        if (zzuy() != 0) {
            AppMethodBeat.o(40226);
            return true;
        }
        AppMethodBeat.o(40226);
        return false;
    }

    public final int zzuy() {
        AppMethodBeat.i(40230);
        int zzvd = zzvd();
        if (zzvd >= 0) {
            AppMethodBeat.o(40230);
        } else {
            int i2 = zzvd & TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH;
            byte zzvd2 = zzvd();
            if (zzvd2 >= 0) {
                zzvd = i2 | (zzvd2 << 7);
            } else {
                int i3 = i2 | ((zzvd2 & Byte.MAX_VALUE) << 7);
                byte zzvd3 = zzvd();
                if (zzvd3 >= 0) {
                    zzvd = i3 | (zzvd3 << 14);
                } else {
                    int i4 = i3 | ((zzvd3 & Byte.MAX_VALUE) << 14);
                    byte zzvd4 = zzvd();
                    if (zzvd4 >= 0) {
                        zzvd = i4 | (zzvd4 << 21);
                    } else {
                        int i5 = i4 | ((zzvd4 & Byte.MAX_VALUE) << 21);
                        byte zzvd5 = zzvd();
                        zzvd = i5 | (zzvd5 << 28);
                        if (zzvd5 < 0) {
                            for (int i6 = 0; i6 < 5; i6++) {
                                if (zzvd() >= 0) {
                                    AppMethodBeat.o(40230);
                                }
                            }
                            zzacd zzvj = zzacd.zzvj();
                            AppMethodBeat.o(40230);
                            throw zzvj;
                        }
                    }
                }
            }
            AppMethodBeat.o(40230);
        }
        return zzvd;
    }

    public final long zzuz() {
        AppMethodBeat.i(40231);
        long j2 = 0;
        for (int i2 = 0; i2 < 64; i2 += 7) {
            byte zzvd = zzvd();
            j2 |= ((long) (zzvd & Byte.MAX_VALUE)) << i2;
            if ((zzvd & 128) == 0) {
                AppMethodBeat.o(40231);
                return j2;
            }
        }
        zzacd zzvj = zzacd.zzvj();
        AppMethodBeat.o(40231);
        throw zzvj;
    }

    public final int zzva() {
        AppMethodBeat.i(40232);
        int zzvd = (zzvd() & 255) | ((zzvd() & 255) << 8) | ((zzvd() & 255) << 16) | ((zzvd() & 255) << 24);
        AppMethodBeat.o(40232);
        return zzvd;
    }

    public final long zzvb() {
        AppMethodBeat.i(40233);
        byte zzvd = zzvd();
        byte zzvd2 = zzvd();
        long j2 = (((long) zzvd2) & 255) << 8;
        long zzvd3 = j2 | (((long) zzvd) & 255) | ((((long) zzvd()) & 255) << 16) | ((((long) zzvd()) & 255) << 24) | ((((long) zzvd()) & 255) << 32) | ((((long) zzvd()) & 255) << 40) | ((((long) zzvd()) & 255) << 48) | ((((long) zzvd()) & 255) << 56);
        AppMethodBeat.o(40233);
        return zzvd3;
    }

    public final int zzvc() {
        if (this.zzbrk == Integer.MAX_VALUE) {
            return -1;
        }
        return this.zzbrk - this.zzbws;
    }
}
