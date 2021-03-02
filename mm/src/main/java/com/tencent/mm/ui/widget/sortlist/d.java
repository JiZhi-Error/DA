package com.tencent.mm.ui.widget.sortlist;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.as;
import com.tencent.mm.ui.widget.sortlist.DragSortListView;
import com.tencent.smtt.sdk.WebView;

public class d implements DragSortListView.i {
    private Bitmap QXJ;
    int QXK = WebView.NIGHT_MODE_COLOR;
    private ImageView cIN;
    private ListView mListView;

    public d(ListView listView) {
        this.mListView = listView;
    }

    @Override // com.tencent.mm.ui.widget.sortlist.DragSortListView.i
    public final View apz(int i2) {
        AppMethodBeat.i(159840);
        ListView listView = this.mListView;
        View childAt = listView.getChildAt((listView.getHeaderViewsCount() + i2) - this.mListView.getFirstVisiblePosition());
        if (childAt == null) {
            AppMethodBeat.o(159840);
            return null;
        }
        childAt.setPressed(false);
        childAt.setDrawingCacheEnabled(true);
        this.QXJ = Bitmap.createBitmap(childAt.getDrawingCache());
        childAt.setDrawingCacheEnabled(false);
        if (this.cIN == null) {
            this.cIN = new ImageView(this.mListView.getContext());
        }
        this.cIN.setBackgroundColor(this.QXK);
        this.cIN.setPadding(0, 0, 0, 0);
        this.cIN.setImageBitmap(this.QXJ);
        this.cIN.setLayoutParams(new ViewGroup.LayoutParams(childAt.getWidth(), childAt.getHeight()));
        ImageView imageView = this.cIN;
        AppMethodBeat.o(159840);
        return imageView;
    }

    @Override // com.tencent.mm.ui.widget.sortlist.DragSortListView.i
    public void n(Point point) {
    }

    @Override // com.tencent.mm.ui.widget.sortlist.DragSortListView.i
    public final void hA(View view) {
        AppMethodBeat.i(159841);
        if (view instanceof ImageView) {
            ((ImageView) view).setImageDrawable(null);
        }
        as.i("MicroMsg.SimpleFloatViewManager", "bitmap recycle %s", this.QXJ.toString());
        this.QXJ.recycle();
        this.QXJ = null;
        AppMethodBeat.o(159841);
    }
}
