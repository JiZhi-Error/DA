package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.kinda.gen.KTableView;
import com.tencent.kinda.gen.KTableViewCellManager;
import com.tencent.kinda.gen.KViewLayout;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aa;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

public class KindaTableViewImpl extends MMKView<ListView> implements KTableView {
    private static final String TAG = "MicroMsg.KindaTableViewImplV2";
    private Adapter mAdapter;
    private ArrayList<KTableViewCellManager> mDataList = new ArrayList<>();
    private boolean mEnableRefresh = false;
    private VoidCallback mLoadMoreCallback;
    private Map<Integer, WeakReference<View>> mViewMap = new HashMap();
    private View refreshFooterView;

    public KindaTableViewImpl() {
        AppMethodBeat.i(214504);
        AppMethodBeat.o(214504);
    }

    @Override // com.tencent.kinda.framework.widget.base.MMKView
    public ListView createView(Context context) {
        AppMethodBeat.i(214505);
        Log.d(TAG, "create view");
        this.view = new ListView(context);
        this.refreshFooterView = aa.jQ(context).inflate(R.layout.ad, (ViewGroup) null);
        this.refreshFooterView.setVisibility(8);
        ((ListView) this.view).addFooterView(this.refreshFooterView, null, false);
        this.mAdapter = new Adapter();
        ((ListView) this.view).setAdapter((ListAdapter) this.mAdapter);
        ((ListView) this.view).setSelector(R.color.ac_);
        ((ListView) this.view).setOnScrollListener(new AbsListView.OnScrollListener() {
            /* class com.tencent.kinda.framework.widget.base.KindaTableViewImpl.AnonymousClass1 */

            public void onScrollStateChanged(AbsListView absListView, int i2) {
            }

            public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                AppMethodBeat.i(214499);
                if (KindaTableViewImpl.this.mEnableRefresh && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getCount() > 0 && KindaTableViewImpl.this.mLoadMoreCallback != null) {
                    KindaTableViewImpl.this.mLoadMoreCallback.call();
                }
                AppMethodBeat.o(214499);
            }
        });
        ListView listView = (ListView) this.view;
        AppMethodBeat.o(214505);
        return listView;
    }

    @Override // com.tencent.kinda.gen.KTableView
    public void setCells(ArrayList<KTableViewCellManager> arrayList) {
        AppMethodBeat.i(214506);
        Log.i(TAG, "set cells: %s", Integer.valueOf(arrayList.size()));
        this.mDataList.clear();
        this.mViewMap.clear();
        this.mDataList.addAll(arrayList);
        if (this.mAdapter != null) {
            this.mAdapter.notifyDataSetChanged();
        }
        AppMethodBeat.o(214506);
    }

    @Override // com.tencent.kinda.gen.KTableView
    public void setEnableFooterRefreshView(boolean z) {
        AppMethodBeat.i(214507);
        this.mEnableRefresh = z;
        if (z) {
            this.refreshFooterView.setVisibility(0);
            AppMethodBeat.o(214507);
            return;
        }
        this.refreshFooterView.setVisibility(8);
        AppMethodBeat.o(214507);
    }

    @Override // com.tencent.kinda.gen.KTableView
    public void setFooterRefreshViewLoadMoreCallbackImpl(VoidCallback voidCallback) {
        AppMethodBeat.i(214508);
        Log.d(TAG, "set footer refresh callback");
        this.mLoadMoreCallback = voidCallback;
        AppMethodBeat.o(214508);
    }

    /* access modifiers changed from: package-private */
    public class Adapter extends BaseAdapter {
        private Adapter() {
        }

        public int getCount() {
            AppMethodBeat.i(214500);
            int size = KindaTableViewImpl.this.mDataList.size();
            AppMethodBeat.o(214500);
            return size;
        }

        public KTableViewCellManager getItem(int i2) {
            AppMethodBeat.i(214501);
            KTableViewCellManager kTableViewCellManager = (KTableViewCellManager) KindaTableViewImpl.this.mDataList.get(i2);
            AppMethodBeat.o(214501);
            return kTableViewCellManager;
        }

        public long getItemId(int i2) {
            return 0;
        }

        public View getView(int i2, View view, ViewGroup viewGroup) {
            AppMethodBeat.i(214502);
            Log.v(KindaTableViewImpl.TAG, "get view for: %s", Integer.valueOf(i2));
            KViewLayout view2 = ((KTableViewCellManager) KindaTableViewImpl.this.mDataList.get(i2)).getView();
            Assert.assertTrue("kViewLayout must be MMKViewLayout!", view2 instanceof MMKViewLayout);
            KindaTableViewImpl.this.mViewMap.put(Integer.valueOf(i2), new WeakReference(((MMKViewLayout) view2).getView()));
            ((MMKViewLayout) view2).getView().setTag("test_position_".concat(String.valueOf(i2)));
            ViewGroup viewGroup2 = (ViewGroup) ((MMKViewLayout) view2).getView();
            if (viewGroup2.getParent() != null) {
                ((ViewGroup) viewGroup2.getParent()).removeView(viewGroup2);
            }
            FrameLayout frameLayout = new FrameLayout(KindaTableViewImpl.this.mContext);
            frameLayout.addView(viewGroup2);
            AppMethodBeat.o(214502);
            return frameLayout;
        }
    }
}
