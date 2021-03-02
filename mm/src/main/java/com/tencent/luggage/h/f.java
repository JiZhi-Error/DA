package com.tencent.luggage.h;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public final class f {
    private static final WeakHashMap<Activity, f> cDp = new WeakHashMap<>();
    @SuppressLint({"StaticFieldLeak"})
    private static final f cDq = new f(null);
    private final SparseArray<b> cDk = new SparseArray<>();
    private final SparseArray<AbstractC0176f> cDl = new SparseArray<>();
    final Set<c> cDm = Collections.newSetFromMap(new ConcurrentHashMap());
    public a cDn;
    private Random cDo;
    private Activity mActivity;

    public interface a {
        boolean Pg();
    }

    public interface b extends d {
        void a(int i2, Intent intent);
    }

    public interface c extends d {
        boolean c(int i2, int i3, Intent intent);
    }

    interface d {
    }

    public interface e {
    }

    /* renamed from: com.tencent.luggage.h.f$f  reason: collision with other inner class name */
    public interface AbstractC0176f extends d {
        void q(int[] iArr);
    }

    private f(Activity activity) {
        AppMethodBeat.i(140506);
        this.mActivity = activity;
        this.cDo = new Random();
        AppMethodBeat.o(140506);
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(140507);
        for (c cVar : this.cDm) {
            if (cVar.c(i2, i3, intent)) {
                AppMethodBeat.o(140507);
                return;
            }
        }
        b bVar = this.cDk.get(i2);
        this.cDk.delete(i2);
        if (bVar != null) {
            bVar.a(i3, intent);
        }
        AppMethodBeat.o(140507);
    }

    public final void b(int i2, int[] iArr) {
        AppMethodBeat.i(140508);
        AbstractC0176f fVar = this.cDl.get(i2);
        this.cDl.delete(i2);
        if (fVar != null) {
            fVar.q(iArr);
        }
        AppMethodBeat.o(140508);
    }

    public final void a(Intent intent, b bVar) {
        AppMethodBeat.i(140509);
        if (this.mActivity == null) {
            AppMethodBeat.o(140509);
            return;
        }
        int b2 = b(this.cDk);
        this.cDk.put(b2, bVar);
        this.mActivity.startActivityForResult(intent, b2);
        AppMethodBeat.o(140509);
    }

    public final void b(Intent intent, b bVar) {
        AppMethodBeat.i(174617);
        a(intent, bVar);
        AppMethodBeat.o(174617);
    }

    public final void a(c cVar) {
        AppMethodBeat.i(174618);
        this.cDm.add(cVar);
        AppMethodBeat.o(174618);
    }

    public final void b(final c cVar) {
        AppMethodBeat.i(174619);
        a(new c() {
            /* class com.tencent.luggage.h.f.AnonymousClass1 */

            @Override // com.tencent.luggage.h.f.c
            public final boolean c(int i2, int i3, Intent intent) {
                AppMethodBeat.i(174616);
                f.this.cDm.remove(this);
                boolean c2 = cVar.c(i2, i3, intent);
                AppMethodBeat.o(174616);
                return c2;
            }
        });
        AppMethodBeat.o(174619);
    }

    public final boolean a(String str, AbstractC0176f fVar) {
        AppMethodBeat.i(140510);
        if (Build.VERSION.SDK_INT < 23 && !"MNC".equals(Build.VERSION.CODENAME)) {
            AppMethodBeat.o(140510);
            return true;
        } else if (this.mActivity == null) {
            AppMethodBeat.o(140510);
            return false;
        } else {
            try {
                if (android.support.v4.content.b.checkSelfPermission(this.mActivity, str) == 0) {
                    AppMethodBeat.o(140510);
                    return true;
                }
                a(new String[]{str}, fVar);
                AppMethodBeat.o(140510);
                return false;
            } catch (Exception e2) {
                Log.e("Luggage.LuggageActivityHelper", "check mpermission exception:%s.", e2);
                AppMethodBeat.o(140510);
                return true;
            }
        }
    }

    public final void finish() {
        AppMethodBeat.i(221206);
        if (this.mActivity != null && !this.mActivity.isFinishing() && !this.mActivity.isDestroyed()) {
            if (this.cDn != null) {
                this.cDn.Pg();
            }
            this.mActivity.finish();
        }
        AppMethodBeat.o(221206);
    }

    @TargetApi(23)
    public final void a(String[] strArr, AbstractC0176f fVar) {
        AppMethodBeat.i(140511);
        if (this.mActivity == null) {
            AppMethodBeat.o(140511);
        } else if (Build.VERSION.SDK_INT < 23) {
            int[] iArr = new int[strArr.length];
            Arrays.fill(iArr, 0);
            fVar.q(iArr);
            AppMethodBeat.o(140511);
        } else {
            int b2 = b(this.cDl);
            this.cDl.put(b2, fVar);
            Activity activity = this.mActivity;
            com.tencent.mm.hellhoundlib.b.a bl = com.tencent.mm.hellhoundlib.b.c.a(b2, new com.tencent.mm.hellhoundlib.b.a()).bl(strArr);
            com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/luggage/util/LuggageActivityHelper", "requestPermissions", "([Ljava/lang/String;Lcom/tencent/luggage/util/LuggageActivityHelper$PermissionResultCallback;)V", "Undefined", "requestPermissions", "([Ljava/lang/String;I)V");
            activity.requestPermissions((String[]) bl.pG(0), ((Integer) bl.pG(1)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/luggage/util/LuggageActivityHelper", "requestPermissions", "([Ljava/lang/String;Lcom/tencent/luggage/util/LuggageActivityHelper$PermissionResultCallback;)V", "Undefined", "requestPermissions", "([Ljava/lang/String;I)V");
            AppMethodBeat.o(140511);
        }
    }

    private int b(SparseArray sparseArray) {
        int rand;
        AppMethodBeat.i(140512);
        do {
            rand = rand();
        } while (sparseArray.get(rand) != null);
        AppMethodBeat.o(140512);
        return rand;
    }

    private int rand() {
        AppMethodBeat.i(140513);
        int nextInt = (this.cDo.nextInt(2147483646) + 1) & 65535;
        AppMethodBeat.o(140513);
        return nextInt;
    }

    static {
        AppMethodBeat.i(140516);
        AppMethodBeat.o(140516);
    }

    public static f aK(Context context) {
        AppMethodBeat.i(140514);
        Assert.assertFalse("must implements ILuggageActivityHelper", false);
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (activity.isFinishing() || activity.isDestroyed()) {
                Log.e("Luggage.LuggageActivityHelper", "FOR(%s) instance destroyed, return DUMMY", activity);
                f fVar = cDq;
                AppMethodBeat.o(140514);
                return fVar;
            }
            if (!cDp.containsKey(activity)) {
                cDp.put(activity, new f(activity));
            }
            f fVar2 = cDp.get(context);
            AppMethodBeat.o(140514);
            return fVar2;
        }
        Assert.assertFalse(false);
        f fVar3 = cDq;
        AppMethodBeat.o(140514);
        return fVar3;
    }

    public static void aL(Context context) {
        f remove;
        AppMethodBeat.i(140515);
        if ((context instanceof Activity) && (remove = cDp.remove(context)) != null) {
            remove.cDk.clear();
            remove.cDm.clear();
            remove.cDl.clear();
        }
        AppMethodBeat.o(140515);
    }
}
