package com.tencent.mm.plugin.appbrand.phonenumber;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\n\u0010\u0016\u001a\u0004\u0018\u00010\fH\u0016J\u001e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0016R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManagerView;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberManagerView;", "mContext", "Landroid/content/Context;", "mPhoneNumberManagerLogic", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberManageLogic;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberManageLogic;)V", "MAX_COUNT", "", "getMAX_COUNT", "()I", "mAddPhoneLineV", "Landroid/view/View;", "mAddPhoneTv", "Landroid/widget/TextView;", "mContentView", "mExposeTv", "mItemAdapter", "Lcom/tencent/mm/plugin/appbrand/phonenumber/DeleteItemAdapter;", "mListRv", "Landroid/support/v7/widget/RecyclerView;", "mTipsTv", "getView", "updateView", "", "showDelete", "", "phoneItems", "", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "Companion", "luggage-wechat-full-sdk_release"})
public final class x implements p {
    public static final a nAC = new a((byte) 0);
    private final int MAX_COUNT = 3;
    private View mContentView = View.inflate(this.mContext, R.layout.ek, null);
    private final Context mContext;
    private TextView nAA;
    private TextView nAB;
    private final o nAt;
    private RecyclerView nAw;
    private j nAx;
    private TextView nAy;
    private View nAz;

    static {
        AppMethodBeat.i(148165);
        AppMethodBeat.o(148165);
    }

    public x(Context context, o oVar) {
        TextView textView;
        View view;
        TextView textView2;
        TextView textView3;
        SpannableString spannableString;
        p.h(context, "mContext");
        AppMethodBeat.i(148164);
        this.mContext = context;
        this.nAt = oVar;
        View view2 = this.mContentView;
        this.nAw = view2 != null ? (RecyclerView) view2.findViewById(R.id.gax) : null;
        RecyclerView recyclerView = this.nAw;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager());
        }
        this.nAx = new j(this.mContext, new ArrayList(), new b<PhoneItem, kotlin.x>(this) {
            /* class com.tencent.mm.plugin.appbrand.phonenumber.x.AnonymousClass1 */
            final /* synthetic */ x nAD;

            {
                this.nAD = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ kotlin.x invoke(PhoneItem phoneItem) {
                AppMethodBeat.i(148161);
                PhoneItem phoneItem2 = phoneItem;
                p.h(phoneItem2, LocaleUtil.ITALIAN);
                o oVar = this.nAD.nAt;
                if (oVar != null) {
                    oVar.a(phoneItem2);
                }
                kotlin.x xVar = kotlin.x.SXb;
                AppMethodBeat.o(148161);
                return xVar;
            }
        });
        RecyclerView recyclerView2 = this.nAw;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(this.nAx);
        }
        View view3 = this.mContentView;
        if (view3 != null) {
            textView = (TextView) view3.findViewById(R.id.gao);
        } else {
            textView = null;
        }
        this.nAy = textView;
        TextView textView4 = this.nAy;
        if (textView4 != null) {
            textView4.setOnClickListener(new View.OnClickListener(this) {
                /* class com.tencent.mm.plugin.appbrand.phonenumber.x.AnonymousClass2 */
                final /* synthetic */ x nAD;

                {
                    this.nAD = r1;
                }

                public final void onClick(View view) {
                    AppMethodBeat.i(148162);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManagerView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    o oVar = this.nAD.nAt;
                    if (oVar != null) {
                        oVar.bTv();
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManagerView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(148162);
                }
            });
        }
        View view4 = this.mContentView;
        if (view4 != null) {
            view = view4.findViewById(R.id.gaw);
        } else {
            view = null;
        }
        this.nAz = view;
        View view5 = this.mContentView;
        if (view5 != null) {
            textView2 = (TextView) view5.findViewById(R.id.gav);
        } else {
            textView2 = null;
        }
        this.nAA = textView2;
        TextView textView5 = this.nAA;
        if (textView5 != null) {
            textView5.setMovementMethod(LinkMovementMethod.getInstance());
        }
        TextView textView6 = this.nAA;
        if (textView6 != null) {
            o oVar2 = this.nAt;
            if (oVar2 != null) {
                spannableString = oVar2.bTw();
            } else {
                spannableString = null;
            }
            textView6.setText(spannableString);
        }
        View view6 = this.mContentView;
        if (view6 != null) {
            textView3 = (TextView) view6.findViewById(R.id.gap);
        } else {
            textView3 = null;
        }
        this.nAB = textView3;
        AppMethodBeat.o(148164);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManagerView$Companion;", "", "()V", "luggage-wechat-full-sdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.phonenumber.p
    public final void b(boolean z, List<PhoneItem> list) {
        AppMethodBeat.i(148163);
        p.h(list, "phoneItems");
        j jVar = this.nAx;
        if (jVar != null) {
            jVar.nze = z;
        }
        j jVar2 = this.nAx;
        if (jVar2 != null) {
            jVar2.notifyDataSetChanged();
        }
        j jVar3 = this.nAx;
        if (jVar3 != null) {
            p.h(list, "phoneItems");
            jVar3.nze = z;
            jVar3.lJn = (ArrayList) list;
            jVar3.notifyDataSetChanged();
        }
        if (z || list.size() >= this.MAX_COUNT) {
            TextView textView = this.nAy;
            if (textView != null) {
                textView.setVisibility(8);
            }
            View view = this.nAz;
            if (view != null) {
                view.setVisibility(8);
            }
        } else {
            TextView textView2 = this.nAy;
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
            View view2 = this.nAz;
            if (view2 != null) {
                view2.setVisibility(0);
            }
        }
        if (z) {
            TextView textView3 = this.nAB;
            if (textView3 != null) {
                textView3.setVisibility(8);
                AppMethodBeat.o(148163);
                return;
            }
            AppMethodBeat.o(148163);
        } else if (list.size() >= this.MAX_COUNT) {
            TextView textView4 = this.nAB;
            if (textView4 != null) {
                textView4.setVisibility(0);
                AppMethodBeat.o(148163);
                return;
            }
            AppMethodBeat.o(148163);
        } else {
            TextView textView5 = this.nAB;
            if (textView5 != null) {
                textView5.setVisibility(8);
                AppMethodBeat.o(148163);
                return;
            }
            AppMethodBeat.o(148163);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.phonenumber.p
    public final View getView() {
        return this.mContentView;
    }
}
