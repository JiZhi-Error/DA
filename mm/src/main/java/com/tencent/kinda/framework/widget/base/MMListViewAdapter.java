package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.kinda.gen.KListViewCallback;
import com.tencent.kinda.gen.KView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class MMListViewAdapter extends BaseAdapter {
    private static final String TAG = "MicroMsg.MMListViewAdapter";
    private Context mContext;
    private KListViewCallback mListViewCallback;

    public MMListViewAdapter(Context context, KListViewCallback kListViewCallback) {
        this.mContext = context;
        this.mListViewCallback = kListViewCallback;
    }

    public int getCount() {
        AppMethodBeat.i(19282);
        int count = this.mListViewCallback.getCount();
        AppMethodBeat.o(19282);
        return count;
    }

    public int getItemViewType(int i2) {
        AppMethodBeat.i(19283);
        int viewType = this.mListViewCallback.getViewType(i2);
        AppMethodBeat.o(19283);
        return viewType;
    }

    public int getViewTypeCount() {
        AppMethodBeat.i(19284);
        int viewTypeCount = this.mListViewCallback.getViewTypeCount();
        AppMethodBeat.o(19284);
        return viewTypeCount;
    }

    public Object getItem(int i2) {
        return null;
    }

    public long getItemId(int i2) {
        return 0;
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        MMKViewLayout mMKViewLayout;
        MMKViewLayout mMKViewLayout2 = null;
        AppMethodBeat.i(19285);
        Log.i(TAG, "getView %s %s", Integer.valueOf(i2), view);
        if (view != null) {
            mMKViewLayout = (MMKViewLayout) view.getTag();
        } else {
            mMKViewLayout = null;
        }
        KListViewCallback kListViewCallback = this.mListViewCallback;
        if (mMKViewLayout != null) {
            mMKViewLayout2 = mMKViewLayout;
        }
        KView fillData = kListViewCallback.fillData(i2, mMKViewLayout2);
        MMKView mMKView = (MMKView) fillData;
        mMKView.getView().setTag(fillData);
        View view2 = mMKView.getView();
        AppMethodBeat.o(19285);
        return view2;
    }
}
