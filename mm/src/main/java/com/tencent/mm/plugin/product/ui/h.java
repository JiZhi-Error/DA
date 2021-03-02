package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class h extends BaseAdapter implements Filterable {
    private List<String> AZp = null;
    private List<String> Bbc = null;
    Filter Bbd = new Filter() {
        /* class com.tencent.mm.plugin.product.ui.h.AnonymousClass1 */

        /* access modifiers changed from: protected */
        public final synchronized void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            AppMethodBeat.i(66989);
            h.this.AZp = (List) filterResults.values;
            h.this.notifyDataSetChanged();
            AppMethodBeat.o(66989);
        }

        /* access modifiers changed from: protected */
        public final Filter.FilterResults performFiltering(CharSequence charSequence) {
            AppMethodBeat.i(66990);
            Filter.FilterResults filterResults = new Filter.FilterResults();
            ArrayList arrayList = new ArrayList();
            for (String str : h.this.Bbc) {
                if (!(str == null || charSequence == null || !str.contains(charSequence))) {
                    arrayList.add(str);
                }
            }
            filterResults.values = arrayList;
            filterResults.count = arrayList.size();
            AppMethodBeat.o(66990);
            return filterResults;
        }
    };
    private Context mContext;

    public h(Context context) {
        AppMethodBeat.i(66991);
        this.mContext = context;
        this.Bbc = com.tencent.mm.plugin.product.a.a.eDb().eDd().AZp;
        AppMethodBeat.o(66991);
    }

    public final int getCount() {
        AppMethodBeat.i(66992);
        if (this.AZp != null) {
            int size = this.AZp.size();
            AppMethodBeat.o(66992);
            return size;
        }
        AppMethodBeat.o(66992);
        return 0;
    }

    private String getItem(int i2) {
        AppMethodBeat.i(66993);
        String str = this.AZp.get(i2);
        AppMethodBeat.o(66993);
        return str;
    }

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        a aVar;
        AppMethodBeat.i(66994);
        if (view == null) {
            a aVar2 = new a();
            view = LayoutInflater.from(this.mContext).inflate(17367043, (ViewGroup) null);
            aVar2.BaI = (TextView) view.findViewById(16908308);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.BaI.setText(getItem(i2));
        AppMethodBeat.o(66994);
        return view;
    }

    public final Filter getFilter() {
        return this.Bbd;
    }

    class a {
        TextView BaI;

        a() {
        }
    }
}
