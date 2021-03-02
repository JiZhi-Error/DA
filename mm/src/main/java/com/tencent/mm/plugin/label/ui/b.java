package com.tencent.mm.plugin.label.ui;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMTextView;
import java.util.ArrayList;

public final class b extends BaseAdapter {
    String kcy;
    private Context mContext;
    ArrayList<String> yCY = new ArrayList<>();
    SparseArray<SpannableString> yCZ = new SparseArray<>();

    public b(Context context) {
        AppMethodBeat.i(26275);
        this.mContext = context;
        AppMethodBeat.o(26275);
    }

    public final int getCount() {
        AppMethodBeat.i(26276);
        if (this.yCY == null) {
            AppMethodBeat.o(26276);
            return 0;
        }
        int size = this.yCY.size();
        AppMethodBeat.o(26276);
        return size;
    }

    public final String getItem(int i2) {
        AppMethodBeat.i(26277);
        if (this.yCY == null || i2 >= getCount()) {
            AppMethodBeat.o(26277);
            return null;
        }
        String str = this.yCY.get(i2);
        AppMethodBeat.o(26277);
        return str;
    }

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        c cVar;
        AppMethodBeat.i(26278);
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext).inflate(R.layout.xy, viewGroup, false);
            cVar = new c(view);
            view.setTag(cVar);
        } else {
            cVar = (c) view.getTag();
        }
        MMTextView mMTextView = cVar.yDz;
        String nullAs = Util.nullAs(getItem(i2), "");
        int textSize = (int) cVar.yDz.getTextSize();
        int hashCode = nullAs.hashCode();
        SpannableString spannableString = this.yCZ.get(hashCode);
        if (spannableString == null) {
            spannableString = new SpannableString(l.e(this.mContext, (CharSequence) nullAs, textSize));
            int indexOf = nullAs.indexOf(this.kcy);
            if (indexOf == -1) {
                Log.w("MicroMsg.Label.ContactLabelSearchAdapter", "hight light %s error.", nullAs);
            } else {
                int length = this.kcy.length() + indexOf;
                spannableString.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(R.color.afp)), indexOf, length, 33);
                spannableString.setSpan(new StyleSpan(1), indexOf, length, 33);
                this.yCZ.put(hashCode, spannableString);
            }
        }
        mMTextView.setText(spannableString);
        AppMethodBeat.o(26278);
        return view;
    }
}
