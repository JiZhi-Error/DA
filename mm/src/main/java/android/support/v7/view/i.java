package android.support.v7.view;

import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

public class i implements Window.Callback {
    final Window.Callback aeD;

    public i(Window.Callback callback) {
        if (callback == null) {
            throw new IllegalArgumentException("Window callback may not be null");
        }
        this.aeD = callback;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.aeD.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return this.aeD.dispatchKeyShortcutEvent(keyEvent);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.aeD.dispatchTouchEvent(motionEvent);
    }

    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.aeD.dispatchTrackballEvent(motionEvent);
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.aeD.dispatchGenericMotionEvent(motionEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.aeD.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    public View onCreatePanelView(int i2) {
        return this.aeD.onCreatePanelView(i2);
    }

    public boolean onCreatePanelMenu(int i2, Menu menu) {
        return this.aeD.onCreatePanelMenu(i2, menu);
    }

    public boolean onPreparePanel(int i2, View view, Menu menu) {
        return this.aeD.onPreparePanel(i2, view, menu);
    }

    public boolean onMenuOpened(int i2, Menu menu) {
        return this.aeD.onMenuOpened(i2, menu);
    }

    public boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        return this.aeD.onMenuItemSelected(i2, menuItem);
    }

    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        this.aeD.onWindowAttributesChanged(layoutParams);
    }

    public void onContentChanged() {
        this.aeD.onContentChanged();
    }

    public void onWindowFocusChanged(boolean z) {
        this.aeD.onWindowFocusChanged(z);
    }

    public void onAttachedToWindow() {
        this.aeD.onAttachedToWindow();
    }

    public void onDetachedFromWindow() {
        this.aeD.onDetachedFromWindow();
    }

    public void onPanelClosed(int i2, Menu menu) {
        this.aeD.onPanelClosed(i2, menu);
    }

    public boolean onSearchRequested(SearchEvent searchEvent) {
        return this.aeD.onSearchRequested(searchEvent);
    }

    public boolean onSearchRequested() {
        return this.aeD.onSearchRequested();
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return this.aeD.onWindowStartingActionMode(callback);
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i2) {
        return this.aeD.onWindowStartingActionMode(callback, i2);
    }

    public void onActionModeStarted(ActionMode actionMode) {
        this.aeD.onActionModeStarted(actionMode);
    }

    public void onActionModeFinished(ActionMode actionMode) {
        this.aeD.onActionModeFinished(actionMode);
    }

    @Override // android.view.Window.Callback
    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i2) {
        this.aeD.onProvideKeyboardShortcuts(list, menu, i2);
    }

    public void onPointerCaptureChanged(boolean z) {
        this.aeD.onPointerCaptureChanged(z);
    }
}
