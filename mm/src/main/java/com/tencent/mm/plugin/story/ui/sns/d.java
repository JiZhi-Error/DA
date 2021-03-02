package com.tencent.mm.plugin.story.ui.sns;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.we;
import com.tencent.mm.g.b.a.ji;
import com.tencent.mm.g.b.a.jj;
import com.tencent.mm.g.b.a.jo;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.story.c.a.a;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.g.f;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.plugin.story.ui.StoryBrowseUI;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.blur.BlurView;
import com.tencent.mm.ui.blur.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 +2\u00020\u00012\u00020\u0002:\u0003+,-B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010&\u001a\u00020'J\b\u0010(\u001a\u00020'H\u0016J\b\u0010)\u001a\u00020'H\u0002J\b\u0010*\u001a\u00020'H\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00060\rR\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R*\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u0014\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00160\u0015j\b\u0012\u0004\u0012\u00020\u0016`\u00170\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R2\u0010!\u001a&\u0012\f\u0012\n $*\u0004\u0018\u00010#0# $*\u0012\u0012\f\u0012\n $*\u0004\u0018\u00010#0#\u0018\u00010%0\"X\u000e¢\u0006\u0002\n\u0000¨\u0006."}, hxF = {"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/plugin/story/ui/sns/DialogLifeStyle;", "context", "Landroid/content/Context;", "click", "Landroid/view/View$OnClickListener;", "(Landroid/content/Context;Landroid/view/View$OnClickListener;)V", "blurLayout", "Lcom/tencent/mm/ui/blur/BlurView;", "clearTxt", "Landroid/widget/TextView;", "entranceAdapter", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter;", "entranceRecycler", "Landroid/support/v7/widget/RecyclerView;", "noDataView", "Landroid/view/View;", "replyToIndexMap", "Ljava/util/LinkedHashMap;", "", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "shouldClear", "", "storyClearReport", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryEntranceExposeCleanStruct;", "storyTypeNewIndex", "", "storyTypeOlderIndex", "storyTypeReplyCount", "uiContext", "userNameList", "", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$DataObject;", "kotlin.jvm.PlatformType", "", "buildRender", "", "finish", "hideContent", "showContent", "Companion", "DataObject", "EntranceAdapter", "plugin-story_release"})
public final class d extends LinearLayout implements a {
    public static final a FAu = new a((byte) 0);
    private RecyclerView FAa;
    private List<b> FAd = Collections.synchronizedList(new LinkedList());
    private c FAk;
    private int FAl = -1;
    private int FAm = -1;
    private int FAn = -1;
    private View FAo;
    private TextView FAp;
    private boolean FAq;
    private BlurView FAr;
    private ji FAs = new ji();
    private LinkedHashMap<String, ArrayList<Long>> FAt = new LinkedHashMap<>();
    private Context uiContext;

    static {
        AppMethodBeat.i(119999);
        AppMethodBeat.o(119999);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$Companion;", "", "()V", "AGO_TYPE_TIP", "", "NEW_TYPE_TIP", "REPLY_TYPE_TIP", "TAG", "", "TYPE_REPLY_USERNAME", "TYPE_USERNAME", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$DataObject;", "", "userName", "", "type", "", "(Ljava/lang/String;I)V", "getType", "()I", "getUserName", "()Ljava/lang/String;", "plugin-story_release"})
    public static final class b {
        final int type;
        final String userName;

        public b(String str, int i2) {
            p.h(str, "userName");
            AppMethodBeat.i(119984);
            this.userName = str;
            this.type = i2;
            AppMethodBeat.o(119984);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(final Context context, final View.OnClickListener onClickListener) {
        super(context);
        p.h(context, "context");
        AppMethodBeat.i(119998);
        this.uiContext = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.c04, (ViewGroup) this, true);
        if (inflate == null) {
            t tVar = new t("null cannot be cast to non-null type android.widget.LinearLayout");
            AppMethodBeat.o(119998);
            throw tVar;
        }
        LinearLayout linearLayout = (LinearLayout) inflate;
        LinearLayout linearLayout2 = (LinearLayout) linearLayout.findViewById(R.id.hy9);
        View inflate2 = LayoutInflater.from(context).inflate(R.layout.c02, (ViewGroup) null);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        if (((a.C1744a) com.tencent.mm.plugin.story.c.a.a.FkW.aLT()).BNT) {
            this.FAr = new BlurView(context);
            BlurView blurView = this.FAr;
            if (blurView != null) {
                blurView.alW(Color.parseColor("#B31D1D1D"));
            }
            Context context2 = this.uiContext;
            if (context2 == null) {
                p.btv("uiContext");
            }
            if (context2 == null) {
                t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                AppMethodBeat.o(119998);
                throw tVar2;
            }
            MMActivity mMActivity = (MMActivity) context2;
            Window window = mMActivity.getWindow();
            p.g(window, "activity.window");
            View decorView = window.getDecorView();
            if (decorView == null) {
                t tVar3 = new t("null cannot be cast to non-null type android.view.ViewGroup");
                AppMethodBeat.o(119998);
                throw tVar3;
            }
            ViewGroup viewGroup = (ViewGroup) decorView;
            Window window2 = mMActivity.getWindow();
            p.g(window2, "activity.window");
            View decorView2 = window2.getDecorView();
            p.g(decorView2, "activity.window.decorView");
            Drawable background = decorView2.getBackground();
            int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(getContext(), 20);
            BlurView blurView2 = this.FAr;
            if (blurView2 != null) {
                BlurView F = blurView2.L(viewGroup).gMt().F(background);
                Context context3 = this.uiContext;
                if (context3 == null) {
                    p.btv("uiContext");
                }
                F.b(new f(context3)).cw(20.0f).gMs().cv(((float) fromDPToPix) * 1.0f);
            }
            linearLayout2.addView(this.FAr, layoutParams);
            BlurView blurView3 = this.FAr;
            if (blurView3 != null) {
                blurView3.addView(inflate2, layoutParams);
            }
        } else {
            p.g(inflate2, "contentLayout");
            inflate2.setBackground(context.getResources().getDrawable(R.drawable.g8));
            linearLayout2.addView(inflate2, layoutParams);
        }
        linearLayout.findViewById(R.id.b4g).setOnClickListener(onClickListener);
        View findViewById = linearLayout.findViewById(R.id.fzq);
        p.g(findViewById, "parent.findViewById<View>(R.id.no_data)");
        this.FAo = findViewById;
        View findViewById2 = linearLayout.findViewById(R.id.b3m);
        p.g(findViewById2, "parent.findViewById<TextView>(R.id.clear_txt)");
        this.FAp = (TextView) findViewById2;
        this.FAp.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.story.ui.sns.d.AnonymousClass1 */
            final /* synthetic */ d FAv;

            {
                this.FAv = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(119982);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/sns/StoryEntranceView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.FAv.FAq = !this.FAv.FAq;
                if (this.FAv.FAq) {
                    d.b(this.FAv);
                } else {
                    d.c(this.FAv);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/sns/StoryEntranceView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(119982);
            }
        });
        View findViewById3 = linearLayout.findViewById(R.id.iaa);
        p.g(findViewById3, "parent.findViewById(R.id.story_entrance_recycler)");
        this.FAa = (RecyclerView) findViewById3;
        this.FAa.setLayoutManager(new LinearLayoutManager());
        this.FAk = new c();
        this.FAa.setItemViewCacheSize(0);
        this.FAa.setAdapter(this.FAk);
        this.FAk.uAj = new m<Integer, b, x>(this) {
            /* class com.tencent.mm.plugin.story.ui.sns.d.AnonymousClass2 */
            final /* synthetic */ d FAv;

            {
                this.FAv = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.m
            public final /* synthetic */ x invoke(Integer num, b bVar) {
                int i2;
                int i3;
                AppMethodBeat.i(119983);
                int intValue = num.intValue();
                b bVar2 = bVar;
                p.h(bVar2, "item");
                LinkedList linkedList = new LinkedList();
                HashMap hashMap = new HashMap();
                if (bVar2.type == 5) {
                    for (Map.Entry entry : this.FAv.FAt.entrySet()) {
                        String str = (String) entry.getKey();
                        ArrayList arrayList = new ArrayList();
                        for (Number number : (ArrayList) entry.getValue()) {
                            arrayList.add(Long.valueOf(number.longValue()));
                        }
                        hashMap.put(str, arrayList);
                    }
                    int i4 = this.FAv.FAn != -1 ? intValue - 1 : intValue;
                    h hVar = h.FuH;
                    h.fqi().sx(1);
                    i2 = i4;
                } else if (bVar2.type == 1) {
                    if (intValue <= this.FAv.FAn || this.FAv.FAn == -1) {
                        i3 = intValue;
                    } else {
                        i3 = intValue - this.FAv.FAn;
                    }
                    if (intValue >= this.FAv.FAl && this.FAv.FAl != -1) {
                        i3--;
                        h hVar2 = h.FuH;
                        h.fqi().sl(12);
                        h hVar3 = h.FuH;
                        jo fqi = h.fqi();
                        StringBuilder sb = new StringBuilder("12_");
                        h hVar4 = h.FuH;
                        fqi.wU(sb.append(h.fqD()).toString());
                    }
                    if (intValue >= this.FAv.FAm && this.FAv.FAm != -1) {
                        i3--;
                        h hVar5 = h.FuH;
                        h.fqi().sl(13);
                        h hVar6 = h.FuH;
                        jo fqi2 = h.fqi();
                        StringBuilder sb2 = new StringBuilder("13_");
                        h hVar7 = h.FuH;
                        fqi2.wU(sb2.append(h.fqD()).toString());
                    }
                    i2 = i3;
                } else {
                    i2 = intValue;
                }
                List list = this.FAv.FAd;
                p.g(list, "userNameList");
                List<b> list2 = list;
                synchronized (list2) {
                    try {
                        for (b bVar3 : list2) {
                            if (!(bVar3.type == bVar2.type)) {
                                bVar3 = null;
                            }
                            if (bVar3 != null) {
                                linkedList.add(bVar3.userName);
                            }
                        }
                        x xVar = x.SXb;
                    } finally {
                        AppMethodBeat.o(119983);
                    }
                }
                com.tencent.mm.plugin.report.service.h.INSTANCE.n(1015, 6, 1);
                List list3 = this.FAv.FAd;
                p.g(list3, "userNameList");
                List list4 = list3;
                synchronized (list4) {
                    try {
                        int i5 = 0;
                        for (Object obj : list4) {
                            int i6 = i5 + 1;
                            if (i5 < 0) {
                                j.hxH();
                            }
                            b bVar4 = (b) obj;
                            if (!(bVar4.type == bVar2.type && i5 < intValue)) {
                                bVar4 = null;
                            }
                            if (bVar4 != null) {
                                linkedList.add(bVar4.userName);
                                i5 = i6;
                            } else {
                                i5 = i6;
                            }
                        }
                        x xVar2 = x.SXb;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                h hVar8 = h.FuH;
                h.fqi().wS((String) linkedList.get(i2));
                com.tencent.mm.plugin.story.g.d dVar = com.tencent.mm.plugin.story.g.d.FrG;
                int fpC = com.tencent.mm.plugin.story.g.d.fpC();
                if (!hashMap.isEmpty()) {
                    com.tencent.mm.plugin.story.g.d dVar2 = com.tencent.mm.plugin.story.g.d.FrG;
                    fpC = com.tencent.mm.plugin.story.g.d.fpE() | fpC;
                }
                long a2 = com.tencent.mm.plugin.story.api.p.FkJ.a(linkedList, hashMap, fpC);
                Intent intent = new Intent(context, StoryBrowseUI.class);
                intent.putExtra("v_position", i2);
                intent.putExtra("data_seed_key", a2);
                intent.putExtra("gallery_session_id", "");
                intent.putExtra("gallery_is_for_sns", true);
                Context context = context;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/story/ui/sns/StoryEntranceView$2", "invoke", "(ILcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$DataObject;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/story/ui/sns/StoryEntranceView$2", "invoke", "(ILcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$DataObject;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                View.OnClickListener onClickListener = onClickListener;
                if (onClickListener != null) {
                    onClickListener.onClick(this.FAv);
                }
                x xVar3 = x.SXb;
                AppMethodBeat.o(119983);
                return xVar3;
            }
        };
        List<String> fnj = com.tencent.mm.plugin.story.f.f.a.FpB.fnj();
        List<String> fnk = com.tencent.mm.plugin.story.f.f.a.FpB.fnk();
        this.FAt = com.tencent.mm.plugin.story.f.f.a.FpB.fnl();
        if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_story_preload_with_enter_pop_sns, 1) == 1) {
            if (!fnj.isEmpty()) {
                f.a aVar = com.tencent.mm.plugin.story.g.f.FrJ;
                com.tencent.mm.plugin.story.f.d.h ct = f.a.ct(fnj.get(0), false);
                if (ct != null) {
                    com.tencent.mm.plugin.story.ui.view.gallery.m.FHB.C(j.listOf(ct.FoT), 5);
                }
            } else {
                if (!fnk.isEmpty()) {
                    f.a aVar2 = com.tencent.mm.plugin.story.g.f.FrJ;
                    com.tencent.mm.plugin.story.f.d.h ct2 = f.a.ct(fnk.get(0), false);
                    if (ct2 != null) {
                        com.tencent.mm.plugin.story.ui.view.gallery.m.FHB.C(j.listOf(ct2.FoT), 5);
                    }
                }
            }
        }
        Log.i("MicroMsg.StoryEntranceView", "userNames " + fnj.size() + " lastUserNames " + fnk.size());
        if (!this.FAt.isEmpty()) {
            this.FAd.add(new b("", 4));
            this.FAn = this.FAt.size() + 1;
        }
        Set<Map.Entry<String, ArrayList<Long>>> entrySet = this.FAt.entrySet();
        p.g(entrySet, "replyToIndexMap.entries");
        Set<Map.Entry<String, ArrayList<Long>>> set = entrySet;
        synchronized (set) {
            try {
                Iterator<T> it = set.iterator();
                while (it.hasNext()) {
                    List<b> list = this.FAd;
                    Object key = it.next().getKey();
                    p.g(key, "it.key");
                    list.add(new b((String) key, 5));
                }
                x xVar = x.SXb;
            } finally {
                AppMethodBeat.o(119998);
            }
        }
        if (!fnj.isEmpty()) {
            this.FAl = this.FAd.size();
            this.FAd.add(new b("", 3));
        }
        h hVar = h.FuH;
        h.fqE().lI(fnj.size());
        String str = "";
        List<String> list2 = fnj;
        synchronized (list2) {
            try {
                for (T t : list2) {
                    this.FAd.add(new b(t, 1));
                    com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
                    p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
                    as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN().Kn(t);
                    p.g(Kn, "contact");
                    if (Kn.arA()) {
                        h hVar2 = h.FuH;
                        jj fqE = h.fqE();
                        fqE.lJ(fqE.ahs() + 1);
                    }
                    str = str + '|' + ((String) t);
                }
                x xVar2 = x.SXb;
            } finally {
                AppMethodBeat.o(119998);
            }
        }
        if (str.length() > 0) {
            if (str == null) {
                t tVar4 = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(119998);
                throw tVar4;
            }
            str = str.substring(1);
            p.g(str, "(this as java.lang.String).substring(startIndex)");
        }
        h hVar3 = h.FuH;
        h.fqE().wO(str);
        h hVar4 = h.FuH;
        h.fqE().lK(fnk.size());
        this.FAm = this.FAd.size();
        if (!fnk.isEmpty()) {
            this.FAd.add(new b("", 2));
        }
        String str2 = "";
        List<String> list3 = fnk;
        synchronized (list3) {
            try {
                for (T t2 : list3) {
                    this.FAd.add(new b(t2, 1));
                    com.tencent.mm.kernel.c.a af2 = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
                    p.g(af2, "MMKernel.service(IMessengerStorage::class.java)");
                    as Kn2 = ((com.tencent.mm.plugin.messenger.foundation.a.l) af2).aSN().Kn(t2);
                    p.g(Kn2, "contact");
                    if (Kn2.arA()) {
                        h hVar5 = h.FuH;
                        jj fqE2 = h.fqE();
                        fqE2.lL(fqE2.aht() + 1);
                    }
                    str2 = str2 + '|' + ((String) t2);
                }
                x xVar3 = x.SXb;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (str2.length() > 0) {
            if (str2 == null) {
                t tVar5 = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(119998);
                throw tVar5;
            }
            str2 = str2.substring(1);
            p.g(str2, "(this as java.lang.String).substring(startIndex)");
        }
        h hVar6 = h.FuH;
        h.fqE().wP(str2);
        h hVar7 = h.FuH;
        h.fqE().sd((long) this.FAt.size());
        h hVar8 = h.FuH;
        h.fqF();
        c cVar = this.FAk;
        List<b> list4 = this.FAd;
        p.g(list4, "userNameList");
        p.h(list4, "extInfoList");
        cVar.hKT.clear();
        cVar.hKT.addAll(list4);
        cVar.notifyDataSetChanged();
        ji jiVar = this.FAs;
        h hVar9 = h.FuH;
        jiVar.rZ((long) h.fqD());
        we weVar = new we();
        weVar.ecn.eco = true;
        EventCenter.instance.publish(weVar);
        AppMethodBeat.o(119998);
    }

    @Override // com.tencent.mm.plugin.story.ui.sns.a
    public final void finish() {
        com.tencent.mm.ui.blur.c blurController;
        AppMethodBeat.i(119997);
        this.FAs.sc(this.FAq ? 1 : 0);
        this.FAs.bfK();
        if (this.FAq) {
            j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
            com.tencent.mm.plugin.story.f.j.Fmx = cl.aWz() + 10;
            for (Map.Entry<String, ArrayList<Long>> entry : this.FAt.entrySet()) {
                entry.getKey();
                Iterator<T> it = entry.getValue().iterator();
                while (it.hasNext()) {
                    long longValue = it.next().longValue();
                    com.tencent.mm.plugin.story.f.b.b bVar2 = com.tencent.mm.plugin.story.f.b.b.Fom;
                    com.tencent.mm.plugin.story.f.b.b.Kk(longValue);
                }
            }
            e aAh = g.aAh();
            p.g(aAh, "MMKernel.storage()");
            ao azQ = aAh.azQ();
            ar.a aVar = ar.a.USERINFO_STORY_SNS_ALL_READ_TIME_LONG;
            j.b bVar3 = com.tencent.mm.plugin.story.f.j.Fmy;
            azQ.set(aVar, Long.valueOf(j.b.fop()));
        }
        we weVar = new we();
        weVar.ecn.eco = false;
        EventCenter.instance.publish(weVar);
        Log.i("MicroMsg.StoryEntranceView", "finish");
        if (this.FAd.size() > 0) {
            e aAh2 = g.aAh();
            p.g(aAh2, "MMKernel.storage()");
            aAh2.azQ().set(ar.a.USERINFO_STORY_SNS_UPDATE_TIME_LONG, Long.valueOf(cl.aWz()));
        }
        BlurView blurView = this.FAr;
        if (!(blurView == null || (blurController = blurView.getBlurController()) == null)) {
            blurController.destroy();
        }
        com.tencent.mm.plugin.story.f.f.a aVar2 = com.tencent.mm.plugin.story.f.f.a.FpB;
        com.tencent.mm.plugin.story.f.f.a.fpf();
        AppMethodBeat.o(119997);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\b\u0004\u0018\u00002\u0010\u0012\f\u0012\n0\u0002R\u00060\u0000R\u00020\u00030\u0001:\u0003 !\"B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0015\u001a\u00020\u0007H\u0016J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016J \u0010\u0017\u001a\u00020\r2\u000e\u0010\u0018\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\n\u001a\u00020\u0007H\u0016J \u0010\u0019\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0007H\u0016J\u0014\u0010\u001d\u001a\u00020\r2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001fRL\u0010\u0005\u001a4\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0013j\b\u0012\u0004\u0012\u00020\u000b`\u0014X\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter$EntranceViewHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView;", "(Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView;)V", "onItemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$DataObject;", "item", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "userList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getItemCount", "getItemViewType", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "update", "extInfoList", "", "EntranceViewHolder", "EntranceViewTipHolder", "EntranceViewUserHolder", "plugin-story_release"})
    public final class c extends RecyclerView.a<a> {
        final ArrayList<b> hKT = new ArrayList<>();
        m<? super Integer, ? super b, x> uAj;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public c() {
            AppMethodBeat.i(119996);
            AppMethodBeat.o(119996);
        }

        /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ a a(ViewGroup viewGroup, int i2) {
            b bVar;
            AppMethodBeat.i(119993);
            p.h(viewGroup, "parent");
            switch (i2) {
                case 1:
                case 5:
                    View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.c01, viewGroup, false);
                    p.g(inflate, "LayoutInflater.from(pare…ance_item, parent, false)");
                    bVar = new C1784c(this, inflate);
                    break;
                case 2:
                    View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.c03, viewGroup, false);
                    p.g(inflate2, "LayoutInflater.from(pare…rance_tip, parent, false)");
                    bVar = new b(this, inflate2, R.string.ha1);
                    break;
                case 3:
                default:
                    View inflate3 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.c03, viewGroup, false);
                    p.g(inflate3, "LayoutInflater.from(pare…rance_tip, parent, false)");
                    bVar = new b(this, inflate3, R.string.ha0);
                    break;
                case 4:
                    View inflate4 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.c03, viewGroup, false);
                    p.g(inflate4, "LayoutInflater.from(pare…rance_tip, parent, false)");
                    bVar = new b(this, inflate4, R.string.h_y);
                    break;
            }
            RecyclerView.v vVar = bVar;
            AppMethodBeat.o(119993);
            return vVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ void a(a aVar, int i2) {
            AppMethodBeat.i(119995);
            a aVar2 = aVar;
            p.h(aVar2, "holder");
            b bVar = this.hKT.get(i2);
            p.g(bVar, "userList[position]");
            aVar2.a(bVar);
            AppMethodBeat.o(119995);
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemCount() {
            AppMethodBeat.i(119992);
            int size = this.hKT.size();
            AppMethodBeat.o(119992);
            return size;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemViewType(int i2) {
            AppMethodBeat.i(119994);
            int i3 = this.hKT.get(i2).type;
            AppMethodBeat.o(119994);
            return i3;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b¦\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter$EntranceViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter;Landroid/view/View;)V", "onBind", "", "position", "", "data", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$DataObject;", "plugin-story_release"})
        public abstract class a extends RecyclerView.v {
            final /* synthetic */ c FAx;

            public abstract void a(b bVar);

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(c cVar, View view) {
                super(view);
                p.h(view, "itemView");
                this.FAx = cVar;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\n0\u0001R\u00060\u0002R\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter$EntranceViewTipHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter$EntranceViewHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView;", "itemView", "Landroid/view/View;", "tipId", "", "(Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter;Landroid/view/View;I)V", "contentTv", "Landroid/widget/TextView;", "getContentTv", "()Landroid/widget/TextView;", "getTipId", "()I", "setTipId", "(I)V", "onBind", "", "position", "data", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$DataObject;", "plugin-story_release"})
        public final class b extends a {
            final /* synthetic */ c FAx;
            private int FAy;
            private final TextView hXC;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(c cVar, View view, int i2) {
                super(cVar, view);
                p.h(view, "itemView");
                this.FAx = cVar;
                AppMethodBeat.i(119988);
                this.FAy = i2;
                View findViewById = view.findViewById(R.id.ior);
                p.g(findViewById, "itemView.findViewById(R.id.tip_tv)");
                this.hXC = (TextView) findViewById;
                view.setOnClickListener(AnonymousClass1.FAz);
                AppMethodBeat.o(119988);
            }

            @Override // com.tencent.mm.plugin.story.ui.sns.d.c.a
            public final void a(b bVar) {
                AppMethodBeat.i(119987);
                p.h(bVar, "data");
                this.hXC.setText(this.FAy);
                AppMethodBeat.o(119987);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\n0\u0001R\u00060\u0002R\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000e\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter$EntranceViewUserHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter$EntranceViewHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter;Landroid/view/View;)V", "avatar", "Landroid/widget/ImageView;", "getAvatar", "()Landroid/widget/ImageView;", "contentTv", "Landroid/widget/TextView;", "getContentTv", "()Landroid/widget/TextView;", "reply", "getReply", "setReply", "(Landroid/widget/TextView;)V", "star", "getStar", "()Landroid/view/View;", "setStar", "(Landroid/view/View;)V", "onBind", "", "position", "", "data", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$DataObject;", "plugin-story_release"})
        /* renamed from: com.tencent.mm.plugin.story.ui.sns.d$c$c  reason: collision with other inner class name */
        public final class C1784c extends a {
            private View FAA;
            private TextView FAB;
            final /* synthetic */ c FAx;
            private final TextView hXC;
            private final ImageView keC;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C1784c(c cVar, View view) {
                super(cVar, view);
                p.h(view, "itemView");
                this.FAx = cVar;
                AppMethodBeat.i(119991);
                View findViewById = view.findViewById(R.id.x1);
                p.g(findViewById, "itemView.findViewById(R.id.avatar_iv)");
                this.keC = (ImageView) findViewById;
                View findViewById2 = view.findViewById(R.id.j1l);
                p.g(findViewById2, "itemView.findViewById(R.id.user_name_tv)");
                this.hXC = (TextView) findViewById2;
                View findViewById3 = view.findViewById(R.id.i4b);
                p.g(findViewById3, "itemView.findViewById(R.id.star)");
                this.FAA = findViewById3;
                View findViewById4 = view.findViewById(R.id.h38);
                p.g(findViewById4, "itemView.findViewById(R.id.reply_icon)");
                this.FAB = (TextView) findViewById4;
                view.setOnClickListener(new View.OnClickListener(this) {
                    /* class com.tencent.mm.plugin.story.ui.sns.d.c.C1784c.AnonymousClass1 */
                    final /* synthetic */ C1784c FAC;

                    {
                        this.FAC = r1;
                    }

                    public final void onClick(View view) {
                        AppMethodBeat.i(119989);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter$EntranceViewUserHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        int lR = this.FAC.lR();
                        Object obj = this.FAC.FAx.hKT.get(lR);
                        p.g(obj, "userList[position]");
                        b bVar2 = (b) obj;
                        m<? super Integer, ? super b, x> mVar = this.FAC.FAx.uAj;
                        if (mVar != null) {
                            mVar.invoke(Integer.valueOf(lR), bVar2);
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter$EntranceViewUserHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(119989);
                    }
                });
                AppMethodBeat.o(119991);
            }

            @Override // com.tencent.mm.plugin.story.ui.sns.d.c.a
            public final void a(b bVar) {
                String str;
                int i2 = 0;
                AppMethodBeat.i(119990);
                p.h(bVar, "data");
                a.b.d(this.keC, bVar.userName);
                com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
                p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
                as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN().Kn(bVar.userName);
                if (Kn == null || (str = Kn.arJ()) == null) {
                    str = bVar.userName;
                }
                SpannableString b2 = com.tencent.mm.pluginsdk.ui.span.l.b(this.hXC.getContext(), str, this.hXC.getTextSize());
                View view = this.FAA;
                p.g(Kn, "contact");
                view.setVisibility(Kn.arA() ? 0 : 4);
                this.hXC.setText(b2);
                TextView textView = this.FAB;
                if (bVar.type == 5) {
                    this.FAB.setText(String.valueOf(com.tencent.mm.plugin.story.f.f.a.FpB.aSf(bVar.userName)));
                } else {
                    i2 = 8;
                }
                textView.setVisibility(i2);
                AppMethodBeat.o(119990);
            }
        }
    }

    public static final /* synthetic */ void b(d dVar) {
        AppMethodBeat.i(120000);
        dVar.FAo.setVisibility(0);
        dVar.FAa.setVisibility(4);
        dVar.FAp.setText(dVar.getResources().getString(R.string.hhx));
        dVar.FAq = true;
        ji jiVar = dVar.FAs;
        jiVar.sa(jiVar.ahp() + 1);
        AppMethodBeat.o(120000);
    }

    public static final /* synthetic */ void c(d dVar) {
        AppMethodBeat.i(120001);
        dVar.FAo.setVisibility(4);
        dVar.FAa.setVisibility(0);
        dVar.FAp.setText(dVar.getResources().getString(R.string.hhu));
        dVar.FAq = false;
        ji jiVar = dVar.FAs;
        jiVar.sb(jiVar.ahq() + 1);
        AppMethodBeat.o(120001);
    }
}
