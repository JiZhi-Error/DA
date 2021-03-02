package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.q;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.plugin.emoji.e.k;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreVpHeader;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.emoji.StoreBannerEmojiView;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.z;
import java.util.ArrayList;
import java.util.LinkedList;

public final class i extends z implements View.OnClickListener {
    public static int qXO = 60;
    private Context mContext;
    public LinkedList<com.tencent.mm.plugin.emoji.model.a> qXN;
    private int qXP = 0;
    private boolean qXQ = false;
    private ArrayList<String> qXR = new ArrayList<>();
    private a qXS = new a((byte) 0);

    public i(Context context, LinkedList<com.tencent.mm.plugin.emoji.model.a> linkedList) {
        AppMethodBeat.i(108342);
        if (linkedList == null) {
            IllegalAccessError illegalAccessError = new IllegalAccessError("must has emoji banner list");
            AppMethodBeat.o(108342);
            throw illegalAccessError;
        }
        this.mContext = context;
        this.qXN = new LinkedList<>();
        this.qXN.addAll(linkedList);
        this.qXS.qXT = this;
        AppMethodBeat.o(108342);
    }

    @Override // android.support.v4.view.q
    public final int getCount() {
        AppMethodBeat.i(108343);
        if (this.qXN == null) {
            AppMethodBeat.o(108343);
            return 0;
        } else if (this.qXN.size() == 1) {
            AppMethodBeat.o(108343);
            return 1;
        } else {
            int size = this.qXN.size() * qXO;
            AppMethodBeat.o(108343);
            return size;
        }
    }

    @Override // android.support.v4.view.q, com.tencent.mm.ui.base.z
    public final void notifyDataSetChanged() {
        AppMethodBeat.i(108344);
        if (!this.qXQ) {
            this.qXP = getCount();
            super.notifyDataSetChanged();
            AppMethodBeat.o(108344);
            return;
        }
        Log.i("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "has destroy need to notify");
        AppMethodBeat.o(108344);
    }

    @Override // android.support.v4.view.q
    public final int getItemPosition(Object obj) {
        AppMethodBeat.i(108345);
        if (this.qXP > 0) {
            this.qXP--;
            AppMethodBeat.o(108345);
            return -2;
        }
        int itemPosition = super.getItemPosition(obj);
        AppMethodBeat.o(108345);
        return itemPosition;
    }

    class b {
        StoreBannerEmojiView qXV;
        ImageView qXW;

        public b(View view) {
            AppMethodBeat.i(108341);
            this.qXV = (StoreBannerEmojiView) view.findViewById(R.id.byw);
            this.qXW = (ImageView) view.findViewById(R.id.fxj);
            this.qXV.setDefaultImageResource(0);
            AppMethodBeat.o(108341);
        }
    }

    @Override // com.tencent.mm.ui.base.z
    public final View e(int i2, View view) {
        b bVar;
        String str;
        String str2;
        AppMethodBeat.i(176178);
        if (this.qXN == null) {
            AppMethodBeat.o(176178);
            return null;
        }
        int size = i2 % this.qXN.size();
        if (view == null) {
            Log.i("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "getView inflate");
            view = View.inflate(this.mContext, R.layout.a3m, null);
            b bVar2 = new b(view);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            b bVar3 = (b) view.getTag();
            int i3 = EmojiStoreVpHeader.getScreenWH(this.mContext)[0];
            bVar3.qXV.setLayoutParams(new RelativeLayout.LayoutParams(i3, ((i3 * 3) / 8) + 1));
            bVar = bVar3;
        }
        view.setTag(R.id.c03, Integer.valueOf(size));
        view.setOnClickListener(this);
        com.tencent.mm.plugin.emoji.model.a aVar = this.qXN.get(size);
        if (aVar == null) {
            Log.e("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "BaseEmotionBanner is null.");
            AppMethodBeat.o(176178);
            return null;
        }
        if (aVar.raX) {
            str = aVar.raV.BannerImg.StripUrl;
            if (Util.isNullOrNil(aVar.raV.LocateUrl)) {
                str2 = "H5";
            } else {
                str2 = "Toptic";
            }
        } else {
            str = aVar.raW.BannerImg.StripUrl;
            str2 = aVar.raW.BannerSummary.ProductID;
        }
        if (aVar != null && !Util.isNullOrNil(str)) {
            com.tencent.mm.cb.a.getDensity(this.mContext);
            EmojiInfo H = EmojiLogic.H(str2, 8, str);
            if (H != null) {
                bVar.qXV.setImageFilePath(H.hYx());
            } else if (this.qXR.contains(str)) {
                Log.i("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "url has add to list. no need to try load image.");
                bVar.qXV.setImageFilePath("-");
            } else {
                q.bcV().a(str, (ImageView) null, e.j(str2, str, str2, "BANNER"), this.qXS);
                this.qXR.add(str);
            }
        }
        Log.d("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "position:%d allPostion:%d banner url:%s ", Integer.valueOf(size), Integer.valueOf(i2), str);
        AppMethodBeat.o(176178);
        return view;
    }

    public final void clear() {
        AppMethodBeat.i(108347);
        if (this.qXN != null) {
            this.qXN.clear();
        }
        if (this.qXR != null) {
            this.qXR.clear();
        }
        this.qXQ = true;
        this.qXS.qXT = null;
        AppMethodBeat.o(108347);
    }

    public final void onClick(View view) {
        AppMethodBeat.i(108348);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/adapter/EmojiStoreVpHeaderAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        com.tencent.mm.plugin.emoji.model.a aVar = this.qXN.get(((Integer) view.getTag(R.id.c03)).intValue());
        if (aVar != null) {
            if (aVar.raX) {
                k.a(this.mContext, aVar.raV, true);
            } else {
                EmotionSummary emotionSummary = aVar.raW.BannerSummary;
                if (emotionSummary != null) {
                    Object[] objArr = new Object[1];
                    objArr[0] = emotionSummary == null ? "" : emotionSummary.ProductID;
                    Log.d("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "productId %s", objArr);
                    h.INSTANCE.a(11929, 0);
                    k.a(this.mContext, emotionSummary, 15, -1, -1, "", 8);
                }
            }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/adapter/EmojiStoreVpHeaderAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(108348);
    }

    /* access modifiers changed from: package-private */
    public static class a implements com.tencent.mm.av.a.c.k {
        i qXT;

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        @Override // com.tencent.mm.av.a.c.k
        public final void a(String str, View view, Bitmap bitmap, Object... objArr) {
            AppMethodBeat.i(108340);
            Log.i("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "onImageLoadComplete url:%s", str);
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.emoji.a.i.a.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(108339);
                    if (a.this.qXT != null) {
                        a.this.qXT.notifyDataSetChanged();
                    }
                    AppMethodBeat.o(108339);
                }
            });
            AppMethodBeat.o(108340);
        }
    }
}
