package com.tencent.mm.plugin.downloader_app.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ipcinvoker.p;
import com.tencent.mm.plugin.downloader_app.a.i;
import com.tencent.mm.plugin.game.commlib.c.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class b extends RecyclerView.a<a> {
    private Context mContext;
    c<i> qMX = new c<>();
    private boolean qMY = true;
    private boolean qMZ = false;
    private boolean qNa = false;
    private boolean qNb = false;
    boolean qNc = false;
    boolean qNd = true;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ void a(a aVar, int i2) {
        int i3;
        int i4;
        boolean z = false;
        AppMethodBeat.i(9060);
        a aVar2 = aVar;
        Log.d("MicroMsg.TaskListAdapter", "onBindViewHolder");
        i iVar = (i) this.qMX.get(i2);
        aVar2.aus.setClickable(this.qMY);
        switch (iVar.type) {
            case 1:
                if (this.qMX.ds(2) == 0) {
                    this.qMZ = false;
                    aVar2.contentView.setVisibility(8);
                    AppMethodBeat.o(9060);
                    return;
                }
                this.qMZ = true;
                aVar2.contentView.setVisibility(0);
                ((TaskHeaderView) aVar2.contentView).a(iVar, false);
                AppMethodBeat.o(9060);
                return;
            case 2:
            case 4:
                ((TaskItemView) aVar2.contentView).setData(iVar);
                AppMethodBeat.o(9060);
                return;
            case 3:
                int ds = this.qMX.ds(4);
                if (ds == 0) {
                    this.qNa = false;
                    aVar2.contentView.setVisibility(8);
                    AppMethodBeat.o(9060);
                    return;
                }
                this.qNa = true;
                aVar2.contentView.setVisibility(0);
                iVar.qLh = ds;
                ((TaskHeaderView) aVar2.contentView).a(iVar, this.qMZ);
                AppMethodBeat.o(9060);
                return;
            case 5:
                if (this.qMX.ds(6) == 0) {
                    this.qNb = false;
                    aVar2.contentView.setVisibility(8);
                    AppMethodBeat.o(9060);
                    return;
                }
                this.qNb = true;
                aVar2.contentView.setVisibility(0);
                TaskHeaderView taskHeaderView = (TaskHeaderView) aVar2.contentView;
                if (this.qMZ || this.qNa) {
                    z = true;
                }
                taskHeaderView.a(iVar, z);
                AppMethodBeat.o(9060);
                return;
            case 6:
                if (this.qNc || i2 < 3 || ((i) this.qMX.get(i2 - 3)).type != 6) {
                    ((TaskItemView) aVar2.contentView).setData(iVar);
                    AppMethodBeat.o(9060);
                    return;
                }
                aVar2.contentView.setVisibility(8);
                AppMethodBeat.o(9060);
                return;
            case 7:
                if (!this.qNc) {
                    if (Util.isNullOrNil(this.qMX)) {
                        i3 = 0;
                    } else {
                        Iterator<E> it = this.qMX.iterator();
                        i3 = 0;
                        while (it.hasNext()) {
                            if (it.next().type == 6) {
                                i4 = i3 + 1;
                            } else {
                                i4 = i3;
                            }
                            i3 = i4;
                        }
                    }
                    if (i3 > 3) {
                        aVar2.contentView.setVisibility(0);
                        AppMethodBeat.o(9060);
                        return;
                    }
                }
                aVar2.contentView.setVisibility(8);
                AppMethodBeat.o(9060);
                return;
            case 8:
                if (this.qNd) {
                    ((BottomEntranceView) aVar2.contentView).setData(iVar.qLj);
                    break;
                } else {
                    aVar2.contentView.setVisibility(8);
                    AppMethodBeat.o(9060);
                    return;
                }
        }
        AppMethodBeat.o(9060);
    }

    public b(Context context) {
        AppMethodBeat.i(9055);
        this.mContext = context;
        AppMethodBeat.o(9055);
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemViewType(int i2) {
        AppMethodBeat.i(9056);
        int i3 = ((i) this.qMX.get(i2)).type;
        AppMethodBeat.o(9056);
        return i3;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(9057);
        int size = this.qMX.size();
        AppMethodBeat.o(9057);
        return size;
    }

    public final void Y(LinkedList<i> linkedList) {
        AppMethodBeat.i(9058);
        if (Util.isNullOrNil(linkedList)) {
            AppMethodBeat.o(9058);
        } else if (linkedList.size() == 1) {
            final int indexOf = this.qMX.indexOf(linkedList.get(0));
            this.qMX.remove(indexOf);
            p.y(new Runnable() {
                /* class com.tencent.mm.plugin.downloader_app.ui.b.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(9052);
                    b.this.ck(indexOf);
                    AppMethodBeat.o(9052);
                }
            });
            AppMethodBeat.o(9058);
        } else {
            this.qMX.removeAll(linkedList);
            p.y(new Runnable() {
                /* class com.tencent.mm.plugin.downloader_app.ui.b.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(9053);
                    b.this.atj.notifyChanged();
                    AppMethodBeat.o(9053);
                }
            });
            AppMethodBeat.o(9058);
        }
    }

    public final boolean cCb() {
        AppMethodBeat.i(9059);
        if (this.qMX.size() <= 5) {
            AppMethodBeat.o(9059);
            return true;
        }
        AppMethodBeat.o(9059);
        return false;
    }

    public static class a extends RecyclerView.v {
        public View contentView;

        public a(View view) {
            super(view);
            AppMethodBeat.i(9054);
            this.contentView = ((ViewGroup) view).getChildAt(0);
            AppMethodBeat.o(9054);
        }
    }

    /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ a a(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(9061);
        Log.d("MicroMsg.TaskListAdapter", "onCreateViewHolder");
        View view = new View(this.mContext);
        switch (i2) {
            case 1:
            case 3:
            case 5:
                view = LayoutInflater.from(this.mContext).inflate(R.layout.a03, viewGroup, false);
                break;
            case 2:
            case 4:
            case 6:
                view = LayoutInflater.from(this.mContext).inflate(R.layout.a05, viewGroup, false);
                break;
            case 7:
                view = LayoutInflater.from(this.mContext).inflate(R.layout.a02, viewGroup, false);
                break;
            case 8:
                view = LayoutInflater.from(this.mContext).inflate(R.layout.a00, viewGroup, false);
                break;
        }
        a aVar = new a(view);
        AppMethodBeat.o(9061);
        return aVar;
    }
}
