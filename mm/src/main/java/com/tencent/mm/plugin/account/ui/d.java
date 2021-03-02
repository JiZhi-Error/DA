package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class d extends BaseAdapter implements Filterable {
    private List<String> kjY;
    private ArrayList<String> kjZ;
    private a kka;
    private String kkb;
    private Context mContext;
    private final Object mLock = new Object();

    public d(Context context, String[] strArr, String str) {
        AppMethodBeat.i(127871);
        this.mContext = context;
        this.kjY = Arrays.asList(strArr);
        this.kkb = str;
        AppMethodBeat.o(127871);
    }

    public final int getCount() {
        AppMethodBeat.i(127872);
        int size = this.kjY.size();
        AppMethodBeat.o(127872);
        return size;
    }

    private String getItem(int i2) {
        AppMethodBeat.i(127873);
        String str = this.kjY.get(i2);
        AppMethodBeat.o(127873);
        return str;
    }

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        b bVar;
        AppMethodBeat.i(127874);
        if (view == null) {
            view = View.inflate(this.mContext, R.layout.hf, null);
            b bVar2 = new b();
            bVar2.vr = (TextView) view.findViewById(R.id.il1);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        bVar.vr.setText(getItem(i2));
        view.setBackgroundResource(R.drawable.qa);
        AppMethodBeat.o(127874);
        return view;
    }

    public final Filter getFilter() {
        AppMethodBeat.i(127875);
        if (this.kka == null) {
            this.kka = new a(this, (byte) 0);
        }
        a aVar = this.kka;
        AppMethodBeat.o(127875);
        return aVar;
    }

    static class b {
        public TextView vr;

        b() {
        }
    }

    class a extends Filter {
        private a() {
        }

        /* synthetic */ a(d dVar, byte b2) {
            this();
        }

        /* access modifiers changed from: protected */
        public final Filter.FilterResults performFiltering(CharSequence charSequence) {
            String str;
            String[] split;
            AppMethodBeat.i(127869);
            Filter.FilterResults filterResults = new Filter.FilterResults();
            if (d.this.kjZ == null) {
                synchronized (d.this.mLock) {
                    try {
                        d.this.kjZ = new ArrayList(d.this.kjY);
                    } catch (Throwable th) {
                        AppMethodBeat.o(127869);
                        throw th;
                    }
                }
            }
            if (charSequence == null || charSequence.length() == 0) {
                synchronized (d.this.mLock) {
                    try {
                        ArrayList arrayList = new ArrayList(d.this.kjZ);
                        filterResults.values = arrayList;
                        filterResults.count = arrayList.size();
                    } finally {
                        AppMethodBeat.o(127869);
                    }
                }
            } else {
                String lowerCase = charSequence.toString().toLowerCase();
                String str2 = "";
                if (d.this.kkb == null || d.this.kkb.length() <= 0 || (split = lowerCase.split(d.this.kkb)) == null || split.length <= 1) {
                    str = lowerCase;
                } else {
                    str2 = split[0] + d.this.kkb;
                    str = split[1];
                }
                ArrayList arrayList2 = d.this.kjZ;
                int size = arrayList2.size();
                ArrayList arrayList3 = new ArrayList(size);
                for (int i2 = 0; i2 < size; i2++) {
                    String str3 = (String) arrayList2.get(i2);
                    if (str3.toString().toLowerCase().startsWith(str)) {
                        arrayList3.add(str2 + str3);
                    }
                }
                filterResults.values = arrayList3;
                filterResults.count = arrayList3.size();
            }
            return filterResults;
        }

        /* access modifiers changed from: protected */
        public final void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            AppMethodBeat.i(127870);
            d.this.kjY = (List) filterResults.values;
            if (filterResults.count > 0) {
                d.this.notifyDataSetChanged();
                AppMethodBeat.o(127870);
                return;
            }
            d.this.notifyDataSetInvalidated();
            AppMethodBeat.o(127870);
        }
    }
}
