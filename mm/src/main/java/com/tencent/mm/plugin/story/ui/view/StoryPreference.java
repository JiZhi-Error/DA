package com.tencent.mm.plugin.story.ui.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.cb.a;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.api.AbsStoryPreference;
import com.tencent.mm.plugin.story.api.d;
import com.tencent.mm.plugin.story.api.p;
import com.tencent.mm.plugin.story.e.a;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.f.n;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.plugin.story.i.a;
import com.tencent.mm.plugin.story.i.j;
import com.tencent.mm.plugin.story.i.k;
import com.tencent.mm.plugin.story.ui.StoryBrowseUI;
import com.tencent.mm.protocal.protobuf.edk;
import com.tencent.mm.protocal.protobuf.edt;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.ar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\bB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u000e\u0010'\u001a\b\u0012\u0004\u0012\u00020%0(H\u0002J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\nH\u0002J\b\u0010,\u001a\u00020*H\u0016J\b\u0010-\u001a\u00020*H\u0016J\u0010\u0010.\u001a\u00020*2\u0006\u0010/\u001a\u00020\u0011H\u0014J\u0012\u00100\u001a\u00020*2\b\u00101\u001a\u0004\u0018\u00010%H\u0016J\u0010\u00102\u001a\u00020\u00112\u0006\u00103\u001a\u00020\u001fH\u0014J\b\u00104\u001a\u00020*H\u0016J,\u00105\u001a\u00020*2\u0006\u00106\u001a\u00020\n2\u0006\u00107\u001a\u00020\n2\b\u00108\u001a\u0004\u0018\u00010%2\b\u00109\u001a\u0004\u0018\u00010:H\u0016J\u0012\u0010;\u001a\u00020*2\b\u0010<\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010=\u001a\u00020*H\u0016R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000¨\u0006>"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/view/StoryPreference;", "Lcom/tencent/mm/plugin/story/api/AbsStoryPreference;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isAddedSceneListener", "", "mCallback", "Lcom/tencent/mm/plugin/story/api/ILoadFavStoryCallback;", "mCoverView", "Landroid/view/View;", "mStoryFavList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "Lkotlin/collections/ArrayList;", "mStoryIconView1", "Landroid/widget/ImageView;", "mStoryIconView2", "mStoryIconView3", "mStoryView1", "Lcom/tencent/mm/plugin/story/ui/view/StoryRoundImageView;", "mStoryView2", "mStoryView3", "mStoryViewGroup1", "Landroid/view/ViewGroup;", "mStoryViewGroup2", "mStoryViewGroup3", "mTitleView", "Landroid/widget/TextView;", "mUsername", "", "mView", "getDateList", "", "goFavGallery", "", "position", "handleEvent", "loadStory", "onBindView", "view", "onCreate", ch.COL_USERNAME, "onCreateView", "parent", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "setLoadCallback", "callback", "updateFavStory", "plugin-story_release"})
public final class StoryPreference extends AbsStoryPreference implements i {
    private StoryRoundImageView FDV;
    private StoryRoundImageView FDW;
    private StoryRoundImageView FDX;
    private ImageView FDY;
    private ImageView FDZ;
    private ImageView FEa;
    private ViewGroup FEb;
    private ViewGroup FEc;
    private ViewGroup FEd;
    private ArrayList<j> FEe;
    private d FEf;
    private boolean FEg;
    private TextView Xy;
    private String mRa;
    private View mView;
    private View zlc;

    public static final /* synthetic */ void a(StoryPreference storyPreference, int i2) {
        AppMethodBeat.i(120300);
        storyPreference.abf(i2);
        AppMethodBeat.o(120300);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public StoryPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(120298);
        AppMethodBeat.o(120298);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StoryPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(120299);
        View inflate = View.inflate(getContext(), R.layout.c0r, null);
        p.g(inflate, "View.inflate(context, R.…e_fav_panel_layout, null)");
        this.mView = inflate;
        this.FEe = new ArrayList<>();
        this.mRa = "";
        View findViewById = this.mView.findViewById(16908310);
        p.g(findViewById, "mView.findViewById(android.R.id.title)");
        this.Xy = (TextView) findViewById;
        View findViewById2 = this.mView.findViewById(R.id.fg5);
        p.g(findViewById2, "mView.findViewById(R.id.…eference_story_image_iv1)");
        this.FDV = (StoryRoundImageView) findViewById2;
        View findViewById3 = this.mView.findViewById(R.id.fg7);
        p.g(findViewById3, "mView.findViewById(R.id.…eference_story_image_iv2)");
        this.FDW = (StoryRoundImageView) findViewById3;
        View findViewById4 = this.mView.findViewById(R.id.fg9);
        p.g(findViewById4, "mView.findViewById(R.id.…eference_story_image_iv3)");
        this.FDX = (StoryRoundImageView) findViewById4;
        View findViewById5 = this.mView.findViewById(R.id.fg2);
        p.g(findViewById5, "mView.findViewById(R.id.…erence_story_image_icon1)");
        this.FDY = (ImageView) findViewById5;
        View findViewById6 = this.mView.findViewById(R.id.fg3);
        p.g(findViewById6, "mView.findViewById(R.id.…erence_story_image_icon2)");
        this.FDZ = (ImageView) findViewById6;
        View findViewById7 = this.mView.findViewById(R.id.fg4);
        p.g(findViewById7, "mView.findViewById(R.id.…erence_story_image_icon3)");
        this.FEa = (ImageView) findViewById7;
        View findViewById8 = this.mView.findViewById(R.id.fg6);
        p.g(findViewById8, "mView.findViewById(R.id.…ce_story_image_iv1_group)");
        this.FEb = (ViewGroup) findViewById8;
        View findViewById9 = this.mView.findViewById(R.id.fg8);
        p.g(findViewById9, "mView.findViewById(R.id.…ce_story_image_iv2_group)");
        this.FEc = (ViewGroup) findViewById9;
        View findViewById10 = this.mView.findViewById(R.id.fg_);
        p.g(findViewById10, "mView.findViewById(R.id.…ce_story_image_iv3_group)");
        this.FEd = (ViewGroup) findViewById10;
        int fromDPToPix = a.fromDPToPix(getContext(), 8);
        this.FDV.setRound(fromDPToPix);
        this.FDW.setRound(fromDPToPix);
        this.FDX.setRound(fromDPToPix);
        Drawable m = ar.m(getContext(), R.raw.icons_filled_play2, -1);
        this.FDY.setImageDrawable(m);
        this.FDZ.setImageDrawable(m);
        this.FEa.setImageDrawable(m);
        this.FDV.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.story.ui.view.StoryPreference.AnonymousClass1 */
            final /* synthetic */ StoryPreference FEh;

            {
                this.FEh = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(120286);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/StoryPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                StoryPreference.a(this.FEh, 0);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(120286);
            }
        });
        this.FDW.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.story.ui.view.StoryPreference.AnonymousClass2 */
            final /* synthetic */ StoryPreference FEh;

            {
                this.FEh = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(120287);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/StoryPreference$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                StoryPreference.a(this.FEh, 1);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryPreference$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(120287);
            }
        });
        this.FDX.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.story.ui.view.StoryPreference.AnonymousClass3 */
            final /* synthetic */ StoryPreference FEh;

            {
                this.FEh = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(120288);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/StoryPreference$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                StoryPreference.a(this.FEh, 2);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryPreference$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(120288);
            }
        });
        AppMethodBeat.o(120299);
    }

    @Override // com.tencent.mm.plugin.story.api.AbsStoryPreference
    public final void onCreate(String str) {
        AppMethodBeat.i(120290);
        if (str == null) {
            str = "";
        }
        this.mRa = str;
        if (!this.FEg) {
            com.tencent.mm.kernel.b aAg = g.aAg();
            p.g(aAg, "MMKernel.network()");
            aAg.azz().a(273, this);
            this.FEg = true;
        }
        AppMethodBeat.o(120290);
    }

    @Override // com.tencent.mm.plugin.story.api.AbsStoryPreference
    public final void fmX() {
        AppMethodBeat.i(120291);
        n.a aVar = n.FmM;
        String str = this.mRa;
        p.h(str, ch.COL_USERNAME);
        com.tencent.mm.kernel.b aAg = g.aAg();
        p.g(aAg, "MMKernel.network()");
        t azz = aAg.azz();
        j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
        boolean isEqual = Util.isEqual(str, j.b.fau());
        a.C1768a aVar2 = com.tencent.mm.plugin.story.i.a.FvD;
        azz.b(new com.tencent.mm.plugin.story.f.a.i(str, 0, isEqual, "", com.tencent.mm.plugin.story.i.a.FvB));
        AppMethodBeat.o(120291);
    }

    @Override // com.tencent.mm.plugin.story.api.AbsStoryPreference
    public final void fmY() {
        boolean z;
        boolean z2;
        boolean z3 = true;
        AppMethodBeat.i(120292);
        ViewGroup.LayoutParams layoutParams = this.Xy.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = com.tencent.mm.cb.a.aG(getContext(), R.dimen.em);
        }
        this.Xy.setLayoutParams(layoutParams);
        this.FEe.clear();
        ArrayList<com.tencent.mm.plugin.story.i.j> arrayList = this.FEe;
        j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
        k foc = j.b.foc();
        String str = this.mRa;
        String str2 = this.mRa;
        j.b bVar2 = com.tencent.mm.plugin.story.f.j.Fmy;
        arrayList.addAll(foc.a(str, Util.isEqual(str2, j.b.fau()), 0, 20));
        this.FEb.setVisibility(8);
        this.FEc.setVisibility(8);
        this.FEd.setVisibility(8);
        if (!this.FEe.isEmpty()) {
            TextView textView = this.Xy;
            Context context = getContext();
            p.g(context, "context");
            textView.setText(context.getResources().getString(R.string.bh3));
        } else {
            this.Xy.setText("");
        }
        if (this.FEe.size() == 1) {
            this.Xy.setVisibility(0);
            this.FEb.setVisibility(0);
            edk edk = this.FEe.get(0).frG().NeB;
            if (edk != null) {
                LinkedList<edt> linkedList = edk.LoV;
                p.g(linkedList, "obj.MediaObjList");
                if (linkedList.isEmpty()) {
                    z3 = false;
                }
                if (z3) {
                    j.b bVar3 = com.tencent.mm.plugin.story.f.j.Fmy;
                    com.tencent.mm.loader.d<com.tencent.mm.plugin.story.f.c.d> fok = j.b.fok();
                    edt edt = edk.LoV.get(0);
                    p.g(edt, "obj.MediaObjList[0]");
                    String str3 = this.FEe.get(0).field_userName;
                    bp bpVar = bp.Oqx;
                    p.g(bpVar, "FROM_SCENE.storyalbum");
                    com.tencent.mm.plugin.story.f.c.d dVar = new com.tencent.mm.plugin.story.f.c.d(edt, str3, bpVar);
                    StoryRoundImageView storyRoundImageView = this.FDV;
                    if (storyRoundImageView == null) {
                        p.hyc();
                    }
                    j.b bVar4 = com.tencent.mm.plugin.story.f.j.Fmy;
                    fok.a(dVar, storyRoundImageView, j.b.a(com.tencent.mm.plugin.story.f.c.a.COMMON_SCENE));
                }
            }
        } else if (this.FEe.size() == 2) {
            this.Xy.setVisibility(0);
            this.FEb.setVisibility(0);
            this.FEc.setVisibility(0);
            edk edk2 = this.FEe.get(0).frG().NeB;
            if (edk2 != null) {
                LinkedList<edt> linkedList2 = edk2.LoV;
                p.g(linkedList2, "obj1.MediaObjList");
                if (!linkedList2.isEmpty()) {
                    j.b bVar5 = com.tencent.mm.plugin.story.f.j.Fmy;
                    com.tencent.mm.loader.d<com.tencent.mm.plugin.story.f.c.d> fok2 = j.b.fok();
                    edt edt2 = edk2.LoV.get(0);
                    p.g(edt2, "obj1.MediaObjList[0]");
                    String str4 = this.FEe.get(0).field_userName;
                    bp bpVar2 = bp.Oqx;
                    p.g(bpVar2, "FROM_SCENE.storyalbum");
                    com.tencent.mm.plugin.story.f.c.d dVar2 = new com.tencent.mm.plugin.story.f.c.d(edt2, str4, bpVar2);
                    StoryRoundImageView storyRoundImageView2 = this.FDV;
                    if (storyRoundImageView2 == null) {
                        p.hyc();
                    }
                    j.b bVar6 = com.tencent.mm.plugin.story.f.j.Fmy;
                    fok2.a(dVar2, storyRoundImageView2, j.b.a(com.tencent.mm.plugin.story.f.c.a.COMMON_SCENE));
                }
            }
            edk edk3 = this.FEe.get(1).frG().NeB;
            if (edk3 != null) {
                LinkedList<edt> linkedList3 = edk3.LoV;
                p.g(linkedList3, "obj2.MediaObjList");
                if (linkedList3.isEmpty()) {
                    z3 = false;
                }
                if (z3) {
                    j.b bVar7 = com.tencent.mm.plugin.story.f.j.Fmy;
                    com.tencent.mm.loader.d<com.tencent.mm.plugin.story.f.c.d> fok3 = j.b.fok();
                    edt edt3 = edk3.LoV.get(0);
                    p.g(edt3, "obj2.MediaObjList[0]");
                    String str5 = this.FEe.get(0).field_userName;
                    bp bpVar3 = bp.Oqx;
                    p.g(bpVar3, "FROM_SCENE.storyalbum");
                    com.tencent.mm.plugin.story.f.c.d dVar3 = new com.tencent.mm.plugin.story.f.c.d(edt3, str5, bpVar3);
                    StoryRoundImageView storyRoundImageView3 = this.FDW;
                    if (storyRoundImageView3 == null) {
                        p.hyc();
                    }
                    j.b bVar8 = com.tencent.mm.plugin.story.f.j.Fmy;
                    fok3.a(dVar3, storyRoundImageView3, j.b.a(com.tencent.mm.plugin.story.f.c.a.COMMON_SCENE));
                }
            }
        } else if (this.FEe.size() >= 3) {
            this.Xy.setVisibility(0);
            this.FEb.setVisibility(0);
            this.FEc.setVisibility(0);
            this.FEd.setVisibility(0);
            edk edk4 = this.FEe.get(0).frG().NeB;
            if (edk4 != null) {
                LinkedList<edt> linkedList4 = edk4.LoV;
                p.g(linkedList4, "obj1.MediaObjList");
                if (!linkedList4.isEmpty()) {
                    j.b bVar9 = com.tencent.mm.plugin.story.f.j.Fmy;
                    com.tencent.mm.loader.d<com.tencent.mm.plugin.story.f.c.d> fok4 = j.b.fok();
                    edt edt4 = edk4.LoV.get(0);
                    p.g(edt4, "obj1.MediaObjList[0]");
                    String str6 = this.FEe.get(0).field_userName;
                    bp bpVar4 = bp.Oqx;
                    p.g(bpVar4, "FROM_SCENE.storyalbum");
                    com.tencent.mm.plugin.story.f.c.d dVar4 = new com.tencent.mm.plugin.story.f.c.d(edt4, str6, bpVar4);
                    StoryRoundImageView storyRoundImageView4 = this.FDV;
                    if (storyRoundImageView4 == null) {
                        p.hyc();
                    }
                    j.b bVar10 = com.tencent.mm.plugin.story.f.j.Fmy;
                    fok4.a(dVar4, storyRoundImageView4, j.b.a(com.tencent.mm.plugin.story.f.c.a.COMMON_SCENE));
                }
            }
            edk edk5 = this.FEe.get(1).frG().NeB;
            if (edk5 != null) {
                LinkedList<edt> linkedList5 = edk5.LoV;
                p.g(linkedList5, "obj2.MediaObjList");
                if (!linkedList5.isEmpty()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    j.b bVar11 = com.tencent.mm.plugin.story.f.j.Fmy;
                    com.tencent.mm.loader.d<com.tencent.mm.plugin.story.f.c.d> fok5 = j.b.fok();
                    edt edt5 = edk5.LoV.get(0);
                    p.g(edt5, "obj2.MediaObjList[0]");
                    String str7 = this.FEe.get(0).field_userName;
                    bp bpVar5 = bp.Oqx;
                    p.g(bpVar5, "FROM_SCENE.storyalbum");
                    com.tencent.mm.plugin.story.f.c.d dVar5 = new com.tencent.mm.plugin.story.f.c.d(edt5, str7, bpVar5);
                    StoryRoundImageView storyRoundImageView5 = this.FDW;
                    if (storyRoundImageView5 == null) {
                        p.hyc();
                    }
                    j.b bVar12 = com.tencent.mm.plugin.story.f.j.Fmy;
                    fok5.a(dVar5, storyRoundImageView5, j.b.a(com.tencent.mm.plugin.story.f.c.a.COMMON_SCENE));
                }
            }
            edk edk6 = this.FEe.get(2).frG().NeB;
            if (edk6 != null) {
                LinkedList<edt> linkedList6 = edk6.LoV;
                p.g(linkedList6, "obj3.MediaObjList");
                if (!linkedList6.isEmpty()) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    j.b bVar13 = com.tencent.mm.plugin.story.f.j.Fmy;
                    com.tencent.mm.loader.d<com.tencent.mm.plugin.story.f.c.d> fok6 = j.b.fok();
                    edt edt6 = edk6.LoV.get(0);
                    p.g(edt6, "obj3.MediaObjList[0]");
                    String str8 = this.FEe.get(0).field_userName;
                    bp bpVar6 = bp.Oqx;
                    p.g(bpVar6, "FROM_SCENE.storyalbum");
                    com.tencent.mm.plugin.story.f.c.d dVar6 = new com.tencent.mm.plugin.story.f.c.d(edt6, str8, bpVar6);
                    StoryRoundImageView storyRoundImageView6 = this.FDX;
                    if (storyRoundImageView6 == null) {
                        p.hyc();
                    }
                    j.b bVar14 = com.tencent.mm.plugin.story.f.j.Fmy;
                    fok6.a(dVar6, storyRoundImageView6, j.b.a(com.tencent.mm.plugin.story.f.c.a.COMMON_SCENE));
                }
            }
        }
        d dVar7 = this.FEf;
        if (dVar7 != null) {
            dVar7.fP(this.FEe);
            AppMethodBeat.o(120292);
            return;
        }
        AppMethodBeat.o(120292);
    }

    @Override // com.tencent.mm.plugin.story.api.AbsStoryPreference
    public final void fmZ() {
        boolean z;
        AppMethodBeat.i(120293);
        if (!this.FEe.isEmpty()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            abf(0);
        }
        AppMethodBeat.o(120293);
    }

    @Override // com.tencent.mm.plugin.story.api.AbsStoryPreference
    public final void onDestroy() {
        AppMethodBeat.i(120294);
        this.FEf = null;
        com.tencent.mm.kernel.b aAg = g.aAg();
        p.g(aAg, "MMKernel.network()");
        aAg.azz().b(273, this);
        AppMethodBeat.o(120294);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(120295);
        if (qVar instanceof com.tencent.mm.plugin.story.f.a.i) {
            int i4 = ((com.tencent.mm.plugin.story.f.a.i) qVar).source;
            a.C1768a aVar = com.tencent.mm.plugin.story.i.a.FvD;
            if (i4 == com.tencent.mm.plugin.story.i.a.FvB && Util.isEqual(((com.tencent.mm.plugin.story.f.a.i) qVar).userName, this.mRa) && i2 == 0) {
                fmY();
            }
        }
        AppMethodBeat.o(120295);
    }

    @Override // com.tencent.mm.plugin.story.api.AbsStoryPreference
    public final void a(d dVar) {
        this.FEf = dVar;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(120296);
        p.h(viewGroup, "parent");
        if (this.zlc == null) {
            View onCreateView = super.onCreateView(viewGroup);
            ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.be9);
            viewGroup2.removeAllViews();
            this.mView.setId(R.id.iqp);
            viewGroup2.addView(this.mView, new ViewGroup.LayoutParams(-1, -2));
            this.zlc = onCreateView;
        }
        View view = this.zlc;
        if (view == null) {
            p.hyc();
        }
        AppMethodBeat.o(120296);
        return view;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(120297);
        p.h(view, "view");
        super.onBindView(view);
        fmY();
        AppMethodBeat.o(120297);
    }

    private final void abf(int i2) {
        AppMethodBeat.i(120289);
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = this.FEe.iterator();
        while (it.hasNext()) {
            a.C1747a aVar = com.tencent.mm.plugin.story.e.a.Flw;
            arrayList.add(a.C1747a.n(Integer.valueOf(((com.tencent.mm.plugin.story.i.j) it.next()).field_createTime)));
        }
        ArrayList arrayList2 = arrayList;
        p.b bVar = com.tencent.mm.plugin.story.api.p.FkJ;
        String str = this.mRa;
        com.tencent.mm.plugin.story.g.d dVar = com.tencent.mm.plugin.story.g.d.FrG;
        long a2 = bVar.a(arrayList2, str, com.tencent.mm.plugin.story.g.d.fpB());
        Intent intent = new Intent(getContext(), StoryBrowseUI.class);
        intent.putExtra(ch.COL_USERNAME, this.mRa);
        intent.putExtra("data_seed_key", a2);
        intent.putExtra("v_position", i2);
        intent.putExtra("gallery_story_need_action", true);
        Context context = getContext();
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/story/ui/view/StoryPreference", "goFavGallery", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/story/ui/view/StoryPreference", "goFavGallery", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        h hVar = h.FuH;
        h.fqi().sl(14);
        AppMethodBeat.o(120289);
    }
}
