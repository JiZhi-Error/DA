package android.support.v7.widget;

import android.os.Bundle;
import android.support.v4.view.a.c;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

public final class al extends android.support.v4.view.a {
    final android.support.v4.view.a auJ = new a(this);
    final RecyclerView mRecyclerView;

    public al(RecyclerView recyclerView) {
        this.mRecyclerView = recyclerView;
    }

    @Override // android.support.v4.view.a
    public final boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
        if (super.performAccessibilityAction(view, i2, bundle)) {
            return true;
        }
        if (this.mRecyclerView.lt() || this.mRecyclerView.getLayoutManager() == null) {
            return false;
        }
        return this.mRecyclerView.getLayoutManager().performAccessibilityAction(i2, bundle);
    }

    @Override // android.support.v4.view.a
    public final void onInitializeAccessibilityNodeInfo(View view, c cVar) {
        super.onInitializeAccessibilityNodeInfo(view, cVar);
        cVar.setClassName(RecyclerView.class.getName());
        if (!this.mRecyclerView.lt() && this.mRecyclerView.getLayoutManager() != null) {
            this.mRecyclerView.getLayoutManager().onInitializeAccessibilityNodeInfo(cVar);
        }
    }

    @Override // android.support.v4.view.a
    public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        accessibilityEvent.setClassName(RecyclerView.class.getName());
        if ((view instanceof RecyclerView) && !this.mRecyclerView.lt()) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.getLayoutManager() != null) {
                recyclerView.getLayoutManager().onInitializeAccessibilityEvent(accessibilityEvent);
            }
        }
    }

    public static class a extends android.support.v4.view.a {
        final al auK;

        public a(al alVar) {
            this.auK = alVar;
        }

        @Override // android.support.v4.view.a
        public final void onInitializeAccessibilityNodeInfo(View view, c cVar) {
            super.onInitializeAccessibilityNodeInfo(view, cVar);
            if (!this.auK.mRecyclerView.lt() && this.auK.mRecyclerView.getLayoutManager() != null) {
                this.auK.mRecyclerView.getLayoutManager().onInitializeAccessibilityNodeInfoForItem(view, cVar);
            }
        }

        @Override // android.support.v4.view.a
        public final boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
            if (super.performAccessibilityAction(view, i2, bundle)) {
                return true;
            }
            if (this.auK.mRecyclerView.lt() || this.auK.mRecyclerView.getLayoutManager() == null) {
                return false;
            }
            return this.auK.mRecyclerView.getLayoutManager().performAccessibilityActionForItem(view, i2, bundle);
        }
    }
}
