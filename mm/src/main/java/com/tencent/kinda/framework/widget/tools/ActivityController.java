package com.tencent.kinda.framework.widget.tools;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.kinda.framework.app.MainFragment;
import com.tencent.kinda.framework.app.ModalFragment;
import com.tencent.kinda.framework.widget.base.BaseFragment;
import com.tencent.kinda.framework.widget.base.IEventFragment;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.kinda.gen.IUIModal;
import com.tencent.kinda.gen.IUIPage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.framework.app.UIPageFragmentActivity;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMFragmentActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ActivityController {
    public static final String TAG = "MicroMsg.ActivityController";
    private static boolean activityCreating = false;
    private static WeakReference<Activity> currentActivity;
    private static HashMap<Integer, BaseFragment> fragmentPond = new HashMap<>();
    private static List<Integer> pendingList = new ArrayList();
    private byte _hellAccFlag_;

    static {
        AppMethodBeat.i(19311);
        AppMethodBeat.o(19311);
    }

    public static void attach(Activity activity) {
        AppMethodBeat.i(19305);
        Log.i(TAG, "attach %s", activity);
        synchronized (ActivityController.class) {
            try {
                currentActivity = new WeakReference<>(activity);
                if (pendingList.size() > 0) {
                    IEventFragment iEventFragment = (IEventFragment) activity;
                    if (!activity.isFinishing()) {
                        for (Integer num : pendingList) {
                            BaseFragment baseFragment = fragmentPond.get(num);
                            if (baseFragment != null) {
                                iEventFragment.addFragment(baseFragment);
                            }
                        }
                        pendingList.clear();
                    } else {
                        return;
                    }
                }
                activityCreating = false;
                Log.i(TAG, "activityCreating has set false.");
                AppMethodBeat.o(19305);
            } finally {
                AppMethodBeat.o(19305);
            }
        }
    }

    public static void detach(Activity activity) {
        AppMethodBeat.i(214570);
        Log.i(TAG, "detach %s", activity);
        synchronized (ActivityController.class) {
            try {
                if (currentActivity != null && activity == currentActivity.get()) {
                    currentActivity = null;
                }
                pendingList.clear();
                activityCreating = false;
            } finally {
                AppMethodBeat.o(214570);
            }
        }
    }

    public static BaseFragment resolveFragment(Bundle bundle) {
        AppMethodBeat.i(19306);
        int i2 = bundle.getInt("intent_target", 0);
        if (fragmentPond.containsKey(Integer.valueOf(i2))) {
            BaseFragment remove = fragmentPond.remove(Integer.valueOf(i2));
            AppMethodBeat.o(19306);
            return remove;
        }
        AppMethodBeat.o(19306);
        return null;
    }

    public static void startNewUIPage(IUIPage iUIPage, ITransmitKvData iTransmitKvData) {
        Activity activity;
        Intent intent;
        AppMethodBeat.i(19307);
        if (currentActivity != null) {
            Activity activity2 = currentActivity.get();
            if (activity2 instanceof UIPageFragmentActivity) {
                ((UIPageFragmentActivity) activity2).hgt = false;
            }
        }
        String string = iTransmitKvData.getString("KindaWebViewURL");
        String string2 = iTransmitKvData.getString("KindaTinyAppUserName");
        String string3 = iTransmitKvData.getString("KindaTinyAppPath");
        String string4 = iTransmitKvData.getString("KindaTinyAppVersion");
        int i2 = Util.getInt(iTransmitKvData.getString("KindaTinyAppScene"), 0);
        int i3 = Util.getInt(iTransmitKvData.getString("KindaTinyAppType"), 0);
        MainFragment mainFragment = new MainFragment();
        mainFragment.attachPage(iUIPage);
        fragmentPond.put(Integer.valueOf(iUIPage.hashCode()), mainFragment);
        if (isTopKindaActivity()) {
            activity = currentActivity.get();
            intent = new Intent(activity, UIPageFragmentActivity.class);
            intent.addFlags(67108864);
        } else {
            activity = KindaContext.get();
            if (activity == null) {
                AppMethodBeat.o(19307);
                return;
            }
            intent = new Intent(activity, UIPageFragmentActivity.class);
        }
        Bundle bundle = new Bundle();
        bundle.putInt("intent_target", iUIPage.hashCode());
        if (string.length() > 0) {
            bundle.putBoolean(ConstantsKinda.INTENT_WEBVIEW, true);
            bundle.putString(ConstantsKinda.INTENT_WEBVIEW_URL, string);
        } else if (string2.length() > 0) {
            bundle.putBoolean(ConstantsKinda.INTENT_TINYAPP, true);
            bundle.putString(ConstantsKinda.INTENT_TINYAPP_USERNAME, string2);
            bundle.putString(ConstantsKinda.INTENT_TINYAPP_PATH, string3);
            bundle.putString(ConstantsKinda.INTENT_TINYAPP_VERSION, string4);
            bundle.putInt(ConstantsKinda.INTENT_TINYAPP_TYPE, i3);
            bundle.putInt(ConstantsKinda.INTENT_TINYAPP_SCENE, i2);
        }
        intent.putExtra("intent_bundle", bundle);
        intent.putExtra(ConstantsKinda.CHEEK_WALLET_LOCK, iTransmitKvData.getBool(ConstantsKinda.CHEEK_WALLET_LOCK));
        if (isTopKindaActivity()) {
            ((UIPageFragmentActivity) currentActivity.get()).t(intent.getBundleExtra("intent_bundle"));
            Log.i(TAG, "startNewUIPage by onNewIntentForKinda.");
            AppMethodBeat.o(19307);
            return;
        }
        a bl = new a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/kinda/framework/widget/tools/ActivityController", "startNewUIPage", "(Lcom/tencent/kinda/gen/IUIPage;Lcom/tencent/kinda/gen/ITransmitKvData;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        activity.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/kinda/framework/widget/tools/ActivityController", "startNewUIPage", "(Lcom/tencent/kinda/gen/IUIPage;Lcom/tencent/kinda/gen/ITransmitKvData;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        Log.i(TAG, "startNewUIPage by a new activity.");
        AppMethodBeat.o(19307);
    }

    public static void startNewUIModal(IUIModal iUIModal) {
        ModalFragment modalFragment;
        Intent intent;
        AppMethodBeat.i(19308);
        synchronized (ActivityController.class) {
            try {
                if (currentActivity != null) {
                    Activity activity = currentActivity.get();
                    if ((activity instanceof UIPageFragmentActivity) && fragmentPond.size() == 0) {
                        ((UIPageFragmentActivity) activity).hgt = true;
                    }
                }
                int hashCode = iUIModal.hashCode();
                if (!fragmentPond.containsKey(Integer.valueOf(hashCode))) {
                    modalFragment = new ModalFragment();
                    modalFragment.attachModal(iUIModal);
                    fragmentPond.put(Integer.valueOf(hashCode), modalFragment);
                } else {
                    modalFragment = fragmentPond.get(Integer.valueOf(hashCode));
                }
                if (isTopKindaActivity()) {
                    ((IEventFragment) currentActivity.get()).addFragment(modalFragment);
                    Log.i(TAG, "startNewUIModal by an existing activity.");
                } else {
                    pendingList.add(Integer.valueOf(hashCode));
                    if (activityCreating) {
                        Log.w(TAG, "startNewUIModal failed, because activityCreating is true!");
                        AppMethodBeat.o(19308);
                        return;
                    }
                    Context context = KindaContext.get();
                    if (context == null) {
                        Log.w(TAG, "startNewUIModal failed, because KindaContext get null!");
                        AppMethodBeat.o(19308);
                        return;
                    }
                    activityCreating = true;
                    Log.i(TAG, "activityCreating has set true.");
                    Intent intent2 = new Intent(context, UIPageFragmentActivity.class);
                    if ((context instanceof Activity) && (intent = ((Activity) context).getIntent()) != null) {
                        intent.putExtra(MMFragmentActivity.EXTRA_USE_SYSTEM_DEFAULT_ENTER_EXIT_ANIM, true);
                    }
                    intent2.putExtra("key_support_swipe_back", false);
                    a bl = new a().bl(intent2);
                    com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/kinda/framework/widget/tools/ActivityController", "startNewUIModal", "(Lcom/tencent/kinda/gen/IUIModal;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    context.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/kinda/framework/widget/tools/ActivityController", "startNewUIModal", "(Lcom/tencent/kinda/gen/IUIModal;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    Log.i(TAG, "startNewUIModal by a new activity.");
                }
            } finally {
                AppMethodBeat.o(19308);
            }
        }
    }

    private static boolean isTopKindaActivity() {
        AppMethodBeat.i(178778);
        if (currentActivity == null || !(currentActivity.get() instanceof UIPageFragmentActivity) || !currentActivity.get().equals(KindaContext.get())) {
            AppMethodBeat.o(178778);
            return false;
        }
        AppMethodBeat.o(178778);
        return true;
    }

    public static void remove(IUIModal iUIModal) {
        AppMethodBeat.i(19309);
        synchronized (ActivityController.class) {
            try {
                if (currentActivity == null) {
                    Log.e(TAG, "currentActivity is null, needn't remove any modal.");
                    return;
                }
                Activity activity = currentActivity.get();
                BaseFragment remove = fragmentPond.remove(Integer.valueOf(iUIModal.hashCode()));
                if (!(activity instanceof IEventFragment) || remove == null) {
                    if (remove == null) {
                        h.INSTANCE.dN(965, 53);
                    }
                    Log.e(TAG, "activity or fragment error! activity: " + activity + ", fragment: " + remove);
                } else {
                    ((IEventFragment) activity).removeModal(remove);
                }
                AppMethodBeat.o(19309);
            } finally {
                AppMethodBeat.o(19309);
            }
        }
    }

    public static void removeAll() {
        AppMethodBeat.i(185698);
        Log.i(TAG, "removeAllFragments");
        if (currentActivity == null || currentActivity.get() == null) {
            Log.e(TAG, "currentActivity is null, needn't remove any modal.");
            AppMethodBeat.o(185698);
            return;
        }
        Activity activity = currentActivity.get();
        if (activity != null && !activity.isFinishing()) {
            Log.w(TAG, "remove all modal");
            if (fragmentPond.size() > 0) {
                fragmentPond.clear();
                h.INSTANCE.dN(965, 52);
            }
            activity.finish();
        }
        AppMethodBeat.o(185698);
    }

    public static void resetFlag() {
        AppMethodBeat.i(19310);
        activityCreating = false;
        Log.i(TAG, "activityCreating has set false.");
        AppMethodBeat.o(19310);
    }
}
