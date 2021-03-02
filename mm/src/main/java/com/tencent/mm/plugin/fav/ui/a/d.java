package com.tencent.mm.plugin.fav.ui.a;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.List;

public abstract class d extends BaseAdapter implements View.OnClickListener {
    private Context context;
    public String qLO;
    public List<String> thB = new LinkedList();
    public SparseArray<SpannableString> thC = new SparseArray<>();

    /* access modifiers changed from: protected */
    public abstract void anW(String str);

    public d(Context context2) {
        this.context = context2;
    }

    public int getCount() {
        return this.thB.size();
    }

    /* access modifiers changed from: private */
    public String getItem(int i2) {
        return this.thB.get(i2);
    }

    public long getItemId(int i2) {
        return (long) i2;
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = View.inflate(this.context, R.layout.a84, null);
            view.setOnClickListener(this);
        }
        TextView textView = (TextView) view.findViewById(R.id.hea);
        String nullAs = Util.nullAs(getItem(i2), "");
        int textSize = (int) textView.getTextSize();
        int hashCode = nullAs.hashCode();
        SpannableString spannableString = this.thC.get(hashCode);
        if (spannableString == null) {
            spannableString = new SpannableString(l.e(this.context, (CharSequence) nullAs, textSize));
            int indexOf = nullAs.indexOf(this.qLO);
            if (-1 == indexOf) {
                Log.w("MicroMsg.FavoriteTagSearchAdapter", "high light %s error", nullAs);
            } else {
                int length = this.qLO.length() + indexOf;
                spannableString.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(R.color.afp)), indexOf, length, 33);
                spannableString.setSpan(new StyleSpan(1), indexOf, length, 33);
                this.thC.put(hashCode, spannableString);
            }
        }
        textView.setText(spannableString);
        return view;
    }

    public void onClick(View view) {
        b bVar = new b();
        bVar.bm(view);
        a.b("com/tencent/mm/plugin/fav/ui/adapter/FavoriteTagSearchAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        String charSequence = ((TextView) view.findViewById(R.id.hea)).getText().toString();
        Log.d("MicroMsg.FavoriteTagSearchAdapter", "select search tag %s", charSequence);
        anW(charSequence);
        a.a(this, "com/tencent/mm/plugin/fav/ui/adapter/FavoriteTagSearchAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    }
}
