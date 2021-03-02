package com.tencent.mm.plugin.sns.lucky.ui;

import android.content.Context;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.l.a;
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.i.e;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.protocal.protobuf.cbd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.wallet_core.ui.f;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public final class b extends BaseAdapter {
    private final String TAG = "SnsLuckyMoneyReceivedRecordListAdapter";
    private Context mContext;
    private LayoutInflater mInflater;
    List<a.C1455a> yQe = new ArrayList();
    private int yQh = 1;

    public final /* synthetic */ Object getItem(int i2) {
        AppMethodBeat.i(68366);
        a.C1455a Yq = Yq(i2);
        AppMethodBeat.o(68366);
        return Yq;
    }

    public b(Context context) {
        AppMethodBeat.i(68362);
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        AppMethodBeat.o(68362);
    }

    public final int getCount() {
        AppMethodBeat.i(68363);
        int size = this.yQe.size();
        AppMethodBeat.o(68363);
        return size;
    }

    private a.C1455a Yq(int i2) {
        AppMethodBeat.i(68364);
        a.C1455a aVar = this.yQe.get(i2);
        AppMethodBeat.o(68364);
        return aVar;
    }

    public final long getItemId(int i2) {
        return 0;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        a aVar;
        String charSequence;
        AppMethodBeat.i(68365);
        if (view == null) {
            view = this.mInflater.inflate(R.layout.bw_, viewGroup, false);
            aVar = new a();
            aVar.qyu = (ImageView) view.findViewById(R.id.f4j);
            aVar.rMV = (TextView) view.findViewById(R.id.f4n);
            aVar.yQj = (TextView) view.findViewById(R.id.f4o);
            aVar.yQk = (TextView) view.findViewById(R.id.f4h);
            aVar.yQo = (TextView) view.findViewById(R.id.f4l);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        a.C1455a Yq = Yq(i2);
        g.aAi();
        as Kn = ((l) g.af(l.class)).aSN().Kn(Yq.mRa);
        if (Yq.mRa != null) {
            a.b.d(aVar.qyu, Yq.mRa);
        } else {
            Log.e("SnsLuckyMoneyReceivedRecordListAdapter", "the contact is null,by username:%s", Yq.mRa);
        }
        TextView textView = aVar.yQj;
        Context context = this.mContext;
        long j2 = ((long) Yq.yOR) * 1000;
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        if (j2 < Util.MILLSECONDS_OF_HOUR) {
            charSequence = "";
        } else {
            long timeInMillis = j2 - new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5)).getTimeInMillis();
            if (timeInMillis <= 0 || timeInMillis > Util.MILLSECONDS_OF_DAY) {
                Time time = new Time();
                time.set(j2);
                charSequence = e.a(context.getString(R.string.dee, " "), time).toString();
            } else {
                charSequence = new SimpleDateFormat("HH:mm").format(new Date(j2));
            }
        }
        textView.setText(charSequence);
        aVar.yQj.setVisibility(0);
        if (Kn != null) {
            af.a(this.mContext, aVar.rMV, Kn.arJ());
        } else {
            Log.e("SnsLuckyMoneyReceivedRecordListAdapter", "the contact is null,by username:%s", Yq.mRa);
        }
        cbd cbd = new cbd();
        try {
            if (Yq.yOS == null || Yq.yOS.getILen() <= 0) {
                aVar.yQk.setVisibility(8);
                aVar.yQo.setVisibility(0);
                AppMethodBeat.o(68365);
                return view;
            }
            cbd.parseFrom(z.a(Yq.yOS));
            if (cbd.eht > 0) {
                aVar.yQk.setText(this.mContext.getString(R.string.eri, f.formatMoney2f(((double) cbd.eht) / 100.0d)));
                aVar.yQo.setVisibility(8);
            } else {
                aVar.yQk.setVisibility(8);
                aVar.yQo.setVisibility(0);
            }
            AppMethodBeat.o(68365);
            return view;
        } catch (Exception e2) {
            Log.e("SnsLuckyMoneyReceivedRecordListAdapter", e2.getMessage() + "hbBuffer is error");
            aVar.yQk.setVisibility(8);
            aVar.yQo.setVisibility(8);
            aVar.qyu.setVisibility(8);
            aVar.rMV.setVisibility(8);
            aVar.yQj.setVisibility(8);
        }
    }

    class a {
        ImageView qyu;
        TextView rMV;
        TextView yQj;
        TextView yQk;
        TextView yQo;

        a() {
        }
    }
}
