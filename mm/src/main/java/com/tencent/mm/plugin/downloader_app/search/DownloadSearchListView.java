package com.tencent.mm.plugin.downloader_app.search;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.mm.plugin.downloader.b.a;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DownloadSearchListView extends MRecyclerView {
    Context mContext;
    a qLD;
    List<b> qLE;
    List<b> qLF;
    private a.b qLG = new a.b() {
        /* class com.tencent.mm.plugin.downloader_app.search.DownloadSearchListView.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.downloader.b.a.b
        public final void O(int i2, long j2) {
            com.tencent.mm.plugin.downloader.g.a Cw;
            AppMethodBeat.i(8934);
            if (i2 == 9 && (Cw = d.Cw(j2)) != null) {
                a aVar = DownloadSearchListView.this.qLD;
                String str = Cw.field_appId;
                if (!Util.isNullOrNil(aVar.mDataList) && !Util.isNullOrNil(str)) {
                    Iterator<b> it = aVar.mDataList.iterator();
                    while (it.hasNext()) {
                        b next = it.next();
                        if (next.appId != null && next.appId.equals(str)) {
                            next.state = 2;
                        }
                    }
                    aVar.atj.notifyChanged();
                }
            }
            AppMethodBeat.o(8934);
        }
    };

    public DownloadSearchListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(8935);
        this.mContext = context;
        AppMethodBeat.o(8935);
    }

    public DownloadSearchListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(8936);
        this.mContext = context;
        AppMethodBeat.o(8936);
    }

    @Override // android.support.v7.widget.RecyclerView
    public void onAttachedToWindow() {
        AppMethodBeat.i(8937);
        Log.i("MicroMsg.DownloadSearchListView", "onAttachedToWindow");
        super.onAttachedToWindow();
        a.a(this.qLG);
        AppMethodBeat.o(8937);
    }

    @Override // android.support.v7.widget.RecyclerView
    public void onDetachedFromWindow() {
        AppMethodBeat.i(8938);
        Log.i("MicroMsg.DownloadSearchListView", "onDetachedFromWindow");
        super.onDetachedFromWindow();
        a.b(this.qLG);
        AppMethodBeat.o(8938);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(8939);
        super.onFinishInflate();
        getContext();
        setLayoutManager(new LinearLayoutManager());
        this.qLD = new a(this.mContext, this);
        setAdapter(this.qLD);
        a(new c(getResources()));
        this.qLE = b.eX(this.mContext);
        this.qLF = new ArrayList();
        AppMethodBeat.o(8939);
    }

    public final void alC(String str) {
        AppMethodBeat.i(8940);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(8940);
            return;
        }
        b.au(this.mContext, str);
        this.qLE = b.eX(this.mContext);
        AppMethodBeat.o(8940);
    }

    /* access modifiers changed from: package-private */
    public void setData(List<b> list) {
        AppMethodBeat.i(8941);
        a aVar = this.qLD;
        aVar.mDataList.clear();
        if (!Util.isNullOrNil(list)) {
            aVar.mDataList.addAll(list);
        }
        aVar.atj.notifyChanged();
        AppMethodBeat.o(8941);
    }
}
