package com.tencent.mm.ui;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;

public abstract class FragmentActivitySupport extends Fragment {
    private byte _hellAccFlag_;
    public boolean hasDestory;
    public boolean isCurrentActivity;
    private FragmentActivity mActivity;

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mActivity = getActivity();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.hasDestory = true;
    }

    public FragmentActivitySupport(boolean z) {
        this.hasDestory = false;
        this.isCurrentActivity = z;
    }

    public FragmentActivitySupport() {
        this.hasDestory = false;
        this.isCurrentActivity = false;
    }

    @Override // android.support.v4.app.Fragment
    public void startActivity(Intent intent) {
        FragmentActivity thisActivity = thisActivity();
        if (thisActivity == null) {
            Context context = MMApplicationContext.getContext();
            a bl = new a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/ui/FragmentActivitySupport", "startActivity", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/ui/FragmentActivitySupport", "startActivity", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            return;
        }
        thisActivity.startActivityFromFragment(this, intent, -1);
    }

    public void finish() {
        if (this.isCurrentActivity) {
            if (thisActivity() != null) {
                thisActivity().finish();
            }
        } else if (thisActivity() != null) {
            thisActivity().getSupportFragmentManager().popBackStack();
        }
    }

    public int getIntExtra(String str, int i2) {
        if (this.isCurrentActivity && getArguments() == null && thisActivity() != null) {
            return thisActivity().getIntent().getIntExtra(str, i2);
        }
        if (getArguments() != null) {
            return getArguments().getInt(str, i2);
        }
        return i2;
    }

    public String getStringExtra(String str) {
        String str2 = null;
        if (this.isCurrentActivity && thisActivity() != null) {
            str2 = thisActivity().getIntent().getStringExtra(str);
        }
        if (str2 != null || getArguments() == null) {
            return str2;
        }
        return super.getArguments().getString(str);
    }

    public <T extends Parcelable> T getParcelableExtra(String str) {
        T t = null;
        if (this.isCurrentActivity && thisActivity() != null) {
            t = (T) thisActivity().getIntent().getParcelableExtra(str);
        }
        return (t != null || getArguments() == null) ? t : (T) super.getArguments().getParcelable(str);
    }

    public String getPackageName() {
        return thisActivity().getPackageName();
    }

    public SharedPreferences getSharedPreferences(String str, int i2) {
        return thisActivity().getSharedPreferences(str, i2);
    }

    public LayoutInflater getActivityLayoutInflater() {
        return thisActivity().getLayoutInflater();
    }

    public FragmentActivity thisActivity() {
        if (this.mActivity == null) {
            this.mActivity = getActivity();
        }
        return this.mActivity;
    }

    public View findViewById(int i2) {
        View view = getView();
        View view2 = null;
        if (view != null) {
            view2 = view.findViewById(i2);
        }
        return view2 != null ? view2 : thisActivity().findViewById(i2);
    }

    public void sendBroadcast(Intent intent) {
        thisActivity().sendBroadcast(intent);
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            finish();
            return true;
        } else if (i2 == 82 && keyEvent.getAction() == 1) {
            return onKeyUp(i2, keyEvent);
        } else {
            return false;
        }
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        return false;
    }

    public boolean isFinishing() {
        if (thisActivity() == null) {
            return true;
        }
        return thisActivity().isFinishing();
    }

    public void setRequestedOrientation(int i2) {
        if (thisActivity() != null) {
            thisActivity().setRequestedOrientation(i2);
        }
    }

    public WindowManager getWindowManager() {
        if (thisActivity() != null) {
            return thisActivity().getWindowManager();
        }
        return null;
    }

    public Window getWindow() {
        if (thisActivity() != null) {
            return thisActivity().getWindow();
        }
        return null;
    }

    public void openContextMenu(View view) {
        if (thisActivity() != null) {
            thisActivity().openContextMenu(view);
        }
    }

    public ContentResolver getContentResolver() {
        if (thisActivity() != null) {
            return thisActivity().getContentResolver();
        }
        return null;
    }

    public Boolean getBooleanExtra(String str, boolean z) {
        if (!this.isCurrentActivity || getArguments() != null) {
            return Boolean.valueOf(getArguments().getBoolean(str, z));
        }
        return Boolean.valueOf(thisActivity().getIntent().getBooleanExtra(str, z));
    }

    public ArrayList<String> getStringArrayList(String str) {
        if (!this.isCurrentActivity || getArguments() != null) {
            return getArguments().getStringArrayList(str);
        }
        return thisActivity().getIntent().getStringArrayListExtra(str);
    }

    public long getLongExtra(String str, long j2) {
        if (this.isCurrentActivity && getArguments() == null) {
            return thisActivity().getIntent().getLongExtra(str, j2);
        }
        if (getArguments() != null) {
            return getArguments().getLong(str, j2);
        }
        return j2;
    }

    public void setResult(int i2) {
        if (this.isCurrentActivity) {
            thisActivity().setResult(i2);
        }
    }

    public void setResult(int i2, Intent intent) {
        if (this.isCurrentActivity) {
            thisActivity().setResult(i2);
        } else {
            thisActivity().setResult(i2, intent);
        }
    }

    public final Cursor managedQuery(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (thisActivity() != null) {
            return thisActivity().managedQuery(uri, strArr, str, strArr2, str2);
        }
        return null;
    }

    public void overridePendingTransition(int i2, int i3) {
        if (thisActivity() != null) {
            thisActivity().overridePendingTransition(i2, i3);
        }
    }

    public void startFragment(Class<?> cls, Intent intent) {
        if (this.isCurrentActivity) {
            a bl = new a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/ui/FragmentActivitySupport", "startFragment", "(Ljava/lang/Class;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/FragmentActivitySupport", "startFragment", "(Ljava/lang/Class;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
    }

    public boolean isShowing() {
        return !this.hasDestory;
    }
}
