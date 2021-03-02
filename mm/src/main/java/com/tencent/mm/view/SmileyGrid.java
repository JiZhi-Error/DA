package com.tencent.mm.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.widget.Adapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.j;

public class SmileyGrid extends GridView {
    public static int RmN = 1;
    public ListAdapter GO;
    private j Knu;
    private int RmO = 20;
    public int RmP = 0;
    private int RmQ = 0;
    private ChatFooterPanel.a RmR;
    private int mScene = ChatFooterPanel.KbB;

    @Override // android.widget.GridView, android.widget.AbsListView, android.widget.AdapterView
    public /* bridge */ /* synthetic */ void setAdapter(Adapter adapter) {
        AppMethodBeat.i(105181);
        setAdapter((ListAdapter) adapter);
        AppMethodBeat.o(105181);
    }

    public void setCallback(j jVar) {
        this.Knu = jVar;
    }

    public SmileyGrid(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(105175);
        AppMethodBeat.o(105175);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(105176);
        super.onSizeChanged(i2, i3, i4, i5);
        AppMethodBeat.o(105176);
    }

    /* access modifiers changed from: protected */
    @TargetApi(8)
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(105177);
        super.onConfigurationChanged(configuration);
        AppMethodBeat.o(105177);
    }

    @Override // android.widget.GridView, android.widget.AbsListView
    public void setAdapter(ListAdapter listAdapter) {
        AppMethodBeat.i(105180);
        super.setAdapter(listAdapter);
        this.GO = listAdapter;
        AppMethodBeat.o(105180);
    }

    public void setOnTextOperationListener(ChatFooterPanel.a aVar) {
        this.RmR = aVar;
    }

    public int getSmileyType() {
        return this.RmO;
    }

    public void setScene(int i2) {
        this.mScene = i2;
    }
}
