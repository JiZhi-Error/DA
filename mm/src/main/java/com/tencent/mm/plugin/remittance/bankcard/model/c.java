package com.tencent.mm.plugin.remittance.bankcard.model;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;

public final class c extends BaseAdapter implements Filterable {
    private List<TransferRecordParcel> Cjk;
    private List<TransferRecordParcel> Cjl = new ArrayList();
    private List<Pair<Integer, Integer>> Cjm = new ArrayList();
    private Filter Cjn;
    private Context mContext;

    public c(Context context, List<TransferRecordParcel> list) {
        AppMethodBeat.i(67412);
        this.mContext = context;
        this.Cjk = list;
        AppMethodBeat.o(67412);
    }

    public final int getCount() {
        AppMethodBeat.i(67413);
        int size = this.Cjl.size();
        AppMethodBeat.o(67413);
        return size;
    }

    public final Object getItem(int i2) {
        AppMethodBeat.i(67414);
        TransferRecordParcel transferRecordParcel = this.Cjl.get(i2);
        AppMethodBeat.o(67414);
        return transferRecordParcel;
    }

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        AppMethodBeat.i(67415);
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(R.layout.ii, viewGroup, false);
            b bVar = new b(this, (byte) 0);
            bVar.Cjq = (CdnImageView) view.findViewById(R.id.adw);
            bVar.Cjr = (TextView) view.findViewById(R.id.ady);
            bVar.Cjs = (TextView) view.findViewById(R.id.adx);
            view.setTag(bVar);
        }
        b bVar2 = (b) view.getTag();
        TransferRecordParcel transferRecordParcel = (TransferRecordParcel) getItem(i2);
        Pair<Integer, Integer> pair = this.Cjm.get(i2);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(this.mContext.getResources().getColor(R.color.a2x));
        SpannableString spannableString = new SpannableString(transferRecordParcel.Cjv);
        spannableString.setSpan(foregroundColorSpan, ((Integer) pair.first).intValue(), ((Integer) pair.second).intValue(), 18);
        bVar2.Cjq.setUrl(transferRecordParcel.CiX);
        bVar2.Cjr.setText(spannableString);
        bVar2.Cjs.setText(this.mContext.getString(R.string.ac4, transferRecordParcel.ynT, transferRecordParcel.Cju));
        AppMethodBeat.o(67415);
        return view;
    }

    public final Filter getFilter() {
        AppMethodBeat.i(67416);
        if (this.Cjn == null) {
            this.Cjn = new a(this, (byte) 0);
        }
        Filter filter = this.Cjn;
        AppMethodBeat.o(67416);
        return filter;
    }

    class b {
        CdnImageView Cjq;
        TextView Cjr;
        TextView Cjs;

        private b() {
        }

        /* synthetic */ b(c cVar, byte b2) {
            this();
        }
    }

    class a extends Filter {
        List<TransferRecordParcel> Cjo;

        private a() {
            AppMethodBeat.i(67409);
            this.Cjo = new ArrayList();
            AppMethodBeat.o(67409);
        }

        /* synthetic */ a(c cVar, byte b2) {
            this();
        }

        /* access modifiers changed from: protected */
        public final Filter.FilterResults performFiltering(CharSequence charSequence) {
            AppMethodBeat.i(67410);
            this.Cjo.clear();
            c.this.Cjm.clear();
            Log.d("MicroMsg.PayeeAutoCompleteAdapter", "input: %s", charSequence);
            for (TransferRecordParcel transferRecordParcel : c.this.Cjk) {
                if (!Util.isNullOrNil(charSequence) && transferRecordParcel.Cjv.contains(charSequence)) {
                    int indexOf = transferRecordParcel.Cjv.indexOf((String) charSequence);
                    int length = charSequence.length() + indexOf;
                    Log.i("MicroMsg.PayeeAutoCompleteAdapter", "match payee: %s, start: %s, end: %s", transferRecordParcel.Cjv, Integer.valueOf(indexOf), Integer.valueOf(length));
                    c.this.Cjm.add(new Pair(Integer.valueOf(indexOf), Integer.valueOf(length)));
                    this.Cjo.add(transferRecordParcel);
                }
            }
            Filter.FilterResults filterResults = new Filter.FilterResults();
            filterResults.count = this.Cjo.size();
            filterResults.values = this.Cjo;
            AppMethodBeat.o(67410);
            return filterResults;
        }

        /* access modifiers changed from: protected */
        public final void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            AppMethodBeat.i(67411);
            c.this.Cjl = (List) filterResults.values;
            Log.i("MicroMsg.PayeeAutoCompleteAdapter", "match count: %d", Integer.valueOf(c.this.Cjl.size()));
            c.this.notifyDataSetChanged();
            AppMethodBeat.o(67411);
        }
    }
}
