package com.tencent.kinda.framework.widget.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.Stack;

public class KindaActionBarColorManager {
    static final int NO_RESTORE = -1;
    private static final String TAG = "KindaActionBarColorManager";
    private Stack<ActionBarColorItem> mColorItemStack;

    private KindaActionBarColorManager() {
        AppMethodBeat.i(18823);
        this.mColorItemStack = new Stack<>();
        AppMethodBeat.o(18823);
    }

    public static final class Holder {
        private static final KindaActionBarColorManager sInstance = new KindaActionBarColorManager();

        static {
            AppMethodBeat.i(18822);
            AppMethodBeat.o(18822);
        }
    }

    public static KindaActionBarColorManager getInstance() {
        AppMethodBeat.i(18824);
        KindaActionBarColorManager kindaActionBarColorManager = Holder.sInstance;
        AppMethodBeat.o(18824);
        return kindaActionBarColorManager;
    }

    /* access modifiers changed from: package-private */
    public void pushActionBarColorItem(BaseFragment baseFragment, int i2) {
        AppMethodBeat.i(18825);
        ActionBarColorItem actionBarColorItem = new ActionBarColorItem();
        actionBarColorItem.color = i2;
        actionBarColorItem.enable = true;
        actionBarColorItem.baseFragment = baseFragment;
        pushUniqueStack(actionBarColorItem);
        AppMethodBeat.o(18825);
    }

    /* access modifiers changed from: package-private */
    public int onRestoreActionBarColor(BaseFragment baseFragment) {
        AppMethodBeat.i(18826);
        if (baseFragment == null) {
            Log.w(TAG, "onRestoreActionBarColor return NO_RESTORE(-1), because baseFragment null.");
            AppMethodBeat.o(18826);
            return -1;
        }
        ActionBarColorItem actionBarColorItem = null;
        if (!this.mColorItemStack.empty()) {
            actionBarColorItem = this.mColorItemStack.peek();
        }
        if (actionBarColorItem == null) {
            Log.w(TAG, "onRestoreActionBarColor return NO_RESTORE(-1), because mColorItemStack empty.");
            AppMethodBeat.o(18826);
            return -1;
        } else if (baseFragment.equals(actionBarColorItem.baseFragment)) {
            int popTopRestoreColor = popTopRestoreColor();
            Log.i(TAG, "onRestoreActionBarColor return " + popTopRestoreColor + " while the baseFragment at the top of stack.");
            AppMethodBeat.o(18826);
            return popTopRestoreColor;
        } else {
            Iterator<ActionBarColorItem> it = this.mColorItemStack.iterator();
            while (it.hasNext()) {
                ActionBarColorItem next = it.next();
                if (next.baseFragment.equals(baseFragment)) {
                    next.enable = false;
                }
            }
            Log.i(TAG, "onRestoreActionBarColor return NO_RESTORE(-1), Because it's not at the top of stack.");
            AppMethodBeat.o(18826);
            return -1;
        }
    }

    public void reset() {
        AppMethodBeat.i(18827);
        this.mColorItemStack.clear();
        AppMethodBeat.o(18827);
    }

    private int popTopRestoreColor() {
        AppMethodBeat.i(18828);
        while (this.mColorItemStack.size() > 1) {
            this.mColorItemStack.pop();
            ActionBarColorItem peek = this.mColorItemStack.peek();
            if (peek.enable) {
                int i2 = peek.color;
                AppMethodBeat.o(18828);
                return i2;
            }
        }
        AppMethodBeat.o(18828);
        return -1;
    }

    private void pushUniqueStack(ActionBarColorItem actionBarColorItem) {
        AppMethodBeat.i(18829);
        if (actionBarColorItem == null || actionBarColorItem.baseFragment == null) {
            AppMethodBeat.o(18829);
            return;
        }
        ActionBarColorItem actionBarColorItem2 = null;
        Iterator<ActionBarColorItem> it = this.mColorItemStack.iterator();
        while (it.hasNext()) {
            ActionBarColorItem next = it.next();
            if (!actionBarColorItem.baseFragment.equals(next.baseFragment)) {
                next = actionBarColorItem2;
            }
            actionBarColorItem2 = next;
        }
        if (actionBarColorItem2 != null) {
            this.mColorItemStack.remove(actionBarColorItem2);
        }
        this.mColorItemStack.push(actionBarColorItem);
        AppMethodBeat.o(18829);
    }
}
