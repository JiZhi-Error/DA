package com.tencent.kinda.framework.widget.tools;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.framework.app.UIPageFragmentActivity;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class KindaContext {
    private static final String TAG = "KindaContext";
    private static Application.ActivityLifecycleCallbacks sActivityLifeCycleCallbacks = new Application.ActivityLifecycleCallbacks() {
        /* class com.tencent.kinda.framework.widget.tools.KindaContext.AnonymousClass1 */

        public final void onActivityCreated(Activity activity, Bundle bundle) {
            AppMethodBeat.i(19378);
            Log.d(KindaContext.TAG, "onActivityCreated：".concat(String.valueOf(activity)));
            if (KindaContext.sContextStack != null) {
                String topActivityName2 = Util.getTopActivityName2(MMApplicationContext.getContext());
                String className = activity.getComponentName().getClassName();
                if (className.contains(".")) {
                    className = className.substring(className.lastIndexOf(".") + 1);
                }
                if (Util.isNullOrNil(topActivityName2) || !className.equals(topActivityName2)) {
                    ComponentName topActivityByAppTasks = Util.getTopActivityByAppTasks(MMApplicationContext.getContext());
                    String str = "";
                    if (topActivityByAppTasks != null) {
                        str = topActivityByAppTasks.getClassName();
                    }
                    Log.w(KindaContext.TAG, "created activity: %s not in the top, top is %s, fullClassName: %s", className, topActivityName2, str);
                    h.INSTANCE.n(1589, 2, 1);
                }
                KindaContext.sContextStack.push(new WeakReference(activity));
                Log.i(KindaContext.TAG, "sContextStack.push：".concat(String.valueOf(activity)));
            }
            AppMethodBeat.o(19378);
        }

        public final void onActivityStarted(Activity activity) {
        }

        public final void onActivityResumed(Activity activity) {
        }

        public final void onActivityPaused(Activity activity) {
            WeakReference weakReference;
            AppMethodBeat.i(19379);
            Log.d(KindaContext.TAG, "onActivityPaused：".concat(String.valueOf(activity)));
            if (activity.isFinishing()) {
                Iterator it = KindaContext.sContextStack.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        weakReference = null;
                        break;
                    }
                    weakReference = (WeakReference) it.next();
                    if (weakReference.get() == activity) {
                        break;
                    }
                }
                if (weakReference != null) {
                    KindaContext.sContextStack.remove(weakReference);
                    Log.i(KindaContext.TAG, "The context is finishing, so sContextStack.remove:[" + activity + "]");
                }
            }
            AppMethodBeat.o(19379);
        }

        public final void onActivityStopped(Activity activity) {
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public final void onActivityDestroyed(Activity activity) {
        }
    };
    private static Stack<WeakReference<Context>> sContextStack;

    static {
        AppMethodBeat.i(19388);
        AppMethodBeat.o(19388);
    }

    public static void initStack() {
        AppMethodBeat.i(19380);
        if (sContextStack == null) {
            sContextStack = new Stack<>();
            init();
            AppMethodBeat.o(19380);
            return;
        }
        sContextStack = new Stack<>();
        AppMethodBeat.o(19380);
    }

    public static Context get() {
        AppMethodBeat.i(19381);
        Context usableContext = getUsableContext();
        AppMethodBeat.o(19381);
        return usableContext;
    }

    public static Activity getTopOrUIPageFragmentActivity() {
        Activity activity;
        Activity activity2;
        AppMethodBeat.i(19382);
        if (sContextStack == null) {
            Log.e(TAG, "KindaContext is null then return case1");
            AppMethodBeat.o(19382);
            return null;
        }
        clearNullContextOfStack();
        if (sContextStack.size() == 0) {
            Log.e(TAG, "KindaContext is stack is null then return case2");
            AppMethodBeat.o(19382);
            return null;
        }
        Stack stack = new Stack();
        stack.addAll(sContextStack);
        Activity activity3 = null;
        Activity activity4 = null;
        while (true) {
            if (stack.empty()) {
                activity = null;
                activity2 = activity4;
                break;
            }
            WeakReference weakReference = (WeakReference) stack.pop();
            if (weakReference != null) {
                activity3 = (Context) weakReference.get();
            }
            if (activity3 instanceof Activity) {
                Activity activity5 = activity3;
                if (activity5.isFinishing()) {
                    continue;
                } else {
                    if (activity4 == null) {
                        activity4 = activity5;
                    }
                    if (activity5 instanceof UIPageFragmentActivity) {
                        activity = (UIPageFragmentActivity) activity5;
                        activity2 = activity4;
                        break;
                    }
                }
            }
        }
        if (activity == null) {
            activity = activity2;
        }
        Log.i(TAG, "getTopOrUIPageFragmentActivity finally return [" + activity + "]");
        AppMethodBeat.o(19382);
        return activity;
    }

    public static void popToContext(Context context) {
        boolean z;
        AppMethodBeat.i(19383);
        if (context == null) {
            AppMethodBeat.o(19383);
            return;
        }
        Log.d(TAG, "popToContext run");
        Iterator<WeakReference<Context>> it = sContextStack.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            WeakReference<Context> next = it.next();
            if (next.get() != null && context == next.get()) {
                z = true;
                break;
            }
        }
        if (z) {
            do {
                WeakReference<Context> peek = sContextStack.peek();
                if (peek == null || peek.get() != context) {
                    sContextStack.pop();
                    Log.i(TAG, "popToContext pop context：".concat(String.valueOf((peek == null || peek.get() == null) ? BuildConfig.COMMAND : peek.toString())));
                } else {
                    Log.i(TAG, "popToContext break");
                    AppMethodBeat.o(19383);
                    return;
                }
            } while (sContextStack.size() > 0);
        }
        AppMethodBeat.o(19383);
    }

    private static Context getUsableContext() {
        Context context = null;
        AppMethodBeat.i(19384);
        if (sContextStack == null) {
            Log.e(TAG, "The sContextStack is null then getUsableContext return null! case1");
            AppMethodBeat.o(19384);
        } else {
            clearNullContextOfStack();
            String printContextStack = printContextStack();
            if (sContextStack.size() == 0) {
                Log.e(TAG, "The sContextStack is empty, so that return null! case2");
                AppMethodBeat.o(19384);
            } else {
                WeakReference<Context> peek = sContextStack.peek();
                if (peek != null) {
                    context = peek.get();
                }
                if (context instanceof Activity) {
                    Activity activity = (Activity) context;
                    if (activity.isFinishing()) {
                        sContextStack.pop();
                        Log.i(TAG, "getUsableContext，sContextStack.pop:[" + activity + "]");
                        context = getUsableContext();
                    }
                }
                if (context == null) {
                    Log.e(TAG, "getUsableContext get null and the sContextStack before call：".concat(String.valueOf(printContextStack)));
                } else {
                    Log.i(TAG, "getUsableContext get value：".concat(String.valueOf(context)));
                }
                AppMethodBeat.o(19384);
            }
        }
        return context;
    }

    private static String printContextStack() {
        AppMethodBeat.i(19385);
        StringBuilder sb = new StringBuilder("\n\t");
        Iterator<WeakReference<Context>> it = sContextStack.iterator();
        while (it.hasNext()) {
            Context context = it.next().get();
            if (context != null) {
                sb.append(context.toString());
                sb.append("\n\t");
            } else {
                sb.append(BuildConfig.COMMAND);
                sb.append("\n\t");
            }
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(19385);
        return sb2;
    }

    private static void clearNullContextOfStack() {
        AppMethodBeat.i(19386);
        if (sContextStack == null || sContextStack.size() <= 0) {
            AppMethodBeat.o(19386);
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<WeakReference<Context>> it = sContextStack.iterator();
        while (it.hasNext()) {
            WeakReference<Context> next = it.next();
            if (next.get() == null) {
                arrayList.add(next);
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            WeakReference weakReference = (WeakReference) it2.next();
            sContextStack.remove(weakReference);
            Log.i(TAG, "clearNullContextOfStack sContextStack.remove:[" + weakReference.get() + "]");
        }
        AppMethodBeat.o(19386);
    }

    private static void init() {
        AppMethodBeat.i(19387);
        ((Application) MMApplicationContext.getContext()).registerActivityLifecycleCallbacks(sActivityLifeCycleCallbacks);
        Log.i(TAG, "KindaContext has finish init.");
        AppMethodBeat.o(19387);
    }
}
