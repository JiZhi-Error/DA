package com.tencent.mm.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.compatible.util.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Iterator;
import java.util.List;

public abstract class BasePanelKeybordLayout extends KeyboardLinearLayout {
    private int KmP = -1;
    private a Oys = null;

    public interface a {
    }

    /* access modifiers changed from: protected */
    public abstract List<View> getPanelView();

    public BasePanelKeybordLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BasePanelKeybordLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public void setOnMeasureListener(a aVar) {
        this.Oys = aVar;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        List<View> panelView;
        View next;
        ViewGroup.LayoutParams layoutParams;
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        Log.d("MicroMsg.BasePanelKeybordLayout", "onMeasure, width: %d, height: %d", Integer.valueOf(size), Integer.valueOf(size2));
        if (size2 >= 0) {
            if (this.KmP < 0) {
                this.KmP = size2;
            } else {
                int i4 = this.KmP - size2;
                this.KmP = size2;
                if (!(i4 == 0 || (panelView = getPanelView()) == null)) {
                    Iterator<View> it = panelView.iterator();
                    while (it.hasNext() && (layoutParams = (next = it.next()).getLayoutParams()) != null) {
                        int i5 = layoutParams.height < 0 ? 0 : layoutParams.height - i4;
                        if (i5 < 0) {
                            i5 = 0;
                        }
                        int keyBordHeightPx = i.getKeyBordHeightPx(MMApplicationContext.getContext(), true);
                        int validPanelHeight = i.getValidPanelHeight(getContext());
                        if (i.apt() > 0 && size2 >= i.apt()) {
                            i5 = validPanelHeight;
                        }
                        if (i5 > 0 && i5 < keyBordHeightPx && next.getVisibility() != 0) {
                            i5 = 0;
                        }
                        if (i5 > validPanelHeight) {
                            i5 = validPanelHeight;
                        }
                        if (i5 > 0 && i5 < validPanelHeight) {
                            i5 = validPanelHeight;
                        }
                        Log.d("MicroMsg.BasePanelKeybordLayout", "oldHeight: %d, offset: %d newHeight: %d, validPanelHeight: %d", Integer.valueOf(layoutParams.height), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(validPanelHeight));
                        layoutParams.height = i5;
                        next.setLayoutParams(layoutParams);
                    }
                }
            }
        }
        super.onMeasure(i2, i3);
    }
}
