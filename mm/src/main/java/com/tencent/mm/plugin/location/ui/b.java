package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.MMGridPaper;
import com.tencent.mm.ui.base.i;
import java.util.ArrayList;
import java.util.Iterator;

public final class b {
    private Context mContext = null;
    private i yHl = null;
    private MMGridPaper yHm = null;
    private a yHn = null;
    private ViewGroup yHo = null;
    private RelativeLayout yHp = null;
    private ArrayList<String> yHq = null;
    private int yHr = 0;

    private b(Context context) {
        AppMethodBeat.i(55799);
        this.mContext = context;
        this.yHl = new i(this.mContext, R.style.a7a);
        this.yHo = (ViewGroup) ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(R.layout.hk, (ViewGroup) null);
        this.yHm = (MMGridPaper) this.yHo.findViewById(R.id.bqt);
        this.yHm.gKH();
        this.yHm.setDialogMode(true);
        this.yHm.gKG();
        this.yHm.setMaxRow(3);
        this.yHm.setMaxCol(3);
        this.yHm.setHeaderView(null);
        this.yHm.gKH();
        this.yHm.setItemWidthInDp(70);
        this.yHm.setItemHeightInDp(70);
        this.yHl.setCanceledOnTouchOutside(true);
        this.yHl.setContentView(this.yHo);
        this.yHn = new a();
        this.yHm.setGridPaperAdapter(this.yHn);
        AppMethodBeat.o(55799);
    }

    public static void d(Context context, ArrayList<String> arrayList) {
        int i2;
        int i3;
        AppMethodBeat.i(55800);
        Log.d("MicroMsg.AvatarsDialog", "showDialog, username.size = %d", Integer.valueOf(arrayList.size()));
        b bVar = new b(context);
        bVar.yHq = new ArrayList<>();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            bVar.yHq.add(it.next());
        }
        if (bVar.yHq.size() < 3) {
            bVar.yHm.setMaxCol(bVar.yHq.size());
        } else {
            bVar.yHm.setMaxCol(3);
        }
        ViewGroup.LayoutParams layoutParams = bVar.yHm.getLayoutParams();
        bVar.yHr = a.fromDPToPix(bVar.mContext, 70);
        int fromDPToPix = a.fromDPToPix(bVar.mContext, 8);
        if (bVar.yHq.size() <= 0) {
            i2 = 0;
        } else if (bVar.yHq.size() < 3) {
            i2 = (fromDPToPix * (bVar.yHq.size() - 1)) + (bVar.yHr * bVar.yHq.size());
        } else {
            i2 = (fromDPToPix * 2) + (bVar.yHr * 3);
        }
        Log.d("MicroMsg.AvatarsDialog", "calculateGridWidth, result = %d, mUsername.size = %d, avatarSize = %d, densityType = %s", Integer.valueOf(i2), Integer.valueOf(bVar.yHq.size()), Integer.valueOf(bVar.yHr), BackwardSupportUtil.BitmapFactory.getDisplayDensityType(bVar.mContext));
        layoutParams.width = i2;
        bVar.yHr = a.fromDPToPix(bVar.mContext, 70);
        int fromDPToPix2 = a.fromDPToPix(bVar.mContext, 15);
        if (bVar.yHq.size() > 0) {
            if (bVar.yHq.size() <= 3) {
                i3 = fromDPToPix2 + bVar.yHr;
            } else if (bVar.yHq.size() <= 6) {
                i3 = fromDPToPix2 + (bVar.yHr * 2);
            } else {
                i3 = (fromDPToPix2 * 2) + (bVar.yHr * 3) + a.fromDPToPix(bVar.mContext, 10);
            }
            Log.d("MicroMsg.AvatarsDialog", "calculateGridHeight, result = %d", Integer.valueOf(i3));
        } else {
            i3 = 0;
        }
        layoutParams.height = i3;
        bVar.yHm.setLayoutParams(layoutParams);
        bVar.yHm.requestLayout();
        bVar.yHn.setData(bVar.yHq);
        bVar.yHl.show();
        AppMethodBeat.o(55800);
    }
}
