package android.support.v7.app;

import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.a;
import android.support.v4.app.ab;
import android.support.v4.app.q;
import android.support.v7.app.a;
import android.support.v7.view.b;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.be;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

public class AppCompatActivity extends FragmentActivity implements ab.a, c {
    private d mDelegate;
    private Resources mResources;
    private int mThemeId = 0;

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.SupportActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        d delegate = getDelegate();
        delegate.gB();
        delegate.onCreate(bundle);
        if (delegate.gC() && this.mThemeId != 0) {
            if (Build.VERSION.SDK_INT >= 23) {
                onApplyThemeResource(getTheme(), this.mThemeId, false);
            } else {
                setTheme(this.mThemeId);
            }
        }
        super.onCreate(bundle);
    }

    @Override // android.view.ContextThemeWrapper, android.app.Activity
    public void setTheme(int i2) {
        super.setTheme(i2);
        this.mThemeId = i2;
    }

    /* access modifiers changed from: protected */
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        getDelegate().gA();
    }

    public ActionBar getSupportActionBar() {
        return getDelegate().getSupportActionBar();
    }

    public void setSupportActionBar(Toolbar toolbar) {
        getDelegate().setSupportActionBar(toolbar);
    }

    public MenuInflater getMenuInflater() {
        return getDelegate().getMenuInflater();
    }

    @Override // android.app.Activity
    public void setContentView(int i2) {
        getDelegate().setContentView(i2);
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        getDelegate().setContentView(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        getDelegate().setContentView(view, layoutParams);
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        getDelegate().addContentView(view, layoutParams);
    }

    @Override // android.support.v4.app.FragmentActivity
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        getDelegate().onConfigurationChanged(configuration);
        if (this.mResources != null) {
            this.mResources.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public void onPostResume() {
        super.onPostResume();
        getDelegate().onPostResume();
    }

    @Override // android.support.v4.app.FragmentActivity
    public void onStart() {
        super.onStart();
        getDelegate().onStart();
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        super.onStop();
        getDelegate().onStop();
    }

    @Override // android.app.Activity
    public <T extends View> T findViewById(int i2) {
        return (T) getDelegate().findViewById(i2);
    }

    @Override // android.support.v4.app.FragmentActivity
    public final boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        if (super.onMenuItemSelected(i2, menuItem)) {
            return true;
        }
        ActionBar supportActionBar = getSupportActionBar();
        if (menuItem.getItemId() != 16908332 || supportActionBar == null || (supportActionBar.getDisplayOptions() & 4) == 0) {
            return false;
        }
        return onSupportNavigateUp();
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
        getDelegate().onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onTitleChanged(CharSequence charSequence, int i2) {
        super.onTitleChanged(charSequence, i2);
        getDelegate().setTitle(charSequence);
    }

    public boolean supportRequestWindowFeature(int i2) {
        return getDelegate().requestWindowFeature(i2);
    }

    @Override // android.support.v4.app.FragmentActivity
    public void supportInvalidateOptionsMenu() {
        getDelegate().invalidateOptionsMenu();
    }

    public void invalidateOptionsMenu() {
        getDelegate().invalidateOptionsMenu();
    }

    @Override // android.support.v7.app.c
    public void onSupportActionModeStarted(b bVar) {
    }

    @Override // android.support.v7.app.c
    public void onSupportActionModeFinished(b bVar) {
    }

    @Override // android.support.v7.app.c
    public b onWindowStartingSupportActionMode(b.a aVar) {
        return null;
    }

    public b startSupportActionMode(b.a aVar) {
        return getDelegate().startSupportActionMode(aVar);
    }

    @Deprecated
    public void setSupportProgressBarVisibility(boolean z) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminateVisibility(boolean z) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminate(boolean z) {
    }

    @Deprecated
    public void setSupportProgress(int i2) {
    }

    public void onCreateSupportNavigateUpTaskStack(ab abVar) {
        Intent intent;
        Intent supportParentActivityIntent = getSupportParentActivityIntent();
        if (supportParentActivityIntent == null) {
            intent = q.h(this);
        } else {
            intent = supportParentActivityIntent;
        }
        if (intent != null) {
            ComponentName component = intent.getComponent();
            if (component == null) {
                component = intent.resolveActivity(abVar.IT.getPackageManager());
            }
            abVar.a(component);
            abVar.IS.add(intent);
        }
    }

    public void onPrepareSupportNavigateUpTaskStack(ab abVar) {
    }

    public boolean onSupportNavigateUp() {
        Intent supportParentActivityIntent = getSupportParentActivityIntent();
        if (supportParentActivityIntent == null) {
            return false;
        }
        if (supportShouldUpRecreateTask(supportParentActivityIntent)) {
            ab R = ab.R(this);
            onCreateSupportNavigateUpTaskStack(R);
            onPrepareSupportNavigateUpTaskStack(R);
            if (R.IS.isEmpty()) {
                throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
            }
            Intent[] intentArr = (Intent[]) R.IS.toArray(new Intent[R.IS.size()]);
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            android.support.v4.content.b.a(R.IT, intentArr);
            try {
                a.d(this);
            } catch (IllegalStateException e2) {
                finish();
            }
        } else {
            supportNavigateUpTo(supportParentActivityIntent);
        }
        return true;
    }

    @Override // android.support.v4.app.ab.a
    public Intent getSupportParentActivityIntent() {
        return q.h(this);
    }

    public void onContentChanged() {
        onSupportContentChanged();
    }

    @Deprecated
    public void onSupportContentChanged() {
    }

    public a.AbstractC0041a getDrawerToggleDelegate() {
        return getDelegate().getDrawerToggleDelegate();
    }

    public boolean onMenuOpened(int i2, Menu menu) {
        return super.onMenuOpened(i2, menu);
    }

    @Override // android.support.v4.app.FragmentActivity
    public void onPanelClosed(int i2, Menu menu) {
        super.onPanelClosed(i2, menu);
    }

    @Override // android.support.v4.app.SupportActivity, android.support.v4.app.FragmentActivity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        getDelegate().onSaveInstanceState(bundle);
    }

    public d getDelegate() {
        if (this.mDelegate == null) {
            this.mDelegate = d.a(this, this);
        }
        return this.mDelegate;
    }

    @Override // android.support.v4.app.SupportActivity
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        ActionBar supportActionBar = getSupportActionBar();
        if (keyCode != 82 || supportActionBar == null || !supportActionBar.b(keyEvent)) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    public Resources getResources() {
        if (this.mResources == null && be.nk()) {
            this.mResources = new be(this, super.getResources());
        }
        return this.mResources == null ? super.getResources() : this.mResources;
    }

    private boolean performMenuItemShortcut(int i2, KeyEvent keyEvent) {
        Window window;
        if (Build.VERSION.SDK_INT >= 26 || keyEvent.isCtrlPressed() || KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) || keyEvent.getRepeatCount() != 0 || KeyEvent.isModifierKey(keyEvent.getKeyCode()) || (window = getWindow()) == null || window.getDecorView() == null || !window.getDecorView().dispatchKeyShortcutEvent(keyEvent)) {
            return false;
        }
        return true;
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (performMenuItemShortcut(i2, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    public void openOptionsMenu() {
        ActionBar supportActionBar = getSupportActionBar();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (supportActionBar == null || !supportActionBar.gw()) {
            super.openOptionsMenu();
        }
    }

    public void closeOptionsMenu() {
        ActionBar supportActionBar = getSupportActionBar();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (supportActionBar == null || !supportActionBar.gx()) {
            super.closeOptionsMenu();
        }
    }

    public boolean supportShouldUpRecreateTask(Intent intent) {
        if (Build.VERSION.SDK_INT >= 16) {
            return shouldUpRecreateTask(intent);
        }
        String action = getIntent().getAction();
        return action != null && !action.equals("android.intent.action.MAIN");
    }

    public void supportNavigateUpTo(Intent intent) {
        if (Build.VERSION.SDK_INT >= 16) {
            navigateUpTo(intent);
            return;
        }
        intent.addFlags(67108864);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "android/support/v4/app/NavUtils", "navigateUpTo", "(Landroid/app/Activity;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "android/support/v4/app/NavUtils", "navigateUpTo", "(Landroid/app/Activity;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
    }
}
