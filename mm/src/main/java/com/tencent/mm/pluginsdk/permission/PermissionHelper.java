package com.tencent.mm.pluginsdk.permission;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.h;
import com.tencent.smtt.sdk.TbsListener;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class PermissionHelper {
    private static final byte[] JXL = new byte[0];
    private static final Map<Integer, d> JXM = new HashMap();
    private static volatile int JXN = 28673;
    private static final byte[] JXO = new byte[0];
    private static final Map<Integer, g> JXP = new HashMap();
    private static volatile int JXQ = 24577;
    private static final Handler mHandler = new Handler(Looper.getMainLooper());

    /* access modifiers changed from: package-private */
    public interface b {
        Context getContext();

        void requestPermissions(String[] strArr, int i2);

        boolean shouldShowRequestPermissionRationale(String str);

        void startActivityForResult(Intent intent, int i2);
    }

    public interface c {
        void a(f fVar);

        void a(String str, String str2, String str3, e eVar);
    }

    public interface e {
        void Sn(String str);

        void a(c cVar, String str);
    }

    public interface f {
        void blw();

        void blx();
    }

    static /* synthetic */ void b(c cVar, int i2, f fVar) {
        AppMethodBeat.i(223802);
        a(cVar, i2, fVar);
        AppMethodBeat.o(223802);
    }

    static /* synthetic */ void b(c cVar, int i2, String str, e eVar) {
        AppMethodBeat.i(223801);
        a(cVar, i2, str, eVar);
        AppMethodBeat.o(223801);
    }

    static {
        AppMethodBeat.i(223807);
        AppMethodBeat.o(223807);
    }

    /* access modifiers changed from: package-private */
    public static final class d {
        int JXW;
        e JXX;
        String permission;

        /* synthetic */ d(int i2, String str, e eVar, byte b2) {
            this(i2, str, eVar);
        }

        private d(int i2, String str, e eVar) {
            this.JXW = i2;
            this.permission = str;
            this.JXX = eVar;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class g {
        int JXW;
        f JXY;

        /* synthetic */ g(int i2, f fVar, byte b2) {
            this(i2, fVar);
        }

        private g(int i2, f fVar) {
            this.JXW = i2;
            this.JXY = fVar;
        }
    }

    public static boolean bdR(String str) {
        AppMethodBeat.i(223796);
        if (android.support.v4.app.a.checkSelfPermission(MMApplicationContext.getContext(), str) == 0) {
            AppMethodBeat.o(223796);
            return true;
        }
        AppMethodBeat.o(223796);
        return false;
    }

    @SuppressLint({"NewApi"})
    public static c aX(final Activity activity) {
        AppMethodBeat.i(223797);
        Log.i("MicroMsg.PermissionHelper", "[+] withActivity called, is_on_mainthread: %s", Boolean.valueOf(gnm()));
        final c[] cVarArr = {null};
        AnonymousClass1 r0 = new Runnable() {
            /* class com.tencent.mm.pluginsdk.permission.PermissionHelper.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(223778);
                if (activity instanceof FragmentActivity) {
                    android.support.v4.app.g supportFragmentManager = ((FragmentActivity) activity).getSupportFragmentManager();
                    AuxSupportFragment auxSupportFragment = (AuxSupportFragment) supportFragmentManager.findFragmentByTag("wx_permission_helper_aux_fragment");
                    if (auxSupportFragment == null) {
                        auxSupportFragment = new AuxSupportFragment();
                        try {
                            supportFragmentManager.beginTransaction().a(auxSupportFragment, "wx_permission_helper_aux_fragment").commit();
                            supportFragmentManager.executePendingTransactions();
                        } catch (Throwable th) {
                            Log.printErrStackTrace("MicroMsg.PermissionHelper", th, "[-] Fail to add aux fragment.", new Object[0]);
                        }
                    }
                    cVarArr[0] = auxSupportFragment;
                } else {
                    FragmentManager fragmentManager = activity.getFragmentManager();
                    a aVar = (a) fragmentManager.findFragmentByTag("wx_permission_helper_aux_fragment");
                    if (aVar == null) {
                        aVar = new a();
                        aVar.mContextRef = new WeakReference<>(activity);
                        try {
                            fragmentManager.beginTransaction().add(aVar, "wx_permission_helper_aux_fragment").commit();
                            fragmentManager.executePendingTransactions();
                        } catch (Throwable th2) {
                            Log.printErrStackTrace("MicroMsg.PermissionHelper", th2, "[-] Fail to add aux fragment.", new Object[0]);
                        }
                    }
                    cVarArr[0] = aVar;
                }
                synchronized (cVarArr) {
                    try {
                        cVarArr.notifyAll();
                    } catch (Throwable th3) {
                    }
                    try {
                    } catch (Throwable th4) {
                        AppMethodBeat.o(223778);
                        throw th4;
                    }
                }
                AppMethodBeat.o(223778);
            }
        };
        if (gnm()) {
            r0.run();
            c cVar = cVarArr[0];
            AppMethodBeat.o(223797);
            return cVar;
        }
        mHandler.postAtFrontOfQueue(r0);
        synchronized (cVarArr) {
            while (cVarArr[0] == null) {
                try {
                    try {
                        cVarArr.wait();
                    } catch (Throwable th) {
                    }
                } catch (Throwable th2) {
                    AppMethodBeat.o(223797);
                    throw th2;
                }
            }
        }
        c cVar2 = cVarArr[0];
        AppMethodBeat.o(223797);
        return cVar2;
    }

    private static int gnk() {
        int i2;
        synchronized (JXL) {
            if (JXN == 32768) {
                JXN = 28673;
            }
            i2 = JXN;
            JXN = i2 + 1;
        }
        return i2;
    }

    private static int gnl() {
        int i2;
        synchronized (JXO) {
            if (JXQ == 28672) {
                JXQ = 24577;
            }
            i2 = JXQ;
            JXQ = i2 + 1;
        }
        return i2;
    }

    private static boolean gnm() {
        AppMethodBeat.i(223798);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            AppMethodBeat.o(223798);
            return true;
        }
        AppMethodBeat.o(223798);
        return false;
    }

    private static void a(c cVar, int i2, String str, e eVar) {
        AppMethodBeat.i(223799);
        Context context = ((b) cVar).getContext();
        if (context == null) {
            Log.e("MicroMsg.PermissionHelper", "[-] context is null, skip rest steps.");
            AppMethodBeat.o(223799);
        } else if (android.support.v4.app.a.checkSelfPermission(context, str) == 0) {
            eVar.Sn(str);
            AppMethodBeat.o(223799);
        } else {
            synchronized (JXL) {
                try {
                    int gnk = gnk();
                    JXM.put(Integer.valueOf(gnk), new d(i2, str, eVar, (byte) 0));
                    ((b) cVar).requestPermissions(new String[]{str}, gnk);
                } finally {
                    AppMethodBeat.o(223799);
                }
            }
        }
    }

    private static void a(c cVar, int i2, f fVar) {
        AppMethodBeat.i(223800);
        try {
            Context context = ((b) cVar).getContext();
            if (context == null) {
                Log.e("MicroMsg.PermissionHelper", "[-] context is null, skip rest steps.");
                AppMethodBeat.o(223800);
                return;
            }
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + context.getPackageName()));
            synchronized (JXO) {
                try {
                    int gnl = gnl();
                    JXP.put(Integer.valueOf(gnl), new g(i2, fVar, (byte) 0));
                    ((b) cVar).startActivityForResult(intent, gnl);
                } finally {
                    AppMethodBeat.o(223800);
                }
            }
        } catch (Throwable th) {
            fVar.blx();
            AppMethodBeat.o(223800);
        }
    }

    public static final class a extends Fragment implements b, c {
        public WeakReference<Context> mContextRef;

        public final void onCreate(Bundle bundle) {
            AppMethodBeat.i(223782);
            super.onCreate(bundle);
            setRetainInstance(true);
            AppMethodBeat.o(223782);
        }

        public final void a(int i2, String str, e eVar) {
            AppMethodBeat.i(223783);
            if (!isDetached()) {
                PermissionHelper.c(this, i2, str, eVar);
            }
            AppMethodBeat.o(223783);
        }

        @Override // com.tencent.mm.pluginsdk.permission.PermissionHelper.b
        public final Context getContext() {
            AppMethodBeat.i(223784);
            Context context = null;
            if (Build.VERSION.SDK_INT >= 23) {
                context = super.getContext();
            } else if (this.mContextRef != null) {
                context = this.mContextRef.get();
            }
            AppMethodBeat.o(223784);
            return context;
        }

        @Override // com.tencent.mm.pluginsdk.permission.PermissionHelper.c
        public final void a(String str, String str2, final String str3, final e eVar) {
            Context context;
            AppMethodBeat.i(223785);
            if (!isDetached() && (context = getContext()) != null) {
                if (PermissionHelper.bdR(str3)) {
                    a(TbsListener.ErrorCode.TPATCH_BACKUP_NOT_VALID, str3, eVar);
                    AppMethodBeat.o(223785);
                    return;
                }
                h.a(context, str2, str, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.pluginsdk.permission.PermissionHelper.a.AnonymousClass1 */
                    final /* synthetic */ int val$requestCode = TbsListener.ErrorCode.TPATCH_BACKUP_NOT_VALID;

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(223781);
                        a.this.a(this.val$requestCode, str3, eVar);
                        AppMethodBeat.o(223781);
                    }
                });
            }
            AppMethodBeat.o(223785);
        }

        public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
            AppMethodBeat.i(223786);
            super.onRequestPermissionsResult(i2, strArr, iArr);
            if (!isDetached()) {
                PermissionHelper.a(this, i2, strArr, iArr);
            }
            AppMethodBeat.o(223786);
        }

        @Override // com.tencent.mm.pluginsdk.permission.PermissionHelper.c
        public final void a(f fVar) {
            AppMethodBeat.i(223787);
            if (!isDetached()) {
                PermissionHelper.a(this, fVar);
            }
            AppMethodBeat.o(223787);
        }

        public final void onActivityResult(int i2, int i3, Intent intent) {
            AppMethodBeat.i(223788);
            super.onActivityResult(i2, i3, intent);
            if (!isDetached()) {
                PermissionHelper.ahN(i2);
            }
            AppMethodBeat.o(223788);
        }
    }

    public static final class AuxSupportFragment extends android.support.v4.app.Fragment implements b, c {
        @Override // android.support.v4.app.Fragment
        public final void onCreate(Bundle bundle) {
            AppMethodBeat.i(223790);
            super.onCreate(bundle);
            setRetainInstance(true);
            AppMethodBeat.o(223790);
        }

        public final void a(int i2, String str, e eVar) {
            AppMethodBeat.i(223791);
            if (!isDetached()) {
                PermissionHelper.c(this, i2, str, eVar);
            }
            AppMethodBeat.o(223791);
        }

        @Override // com.tencent.mm.pluginsdk.permission.PermissionHelper.c
        public final void a(String str, String str2, final String str3, final e eVar) {
            Context context;
            AppMethodBeat.i(223792);
            if (!isDetached() && (context = getContext()) != null) {
                if (PermissionHelper.bdR(str3)) {
                    a(TbsListener.ErrorCode.TPATCH_BACKUP_NOT_VALID, str3, eVar);
                    AppMethodBeat.o(223792);
                    return;
                }
                h.a(context, str2, str, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.pluginsdk.permission.PermissionHelper.AuxSupportFragment.AnonymousClass1 */
                    final /* synthetic */ int val$requestCode = TbsListener.ErrorCode.TPATCH_BACKUP_NOT_VALID;

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(223789);
                        AuxSupportFragment.this.a(this.val$requestCode, str3, eVar);
                        AppMethodBeat.o(223789);
                    }
                });
            }
            AppMethodBeat.o(223792);
        }

        @Override // android.support.v4.app.Fragment
        public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
            AppMethodBeat.i(223793);
            super.onRequestPermissionsResult(i2, strArr, iArr);
            if (!isDetached()) {
                PermissionHelper.a(this, i2, strArr, iArr);
            }
            AppMethodBeat.o(223793);
        }

        @Override // com.tencent.mm.pluginsdk.permission.PermissionHelper.c
        public final void a(f fVar) {
            AppMethodBeat.i(223794);
            if (!isDetached()) {
                PermissionHelper.a(this, fVar);
            }
            AppMethodBeat.o(223794);
        }

        @Override // android.support.v4.app.Fragment
        public final void onActivityResult(int i2, int i3, Intent intent) {
            AppMethodBeat.i(223795);
            super.onActivityResult(i2, i3, intent);
            if (!isDetached()) {
                PermissionHelper.ahN(i2);
            }
            AppMethodBeat.o(223795);
        }
    }

    static /* synthetic */ void c(final c cVar, final int i2, final String str, final e eVar) {
        AppMethodBeat.i(223803);
        if (gnm()) {
            a(cVar, i2, str, eVar);
            AppMethodBeat.o(223803);
            return;
        }
        mHandler.post(new Runnable() {
            /* class com.tencent.mm.pluginsdk.permission.PermissionHelper.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(223779);
                PermissionHelper.b(cVar, i2, str, eVar);
                AppMethodBeat.o(223779);
            }
        });
        AppMethodBeat.o(223803);
    }

    static /* synthetic */ void a(c cVar, int i2, String[] strArr, int[] iArr) {
        d remove;
        AppMethodBeat.i(223804);
        if (strArr.length == 0 || iArr.length == 0) {
            AppMethodBeat.o(223804);
            return;
        }
        synchronized (JXL) {
            try {
                remove = JXM.remove(Integer.valueOf(i2));
            } finally {
                AppMethodBeat.o(223804);
            }
        }
        if (!(remove == null || remove.JXX == null)) {
            String str = remove.permission;
            e eVar = remove.JXX;
            if (iArr[0] == 0) {
                eVar.Sn(str);
                AppMethodBeat.o(223804);
                return;
            }
            ((b) cVar).shouldShowRequestPermissionRationale(str);
            eVar.a(cVar, str);
        }
    }

    static /* synthetic */ void a(c cVar, f fVar) {
        AppMethodBeat.i(223805);
        if (gnm()) {
            a(cVar, TbsListener.ErrorCode.TPATCH_BACKUP_NOT_VALID, fVar);
            AppMethodBeat.o(223805);
            return;
        }
        mHandler.post(new Runnable(cVar, TbsListener.ErrorCode.TPATCH_BACKUP_NOT_VALID, fVar) {
            /* class com.tencent.mm.pluginsdk.permission.PermissionHelper.AnonymousClass3 */
            final /* synthetic */ f JXT;
            final /* synthetic */ c jMZ;
            final /* synthetic */ int val$requestCode = TbsListener.ErrorCode.TPATCH_BACKUP_NOT_VALID;

            {
                this.jMZ = r2;
                this.JXT = r4;
            }

            public final void run() {
                AppMethodBeat.i(223780);
                PermissionHelper.b(this.jMZ, this.val$requestCode, this.JXT);
                AppMethodBeat.o(223780);
            }
        });
        AppMethodBeat.o(223805);
    }

    static /* synthetic */ void ahN(int i2) {
        AppMethodBeat.i(223806);
        synchronized (JXO) {
            try {
                g remove = JXP.remove(Integer.valueOf(i2));
                if (!(remove == null || remove.JXY == null)) {
                    remove.JXY.blw();
                }
            } finally {
                AppMethodBeat.o(223806);
            }
        }
    }
}
