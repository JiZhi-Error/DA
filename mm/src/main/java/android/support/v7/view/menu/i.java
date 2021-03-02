package android.support.v7.view.menu;

import android.content.DialogInterface;
import android.support.v7.app.b;
import android.support.v7.view.menu.o;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;

final class i implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener, DialogInterface.OnKeyListener, o.a {
    h aaQ;
    private o.a afH;
    b agL;
    f agM;

    public i(h hVar) {
        this.aaQ = hVar;
    }

    public final boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i2 == 82 || i2 == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.agL.getWindow();
                if (!(window2 == null || (decorView2 = window2.getDecorView()) == null || (keyDispatcherState2 = decorView2.getKeyDispatcherState()) == null)) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.agL.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.aaQ.aa(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.aaQ.performShortcut(i2, keyEvent, 0);
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        this.agM.a(this.aaQ, true);
    }

    @Override // android.support.v7.view.menu.o.a
    public final void a(h hVar, boolean z) {
        if ((z || hVar == this.aaQ) && this.agL != null) {
            this.agL.dismiss();
        }
        if (this.afH != null) {
            this.afH.a(hVar, z);
        }
    }

    @Override // android.support.v7.view.menu.o.a
    public final boolean d(h hVar) {
        if (this.afH != null) {
            return this.afH.d(hVar);
        }
        return false;
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        this.aaQ.a((j) this.agM.getAdapter().getItem(i2), (o) null, 0);
    }
}
