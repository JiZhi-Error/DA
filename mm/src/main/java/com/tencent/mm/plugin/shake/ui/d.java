package com.tencent.mm.plugin.shake.ui;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.shake.b.f;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.s;
import java.util.GregorianCalendar;

/* access modifiers changed from: package-private */
public final class d extends s<f> {
    int DjM = 20;
    private Context mContext;
    private LayoutInflater mInflater;

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, android.database.Cursor] */
    @Override // com.tencent.mm.ui.s
    public final /* synthetic */ f a(f fVar, Cursor cursor) {
        AppMethodBeat.i(28421);
        f fVar2 = fVar;
        if (fVar2 == null) {
            fVar2 = new f();
        }
        fVar2.convertFrom(cursor);
        AppMethodBeat.o(28421);
        return fVar2;
    }

    public d(Context context) {
        super(context, new f());
        AppMethodBeat.i(28416);
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        AppMethodBeat.o(28416);
    }

    public final void XB(int i2) {
        AppMethodBeat.i(28417);
        ebf();
        this.DjM = i2;
        anp();
        AppMethodBeat.o(28417);
    }

    @Override // com.tencent.mm.ui.s
    public final void anq() {
        AppMethodBeat.i(28418);
        anp();
        AppMethodBeat.o(28418);
    }

    @Override // com.tencent.mm.ui.s
    public final void anp() {
        AppMethodBeat.i(28419);
        setCursor(m.eUn().Xw(this.DjM));
        super.notifyDataSetChanged();
        AppMethodBeat.o(28419);
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        a aVar;
        String quantityString;
        AppMethodBeat.i(28420);
        if (view == null) {
            view = this.mInflater.inflate(R.layout.brq, viewGroup, false);
            aVar = new a();
            aVar.DjN = (MMImageView) view.findViewById(R.id.hnx);
            aVar.mPa = (TextView) view.findViewById(R.id.hnz);
            aVar.jVn = (TextView) view.findViewById(R.id.hnw);
            aVar.yQj = (TextView) view.findViewById(R.id.hny);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        f fVar = (f) getItem(i2);
        e.a(aVar.DjN, fVar.field_thumburl, R.raw.app_attach_file_icon_webpage, false);
        if (Util.isNullOrNil(fVar.field_title)) {
            aVar.mPa.setVisibility(8);
        } else {
            aVar.mPa.setText(l.b(this.mContext, fVar.field_title, aVar.mPa.getTextSize()));
            aVar.mPa.setVisibility(0);
        }
        if (Util.isNullOrNil(fVar.field_desc)) {
            aVar.jVn.setVisibility(8);
        } else {
            aVar.jVn.setText(l.b(this.mContext, fVar.field_desc, aVar.jVn.getTextSize()));
            aVar.jVn.setVisibility(0);
        }
        TextView textView = aVar.yQj;
        Context context = this.mContext;
        long j2 = fVar.field_createtime * 1000;
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        if (j2 < Util.MILLSECONDS_OF_HOUR) {
            quantityString = "";
        } else {
            long timeInMillis = gregorianCalendar.getTimeInMillis();
            if ((timeInMillis - j2) / Util.MILLSECONDS_OF_HOUR == 0) {
                int i3 = (int) ((timeInMillis - j2) / Util.MILLSECONDS_OF_MINUTE);
                if (i3 <= 0) {
                    i3 = 1;
                }
                quantityString = context.getResources().getQuantityString(R.plurals.k, i3, Integer.valueOf(i3));
            } else {
                GregorianCalendar gregorianCalendar2 = new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5));
                long timeInMillis2 = j2 - gregorianCalendar2.getTimeInMillis();
                if (timeInMillis2 <= 0 || timeInMillis2 > Util.MILLSECONDS_OF_DAY) {
                    long timeInMillis3 = (j2 - gregorianCalendar2.getTimeInMillis()) + Util.MILLSECONDS_OF_DAY;
                    if (timeInMillis3 <= 0 || timeInMillis3 > Util.MILLSECONDS_OF_DAY) {
                        int i4 = (int) ((timeInMillis - j2) / Util.MILLSECONDS_OF_DAY);
                        if (i4 <= 0) {
                            i4 = 1;
                        }
                        quantityString = context.getResources().getQuantityString(R.plurals.l, i4, Integer.valueOf(i4));
                    } else {
                        quantityString = context.getString(R.string.dfu);
                    }
                } else {
                    int i5 = (int) ((timeInMillis - j2) / Util.MILLSECONDS_OF_HOUR);
                    if (i5 <= 0) {
                        i5 = 1;
                    }
                    quantityString = context.getResources().getQuantityString(R.plurals.f3143j, i5, Integer.valueOf(i5));
                }
            }
        }
        textView.setText(quantityString);
        AppMethodBeat.o(28420);
        return view;
    }

    class a {
        MMImageView DjN;
        TextView jVn;
        TextView mPa;
        TextView yQj;

        a() {
        }
    }
}
