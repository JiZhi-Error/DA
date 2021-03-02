package com.tencent.mm.ui.contact;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.v;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.contact.GroupCardSelectUI;
import java.util.List;

public final class m extends BaseAdapter {
    private List<String> PVI;
    private boolean PVJ;
    private Context context;
    private List<as> gxh;

    public m(Context context2, List<as> list, List<String> list2, boolean z) {
        this.gxh = list;
        this.context = context2;
        this.PVJ = z;
        this.PVI = list2;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        GroupCardSelectUI.a aVar;
        AppMethodBeat.i(37848);
        as asVar = this.gxh.get(i2);
        if (view == null) {
            GroupCardSelectUI.a aVar2 = new GroupCardSelectUI.a();
            view = View.inflate(this.context, R.layout.atu, null);
            aVar2.yDA = (TextView) view.findViewById(R.id.dlb);
            aVar2.PVW = (TextView) view.findViewById(R.id.dlc);
            aVar2.keC = (ImageView) view.findViewById(R.id.dla);
            aVar2.BaJ = (CheckBox) view.findViewById(R.id.hhc);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (GroupCardSelectUI.a) view.getTag();
        }
        a.b.c(aVar.keC, asVar.field_username);
        aVar.PVW.setText(l.e(this.context, (CharSequence) aa.getDisplayName(asVar.field_username), com.tencent.mm.cb.a.aG(this.context, R.dimen.is)));
        aVar.yDA.setText("(" + v.Ie(asVar.field_username) + ")");
        if (ab.Iz(asVar.field_username)) {
            Drawable drawable = this.context.getResources().getDrawable(R.raw.open_im_main_logo);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            aVar.PVW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        } else {
            aVar.PVW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        if (this.PVJ) {
            aVar.BaJ.setVisibility(0);
            if (this.PVI.contains(asVar.field_username)) {
                aVar.BaJ.setChecked(true);
            } else {
                aVar.BaJ.setChecked(false);
            }
        }
        AppMethodBeat.o(37848);
        return view;
    }

    public final int getCount() {
        AppMethodBeat.i(37849);
        int size = this.gxh.size();
        AppMethodBeat.o(37849);
        return size;
    }

    public final Object getItem(int i2) {
        AppMethodBeat.i(37850);
        as asVar = this.gxh.get(i2);
        AppMethodBeat.o(37850);
        return asVar;
    }

    public final long getItemId(int i2) {
        return 0;
    }
}
