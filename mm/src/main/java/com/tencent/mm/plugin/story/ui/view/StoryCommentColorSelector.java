package com.tencent.mm.plugin.story.ui.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.story.ui.view.StoryCommentView;
import com.tencent.smtt.sdk.WebView;
import java.util.Random;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010%\u001a\u00020&J\u000e\u0010'\u001a\u00020&2\u0006\u0010\u0014\u001a\u00020\tJ\u000e\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\fJ\b\u0010+\u001a\u00020\u0015H\u0002J\u0006\u0010,\u001a\u00020\tR\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R7\u0010\u0010\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/view/StoryCommentColorSelector;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "allColorDrawable", "Landroid/graphics/drawable/Drawable;", "blackView", "Landroid/widget/ImageView;", "insetSize", "onColorSelected", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "color", "", "getOnColorSelected", "()Lkotlin/jvm/functions/Function1;", "setOnColorSelected", "(Lkotlin/jvm/functions/Function1;)V", "randomRoot", "randomText", "Landroid/widget/TextView;", "randomView", "selectedColor", "getSelectedColor", "()I", "setSelectedColor", "(I)V", "strokeWidth", "whiteView", "createAllColorDrawable", "Landroid/graphics/drawable/GradientDrawable;", "createDrawable", "insetDrawable", "Landroid/graphics/drawable/InsetDrawable;", FirebaseAnalytics.b.ORIGIN, "notifyView", "randowmColor", "plugin-story_release"})
public final class StoryCommentColorSelector extends LinearLayout {
    private final int FBF;
    private final Drawable FBG;
    private final ImageView FBH;
    private final ImageView FBI;
    private final ImageView FBJ;
    private final LinearLayout FBK;
    private final TextView FBL;
    private b<? super Integer, x> FBM;
    private int ruC;
    private final int strokeWidth;

    public static final /* synthetic */ void a(StoryCommentColorSelector storyCommentColorSelector) {
        AppMethodBeat.i(120103);
        storyCommentColorSelector.frX();
        AppMethodBeat.o(120103);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StoryCommentColorSelector(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(120101);
        this.ruC = -1;
        View.inflate(context, R.layout.bzk, this);
        setOrientation(0);
        View findViewById = findViewById(R.id.i84);
        p.g(findViewById, "findViewById(R.id.story_…ent_color_selector_white)");
        this.FBH = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.i80);
        p.g(findViewById2, "findViewById(R.id.story_…ent_color_selector_black)");
        this.FBI = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.i82);
        p.g(findViewById3, "findViewById(R.id.story_…lor_selector_random_icon)");
        this.FBJ = (ImageView) findViewById3;
        View findViewById4 = findViewById(R.id.i81);
        p.g(findViewById4, "findViewById(R.id.story_…nt_color_selector_random)");
        this.FBK = (LinearLayout) findViewById4;
        View findViewById5 = findViewById(R.id.i83);
        p.g(findViewById5, "findViewById(R.id.story_…lor_selector_random_text)");
        this.FBL = (TextView) findViewById5;
        this.FBH.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.story.ui.view.StoryCommentColorSelector.AnonymousClass1 */
            final /* synthetic */ StoryCommentColorSelector FBN;

            {
                this.FBN = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(120096);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/story/ui/view/StoryCommentColorSelector$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.FBN.setSelectedColor(-1);
                StoryCommentColorSelector.a(this.FBN);
                a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryCommentColorSelector$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(120096);
            }
        });
        this.FBI.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.story.ui.view.StoryCommentColorSelector.AnonymousClass2 */
            final /* synthetic */ StoryCommentColorSelector FBN;

            {
                this.FBN = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(120097);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/story/ui/view/StoryCommentColorSelector$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.FBN.setSelectedColor(WebView.NIGHT_MODE_COLOR);
                StoryCommentColorSelector.a(this.FBN);
                a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryCommentColorSelector$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(120097);
            }
        });
        this.FBK.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.story.ui.view.StoryCommentColorSelector.AnonymousClass3 */
            final /* synthetic */ StoryCommentColorSelector FBN;

            {
                this.FBN = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(120098);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/story/ui/view/StoryCommentColorSelector$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.FBN.setSelectedColor(StoryCommentColorSelector.frY());
                StoryCommentColorSelector.a(this.FBN);
                a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryCommentColorSelector$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(120098);
            }
        });
        this.strokeWidth = com.tencent.mm.cb.a.fromDPToPix(context, 2);
        this.FBF = com.tencent.mm.cb.a.fromDPToPix(context, 4);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColors(new int[]{-372399, -352965, -15616, -7220480, -16268960, -15683841, -15432210, -10197008, -372399});
        gradientDrawable.setGradientType(2);
        gradientDrawable.setStroke(this.strokeWidth, -1);
        gradientDrawable.setShape(1);
        GradientDrawable gradientDrawable2 = gradientDrawable;
        p.h(gradientDrawable2, FirebaseAnalytics.b.ORIGIN);
        this.FBG = new InsetDrawable((Drawable) gradientDrawable2, this.FBF);
        frX();
        AppMethodBeat.o(120101);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public StoryCommentColorSelector(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(120102);
        AppMethodBeat.o(120102);
    }

    public final int getSelectedColor() {
        return this.ruC;
    }

    public final void setSelectedColor(int i2) {
        this.ruC = i2;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.g.a.b<? super java.lang.Integer, kotlin.x>, kotlin.g.a.b<java.lang.Integer, kotlin.x> */
    public final b<Integer, x> getOnColorSelected() {
        return this.FBM;
    }

    public final void setOnColorSelected(b<? super Integer, x> bVar) {
        this.FBM = bVar;
    }

    private final void frX() {
        AppMethodBeat.i(120099);
        switch (this.ruC) {
            case WebView.NIGHT_MODE_COLOR /*{ENCODED_INT: -16777216}*/:
                this.FBH.setSelected(false);
                this.FBI.setSelected(true);
                this.FBJ.setImageDrawable(this.FBG);
                this.FBL.setVisibility(8);
                break;
            case -1:
                this.FBH.setSelected(true);
                this.FBI.setSelected(false);
                this.FBJ.setImageDrawable(this.FBG);
                this.FBL.setVisibility(8);
                break;
            default:
                this.FBH.setSelected(false);
                this.FBI.setSelected(false);
                ImageView imageView = this.FBJ;
                int i2 = this.ruC;
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(i2);
                gradientDrawable.setStroke(this.strokeWidth, -1);
                gradientDrawable.setShape(1);
                imageView.setImageDrawable(gradientDrawable);
                this.FBL.setVisibility(0);
                break;
        }
        b<? super Integer, x> bVar = this.FBM;
        if (bVar != null) {
            bVar.invoke(Integer.valueOf(this.ruC));
            AppMethodBeat.o(120099);
            return;
        }
        AppMethodBeat.o(120099);
    }

    public static int frY() {
        AppMethodBeat.i(120100);
        Random random = new Random();
        StoryCommentView.a aVar = StoryCommentView.FCD;
        int nextInt = random.nextInt(StoryCommentView.Cdb.length);
        StoryCommentView.a aVar2 = StoryCommentView.FCD;
        int i2 = StoryCommentView.Cdb[nextInt];
        AppMethodBeat.o(120100);
        return i2;
    }
}
