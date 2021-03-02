package com.google.android.gms.internal.wearable;

import android.support.constraint.ConstraintLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import java.util.Arrays;

public final class zzj extends zzn<zzj> {
    public byte[] zzgd = zzw.zzhy;
    public String zzge = "";
    public double zzgf = 0.0d;
    public float zzgg = 0.0f;
    public long zzgh = 0;
    public int zzgi = 0;
    public int zzgj = 0;
    public boolean zzgk = false;
    public zzh[] zzgl = zzh.zzh();
    public zzi[] zzgm = zzi.zzi();
    public String[] zzgn = zzw.zzhw;
    public long[] zzgo = zzw.zzhs;
    public float[] zzgp = zzw.zzht;
    public long zzgq = 0;

    public zzj() {
        AppMethodBeat.i(100681);
        this.zzhc = null;
        this.zzhl = -1;
        AppMethodBeat.o(100681);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(100682);
        if (obj == this) {
            AppMethodBeat.o(100682);
            return true;
        } else if (!(obj instanceof zzj)) {
            AppMethodBeat.o(100682);
            return false;
        } else {
            zzj zzj = (zzj) obj;
            if (!Arrays.equals(this.zzgd, zzj.zzgd)) {
                AppMethodBeat.o(100682);
                return false;
            }
            if (this.zzge == null) {
                if (zzj.zzge != null) {
                    AppMethodBeat.o(100682);
                    return false;
                }
            } else if (!this.zzge.equals(zzj.zzge)) {
                AppMethodBeat.o(100682);
                return false;
            }
            if (Double.doubleToLongBits(this.zzgf) != Double.doubleToLongBits(zzj.zzgf)) {
                AppMethodBeat.o(100682);
                return false;
            } else if (Float.floatToIntBits(this.zzgg) != Float.floatToIntBits(zzj.zzgg)) {
                AppMethodBeat.o(100682);
                return false;
            } else if (this.zzgh != zzj.zzgh) {
                AppMethodBeat.o(100682);
                return false;
            } else if (this.zzgi != zzj.zzgi) {
                AppMethodBeat.o(100682);
                return false;
            } else if (this.zzgj != zzj.zzgj) {
                AppMethodBeat.o(100682);
                return false;
            } else if (this.zzgk != zzj.zzgk) {
                AppMethodBeat.o(100682);
                return false;
            } else if (!zzr.equals(this.zzgl, zzj.zzgl)) {
                AppMethodBeat.o(100682);
                return false;
            } else if (!zzr.equals(this.zzgm, zzj.zzgm)) {
                AppMethodBeat.o(100682);
                return false;
            } else if (!zzr.equals(this.zzgn, zzj.zzgn)) {
                AppMethodBeat.o(100682);
                return false;
            } else if (!zzr.equals(this.zzgo, zzj.zzgo)) {
                AppMethodBeat.o(100682);
                return false;
            } else if (!zzr.equals(this.zzgp, zzj.zzgp)) {
                AppMethodBeat.o(100682);
                return false;
            } else if (this.zzgq != zzj.zzgq) {
                AppMethodBeat.o(100682);
                return false;
            } else if (this.zzhc != null && !this.zzhc.isEmpty()) {
                boolean equals = this.zzhc.equals(zzj.zzhc);
                AppMethodBeat.o(100682);
                return equals;
            } else if (zzj.zzhc == null || zzj.zzhc.isEmpty()) {
                AppMethodBeat.o(100682);
                return true;
            } else {
                AppMethodBeat.o(100682);
                return false;
            }
        }
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(100683);
        int hashCode = (this.zzge == null ? 0 : this.zzge.hashCode()) + ((((getClass().getName().hashCode() + JsApiGetABTestConfig.CTRL_INDEX) * 31) + Arrays.hashCode(this.zzgd)) * 31);
        long doubleToLongBits = Double.doubleToLongBits(this.zzgf);
        int floatToIntBits = ((((((((((((((this.zzgk ? 1231 : 1237) + (((((((((((hashCode * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + Float.floatToIntBits(this.zzgg)) * 31) + ((int) (this.zzgh ^ (this.zzgh >>> 32)))) * 31) + this.zzgi) * 31) + this.zzgj) * 31)) * 31) + zzr.hashCode(this.zzgl)) * 31) + zzr.hashCode(this.zzgm)) * 31) + zzr.hashCode(this.zzgn)) * 31) + zzr.hashCode(this.zzgo)) * 31) + zzr.hashCode(this.zzgp)) * 31) + ((int) (this.zzgq ^ (this.zzgq >>> 32)))) * 31;
        if (this.zzhc != null && !this.zzhc.isEmpty()) {
            i2 = this.zzhc.hashCode();
        }
        int i3 = floatToIntBits + i2;
        AppMethodBeat.o(100683);
        return i3;
    }

    @Override // com.google.android.gms.internal.wearable.zzt
    public final /* synthetic */ zzt zza(zzk zzk) {
        AppMethodBeat.i(100686);
        while (true) {
            int zzj = zzk.zzj();
            switch (zzj) {
                case 0:
                    AppMethodBeat.o(100686);
                    break;
                case 10:
                    this.zzgd = zzk.readBytes();
                    break;
                case 18:
                    this.zzge = zzk.readString();
                    break;
                case 25:
                    this.zzgf = Double.longBitsToDouble(zzk.zzn());
                    break;
                case 37:
                    this.zzgg = Float.intBitsToFloat(zzk.zzm());
                    break;
                case 40:
                    this.zzgh = zzk.zzl();
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                    this.zzgi = zzk.zzk();
                    break;
                case 56:
                    int zzk2 = zzk.zzk();
                    this.zzgj = (-(zzk2 & 1)) ^ (zzk2 >>> 1);
                    break;
                case 64:
                    this.zzgk = zzk.zzk() != 0;
                    break;
                case 74:
                    int zzb = zzw.zzb(zzk, 74);
                    int length = this.zzgl == null ? 0 : this.zzgl.length;
                    zzh[] zzhArr = new zzh[(zzb + length)];
                    if (length != 0) {
                        System.arraycopy(this.zzgl, 0, zzhArr, 0, length);
                    }
                    while (length < zzhArr.length - 1) {
                        zzhArr[length] = new zzh();
                        zzk.zza(zzhArr[length]);
                        zzk.zzj();
                        length++;
                    }
                    zzhArr[length] = new zzh();
                    zzk.zza(zzhArr[length]);
                    this.zzgl = zzhArr;
                    break;
                case PlayerException.EXCEPTION_TYPE_ERROR_CREATE_JAVA_DATASOURCE /*{ENCODED_INT: 82}*/:
                    int zzb2 = zzw.zzb(zzk, 82);
                    int length2 = this.zzgm == null ? 0 : this.zzgm.length;
                    zzi[] zziArr = new zzi[(zzb2 + length2)];
                    if (length2 != 0) {
                        System.arraycopy(this.zzgm, 0, zziArr, 0, length2);
                    }
                    while (length2 < zziArr.length - 1) {
                        zziArr[length2] = new zzi();
                        zzk.zza(zziArr[length2]);
                        zzk.zzj();
                        length2++;
                    }
                    zziArr[length2] = new zzi();
                    zzk.zza(zziArr[length2]);
                    this.zzgm = zziArr;
                    break;
                case 90:
                    int zzb3 = zzw.zzb(zzk, 90);
                    int length3 = this.zzgn == null ? 0 : this.zzgn.length;
                    String[] strArr = new String[(zzb3 + length3)];
                    if (length3 != 0) {
                        System.arraycopy(this.zzgn, 0, strArr, 0, length3);
                    }
                    while (length3 < strArr.length - 1) {
                        strArr[length3] = zzk.readString();
                        zzk.zzj();
                        length3++;
                    }
                    strArr[length3] = zzk.readString();
                    this.zzgn = strArr;
                    break;
                case PlayerException.EXCEPTION_IN_SETAUDIOEFFECT /*{ENCODED_INT: 96}*/:
                    int zzb4 = zzw.zzb(zzk, 96);
                    int length4 = this.zzgo == null ? 0 : this.zzgo.length;
                    long[] jArr = new long[(zzb4 + length4)];
                    if (length4 != 0) {
                        System.arraycopy(this.zzgo, 0, jArr, 0, length4);
                    }
                    while (length4 < jArr.length - 1) {
                        jArr[length4] = zzk.zzl();
                        zzk.zzj();
                        length4++;
                    }
                    jArr[length4] = zzk.zzl();
                    this.zzgo = jArr;
                    break;
                case 98:
                    int zze = zzk.zze(zzk.zzk());
                    int position = zzk.getPosition();
                    int i2 = 0;
                    while (zzk.zzp() > 0) {
                        zzk.zzl();
                        i2++;
                    }
                    zzk.zzg(position);
                    int length5 = this.zzgo == null ? 0 : this.zzgo.length;
                    long[] jArr2 = new long[(i2 + length5)];
                    if (length5 != 0) {
                        System.arraycopy(this.zzgo, 0, jArr2, 0, length5);
                    }
                    while (length5 < jArr2.length) {
                        jArr2[length5] = zzk.zzl();
                        length5++;
                    }
                    this.zzgo = jArr2;
                    zzk.zzf(zze);
                    break;
                case 104:
                    this.zzgq = zzk.zzl();
                    break;
                case 114:
                    int zzk3 = zzk.zzk();
                    int zze2 = zzk.zze(zzk3);
                    int i3 = zzk3 / 4;
                    int length6 = this.zzgp == null ? 0 : this.zzgp.length;
                    float[] fArr = new float[(i3 + length6)];
                    if (length6 != 0) {
                        System.arraycopy(this.zzgp, 0, fArr, 0, length6);
                    }
                    while (length6 < fArr.length) {
                        fArr[length6] = Float.intBitsToFloat(zzk.zzm());
                        length6++;
                    }
                    this.zzgp = fArr;
                    zzk.zzf(zze2);
                    break;
                case 117:
                    int zzb5 = zzw.zzb(zzk, 117);
                    int length7 = this.zzgp == null ? 0 : this.zzgp.length;
                    float[] fArr2 = new float[(zzb5 + length7)];
                    if (length7 != 0) {
                        System.arraycopy(this.zzgp, 0, fArr2, 0, length7);
                    }
                    while (length7 < fArr2.length - 1) {
                        fArr2[length7] = Float.intBitsToFloat(zzk.zzm());
                        zzk.zzj();
                        length7++;
                    }
                    fArr2[length7] = Float.intBitsToFloat(zzk.zzm());
                    this.zzgp = fArr2;
                    break;
                default:
                    if (super.zza(zzk, zzj)) {
                        break;
                    } else {
                        AppMethodBeat.o(100686);
                        break;
                    }
            }
        }
        return this;
    }

    @Override // com.google.android.gms.internal.wearable.zzn, com.google.android.gms.internal.wearable.zzt
    public final void zza(zzl zzl) {
        int i2 = 1;
        AppMethodBeat.i(100684);
        if (!Arrays.equals(this.zzgd, zzw.zzhy)) {
            byte[] bArr = this.zzgd;
            zzl.zzf(1, 2);
            zzl.zzl(bArr.length);
            zzl.zzc(bArr);
        }
        if (this.zzge != null && !this.zzge.equals("")) {
            zzl.zza(2, this.zzge);
        }
        if (Double.doubleToLongBits(this.zzgf) != Double.doubleToLongBits(0.0d)) {
            double d2 = this.zzgf;
            zzl.zzf(3, 1);
            zzl.zzb(Double.doubleToLongBits(d2));
        }
        if (Float.floatToIntBits(this.zzgg) != Float.floatToIntBits(0.0f)) {
            zzl.zza(4, this.zzgg);
        }
        if (this.zzgh != 0) {
            zzl.zza(5, this.zzgh);
        }
        if (this.zzgi != 0) {
            zzl.zzd(6, this.zzgi);
        }
        if (this.zzgj != 0) {
            int i3 = this.zzgj;
            zzl.zzf(7, 0);
            zzl.zzl(zzl.zzn(i3));
        }
        if (this.zzgk) {
            boolean z = this.zzgk;
            zzl.zzf(8, 0);
            if (!z) {
                i2 = 0;
            }
            zzl.zza((byte) i2);
        }
        if (this.zzgl != null && this.zzgl.length > 0) {
            for (int i4 = 0; i4 < this.zzgl.length; i4++) {
                zzh zzh = this.zzgl[i4];
                if (zzh != null) {
                    zzl.zza(9, zzh);
                }
            }
        }
        if (this.zzgm != null && this.zzgm.length > 0) {
            for (int i5 = 0; i5 < this.zzgm.length; i5++) {
                zzi zzi = this.zzgm[i5];
                if (zzi != null) {
                    zzl.zza(10, zzi);
                }
            }
        }
        if (this.zzgn != null && this.zzgn.length > 0) {
            for (int i6 = 0; i6 < this.zzgn.length; i6++) {
                String str = this.zzgn[i6];
                if (str != null) {
                    zzl.zza(11, str);
                }
            }
        }
        if (this.zzgo != null && this.zzgo.length > 0) {
            for (int i7 = 0; i7 < this.zzgo.length; i7++) {
                zzl.zza(12, this.zzgo[i7]);
            }
        }
        if (this.zzgq != 0) {
            zzl.zza(13, this.zzgq);
        }
        if (this.zzgp != null && this.zzgp.length > 0) {
            for (int i8 = 0; i8 < this.zzgp.length; i8++) {
                zzl.zza(14, this.zzgp[i8]);
            }
        }
        super.zza(zzl);
        AppMethodBeat.o(100684);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.wearable.zzn, com.google.android.gms.internal.wearable.zzt
    public final int zzg() {
        AppMethodBeat.i(100685);
        int zzg = super.zzg();
        if (!Arrays.equals(this.zzgd, zzw.zzhy)) {
            byte[] bArr = this.zzgd;
            zzg += bArr.length + zzl.zzm(bArr.length) + zzl.zzk(1);
        }
        if (this.zzge != null && !this.zzge.equals("")) {
            zzg += zzl.zzb(2, this.zzge);
        }
        if (Double.doubleToLongBits(this.zzgf) != Double.doubleToLongBits(0.0d)) {
            zzg += zzl.zzk(3) + 8;
        }
        if (Float.floatToIntBits(this.zzgg) != Float.floatToIntBits(0.0f)) {
            zzg += zzl.zzk(4) + 4;
        }
        if (this.zzgh != 0) {
            zzg += zzl.zzb(5, this.zzgh);
        }
        if (this.zzgi != 0) {
            zzg += zzl.zze(6, this.zzgi);
        }
        if (this.zzgj != 0) {
            zzg += zzl.zzm(zzl.zzn(this.zzgj)) + zzl.zzk(7);
        }
        if (this.zzgk) {
            zzg += zzl.zzk(8) + 1;
        }
        if (this.zzgl != null && this.zzgl.length > 0) {
            int i2 = zzg;
            for (int i3 = 0; i3 < this.zzgl.length; i3++) {
                zzh zzh = this.zzgl[i3];
                if (zzh != null) {
                    i2 += zzl.zzb(9, zzh);
                }
            }
            zzg = i2;
        }
        if (this.zzgm != null && this.zzgm.length > 0) {
            int i4 = zzg;
            for (int i5 = 0; i5 < this.zzgm.length; i5++) {
                zzi zzi = this.zzgm[i5];
                if (zzi != null) {
                    i4 += zzl.zzb(10, zzi);
                }
            }
            zzg = i4;
        }
        if (this.zzgn != null && this.zzgn.length > 0) {
            int i6 = 0;
            int i7 = 0;
            for (int i8 = 0; i8 < this.zzgn.length; i8++) {
                String str = this.zzgn[i8];
                if (str != null) {
                    i7++;
                    i6 += zzl.zzg(str);
                }
            }
            zzg = zzg + i6 + (i7 * 1);
        }
        if (this.zzgo != null && this.zzgo.length > 0) {
            int i9 = 0;
            for (int i10 = 0; i10 < this.zzgo.length; i10++) {
                long j2 = this.zzgo[i10];
                i9 += (-128 & j2) == 0 ? 1 : (-16384 & j2) == 0 ? 2 : (-2097152 & j2) == 0 ? 3 : (-268435456 & j2) == 0 ? 4 : (-34359738368L & j2) == 0 ? 5 : (-4398046511104L & j2) == 0 ? 6 : (-562949953421312L & j2) == 0 ? 7 : (-72057594037927936L & j2) == 0 ? 8 : (j2 & Long.MIN_VALUE) == 0 ? 9 : 10;
            }
            zzg = zzg + i9 + (this.zzgo.length * 1);
        }
        if (this.zzgq != 0) {
            zzg += zzl.zzb(13, this.zzgq);
        }
        if (this.zzgp != null && this.zzgp.length > 0) {
            zzg = zzg + (this.zzgp.length * 4) + (this.zzgp.length * 1);
        }
        AppMethodBeat.o(100685);
        return zzg;
    }
}
