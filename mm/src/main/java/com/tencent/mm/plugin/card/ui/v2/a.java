package com.tencent.mm.plugin.card.ui.v2;

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
import com.tencent.mm.plugin.card.ui.v2.c;
import com.tencent.mm.plugin.card.widget.CardTagTextView;
import com.tencent.mm.plugin.card.widget.MemberCardTopCropImageView;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.cnf;
import com.tencent.mm.protocal.protobuf.cyp;
import com.tencent.mm.protocal.protobuf.cyq;
import com.tencent.mm.protocal.protobuf.tz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 92\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00019B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\"H\u0016J\u0010\u0010&\u001a\u00020\"2\u0006\u0010%\u001a\u00020\"H\u0016J\u0010\u0010'\u001a\u0004\u0018\u00010\n2\u0006\u0010%\u001a\u00020\"J\u000e\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020*J\u000e\u0010+\u001a\u00020\"2\u0006\u0010)\u001a\u00020*J\u000e\u0010,\u001a\u00020\"2\u0006\u0010)\u001a\u00020*J\u0016\u0010-\u001a\u00020\"2\u0006\u0010)\u001a\u00020*2\u0006\u0010.\u001a\u00020\"J\u0018\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\"H\u0016J\u0018\u00102\u001a\u00020\u00022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\"H\u0016J\u000e\u00106\u001a\u0002002\u0006\u0010)\u001a\u00020*J\u000e\u0010\u0016\u001a\u0002002\u0006\u00107\u001a\u00020*Jd\u00108\u001a\u0002002\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b2\u001a\u0010\u001b\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b2\u001a\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\nJ\u000e\u0010 \u001a\u0002002\u0006\u00107\u001a\u00020*R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\u0007\u0010\u0005R.\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR.\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R.\u0010\u001b\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\r\"\u0004\b\u001d\u0010\u000fR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010\u0017¨\u0006:"}, hxF = {"Lcom/tencent/mm/plugin/card/ui/v2/CardTicketAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/card/ui/v2/CardTicketVH;", "isInvalid", "", "(Z)V", "()Z", "setInvalid", "jumpList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListModel;", "Lkotlin/collections/ArrayList;", "getJumpList", "()Ljava/util/ArrayList;", "setJumpList", "(Ljava/util/ArrayList;)V", "licenseList", "getLicenseList", "setLicenseList", "licenseTitle", "getLicenseTitle", "()Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListModel;", "setLicenseTitle", "(Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListModel;)V", "medicareCard", "getMedicareCard", "setMedicareCard", "ticketList", "getTicketList", "setTicketList", "ticketTitle", "getTicketTitle", "setTicketTitle", "getItemCount", "", "getItemId", "", "position", "getItemViewType", "getModelByPos", "getPosByCardId", "cardId", "", "getPosInLicenseListByCardId", "getPosInTicketListByCardId", "getRelativePosByType", "cardType", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "removeModelByCardId", "title", "setModelList", "Companion", "plugin-card_release"})
public final class a extends RecyclerView.a<c> {
    public static final C0911a qgE = new C0911a((byte) 0);
    private b qgA;
    private b qgB;
    private b qgC;
    private boolean qgD;
    private ArrayList<b> qgx;
    private ArrayList<b> qgy;
    private ArrayList<b> qgz;

    static {
        AppMethodBeat.i(112523);
        AppMethodBeat.o(112523);
    }

    public /* synthetic */ a() {
        this(false);
    }

    public a(boolean z) {
        this.qgD = z;
    }

    /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ c a(ViewGroup viewGroup, int i2) {
        int i3;
        AppMethodBeat.i(112513);
        p.h(viewGroup, "parent");
        switch (i2) {
            case 0:
                i3 = R.layout.p7;
                break;
            case 1:
                i3 = R.layout.nv;
                break;
            case 2:
                i3 = R.layout.p6;
                break;
            case 3:
                i3 = R.layout.nu;
                break;
            default:
                i3 = 0;
                break;
        }
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i3, viewGroup, false);
        if (this.qgD) {
            p.g(inflate, "itemView");
            inflate.setAlpha(0.6f);
        }
        p.g(inflate, "itemView");
        c cVar = new c(inflate, i2);
        AppMethodBeat.o(112513);
        return cVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ void a(c cVar, int i2) {
        AppMethodBeat.i(112514);
        c cVar2 = cVar;
        p.h(cVar2, "holder");
        Log.d("MicroMsg.CardTicketAdapter", "bind view %s", Integer.valueOf(i2));
        b EB = EB(i2);
        if (EB != null) {
            p.h(EB, "model");
            switch (EB.type) {
                case 0:
                    TextView textView = cVar2.titleTv;
                    if (textView == null) {
                        p.btv("titleTv");
                    }
                    textView.setText(EB.title);
                    break;
                case 1:
                    cyq cyq = EB.qgF;
                    if (cyq != null) {
                        if (!Util.isNullOrNil(cyq.MDF)) {
                            CdnImageView cdnImageView = cVar2.qgQ;
                            if (cdnImageView == null) {
                                p.btv("logoIv");
                            }
                            cdnImageView.gI(cyq.MDF, R.raw.card_default_merchant_icon);
                        } else {
                            CdnImageView cdnImageView2 = cVar2.qgQ;
                            if (cdnImageView2 == null) {
                                p.btv("logoIv");
                            }
                            cdnImageView2.setImageResource(R.raw.card_default_merchant_icon);
                        }
                        TextView textView2 = cVar2.titleTv;
                        if (textView2 == null) {
                            p.btv("titleTv");
                        }
                        textView2.setText(cyq.MDE);
                        TextView textView3 = cVar2.hPW;
                        if (textView3 == null) {
                            p.btv("descTv");
                        }
                        textView3.setText(cyq.MDG);
                        break;
                    }
                    break;
                case 2:
                    cyp cyp = EB.qgG;
                    if (cyp != null) {
                        MemberCardTopCropImageView memberCardTopCropImageView = cVar2.qgR;
                        if (memberCardTopCropImageView == null) {
                            p.btv("bgIv");
                        }
                        Object tag = memberCardTopCropImageView.getTag();
                        String str = cyp.KDM;
                        if (!(tag instanceof String) || TextUtils.isEmpty((CharSequence) tag) || !tag.equals(str)) {
                            MemberCardTopCropImageView memberCardTopCropImageView2 = cVar2.qgR;
                            if (memberCardTopCropImageView2 == null) {
                                p.btv("bgIv");
                            }
                            memberCardTopCropImageView2.setTag(str);
                            CdnImageView cdnImageView3 = cVar2.qgQ;
                            if (cdnImageView3 == null) {
                                p.btv("logoIv");
                            }
                            cdnImageView3.setRoundCorner(true);
                            if (!Util.isNullOrNil(cyp.MDz)) {
                                CdnImageView cdnImageView4 = cVar2.qgQ;
                                if (cdnImageView4 == null) {
                                    p.btv("logoIv");
                                }
                                cdnImageView4.gI(cyp.MDz, R.raw.card_default_merchant_icon);
                            } else {
                                CdnImageView cdnImageView5 = cVar2.qgQ;
                                if (cdnImageView5 == null) {
                                    p.btv("logoIv");
                                }
                                cdnImageView5.setImageResource(R.raw.card_default_merchant_icon);
                            }
                            TextView textView4 = cVar2.titleTv;
                            if (textView4 == null) {
                                p.btv("titleTv");
                            }
                            textView4.setText(cyp.MDx);
                            TextView textView5 = cVar2.hPW;
                            if (textView5 == null) {
                                p.btv("descTv");
                            }
                            textView5.setText(cyp.MDy);
                            if (cyp.MDA != 1 && cyp.MDA != 3 && cyp.MDA != 4) {
                                TextView textView6 = cVar2.titleTv;
                                if (textView6 == null) {
                                    p.btv("titleTv");
                                }
                                textView6.setTextColor(-1);
                                TextView textView7 = cVar2.hPW;
                                if (textView7 == null) {
                                    p.btv("descTv");
                                }
                                MemberCardTopCropImageView memberCardTopCropImageView3 = cVar2.qgR;
                                if (memberCardTopCropImageView3 == null) {
                                    p.btv("bgIv");
                                }
                                textView7.setTextColor(com.tencent.mm.cb.a.n(memberCardTopCropImageView3.getContext(), R.color.BW_100_Alpha_0_8));
                                LinkedList<tz> linkedList = cyp.MDB;
                                p.g(linkedList, "ticket_label");
                                LinkedList<tz> linkedList2 = linkedList;
                                LinearLayout linearLayout = cVar2.qgS;
                                if (linearLayout == null) {
                                    p.btv("rightLabelLayout");
                                }
                                p.h(linkedList2, "couponLabelList");
                                p.h(linearLayout, "labelLayout");
                                linearLayout.removeAllViews();
                                if (linkedList2.isEmpty()) {
                                    linearLayout.setVisibility(4);
                                } else {
                                    linearLayout.setVisibility(0);
                                    for (tz tzVar : linkedList2) {
                                        if (!Util.isNullOrNil(tzVar.LcI)) {
                                            LinearLayout linearLayout2 = cVar2.qgS;
                                            if (linearLayout2 == null) {
                                                p.btv("rightLabelLayout");
                                            }
                                            CardTagTextView cardTagTextView = new CardTagTextView(linearLayout2.getContext());
                                            Context context = linearLayout.getContext();
                                            cardTagTextView.setMinHeight(com.tencent.mm.cb.a.fromDPToPix(context, 18));
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
                                    }
                                }
                                c.a aVar = new c.a(cyp, cVar2);
                                if (cVar2.aYO <= 0 || cVar2.aYN <= 0) {
                                    View view = cVar2.aus;
                                    p.g(view, "itemView");
                                    cVar2.aYO = view.getHeight();
                                    View view2 = cVar2.aus;
                                    p.g(view2, "itemView");
                                    cVar2.aYN = view2.getWidth();
                                    if (cVar2.aYO <= 0 || cVar2.aYN <= 0) {
                                        cVar2.aus.post(new c.b(aVar, cVar2));
                                        break;
                                    }
                                }
                                aVar.invoke();
                                break;
                            } else {
                                MemberCardTopCropImageView memberCardTopCropImageView4 = cVar2.qgR;
                                if (memberCardTopCropImageView4 == null) {
                                    p.btv("bgIv");
                                }
                                memberCardTopCropImageView4.setVisibility(4);
                                ImageView imageView = cVar2.qgT;
                                if (imageView == null) {
                                    p.btv("shadowIv");
                                }
                                imageView.setVisibility(4);
                                View view3 = cVar2.aus;
                                p.g(view3, "itemView");
                                View view4 = cVar2.aus;
                                p.g(view4, "itemView");
                                Context context2 = view4.getContext();
                                p.g(context2, "itemView.context");
                                view3.setBackground(context2.getResources().getDrawable(R.drawable.le));
                                TextView textView8 = cVar2.titleTv;
                                if (textView8 == null) {
                                    p.btv("titleTv");
                                }
                                textView8.setTextColor(Color.parseColor("#555555"));
                                TextView textView9 = cVar2.titleTv;
                                if (textView9 == null) {
                                    p.btv("titleTv");
                                }
                                View view5 = cVar2.aus;
                                p.g(view5, "itemView");
                                textView9.setShadowLayer(0.0f, 0.0f, 0.0f, com.tencent.mm.cb.a.n(view5.getContext(), R.color.ac_));
                                TextView textView10 = cVar2.hPW;
                                if (textView10 == null) {
                                    p.btv("descTv");
                                }
                                textView10.setTextColor(Color.parseColor("#555555"));
                                TextView textView11 = cVar2.hPW;
                                if (textView11 == null) {
                                    p.btv("descTv");
                                }
                                View view6 = cVar2.aus;
                                p.g(view6, "itemView");
                                textView11.setShadowLayer(0.0f, 0.0f, 0.0f, com.tencent.mm.cb.a.n(view6.getContext(), R.color.ac_));
                                break;
                            }
                        }
                    }
                    break;
                case 3:
                    cnf cnf = EB.qgH;
                    if (cnf != null) {
                        TextView textView12 = cVar2.titleTv;
                        if (textView12 == null) {
                            p.btv("titleTv");
                        }
                        textView12.setText(cnf.Mtz);
                        String str2 = cnf.MtB;
                        if (!(str2 == null || str2.length() == 0)) {
                            TextView textView13 = cVar2.hPW;
                            if (textView13 == null) {
                                p.btv("descTv");
                            }
                            textView13.setText(cnf.MtB);
                            TextView textView14 = cVar2.hPW;
                            if (textView14 == null) {
                                p.btv("descTv");
                            }
                            textView14.setVisibility(0);
                            break;
                        } else {
                            TextView textView15 = cVar2.hPW;
                            if (textView15 == null) {
                                p.btv("descTv");
                            }
                            textView15.setVisibility(8);
                            break;
                        }
                    }
                    break;
            }
            if (this.qgD) {
                View view7 = cVar2.aus;
                p.g(view7, "holder.itemView");
                view7.setAlpha(0.6f);
            }
            AppMethodBeat.o(112514);
            return;
        }
        AppMethodBeat.o(112514);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/card/ui/v2/CardTicketAdapter$Companion;", "", "()V", "LIST_ITEM_CARD", "", "LIST_ITEM_MEDICARE_CARD", "LIST_ITEM_TICKET_ENTRANCE", "LIST_ITEM_TITLE", "TAG", "", "plugin-card_release"})
    /* renamed from: com.tencent.mm.plugin.card.ui.v2.a$a  reason: collision with other inner class name */
    public static final class C0911a {
        private C0911a() {
        }

        public /* synthetic */ C0911a(byte b2) {
            this();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemViewType(int i2) {
        AppMethodBeat.i(112515);
        b EB = EB(i2);
        if (EB != null) {
            int i3 = EB.type;
            AppMethodBeat.o(112515);
            return i3;
        }
        AppMethodBeat.o(112515);
        return -1;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final long getItemId(int i2) {
        String str;
        String str2;
        String str3;
        AppMethodBeat.i(201399);
        b EB = EB(i2);
        if (EB != null) {
            String str4 = EB.title;
            if (str4 == null) {
                str4 = "";
            }
            cyp cyp = EB.qgG;
            if (cyp == null || (str = cyp.KDM) == null) {
                str = "";
            }
            cyq cyq = EB.qgF;
            if (cyq == null || (str2 = cyq.MDE) == null) {
                str2 = "";
            }
            cnf cnf = EB.qgH;
            if (cnf == null || (str3 = cnf.Mtz) == null) {
                str3 = "";
            }
            String str5 = str4 + str + str2 + str3;
            String str6 = str5;
            if (str6 == null || str6.length() == 0) {
                long hashCode = (long) EB.hashCode();
                AppMethodBeat.o(201399);
                return hashCode;
            }
            long hashCode2 = (long) (str5 + i2 + EB.type).hashCode();
            AppMethodBeat.o(201399);
            return hashCode2;
        }
        Log.e("MicroMsg.CardTicketAdapter", "[getItemId] position=" + i2 + " itemCount=" + getItemCount() + " }");
        AppMethodBeat.o(201399);
        return 0;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(112516);
        int i2 = 0;
        if (this.qgA != null) {
            i2 = 1;
        }
        ArrayList<b> arrayList = this.qgz;
        if (arrayList != null) {
            i2 += arrayList.size();
        }
        ArrayList<b> arrayList2 = this.qgx;
        if (arrayList2 != null) {
            i2 += arrayList2.size();
        }
        if (this.qgB != null) {
            i2++;
        }
        ArrayList<b> arrayList3 = this.qgy;
        if (arrayList3 != null) {
            i2 += arrayList3.size();
        }
        if (this.qgC != null) {
            i2++;
        }
        AppMethodBeat.o(112516);
        return i2;
    }

    public final b EB(int i2) {
        AppMethodBeat.i(112517);
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(i2);
        ArrayList<b> arrayList = this.qgz;
        objArr[1] = arrayList != null ? Integer.valueOf(arrayList.size()) : null;
        ArrayList<b> arrayList2 = this.qgx;
        objArr[2] = arrayList2 != null ? Integer.valueOf(arrayList2.size()) : null;
        ArrayList<b> arrayList3 = this.qgy;
        objArr[3] = arrayList3 != null ? Integer.valueOf(arrayList3.size()) : null;
        Log.d("MicroMsg.CardTicketAdapter", "pos: %s, jSize: %s, tSize: %s, lSize: %s", objArr);
        int i3 = -1;
        if (this.qgA != null) {
            if (i2 == 0) {
                b bVar = this.qgA;
                AppMethodBeat.o(112517);
                return bVar;
            }
            i3 = 0;
        }
        ArrayList<b> arrayList4 = this.qgz;
        if (arrayList4 != null) {
            if (i2 <= i3 || i2 > arrayList4.size() + i3) {
                i3 += arrayList4.size();
            } else {
                b bVar2 = arrayList4.get((i2 - i3) - 1);
                AppMethodBeat.o(112517);
                return bVar2;
            }
        }
        ArrayList<b> arrayList5 = this.qgx;
        if (arrayList5 != null) {
            if (i2 <= i3 || i2 > arrayList5.size() + i3) {
                i3 += arrayList5.size();
            } else {
                b bVar3 = arrayList5.get((i2 - i3) - 1);
                AppMethodBeat.o(112517);
                return bVar3;
            }
        }
        if (this.qgB == null || i2 != (i3 = i3 + 1)) {
            ArrayList<b> arrayList6 = this.qgy;
            if (arrayList6 != null) {
                if (i2 <= i3 || i2 > arrayList6.size() + i3) {
                    i3 += arrayList6.size();
                } else {
                    b bVar4 = arrayList6.get((i2 - i3) - 1);
                    AppMethodBeat.o(112517);
                    return bVar4;
                }
            }
            if (this.qgC == null || i2 != i3 + 1) {
                AppMethodBeat.o(112517);
                return null;
            }
            b bVar5 = this.qgC;
            AppMethodBeat.o(112517);
            return bVar5;
        }
        b bVar6 = this.qgB;
        AppMethodBeat.o(112517);
        return bVar6;
    }

    public final int cQ(String str, int i2) {
        int i3;
        String str2;
        AppMethodBeat.i(112518);
        p.h(str, "cardId");
        switch (i2) {
            case 1:
                p.h(str, "cardId");
                ArrayList<b> arrayList = this.qgz;
                if (arrayList != null) {
                    i3 = arrayList.size() + 0;
                } else {
                    i3 = 0;
                }
                ArrayList<b> arrayList2 = this.qgx;
                if (arrayList2 != null) {
                    Iterator<T> it = arrayList2.iterator();
                    int i4 = 0;
                    while (it.hasNext()) {
                        cyp cyp = it.next().qgG;
                        if (cyp != null) {
                            str2 = cyp.KDM;
                        } else {
                            str2 = null;
                        }
                        if (p.j(str2, str)) {
                            int i5 = i4 + i3;
                            AppMethodBeat.o(112518);
                            return i5;
                        }
                        i4++;
                    }
                }
                AppMethodBeat.o(112518);
                return 0;
            default:
                p.h(str, "cardId");
                ArrayList<b> arrayList3 = this.qgy;
                if (arrayList3 != null) {
                    Iterator<T> it2 = arrayList3.iterator();
                    int i6 = 0;
                    while (it2.hasNext()) {
                        cyp cyp2 = it2.next().qgG;
                        if (p.j(cyp2 != null ? cyp2.KDM : null, str)) {
                            AppMethodBeat.o(112518);
                            return i6;
                        }
                        i6++;
                    }
                }
                AppMethodBeat.o(112518);
                return 0;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0072, code lost:
        if (r0.isEmpty() != false) goto L_0x0074;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void ajO(java.lang.String r12) {
        /*
        // Method dump skipped, instructions count: 242
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.card.ui.v2.a.ajO(java.lang.String):void");
    }

    public final void a(ArrayList<b> arrayList, ArrayList<b> arrayList2, ArrayList<b> arrayList3, b bVar) {
        AppMethodBeat.i(201400);
        this.qgz = arrayList;
        this.qgx = arrayList2;
        this.qgy = arrayList3;
        this.qgC = bVar;
        notifyDataSetChanged();
        AppMethodBeat.o(201400);
    }

    public final void ajP(String str) {
        AppMethodBeat.i(112521);
        p.h(str, "title");
        if (Util.isNullOrNil(str)) {
            this.qgA = null;
            AppMethodBeat.o(112521);
            return;
        }
        if (this.qgA == null) {
            this.qgA = new b();
            b bVar = this.qgA;
            if (bVar == null) {
                p.hyc();
            }
            bVar.type = 0;
        }
        b bVar2 = this.qgA;
        if (bVar2 == null) {
            p.hyc();
        }
        bVar2.title = str;
        AppMethodBeat.o(112521);
    }

    public final void ajQ(String str) {
        AppMethodBeat.i(112522);
        p.h(str, "title");
        if (Util.isNullOrNil(str)) {
            this.qgB = null;
            AppMethodBeat.o(112522);
            return;
        }
        if (this.qgB == null) {
            this.qgB = new b();
            b bVar = this.qgB;
            if (bVar == null) {
                p.hyc();
            }
            bVar.type = 0;
        }
        b bVar2 = this.qgB;
        if (bVar2 == null) {
            p.hyc();
        }
        bVar2.title = str;
        AppMethodBeat.o(112522);
    }
}
