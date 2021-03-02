package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;

public final class zzkf extends zzaby<zzkf> {
    private static volatile zzkf[] zzaru;
    public zzki zzarv = null;
    public zzkg zzarw = null;
    public Boolean zzarx = null;
    public String zzary = null;

    public zzkf() {
        AppMethodBeat.i(2180);
        this.zzbww = null;
        this.zzbxh = -1;
        AppMethodBeat.o(2180);
    }

    public static zzkf[] zzlg() {
        if (zzaru == null) {
            synchronized (zzacc.zzbxg) {
                if (zzaru == null) {
                    zzaru = new zzkf[0];
                }
            }
        }
        return zzaru;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(2181);
        if (obj == this) {
            AppMethodBeat.o(2181);
            return true;
        } else if (!(obj instanceof zzkf)) {
            AppMethodBeat.o(2181);
            return false;
        } else {
            zzkf zzkf = (zzkf) obj;
            if (this.zzarv == null) {
                if (zzkf.zzarv != null) {
                    AppMethodBeat.o(2181);
                    return false;
                }
            } else if (!this.zzarv.equals(zzkf.zzarv)) {
                AppMethodBeat.o(2181);
                return false;
            }
            if (this.zzarw == null) {
                if (zzkf.zzarw != null) {
                    AppMethodBeat.o(2181);
                    return false;
                }
            } else if (!this.zzarw.equals(zzkf.zzarw)) {
                AppMethodBeat.o(2181);
                return false;
            }
            if (this.zzarx == null) {
                if (zzkf.zzarx != null) {
                    AppMethodBeat.o(2181);
                    return false;
                }
            } else if (!this.zzarx.equals(zzkf.zzarx)) {
                AppMethodBeat.o(2181);
                return false;
            }
            if (this.zzary == null) {
                if (zzkf.zzary != null) {
                    AppMethodBeat.o(2181);
                    return false;
                }
            } else if (!this.zzary.equals(zzkf.zzary)) {
                AppMethodBeat.o(2181);
                return false;
            }
            if (this.zzbww != null && !this.zzbww.isEmpty()) {
                boolean equals = this.zzbww.equals(zzkf.zzbww);
                AppMethodBeat.o(2181);
                return equals;
            } else if (zzkf.zzbww == null || zzkf.zzbww.isEmpty()) {
                AppMethodBeat.o(2181);
                return true;
            } else {
                AppMethodBeat.o(2181);
                return false;
            }
        }
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(2182);
        int hashCode = getClass().getName().hashCode() + JsApiGetABTestConfig.CTRL_INDEX;
        zzki zzki = this.zzarv;
        int i3 = hashCode * 31;
        int hashCode2 = zzki == null ? 0 : zzki.hashCode();
        zzkg zzkg = this.zzarw;
        int hashCode3 = ((this.zzary == null ? 0 : this.zzary.hashCode()) + (((this.zzarx == null ? 0 : this.zzarx.hashCode()) + (((zzkg == null ? 0 : zzkg.hashCode()) + ((hashCode2 + i3) * 31)) * 31)) * 31)) * 31;
        if (this.zzbww != null && !this.zzbww.isEmpty()) {
            i2 = this.zzbww.hashCode();
        }
        int i4 = hashCode3 + i2;
        AppMethodBeat.o(2182);
        return i4;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzaby, com.google.android.gms.internal.measurement.zzace
    public final int zza() {
        AppMethodBeat.i(2184);
        int zza = super.zza();
        if (this.zzarv != null) {
            zza += zzabw.zzb(1, this.zzarv);
        }
        if (this.zzarw != null) {
            zza += zzabw.zzb(2, this.zzarw);
        }
        if (this.zzarx != null) {
            this.zzarx.booleanValue();
            zza += zzabw.zzaq(3) + 1;
        }
        if (this.zzary != null) {
            zza += zzabw.zzc(4, this.zzary);
        }
        AppMethodBeat.o(2184);
        return zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzaby, com.google.android.gms.internal.measurement.zzace
    public final void zza(zzabw zzabw) {
        AppMethodBeat.i(2183);
        if (this.zzarv != null) {
            zzabw.zza(1, this.zzarv);
        }
        if (this.zzarw != null) {
            zzabw.zza(2, this.zzarw);
        }
        if (this.zzarx != null) {
            zzabw.zza(3, this.zzarx.booleanValue());
        }
        if (this.zzary != null) {
            zzabw.zzb(4, this.zzary);
        }
        super.zza(zzabw);
        AppMethodBeat.o(2183);
    }

    @Override // com.google.android.gms.internal.measurement.zzace
    public final /* synthetic */ zzace zzb(zzabv zzabv) {
        AppMethodBeat.i(2185);
        while (true) {
            int zzuw = zzabv.zzuw();
            switch (zzuw) {
                case 0:
                    AppMethodBeat.o(2185);
                    break;
                case 10:
                    if (this.zzarv == null) {
                        this.zzarv = new zzki();
                    }
                    zzabv.zza(this.zzarv);
                    break;
                case 18:
                    if (this.zzarw == null) {
                        this.zzarw = new zzkg();
                    }
                    zzabv.zza(this.zzarw);
                    break;
                case 24:
                    this.zzarx = Boolean.valueOf(zzabv.zzux());
                    break;
                case 34:
                    this.zzary = zzabv.readString();
                    break;
                default:
                    if (super.zza(zzabv, zzuw)) {
                        break;
                    } else {
                        AppMethodBeat.o(2185);
                        break;
                    }
            }
        }
        return this;
    }
}
