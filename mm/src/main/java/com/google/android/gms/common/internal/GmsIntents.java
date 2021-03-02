package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.y;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.AccountPicker;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.android.gms.common.api.Scope;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;

public class GmsIntents {
    public static final String ACTION_FITNESS_APP_DISCONNECTED = "com.google.android.gms.fitness.app_disconnected";
    public static final String ACTION_ICING_CONTACT_CHANGED = "com.google.android.gms.icing.action.CONTACT_CHANGED";
    public static final String ACTION_SET_GMS_ACCOUNT = "com.google.android.gms.common.SET_GMS_ACCOUNT";
    public static final String ACTION_UDC_SETTING_CHANGED = "com.google.android.gms.udc.action.SETTING_CHANGED";
    public static final String BROADCAST_CIRCLES_CHANGED = "com.google.android.gms.people.BROADCAST_CIRCLES_CHANGED";
    public static final String COMMON_SIGN_IN_EXTRA_PACKAGE_NAME = "SIGN_IN_PACKAGE_NAME";
    public static final String COMMON_SIGN_IN_EXTRA_SAVE_DEFAULT_ACCOUNT = "SIGN_IN_SAVE_DEFAULT_ACCOUNT";
    public static final String COMMON_SIGN_IN_EXTRA_SCOPE_ARRAY = "SIGN_IN_SCOPE_ARRAY";
    public static final String EXTRA_ACCOUNT = "com.google.android.gms.fitness.disconnected_account";
    public static final String EXTRA_APP = "com.google.android.gms.fitness.disconnected_app";
    public static final String EXTRA_ICING_CONTACT_CHANGED_IS_SIGNIFICANT = "com.google.android.gms.icing.extra.isSignificant";
    public static final String EXTRA_SET_GMS_ACCOUNT_NAME = "ACCOUNT_NAME";
    public static final String EXTRA_SET_GMS_ACCOUNT_PACKAGE_NAME = "PACKAGE_NAME";
    public static final String EXTRA_UDC_ACCOUNT_NAME = "com.google.android.gms.udc.extra.accountName";
    public static final String EXTRA_UDC_SETTING_ID_LIST = "com.google.android.gms.udc.extra.settingIdList";
    public static final String GOOGLE_NOW_PACKAGE_NAME = "com.google.android.googlequicksearchbox";
    public static final String MIME_ACTIVITY_DISCONNECT_TYPE = "vnd.google.android.fitness/app_disconnect";
    public static final String PERMISSION_GMS_INTERNAL_BROADCAST = "com.google.android.gms.permission.INTERNAL_BROADCAST";
    private static final Uri zztz;
    private static final Uri zzua;

    static {
        AppMethodBeat.i(4663);
        Uri parse = Uri.parse("https://plus.google.com/");
        zztz = parse;
        zzua = parse.buildUpon().appendPath("circles").appendPath("find").build();
        AppMethodBeat.o(4663);
    }

    private GmsIntents() {
    }

    public static Intent createAndroidWearUpdateIntent() {
        AppMethodBeat.i(4650);
        Intent intent = new Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
        intent.setPackage("com.google.android.wearable.app");
        AppMethodBeat.o(4650);
        return intent;
    }

    public static Intent createChooseGmsAccountIntent() {
        AppMethodBeat.i(4658);
        Intent newChooseAccountIntent = AccountPicker.newChooseAccountIntent(null, null, new String[]{"com.google"}, true, null, null, null, null, true);
        AppMethodBeat.o(4658);
        return newChooseAccountIntent;
    }

    public static Intent createChooseGmsAccountWithConsentIntent(String str, Scope[] scopeArr, boolean z) {
        AppMethodBeat.i(4659);
        Intent intent = new Intent("com.google.android.gms.signin.action.SIGN_IN");
        intent.putExtra(COMMON_SIGN_IN_EXTRA_PACKAGE_NAME, str);
        intent.putExtra(COMMON_SIGN_IN_EXTRA_SCOPE_ARRAY, scopeArr);
        intent.putExtra(COMMON_SIGN_IN_EXTRA_SAVE_DEFAULT_ACCOUNT, z);
        AppMethodBeat.o(4659);
        return intent;
    }

    public static Intent createDateSettingsIntent() {
        AppMethodBeat.i(4644);
        Intent intent = new Intent("android.settings.DATE_SETTINGS");
        AppMethodBeat.o(4644);
        return intent;
    }

    public static Intent createFindPeopleIntent(Context context) {
        AppMethodBeat.i(4654);
        Intent zza = zza(context, zzua);
        AppMethodBeat.o(4654);
        return zza;
    }

    public static Intent createPlayStoreGamesIntent(Context context) {
        AppMethodBeat.i(4649);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(GooglePlayServicesUtilLight.GOOGLE_PLAY_STORE_GAMES_URI_STRING));
        intent.addFlags(524288);
        intent.setPackage("com.android.vending");
        if (context.getPackageManager().resolveActivity(intent, 65536) == null) {
            Intent intent2 = new Intent(intent.getAction(), intent.getData());
            intent2.setFlags(intent.getFlags());
            AppMethodBeat.o(4649);
            return intent2;
        }
        AppMethodBeat.o(4649);
        return intent;
    }

    public static Intent createPlayStoreIntent(String str) {
        AppMethodBeat.i(4646);
        Intent createPlayStoreIntent = createPlayStoreIntent(str, null);
        AppMethodBeat.o(4646);
        return createPlayStoreIntent;
    }

    public static Intent createPlayStoreIntent(String str, String str2) {
        AppMethodBeat.i(4647);
        Intent intent = new Intent("android.intent.action.VIEW");
        Uri.Builder appendQueryParameter = Uri.parse("market://details").buildUpon().appendQueryParameter("id", str);
        if (!TextUtils.isEmpty(str2)) {
            appendQueryParameter.appendQueryParameter("pcampaignid", str2);
        }
        intent.setData(appendQueryParameter.build());
        intent.setPackage("com.android.vending");
        intent.addFlags(524288);
        AppMethodBeat.o(4647);
        return intent;
    }

    public static Intent createPlayStoreLightPurchaseFlowIntent(Context context, String str, String str2) {
        AppMethodBeat.i(4648);
        Intent intent = new Intent("com.android.vending.billing.PURCHASE");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setPackage("com.android.vending");
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("authAccount", str);
        }
        intent.putExtra("backend", 3);
        intent.putExtra("document_type", 1);
        intent.putExtra("full_docid", str2);
        intent.putExtra("backend_docid", str2);
        intent.putExtra("offer_type", 1);
        if (!isIntentResolvable(context.getPackageManager(), intent)) {
            intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(String.format(Locale.US, "https://play.google.com/store/apps/details?id=%1$s&rdid=%1$s&rdot=%2$d", str2, 1)));
            intent.setPackage("com.android.vending");
            intent.putExtra("use_direct_purchase", true);
        }
        AppMethodBeat.o(4648);
        return intent;
    }

    public static Intent createSettingsIntent(String str) {
        AppMethodBeat.i(4643);
        Uri fromParts = Uri.fromParts("package", str, null);
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(fromParts);
        AppMethodBeat.o(4643);
        return intent;
    }

    public static Intent createShowProfileIntent(Context context, String str) {
        AppMethodBeat.i(4655);
        Intent zza = zza(context, Uri.parse(String.format("https://plus.google.com/%s/about", str)));
        AppMethodBeat.o(4655);
        return zza;
    }

    public static Intent getFitnessAppDisconnectedIntent(String str, String str2) {
        AppMethodBeat.i(4662);
        Intent intent = new Intent();
        intent.setPackage("com.google.android.gms");
        intent.setAction(ACTION_FITNESS_APP_DISCONNECTED);
        intent.setType(MIME_ACTIVITY_DISCONNECT_TYPE);
        intent.putExtra(EXTRA_APP, str);
        intent.putExtra(EXTRA_ACCOUNT, str2);
        AppMethodBeat.o(4662);
        return intent;
    }

    public static Uri getPlayStoreUri(String str) {
        AppMethodBeat.i(4645);
        Uri build = Uri.parse("https://play.google.com/store/apps/details").buildUpon().appendQueryParameter("id", str).build();
        AppMethodBeat.o(4645);
        return build;
    }

    public static boolean isIntentResolvable(PackageManager packageManager, Intent intent) {
        AppMethodBeat.i(4661);
        if (packageManager.resolveActivity(intent, 65536) != null) {
            AppMethodBeat.o(4661);
            return true;
        }
        AppMethodBeat.o(4661);
        return false;
    }

    public static void sendIcingContactChangedBroadcast(Context context, boolean z) {
        AppMethodBeat.i(4653);
        Intent putExtra = new Intent(ACTION_ICING_CONTACT_CHANGED).setPackage("com.google.android.gms").putExtra(EXTRA_ICING_CONTACT_CHANGED_IS_SIGNIFICANT, z);
        if (Log.isLoggable("GmsIntents", 2)) {
            String action = putExtra.getAction();
            new StringBuilder(String.valueOf(action).length() + 98).append("Icing detected contact change, broadcasting it with intent action: ").append(action).append(" and isSignificant extra: ").append(z);
        }
        context.sendBroadcast(putExtra);
        AppMethodBeat.o(4653);
    }

    public static void sendSetGmsAccountIntent(Context context, String str, String str2) {
        AppMethodBeat.i(4660);
        Intent intent = new Intent(ACTION_SET_GMS_ACCOUNT);
        intent.putExtra(EXTRA_SET_GMS_ACCOUNT_NAME, str);
        intent.putExtra(EXTRA_SET_GMS_ACCOUNT_PACKAGE_NAME, str2);
        intent.setPackage("com.google.android.gms");
        context.sendBroadcast(intent, PERMISSION_GMS_INTERNAL_BROADCAST);
        AppMethodBeat.o(4660);
    }

    public static void sendUdcSettingsChangedBroadcast(Context context, String str, int[] iArr) {
        AppMethodBeat.i(4651);
        zza("com.google.android.gms", context, str, iArr);
        if (!GoogleSignatureVerifier.getInstance(context).isPackageGoogleSigned(GOOGLE_NOW_PACKAGE_NAME)) {
            Log.isLoggable("GmsIntents", 5);
            AppMethodBeat.o(4651);
            return;
        }
        zza(GOOGLE_NOW_PACKAGE_NAME, context, str, iArr);
        AppMethodBeat.o(4651);
    }

    private static Intent zza(Context context, Uri uri) {
        AppMethodBeat.i(4656);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.setPackage("com.google.android.apps.plus");
        if (isIntentResolvable(context.getPackageManager(), intent)) {
            AppMethodBeat.o(4656);
            return intent;
        }
        Intent createPlayStoreIntent = createPlayStoreIntent("com.google.android.apps.plus");
        AppMethodBeat.o(4656);
        return createPlayStoreIntent;
    }

    private static void zza(String str, Context context, String str2, int[] iArr) {
        AppMethodBeat.i(4652);
        Intent putExtra = new Intent(ACTION_UDC_SETTING_CHANGED).setPackage(str).putExtra(EXTRA_UDC_ACCOUNT_NAME, str2).putExtra(EXTRA_UDC_SETTING_ID_LIST, iArr);
        if (Log.isLoggable("GmsIntents", 3)) {
            String action = putExtra.getAction();
            new StringBuilder(String.valueOf(str).length() + 72 + String.valueOf(action).length()).append("UDC settings changed, sending broadcast to package ").append(str).append(" with intent action: ").append(action);
        }
        context.sendBroadcast(putExtra);
        AppMethodBeat.o(4652);
    }

    public static Intent createShareOnPlusIntent(Activity activity, String str, String str2) {
        AppMethodBeat.i(4657);
        y.a aVar = new y.a(activity);
        aVar.mIntent.putExtra("android.intent.extra.SUBJECT", str);
        aVar.mIntent.putExtra("android.intent.extra.TEXT", (CharSequence) str2);
        aVar.mIntent.setType("text/plain");
        if (aVar.IN != null) {
            aVar.b("android.intent.extra.EMAIL", aVar.IN);
            aVar.IN = null;
        }
        if (aVar.IP != null) {
            aVar.b("android.intent.extra.CC", aVar.IP);
            aVar.IP = null;
        }
        if (aVar.IQ != null) {
            aVar.b("android.intent.extra.BCC", aVar.IQ);
            aVar.IQ = null;
        }
        boolean z = aVar.IR != null && aVar.IR.size() > 1;
        boolean equals = aVar.mIntent.getAction().equals("android.intent.action.SEND_MULTIPLE");
        if (!z && equals) {
            aVar.mIntent.setAction("android.intent.action.SEND");
            if (aVar.IR == null || aVar.IR.isEmpty()) {
                aVar.mIntent.removeExtra("android.intent.extra.STREAM");
            } else {
                aVar.mIntent.putExtra("android.intent.extra.STREAM", aVar.IR.get(0));
            }
            aVar.IR = null;
        }
        if (z && !equals) {
            aVar.mIntent.setAction("android.intent.action.SEND_MULTIPLE");
            if (aVar.IR == null || aVar.IR.isEmpty()) {
                aVar.mIntent.removeExtra("android.intent.extra.STREAM");
            } else {
                aVar.mIntent.putParcelableArrayListExtra("android.intent.extra.STREAM", aVar.IR);
            }
        }
        Intent intent = aVar.mIntent;
        intent.setPackage("com.google.android.apps.plus");
        if (isIntentResolvable(activity.getPackageManager(), intent)) {
            AppMethodBeat.o(4657);
            return intent;
        }
        Intent createPlayStoreIntent = createPlayStoreIntent("com.google.android.apps.plus");
        AppMethodBeat.o(4657);
        return createPlayStoreIntent;
    }
}
