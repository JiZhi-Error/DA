package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.kinda.gen.KListView;
import com.tencent.kinda.gen.KListViewCallback;
import com.tencent.kinda.gen.KListViewOnScrollCallback;
import com.tencent.kinda.gen.KView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MMKListView extends MMKView<ListView> implements KListView {
    private MMListViewAdapter adapter;
    private KListViewCallback mListViewCallback;

    @Override // com.tencent.kinda.framework.widget.base.MMKView
    public ListView createView(Context context) {
        AppMethodBeat.i(19080);
        ListView listView = new ListView(context);
        AppMethodBeat.o(19080);
        return listView;
    }

    private void binding() {
        AppMethodBeat.i(19081);
        this.adapter = new MMListViewAdapter(this.mContext, this.mListViewCallback);
        ((ListView) getView()).setAdapter((ListAdapter) this.adapter);
        AppMethodBeat.o(19081);
    }

    @Override // com.tencent.kinda.gen.KListView
    public void addHeader(KView kView) {
    }

    @Override // com.tencent.kinda.gen.KListView
    public void addFooter(KView kView) {
    }

    @Override // com.tencent.kinda.gen.KListView
    public void setImpl(KListViewCallback kListViewCallback) {
        AppMethodBeat.i(19082);
        this.mListViewCallback = kListViewCallback;
        binding();
        AppMethodBeat.o(19082);
    }

    @Override // com.tencent.kinda.gen.KListView
    public void setVertical(boolean z) {
    }

    @Override // com.tencent.kinda.gen.KListView
    public boolean getVertical() {
        return false;
    }

    @Override // com.tencent.kinda.gen.KListView
    public void setShowScrollBar(boolean z) {
    }

    @Override // com.tencent.kinda.gen.KListView
    public boolean getShowScrollBar() {
        return false;
    }

    @Override // com.tencent.kinda.gen.KListView
    public void setOnScrollCallback(KListViewOnScrollCallback kListViewOnScrollCallback) {
    }
}
