package com.tencent.mm.wallet_core;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.br.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.t;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.lang.ref.WeakReference;

public abstract class d {
    protected WeakReference<a> MF;
    public WeakReference<Context> RrY = new WeakReference<>(null);
    public Bundle dQL = new Bundle();

    public interface a {
        Intent q(int i2, Bundle bundle);
    }

    public abstract void a(Activity activity, int i2, Bundle bundle);

    public abstract void b(Activity activity, Bundle bundle);

    public abstract boolean c(Activity activity, Bundle bundle);

    public abstract String dKC();

    public abstract void g(Activity activity, int i2);

    public final d bA(Bundle bundle) {
        this.dQL.putAll(bundle);
        return this;
    }

    private static String eu(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof Bundle) {
            return String.format("Bundle: %s, ", obj.toString());
        } else if (obj instanceof Context) {
            return String.format("Context: %s, ", obj.toString());
        } else if (obj instanceof Class) {
            return String.format("Class: %s, ", ((Class) obj).getSimpleName());
        } else {
            return String.format("Value: %s, ", obj.toString());
        }
    }

    private String u(Object... objArr) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("this %s, procname %s", this, dKC()));
        if (objArr == null || objArr.length <= 0) {
            Log.w("MicroMsg.ProcessManager", "vals is null, use '' as value");
            return sb.toString();
        }
        int length = objArr.length - 1;
        for (int i2 = 0; i2 < length; i2++) {
            sb.append(eu(objArr[i2])).append(',');
        }
        sb.append(eu(objArr[length]));
        return sb.toString();
    }

    public final void K(Object... objArr) {
        Log.i("MicroMsg.ProcessManager", "__CURRENT__ %s", u(objArr));
    }

    public final void a(Activity activity, Class<?> cls, Bundle bundle, Bundle bundle2) {
        K("startActivity1", activity, cls, bundle);
        Intent intent = new Intent(activity, cls);
        intent.putExtra("process_id", getClass().hashCode());
        if (bundle2 != null) {
            intent.putExtras(bundle2);
            Log.d("MicroMsg.ProcessManager", "put bundle: %s", intent.getExtras().toString());
        }
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/wallet_core/WalletProcess", "startActivity", "(Landroid/app/Activity;Ljava/lang/Class;Landroid/os/Bundle;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        activity.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/wallet_core/WalletProcess", "startActivity", "(Landroid/app/Activity;Ljava/lang/Class;Landroid/os/Bundle;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        if (bundle != null) {
            this.dQL.putAll(bundle);
        }
        Log.d("MicroMsg.ProcessManager", "bankcard tag :" + hgI());
    }

    public final void b(Activity activity, Class<?> cls, Bundle bundle) {
        K("startActivity1", activity, cls, bundle);
        Intent intent = new Intent(activity, cls);
        intent.putExtra("process_id", getClass().hashCode());
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/wallet_core/WalletProcess", "startActivity", "(Landroid/app/Activity;Ljava/lang/Class;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        activity.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/wallet_core/WalletProcess", "startActivity", "(Landroid/app/Activity;Ljava/lang/Class;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        if (bundle != null) {
            this.dQL.putAll(bundle);
        }
        Log.d("MicroMsg.ProcessManager", "bankcard tag :" + hgI());
    }

    public final void a(Activity activity, String str, String str2, Bundle bundle) {
        K("startActivity3", activity, str, str2, bundle);
        Class<?> mI = c.mI(str, str2);
        if (mI != null) {
            b(activity, mI, bundle);
        } else {
            Log.e("MicroMsg.ProcessManager", " Class Not Found! can't startActivity to " + str + str2);
        }
    }

    public final void a(Activity activity, Class<?> cls, Bundle bundle, int i2) {
        K("startActivityForResult1", activity, cls, bundle, Integer.valueOf(i2));
        Intent intent = new Intent(activity, cls);
        intent.putExtra("process_id", getClass().hashCode());
        intent.addFlags(67108864);
        activity.startActivityForResult(intent, i2);
        if (bundle != null) {
            this.dQL.putAll(bundle);
        }
    }

    public void P(Activity activity) {
        K("finishActivity", activity);
        if (!activity.isFinishing() && (activity instanceof MMActivity)) {
            ((MMActivity) activity).finish();
        }
    }

    /* access modifiers changed from: protected */
    public final void b(Activity activity, Class<?> cls, Bundle bundle, int i2) {
        K("finishActivity", activity, cls, "errCode ".concat(String.valueOf(i2)));
        Intent intent = new Intent(activity, cls);
        intent.putExtra("process_id", getClass().hashCode());
        intent.addFlags(67108864);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/wallet_core/WalletProcess", "backActivity", "(Landroid/app/Activity;Ljava/lang/Class;Landroid/os/Bundle;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        activity.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/wallet_core/WalletProcess", "backActivity", "(Landroid/app/Activity;Ljava/lang/Class;Landroid/os/Bundle;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        this.dQL.putInt("key_err_code", i2);
    }

    /* access modifiers changed from: protected */
    public final void a(Activity activity, Class<?> cls, int i2) {
        b(activity, cls, null, i2);
    }

    public d a(Activity activity, Bundle bundle) {
        return this;
    }

    public final void a(a aVar, Context context) {
        this.MF = new WeakReference<>(aVar);
        this.RrY = new WeakReference<>(context);
    }

    public final void hgH() {
        this.MF = null;
        this.RrY = null;
    }

    public final void bz(Activity activity) {
        K("specEndProcess", activity);
        if (!activity.isFinishing() && (activity instanceof MMActivity)) {
            ((MMActivity) activity).finish();
        }
        if (this.dQL != null) {
            this.dQL.clear();
        }
        a.remove(getClass().hashCode());
        fOj();
    }

    public final void bA(Activity activity) {
        K("endProcess1", activity);
        if (!activity.isFinishing() && (activity instanceof MMActivity)) {
            ((MMActivity) activity).finish();
        }
        if (this.dQL != null) {
            this.dQL.clear();
        }
        a.remove(getClass().hashCode());
    }

    public final void b(Activity activity, int i2, Bundle bundle) {
        K("endProcess1", activity);
        if (!activity.isFinishing() && (activity instanceof MMActivity)) {
            ((MMActivity) activity).finish();
        }
        if (this.MF.get() != null) {
            this.MF.get().q(i2, bundle);
        }
        if (bundle != null) {
            bundle.clear();
        }
        a.remove(getClass().hashCode());
    }

    public final void a(Activity activity, Class<?> cls, int i2, Intent intent, boolean z) {
        Intent intent2;
        K("endProcess2", activity, cls, Integer.valueOf(i2), intent, Boolean.valueOf(z));
        if (this.MF == null || this.MF.get() == null) {
            intent2 = intent;
        } else {
            intent2 = this.MF.get().q(i2, this.dQL);
        }
        if (intent2 == null) {
            intent2 = new Intent(activity, cls);
            intent2.putExtra("key_process_is_stay", z);
        } else if (intent2.getExtras() != null && !intent2.getExtras().containsKey("key_process_is_stay")) {
            intent2.putExtra("key_process_is_stay", true);
        }
        if (cls != null) {
            intent2.setClass(activity, cls);
        }
        intent2.addFlags(67108864);
        intent2.putExtra("key_process_is_end", true);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
        com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/wallet_core/WalletProcess", "endProcess", "(Landroid/app/Activity;Ljava/lang/Class;ILandroid/content/Intent;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        activity.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/wallet_core/WalletProcess", "endProcess", "(Landroid/app/Activity;Ljava/lang/Class;ILandroid/content/Intent;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        if (this.dQL != null) {
            this.dQL.clear();
        }
        a.remove(getClass().hashCode());
    }

    /* access modifiers changed from: protected */
    public final void a(Activity activity, String str, String str2, int i2, boolean z) {
        a(activity, str, str2, i2, null, z);
    }

    public final void a(Activity activity, String str, String str2, int i2, Intent intent, boolean z) {
        K("endProcess3", activity, str, str2, Integer.valueOf(i2), intent, Boolean.valueOf(z));
        Intent intent2 = null;
        if (this.MF.get() != null) {
            intent2 = this.MF.get().q(i2, this.dQL);
        }
        if (intent == null) {
            intent = new Intent();
            intent.putExtra("key_process_is_stay", z);
        } else if (intent.getExtras() != null && !intent.getExtras().containsKey("key_process_is_stay")) {
            intent.putExtra("key_process_is_stay", true);
        }
        if (intent2 != null) {
            intent.putExtras(intent2);
        }
        intent.addFlags(67108864);
        intent.putExtra("key_process_is_end", true);
        c.b(activity, str, str2, intent);
        if (this.dQL != null) {
            this.dQL.clear();
        }
        a.remove(getClass().hashCode());
    }

    /* access modifiers changed from: protected */
    public final void a(Activity activity, Class<?> cls, Intent intent) {
        a(activity, cls, -1, intent, true);
    }

    /* access modifiers changed from: protected */
    public final void a(Activity activity, Class<?> cls, int i2, boolean z) {
        a(activity, cls, i2, (Intent) null, z);
    }

    /* access modifiers changed from: protected */
    public final void c(Activity activity, Class<?> cls) {
        a(activity, cls, -1, (Intent) null, true);
    }

    /* access modifiers changed from: protected */
    public final void e(Activity activity, String str, String str2) {
        a(activity, str, str2, -1, true);
    }

    public final int hgI() {
        return this.dQL.getInt("key_support_bankcard", 1);
    }

    public final boolean fTp() {
        return this.dQL.getBoolean("key_is_oversea", false);
    }

    public final boolean hgJ() {
        return this.dQL.getInt("key_pay_flag", 0) == 2;
    }

    public final boolean hgK() {
        return this.dQL.getInt("key_pay_flag", 0) == 1;
    }

    public final boolean hgL() {
        return this.dQL.getInt("key_pay_flag", 0) == 3;
    }

    public g a(MMActivity mMActivity, i iVar) {
        return null;
    }

    public boolean j(Activity activity, Bundle bundle) {
        return false;
    }

    public final boolean hgM() {
        String string = this.dQL.getString("key_bank_username");
        Log.i("MicroMsg.ProcessManager", "follow bank account : isFollow " + this.dQL.getBoolean("key_is_follow_bank_username", false) + ", username : " + string);
        if (!this.dQL.getBoolean("key_is_follow_bank_username", false) || Util.isNullOrNil(string)) {
            return false;
        }
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.a(new t(string), 0);
        return true;
    }

    public int a(MMActivity mMActivity, int i2) {
        return -1;
    }

    public boolean a(WalletBaseUI walletBaseUI, int i2, String str) {
        return false;
    }

    public void fOj() {
    }

    public void a(WalletBaseUI walletBaseUI) {
    }

    public void b(WalletBaseUI walletBaseUI) {
    }
}
