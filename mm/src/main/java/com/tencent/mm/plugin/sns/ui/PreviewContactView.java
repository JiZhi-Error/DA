package com.tencent.mm.plugin.sns.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressLint({"UseSparseArrays"})
public class PreviewContactView extends LinearLayout {
    private TableLayout EuT;
    private final Map<Integer, View> EuU = new HashMap();
    @SuppressLint({"UseSparseArrays"})
    private final Map<Integer, TableRow> EuV = new HashMap();
    private int EuW = 5;
    private final Context context;
    private List<String> list = new ArrayList();

    static abstract class a {
    }

    public PreviewContactView(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        AppMethodBeat.i(98190);
        this.context = context2;
        this.EuT = (TableLayout) LayoutInflater.from(this.context).inflate(R.layout.bwx, (ViewGroup) this, true).findViewById(R.id.be9);
        AppMethodBeat.o(98190);
    }

    public void setLineNum(int i2) {
        AppMethodBeat.i(98191);
        this.EuW = i2;
        setList(this.list);
        AppMethodBeat.o(98191);
    }

    public void setImageClick(a aVar) {
    }

    public void setList(List<String> list2) {
        TableRow tableRow;
        AppMethodBeat.i(98192);
        if (list2 == null) {
            AppMethodBeat.o(98192);
            return;
        }
        this.list = list2;
        this.EuT.removeAllViews();
        if (list2.size() == 0) {
            AppMethodBeat.o(98192);
            return;
        }
        int size = list2.size();
        int i2 = 0;
        int i3 = 0;
        while (i3 < size) {
            TableRow tableRow2 = this.EuV.get(Integer.valueOf(i2));
            if (tableRow2 == null) {
                TableRow tableRow3 = new TableRow(this.context);
                this.EuV.put(Integer.valueOf(i2), tableRow3);
                tableRow = tableRow3;
            } else {
                tableRow = tableRow2;
            }
            tableRow.removeAllViews();
            for (int i4 = 0; i4 < this.EuW && i3 < size; i4++) {
                View view = this.EuU.get(Integer.valueOf(i3));
                if (view == null) {
                    view = View.inflate(this.context, R.layout.bww, null);
                    this.EuU.put(Integer.valueOf(i3), view);
                }
                ImageView imageView = (ImageView) view.findViewById(R.id.e44);
                imageView.setBackgroundDrawable(null);
                a.b.c(imageView, list2.get(i3));
                view.setTag(0);
                view.setClickable(false);
                tableRow.addView(view);
                i3++;
            }
            this.EuT.addView(tableRow);
            i2++;
            i3 = i3;
        }
        AppMethodBeat.o(98192);
    }
}
