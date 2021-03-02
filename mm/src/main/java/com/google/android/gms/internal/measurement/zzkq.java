package com.google.android.gms.internal.measurement;

import android.support.constraint.ConstraintLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;
import com.tencent.mm.plugin.appbrand.jsapi.af.g;
import com.tencent.mm.plugin.appbrand.jsapi.k.r;
import com.tencent.mm.plugin.appbrand.jsapi.o.c.a;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.smtt.sdk.TbsListener;

public final class zzkq extends zzaby<zzkq> {
    private static volatile zzkq[] zzatg;
    public String zzadl = null;
    public String zzadm = null;
    public String zzado = null;
    public String zzadt = null;
    public String zzaek = null;
    public String zzafn = null;
    public Integer zzath = null;
    public zzkn[] zzati = zzkn.zzll();
    public zzks[] zzatj = zzks.zzlo();
    public Long zzatk = null;
    public Long zzatl = null;
    public Long zzatm = null;
    public Long zzatn = null;
    public Long zzato = null;
    public String zzatp = null;
    public String zzatq = null;
    public String zzatr = null;
    public Integer zzats = null;
    public Long zzatt = null;
    public Long zzatu = null;
    public String zzatv = null;
    public Boolean zzatw = null;
    public Long zzatx = null;
    public Integer zzaty = null;
    public Boolean zzatz = null;
    public zzkm[] zzaua = zzkm.zzlk();
    public Integer zzaub = null;
    private Integer zzauc = null;
    private Integer zzaud = null;
    public String zzaue = null;
    public Long zzauf = null;
    public Long zzaug = null;
    public String zzauh = null;
    private String zzaui = null;
    public Integer zzauj = null;
    public String zzth = null;
    public String zzti = null;

    public zzkq() {
        AppMethodBeat.i(2248);
        this.zzbww = null;
        this.zzbxh = -1;
        AppMethodBeat.o(2248);
    }

    public static zzkq[] zzln() {
        if (zzatg == null) {
            synchronized (zzacc.zzbxg) {
                if (zzatg == null) {
                    zzatg = new zzkq[0];
                }
            }
        }
        return zzatg;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(2249);
        if (obj == this) {
            AppMethodBeat.o(2249);
            return true;
        } else if (!(obj instanceof zzkq)) {
            AppMethodBeat.o(2249);
            return false;
        } else {
            zzkq zzkq = (zzkq) obj;
            if (this.zzath == null) {
                if (zzkq.zzath != null) {
                    AppMethodBeat.o(2249);
                    return false;
                }
            } else if (!this.zzath.equals(zzkq.zzath)) {
                AppMethodBeat.o(2249);
                return false;
            }
            if (!zzacc.equals(this.zzati, zzkq.zzati)) {
                AppMethodBeat.o(2249);
                return false;
            } else if (!zzacc.equals(this.zzatj, zzkq.zzatj)) {
                AppMethodBeat.o(2249);
                return false;
            } else {
                if (this.zzatk == null) {
                    if (zzkq.zzatk != null) {
                        AppMethodBeat.o(2249);
                        return false;
                    }
                } else if (!this.zzatk.equals(zzkq.zzatk)) {
                    AppMethodBeat.o(2249);
                    return false;
                }
                if (this.zzatl == null) {
                    if (zzkq.zzatl != null) {
                        AppMethodBeat.o(2249);
                        return false;
                    }
                } else if (!this.zzatl.equals(zzkq.zzatl)) {
                    AppMethodBeat.o(2249);
                    return false;
                }
                if (this.zzatm == null) {
                    if (zzkq.zzatm != null) {
                        AppMethodBeat.o(2249);
                        return false;
                    }
                } else if (!this.zzatm.equals(zzkq.zzatm)) {
                    AppMethodBeat.o(2249);
                    return false;
                }
                if (this.zzatn == null) {
                    if (zzkq.zzatn != null) {
                        AppMethodBeat.o(2249);
                        return false;
                    }
                } else if (!this.zzatn.equals(zzkq.zzatn)) {
                    AppMethodBeat.o(2249);
                    return false;
                }
                if (this.zzato == null) {
                    if (zzkq.zzato != null) {
                        AppMethodBeat.o(2249);
                        return false;
                    }
                } else if (!this.zzato.equals(zzkq.zzato)) {
                    AppMethodBeat.o(2249);
                    return false;
                }
                if (this.zzatp == null) {
                    if (zzkq.zzatp != null) {
                        AppMethodBeat.o(2249);
                        return false;
                    }
                } else if (!this.zzatp.equals(zzkq.zzatp)) {
                    AppMethodBeat.o(2249);
                    return false;
                }
                if (this.zzatq == null) {
                    if (zzkq.zzatq != null) {
                        AppMethodBeat.o(2249);
                        return false;
                    }
                } else if (!this.zzatq.equals(zzkq.zzatq)) {
                    AppMethodBeat.o(2249);
                    return false;
                }
                if (this.zzatr == null) {
                    if (zzkq.zzatr != null) {
                        AppMethodBeat.o(2249);
                        return false;
                    }
                } else if (!this.zzatr.equals(zzkq.zzatr)) {
                    AppMethodBeat.o(2249);
                    return false;
                }
                if (this.zzafn == null) {
                    if (zzkq.zzafn != null) {
                        AppMethodBeat.o(2249);
                        return false;
                    }
                } else if (!this.zzafn.equals(zzkq.zzafn)) {
                    AppMethodBeat.o(2249);
                    return false;
                }
                if (this.zzats == null) {
                    if (zzkq.zzats != null) {
                        AppMethodBeat.o(2249);
                        return false;
                    }
                } else if (!this.zzats.equals(zzkq.zzats)) {
                    AppMethodBeat.o(2249);
                    return false;
                }
                if (this.zzadt == null) {
                    if (zzkq.zzadt != null) {
                        AppMethodBeat.o(2249);
                        return false;
                    }
                } else if (!this.zzadt.equals(zzkq.zzadt)) {
                    AppMethodBeat.o(2249);
                    return false;
                }
                if (this.zzti == null) {
                    if (zzkq.zzti != null) {
                        AppMethodBeat.o(2249);
                        return false;
                    }
                } else if (!this.zzti.equals(zzkq.zzti)) {
                    AppMethodBeat.o(2249);
                    return false;
                }
                if (this.zzth == null) {
                    if (zzkq.zzth != null) {
                        AppMethodBeat.o(2249);
                        return false;
                    }
                } else if (!this.zzth.equals(zzkq.zzth)) {
                    AppMethodBeat.o(2249);
                    return false;
                }
                if (this.zzatt == null) {
                    if (zzkq.zzatt != null) {
                        AppMethodBeat.o(2249);
                        return false;
                    }
                } else if (!this.zzatt.equals(zzkq.zzatt)) {
                    AppMethodBeat.o(2249);
                    return false;
                }
                if (this.zzatu == null) {
                    if (zzkq.zzatu != null) {
                        AppMethodBeat.o(2249);
                        return false;
                    }
                } else if (!this.zzatu.equals(zzkq.zzatu)) {
                    AppMethodBeat.o(2249);
                    return false;
                }
                if (this.zzatv == null) {
                    if (zzkq.zzatv != null) {
                        AppMethodBeat.o(2249);
                        return false;
                    }
                } else if (!this.zzatv.equals(zzkq.zzatv)) {
                    AppMethodBeat.o(2249);
                    return false;
                }
                if (this.zzatw == null) {
                    if (zzkq.zzatw != null) {
                        AppMethodBeat.o(2249);
                        return false;
                    }
                } else if (!this.zzatw.equals(zzkq.zzatw)) {
                    AppMethodBeat.o(2249);
                    return false;
                }
                if (this.zzadl == null) {
                    if (zzkq.zzadl != null) {
                        AppMethodBeat.o(2249);
                        return false;
                    }
                } else if (!this.zzadl.equals(zzkq.zzadl)) {
                    AppMethodBeat.o(2249);
                    return false;
                }
                if (this.zzatx == null) {
                    if (zzkq.zzatx != null) {
                        AppMethodBeat.o(2249);
                        return false;
                    }
                } else if (!this.zzatx.equals(zzkq.zzatx)) {
                    AppMethodBeat.o(2249);
                    return false;
                }
                if (this.zzaty == null) {
                    if (zzkq.zzaty != null) {
                        AppMethodBeat.o(2249);
                        return false;
                    }
                } else if (!this.zzaty.equals(zzkq.zzaty)) {
                    AppMethodBeat.o(2249);
                    return false;
                }
                if (this.zzaek == null) {
                    if (zzkq.zzaek != null) {
                        AppMethodBeat.o(2249);
                        return false;
                    }
                } else if (!this.zzaek.equals(zzkq.zzaek)) {
                    AppMethodBeat.o(2249);
                    return false;
                }
                if (this.zzadm == null) {
                    if (zzkq.zzadm != null) {
                        AppMethodBeat.o(2249);
                        return false;
                    }
                } else if (!this.zzadm.equals(zzkq.zzadm)) {
                    AppMethodBeat.o(2249);
                    return false;
                }
                if (this.zzatz == null) {
                    if (zzkq.zzatz != null) {
                        AppMethodBeat.o(2249);
                        return false;
                    }
                } else if (!this.zzatz.equals(zzkq.zzatz)) {
                    AppMethodBeat.o(2249);
                    return false;
                }
                if (!zzacc.equals(this.zzaua, zzkq.zzaua)) {
                    AppMethodBeat.o(2249);
                    return false;
                }
                if (this.zzado == null) {
                    if (zzkq.zzado != null) {
                        AppMethodBeat.o(2249);
                        return false;
                    }
                } else if (!this.zzado.equals(zzkq.zzado)) {
                    AppMethodBeat.o(2249);
                    return false;
                }
                if (this.zzaub == null) {
                    if (zzkq.zzaub != null) {
                        AppMethodBeat.o(2249);
                        return false;
                    }
                } else if (!this.zzaub.equals(zzkq.zzaub)) {
                    AppMethodBeat.o(2249);
                    return false;
                }
                if (this.zzauc == null) {
                    if (zzkq.zzauc != null) {
                        AppMethodBeat.o(2249);
                        return false;
                    }
                } else if (!this.zzauc.equals(zzkq.zzauc)) {
                    AppMethodBeat.o(2249);
                    return false;
                }
                if (this.zzaud == null) {
                    if (zzkq.zzaud != null) {
                        AppMethodBeat.o(2249);
                        return false;
                    }
                } else if (!this.zzaud.equals(zzkq.zzaud)) {
                    AppMethodBeat.o(2249);
                    return false;
                }
                if (this.zzaue == null) {
                    if (zzkq.zzaue != null) {
                        AppMethodBeat.o(2249);
                        return false;
                    }
                } else if (!this.zzaue.equals(zzkq.zzaue)) {
                    AppMethodBeat.o(2249);
                    return false;
                }
                if (this.zzauf == null) {
                    if (zzkq.zzauf != null) {
                        AppMethodBeat.o(2249);
                        return false;
                    }
                } else if (!this.zzauf.equals(zzkq.zzauf)) {
                    AppMethodBeat.o(2249);
                    return false;
                }
                if (this.zzaug == null) {
                    if (zzkq.zzaug != null) {
                        AppMethodBeat.o(2249);
                        return false;
                    }
                } else if (!this.zzaug.equals(zzkq.zzaug)) {
                    AppMethodBeat.o(2249);
                    return false;
                }
                if (this.zzauh == null) {
                    if (zzkq.zzauh != null) {
                        AppMethodBeat.o(2249);
                        return false;
                    }
                } else if (!this.zzauh.equals(zzkq.zzauh)) {
                    AppMethodBeat.o(2249);
                    return false;
                }
                if (this.zzaui == null) {
                    if (zzkq.zzaui != null) {
                        AppMethodBeat.o(2249);
                        return false;
                    }
                } else if (!this.zzaui.equals(zzkq.zzaui)) {
                    AppMethodBeat.o(2249);
                    return false;
                }
                if (this.zzauj == null) {
                    if (zzkq.zzauj != null) {
                        AppMethodBeat.o(2249);
                        return false;
                    }
                } else if (!this.zzauj.equals(zzkq.zzauj)) {
                    AppMethodBeat.o(2249);
                    return false;
                }
                if (this.zzbww != null && !this.zzbww.isEmpty()) {
                    boolean equals = this.zzbww.equals(zzkq.zzbww);
                    AppMethodBeat.o(2249);
                    return equals;
                } else if (zzkq.zzbww == null || zzkq.zzbww.isEmpty()) {
                    AppMethodBeat.o(2249);
                    return true;
                } else {
                    AppMethodBeat.o(2249);
                    return false;
                }
            }
        }
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(2250);
        int hashCode = ((this.zzauj == null ? 0 : this.zzauj.hashCode()) + (((this.zzaui == null ? 0 : this.zzaui.hashCode()) + (((this.zzauh == null ? 0 : this.zzauh.hashCode()) + (((this.zzaug == null ? 0 : this.zzaug.hashCode()) + (((this.zzauf == null ? 0 : this.zzauf.hashCode()) + (((this.zzaue == null ? 0 : this.zzaue.hashCode()) + (((this.zzaud == null ? 0 : this.zzaud.hashCode()) + (((this.zzauc == null ? 0 : this.zzauc.hashCode()) + (((this.zzaub == null ? 0 : this.zzaub.hashCode()) + (((this.zzado == null ? 0 : this.zzado.hashCode()) + (((((this.zzatz == null ? 0 : this.zzatz.hashCode()) + (((this.zzadm == null ? 0 : this.zzadm.hashCode()) + (((this.zzaek == null ? 0 : this.zzaek.hashCode()) + (((this.zzaty == null ? 0 : this.zzaty.hashCode()) + (((this.zzatx == null ? 0 : this.zzatx.hashCode()) + (((this.zzadl == null ? 0 : this.zzadl.hashCode()) + (((this.zzatw == null ? 0 : this.zzatw.hashCode()) + (((this.zzatv == null ? 0 : this.zzatv.hashCode()) + (((this.zzatu == null ? 0 : this.zzatu.hashCode()) + (((this.zzatt == null ? 0 : this.zzatt.hashCode()) + (((this.zzth == null ? 0 : this.zzth.hashCode()) + (((this.zzti == null ? 0 : this.zzti.hashCode()) + (((this.zzadt == null ? 0 : this.zzadt.hashCode()) + (((this.zzats == null ? 0 : this.zzats.hashCode()) + (((this.zzafn == null ? 0 : this.zzafn.hashCode()) + (((this.zzatr == null ? 0 : this.zzatr.hashCode()) + (((this.zzatq == null ? 0 : this.zzatq.hashCode()) + (((this.zzatp == null ? 0 : this.zzatp.hashCode()) + (((this.zzato == null ? 0 : this.zzato.hashCode()) + (((this.zzatn == null ? 0 : this.zzatn.hashCode()) + (((this.zzatm == null ? 0 : this.zzatm.hashCode()) + (((this.zzatl == null ? 0 : this.zzatl.hashCode()) + (((this.zzatk == null ? 0 : this.zzatk.hashCode()) + (((((((this.zzath == null ? 0 : this.zzath.hashCode()) + ((getClass().getName().hashCode() + JsApiGetABTestConfig.CTRL_INDEX) * 31)) * 31) + zzacc.hashCode(this.zzati)) * 31) + zzacc.hashCode(this.zzatj)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31) + zzacc.hashCode(this.zzaua)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (this.zzbww != null && !this.zzbww.isEmpty()) {
            i2 = this.zzbww.hashCode();
        }
        int i3 = hashCode + i2;
        AppMethodBeat.o(2250);
        return i3;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzaby, com.google.android.gms.internal.measurement.zzace
    public final int zza() {
        AppMethodBeat.i(2252);
        int zza = super.zza();
        if (this.zzath != null) {
            zza += zzabw.zzf(1, this.zzath.intValue());
        }
        if (this.zzati != null && this.zzati.length > 0) {
            int i2 = zza;
            for (int i3 = 0; i3 < this.zzati.length; i3++) {
                zzkn zzkn = this.zzati[i3];
                if (zzkn != null) {
                    i2 += zzabw.zzb(2, zzkn);
                }
            }
            zza = i2;
        }
        if (this.zzatj != null && this.zzatj.length > 0) {
            int i4 = zza;
            for (int i5 = 0; i5 < this.zzatj.length; i5++) {
                zzks zzks = this.zzatj[i5];
                if (zzks != null) {
                    i4 += zzabw.zzb(3, zzks);
                }
            }
            zza = i4;
        }
        if (this.zzatk != null) {
            zza += zzabw.zzc(4, this.zzatk.longValue());
        }
        if (this.zzatl != null) {
            zza += zzabw.zzc(5, this.zzatl.longValue());
        }
        if (this.zzatm != null) {
            zza += zzabw.zzc(6, this.zzatm.longValue());
        }
        if (this.zzato != null) {
            zza += zzabw.zzc(7, this.zzato.longValue());
        }
        if (this.zzatp != null) {
            zza += zzabw.zzc(8, this.zzatp);
        }
        if (this.zzatq != null) {
            zza += zzabw.zzc(9, this.zzatq);
        }
        if (this.zzatr != null) {
            zza += zzabw.zzc(10, this.zzatr);
        }
        if (this.zzafn != null) {
            zza += zzabw.zzc(11, this.zzafn);
        }
        if (this.zzats != null) {
            zza += zzabw.zzf(12, this.zzats.intValue());
        }
        if (this.zzadt != null) {
            zza += zzabw.zzc(13, this.zzadt);
        }
        if (this.zzti != null) {
            zza += zzabw.zzc(14, this.zzti);
        }
        if (this.zzth != null) {
            zza += zzabw.zzc(16, this.zzth);
        }
        if (this.zzatt != null) {
            zza += zzabw.zzc(17, this.zzatt.longValue());
        }
        if (this.zzatu != null) {
            zza += zzabw.zzc(18, this.zzatu.longValue());
        }
        if (this.zzatv != null) {
            zza += zzabw.zzc(19, this.zzatv);
        }
        if (this.zzatw != null) {
            this.zzatw.booleanValue();
            zza += zzabw.zzaq(20) + 1;
        }
        if (this.zzadl != null) {
            zza += zzabw.zzc(21, this.zzadl);
        }
        if (this.zzatx != null) {
            zza += zzabw.zzc(22, this.zzatx.longValue());
        }
        if (this.zzaty != null) {
            zza += zzabw.zzf(23, this.zzaty.intValue());
        }
        if (this.zzaek != null) {
            zza += zzabw.zzc(24, this.zzaek);
        }
        if (this.zzadm != null) {
            zza += zzabw.zzc(25, this.zzadm);
        }
        if (this.zzatn != null) {
            zza += zzabw.zzc(26, this.zzatn.longValue());
        }
        if (this.zzatz != null) {
            this.zzatz.booleanValue();
            zza += zzabw.zzaq(28) + 1;
        }
        if (this.zzaua != null && this.zzaua.length > 0) {
            for (int i6 = 0; i6 < this.zzaua.length; i6++) {
                zzkm zzkm = this.zzaua[i6];
                if (zzkm != null) {
                    zza += zzabw.zzb(29, zzkm);
                }
            }
        }
        if (this.zzado != null) {
            zza += zzabw.zzc(30, this.zzado);
        }
        if (this.zzaub != null) {
            zza += zzabw.zzf(31, this.zzaub.intValue());
        }
        if (this.zzauc != null) {
            zza += zzabw.zzf(32, this.zzauc.intValue());
        }
        if (this.zzaud != null) {
            zza += zzabw.zzf(33, this.zzaud.intValue());
        }
        if (this.zzaue != null) {
            zza += zzabw.zzc(34, this.zzaue);
        }
        if (this.zzauf != null) {
            zza += zzabw.zzc(35, this.zzauf.longValue());
        }
        if (this.zzaug != null) {
            zza += zzabw.zzc(36, this.zzaug.longValue());
        }
        if (this.zzauh != null) {
            zza += zzabw.zzc(37, this.zzauh);
        }
        if (this.zzaui != null) {
            zza += zzabw.zzc(38, this.zzaui);
        }
        if (this.zzauj != null) {
            zza += zzabw.zzf(39, this.zzauj.intValue());
        }
        AppMethodBeat.o(2252);
        return zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzaby, com.google.android.gms.internal.measurement.zzace
    public final void zza(zzabw zzabw) {
        AppMethodBeat.i(2251);
        if (this.zzath != null) {
            zzabw.zze(1, this.zzath.intValue());
        }
        if (this.zzati != null && this.zzati.length > 0) {
            for (int i2 = 0; i2 < this.zzati.length; i2++) {
                zzkn zzkn = this.zzati[i2];
                if (zzkn != null) {
                    zzabw.zza(2, zzkn);
                }
            }
        }
        if (this.zzatj != null && this.zzatj.length > 0) {
            for (int i3 = 0; i3 < this.zzatj.length; i3++) {
                zzks zzks = this.zzatj[i3];
                if (zzks != null) {
                    zzabw.zza(3, zzks);
                }
            }
        }
        if (this.zzatk != null) {
            zzabw.zzb(4, this.zzatk.longValue());
        }
        if (this.zzatl != null) {
            zzabw.zzb(5, this.zzatl.longValue());
        }
        if (this.zzatm != null) {
            zzabw.zzb(6, this.zzatm.longValue());
        }
        if (this.zzato != null) {
            zzabw.zzb(7, this.zzato.longValue());
        }
        if (this.zzatp != null) {
            zzabw.zzb(8, this.zzatp);
        }
        if (this.zzatq != null) {
            zzabw.zzb(9, this.zzatq);
        }
        if (this.zzatr != null) {
            zzabw.zzb(10, this.zzatr);
        }
        if (this.zzafn != null) {
            zzabw.zzb(11, this.zzafn);
        }
        if (this.zzats != null) {
            zzabw.zze(12, this.zzats.intValue());
        }
        if (this.zzadt != null) {
            zzabw.zzb(13, this.zzadt);
        }
        if (this.zzti != null) {
            zzabw.zzb(14, this.zzti);
        }
        if (this.zzth != null) {
            zzabw.zzb(16, this.zzth);
        }
        if (this.zzatt != null) {
            zzabw.zzb(17, this.zzatt.longValue());
        }
        if (this.zzatu != null) {
            zzabw.zzb(18, this.zzatu.longValue());
        }
        if (this.zzatv != null) {
            zzabw.zzb(19, this.zzatv);
        }
        if (this.zzatw != null) {
            zzabw.zza(20, this.zzatw.booleanValue());
        }
        if (this.zzadl != null) {
            zzabw.zzb(21, this.zzadl);
        }
        if (this.zzatx != null) {
            zzabw.zzb(22, this.zzatx.longValue());
        }
        if (this.zzaty != null) {
            zzabw.zze(23, this.zzaty.intValue());
        }
        if (this.zzaek != null) {
            zzabw.zzb(24, this.zzaek);
        }
        if (this.zzadm != null) {
            zzabw.zzb(25, this.zzadm);
        }
        if (this.zzatn != null) {
            zzabw.zzb(26, this.zzatn.longValue());
        }
        if (this.zzatz != null) {
            zzabw.zza(28, this.zzatz.booleanValue());
        }
        if (this.zzaua != null && this.zzaua.length > 0) {
            for (int i4 = 0; i4 < this.zzaua.length; i4++) {
                zzkm zzkm = this.zzaua[i4];
                if (zzkm != null) {
                    zzabw.zza(29, zzkm);
                }
            }
        }
        if (this.zzado != null) {
            zzabw.zzb(30, this.zzado);
        }
        if (this.zzaub != null) {
            zzabw.zze(31, this.zzaub.intValue());
        }
        if (this.zzauc != null) {
            zzabw.zze(32, this.zzauc.intValue());
        }
        if (this.zzaud != null) {
            zzabw.zze(33, this.zzaud.intValue());
        }
        if (this.zzaue != null) {
            zzabw.zzb(34, this.zzaue);
        }
        if (this.zzauf != null) {
            zzabw.zzb(35, this.zzauf.longValue());
        }
        if (this.zzaug != null) {
            zzabw.zzb(36, this.zzaug.longValue());
        }
        if (this.zzauh != null) {
            zzabw.zzb(37, this.zzauh);
        }
        if (this.zzaui != null) {
            zzabw.zzb(38, this.zzaui);
        }
        if (this.zzauj != null) {
            zzabw.zze(39, this.zzauj.intValue());
        }
        super.zza(zzabw);
        AppMethodBeat.o(2251);
    }

    @Override // com.google.android.gms.internal.measurement.zzace
    public final /* synthetic */ zzace zzb(zzabv zzabv) {
        AppMethodBeat.i(2253);
        while (true) {
            int zzuw = zzabv.zzuw();
            switch (zzuw) {
                case 0:
                    AppMethodBeat.o(2253);
                    break;
                case 8:
                    this.zzath = Integer.valueOf(zzabv.zzuy());
                    break;
                case 18:
                    int zzb = zzach.zzb(zzabv, 18);
                    int length = this.zzati == null ? 0 : this.zzati.length;
                    zzkn[] zzknArr = new zzkn[(zzb + length)];
                    if (length != 0) {
                        System.arraycopy(this.zzati, 0, zzknArr, 0, length);
                    }
                    while (length < zzknArr.length - 1) {
                        zzknArr[length] = new zzkn();
                        zzabv.zza(zzknArr[length]);
                        zzabv.zzuw();
                        length++;
                    }
                    zzknArr[length] = new zzkn();
                    zzabv.zza(zzknArr[length]);
                    this.zzati = zzknArr;
                    break;
                case 26:
                    int zzb2 = zzach.zzb(zzabv, 26);
                    int length2 = this.zzatj == null ? 0 : this.zzatj.length;
                    zzks[] zzksArr = new zzks[(zzb2 + length2)];
                    if (length2 != 0) {
                        System.arraycopy(this.zzatj, 0, zzksArr, 0, length2);
                    }
                    while (length2 < zzksArr.length - 1) {
                        zzksArr[length2] = new zzks();
                        zzabv.zza(zzksArr[length2]);
                        zzabv.zzuw();
                        length2++;
                    }
                    zzksArr[length2] = new zzks();
                    zzabv.zza(zzksArr[length2]);
                    this.zzatj = zzksArr;
                    break;
                case 32:
                    this.zzatk = Long.valueOf(zzabv.zzuz());
                    break;
                case 40:
                    this.zzatl = Long.valueOf(zzabv.zzuz());
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                    this.zzatm = Long.valueOf(zzabv.zzuz());
                    break;
                case 56:
                    this.zzato = Long.valueOf(zzabv.zzuz());
                    break;
                case 66:
                    this.zzatp = zzabv.readString();
                    break;
                case 74:
                    this.zzatq = zzabv.readString();
                    break;
                case PlayerException.EXCEPTION_TYPE_ERROR_CREATE_JAVA_DATASOURCE /*{ENCODED_INT: 82}*/:
                    this.zzatr = zzabv.readString();
                    break;
                case 90:
                    this.zzafn = zzabv.readString();
                    break;
                case PlayerException.EXCEPTION_IN_SETAUDIOEFFECT /*{ENCODED_INT: 96}*/:
                    this.zzats = Integer.valueOf(zzabv.zzuy());
                    break;
                case 106:
                    this.zzadt = zzabv.readString();
                    break;
                case 114:
                    this.zzti = zzabv.readString();
                    break;
                case 130:
                    this.zzth = zzabv.readString();
                    break;
                case r.CTRL_INDEX /*{ENCODED_INT: 136}*/:
                    this.zzatt = Long.valueOf(zzabv.zzuz());
                    break;
                case 144:
                    this.zzatu = Long.valueOf(zzabv.zzuz());
                    break;
                case 154:
                    this.zzatv = zzabv.readString();
                    break;
                case 160:
                    this.zzatw = Boolean.valueOf(zzabv.zzux());
                    break;
                case TbsListener.ErrorCode.NEEDDOWNLOAD_TRUE /*{ENCODED_INT: 170}*/:
                    this.zzadl = zzabv.readString();
                    break;
                case TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_6 /*{ENCODED_INT: 176}*/:
                    this.zzatx = Long.valueOf(zzabv.zzuz());
                    break;
                case 184:
                    this.zzaty = Integer.valueOf(zzabv.zzuy());
                    break;
                case 194:
                    this.zzaek = zzabv.readString();
                    break;
                case 202:
                    this.zzadm = zzabv.readString();
                    break;
                case 208:
                    this.zzatn = Long.valueOf(zzabv.zzuz());
                    break;
                case TbsListener.ErrorCode.EXCEED_INCR_UPDATE /*{ENCODED_INT: 224}*/:
                    this.zzatz = Boolean.valueOf(zzabv.zzux());
                    break;
                case TbsListener.ErrorCode.DECOUPLE_INCURUPDATE_SUCCESS /*{ENCODED_INT: 234}*/:
                    int zzb3 = zzach.zzb(zzabv, TbsListener.ErrorCode.DECOUPLE_INCURUPDATE_SUCCESS);
                    int length3 = this.zzaua == null ? 0 : this.zzaua.length;
                    zzkm[] zzkmArr = new zzkm[(zzb3 + length3)];
                    if (length3 != 0) {
                        System.arraycopy(this.zzaua, 0, zzkmArr, 0, length3);
                    }
                    while (length3 < zzkmArr.length - 1) {
                        zzkmArr[length3] = new zzkm();
                        zzabv.zza(zzkmArr[length3]);
                        zzabv.zzuw();
                        length3++;
                    }
                    zzkmArr[length3] = new zzkm();
                    zzabv.zza(zzkmArr[length3]);
                    this.zzaua = zzkmArr;
                    break;
                case 242:
                    this.zzado = zzabv.readString();
                    break;
                case 248:
                    this.zzaub = Integer.valueOf(zzabv.zzuy());
                    break;
                case 256:
                    this.zzauc = Integer.valueOf(zzabv.zzuy());
                    break;
                case 264:
                    this.zzaud = Integer.valueOf(zzabv.zzuy());
                    break;
                case a.C0693a.CTRL_INDEX /*{ENCODED_INT: 274}*/:
                    this.zzaue = zzabv.readString();
                    break;
                case 280:
                    this.zzauf = Long.valueOf(zzabv.zzuz());
                    break;
                case 288:
                    this.zzaug = Long.valueOf(zzabv.zzuz());
                    break;
                case g.CTRL_INDEX /*{ENCODED_INT: 298}*/:
                    this.zzauh = zzabv.readString();
                    break;
                case TbsListener.ErrorCode.THROWABLE_QBSDK_INIT /*{ENCODED_INT: 306}*/:
                    this.zzaui = zzabv.readString();
                    break;
                case 312:
                    this.zzauj = Integer.valueOf(zzabv.zzuy());
                    break;
                default:
                    if (super.zza(zzabv, zzuw)) {
                        break;
                    } else {
                        AppMethodBeat.o(2253);
                        break;
                    }
            }
        }
        return this;
    }
}
