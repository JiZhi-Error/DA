package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.e.m;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mm.hellhoundlib.b.a;
import java.io.PrintWriter;

public abstract class f<E> extends d {
    private final int FG;
    final Activity mActivity;
    final Context mContext;
    final FragmentManagerImpl mFragmentManager;
    final Handler mHandler;

    public abstract E onGetHost();

    f(FragmentActivity fragmentActivity) {
        this(fragmentActivity, fragmentActivity, fragmentActivity.mHandler);
    }

    private f(Activity activity, Context context, Handler handler) {
        this.mFragmentManager = new FragmentManagerImpl();
        this.mActivity = activity;
        this.mContext = (Context) m.checkNotNull(context, "context == null");
        this.mHandler = (Handler) m.checkNotNull(handler, "handler == null");
        this.FG = 0;
    }

    public void a(String str, PrintWriter printWriter, String[] strArr) {
    }

    public boolean ek() {
        return true;
    }

    public LayoutInflater onGetLayoutInflater() {
        return LayoutInflater.from(this.mContext);
    }

    public void el() {
    }

    public void a(Fragment fragment, Intent intent, int i2, Bundle bundle) {
        if (i2 != -1) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        Context context = this.mContext;
        a bl = new a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "android/support/v4/app/FragmentHostCallback", "onStartActivityFromFragment", "(Landroid/support/v4/app/Fragment;Landroid/content/Intent;ILandroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "android/support/v4/app/FragmentHostCallback", "onStartActivityFromFragment", "(Landroid/support/v4/app/Fragment;Landroid/content/Intent;ILandroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }

    public void a(Fragment fragment, IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) {
        if (i2 != -1) {
            throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
        }
        a.a(this.mActivity, intentSender, i2, intent, i3, i4, i5, bundle);
    }

    public void a(Fragment fragment, String[] strArr, int i2) {
    }

    public boolean r(String str) {
        return false;
    }

    public boolean onHasWindowAnimations() {
        return true;
    }

    public int onGetWindowAnimations() {
        return this.FG;
    }

    @Override // android.support.v4.app.d
    public View onFindViewById(int i2) {
        return null;
    }

    @Override // android.support.v4.app.d
    public boolean onHasView() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public void onAttachFragment(Fragment fragment) {
    }
}
