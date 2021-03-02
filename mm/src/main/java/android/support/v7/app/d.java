package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.a;
import android.support.v7.view.b;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class d {
    static int Yv = -1;

    public abstract void addContentView(View view, ViewGroup.LayoutParams layoutParams);

    public abstract <T extends View> T findViewById(int i2);

    public abstract void gA();

    public abstract void gB();

    public abstract boolean gC();

    public abstract a.AbstractC0041a getDrawerToggleDelegate();

    public abstract MenuInflater getMenuInflater();

    public abstract ActionBar getSupportActionBar();

    public abstract void invalidateOptionsMenu();

    public abstract void onConfigurationChanged(Configuration configuration);

    public abstract void onCreate(Bundle bundle);

    public abstract void onDestroy();

    public abstract void onPostResume();

    public abstract void onSaveInstanceState(Bundle bundle);

    public abstract void onStart();

    public abstract void onStop();

    public abstract boolean requestWindowFeature(int i2);

    public abstract void setContentView(int i2);

    public abstract void setContentView(View view);

    public abstract void setContentView(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void setSupportActionBar(Toolbar toolbar);

    public abstract void setTitle(CharSequence charSequence);

    public abstract b startSupportActionMode(b.a aVar);

    public static d a(Activity activity, c cVar) {
        return new AppCompatDelegateImpl(activity, activity.getWindow(), cVar);
    }

    public static d a(Dialog dialog, c cVar) {
        return new AppCompatDelegateImpl(dialog.getContext(), dialog.getWindow(), cVar);
    }

    d() {
    }
}
