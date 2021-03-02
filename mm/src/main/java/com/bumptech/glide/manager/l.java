package com.bumptech.glide.manager;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.g;
import android.util.Log;
import android.view.View;
import com.bumptech.glide.c;
import com.bumptech.glide.g.k;
import com.bumptech.glide.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class l implements Handler.Callback {
    private static final a aMF = new a() {
        /* class com.bumptech.glide.manager.l.AnonymousClass1 */

        @Override // com.bumptech.glide.manager.l.a
        public final j a(c cVar, h hVar, m mVar, Context context) {
            AppMethodBeat.i(77563);
            j jVar = new j(cVar, hVar, mVar, context);
            AppMethodBeat.o(77563);
            return jVar;
        }
    };
    final Map<g, SupportRequestManagerFragment> aMA = new HashMap();
    private final a aMB;
    private final android.support.v4.e.a<View, Fragment> aMC = new android.support.v4.e.a<>();
    private final android.support.v4.e.a<View, android.app.Fragment> aMD = new android.support.v4.e.a<>();
    private final Bundle aME = new Bundle();
    private volatile j aMy;
    final Map<FragmentManager, k> aMz = new HashMap();
    private final Handler handler;

    public interface a {
        j a(c cVar, h hVar, m mVar, Context context);
    }

    public l(a aVar) {
        AppMethodBeat.i(77564);
        this.aMB = aVar == null ? aMF : aVar;
        this.handler = new Handler(Looper.getMainLooper(), this);
        AppMethodBeat.o(77564);
    }

    private j ah(Context context) {
        AppMethodBeat.i(77565);
        if (this.aMy == null) {
            synchronized (this) {
                try {
                    if (this.aMy == null) {
                        this.aMy = this.aMB.a(c.af(context.getApplicationContext()), new b(), new g(), context.getApplicationContext());
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(77565);
                    throw th;
                }
            }
        }
        j jVar = this.aMy;
        AppMethodBeat.o(77565);
        return jVar;
    }

    public final j ai(Context context) {
        AppMethodBeat.i(77566);
        for (Context context2 = context; context2 != null; context2 = ((ContextWrapper) context2).getBaseContext()) {
            if (k.qw() && !(context2 instanceof Application)) {
                if (context2 instanceof FragmentActivity) {
                    j a2 = a((FragmentActivity) context2);
                    AppMethodBeat.o(77566);
                    return a2;
                } else if (context2 instanceof Activity) {
                    j j2 = j((Activity) context2);
                    AppMethodBeat.o(77566);
                    return j2;
                } else if (context2 instanceof ContextWrapper) {
                }
            }
            j ah = ah(context2);
            AppMethodBeat.o(77566);
            return ah;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("You cannot start a load on a null Context");
        AppMethodBeat.o(77566);
        throw illegalArgumentException;
    }

    private j a(FragmentActivity fragmentActivity) {
        AppMethodBeat.i(77567);
        if (k.qx()) {
            j ai = ai(fragmentActivity.getApplicationContext());
            AppMethodBeat.o(77567);
            return ai;
        }
        k(fragmentActivity);
        j a2 = a(fragmentActivity, fragmentActivity.getSupportFragmentManager(), l(fragmentActivity));
        AppMethodBeat.o(77567);
        return a2;
    }

    private j j(Activity activity) {
        AppMethodBeat.i(77568);
        if (k.qx()) {
            j ai = ai(activity.getApplicationContext());
            AppMethodBeat.o(77568);
            return ai;
        }
        k(activity);
        j a2 = a(activity, activity.getFragmentManager(), l(activity));
        AppMethodBeat.o(77568);
        return a2;
    }

    @TargetApi(17)
    private static void k(Activity activity) {
        AppMethodBeat.i(77569);
        if (Build.VERSION.SDK_INT < 17 || !activity.isDestroyed()) {
            AppMethodBeat.o(77569);
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("You cannot start a load for a destroyed activity");
        AppMethodBeat.o(77569);
        throw illegalArgumentException;
    }

    /* access modifiers changed from: package-private */
    public k a(FragmentManager fragmentManager, boolean z) {
        AppMethodBeat.i(77570);
        k kVar = (k) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (kVar == null && (kVar = this.aMz.get(fragmentManager)) == null) {
            kVar = new k();
            kVar.aMw = null;
            if (z) {
                kVar.aMs.onStart();
            }
            this.aMz.put(fragmentManager, kVar);
            fragmentManager.beginTransaction().add(kVar, "com.bumptech.glide.manager").commitAllowingStateLoss();
            this.handler.obtainMessage(1, fragmentManager).sendToTarget();
        }
        AppMethodBeat.o(77570);
        return kVar;
    }

    @Deprecated
    private j a(Context context, FragmentManager fragmentManager, boolean z) {
        AppMethodBeat.i(77571);
        k a2 = a(fragmentManager, z);
        j jVar = a2.aDc;
        if (jVar == null) {
            jVar = this.aMB.a(c.af(context), a2.aMs, a2.aMt, context);
            a2.aDc = jVar;
        }
        AppMethodBeat.o(77571);
        return jVar;
    }

    static boolean l(Activity activity) {
        AppMethodBeat.i(77572);
        if (!activity.isFinishing()) {
            AppMethodBeat.o(77572);
            return true;
        }
        AppMethodBeat.o(77572);
        return false;
    }

    /* access modifiers changed from: package-private */
    public SupportRequestManagerFragment a(g gVar, boolean z) {
        AppMethodBeat.i(77573);
        SupportRequestManagerFragment supportRequestManagerFragment = (SupportRequestManagerFragment) gVar.findFragmentByTag("com.bumptech.glide.manager");
        if (supportRequestManagerFragment == null && (supportRequestManagerFragment = this.aMA.get(gVar)) == null) {
            supportRequestManagerFragment = new SupportRequestManagerFragment();
            supportRequestManagerFragment.aMJ = null;
            if (z) {
                supportRequestManagerFragment.aMs.onStart();
            }
            this.aMA.put(gVar, supportRequestManagerFragment);
            gVar.beginTransaction().a(supportRequestManagerFragment, "com.bumptech.glide.manager").commitAllowingStateLoss();
            this.handler.obtainMessage(2, gVar).sendToTarget();
        }
        AppMethodBeat.o(77573);
        return supportRequestManagerFragment;
    }

    private j a(Context context, g gVar, boolean z) {
        AppMethodBeat.i(77574);
        SupportRequestManagerFragment a2 = a(gVar, z);
        j jVar = a2.aDc;
        if (jVar == null) {
            jVar = this.aMB.a(c.af(context), a2.aMs, a2.aMt, context);
            a2.aDc = jVar;
        }
        AppMethodBeat.o(77574);
        return jVar;
    }

    public final boolean handleMessage(Message message) {
        Object obj;
        k remove;
        AppMethodBeat.i(77575);
        boolean z = true;
        switch (message.what) {
            case 1:
                obj = (FragmentManager) message.obj;
                remove = this.aMz.remove(obj);
                break;
            case 2:
                obj = (g) message.obj;
                remove = this.aMA.remove(obj);
                break;
            default:
                z = false;
                obj = null;
                remove = null;
                break;
        }
        if (z && remove == null && Log.isLoggable("RMRetriever", 5)) {
            new StringBuilder("Failed to remove expected request manager fragment, manager: ").append(obj);
        }
        AppMethodBeat.o(77575);
        return z;
    }

    static {
        AppMethodBeat.i(77576);
        AppMethodBeat.o(77576);
    }
}
