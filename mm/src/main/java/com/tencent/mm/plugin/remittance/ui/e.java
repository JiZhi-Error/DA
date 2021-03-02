package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.lang.ref.WeakReference;

public final class e {
    WeakReference<Context> cMO;

    /* access modifiers changed from: package-private */
    public static class a {
        static e CrX = new e();

        static {
            AppMethodBeat.i(67985);
            AppMethodBeat.o(67985);
        }
    }

    public static synchronized e eNU() {
        e eVar;
        synchronized (e.class) {
            eVar = a.CrX;
        }
        return eVar;
    }

    public final void gS(Context context) {
        AppMethodBeat.i(67986);
        Log.i("MicroMsg.RemittanceBusiDialogMgr", "attach() %s", context.getClass().getSimpleName());
        this.cMO = new WeakReference<>(context);
        AppMethodBeat.o(67986);
    }

    public final Context getContext() {
        AppMethodBeat.i(163812);
        Context context = this.cMO.get();
        if (context == null) {
            Log.i("MicroMsg.RemittanceBusiDialogMgr", "getContext() == null");
            AppMethodBeat.o(163812);
            return null;
        }
        AppMethodBeat.o(163812);
        return context;
    }

    public final boolean eNV() {
        AppMethodBeat.i(163813);
        Log.i("MicroMsg.RemittanceBusiDialogMgr", "finishRemitF2fDCodeAndLMRemindUI()");
        Context context = this.cMO.get();
        if (context == null) {
            Log.i("MicroMsg.RemittanceBusiDialogMgr", "getContext() == null");
            AppMethodBeat.o(163813);
            return false;
        } else if (context instanceof RemittanceF2fDynamicCodeUI) {
            Log.w("MicroMsg.RemittanceBusiDialogMgr", "check() is RemittanceF2fDynamicCodeUI");
            ((Activity) context).finish();
            AppMethodBeat.o(163813);
            return true;
        } else if (context instanceof RemittanceF2fLargeMoneyUI) {
            Log.w("MicroMsg.RemittanceBusiDialogMgr", "check() is RemittanceF2fLargeMoneyUI");
            ((Activity) context).finish();
            AppMethodBeat.o(163813);
            return true;
        } else {
            AppMethodBeat.o(163813);
            return false;
        }
    }

    public final boolean eNW() {
        AppMethodBeat.i(163814);
        Log.i("MicroMsg.RemittanceBusiDialogMgr", "finishRemitLMRemindUI()");
        Context context = this.cMO.get();
        if (context == null) {
            Log.i("MicroMsg.RemittanceBusiDialogMgr", "getContext() == null");
            AppMethodBeat.o(163814);
            return false;
        } else if (context instanceof RemittanceF2fLargeMoneyUI) {
            Log.w("MicroMsg.RemittanceBusiDialogMgr", "check() is RemittanceF2fLargeMoneyUI");
            ((Activity) context).finish();
            AppMethodBeat.o(163814);
            return true;
        } else {
            AppMethodBeat.o(163814);
            return false;
        }
    }

    public final d a(String str, String str2, String str3, String str4, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        AppMethodBeat.i(67988);
        Log.w("MicroMsg.RemittanceBusiDialogMgr", "showAlert1() msg:%s, title:%s, yes:%s, no:%s", Util.nullAsNil(str), Util.nullAsNil(str2), Util.nullAsNil(str3), Util.nullAsNil(str4));
        Context context = this.cMO.get();
        if (context == null) {
            Log.i("MicroMsg.RemittanceBusiDialogMgr", "getContext() == null");
            AppMethodBeat.o(67988);
            return null;
        }
        d c2 = h.c(context, str, str2, str3, str4, onClickListener, onClickListener2);
        AppMethodBeat.o(67988);
        return c2;
    }

    public final d a(String str, DialogInterface.OnClickListener onClickListener) {
        AppMethodBeat.i(67989);
        Log.w("MicroMsg.RemittanceBusiDialogMgr", "showAlert2() msg:%s, title:%s", Util.nullAsNil(str), Util.nullAsNil((String) null));
        Context context = this.cMO.get();
        if (context == null) {
            Log.i("MicroMsg.RemittanceBusiDialogMgr", "getContext() == null");
            AppMethodBeat.o(67989);
            return null;
        }
        d a2 = h.a(context, str, (String) null, false, onClickListener);
        AppMethodBeat.o(67989);
        return a2;
    }

    public final boolean eNX() {
        AppMethodBeat.i(163815);
        Log.w("MicroMsg.RemittanceBusiDialogMgr", "showSafeProgress()");
        Context context = this.cMO.get();
        if (context == null) {
            Log.i("MicroMsg.RemittanceBusiDialogMgr", "getContext() == null");
            AppMethodBeat.o(163815);
            return false;
        } else if (context instanceof RemittanceBusiUI) {
            AppMethodBeat.o(163815);
            return false;
        } else if (context instanceof WalletBaseUI) {
            ((WalletBaseUI) context).showSafeProgress();
            AppMethodBeat.o(163815);
            return true;
        } else {
            AppMethodBeat.o(163815);
            return false;
        }
    }
}
