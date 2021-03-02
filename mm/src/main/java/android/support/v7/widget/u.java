package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.y;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.o;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

public interface u {
    void a(o.a aVar, h.a aVar2);

    void a(ar arVar);

    void a(Menu menu, o.a aVar);

    y c(int i2, long j2);

    void collapseActionView();

    void dismissPopupMenus();

    Context getContext();

    View getCustomView();

    int getDisplayOptions();

    int getHeight();

    Menu getMenu();

    int getNavigationMode();

    CharSequence getTitle();

    int getVisibility();

    boolean hasExpandedActionView();

    boolean hideOverflowMenu();

    boolean iB();

    boolean iC();

    void iD();

    boolean isOverflowMenuShowing();

    ViewGroup jC();

    void setBackgroundDrawable(Drawable drawable);

    void setCollapsible(boolean z);

    void setCustomView(View view);

    void setDisplayOptions(int i2);

    void setIcon(int i2);

    void setIcon(Drawable drawable);

    void setLogo(int i2);

    void setLogo(Drawable drawable);

    void setNavigationContentDescription(int i2);

    void setTitle(CharSequence charSequence);

    void setVisibility(int i2);

    void setWindowCallback(Window.Callback callback);

    void setWindowTitle(CharSequence charSequence);

    boolean showOverflowMenu();
}
