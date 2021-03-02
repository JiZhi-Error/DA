package com.google.android.gms.internal.wearable;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.api.TPOptionalID;

public final class zzk {
    private final byte[] buffer;
    private final int zzgr;
    private final int zzgs;
    private int zzgt;
    private int zzgu;
    private int zzgv;
    private int zzgw;
    private int zzgx = Integer.MAX_VALUE;
    private int zzgy;
    private int zzgz = 64;
    private int zzha = 67108864;

    private zzk(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(100698);
        this.buffer = bArr;
        this.zzgr = i2;
        int i4 = i2 + i3;
        this.zzgt = i4;
        this.zzgs = i4;
        this.zzgv = i2;
        AppMethodBeat.o(100698);
    }

    public static zzk zza(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(100687);
        zzk zzk = new zzk(bArr, 0, i3);
        AppMethodBeat.o(100687);
        return zzk;
    }

    private final void zzh(int i2) {
        AppMethodBeat.i(100705);
        if (i2 < 0) {
            zzs zzv = zzs.zzv();
            AppMethodBeat.o(100705);
            throw zzv;
        } else if (this.zzgv + i2 > this.zzgx) {
            zzh(this.zzgx - this.zzgv);
            zzs zzu = zzs.zzu();
            AppMethodBeat.o(100705);
            throw zzu;
        } else if (i2 <= this.zzgt - this.zzgv) {
            this.zzgv += i2;
            AppMethodBeat.o(100705);
        } else {
            zzs zzu2 = zzs.zzu();
            AppMethodBeat.o(100705);
            throw zzu2;
        }
    }

    private final void zzo() {
        this.zzgt += this.zzgu;
        int i2 = this.zzgt;
        if (i2 > this.zzgx) {
            this.zzgu = i2 - this.zzgx;
            this.zzgt -= this.zzgu;
            return;
        }
        this.zzgu = 0;
    }

    private final byte zzq() {
        AppMethodBeat.i(100704);
        if (this.zzgv == this.zzgt) {
            zzs zzu = zzs.zzu();
            AppMethodBeat.o(100704);
            throw zzu;
        }
        byte[] bArr = this.buffer;
        int i2 = this.zzgv;
        this.zzgv = i2 + 1;
        byte b2 = bArr[i2];
        AppMethodBeat.o(100704);
        return b2;
    }

    public final int getPosition() {
        return this.zzgv - this.zzgr;
    }

    public final byte[] readBytes() {
        AppMethodBeat.i(100693);
        int zzk = zzk();
        if (zzk < 0) {
            zzs zzv = zzs.zzv();
            AppMethodBeat.o(100693);
            throw zzv;
        } else if (zzk == 0) {
            byte[] bArr = zzw.zzhy;
            AppMethodBeat.o(100693);
            return bArr;
        } else if (zzk > this.zzgt - this.zzgv) {
            zzs zzu = zzs.zzu();
            AppMethodBeat.o(100693);
            throw zzu;
        } else {
            byte[] bArr2 = new byte[zzk];
            System.arraycopy(this.buffer, this.zzgv, bArr2, 0, zzk);
            this.zzgv = zzk + this.zzgv;
            AppMethodBeat.o(100693);
            return bArr2;
        }
    }

    public final String readString() {
        AppMethodBeat.i(100691);
        int zzk = zzk();
        if (zzk < 0) {
            zzs zzv = zzs.zzv();
            AppMethodBeat.o(100691);
            throw zzv;
        } else if (zzk > this.zzgt - this.zzgv) {
            zzs zzu = zzs.zzu();
            AppMethodBeat.o(100691);
            throw zzu;
        } else {
            String str = new String(this.buffer, this.zzgv, zzk, zzr.UTF_8);
            this.zzgv = zzk + this.zzgv;
            AppMethodBeat.o(100691);
            return str;
        }
    }

    public final void zza(zzt zzt) {
        AppMethodBeat.i(100692);
        int zzk = zzk();
        if (this.zzgy >= this.zzgz) {
            zzs zzs = new zzs("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
            AppMethodBeat.o(100692);
            throw zzs;
        }
        int zze = zze(zzk);
        this.zzgy++;
        zzt.zza(this);
        zzc(0);
        this.zzgy--;
        zzf(zze);
        AppMethodBeat.o(100692);
    }

    public final byte[] zzb(int i2, int i3) {
        AppMethodBeat.i(100701);
        if (i3 == 0) {
            byte[] bArr = zzw.zzhy;
            AppMethodBeat.o(100701);
            return bArr;
        }
        byte[] bArr2 = new byte[i3];
        System.arraycopy(this.buffer, this.zzgr + i2, bArr2, 0, i3);
        AppMethodBeat.o(100701);
        return bArr2;
    }

    public final void zzc(int i2) {
        AppMethodBeat.i(100689);
        if (this.zzgw != i2) {
            zzs zzs = new zzs("Protocol message end-group tag did not match expected tag.");
            AppMethodBeat.o(100689);
            throw zzs;
        }
        AppMethodBeat.o(100689);
    }

    /* access modifiers changed from: package-private */
    public final void zzc(int i2, int i3) {
        AppMethodBeat.i(100703);
        if (i2 > this.zzgv - this.zzgr) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(new StringBuilder(50).append("Position ").append(i2).append(" is beyond current ").append(this.zzgv - this.zzgr).toString());
            AppMethodBeat.o(100703);
            throw illegalArgumentException;
        } else if (i2 < 0) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(new StringBuilder(24).append("Bad position ").append(i2).toString());
            AppMethodBeat.o(100703);
            throw illegalArgumentException2;
        } else {
            this.zzgv = this.zzgr + i2;
            this.zzgw = i3;
            AppMethodBeat.o(100703);
        }
    }

    public final boolean zzd(int i2) {
        int zzj;
        AppMethodBeat.i(100690);
        switch (i2 & 7) {
            case 0:
                zzk();
                AppMethodBeat.o(100690);
                return true;
            case 1:
                zzn();
                AppMethodBeat.o(100690);
                return true;
            case 2:
                zzh(zzk());
                AppMethodBeat.o(100690);
                return true;
            case 3:
                break;
            case 4:
                AppMethodBeat.o(100690);
                return false;
            case 5:
                zzm();
                AppMethodBeat.o(100690);
                return true;
            default:
                zzs zzs = new zzs("Protocol message tag had invalid wire type.");
                AppMethodBeat.o(100690);
                throw zzs;
        }
        do {
            zzj = zzj();
            if (zzj != 0) {
            }
            zzc(((i2 >>> 3) << 3) | 4);
            AppMethodBeat.o(100690);
            return true;
        } while (zzd(zzj));
        zzc(((i2 >>> 3) << 3) | 4);
        AppMethodBeat.o(100690);
        return true;
    }

    public final int zze(int i2) {
        AppMethodBeat.i(100699);
        if (i2 < 0) {
            zzs zzv = zzs.zzv();
            AppMethodBeat.o(100699);
            throw zzv;
        }
        int i3 = this.zzgv + i2;
        int i4 = this.zzgx;
        if (i3 > i4) {
            zzs zzu = zzs.zzu();
            AppMethodBeat.o(100699);
            throw zzu;
        }
        this.zzgx = i3;
        zzo();
        AppMethodBeat.o(100699);
        return i4;
    }

    public final void zzf(int i2) {
        AppMethodBeat.i(100700);
        this.zzgx = i2;
        zzo();
        AppMethodBeat.o(100700);
    }

    public final void zzg(int i2) {
        AppMethodBeat.i(100702);
        zzc(i2, this.zzgw);
        AppMethodBeat.o(100702);
    }

    public final int zzj() {
        AppMethodBeat.i(100688);
        if (this.zzgv == this.zzgt) {
            this.zzgw = 0;
            AppMethodBeat.o(100688);
            return 0;
        }
        this.zzgw = zzk();
        if (this.zzgw == 0) {
            zzs zzs = new zzs("Protocol message contained an invalid tag (zero).");
            AppMethodBeat.o(100688);
            throw zzs;
        }
        int i2 = this.zzgw;
        AppMethodBeat.o(100688);
        return i2;
    }

    public final int zzk() {
        AppMethodBeat.i(100694);
        int zzq = zzq();
        if (zzq >= 0) {
            AppMethodBeat.o(100694);
        } else {
            int i2 = zzq & TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH;
            byte zzq2 = zzq();
            if (zzq2 >= 0) {
                zzq = i2 | (zzq2 << 7);
            } else {
                int i3 = i2 | ((zzq2 & Byte.MAX_VALUE) << 7);
                byte zzq3 = zzq();
                if (zzq3 >= 0) {
                    zzq = i3 | (zzq3 << 14);
                } else {
                    int i4 = i3 | ((zzq3 & Byte.MAX_VALUE) << 14);
                    byte zzq4 = zzq();
                    if (zzq4 >= 0) {
                        zzq = i4 | (zzq4 << 21);
                    } else {
                        int i5 = i4 | ((zzq4 & Byte.MAX_VALUE) << 21);
                        byte zzq5 = zzq();
                        zzq = i5 | (zzq5 << 28);
                        if (zzq5 < 0) {
                            for (int i6 = 0; i6 < 5; i6++) {
                                if (zzq() >= 0) {
                                    AppMethodBeat.o(100694);
                                }
                            }
                            zzs zzw = zzs.zzw();
                            AppMethodBeat.o(100694);
                            throw zzw;
                        }
                    }
                }
            }
            AppMethodBeat.o(100694);
        }
        return zzq;
    }

    public final long zzl() {
        AppMethodBeat.i(100695);
        long j2 = 0;
        for (int i2 = 0; i2 < 64; i2 += 7) {
            byte zzq = zzq();
            j2 |= ((long) (zzq & Byte.MAX_VALUE)) << i2;
            if ((zzq & 128) == 0) {
                AppMethodBeat.o(100695);
                return j2;
            }
        }
        zzs zzw = zzs.zzw();
        AppMethodBeat.o(100695);
        throw zzw;
    }

    public final int zzm() {
        AppMethodBeat.i(100696);
        int zzq = (zzq() & 255) | ((zzq() & 255) << 8) | ((zzq() & 255) << 16) | ((zzq() & 255) << 24);
        AppMethodBeat.o(100696);
        return zzq;
    }

    public final long zzn() {
        AppMethodBeat.i(100697);
        byte zzq = zzq();
        byte zzq2 = zzq();
        long j2 = (((long) zzq2) & 255) << 8;
        long zzq3 = j2 | (((long) zzq) & 255) | ((((long) zzq()) & 255) << 16) | ((((long) zzq()) & 255) << 24) | ((((long) zzq()) & 255) << 32) | ((((long) zzq()) & 255) << 40) | ((((long) zzq()) & 255) << 48) | ((((long) zzq()) & 255) << 56);
        AppMethodBeat.o(100697);
        return zzq3;
    }

    public final int zzp() {
        if (this.zzgx == Integer.MAX_VALUE) {
            return -1;
        }
        return this.zzgx - this.zzgv;
    }
}
