package com.tencent.mm.plugin.card.ui.v4;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.plugin.card.widget.CardTagTextView;
import com.tencent.mm.plugin.card.widget.MemberCardTopCropImageView;
import com.tencent.mm.protocal.protobuf.tz;
import com.tencent.mm.protocal.protobuf.ua;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0019\u001aB\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\u000bJ\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000bH\u0016J\"\u0010\u0018\u001a\u00020\u00122\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\tR\"\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/card/ui/v4/CardsAndOffersAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/card/ui/v4/CardsAndOffersAdapter$CardTicketVH;", "isInvalid", "", "(Z)V", "cardList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v4/CardDataModel;", "Lkotlin/collections/ArrayList;", "getItemCount", "", "getItemId", "", "position", "getItemViewType", "getModelByPos", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateModelList", "CardTicketVH", "Companion", "plugin-card_release"})
public final class c extends RecyclerView.a<a> {
    public static final b qiC = new b((byte) 0);
    private final boolean qgD;
    private ArrayList<a> qiB;

    static {
        AppMethodBeat.i(201622);
        AppMethodBeat.o(201622);
    }

    public /* synthetic */ c() {
        this(false);
    }

    public c(boolean z) {
        this.qgD = z;
    }

    /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ a a(ViewGroup viewGroup, int i2) {
        int i3 = R.layout.n3;
        AppMethodBeat.i(201615);
        p.h(viewGroup, "parent");
        switch (i2) {
            case 0:
                i3 = R.layout.p7;
                break;
            case 1:
            case 5:
                i3 = R.layout.mk;
                break;
        }
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i3, viewGroup, false);
        if (this.qgD) {
            p.g(inflate, "itemView");
            inflate.setAlpha(0.6f);
        }
        p.g(inflate, "itemView");
        a aVar = new a(inflate, i2);
        AppMethodBeat.o(201615);
        return aVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ void a(a aVar, int i2) {
        boolean z;
        String str;
        boolean z2 = true;
        AppMethodBeat.i(201619);
        a aVar2 = aVar;
        p.h(aVar2, "holder");
        a EF = EF(i2);
        if (EF != null) {
            p.h(EF, "model");
            switch (EF.type) {
                case 0:
                    TextView textView = aVar2.titleTv;
                    if (textView == null) {
                        p.btv("titleTv");
                    }
                    textView.setText(EF.title);
                    break;
                case 1:
                case 5:
                    ua uaVar = EF.qiw;
                    int i3 = EF.type;
                    if (uaVar != null) {
                        TextView textView2 = aVar2.titleTv;
                        if (textView2 == null) {
                            p.btv("titleTv");
                        }
                        textView2.setText(uaVar.LcO);
                        TextView textView3 = aVar2.titleTv;
                        if (textView3 == null) {
                            p.btv("titleTv");
                        }
                        ao.a(textView3.getPaint(), 0.8f);
                        TextView textView4 = aVar2.hPW;
                        if (textView4 == null) {
                            p.btv("descTv");
                        }
                        textView4.setText(uaVar.LcP);
                        String str2 = uaVar.LcX;
                        if (!(str2 == null || str2.length() == 0)) {
                            TextView textView5 = aVar2.titleTv;
                            if (textView5 == null) {
                                p.btv("titleTv");
                            }
                            textView5.setTextColor(com.tencent.mm.plugin.card.d.l.cT(uaVar.LcX, uaVar.LcY));
                        }
                        String str3 = uaVar.LcZ;
                        if (!(str3 == null || str3.length() == 0)) {
                            z2 = false;
                        }
                        if (!z2) {
                            TextView textView6 = aVar2.hPW;
                            if (textView6 == null) {
                                p.btv("descTv");
                            }
                            textView6.setTextColor(com.tencent.mm.plugin.card.d.l.cT(uaVar.LcZ, uaVar.Lda));
                        }
                        String str4 = uaVar.Ldb;
                        if (str4 != null) {
                            ImageView imageView = aVar2.qiF;
                            if (imageView == null) {
                                p.btv("roundCornerIv");
                            }
                            int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(imageView.getContext(), 48);
                            ImageView imageView2 = aVar2.qiF;
                            if (imageView2 == null) {
                                p.btv("roundCornerIv");
                            }
                            m.a(imageView2, str4, false, R.raw.card_default_merchant_icon, fromDPToPix, fromDPToPix, 12);
                        }
                        switch (i3) {
                            case 1:
                                LinearLayout linearLayout = aVar2.qiE;
                                if (linearLayout == null) {
                                    p.btv("labelLayout");
                                }
                                linearLayout.removeAllViews();
                                LinearLayout linearLayout2 = aVar2.qiD;
                                if (linearLayout2 == null) {
                                    p.btv("subTextLayout");
                                }
                                linearLayout2.setVisibility(8);
                                LinkedList<tz> linkedList = uaVar.LcT;
                                LinearLayout linearLayout3 = aVar2.qiE;
                                if (linearLayout3 == null) {
                                    p.btv("labelLayout");
                                }
                                a.a(linkedList, linearLayout3);
                                break;
                            default:
                                LinearLayout linearLayout4 = aVar2.qiD;
                                if (linearLayout4 == null) {
                                    p.btv("subTextLayout");
                                }
                                linearLayout4.removeAllViews();
                                LinearLayout linearLayout5 = aVar2.qiE;
                                if (linearLayout5 == null) {
                                    p.btv("labelLayout");
                                }
                                linearLayout5.setVisibility(8);
                                String str5 = uaVar.Ldg;
                                LinkedList<tz> linkedList2 = uaVar.LcT;
                                LinearLayout linearLayout6 = aVar2.qiD;
                                if (linearLayout6 == null) {
                                    p.btv("subTextLayout");
                                }
                                a.a(str5, linkedList2, linearLayout6, i3);
                                break;
                        }
                    }
                    break;
                case 2:
                case 3:
                case 4:
                    ua uaVar2 = EF.qiw;
                    int i4 = EF.type;
                    if (uaVar2 != null) {
                        String str6 = uaVar2.LcX;
                        if (!(str6 == null || str6.length() == 0)) {
                            TextView textView7 = aVar2.titleTv;
                            if (textView7 == null) {
                                p.btv("titleTv");
                            }
                            textView7.setTextColor(com.tencent.mm.plugin.card.d.l.cT(uaVar2.LcX, uaVar2.LcY));
                        }
                        TextView textView8 = aVar2.titleTv;
                        if (textView8 == null) {
                            p.btv("titleTv");
                        }
                        textView8.setText(uaVar2.LcO);
                        TextView textView9 = aVar2.titleTv;
                        if (textView9 == null) {
                            p.btv("titleTv");
                        }
                        ao.a(textView9.getPaint(), 0.8f);
                        TextView textView10 = aVar2.hPW;
                        if (textView10 == null) {
                            p.btv("descTv");
                        }
                        textView10.setText(uaVar2.LcP);
                        String str7 = uaVar2.Ldb;
                        if (str7 == null || str7.length() == 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!z) {
                            ImageView imageView3 = aVar2.qiF;
                            if (imageView3 == null) {
                                p.btv("roundCornerIv");
                            }
                            int fromDPToPix2 = com.tencent.mm.cb.a.fromDPToPix(imageView3.getContext(), 48);
                            ImageView imageView4 = aVar2.qiF;
                            if (imageView4 == null) {
                                p.btv("roundCornerIv");
                            }
                            String str8 = uaVar2.Ldb;
                            p.g(str8, "element.card_icon_url");
                            m.a(imageView4, str8, false, R.raw.card_default_merchant_icon, fromDPToPix2, fromDPToPix2, 12);
                        }
                        switch (i4) {
                            case 2:
                                LinearLayout linearLayout7 = aVar2.qiE;
                                if (linearLayout7 == null) {
                                    p.btv("labelLayout");
                                }
                                linearLayout7.removeAllViews();
                                LinearLayout linearLayout8 = aVar2.qiD;
                                if (linearLayout8 == null) {
                                    p.btv("subTextLayout");
                                }
                                linearLayout8.setVisibility(8);
                                LinkedList<tz> linkedList3 = uaVar2.LcT;
                                LinearLayout linearLayout9 = aVar2.qiE;
                                if (linearLayout9 == null) {
                                    p.btv("labelLayout");
                                }
                                a.a(linkedList3, linearLayout9);
                                break;
                            default:
                                LinearLayout linearLayout10 = aVar2.qiD;
                                if (linearLayout10 == null) {
                                    p.btv("subTextLayout");
                                }
                                linearLayout10.removeAllViews();
                                LinearLayout linearLayout11 = aVar2.qiE;
                                if (linearLayout11 == null) {
                                    p.btv("labelLayout");
                                }
                                linearLayout11.setVisibility(8);
                                String str9 = uaVar2.Ldg;
                                LinkedList<tz> linkedList4 = uaVar2.LcT;
                                LinearLayout linearLayout12 = aVar2.qiD;
                                if (linearLayout12 == null) {
                                    p.btv("subTextLayout");
                                }
                                a.a(str9, linkedList4, linearLayout12, i4);
                                break;
                        }
                        MemberCardTopCropImageView memberCardTopCropImageView = aVar2.qgR;
                        if (memberCardTopCropImageView == null) {
                            p.btv("bgIv");
                        }
                        Object tag = memberCardTopCropImageView.getTag();
                        String str10 = uaVar2.KDM;
                        if (str10 == null) {
                            str = "";
                        } else {
                            str = str10;
                        }
                        if (!(tag instanceof String) || TextUtils.isEmpty((CharSequence) tag) || !tag.equals(str)) {
                            MemberCardTopCropImageView memberCardTopCropImageView2 = aVar2.qgR;
                            if (memberCardTopCropImageView2 == null) {
                                p.btv("bgIv");
                            }
                            memberCardTopCropImageView2.setTag(str);
                            a.b bVar = new a.b(aVar2, uaVar2);
                            if (aVar2.aYO <= 0 || aVar2.aYN <= 0) {
                                View view = aVar2.aus;
                                p.g(view, "itemView");
                                aVar2.aYO = view.getHeight();
                                View view2 = aVar2.aus;
                                p.g(view2, "itemView");
                                aVar2.aYN = view2.getWidth();
                                if (aVar2.aYO <= 0 || aVar2.aYN <= 0) {
                                    aVar2.aus.post(new a.RunnableC0917a(aVar2, bVar));
                                    break;
                                }
                            }
                            bVar.invoke();
                            break;
                        }
                    }
                    break;
            }
            if (this.qgD) {
                View view3 = aVar2.aus;
                p.g(view3, "holder.itemView");
                view3.setAlpha(0.6f);
            }
            AppMethodBeat.o(201619);
            return;
        }
        AppMethodBeat.o(201619);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/card/ui/v4/CardsAndOffersAdapter$Companion;", "", "()V", "TAG", "", "plugin-card_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemViewType(int i2) {
        AppMethodBeat.i(201616);
        a EF = EF(i2);
        if (EF != null) {
            int i3 = EF.type;
            AppMethodBeat.o(201616);
            return i3;
        }
        AppMethodBeat.o(201616);
        return -1;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(201617);
        int i2 = 0;
        ArrayList<a> arrayList = this.qiB;
        if (arrayList != null) {
            i2 = arrayList.size() + 0;
        }
        AppMethodBeat.o(201617);
        return i2;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final long getItemId(int i2) {
        String str;
        AppMethodBeat.i(201618);
        a EF = EF(i2);
        if (EF != null) {
            String str2 = EF.title;
            if (str2 == null) {
                str2 = "";
            }
            ua uaVar = EF.qiw;
            if (uaVar == null || (str = uaVar.KDM) == null) {
                str = "";
            }
            String str3 = str2 + str;
            String str4 = str3;
            if (str4 == null || str4.length() == 0) {
                long hashCode = (long) EF.hashCode();
                AppMethodBeat.o(201618);
                return hashCode;
            }
            long hashCode2 = (long) (str3 + i2).hashCode();
            AppMethodBeat.o(201618);
            return hashCode2;
        }
        Log.e("MicroMsg.CouponAndGiftCardListAdapter", "[getItemId] position=" + i2 + " itemCount=" + getItemCount() + " }");
        AppMethodBeat.o(201618);
        return 0;
    }

    public final a EF(int i2) {
        AppMethodBeat.i(201620);
        ArrayList<a> arrayList = this.qiB;
        if (arrayList != null) {
            int size = arrayList.size();
            if (i2 >= 0 && size > i2) {
                a aVar = arrayList.get(i2);
                AppMethodBeat.o(201620);
                return aVar;
            }
        }
        AppMethodBeat.o(201620);
        return null;
    }

    public final void P(ArrayList<a> arrayList) {
        AppMethodBeat.i(201621);
        this.qiB = arrayList;
        notifyDataSetChanged();
        AppMethodBeat.o(201621);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0005H\u0002J\u001a\u0010\u0019\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0005H\u0002J\u000e\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001cJ \u0010\u001d\u001a\u00020\u00152\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f2\u0006\u0010\u000b\u001a\u00020\fH\u0002J2\u0010!\u001a\u00020\u00152\b\u0010\"\u001a\u0004\u0018\u00010#2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0005H\u0002R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX.¢\u0006\u0002\n\u0000¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/card/ui/v4/CardsAndOffersAdapter$CardTicketVH;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "viewType", "", "(Landroid/view/View;I)V", "bgIv", "Lcom/tencent/mm/plugin/card/widget/MemberCardTopCropImageView;", "descTv", "Landroid/widget/TextView;", "labelLayout", "Landroid/widget/LinearLayout;", "mViewHeight", "mViewWidth", "roundCornerIv", "Landroid/widget/ImageView;", "shadowBgIv", "subTextLayout", "titleTv", "bindCommonCardDataModel", "", "element", "Lcom/tencent/mm/protocal/protobuf/CardElementCouponList;", "cardType", "bindCouponCardDataModel", "bindDataModel", "model", "Lcom/tencent/mm/plugin/card/ui/v4/CardDataModel;", "updateCardLabelLayout", "couponLabelList", "", "Lcom/tencent/mm/protocal/protobuf/CardElementCouponLabel;", "updateSubLabelText", "subLabel", "", "plugin-card_release"})
    public static final class a extends RecyclerView.v {
        int aYN;
        int aYO;
        TextView hPW;
        MemberCardTopCropImageView qgR;
        LinearLayout qiD;
        LinearLayout qiE;
        ImageView qiF;
        private ImageView qiG;
        TextView titleTv;

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view, int i2) {
            super(view);
            p.h(view, "itemView");
            AppMethodBeat.i(201612);
            switch (i2) {
                case 0:
                    View findViewById = view.findViewById(R.id.anm);
                    p.g(findViewById, "itemView.findViewById(R.id.card_list_header_text)");
                    this.titleTv = (TextView) findViewById;
                    AppMethodBeat.o(201612);
                    return;
                case 1:
                case 5:
                    View findViewById2 = view.findViewById(R.id.b2b);
                    p.g(findViewById2, "itemView.findViewById(R.id.chpiv3_title_tv)");
                    this.titleTv = (TextView) findViewById2;
                    View findViewById3 = view.findViewById(R.id.b27);
                    p.g(findViewById3, "itemView.findViewById(R.id.chpiv3_desc_tv)");
                    this.hPW = (TextView) findViewById3;
                    View findViewById4 = view.findViewById(R.id.b2_);
                    p.g(findViewById4, "itemView.findViewById(R.…iv3_right_subtext_layout)");
                    this.qiD = (LinearLayout) findViewById4;
                    View findViewById5 = view.findViewById(R.id.b1e);
                    p.g(findViewById5, "itemView.findViewById(R.….chpc_rignt_label_layout)");
                    this.qiE = (LinearLayout) findViewById5;
                    View findViewById6 = view.findViewById(R.id.b28);
                    p.g(findViewById6, "itemView.findViewById(R.id.chpiv3_icon_iv)");
                    this.qiF = (ImageView) findViewById6;
                    AppMethodBeat.o(201612);
                    return;
                case 2:
                case 3:
                case 4:
                    View findViewById7 = view.findViewById(R.id.b2b);
                    p.g(findViewById7, "itemView.findViewById(R.id.chpiv3_title_tv)");
                    this.titleTv = (TextView) findViewById7;
                    View findViewById8 = view.findViewById(R.id.b27);
                    p.g(findViewById8, "itemView.findViewById(R.id.chpiv3_desc_tv)");
                    this.hPW = (TextView) findViewById8;
                    View findViewById9 = view.findViewById(R.id.b2_);
                    p.g(findViewById9, "itemView.findViewById(R.…iv3_right_subtext_layout)");
                    this.qiD = (LinearLayout) findViewById9;
                    View findViewById10 = view.findViewById(R.id.b1e);
                    p.g(findViewById10, "itemView.findViewById(R.….chpc_rignt_label_layout)");
                    this.qiE = (LinearLayout) findViewById10;
                    View findViewById11 = view.findViewById(R.id.b26);
                    p.g(findViewById11, "itemView.findViewById(R.id.chpiv3_card_bg_iv)");
                    this.qgR = (MemberCardTopCropImageView) findViewById11;
                    View findViewById12 = view.findViewById(R.id.b25);
                    p.g(findViewById12, "itemView.findViewById(R.id.chpiv3_bg_shadow_iv)");
                    this.qiG = (ImageView) findViewById12;
                    View findViewById13 = view.findViewById(R.id.b28);
                    p.g(findViewById13, "itemView.findViewById(R.id.chpiv3_icon_iv)");
                    this.qiF = (ImageView) findViewById13;
                    break;
            }
            AppMethodBeat.o(201612);
        }

        public static final /* synthetic */ MemberCardTopCropImageView a(a aVar) {
            AppMethodBeat.i(201613);
            MemberCardTopCropImageView memberCardTopCropImageView = aVar.qgR;
            if (memberCardTopCropImageView == null) {
                p.btv("bgIv");
            }
            AppMethodBeat.o(201613);
            return memberCardTopCropImageView;
        }

        public static final /* synthetic */ ImageView c(a aVar) {
            AppMethodBeat.i(201614);
            ImageView imageView = aVar.qiG;
            if (imageView == null) {
                p.btv("shadowBgIv");
            }
            AppMethodBeat.o(201614);
            return imageView;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.card.ui.v4.c$a$a  reason: collision with other inner class name */
        static final class RunnableC0917a implements Runnable {
            final /* synthetic */ kotlin.g.a.a qgW;
            final /* synthetic */ a qiH;

            RunnableC0917a(a aVar, kotlin.g.a.a aVar2) {
                this.qiH = aVar;
                this.qgW = aVar2;
            }

            public final void run() {
                AppMethodBeat.i(201607);
                a aVar = this.qiH;
                View view = this.qiH.aus;
                p.g(view, "itemView");
                aVar.aYO = view.getHeight();
                a aVar2 = this.qiH;
                View view2 = this.qiH.aus;
                p.g(view2, "itemView");
                aVar2.aYN = view2.getWidth();
                this.qgW.invoke();
                AppMethodBeat.o(201607);
            }
        }

        static void a(List<? extends tz> list, LinearLayout linearLayout) {
            AppMethodBeat.i(201610);
            List<? extends tz> list2 = list;
            if (list2 == null || list2.isEmpty()) {
                AppMethodBeat.o(201610);
                return;
            }
            linearLayout.setVisibility(0);
            Context context = MMApplicationContext.getContext();
            for (tz tzVar : list) {
                CardTagTextView cardTagTextView = new CardTagTextView(context);
                cardTagTextView.setMinHeight(com.tencent.mm.cb.a.fromDPToPix(context, 18));
                cardTagTextView.setMinWidth(com.tencent.mm.cb.a.fromDPToPix(context, 56));
                int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(context, 8);
                int fromDPToPix2 = com.tencent.mm.cb.a.fromDPToPix(context, 4);
                cardTagTextView.setPadding(fromDPToPix, fromDPToPix2, fromDPToPix, fromDPToPix2);
                cardTagTextView.setText(tzVar.LcI);
                cardTagTextView.setTextSize(1, 10.0f);
                if (!Util.isNullOrNil(tzVar.LcJ)) {
                    cardTagTextView.setTextColor(Color.parseColor(tzVar.LcJ));
                } else {
                    cardTagTextView.setTextColor(-1);
                }
                if (!Util.isNullOrNil(tzVar.LcK)) {
                    cardTagTextView.setFillColor(com.tencent.mm.plugin.card.d.l.cT(tzVar.LcK, tzVar.LcN));
                } else {
                    cardTagTextView.setFillColor(com.tencent.mm.plugin.card.d.l.fj(WebView.NIGHT_MODE_COLOR, 26));
                }
                linearLayout.addView(cardTagTextView);
            }
            AppMethodBeat.o(201610);
        }

        static void a(String str, List<? extends tz> list, LinearLayout linearLayout, int i2) {
            AppMethodBeat.i(201611);
            String str2 = str;
            if (str2 == null || str2.length() == 0) {
                List<? extends tz> list2 = list;
                if (list2 == null || list2.isEmpty()) {
                    AppMethodBeat.o(201611);
                    return;
                }
            }
            linearLayout.setVisibility(0);
            Context context = MMApplicationContext.getContext();
            if (context != null) {
                C0918c cVar = new C0918c(context, i2, list, linearLayout, str);
                if (list != null) {
                    for (tz tzVar : list) {
                        String str3 = tzVar.LcI;
                        if (str3 != null) {
                            TextView textView = (TextView) cVar.invoke();
                            textView.setText(str3);
                            textView.setTextSize(1, 12.0f);
                            linearLayout.addView(textView);
                        }
                    }
                }
                if (str != null) {
                    TextView textView2 = (TextView) cVar.invoke();
                    textView2.setText(str);
                    textView2.setTextSize(1, 10.0f);
                    linearLayout.addView(textView2);
                }
            }
            AppMethodBeat.o(201611);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class b extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ a qiH;
            final /* synthetic */ ua qiI;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(a aVar, ua uaVar) {
                super(0);
                this.qiH = aVar;
                this.qiI = uaVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                boolean z;
                AppMethodBeat.i(201608);
                a.a(this.qiH).itemPadding = com.tencent.mm.cb.a.fromDPToPix(a.a(this.qiH).getContext(), 32);
                a.a(this.qiH).kn = this.qiH.aYO;
                a.a(this.qiH).getLayoutParams().height = this.qiH.aYO;
                a.a(this.qiH).setVisibility(0);
                a.c(this.qiH).setVisibility(0);
                String str = this.qiI.LcS;
                if (!(str == null || str.length() == 0)) {
                    b.a(a.a(this.qiH), this.qiI.LcS, this.qiH.aYN, this.qiH.aYO);
                } else {
                    String str2 = this.qiI.LcR;
                    if (str2 == null || str2.length() == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        a.a(this.qiH).setImageDrawable(b.EE(Color.parseColor(this.qiI.LcR)));
                    }
                }
                x xVar = x.SXb;
                AppMethodBeat.o(201608);
                return xVar;
            }
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "Landroid/widget/TextView;", "invoke", "com/tencent/mm/plugin/card/ui/v4/CardsAndOffersAdapter$CardTicketVH$updateSubLabelText$1$generateTextView$1"})
        /* renamed from: com.tencent.mm.plugin.card.ui.v4.c$a$c  reason: collision with other inner class name */
        public static final class C0918c extends q implements kotlin.g.a.a<TextView> {
            final /* synthetic */ Context $context$inlined;
            final /* synthetic */ int qiJ;
            final /* synthetic */ List qiK;
            final /* synthetic */ LinearLayout qiL;
            final /* synthetic */ String qiM;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0918c(Context context, int i2, List list, LinearLayout linearLayout, String str) {
                super(0);
                this.$context$inlined = context;
                this.qiJ = i2;
                this.qiK = list;
                this.qiL = linearLayout;
                this.qiM = str;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ TextView invoke() {
                AppMethodBeat.i(201609);
                TextView textView = new TextView(this.$context$inlined);
                textView.setGravity(17);
                switch (this.qiJ) {
                    case 1:
                    case 5:
                        textView.setTextColor(com.tencent.mm.cb.a.n(this.$context$inlined, R.color.FG_1));
                        break;
                    default:
                        textView.setTextColor(-1);
                        break;
                }
                AppMethodBeat.o(201609);
                return textView;
            }
        }
    }
}
