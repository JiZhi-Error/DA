package com.google.android.gms.measurement;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.support.v4.e.a;
import com.facebook.AccessToken;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.GoogleServices;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzgl;
import com.google.android.gms.internal.measurement.zzie;
import com.google.android.gms.internal.measurement.zzjx;
import com.google.android.gms.internal.measurement.zzka;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.Map;

@Keep
@Deprecated
public class AppMeasurement {
    @KeepForSdk
    public static final String CRASH_ORIGIN = "crash";
    @KeepForSdk
    public static final String FCM_ORIGIN = "fcm";
    private final zzgl zzacw;

    @KeepForSdk
    public static class ConditionalUserProperty {
        @Keep
        @KeepForSdk
        public boolean mActive;
        @Keep
        @KeepForSdk
        public String mAppId;
        @Keep
        @KeepForSdk
        public long mCreationTimestamp;
        @Keep
        public String mExpiredEventName;
        @Keep
        public Bundle mExpiredEventParams;
        @Keep
        @KeepForSdk
        public String mName;
        @Keep
        @KeepForSdk
        public String mOrigin;
        @Keep
        @KeepForSdk
        public long mTimeToLive;
        @Keep
        public String mTimedOutEventName;
        @Keep
        public Bundle mTimedOutEventParams;
        @Keep
        @KeepForSdk
        public String mTriggerEventName;
        @Keep
        @KeepForSdk
        public long mTriggerTimeout;
        @Keep
        public String mTriggeredEventName;
        @Keep
        public Bundle mTriggeredEventParams;
        @Keep
        @KeepForSdk
        public long mTriggeredTimestamp;
        @Keep
        @KeepForSdk
        public Object mValue;

        public ConditionalUserProperty() {
        }

        public ConditionalUserProperty(ConditionalUserProperty conditionalUserProperty) {
            AppMethodBeat.i(2299);
            Preconditions.checkNotNull(conditionalUserProperty);
            this.mAppId = conditionalUserProperty.mAppId;
            this.mOrigin = conditionalUserProperty.mOrigin;
            this.mCreationTimestamp = conditionalUserProperty.mCreationTimestamp;
            this.mName = conditionalUserProperty.mName;
            if (conditionalUserProperty.mValue != null) {
                this.mValue = zzka.zzf(conditionalUserProperty.mValue);
                if (this.mValue == null) {
                    this.mValue = conditionalUserProperty.mValue;
                }
            }
            this.mActive = conditionalUserProperty.mActive;
            this.mTriggerEventName = conditionalUserProperty.mTriggerEventName;
            this.mTriggerTimeout = conditionalUserProperty.mTriggerTimeout;
            this.mTimedOutEventName = conditionalUserProperty.mTimedOutEventName;
            if (conditionalUserProperty.mTimedOutEventParams != null) {
                this.mTimedOutEventParams = new Bundle(conditionalUserProperty.mTimedOutEventParams);
            }
            this.mTriggeredEventName = conditionalUserProperty.mTriggeredEventName;
            if (conditionalUserProperty.mTriggeredEventParams != null) {
                this.mTriggeredEventParams = new Bundle(conditionalUserProperty.mTriggeredEventParams);
            }
            this.mTriggeredTimestamp = conditionalUserProperty.mTriggeredTimestamp;
            this.mTimeToLive = conditionalUserProperty.mTimeToLive;
            this.mExpiredEventName = conditionalUserProperty.mExpiredEventName;
            if (conditionalUserProperty.mExpiredEventParams != null) {
                this.mExpiredEventParams = new Bundle(conditionalUserProperty.mExpiredEventParams);
            }
            AppMethodBeat.o(2299);
        }
    }

    @KeepForSdk
    public static final class Event extends FirebaseAnalytics.a {
        @KeepForSdk
        public static final String AD_REWARD = "_ar";
        @KeepForSdk
        public static final String APP_EXCEPTION = "_ae";
        public static final String[] zzacx = {"app_clear_data", "app_exception", "app_remove", "app_upgrade", "app_install", "app_update", "firebase_campaign", "error", "first_open", "first_visit", "in_app_purchase", "notification_dismiss", "notification_foreground", "notification_open", "notification_receive", "os_update", "session_start", "user_engagement", "ad_exposure", "adunit_exposure", "ad_query", "ad_activeview", "ad_impression", "ad_click", "ad_reward", "screen_view", "ga_extra_parameter"};
        public static final String[] zzacy = {"_cd", APP_EXCEPTION, "_ui", "_ug", "_in", "_au", "_cmp", "_err", "_f", "_v", "_iap", "_nd", "_nf", "_no", "_nr", "_ou", "_s", "_e", "_xa", "_xu", "_aq", "_aa", "_ai", "_ac", AD_REWARD, "_vs", "_ep"};

        private Event() {
        }

        public static String zzak(String str) {
            AppMethodBeat.i(2300);
            String zza = zzka.zza(str, zzacx, zzacy);
            AppMethodBeat.o(2300);
            return zza;
        }
    }

    @KeepForSdk
    public interface EventInterceptor {
        @KeepForSdk
        void interceptEvent(String str, String str2, Bundle bundle, long j2);
    }

    @KeepForSdk
    public interface OnEventListener {
        @KeepForSdk
        void onEvent(String str, String str2, Bundle bundle, long j2);
    }

    @KeepForSdk
    public static final class Param extends FirebaseAnalytics.b {
        @KeepForSdk
        public static final String FATAL = "fatal";
        @KeepForSdk
        public static final String TIMESTAMP = "timestamp";
        @KeepForSdk
        public static final String TYPE = "type";
        public static final String[] zzacz = {"firebase_conversion", "engagement_time_msec", "exposure_time", "ad_event_id", "ad_unit_id", "firebase_error", "firebase_error_value", "firebase_error_length", "firebase_event_origin", "firebase_screen", "firebase_screen_class", "firebase_screen_id", "firebase_previous_screen", "firebase_previous_class", "firebase_previous_id", "message_device_time", "message_id", "message_name", "message_time", "previous_app_version", "previous_os_version", "topic", "update_with_analytics", "previous_first_open_count", "system_app", "system_app_update", "previous_install_count", "ga_event_id", "ga_extra_params_ct", "ga_group_name", "ga_list_length", "ga_index", "ga_event_name", "campaign_info_source", "deferred_analytics_collection"};
        public static final String[] zzada = {"_c", "_et", "_xt", "_aeid", "_ai", "_err", "_ev", "_el", "_o", "_sn", "_sc", "_si", "_pn", "_pc", "_pi", "_ndt", "_nmid", "_nmn", "_nmt", "_pv", "_po", "_nt", "_uwa", "_pfo", "_sys", "_sysu", "_pin", "_eid", "_epc", "_gn", "_ll", "_i", "_en", "_cis", "_dac"};

        private Param() {
        }

        public static String zzak(String str) {
            AppMethodBeat.i(2301);
            String zza = zzka.zza(str, zzacz, zzada);
            AppMethodBeat.o(2301);
            return zza;
        }
    }

    @KeepForSdk
    public static final class UserProperty extends FirebaseAnalytics.c {
        @KeepForSdk
        public static final String FIREBASE_LAST_NOTIFICATION = "_ln";
        public static final String[] zzadb = {"firebase_last_notification", "first_open_time", "first_visit_time", "last_deep_link_referrer", AccessToken.USER_ID_KEY, "first_open_after_install", "lifetime_user_engagement"};
        public static final String[] zzadc = {FIREBASE_LAST_NOTIFICATION, "_fot", "_fvt", "_ldl", "_id", "_fi", "_lte"};

        private UserProperty() {
        }

        public static String zzak(String str) {
            AppMethodBeat.i(2302);
            String zza = zzka.zza(str, zzadb, zzadc);
            AppMethodBeat.o(2302);
            return zza;
        }
    }

    public AppMeasurement(zzgl zzgl) {
        AppMethodBeat.i(2309);
        Preconditions.checkNotNull(zzgl);
        this.zzacw = zzgl;
        AppMethodBeat.o(2309);
    }

    @Keep
    @Deprecated
    public static AppMeasurement getInstance(Context context) {
        AppMethodBeat.i(2303);
        AppMeasurement zzjr = zzgl.zzg(context).zzjr();
        AppMethodBeat.o(2303);
        return zzjr;
    }

    @Keep
    public void beginAdUnitExposure(String str) {
        AppMethodBeat.i(2322);
        this.zzacw.zzft().beginAdUnitExposure(str);
        AppMethodBeat.o(2322);
    }

    @Keep
    @KeepForSdk
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        AppMethodBeat.i(2326);
        this.zzacw.zzfu().clearConditionalUserProperty(str, str2, bundle);
        AppMethodBeat.o(2326);
    }

    /* access modifiers changed from: protected */
    @Keep
    @VisibleForTesting
    public void clearConditionalUserPropertyAs(String str, String str2, String str3, Bundle bundle) {
        AppMethodBeat.i(2327);
        this.zzacw.zzfu().clearConditionalUserPropertyAs(str, str2, str3, bundle);
        AppMethodBeat.o(2327);
    }

    @Keep
    public void endAdUnitExposure(String str) {
        AppMethodBeat.i(2323);
        this.zzacw.zzft().endAdUnitExposure(str);
        AppMethodBeat.o(2323);
    }

    @Keep
    public long generateEventId() {
        AppMethodBeat.i(2321);
        long zzlb = this.zzacw.zzgb().zzlb();
        AppMethodBeat.o(2321);
        return zzlb;
    }

    @Keep
    public String getAppInstanceId() {
        AppMethodBeat.i(2319);
        String zzja = this.zzacw.zzfu().zzja();
        AppMethodBeat.o(2319);
        return zzja;
    }

    @KeepForSdk
    public Boolean getBoolean() {
        AppMethodBeat.i(2333);
        Boolean zzjx = this.zzacw.zzfu().zzjx();
        AppMethodBeat.o(2333);
        return zzjx;
    }

    @Keep
    @KeepForSdk
    public List<ConditionalUserProperty> getConditionalUserProperties(String str, String str2) {
        AppMethodBeat.i(2330);
        List<ConditionalUserProperty> conditionalUserProperties = this.zzacw.zzfu().getConditionalUserProperties(str, str2);
        AppMethodBeat.o(2330);
        return conditionalUserProperties;
    }

    /* access modifiers changed from: protected */
    @Keep
    @VisibleForTesting
    public List<ConditionalUserProperty> getConditionalUserPropertiesAs(String str, String str2, String str3) {
        AppMethodBeat.i(2331);
        List<ConditionalUserProperty> conditionalUserPropertiesAs = this.zzacw.zzfu().getConditionalUserPropertiesAs(str, str2, str3);
        AppMethodBeat.o(2331);
        return conditionalUserPropertiesAs;
    }

    @Keep
    public String getCurrentScreenClass() {
        AppMethodBeat.i(2318);
        zzie zzkd = this.zzacw.zzfy().zzkd();
        if (zzkd != null) {
            String str = zzkd.zzaoi;
            AppMethodBeat.o(2318);
            return str;
        }
        AppMethodBeat.o(2318);
        return null;
    }

    @Keep
    public String getCurrentScreenName() {
        AppMethodBeat.i(2317);
        zzie zzkd = this.zzacw.zzfy().zzkd();
        if (zzkd != null) {
            String str = zzkd.zzul;
            AppMethodBeat.o(2317);
            return str;
        }
        AppMethodBeat.o(2317);
        return null;
    }

    @KeepForSdk
    public Double getDouble() {
        AppMethodBeat.i(2337);
        Double zzka = this.zzacw.zzfu().zzka();
        AppMethodBeat.o(2337);
        return zzka;
    }

    @Keep
    public String getGmpAppId() {
        AppMethodBeat.i(2320);
        try {
            String googleAppId = GoogleServices.getGoogleAppId();
            AppMethodBeat.o(2320);
            return googleAppId;
        } catch (IllegalStateException e2) {
            this.zzacw.zzge().zzim().zzg("getGoogleAppId failed with exception", e2);
            AppMethodBeat.o(2320);
            return null;
        }
    }

    @KeepForSdk
    public Integer getInteger() {
        AppMethodBeat.i(2336);
        Integer zzjz = this.zzacw.zzfu().zzjz();
        AppMethodBeat.o(2336);
        return zzjz;
    }

    @KeepForSdk
    public Long getLong() {
        AppMethodBeat.i(2335);
        Long zzjy = this.zzacw.zzfu().zzjy();
        AppMethodBeat.o(2335);
        return zzjy;
    }

    @Keep
    @KeepForSdk
    public int getMaxUserProperties(String str) {
        AppMethodBeat.i(2332);
        this.zzacw.zzfu();
        Preconditions.checkNotEmpty(str);
        AppMethodBeat.o(2332);
        return 25;
    }

    @KeepForSdk
    public String getString() {
        AppMethodBeat.i(2334);
        String zzhm = this.zzacw.zzfu().zzhm();
        AppMethodBeat.o(2334);
        return zzhm;
    }

    /* access modifiers changed from: protected */
    @Keep
    @VisibleForTesting
    public Map<String, Object> getUserProperties(String str, String str2, boolean z) {
        AppMethodBeat.i(2328);
        Map<String, Object> userProperties = this.zzacw.zzfu().getUserProperties(str, str2, z);
        AppMethodBeat.o(2328);
        return userProperties;
    }

    @KeepForSdk
    public Map<String, Object> getUserProperties(boolean z) {
        AppMethodBeat.i(2313);
        List<zzjx> zzj = this.zzacw.zzfu().zzj(z);
        a aVar = new a(zzj.size());
        for (zzjx zzjx : zzj) {
            aVar.put(zzjx.name, zzjx.getValue());
        }
        AppMethodBeat.o(2313);
        return aVar;
    }

    /* access modifiers changed from: protected */
    @Keep
    @VisibleForTesting
    public Map<String, Object> getUserPropertiesAs(String str, String str2, String str3, boolean z) {
        AppMethodBeat.i(2329);
        Map<String, Object> userPropertiesAs = this.zzacw.zzfu().getUserPropertiesAs(str, str2, str3, z);
        AppMethodBeat.o(2329);
        return userPropertiesAs;
    }

    public final void logEvent(String str, Bundle bundle) {
        AppMethodBeat.i(2304);
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.zzacw.zzfu().zza("app", str, bundle, true);
        AppMethodBeat.o(2304);
    }

    @Keep
    public void logEventInternal(String str, String str2, Bundle bundle) {
        AppMethodBeat.i(2310);
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.zzacw.zzfu().logEvent(str, str2, bundle);
        AppMethodBeat.o(2310);
    }

    @KeepForSdk
    public void logEventInternalNoInterceptor(String str, String str2, Bundle bundle, long j2) {
        AppMethodBeat.i(2311);
        this.zzacw.zzfu().zza(str, str2, bundle == null ? new Bundle() : bundle, j2);
        AppMethodBeat.o(2311);
    }

    @KeepForSdk
    public void registerOnMeasurementEventListener(OnEventListener onEventListener) {
        AppMethodBeat.i(2315);
        this.zzacw.zzfu().registerOnMeasurementEventListener(onEventListener);
        AppMethodBeat.o(2315);
    }

    @Keep
    @KeepForSdk
    public void setConditionalUserProperty(ConditionalUserProperty conditionalUserProperty) {
        AppMethodBeat.i(2324);
        this.zzacw.zzfu().setConditionalUserProperty(conditionalUserProperty);
        AppMethodBeat.o(2324);
    }

    /* access modifiers changed from: protected */
    @Keep
    @VisibleForTesting
    public void setConditionalUserPropertyAs(ConditionalUserProperty conditionalUserProperty) {
        AppMethodBeat.i(2325);
        this.zzacw.zzfu().setConditionalUserPropertyAs(conditionalUserProperty);
        AppMethodBeat.o(2325);
    }

    @KeepForSdk
    public void setEventInterceptor(EventInterceptor eventInterceptor) {
        AppMethodBeat.i(2314);
        this.zzacw.zzfu().setEventInterceptor(eventInterceptor);
        AppMethodBeat.o(2314);
    }

    @Deprecated
    public void setMeasurementEnabled(boolean z) {
        AppMethodBeat.i(2306);
        this.zzacw.zzfu().setMeasurementEnabled(z);
        AppMethodBeat.o(2306);
    }

    public final void setMinimumSessionDuration(long j2) {
        AppMethodBeat.i(2307);
        this.zzacw.zzfu().setMinimumSessionDuration(j2);
        AppMethodBeat.o(2307);
    }

    public final void setSessionTimeoutDuration(long j2) {
        AppMethodBeat.i(2308);
        this.zzacw.zzfu().setSessionTimeoutDuration(j2);
        AppMethodBeat.o(2308);
    }

    public final void setUserProperty(String str, String str2) {
        AppMethodBeat.i(2305);
        int zzce = this.zzacw.zzgb().zzce(str);
        if (zzce != 0) {
            this.zzacw.zzgb();
            this.zzacw.zzgb().zza(zzce, "_ev", zzka.zza(str, 24, true), str != null ? str.length() : 0);
            AppMethodBeat.o(2305);
            return;
        }
        setUserPropertyInternal("app", str, str2);
        AppMethodBeat.o(2305);
    }

    @KeepForSdk
    public void setUserPropertyInternal(String str, String str2, Object obj) {
        AppMethodBeat.i(2312);
        this.zzacw.zzfu().setUserProperty(str, str2, obj);
        AppMethodBeat.o(2312);
    }

    @KeepForSdk
    public void unregisterOnMeasurementEventListener(OnEventListener onEventListener) {
        AppMethodBeat.i(2316);
        this.zzacw.zzfu().unregisterOnMeasurementEventListener(onEventListener);
        AppMethodBeat.o(2316);
    }
}
