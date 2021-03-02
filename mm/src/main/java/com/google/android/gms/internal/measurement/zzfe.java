package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import java.util.concurrent.atomic.AtomicReference;

public final class zzfe extends zzhh {
    private static final AtomicReference<String[]> zzaij = new AtomicReference<>();
    private static final AtomicReference<String[]> zzaik = new AtomicReference<>();
    private static final AtomicReference<String[]> zzail = new AtomicReference<>();

    static {
        AppMethodBeat.i(1391);
        AppMethodBeat.o(1391);
    }

    zzfe(zzgl zzgl) {
        super(zzgl);
    }

    private static String zza(String str, String[] strArr, String[] strArr2, AtomicReference<String[]> atomicReference) {
        int i2 = 0;
        AppMethodBeat.i(1359);
        Preconditions.checkNotNull(strArr);
        Preconditions.checkNotNull(strArr2);
        Preconditions.checkNotNull(atomicReference);
        Preconditions.checkArgument(strArr.length == strArr2.length);
        while (true) {
            if (i2 >= strArr.length) {
                AppMethodBeat.o(1359);
                break;
            } else if (zzka.zzs(str, strArr[i2])) {
                synchronized (atomicReference) {
                    try {
                        String[] strArr3 = atomicReference.get();
                        if (strArr3 == null) {
                            strArr3 = new String[strArr2.length];
                            atomicReference.set(strArr3);
                        }
                        if (strArr3[i2] == null) {
                            strArr3[i2] = strArr2[i2] + "(" + strArr[i2] + ")";
                        }
                        str = strArr3[i2];
                    } finally {
                        AppMethodBeat.o(1359);
                    }
                }
            } else {
                i2++;
            }
        }
        return str;
    }

    private static void zza(StringBuilder sb, int i2) {
        AppMethodBeat.i(1367);
        for (int i3 = 0; i3 < i2; i3++) {
            sb.append("  ");
        }
        AppMethodBeat.o(1367);
    }

    private final void zza(StringBuilder sb, int i2, zzkf zzkf) {
        AppMethodBeat.i(1371);
        if (zzkf == null) {
            AppMethodBeat.o(1371);
            return;
        }
        zza(sb, i2);
        sb.append("filter {\n");
        zza(sb, i2, "complement", zzkf.zzarx);
        zza(sb, i2, "param_name", zzbk(zzkf.zzary));
        int i3 = i2 + 1;
        zzki zzki = zzkf.zzarv;
        if (zzki != null) {
            zza(sb, i3);
            sb.append("string_filter");
            sb.append(" {\n");
            if (zzki.zzash != null) {
                String str = "UNKNOWN_MATCH_TYPE";
                switch (zzki.zzash.intValue()) {
                    case 1:
                        str = "REGEXP";
                        break;
                    case 2:
                        str = "BEGINS_WITH";
                        break;
                    case 3:
                        str = "ENDS_WITH";
                        break;
                    case 4:
                        str = "PARTIAL";
                        break;
                    case 5:
                        str = "EXACT";
                        break;
                    case 6:
                        str = "IN_LIST";
                        break;
                }
                zza(sb, i3, "match_type", str);
            }
            zza(sb, i3, "expression", zzki.zzasi);
            zza(sb, i3, "case_sensitive", zzki.zzasj);
            if (zzki.zzask.length > 0) {
                zza(sb, i3 + 1);
                sb.append("expression_list {\n");
                String[] strArr = zzki.zzask;
                for (String str2 : strArr) {
                    zza(sb, i3 + 2);
                    sb.append(str2);
                    sb.append("\n");
                }
                sb.append("}\n");
            }
            zza(sb, i3);
            sb.append("}\n");
        }
        zza(sb, i3, "number_filter", zzkf.zzarw);
        zza(sb, i2);
        sb.append("}\n");
        AppMethodBeat.o(1371);
    }

    private final void zza(StringBuilder sb, int i2, String str, zzkg zzkg) {
        AppMethodBeat.i(1370);
        if (zzkg == null) {
            AppMethodBeat.o(1370);
            return;
        }
        zza(sb, i2);
        sb.append(str);
        sb.append(" {\n");
        if (zzkg.zzarz != null) {
            String str2 = "UNKNOWN_COMPARISON_TYPE";
            switch (zzkg.zzarz.intValue()) {
                case 1:
                    str2 = "LESS_THAN";
                    break;
                case 2:
                    str2 = "GREATER_THAN";
                    break;
                case 3:
                    str2 = "EQUAL";
                    break;
                case 4:
                    str2 = "BETWEEN";
                    break;
            }
            zza(sb, i2, "comparison_type", str2);
        }
        zza(sb, i2, "match_as_float", zzkg.zzasa);
        zza(sb, i2, "comparison_value", zzkg.zzasb);
        zza(sb, i2, "min_comparison_value", zzkg.zzasc);
        zza(sb, i2, "max_comparison_value", zzkg.zzasd);
        zza(sb, i2);
        sb.append("}\n");
        AppMethodBeat.o(1370);
    }

    private static void zza(StringBuilder sb, int i2, String str, zzkr zzkr) {
        AppMethodBeat.i(1369);
        if (zzkr == null) {
            AppMethodBeat.o(1369);
            return;
        }
        zza(sb, 3);
        sb.append(str);
        sb.append(" {\n");
        if (zzkr.zzaul != null) {
            zza(sb, 4);
            sb.append("results: ");
            long[] jArr = zzkr.zzaul;
            int length = jArr.length;
            int i3 = 0;
            int i4 = 0;
            while (i3 < length) {
                Long valueOf = Long.valueOf(jArr[i3]);
                int i5 = i4 + 1;
                if (i4 != 0) {
                    sb.append(", ");
                }
                sb.append(valueOf);
                i3++;
                i4 = i5;
            }
            sb.append('\n');
        }
        if (zzkr.zzauk != null) {
            zza(sb, 4);
            sb.append("status: ");
            long[] jArr2 = zzkr.zzauk;
            int length2 = jArr2.length;
            int i6 = 0;
            int i7 = 0;
            while (i6 < length2) {
                Long valueOf2 = Long.valueOf(jArr2[i6]);
                int i8 = i7 + 1;
                if (i7 != 0) {
                    sb.append(", ");
                }
                sb.append(valueOf2);
                i6++;
                i7 = i8;
            }
            sb.append('\n');
        }
        zza(sb, 3);
        sb.append("}\n");
        AppMethodBeat.o(1369);
    }

    private static void zza(StringBuilder sb, int i2, String str, Object obj) {
        AppMethodBeat.i(1368);
        if (obj == null) {
            AppMethodBeat.o(1368);
            return;
        }
        zza(sb, i2 + 1);
        sb.append(str);
        sb.append(": ");
        sb.append(obj);
        sb.append('\n');
        AppMethodBeat.o(1368);
    }

    private final String zzb(zzer zzer) {
        AppMethodBeat.i(1362);
        if (zzer == null) {
            AppMethodBeat.o(1362);
            return null;
        } else if (!zzil()) {
            String zzer2 = zzer.toString();
            AppMethodBeat.o(1362);
            return zzer2;
        } else {
            String zzb = zzb(zzer.zzif());
            AppMethodBeat.o(1362);
            return zzb;
        }
    }

    private final boolean zzil() {
        AppMethodBeat.i(1355);
        boolean isLoggable = this.zzacw.zzge().isLoggable(3);
        AppMethodBeat.o(1355);
        return isLoggable;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg, com.google.android.gms.internal.measurement.zzec
    public final /* bridge */ /* synthetic */ Context getContext() {
        AppMethodBeat.i(1382);
        Context context = super.getContext();
        AppMethodBeat.o(1382);
        return context;
    }

    /* access modifiers changed from: protected */
    public final String zza(zzep zzep) {
        AppMethodBeat.i(1361);
        if (zzep == null) {
            AppMethodBeat.o(1361);
            return null;
        } else if (!zzil()) {
            String zzep2 = zzep.toString();
            AppMethodBeat.o(1361);
            return zzep2;
        } else {
            String str = "Event{appId='" + zzep.zzti + "', name='" + zzbj(zzep.name) + "', params=" + zzb(zzep.zzafq) + "}";
            AppMethodBeat.o(1361);
            return str;
        }
    }

    /* access modifiers changed from: protected */
    public final String zza(zzke zzke) {
        AppMethodBeat.i(1365);
        if (zzke == null) {
            AppMethodBeat.o(1365);
            return BuildConfig.COMMAND;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nevent_filter {\n");
        zza(sb, 0, "filter_id", zzke.zzarp);
        zza(sb, 0, "event_name", zzbj(zzke.zzarq));
        zza(sb, 1, "event_count_filter", zzke.zzart);
        sb.append("  filters {\n");
        for (zzkf zzkf : zzke.zzarr) {
            zza(sb, 2, zzkf);
        }
        zza(sb, 1);
        sb.append("}\n}\n");
        String sb2 = sb.toString();
        AppMethodBeat.o(1365);
        return sb2;
    }

    /* access modifiers changed from: protected */
    public final String zza(zzkh zzkh) {
        AppMethodBeat.i(1366);
        if (zzkh == null) {
            AppMethodBeat.o(1366);
            return BuildConfig.COMMAND;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nproperty_filter {\n");
        zza(sb, 0, "filter_id", zzkh.zzarp);
        zza(sb, 0, "property_name", zzbl(zzkh.zzasf));
        zza(sb, 1, zzkh.zzasg);
        sb.append("}\n");
        String sb2 = sb.toString();
        AppMethodBeat.o(1366);
        return sb2;
    }

    /* access modifiers changed from: protected */
    public final String zza(zzkp zzkp) {
        AppMethodBeat.i(1364);
        StringBuilder sb = new StringBuilder();
        sb.append("\nbatch {\n");
        if (zzkp.zzatf != null) {
            zzkq[] zzkqArr = zzkp.zzatf;
            for (zzkq zzkq : zzkqArr) {
                if (!(zzkq == null || zzkq == null)) {
                    zza(sb, 1);
                    sb.append("bundle {\n");
                    zza(sb, 1, "protocol_version", zzkq.zzath);
                    zza(sb, 1, TPDownloadProxyEnum.USER_PLATFORM, zzkq.zzatp);
                    zza(sb, 1, "gmp_version", zzkq.zzatt);
                    zza(sb, 1, "uploading_gmp_version", zzkq.zzatu);
                    zza(sb, 1, "config_version", zzkq.zzauf);
                    zza(sb, 1, "gmp_app_id", zzkq.zzadm);
                    zza(sb, 1, "app_id", zzkq.zzti);
                    zza(sb, 1, "app_version", zzkq.zzth);
                    zza(sb, 1, "app_version_major", zzkq.zzaub);
                    zza(sb, 1, "firebase_instance_id", zzkq.zzado);
                    zza(sb, 1, "dev_cert_hash", zzkq.zzatx);
                    zza(sb, 1, "app_store", zzkq.zzadt);
                    zza(sb, 1, "upload_timestamp_millis", zzkq.zzatk);
                    zza(sb, 1, "start_timestamp_millis", zzkq.zzatl);
                    zza(sb, 1, "end_timestamp_millis", zzkq.zzatm);
                    zza(sb, 1, "previous_bundle_start_timestamp_millis", zzkq.zzatn);
                    zza(sb, 1, "previous_bundle_end_timestamp_millis", zzkq.zzato);
                    zza(sb, 1, "app_instance_id", zzkq.zzadl);
                    zza(sb, 1, "resettable_device_id", zzkq.zzatv);
                    zza(sb, 1, TPDownloadProxyEnum.USER_DEVICE_ID, zzkq.zzaue);
                    zza(sb, 1, "limited_ad_tracking", zzkq.zzatw);
                    zza(sb, 1, TPDownloadProxyEnum.USER_OS_VERSION, zzkq.zzatq);
                    zza(sb, 1, TPDownloadProxyEnum.USER_DEVICE_MODEL, zzkq.zzatr);
                    zza(sb, 1, "user_default_language", zzkq.zzafn);
                    zza(sb, 1, "time_zone_offset_minutes", zzkq.zzats);
                    zza(sb, 1, "bundle_sequential_index", zzkq.zzaty);
                    zza(sb, 1, "service_upload", zzkq.zzatz);
                    zza(sb, 1, "health_monitor", zzkq.zzaek);
                    if (!(zzkq.zzaug == null || zzkq.zzaug.longValue() == 0)) {
                        zza(sb, 1, "android_id", zzkq.zzaug);
                    }
                    if (zzkq.zzauj != null) {
                        zza(sb, 1, "retry_counter", zzkq.zzauj);
                    }
                    zzks[] zzksArr = zzkq.zzatj;
                    if (zzksArr != null) {
                        for (zzks zzks : zzksArr) {
                            if (zzks != null) {
                                zza(sb, 2);
                                sb.append("user_property {\n");
                                zza(sb, 2, "set_timestamp_millis", zzks.zzaun);
                                zza(sb, 2, "name", zzbl(zzks.name));
                                zza(sb, 2, "string_value", zzks.zzajf);
                                zza(sb, 2, "int_value", zzks.zzate);
                                zza(sb, 2, "double_value", zzks.zzarc);
                                zza(sb, 2);
                                sb.append("}\n");
                            }
                        }
                    }
                    zzkm[] zzkmArr = zzkq.zzaua;
                    if (zzkmArr != null) {
                        for (zzkm zzkm : zzkmArr) {
                            if (zzkm != null) {
                                zza(sb, 2);
                                sb.append("audience_membership {\n");
                                zza(sb, 2, "audience_id", zzkm.zzarl);
                                zza(sb, 2, "new_audience", zzkm.zzasy);
                                zza(sb, 2, "current_data", zzkm.zzasw);
                                zza(sb, 2, "previous_data", zzkm.zzasx);
                                zza(sb, 2);
                                sb.append("}\n");
                            }
                        }
                    }
                    zzkn[] zzknArr = zzkq.zzati;
                    if (zzknArr != null) {
                        for (zzkn zzkn : zzknArr) {
                            if (zzkn != null) {
                                zza(sb, 2);
                                sb.append("event {\n");
                                zza(sb, 2, "name", zzbj(zzkn.name));
                                zza(sb, 2, "timestamp_millis", zzkn.zzatb);
                                zza(sb, 2, "previous_timestamp_millis", zzkn.zzatc);
                                zza(sb, 2, "count", zzkn.count);
                                zzko[] zzkoArr = zzkn.zzata;
                                if (zzkoArr != null) {
                                    for (zzko zzko : zzkoArr) {
                                        if (zzko != null) {
                                            zza(sb, 3);
                                            sb.append("param {\n");
                                            zza(sb, 3, "name", zzbk(zzko.name));
                                            zza(sb, 3, "string_value", zzko.zzajf);
                                            zza(sb, 3, "int_value", zzko.zzate);
                                            zza(sb, 3, "double_value", zzko.zzarc);
                                            zza(sb, 3);
                                            sb.append("}\n");
                                        }
                                    }
                                }
                                zza(sb, 2);
                                sb.append("}\n");
                            }
                        }
                    }
                    zza(sb, 1);
                    sb.append("}\n");
                }
            }
        }
        sb.append("}\n");
        String sb2 = sb.toString();
        AppMethodBeat.o(1364);
        return sb2;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ void zzab() {
        AppMethodBeat.i(1374);
        super.zzab();
        AppMethodBeat.o(1374);
    }

    /* access modifiers changed from: protected */
    public final String zzb(Bundle bundle) {
        AppMethodBeat.i(1363);
        if (bundle == null) {
            AppMethodBeat.o(1363);
            return null;
        } else if (!zzil()) {
            String bundle2 = bundle.toString();
            AppMethodBeat.o(1363);
            return bundle2;
        } else {
            StringBuilder sb = new StringBuilder();
            for (String str : bundle.keySet()) {
                if (sb.length() != 0) {
                    sb.append(", ");
                } else {
                    sb.append("Bundle[{");
                }
                sb.append(zzbk(str));
                sb.append("=");
                sb.append(bundle.get(str));
            }
            sb.append("}]");
            String sb2 = sb.toString();
            AppMethodBeat.o(1363);
            return sb2;
        }
    }

    /* access modifiers changed from: protected */
    public final String zzb(zzeu zzeu) {
        AppMethodBeat.i(1360);
        if (zzeu == null) {
            AppMethodBeat.o(1360);
            return null;
        } else if (!zzil()) {
            String zzeu2 = zzeu.toString();
            AppMethodBeat.o(1360);
            return zzeu2;
        } else {
            String str = "origin=" + zzeu.origin + ",name=" + zzbj(zzeu.name) + ",params=" + zzb(zzeu.zzafq);
            AppMethodBeat.o(1360);
            return str;
        }
    }

    /* access modifiers changed from: protected */
    public final String zzbj(String str) {
        AppMethodBeat.i(1356);
        if (str == null) {
            AppMethodBeat.o(1356);
            return null;
        } else if (!zzil()) {
            AppMethodBeat.o(1356);
            return str;
        } else {
            String zza = zza(str, AppMeasurement.Event.zzacy, AppMeasurement.Event.zzacx, zzaij);
            AppMethodBeat.o(1356);
            return zza;
        }
    }

    /* access modifiers changed from: protected */
    public final String zzbk(String str) {
        AppMethodBeat.i(1357);
        if (str == null) {
            AppMethodBeat.o(1357);
            return null;
        } else if (!zzil()) {
            AppMethodBeat.o(1357);
            return str;
        } else {
            String zza = zza(str, AppMeasurement.Param.zzada, AppMeasurement.Param.zzacz, zzaik);
            AppMethodBeat.o(1357);
            return zza;
        }
    }

    /* access modifiers changed from: protected */
    public final String zzbl(String str) {
        AppMethodBeat.i(1358);
        if (str == null) {
            AppMethodBeat.o(1358);
            return null;
        } else if (!zzil()) {
            AppMethodBeat.o(1358);
            return str;
        } else if (str.startsWith("_exp_")) {
            String str2 = "experiment_id" + "(" + str + ")";
            AppMethodBeat.o(1358);
            return str2;
        } else {
            String zza = zza(str, AppMeasurement.UserProperty.zzadc, AppMeasurement.UserProperty.zzadb, zzail);
            AppMethodBeat.o(1358);
            return zza;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzhg, com.google.android.gms.internal.measurement.zzec
    public final /* bridge */ /* synthetic */ Clock zzbt() {
        AppMethodBeat.i(1381);
        Clock zzbt = super.zzbt();
        AppMethodBeat.o(1381);
        return zzbt;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ void zzfr() {
        AppMethodBeat.i(1372);
        super.zzfr();
        AppMethodBeat.o(1372);
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ void zzfs() {
        AppMethodBeat.i(1373);
        super.zzfs();
        AppMethodBeat.o(1373);
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzdu zzft() {
        AppMethodBeat.i(1375);
        zzdu zzft = super.zzft();
        AppMethodBeat.o(1375);
        return zzft;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzhk zzfu() {
        AppMethodBeat.i(1376);
        zzhk zzfu = super.zzfu();
        AppMethodBeat.o(1376);
        return zzfu;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzfb zzfv() {
        AppMethodBeat.i(1377);
        zzfb zzfv = super.zzfv();
        AppMethodBeat.o(1377);
        return zzfv;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzeo zzfw() {
        AppMethodBeat.i(1378);
        zzeo zzfw = super.zzfw();
        AppMethodBeat.o(1378);
        return zzfw;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzii zzfx() {
        AppMethodBeat.i(1379);
        zzii zzfx = super.zzfx();
        AppMethodBeat.o(1379);
        return zzfx;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzif zzfy() {
        AppMethodBeat.i(1380);
        zzif zzfy = super.zzfy();
        AppMethodBeat.o(1380);
        return zzfy;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzfc zzfz() {
        AppMethodBeat.i(1383);
        zzfc zzfz = super.zzfz();
        AppMethodBeat.o(1383);
        return zzfz;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzfe zzga() {
        AppMethodBeat.i(1384);
        zzfe zzga = super.zzga();
        AppMethodBeat.o(1384);
        return zzga;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzka zzgb() {
        AppMethodBeat.i(1385);
        zzka zzgb = super.zzgb();
        AppMethodBeat.o(1385);
        return zzgb;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzjh zzgc() {
        AppMethodBeat.i(1386);
        zzjh zzgc = super.zzgc();
        AppMethodBeat.o(1386);
        return zzgc;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg, com.google.android.gms.internal.measurement.zzec
    public final /* bridge */ /* synthetic */ zzgg zzgd() {
        AppMethodBeat.i(1387);
        zzgg zzgd = super.zzgd();
        AppMethodBeat.o(1387);
        return zzgd;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg, com.google.android.gms.internal.measurement.zzec
    public final /* bridge */ /* synthetic */ zzfg zzge() {
        AppMethodBeat.i(1388);
        zzfg zzge = super.zzge();
        AppMethodBeat.o(1388);
        return zzge;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzfr zzgf() {
        AppMethodBeat.i(1389);
        zzfr zzgf = super.zzgf();
        AppMethodBeat.o(1389);
        return zzgf;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzef zzgg() {
        AppMethodBeat.i(1390);
        zzef zzgg = super.zzgg();
        AppMethodBeat.o(1390);
        return zzgg;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzhh
    public final boolean zzhf() {
        return false;
    }
}
