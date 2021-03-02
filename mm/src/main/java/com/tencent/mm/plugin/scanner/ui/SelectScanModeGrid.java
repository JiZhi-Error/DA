package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;

public class SelectScanModeGrid extends GridView {
    public SelectScanModeGrid(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SelectScanModeGrid(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public static class b {
        public int COg;
        public int COh;
        public int COi;
        public TextView COj;
        public boolean COk;
        public String title;

        public b(String str, int i2, int i3, int i4, boolean z) {
            this.title = str;
            this.COg = i2;
            this.COh = i3;
            this.COi = i4;
            this.COk = z;
        }
    }

    public static class a extends BaseAdapter {
        int COe = -1;
        private Context context;
        private List<b> jzm;

        public a(Context context2, List<b> list) {
            AppMethodBeat.i(51981);
            this.context = context2;
            this.jzm = list;
            Log.d("MicroMsg.scanner.SelectScanModeGroupAdapter", "<init> list size = " + this.jzm.size());
            AppMethodBeat.o(51981);
        }

        public final int getCount() {
            AppMethodBeat.i(51982);
            int size = this.jzm.size();
            AppMethodBeat.o(51982);
            return size;
        }

        public final Object getItem(int i2) {
            AppMethodBeat.i(51983);
            if (i2 < 0 || i2 >= this.jzm.size()) {
                Log.e("MicroMsg.scanner.SelectScanModeGroupAdapter", "getItem fail, invalid position = ".concat(String.valueOf(i2)));
                AppMethodBeat.o(51983);
                return null;
            }
            b bVar = this.jzm.get(i2);
            AppMethodBeat.o(51983);
            return bVar;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            C1676a aVar;
            AppMethodBeat.i(51984);
            if (view == null) {
                view = View.inflate(this.context, R.layout.bpx, null);
                aVar = new C1676a();
                aVar.COf = (TextView) view.findViewById(R.id.him);
                aVar.BaI = (TextView) view.findViewById(R.id.hir);
                aVar.xXF = (ImageView) view.findViewById(R.id.hiq);
                view.setTag(aVar);
            } else {
                aVar = (C1676a) view.getTag();
            }
            if (i2 == viewGroup.getChildCount()) {
                b bVar = (b) getItem(i2);
                if (bVar == null) {
                    Log.e("MicroMsg.scanner.SelectScanModeGroupAdapter", "getView fail, item is null");
                    AppMethodBeat.o(51984);
                    return view;
                }
                aVar.BaI.setText(bVar.title);
                if (i2 == this.COe) {
                    aVar.COf.setBackgroundResource(bVar.COh);
                } else {
                    aVar.COf.setBackgroundResource(bVar.COg);
                }
                bVar.COj = aVar.COf;
                if (bVar.COk) {
                    aVar.xXF.setVisibility(0);
                } else {
                    aVar.xXF.setVisibility(4);
                }
            }
            AppMethodBeat.o(51984);
            return view;
        }

        /* renamed from: com.tencent.mm.plugin.scanner.ui.SelectScanModeGrid$a$a  reason: collision with other inner class name */
        static class C1676a {
            public TextView BaI;
            public TextView COf;
            public ImageView xXF;

            C1676a() {
            }
        }
    }
}
