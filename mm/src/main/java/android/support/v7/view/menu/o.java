package android.support.v7.view.menu;

import android.content.Context;
import android.os.Parcelable;

public interface o {

    public interface a {
        void a(h hVar, boolean z);

        boolean d(h hVar);
    }

    void a(Context context, h hVar);

    void a(h hVar, boolean z);

    void a(a aVar);

    boolean a(u uVar);

    boolean b(j jVar);

    boolean bF();

    boolean c(j jVar);

    int getId();

    void onRestoreInstanceState(Parcelable parcelable);

    Parcelable onSaveInstanceState();

    void p(boolean z);
}
