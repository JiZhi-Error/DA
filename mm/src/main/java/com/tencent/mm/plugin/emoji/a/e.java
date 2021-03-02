package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.q;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.c;
import java.util.List;

public final class e extends ArrayAdapter<EmojiGroupInfo> {
    private static final int qXn = R.layout.a2j;
    private final String TAG = "MicroMsg.emoji.EmojiSortAdapter";
    private Context mContext;
    private int qXo;
    public List<EmojiGroupInfo> qXp;

    public e(Context context, List<EmojiGroupInfo> list) {
        super(context, qXn, list);
        AppMethodBeat.i(108316);
        this.qXo = context.getResources().getDimensionPixelSize(R.dimen.a2k);
        this.mContext = context;
        this.qXp = list;
        AppMethodBeat.o(108316);
    }

    public final void cFn() {
        AppMethodBeat.i(108317);
        if (this.qXp == null) {
            AppMethodBeat.o(108317);
            return;
        }
        int size = this.qXp.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.qXp.get(i2).field_idx = i2;
        }
        k.getEmojiStorageMgr().OpO.iY(this.qXp);
        EmojiGroupInfo di = k.getEmojiStorageMgr().OpO.di(new StringBuilder().append(EmojiGroupInfo.VkO).toString(), false);
        di.field_sort = this.qXp.size() + 2;
        k.getEmojiStorageMgr();
        if (!c.gEJ()) {
            c cVar = k.getEmojiStorageMgr().OpO;
            if (di != null) {
                Log.d("MicroMsg.emoji.EmojiGroupInfoStorage", "jacks updateEmojiGroupInfo: packname: %s, lasttime: %d, sort: %d", di.field_packName, Long.valueOf(di.field_lastUseTime), Integer.valueOf(di.field_sort));
                cVar.replace(di);
                cVar.doNotify("event_update_group", 0, Util.getStack().toString());
            }
        }
        AppMethodBeat.o(108317);
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        a aVar;
        AppMethodBeat.i(108318);
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext).inflate(qXn, (ViewGroup) null);
            a aVar2 = new a(view);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        EmojiGroupInfo emojiGroupInfo = (EmojiGroupInfo) getItem(i2);
        if (com.tencent.mm.plugin.emoji.h.a.b(emojiGroupInfo)) {
            aVar.jVO.setText(R.string.bvz);
        } else {
            aVar.jVO.setText(emojiGroupInfo.field_packName);
        }
        if (com.tencent.mm.plugin.emoji.h.a.b(emojiGroupInfo)) {
            aVar.nnL.setImageResource(R.drawable.icon_002_cover);
        } else {
            q.bcV().a(emojiGroupInfo.field_packIconUrl, aVar.nnL, com.tencent.mm.plugin.emoji.e.e.fQ(emojiGroupInfo.field_productID, emojiGroupInfo.field_packIconUrl));
        }
        if (i2 + 1 == getCount()) {
            aVar.qXq.setBackgroundResource(R.drawable.qd);
        }
        view.setVisibility(0);
        AppMethodBeat.o(108318);
        return view;
    }

    class a {
        TextView jVO;
        ImageView nnL;
        View qXq;
        ImageView qXr;

        public a(View view) {
            AppMethodBeat.i(108315);
            this.qXr = (ImageView) view.findViewById(R.id.c1z);
            this.nnL = (ImageView) view.findViewById(R.id.c1x);
            this.jVO = (TextView) view.findViewById(R.id.c1y);
            this.qXq = view.findViewById(R.id.c09);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = e.this.qXo;
                view.setLayoutParams(layoutParams);
            }
            AppMethodBeat.o(108315);
        }
    }
}
