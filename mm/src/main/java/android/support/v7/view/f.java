package android.support.v7.view;

import android.content.Context;
import android.support.v4.e.n;
import android.support.v7.view.b;
import android.support.v7.view.menu.q;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.util.ArrayList;

public final class f extends ActionMode {
    final b adI;
    final Context mContext;

    public f(Context context, b bVar) {
        this.mContext = context;
        this.adI = bVar;
    }

    public final Object getTag() {
        return this.adI.mTag;
    }

    public final void setTag(Object obj) {
        this.adI.mTag = obj;
    }

    @Override // android.view.ActionMode
    public final void setTitle(CharSequence charSequence) {
        this.adI.setTitle(charSequence);
    }

    @Override // android.view.ActionMode
    public final void setSubtitle(CharSequence charSequence) {
        this.adI.setSubtitle(charSequence);
    }

    public final void invalidate() {
        this.adI.invalidate();
    }

    public final void finish() {
        this.adI.finish();
    }

    public final Menu getMenu() {
        return q.a(this.mContext, (android.support.v4.a.a.a) this.adI.getMenu());
    }

    public final CharSequence getTitle() {
        return this.adI.getTitle();
    }

    @Override // android.view.ActionMode
    public final void setTitle(int i2) {
        this.adI.setTitle(i2);
    }

    public final CharSequence getSubtitle() {
        return this.adI.getSubtitle();
    }

    @Override // android.view.ActionMode
    public final void setSubtitle(int i2) {
        this.adI.setSubtitle(i2);
    }

    public final View getCustomView() {
        return this.adI.getCustomView();
    }

    public final void setCustomView(View view) {
        this.adI.setCustomView(view);
    }

    public final MenuInflater getMenuInflater() {
        return this.adI.getMenuInflater();
    }

    public final boolean getTitleOptionalHint() {
        return this.adI.adE;
    }

    public final void setTitleOptionalHint(boolean z) {
        this.adI.setTitleOptionalHint(z);
    }

    public final boolean isTitleOptional() {
        return this.adI.isTitleOptional();
    }

    public static class a implements b.a {
        final ActionMode.Callback adJ;
        final ArrayList<f> adK = new ArrayList<>();
        final n<Menu, Menu> adL = new n<>();
        final Context mContext;

        public a(Context context, ActionMode.Callback callback) {
            this.mContext = context;
            this.adJ = callback;
        }

        @Override // android.support.v7.view.b.a
        public final boolean a(b bVar, Menu menu) {
            return this.adJ.onCreateActionMode(b(bVar), b(menu));
        }

        @Override // android.support.v7.view.b.a
        public final boolean b(b bVar, Menu menu) {
            return this.adJ.onPrepareActionMode(b(bVar), b(menu));
        }

        @Override // android.support.v7.view.b.a
        public final boolean a(b bVar, MenuItem menuItem) {
            return this.adJ.onActionItemClicked(b(bVar), q.a(this.mContext, (android.support.v4.a.a.b) menuItem));
        }

        @Override // android.support.v7.view.b.a
        public final void a(b bVar) {
            this.adJ.onDestroyActionMode(b(bVar));
        }

        private Menu b(Menu menu) {
            Menu menu2 = this.adL.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            Menu a2 = q.a(this.mContext, (android.support.v4.a.a.a) menu);
            this.adL.put(menu, a2);
            return a2;
        }

        public final ActionMode b(b bVar) {
            int size = this.adK.size();
            for (int i2 = 0; i2 < size; i2++) {
                f fVar = this.adK.get(i2);
                if (fVar != null && fVar.adI == bVar) {
                    return fVar;
                }
            }
            f fVar2 = new f(this.mContext, bVar);
            this.adK.add(fVar2);
            return fVar2;
        }
    }
}
