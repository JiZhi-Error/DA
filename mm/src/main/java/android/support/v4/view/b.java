package android.support.v4.view;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public abstract class b {
    public a Po;
    public AbstractC0037b Pp;
    private final Context mContext;

    public interface a {
        void K(boolean z);
    }

    /* renamed from: android.support.v4.view.b$b  reason: collision with other inner class name */
    public interface AbstractC0037b {
        void fz();
    }

    public abstract View onCreateActionView();

    public b(Context context) {
        this.mContext = context;
    }

    public View onCreateActionView(MenuItem menuItem) {
        return onCreateActionView();
    }

    public boolean overridesItemVisibility() {
        return false;
    }

    public boolean isVisible() {
        return true;
    }

    public boolean onPerformDefaultAction() {
        return false;
    }

    public boolean hasSubMenu() {
        return false;
    }

    public void onPrepareSubMenu(SubMenu subMenu) {
    }

    public final void J(boolean z) {
        if (this.Po != null) {
            this.Po.K(z);
        }
    }

    public void a(AbstractC0037b bVar) {
        if (this.Pp != null) {
            new StringBuilder("setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this ").append(getClass().getSimpleName()).append(" instance while it is still in use somewhere else?");
        }
        this.Pp = bVar;
    }
}
