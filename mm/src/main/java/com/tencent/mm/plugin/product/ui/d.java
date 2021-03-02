package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import java.util.List;

public final class d {

    static class a extends BaseAdapter {
        int BaH = -1;
        List<String> aKs;
        private final Context context;
        private final int style;

        public a(Context context2) {
            this.context = context2;
            this.style = 1;
        }

        public final int getCount() {
            AppMethodBeat.i(66957);
            if (this.aKs != null) {
                int size = this.aKs.size();
                AppMethodBeat.o(66957);
                return size;
            }
            AppMethodBeat.o(66957);
            return 0;
        }

        public final Object getItem(int i2) {
            return null;
        }

        public final long getItemId(int i2) {
            return 0;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            boolean z = true;
            AppMethodBeat.i(66958);
            if (view == null) {
                view = View.inflate(this.context, R.layout.b9x, null);
                b bVar = new b();
                bVar.BaI = (TextView) view.findViewById(R.id.ijq);
                bVar.BaJ = (CheckBox) view.findViewById(R.id.azg);
                bVar.BaK = (RadioButton) view.findViewById(R.id.gqn);
                view.setTag(bVar);
            }
            b bVar2 = (b) view.getTag();
            bVar2.BaI.setText(this.aKs.get(i2));
            switch (this.style) {
                case 1:
                    bVar2.BaJ.setVisibility(8);
                    bVar2.BaK.setVisibility(0);
                    bVar2.BaK.setChecked(i2 == this.BaH);
                    break;
                case 2:
                    bVar2.BaJ.setVisibility(0);
                    bVar2.BaK.setVisibility(8);
                    CheckBox checkBox = bVar2.BaJ;
                    if (i2 != this.BaH) {
                        z = false;
                    }
                    checkBox.setChecked(z);
                    break;
                default:
                    bVar2.BaJ.setVisibility(8);
                    bVar2.BaK.setVisibility(8);
                    break;
            }
            AppMethodBeat.o(66958);
            return view;
        }
    }

    static class b {
        TextView BaI;
        CheckBox BaJ;
        RadioButton BaK;

        b() {
        }
    }
}
