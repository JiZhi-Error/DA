package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzzo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class zzzm<FieldDescriptorType extends zzzo<FieldDescriptorType>> {
    private static final zzzm zzbru = new zzzm(true);
    private boolean zzbls;
    private final zzaay<FieldDescriptorType, Object> zzbrs = zzaay.zzag(16);
    private boolean zzbrt = false;

    static {
        AppMethodBeat.i(40370);
        AppMethodBeat.o(40370);
    }

    private zzzm() {
        AppMethodBeat.i(40362);
        AppMethodBeat.o(40362);
    }

    private zzzm(boolean z) {
        AppMethodBeat.i(40363);
        if (!this.zzbls) {
            this.zzbrs.zzrg();
            this.zzbls = true;
        }
        AppMethodBeat.o(40363);
    }

    private static void zza(zzabp zzabp, Object obj) {
        boolean z = false;
        AppMethodBeat.i(40368);
        zzzr.checkNotNull(obj);
        switch (zzzn.zzbrv[zzabp.zzuv().ordinal()]) {
            case 1:
                z = obj instanceof Integer;
                break;
            case 2:
                z = obj instanceof Long;
                break;
            case 3:
                z = obj instanceof Float;
                break;
            case 4:
                z = obj instanceof Double;
                break;
            case 5:
                z = obj instanceof Boolean;
                break;
            case 6:
                z = obj instanceof String;
                break;
            case 7:
                if ((obj instanceof zzyw) || (obj instanceof byte[])) {
                    z = true;
                    break;
                }
            case 8:
                if ((obj instanceof Integer) || (obj instanceof zzzs)) {
                    z = true;
                    break;
                }
            case 9:
                if ((obj instanceof zzaal) || (obj instanceof zzzu)) {
                    z = true;
                    break;
                }
        }
        if (!z) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            AppMethodBeat.o(40368);
            throw illegalArgumentException;
        }
        AppMethodBeat.o(40368);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:15:0x0046 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: com.google.android.gms.internal.measurement.zzaay<FieldDescriptorType extends com.google.android.gms.internal.measurement.zzzo<FieldDescriptorType>, java.lang.Object>, com.google.android.gms.internal.measurement.zzaay */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v1 */
    private final void zza(FieldDescriptorType fielddescriptortype, Object obj) {
        ArrayList arrayList;
        AppMethodBeat.i(40367);
        if (!fielddescriptortype.zztk()) {
            zza(fielddescriptortype.zztj(), obj);
            arrayList = obj;
        } else if (!(obj instanceof List)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            AppMethodBeat.o(40367);
            throw illegalArgumentException;
        } else {
            arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj2 = arrayList2.get(i2);
                i2++;
                zza(fielddescriptortype.zztj(), obj2);
            }
        }
        if (arrayList instanceof zzzu) {
            this.zzbrt = true;
        }
        ((zzaay<FieldDescriptorType, Object>) this.zzbrs).zza(fielddescriptortype, (Object) arrayList);
        AppMethodBeat.o(40367);
    }

    public static <T extends zzzo<T>> zzzm<T> zzti() {
        return zzbru;
    }

    public final /* synthetic */ Object clone() {
        AppMethodBeat.i(40369);
        zzzm zzzm = new zzzm();
        for (int i2 = 0; i2 < this.zzbrs.zzuj(); i2++) {
            Map.Entry<FieldDescriptorType, Object> zzah = this.zzbrs.zzah(i2);
            zzzm.zza(zzah.getKey(), zzah.getValue());
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.zzbrs.zzuk()) {
            zzzm.zza(entry.getKey(), entry.getValue());
        }
        zzzm.zzbrt = this.zzbrt;
        AppMethodBeat.o(40369);
        return zzzm;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(40364);
        if (this == obj) {
            AppMethodBeat.o(40364);
            return true;
        } else if (!(obj instanceof zzzm)) {
            AppMethodBeat.o(40364);
            return false;
        } else {
            boolean equals = this.zzbrs.equals(((zzzm) obj).zzbrs);
            AppMethodBeat.o(40364);
            return equals;
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(40365);
        int hashCode = this.zzbrs.hashCode();
        AppMethodBeat.o(40365);
        return hashCode;
    }

    public final Iterator<Map.Entry<FieldDescriptorType, Object>> iterator() {
        AppMethodBeat.i(40366);
        if (this.zzbrt) {
            zzzx zzzx = new zzzx(this.zzbrs.entrySet().iterator());
            AppMethodBeat.o(40366);
            return zzzx;
        }
        Iterator<Map.Entry<FieldDescriptorType, Object>> it = this.zzbrs.entrySet().iterator();
        AppMethodBeat.o(40366);
        return it;
    }
}
