package com.google.android.gms.internal.measurement;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
@TargetApi(14)
public final class zzid implements Application.ActivityLifecycleCallbacks {
    private final /* synthetic */ zzhk zzanw;

    private zzid(zzhk zzhk) {
        this.zzanw = zzhk;
    }

    /* synthetic */ zzid(zzhk zzhk, zzhl zzhl) {
        this(zzhk);
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        Uri data;
        AppMethodBeat.i(1758);
        try {
            this.zzanw.zzge().zzit().log("onActivityCreated");
            Intent intent = activity.getIntent();
            if (!(intent == null || (data = intent.getData()) == null || !data.isHierarchical())) {
                if (bundle == null) {
                    Bundle zza = this.zzanw.zzgb().zza(data);
                    this.zzanw.zzgb();
                    String str = zzka.zzd(intent) ? "gs" : "auto";
                    if (zza != null) {
                        this.zzanw.logEvent(str, "_cmp", zza);
                    }
                }
                String queryParameter = data.getQueryParameter("referrer");
                if (TextUtils.isEmpty(queryParameter)) {
                    AppMethodBeat.o(1758);
                    return;
                }
                if (!(queryParameter.contains("gclid") && (queryParameter.contains("utm_campaign") || queryParameter.contains("utm_source") || queryParameter.contains("utm_medium") || queryParameter.contains("utm_term") || queryParameter.contains("utm_content")))) {
                    this.zzanw.zzge().zzis().log("Activity created with data 'referrer' param without gclid and at least one utm field");
                    AppMethodBeat.o(1758);
                    return;
                }
                this.zzanw.zzge().zzis().zzg("Activity created with referrer", queryParameter);
                if (!TextUtils.isEmpty(queryParameter)) {
                    this.zzanw.setUserProperty("auto", "_ldl", queryParameter);
                }
            }
        } catch (Exception e2) {
            this.zzanw.zzge().zzim().zzg("Throwable caught in onActivityCreated", e2);
        }
        this.zzanw.zzfy().onActivityCreated(activity, bundle);
        AppMethodBeat.o(1758);
    }

    public final void onActivityDestroyed(Activity activity) {
        AppMethodBeat.i(1759);
        this.zzanw.zzfy().onActivityDestroyed(activity);
        AppMethodBeat.o(1759);
    }

    public final void onActivityPaused(Activity activity) {
        AppMethodBeat.i(1760);
        this.zzanw.zzfy().onActivityPaused(activity);
        zzjh zzgc = this.zzanw.zzgc();
        zzgc.zzgd().zzc(new zzjl(zzgc, zzgc.zzbt().elapsedRealtime()));
        AppMethodBeat.o(1760);
    }

    public final void onActivityResumed(Activity activity) {
        AppMethodBeat.i(1761);
        this.zzanw.zzfy().onActivityResumed(activity);
        zzjh zzgc = this.zzanw.zzgc();
        zzgc.zzgd().zzc(new zzjk(zzgc, zzgc.zzbt().elapsedRealtime()));
        AppMethodBeat.o(1761);
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        AppMethodBeat.i(1762);
        this.zzanw.zzfy().onActivitySaveInstanceState(activity, bundle);
        AppMethodBeat.o(1762);
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }
}
