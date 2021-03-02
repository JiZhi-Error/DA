package com.tencent.mm.plugin.aa.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.aa.model.i;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.m;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ao;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public final class b extends BaseAdapter {
    private Context context;
    List<m> dataList = new ArrayList();
    int mode;

    public b(Context context2, int i2) {
        AppMethodBeat.i(63494);
        this.context = context2;
        this.mode = i2;
        AppMethodBeat.o(63494);
    }

    public final int getCount() {
        AppMethodBeat.i(63495);
        int size = this.dataList.size();
        AppMethodBeat.o(63495);
        return size;
    }

    public final Object getItem(int i2) {
        AppMethodBeat.i(63496);
        m mVar = this.dataList.get(i2);
        AppMethodBeat.o(63496);
        return mVar;
    }

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        AppMethodBeat.i(63497);
        if (view == null) {
            view = aa.jQ(this.context).inflate(R.layout.aa, viewGroup, false);
            view.setTag(new a(view));
        }
        a aVar = (a) view.getTag();
        m mVar = (m) getItem(i2);
        if (!Util.isNullOrNil(mVar.KBt)) {
            a.b.a(aVar.gyr, mVar.KBt, 0.1f, false);
        } else {
            aVar.gyr.setImageResource(R.raw.aa_record_default_icon);
        }
        aVar.titleTv.setText(l.b(this.context, mVar.title, aVar.titleTv.getTextSize()));
        String displayName = ((com.tencent.mm.plugin.messenger.a.b) g.af(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(mVar.KBt);
        if (Util.isNullOrNil(displayName) || displayName.endsWith("@chatroom")) {
            displayName = this.context.getString(R.string.p);
        }
        aVar.jUN.setText(l.b(this.context, displayName, aVar.jUN.getTextSize()));
        if (this.mode == 2) {
            aVar.jUO.setText(mVar.KBI);
        } else {
            aVar.jUO.setText(mVar.KBG);
        }
        String bigDecimal = new BigDecimal(i.o((double) mVar.eht)).setScale(2, 4).toString();
        aVar.jUP.setText(String.format("%s%s", this.context.getString(R.string.b8), bigDecimal));
        ao.a(aVar.jUP.getPaint(), 0.8f);
        aVar.gCd.setVisibility(0);
        if (this.mode != 2) {
            switch (mVar.state) {
                case 1:
                    aVar.gCd.setText(R.string.a9);
                    aVar.gCd.setTextColor(this.context.getResources().getColor(R.color.as));
                    break;
                case 2:
                    aVar.gCd.setText(R.string.a7);
                    aVar.gCd.setTextColor(this.context.getResources().getColor(R.color.Brand));
                    break;
                case 3:
                    aVar.gCd.setText(R.string.a5);
                    aVar.gCd.setTextColor(this.context.getResources().getColor(R.color.Red_100));
                    break;
                case 4:
                    aVar.gCd.setText(R.string.a6);
                    aVar.gCd.setTextColor(this.context.getResources().getColor(R.color.Red_100));
                    break;
                default:
                    aVar.gCd.setVisibility(4);
                    break;
            }
        } else {
            switch (mVar.state) {
                case 1:
                    aVar.gCd.setText(R.string.a_);
                    aVar.gCd.setTextColor(this.context.getResources().getColor(R.color.as));
                    break;
                case 2:
                    aVar.gCd.setText(R.string.a8);
                    aVar.gCd.setTextColor(this.context.getResources().getColor(R.color.as));
                    break;
                default:
                    aVar.gCd.setVisibility(4);
                    break;
            }
        }
        AppMethodBeat.o(63497);
        return view;
    }

    public final void bmv() {
        AppMethodBeat.i(63498);
        this.dataList.clear();
        AppMethodBeat.o(63498);
    }

    class a {
        public TextView gCd;
        public ImageView gyr;
        public TextView jUN;
        public TextView jUO;
        public TextView jUP;
        public TextView titleTv;

        public a(View view) {
            AppMethodBeat.i(63493);
            this.gyr = (ImageView) view.findViewById(R.id.ad);
            this.jUN = (TextView) view.findViewById(R.id.ae);
            this.titleTv = (TextView) view.findViewById(R.id.ai);
            this.jUO = (TextView) view.findViewById(R.id.af);
            this.jUP = (TextView) view.findViewById(R.id.ac);
            this.gCd = (TextView) view.findViewById(R.id.ah);
            AppMethodBeat.o(63493);
        }
    }
}
