package android.support.v4.view;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class e {
    private static boolean PP = false;
    private static Method PQ = null;
    private static boolean PR = false;
    private static Field PS = null;

    public interface a {
        boolean superDispatchKeyEvent(KeyEvent keyEvent);
    }

    public static boolean a(View view, KeyEvent keyEvent) {
        return u.b(view, keyEvent);
    }

    public static boolean a(a aVar, View view, Window.Callback callback, KeyEvent keyEvent) {
        KeyEvent.DispatcherState dispatcherState = null;
        if (aVar == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            return aVar.superDispatchKeyEvent(keyEvent);
        }
        if (callback instanceof Activity) {
            Activity activity = (Activity) callback;
            activity.onUserInteraction();
            Window window = activity.getWindow();
            if (window.hasFeature(8)) {
                ActionBar actionBar = activity.getActionBar();
                if (keyEvent.getKeyCode() == 82 && actionBar != null && a(actionBar, keyEvent)) {
                    return true;
                }
            }
            if (window.superDispatchKeyEvent(keyEvent)) {
                return true;
            }
            View decorView = window.getDecorView();
            if (u.c(decorView, keyEvent)) {
                return true;
            }
            if (decorView != null) {
                dispatcherState = decorView.getKeyDispatcherState();
            }
            return keyEvent.dispatch(activity, dispatcherState, activity);
        } else if (!(callback instanceof Dialog)) {
            return (view != null && u.c(view, keyEvent)) || aVar.superDispatchKeyEvent(keyEvent);
        } else {
            Dialog dialog = (Dialog) callback;
            DialogInterface.OnKeyListener a2 = a(dialog);
            if (a2 != null && a2.onKey(dialog, keyEvent.getKeyCode(), keyEvent)) {
                return true;
            }
            Window window2 = dialog.getWindow();
            if (window2.superDispatchKeyEvent(keyEvent)) {
                return true;
            }
            View decorView2 = window2.getDecorView();
            if (u.c(decorView2, keyEvent)) {
                return true;
            }
            if (decorView2 != null) {
                dispatcherState = decorView2.getKeyDispatcherState();
            }
            return keyEvent.dispatch(dialog, dispatcherState, dialog);
        }
    }

    private static boolean a(ActionBar actionBar, KeyEvent keyEvent) {
        if (!PP) {
            try {
                PQ = actionBar.getClass().getMethod("onMenuKeyEvent", KeyEvent.class);
            } catch (NoSuchMethodException e2) {
            }
            PP = true;
        }
        if (PQ != null) {
            try {
                return ((Boolean) PQ.invoke(actionBar, keyEvent)).booleanValue();
            } catch (IllegalAccessException | InvocationTargetException e3) {
            }
        }
        return false;
    }

    private static DialogInterface.OnKeyListener a(Dialog dialog) {
        if (!PR) {
            try {
                Field declaredField = Dialog.class.getDeclaredField("mOnKeyListener");
                PS = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
            }
            PR = true;
        }
        if (PS != null) {
            try {
                return (DialogInterface.OnKeyListener) PS.get(dialog);
            } catch (IllegalAccessException e3) {
            }
        }
        return null;
    }
}
