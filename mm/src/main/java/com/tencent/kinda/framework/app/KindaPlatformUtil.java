package com.tencent.kinda.framework.app;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Vibrator;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.AndroidDpiLevel;
import com.tencent.kinda.gen.IOSDevice;
import com.tencent.kinda.gen.IPlatformUtil;
import com.tencent.kinda.gen.Platform;
import com.tencent.kinda.gen.VoidStringCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.compatible.util.a;
import com.tencent.mm.framework.app.UIPageFragmentActivity;
import com.tencent.mm.g.a.bn;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cr;
import com.tencent.mm.plugin.expt.h.d;
import com.tencent.mm.plugin.wallet_core.model.al;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.mm.y.c;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;

public class KindaPlatformUtil implements IPlatformUtil {
    private final String TAG = "KindaPlatformUtil";
    private final IListener checkLanguageChangeIListener = new IListener<bn>() {
        /* class com.tencent.kinda.framework.app.KindaPlatformUtil.AnonymousClass1 */

        {
            AppMethodBeat.i(160756);
            this.__eventId = bn.class.getName().hashCode();
            AppMethodBeat.o(160756);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public /* bridge */ /* synthetic */ boolean callback(bn bnVar) {
            AppMethodBeat.i(18470);
            boolean callback = callback(bnVar);
            AppMethodBeat.o(18470);
            return callback;
        }

        public boolean callback(bn bnVar) {
            AppMethodBeat.i(18469);
            if (KindaPlatformUtil.this.languageChangeCallback != null) {
                KindaPlatformUtil.this.languageChangeCallback.call(KindaPlatformUtil.this.currentLanguageCode());
            }
            AppMethodBeat.o(18469);
            return true;
        }
    };
    private VoidStringCallback languageChangeCallback = null;
    private WindowManager.LayoutParams mWindowParams;

    public KindaPlatformUtil() {
        AppMethodBeat.i(18471);
        AppMethodBeat.o(18471);
    }

    private ar.a[] getRedDotKey(String str) {
        AppMethodBeat.i(18472);
        if (str.equals("receipt")) {
            ar.a[] aVarArr = {ar.a.NEW_BANDAGE_DATASOURCE_F2F_COLLECT_STRING_SYNC, ar.a.NEW_BANDAGE_WATCHER_WALLET_COMMON_STRING_SYNC};
            AppMethodBeat.o(18472);
            return aVarArr;
        } else if (str.equals("reward")) {
            ar.a[] aVarArr2 = {ar.a.NEW_BANDAGE_DATASOURCE_QR_REWARD_STRING_SYNC, ar.a.NEW_BANDAGE_WATCHER_WALLET_COMMON_STRING_SYNC};
            AppMethodBeat.o(18472);
            return aVarArr2;
        } else if (str.equals("groupaa")) {
            ar.a[] aVarArr3 = {ar.a.NEW_BANDAGE_DATASOURCE_GROUP_PAY_STRING_SYNC, ar.a.NEW_BANDAGE_WATCHER_WALLET_COMMON_STRING_SYNC};
            AppMethodBeat.o(18472);
            return aVarArr3;
        } else if (str.equals("faceHongBao")) {
            ar.a[] aVarArr4 = {ar.a.NEW_BANDAGE_DATASOURCE_F2F_HB_STRING_SYNC, ar.a.NEW_BANDAGE_WATCHER_WALLET_COMMON_STRING_SYNC};
            AppMethodBeat.o(18472);
            return aVarArr4;
        } else if (str.equals("transferBank")) {
            ar.a[] aVarArr5 = {ar.a.NEW_BANDAGE_DATASOURCE_BANK_REMIT_STRING_SYNC, ar.a.NEW_BANDAGE_WATCHER_WALLET_COMMON_STRING_SYNC};
            AppMethodBeat.o(18472);
            return aVarArr5;
        } else {
            AppMethodBeat.o(18472);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        AppMethodBeat.i(18473);
        EventCenter.instance.removeListener(this.checkLanguageChangeIListener);
        AppMethodBeat.o(18473);
    }

    @Override // com.tencent.kinda.gen.IPlatformUtil
    public Platform currentPlatform() {
        return Platform.ANDROID;
    }

    @Override // com.tencent.kinda.gen.IPlatformUtil
    public String currentLanguageCode() {
        AppMethodBeat.i(18474);
        String currentLanguage = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
        AppMethodBeat.o(18474);
        return currentLanguage;
    }

    @Override // com.tencent.kinda.gen.IPlatformUtil
    public void setLanguageChangeCallbackImpl(VoidStringCallback voidStringCallback) {
        AppMethodBeat.i(18475);
        this.languageChangeCallback = voidStringCallback;
        EventCenter.instance.addListener(this.checkLanguageChangeIListener);
        AppMethodBeat.o(18475);
    }

    @Override // com.tencent.kinda.gen.IPlatformUtil
    public int androidAPILevel() {
        return Build.VERSION.SDK_INT;
    }

    @Override // com.tencent.kinda.gen.IPlatformUtil
    public String iOSVersion() {
        return null;
    }

    @Override // com.tencent.kinda.gen.IPlatformUtil
    public AndroidDpiLevel androidDpiLevel() {
        return AndroidDpiLevel.UNKNOWN;
    }

    @Override // com.tencent.kinda.gen.IPlatformUtil
    public IOSDevice iOSDevice() {
        return IOSDevice.UNKNOWN;
    }

    @Override // com.tencent.kinda.gen.IPlatformUtil
    public float getBottomSafeAreaHeight() {
        return 0.0f;
    }

    @Override // com.tencent.kinda.gen.IPlatformUtil
    public float getPx(float f2) {
        AppMethodBeat.i(18476);
        if (KindaContext.get() != null) {
            float f3 = f2 / KindaContext.get().getResources().getDisplayMetrics().density;
            AppMethodBeat.o(18476);
            return f3;
        }
        AppMethodBeat.o(18476);
        return f2;
    }

    @Override // com.tencent.kinda.gen.IPlatformUtil
    public float getLoigcalResolutionWidth() {
        AppMethodBeat.i(18477);
        if (KindaContext.get() != null) {
            DisplayMetrics displayMetrics = KindaContext.get().getResources().getDisplayMetrics();
            float f2 = ((float) displayMetrics.widthPixels) / displayMetrics.density;
            AppMethodBeat.o(18477);
            return f2;
        }
        AppMethodBeat.o(18477);
        return 0.0f;
    }

    @Override // com.tencent.kinda.gen.IPlatformUtil
    public float getLoigcalResolutionHeight() {
        AppMethodBeat.i(18478);
        if (KindaContext.get() != null) {
            DisplayMetrics displayMetrics = KindaContext.get().getResources().getDisplayMetrics();
            float f2 = ((float) displayMetrics.heightPixels) / displayMetrics.density;
            AppMethodBeat.o(18478);
            return f2;
        }
        AppMethodBeat.o(18478);
        return 0.0f;
    }

    @Override // com.tencent.kinda.gen.IPlatformUtil
    public float getStatusBarHeight() {
        AppMethodBeat.i(18479);
        if (KindaContext.get() != null) {
            float statusBarHeight = (float) ao.getStatusBarHeight(KindaContext.get());
            AppMethodBeat.o(18479);
            return statusBarHeight;
        }
        AppMethodBeat.o(18479);
        return 0.0f;
    }

    @Override // com.tencent.kinda.gen.IPlatformUtil
    public float getNavigationBarHeight() {
        AppMethodBeat.i(18480);
        if (KindaContext.get() != null) {
            Context context = KindaContext.get();
            if (!(context instanceof MMActivity)) {
                Log.e("KindaPlatformUtil", "KindaContext.get() is not MMActivity, is %s.", context.getClass().getName());
                AppMethodBeat.o(18480);
                return 0.0f;
            }
            float u = ((float) a.u((MMActivity) context)) / getDensity(context);
            AppMethodBeat.o(18480);
            return u;
        }
        AppMethodBeat.o(18480);
        return 0.0f;
    }

    private float getDensity(Context context) {
        AppMethodBeat.i(18481);
        if (context != null) {
            float f2 = context.getResources().getDisplayMetrics().density;
            AppMethodBeat.o(18481);
            return f2;
        }
        AppMethodBeat.o(18481);
        return 0.0f;
    }

    @Override // com.tencent.kinda.gen.IPlatformUtil
    public boolean getExptBoolValue(String str) {
        AppMethodBeat.i(18482);
        String b2 = d.cRY().b(str, "", false, false);
        if (Util.isNullOrNil(b2)) {
            AppMethodBeat.o(18482);
            return false;
        } else if (Util.getInt(b2, 0) != 0) {
            AppMethodBeat.o(18482);
            return true;
        } else {
            AppMethodBeat.o(18482);
            return false;
        }
    }

    @Override // com.tencent.kinda.gen.IPlatformUtil
    public String getPlatformString(String str) {
        return "";
    }

    @Override // com.tencent.kinda.gen.IPlatformUtil
    public boolean isPad() {
        return false;
    }

    @Override // com.tencent.kinda.gen.IPlatformUtil
    public String md5(String str) {
        AppMethodBeat.i(18483);
        String mD5String = MD5Util.getMD5String(str);
        AppMethodBeat.o(18483);
        return mD5String;
    }

    @Override // com.tencent.kinda.gen.IPlatformUtil
    public boolean getRedDotStatus(String str) {
        AppMethodBeat.i(18484);
        ar.a[] redDotKey = getRedDotKey(str);
        if (redDotKey != null) {
            boolean b2 = c.axV().b(redDotKey[0], redDotKey[1]);
            AppMethodBeat.o(18484);
            return b2;
        }
        AppMethodBeat.o(18484);
        return false;
    }

    @Override // com.tencent.kinda.gen.IPlatformUtil
    public String getRedDotWording(String str) {
        AppMethodBeat.i(18485);
        if (str.equals("receipt")) {
            g.aAi();
            String str2 = (String) g.aAh().azQ().get(ar.a.USERINFO_WALLET_FACING_REDDOT_WORDING_STRING_SYNC, "");
            AppMethodBeat.o(18485);
            return str2;
        }
        AppMethodBeat.o(18485);
        return null;
    }

    @Override // com.tencent.kinda.gen.IPlatformUtil
    public void setRedDotStatus(String str, boolean z) {
        AppMethodBeat.i(18486);
        ar.a[] redDotKey = getRedDotKey(str);
        if (redDotKey != null && !z) {
            c.axV().c(redDotKey[0], redDotKey[1]);
        }
        AppMethodBeat.o(18486);
    }

    @Override // com.tencent.kinda.gen.IPlatformUtil
    public void setStatusBarHidden(boolean z, boolean z2) {
        AppMethodBeat.i(18487);
        Activity topOrUIPageFragmentActivity = KindaContext.getTopOrUIPageFragmentActivity();
        if (!(topOrUIPageFragmentActivity instanceof UIPageFragmentActivity)) {
            Log.e("KindaPlatformUtil", "While setStatusBarHidden, We can't get the UIPageFragmentActivity on the top of stack, which we get is [" + topOrUIPageFragmentActivity + "]");
            AppMethodBeat.o(18487);
        } else if (z) {
            topOrUIPageFragmentActivity.getWindow().addFlags(1024);
            AppMethodBeat.o(18487);
        } else {
            topOrUIPageFragmentActivity.getWindow().clearFlags(1024);
            AppMethodBeat.o(18487);
        }
    }

    @Override // com.tencent.kinda.gen.IPlatformUtil
    public float getPadSplitWidth() {
        AppMethodBeat.i(18488);
        float loigcalResolutionWidth = getLoigcalResolutionWidth();
        AppMethodBeat.o(18488);
        return loigcalResolutionWidth;
    }

    @Override // com.tencent.kinda.gen.IPlatformUtil
    public float getPadSplitHeight() {
        AppMethodBeat.i(18489);
        float loigcalResolutionHeight = getLoigcalResolutionHeight();
        AppMethodBeat.o(18489);
        return loigcalResolutionHeight;
    }

    @Override // com.tencent.kinda.gen.IPlatformUtil
    public void playVibration() {
        AppMethodBeat.i(18490);
        try {
            Context context = KindaContext.get();
            if (context == null) {
                Log.e("KindaPlatformUtil", "KindaContext get null while playVibration!");
                AppMethodBeat.o(18490);
                return;
            }
            Vibrator vibrator = (Vibrator) context.getSystemService("vibrator");
            if (vibrator == null) {
                Log.e("KindaPlatformUtil", "playVibration call getSystemService get null!");
                AppMethodBeat.o(18490);
                return;
            }
            vibrator.vibrate(15);
            AppMethodBeat.o(18490);
        } catch (Exception e2) {
            Log.e("KindaPlatformUtil", "playVibration exception %s", e2.getMessage());
            AppMethodBeat.o(18490);
        }
    }

    @Override // com.tencent.kinda.gen.IPlatformUtil
    public float getScreenBrightness() {
        AppMethodBeat.i(18491);
        initWindowParamsIfNeed();
        if (this.mWindowParams != null) {
            float f2 = this.mWindowParams.screenBrightness;
            AppMethodBeat.o(18491);
            return f2;
        }
        AppMethodBeat.o(18491);
        return 0.0f;
    }

    @Override // com.tencent.kinda.gen.IPlatformUtil
    public void setScreenBrightness(float f2) {
        AppMethodBeat.i(18492);
        initWindowParamsIfNeed();
        if (this.mWindowParams != null) {
            this.mWindowParams.screenBrightness = f2;
            Activity topOrUIPageFragmentActivity = KindaContext.getTopOrUIPageFragmentActivity();
            if (topOrUIPageFragmentActivity != null) {
                topOrUIPageFragmentActivity.getWindow().setAttributes(this.mWindowParams);
                AppMethodBeat.o(18492);
                return;
            }
            Log.e("KindaPlatformUtil", "KindaContext.getTopOrUIPageFragmentActivity return null, so can't set ScreenBrightness!");
        }
        AppMethodBeat.o(18492);
    }

    @Override // com.tencent.kinda.gen.IPlatformUtil
    public void makesureLonglink() {
        AppMethodBeat.i(18493);
        f.hhU();
        AppMethodBeat.o(18493);
    }

    @Override // com.tencent.kinda.gen.IPlatformUtil
    public void setIdleTimerDisable(boolean z) {
    }

    @Override // com.tencent.kinda.gen.IPlatformUtil
    public String genUUID() {
        AppMethodBeat.i(18494);
        String aoG = q.aoG();
        AppMethodBeat.o(18494);
        return aoG;
    }

    @Override // com.tencent.kinda.gen.IPlatformUtil
    public byte[] base64Decode(String str) {
        AppMethodBeat.i(18495);
        byte[] decode = Base64.decode(str, 0);
        AppMethodBeat.o(18495);
        return decode;
    }

    @Override // com.tencent.kinda.gen.IPlatformUtil
    public String base64Encode(byte[] bArr) {
        AppMethodBeat.i(18496);
        String encodeToString = Base64.encodeToString(bArr, 0);
        AppMethodBeat.o(18496);
        return encodeToString;
    }

    @Override // com.tencent.kinda.gen.IPlatformUtil
    public boolean isNetworkConnected() {
        AppMethodBeat.i(18497);
        boolean isNetworkConnected = NetStatusUtil.isNetworkConnected(MMApplicationContext.getContext());
        AppMethodBeat.o(18497);
        return isNetworkConnected;
    }

    private void initWindowParamsIfNeed() {
        AppMethodBeat.i(18498);
        if (this.mWindowParams == null) {
            Activity topOrUIPageFragmentActivity = KindaContext.getTopOrUIPageFragmentActivity();
            if (topOrUIPageFragmentActivity != null) {
                this.mWindowParams = topOrUIPageFragmentActivity.getWindow().getAttributes();
                AppMethodBeat.o(18498);
                return;
            }
            Log.e("KindaPlatformUtil", "KindaContext.getTopOrUIPageFragmentActivity return null, so can't initWindowParamsIfNeed!");
        }
        AppMethodBeat.o(18498);
    }

    @Override // com.tencent.kinda.gen.IPlatformUtil
    public String getMemoryKVString(String str) {
        return "";
    }

    @Override // com.tencent.kinda.gen.IPlatformUtil
    public float getIphoneSafeAreaBottomHeight() {
        return 0.0f;
    }

    @Override // com.tencent.kinda.gen.IPlatformUtil
    public boolean shouldReportWifiSsid() {
        AppMethodBeat.i(18499);
        boolean fQz = k.fQz();
        AppMethodBeat.o(18499);
        return fQz;
    }

    @Override // com.tencent.kinda.gen.IPlatformUtil
    public boolean shouldReportCellInfo() {
        AppMethodBeat.i(18500);
        boolean shouldReportCellInfo = k.shouldReportCellInfo();
        AppMethodBeat.o(18500);
        return shouldReportCellInfo;
    }

    @Override // com.tencent.kinda.gen.IPlatformUtil
    public boolean shouldReportLocation() {
        AppMethodBeat.i(18501);
        boolean shouldReportLocation = k.shouldReportLocation();
        AppMethodBeat.o(18501);
        return shouldReportLocation;
    }

    @Override // com.tencent.kinda.gen.IPlatformUtil
    public void setReportLocationState(boolean z, boolean z2) {
        AppMethodBeat.i(18502);
        Log.i("KindaPlatformUtil", "setLocationState, set wifiSsidState as: [%b], set cellInfoState as [%b].", Boolean.valueOf(z), Boolean.valueOf(z2));
        al fRs = t.fQI().fRs();
        Log.i("MicroMsg.WalletSwitchConfig", "setReportLocation, set wifiSsidState as: [%b], set cellInfoState as [%b].", Boolean.valueOf(z), Boolean.valueOf(z2));
        if (z) {
            fRs.IbF |= TPMediaCodecProfileLevel.HEVCMainTierLevel52;
        } else {
            fRs.IbF &= -262145;
        }
        if (z2) {
            fRs.IbF |= TPMediaCodecProfileLevel.HEVCHighTierLevel61;
        } else {
            fRs.IbF &= -8388609;
        }
        Log.i("MicroMsg.WalletSwitchConfig", "setReportLocation, After set, switchBit is [%d]", Integer.valueOf(fRs.IbF));
        AppMethodBeat.o(18502);
    }

    @Override // com.tencent.kinda.gen.IPlatformUtil
    public String resolveURLStringForGlobal(String str) {
        AppMethodBeat.i(214424);
        String KO = cr.KO(str);
        AppMethodBeat.o(214424);
        return KO;
    }

    @Override // com.tencent.kinda.gen.IPlatformUtil
    public String resolveLanguageStringForGlobal(String str) {
        AppMethodBeat.i(214425);
        String KN = cr.KN(str);
        AppMethodBeat.o(214425);
        return KN;
    }

    @Override // com.tencent.kinda.gen.IPlatformUtil
    public void beginIgnoringInteractionEvents() {
    }

    @Override // com.tencent.kinda.gen.IPlatformUtil
    public void endIgnoringInteractionEvents() {
    }
}
