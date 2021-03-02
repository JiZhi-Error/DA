package com.tencent.mm.ui.tools;

import android.view.View;
import android.widget.TextView;
import com.tencent.mm.ui.tools.ActionBarSearchView;
import com.tencent.mm.ui.tools.SearchViewNotRealTimeHelper;
import java.util.ArrayList;

public interface d {
    void CG(boolean z);

    void CH(boolean z);

    void gXo();

    boolean gXp();

    boolean gXq();

    String getSearchContent();

    void setAutoMatchKeywords(boolean z);

    void setBackClickCallback(ActionBarSearchView.a aVar);

    void setCallBack(ActionBarSearchView.b bVar);

    void setEditTextEnabled(boolean z);

    void setFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener);

    void setHint(CharSequence charSequence);

    void setKeywords(ArrayList<String> arrayList);

    void setNotRealCallBack(SearchViewNotRealTimeHelper.a aVar);

    void setOnEditorActionListener(TextView.OnEditorActionListener onEditorActionListener);

    void setSearchContent(String str);

    void setSearchTipIcon(int i2);

    void setSelectedTag(String str);

    void setStatusBtnEnabled(boolean z);
}
