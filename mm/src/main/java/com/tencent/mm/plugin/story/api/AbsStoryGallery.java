package com.tencent.mm.plugin.story.api;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.mm.ui.widget.listview.PullDownListView;

public abstract class AbsStoryGallery extends RelativeLayout {
    public abstract void UE(int i2);

    public abstract void a(PullDownListView pullDownListView);

    public abstract void aaB(int i2);

    public abstract void aaC(int i2);

    public abstract void ar(boolean z, boolean z2);

    public abstract void fmO();

    public abstract void fmP();

    public abstract void fmQ();

    public abstract void fmR();

    public abstract void fmS();

    public abstract boolean onBackPressed();

    public abstract void onDestroy();

    public abstract void onPause();

    public abstract void onResume();

    public abstract void onStart();

    public abstract void onStop();

    public abstract void setCurrentHItem(int i2);

    public abstract void setCurrentVItem(int i2);

    public abstract void setDataSeed(Object obj);

    public abstract void setStoryBrowseUIListener(g gVar);

    public abstract void vI(boolean z);

    public AbsStoryGallery(Context context) {
        super(context);
    }

    public AbsStoryGallery(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AbsStoryGallery(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
