package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.view.menu.ListMenuItemView;
import android.support.v7.view.menu.g;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.j;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

public final class ah extends ListPopupWindow implements ag {
    private static Method arC;
    public ag arD;

    static {
        try {
            arC = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
        } catch (NoSuchMethodException e2) {
        }
    }

    public ah(Context context, int i2, int i3) {
        super(context, null, i2, i3);
    }

    /* access modifiers changed from: package-private */
    @Override // android.support.v7.widget.ListPopupWindow
    public final y i(Context context, boolean z) {
        a aVar = new a(context, z);
        aVar.setHoverListener(this);
        return aVar;
    }

    public final void kE() {
        if (Build.VERSION.SDK_INT >= 23) {
            this.arA.setEnterTransition(null);
        }
    }

    public final void kF() {
        if (arC != null) {
            try {
                arC.invoke(this.arA, Boolean.FALSE);
            } catch (Exception e2) {
            }
        }
    }

    @Override // android.support.v7.widget.ag
    public final void c(h hVar, MenuItem menuItem) {
        if (this.arD != null) {
            this.arD.c(hVar, menuItem);
        }
    }

    @Override // android.support.v7.widget.ag
    public final void b(h hVar, MenuItem menuItem) {
        if (this.arD != null) {
            this.arD.b(hVar, menuItem);
        }
    }

    public static class a extends y {
        private ag arD;
        final int arE;
        final int arF;
        private MenuItem arG;

        @Override // android.support.v7.widget.y
        public final /* bridge */ /* synthetic */ int e(int i2, int i3, int i4, int i5, int i6) {
            return super.e(i2, i3, i4, i5, i6);
        }

        @Override // android.support.v7.widget.y
        public final /* bridge */ /* synthetic */ boolean f(MotionEvent motionEvent, int i2) {
            return super.f(motionEvent, i2);
        }

        @Override // android.support.v7.widget.y
        public final /* bridge */ /* synthetic */ boolean hasFocus() {
            return super.hasFocus();
        }

        @Override // android.support.v7.widget.y
        public final /* bridge */ /* synthetic */ boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        @Override // android.support.v7.widget.y
        public final /* bridge */ /* synthetic */ boolean isFocused() {
            return super.isFocused();
        }

        @Override // android.support.v7.widget.y
        public final /* bridge */ /* synthetic */ boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        @Override // android.support.v7.widget.y
        public final /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }

        @Override // android.support.v7.widget.y, android.widget.AbsListView
        public final /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }

        public a(Context context, boolean z) {
            super(context, z);
            Configuration configuration = context.getResources().getConfiguration();
            if (Build.VERSION.SDK_INT < 17 || 1 != configuration.getLayoutDirection()) {
                this.arE = 22;
                this.arF = 21;
                return;
            }
            this.arE = 21;
            this.arF = 22;
        }

        public final void setHoverListener(ag agVar) {
            this.arD = agVar;
        }

        public final boolean onKeyDown(int i2, KeyEvent keyEvent) {
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i2 == this.arE) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            } else if (listMenuItemView == null || i2 != this.arF) {
                return super.onKeyDown(i2, keyEvent);
            } else {
                setSelection(-1);
                ((g) getAdapter()).agm.aa(false);
                return true;
            }
        }

        @Override // android.support.v7.widget.y
        public final boolean onHoverEvent(MotionEvent motionEvent) {
            int i2;
            g gVar;
            j jVar;
            int pointToPosition;
            int i3;
            if (this.arD != null) {
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    i2 = headerViewListAdapter.getHeadersCount();
                    gVar = (g) headerViewListAdapter.getWrappedAdapter();
                } else {
                    i2 = 0;
                    gVar = (g) adapter;
                }
                if (motionEvent.getAction() == 10 || (pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) == -1 || (i3 = pointToPosition - i2) < 0 || i3 >= gVar.getCount()) {
                    jVar = null;
                } else {
                    jVar = gVar.getItem(i3);
                }
                MenuItem menuItem = this.arG;
                if (menuItem != jVar) {
                    h hVar = gVar.agm;
                    if (menuItem != null) {
                        this.arD.b(hVar, menuItem);
                    }
                    this.arG = jVar;
                    if (jVar != null) {
                        this.arD.c(hVar, jVar);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }
    }
}
