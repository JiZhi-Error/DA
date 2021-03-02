package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.e.a;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReference;

public final class zzhk extends zzhh {
    @VisibleForTesting
    protected zzid zzanp;
    private AppMeasurement.EventInterceptor zzanq;
    private final Set<AppMeasurement.OnEventListener> zzanr = new CopyOnWriteArraySet();
    private boolean zzans;
    private final AtomicReference<String> zzant = new AtomicReference<>();
    @VisibleForTesting
    protected boolean zzanu = true;

    protected zzhk(zzgl zzgl) {
        super(zzgl);
        AppMethodBeat.i(1672);
        AppMethodBeat.o(1672);
    }

    static /* synthetic */ void zza(zzhk zzhk, AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        AppMethodBeat.i(1738);
        zzhk.zzb(conditionalUserProperty);
        AppMethodBeat.o(1738);
    }

    static /* synthetic */ void zza(zzhk zzhk, String str, String str2, long j2, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        AppMethodBeat.i(1736);
        zzhk.zzb(str, str2, j2, bundle, z, z2, z3, str3);
        AppMethodBeat.o(1736);
    }

    static /* synthetic */ void zza(zzhk zzhk, String str, String str2, Object obj, long j2) {
        AppMethodBeat.i(1737);
        zzhk.zza(str, str2, obj, j2);
        AppMethodBeat.o(1737);
    }

    static /* synthetic */ void zza(zzhk zzhk, boolean z) {
        AppMethodBeat.i(1735);
        zzhk.zzi(z);
        AppMethodBeat.o(1735);
    }

    private final void zza(AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        AppMethodBeat.i(1704);
        long currentTimeMillis = zzbt().currentTimeMillis();
        Preconditions.checkNotNull(conditionalUserProperty);
        Preconditions.checkNotEmpty(conditionalUserProperty.mName);
        Preconditions.checkNotEmpty(conditionalUserProperty.mOrigin);
        Preconditions.checkNotNull(conditionalUserProperty.mValue);
        conditionalUserProperty.mCreationTimestamp = currentTimeMillis;
        String str = conditionalUserProperty.mName;
        Object obj = conditionalUserProperty.mValue;
        if (zzgb().zzcf(str) != 0) {
            zzge().zzim().zzg("Invalid conditional user property name", zzga().zzbl(str));
            AppMethodBeat.o(1704);
        } else if (zzgb().zzi(str, obj) != 0) {
            zzge().zzim().zze("Invalid conditional user property value", zzga().zzbl(str), obj);
            AppMethodBeat.o(1704);
        } else {
            Object zzj = zzgb().zzj(str, obj);
            if (zzj == null) {
                zzge().zzim().zze("Unable to normalize conditional user property value", zzga().zzbl(str), obj);
                AppMethodBeat.o(1704);
                return;
            }
            conditionalUserProperty.mValue = zzj;
            long j2 = conditionalUserProperty.mTriggerTimeout;
            if (TextUtils.isEmpty(conditionalUserProperty.mTriggerEventName) || (j2 <= 15552000000L && j2 >= 1)) {
                long j3 = conditionalUserProperty.mTimeToLive;
                if (j3 > 15552000000L || j3 < 1) {
                    zzge().zzim().zze("Invalid conditional user property time to live", zzga().zzbl(str), Long.valueOf(j3));
                    AppMethodBeat.o(1704);
                    return;
                }
                zzgd().zzc(new zzhr(this, conditionalUserProperty));
                AppMethodBeat.o(1704);
                return;
            }
            zzge().zzim().zze("Invalid conditional user property timeout", zzga().zzbl(str), Long.valueOf(j2));
            AppMethodBeat.o(1704);
        }
    }

    private final void zza(String str, String str2, long j2, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        Bundle bundle2;
        AppMethodBeat.i(1687);
        if (bundle == null) {
            bundle2 = new Bundle();
        } else {
            bundle2 = new Bundle(bundle);
            for (String str4 : bundle2.keySet()) {
                Object obj = bundle2.get(str4);
                if (obj instanceof Bundle) {
                    bundle2.putBundle(str4, new Bundle((Bundle) obj));
                } else if (obj instanceof Parcelable[]) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj;
                    for (int i2 = 0; i2 < parcelableArr.length; i2++) {
                        if (parcelableArr[i2] instanceof Bundle) {
                            parcelableArr[i2] = new Bundle((Bundle) parcelableArr[i2]);
                        }
                    }
                } else if (obj instanceof ArrayList) {
                    ArrayList arrayList = (ArrayList) obj;
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        Object obj2 = arrayList.get(i3);
                        if (obj2 instanceof Bundle) {
                            arrayList.set(i3, new Bundle((Bundle) obj2));
                        }
                    }
                }
            }
        }
        zzgd().zzc(new zzic(this, str, str2, j2, bundle2, z, z2, z3, str3));
        AppMethodBeat.o(1687);
    }

    private final void zza(String str, String str2, long j2, Object obj) {
        AppMethodBeat.i(1690);
        zzgd().zzc(new zzhm(this, str, str2, obj, j2));
        AppMethodBeat.o(1690);
    }

    private final void zza(String str, String str2, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        AppMethodBeat.i(1686);
        zza(str, str2, zzbt().currentTimeMillis(), bundle, true, z2, z3, null);
        AppMethodBeat.o(1686);
    }

    private final void zza(String str, String str2, Object obj, long j2) {
        AppMethodBeat.i(1691);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzab();
        zzch();
        if (!this.zzacw.isEnabled()) {
            zzge().zzis().log("User property not set since app measurement is disabled");
            AppMethodBeat.o(1691);
        } else if (!this.zzacw.zzjv()) {
            AppMethodBeat.o(1691);
        } else {
            zzge().zzis().zze("Setting user property (FE)", zzga().zzbj(str2), obj);
            zzfx().zzb(new zzjx(str2, j2, obj, str));
            AppMethodBeat.o(1691);
        }
    }

    private final void zza(String str, String str2, String str3, Bundle bundle) {
        AppMethodBeat.i(1707);
        long currentTimeMillis = zzbt().currentTimeMillis();
        Preconditions.checkNotEmpty(str2);
        AppMeasurement.ConditionalUserProperty conditionalUserProperty = new AppMeasurement.ConditionalUserProperty();
        conditionalUserProperty.mAppId = str;
        conditionalUserProperty.mName = str2;
        conditionalUserProperty.mCreationTimestamp = currentTimeMillis;
        if (str3 != null) {
            conditionalUserProperty.mExpiredEventName = str3;
            conditionalUserProperty.mExpiredEventParams = bundle;
        }
        zzgd().zzc(new zzhs(this, conditionalUserProperty));
        AppMethodBeat.o(1707);
    }

    @VisibleForTesting
    private final Map<String, Object> zzb(String str, String str2, String str3, boolean z) {
        AppMethodBeat.i(1715);
        if (zzgd().zzjk()) {
            zzge().zzim().log("Cannot get user properties from analytics worker thread");
            Map<String, Object> emptyMap = Collections.emptyMap();
            AppMethodBeat.o(1715);
            return emptyMap;
        }
        zzgd();
        if (zzgg.isMainThread()) {
            zzge().zzim().log("Cannot get user properties from main thread");
            Map<String, Object> emptyMap2 = Collections.emptyMap();
            AppMethodBeat.o(1715);
            return emptyMap2;
        }
        AtomicReference atomicReference = new AtomicReference();
        synchronized (atomicReference) {
            try {
                this.zzacw.zzgd().zzc(new zzhu(this, atomicReference, str, str2, str3, z));
                try {
                    atomicReference.wait(5000);
                } catch (InterruptedException e2) {
                    zzge().zzip().zzg("Interrupted waiting for get user properties", e2);
                }
            } finally {
                AppMethodBeat.o(1715);
            }
        }
        List<zzjx> list = (List) atomicReference.get();
        if (list == null) {
            zzge().zzip().log("Timed out waiting for get user properties");
            Map<String, Object> emptyMap3 = Collections.emptyMap();
            AppMethodBeat.o(1715);
            return emptyMap3;
        }
        a aVar = new a(list.size());
        for (zzjx zzjx : list) {
            aVar.put(zzjx.name, zzjx.getValue());
        }
        return aVar;
    }

    static /* synthetic */ void zzb(zzhk zzhk, AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        AppMethodBeat.i(1739);
        zzhk.zzc(conditionalUserProperty);
        AppMethodBeat.o(1739);
    }

    private final void zzb(AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        AppMethodBeat.i(1708);
        zzab();
        zzch();
        Preconditions.checkNotNull(conditionalUserProperty);
        Preconditions.checkNotEmpty(conditionalUserProperty.mName);
        Preconditions.checkNotEmpty(conditionalUserProperty.mOrigin);
        Preconditions.checkNotNull(conditionalUserProperty.mValue);
        if (!this.zzacw.isEnabled()) {
            zzge().zzis().log("Conditional property not sent since Firebase Analytics is disabled");
            AppMethodBeat.o(1708);
            return;
        }
        zzjx zzjx = new zzjx(conditionalUserProperty.mName, conditionalUserProperty.mTriggeredTimestamp, conditionalUserProperty.mValue, conditionalUserProperty.mOrigin);
        try {
            zzeu zza = zzgb().zza(conditionalUserProperty.mTriggeredEventName, conditionalUserProperty.mTriggeredEventParams, conditionalUserProperty.mOrigin, 0, true, false);
            zzfx().zzd(new zzed(conditionalUserProperty.mAppId, conditionalUserProperty.mOrigin, zzjx, conditionalUserProperty.mCreationTimestamp, false, conditionalUserProperty.mTriggerEventName, zzgb().zza(conditionalUserProperty.mTimedOutEventName, conditionalUserProperty.mTimedOutEventParams, conditionalUserProperty.mOrigin, 0, true, false), conditionalUserProperty.mTriggerTimeout, zza, conditionalUserProperty.mTimeToLive, zzgb().zza(conditionalUserProperty.mExpiredEventName, conditionalUserProperty.mExpiredEventParams, conditionalUserProperty.mOrigin, 0, true, false)));
            AppMethodBeat.o(1708);
        } catch (IllegalArgumentException e2) {
            AppMethodBeat.o(1708);
        }
    }

    private final void zzb(String str, String str2, long j2, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        int i2;
        AppMethodBeat.i(1688);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(bundle);
        zzab();
        zzch();
        if (!this.zzacw.isEnabled()) {
            zzge().zzis().log("Event not sent since app measurement is disabled");
            AppMethodBeat.o(1688);
            return;
        }
        if (!this.zzans) {
            this.zzans = true;
            try {
                try {
                    Class.forName("com.google.android.gms.tagmanager.TagManagerService").getDeclaredMethod("initialize", Context.class).invoke(null, getContext());
                } catch (Exception e2) {
                    zzge().zzip().zzg("Failed to invoke Tag Manager's initialize() method", e2);
                }
            } catch (ClassNotFoundException e3) {
                zzge().zzir().log("Tag Manager is not found and thus will not be used");
            }
        }
        if (z3 && !"_iap".equals(str2)) {
            zzka zzgb = this.zzacw.zzgb();
            int i3 = !zzgb.zzq("event", str2) ? 2 : !zzgb.zza("event", AppMeasurement.Event.zzacx, str2) ? 13 : !zzgb.zza("event", 40, str2) ? 2 : 0;
            if (i3 != 0) {
                zzge().zzio().zzg("Invalid public event name. Event will not be logged (FE)", zzga().zzbj(str2));
                this.zzacw.zzgb();
                this.zzacw.zzgb().zza(i3, "_ev", zzka.zza(str2, 40, true), str2 != null ? str2.length() : 0);
                AppMethodBeat.o(1688);
                return;
            }
        }
        zzie zzkc = zzfy().zzkc();
        if (zzkc != null && !bundle.containsKey("_sc")) {
            zzkc.zzaok = true;
        }
        zzif.zza(zzkc, bundle, z && z3);
        boolean equals = "am".equals(str);
        boolean zzci = zzka.zzci(str2);
        if (z && this.zzanq != null && !zzci && !equals) {
            zzge().zzis().zze("Passing event to registered event handler (FE)", zzga().zzbj(str2), zzga().zzb(bundle));
            this.zzanq.interceptEvent(str, str2, bundle, j2);
            AppMethodBeat.o(1688);
        } else if (!this.zzacw.zzjv()) {
            AppMethodBeat.o(1688);
        } else {
            int zzcd = zzgb().zzcd(str2);
            if (zzcd != 0) {
                zzge().zzio().zzg("Invalid event name. Event will not be logged (FE)", zzga().zzbj(str2));
                zzgb();
                this.zzacw.zzgb().zza(str3, zzcd, "_ev", zzka.zza(str2, 40, true), str2 != null ? str2.length() : 0);
                AppMethodBeat.o(1688);
                return;
            }
            List<String> listOf = CollectionUtils.listOf((Object[]) new String[]{"_o", "_sn", "_sc", "_si"});
            Bundle zza = zzgb().zza(str2, bundle, listOf, z3, true);
            zzie zzie = (zza == null || !zza.containsKey("_sc") || !zza.containsKey("_si")) ? null : new zzie(zza.getString("_sn"), zza.getString("_sc"), Long.valueOf(zza.getLong("_si")).longValue());
            zzie zzie2 = zzie == null ? zzkc : zzie;
            ArrayList arrayList = new ArrayList();
            arrayList.add(zza);
            long nextLong = zzgb().zzlc().nextLong();
            int i4 = 0;
            String[] strArr = (String[]) zza.keySet().toArray(new String[bundle.size()]);
            Arrays.sort(strArr);
            int length = strArr.length;
            int i5 = 0;
            while (i5 < length) {
                String str4 = strArr[i5];
                Object obj = zza.get(str4);
                zzgb();
                Bundle[] zze = zzka.zze(obj);
                if (zze != null) {
                    zza.putInt(str4, zze.length);
                    for (int i6 = 0; i6 < zze.length; i6++) {
                        Bundle bundle2 = zze[i6];
                        zzif.zza(zzie2, bundle2, true);
                        Bundle zza2 = zzgb().zza("_ep", bundle2, listOf, z3, false);
                        zza2.putString("_en", str2);
                        zza2.putLong("_eid", nextLong);
                        zza2.putString("_gn", str4);
                        zza2.putInt("_ll", zze.length);
                        zza2.putInt("_i", i6);
                        arrayList.add(zza2);
                    }
                    i2 = zze.length + i4;
                } else {
                    i2 = i4;
                }
                i5++;
                i4 = i2;
            }
            if (i4 != 0) {
                zza.putLong("_eid", nextLong);
                zza.putInt("_epc", i4);
            }
            int i7 = 0;
            while (i7 < arrayList.size()) {
                Bundle bundle3 = (Bundle) arrayList.get(i7);
                String str5 = i7 != 0 ? "_ep" : str2;
                bundle3.putString("_o", str);
                Bundle zzd = z2 ? zzgb().zzd(bundle3) : bundle3;
                zzge().zzis().zze("Logging event (FE)", zzga().zzbj(str2), zzga().zzb(zzd));
                zzfx().zzb(new zzeu(str5, new zzer(zzd), str, j2), str3);
                if (!equals) {
                    for (AppMeasurement.OnEventListener onEventListener : this.zzanr) {
                        onEventListener.onEvent(str, str2, new Bundle(zzd), j2);
                    }
                }
                i7++;
            }
            if (zzfy().zzkc() != null && AppMeasurement.Event.APP_EXCEPTION.equals(str2)) {
                zzgc().zzl(true);
            }
            AppMethodBeat.o(1688);
        }
    }

    private final void zzc(AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        AppMethodBeat.i(1709);
        zzab();
        zzch();
        Preconditions.checkNotNull(conditionalUserProperty);
        Preconditions.checkNotEmpty(conditionalUserProperty.mName);
        if (!this.zzacw.isEnabled()) {
            zzge().zzis().log("Conditional property not cleared since Firebase Analytics is disabled");
            AppMethodBeat.o(1709);
            return;
        }
        try {
            zzfx().zzd(new zzed(conditionalUserProperty.mAppId, conditionalUserProperty.mOrigin, new zzjx(conditionalUserProperty.mName, 0, null, null), conditionalUserProperty.mCreationTimestamp, conditionalUserProperty.mActive, conditionalUserProperty.mTriggerEventName, null, conditionalUserProperty.mTriggerTimeout, null, conditionalUserProperty.mTimeToLive, zzgb().zza(conditionalUserProperty.mExpiredEventName, conditionalUserProperty.mExpiredEventParams, conditionalUserProperty.mOrigin, conditionalUserProperty.mCreationTimestamp, true, false)));
            AppMethodBeat.o(1709);
        } catch (IllegalArgumentException e2) {
            AppMethodBeat.o(1709);
        }
    }

    @VisibleForTesting
    private final List<AppMeasurement.ConditionalUserProperty> zzf(String str, String str2, String str3) {
        AppMethodBeat.i(1712);
        if (zzgd().zzjk()) {
            zzge().zzim().log("Cannot get conditional user properties from analytics worker thread");
            List<AppMeasurement.ConditionalUserProperty> emptyList = Collections.emptyList();
            AppMethodBeat.o(1712);
            return emptyList;
        }
        zzgd();
        if (zzgg.isMainThread()) {
            zzge().zzim().log("Cannot get conditional user properties from main thread");
            List<AppMeasurement.ConditionalUserProperty> emptyList2 = Collections.emptyList();
            AppMethodBeat.o(1712);
            return emptyList2;
        }
        AtomicReference atomicReference = new AtomicReference();
        synchronized (atomicReference) {
            try {
                this.zzacw.zzgd().zzc(new zzht(this, atomicReference, str, str2, str3));
                try {
                    atomicReference.wait(5000);
                } catch (InterruptedException e2) {
                    zzge().zzip().zze("Interrupted waiting for get conditional user properties", str, e2);
                }
            } finally {
                AppMethodBeat.o(1712);
            }
        }
        List<zzed> list = (List) atomicReference.get();
        if (list == null) {
            zzge().zzip().zzg("Timed out waiting for get conditional user properties", str);
            List<AppMeasurement.ConditionalUserProperty> emptyList3 = Collections.emptyList();
            AppMethodBeat.o(1712);
            return emptyList3;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (zzed zzed : list) {
            AppMeasurement.ConditionalUserProperty conditionalUserProperty = new AppMeasurement.ConditionalUserProperty();
            conditionalUserProperty.mAppId = str;
            conditionalUserProperty.mOrigin = str2;
            conditionalUserProperty.mCreationTimestamp = zzed.creationTimestamp;
            conditionalUserProperty.mName = zzed.zzaep.name;
            conditionalUserProperty.mValue = zzed.zzaep.getValue();
            conditionalUserProperty.mActive = zzed.active;
            conditionalUserProperty.mTriggerEventName = zzed.triggerEventName;
            if (zzed.zzaeq != null) {
                conditionalUserProperty.mTimedOutEventName = zzed.zzaeq.name;
                if (zzed.zzaeq.zzafq != null) {
                    conditionalUserProperty.mTimedOutEventParams = zzed.zzaeq.zzafq.zzif();
                }
            }
            conditionalUserProperty.mTriggerTimeout = zzed.triggerTimeout;
            if (zzed.zzaer != null) {
                conditionalUserProperty.mTriggeredEventName = zzed.zzaer.name;
                if (zzed.zzaer.zzafq != null) {
                    conditionalUserProperty.mTriggeredEventParams = zzed.zzaer.zzafq.zzif();
                }
            }
            conditionalUserProperty.mTriggeredTimestamp = zzed.zzaep.zzaqz;
            conditionalUserProperty.mTimeToLive = zzed.timeToLive;
            if (zzed.zzaes != null) {
                conditionalUserProperty.mExpiredEventName = zzed.zzaes.name;
                if (zzed.zzaes.zzafq != null) {
                    conditionalUserProperty.mExpiredEventParams = zzed.zzaes.zzafq.zzif();
                }
            }
            arrayList.add(conditionalUserProperty);
        }
        return arrayList;
    }

    private final void zzi(boolean z) {
        AppMethodBeat.i(1679);
        zzab();
        zzch();
        zzge().zzis().zzg("Setting app measurement enabled (FE)", Boolean.valueOf(z));
        zzgf().setMeasurementEnabled(z);
        if (!zzgg().zzaz(zzfv().zzah())) {
            zzfx().zzke();
            AppMethodBeat.o(1679);
        } else if (!this.zzacw.isEnabled() || !this.zzanu) {
            zzfx().zzke();
            AppMethodBeat.o(1679);
        } else {
            zzge().zzis().log("Recording app launch after enabling measurement for the first time (FE)");
            zzkb();
            AppMethodBeat.o(1679);
        }
    }

    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        AppMethodBeat.i(1705);
        zza((String) null, str, str2, bundle);
        AppMethodBeat.o(1705);
    }

    public final void clearConditionalUserPropertyAs(String str, String str2, String str3, Bundle bundle) {
        AppMethodBeat.i(1706);
        Preconditions.checkNotEmpty(str);
        zzfr();
        zza(str, str2, str3, bundle);
        AppMethodBeat.o(1706);
    }

    public final Task<String> getAppInstanceId() {
        AppMethodBeat.i(1693);
        try {
            String zzja = zzgf().zzja();
            if (zzja != null) {
                Task<String> forResult = Tasks.forResult(zzja);
                AppMethodBeat.o(1693);
                return forResult;
            }
            Task<String> call = Tasks.call(zzgd().zzjl(), new zzho(this));
            AppMethodBeat.o(1693);
            return call;
        } catch (Exception e2) {
            zzge().zzip().log("Failed to schedule task for getAppInstanceId");
            Task<String> forException = Tasks.forException(e2);
            AppMethodBeat.o(1693);
            return forException;
        }
    }

    public final List<AppMeasurement.ConditionalUserProperty> getConditionalUserProperties(String str, String str2) {
        AppMethodBeat.i(1710);
        List<AppMeasurement.ConditionalUserProperty> zzf = zzf(null, str, str2);
        AppMethodBeat.o(1710);
        return zzf;
    }

    public final List<AppMeasurement.ConditionalUserProperty> getConditionalUserPropertiesAs(String str, String str2, String str3) {
        AppMethodBeat.i(1711);
        Preconditions.checkNotEmpty(str);
        zzfr();
        List<AppMeasurement.ConditionalUserProperty> zzf = zzf(str, str2, str3);
        AppMethodBeat.o(1711);
        return zzf;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg, com.google.android.gms.internal.measurement.zzec
    public final /* bridge */ /* synthetic */ Context getContext() {
        AppMethodBeat.i(1726);
        Context context = super.getContext();
        AppMethodBeat.o(1726);
        return context;
    }

    public final Map<String, Object> getUserProperties(String str, String str2, boolean z) {
        AppMethodBeat.i(1713);
        Map<String, Object> zzb = zzb(null, str, str2, z);
        AppMethodBeat.o(1713);
        return zzb;
    }

    public final Map<String, Object> getUserPropertiesAs(String str, String str2, String str3, boolean z) {
        AppMethodBeat.i(1714);
        Preconditions.checkNotEmpty(str);
        zzfr();
        Map<String, Object> zzb = zzb(str, str2, str3, z);
        AppMethodBeat.o(1714);
        return zzb;
    }

    public final void logEvent(String str, String str2, Bundle bundle) {
        AppMethodBeat.i(1683);
        zza(str, str2, bundle, true, this.zzanq == null || zzka.zzci(str2), false, null);
        AppMethodBeat.o(1683);
    }

    public final void registerOnMeasurementEventListener(AppMeasurement.OnEventListener onEventListener) {
        AppMethodBeat.i(1700);
        zzch();
        Preconditions.checkNotNull(onEventListener);
        if (!this.zzanr.add(onEventListener)) {
            zzge().zzip().log("OnEventListener already registered");
        }
        AppMethodBeat.o(1700);
    }

    public final void resetAnalyticsData() {
        AppMethodBeat.i(1697);
        zzgd().zzc(new zzhq(this, zzbt().currentTimeMillis()));
        AppMethodBeat.o(1697);
    }

    public final void setConditionalUserProperty(AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        AppMethodBeat.i(1702);
        Preconditions.checkNotNull(conditionalUserProperty);
        AppMeasurement.ConditionalUserProperty conditionalUserProperty2 = new AppMeasurement.ConditionalUserProperty(conditionalUserProperty);
        if (!TextUtils.isEmpty(conditionalUserProperty2.mAppId)) {
            zzge().zzip().log("Package name should be null when calling setConditionalUserProperty");
        }
        conditionalUserProperty2.mAppId = null;
        zza(conditionalUserProperty2);
        AppMethodBeat.o(1702);
    }

    public final void setConditionalUserPropertyAs(AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        AppMethodBeat.i(1703);
        Preconditions.checkNotNull(conditionalUserProperty);
        Preconditions.checkNotEmpty(conditionalUserProperty.mAppId);
        zzfr();
        zza(new AppMeasurement.ConditionalUserProperty(conditionalUserProperty));
        AppMethodBeat.o(1703);
    }

    public final void setEventInterceptor(AppMeasurement.EventInterceptor eventInterceptor) {
        AppMethodBeat.i(1699);
        zzab();
        zzch();
        if (!(eventInterceptor == null || eventInterceptor == this.zzanq)) {
            Preconditions.checkState(this.zzanq == null, "EventInterceptor already set.");
        }
        this.zzanq = eventInterceptor;
        AppMethodBeat.o(1699);
    }

    public final void setMeasurementEnabled(boolean z) {
        AppMethodBeat.i(1678);
        zzch();
        zzgd().zzc(new zzhz(this, z));
        AppMethodBeat.o(1678);
    }

    public final void setMinimumSessionDuration(long j2) {
        AppMethodBeat.i(1680);
        zzgd().zzc(new zzia(this, j2));
        AppMethodBeat.o(1680);
    }

    public final void setSessionTimeoutDuration(long j2) {
        AppMethodBeat.i(1681);
        zzgd().zzc(new zzib(this, j2));
        AppMethodBeat.o(1681);
    }

    public final void setUserProperty(String str, String str2, Object obj) {
        int i2 = 0;
        AppMethodBeat.i(1689);
        Preconditions.checkNotEmpty(str);
        long currentTimeMillis = zzbt().currentTimeMillis();
        int zzcf = zzgb().zzcf(str2);
        if (zzcf != 0) {
            zzgb();
            String zza = zzka.zza(str2, 24, true);
            if (str2 != null) {
                i2 = str2.length();
            }
            this.zzacw.zzgb().zza(zzcf, "_ev", zza, i2);
            AppMethodBeat.o(1689);
        } else if (obj != null) {
            int zzi = zzgb().zzi(str2, obj);
            if (zzi != 0) {
                zzgb();
                String zza2 = zzka.zza(str2, 24, true);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    i2 = String.valueOf(obj).length();
                }
                this.zzacw.zzgb().zza(zzi, "_ev", zza2, i2);
                AppMethodBeat.o(1689);
                return;
            }
            Object zzj = zzgb().zzj(str2, obj);
            if (zzj != null) {
                zza(str, str2, currentTimeMillis, zzj);
            }
            AppMethodBeat.o(1689);
        } else {
            zza(str, str2, currentTimeMillis, (Object) null);
            AppMethodBeat.o(1689);
        }
    }

    public final void unregisterOnMeasurementEventListener(AppMeasurement.OnEventListener onEventListener) {
        AppMethodBeat.i(1701);
        zzch();
        Preconditions.checkNotNull(onEventListener);
        if (!this.zzanr.remove(onEventListener)) {
            zzge().zzip().log("OnEventListener had not been registered");
        }
        AppMethodBeat.o(1701);
    }

    /* access modifiers changed from: package-private */
    public final void zza(String str, String str2, Bundle bundle) {
        AppMethodBeat.i(1684);
        zzab();
        zzb(str, str2, zzbt().currentTimeMillis(), bundle, true, this.zzanq == null || zzka.zzci(str2), false, null);
        AppMethodBeat.o(1684);
    }

    public final void zza(String str, String str2, Bundle bundle, long j2) {
        AppMethodBeat.i(1685);
        zza(str, str2, j2, bundle, false, true, true, null);
        AppMethodBeat.o(1685);
    }

    public final void zza(String str, String str2, Bundle bundle, boolean z) {
        AppMethodBeat.i(1682);
        zza(str, str2, bundle, true, this.zzanq == null || zzka.zzci(str2), true, null);
        AppMethodBeat.o(1682);
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ void zzab() {
        AppMethodBeat.i(1718);
        super.zzab();
        AppMethodBeat.o(1718);
    }

    /* access modifiers changed from: package-private */
    public final String zzae(long j2) {
        AppMethodBeat.i(1696);
        AtomicReference atomicReference = new AtomicReference();
        synchronized (atomicReference) {
            try {
                zzgd().zzc(new zzhp(this, atomicReference));
                try {
                    atomicReference.wait(j2);
                } catch (InterruptedException e2) {
                    zzge().zzip().log("Interrupted waiting for app instance id");
                    return null;
                }
            } finally {
                AppMethodBeat.o(1696);
            }
        }
        String str = (String) atomicReference.get();
        AppMethodBeat.o(1696);
        return str;
    }

    /* access modifiers changed from: package-private */
    public final void zzbr(String str) {
        AppMethodBeat.i(1695);
        this.zzant.set(str);
        AppMethodBeat.o(1695);
    }

    @Override // com.google.android.gms.internal.measurement.zzhg, com.google.android.gms.internal.measurement.zzec
    public final /* bridge */ /* synthetic */ Clock zzbt() {
        AppMethodBeat.i(1725);
        Clock zzbt = super.zzbt();
        AppMethodBeat.o(1725);
        return zzbt;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ void zzfr() {
        AppMethodBeat.i(1716);
        super.zzfr();
        AppMethodBeat.o(1716);
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ void zzfs() {
        AppMethodBeat.i(1717);
        super.zzfs();
        AppMethodBeat.o(1717);
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzdu zzft() {
        AppMethodBeat.i(1719);
        zzdu zzft = super.zzft();
        AppMethodBeat.o(1719);
        return zzft;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzhk zzfu() {
        AppMethodBeat.i(1720);
        zzhk zzfu = super.zzfu();
        AppMethodBeat.o(1720);
        return zzfu;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzfb zzfv() {
        AppMethodBeat.i(1721);
        zzfb zzfv = super.zzfv();
        AppMethodBeat.o(1721);
        return zzfv;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzeo zzfw() {
        AppMethodBeat.i(1722);
        zzeo zzfw = super.zzfw();
        AppMethodBeat.o(1722);
        return zzfw;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzii zzfx() {
        AppMethodBeat.i(1723);
        zzii zzfx = super.zzfx();
        AppMethodBeat.o(1723);
        return zzfx;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzif zzfy() {
        AppMethodBeat.i(1724);
        zzif zzfy = super.zzfy();
        AppMethodBeat.o(1724);
        return zzfy;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzfc zzfz() {
        AppMethodBeat.i(1727);
        zzfc zzfz = super.zzfz();
        AppMethodBeat.o(1727);
        return zzfz;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzfe zzga() {
        AppMethodBeat.i(1728);
        zzfe zzga = super.zzga();
        AppMethodBeat.o(1728);
        return zzga;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzka zzgb() {
        AppMethodBeat.i(1729);
        zzka zzgb = super.zzgb();
        AppMethodBeat.o(1729);
        return zzgb;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzjh zzgc() {
        AppMethodBeat.i(1730);
        zzjh zzgc = super.zzgc();
        AppMethodBeat.o(1730);
        return zzgc;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg, com.google.android.gms.internal.measurement.zzec
    public final /* bridge */ /* synthetic */ zzgg zzgd() {
        AppMethodBeat.i(1731);
        zzgg zzgd = super.zzgd();
        AppMethodBeat.o(1731);
        return zzgd;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg, com.google.android.gms.internal.measurement.zzec
    public final /* bridge */ /* synthetic */ zzfg zzge() {
        AppMethodBeat.i(1732);
        zzfg zzge = super.zzge();
        AppMethodBeat.o(1732);
        return zzge;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzfr zzgf() {
        AppMethodBeat.i(1733);
        zzfr zzgf = super.zzgf();
        AppMethodBeat.o(1733);
        return zzgf;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzef zzgg() {
        AppMethodBeat.i(1734);
        zzef zzgg = super.zzgg();
        AppMethodBeat.o(1734);
        return zzgg;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzhh
    public final boolean zzhf() {
        return false;
    }

    public final String zzhm() {
        AppMethodBeat.i(1674);
        AtomicReference atomicReference = new AtomicReference();
        String str = (String) zzgd().zza(atomicReference, 15000, "String test flag value", new zzhv(this, atomicReference));
        AppMethodBeat.o(1674);
        return str;
    }

    public final List<zzjx> zzj(boolean z) {
        AppMethodBeat.i(1692);
        zzch();
        zzge().zzis().log("Fetching user attributes (FE)");
        if (zzgd().zzjk()) {
            zzge().zzim().log("Cannot get all user properties from analytics worker thread");
            List<zzjx> emptyList = Collections.emptyList();
            AppMethodBeat.o(1692);
            return emptyList;
        }
        zzgd();
        if (zzgg.isMainThread()) {
            zzge().zzim().log("Cannot get all user properties from main thread");
            List<zzjx> emptyList2 = Collections.emptyList();
            AppMethodBeat.o(1692);
            return emptyList2;
        }
        AtomicReference atomicReference = new AtomicReference();
        synchronized (atomicReference) {
            try {
                this.zzacw.zzgd().zzc(new zzhn(this, atomicReference, z));
                try {
                    atomicReference.wait(5000);
                } catch (InterruptedException e2) {
                    zzge().zzip().zzg("Interrupted waiting for get user properties", e2);
                }
            } catch (Throwable th) {
                AppMethodBeat.o(1692);
                throw th;
            }
        }
        List<zzjx> list = (List) atomicReference.get();
        if (list == null) {
            zzge().zzip().log("Timed out waiting for get user properties");
            List<zzjx> emptyList3 = Collections.emptyList();
            AppMethodBeat.o(1692);
            return emptyList3;
        }
        AppMethodBeat.o(1692);
        return list;
    }

    public final String zzja() {
        AppMethodBeat.i(1694);
        String str = this.zzant.get();
        AppMethodBeat.o(1694);
        return str;
    }

    public final Boolean zzjx() {
        AppMethodBeat.i(1673);
        AtomicReference atomicReference = new AtomicReference();
        Boolean bool = (Boolean) zzgd().zza(atomicReference, 15000, "boolean test flag value", new zzhl(this, atomicReference));
        AppMethodBeat.o(1673);
        return bool;
    }

    public final Long zzjy() {
        AppMethodBeat.i(1675);
        AtomicReference atomicReference = new AtomicReference();
        Long l = (Long) zzgd().zza(atomicReference, 15000, "long test flag value", new zzhw(this, atomicReference));
        AppMethodBeat.o(1675);
        return l;
    }

    public final Integer zzjz() {
        AppMethodBeat.i(1676);
        AtomicReference atomicReference = new AtomicReference();
        Integer num = (Integer) zzgd().zza(atomicReference, 15000, "int test flag value", new zzhx(this, atomicReference));
        AppMethodBeat.o(1676);
        return num;
    }

    public final Double zzka() {
        AppMethodBeat.i(1677);
        AtomicReference atomicReference = new AtomicReference();
        Double d2 = (Double) zzgd().zza(atomicReference, 15000, "double test flag value", new zzhy(this, atomicReference));
        AppMethodBeat.o(1677);
        return d2;
    }

    public final void zzkb() {
        AppMethodBeat.i(1698);
        zzab();
        zzch();
        if (!this.zzacw.zzjv()) {
            AppMethodBeat.o(1698);
            return;
        }
        zzfx().zzkb();
        this.zzanu = false;
        String zzjd = zzgf().zzjd();
        if (!TextUtils.isEmpty(zzjd)) {
            zzfw().zzch();
            if (!zzjd.equals(Build.VERSION.RELEASE)) {
                Bundle bundle = new Bundle();
                bundle.putString("_po", zzjd);
                logEvent("auto", "_ou", bundle);
            }
        }
        AppMethodBeat.o(1698);
    }
}
