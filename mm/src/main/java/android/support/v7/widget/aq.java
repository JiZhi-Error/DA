package android.support.v7.widget;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/* access modifiers changed from: package-private */
public final class aq {
    static int a(RecyclerView.s sVar, aj ajVar, View view, View view2, RecyclerView.LayoutManager layoutManager, boolean z, boolean z2) {
        int max;
        if (layoutManager.getChildCount() == 0 || sVar.getItemCount() == 0 || view == null || view2 == null) {
            return 0;
        }
        int min = Math.min(layoutManager.getPosition(view), layoutManager.getPosition(view2));
        int max2 = Math.max(layoutManager.getPosition(view), layoutManager.getPosition(view2));
        if (z2) {
            max = Math.max(0, (sVar.getItemCount() - max2) - 1);
        } else {
            max = Math.max(0, min);
        }
        if (!z) {
            return max;
        }
        return Math.round((((float) max) * (((float) Math.abs(ajVar.bp(view2) - ajVar.bo(view))) / ((float) (Math.abs(layoutManager.getPosition(view) - layoutManager.getPosition(view2)) + 1)))) + ((float) (ajVar.kH() - ajVar.bo(view))));
    }

    static int a(RecyclerView.s sVar, aj ajVar, View view, View view2, RecyclerView.LayoutManager layoutManager, boolean z) {
        if (layoutManager.getChildCount() == 0 || sVar.getItemCount() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(layoutManager.getPosition(view) - layoutManager.getPosition(view2)) + 1;
        }
        return Math.min(ajVar.kJ(), ajVar.bp(view2) - ajVar.bo(view));
    }

    static int b(RecyclerView.s sVar, aj ajVar, View view, View view2, RecyclerView.LayoutManager layoutManager, boolean z) {
        if (layoutManager.getChildCount() == 0 || sVar.getItemCount() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return sVar.getItemCount();
        }
        return (int) ((((float) (ajVar.bp(view2) - ajVar.bo(view))) / ((float) (Math.abs(layoutManager.getPosition(view) - layoutManager.getPosition(view2)) + 1))) * ((float) sVar.getItemCount()));
    }
}
