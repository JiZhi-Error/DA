package com.facebook.appevents.internal;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Validate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore;
import java.math.BigDecimal;
import java.util.Currency;
import org.json.JSONException;
import org.json.JSONObject;

public class AutomaticAnalyticsLogger {
    private static final String TAG = AutomaticAnalyticsLogger.class.getCanonicalName();
    private static final InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(FacebookSdk.getApplicationContext());

    static {
        AppMethodBeat.i(17614);
        AppMethodBeat.o(17614);
    }

    public static void logActivateAppEvent() {
        AppMethodBeat.i(17608);
        Context applicationContext = FacebookSdk.getApplicationContext();
        String applicationId = FacebookSdk.getApplicationId();
        boolean autoLogAppEventsEnabled = FacebookSdk.getAutoLogAppEventsEnabled();
        Validate.notNull(applicationContext, "context");
        if (autoLogAppEventsEnabled && (applicationContext instanceof Application)) {
            AppEventsLogger.activateApp((Application) applicationContext, applicationId);
        }
        AppMethodBeat.o(17608);
    }

    public static void logActivityTimeSpentEvent(String str, long j2) {
        AppMethodBeat.i(17609);
        Context applicationContext = FacebookSdk.getApplicationContext();
        String applicationId = FacebookSdk.getApplicationId();
        Validate.notNull(applicationContext, "context");
        FetchedAppSettings queryAppSettings = FetchedAppSettingsManager.queryAppSettings(applicationId, false);
        if (queryAppSettings != null && queryAppSettings.getAutomaticLoggingEnabled() && j2 > 0) {
            AppEventsLogger newLogger = AppEventsLogger.newLogger(applicationContext);
            Bundle bundle = new Bundle(1);
            bundle.putCharSequence(Constants.AA_TIME_SPENT_SCREEN_PARAMETER_NAME, str);
            newLogger.logEvent(Constants.AA_TIME_SPENT_EVENT_NAME, (double) j2, bundle);
        }
        AppMethodBeat.o(17609);
    }

    public static void logPurchaseInapp(String str, String str2) {
        AppMethodBeat.i(17610);
        if (!isImplicitPurchaseLoggingEnabled()) {
            AppMethodBeat.o(17610);
            return;
        }
        PurchaseLoggingParameters purchaseLoggingParameters = getPurchaseLoggingParameters(str, str2);
        if (purchaseLoggingParameters != null) {
            internalAppEventsLogger.logPurchaseImplicitlyInternal(purchaseLoggingParameters.purchaseAmount, purchaseLoggingParameters.currency, purchaseLoggingParameters.param);
        }
        AppMethodBeat.o(17610);
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void logPurchaseSubs(com.facebook.appevents.internal.SubscriptionType r6, java.lang.String r7, java.lang.String r8) {
        /*
        // Method dump skipped, instructions count: 102
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.internal.AutomaticAnalyticsLogger.logPurchaseSubs(com.facebook.appevents.internal.SubscriptionType, java.lang.String, java.lang.String):void");
    }

    public static boolean isImplicitPurchaseLoggingEnabled() {
        AppMethodBeat.i(17612);
        FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
        if (appSettingsWithoutQuery == null || !FacebookSdk.getAutoLogAppEventsEnabled() || !appSettingsWithoutQuery.getIAPAutomaticLoggingEnabled()) {
            AppMethodBeat.o(17612);
            return false;
        }
        AppMethodBeat.o(17612);
        return true;
    }

    private static PurchaseLoggingParameters getPurchaseLoggingParameters(String str, String str2) {
        AppMethodBeat.i(17613);
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = new JSONObject(str2);
            Bundle bundle = new Bundle(1);
            bundle.putCharSequence(Constants.IAP_PRODUCT_ID, jSONObject.getString("productId"));
            bundle.putCharSequence(Constants.IAP_PURCHASE_TIME, jSONObject.getString("purchaseTime"));
            bundle.putCharSequence(Constants.IAP_PURCHASE_TOKEN, jSONObject.getString("purchaseToken"));
            bundle.putCharSequence(Constants.IAP_PACKAGE_NAME, jSONObject.optString(AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME));
            bundle.putCharSequence(Constants.IAP_PRODUCT_TITLE, jSONObject2.optString("title"));
            bundle.putCharSequence(Constants.IAP_PRODUCT_DESCRIPTION, jSONObject2.optString("description"));
            String optString = jSONObject2.optString("type");
            bundle.putCharSequence(Constants.IAP_PRODUCT_TYPE, optString);
            if (optString.equals("subs")) {
                bundle.putCharSequence(Constants.IAP_SUBSCRIPTION_AUTORENEWING, Boolean.toString(jSONObject.optBoolean("autoRenewing", false)));
                bundle.putCharSequence(Constants.IAP_SUBSCRIPTION_PERIOD, jSONObject2.optString("subscriptionPeriod"));
                bundle.putCharSequence(Constants.IAP_FREE_TRIAL_PERIOD, jSONObject2.optString("freeTrialPeriod"));
                String optString2 = jSONObject2.optString("introductoryPriceCycles");
                if (!optString2.isEmpty()) {
                    bundle.putCharSequence(Constants.IAP_INTRO_PRICE_AMOUNT_MICROS, jSONObject2.optString("introductoryPriceAmountMicros"));
                    bundle.putCharSequence(Constants.IAP_INTRO_PRICE_CYCLES, optString2);
                }
            }
            PurchaseLoggingParameters purchaseLoggingParameters = new PurchaseLoggingParameters(new BigDecimal(((double) jSONObject2.getLong("price_amount_micros")) / 1000000.0d), Currency.getInstance(jSONObject2.getString("price_currency_code")), bundle);
            AppMethodBeat.o(17613);
            return purchaseLoggingParameters;
        } catch (JSONException e2) {
            AppMethodBeat.o(17613);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public static class PurchaseLoggingParameters {
        Currency currency;
        Bundle param;
        BigDecimal purchaseAmount;

        PurchaseLoggingParameters(BigDecimal bigDecimal, Currency currency2, Bundle bundle) {
            this.purchaseAmount = bigDecimal;
            this.currency = currency2;
            this.param = bundle;
        }
    }
}
