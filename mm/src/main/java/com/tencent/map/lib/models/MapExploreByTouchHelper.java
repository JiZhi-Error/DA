package com.tencent.map.lib.models;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.view.a;
import android.support.v4.view.a.c;
import android.support.v4.view.u;
import android.support.v4.widget.j;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.List;

public abstract class MapExploreByTouchHelper extends j {
    protected static final int MAP_ACTION_CLICKED = 1;
    protected static final int NO_ITEM = -1;
    protected List<AccessibleTouchItem> accessibleTouchItems = new ArrayList();

    /* access modifiers changed from: protected */
    public abstract int getTargetPoiItemIdx(float f2, float f3);

    /* access modifiers changed from: protected */
    public abstract boolean onItemClicked(int i2);

    public MapExploreByTouchHelper(View view) {
        super(view);
    }

    @Override // android.support.v4.widget.j
    public int getVirtualViewAt(float f2, float f3) {
        int targetPoiItemIdx = getTargetPoiItemIdx(f2, f3);
        if (targetPoiItemIdx == -1) {
            return Integer.MIN_VALUE;
        }
        return targetPoiItemIdx;
    }

    @Override // android.support.v4.widget.j
    public void getVisibleVirtualViews(List<Integer> list) {
        for (int i2 = 0; i2 < this.accessibleTouchItems.size(); i2++) {
            list.add(Integer.valueOf(i2));
        }
    }

    @Override // android.support.v4.widget.j
    public void onPopulateEventForVirtualView(int i2, AccessibilityEvent accessibilityEvent) {
        if (i2 >= this.accessibleTouchItems.size()) {
            accessibilityEvent.getText().add("");
            return;
        }
        AccessibleTouchItem accessibleTouchItem = this.accessibleTouchItems.get(i2);
        if (accessibleTouchItem == null) {
            throw new IllegalArgumentException("Invalid virtual view id");
        }
        accessibilityEvent.getText().add(accessibleTouchItem.getContentDescription());
    }

    @Override // android.support.v4.widget.j
    public void onPopulateNodeForVirtualView(int i2, c cVar) {
        if (i2 >= this.accessibleTouchItems.size()) {
            cVar.setText("");
            cVar.setBoundsInParent(new Rect());
            return;
        }
        AccessibleTouchItem accessibleTouchItem = this.accessibleTouchItems.get(i2);
        if (accessibleTouchItem == null) {
            throw new IllegalArgumentException("Invalid virtual view id");
        }
        cVar.setText(accessibleTouchItem.getContentDescription());
        cVar.setBoundsInParent(accessibleTouchItem.getBounds());
        cVar.addAction(16);
    }

    @Override // android.support.v4.widget.j
    public boolean onPerformActionForVirtualView(int i2, int i3, Bundle bundle) {
        if (i3 == 16) {
            return onItemClicked(i2);
        }
        return false;
    }

    public void onTalkBackActivate(View view) {
        u.a(view, this);
    }

    public void onTalkBackDeActivate(View view) {
        u.a(view, (a) null);
    }
}
